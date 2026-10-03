package net.ibizsys.psmsg.util;

import java.util.HashMap;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;

/**
 * 消息模板全局对象
 * 
 * @author Administrator
 *
 */
public class MsgTemplateGlobal {

	private static HashMap<String, MsgTemplate> msgTemplateMap = new HashMap<String, MsgTemplate>();

	/**
	 * 获取消息模板
	 * 
	 * @param strMsgTemplateId 模板标识
	 * @return
	 * @throws Exception
	 */
	public static MsgTemplate getMsgTemplate(String strMsgTemplateId) throws Exception {
		MsgTemplate msgTemplate = null;
		synchronized (msgTemplateMap) {
			msgTemplate = msgTemplateMap.get(strMsgTemplateId);
		}
		if (msgTemplate != null) return msgTemplate;

		msgTemplate = new MsgTemplate();
		msgTemplate.setMsgTemplateId(strMsgTemplateId);

		MsgTemplateService msgTemplateService = (MsgTemplateService) ServiceGlobal.getService(MsgTemplateService.class);
		msgTemplateService.get(msgTemplate);

		synchronized (msgTemplateMap) {
			msgTemplateMap.put(strMsgTemplateId, msgTemplate);
		}

		return msgTemplate;
	}

	/**
	 * 移除消息模板
	 * 
	 * @param strMsgTemplateId 模板标识
	 * @throws Exception
	 */
	public static void removeMsgTemplate(String strMsgTemplateId) throws Exception {
		synchronized (msgTemplateMap) {
			msgTemplateMap.remove(strMsgTemplateId);
		}
	}

}
