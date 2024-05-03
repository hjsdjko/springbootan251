package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweiyingpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweiyingpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweiyingpinView;


/**
 * 岗位应聘
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface GangweiyingpinService extends IService<GangweiyingpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweiyingpinVO> selectListVO(Wrapper<GangweiyingpinEntity> wrapper);
   	
   	GangweiyingpinVO selectVO(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
   	
   	List<GangweiyingpinView> selectListView(Wrapper<GangweiyingpinEntity> wrapper);
   	
   	GangweiyingpinView selectView(@Param("ew") Wrapper<GangweiyingpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweiyingpinEntity> wrapper);
   	
}

