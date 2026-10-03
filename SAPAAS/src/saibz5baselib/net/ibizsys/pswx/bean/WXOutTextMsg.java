package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

/**
 * text消息
 * 
 * @author Enmaai
 *
 */
public class WXOutTextMsg extends WXOutMsg {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	protected void fillJSON(JSONObject json) {
		super.fillJSON(json);

		JSONObject text = new JSONObject();
		text.put("content", this.getContent());

		json.put("msgtype", "text");
		json.put("text", text);

	}
	@Override
	protected void fillXML(StringBuilder builder) {
		builder.append("<MsgType><![CDATA[text]]></MsgType>");
		builder.append("<Content><![CDATA["+this.getContent()+"]]></Content>");
	}	
}
