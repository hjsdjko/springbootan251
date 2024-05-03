package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhaopingangweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhaopingangweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhaopingangweiView;


/**
 * 招聘岗位评论表
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface DiscusszhaopingangweiService extends IService<DiscusszhaopingangweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhaopingangweiVO> selectListVO(Wrapper<DiscusszhaopingangweiEntity> wrapper);
   	
   	DiscusszhaopingangweiVO selectVO(@Param("ew") Wrapper<DiscusszhaopingangweiEntity> wrapper);
   	
   	List<DiscusszhaopingangweiView> selectListView(Wrapper<DiscusszhaopingangweiEntity> wrapper);
   	
   	DiscusszhaopingangweiView selectView(@Param("ew") Wrapper<DiscusszhaopingangweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhaopingangweiEntity> wrapper);
   	
}

