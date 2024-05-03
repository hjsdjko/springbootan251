package com.dao;

import com.entity.ZhaopingangweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaopingangweiVO;
import com.entity.view.ZhaopingangweiView;


/**
 * 招聘岗位
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface ZhaopingangweiDao extends BaseMapper<ZhaopingangweiEntity> {
	
	List<ZhaopingangweiVO> selectListVO(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
	
	ZhaopingangweiVO selectVO(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
	
	List<ZhaopingangweiView> selectListView(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);

	List<ZhaopingangweiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
	
	ZhaopingangweiView selectView(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
	
}
