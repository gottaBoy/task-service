/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.WT.Ctrl.IWTConfigTypeHelper;
import SA.WT.Ctrl.IWTConfigValueHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.WTModelStorageFactory;
import SA.WT.Data.WTServiceSession;
import SA.WT.Data.WTServiceStep;
import SA.WT.Data.WTUser;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;

public class WTMsgTemplateHelper {
    public static CallResult FillWTServiceSession(ISRFDAGlobalHelper iDAGlobalHelper, IWTServiceHelper iWTServiceHelper, WTServiceStep wtServiceStep, WTUser wtUser, WTServiceSession wtServiceSession) {
        Object objMap;
        CallResult callResult = new CallResult();
        TreeMap params = new TreeMap();
        MacroHelper.FillMacroParams(params, null, (ISRFDAGlobalHelper)iDAGlobalHelper, (String)"", null, (BaseDataEntity)wtServiceSession, (String)wtUser.getLANGUAGE());
        wtServiceSession.SetParamValue("SENDTEXT", "");
        wtServiceSession.SetParamValue("SENDCONTENT", "");
        if (wtServiceSession.ContainesParam("#extparams") && (objMap = wtServiceSession.GetParamValue("#extparams")) != null && objMap instanceof Map) {
            Map map = (Map)objMap;
            for (Object objKey : map.keySet()) {
                params.put(objKey.toString(), map.get(objKey));
            }
        }
        try {
            IWTModelStorage iWTModelStorage = WTModelStorageFactory.Create(iDAGlobalHelper);
            IWTConfigTypeHelper iWTConfigTypeHelper = iWTModelStorage.FindWTConfigType("WTMESSAGEFORMAT");
            IWTConfigValueHelper iWTConfigValueHelper = iWTConfigTypeHelper.FindWTConfigValue(wtServiceStep.getMSGFORMAT().toUpperCase());
            Configuration config = new Configuration();
            StringTemplateLoader dpTemplate = new StringTemplateLoader();
            dpTemplate.putTemplate("SENDTEXT", wtServiceStep.getCONTENT());
            dpTemplate.putTemplate("SENDTITLE", wtServiceStep.getTITLE());
            dpTemplate.putTemplate("SENDPICURL", wtServiceStep.getPICURL());
            dpTemplate.putTemplate("SENDDETAILURL", wtServiceStep.getDETAILURL());
            dpTemplate.putTemplate("SENDCONTENT", iWTConfigValueHelper.getConfigValue());
            config.setTemplateLoader((TemplateLoader)dpTemplate);
            Template template = config.getTemplate("SENDTEXT");
            StringWriter sw = new StringWriter();
            template.process(params, (Writer)sw);
            wtServiceSession.SetParamValue("SENDTEXT", sw.toString());
            template = config.getTemplate("SENDTITLE");
            sw = new StringWriter();
            template.process(params, (Writer)sw);
            wtServiceSession.SetParamValue("SENDTITLE", sw.toString());
            template = config.getTemplate("SENDPICURL");
            sw = new StringWriter();
            template.process(params, (Writer)sw);
            wtServiceSession.SetParamValue("SENDPICURL", sw.toString());
            template = config.getTemplate("SENDDETAILURL");
            sw = new StringWriter();
            template.process(params, (Writer)sw);
            wtServiceSession.SetParamValue("SENDDETAILURL", sw.toString());
            template = config.getTemplate("SENDCONTENT");
            sw = new StringWriter();
            template.process(params, (Writer)sw);
            wtServiceSession.SetParamValue("SENDCONTENT", sw.toString());
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
        catch (Exception e) {
            e.printStackTrace();
            callResult.setRetCode(1);
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }
}

