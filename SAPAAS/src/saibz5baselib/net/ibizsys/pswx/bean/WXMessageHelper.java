package net.ibizsys.pswx.bean;

import java.util.Map;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.util.XMLConverUtil;

/**
 * 微信消息帮助对象
 * 
 * @author Administrator
 * 
 */
public class WXMessageHelper {
	/**
	 * 获取微信消息
	 * 
	 * @param content 内容
	 * @return
	 * @throws Exception
	 */
	public static WXMessage getWXMessage(String content) throws Exception {
		Map<String, String> map = XMLConverUtil.convertToMap(content);

		WXMessage wxMessage = new WXMessage();

		if (map.containsKey("MsgId")) {
			wxMessage.setWXMessageId(map.get("MsgId"));
			wxMessage.setWXMessageName(map.get("MsgId"));
		}
		if (map.containsKey("ToUserName")) {
			wxMessage.setToUserName(map.get("ToUserName"));
		}
		if (map.containsKey("FromUserName")) {
			wxMessage.setFromUserName(map.get("FromUserName"));
		}
		if (map.containsKey("CreateTime")) {

			long nTime = Integer.parseInt(map.get("CreateTime"));
			wxMessage.setIncomeTime(new java.sql.Timestamp(nTime * 1000));
		}
		if (map.containsKey("MsgType")) {
			wxMessage.setMsgType(map.get("MsgType"));
		}

		if (map.containsKey("ToUserName")) {
			wxMessage.setToUserName(map.get("ToUserName"));
		}
		if (map.containsKey("ToUserName")) {
			wxMessage.setToUserName(map.get("ToUserName"));
		}

		if (StringHelper.compare(wxMessage.getMsgType(), WXMsgTypeCodeListModel.TEXT, true) == 0) {
			wxMessage.setContent(map.get("Content"));
			return wxMessage;
		}

		if (StringHelper.compare(wxMessage.getMsgType(), WXMsgTypeCodeListModel.VOICE, true) == 0) {
			wxMessage.setFormat(map.get("Format"));
			wxMessage.setMediaId(map.get("MediaId"));
			wxMessage.setContent(map.get("Recognition"));
			return wxMessage;
		}

		if (StringHelper.compare(wxMessage.getMsgType(), WXMsgTypeCodeListModel.EVENT, true) == 0) {
			wxMessage.setEvent(map.get("Event"));
			wxMessage.setContent(map.get("EventKey"));
			return wxMessage;
		}

		return wxMessage;
	}
}
