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

public class WXOutNewsMsg
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
        json.put("msgtype", (Object)"news");
        json.put("news", (Object)text);
    }

    @Override
    protected void fillXML(StringBuilder builder) {
        int nCount = 0;
        if (this.articles != null) {
            nCount = this.articles.size();
        }
        builder.append("<MsgType><![CDATA[news]]></MsgType>");
        builder.append("<ArticleCount>" + nCount + "</ArticleCount>");
        builder.append("<Articles>");
        if (this.articles != null) {
            for (Article article : this.articles) {
                builder.append("<item>");
                builder.append("<Title><![CDATA[" + article.getTitle() + "]]></Title>");
                builder.append("<Description><![CDATA[" + article.getDescription() + "]]></Description>");
                builder.append("<PicUrl><![CDATA[" + article.getPicurl() + "]]></PicUrl>");
                builder.append("<Url><![CDATA[" + article.getUrl() + "]]></Url>");
                builder.append("</item>");
            }
        }
        builder.append("</Articles>");
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return this.picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public JSONObject toJSON() {
            JSONObject json = new JSONObject();
            json.put("title", (Object)this.getTitle());
            json.put("description", (Object)this.getDescription());
            json.put("url", (Object)this.getUrl());
            json.put("picurl", (Object)this.getPicurl());
            return json;
        }
    }
}

