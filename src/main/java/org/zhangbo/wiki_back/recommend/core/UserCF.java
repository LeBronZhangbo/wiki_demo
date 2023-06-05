package org.zhangbo.wiki_back.recommend.core;

import org.zhangbo.wiki_back.recommend.dto.RelateDTO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 核心算法
 *
 * @author tarzan
 * @version 1.0
 * @date 2020/7/31$ 15:21$
 * @since JDK1.8
 */
public class UserCF {

    /**
     * 方法描述: 推荐列表
     *
     * @param userId 当前用户
     * @param list 用户数据
     * @return {@link List<Integer>}
     * @date 2023-05-01 17:21
     */
    public static List<Integer> recommend(Integer userId, List<RelateDTO> list) {
        //按用户分组
        Map<Integer, List<RelateDTO>>  userMap=list.stream().collect(Collectors.groupingBy(RelateDTO::getUseId));
        //获取其他用户与当前用户的关系值
        Map<Integer,Double>  userDisMap = CoreMath.computeNeighbor(userId, userMap,0);
        //获取关系最近的用户
        double maxValue=Collections.max(userDisMap.values());
        Set<Integer> userIds=userDisMap.entrySet().stream().filter(e->e.getValue()==maxValue).map(Map.Entry::getKey).collect(Collectors.toSet());
        //取关系最近的用户
        Integer nearestUserId = userIds.stream().findAny().orElse(null);
        if(nearestUserId==null){
            return Collections.emptyList();
        }
        List<Integer>  neighborItems = userMap.get(nearestUserId).stream().map(RelateDTO::getWikiId).collect(Collectors.toList());
        List<Integer>  userItems  = userMap.get(userId).stream().map(RelateDTO::getWikiId).collect(Collectors.toList());
        neighborItems.removeAll(userItems);
        return neighborItems;
    }

}
