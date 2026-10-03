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
public class WXOutMPNewsMsg extends WXOutMsg {

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

		json.put("msgtype", "mpnews");
		json.put("mpnews", text);
	}

	/**
	 * 文章
	 * 
	 * @author Enmaai
	 *
	 */
	public static class Article {
		private String title;
		private String thumb_media_id;
		private String author;
		private String content_source_url;
		private String content;
		private String digest;
		private int show_cover_pic;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getContent_source_url() {
			return content_source_url;
		}

		public void setContent_source_url(String content_source_url) {
			this.content_source_url = content_source_url;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getDigest() {
			return digest;
		}

		public void setDigest(String digest) {
			this.digest = digest;
		}

		public int getShow_cover_pic() {
			return show_cover_pic;
		}

		public void setShow_cover_pic(int show_cover_pic) {
			this.show_cover_pic = show_cover_pic;
		}

		public JSONObject toJSON() {
			JSONObject json = new JSONObject();

			json.put("title", this.getTitle());
			json.put("thumb_media_id", this.getThumb_media_id());
			json.put("author", this.getAuthor());
			json.put("content_source_url", this.getContent_source_url());
			json.put("content", this.getContent());
			json.put("digest", this.getDigest());
			json.put("show_cover_pic", this.getShow_cover_pic());

			return json;
		}

	}
}
