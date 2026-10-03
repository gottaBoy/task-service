package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

/**
 * file消息
 * 
 * @author Enmaai
 *
 */
public class WXOutVoiceMsg extends WXOutMsg {
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
		json.put("msgtype", "voice");
		json.put("voice", text);
	}
	
	@Override
	protected void fillXML(StringBuilder builder) {
		builder.append("<MsgType><![CDATA[voice]]></MsgType>");

		builder.append("<Voice>");
		builder.append("<MediaId><![CDATA[" + this.getMedia_id() + "]]></MediaId>");
		builder.append("</Voice>");
	}
	
}
