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
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public abstract class PSDEFUIItemImpl
extends PSDEFieldObjectImpl
implements IPSDEFUIItem,
IPSAppDEFUIItem {
    private static final Log log = LogFactory.getLog(PSDEFUIItemImpl.class);
    protected PSDEFUIMode psDEFUIMode = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    protected Integer nDefaultEditorWidth = null;
    protected Integer nDefaultEditorHeight = null;
    private boolean bAllowEmpty = true;
    private String strValueFormat = "";
    private IPSDataEntity refPSDataEntity = null;
    protected IPSEditorType iPSEditorType = null;
    private Properties editorParams = null;
    private String strPSCodeListId = "";
    private String strCaption = "";
    private int nIgnoreInput = 0;
    private boolean bDefineIgnoreInput = false;
    private boolean bNeedCodeListConfig = false;
    private boolean bDefineEditorType = false;
    private int nOutputCodeListConfigMode = 0;
    private String strPlaceHolder = null;
    private IPSSysImage iPSSysImage = null;
    private boolean bRefTempData = false;
    private boolean bRefTempDataDefined = false;
    private boolean bEnableResetItemName = false;
    private String strResetItemName = null;
    private IPSDEFInputTip iPSDEFInputTip = null;
    private String strUnitName = null;
    private int nUnitNameWidth = 0;
    private boolean bEnableUnitName = true;
    private boolean bEnableInputTip = true;
    private IPSDataEntity refPSDE = null;
    private IPSDEACMode refPSDEACMode = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSDELogic refActiveDataPSDELogic = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSSysUnit iPSSysUnit = null;
    private IPSLanguageRes phPSLanguageRes = null;
    private String strPSAjaxHandlerId = null;
    private IPSDERBase refPSDERBase = null;
    private boolean bMobileMode = false;
    private boolean bAllowEmptyDefined = false;
    private IPSAppDEField iPSAppDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEField iPSAppDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        this.setPSAppDEField(iPSAppDEField);
        this.init(iDAGlobalHelper, this.getPSAppDEField().getPSDEField(), psDEFUIMode);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.setId(psDEFUIMode.getPSDEFFORMITEMID());
            this.setName(psDEFUIMode.getPSDEFFORMITEMNAME());
            this.setPSObjectData(psDEFUIMode);
            this.psDEFUIMode = psDEFUIMode;
            this.strEditorType = this.psDEFUIMode.getEDITORTYPE();
            this.strEditorStyle = this.psDEFUIMode.getPSSYSEDITORSTYLEID();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) == 0) {
                this.bMobileMode = true;
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) == 0) {
                    this.bMobileMode = true;
                    this.strEditorType = iPSDEField.getPSDEFieldType().getMBEditorType();
                    this.nDefaultEditorWidth = iPSDEField.getPSDEFieldType().getMBEditorWidth();
                    this.nDefaultEditorHeight = iPSDEField.getPSDEFieldType().getMBEditorHeight();
                } else {
                    this.strEditorType = iPSDEField.getPSDEFieldType().getEditorType();
                    this.nDefaultEditorWidth = iPSDEField.getPSDEFieldType().getEditorWidth();
                    this.nDefaultEditorHeight = iPSDEField.getPSDEFieldType().getEditorHeight();
                }
            } else {
                this.bDefineEditorType = true;
            }
            this.editorParams = PropertiesHelper.load((String)this.psDEFUIMode.getEDITORPARAMS());
            if (!this.psDEFUIMode.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psDEFUIMode.getALLOWEMPTY();
                this.bAllowEmptyDefined = true;
            } else {
                this.bAllowEmpty = iPSDEField.isAllowEmpty();
            }
            this.strValueFormat = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getVALUEFORMAT()) ? this.psDEFUIMode.getVALUEFORMAT() : this.getPSDEField().getValueFormat();
            this.strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSCodeListId)) {
                this.strPSCodeListId = this.iPSDEField.getCodeListId();
            }
            this.strCaption = this.psDEFUIMode.getCAPTION();
            if (!this.psDEFUIMode.isIGNOREINPUTNull()) {
                this.nIgnoreInput = this.psDEFUIMode.getIGNOREINPUT();
                this.bDefineIgnoreInput = true;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDEFUIMode.getPLACEHOLDER();
            }
            if (!this.psDEFUIMode.isREFTEMPDATANull()) {
                this.bRefTempDataDefined = true;
                this.bRefTempData = this.psDEFUIMode.getREFTEMPDATA();
            }
            if (!this.psDEFUIMode.isENABLERESETITEMNAMENull()) {
                this.bEnableResetItemName = this.psDEFUIMode.getENABLERESETITEMNAME();
                if (this.bEnableResetItemName) {
                    this.strResetItemName = this.psDEFUIMode.getRESETITEMNAME();
                }
            }
            if (!psDEFUIMode.isENABLEINPUTTIPNull()) {
                this.bEnableInputTip = this.psDEFUIMode.getENABLEINPUTTIP();
            }
            if (this.bEnableInputTip) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPSDEFINPUTTIPID())) {
                    this.iPSDEFInputTip = this.getPSDEField().getPSDEFInputTip(this.psDEFUIMode.getPSDEFINPUTTIPID(), true);
                    if (this.iPSDEFInputTip == null) {
                        log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s]\uff0c\u53ef\u80fd\u672a\u542f\u7528", (Object)this.psDEFUIMode.getPSDEFINPUTTIPID()));
                    }
                } else {
                    this.iPSDEFInputTip = this.getPSDEField().getDefaultPSDEFInputTip();
                }
            }
            if (!this.psDEFUIMode.isENABLEUNITNAMENull()) {
                this.bEnableUnitName = this.psDEFUIMode.getENABLEUNITNAME();
            }
            if (this.bEnableUnitName) {
                this.strUnitName = this.psDEFUIMode.getUNITNAME();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPSSYSUNITID())) {
                    this.iPSSysUnit = this.getPSDataEntity().getPSSystem().getPSSysUnit(this.psDEFUIMode.getPSSYSUNITID());
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
                        this.strUnitName = this.iPSSysUnit.getName();
                    }
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
                    this.strUnitName = this.getPSDEField().getUnit();
                }
                this.nUnitNameWidth = !this.psDEFUIMode.isUNITNAMEWIDTHNull() ? this.psDEFUIMode.getUNITNAMEWIDTH() : this.getPSDEField().getUnitWidth();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFUIMode.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPHPSLANRESID())) {
                this.phPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFUIMode.getPHPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getITEMPSACHANDLERID())) {
                this.strPSAjaxHandlerId = this.psDEFUIMode.getITEMPSACHANDLERID();
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDEId())) {
            this.refPSDataEntity = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity2(this.getRefPSDEId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
        }
        if (!this.psDEFUIMode.isNEEDCODELISTCONFIGNull()) {
            this.bNeedCodeListConfig = this.psDEFUIMode.getNEEDCODELISTCONFIG();
        } else if (this.iPSEditorType != null) {
            this.bNeedCodeListConfig = this.iPSEditorType.isNeedCodeListConfig();
        }
        if (!this.psDEFUIMode.isCODELISTCONFIGMODENull()) {
            this.nOutputCodeListConfigMode = this.psDEFUIMode.getCODELISTCONFIGMODE();
        } else if (this.iPSEditorType != null) {
            this.nOutputCodeListConfigMode = this.iPSEditorType.getOutputCodeListConfigMode();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFUIMode.getPSSYSIMAGEID());
        }
        super.onInit();
    }

    @Override
    public String getDataItemName() {
        return this.getPSDEField().getName().toLowerCase();
    }

    @Override
    public String getCaption(String strLanguage) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.strCaption;
        }
        return this.getPSDEField().getLogicName(strLanguage);
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292, fields={"EDITORTYPE"})
    public String getEditorType() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            return this.iPSDEField.getPSDEFieldType().getEditorType();
        }
        return this.strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", fields={"PSSYSEDITORSTYLEID"})
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", ignoredumpvalues="true", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    public boolean isAllowEmptyDefined() {
        return this.bAllowEmptyDefined;
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    public String getRefPSDEId() {
        return this.psDEFUIMode.getREFPSDEID();
    }

    @Override
    public String getRefPSDEName() throws Exception {
        if (this.getRefPSDE() == null) {
            return "";
        }
        return this.getRefPSDE().getName();
    }

    @Override
    public String getRefPSDEACModeId() {
        return this.psDEFUIMode.getREFPSDEACMODEID();
    }

    @Override
    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.psDEFUIMode.getREFPICKUPPSDEVIEWID();
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.psDEFUIMode.getREFPICKUPPSDEVIEWNAME();
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.psDEFUIMode.getREFMPICKUPPSDEVIEWID();
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.psDEFUIMode.getREFMPICKUPPSDEVIEWNAME();
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.psDEFUIMode.getREFLINKPSDEVIEWID();
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return this.psDEFUIMode.getREFLINKPSDEVIEWNAME();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", ignoredumpvalues="%1$s", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    public String getOriginValueFormat() {
        return this.psDEFUIMode.getVALUEFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, fields={"REFPSDEID"})
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.psDEFUIMode.getREFPSDEDATASETID();
    }

    @Override
    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    @Override
    public String getCreateDVT() {
        return this.psDEFUIMode.getCREATEDVT();
    }

    @Override
    public String getCreateDV() {
        return this.psDEFUIMode.getCREATEDV();
    }

    @Override
    public String getUpdateDVT() {
        return this.psDEFUIMode.getUPDATEDVT();
    }

    @Override
    public String getUpdateDV() {
        return this.psDEFUIMode.getUPDATEDV();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u53c2\u6570\u96c6\u5408", ignorepf=true, fields={"EDITORPARAMS"})
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)(this.iPSEditorType == null ? nDefault : this.iPSEditorType.getEditorParam(strParam, nDefault)));
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)(this.iPSEditorType == null ? strDefault : this.iPSEditorType.getEditorParam(strParam, strDefault)));
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)(this.iPSEditorType == null ? fDefault : this.iPSEditorType.getEditorParam(strParam, fDefault)));
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)(this.iPSEditorType == null ? bDefault : this.iPSEditorType.getEditorParam(strParam, bDefault)));
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.psDEFUIMode.getPSSYSVALUERULEID();
    }

    @Override
    public String getPSSysDictCatId() {
        return this.psDEFUIMode.getPSSYSDICTCATID();
    }

    @Override
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @Override
    public boolean isIgnoreInputDefined() {
        return this.bDefineIgnoreInput;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e", ignoredumpvalues="false", fields={"NEEDCODELISTCONFIG"})
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode", ignoredumpvalues="0", fields={"CODELISTCONFIGMODE"})
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", fields={"PLACEHOLDER"})
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public boolean isRefTempData() {
        return this.bRefTempData;
    }

    protected boolean isRefTempDataDefined() {
        return this.bRefTempDataDefined;
    }

    @Override
    public boolean isEnableResetItemName() {
        return this.bEnableResetItemName;
    }

    @Override
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    public String getUnitName() {
        return this.strUnitName;
    }

    @Override
    public int getUnitNameWidth() {
        return this.nUnitNameWidth;
    }

    @Override
    public IPSDEFInputTip getPSDEFInputTip() {
        return this.iPSDEFInputTip;
    }

    @Override
    public boolean isEnableUnitName() {
        return this.bEnableUnitName;
    }

    @Override
    public IPSDataEntity getRefPSDE() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDEId())) {
            return null;
        }
        if (this.refPSDE == null) {
            IPSDataEntity iPSDataEntity;
            this.refPSDE = iPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.getRefPSDEId());
        }
        return this.refPSDE;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true, dumpref=true, from="__self__", from_method="getRefPSDataEntityMust().getPSDEACMode", fields={"REFPSDEACMODEID"})
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDEACModeId())) {
            return null;
        }
        if (this.refPSDEACMode == null) {
            IPSDEACMode iPSDEACMode;
            if (this.getRefPSDE() == null) {
                throw new Exception("\u5f15\u7528\u5b9e\u4f53\u65e0\u6548");
            }
            this.refPSDEACMode = iPSDEACMode = this.getRefPSDE().getPSDEACMode(this.getRefPSDEACModeId());
        }
        return this.refPSDEACMode;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dumpref=true, from="__self__", from_method="getRefPSDataEntityMust().getPSDEDataSet", fields={"REFPSDEDATASETID"})
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDEDataSetId())) {
            return null;
        }
        if (this.refPSDEDataSet == null) {
            IPSDEDataSet iPSDEDataSet;
            if (this.getRefPSDE() == null) {
                throw new Exception("\u5f15\u7528\u5b9e\u4f53\u65e0\u6548");
            }
            this.refPSDEDataSet = iPSDEDataSet = this.getRefPSDE().getPSDEDataSet(this.getRefPSDEDataSetId());
        }
        return this.refPSDEDataSet;
    }

    @Override
    public String getRefActiveDataPSDELogicId() {
        return this.psDEFUIMode.getREFADPSDELOGICID();
    }

    @Override
    public String getRefActiveDataPSDELogicName() throws Exception {
        if (this.getRefActiveDataPSDELogic() == null) {
            return "";
        }
        return this.getRefActiveDataPSDELogic().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true, fields={"REFADPSDELOGICID"})
    public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefActiveDataPSDELogicId())) {
            return null;
        }
        if (this.refActiveDataPSDELogic == null) {
            IPSDELogic iPSDELogic;
            if (this.getRefPSDE() == null) {
                throw new Exception("\u5f15\u7528\u5b9e\u4f53\u65e0\u6548");
            }
            this.refActiveDataPSDELogic = iPSDELogic = this.getRefPSDE().getPSDELogic(this.getRefActiveDataPSDELogicId());
        }
        return this.refActiveDataPSDELogic;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            return this.getPSDEField().getLNPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    @Override
    public IPSSysUnit getPSSysUnit() {
        return this.iPSSysUnit;
    }

    @Override
    public String getUnitLanResTag() {
        if (this.getUnitPSLanguageRes() != null) {
            return this.getUnitPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getUnitPSLanguageRes() {
        if (this.getPSSysUnit() != null) {
            return this.getPSSysUnit().getNamePSLanguageRes();
        }
        return this.getPSDEField().getUnitPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"PHPSLANRESID"})
    public IPSLanguageRes getPHPSLanguageRes() {
        return this.phPSLanguageRes;
    }

    @Override
    public String getPHLanResTag() {
        if (this.getPHPSLanguageRes() != null) {
            return this.getPHPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public String getPSAjaxHandlerId() {
        return this.strPSAjaxHandlerId;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb", hideempty=true)
    public IPSDERBase getRefPSDER() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDERId())) {
            return null;
        }
        if (this.refPSDERBase == null) {
            IPSDERBase iPSDER;
            this.refPSDERBase = iPSDER = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDER(this.getRefPSDERId());
        }
        return this.refPSDERBase;
    }

    @Override
    public String getRefPSDERId() {
        return this.psDEFUIMode.getREFPSDERID();
    }

    @Override
    public String getRefPSDERName() throws Exception {
        if (this.getRefPSDER() == null) {
            return "";
        }
        return this.getRefPSDER().getName();
    }

    @Override
    public String getRefLinkPSDEViewId(IPSApplication iPSApplication) throws Exception {
        return this.psDEFUIMode.getREFLINKPSDEVIEWID();
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        return this.psDEFUIMode.getREFMPICKUPPSDEVIEWID();
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        return this.psDEFUIMode.getREFPICKUPPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u6a21\u5f0f", ignoredumpvalues="false", fields={"FTMODE"})
    public boolean isMobileMode() {
        return this.bMobileMode;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEFUIMode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5f0f", codelist="FieldUIMode", fields={"FTMODE"})
    public String getUIMode() {
        return this.psDEFUIMode.getFTMODE();
    }

    public boolean isEditorTypeDefined() {
        return this.bDefineEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", fields={"STRLENGTH"})
    public int getStringLength() {
        return this.getStringLength(this.getPSDEField());
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", fields={"MINSTRLENGTH"})
    public int getMinStringLength() {
        return this.getMinStringLength(this.getPSDEField());
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09", fields={"MAXVALUE"})
    public String getMaxValueString() {
        return this.getMaxValueString(this.getPSDEField());
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09", fields={"MINVALUE"})
    public String getMinValueString() {
        return this.getMinValueString(this.getPSDEField());
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0", fields={"PRECISION"})
    public int getPrecision() {
        return this.getPrecision(this.getPSDEField());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219")
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.getPSSysValueRule(this.getPSDEField());
    }

    @Override
    public int getPrecision(IPSDEFieldBase iPSDEFieldBase) {
        if (!this.psDEFUIMode.isPRECISION2Null()) {
            return this.psDEFUIMode.getPRECISION2();
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getPrecision();
        }
        return 0;
    }

    @Override
    public int getStringLength(IPSDEFieldBase iPSDEFieldBase) {
        if (!this.psDEFUIMode.isSTRLENGTHNull()) {
            return this.psDEFUIMode.getSTRLENGTH();
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getStringLength();
        }
        return -1;
    }

    @Override
    public int getMinStringLength(IPSDEFieldBase iPSDEFieldBase) {
        if (!this.psDEFUIMode.isMINSTRLENGTHNull()) {
            return this.psDEFUIMode.getMINSTRLENGTH();
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getMinStringLength();
        }
        return -1;
    }

    @Override
    public String getMaxValueString(IPSDEFieldBase iPSDEFieldBase) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getMAXVALUE())) {
            return this.psDEFUIMode.getMAXVALUE();
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getMaxValueString();
        }
        return null;
    }

    @Override
    public String getMinValueString(IPSDEFieldBase iPSDEFieldBase) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getMINVALUE())) {
            return this.psDEFUIMode.getMINVALUE();
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getMinValueString();
        }
        return null;
    }

    @Override
    public IPSSysValueRule getPSSysValueRule(IPSDEFieldBase iPSDEFieldBase) throws Exception {
        if (!this.psDEFUIMode.isENABLEVALUERULENull() && !this.psDEFUIMode.getENABLEVALUERULE()) {
            return null;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getPSSYSVALUERULEID())) {
            return this.getPSDataEntity().getPSSystem().getPSSysValueRule(this.psDEFUIMode.getPSSYSVALUERULEID());
        }
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getPSSysValueRule();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5355\u9879\u9009\u62e9\u5b9e\u4f53\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", hideempty=true)
    public String getRefPickupPSDEViewCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPickupPSDEViewId()) || this.getRefPSDataEntity() == null) {
            return null;
        }
        try {
            PSDEViewBase psDEViewBase = this.getRefPSDataEntity().getPSDEViewData(this.getRefPickupPSDEViewId(), true);
            if (psDEViewBase != null) {
                return psDEViewBase.getCODENAME();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u591a\u9879\u9009\u62e9\u5b9e\u4f53\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", hideempty=true)
    public String getRefMPickupPSDEViewCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefMPickupPSDEViewId()) || this.getRefPSDataEntity() == null) {
            return null;
        }
        try {
            PSDEViewBase psDEViewBase = this.getRefPSDataEntity().getPSDEViewData(this.getRefMPickupPSDEViewId(), true);
            if (psDEViewBase != null) {
                return psDEViewBase.getCODENAME();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u94fe\u63a5\u5b9e\u4f53\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", hideempty=true)
    public String getRefLinkPSDEViewCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefLinkPSDEViewId()) || this.getRefPSDataEntity() == null) {
            return null;
        }
        try {
            PSDEViewBase psDEViewBase = this.getRefPSDataEntity().getPSDEViewData(this.getRefLinkPSDEViewId(), true);
            if (psDEViewBase != null) {
                return psDEViewBase.getCODENAME();
            }
        }
        catch (Exception e) {
            log.error((Object)e);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u6807\u9898", hideempty=true)
    public String getOriginCaption() {
        return this.strCaption;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", outputdoc="false", hideempty=true)
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    protected void setPSAppDEField(IPSAppDEField iPSAppDEField) {
        this.iPSAppDEField = iPSAppDEField;
    }
}

