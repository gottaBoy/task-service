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
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSControlHandlerImpl
extends PSObjectImpl
implements IPSControlHandler {
    private static final Log log = LogFactory.getLog(PSControlHandlerImpl.class);
    private static final HashMap<String, IPSControlHandlerAction> emptyPSAjaxHandlerActionMap = new HashMap();
    protected IPSControl iPSControl = null;
    protected PSACHandler psAjaxControlHandler = null;
    protected IPSAppView iPSAppView = null;
    protected Map<String, String> ajaxDEActionMap = new LinkedHashMap<String, String>();
    protected Map<String, String> ajaxDEActionNameMap = new LinkedHashMap<String, String>();
    private Map<String, IPSControlHandlerAction> psControlHandlerActionMap = null;
    protected boolean bEnableDEFieldPrivilege = false;
    protected int nTempDataMode = 0;
    private IPSAppDEView iPSAppDEView = null;
    private Properties handlerParams = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private String strHandlerTag = "";
    private String strHandlerTag2 = "";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppView iPSAppView, IPSControl iPSControl, PSACHandler psAjaxControlHandler) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSAppView(iPSAppView);
            this.setPSControl(iPSControl);
            this.psAjaxControlHandler = psAjaxControlHandler;
            this.setId(this.psAjaxControlHandler.getPSACHANDLERID());
            this.setName(this.psAjaxControlHandler.getPSACHANDLERNAME());
            if (this.getPSControl() != null) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getId())) {
                    this.setId(this.getPSControl().getId());
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
                    this.setName(this.getPSControl().getName());
                }
            }
            this.setPSObjectData(this.psAjaxControlHandler);
            this.handlerParams = PropertiesHelper.load((Properties)new Properties(), (String)psAjaxControlHandler.getHANDLERPARAMS());
            if (iPSAppView instanceof IPSAppDEView) {
                this.iPSAppDEView = (IPSAppDEView)iPSAppView;
                this.nTempDataMode = this.iPSAppDEView.getTempMode();
            }
            if (!psAjaxControlHandler.isTEMPMODENull()) {
                this.nTempDataMode = psAjaxControlHandler.getTEMPMODE();
            }
            this.strHandlerTag = this.psAjaxControlHandler.getHANDLERTAG();
            this.strHandlerTag2 = this.psAjaxControlHandler.getHANDLERTAG2();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG())) {
                this.strUserTag = this.psAjaxControlHandler.getUSERTAG();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG2())) {
                this.strUserTag2 = this.psAjaxControlHandler.getUSERTAG2();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG3())) {
                this.strUserTag3 = this.psAjaxControlHandler.getUSERTAG3();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSERTAG4())) {
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
    protected void onInit() throws Exception {
        if (this.handlerParams != null) {
            for (Object objKey : this.handlerParams.keySet()) {
                String strValue;
                String strKey = objKey.toString().toLowerCase();
                if (strKey.indexOf("action.") != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strValue = PropertiesHelper.getProperty((Properties)this.handlerParams, (String)objKey.toString(), (String)"")))) continue;
                this.ajaxDEActionNameMap.put(strKey.substring(7), strValue);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100, dump=false)
    public String getName() {
        return super.getName();
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    protected void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected void setPSControl(IPSControl iPSControl) {
        this.iPSControl = iPSControl;
    }

    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSDataEntity();
        }
        if (this.getPSControl() != null) {
            return this.getPSControl().getPSDataEntity();
        }
        return null;
    }

    public IPSDataEntity getPSDataEntityMust() throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSDataEntity();
        if (iPSDataEntity == null) {
            throw new Exception("\u5f53\u524d\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
        }
        return iPSDataEntity;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5c5e\u6027\u7ea7\u6743\u9650")
    public boolean isEnableDEFieldPrivilege() {
        return this.bEnableDEFieldPrivilege;
    }

    public void setEnableDEFieldPrivilege(boolean bEnableDEFieldPrivilege) {
        this.bEnableDEFieldPrivilege = bEnableDEFieldPrivilege;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", dump=false)
    public int getTempMode() {
        return this.nTempDataMode;
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
        return this.getPSControl().getModelId();
    }

    public void registerPSControlAction(IPSControlHandlerAction iPSControlHandlerAction) {
        if (this.psControlHandlerActionMap == null) {
            this.psControlHandlerActionMap = new LinkedHashMap<String, IPSControlHandlerAction>();
        }
        this.psControlHandlerActionMap.put(iPSControlHandlerAction.getName().toLowerCase(), iPSControlHandlerAction);
    }

    protected void removePSControlAction(String strActionName) {
        if (this.psControlHandlerActionMap == null) {
            return;
        }
        this.psControlHandlerActionMap.remove(strActionName.toLowerCase());
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u884c\u4e3a\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlHandlerAction> getPSHandlerActions() {
        if (this.psControlHandlerActionMap != null) {
            return this.psControlHandlerActionMap.values().iterator();
        }
        return emptyPSAjaxHandlerActionMap.values().iterator();
    }

    protected String getUserActionName() {
        return "user";
    }

    protected String getUser2ActionName() {
        return "user2";
    }

    protected void onPreparePSAjaxHandlerActions() throws Exception {
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61")
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSControl() != null) {
            return this.getPSControl().getPSAppDataEntity();
        }
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getPSAppDataEntity();
        }
        return null;
    }

    public IPSAppDataEntity getPSAppDataEntityMust() throws Exception {
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity == null) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
        }
        return iPSAppDataEntity;
    }

    @Override
    public IPSControlHandlerAction getPSControlHandlerAction(String strName, boolean bTryMode) throws Exception {
        IPSControlHandlerAction iPSControlHandlerAction = null;
        if (this.psControlHandlerActionMap != null) {
            iPSControlHandlerAction = this.psControlHandlerActionMap.get(strName.toLowerCase());
        }
        if (iPSControlHandlerAction == null && !bTryMode) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSControlHandlerAction;
    }
}

