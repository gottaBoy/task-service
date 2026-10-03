/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MsgAccount
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.Data.MsgTemplate
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.DETemplateLoader
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 */
package SA.SRFDA.MSG.Ctrl;

import SA.SRFDA.Ctrl.Data.MsgAccount;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.DETemplateLoader;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.TreeMap;

public class MsgTemplateHelper {
    public static CallResult GetMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, BaseDataEntity dataEntity, ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId) {
        return MsgTemplateHelper.GetMsgSendQueue(nMsgType, msgTemplate, null, dataEntity, null, iDAGlobalHelper, iWebContext, msgAccount, strCurPersonId, "");
    }

    public static CallResult GetMsgSendQueue(int nMsgType, MsgTemplate msgTemplate, IDEHelper iDEHelper, BaseDataEntity dataEntity, BaseDataEntity oldDataEntity, ISRFDAGlobalHelper iDAGlobalHelper, ISRFDAWebContext iWebContext, MsgAccount msgAccount, String strCurPersonId, String strLanguage) {
        CallResult callResult = new CallResult();
        if (iDEHelper == null && !StringHelper.IsNullOrEmpty((String)msgTemplate.getDEID()) && (iDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(msgTemplate.getDEID())) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)msgTemplate.getDEID()));
            return callResult;
        }
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        MacroHelper.FillMacroParams(params, (ISRFDAWebContext)iWebContext, (ISRFDAGlobalHelper)iDAGlobalHelper, (String)strCurPersonId, (IDEHelper)iDEHelper, (BaseDataEntity)dataEntity, (String)strLanguage);
        if (oldDataEntity != null) {
            MacroHelper.FillDEMacroParams(params, (String)"odef", (IDEHelper)iDEHelper, (BaseDataEntity)oldDataEntity, (String)strLanguage);
        }
        if (msgAccount != null) {
            params.put("username", msgAccount.getMSGACCOUNTNAME());
            params.put("userid", msgAccount.getMSGACCOUNTID());
        } else {
            params.put("username", "");
            params.put("userid", "");
        }
        Configuration config = new Configuration();
        DETemplateLoader deTemplateLoader = new DETemplateLoader((BaseDataEntity)msgTemplate);
        config.setTemplateLoader((TemplateLoader)deTemplateLoader);
        MsgSendQueue msq = new MsgSendQueue();
        msq.setMSGTYPE(nMsgType);
        switch (nMsgType) {
            case 1: 
            case 2: {
                StringWriter sw;
                Template template;
                msq.setCONTENTTYPE(msgTemplate.getCONTENTTYPE());
                try {
                    template = config.getTemplate("SUBJECT");
                    sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setSUBJECT(sw.toString());
                }
                catch (IOException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (TemplateException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                try {
                    template = config.getTemplate("CONTENT");
                    sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setCONTENT(sw.toString());
                    break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (TemplateException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
            }
            case 8: {
                msq.setCONTENTTYPE("TEXT");
                try {
                    String strParamId = StringHelper.IsNullOrEmpty((String)msgTemplate.getIMCONTENT()) ? "CONTENT" : "IMCONTENT";
                    Template template = config.getTemplate(strParamId);
                    StringWriter sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setCONTENT(sw.toString());
                    break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (TemplateException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
            }
            case 4: {
                msq.setCONTENTTYPE("TEXT");
                try {
                    String strParamId = StringHelper.IsNullOrEmpty((String)msgTemplate.getSMSCONTENT()) ? "CONTENT" : "SMSCONTENT";
                    Template template = config.getTemplate(strParamId);
                    StringWriter sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setCONTENT(sw.toString());
                    break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (TemplateException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
            }
            case 16: {
                msq.setCONTENTTYPE("TEXT");
                try {
                    String strParamId = StringHelper.IsNullOrEmpty((String)msgTemplate.getIMCONTENT()) ? "CONTENT" : "IMCONTENT";
                    Template template = config.getTemplate(strParamId);
                    StringWriter sw = new StringWriter();
                    template.process(params, (Writer)sw);
                    msq.setCONTENT(sw.toString());
                    break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
                catch (TemplateException e) {
                    e.printStackTrace();
                    callResult.setRetCode(1);
                    return callResult;
                }
            }
        }
        msq.setMSGSENDQUEUENAME(msq.getSUBJECT());
        callResult.setRetCode(0);
        callResult.setUserObject((Object)msq);
        return callResult;
    }
}

