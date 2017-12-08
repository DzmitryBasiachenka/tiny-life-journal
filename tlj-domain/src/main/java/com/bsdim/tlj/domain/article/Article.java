package com.bsdim.tlj.domain.article;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The article.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class Article implements Serializable {
    private static final int INITIAL_NON_ZERO_ODD_NUMBER = 17;
    private static final int MULTIPLIER_NON_ZERO_ODD_NUMBER = 47;
    private static final String LINE_FEED = "\n";
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
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
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
        return new HashCodeBuilder(INITIAL_NON_ZERO_ODD_NUMBER, MULTIPLIER_NON_ZERO_ODD_NUMBER)
                .append(id)
                .append(title)
                .append(text)
                .append(userId)
                .toHashCode();
    }

    /**
     * Converts article to string.
     *
     * @return the data of article.
     */
    public String toString() {
        return new StringBuilder("id: ")
                .append(id)
                .append(LINE_FEED)
                .append("userId: ")
                .append(userId)
                .append(LINE_FEED)
                .append(title)
                .append(LINE_FEED)
                .append(text)
                .toString();
    }
}
