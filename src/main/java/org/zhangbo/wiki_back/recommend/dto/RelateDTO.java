package org.zhangbo.wiki_back.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @Date 2023-05-01 15:21
 */

public class RelateDTO {
    /** 用户id */
    private Integer useId;
    /** 作者id */
    private Integer wikiId;
    /** 指数 */
    private Double index;

    public RelateDTO() {
    }

    public RelateDTO(Integer useId, Integer wikiId, Double index) {
        this.useId = useId;
        this.wikiId = wikiId;
        this.index = index;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public Integer getWikiId() {
        return wikiId;
    }

    public void setWikiId(Integer wikiId) {
        this.wikiId = wikiId;
    }

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }
}
