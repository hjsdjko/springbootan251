package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KongzhongxuanjianghuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KongzhongxuanjianghuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KongzhongxuanjianghuiView;


/**
 * 空中宣讲会
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface KongzhongxuanjianghuiService extends IService<KongzhongxuanjianghuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KongzhongxuanjianghuiVO> selectListVO(Wrapper<KongzhongxuanjianghuiEntity> wrapper);
   	
   	KongzhongxuanjianghuiVO selectVO(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
   	
   	List<KongzhongxuanjianghuiView> selectListView(Wrapper<KongzhongxuanjianghuiEntity> wrapper);
   	
   	KongzhongxuanjianghuiView selectView(@Param("ew") Wrapper<KongzhongxuanjianghuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KongzhongxuanjianghuiEntity> wrapper);
   	
}

