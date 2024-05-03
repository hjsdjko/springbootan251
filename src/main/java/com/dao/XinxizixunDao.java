package com.dao;

import com.entity.XinxizixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinxizixunVO;
import com.entity.view.XinxizixunView;


/**
 * 信息咨询
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface XinxizixunDao extends BaseMapper<XinxizixunEntity> {
	
	List<XinxizixunVO> selectListVO(@Param("ew") Wrapper<XinxizixunEntity> wrapper);
	
	XinxizixunVO selectVO(@Param("ew") Wrapper<XinxizixunEntity> wrapper);
	
	List<XinxizixunView> selectListView(@Param("ew") Wrapper<XinxizixunEntity> wrapper);

	List<XinxizixunView> selectListView(Pagination page,@Param("ew") Wrapper<XinxizixunEntity> wrapper);
	
	XinxizixunView selectView(@Param("ew") Wrapper<XinxizixunEntity> wrapper);
	
}
