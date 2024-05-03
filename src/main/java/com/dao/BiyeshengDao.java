package com.dao;

import com.entity.BiyeshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BiyeshengVO;
import com.entity.view.BiyeshengView;


/**
 * 毕业生
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface BiyeshengDao extends BaseMapper<BiyeshengEntity> {
	
	List<BiyeshengVO> selectListVO(@Param("ew") Wrapper<BiyeshengEntity> wrapper);
	
	BiyeshengVO selectVO(@Param("ew") Wrapper<BiyeshengEntity> wrapper);
	
	List<BiyeshengView> selectListView(@Param("ew") Wrapper<BiyeshengEntity> wrapper);

	List<BiyeshengView> selectListView(Pagination page,@Param("ew") Wrapper<BiyeshengEntity> wrapper);
	
	BiyeshengView selectView(@Param("ew") Wrapper<BiyeshengEntity> wrapper);
	
}
