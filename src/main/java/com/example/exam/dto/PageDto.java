package com.example.exam.dto;

import java.util.List;

public class PageDto<T> {
    private  long total;
    private List<T> content;
    private int size;
    private int page;
    private int currentPage;

    public PageDto(long total, List<T> content, int pageSize, int page, int currentPage) {
        this.total = total;
        this.content = content;
        this.size = size;
        this.currentPage = currentPage;

    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
