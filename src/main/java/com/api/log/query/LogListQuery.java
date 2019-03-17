package com.api.log.query;

import com.api.log.entity.Log;

import java.util.List;

public class LogListQuery {
    private List<Log> content;
    private long total;

    public List<Log> getContent() {
        return content;
    }

    public void setContent(List<Log> content) {
        this.content = content;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LogListQuery{" +
                "content=" + content +
                ", total=" + total +
                '}';
    }
}
