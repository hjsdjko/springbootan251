package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhaopingangweiDao;
import com.entity.ZhaopingangweiEntity;
import com.service.ZhaopingangweiService;
import com.entity.vo.ZhaopingangweiVO;
import com.entity.view.ZhaopingangweiView;

@Service("zhaopingangweiService")
public class ZhaopingangweiServiceImpl extends ServiceImpl<ZhaopingangweiDao, ZhaopingangweiEntity> implements ZhaopingangweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaopingangweiEntity> page = this.selectPage(
                new Query<ZhaopingangweiEntity>(params).getPage(),
                new EntityWrapper<ZhaopingangweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaopingangweiEntity> wrapper) {
		  Page<ZhaopingangweiView> page =new Query<ZhaopingangweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaopingangweiVO> selectListVO(Wrapper<ZhaopingangweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaopingangweiVO selectVO(Wrapper<ZhaopingangweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaopingangweiView> selectListView(Wrapper<ZhaopingangweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaopingangweiView selectView(Wrapper<ZhaopingangweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
