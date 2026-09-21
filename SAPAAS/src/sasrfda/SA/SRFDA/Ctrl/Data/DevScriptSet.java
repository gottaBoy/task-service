/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DevScriptSet
extends BaseDataEntity {
    public static final int SCRIPTFUNC_EXT_BASE = 1;
    public static final int SCRIPTFUNC_EXT_TREE = 128;
    public static final int SCRIPTFUNC_EXT_TREE_ADV = 2;
    public static final int SCRIPTFUNC_EXT_TABPANEL = 4;
    public static final int SCRIPTFUNC_EXT_GRID = 32;
    public static final int SCRIPTFUNC_EXT_GRID_ADV = 64;
    public static final int SCRIPTFUNC_SA_DPEX = 8;
    public static final int SCRIPTFUNC_SA_SPEX = 16;
    public static final int SCRIPTFUNC_EXT_DATAVIEW = 256;
    public static final int SCRIPTFUNC_ALL = Integer.MAX_VALUE;
    public static final int SCRIPTFUNC_EDITVIEW = 141;
    public static final int SCRIPTFUNC_GRIDVIEW = 125;
    public static final String TAG_DEVSCRIPTSETID = "DEVSCRIPTSETID";
    public static final String TAG_DEVSCRIPTSETNAME = "DEVSCRIPTSETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SCRIPTGROUP = "SCRIPTGROUP";
    public static final String TAG_RCODE = "RCODE";
    public static final String TAG_DCODE = "DCODE";
    public static final String TAG_CODEORDER = "CODEORDER";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public String getDEVSCRIPTSETID() {
        return this.GetParamStringValue(TAG_DEVSCRIPTSETID, "");
    }

    public void setDEVSCRIPTSETID(String strValue) {
        this.SetParamValue(TAG_DEVSCRIPTSETID, strValue);
    }

    public String getDEVSCRIPTSETNAME() {
        return this.GetParamStringValue(TAG_DEVSCRIPTSETNAME, "");
    }

    public void setDEVSCRIPTSETNAME(String strValue) {
        this.SetParamValue(TAG_DEVSCRIPTSETNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public int getSCRIPTGROUP() {
        return this.GetParamIntValue(TAG_SCRIPTGROUP, 0);
    }

    public void setSCRIPTGROUP(int strValue) {
        this.SetParamValue(TAG_SCRIPTGROUP, strValue);
    }

    public String getRCODE() {
        return this.GetParamStringValue(TAG_RCODE, "");
    }

    public void setRCODE(String strValue) {
        this.SetParamValue(TAG_RCODE, strValue);
    }

    public String getDCODE() {
        return this.GetParamStringValue(TAG_DCODE, "");
    }

    public void setDCODE(String strValue) {
        this.SetParamValue(TAG_DCODE, strValue);
    }

    public String getCODEORDER() {
        return this.GetParamStringValue(TAG_CODEORDER, "");
    }

    public void setCODEORDER(String strValue) {
        this.SetParamValue(TAG_CODEORDER, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

