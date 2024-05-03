package com.dao;

import com.entity.MianshihuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshihuifuVO;
import com.entity.view.MianshihuifuView;


/**
 * 面试回复
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface MianshihuifuDao extends BaseMapper<MianshihuifuEntity> {
	
	List<MianshihuifuVO> selectListVO(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
	
	MianshihuifuVO selectVO(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
	
	List<MianshihuifuView> selectListView(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);

	List<MianshihuifuView> selectListView(Pagination page,@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
	
	MianshihuifuView selectView(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
	
}
