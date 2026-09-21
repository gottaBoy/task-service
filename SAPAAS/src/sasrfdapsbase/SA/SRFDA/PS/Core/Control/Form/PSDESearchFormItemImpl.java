/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDESearchFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDESearchFormItemImpl
extends PSDEFormItemImpl
implements IPSDESearchFormItem {
    private static final Log log = LogFactory.getLog(PSDESearchFormItemImpl.class);
    private IPSDEFSearchMode iPSDEFSearchMode = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFID())) {
            this.iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.psDEFormDetail.getPSDEFID(), false);
        }
        super.onInit();
    }

    @Override
    protected void preparePSDEFFormItem() throws Exception {
        if (this.getPSDEField() != null) {
            if (StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSDEFSFITEMID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u641c\u7d22\u6a21\u5f0f"));
            }
            this.iPSDEFSearchMode = this.getPSDEField().getPSDEFSearchMode(this.psDEFormDetail.getPSDEFSFITEMID());
            this.setPSDEFFormItem(this.iPSDEFSearchMode.getPSDEFFormItem(this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp() ? "MOBILEDEFAULT" : "DEFAULT"));
        }
    }

    @Override
    protected void prepareDataItem() throws Exception {
        super.prepareDataItem();
        this.psDataItemImpl.setName(this.getName());
        String strValueFormat = this.psDEFormDetail.getVALUEFORMAT();
        if (this.iPSDEFSearchMode != null && this.iPSDEFSearchMode.getPSSysDBValueFunc() != null) {
            this.psDataItemImpl.setDataType(this.iPSDEFSearchMode.getPSSysDBValueFunc().getOutputStdDataType());
            this.psDataItemImpl.setFormat(strValueFormat);
            return;
        }
        boolean bUseDTO = false;
        if (this.getPSDEForm().getPSAppView() != null && this.getPSDEForm().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSDEForm().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (StringHelper.IsNullOrEmpty((String)strValueFormat) && this.getPSDEFFormItem() != null) {
            strValueFormat = !bUseDTO ? this.getPSDEFFormItem().getValueFormat() : this.getPSDEFFormItem().getOriginValueFormat();
        }
        if (StringHelper.IsNullOrEmpty((String)strValueFormat) && bUseDTO && this.getPSAppDEField() != null) {
            strValueFormat = this.getPSAppDEField().getValueFormat();
        }
        if (this.getPSDEField() != null) {
            this.psDataItemImpl.setDataType(this.getPSDEField().getStdDataType());
            this.psDataItemImpl.setFormat(strValueFormat);
        }
    }

    @Override
    public double getItemWidth() {
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        return super.getRefPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f")
    public IPSDEFSearchMode getPSDEFSearchMode() {
        return this.iPSDEFSearchMode;
    }

    @Override
    public int getStdDataType() {
        if (this.getPSDEFSearchMode() != null) {
            return this.getPSDEFSearchMode().getStdDataType();
        }
        return super.getStdDataType();
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        String strValue = super.getEditorParam(strParam, strDefault);
        if (StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null && StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0) {
            String strValue2 = super.getEditorParam(strParam, null);
            if (strValue2 != null) {
                return strValue2;
            }
            if (this.getPSDEFSearchMode() != null && StringHelper.Compare((String)strParam, (String)"DEFAULTVALUETYPE", (boolean)false) == 0) {
                if (this.getPSDEFSearchMode().isArray()) {
                    return "SIMPLES";
                }
                return "SIMPLE";
            }
            return strValue;
        }
        return strValue;
    }
}

