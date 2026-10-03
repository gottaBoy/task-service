/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.PanelConfig;
import SA.SRFramework.WebEx.UI.PanelTemplateConfig;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import SA.SRFramework.WebEx.UI.UIStyleMgr;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DynamicPanelMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(DynamicPanelMgr.class);
    private final byte[] key;
    static final String TAG_DEFAULTUISTYLE = "UISTYLE_DEFAULT";
    protected TreeMap<String, DPConfig> staticDPConfigMap;
    private UIStyleMgr uiStyleMgr;

    public DynamicPanelMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.staticDPConfigMap = new TreeMap();
        this.uiStyleMgr = null;
    }

    public void setUIStyleMgr(UIStyleMgr uiStyleMgr) {
        this.uiStyleMgr = uiStyleMgr;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Document GetDocument(String strDynamicPanelId) {
        String strDPConfigPath = this.GetConfigFilePath("dynamicpanel" + this.strFolderSeperator + this.GetRealPath(strDynamicPanelId) + ".xml");
        File file = new File(strDPConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDPConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDPConfigPath))) {
                    Document doc = (Document)this.fileList.get(strDPConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DynamicPanelMgr.getContent((String)strDPConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDPConfigPath);
                }
                Document doc = parser.getDocument();
                Map<?, ?> map = this.fileList;
                synchronized (map) {
                    this.fileList.put(strDPConfigPath, doc);
                    this.modifydateList.put(strDPConfigPath, nLastModify);
                }
                map = this.staticDPConfigMap;
                synchronized (map) {
                    this.staticDPConfigMap.remove(strDPConfigPath);
                }
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)"\u52a0\u8f7d\u52a8\u6001\u9762\u677f\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u52a8\u6001\u9762\u677f\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strDPConfigPath));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PanelConfig GetPanelConfig(String strDynamicPanelId) {
        Document doc = this.GetDocument(strDynamicPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                ControlConfigContext controlConfigContext = new ControlConfigContext();
                controlConfigContext.setGlobalUIStyle(this.uiStyleMgr.Get(TAG_DEFAULTUISTYLE));
                controlConfigContext.setParam("DYNAMICPANELMGR", (Object)this);
                PanelConfig panelConfig = new PanelConfig();
                if (panelConfig.LoadConfig(doc.getDocumentElement(), controlConfigContext)) {
                    return panelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u52a8\u6001\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    public DPConfig GetDPExConfig(String strDynamicPanelId) {
        return this.GetDPExConfig(strDynamicPanelId, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DPConfig GetDPExConfig(String strDynamicPanelId, String strCacheMode) {
        Object object;
        StringBuilderEx info = new StringBuilderEx();
        info.Append("\u5f00\u59cb\u52a0\u8f7d\u52a8\u6001\u9762\u677f\u914d\u7f6e[%1$s]\r\n", strDynamicPanelId);
        long nTime = Helper.CurTime();
        Document doc = this.GetDocument(strDynamicPanelId);
        if (doc == null) {
            return null;
        }
        if (!StringHelper.IsNullOrEmpty((String)strCacheMode)) {
            object = this.staticDPConfigMap;
            synchronized (object) {
                DPConfig dpConfig;
                if (this.staticDPConfigMap.containsKey(strDynamicPanelId) && StringHelper.Compare((String)(dpConfig = this.staticDPConfigMap.get(strDynamicPanelId)).getSRFCache(), (String)strCacheMode, (boolean)true) == 0) {
                    return dpConfig;
                }
            }
        }
        nTime = Helper.CurTime() - nTime;
        info.Append("\u8f7d\u5165\u5230XML\u6587\u6863\u8017\u65f6[%1$sms]\r\n", nTime);
        try {
            object = doc;
            synchronized (object) {
                ControlConfigContext controlConfigContext = new ControlConfigContext();
                controlConfigContext.setGlobalUIStyle(this.uiStyleMgr.Get(TAG_DEFAULTUISTYLE));
                controlConfigContext.setParam("DYNAMICPANELMGR", (Object)this);
                nTime = Helper.CurTime();
                DPConfig panelConfig = new DPConfig();
                if (panelConfig.LoadConfig(doc.getDocumentElement(), controlConfigContext)) {
                    panelConfig.setConfigId(strDynamicPanelId);
                    nTime = Helper.CurTime() - nTime;
                    info.Append("\u8f7d\u5165\u5230\u52a8\u6001\u914d\u7f6e\u8017\u65f6[%1$sms]\r\n", nTime);
                    log.debug((Object)info.toString());
                    if (!StringHelper.IsNullOrEmpty((String)strCacheMode)) {
                        panelConfig.setSRFCache(strCacheMode);
                        TreeMap<String, DPConfig> treeMap = this.staticDPConfigMap;
                        synchronized (treeMap) {
                            this.staticDPConfigMap.put(strDynamicPanelId, panelConfig);
                        }
                    }
                    return panelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u52a8\u6001\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public RemotePanelConfig GetRemotePanelConfig(String strDynamicPanelId) {
        Document doc = this.GetDocument(strDynamicPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                ControlConfigContext controlConfigContext = new ControlConfigContext();
                controlConfigContext.setGlobalUIStyle(this.uiStyleMgr.Get(TAG_DEFAULTUISTYLE));
                controlConfigContext.setParam("DYNAMICPANELMGR", (Object)this);
                RemotePanelConfig panelConfig = new RemotePanelConfig();
                if (panelConfig.LoadConfig(doc.getDocumentElement(), controlConfigContext)) {
                    return panelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u52a8\u6001\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PanelTemplateConfig GetPanelTemplateConfig(String strDynamicPanelId) {
        Document doc = this.GetDocument(strDynamicPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                ControlConfigContext controlConfigContext = new ControlConfigContext();
                controlConfigContext.setGlobalUIStyle(this.uiStyleMgr.Get(TAG_DEFAULTUISTYLE));
                controlConfigContext.setParam("DYNAMICPANELMGR", (Object)this);
                PanelTemplateConfig panelConfig = new PanelTemplateConfig();
                if (panelConfig.LoadConfig(doc.getDocumentElement(), controlConfigContext)) {
                    return panelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u6a21\u677f\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    protected String GetConfigRootFolder() {
        return "dynamicpanel";
    }
}
