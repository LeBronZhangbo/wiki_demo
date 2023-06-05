package org.zhangbo.wiki_back.recommend.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.zhangbo.wiki_back.recommend.dto.WikiDTO;
import org.zhangbo.wiki_back.recommend.dto.RelateDTO;
import org.zhangbo.wiki_back.recommend.dto.UserDTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhangbo
 */
@Data
@Slf4j
public class FileDataSource {


    public static String folderPath;

    static {
        folderPath = Objects.requireNonNull(FileDataSource.class.getResource("/ml-100k")).getPath();
    }


    /**
     * 方法描述: 读取基础数据
     *
     * @Return {@link List<RelateDTO>}
     * @author zhangbo
     * @date 2023年05月19日 16:54:51
     */
    public static List<RelateDTO> getData() {
        List<RelateDTO> relateList = new ArrayList();
        try {
            FileInputStream out = new FileInputStream(folderPath + "\\u.data");
            InputStreamReader reader = new InputStreamReader(out, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                String newline = line.replaceAll("[\t]", " ");
                String[] ht = newline.split(" ");
                Integer userId = Integer.parseInt(ht[0]);
                Integer movieId = Integer.parseInt(ht[1]);
                Double rating = Double.parseDouble(ht[2]);
                RelateDTO dto = new RelateDTO(userId, movieId, rating);
                relateList.add(dto);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return relateList;
    }

    /**
     * 方法描述: 读取用户数据
     *
     * @Return {@link List<UserDTO>}
     * @author zhangbo
     * @date 2023年05月19日 16:54:51
     */
    public static List<UserDTO> getUserData() {
        List<UserDTO> userList = new ArrayList();
        try {
            FileInputStream out = new FileInputStream(folderPath + "\\u.user");
            InputStreamReader reader = new InputStreamReader(out, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                String newline = line.replaceAll("[\t]", " ");
                String[] ht = newline.split("\\|");
                Integer id = Integer.parseInt(ht[0]);
                UserDTO dto = new UserDTO(id);
                userList.add(dto);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return userList;
    }


    /**
     * 方法描述: 读取wiki知识库数据
     *
     * @Return {@link List< WikiDTO >}
     * @author zhangbo
     * @date 2023年05月19日 16:54:51
     */
    public static List<WikiDTO> getItemData() {
        List<WikiDTO> itemList = new ArrayList();
        try {
            FileInputStream out = new FileInputStream(folderPath + "\\u.item");
            InputStreamReader reader = new InputStreamReader(out, StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            String line;
            while ((line = in.readLine()) != null) {
                String newline = line.replaceAll("[\t]", " ");
                String[] ht = newline.split("\\|");
                Integer id = Integer.parseInt(ht[0]);
                String name = ht[1];
                String date = ht[2];
                String link = ht[3];
                WikiDTO dto = new WikiDTO(id, name, date, link);
                itemList.add(dto);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return itemList;
    }


}

