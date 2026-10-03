package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

/**
 * file消息
 * 
 * @author Enmaai
 * 
 */
public class WXOutVideoMsg extends WXOutMsg {
	private String media_id;
	private String title;
	private String description;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

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

	@Override
	protected void fillJSON(JSONObject json) {
		super.fillJSON(json);

		JSONObject text = new JSONObject();
		text.put("media_id", this.getMedia_id());
		text.put("title", this.getTitle());
		text.put("description", this.getDescription());

		json.put("msgtype", "video");
		json.put("video", text);
	}

	@Override
	protected void fillXML(StringBuilder builder) {
		builder.append("<MsgType><![CDATA[video]]></MsgType>");

		builder.append("<Video>");
		builder.append("<MediaId><![CDATA[" + this.getMedia_id() + "]]></MediaId>");
		builder.append("<Title><![CDATA[" + this.getTitle() + "]]></Title>");
		builder.append("<Description><![CDATA[" + this.getDescription() + "]]></Description>");
		builder.append("</Video>");
	}
}
