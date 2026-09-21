/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.ajax.IPSAjaxHandlerAction
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
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerAction;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerRuntime;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxHandlerImpl
extends PSObjectImpl
implements IPSAjaxHandler,
IPSAjaxHandlerRuntime {
    private static final Log log = LogFactory.getLog(PSAjaxHandlerImpl.class);
    protected PSACHandler psAjaxControlHandler = null;
    private Object objItem = null;
    private Properties handlerParams = null;
    private String strHandlerObj = "";
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private HashMap<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = new HashMap();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, Object item, PSACHandler psAjaxControlHandler) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.psAjaxControlHandler = psAjaxControlHandler;
            this.setId(this.psAjaxControlHandler.getPSACHANDLERID());
            this.setName(this.psAjaxControlHandler.getPSACHANDLERNAME());
            this.setPSObjectData(this.psAjaxControlHandler);
            this.setItem(item);
            this.handlerParams = PropertiesHelper.load((Properties)new Properties(), (String)psAjaxControlHandler.getHANDLERPARAMS());
            this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ();
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

    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b")
    public String getHandlerObj() {
        return this.strHandlerObj;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected void setItem(Object item) {
        this.objItem = item;
    }

    protected Object getItem() {
        return this.objItem;
    }

    protected Properties getHandlerParams() {
        return this.handlerParams;
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

    protected void onPreparePSAjaxHandlerActions() throws Exception {
    }

    public IPSAppView getPSAppView() {
        return null;
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
}

