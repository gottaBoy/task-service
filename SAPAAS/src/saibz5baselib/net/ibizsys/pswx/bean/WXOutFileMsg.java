package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

/**
 * file消息
 * 
 * @author Enmaai
 *
 */
public class WXOutFileMsg extends WXOutMsg {
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


		json.put("msgtype", "file");
		json.put("file", text);
	}
}
