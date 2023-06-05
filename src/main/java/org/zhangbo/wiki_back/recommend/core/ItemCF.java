package org.zhangbo.wiki_back.recommend.core;


import org.zhangbo.wiki_back.recommend.dto.RelateDTO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 核心算法
 *
 * @author zhangbo
 * @date 2023-05-01 17:21
 */
public class ItemCF {

    /**
     * 方法描述: 推荐列表
     *
     * @param itemId 当前wikiid
     * @param list 用户数据
     * @return {@link List<Integer>}
     * @date 2023-05-01 17:21
     */
    public static List<Integer> recommend(Integer itemId, List<RelateDTO> list) {
        //按物品分组
        Map<Integer, List<RelateDTO>>  itemMap=list.stream().collect(Collectors.groupingBy(RelateDTO::getWikiId));
        //获取其他物品与当前物品的关系值
        Map<Integer,Double>  itemDisMap = CoreMath.computeNeighbor(itemId, itemMap,1);
        //获取关系最近物品
        double maxValue=Collections.max(itemDisMap.values());
        return itemDisMap.entrySet().stream().filter(e->e.getValue()==maxValue).map(Map.Entry::getKey).collect(Collectors.toList());
    }


}
