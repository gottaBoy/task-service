/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppViewLogicProxy2
extends PSObjectImpl
implements IPSAppViewLogic {
    private static final Log log = LogFactory.getLog(PSAppViewLogicProxy2.class);
    private String strLogicType = null;
    private IPSAppView iPSAppView = null;
    private IPSAppUILogic iPSAppUILogic = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSAppDEUIAction iPSAppDEUIAction = null;
    private IPSAppViewUIAction iPSAppViewUIAction = null;
    private IPSAppViewEngine iPSAppViewEngine = null;
    private String strPSSysPFPluginId = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = null;

    public PSAppViewLogicProxy2(IPSAppView iPSAppView, IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) throws Exception {
        String strPSDEId;
        this.iPSAppView = iPSAppView;
        this.iPSAppDEUILogicGroupDetail = iPSAppDEUILogicGroupDetail;
        String strDstLogicType = iPSAppDEUILogicGroupDetail.getLogicType();
        if (StringHelper.Compare((String)strDstLogicType, (String)"SYSVIEWLOGIC", (boolean)true) == 0) {
            String strPSSysViewLogicId;
            if (this.getPSAppUILogic() == null && !StringHelper.IsNullOrEmpty((String)(strPSSysViewLogicId = iPSAppDEUILogicGroupDetail.getPSSysViewLogicId()))) {
                this.iPSAppUILogic = this.getPSAppView().getPSApplication().getPSAppUILogic(strPSSysViewLogicId);
            }
            if (this.getPSAppUILogic() == null) {
                throw new Exception(StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u6ca1\u6709\u6307\u5b9a\u9884\u7f6e\u754c\u9762\u903b\u8f91", (Object)this.getName()));
            }
            this.strLogicType = "SYSUILOGIC";
        } else if (StringHelper.Compare((String)strDstLogicType, (String)"DELOGIC", (boolean)true) == 0 || StringHelper.Compare((String)strDstLogicType, (String)"DEUILOGIC", (boolean)true) == 0) {
            String strPSDELogicId = iPSAppDEUILogicGroupDetail.getPSDEUILogicId();
            if (StringHelper.IsNullOrEmpty((String)strPSDELogicId)) {
                throw new Exception("\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u65e0\u6548");
            }
            strPSDEId = null;
            PSDELogic psDELogic = this.getPSAppView().getPSSystem().getPSDELogicData(strPSDELogicId, true);
            if (psDELogic != null) {
                strPSDEId = psDELogic.getPSDEID();
            }
            IPSDataEntity iPSDataEntity = null;
            iPSDataEntity = !StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity2(strPSDEId) : this.iPSAppDEUILogicGroupDetail.getPSDataEntity();
            if (iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
            this.iPSAppDEUILogic = this.iPSAppDataEntity.getPSAppDEUILogic(strPSDELogicId);
            this.strLogicType = "DEUILOGIC";
        } else if (StringHelper.Compare((String)strDstLogicType, (String)"DEUIACTION", (boolean)true) == 0) {
            String strPSDEUIActionId = iPSAppDEUILogicGroupDetail.getPSDEUIActionId();
            if (StringHelper.IsNullOrEmpty((String)strPSDEUIActionId)) {
                throw new Exception("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u65e0\u6548");
            }
            strPSDEId = null;
            PSDEUIAction psDEUIAction = this.getPSAppView().getPSSystem().getPSDEUIActionData(strPSDEUIActionId, true);
            if (psDEUIAction != null) {
                strPSDEId = psDEUIAction.getPSDEID();
            }
            IPSDataEntity iPSDataEntity = null;
            iPSDataEntity = !StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity2(strPSDEId) : iPSAppDEUILogicGroupDetail.getPSDataEntity();
            if (iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
            this.iPSAppDEUIAction = this.iPSAppDataEntity.getPSAppDEUIAction(strPSDEUIActionId);
            IPSControl iPSControl = null;
            if (!StringHelper.IsNullOrEmpty((String)this.getPSViewCtrlName()) && this.getPSAppView().hasPSControl(this.getPSViewCtrlName())) {
                iPSControl = this.getPSAppView().getPSControl(this.getPSViewCtrlName());
            }
            if (this.getPSAppView().isPrepareTemplV2logic()) {
                PSAppViewUIActionProxy psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getPSAppView(), this.iPSAppDEUIAction, iPSControl);
                this.getPSAppView().registerPSAppViewUIAction(psAppViewUIActionProxy);
                this.iPSAppViewUIAction = psAppViewUIActionProxy;
            } else {
                this.getPSAppView().registerPSUIAction(this.iPSAppDEUIAction);
            }
            this.strLogicType = "APPVIEWUIACTION";
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableUIModelEx()) {
                this.strLogicType = "APPDEUIACTION";
                this.setPSAppViewUIAction(null);
            } else {
                this.iPSAppDEUIAction = null;
            }
        } else if (StringHelper.Compare((String)strDstLogicType, (String)"SCRIPT", (boolean)true) == 0) {
            this.strLogicType = "SCRIPT";
        } else if (StringHelper.Compare((String)strDstLogicType, (String)"PFPLUGIN", (boolean)true) == 0) {
            this.strPSSysPFPluginId = this.iPSAppDEUILogicGroupDetail.getPSSysPFPluginId();
            if (StringHelper.IsNullOrEmpty((String)this.strPSSysPFPluginId)) {
                throw new Exception("\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u65e0\u6548");
            }
            this.strLogicType = "PFPLUGIN";
            this.iPSSysPFPlugin = this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.strPSSysPFPluginId, "APPVIEWLOGIC", null, null);
        }
        if (!(StringHelper.Compare((String)this.getLogicTrigger(), (String)"VIEWEVENT", (boolean)true) != 0 && StringHelper.Compare((String)this.getLogicTrigger(), (String)"CTRLEVENT", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)this.getPSViewCtrlName()))) {
            if (!this.getPSControlContainer().hasPSControl(this.getPSViewCtrlName())) {
                throw new Exception(StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6[%2$s]", (Object)this.getName(), (Object)this.getPSViewCtrlName()));
            }
            if (!this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableUIModelEx()) {
                IPSControl iPSControl = this.getPSControlContainer().getPSControl(this.getPSViewCtrlName());
                PSControlLogicImpl iPSControlLogic = new PSControlLogicImpl(this){

                    @Override
                    public String getLogicTag() {
                        return PSAppViewLogicProxy2.this.getPSViewCtrlName();
                    }

                    @Override
                    public String getEventNames() {
                        return ((IPSAppViewLogic)this.getOwner()).getEventNames();
                    }

                    @Override
                    public String getEventArg() {
                        return ((IPSAppViewLogic)this.getOwner()).getEventArg();
                    }

                    @Override
                    public String getEventArg2() {
                        return ((IPSAppViewLogic)this.getOwner()).getEventArg2();
                    }

                    @Override
                    public IPSAppViewLogic getPSAppViewLogic() {
                        return (IPSAppViewLogic)this.getOwner();
                    }
                };
                iPSControl.registerPSControlLogic(iPSControlLogic);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="ViewLogicTrigger")
    public String getLogicTrigger() {
        return this.iPSAppDEUILogicGroupDetail.getTriggerType();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0")
    public String getEventNames() {
        return this.iPSAppDEUILogicGroupDetail.getEventNames();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570")
    public String getEventArg() {
        return this.iPSAppDEUILogicGroupDetail.getEventArg();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702")
    public String getEventArg2() {
        return this.iPSAppDEUILogicGroupDetail.getEventArg2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSAppDEUILogicGroupDetail.getName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", codelist="ControlLogicType")
    public String getLogicType() {
        return this.strLogicType;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.iPSAppDEUILogicGroupDetail.getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        if (StringHelper.Compare((String)this.getLogicTrigger(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.iPSAppDEUILogicGroupDetail.getTimer();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSAppView.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.Format((String)"PSAPPVIEWLOGIC$%1$s", (Object)this.iPSAppView.getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppView.getModelId(), (Object)this.getName());
    }

    @Override
    @Deprecated
    public IPSViewLogic getPSViewLogic() {
        return this.getPSAppUILogic();
    }

    @Override
    public String getPSViewCtrlName() {
        return this.iPSAppDEUILogicGroupDetail.getCtrlName();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0")
    public String getLogicParam() {
        return this.iPSAppDEUILogicGroupDetail.getLogicTag();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb02")
    public String getLogicParam2() {
        return this.iPSAppDEUILogicGroupDetail.getLogicTag2();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSDataEntity();
        }
        return null;
    }

    @Override
    public boolean isBuiltinLogic() {
        return false;
    }

    @Override
    public Object getOwner() {
        return this.getPSAppView();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty2=true, dumpref=true, from="IPSApplication")
    public IPSAppUILogic getPSAppUILogic() {
        return this.iPSAppUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u89c6\u56fe\u903b\u8f91", hideempty2=true, dumpref=true)
    public IPSAppViewLogic getPSAppViewLogic() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u5f15\u64ce", hideempty=true, dumpref=true)
    public IPSAppViewEngine getPSAppViewEngine() {
        return this.iPSAppViewEngine;
    }

    protected void setPSAppViewEngine(IPSAppViewEngine iPSAppViewEngine) {
        this.iPSAppViewEngine = iPSAppViewEngine;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u884c\u4e3a", hideempty=true, modelcls="SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction", modeltype="PSAPPVIEWUIACTION", dumpref=true)
    public IPSAppViewUIAction getPSAppViewUIAction() {
        return this.iPSAppViewUIAction;
    }

    protected void setPSAppViewUIAction(IPSAppViewUIAction iPSAppViewUIAction) {
        this.iPSAppViewUIAction = iPSAppViewUIAction;
    }

    protected void setPSAppUILogic(IPSAppUILogic iPSAppUILogic) {
        this.iPSAppUILogic = iPSAppUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDELOGICID"})
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDEUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", hideempty=true, child=true, fields={"PSDEUIACTIONID"})
    public IPSAppDEUIAction getPSAppDEUIAction() {
        return this.iPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0")
    public String getAttrName() {
        return this.iPSAppDEUILogicGroupDetail.getAttrName();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0")
    public String getItemName() {
        return this.iPSAppDEUILogicGroupDetail.getItemName();
    }

    @Override
    public String getPSSysViewPanelId() {
        return this.iPSAppDEUILogicGroupDetail.getPSSysViewPanelId();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u524d\u7aef\u63d2\u4ef6", hideempty=true, fields={"PSSYSPFPLUGINID"})
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.isBuiltinLogic() && this.getPSAppUILogic() != null) {
            objectNode.remove("getPSAppUILogic");
            objectNode.put("getPSAppUILogic", (JsonNode)this.getPSAppUILogic().getModel());
        }
    }
}

