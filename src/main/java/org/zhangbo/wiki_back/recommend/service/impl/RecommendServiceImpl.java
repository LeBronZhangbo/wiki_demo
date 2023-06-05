package org.zhangbo.wiki_back.recommend.service.impl;


import org.springframework.stereotype.Service;
import org.zhangbo.wiki_back.recommend.core.ItemCF;
import org.zhangbo.wiki_back.recommend.core.UserCF;
import org.zhangbo.wiki_back.recommend.dto.WikiDTO;
import org.zhangbo.wiki_back.recommend.dto.RelateDTO;
import org.zhangbo.wiki_back.recommend.service.RecommendService;
import org.zhangbo.wiki_back.recommend.util.FileDataSource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 推荐服务
 *
 * @author zhangbo
 * @date 2023年05月22日 17:28:06
 */
@Service
public class RecommendServiceImpl implements RecommendService {

    /**
     * 方法描述: 猜你喜欢
     *
     * @param userId 用户id
     * @Return {@link List< WikiDTO >}
     * @author zhangbo
     * @date 2023年05月21日 17:28:06
     */
    @Override
    public List<WikiDTO> userCfRecommend(int userId) {
        List<RelateDTO> data = FileDataSource.getData();
        List<Integer> recommendations = UserCF.recommend(userId, data);
        return FileDataSource.getItemData().stream().filter(e -> recommendations.contains(e.getId())).collect(Collectors.toList());
    }


    /**
     * 方法描述: 猜你喜欢
     *
     * @param itemId 物品id
     * @Return {@link List< WikiDTO >}
     * @author zhangbo
     * @date 2023年05月22日 17:28:06
     */
    @Override
    public List<WikiDTO> itemCfRecommend(int itemId) {
        List<RelateDTO> data = FileDataSource.getData();
        List<Integer> recommendations = ItemCF.recommend(itemId, data);
        return FileDataSource.getItemData().stream().filter(e -> recommendations.contains(e.getId())).collect(Collectors.toList());
    }


}
