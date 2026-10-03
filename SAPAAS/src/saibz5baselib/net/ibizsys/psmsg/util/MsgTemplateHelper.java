package net.ibizsys.psmsg.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.EntityTemplateLoader;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psmsg.core.MsgContentTypes;
import net.ibizsys.psmsg.core.MsgTypes;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

/**
 * 消息模板辅助对象
 * 
 * @author Administrator
 * 
 */
public class MsgTemplateHelper {

	private static HashMap<Integer, Template> templateCacheMap = new HashMap<Integer, Template>();
	
	
	/**
	 * 建立消息队列对象
	 * 
	 * @param nMsgType
	 * @param msgTemplate
	 * @param iEntity
	 * @param iWebContext
	 * @param msgAccount
	 * @param strCurPersonId
	 * @return
	 * @throws Exception
	 */
	public static MsgSendQueue getMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, IEntity iEntity, IWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId) throws Exception {
		return getMsgSendQueue(nMsgType, msgTemplate, null, iEntity, null, iWebContext, msgAccount, strCurPersonId, "");
	}

	/**
	 * 建立消息队列对象
	 * 
	 * @param nMsgType
	 * @param msgTemplate
	 * @param iDEModel
	 * @param iEntity
	 * @param oldEntity
	 * @param iWebContext
	 * @param msgAccount
	 * @param strCurPersonId
	 * @param strLanguage
	 * @return
	 * @throws Exception
	 */
	public static MsgSendQueue getMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, IDataEntityModel iDEModel, IEntity iEntity, IEntity oldEntity, IWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId, String strLanguage) throws Exception {
		if (iDEModel == null && (!StringHelper.isNullOrEmpty(msgTemplate.getDEId()))) {
			iDEModel = DEModelGlobal.getDEModel(msgTemplate.getDEId());
		}

		Map<String, Object> params = new TreeMap<String, Object>();
		if (iDEModel != null) params.put("demodel", iDEModel);
		if (iEntity != null) {
			params.put("activedata", iEntity);
			params.put("data", iEntity);
		}
		if (oldEntity != null) params.put("olddata", oldEntity);
		if (iWebContext != null) params.put("webcontext", iWebContext);
		params.put("msgtype", nMsgType);
		// MacroHelper.FillMacroParams(params, iWebContext, iDAGlobalHelper, strCurPersonId, iDEModel,iEntity, strLanguage);
		// if(oldEntity!=null)
		// MacroHelper.FillDEMacroParams(params,"odef" , iDEModel,oldEntity,strLanguage);

		if (msgAccount != null) {
			params.put("username", msgAccount.getMsgAccountName());
			params.put("userid", msgAccount.getMsgAccountId());
		} else {
			params.put("username", "");
			params.put("userid", "");
		}

//		Configuration config = new Configuration();
//		EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader(msgTemplate);
//		config.setTemplateLoader(deTemplateLoader);

		MsgSendQueue msq = new MsgSendQueue();

		msq.setMsgType(nMsgType);
		switch (nMsgType) {
		case MsgTypes.INTERNAL:
		case MsgTypes.EMAIL: {
			msq.setContentType(msgTemplate.getContentType());
//			if (true) {
//				Template template = config.getTemplate(MsgTemplate.FIELD_SUBJECT);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setSubject(sw.toString());
//			}
//
//			if (true) {
//				Template template = config.getTemplate(MsgTemplate.FIELD_CONTENT);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setContent(sw.toString());
//			}
			
			if (true) {
				Template template = getTemplate( msgTemplate, MsgTemplate.FIELD_SUBJECT);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setSubject(sw.toString());
				}
			}
			
			if (true) {
				Template template = getTemplate( msgTemplate, MsgTemplate.FIELD_CONTENT);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setContent(sw.toString());
				}
			}
		}
			break;
		case MsgTypes.MSN: {
			msq.setContentType(MsgContentTypes.TEXT);
			if (true) {
				String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getIMContent()) ? MsgTemplate.FIELD_CONTENT : MsgTemplate.FIELD_IMCONTENT;
//				Template template = config.getTemplate(strParamId);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setContent(sw.toString());
				Template template = getTemplate( msgTemplate,strParamId);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setContent(sw.toString());
				}
			}
		}
			break;
		case MsgTypes.SMS: {
			msq.setContentType(MsgContentTypes.TEXT);
			if (true) {
				String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getSMSContent()) ? MsgTemplate.FIELD_CONTENT : MsgTemplate.FIELD_SMSCONTENT;
//				Template template = config.getTemplate(strParamId);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setContent(sw.toString());
				Template template = getTemplate( msgTemplate,strParamId);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setContent(sw.toString());
				}
			}
		}
			break;

		case MsgTypes.IM: {
			msq.setContentType(MsgContentTypes.TEXT);
			if (true) {
				String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getIMContent()) ? MsgTemplate.FIELD_CONTENT : MsgTemplate.FIELD_IMCONTENT;
//				Template template = config.getTemplate(strParamId);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setContent(sw.toString());
				Template template = getTemplate( msgTemplate,strParamId);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setContent(sw.toString());
				}
			}
		}
		
		case MsgTypes.WX: {
			msq.setContentType(MsgContentTypes.TEXT);
			if (true) {
				String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getWCContent()) ? MsgTemplate.FIELD_CONTENT : MsgTemplate.FIELD_WCCONTENT;
//				Template template = config.getTemplate(strParamId);
//				StringWriter sw = new StringWriter();
//				template.process(params, sw);
//				msq.setContent(sw.toString());
				Template template = getTemplate( msgTemplate,strParamId);
				if(template!=null){
					StringWriter sw = new StringWriter();
					template.process(params, sw);
					msq.setContent(sw.toString());
				}
			}
		}
			break;
		}

		msq.setMsgSendQueueName(msq.getSubject());
		return msq;
	}
	
	
	/**
	 * 获取模板对象
	 * @param msgTemplate
	 * @param strField
	 * @return
	 * @throws Exception
	 */
	public static Template getTemplate(MsgTemplate msgTemplate,String strField)throws Exception{
		Template template = null;
		String strCode =DataObject.getStringValue(msgTemplate.get(strField),null);
		if(StringHelper.isNullOrEmpty(strCode))
			return template;
		Integer nHashCode = strCode.hashCode();
		synchronized(templateCacheMap)
		{
			template = templateCacheMap.get(nHashCode);
		}
		if(template==null)
		{
			Configuration config = new Configuration();
			EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader(msgTemplate);
			config.setTemplateLoader(deTemplateLoader);
			template = config.getTemplate(strField);

			synchronized(templateCacheMap)
			{
				if(templateCacheMap.size()>2000)
					templateCacheMap.clear();
				templateCacheMap.put(nHashCode, template);
			}
		}
		return template;
	}
}
