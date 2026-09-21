/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEFUIItem
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFUIItem;
import net.ibizsys.model.dataentity.field.IPSDEFUIItemRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.PSDEFieldObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFUIItemImpl
extends PSDEFieldObjectImpl
implements IPSDEFUIItem,
IPSDEFUIItemRuntime {
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
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfigMode = 0;
    private String strPlaceHolder = null;
    private IPSSysImage iPSSysImage = null;
    private boolean bRefTempData = false;
    private boolean bRefTempDataDefined = false;
    private boolean bEnableResetItemName = false;
    private String strResetItemName = null;
    private String strUnitName = null;
    private int nUnitNameWidth = 0;
    private boolean bEnableUnitName = true;
    private boolean bEnableInputTip = true;
    private IPSDataEntity refPSDE = null;
    private IPSDEACMode refPSDEACMode = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSDELogic refActiveDataPSDELogic = null;
    private String strPSAjaxHandlerId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSDEField(iPSDEField);
        this.psDEFUIMode = psDEFUIMode;
        this.strEditorType = this.psDEFUIMode.getEDITORTYPE();
        this.strEditorStyle = this.psDEFUIMode.getPSSYSEDITORSTYLEID();
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            if (StringHelper.compare((String)this.psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) == 0) {
                this.strEditorType = this.getPSDEFieldRuntime().getPSDEFieldType().getMBEditorType();
                this.nDefaultEditorWidth = this.getPSDEFieldRuntime().getPSDEFieldType().getMBEditorWidth();
                this.nDefaultEditorHeight = this.getPSDEFieldRuntime().getPSDEFieldType().getMBEditorHeight();
            } else {
                this.strEditorType = this.getPSDEFieldRuntime().getPSDEFieldType().getEditorType();
                this.nDefaultEditorWidth = this.getPSDEFieldRuntime().getPSDEFieldType().getEditorWidth();
                this.nDefaultEditorHeight = this.getPSDEFieldRuntime().getPSDEFieldType().getEditorHeight();
            }
        }
        this.editorParams = PropertiesHelper.load((String)this.psDEFUIMode.getEDITORPARAMS());
        this.bAllowEmpty = !this.psDEFUIMode.isALLOWEMPTYNull() ? this.psDEFUIMode.getALLOWEMPTY() : iPSDEField.isAllowEmpty();
        this.strValueFormat = !StringHelper.isNullOrEmpty((String)this.psDEFUIMode.getVALUEFORMAT()) ? this.psDEFUIMode.getVALUEFORMAT() : this.getPSDEField().getValueFormat();
        this.strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
        if (StringHelper.isNullOrEmpty((String)this.strPSCodeListId)) {
            this.strPSCodeListId = this.iPSDEField.getCodeListId();
        }
        this.strCaption = this.psDEFUIMode.getCAPTION();
        if (!this.psDEFUIMode.isIGNOREINPUTNull()) {
            this.nIgnoreInput = this.psDEFUIMode.getIGNOREINPUT();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFUIMode.getPLACEHOLDER())) {
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
        if (!this.psDEFUIMode.isENABLEUNITNAMENull()) {
            this.bEnableUnitName = this.psDEFUIMode.getENABLEUNITNAME();
        }
        if (this.bEnableUnitName) {
            this.strUnitName = this.psDEFUIMode.getUNITNAME();
            if (!this.psDEFUIMode.isUNITNAMEWIDTHNull()) {
                this.nUnitNameWidth = this.psDEFUIMode.getUNITNAMEWIDTH();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFUIMode.getITEMPSACHANDLERID())) {
            this.strPSAjaxHandlerId = this.psDEFUIMode.getITEMPSACHANDLERID();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getRefPSDEId())) {
            this.refPSDataEntity = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity(this.getRefPSDEId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.getEditorType());
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEFUIMode.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFUIMode.getPSSYSIMAGEID());
        }
        super.onInit();
    }

    public String getDataItemName() {
        return this.getPSDEField().getName().toLowerCase();
    }

    public String getCaption(String strLanguage) {
        if (!StringHelper.isNullOrEmpty((String)this.strCaption)) {
            return this.strCaption;
        }
        return this.getPSDEField().getLogicName(strLanguage);
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            return this.getPSDEFieldRuntime().getPSDEFieldType().getEditorType();
        }
        return this.strEditorType;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f")
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    public String getRefPSDEId() {
        return this.psDEFUIMode.getREFPSDEID();
    }

    public String getRefPSDEName() throws Exception {
        if (this.getRefPSDE() == null) {
            return "";
        }
        return this.getRefPSDE().getName();
    }

    public String getRefPSDEACModeId() {
        return this.psDEFUIMode.getREFPSDEACMODEID();
    }

    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    public String getRefPickupPSDEViewId() {
        return this.psDEFUIMode.getREFPICKUPPSDEVIEWID();
    }

    public String getRefPickupPSDEViewName() {
        return this.psDEFUIMode.getREFPICKUPPSDEVIEWNAME();
    }

    public String getRefMPickupPSDEViewId() {
        return this.psDEFUIMode.getREFMPICKUPPSDEVIEWID();
    }

    public String getRefMPickupPSDEViewName() {
        return this.psDEFUIMode.getREFMPICKUPPSDEVIEWNAME();
    }

    public String getRefLinkPSDEViewId() {
        return this.psDEFUIMode.getREFLINKPSDEVIEWID();
    }

    public String getRefLinkPSDEViewName() {
        return this.psDEFUIMode.getREFLINKPSDEVIEWNAME();
    }

    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    public String getRefPSDEDataSetId() {
        return this.psDEFUIMode.getREFPSDEDATASETID();
    }

    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    public String getCreateDVT() {
        return this.psDEFUIMode.getCREATEDVT();
    }

    public String getCreateDV() {
        return this.psDEFUIMode.getCREATEDV();
    }

    public String getUpdateDVT() {
        return this.psDEFUIMode.getUPDATEDVT();
    }

    public String getUpdateDV() {
        return this.psDEFUIMode.getUPDATEDV();
    }

    public Properties getEditorParams() {
        return this.editorParams;
    }

    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)(this.iPSEditorType == null ? nDefault : this.iPSEditorType.getEditorParam(strParam, nDefault)));
    }

    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)(this.iPSEditorType == null ? strDefault : this.iPSEditorType.getEditorParam(strParam, strDefault)));
    }

    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)(this.iPSEditorType == null ? fDefault : this.iPSEditorType.getEditorParam(strParam, fDefault)));
    }

    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)(this.iPSEditorType == null ? bDefault : this.iPSEditorType.getEditorParam(strParam, bDefault)));
    }

    public String getPSSysValueRuleId() {
        return this.psDEFUIMode.getPSSYSVALUERULEID();
    }

    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode")
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f")
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public boolean isRefTempData() {
        return this.bRefTempData;
    }

    protected boolean isRefTempDataDefined() {
        return this.bRefTempDataDefined;
    }

    public boolean isEnableResetItemName() {
        return this.bEnableResetItemName;
    }

    public String getResetItemName() {
        return this.strResetItemName;
    }

    public String getUnitName() {
        return this.strUnitName;
    }

    public int getUnitNameWidth() {
        return this.nUnitNameWidth;
    }

    public boolean isEnableUnitName() {
        return this.bEnableUnitName;
    }

    public IPSDataEntity getRefPSDE() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEId())) {
            return null;
        }
        if (this.refPSDE == null) {
            IPSDataEntity iPSDataEntity;
            this.refPSDE = iPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity(this.getRefPSDEId());
        }
        return this.refPSDE;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEACModeId())) {
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

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEDataSetId())) {
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

    public String getRefActiveDataPSDELogicId() {
        return this.psDEFUIMode.getREFADPSDELOGICID();
    }

    public String getRefActiveDataPSDELogicName() throws Exception {
        if (this.getRefActiveDataPSDELogic() == null) {
            return "";
        }
        return this.getRefActiveDataPSDELogic().getName();
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true)
    public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefActiveDataPSDELogicId())) {
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

    public String getCapLanResTag() {
        return null;
    }

    public String getUnitLanResTag() {
        return null;
    }

    public String getPHLanResTag() {
        return null;
    }

    public String getPSAjaxHandlerId() {
        return this.strPSAjaxHandlerId;
    }
}

