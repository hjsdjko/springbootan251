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


import com.dao.DiscussqiuzhixinxiDao;
import com.entity.DiscussqiuzhixinxiEntity;
import com.service.DiscussqiuzhixinxiService;
import com.entity.vo.DiscussqiuzhixinxiVO;
import com.entity.view.DiscussqiuzhixinxiView;

@Service("discussqiuzhixinxiService")
public class DiscussqiuzhixinxiServiceImpl extends ServiceImpl<DiscussqiuzhixinxiDao, DiscussqiuzhixinxiEntity> implements DiscussqiuzhixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqiuzhixinxiEntity> page = this.selectPage(
                new Query<DiscussqiuzhixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussqiuzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqiuzhixinxiEntity> wrapper) {
		  Page<DiscussqiuzhixinxiView> page =new Query<DiscussqiuzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqiuzhixinxiVO> selectListVO(Wrapper<DiscussqiuzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqiuzhixinxiVO selectVO(Wrapper<DiscussqiuzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqiuzhixinxiView> selectListView(Wrapper<DiscussqiuzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqiuzhixinxiView selectView(Wrapper<DiscussqiuzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
