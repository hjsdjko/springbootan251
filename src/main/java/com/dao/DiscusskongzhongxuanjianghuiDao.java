package com.dao;

import com.entity.DiscusskongzhongxuanjianghuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskongzhongxuanjianghuiVO;
import com.entity.view.DiscusskongzhongxuanjianghuiView;


/**
 * 空中宣讲会评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface DiscusskongzhongxuanjianghuiDao extends BaseMapper<DiscusskongzhongxuanjianghuiEntity> {
	
	List<DiscusskongzhongxuanjianghuiVO> selectListVO(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
	
	DiscusskongzhongxuanjianghuiVO selectVO(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
	
	List<DiscusskongzhongxuanjianghuiView> selectListView(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);

	List<DiscusskongzhongxuanjianghuiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
	
	DiscusskongzhongxuanjianghuiView selectView(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
	
}
