package com.project.game.mapper;

import com.project.common.dto.PageRequestDTO;

public class QnASqlProvider {

    public String QnASearchQuery(PageRequestDTO pageRequestDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT GAME_NO, GAME_TITLE, GAME_CONTENT, GAME_WRITER, TO_CHAR(GAME_DATE, 'YYYY-MM-DD') AS dateQnA, GAME_hits, GAME_recommend ");
        sql.append("FROM LOL_QNA");

        String keyword = pageRequestDTO.getKeyword();
        if (keyword != null && !keyword.isBlank()) {
            String column = switch (pageRequestDTO.getSearchType()) {
                case "title" -> "GAME_TITLE";
                case "content" -> "GAME_CONTENT";
                case "writer" -> "GAME_WRITER";
                default -> "GAME_TITLE";
            };

            sql.append(" WHERE ");
            sql.append(column);
            sql.append(" LIKE '%' || #{keyword} || '%' ");
        }
        sql.append(" ORDER BY GAME_NO desc");

        return sql.toString();
    }

}
