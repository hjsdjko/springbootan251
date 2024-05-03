package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaopingangweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaopingangweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopingangweiView;


/**
 * 招聘岗位
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface ZhaopingangweiService extends IService<ZhaopingangweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaopingangweiVO> selectListVO(Wrapper<ZhaopingangweiEntity> wrapper);
   	
   	ZhaopingangweiVO selectVO(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
   	
   	List<ZhaopingangweiView> selectListView(Wrapper<ZhaopingangweiEntity> wrapper);
   	
   	ZhaopingangweiView selectView(@Param("ew") Wrapper<ZhaopingangweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaopingangweiEntity> wrapper);
   	
}

