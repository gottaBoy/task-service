/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSON
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import java.util.List;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXOutMPNewsMsg
extends WXOutMsg {
    private List<Article> articles = null;

    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    protected void fillJSON(JSONObject json) {
        super.fillJSON(json);
        JSONObject text = new JSONObject();
        JSONArray array = new JSONArray();
        if (this.articles != null) {
            for (Article article : this.articles) {
                array.put((JSON)article.toJSON());
            }
        }
        text.put("articles", (Object)array);
        json.put("msgtype", (Object)"mpnews");
        json.put("mpnews", (Object)text);
    }

    public static class Article {
        private String title;
        private String thumb_media_id;
        private String author;
        private String content_source_url;
        private String content;
        private String digest;
        private int show_cover_pic;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb_media_id() {
            return this.thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent_source_url() {
            return this.content_source_url;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return this.digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public int getShow_cover_pic() {
            return this.show_cover_pic;
        }

        public void setShow_cover_pic(int show_cover_pic) {
            this.show_cover_pic = show_cover_pic;
        }

        public JSONObject toJSON() {
            JSONObject json = new JSONObject();
            json.put("title", (Object)this.getTitle());
            json.put("thumb_media_id", (Object)this.getThumb_media_id());
            json.put("author", (Object)this.getAuthor());
            json.put("content_source_url", (Object)this.getContent_source_url());
            json.put("content", (Object)this.getContent());
            json.put("digest", (Object)this.getDigest());
            json.put("show_cover_pic", this.getShow_cover_pic());
            return json;
        }
    }
}

