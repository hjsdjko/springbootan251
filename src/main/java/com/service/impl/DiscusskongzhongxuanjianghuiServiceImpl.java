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


import com.dao.DiscusskongzhongxuanjianghuiDao;
import com.entity.DiscusskongzhongxuanjianghuiEntity;
import com.service.DiscusskongzhongxuanjianghuiService;
import com.entity.vo.DiscusskongzhongxuanjianghuiVO;
import com.entity.view.DiscusskongzhongxuanjianghuiView;

@Service("discusskongzhongxuanjianghuiService")
public class DiscusskongzhongxuanjianghuiServiceImpl extends ServiceImpl<DiscusskongzhongxuanjianghuiDao, DiscusskongzhongxuanjianghuiEntity> implements DiscusskongzhongxuanjianghuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskongzhongxuanjianghuiEntity> page = this.selectPage(
                new Query<DiscusskongzhongxuanjianghuiEntity>(params).getPage(),
                new EntityWrapper<DiscusskongzhongxuanjianghuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper) {
		  Page<DiscusskongzhongxuanjianghuiView> page =new Query<DiscusskongzhongxuanjianghuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskongzhongxuanjianghuiVO> selectListVO(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskongzhongxuanjianghuiVO selectVO(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskongzhongxuanjianghuiView> selectListView(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskongzhongxuanjianghuiView selectView(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
