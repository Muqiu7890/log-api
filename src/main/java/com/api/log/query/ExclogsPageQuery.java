package com.api.log.query;

import java.util.List;

public class ExclogsPageQuery {
    private List<ExclogsQuery> content;
    private long total;

    public List<ExclogsQuery> getContent() {
        return content;
    }

    public void setContent(List<ExclogsQuery> content) {
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
        return "ExclogsPageQuery{" +
                "content=" + content +
                ", total=" + total +
                '}';
    }
}
