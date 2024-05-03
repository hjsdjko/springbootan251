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


import com.dao.XinxizixunDao;
import com.entity.XinxizixunEntity;
import com.service.XinxizixunService;
import com.entity.vo.XinxizixunVO;
import com.entity.view.XinxizixunView;

@Service("xinxizixunService")
public class XinxizixunServiceImpl extends ServiceImpl<XinxizixunDao, XinxizixunEntity> implements XinxizixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinxizixunEntity> page = this.selectPage(
                new Query<XinxizixunEntity>(params).getPage(),
                new EntityWrapper<XinxizixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinxizixunEntity> wrapper) {
		  Page<XinxizixunView> page =new Query<XinxizixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinxizixunVO> selectListVO(Wrapper<XinxizixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinxizixunVO selectVO(Wrapper<XinxizixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinxizixunView> selectListView(Wrapper<XinxizixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinxizixunView selectView(Wrapper<XinxizixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
