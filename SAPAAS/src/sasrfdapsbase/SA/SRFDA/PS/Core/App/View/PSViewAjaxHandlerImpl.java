/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
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

@PSModelPFIgnoreMeta
public class PSViewAjaxHandlerImpl
extends PSObjectImpl
implements IPSAjaxHandler {
    private static final Log log = LogFactory.getLog(PSViewAjaxHandlerImpl.class);
    protected PSACHandler psAjaxHandler = null;
    protected IPSAppView iPSAppView = null;
    protected boolean bEnableDEFieldPrivilege = false;
    protected int nTempDataMode = 0;
    private IPSAppDEView iPSAppDEView = null;
    private Properties handlerParams = null;
    private IPSSFACHandler iPSSFACHandler = null;
    private String strHandlerObj = "";
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private String strHandlerTag = "";
    private String strHandlerTag2 = "";
    private Map<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = new LinkedHashMap<String, IPSAjaxHandlerAction>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object item, PSACHandler psAjaxHandler) throws Exception {
        try {
            if (!(item instanceof IPSAppView)) {
                throw new Exception("\u4f20\u5165\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
            }
            IPSAppView iPSAppView = (IPSAppView)item;
            this.setDAGlobalHelper(iDAGlobalHelper);
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
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getPSSFACHANDLERID())) {
                IPSSF iPSSF = this.getPSModelStorage().getPSSF(iPSAppView.getPSApplication().getPSSystem().getPSSFId());
                this.iPSSFACHandler = iPSSF.getPSSFACHandler(this.psAjaxHandler.getPSSFACHANDLERID());
            }
            this.strHandlerObj = this.psAjaxHandler.getHANDLEROBJ();
            if (iPSAppView.isEnableWF() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getHANDLEROBJ2()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.psAjaxHandler.getHANDLEROBJ2(), (String)"#", (boolean)true) != 0) {
                this.strHandlerObj = this.psAjaxHandler.getHANDLEROBJ2();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strHandlerObj, (String)"#", (boolean)true) == 0) {
                this.strHandlerObj = "";
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strHandlerObj) && this.iPSSFACHandler != null) {
                this.strHandlerObj = iPSAppView.isEnableWF() ? this.iPSSFACHandler.getHandlerObj2() : this.iPSSFACHandler.getHandlerObj();
            }
            this.strHandlerTag = this.psAjaxHandler.getHANDLERTAG();
            this.strHandlerTag2 = this.psAjaxHandler.getHANDLERTAG2();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getUSERTAG())) {
                this.strUserTag = this.psAjaxHandler.getUSERTAG();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getUSERTAG2())) {
                this.strUserTag2 = this.psAjaxHandler.getUSERTAG2();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getUSERTAG3())) {
                this.strUserTag3 = this.psAjaxHandler.getUSERTAG3();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxHandler.getUSERTAG4())) {
                this.strUserTag4 = this.psAjaxHandler.getUSERTAG4();
            }
            this.onInit();
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    protected void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b")
    public String getHandlerObj() {
        return this.strHandlerObj;
    }

    protected Properties getHandlerParams() {
        return this.handlerParams;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSAppView.getPSSysModelInstId();
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
    public String getModelType() {
        return "PSACHANDLER";
    }

    @Override
    public String getModelId() {
        return this.getPSAppView().getModelId();
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
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSAjaxHandlerAction;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
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

