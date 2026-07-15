package com.project;

import com.project.game.dto.FreeDTO;
import com.project.game.mapper.FreeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class FreeMapperTest {
    @Autowired
    private FreeMapper freeMapper;

    @Test
    public void freeListTest() {
        freeMapper.freeList().forEach(free -> {
            log.info(free.toString());
        });
    }

    @Test
    public void freeInsertTest() {
        FreeDTO freeDTO = new FreeDTO();
        freeDTO.setGameTitle("aaa");
        freeDTO.setGamePasswd("123");
        freeDTO.setGameContent("zzzz");
        freeDTO.setGameWriter("zfzf");

        int result = freeMapper.freeInsert(freeDTO);
        log.info("생성된 행의 수: {}", result);
    }

    @Test
    public void freeUpdateTest() {
        FreeDTO freeDTO = new FreeDTO();
        freeDTO.setGameNo(1);
        freeDTO.setGameTitle("aaa");
        freeDTO.setGamePasswd("123");
        freeDTO.setGameContent("zzzz");
        freeDTO.setGameWriter("zfzf");

        int result = freeMapper.freeUpdate(freeDTO);
        log.info("변경된 행의 수: {}", result);
    }

    @Test
    public void freeDeleteTest() {
        int gameNo = 1;
        int result = freeMapper.freeDelete(gameNo);
        log.info("삭제된 행의 수: {}", result);
    }

}
