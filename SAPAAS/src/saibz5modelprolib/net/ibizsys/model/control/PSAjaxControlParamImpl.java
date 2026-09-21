/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSControlParamImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAjaxControlParamImpl
extends PSControlParamImpl
implements IPSAjaxControlParam {
    private static final Log log = LogFactory.getLog(PSAjaxControlParamImpl.class);
    protected String strPSAjaxControlHandlerId = "";
    private Boolean bAutoLoad = true;
    private Boolean bEnableItemPrivilege = false;
    private Integer nRecvAjaxActionMode = 0;

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
    }

    public String getPSAjaxControlHandlerId() {
        return this.strPSAjaxControlHandlerId;
    }

    public void setPSAjaxControlHandlerId(String strPSAjaxControlHandlerId) {
        this.strPSAjaxControlHandlerId = strPSAjaxControlHandlerId;
    }

    public Boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(Boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }

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
                iPSSysEngineConfig = ((IPSSystemRuntime)iPSAppView.getPSSystem()).getPSSysEngineConfig();
            }
            if (iPSSysEngineConfig == null || !iPSSysEngineConfig.isViewCtrlHandlerFirst()) {
                if (StringHelper.isNullOrEmpty((String)this.getPSAjaxControlHandlerId())) {
                    this.setPSAjaxControlHandlerId(iPSAjaxControlParam.getPSAjaxControlHandlerId());
                }
            } else if (!StringHelper.isNullOrEmpty((String)iPSAjaxControlParam.getPSAjaxControlHandlerId())) {
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
        }
    }

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
}

