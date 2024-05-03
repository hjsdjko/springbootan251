package com.dao;

import com.entity.KongzhongxuanjianghuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KongzhongxuanjianghuiVO;
import com.entity.view.KongzhongxuanjianghuiView;


/**
 * 空中宣讲会
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface KongzhongxuanjianghuiDao extends BaseMapper<KongzhongxuanjianghuiEntity> {
	
	List<KongzhongxuanjianghuiVO> selectListVO(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
	
	KongzhongxuanjianghuiVO selectVO(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
	
	List<KongzhongxuanjianghuiView> selectListView(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);

	List<KongzhongxuanjianghuiView> selectListView(Pagination page,@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
	
	KongzhongxuanjianghuiView selectView(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
	
}
