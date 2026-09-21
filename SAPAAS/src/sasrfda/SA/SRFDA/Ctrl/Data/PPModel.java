/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class PPModel
extends BaseDataEntity {
    public static final String TAG_PPMODELID = "PPMODELID";
    public static final String TAG_PPMODELNAME = "PPMODELNAME";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_PORTALPAGEID = "PORTALPAGEID";
    public static final String TAG_PORTALPAGENAME = "PORTALPAGENAME";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PPMVERSION = "PPMVERSION";
    public static final String TAG_PPMODEL = "PPMODEL";
    public static final String TAG_PPMODELDETAIL = "PPMODELDETAIL";
    public static final String TAG_ENABLECTX = "ENABLECTX";

    public String getPPMODELID() {
        return this.GetParamStringValue(TAG_PPMODELID, "").trim();
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "").trim();
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public String getPPMODELNAME() {
        return this.GetParamStringValue(TAG_PPMODELNAME, "");
    }

    public String getPORTALPAGEID() {
        return this.GetParamStringValue(TAG_PORTALPAGEID, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getPORTALPAGENAME() {
        return this.GetParamStringValue(TAG_PORTALPAGENAME, "");
    }

    public String getPPMODEL() {
        return this.GetParamStringValue(TAG_PPMODEL, "50%;50%;").trim();
    }

    public void setPPMODEL(String strValue) {
        this.SetParamValue(TAG_PPMODEL, strValue);
    }

    public String getPPMODELDETAIL() {
        return this.GetParamStringValue(TAG_PPMODELDETAIL, "");
    }

    public void setPPMODELDETAIL(String strValue) {
        this.SetParamValue(TAG_PPMODELDETAIL, strValue);
    }

    public void setPPMODELID(String strValue) {
        this.SetParamValue(TAG_PPMODELID, strValue);
    }

    public void setPPMODELNAME(String strValue) {
        this.SetParamValue(TAG_PPMODELNAME, strValue);
    }

    public void setPORTALPAGEID(String strValue) {
        this.SetParamValue(TAG_PORTALPAGEID, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setPORTALPAGENAME(String strValue) {
        this.SetParamValue(TAG_PORTALPAGENAME, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getPPMVERSION() {
        return this.GetParamIntValue(TAG_PPMVERSION, 1);
    }

    public void setPPMVERSION(int nValue) {
        this.SetParamValue(TAG_PPMVERSION, nValue);
    }

    public boolean isENABLECTXNull() {
        return this.IsParamNull(TAG_ENABLECTX);
    }

    public boolean getENABLECTX() {
        return this.GetParamIntValue(TAG_ENABLECTX, 0) == 1;
    }

    public void setENABLECTX(boolean bValue) {
        this.SetParamValue(TAG_ENABLECTX, bValue ? 1 : 0);
    }
}

