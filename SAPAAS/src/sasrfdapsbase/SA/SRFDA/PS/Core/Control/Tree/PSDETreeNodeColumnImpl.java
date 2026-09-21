/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeFieldColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeUAColumn;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeColumnImpl
extends PSObjectImpl
implements IPSDETreeNodeColumn,
IPSControlObject,
IPSPFCtrlPartCodeObject {
    private static final Log log = LogFactory.getLog(PSDETreeNodeColumnImpl.class);
    private IPSDETreeNode iPSDETreeNode = null;
    protected PSDETreeNodeColumn psDETreeNodeColumn = null;
    private IPSDETreeColumn iPSDETreeColumn = null;
    private IPSSysPFPlugin renderPSSysPFPlugin = null;
    private boolean bHiddenDataItem = false;
    private String strColumnStyle = null;
    private IPSSysCss cellPSSysCss = null;
    private int nNoPrivDisplayMode = 1;
    private IPSPFXCodeObject iPSPFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETreeNode iPSDETreeNode, PSDETreeNodeColumn psDETreeNodeColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDETreeNode(iPSDETreeNode);
            this.psDETreeNodeColumn = psDETreeNodeColumn;
            this.setId(this.psDETreeNodeColumn.getPSDETREENODECOLID());
            this.setName(this.psDETreeNodeColumn.getPSDETREENODECOLNAME().toLowerCase());
            this.setPSObjectData(psDETreeNodeColumn);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getPSDETREECOLID())) {
                this.iPSDETreeColumn = this.getPSDETree().getPSDETreeColumn(this.psDETreeNodeColumn.getPSDETREECOLID());
            }
            if (!this.getPSDETree().isDesignMode() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRenderPSSysPFPluginId())) {
                this.renderPSSysPFPlugin = this.getPSDETree().getPSAppView().getPSApplication() != null ? this.getPSDETree().getPSAppView().getPSApplication().getPSSysPFPlugin(this.getRenderPSSysPFPluginId(), "CONTROLITEM", this.getPSDETree().getControlType(), this.getColumnType()) : this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.getRenderPSSysPFPluginId());
                this.getPSDETree().getPSAppView().registerPSSysPFPlugin(this.renderPSSysPFPlugin);
            }
            if (this.getRenderPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getRenderPSSysPFPlugin().getId(), (String)this.getPSDETree().getPSAppView().getPSPFStyle().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSDETree().getPSAppView().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDETree().getPSAppView(), (Object)this.getPSDETree(), (Object)this);
                }
            }
            if (!psDETreeNodeColumn.isHIDDENDATAITEMNull()) {
                this.bHiddenDataItem = psDETreeNodeColumn.getHIDDENDATAITEM();
            }
            this.strColumnStyle = this.psDETreeNodeColumn.getGRIDCOLSTYLE();
            boolean bRegisterToContainer = true;
            if (this.getPSDETree().getPSAppView() != null) {
                bRegisterToContainer = this.getPSDETree().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeNodeColumn.getCELLPSSYSCSSID())) {
                this.cellPSSysCss = this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysCss(this.psDETreeNodeColumn.getCELLPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDETree().registerPSSysCss(this.cellPSSysCss);
                } else if (this.getPSDETree().getPSAppView() != null) {
                    this.getPSDETree().getPSAppView().registerPSSysCss(this.cellPSSysCss);
                }
            }
            this.nNoPrivDisplayMode = !this.psDETreeNodeColumn.isNOPRIVDMNull() ? this.psDETreeNodeColumn.getNOPRIVDM() : (this.getPSDETreeColumn() != null ? this.getPSDETreeColumn().getNoPrivDisplayMode() : this.getPSDETree().getPSAppView().getPSApplication().getPSApplicationUI().getFormItemNoPrivDisplayMode());
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getName();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6811\u5bf9\u8c61", outputdoc="false")
    public IPSDETree getPSDETree() {
        return this.getPSDETreeNode().getPSDETree();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6811\u8282\u70b9\u5bf9\u8c61", outputdoc="false")
    public IPSDETreeNode getPSDETreeNode() {
        return this.iPSDETreeNode;
    }

    protected void setPSDETreeNode(IPSDETreeNode iPSDETreeNode) {
        this.iPSDETreeNode = iPSDETreeNode;
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u5217", dumpref=true, from="IPSDETree", fields={"PSDETREECOLID"})
    public IPSDETreeColumn getPSDETreeColumn() {
        return this.iPSDETreeColumn;
    }

    @Override
    public String getDataItemName() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7c7b\u578b", codelist="DEGridColType")
    public String getColumnType() {
        if (this.getPSDETreeColumn() != null) {
            return this.getPSDETreeColumn().getColumnType();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDETreeNode.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", modelattr="getPSSysPFPlugin")
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    protected void setRenderPSSysPFPlugin(IPSSysPFPlugin renderPSSysPFPlugin) {
        this.renderPSSysPFPlugin = renderPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6570\u636e\u9879", ignoredumpvalues="false", dump=false, fields={"HIDDENDATAITEM"})
    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    @Override
    public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems() {
        return null;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    public IPSCodeList getPSCodeList() {
        return null;
    }

    public String getPSCodeListId() {
        return null;
    }

    @Override
    public boolean isEnableRowEdit() {
        return false;
    }

    @Override
    public IPSDETreeNodeEditItem getPSDETreeNodeEditItem() {
        return null;
    }

    public boolean isDesignMode() {
        return this.getPSDETree().isDesignMode();
    }

    public IPSSystem getPSSystem() {
        return this.getPSDETree().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u6837\u5f0f", fields={"GRIDCOLSTYLE"})
    public String getColumnStyle() {
        return this.strColumnStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u5143\u683c\u6837\u5f0f\u5bf9\u8c61", fields={"CELLPSSYSCSSID"})
    public IPSSysCss getCellPSSysCss() {
        return this.cellPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes", ignoredumpvalues="1", fields={"NOPRIVDM"})
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @Override
    public String getModelType(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDETREENODEEDITITEM", (boolean)true) == 0) {
            return "PSDETREENODEEDITITEM";
        }
        return super.getModelType(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDETREENODEEDITITEM", (boolean)true) == 0) {
            return IPSDETreeNodeEditItem.class;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDETREENODECOL", (boolean)true) == 0) {
            if (this instanceof IPSDETreeNodeFieldColumn) {
                return IPSDETreeNodeFieldColumn.class;
            }
            if (this instanceof IPSDETreeNodeUAColumn) {
                return IPSDETreeNodeUAColumn.class;
            }
            return IPSDETreeNodeColumn.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDETree().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDETree().getPSAppView().getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSDETree().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDETree();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u4ee3\u7801\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"COL_%1$s", (Object)this.getColumnType());
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    public String getRenderPSSysPFPluginId() {
        return this.onGetRenderPSSysPFPluginId();
    }

    protected String onGetRenderPSSysPFPluginId() {
        return this.psDETreeNodeColumn.getGCRPSSYSPFPLUGINID();
    }

    @Override
    public boolean isCustomCode() {
        return this.psDETreeNodeColumn.getCUSTOMMODE();
    }

    @Override
    public String getScriptCode() {
        if (this.isCustomCode()) {
            return this.psDETreeNodeColumn.getCUSTOMCODE();
        }
        return "";
    }

    public String getPredefinedType() {
        return null;
    }

    public String getRenderMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        if (this.getPSDETreeColumn() == null) {
            return null;
        }
        String strName = String.format("%1$s__%2$s", this.getPSDETreeNode().getName(), this.getPSDETreeColumn().getName());
        return this.getOwnedPSControl().getPSControlLogicsByItemName(strName);
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        if (this.getPSDETreeColumn() == null) {
            return null;
        }
        String strName = String.format("%1$s__%2$s", this.getPSDETreeNode().getName(), this.getPSDETreeColumn().getName());
        return this.getOwnedPSControl().getPSControlAttributesByItemName(strName);
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        if (this.getPSDETreeColumn() == null) {
            return null;
        }
        String strName = String.format("%1$s__%2$s", this.getPSDETreeNode().getName(), this.getPSDETreeColumn().getName());
        return this.getOwnedPSControl().getPSControlRendersByItemName(strName);
    }

    @Override
    public String getModelId() {
        if (this.getPSDETreeNode() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDETreeNode().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDETREENODECOL";
    }
}

