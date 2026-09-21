/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.ajax.IPSAjaxHandlerAction
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerAction;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerRuntime;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewAjaxHandlerImpl
extends PSObjectImpl
implements IPSAjaxHandler,
IPSAjaxHandlerRuntime {
    private static final Log log = LogFactory.getLog(PSViewAjaxHandlerImpl.class);
    protected PSACHandler psAjaxHandler = null;
    protected IPSAppView iPSAppView = null;
    protected boolean bEnableDEFieldPrivilege = false;
    protected int nTempDataMode = 0;
    private IPSAppDEView iPSAppDEView = null;
    private Properties handlerParams = null;
    private String strHandlerObj = "";
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private HashMap<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = new HashMap();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, Object item, PSACHandler psAjaxHandler) throws Exception {
        try {
            if (!(item instanceof IPSAppView)) {
                throw new Exception("\u4f20\u5165\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
            }
            IPSAppView iPSAppView = (IPSAppView)item;
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSAppView(iPSAppView);
            this.psAjaxHandler = psAjaxHandler;
            this.setId(this.psAjaxHandler.getPSACHANDLERID());
            this.setName(this.psAjaxHandler.getPSACHANDLERNAME());
            this.setPSObjectData(this.psAjaxHandler);
            this.handlerParams = PropertiesHelper.load((Properties)new Properties(), (String)psAjaxHandler.getHANDLERPARAMS());
            if (iPSAppView instanceof IPSAppDEView) {
                this.iPSAppDEView = (IPSAppDEView)iPSAppView;
                this.nTempDataMode = this.iPSAppDEView.getTempMode();
            }
            if (!psAjaxHandler.isTEMPMODENull()) {
                this.nTempDataMode = psAjaxHandler.getTEMPMODE();
            }
            this.strHandlerObj = this.psAjaxHandler.getHANDLEROBJ();
            if (iPSAppView.isEnableWF() && !StringHelper.isNullOrEmpty((String)this.psAjaxHandler.getHANDLEROBJ2()) && StringHelper.compare((String)this.psAjaxHandler.getHANDLEROBJ2(), (String)"#", (boolean)true) != 0) {
                this.strHandlerObj = this.psAjaxHandler.getHANDLEROBJ2();
            }
            if (StringHelper.compare((String)this.strHandlerObj, (String)"#", (boolean)true) == 0) {
                this.strHandlerObj = "";
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxHandler.getUSERTAG())) {
                this.strUserTag = this.psAjaxHandler.getUSERTAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxHandler.getUSERTAG2())) {
                this.strUserTag2 = this.psAjaxHandler.getUSERTAG2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxHandler.getUSERTAG3())) {
                this.strUserTag3 = this.psAjaxHandler.getUSERTAG3();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAjaxHandler.getUSERTAG4())) {
                this.strUserTag4 = this.psAjaxHandler.getUSERTAG4();
            }
            this.onInit();
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
        super.onInit();
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    protected void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b")
    public String getHandlerObj() {
        return this.strHandlerObj;
    }

    protected Properties getHandlerParams() {
        return this.handlerParams;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSAppViewRuntime)this.iPSAppView).getPSSysModelInstId();
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
        this.psAjaxHandlerActionMap.put(iPSAjaxHandlerAction.getName().toLowerCase(), iPSAjaxHandlerAction);
    }

    protected void removePSAjaxHandlerAction(String strActionName) {
        this.psAjaxHandlerActionMap.remove(strActionName.toLowerCase());
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions() {
        return this.psAjaxHandlerActionMap.values().iterator();
    }

    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String strName, boolean bTryMode) throws Exception {
        IPSAjaxHandlerAction iPSAjaxHandlerAction = this.psAjaxHandlerActionMap.get(strName.toLowerCase());
        if (iPSAjaxHandlerAction == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSAjaxHandlerAction;
    }
}

