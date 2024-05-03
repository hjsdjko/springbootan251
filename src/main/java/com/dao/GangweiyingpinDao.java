package com.dao;

import com.entity.GangweiyingpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GangweiyingpinVO;
import com.entity.view.GangweiyingpinView;


/**
 * 岗位应聘
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface GangweiyingpinDao extends BaseMapper<GangweiyingpinEntity> {
	
	List<GangweiyingpinVO> selectListVO(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	
	GangweiyingpinVO selectVO(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	
	List<GangweiyingpinView> selectListView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);

	List<GangweiyingpinView> selectListView(Pagination page,@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	
	GangweiyingpinView selectView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
	
}
