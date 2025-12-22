package com.macademy.shop.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PageHandler {
    private int totalCnt;
    private int pageSize=10;
    private int naviSize=10;
    private int totalPage;
    private int page;
    private int beginPage;
    private int endPage;
    private boolean firstPage;
    private boolean lastPage;

    public PageHandler(int totalCnt,int pageSize,int page){
        this.totalCnt=totalCnt;
        this.pageSize=pageSize;
        this.page=page;

        totalPage = (int) Math.ceil(totalCnt/pageSize);
        beginPage = totalCnt==0? 0 : (page-1)/naviSize *naviSize+1;
        endPage = Math.min(beginPage+naviSize-1,totalPage);
        firstPage= (totalCnt ==0)||(beginPage==1);
        lastPage= (totalCnt==0)||(endPage==totalPage);
    }

}
