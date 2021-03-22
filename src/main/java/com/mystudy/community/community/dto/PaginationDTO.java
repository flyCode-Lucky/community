package com.mystudy.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    /**
     * 根据数据总条数，数据总页数，每页大小来设置进度条的显示信息
     *
     * @param totalCount 数据总条数
     * @param page       数据总页数
     * @param size       每页大小
     */
    public void setPagination(Integer totalCount, Integer page, Integer size) {


        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }


        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        //将当前页加入pages
        pages.add(page);
        //将所有应显示的页数加入pages
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页图标
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页图标
        if (totalPage.equals(page)) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页图标
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
