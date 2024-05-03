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


import com.dao.KongzhongxuanjianghuiDao;
import com.entity.KongzhongxuanjianghuiEntity;
import com.service.KongzhongxuanjianghuiService;
import com.entity.vo.KongzhongxuanjianghuiVO;
import com.entity.view.KongzhongxuanjianghuiView;

@Service("kongzhongxuanjianghuiService")
public class KongzhongxuanjianghuiServiceImpl extends ServiceImpl<KongzhongxuanjianghuiDao, KongzhongxuanjianghuiEntity> implements KongzhongxuanjianghuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KongzhongxuanjianghuiEntity> page = this.selectPage(
                new Query<KongzhongxuanjianghuiEntity>(params).getPage(),
                new EntityWrapper<KongzhongxuanjianghuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KongzhongxuanjianghuiEntity> wrapper) {
		  Page<KongzhongxuanjianghuiView> page =new Query<KongzhongxuanjianghuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KongzhongxuanjianghuiVO> selectListVO(Wrapper<KongzhongxuanjianghuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KongzhongxuanjianghuiVO selectVO(Wrapper<KongzhongxuanjianghuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KongzhongxuanjianghuiView> selectListView(Wrapper<KongzhongxuanjianghuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KongzhongxuanjianghuiView selectView(Wrapper<KongzhongxuanjianghuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
