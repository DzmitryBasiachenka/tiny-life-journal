package com.bsdim.tlj.domain.article;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Article {
    private String id;
    private String title;
    private String text;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Article article = (Article) obj;
        return new EqualsBuilder()
                .append(id, article.id)
                .append(title, article.title)
                .append(text, article.text)
                .append(userId, article.userId)
                .isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 47).
                append(id).
                append(title).
                append(text).
                append(userId).
                toHashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("id: ");
        builder.append(id);
        builder.append("userId: ");
        builder.append(userId);
        builder.append("\n");
        builder.append(title);
        builder.append("\n");
        builder.append(text);
        return builder.toString();
    }
}
