/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlParamImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSMDAjaxControlParamImpl
extends PSAjaxControlParamImpl
implements IPSMDAjaxControlParam {
    private static final Log log = LogFactory.getLog(PSMDAjaxControlParamImpl.class);
    protected String strPSDEDataSetId = "";
    protected String strPSDEDataExportId = "";
    protected String strPSDEDataImportId = "";
    protected String strActiveDataPSDELogicId = "";
    protected String strCustomCond = "";
    private Integer nEditMode = null;
    private Boolean bActiveDataMode = null;
    protected String strActiveDataField = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEDataSetId(this.getPSDEViewCtrlData().getPSDEDATASETID());
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDEViewCtrlData().getPSDEDATASETID())) {
            this.setCustomCond(this.getPSDEViewCtrlData().getCUSTOMCOND());
        }
        this.setPSDEDataExportId(this.getPSDEViewCtrlData().getPSDEDATAEXPID());
        this.setPSDEDataImportId(this.getPSDEViewCtrlData().getPSDEDATAIMPID());
        this.setActiveDataPSDELogicId(this.getPSDEViewCtrlData().getADPSDELOGICID());
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEditMode(this.psDEViewCtrl.GetParamIntValue("CTRLPARAM6", 0));
        }
    }

    @Override
    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    public void setPSDEDataSetId(String strPSDEDataSetId) {
        this.strPSDEDataSetId = strPSDEDataSetId;
    }

    public String getDEDataSetId() {
        return this.getPSDEDataSetId();
    }

    @Override
    public String getPSDEDataExportId() {
        return this.strPSDEDataExportId;
    }

    public void setPSDEDataExportId(String strPSDEDataExportId) {
        this.strPSDEDataExportId = strPSDEDataExportId;
    }

    public String getDEDataExportId() {
        return this.getPSDEDataExportId();
    }

    public void setActiveDataPSDELogicId(String strActiveDataPSDELogicId) {
        this.strActiveDataPSDELogicId = strActiveDataPSDELogicId;
    }

    @Override
    public String getActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    @Override
    public String getPSDEDataImportId() {
        return this.strPSDEDataImportId;
    }

    public void setPSDEDataImportId(String strPSDEDataImportId) {
        this.strPSDEDataImportId = strPSDEDataImportId;
    }

    @Override
    public String getCustomCond() {
        return this.strCustomCond;
    }

    public void setCustomCond(String strCustomCond) {
        this.strCustomCond = strCustomCond;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSMDAjaxControlParam) {
            IPSMDAjaxControlParam iPSMDAjaxControlParam = (IPSMDAjaxControlParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSMDAjaxControlParam.getPSDEDataSetId())) {
                this.setPSDEDataSetId(iPSMDAjaxControlParam.getPSDEDataSetId());
                this.setCustomCond(iPSMDAjaxControlParam.getCustomCond());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSMDAjaxControlParam.getPSDEDataExportId())) {
                this.setPSDEDataExportId(iPSMDAjaxControlParam.getPSDEDataExportId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSMDAjaxControlParam.getPSDEDataImportId())) {
                this.setPSDEDataImportId(iPSMDAjaxControlParam.getPSDEDataImportId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSMDAjaxControlParam.getActiveDataPSDELogicId())) {
                this.setActiveDataPSDELogicId(iPSMDAjaxControlParam.getActiveDataPSDELogicId());
            }
            if (iPSMDAjaxControlParam.getEditMode() != null) {
                this.setEditMode(iPSMDAjaxControlParam.getEditMode());
            }
            if (iPSMDAjaxControlParam.isActiveDataMode() != null) {
                this.setActiveDataMode(iPSMDAjaxControlParam.isActiveDataMode());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSMDAjaxControlParam.getActiveDataField())) {
                this.setActiveDataField(iPSMDAjaxControlParam.getActiveDataField());
            }
        }
    }

    @Override
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getDEDataSetId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataSet(this.getDEDataSetId());
    }

    @Override
    public IPSDEDataExport getPSDEDataExport() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getDEDataExportId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataExport(this.getDEDataExportId());
    }

    @Override
    public IPSDELogic getActiveDataPSDELogic() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getActiveDataPSDELogicId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDELogic(this.getActiveDataPSDELogicId());
    }

    @Override
    public Integer getEditMode() {
        return this.nEditMode;
    }

    public void setEditMode(Integer nEditMode) {
        this.nEditMode = nEditMode;
    }

    @Override
    public IPSDEDataImport getPSDEDataImport() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEDataImportId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataImport(this.getPSDEDataImportId());
    }

    @Override
    public Boolean isActiveDataMode() {
        return this.bActiveDataMode;
    }

    public void setActiveDataMode(Boolean bActiveDataMode) {
        this.bActiveDataMode = bActiveDataMode;
    }

    @Override
    public String getActiveDataField() {
        return this.strActiveDataField;
    }

    public void setActiveDataField(String strActiveDataField) {
        this.strActiveDataField = strActiveDataField;
    }
}

