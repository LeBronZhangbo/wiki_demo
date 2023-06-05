package org.zhangbo.wiki_back.recommend.service;

import org.zhangbo.wiki_back.recommend.dto.WikiDTO;

import java.util.List;

public interface RecommendService {
    public List<WikiDTO> userCfRecommend(int userId);

    public List<WikiDTO> itemCfRecommend(int itemId);
}
