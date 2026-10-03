package net.ibizsys.pswx.bean;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * file消息
 * 
 * @author Enmaai
 *
 */
public class WXOutNewsMsg extends WXOutMsg {

	private List<Article> articles = null;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	protected void fillJSON(JSONObject json) {
		super.fillJSON(json);

		JSONObject text = new JSONObject();

		JSONArray array = new JSONArray();
		if (articles != null) {
			for (Article article : articles) {
				array.put(article.toJSON());
			}
		}
		text.put("articles", array);
		json.put("msgtype", "news");
		json.put("news", text);
	}

	/**
	 * 文章
	 * @author Enmaai
	 *
	 */
	public static class Article {
		private String title;
		private String description;
		private String url;
		private String picurl;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}

		public JSONObject toJSON() {
			JSONObject json = new JSONObject();

			json.put("title", this.getTitle());
			json.put("description", this.getDescription());
			json.put("url", this.getUrl());
			json.put("picurl", this.getPicurl());

			return json;
		}

	}
	
	@Override
	protected void fillXML(StringBuilder builder) {
		
		int nCount = 0;
		if(articles != null)
		{
			nCount = articles.size();
		}
		
		builder.append("<MsgType><![CDATA[news]]></MsgType>");
		builder.append("<ArticleCount>"+nCount+"</ArticleCount>");

		   
		builder.append("<Articles>");
		
		if(articles != null)
		{
			for(Article article : articles)
			{
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
	
	
	
}
