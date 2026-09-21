/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.ajax.IPSAjaxControlHandler
 *  net.ibizsys.paas.control.IAjaxControlHandlerParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.PSControlImpl;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandlerRuntime;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.paas.control.IAjaxControlHandlerParam;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSAjaxControlImpl
extends PSControlImpl
implements IPSAjaxControl {
    protected IPSAjaxControlHandler iPSAjaxControlHandler = null;
    private boolean bCheckControlHandler = false;
    private boolean bEnableItemPrivilege = false;
    private int nRecvAjaxActionMode = 0;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        IPSSysEngineConfig iPSSysEngineConfig = this.getPSSystemRuntime().getPSSysEngineConfig();
        IPSAjaxControlParam iPSAjaxControlParam = this.getPSAjaxControlParam();
        if (iPSAjaxControlParam.isEnableItemPrivilege() != null) {
            this.bEnableItemPrivilege = iPSAjaxControlParam.isEnableItemPrivilege();
        }
        int nViewCtrlAjaxMode = 0;
        if (iPSSysEngineConfig != null) {
            nViewCtrlAjaxMode = iPSSysEngineConfig.getViewCtrlAjaxRecvRange();
        }
        if (nViewCtrlAjaxMode == 1 && iPSAjaxControlParam.getRecvAjaxActionMode() != null) {
            this.nRecvAjaxActionMode = iPSAjaxControlParam.getRecvAjaxActionMode();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSAjaxControlHandlerId())) {
            this.iPSAjaxControlHandler = this.createPSAjaxControlHandler(this.getPSAjaxControlHandlerId());
        }
    }

    protected String getPSAjaxControlHandlerId() {
        return this.getPSAjaxControlParam().getPSAjaxControlHandlerId();
    }

    protected IPSAjaxControlHandler createPSAjaxControlHandler(String strPSAjaxControlHandlerId) throws Exception {
        PSACHandler psACHandler = null;
        psACHandler = this.getPSDataEntity() == null ? this.getPSSystemRuntime().getPSAjaxControlHandlerData(strPSAjaxControlHandlerId, false) : this.getPSDataEntityRuntime().getPSAjaxControlHandlerData(strPSAjaxControlHandlerId);
        IPSAjaxControlHandler iPSAjaxControlHandler = ((IPSControlTypeRuntime)this.getPSModelStorageContext().getPSControlType(this.getControlType())).createPSAjaxControlHandler(psACHandler);
        ((IPSAjaxControlHandlerRuntime)iPSAjaxControlHandler).init(this.getPSModelStorageContext(), this.getPSAppView(), this, psACHandler);
        return iPSAjaxControlHandler;
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
        if (this.isCheckControlHandler() && this.getPSAjaxControlHandler() == null) {
            throw new Exception(StringHelper.format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u6ca1\u6709\u6307\u5b9a\u540e\u53f0\u5904\u7406\u5bf9\u8c61", (Object)this.getPSAppView().getName(), (Object)this.getName()));
        }
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b")
    public String getHandler() {
        if (this.iPSAjaxControlHandler != null) {
            return this.iPSAjaxControlHandler.getHandlerObj();
        }
        return null;
    }

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5bf9\u8c61\u53c2\u6570")
    public IAjaxControlHandlerParam getHandlerParam() {
        return this.getPSAjaxControlParam();
    }

    public abstract IPSAjaxControlParam getPSAjaxControlParam();

    @PSModelRTMeta(description="\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxControlHandler getPSAjaxControlHandler() {
        return this.iPSAjaxControlHandler;
    }

    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f")
    public boolean isTempMode() {
        if (this.iPSAjaxControlHandler == null) {
            return false;
        }
        return this.iPSAjaxControlHandler.getTempMode() != 0;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d")
    public boolean isAutoLoad() {
        return this.getPSAjaxControlParam().isAutoLoad();
    }

    protected boolean isCheckControlHandler() {
        return this.bCheckControlHandler;
    }

    protected void setCheckControlHandler(boolean bCheckControlHandler) {
        this.bCheckControlHandler = bCheckControlHandler;
    }

    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650")
    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    @PSModelRTMeta(description="\u63a5\u53d7\u8bf7\u6c42\u6a21\u5f0f", codelist="ViewCtrlAjaxProcessMode")
    public int getRecvAjaxActionMode() {
        return this.nRecvAjaxActionMode;
    }

    @PSModelRTMeta(description="\u5f02\u6b65\u8bf7\u6c42\u90e8\u4ef6")
    public boolean isAjaxCtrl() {
        return true;
    }
}

