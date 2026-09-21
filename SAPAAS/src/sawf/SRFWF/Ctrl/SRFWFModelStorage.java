/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFWF.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SRFWF.Ctrl.Data.WFInstance;
import SRFWF.Ctrl.Data.WFWorkflow;
import SRFWF.Ctrl.ISRFWFWorkflowHelper;
import SRFWF.Model.WFConfig;
import java.util.Hashtable;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFWFModelStorage {
    private static Log log = LogFactory.getLog(SRFWFModelStorage.class);
    protected Hashtable<String, WFConfig> wfConfigMap = new Hashtable();
    protected Hashtable<String, ISRFWFWorkflowHelper> wfHelperMap = new Hashtable();
    private static final int MAXSIZE = 100;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFConfig FindWFConfig(WFWorkflow workflow) {
        String strConfigId = StringHelper.Format((String)"%1$s_V%2$s", (Object)workflow.getWFWORKFLOWID(), (Object)workflow.getWFVERSION());
        strConfigId = strConfigId.toUpperCase();
        Hashtable<String, WFConfig> hashtable = this.wfConfigMap;
        synchronized (hashtable) {
            if (this.wfConfigMap.containsKey(strConfigId)) {
                return this.wfConfigMap.get(strConfigId);
            }
        }
        String strWorkflowXML = workflow.getWFMODEL();
        strWorkflowXML.trim();
        if (StringHelper.IsNullOrEmpty((String)strWorkflowXML)) {
            log.error((Object)StringHelper.Format((String)"%1$s(ver%2$s) \u6ca1\u6709\u6d41\u7a0b\u914d\u7f6e", (Object)workflow.getWFWORKFLOWID(), (Object)workflow.getWFVERSION()));
            return null;
        }
        WFConfig wfConfig = new WFConfig();
        if (!wfConfig.LoadFromXML(strWorkflowXML)) {
            log.error((Object)StringHelper.Format((String)"%1$s(ver%2$s) \u52a0\u8f7d\u6d41\u7a0b\u914d\u7f6e\u5931\u8d25", (Object)workflow.getWFWORKFLOWID(), (Object)workflow.getWFVERSION()));
            return null;
        }
        wfConfig.SetValue("VERSION", StringHelper.Format((String)"%1$s", (Object)workflow.getWFVERSION()));
        Hashtable<String, WFConfig> hashtable2 = this.wfConfigMap;
        synchronized (hashtable2) {
            if (this.wfConfigMap.size() > 100) {
                this.wfConfigMap.clear();
            }
            this.wfConfigMap.put(strConfigId, wfConfig);
        }
        return wfConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFConfig FindWFConfig(WFInstance wfInstance) {
        String strConfigId = StringHelper.Format((String)"%1$s_V%2$s", (Object)wfInstance.getWFWORKFLOWID(), (Object)wfInstance.getWFVERSION());
        strConfigId = strConfigId.toUpperCase();
        Hashtable<String, WFConfig> hashtable = this.wfConfigMap;
        synchronized (hashtable) {
            if (this.wfConfigMap.containsKey(strConfigId)) {
                return this.wfConfigMap.get(strConfigId);
            }
        }
        String strWorkflowXML = wfInstance.getWFMODEL();
        strWorkflowXML.trim();
        if (StringHelper.IsNullOrEmpty((String)strWorkflowXML)) {
            log.error((Object)StringHelper.Format((String)"%1$s(ver%2$s) \u6ca1\u6709\u6d41\u7a0b\u914d\u7f6e", (Object)wfInstance.getWFWORKFLOWID(), (Object)wfInstance.getWFVERSION()));
            return null;
        }
        WFConfig wfConfig = new WFConfig();
        if (!wfConfig.LoadFromXML(strWorkflowXML)) {
            log.error((Object)StringHelper.Format((String)"%1$s(ver%2$s) \u52a0\u8f7d\u6d41\u7a0b\u914d\u7f6e\u5931\u8d25", (Object)wfInstance.getWFWORKFLOWID(), (Object)wfInstance.getWFVERSION()));
            return null;
        }
        wfConfig.SetValue("VERSION", StringHelper.Format((String)"%1$s", (Object)wfInstance.getWFVERSION()));
        Hashtable<String, WFConfig> hashtable2 = this.wfConfigMap;
        synchronized (hashtable2) {
            if (this.wfConfigMap.size() > 100) {
                this.wfConfigMap.clear();
            }
            this.wfConfigMap.put(strConfigId, wfConfig);
        }
        return wfConfig;
    }

    public ISRFWFWorkflowHelper FindWFHelper(WFWorkflow workflow) throws Exception {
        String strWFWorkflowHelper = workflow.getWFHELPER();
        if (StringHelper.IsNullOrEmpty((String)strWFWorkflowHelper)) {
            return null;
        }
        ISRFWFWorkflowHelper iSRFWFWorkflowHelper = this.wfHelperMap.get(strWFWorkflowHelper);
        if (iSRFWFWorkflowHelper != null) {
            return iSRFWFWorkflowHelper;
        }
        Object objHelper = ObjectHelper.Create((String)strWFWorkflowHelper);
        if (objHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6d41\u7a0b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strWFWorkflowHelper));
        }
        if (!(objHelper instanceof ISRFWFWorkflowHelper)) {
            throw new Exception(StringHelper.Format((String)"\u6d41\u7a0b\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strWFWorkflowHelper));
        }
        iSRFWFWorkflowHelper = (ISRFWFWorkflowHelper)objHelper;
        Properties helperParams = new Properties();
        if (!StringHelper.IsNullOrEmpty((String)workflow.getWFHELPERPARAM())) {
            PropertiesHelper.Load((Properties)helperParams, (String)workflow.getWFHELPERPARAM());
        }
        iSRFWFWorkflowHelper.Init(helperParams);
        this.wfHelperMap.put(strWFWorkflowHelper, iSRFWFWorkflowHelper);
        return iSRFWFWorkflowHelper;
    }
}

