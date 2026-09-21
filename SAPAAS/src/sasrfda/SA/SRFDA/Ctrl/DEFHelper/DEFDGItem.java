/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDGItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDGItem;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DEFDGItem
implements IDEFDGItem {
    protected IDEFHelper iDEFHelper = null;
    protected DEFDGItemConfig defDgItemConfig = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;

    @Override
    public CallResult Init(IDEFHelper iDEFHelper, DEFDGItemConfig defDgItemConfig, ISRFDAGlobalHelper globalHelperEx) {
        this.iDEFHelper = iDEFHelper;
        this.globalHelperEx = globalHelperEx;
        this.defDgItemConfig = defDgItemConfig;
        return new CallResult();
    }

    @Override
    public String GetItemFormat(DGModeDetail dgModeDetail) {
        String strItemFormat = this.OnGetItemFormat(dgModeDetail);
        return strItemFormat;
    }

    protected String OnGetItemFormat(DGModeDetail dgModeDetail) {
        if (dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDSITEMFORMAT())) {
            return dgModeDetail.getDSITEMFORMAT();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iDEFHelper.getDEField().getDSITEMFORMAT())) {
            return this.iDEFHelper.getDEField().getDSITEMFORMAT();
        }
        if (this.iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)this.iDEFHelper;
            return inheritDEFHelper.GetRelatedDEFHelper().getDGItem().GetItemFormat(dgModeDetail);
        }
        if (this.iDEFHelper.IsLinkDEField() && !this.iDEFHelper.IsPhisicalDEField()) {
            ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)this.iDEFHelper;
            return iLinkDEFHelper.GetRelatedDEFHelper().getDGItem().GetItemFormat(null);
        }
        if (this.defDgItemConfig.getDefaultItemFormat() && this.iDEFHelper.getDEField().getPRECISION2() >= 0) {
            return StringHelper.Format((String)"%%1$.%1$sf", (Object)this.iDEFHelper.getDEField().getPRECISION2());
        }
        return this.defDgItemConfig.getItemFormat();
    }

    @Override
    public String GetCaption(DGModeDetail dgModeDetail, String strLanguage) {
        return this.OnGetCaption(dgModeDetail, strLanguage);
    }

    protected String OnGetCaption(DGModeDetail dgModeDetail, String strLanguage) {
        if (dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLUMNCAPTION())) {
            return dgModeDetail.getDGCOLUMNCAPTION();
        }
        String strColumnGroup = this.iDEFHelper.getDEField().getDGCOLUMNCAPTION();
        if (StringHelper.IsNullOrEmpty((String)strColumnGroup)) {
            return this.iDEFHelper.getLogicName(strLanguage);
        }
        return strColumnGroup;
    }

    @Override
    public String GetCustom(DGModeDetail dgModeDetail) {
        return this.OnGetCustom(dgModeDetail);
    }

    protected String OnGetCustom(DGModeDetail dgModeDetail) {
        if (dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDSITEMCUSTOM())) {
            return dgModeDetail.getDSITEMCUSTOM();
        }
        String strDSItemCustom = this.iDEFHelper.getDEField().getDSITEMCUSTOM();
        if (!StringHelper.IsNullOrEmpty((String)strDSItemCustom)) {
            return strDSItemCustom;
        }
        if (this.iDEFHelper.getEncryptStorage() == 1) {
            return "SA.SRFDA.Ctrl.DataGrid.EncryptHashDSItem";
        }
        return this.defDgItemConfig.getCustom();
    }

    @Override
    public String GetAlign(DGModeDetail dgModeDetail) {
        return this.OnGetAlign(dgModeDetail);
    }

    protected String OnGetAlign(DGModeDetail dgModeDetail) {
        if (dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLUMNALIGN())) {
            return dgModeDetail.getDGCOLUMNALIGN();
        }
        String strDGColumnAlign = this.iDEFHelper.getDEField().getDGCOLUMNALIGN();
        if (!StringHelper.IsNullOrEmpty((String)strDGColumnAlign)) {
            return strDGColumnAlign;
        }
        return this.defDgItemConfig.getAlign();
    }

    @Override
    public String GetEditorParam(DGModeDetail dgModeDetail) {
        return this.OnGetEditorParam(dgModeDetail);
    }

    protected String OnGetEditorParam(DGModeDetail dgModeDetail) {
        if (dgModeDetail != null && !StringHelper.IsNullOrEmpty((String)dgModeDetail.getDGCOLEDITORPARAM())) {
            return dgModeDetail.getDGCOLEDITORPARAM();
        }
        return this.iDEFHelper.getDEField().getDGCOLEDITORPARAM();
    }

    @Override
    public String GetEditorStyle(DGModeDetail dgModeDetail) {
        return this.OnGetEditorStyle(dgModeDetail);
    }

    protected String OnGetEditorStyle(DGModeDetail dgModeDetail) {
        String strEditorStyle = "";
        if (dgModeDetail != null) {
            strEditorStyle = dgModeDetail.getDGCOLEDITOR();
        }
        if (!StringHelper.IsNullOrEmpty((String)strEditorStyle)) {
            return strEditorStyle;
        }
        strEditorStyle = this.iDEFHelper.getDEField().getDGCOLEDITOR();
        if (StringHelper.IsNullOrEmpty((String)strEditorStyle)) {
            strEditorStyle = this.defDgItemConfig.getEditorStyle();
        }
        if (StringHelper.IsNullOrEmpty((String)strEditorStyle)) {
            return this.iDEFHelper.GetFormItemStyle();
        }
        return strEditorStyle;
    }

    @Override
    public boolean isEnableEdit(DGModeDetail dgModeDetail) {
        return this.OnGetEnableEdit(dgModeDetail);
    }

    protected boolean OnGetEnableEdit(DGModeDetail dgModeDetail) {
        if (dgModeDetail != null) {
            return dgModeDetail.isDGCOLEDITABLE();
        }
        return this.iDEFHelper.getDEField().isDGCOLEDITABLE();
    }

    @Override
    public String GetDefaultValueType(DGModeDetail dgModeDetail) {
        return this.iDEFHelper.getDEField().getFORMDVT();
    }

    @Override
    public String GetDefaultValue(DGModeDetail dgModeDetail) {
        return this.iDEFHelper.getDEField().getFORMDV();
    }

    @Override
    public boolean isSortable(DGModeDetail dgModeDetail) {
        if (StringHelper.Compare((String)this.iDEFHelper.GetStdDataType(), (String)"TEXT", (boolean)true) == 0 && StringHelper.Compare((String)this.iDEFHelper.getDEHelper().GetDBType(), (String)"MSSQL", (boolean)true) == 0) {
            return false;
        }
        if (dgModeDetail != null) {
            return !dgModeDetail.getNOSORT();
        }
        return !this.iDEFHelper.getDEField().getNOSORT();
    }

    @Override
    public boolean isExclude() {
        return this.iDEFHelper.getDEField().getDGCOLEXCLUDE();
    }

    @Override
    public String GetFIUpdateMode(DGModeDetail dgModeDetail, String strFIUpdateMode) {
        String strFIUpdateMode2 = strFIUpdateMode;
        if (!StringHelper.IsNullOrEmpty((String)strFIUpdateMode2)) {
            return strFIUpdateMode2;
        }
        return this.iDEFHelper.getDEField().getDGFIUPDATENAME();
    }
}

