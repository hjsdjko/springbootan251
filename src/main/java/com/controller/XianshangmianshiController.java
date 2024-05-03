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

import com.entity.XianshangmianshiEntity;
import com.entity.view.XianshangmianshiView;

import com.service.XianshangmianshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 线上面试
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@RestController
@RequestMapping("/xianshangmianshi")
public class XianshangmianshiController {
    @Autowired
    private XianshangmianshiService xianshangmianshiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianshangmianshiEntity xianshangmianshi, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			xianshangmianshi.setQiyebianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("biyesheng")) {
			xianshangmianshi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianshangmianshiEntity> ew = new EntityWrapper<XianshangmianshiEntity>();
		PageUtils page = xianshangmianshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianshangmianshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianshangmianshiEntity xianshangmianshi, HttpServletRequest request){
        EntityWrapper<XianshangmianshiEntity> ew = new EntityWrapper<XianshangmianshiEntity>();
		PageUtils page = xianshangmianshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianshangmianshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianshangmianshiEntity xianshangmianshi){
       	EntityWrapper<XianshangmianshiEntity> ew = new EntityWrapper<XianshangmianshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianshangmianshi, "xianshangmianshi")); 
        return R.ok().put("data", xianshangmianshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianshangmianshiEntity xianshangmianshi){
        EntityWrapper< XianshangmianshiEntity> ew = new EntityWrapper< XianshangmianshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianshangmianshi, "xianshangmianshi")); 
		XianshangmianshiView xianshangmianshiView =  xianshangmianshiService.selectView(ew);
		return R.ok("查询线上面试成功").put("data", xianshangmianshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        XianshangmianshiEntity xianshangmianshi = xianshangmianshiService.selectById(id);
        return R.ok().put("data", xianshangmianshi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        XianshangmianshiEntity xianshangmianshi = xianshangmianshiService.selectById(id);
        return R.ok().put("data", xianshangmianshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianshangmianshiEntity xianshangmianshi, HttpServletRequest request){
    	xianshangmianshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianshangmianshi);
        xianshangmianshiService.insert(xianshangmianshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianshangmianshiEntity xianshangmianshi, HttpServletRequest request){
    	xianshangmianshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianshangmianshi);
        xianshangmianshiService.insert(xianshangmianshi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XianshangmianshiEntity xianshangmianshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianshangmianshi);
        xianshangmianshiService.updateById(xianshangmianshi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianshangmianshiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XianshangmianshiEntity> wrapper = new EntityWrapper<XianshangmianshiEntity>();
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

		int count = xianshangmianshiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
