/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxHandlerImpl
extends PSObjectImpl
implements IPSAjaxHandler {
    private static final Log log = LogFactory.getLog(PSAjaxHandlerImpl.class);
    protected PSACHandler psAjaxControlHandler = null;
    private Object objItem = null;
    private Properties handlerParams = null;
    private String strHandlerObj = "";
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private String strHandlerTag = "";
    private String strHandlerTag2 = "";
    private Map<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = new LinkedHashMap<String, IPSAjaxHandlerAction>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object item, PSACHandler psAjaxControlHandler) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psAjaxControlHandler = psAjaxControlHandler;
            this.setId(this.psAjaxControlHandler.getPSACHANDLERID());
            this.setName(this.psAjaxControlHandler.getPSACHANDLERNAME());
            this.setPSObjectData(this.psAjaxControlHandler);
            this.setItem(item);
            this.handlerParams = PropertiesHelper.load((Properties)new Properties(), (String)psAjaxControlHandler.getHANDLERPARAMS());
            this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ();
            this.strHandlerTag = this.psAjaxControlHandler.getHANDLERTAG();
            this.strHandlerTag2 = this.psAjaxControlHandler.getHANDLERTAG2();
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
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b", dump=false)
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

    @Override
    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions() {
        return this.psAjaxHandlerActionMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u884c\u4e3a\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlHandlerAction> getPSHandlerActions() {
        return this.getPSAjaxHandlerActions();
    }

    @Override
    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String strName, boolean bTryMode) throws Exception {
        IPSAjaxHandlerAction iPSAjaxHandlerAction = this.psAjaxHandlerActionMap.get(strName.toLowerCase());
        if (iPSAjaxHandlerAction == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSAjaxHandlerAction;
    }

    protected void onPreparePSAjaxHandlerActions() throws Exception {
    }

    @Override
    public IPSAppView getPSAppView() {
        return null;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        if (this.getPSAppView() != null) {
            return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0", hideempty2=true)
    public String getUserTag() {
        return this.strUserTag;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02", hideempty2=true)
    public String getUserTag2() {
        return this.strUserTag2;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb03", hideempty2=true)
    public String getUserTag3() {
        return this.strUserTag3;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb04", hideempty2=true)
    public String getUserTag4() {
        return this.strUserTag4;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u6807\u8bb0", hideempty2=true)
    public String getHandlerTag() {
        return this.strHandlerTag;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u6807\u8bb02", hideempty2=true)
    public String getHandlerTag2() {
        return this.strHandlerTag2;
    }
}

