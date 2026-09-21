/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;

public class PSAppViewLogicImplBase
extends PSObjectImpl
implements IPSAppViewLogic,
IPSPFLogicCodeObject {
    public static final String LOGICTRIGGER_CUSTOM = "CUSTOM";
    protected PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
    private IPSAppView iPSAppView = null;
    private IPSAppUILogic iPSAppUILogic = null;
    private String strPSSysViewLogicId = null;
    private IPSAppViewLogic iPSAppViewLogic = null;
    private IPSAppViewEngine iPSAppViewEngine = null;
    private IPSAppViewUIAction iPSAppViewUIAction = null;
    private String strLogicType = null;
    private boolean bBuiltinLogic = true;
    private Object objOwner = null;
    private IPSControlContainer iPSControlContainer = null;
    private IPSControlLogic iPSControlLogic = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    private IPSAppDEUIAction iPSAppDEUIAction = null;
    private String strScriptCode = "";
    private String strPSSysPFPluginId = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    @Override
    protected void onInit() throws Exception {
        String strDstLogicType = this.psAppViewLogic.getParamStringValue("DSTLOGICTYPE", null);
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"SYSVIEWLOGIC", (boolean)true) == 0) {
            if (this.getPSAppUILogic() == null) {
                this.strPSSysViewLogicId = this.psAppViewLogic.getParamStringValue("PSSYSVIEWLOGICID", null);
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSSysViewLogicId)) {
                    this.iPSAppUILogic = this.getPSAppView().getPSApplication().getPSAppUILogic(this.strPSSysViewLogicId);
                }
            }
            if (this.getPSAppUILogic() == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u6ca1\u6709\u6307\u5b9a\u9884\u7f6e\u754c\u9762\u903b\u8f91", (Object)this.getName()));
            }
            this.strLogicType = "SYSUILOGIC";
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableUIModelEx()) {
                this.strLogicType = "APPUILOGIC";
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"DELOGIC", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"DEUILOGIC", (boolean)true) == 0) {
            String strPSDELogicId = this.psAppViewLogic.getParamStringValue("PSDELOGICID", null);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDELogicId)) {
                throw new Exception("\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u65e0\u6548");
            }
            String strPSDEId = this.psAppViewLogic.getParamStringValue("PSDEID", null);
            PSDELogic psDELogic = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDELogicData(strPSDELogicId, true);
            if (psDELogic != null) {
                strPSDEId = psDELogic.getPSDEID();
            }
            IPSDataEntity iPSDataEntity = null;
            iPSDataEntity = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity2(strPSDEId) : this.getPSDataEntity();
            if (iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
            this.iPSAppDEUILogic = this.iPSAppDataEntity.getPSAppDEUILogic(strPSDELogicId);
            this.strLogicType = "DEUILOGIC";
            if (this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableUIModelEx()) {
                this.strLogicType = "APPDEUILOGIC";
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"DEUIACTION", (boolean)true) == 0) {
            String strPSDEUIActionId = this.psAppViewLogic.getParamStringValue("PSDEUIACTIONID", null);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEUIActionId)) {
                throw new Exception("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u65e0\u6548");
            }
            String strPSDEId = this.psAppViewLogic.getParamStringValue("PSDEID", null);
            PSDEUIAction psDEUIAction = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDEUIActionData(strPSDEUIActionId, true);
            if (psDEUIAction != null) {
                strPSDEId = psDEUIAction.getPSDEID();
            }
            IPSDataEntity iPSDataEntity = null;
            iPSDataEntity = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEId) ? this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity2(strPSDEId) : this.getPSDataEntity();
            if (iPSDataEntity == null) {
                throw new Exception("\u5f53\u524d\u5b9e\u4f53\u65e0\u6548");
            }
            this.iPSAppDataEntity = this.getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, false);
            this.iPSAppDEUIAction = this.iPSAppDataEntity.getPSAppDEUIAction(strPSDEUIActionId);
            IPSControl iPSControl = null;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSViewCtrlName()) && this.getPSAppView().hasPSControl(this.getPSViewCtrlName())) {
                iPSControl = this.getPSAppView().getPSControl(this.getPSViewCtrlName());
            }
            if (this.getPSAppView().isPrepareTemplV2logic()) {
                PSAppViewUIActionProxy psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getPSAppView(), this.iPSAppDEUIAction, iPSControl);
                this.getPSAppView().registerPSAppViewUIAction(psAppViewUIActionProxy);
                this.setPSAppViewUIAction(psAppViewUIActionProxy);
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
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"APPVIEWLOGIC", (boolean)true) == 0) {
            String strLogicTag = this.psAppViewLogic.getREFPSAPPVIEWLOGICNAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicTag)) {
                this.iPSAppViewLogic = this.getPSControlContainer().getPSAppViewLogic(strLogicTag, true);
                if (this.iPSAppViewLogic == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u903b\u8f91[%2$s]", (Object)this.getName(), (Object)strLogicTag));
                }
            }
            this.strLogicType = "APPVIEWLOGIC";
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"APPVIEWENGINE", (boolean)true) == 0) {
            if (this.getPSAppViewEngine() == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u754c\u9762\u5f15\u64ce", (Object)this.getName()));
            }
            this.strLogicType = "APPVIEWENGINE";
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"APPVIEWUIACTION", (boolean)true) == 0) {
            if (this.getPSAppViewUIAction() == null) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u754c\u9762\u884c\u4e3a", (Object)this.getName()));
            }
            this.strLogicType = "APPVIEWUIACTION";
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"SCRIPT", (boolean)true) == 0) {
            this.strScriptCode = this.psAppViewLogic.getCUSTOMCODE();
            this.strLogicType = "SCRIPT";
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strDstLogicType, (String)"PFPLUGIN", (boolean)true) == 0) {
            this.strPSSysPFPluginId = this.psAppViewLogic.getPSSYSPFPLUGINID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSSysPFPluginId)) {
                throw new Exception("\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u65e0\u6548");
            }
            this.strLogicType = "PFPLUGIN";
            this.iPSSysPFPlugin = this.getPSAppView().getPSApplication().getPSSysPFPlugin(this.strPSSysPFPluginId, "APPVIEWLOGIC", null, null);
        }
        if (!(SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicTrigger(), (String)"VIEWEVENT", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicTrigger(), (String)"CTRLEVENT", (boolean)true) != 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSViewCtrlName()))) {
            if (!this.getPSControlContainer().hasPSControl(this.getPSViewCtrlName())) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe\u903b\u8f91[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u90e8\u4ef6[%2$s]", (Object)this.getName(), (Object)this.getPSViewCtrlName()));
            }
            if (!this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableUIModelEx()) {
                IPSControl iPSControl = this.getPSControlContainer().getPSControl(this.getPSViewCtrlName());
                this.iPSControlLogic = new PSControlLogicImpl(this){

                    @Override
                    public String getLogicTag() {
                        return PSAppViewLogicImplBase.this.getPSViewCtrlName();
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
                iPSControl.registerPSControlLogic(this.iPSControlLogic);
            }
        }
        super.onInit();
    }

    @Deprecated
    public String getPSViewLogicTypeId() {
        return null;
    }

    @Deprecated
    public IPSViewLogicType getPSViewLogicType() {
        return null;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSAppView() != null) {
            return this.getPSAppView().getPSSysModelInstId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u89e6\u53d1", codelist="ViewLogicTrigger", group="\u57fa\u672c", order=110, fields={"PSAPPVIEWLOGICTYPE"})
    public String getLogicTrigger() {
        String strLogicTrigger = this.psAppViewLogic.getPSAPPVIEWLOGICTYPE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicTrigger)) {
            return this.psAppViewLogic.getParamStringValue("PSDEVIEWLOGICTYPE", LOGICTRIGGER_CUSTOM);
        }
        return strLogicTrigger;
    }

    @Deprecated
    public IPSDEViewLogic getPSDEViewLogic() {
        return null;
    }

    @Deprecated
    public IPSSysViewLogic getPSSysViewLogic() {
        return this.getPSAppUILogic();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty2=true, dumpref=true, fields={"PSDELOGICID"})
    public IPSAppUILogic getPSAppUILogic() {
        return this.iPSAppUILogic;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u89c6\u56fe\u903b\u8f91", hideempty2=true, dumpref=true, fields={"PSSYSVIEWLOGICID"})
    public IPSAppViewLogic getPSAppViewLogic() {
        return this.iPSAppViewLogic;
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1", outputdoc="%1$s.getLogicTrigger() == 'TIMER'", fields={"TIMER"})
    public int getTimer() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicTrigger(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.psAppViewLogic.GetParamIntValue("TIMER", 0);
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u540d\u79f0", rtname="getCtrlName", hideempty2=true, group="\u57fa\u672c", order=115, fields={"PSDEVIEWCTRLNAME"})
    public String getPSViewCtrlName() {
        String strCtrlName = this.psAppViewLogic.getPSAPPVIEWCTRLNAME();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCtrlName)) {
            strCtrlName = this.psAppViewLogic.getParamStringValue("PSDEVIEWCTRLNAME", null);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCtrlName) && this.getPSAppView().isEnableUIModelEx()) {
            strCtrlName = strCtrlName.toLowerCase();
        }
        return strCtrlName;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=116, fields={"EVENTNAMES"})
    public String getEventNames() {
        return this.psAppViewLogic.getParamStringValue("EVENTNAMES", null);
    }

    @Override
    public String getLogicParam() {
        return this.psAppViewLogic.getParamStringValue("LOGICPARAM", null);
    }

    @Override
    public String getLogicParam2() {
        return this.psAppViewLogic.getParamStringValue("LOGICPARAM2", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570", hideempty2=true, group="\u57fa\u672c", order=117, fields={"EVENTARG"})
    public String getEventArg() {
        return this.psAppViewLogic.getParamStringValue("EVENTARG", null);
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702", hideempty2=true, group="\u57fa\u672c", order=118, fields={"EVENTARG2"})
    public String getEventArg2() {
        return this.psAppViewLogic.getParamStringValue("EVENTARG2", null);
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=120, fields={"ATTRNAME"})
    public String getAttrName() {
        return this.psAppViewLogic.getParamStringValue("ATTRNAME", null);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", hideempty2=true, group="\u57fa\u672c", order=121, fields={"ITEMNAME"})
    public String getItemName() {
        return this.psAppViewLogic.getParamStringValue("ITEMNAME", null);
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return null;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return "VIEWLOGIC";
    }

    @Override
    public String getModelType() {
        if (this.getOwner() instanceof IPSModelObject) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s$%2$s", (Object)"PSAPPVIEWLOGIC", (Object)((IPSModelObject)this.getOwner()).getModelType());
        }
        return "PSAPPVIEWLOGIC";
    }

    @Override
    public String getModelId() {
        if (this.getOwner() instanceof IPSModelObject) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)((IPSModelObject)this.getOwner()).getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", codelist="ControlLogicType")
    public String getLogicType() {
        return this.strLogicType;
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

    @Override
    @PSModelRTMeta(description="\u5185\u5efa\u903b\u8f91", ignoredumpvalues="true")
    public boolean isBuiltinLogic() {
        return this.bBuiltinLogic;
    }

    protected void setBuiltinLogic(boolean bBuiltinLogic) {
        this.bBuiltinLogic = bBuiltinLogic;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u5bb9\u5668", outputdoc="false")
    public Object getOwner() {
        return this.objOwner;
    }

    protected void setOwner(Object objOwner) {
        this.objOwner = objOwner;
        this.iPSAppView = null;
        this.iPSControlContainer = null;
        if (this.objOwner instanceof IPSControlContainer) {
            this.iPSControlContainer = (IPSControlContainer)this.objOwner;
            this.iPSAppView = ((IPSControlContainer)this.objOwner).getPSAppView();
        } else if (this.objOwner instanceof IPSControlObject) {
            IPSControlObject iPSControlObject = (IPSControlObject)this.objOwner;
            this.iPSControlContainer = iPSControlObject.getOwnedPSControl().getPSControlContainer();
            this.iPSAppView = iPSControlObject.getOwnedPSControl().getPSAppView();
        } else if (this.objOwner instanceof IPSControl) {
            IPSControl iPSControl = (IPSControl)this.objOwner;
            this.iPSAppView = iPSControl.getPSAppView();
            this.iPSControlContainer = iPSControl.getPSControlContainer();
        }
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getLogicType(), (String)"SYSUILOGIC", (boolean)true) == 0 && this.getPSAppUILogic() != null) {
            String strLogicStyle = this.getPSAppUILogic().getViewLogicStyle();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicStyle)) {
                return this.getPSAppUILogic().getViewLogicType();
            }
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppUILogic().getViewLogicType(), (Object)this.getPSAppUILogic().getViewLogicStyle());
        }
        return this.getLogicType();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u6240\u5728\u90e8\u4ef6\u5bb9\u5668", outputdoc="false")
    public IPSControlContainer getPSControlContainer() {
        return this.iPSControlContainer;
    }

    @Override
    @Deprecated
    public IPSViewLogic getPSViewLogic() {
        return this.getPSAppUILogic();
    }

    protected void setPSAppUILogic(IPSAppUILogic iPSAppUILogic) {
        this.iPSAppUILogic = iPSAppUILogic;
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return null;
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
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.strScriptCode;
    }

    @Override
    public String getPSSysViewPanelId() {
        return this.psAppViewLogic.getPSSYSVIEWPANELID();
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

