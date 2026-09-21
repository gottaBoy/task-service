/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.IAjaxControlHandlerParam
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlContainerRuntime;
import SA.SRFDA.PS.Core.Control.IPSControlHandler;
import SA.SRFDA.PS.Core.Control.PSControlContainerImpl;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemSetting;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.control.IAjaxControlHandlerParam;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAjaxControlContainerImpl
extends PSControlContainerImpl
implements IPSControlContainer,
IPSControlContainerRuntime,
IPSAjaxControl {
    private static final Log log = LogFactory.getLog(PSAjaxControlContainerImpl.class);
    protected IPSAjaxControlHandler iPSAjaxControlHandler = null;
    private boolean bCheckControlHandler = false;
    private boolean bEnableItemPrivilege = false;
    private boolean bShowBusyIndicator = true;
    private int nRecvAjaxActionMode = 0;
    private boolean bLocalMode = false;
    private static Map<String, String> defaultACHandlerMap = new HashMap<String, String>();

    static {
        defaultACHandlerMap.put("CALENDAR", "CALENDARHANDLER");
        defaultACHandlerMap.put("CHART", "CHARTHANDLER");
        defaultACHandlerMap.put("CUSTOM", "CUSTOMHANDLER");
        defaultACHandlerMap.put("DATAVIEW", "DATAVIEWHANDLER");
        defaultACHandlerMap.put("FORM", "FORMHANDLER");
        defaultACHandlerMap.put("GRID", "GRIDHANDLER");
        defaultACHandlerMap.put("LIST", "LISTHANDLER");
        defaultACHandlerMap.put("MOBMDCTRL", "LISTHANDLER");
        defaultACHandlerMap.put("SEARCHFORM", "SEARCHFORMHANDLER");
        defaultACHandlerMap.put("TREEEXPBAR", "TREEEXPBARHANDLER");
        defaultACHandlerMap.put("TREEGRID", "TREEGRIDHANDLER");
        defaultACHandlerMap.put("TREEVIEW", "TREEHANDLER");
        defaultACHandlerMap.put("WFEXPBAR", "WFEXPBARHANDLER");
        defaultACHandlerMap.put("MAP", "MAPHANDLER");
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        IPSSysEngineConfig iPSSysEngineConfig = PSSystemSetting.getPSSysEngineConfig(this.getPSAppView().getPSSystem());
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
        if (!StringHelper.IsNullOrEmpty((String)this.getPSAjaxControlHandlerId())) {
            this.iPSAjaxControlHandler = this.createPSAjaxControlHandler(this.getPSAjaxControlHandlerId());
        } else if (this.isPrepareDefaultPSAjaxControlHandler()) {
            this.iPSAjaxControlHandler = this.createDefaultPSAjaxControlHandler();
        }
        if (iPSAjaxControlParam.isShowBusyIndicator() != null) {
            this.bShowBusyIndicator = iPSAjaxControlParam.isShowBusyIndicator();
        }
        if (iPSAjaxControlParam.isLocalMode() != null) {
            this.bLocalMode = iPSAjaxControlParam.isLocalMode();
        }
    }

    protected String getPSAjaxControlHandlerId() {
        return this.getPSAjaxControlParam().getPSAjaxControlHandlerId();
    }

    protected IPSAjaxControlHandler createPSAjaxControlHandler(String strPSAjaxControlHandlerId) throws Exception {
        IPSAjaxControlHandler iPSAjaxControlHandler;
        PSACHandler psACHandler = null;
        psACHandler = this.getPSDataEntity() == null ? this.getPSSystem().getPSAjaxControlHandlerData(strPSAjaxControlHandlerId, false) : this.getPSDataEntity().getPSAjaxControlHandlerData(strPSAjaxControlHandlerId);
        if (this.isNeedFillPSACHandlerData()) {
            PSACHandler psACHandler2 = new PSACHandler();
            psACHandler.CopyTo(psACHandler2, false);
            this.fillPSACHandlerData(psACHandler2);
            psACHandler = psACHandler2;
        }
        if ((iPSAjaxControlHandler = this.getPSModelStorage().getPSControlType(this.getControlType()).createPSAjaxControlHandler(psACHandler)) == null) {
            throw new Exception("\u65e0\u6cd5\u5efa\u7acb\u6307\u5b9a\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61");
        }
        iPSAjaxControlHandler.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psACHandler);
        return iPSAjaxControlHandler;
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
        if (this.isCheckControlHandler() && this.getPSAjaxControlHandler() == null) {
            throw new Exception(StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u5904\u7406\u5bf9\u8c61", (Object)this.getPSAppView().getName(), (Object)this.getName()));
        }
    }

    @PSModelRTMeta(description="\u754c\u9762\u5904\u7406\u5bf9\u8c61\u57fa\u7c7b", dump=false)
    public String getHandler() {
        if (this.iPSAjaxControlHandler != null) {
            return this.iPSAjaxControlHandler.getHandlerObj();
        }
        return null;
    }

    @PSModelRTMeta(description="\u754c\u9762\u5904\u7406\u5bf9\u8c61\u53c2\u6570")
    public IAjaxControlHandlerParam getHandlerParam() {
        return this.getPSAjaxControlParam();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxControlHandler getPSAjaxControlHandler() {
        return this.iPSAjaxControlHandler;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", dump=false)
    public boolean isTempMode() {
        if (this.iPSAjaxControlHandler == null) {
            return false;
        }
        return this.iPSAjaxControlHandler.getTempMode() != 0;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d", ignoredumpvalues="true")
    public boolean isAutoLoad() {
        return this.getPSAjaxControlParam().isAutoLoad();
    }

    protected boolean isCheckControlHandler() {
        return this.bCheckControlHandler;
    }

    protected void setCheckControlHandler(boolean bCheckControlHandler) {
        this.bCheckControlHandler = bCheckControlHandler;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650", ignoredumpvalues="false")
    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53d7\u8bf7\u6c42\u6a21\u5f0f", codelist="ViewCtrlAjaxProcessMode", dump=false)
    public int getRecvAjaxActionMode() {
        return this.nRecvAjaxActionMode;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u8bf7\u6c42\u90e8\u4ef6", dump=false)
    public boolean isAjaxCtrl() {
        return true;
    }

    protected boolean isPrepareDefaultPSAjaxControlHandler() {
        return this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    protected IPSAjaxControlHandler createDefaultPSAjaxControlHandler() throws Exception {
        try {
            String strPSSysHandlerId = defaultACHandlerMap.get(this.getControlType());
            if (!StringHelper.IsNullOrEmpty((String)strPSSysHandlerId)) {
                String strPSSFACHandlerId = KeyValueHelper.genUniqueId((String)strPSSysHandlerId, (String)this.getPSSystem().getPSSFId());
                String strPSACHandlerId = KeyValueHelper.genUniqueId((String)this.getPSSystem().getId(), (String)strPSSFACHandlerId);
                PSACHandler psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strPSACHandlerId, true);
                if (psACHandler != null) {
                    IPSAjaxControlHandler iPSAjaxControlHandler;
                    if (this.isNeedFillPSACHandlerData()) {
                        PSACHandler psACHandler2 = new PSACHandler();
                        psACHandler.CopyTo(psACHandler2, false);
                        this.fillPSACHandlerData(psACHandler2);
                        psACHandler = psACHandler2;
                    }
                    if ((iPSAjaxControlHandler = this.getPSModelStorage().getPSControlType(this.getControlType()).createPSAjaxControlHandler(psACHandler)) != null) {
                        iPSAjaxControlHandler.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psACHandler);
                        return iPSAjaxControlHandler;
                    }
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        PSAjaxControlHandlerImpl psAjaxControlHandlerImpl = new PSAjaxControlHandlerImpl();
        PSACHandler psAjaxControlHandler = this.getDefaultPSACHandler();
        psAjaxControlHandlerImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psAjaxControlHandler);
        return psAjaxControlHandlerImpl;
    }

    protected PSACHandler getDefaultPSACHandler() throws Exception {
        PSACHandler psACHandler = new PSACHandler();
        if (this.isNeedFillPSACHandlerData()) {
            this.fillPSACHandlerData(psACHandler);
        }
        return psACHandler;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="true")
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }

    @Override
    @PSModelRTMeta(description="\u672c\u5730\u5904\u7406\u6a21\u5f0f", dump=false)
    public boolean isLocalMode() {
        return this.bLocalMode;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u884c\u4e3a\u96c6\u5408", hideempty=true, group="\u90e8\u4ef6\u903b\u8f91", order=218)
    public Iterator<? extends IPSControlAction> getPSControlActions() {
        if (this.getPSAjaxControlHandler() != null) {
            return this.getPSAjaxControlHandler().getPSAjaxHandlerActions();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u884c\u4e3a", hideempty=true, outputdoc="false")
    public IPSControlAction getUserPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("user", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u884c\u4e3a2", hideempty=true, outputdoc="false")
    public IPSControlAction getUser2PSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("user2", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }

    @Override
    protected IPSControlHandler onGetPSControlHandler() {
        return this.getPSAjaxControlHandler();
    }
}

