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

import com.entity.GangweiyingpinEntity;
import com.entity.view.GangweiyingpinView;

import com.service.GangweiyingpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 岗位应聘
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@RestController
@RequestMapping("/gangweiyingpin")
public class GangweiyingpinController {
    @Autowired
    private GangweiyingpinService gangweiyingpinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			gangweiyingpin.setQiyebianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("biyesheng")) {
			gangweiyingpin.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();
		PageUtils page = gangweiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweiyingpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
        EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();
		PageUtils page = gangweiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweiyingpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweiyingpinEntity gangweiyingpin){
       	EntityWrapper<GangweiyingpinEntity> ew = new EntityWrapper<GangweiyingpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweiyingpin, "gangweiyingpin")); 
        return R.ok().put("data", gangweiyingpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweiyingpinEntity gangweiyingpin){
        EntityWrapper< GangweiyingpinEntity> ew = new EntityWrapper< GangweiyingpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweiyingpin, "gangweiyingpin")); 
		GangweiyingpinView gangweiyingpinView =  gangweiyingpinService.selectView(ew);
		return R.ok("查询岗位应聘成功").put("data", gangweiyingpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        GangweiyingpinEntity gangweiyingpin = gangweiyingpinService.selectById(id);
        return R.ok().put("data", gangweiyingpin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        GangweiyingpinEntity gangweiyingpin = gangweiyingpinService.selectById(id);
        return R.ok().put("data", gangweiyingpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
    	gangweiyingpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.insert(gangweiyingpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
    	gangweiyingpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.insert(gangweiyingpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GangweiyingpinEntity gangweiyingpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweiyingpin);
        gangweiyingpinService.updateById(gangweiyingpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweiyingpinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GangweiyingpinEntity> wrapper = new EntityWrapper<GangweiyingpinEntity>();
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

		int count = gangweiyingpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
