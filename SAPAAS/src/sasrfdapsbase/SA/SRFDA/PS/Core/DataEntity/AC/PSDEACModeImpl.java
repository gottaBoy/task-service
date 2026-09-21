/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.AC;

import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppSysPanelPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACModeDataItem;
import SA.SRFDA.PS.Core.DataEntity.AC.PSDEACModeDataItemImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEACModeItem;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeImpl
extends PSDataEntityObjectImpl
implements IPSDEACMode,
IPSAppDEACMode,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEACModeImpl.class);
    protected PSDEACMode psDEACMode = null;
    protected ArrayList<IDataItem> dataItemList = new ArrayList();
    private ArrayList<IPSDEACModeDataItem> psDEACModeDataItemList = new ArrayList();
    private String strACType = "AUTOCOMPLETE";
    private boolean bDefaultMode = false;
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    protected IPSDEField valuePSDEField = null;
    protected IPSDEField textPSDEField = null;
    private IPSSysPFPlugin itemsPSSysPFPlugin = null;
    private String strLogicName = "";
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private int nExtendMode = 0;
    private IPSPFXCodeObject itemPSPFXCodeObject = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEField minorSortPSAppDEField = null;
    private IPSAppDEField valuePSAppDEField = null;
    private IPSAppDEField textPSAppDEField = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private IPSAppView pickupPSAppView = null;
    private IPSAppView linkPSAppView = null;
    private int nActionHolder = 2;
    private boolean bCustomActionHolder = false;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private int nScriptMode = 0;
    private IPSSysMsgTempl historyPSSysMsgTempl = null;
    private IPSLayoutPanel itemPSLayoutPanel = null;
    private IPSSysAIFactory iPSSysAIFactory = null;
    private IPSSysAIChatAgent iPSSysAIChatAgent = null;
    private Properties acParams = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEACMode psDEACMode) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEACMode);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEACMode psDEACMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEACMode = psDEACMode;
            this.setId(this.psDEACMode.getPSDEACMODEID());
            this.setName(this.psDEACMode.getPSDEACMODENAME());
            this.setPSObjectData(this.psDEACMode);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getACTYPE())) {
                this.strACType = this.psDEACMode.getACTYPE();
            }
            if (!this.psDEACMode.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEACMode.getDEFAULTMODE();
            }
            if (!this.psDEACMode.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEACMode.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getACType(), (String)"CHATCOMPLETION", (boolean)false) == 0) {
                this.nActionHolder = 1;
            }
            this.valuePSDEField = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getVALUEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEACMode.getVALUEPSDEFID()) : this.getPSDataEntity().getKeyPSDEField();
            this.textPSDEField = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getTEXTPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psDEACMode.getTEXTPSDEFID()) : this.getPSDataEntity().getMajorPSDEField();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSDEUAGROUPID())) {
                if (this.getPSAppDataEntity() != null) {
                    this.iPSDEUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEACMode.getPSDEUAGROUPID(), true, this);
                }
                if (this.iPSDEUIActionGroup == null) {
                    this.iPSDEUIActionGroup = this.getPSDataEntity().getPSDEUIActionGroup(this.psDEACMode.getPSDEUAGROUPID());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSDEDATASETID())) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEACMode.getPSDEDATASETID());
            }
            if (!this.psDEACMode.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEACMode.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            }
            this.strCodeName = this.psDEACMode.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEACMode.getPSDEACMODENAME().toLowerCase();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || iPSDataEntity != null && iPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getACIPSSYSPFPLUGINID())) {
                this.itemsPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEACMode.getACIPSSYSPFPLUGINID());
            }
            if (this.getItemsPSSysPFPlugin() != null) {
                if (this.getPSAppDataEntity() != null) {
                    this.getPSAppDataEntity().getPSApplication().getPSSysPFPlugin(this.getItemsPSSysPFPlugin().getId(), "DEACMODE", null, null);
                    String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getItemsPSSysPFPlugin().getId(), (String)this.getPSAppDataEntity().getPSApplication().getPSPF().getId());
                    IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                    if (iPSSysPFPluginTempl != null) {
                        this.itemPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, null);
                    }
                } else {
                    this.itemPSPFXCodeObject = new PSPFXCodeObjectProxy(this.getItemsPSSysPFPlugin(), null, null, (Object)this, null);
                }
            }
            this.strLogicName = this.psDEACMode.getLOGICNAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            this.strEmptyText = this.psDEACMode.getEMPTYTEXT();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getEMPTYTEXTPSLANRESID())) {
                this.emptyTextPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEACMode.getEMPTYTEXTPSLANRESID());
            }
            if (!this.psDEACMode.isCUSTOMMODENull()) {
                this.nScriptMode = this.psDEACMode.getCUSTOMMODE();
            }
            if (!this.psDEACMode.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEACMode.getEXTENDMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getACPARAMS())) {
                this.acParams = PropertiesHelper.load((String)this.psDEACMode.getACPARAMS());
            }
            this.onInit();
        }
        catch (Exception ex) {
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
        PSDataItemParamImpl psItemParamImpl;
        PSDEACModeDataItemImpl psDataItemImpl;
        String strMinorSortPSDEFName = this.psDEACMode.getMINORSORTPSDEFNAME();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMinorSortPSDEFName)) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEACMode.getMINORSORTDIR();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEACMode.getPSSYSSFPLUGINID());
        } else if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (this.getPSAppDataEntity() != null) {
            boolean bTryMode = true;
            if (this.getValuePSDEF() != null) {
                this.valuePSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getValuePSDEF(), bTryMode);
            }
            if (this.getTextPSDEF() != null) {
                this.textPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getTextPSDEF(), bTryMode);
            }
            if (this.getMinorSortPSDEF() != null) {
                this.minorSortPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEF(), bTryMode);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSDEUAGROUPID())) {
                this.iPSDEUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(this.psDEACMode.getPSDEUAGROUPID(), false, this);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPickupPSDEViewId())) {
                this.pickupPSAppView = this.getPSAppDataEntity().getPSApplication().getPSAppViewByDEViewId(this.getPickupPSDEViewId(), false);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getLinkPSDEViewId())) {
                this.linkPSAppView = this.getPSAppDataEntity().getPSApplication().getPSAppViewByDEViewId(this.getLinkPSDEViewId(), false);
            }
            if (this.getPSDEDataSet() != null) {
                this.iPSAppDEDataSet = this.getPSAppDataEntity().getPSAppDEDataSet(this.getPSDEDataSet(), false);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getItemPSLayoutPanelId())) {
                try {
                    PSAppView psAppView = new PSAppView();
                    psAppView.setPSAPPVIEWID("PSDEACModeItemPanelView");
                    psAppView.setPSAPPVIEWNAME("PSDEACModeItemPanelView");
                    PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
                    psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
                    psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
                    psDEViewCtrl.setPSSYSVIEWPANELID(this.getItemPSLayoutPanelId());
                    PSAppSysPanelPreviewViewImpl psAppSysPanelPreviewViewImpl = new PSAppSysPanelPreviewViewImpl();
                    psAppSysPanelPreviewViewImpl.init(this.getDAGlobalHelper(), this.getPSAppDataEntity().getPSApplication(), psAppView, this.getPSDataEntity(), psDEViewCtrl);
                    this.itemPSLayoutPanel = (IPSLayoutPanel)psAppSysPanelPreviewViewImpl.getPSControl("panel");
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getACType(), (String)"CHATCOMPLETION", (boolean)true) == 0 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSSYSAIFACTORYID())) {
            this.iPSSysAIFactory = this.getPSSystem().getPSSysAIFactory(this.psDEACMode.getPSSYSAIFACTORYID());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getPSSYSAICHATAGENTID())) {
                this.iPSSysAIChatAgent = this.iPSSysAIFactory.getPSSysAIChatAgent(this.psDEACMode.getPSSYSAICHATAGENTID());
            }
        }
        super.onInit();
        boolean bUseDTO = false;
        if (this.getPSAppDataEntity() != null && this.getPSAppDataEntity().getPSApplication() != null) {
            bUseDTO = this.getPSAppDataEntity().getPSApplication().isUseServiceApi();
        }
        Vector<PSDEACModeItem> psDEACModeItemList = new Vector<PSDEACModeItem>();
        CallResult callResult = this.getPSModelHelper().getPSDEACModeItems(this.getId(), psDEACModeItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u81ea\u586b\u6570\u636e\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bFixTextItem = (this.getPSSystemSetting().getEngineBugFixs() & 0x20) == 32;
        boolean bValueItemDefined = false;
        boolean bTextItemDefined = false;
        if (bFixTextItem) {
            for (PSDEACModeItem psDEACModeItem : psDEACModeItemList) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"value", (boolean)true) == 0) {
                    bValueItemDefined = true;
                    continue;
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"text", (boolean)true) != 0) continue;
                bTextItemDefined = true;
            }
        }
        if (!bValueItemDefined && this.getValuePSDEF() != null) {
            psDataItemImpl = new PSDEACModeDataItemImpl();
            psDataItemImpl.setName("value");
            if (!bUseDTO) {
                psDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getValuePSDEF().getName());
            psItemParamImpl.setPSDEField(this.getValuePSDEF());
            if (this.getPSAppDataEntity() != null) {
                psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getValuePSDEF(), true));
            }
            psDataItemImpl.addDataItemParam(psItemParamImpl);
            psDataItemImpl.init(this);
            this.dataItemList.add(psDataItemImpl);
            this.psDEACModeDataItemList.add(psDataItemImpl);
        }
        if (!bTextItemDefined && this.getTextPSDEF() != null) {
            psDataItemImpl = new PSDEACModeDataItemImpl();
            psDataItemImpl.setName("text");
            if (!bUseDTO) {
                psDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDataItemImpl.setFormat("");
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getTextPSDEF().getName());
            psItemParamImpl.setPSDEField(this.getTextPSDEF());
            if (this.getPSAppDataEntity() != null) {
                psItemParamImpl.setPSAppDEField(this.getPSAppDataEntity().getPSAppDEField(this.getTextPSDEF(), true));
            }
            psDataItemImpl.addDataItemParam(psItemParamImpl);
            psDataItemImpl.init(this);
            this.dataItemList.add(psDataItemImpl);
            this.psDEACModeDataItemList.add(psDataItemImpl);
        }
        for (PSDEACModeItem psDEACModeItem : psDEACModeItemList) {
            if (!bFixTextItem && (SA.SRFramework.Utility.StringHelper.Compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"value", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)psDEACModeItem.getPSDEACMODEITEMNAME(), (String)"text", (boolean)true) == 0)) continue;
            PSDEACModeDataItemImpl psDataItemImpl2 = new PSDEACModeDataItemImpl();
            psDataItemImpl2.setName(psDEACModeItem.getPSDEACMODEITEMNAME().toLowerCase());
            if (!bUseDTO) {
                psDataItemImpl2.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDataItemImpl2.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psDataItemImpl2.setFormat("");
            }
            IPSDEField iPSDEField = null;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEACModeItem.getPSDEFID())) {
                iPSDEField = this.getPSDataEntity().getPSDEField(psDEACModeItem.getPSDEFID(), true);
            }
            PSDataItemParamImpl psItemParamImpl2 = new PSDataItemParamImpl();
            psItemParamImpl2.setName(psDEACModeItem.getPSDEFNAME());
            psItemParamImpl2.setPSDEField(iPSDEField);
            if (!psDEACModeItem.isCLCONVERTFLAGNull() && psDEACModeItem.getCLCONVERTFLAG()) {
                String strPSCodeListId = psDEACModeItem.getPSCODELISTID();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSCodeListId) && iPSDEField != null && iPSDEField.getPSCodeList() != null) {
                    strPSCodeListId = iPSDEField.getPSCodeList().getId();
                }
                psItemParamImpl2.setCodeListId(strPSCodeListId);
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psItemParamImpl2.getCodeListId())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEACModeItem.getVALUEFORMAT())) {
                    psItemParamImpl2.setFormat(psDEACModeItem.getVALUEFORMAT());
                } else if (iPSDEField != null) {
                    IPSAppDEField iPSAppDEField;
                    psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                    if (this.getPSAppDataEntity() != null && (iPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(iPSDEField, true)) != null) {
                        psItemParamImpl2.setPSAppDEField(iPSAppDEField);
                        if (bUseDTO) {
                            psItemParamImpl2.setFormat(iPSAppDEField.getValueFormat());
                        }
                    }
                }
            }
            psDataItemImpl2.addDataItemParam(psItemParamImpl2);
            if (psDEACModeItem.getCUSTOMMODE()) {
                psDataItemImpl2.setCustomCode(true);
                psDataItemImpl2.setScriptCode(psDEACModeItem.getCUSTOMCODE());
            }
            psDataItemImpl2.init(this);
            this.dataItemList.add(psDataItemImpl2);
            this.psDEACModeDataItemList.add(psDataItemImpl2);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getScriptMode() != 0 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getScriptCode())) {
            throw new Exception("\u672a\u5b9a\u4e49\u811a\u672c\u4ee3\u7801");
        }
        this.getHistoryPSSysMsgTempl();
        this.getPSSysAIFactory();
        this.getPSSysAIChatAgent();
        if (this.getItemPSLayoutPanel() != null) {
            this.getItemPSLayoutPanel().check();
        }
        return super.onCheck();
    }

    @PSModelRTMeta(description="\u6570\u636e\u9879\u96c6\u5408", outputdoc="false")
    public Iterator<IDataItem> getDataItems() {
        if (this.dataItemList == null || this.dataItemList.size() == 0) {
            return null;
        }
        return this.dataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879\u96c6\u5408", child=true, group="\u57fa\u672c", order=240)
    public Iterator<IPSDEACModeDataItem> getPSDEACModeDataItems() {
        if (this.psDEACModeDataItemList == null || this.psDEACModeDataItemList.size() == 0) {
            return null;
        }
        return this.psDEACModeDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u586b\u7c7b\u578b", codelist="ACType", ignoredumpvalues="AUTOCOMPLETE", fields={"ACTYPE"})
    public String getACType() {
        return this.strACType;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u81ea\u586b\u6a21\u5f0f", fields={"DEFAULTMODE"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f", fields={"ENABLEPAGINGBAR"})
    public boolean isEnablePagingBar() {
        if (this.psDEACMode.isENABLEPAGINGBARNull()) {
            return false;
        }
        return this.psDEACMode.getENABLEPAGINGBAR() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u6a21\u5f0f", codelist="PagingMode", ignoredumpvalues="0")
    public int getPagingMode() {
        if (this.psDEACMode.isENABLEPAGINGBARNull()) {
            return 0;
        }
        return this.psDEACMode.getENABLEPAGINGBAR();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f", fields={"PAGINGSIZE"})
    public int getPagingSize() {
        if (this.psDEACMode.isPAGINGSIZENull() || this.psDEACMode.getPAGINGSIZE() <= 0) {
            return 50;
        }
        return this.psDEACMode.getPAGINGSIZE();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u65b9\u5411", codelist="SortDir", fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    public String getMinorSortField() {
        if (this.getMinorSortPSDEF() != null) {
            return this.getMinorSortPSDEF().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getValuePSDEF() {
        return this.valuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getTextPSDEF() {
        return this.textPSDEField;
    }

    @Override
    public IPSSysPFPlugin getItemsPSSysPFPlugin() {
        return this.itemsPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getItemPSSysPFPlugin() {
        return this.itemsPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEACMODE";
        }
        return "PSDEACMODE";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90", fields={"EMPTYTEXTPSLANRESID"})
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText) && this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getItemRender() {
        return this.itemPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDATASETID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e94\u7528\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"VALUEPSDEFID"})
    public IPSAppDEField getValuePSAppDEField() {
        return this.valuePSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5e94\u7528\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"TEXTPSDEFID"})
    public IPSAppDEField getTextPSAppDEField() {
        return this.textPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u6392\u5e8f\u5e94\u7528\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"MINORSORTPSDEFID"})
    public IPSAppDEField getMinorSortPSAppDEField() {
        return this.minorSortPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4", hideempty=true, child=true, fields={"PSDEUAGROUPID"})
    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    public String getPickupPSDEViewId() {
        return this.psDEACMode.getPICKUPPSDEVIEWID();
    }

    @Override
    public String getPickupPSDEViewName() {
        return this.psDEACMode.getPICKUPPSDEVIEWNAME();
    }

    @Override
    public String getLinkPSDEViewId() {
        return this.psDEACMode.getLINKPSDEVIEWID();
    }

    @Override
    public String getLinkPSDEViewName() {
        return this.psDEACMode.getLINKPSDEVIEWNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u9009\u62e9\u89c6\u56fe", dumpref=true, fields={"PICKUPPSDEVIEWID"})
    public IPSAppView getPickupPSAppView() {
        return this.pickupPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u94fe\u63a5\u89c6\u56fe", dumpref=true, fields={"LINKPSDEVIEWID"})
    public IPSAppView getLinkPSAppView() {
        return this.linkPSAppView;
    }

    @Override
    public String getItemPSLayoutPanelId() {
        return this.psDEACMode.getPSSYSVIEWPANELID();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6", ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false, fields={"ACTIONHOLDER"})
    public int getActionHolder() {
        return this.nActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", ignoredumpvalues="false", fields={"ACTIONHOLDER"})
    public boolean isEnableBackend() {
        return (this.getActionHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", ignoredumpvalues="false", dump=false, fields={"ACTIONHOLDER"})
    public boolean isEnableFront() {
        return (this.getActionHolder() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u586b\u6807\u8bb0", ignorepf=true, fields={"ACTAG"})
    public String getACTag() {
        return this.psDEACMode.getACTAG();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u586b\u6807\u8bb02", ignorepf=true, fields={"ACTAG2"})
    public String getACTag2() {
        return this.psDEACMode.getACTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u586b\u6807\u8bb03", ignorepf=true, fields={"ACTAG3"})
    public String getACTag3() {
        return this.psDEACMode.getACTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u586b\u6807\u8bb04", ignorepf=true, fields={"ACTAG4"})
    public String getACTag4() {
        return this.psDEACMode.getACTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u6a21\u5f0f", codelist="ScriptMode", ignorepf=true, ignoredumpvalues="0", fields={"CUSTOMMODE"})
    public int getScriptMode() {
        return this.nScriptMode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", ignorepf=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        if (this.getScriptMode() == 0) {
            return null;
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getCUSTOMCODE())) {
            return null;
        }
        return this.psDEACMode.getCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u5386\u53f2\u6d88\u606f\u6a21\u677f\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"HISTORYPSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getHistoryPSSysMsgTempl() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getACType(), (String)"CHATCOMPLETION", (boolean)true) == 0) {
            if (this.historyPSSysMsgTempl != null) {
                return this.historyPSSysMsgTempl;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEACMode.getHISTORYPSSYSMSGTEMPLID())) {
                this.historyPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(this.psDEACMode.getHISTORYPSSYSMSGTEMPLID());
            }
        }
        return this.historyPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getItemPSLayoutPanel() {
        return this.itemPSLayoutPanel;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="AI\u5de5\u5382", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSAIFACTORYID"})
    public IPSSysAIFactory getPSSysAIFactory() throws Exception {
        return this.iPSSysAIFactory;
    }

    @Override
    @PSModelRTMeta(description="AI\u4ea4\u8c08\u4ee3\u7406", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysAIFactory", fields={"PSSYSAICHATAGENTID"})
    public IPSSysAIChatAgent getPSSysAIChatAgent() throws Exception {
        return this.iPSSysAIChatAgent;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"ACPARAMS"})
    public Properties getACParams() {
        return this.acParams;
    }

    @Override
    public String getDynaModelFilePath() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return super.getDynaModelFilePath();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.getPSAppDataEntity() == null) {
            objectNode.remove("getPSDEUIActionGroup");
        }
    }
}

