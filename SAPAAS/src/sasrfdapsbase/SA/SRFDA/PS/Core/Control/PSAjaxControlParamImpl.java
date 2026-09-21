/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSAjaxControlParamImpl
extends PSControlParamImpl
implements IPSAjaxControlParam {
    private static final Log log = LogFactory.getLog(PSAjaxControlParamImpl.class);
    protected String strPSAjaxControlHandlerId = "";
    private Boolean bAutoLoad = true;
    private Boolean bEnableItemPrivilege = false;
    private Integer nRecvAjaxActionMode = 0;
    private Boolean bShowBusyIndicator = true;
    private Boolean bLocalMode = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSAjaxControlHandlerId(this.getPSDEViewCtrlData().getPSACHANDLERID());
        if (!this.psDEViewCtrl.isENABLEITEMPRIVNull()) {
            this.setEnableItemPrivilege(this.psDEViewCtrl.getENABLEITEMPRIV());
        }
        if (!this.psDEViewCtrl.isENABLEVIEWACTIONSNull() && this.psDEViewCtrl.getENABLEVIEWACTIONS()) {
            this.setRecvAjaxActionMode(1);
        }
        if (!this.psDEViewCtrl.isBUSYINDICATORNull()) {
            this.setShowBusyIndicator(this.psDEViewCtrl.getBUSYINDICATOR());
        }
        if (!this.psDEViewCtrl.isLOCALMODENull()) {
            this.bLocalMode = this.psDEViewCtrl.getLOCALMODE();
        }
    }

    @Override
    public String getPSAjaxControlHandlerId() {
        return this.strPSAjaxControlHandlerId;
    }

    public void setPSAjaxControlHandlerId(String strPSAjaxControlHandlerId) {
        this.strPSAjaxControlHandlerId = strPSAjaxControlHandlerId;
    }

    @Override
    public Boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(Boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }

    @Override
    public Integer getRecvAjaxActionMode() {
        return this.nRecvAjaxActionMode;
    }

    public void setRecvAjaxActionMode(Integer nRecvAjaxActionMode) {
        this.nRecvAjaxActionMode = nRecvAjaxActionMode;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSAjaxControlParam) {
            IPSAjaxControlParam iPSAjaxControlParam = (IPSAjaxControlParam)iPSControlParam;
            IPSAppView iPSAppView = iPSControlParam.getPSAppView();
            if (iPSAppView != null) {
                iPSAppView = this.getPSAppView();
            }
            IPSSysEngineConfig iPSSysEngineConfig = null;
            if (iPSAppView != null) {
                iPSSysEngineConfig = ((IPSSystemSetting)((Object)iPSAppView.getPSSystem())).getPSSysEngineConfig();
            }
            if (iPSSysEngineConfig == null || !iPSSysEngineConfig.isViewCtrlHandlerFirst()) {
                if (StringHelper.IsNullOrEmpty((String)this.getPSAjaxControlHandlerId())) {
                    this.setPSAjaxControlHandlerId(iPSAjaxControlParam.getPSAjaxControlHandlerId());
                }
            } else if (!StringHelper.IsNullOrEmpty((String)iPSAjaxControlParam.getPSAjaxControlHandlerId())) {
                this.setPSAjaxControlHandlerId(iPSAjaxControlParam.getPSAjaxControlHandlerId());
            }
            if (iPSAjaxControlParam.isEnableItemPrivilege() != null) {
                this.setEnableItemPrivilege(iPSAjaxControlParam.isEnableItemPrivilege());
            }
            if (iPSAjaxControlParam.getRecvAjaxActionMode() != null) {
                this.setRecvAjaxActionMode(iPSAjaxControlParam.getRecvAjaxActionMode());
            }
            if (!iPSAjaxControlParam.isAutoLoad()) {
                this.setAutoLoad(iPSAjaxControlParam.isAutoLoad());
            }
            if (iPSAjaxControlParam.isShowBusyIndicator() != null) {
                this.setShowBusyIndicator(iPSAjaxControlParam.isShowBusyIndicator());
            }
            if (iPSAjaxControlParam.isLocalMode() != null) {
                this.setLocalMode(iPSAjaxControlParam.isLocalMode());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d")
    public boolean isAutoLoad() {
        return this.bAutoLoad;
    }

    public void setAutoLoad(boolean bAutoLoad) {
        this.bAutoLoad = bAutoLoad;
    }

    public IPSDataEntity getPSDataEntity() {
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a")
    public Boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }

    public void setShowBusyIndicator(Boolean bShowBusyIndicator) {
        this.bShowBusyIndicator = bShowBusyIndicator;
    }

    @Override
    public Boolean isLocalMode() {
        return this.bLocalMode;
    }

    public void setLocalMode(Boolean bLocalMode) {
        this.bLocalMode = bLocalMode;
    }
}

