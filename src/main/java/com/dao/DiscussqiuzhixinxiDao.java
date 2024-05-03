package com.dao;

import com.entity.DiscussqiuzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqiuzhixinxiVO;
import com.entity.view.DiscussqiuzhixinxiView;


/**
 * 求职信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface DiscussqiuzhixinxiDao extends BaseMapper<DiscussqiuzhixinxiEntity> {
	
	List<DiscussqiuzhixinxiVO> selectListVO(@Param("ew") Wrapper<DiscussqiuzhixinxiEntity> wrapper);
	
	DiscussqiuzhixinxiVO selectVO(@Param("ew") Wrapper<DiscussqiuzhixinxiEntity> wrapper);
	
	List<DiscussqiuzhixinxiView> selectListView(@Param("ew") Wrapper<DiscussqiuzhixinxiEntity> wrapper);

	List<DiscussqiuzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqiuzhixinxiEntity> wrapper);
	
	DiscussqiuzhixinxiView selectView(@Param("ew") Wrapper<DiscussqiuzhixinxiEntity> wrapper);
	
}
