/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 */
package net.ibizsys.psmsg.util;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.TreeMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.EntityTemplateLoader;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

public class MsgTemplateHelper {
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();

    public static MsgSendQueue getMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, IEntity iEntity, IWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId) throws Exception {
        return MsgTemplateHelper.getMsgSendQueue(nMsgType, msgTemplate, null, iEntity, null, iWebContext, msgAccount, strCurPersonId, "");
    }

    public static MsgSendQueue getMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, IDataEntityModel iDEModel, IEntity iEntity, IEntity oldEntity, IWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId, String strLanguage) throws Exception {
        if (iDEModel == null && !StringHelper.isNullOrEmpty(msgTemplate.getDEId())) {
            iDEModel = DEModelGlobal.getDEModel(msgTemplate.getDEId());
        }
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        if (iDEModel != null) {
            params.put("demodel", iDEModel);
        }
        if (iEntity != null) {
            params.put("activedata", iEntity);
            params.put("data", iEntity);
        }
        if (oldEntity != null) {
            params.put("olddata", oldEntity);
        }
        if (iWebContext != null) {
            params.put("webcontext", iWebContext);
        }
        params.put("msgtype", nMsgType);
        if (msgAccount != null) {
            params.put("username", msgAccount.getMsgAccountName());
            params.put("userid", msgAccount.getMsgAccountId());
        } else {
            params.put("username", "");
            params.put("userid", "");
        }
        MsgSendQueue msq = new MsgSendQueue();
        msq.setMsgType(nMsgType);
        switch (nMsgType) {
            case 1: 
            case 2: {
                StringWriter sw;
                msq.setContentType(msgTemplate.getContentType());
                Template template = MsgTemplateHelper.getTemplate(msgTemplate, "SUBJECT");
                if (template != null) {
                    sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setSubject(sw.toString());
                }
                if ((template = MsgTemplateHelper.getTemplate(msgTemplate, "CONTENT")) == null) break;
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                msq.setContent(sw.toString());
                break;
            }
            case 8: {
                msq.setContentType("TEXT");
                String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getIMContent()) ? "CONTENT" : "IMCONTENT";
                Template template = MsgTemplateHelper.getTemplate(msgTemplate, strParamId);
                if (template == null) break;
                StringWriter sw = new StringWriter();
                template.process(params, (Writer)sw);
                msq.setContent(sw.toString());
                break;
            }
            case 4: {
                msq.setContentType("TEXT");
                String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getSMSContent()) ? "CONTENT" : "SMSCONTENT";
                Template template = MsgTemplateHelper.getTemplate(msgTemplate, strParamId);
                if (template == null) break;
                StringWriter sw = new StringWriter();
                template.process(params, (Writer)sw);
                msq.setContent(sw.toString());
                break;
            }
            case 16: {
                StringWriter sw;
                msq.setContentType("TEXT");
                String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getIMContent()) ? "CONTENT" : "IMCONTENT";
                Template template = MsgTemplateHelper.getTemplate(msgTemplate, strParamId);
                if (template != null) {
                    sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setContent(sw.toString());
                }
            }
            case 32: {
                msq.setContentType("TEXT");
                String strParamId = StringHelper.isNullOrEmpty(msgTemplate.getWCContent()) ? "CONTENT" : "WCCONTENT";
                Template template = MsgTemplateHelper.getTemplate(msgTemplate, strParamId);
                if (template == null) break;
                StringWriter sw = new StringWriter();
                template.process(params, (Writer)sw);
                msq.setContent(sw.toString());
            }
        }
        msq.setMsgSendQueueName(msq.getSubject());
        return msq;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Template getTemplate(MsgTemplate msgTemplate, String strField) throws Exception {
        Template template = null;
        String strCode = DataObject.getStringValue(msgTemplate.get(strField), null);
        if (StringHelper.isNullOrEmpty(strCode)) {
            return template;
        }
        Integer nHashCode = strCode.hashCode();
        HashMap<Integer, Template> hashMap = templateCacheMap;
        synchronized (hashMap) {
            template = templateCacheMap.get(nHashCode);
        }
        if (template == null) {
            Configuration config = new Configuration();
            EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader(msgTemplate);
            config.setTemplateLoader((TemplateLoader)deTemplateLoader);
            template = config.getTemplate(strField);
            HashMap<Integer, Template> hashMap2 = templateCacheMap;
            synchronized (hashMap2) {
                if (templateCacheMap.size() > 2000) {
                    templateCacheMap.clear();
                }
                templateCacheMap.put(nHashCode, template);
            }
        }
        return template;
    }
}

