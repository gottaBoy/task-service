/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFSearchFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.Database.IPSDBValueOP;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchFormItemImpl
extends PSDEFieldObjectImpl
implements IPSDEFSearchFormItem {
    private static final Log log = LogFactory.getLog(PSDEFSearchFormItemImpl.class);
    protected PSDEFSearchMode psDEFSearchFormItem = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    private boolean bAllowEmpty = true;
    private String strValueFormat = "";
    private IPSDBValueOP iPSDBValueOP = null;
    protected IPSEditorType iPSEditorType = null;
    private Properties editorParams = null;
    private IPSDataEntity refPSDataEntity = null;
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfigMode = 0;
    private String strPlaceHolder = null;
    private IPSSysImage iPSSysImage = null;
    private boolean bMobileApp = false;
    private IPSDataEntity refPSDE = null;
    private IPSDEACMode refPSDEACMode = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSDERBase refPSDERBase = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes phPSLanguageRes = null;
    private String strCaption = null;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMobPickupPSDEViewId = "";
    private String strRefMobPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefMobMPickupPSDEViewId = "";
    private String strRefMobMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefPSDEId = "";
    private String strRefPSDEDataSetId = "";
    private String strRefActiveDataPSDELogicId = "";
    private IPSDELogic refActiveDataPSDELogic = null;
    private String strRefPSDEACModeId = "";
    private String strRefPSDERId = "";
    private IPSSysDBValueFunc iPSSysDBValueFunc = null;
    private String strPSCodeListId = "";
    private int nEditorWidth = 100;
    private IPSDEFSearchMode iPSDEFSearchMode = null;
    private String strUIMode = "";
    private boolean bDefineEditorType = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, IPSDEFSearchMode iPSDEFSearchMode, PSDEFSearchMode psDEFSearchFormItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.psDEFSearchFormItem = psDEFSearchFormItem;
            this.iPSDEFSearchMode = iPSDEFSearchMode;
            this.strUIMode = this.psDEFSearchFormItem.getParamStringValue("FTMODE", "DEFAULT");
            this.bMobileApp = SA.SRFramework.Utility.StringHelper.Compare((String)this.strUIMode, (String)"MOBILEDEFAULT", (boolean)true) == 0;
            this.setId(this.psDEFSearchFormItem.getPSDEFSFITEMID());
            this.setName(this.psDEFSearchFormItem.getPSDEFSFITEMNAME());
            this.iPSDBValueOP = this.getPSModelStorage().getPSDBValueOP(psDEFSearchFormItem.getPSDBVALUEOPID());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEFSearchFormItem.getPSSYSDBVFID())) {
                this.iPSSysDBValueFunc = this.getPSDataEntity().getPSSystem().getPSSysDBValueFunc(psDEFSearchFormItem.getPSSYSDBVFID());
            }
            this.strEditorType = this.psDEFSearchFormItem.getEDITORTYPE();
            this.strEditorStyle = this.psDEFSearchFormItem.getPSSYSEDITORSTYLEID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.getDefaultEditorType();
            } else {
                this.bDefineEditorType = true;
            }
            this.editorParams = PropertiesHelper.load((String)"");
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.strEditorType);
            }
            if (this.psDEFSearchFormItem.isWIDTHNull()) {
                if (this.getPSSystemSetting().getDEFSFItemWidth() >= 0) {
                    this.nEditorWidth = this.getPSSystemSetting().getDEFSFItemWidth();
                }
            } else {
                this.nEditorWidth = this.psDEFSearchFormItem.getWIDTH();
            }
            if (this.nEditorWidth < 0) {
                this.nEditorWidth = 0;
            }
            this.strValueFormat = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getVALUEFORMAT()) ? this.psDEFSearchFormItem.getVALUEFORMAT() : (this.iPSSysDBValueFunc != null ? this.iPSSysDBValueFunc.getOutputValueFormat() : this.getPSDEField().getValueFormat());
            if (this.iPSEditorType != null) {
                this.bNeedCodeListConfig = this.iPSEditorType.isNeedCodeListConfig();
                this.nOutputCodeListConfigMode = this.iPSEditorType.getOutputCodeListConfigMode();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDEFSearchFormItem.getPLACEHOLDER();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getCAPTION())) {
                this.strCaption = this.psDEFSearchFormItem.getCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFSearchFormItem.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getPHPSLANRESID())) {
                this.phPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFSearchFormItem.getPHPSLANRESID());
            }
            this.strRefPSDEId = this.psDEFSearchFormItem.getREFPSDEID();
            this.strRefPSDEACModeId = this.psDEFSearchFormItem.getREFPSDEACMODEID();
            this.strRefPSDEDataSetId = this.psDEFSearchFormItem.getREFPSDEDATASETID();
            this.strRefPickupPSDEViewId = this.psDEFSearchFormItem.getREFPICKUPPSDEVIEWID();
            this.strRefPickupPSDEViewName = this.psDEFSearchFormItem.getREFPICKUPPSDEVIEWNAME();
            this.strRefMPickupPSDEViewId = this.psDEFSearchFormItem.getREFMPICKUPPSDEVIEWID();
            this.strRefMPickupPSDEViewName = this.psDEFSearchFormItem.getREFMPICKUPPSDEVIEWNAME();
            this.strRefMobPickupPSDEViewId = this.psDEFSearchFormItem.getREFMOBPICKUPPSDEVIEWID();
            this.strRefMobPickupPSDEViewName = this.psDEFSearchFormItem.getREFMOBPICKUPPSDEVIEWNAME();
            this.strRefMobMPickupPSDEViewId = this.psDEFSearchFormItem.getREFMOBMPICKUPPSDEVIEWID();
            this.strRefMobMPickupPSDEViewName = this.psDEFSearchFormItem.getREFMOBMPICKUPPSDEVIEWNAME();
            this.strRefActiveDataPSDELogicId = this.psDEFSearchFormItem.getREFADPSDELOGICID();
            this.strRefPSDERId = this.psDEFSearchFormItem.getREFPSDERID();
            this.strPSCodeListId = this.psDEFSearchFormItem.getPSCODELISTID();
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

    protected String getDefaultEditorType() throws Exception {
        if (this.isMobileApp()) {
            return this.getPSDEField().getPSDEFieldType().getSearchMBEditorType();
        }
        return this.getPSDEField().getPSDEFieldType().getSearchEditorType();
    }

    @Override
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDEId())) {
            this.refPSDataEntity = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity2(this.getRefPSDEId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchFormItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFSearchFormItem.getPSSYSIMAGEID());
        }
        super.onInit();
    }

    @Override
    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295)
    public int getEditorWidth() {
        return this.nEditorWidth;
    }

    @Override
    public String getCaption(String strLanguage) {
        if ((this.getPSSystemSetting().getEngineBugFixs() & 0x40) == 64 && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.strCaption;
        }
        String strCaption = this.getPSDEField().getLogicName(strLanguage);
        String strDBValueOPName = this.iPSDBValueOP.getCaption(true, strLanguage);
        if (this.iPSSysDBValueFunc == null) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDBValueOPName)) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)strCaption);
            }
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s(%2$s)", (Object)strCaption, (Object)strDBValueOPName);
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDBValueOPName)) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s[%2$s]", (Object)strCaption, (Object)this.iPSSysDBValueFunc.getName());
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s[%3$s](%2$s)", (Object)strCaption, (Object)strDBValueOPName, (Object)this.iPSSysDBValueFunc.getName());
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            return this.iPSDEField.getPSDEFieldType().getEditorType();
        }
        return this.strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFUIMode psDEFFormItem) throws Exception {
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u5b9e\u73b0"));
    }

    @Override
    public String getPSCodeListId() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSCodeListId)) {
            return this.strPSCodeListId;
        }
        return this.iPSDEField.getCodeListId();
    }

    @Override
    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        return "";
    }

    @Override
    public String getRefPSDEId() {
        return this.strRefPSDEId;
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
        return this.strRefPSDEACModeId;
    }

    @Override
    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    @Override
    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @Override
    public String getOriginValueFormat() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300)
    public int getEditorHeight() {
        return 0;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return null;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return null;
    }

    @Override
    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormItem.getEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEFormItem.getPSCodeList() != null && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.strRefPSDEDataSetId;
    }

    @Override
    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    @Override
    public int getEnableCond() {
        return 3;
    }

    @Override
    public String getCreateDVT() {
        return "";
    }

    @Override
    public String getCreateDV() {
        return "";
    }

    @Override
    public String getUpdateDVT() {
        return "";
    }

    @Override
    public String getUpdateDV() {
        return "";
    }

    @Override
    public JSONObject getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        return null;
    }

    @Override
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

    protected IPSDBValueOP getPSDBValueOP() {
        return this.iPSDBValueOP;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.psDEFSearchFormItem.getPSSYSVALUERULEID();
    }

    @Override
    public int getIgnoreInput() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public boolean isRefTempData() {
        return false;
    }

    protected boolean isMobileApp() {
        return this.bMobileApp;
    }

    @Override
    public boolean isEnableResetItemName() {
        return false;
    }

    @Override
    public String getResetItemName() {
        return null;
    }

    @Override
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @Override
    public String getUnitName() {
        return null;
    }

    @Override
    public int getUnitNameWidth() {
        return 0;
    }

    @Override
    public IPSDEFInputTip getPSDEFInputTip() {
        return null;
    }

    @Override
    public boolean isEnableUnitName() {
        return false;
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
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
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
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
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
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public IPSSysUnit getPSSysUnit() {
        return null;
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
        return this.getPSDEField().getUnitPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
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
        return null;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEField().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getRefActiveDataPSDELogicId() {
        return this.strRefActiveDataPSDELogicId;
    }

    @Override
    public String getRefActiveDataPSDELogicName() throws Exception {
        if (this.getRefActiveDataPSDELogic() == null) {
            return "";
        }
        return this.getRefActiveDataPSDELogic().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true)
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
    public boolean isIgnoreInputDefined() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f")
    public IPSDEFSearchMode getPSDEFSearchMode() {
        return this.iPSDEFSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb", hideempty=true)
    public IPSDERBase getRefPSDER() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefPSDERId())) {
            return null;
        }
        if (this.refPSDERBase == null) {
            IPSDERBase refPSDERBase;
            if (this.getRefPSDE() == null) {
                throw new Exception("\u5f15\u7528\u5b9e\u4f53\u65e0\u6548");
            }
            this.refPSDERBase = refPSDERBase = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDER(this.getRefPSDERId());
        }
        return this.refPSDERBase;
    }

    @Override
    public String getRefPSDERId() {
        return this.strRefPSDERId;
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
        return null;
    }

    @Override
    public String getRefMPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        if (iPSApplication != null && iPSApplication.isMobileApp()) {
            return this.strRefMobMPickupPSDEViewId;
        }
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewId(IPSApplication iPSApplication) throws Exception {
        if (iPSApplication != null && iPSApplication.isMobileApp()) {
            return this.strRefMobPickupPSDEViewId;
        }
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public boolean isMobileMode() {
        return false;
    }

    @Override
    public String getPSSysDictCatId() {
        return "";
    }

    @Override
    public String getCodeName() {
        return "";
    }

    @Override
    public String getUIMode() {
        return this.strUIMode;
    }

    public boolean isEditorTypeDefined() {
        return this.bDefineEditorType;
    }

    @Override
    public int getStringLength() {
        return this.getStringLength(null);
    }

    @Override
    public int getMinStringLength() {
        return this.getMinStringLength(null);
    }

    @Override
    public String getMaxValueString() {
        return this.getMaxValueString(null);
    }

    @Override
    public String getMinValueString() {
        return this.getMinValueString(null);
    }

    @Override
    public int getPrecision() {
        return this.getPrecision(null);
    }

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.getPSSysValueRule(null);
    }

    @Override
    public int getPrecision(IPSDEFieldBase iPSDEFieldBase) {
        if (iPSDEFieldBase != null) {
            return iPSDEFieldBase.getPrecision();
        }
        return 0;
    }

    @Override
    public int getStringLength(IPSDEFieldBase iPSDEFieldBase) {
        return -1;
    }

    @Override
    public int getMinStringLength(IPSDEFieldBase iPSDEFieldBase) {
        return -1;
    }

    @Override
    public String getMaxValueString(IPSDEFieldBase iPSDEFieldBase) {
        return null;
    }

    @Override
    public String getMinValueString(IPSDEFieldBase iPSDEFieldBase) {
        return null;
    }

    @Override
    public IPSSysValueRule getPSSysValueRule(IPSDEFieldBase iPSDEFieldBase) throws Exception {
        return null;
    }

    @Override
    public boolean getAllowEmpty(IPSDEFormItem iPSDEFormItem) {
        return this.isAllowEmpty();
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
}

