package com.project.game.mapper;

import com.project.common.dto.PageRequestDTO;
import com.project.game.dto.QnADTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QnAMapper {
    @Results(id="QnAResult", value = {
            @Result(property = "noQnA", column = "GAME_NO"),
            @Result(property = "titleQnA", column = "GAME_TITLE"),
            @Result(property = "contentQnA", column = "GAME_CONTENT"),
            @Result(property = "writerQnA", column = "GAME_WRITER"),
            @Result(property = "dateQnA", column = "dateQnA"),
            @Result(property = "hitsQnA", column = "GAME_hits"),
            @Result(property = "recommendQnA", column = "GAME_recommend"),
            @Result(property = "passwdQnA", column = "GAME_PASSWD")
    })
    @Select("""
            SELECT GAME_NO, GAME_TITLE, GAME_CONTENT, GAME_WRITER, TO_CHAR(GAME_DATE, 'YYYY-MM-DD') AS dateQnA, GAME_hits, GAME_recommend
            FROM LOL_QNA ORDER BY GAME_NO DESC
            """)
    List<QnADTO> QnAList();

    @Insert("""
            INSERT INTO LOL_QNA(GAME_TITLE, GAME_CONTENT, GAME_WRITER, GAME_PASSWD)
            VALUES (#{titleQnA}, #{contentQnA}, #{writerQnA}, #{passwdQnA})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "noQnA", keyColumn = "GAME_NO")
    int QnAInsert(QnADTO qnaDTO);

    @Delete("""
            DELETE FROM LOL_QNA WHERE GAME_NO = #{noQnA}
            """)
    int  QnADelete(@Param("noQnA") int  noQnA);

    @Update("""
            UPDATE LOL_QNA
                SET GAME_TITLE = #{titleQnA}, GAME_CONTENT = #{contentQnA},
                    GAME_PASSWD = COALESCE(NULLIF(#{passwdQnA, jdbcType=VARCHAR}, ''), GAME_PASSWD)
            WHERE GAME_NO = #{noQnA}
            """)
    int  QnAUpdate(QnADTO qnaDTO);

    @Update("UPDATE LOL_QNA SET GAME_recommend = GAME_recommend+1 WHERE GAME_NO = #{noQnA}")
    int recommendUpdate(@Param("noQnA") int noQnA);

    @Select("""
            SELECT GAME_recommend FROM LOL_QNA WHERE GAME_NO = #{noQnA}
            """)
    int getRecommend(@Param("noQnA") int noQnA);

    @Update("UPDATE LOL_QNA SET GAME_hits = GAME_hits+1 WHERE GAME_NO = #{noQnA}")
    int hitsUpdate(@Param("noQnA") int noQnA);

    @ResultMap("QnAResult")
    @Select("""
            SELECT GAME_NO, GAME_TITLE, GAME_CONTENT, GAME_WRITER,  TO_CHAR(GAME_DATE, 'YYYY-MM-DD') AS dateQnA, 
            GAME_hits, GAME_recommend
            FROM LOL_QNA
            WHERE GAME_NO = #{noQnA}
            """)
    Optional<QnADTO> QnADetail(@Param("noQnA") int noQnA);

    @Select("""
            SELECT COUNT(*) FROM LOL_QNA
            WHERE GAME_NO = #{noQnA} AND GAME_PASSWD = #{passwdQnA}
            """)
    int pwdCheck(QnADTO qnaDTO);

    @SelectProvider(type = QnASqlProvider.class, method = "countPage")
    int countPage(PageRequestDTO pageRequestDTO);

    @ResultMap("QnAResult")
    @SelectProvider(type = QnASqlProvider.class, method = "postList")
    List<QnADTO> postList(PageRequestDTO pageRequestDTO);
}
