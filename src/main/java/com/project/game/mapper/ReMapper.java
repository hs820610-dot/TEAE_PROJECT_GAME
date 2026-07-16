package com.project.game.mapper;

import com.project.game.dto.ReDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ReMapper {
    @Results(id="replyResult", value = {
            @Result(property = "reContentQnA", column = "REPLY_CONTENT"),
            @Result(property = "reWriterQnA", column = "REPLY_WRITER"),
            @Result(property = "reDateQnA", column = "reDateQnA"),
            @Result(property = "rePasswdQnA", column = "REPLY_PASSWD")
    })
    @Select("""
            SELECT REPLY_CONTENT, REPLY_WRITER, REPLY_PASSWD, TO_CHAR(REPLY_DATE, 'YYYY-MM-DD') AS reDateQnA FROM LOL_QNA_RE WHERE GAME_NO = #{noQnA}
            """)
    ReDTO replyDetail(@Param("noQnA") int noQnA);
}
