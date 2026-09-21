/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DGModeDetail
extends BaseDataEntity {
    public static final String TAG_DGMODEDETAILID = "DGMODEDETAILID";
    public static final String TAG_DGMODEDETAILNAME = "DGMODEDETAILNAME";
    public static final String TAG_DGCOLUMNALIGN = "DGCOLUMNALIGN";
    public static final String TAG_DSITEMFORMAT = "DSITEMFORMAT";
    public static final String TAG_DGCOLUMNCAPTION = "DGCOLUMNCAPTION";
    public static final String TAG_DSITEMCUSTOM = "DSITEMCUSTOM";
    public static final String TAG_DSITEMGROUP = "DSITEMGROUP";
    public static final String TAG_DGCOLRENDER = "DGCOLRENDER";
    public static final String TAG_DGCOLRENDERCUSTOM = "DGCOLRENDERCUSTOM";
    public static final String TAG_DGCOLRENDERPARAM = "DGCOLRENDERPARAM";
    public static final String TAG_ISDGCOLEDITABLE = "ISDGCOLEDITABLE";
    public static final String TAG_ISDISABLE = "ISDISABLE";
    public static final String TAG_ISALLOWEMPTY = "ISALLOWEMPTY";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_DGCOLEDITOR = "DGCOLEDITOR";
    public static final String TAG_DGCOLEDITORPARAM = "DGCOLEDITORPARAM";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_DGCOLVALIDCOND = "DGCOLVALIDCOND";
    public static final String TAG_VALUERULE = "VALUERULE";
    public static final String TAG_CUSTOMVALUERULE = "CUSTOMVALUERULE";
    public static final String TAG_VALUERULEINFO = "VALUERULEINFO";
    public static final String TAG_DGCOLEDITORCUSTOM = "DGCOLEDITORCUSTOM";

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public String getDGCOLUMNCAPTION() {
        return this.GetParamStringValue(TAG_DGCOLUMNCAPTION, "");
    }

    public String getDSITEMCUSTOM() {
        return this.GetParamStringValue(TAG_DSITEMCUSTOM, "");
    }

    public String getDSITEMGROUP() {
        return this.GetParamStringValue(TAG_DSITEMGROUP, "");
    }

    public String getDGCOLUMNALIGN() {
        return this.GetParamStringValue(TAG_DGCOLUMNALIGN, "");
    }

    public String getDGCOLEDITOR() {
        return this.GetParamStringValue(TAG_DGCOLEDITOR, "");
    }

    public String getDGCOLEDITORPARAM() {
        return this.GetParamStringValue(TAG_DGCOLRENDERPARAM, "");
    }

    public String getDGCOLVALIDCOND() {
        return this.GetParamStringValue(TAG_DGCOLVALIDCOND, "");
    }

    public String getDGCOLRENDER() {
        return this.GetParamStringValue(TAG_DGCOLRENDER, "");
    }

    public String getDGCOLRENDERCUSTOM() {
        return this.GetParamStringValue(TAG_DGCOLRENDERCUSTOM, "");
    }

    public String getDGCOLRENDERPARAM() {
        return this.GetParamStringValue(TAG_DGCOLRENDERPARAM, "");
    }

    public boolean isDGCOLEDITABLE() {
        return this.GetParamIntValue(TAG_ISDGCOLEDITABLE, 0) == 1;
    }

    public boolean isDISABLE() {
        return this.GetParamIntValue(TAG_ISDISABLE, 0) == 1;
    }

    public boolean isALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ISALLOWEMPTY, 1) == 1;
    }

    public String getVALUERULE() {
        return this.GetParamStringValue(TAG_VALUERULE, "");
    }

    public String getCUSTOMVALUERULE() {
        return this.GetParamStringValue(TAG_CUSTOMVALUERULE, "");
    }

    public String getVALUERULEINFO() {
        return this.GetParamStringValue(TAG_VALUERULEINFO, "");
    }

    public String getDSITEMFORMAT() {
        return this.GetParamStringValue(TAG_DSITEMFORMAT, "");
    }

    public boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public boolean isDGCOLEDITORCUSTOMNull() {
        return this.IsParamNull(TAG_DGCOLEDITORCUSTOM);
    }

    public String getDGCOLEDITORCUSTOM() {
        return this.GetParamStringValue(TAG_DGCOLEDITORCUSTOM, "");
    }

    public void setDGCOLEDITORCUSTOM(String strValue) {
        this.SetParamValue(TAG_DGCOLEDITORCUSTOM, strValue);
    }
}

