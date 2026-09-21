/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.ajax.IPSAjaxHandlerAction
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.ajax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandlerRuntime;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerAction;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxControlHandlerImpl
extends PSObjectImpl
implements IPSAjaxControlHandlerRuntime {
    private static final Log log = LogFactory.getLog(PSAjaxControlHandlerImpl.class);
    private static final HashMap<String, IPSAjaxHandlerAction> emptyPSAjaxHandlerActionMap = new HashMap();
    protected IPSAjaxControl iPSAjaxControl = null;
    protected PSACHandler psAjaxControlHandler = null;
    protected IPSAppView iPSAppView = null;
    private HashMap<String, Boolean> enableAjaxActionMap = null;
    protected HashMap<String, String> ajaxDEActionMap = new HashMap();
    protected HashMap<String, String> ajaxDEActionNameMap = new HashMap();
    protected HashMap<String, String> ajaxDataAccessActionMap = new HashMap();
    protected HashMap<String, Integer> timeoutAjaxActionMap = new HashMap();
    private HashMap<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = null;
    protected boolean bEnableDEFieldPrivilege = false;
    protected int nTempDataMode = 0;
    private IPSAppDEView iPSAppDEView = null;
    private Properties handlerParams = null;
    private String strHandlerObj = "";
    private boolean bEnableCache = false;
    private int nCacheTimeout = -1;
    private int nCacheScope = 0;
    private String strUniStateKeyValue = null;
    private String strUniStateField = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSAppView iPSAppView, IPSAjaxControl iPSAjaxControl, PSACHandler psAjaxControlHandler) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSAppView(iPSAppView);
            this.setPSAjaxControl(iPSAjaxControl);
            this.psAjaxControlHandler = psAjaxControlHandler;
            this.setId(this.psAjaxControlHandler.getPSACHANDLERID());
            this.setName(this.psAjaxControlHandler.getPSACHANDLERNAME());
            this.setPSObjectData(this.psAjaxControlHandler);
            this.handlerParams = PropertiesHelper.load((Properties)new Properties(), (String)psAjaxControlHandler.getHANDLERPARAMS());
            if (iPSAppView instanceof IPSAppDEView) {
                this.iPSAppDEView = (IPSAppDEView)iPSAppView;
                this.nTempDataMode = this.iPSAppDEView.getTempMode();
            }
            if (!psAjaxControlHandler.isTEMPMODENull()) {
                this.nTempDataMode = psAjaxControlHandler.getTEMPMODE();
            }
            this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ();
            if (iPSAppView.isEnableWF() && !StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getHANDLEROBJ2()) && StringHelper.compare((String)this.psAjaxControlHandler.getHANDLEROBJ2(), (String)"#", (boolean)true) != 0) {
                this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ2();
            }
            if (StringHelper.compare((String)this.strHandlerObj, (String)"#", (boolean)true) == 0) {
                this.strHandlerObj = "";
            }
            if (!this.psAjaxControlHandler.isENABLECACHENull()) {
                this.bEnableCache = this.psAjaxControlHandler.getENABLECACHE();
            }
            if (!this.psAjaxControlHandler.isCACHESCOPENull()) {
                this.nCacheScope = this.psAjaxControlHandler.getCACHESCOPE();
            }
            if (!this.psAjaxControlHandler.isCACHETIMEOUTNull()) {
                this.nCacheTimeout = this.psAjaxControlHandler.getCACHETIMEOUT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUNISTATEKEYVALUE())) {
                this.strUniStateKeyValue = this.psAjaxControlHandler.getUNISTATEKEYVALUE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUNISTATEFIELD())) {
                this.strUniStateField = this.psAjaxControlHandler.getUNISTATEFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG())) {
                this.strUserTag = this.psAjaxControlHandler.getUSERTAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG2())) {
                this.strUserTag2 = this.psAjaxControlHandler.getUSERTAG2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG3())) {
                this.strUserTag3 = this.psAjaxControlHandler.getUSERTAG3();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG4())) {
                this.strUserTag4 = this.psAjaxControlHandler.getUSERTAG4();
            }
            this.onInit();
            this.onPreparePSAjaxHandlerActions();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.handlerParams != null) {
            for (Object objKey : this.handlerParams.keySet()) {
                String strValue;
                String strKey = objKey.toString().toLowerCase();
                if (strKey.indexOf("action.") != 0 || StringHelper.isNullOrEmpty((String)(strValue = PropertiesHelper.getProperty((Properties)this.handlerParams, (String)objKey.toString(), (String)"")))) continue;
                this.ajaxDEActionNameMap.put(strKey.substring(7), strValue);
            }
        }
        super.onInit();
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    protected void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    public IPSAjaxControl getPSAjaxControl() {
        return this.iPSAjaxControl;
    }

    protected void setPSAjaxControl(IPSAjaxControl iPSAjaxControl) {
        this.iPSAjaxControl = iPSAjaxControl;
    }

    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b")
    public String getHandlerObj() {
        return this.strHandlerObj;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAjaxControl() != null) {
            return this.getPSAjaxControl().getPSDataEntity();
        }
        if (this.getPSAppView() instanceof IPSAppDEView) {
            return ((IPSAppDEView)this.getPSAppView()).getPSDataEntity();
        }
        return null;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5c5e\u6027\u7ea7\u6743\u9650")
    public boolean isEnableDEFieldPrivilege() {
        return this.bEnableDEFieldPrivilege;
    }

    public void setEnableDEFieldPrivilege(boolean bEnableDEFieldPrivilege) {
        this.bEnableDEFieldPrivilege = bEnableDEFieldPrivilege;
    }

    public boolean isEnableAjaxAction(String strAjaxActionName) {
        if (this.enableAjaxActionMap != null && this.enableAjaxActionMap.containsKey(strAjaxActionName)) {
            return this.enableAjaxActionMap.get(strAjaxActionName);
        }
        return true;
    }

    public String getDEActionName(String strAjaxActionName) {
        return this.ajaxDEActionNameMap.get(strAjaxActionName);
    }

    public String getDataAccessAction(String strAjaxActionName) {
        String strDataAccessAction = this.ajaxDataAccessActionMap.get(strAjaxActionName);
        if (StringHelper.isNullOrEmpty((String)strDataAccessAction)) {
            return "";
        }
        return strDataAccessAction;
    }

    public Iterator<String> getAjaxActions() {
        return this.ajaxDEActionNameMap.keySet().iterator();
    }

    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode")
    public int getTempMode() {
        return this.nTempDataMode;
    }

    protected Properties getHandlerParams() {
        return this.handlerParams;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSAppView);
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        return this.strUserTag;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        return this.strUserTag2;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb03")
    public String getUserTag3() {
        return this.strUserTag3;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb04")
    public String getUserTag4() {
        return this.strUserTag4;
    }

    @Override
    public String getModelType() {
        return "PSACHANDLER";
    }

    protected void registerPSAjaxHandlerAction(IPSAjaxHandlerAction iPSAjaxHandlerAction) {
        if (this.psAjaxHandlerActionMap == null) {
            this.psAjaxHandlerActionMap = new HashMap();
        }
        this.psAjaxHandlerActionMap.put(iPSAjaxHandlerAction.getName().toLowerCase(), iPSAjaxHandlerAction);
    }

    protected void removePSAjaxHandlerAction(String strActionName) {
        if (this.psAjaxHandlerActionMap == null) {
            return;
        }
        this.psAjaxHandlerActionMap.remove(strActionName.toLowerCase());
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions() {
        if (this.psAjaxHandlerActionMap != null) {
            return this.psAjaxHandlerActionMap.values().iterator();
        }
        return emptyPSAjaxHandlerActionMap.values().iterator();
    }

    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String strName, boolean bTryMode) throws Exception {
        IPSAjaxHandlerAction iPSAjaxHandlerAction = null;
        if (this.psAjaxHandlerActionMap != null) {
            iPSAjaxHandlerAction = this.psAjaxHandlerActionMap.get(strName.toLowerCase());
        }
        if (iPSAjaxHandlerAction == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSAjaxHandlerAction;
    }

    protected void onPreparePSAjaxHandlerActions() throws Exception {
    }
}

