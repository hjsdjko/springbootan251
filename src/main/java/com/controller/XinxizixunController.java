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

import com.entity.XinxizixunEntity;
import com.entity.view.XinxizixunView;

import com.service.XinxizixunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 信息咨询
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@RestController
@RequestMapping("/xinxizixun")
public class XinxizixunController {
    @Autowired
    private XinxizixunService xinxizixunService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinxizixunEntity xinxizixun, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			xinxizixun.setQiyebianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("biyesheng")) {
			xinxizixun.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinxizixunEntity> ew = new EntityWrapper<XinxizixunEntity>();
		PageUtils page = xinxizixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinxizixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinxizixunEntity xinxizixun, HttpServletRequest request){
        EntityWrapper<XinxizixunEntity> ew = new EntityWrapper<XinxizixunEntity>();
		PageUtils page = xinxizixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinxizixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinxizixunEntity xinxizixun){
       	EntityWrapper<XinxizixunEntity> ew = new EntityWrapper<XinxizixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinxizixun, "xinxizixun")); 
        return R.ok().put("data", xinxizixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinxizixunEntity xinxizixun){
        EntityWrapper< XinxizixunEntity> ew = new EntityWrapper< XinxizixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinxizixun, "xinxizixun")); 
		XinxizixunView xinxizixunView =  xinxizixunService.selectView(ew);
		return R.ok("查询信息咨询成功").put("data", xinxizixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        XinxizixunEntity xinxizixun = xinxizixunService.selectById(id);
        return R.ok().put("data", xinxizixun);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        XinxizixunEntity xinxizixun = xinxizixunService.selectById(id);
        return R.ok().put("data", xinxizixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinxizixunEntity xinxizixun, HttpServletRequest request){
    	xinxizixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinxizixun);
        xinxizixunService.insert(xinxizixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinxizixunEntity xinxizixun, HttpServletRequest request){
    	xinxizixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinxizixun);
        xinxizixunService.insert(xinxizixun);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XinxizixunEntity xinxizixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinxizixun);
        xinxizixunService.updateById(xinxizixun);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinxizixunService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XinxizixunEntity> wrapper = new EntityWrapper<XinxizixunEntity>();
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

		int count = xinxizixunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
