/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSFIDEFValueRule
 *  net.ibizsys.model.data.IPSDBValueOP
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.res.IPSSysDBValueFunc
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItemRuntime;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.model.data.IPSDBValueOP;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.PSDEFieldObjectImpl;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchFormItemImpl
extends PSDEFieldObjectImpl
implements IPSDEFSearchFormItem,
IPSDEFSearchFormItemRuntime {
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
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefPSDEId = "";
    private String strRefPSDEDataSetId = "";
    private String strRefActiveDataPSDELogicId = "";
    private IPSDELogic refActiveDataPSDELogic = null;
    private String strRefPSDEACModeId = "";
    private IPSSysDBValueFunc iPSSysDBValueFunc = null;
    private String strPSCodeListId = "";
    private int nEditorWidth = 100;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField, PSDEFSearchMode psDEFSearchFormItem) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEField(iPSDEField);
            this.psDEFSearchFormItem = psDEFSearchFormItem;
            this.bMobileApp = StringHelper.compare((String)this.psDEFSearchFormItem.getParamStringValue("FTMODE", ""), (String)"MOBILEDEFAULT", (boolean)true) == 0;
            this.setId(this.psDEFSearchFormItem.getPSDEFSFITEMID());
            this.setName(this.psDEFSearchFormItem.getPSDEFSFITEMNAME());
            this.iPSDBValueOP = this.getPSModelStorageContext().getPSDBValueOP(psDEFSearchFormItem.getPSDBVALUEOPID());
            if (!StringHelper.isNullOrEmpty((String)psDEFSearchFormItem.getPSSYSDBVFID())) {
                this.iPSSysDBValueFunc = this.getPSDataEntity().getPSSystem().getPSSysDBValueFunc(psDEFSearchFormItem.getPSSYSDBVFID());
            }
            this.strEditorType = this.psDEFSearchFormItem.getEDITORTYPE();
            this.strEditorStyle = this.psDEFSearchFormItem.getPSSYSEDITORSTYLEID();
            if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.getDefaultEditorType();
            }
            this.editorParams = PropertiesHelper.load((String)"");
            if (!StringHelper.isNullOrEmpty((String)this.strEditorType)) {
                this.iPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.strEditorType);
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
            this.strValueFormat = !StringHelper.isNullOrEmpty((String)this.psDEFSearchFormItem.getVALUEFORMAT()) ? this.psDEFSearchFormItem.getVALUEFORMAT() : (this.iPSSysDBValueFunc != null ? this.iPSSysDBValueFunc.getOutputValueFormat() : this.getPSDEField().getValueFormat());
            if (this.iPSEditorType != null) {
                this.bNeedCodeListConfig = this.iPSEditorType.isNeedCodeListConfig();
                this.nOutputCodeListConfigMode = this.iPSEditorType.getOutputCodeListConfigMode();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEFSearchFormItem.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDEFSearchFormItem.getPLACEHOLDER();
            }
            this.strRefPSDEId = this.psDEFSearchFormItem.getREFPSDEID();
            this.strRefPSDEACModeId = this.psDEFSearchFormItem.getREFPSDEACMODEID();
            this.strRefPSDEDataSetId = this.psDEFSearchFormItem.getREFPSDEDATASETID();
            this.strRefPickupPSDEViewId = this.psDEFSearchFormItem.getREFPICKUPPSDEVIEWID();
            this.strRefPickupPSDEViewName = this.psDEFSearchFormItem.getREFPICKUPPSDEVIEWNAME();
            this.strRefMPickupPSDEViewId = this.psDEFSearchFormItem.getREFMPICKUPPSDEVIEWID();
            this.strRefMPickupPSDEViewName = this.psDEFSearchFormItem.getREFMPICKUPPSDEVIEWNAME();
            this.strRefActiveDataPSDELogicId = this.psDEFSearchFormItem.getREFADPSDELOGICID();
            this.strPSCodeListId = this.psDEFSearchFormItem.getPSCODELISTID();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    protected String getDefaultEditorType() throws Exception {
        if (this.isMobileApp()) {
            return this.getPSDEFieldRuntime().getPSDEFieldType().getSearchMBEditorType();
        }
        return this.getPSDEFieldRuntime().getPSDEFieldType().getSearchEditorType();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getRefPSDEId())) {
            this.refPSDataEntity = this.getPSDEField().getPSDataEntity().getPSSystem().getPSDataEntity(this.getRefPSDEId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFSearchFormItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEFSearchFormItem.getPSSYSIMAGEID());
        }
        super.onInit();
    }

    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295)
    public int getEditorWidth() {
        return this.nEditorWidth;
    }

    public String getCaption(String strLanguage) {
        String strCaption = this.getPSDEField().getLogicName(strLanguage);
        if (this.iPSSysDBValueFunc == null) {
            return StringHelper.format((String)"%1$s(%2$s)", (Object)strCaption, (Object)this.iPSDBValueOP.getCaption(true, strLanguage));
        }
        return StringHelper.format((String)"%1$s[%3$s](%2$s)", (Object)strCaption, (Object)this.iPSDBValueOP.getCaption(true, strLanguage), (Object)this.iPSSysDBValueFunc.getName());
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            return this.getPSDEFieldRuntime().getPSDEFieldType().getEditorType();
        }
        return this.strEditorType;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    public String getPSCodeListId() {
        if (!StringHelper.isNullOrEmpty((String)this.strPSCodeListId)) {
            return this.strPSCodeListId;
        }
        return this.iPSDEField.getCodeListId();
    }

    public String getValueItemName(IPSDEFormItem iPSDEFormItem) {
        return "";
    }

    public String getRefPSDEId() {
        return this.strRefPSDEId;
    }

    public String getRefPSDEName() throws Exception {
        if (this.getRefPSDE() == null) {
            return "";
        }
        return this.getRefPSDE().getName();
    }

    public String getRefPSDEACModeId() {
        return this.strRefPSDEACModeId;
    }

    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        return null;
    }

    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300)
    public int getEditorHeight() {
        return 0;
    }

    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    public String getRefLinkPSDEViewId() {
        return null;
    }

    public String getRefLinkPSDEViewName() {
        return null;
    }

    public String getItemHandlerType(IPSDEFormItem iPSDEFormItem) {
        if (iPSDEFormItem.getPSEditorType() != null) {
            if (StringHelper.compare((String)iPSDEFormItem.getEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEFormItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEFormItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEFormItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        return "";
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    public String getRefPSDEDataSetId() {
        return this.strRefPSDEDataSetId;
    }

    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    public int getEnableCond() {
        return 3;
    }

    public String getCreateDVT() {
        return "";
    }

    public String getCreateDV() {
        return "";
    }

    public String getUpdateDVT() {
        return "";
    }

    public String getUpdateDV() {
        return "";
    }

    public ObjectNode getItemParam(IPSDEFormItem iPSDEFormItem) throws Exception {
        return null;
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

    protected IPSDBValueOP getPSDBValueOP() {
        return this.iPSDBValueOP;
    }

    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    public String getPSSysValueRuleId() {
        return this.psDEFSearchFormItem.getPSSYSVALUERULEID();
    }

    public int getIgnoreInput() {
        return 0;
    }

    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
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
        return false;
    }

    protected boolean isMobileApp() {
        return this.bMobileApp;
    }

    public boolean isEnableResetItemName() {
        return false;
    }

    public String getResetItemName() {
        return null;
    }

    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    public String getUnitName() {
        return null;
    }

    public int getUnitNameWidth() {
        return 0;
    }

    public boolean isEnableUnitName() {
        return false;
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
        return null;
    }

    public String getRefActiveDataPSDELogicId() {
        return this.strRefActiveDataPSDELogicId;
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
}

