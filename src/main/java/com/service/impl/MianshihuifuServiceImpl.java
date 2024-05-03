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


import com.dao.MianshihuifuDao;
import com.entity.MianshihuifuEntity;
import com.service.MianshihuifuService;
import com.entity.vo.MianshihuifuVO;
import com.entity.view.MianshihuifuView;

@Service("mianshihuifuService")
public class MianshihuifuServiceImpl extends ServiceImpl<MianshihuifuDao, MianshihuifuEntity> implements MianshihuifuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshihuifuEntity> page = this.selectPage(
                new Query<MianshihuifuEntity>(params).getPage(),
                new EntityWrapper<MianshihuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshihuifuEntity> wrapper) {
		  Page<MianshihuifuView> page =new Query<MianshihuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MianshihuifuVO> selectListVO(Wrapper<MianshihuifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshihuifuVO selectVO(Wrapper<MianshihuifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshihuifuView> selectListView(Wrapper<MianshihuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshihuifuView selectView(Wrapper<MianshihuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
