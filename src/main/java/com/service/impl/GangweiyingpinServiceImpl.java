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


import com.dao.GangweiyingpinDao;
import com.entity.GangweiyingpinEntity;
import com.service.GangweiyingpinService;
import com.entity.vo.GangweiyingpinVO;
import com.entity.view.GangweiyingpinView;

@Service("gangweiyingpinService")
public class GangweiyingpinServiceImpl extends ServiceImpl<GangweiyingpinDao, GangweiyingpinEntity> implements GangweiyingpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweiyingpinEntity> page = this.selectPage(
                new Query<GangweiyingpinEntity>(params).getPage(),
                new EntityWrapper<GangweiyingpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweiyingpinEntity> wrapper) {
		  Page<GangweiyingpinView> page =new Query<GangweiyingpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweiyingpinVO> selectListVO(Wrapper<GangweiyingpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweiyingpinVO selectVO(Wrapper<GangweiyingpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweiyingpinView> selectListView(Wrapper<GangweiyingpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweiyingpinView selectView(Wrapper<GangweiyingpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
