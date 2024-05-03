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


import com.dao.XianshangmianshiDao;
import com.entity.XianshangmianshiEntity;
import com.service.XianshangmianshiService;
import com.entity.vo.XianshangmianshiVO;
import com.entity.view.XianshangmianshiView;

@Service("xianshangmianshiService")
public class XianshangmianshiServiceImpl extends ServiceImpl<XianshangmianshiDao, XianshangmianshiEntity> implements XianshangmianshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianshangmianshiEntity> page = this.selectPage(
                new Query<XianshangmianshiEntity>(params).getPage(),
                new EntityWrapper<XianshangmianshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianshangmianshiEntity> wrapper) {
		  Page<XianshangmianshiView> page =new Query<XianshangmianshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XianshangmianshiVO> selectListVO(Wrapper<XianshangmianshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianshangmianshiVO selectVO(Wrapper<XianshangmianshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianshangmianshiView> selectListView(Wrapper<XianshangmianshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianshangmianshiView selectView(Wrapper<XianshangmianshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
