/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeColumnImpl
extends PSObjectImpl
implements IPSDETreeColumn,
IPSControlObject {
    private static final Log log = LogFactory.getLog(PSDETreeColumnImpl.class);
    private IPSDETree iPSDETree = null;
    protected PSDETreeColumn psDETreeColumn = null;
    private String strCaption = "";
    private IPSSysPFPlugin renderPSSysPFPlugin = null;
    private String strAlign = "";
    private boolean bEnableSort = false;
    private String strWidthString = "";
    private boolean bHideDefault = false;
    private boolean bDefineEnableSort = false;
    private IPSDETreeColumn parentPSDETreeColumn = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strColumnStyle = null;
    private boolean bEnableExpand = false;
    private IPSSysCss headerPSSysCss = null;
    private IPSSysCss cellPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private int nNoPrivDisplayMode = 1;
    private int nEnableLink = 2;
    private int nHideMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETree iPSDETree, IPSDETreeColumn parentPSDETreeColumn, PSDETreeColumn psDETreeColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDETree(iPSDETree);
            this.psDETreeColumn = psDETreeColumn;
            this.parentPSDETreeColumn = parentPSDETreeColumn;
            this.setId(this.psDETreeColumn.getPSDETREECOLID());
            this.setName(this.psDETreeColumn.getPSDETREECOLNAME().toLowerCase());
            this.setPSObjectData(psDETreeColumn);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getDataItemName(), (String)"text", (boolean)false) == 0) {
                this.bEnableExpand = true;
            }
            this.strCaption = this.psDETreeColumn.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDETree().getPSAppView().getPSApplication().getPSLanguageRes(this.psDETreeColumn.getCAPPSLANRESID());
            }
            if (!this.getPSDETree().isDesignMode() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getGCRPSSYSPFPLUGINID())) {
                this.renderPSSysPFPlugin = this.getPSDETree().getPSAppView().getPSApplication() != null ? this.getPSDETree().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psDETreeColumn.getGCRPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSDETree().getControlType(), this.getColumnType()) : this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDETreeColumn.getGCRPSSYSPFPLUGINID());
                this.getPSDETree().getPSAppView().registerPSSysPFPlugin(this.renderPSSysPFPlugin);
            }
            if (this.getRenderPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getRenderPSSysPFPlugin().getId(), (String)this.getPSDETree().getPSAppView().getPSPFStyle().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSDETree().getPSAppView().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDETree().getPSAppView(), (Object)this.getPSDETree(), (Object)this);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDETreeColumn.getALIGN())) {
                this.strAlign = psDETreeColumn.getALIGN();
            }
            if (!psDETreeColumn.isHIDEDEFAULTNull()) {
                if (this.isEnableExpand()) {
                    this.nHideMode = 3;
                } else {
                    this.bHideDefault = psDETreeColumn.getHIDEDEFAULT() == 1;
                    this.nHideMode = psDETreeColumn.getHIDEDEFAULT();
                }
            } else if (this.isEnableExpand()) {
                this.nHideMode = 3;
            }
            this.strWidthString = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDETreeColumn.getWIDTHUNIT(), (String)"PX", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getWIDTHUNIT()) ? (psDETreeColumn.getWIDTH() > 0 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$spx", (Object)psDETreeColumn.getWIDTH()) : "0px") : (psDETreeColumn.getWIDTH() > 1 ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s*", (Object)psDETreeColumn.getWIDTH()) : "*");
            boolean bRegisterToContainer = true;
            if (this.getPSDETree().getPSAppView() != null) {
                bRegisterToContainer = this.getPSDETree().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getHEADERPSSYSCSSID())) {
                this.headerPSSysCss = this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysCss(this.psDETreeColumn.getHEADERPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDETree().registerPSSysCss(this.headerPSSysCss);
                } else if (this.getPSDETree().getPSAppView() != null) {
                    this.getPSDETree().getPSAppView().registerPSSysCss(this.headerPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getCELLPSSYSCSSID())) {
                this.cellPSSysCss = this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysCss(this.psDETreeColumn.getCELLPSSYSCSSID());
                if (bRegisterToContainer) {
                    this.getPSDETree().registerPSSysCss(this.cellPSSysCss);
                } else if (this.getPSDETree().getPSAppView() != null) {
                    this.getPSDETree().getPSAppView().registerPSSysCss(this.cellPSSysCss);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDETreeColumn.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSDETree().getPSDataEntity().getPSSystem().getPSSysImage(this.psDETreeColumn.getPSSYSIMAGEID());
                if (bRegisterToContainer) {
                    this.getPSDETree().registerPSSysImage(this.iPSSysImage);
                } else if (this.getPSDETree().getPSAppView() != null) {
                    this.getPSDETree().getPSAppView().registerPSSysImage(this.iPSSysImage);
                }
            }
            this.strColumnStyle = this.psDETreeColumn.getGRIDCOLSTYLE();
            this.nNoPrivDisplayMode = !this.psDETreeColumn.isNOPRIVDMNull() ? this.psDETreeColumn.getNOPRIVDM() : this.getPSDETree().getPSAppView().getPSApplication().getPSApplicationUI().getFormItemNoPrivDisplayMode();
            if (!this.psDETreeColumn.isENABLELINKNull()) {
                this.nEnableLink = this.psDETreeColumn.getENABLELINK();
            } else if (this.getPSDETree() != null) {
                this.nEnableLink = this.getPSDETree().getColumnEnableLink();
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
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6811\u89c6\u56fe")
    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    protected void setPSDETree(IPSDETree iPSDETree) {
        this.iPSDETree = iPSDETree;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.onGetCapPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    protected IPSLanguageRes onGetCapPSLanguageRes() {
        return null;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bbd\u5355\u4f4d", codelist="DEGridColWidthUnitType", fields={"WIDTHUNIT"})
    public String getWidthUnit() {
        if (this.psDETreeColumn.isWIDTHUNITNull()) {
            return "PX";
        }
        return this.psDETreeColumn.getWIDTHUNIT();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bbd", fields={"WIDTH"})
    public int getWidth() {
        if (this.psDETreeColumn.isWIDTHNull()) {
            return this.onGetWidth();
        }
        return this.psDETreeColumn.getWIDTH();
    }

    protected int onGetWidth() {
        return 100;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7c7b\u578b", codelist="DEGridColType", fields={"GRIDCOLTYPE"})
    public String getColumnType() {
        return this.psDETreeColumn.getGRIDCOLTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDETree.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7ed8\u5236\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    protected void setRenderPSSysPFPlugin(IPSSysPFPlugin renderPSSysPFPlugin) {
        this.renderPSSysPFPlugin = renderPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bf9\u9f50", codelist="GridColAlign", fields={"ALIGN"})
    public String getAlign() {
        return this.strAlign;
    }

    protected void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f", fields={"NOSORT"})
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    public void setEnableSort(boolean bEnableSort) {
        this.bEnableSort = bEnableSort;
    }

    @Override
    public String getWidthString() {
        return this.strWidthString;
    }

    public String getExcelText(IWebContext iWebContext, Object object) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    public String getExcelText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        return "\u6ca1\u6709\u5b9e\u73b0";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u9690\u85cf", ignoredumpvalues="false")
    public boolean isHideDefault() {
        return this.bHideDefault;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6a21\u5f0f", ignoredumpvalues="0", fields={"HIDEDEFAULT"})
    public int getHideMode() {
        return this.nHideMode;
    }

    @Override
    public String getExcelCaption() {
        return null;
    }

    public String getCodeListId() {
        return null;
    }

    protected boolean isDefineEnableSort() {
        return this.bDefineEnableSort;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public boolean isEnableRowEdit() {
        return false;
    }

    public boolean isDesignMode() {
        return this.getPSDETree().isDesignMode();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5217\u5bf9\u8c61", hideempty=true)
    public IPSDETreeColumn getParentPSTreeColumn() {
        return this.parentPSDETreeColumn;
    }

    @Override
    public String getExcelCapLanResTag() {
        if (this.getExcelCapPSLanguageRes() != null) {
            return this.getExcelCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getExcelCapPSLanguageRes() {
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDETree().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDETREECOL";
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u5217\u6837\u5f0f", codelist="DEGridColStype", fields={"GRIDCOLSTYLE"})
    public String getColumnStyle() {
        return this.strColumnStyle;
    }

    @Override
    public String getModelType(String strModelType) {
        return super.getModelType(strModelType);
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strModelType, (String)"PSDETREECOL", (boolean)true) == 0) {
            return IPSDETreeColumn.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    public String getModelId() {
        if (this.getPSDETree() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDETree().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
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
    @PSModelRTMeta(description="\u652f\u6301\u5c55\u5f00\uff08\u6811\u8282\u70b9\uff09", doc="\u5217\u6807\u8bc6\u4e3a(text)\u652f\u6301\u5c55\u5f00")
    public boolean isEnableExpand() {
        return this.bEnableExpand;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u6837\u5f0f\u5bf9\u8c61", fields={"HEADERPSSYSCSSID"})
    public IPSSysCss getHeaderPSSysCss() {
        return this.headerPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u56fe\u7247\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u5143\u683c\u6837\u5f0f\u5bf9\u8c61", fields={"CELLPSSYSCSSID"})
    public IPSSysCss getCellPSSysCss() {
        return this.cellPSSysCss;
    }

    public String getDefaultValue() {
        return this.psDETreeColumn.getDEFAULTVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlLogic> getPSControlLogics() {
        return this.onGetPSControlLogics();
    }

    protected Iterator<? extends IPSControlLogic> onGetPSControlLogics() {
        return this.getOwnedPSControl().getPSControlLogicsByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6ce8\u5165\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlAttribute> getPSControlAttributes() {
        return this.onGetPSControlAttributes();
    }

    protected Iterator<? extends IPSControlAttribute> onGetPSControlAttributes() {
        return this.getOwnedPSControl().getPSControlAttributesByItemName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u7ed8\u5236\u5668\u96c6\u5408", child=true)
    public Iterator<? extends IPSControlRender> getPSControlRenders() {
        return this.onGetPSControlRenders();
    }

    protected Iterator<? extends IPSControlRender> onGetPSControlRenders() {
        return this.getOwnedPSControl().getPSControlRendersByItemName(this.getName());
    }

    @Override
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u94fe\u63a5\u6a21\u5f0f", codelist="DEGridColLinkMode", dump=false)
    public int getEnableLink() {
        return this.nEnableLink;
    }
}

