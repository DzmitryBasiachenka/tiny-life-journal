package com.bsdim.tlj.domain.article;

import org.junit.Assert;
import org.junit.Test;

public class ArticleTest {
    private String id = "id";
    private String title = "title";
    private String text = "text";
    private String userId = "userId";

    @Test
    public void testEquals() throws Exception {
        Article article = testSetters();
        Assert.assertTrue(article.equals(article));
        Assert.assertFalse(article.equals(new Object()));

        Article otherArticle = null;
        Assert.assertFalse(article.equals(otherArticle));

        otherArticle = testSetters();
        Assert.assertTrue(article.equals(otherArticle));
        Assert.assertTrue(otherArticle.equals(article));
    }

    @Test
    public void testHashCode() throws Exception {
        Article article = testSetters();
        Article otherArticle = testSetters();
        Assert.assertEquals(article.hashCode(), otherArticle.hashCode());

        otherArticle = testSetters();
        otherArticle.setId("1");
        Assert.assertNotEquals(article.hashCode(), otherArticle.hashCode());
    }

    public Article testSetters() {
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setText(text);
        article.setUserId(userId);
        return article;
    }
}
