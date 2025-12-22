package com.macademy.shop;

import com.macademy.shop.config.PageHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PageHandlerTest {
    @Test
    void test1(){
        PageHandler ph = new PageHandler(256,10,1);
        assertThat(ph.getBeginPage()).isEqualTo(1);
        assertThat(ph.getEndPage()).isEqualTo(10);
        assertThat(ph.isFirstPage()).isTrue();
        assertThat(ph.isLastPage()).isFalse();
    }
    @Test
    @DisplayName("마지막페이지 테스트")
    void test2(){
        PageHandler ph = new PageHandler(256,10,256);
        assertThat(ph.getBeginPage()).isEqualTo(251);
        assertThat(ph.getEndPage()).isEqualTo(256);
        assertThat(ph.isFirstPage()).isFalse();
        assertThat(ph.isLastPage()).isTrue();
    }
}
