package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshihuifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshihuifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshihuifuView;


/**
 * 面试回复
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface MianshihuifuService extends IService<MianshihuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshihuifuVO> selectListVO(Wrapper<MianshihuifuEntity> wrapper);
   	
   	MianshihuifuVO selectVO(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
   	
   	List<MianshihuifuView> selectListView(Wrapper<MianshihuifuEntity> wrapper);
   	
   	MianshihuifuView selectView(@Param("ew") Wrapper<MianshihuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshihuifuEntity> wrapper);
   	
}

