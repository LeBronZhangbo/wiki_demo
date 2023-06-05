package org.zhangbo.wiki_back.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @Date 2023-05-01 15:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WikiDTO {
    /** 主键 */
    private Integer id;
    /** 作者id */
    private String authorId;
    /** 标题 */
    private String title;
    /** 关键词 */
    private String keyWords;

}
