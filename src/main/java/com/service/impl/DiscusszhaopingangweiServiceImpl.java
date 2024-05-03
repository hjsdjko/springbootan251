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


import com.dao.DiscusszhaopingangweiDao;
import com.entity.DiscusszhaopingangweiEntity;
import com.service.DiscusszhaopingangweiService;
import com.entity.vo.DiscusszhaopingangweiVO;
import com.entity.view.DiscusszhaopingangweiView;

@Service("discusszhaopingangweiService")
public class DiscusszhaopingangweiServiceImpl extends ServiceImpl<DiscusszhaopingangweiDao, DiscusszhaopingangweiEntity> implements DiscusszhaopingangweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaopingangweiEntity> page = this.selectPage(
                new Query<DiscusszhaopingangweiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaopingangweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaopingangweiEntity> wrapper) {
		  Page<DiscusszhaopingangweiView> page =new Query<DiscusszhaopingangweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhaopingangweiVO> selectListVO(Wrapper<DiscusszhaopingangweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhaopingangweiVO selectVO(Wrapper<DiscusszhaopingangweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhaopingangweiView> selectListView(Wrapper<DiscusszhaopingangweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaopingangweiView selectView(Wrapper<DiscusszhaopingangweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
