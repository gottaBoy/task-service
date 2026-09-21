/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.bean;

import java.sql.Timestamp;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.util.XMLConverUtil;

public class WXMessageHelper {
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
            wxMessage.setIncomeTime(new Timestamp(nTime * 1000L));
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
        if (StringHelper.compare(wxMessage.getMsgType(), "text", true) == 0) {
            wxMessage.setContent(map.get("Content"));
            return wxMessage;
        }
        if (StringHelper.compare(wxMessage.getMsgType(), "voice", true) == 0) {
            wxMessage.setFormat(map.get("Format"));
            wxMessage.setMediaId(map.get("MediaId"));
            wxMessage.setContent(map.get("Recognition"));
            return wxMessage;
        }
        if (StringHelper.compare(wxMessage.getMsgType(), "event", true) == 0) {
            wxMessage.setEvent(map.get("Event"));
            wxMessage.setContent(map.get("EventKey"));
            return wxMessage;
        }
        return wxMessage;
    }
}

