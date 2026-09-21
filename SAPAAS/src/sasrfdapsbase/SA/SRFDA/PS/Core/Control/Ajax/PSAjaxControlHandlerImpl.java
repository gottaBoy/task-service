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
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSACHandlerAction;
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

public class PSAjaxControlHandlerImpl
extends PSObjectImpl
implements IPSAjaxControlHandler {
    private static final Log log = LogFactory.getLog(PSAjaxControlHandlerImpl.class);
    private static final HashMap<String, IPSAjaxHandlerAction> emptyPSAjaxHandlerActionMap = new HashMap();
    protected IPSAjaxControl iPSAjaxControl = null;
    protected PSACHandler psAjaxControlHandler = null;
    protected IPSAppView iPSAppView = null;
    private Map<String, Boolean> enableAjaxActionMap = null;
    protected Map<String, String> ajaxDEActionMap = new LinkedHashMap<String, String>();
    protected Map<String, String> ajaxDEActionNameMap = new LinkedHashMap<String, String>();
    protected Map<String, String> ajaxDataAccessActionMap = new LinkedHashMap<String, String>();
    protected Map<String, Integer> timeoutAjaxActionMap = new LinkedHashMap<String, Integer>();
    private Map<String, IPSAjaxHandlerAction> psAjaxHandlerActionMap = null;
    protected boolean bEnableDEFieldPrivilege = false;
    protected int nTempDataMode = 0;
    private IPSAppDEView iPSAppDEView = null;
    private Properties handlerParams = null;
    private IPSSFACHandler iPSSFACHandler = null;
    private String strHandlerObj = "";
    private boolean bEnableCache = false;
    private int nCacheTimeout = -1;
    private int nCacheScope = 0;
    private IPSSysUniState iPSSysUniState = null;
    private String strUniStateKeyValue = null;
    private String strUniStateField = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strUserTag3 = null;
    private String strUserTag4 = null;
    private String strHandlerTag = "";
    private String strHandlerTag2 = "";
    private IPSDataEntity groupPSDataEntity = null;
    private IPSAppDataEntity groupPSAppDataEntity = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppView iPSAppView, IPSAjaxControl iPSAjaxControl, PSACHandler psAjaxControlHandler) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSAppView(iPSAppView);
            this.setPSAjaxControl(iPSAjaxControl);
            this.psAjaxControlHandler = psAjaxControlHandler;
            this.setId(this.psAjaxControlHandler.getPSACHANDLERID());
            this.setName(this.psAjaxControlHandler.getPSACHANDLERNAME());
            if (this.getPSAjaxControl() != null) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getId())) {
                    this.setId(this.getPSAjaxControl().getId());
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
                    this.setName(this.getPSAjaxControl().getName());
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
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getPSSFACHANDLERID())) {
                IPSSF iPSSF = this.getPSModelStorage().getPSSF(iPSAppView.getPSApplication().getPSSystem().getPSSFId());
                this.iPSSFACHandler = iPSSF.getPSSFACHandler(this.psAjaxControlHandler.getPSSFACHANDLERID());
            }
            this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ();
            if (iPSAppView.isEnableWF() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getHANDLEROBJ2()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.psAjaxControlHandler.getHANDLEROBJ2(), (String)"#", (boolean)true) != 0) {
                this.strHandlerObj = this.psAjaxControlHandler.getHANDLEROBJ2();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strHandlerObj, (String)"#", (boolean)true) == 0) {
                this.strHandlerObj = "";
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strHandlerObj) && this.iPSSFACHandler != null) {
                this.strHandlerObj = iPSAppView.isEnableWF() ? this.iPSSFACHandler.getHandlerObj2() : this.iPSSFACHandler.getHandlerObj();
            }
            this.strHandlerTag = this.psAjaxControlHandler.getHANDLERTAG();
            this.strHandlerTag2 = this.psAjaxControlHandler.getHANDLERTAG2();
            if (!this.psAjaxControlHandler.isENABLECACHENull()) {
                this.bEnableCache = this.psAjaxControlHandler.getENABLECACHE();
            }
            if (!this.psAjaxControlHandler.isCACHESCOPENull()) {
                this.nCacheScope = this.psAjaxControlHandler.getCACHESCOPE();
            }
            if (!this.psAjaxControlHandler.isCACHETIMEOUTNull()) {
                this.nCacheTimeout = this.psAjaxControlHandler.getCACHETIMEOUT();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getPSSYSUNISTATEID())) {
                this.iPSSysUniState = this.getPSAppView().getPSSystem().getPSSysUniState(this.psAjaxControlHandler.getPSSYSUNISTATEID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUNISTATEKEYVALUE())) {
                this.strUniStateKeyValue = this.psAjaxControlHandler.getUNISTATEKEYVALUE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUNISTATEFIELD())) {
                this.strUniStateField = this.psAjaxControlHandler.getUNISTATEFIELD();
            }
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
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getGROUPPSDEID())) {
                this.groupPSDataEntity = iPSAppView.getPSApplication().getPSSystem().getPSDataEntity2(this.psAjaxControlHandler.getGROUPPSDEID());
                this.groupPSAppDataEntity = iPSAppView.getPSApplication().getPSAppDataEntity(this.groupPSDataEntity, false);
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

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    protected void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    @Override
    public IPSAjaxControl getPSAjaxControl() {
        return this.iPSAjaxControl;
    }

    protected void setPSAjaxControl(IPSAjaxControl iPSAjaxControl) {
        this.iPSAjaxControl = iPSAjaxControl;
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b", dump=false)
    public String getHandlerObj() {
        return this.strHandlerObj;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSDataEntity();
        }
        if (this.getPSAjaxControl() != null) {
            return this.getPSAjaxControl().getPSDataEntity();
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

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getGroupPSDataEntity() {
        return this.groupPSDataEntity;
    }

    public IPSDataEntity getGroupPSDataEntityMust() throws Exception {
        IPSDataEntity iPSDataEntity = this.getGroupPSDataEntity();
        if (iPSDataEntity == null) {
            throw new Exception("\u5f53\u524d\u5206\u7ec4\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
        }
        return iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5c5e\u6027\u7ea7\u6743\u9650")
    public boolean isEnableDEFieldPrivilege() {
        return this.bEnableDEFieldPrivilege;
    }

    public void setEnableDEFieldPrivilege(boolean bEnableDEFieldPrivilege) {
        this.bEnableDEFieldPrivilege = bEnableDEFieldPrivilege;
    }

    @Override
    public boolean isEnableAjaxAction(String strAjaxActionName) {
        if (this.enableAjaxActionMap != null && this.enableAjaxActionMap.containsKey(strAjaxActionName)) {
            return this.enableAjaxActionMap.get(strAjaxActionName);
        }
        return true;
    }

    @Override
    public String getDEActionName(String strAjaxActionName) {
        return this.ajaxDEActionNameMap.get(strAjaxActionName);
    }

    @Override
    public String getDataAccessAction(String strAjaxActionName) {
        String strDataAccessAction = this.ajaxDataAccessActionMap.get(strAjaxActionName);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDataAccessAction)) {
            return "";
        }
        return strDataAccessAction;
    }

    @Override
    public Iterator<String> getAjaxActions() {
        return this.ajaxDEActionNameMap.keySet().iterator();
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
    public IPSSFACHandler getPSSFACHandler() {
        return this.iPSSFACHandler;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object item, PSACHandler psAjaxControlHandler) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f13\u5b58", ignoredumpvalues="false")
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8303\u56f4", codelist="ACCacheScope", ignoredumpvalues="0")
    public int getCacheScope() {
        return this.nCacheScope;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61")
    public IPSSysUniState getPSSysUniState() {
        return this.iPSSysUniState;
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u4e3b\u952e\u5c5e\u6027")
    public String getUniStateKeyValue() {
        return this.strUniStateKeyValue;
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u72b6\u6001\u76d1\u63a7\u5c5e\u6027")
    public String getUniStateField() {
        return this.strUniStateField;
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
        return this.getPSAjaxControl().getModelId();
    }

    public void registerPSAjaxHandlerAction(IPSAjaxHandlerAction iPSAjaxHandlerAction) {
        if (this.psAjaxHandlerActionMap == null) {
            this.psAjaxHandlerActionMap = new LinkedHashMap<String, IPSAjaxHandlerAction>();
        }
        this.psAjaxHandlerActionMap.put(iPSAjaxHandlerAction.getName().toLowerCase(), iPSAjaxHandlerAction);
    }

    protected void removePSAjaxHandlerAction(String strActionName) {
        if (this.psAjaxHandlerActionMap == null) {
            return;
        }
        this.psAjaxHandlerActionMap.remove(strActionName.toLowerCase());
    }

    @Override
    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions() {
        if (this.psAjaxHandlerActionMap != null) {
            return this.psAjaxHandlerActionMap.values().iterator();
        }
        return emptyPSAjaxHandlerActionMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u884c\u4e3a\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlHandlerAction> getPSHandlerActions() {
        return this.getPSAjaxHandlerActions();
    }

    @Override
    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String strName, boolean bTryMode) throws Exception {
        IPSAjaxHandlerAction iPSAjaxHandlerAction = null;
        if (this.psAjaxHandlerActionMap != null) {
            iPSAjaxHandlerAction = this.psAjaxHandlerActionMap.get(strName.toLowerCase());
        }
        if (iPSAjaxHandlerAction == null && !bTryMode) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u5904\u7406\u884c\u4e3a[%1$s]", (Object)strName));
        }
        return iPSAjaxHandlerAction;
    }

    @Override
    public IPSControlHandlerAction getPSControlHandlerAction(String strName, boolean bTryMode) throws Exception {
        return this.getPSAjaxHandlerAction(strName, bTryMode);
    }

    protected String getUserActionName() {
        return "user";
    }

    protected String getUser2ActionName() {
        return "user2";
    }

    protected void onPreparePSAjaxHandlerActions() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSERPSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put(this.getUserActionName(), this.psAjaxControlHandler.getUSERPSDEACTIONNAME());
            this.ajaxDataAccessActionMap.put(this.getUserActionName(), this.psAjaxControlHandler.getUSERPSDEOPPRIVINAME());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAjaxControlHandler.getUSER2PSDEACTIONNAME())) {
            this.ajaxDEActionNameMap.put(this.getUser2ActionName(), this.psAjaxControlHandler.getUSER2PSDEACTIONNAME());
            this.ajaxDataAccessActionMap.put(this.getUser2ActionName(), this.psAjaxControlHandler.getUSER2PSDEOPPRIVINAME());
        }
        for (Map.Entry<String, String> entry : this.ajaxDEActionNameMap.entrySet()) {
            String strAction = entry.getKey();
            String strDEActionName = entry.getValue();
            Integer nTimeout = this.timeoutAjaxActionMap.get(strAction);
            String strDataAccAction = this.ajaxDataAccessActionMap.get(strAction);
            Boolean bEnable = null;
            if (this.enableAjaxActionMap != null) {
                bEnable = this.enableAjaxActionMap.get(strAction);
            }
            PSACHandlerAction psACHandlerAction = new PSACHandlerAction();
            psACHandlerAction.setPSACHANDLERACTIONID(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getId(), (Object)strAction));
            psACHandlerAction.setPSACHANDLERACTIONNAME(strAction);
            psACHandlerAction.setACTIONTYPE("DEACTION");
            if (bEnable != null && !bEnable.booleanValue()) {
                psACHandlerAction.setVALIDFLAG(false);
            }
            if (nTimeout != null) {
                psACHandlerAction.setACTIONTIMEOUT(nTimeout);
            }
            psACHandlerAction.setPSDEACTIONID(strDEActionName);
            psACHandlerAction.setDATAACCACTION(strDataAccAction);
            PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
            psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), this, psACHandlerAction);
            this.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
        }
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public IPSControl getPSControl() {
        return this.getPSAjaxControl();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61")
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAjaxControl() != null) {
            return this.getPSAjaxControl().getPSAppDataEntity();
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

