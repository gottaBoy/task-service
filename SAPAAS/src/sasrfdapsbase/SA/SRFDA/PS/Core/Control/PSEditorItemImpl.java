/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorItem;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSEditorItemImpl
extends PSObjectImpl
implements IPSEditorItem,
IPSNavigateParamContainer {
    private static final Log log = LogFactory.getLog(PSEditorItemImpl.class);
    private IPSEditorContainer iPSEditorContainer = null;
    private IPSEditor iPSEditor = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private boolean bSimpleMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSEditor iPSEditor, IPSEditorContainer iPSEditorContainer, String strName, boolean bSimpleMode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSEditorContainer(iPSEditorContainer);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            this.setName(iPSEditorContainer.getEditorName());
        } else {
            this.setName(strName);
        }
        this.iPSEditor = iPSEditor;
        this.bSimpleMode = bSimpleMode;
        this.setAutoModel(true);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSNavViewParams();
        super.onInit();
        this.getPSAppDEACMode();
    }

    protected void onPreparePSNavViewParams() throws Exception {
        Enumeration<Object> names;
        JSONObject itemParamJO = this.getPSEditorContainer().getItemParam();
        if (itemParamJO != null) {
            String strContextJOString;
            String strTag;
            boolean bRawValue;
            String strValue;
            String strKey;
            JSONObject jo;
            Iterator keys;
            String strParamJOString = PSEditorImpl.calcParamJOString(itemParamJO);
            if (!StringHelper.isNullOrEmpty((String)strParamJOString) && (keys = (jo = JSONObjectHelper.fromString2((String)strParamJOString)).keys()) != null) {
                while (keys.hasNext()) {
                    strKey = (String)keys.next();
                    strValue = jo.optString(strKey, "");
                    bRawValue = true;
                    strTag = strKey.toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)(strContextJOString = PSEditorImpl.calcContextJOString(itemParamJO))) && (keys = (jo = JSONObjectHelper.fromString2((String)strContextJOString)).keys()) != null) {
                while (keys.hasNext()) {
                    strKey = (String)keys.next();
                    strValue = jo.optString(strKey, "");
                    bRawValue = true;
                    strTag = strKey.toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                }
            }
        }
        if (this.getEditorParams() != null && (names = this.getEditorParams().keys()) != null) {
            while (names.hasMoreElements()) {
                String strKey = (String)names.nextElement();
                String strValue = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strKey, (String)"");
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    boolean bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl3 = new PSNavigateContextImpl();
                    PSNavigateContextImpl3.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl3);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                boolean bRawValue = true;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl PSNavigateParamImpl3 = new PSNavigateParamImpl();
                PSNavigateParamImpl3.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl3);
            }
        }
    }

    public IPSEditorContainer getPSEditorContainer() {
        return this.iPSEditorContainer;
    }

    protected void setPSEditorContainer(IPSEditorContainer iPSEditorContainer) {
        this.iPSEditorContainer = iPSEditorContainer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSEditorContainer().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSEDITORITEM$" + this.getPSEditor().getModelType();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSEditor().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668")
    public IPSEditor getPSEditor() {
        return this.iPSEditor;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    public Properties getEditorParams() {
        return this.getPSEditorContainer().getEditorParams();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() throws Exception {
        if (this.bSimpleMode) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7ed3\u679c\u96c6\u5408")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (this.bSimpleMode) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u81ea\u586b\u6a21\u5f0f")
    public IPSDEACMode getPSDEACMode() throws Exception {
        if (this.bSimpleMode) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDEACMode();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() throws Exception {
        if (this.iPSAppDataEntity == null && this.getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
        }
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception {
        IPSAppDEMethod iPSAppDEMethod;
        if (this.getPSDEDataSet() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null && (iPSAppDEMethod = iPSAppDataEntity.getPSAppDEMethod(this.getPSDEDataSet(), true)) instanceof IPSAppDEDataSet) {
            return (IPSAppDEDataSet)iPSAppDEMethod;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEACMode getPSAppDEACMode() throws Exception {
        if (this.getPSDEACMode() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null) {
            return iPSAppDataEntity.getPSAppDEACMode(this.getPSDEACMode().getId(), true);
        }
        return null;
    }
}

