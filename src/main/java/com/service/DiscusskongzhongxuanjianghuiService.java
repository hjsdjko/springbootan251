package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskongzhongxuanjianghuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskongzhongxuanjianghuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskongzhongxuanjianghuiView;


/**
 * 空中宣讲会评论表
 *
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface DiscusskongzhongxuanjianghuiService extends IService<DiscusskongzhongxuanjianghuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskongzhongxuanjianghuiVO> selectListVO(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
   	
   	DiscusskongzhongxuanjianghuiVO selectVO(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
   	
   	List<DiscusskongzhongxuanjianghuiView> selectListView(Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
   	
   	DiscusskongzhongxuanjianghuiView selectView(@Param("ew") Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskongzhongxuanjianghuiEntity> wrapper);
   	
}

