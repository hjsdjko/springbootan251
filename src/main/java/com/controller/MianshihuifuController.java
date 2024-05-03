package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MianshihuifuEntity;
import com.entity.view.MianshihuifuView;

import com.service.MianshihuifuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 面试回复
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@RestController
@RequestMapping("/mianshihuifu")
public class MianshihuifuController {
    @Autowired
    private MianshihuifuService mianshihuifuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshihuifuEntity mianshihuifu, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			mianshihuifu.setQiyebianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("biyesheng")) {
			mianshihuifu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MianshihuifuEntity> ew = new EntityWrapper<MianshihuifuEntity>();
		PageUtils page = mianshihuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshihuifu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshihuifuEntity mianshihuifu, HttpServletRequest request){
        EntityWrapper<MianshihuifuEntity> ew = new EntityWrapper<MianshihuifuEntity>();
		PageUtils page = mianshihuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshihuifu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshihuifuEntity mianshihuifu){
       	EntityWrapper<MianshihuifuEntity> ew = new EntityWrapper<MianshihuifuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshihuifu, "mianshihuifu")); 
        return R.ok().put("data", mianshihuifuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshihuifuEntity mianshihuifu){
        EntityWrapper< MianshihuifuEntity> ew = new EntityWrapper< MianshihuifuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshihuifu, "mianshihuifu")); 
		MianshihuifuView mianshihuifuView =  mianshihuifuService.selectView(ew);
		return R.ok("查询面试回复成功").put("data", mianshihuifuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        MianshihuifuEntity mianshihuifu = mianshihuifuService.selectById(id);
        return R.ok().put("data", mianshihuifu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        MianshihuifuEntity mianshihuifu = mianshihuifuService.selectById(id);
        return R.ok().put("data", mianshihuifu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshihuifuEntity mianshihuifu, HttpServletRequest request){
    	mianshihuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshihuifu);
        mianshihuifuService.insert(mianshihuifu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshihuifuEntity mianshihuifu, HttpServletRequest request){
    	mianshihuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mianshihuifu);
        mianshihuifuService.insert(mianshihuifu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MianshihuifuEntity mianshihuifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshihuifu);
        mianshihuifuService.updateById(mianshihuifu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshihuifuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MianshihuifuEntity> wrapper = new EntityWrapper<MianshihuifuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			wrapper.eq("qiyebianhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("biyesheng")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = mianshihuifuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
