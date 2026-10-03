package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

/**
 * image消息
 * 
 * @author Enmaai
 * 
 */
public class WXOutImageMsg extends WXOutMsg {
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	@Override
	protected void fillJSON(JSONObject json) {
		super.fillJSON(json);

		JSONObject text = new JSONObject();
		text.put("media_id", this.getMedia_id());
		json.put("msgtype", "image");
		json.put("image", text);
	}

	@Override
	protected void fillXML(StringBuilder builder) {
		builder.append("<MsgType><![CDATA[image]]></MsgType>");

		builder.append("<Image>");
		builder.append("<MediaId><![CDATA[" + this.getMedia_id() + "]]></MediaId>");
		builder.append("</Image>");
	}
}
