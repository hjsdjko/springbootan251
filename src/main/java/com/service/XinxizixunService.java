package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinxizixunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinxizixunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinxizixunView;


/**
 * 信息咨询
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface XinxizixunService extends IService<XinxizixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinxizixunVO> selectListVO(Wrapper<XinxizixunEntity> wrapper);
   	
   	XinxizixunVO selectVO(@Param("ew") Wrapper<XinxizixunEntity> wrapper);
   	
   	List<XinxizixunView> selectListView(Wrapper<XinxizixunEntity> wrapper);
   	
   	XinxizixunView selectView(@Param("ew") Wrapper<XinxizixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinxizixunEntity> wrapper);
   	
}

