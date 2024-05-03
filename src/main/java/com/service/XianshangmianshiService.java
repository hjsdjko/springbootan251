package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianshangmianshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XianshangmianshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XianshangmianshiView;


/**
 * 线上面试
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface XianshangmianshiService extends IService<XianshangmianshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianshangmianshiVO> selectListVO(Wrapper<XianshangmianshiEntity> wrapper);
   	
   	XianshangmianshiVO selectVO(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
   	
   	List<XianshangmianshiView> selectListView(Wrapper<XianshangmianshiEntity> wrapper);
   	
   	XianshangmianshiView selectView(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianshangmianshiEntity> wrapper);
   	
}

