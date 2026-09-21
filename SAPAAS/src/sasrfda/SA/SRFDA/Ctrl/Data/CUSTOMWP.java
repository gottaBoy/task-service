/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class CUSTOMWP
extends BaseDataEntity {
    public static final String TAG_CUSTOMWPID = "CUSTOMWPID";
    public static final String TAG_CUSTOMWPNAME = "CUSTOMWPNAME";
    public static final String TAG_CUSTOMWPTYPE = "CUSTOMWPTYPE";
    public static final String TAG_ROWID = "ROWID";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_DEID = "DEID";

    public String getCUSTOMWPNAME() {
        return this.GetParamStringValue(TAG_CUSTOMWPNAME, "");
    }

    public String getCUSTOMWPID() {
        return this.GetParamStringValue(TAG_CUSTOMWPID, "");
    }

    public String getCUSTOMWPTYPE() {
        return this.GetParamStringValue(TAG_CUSTOMWPTYPE, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setCUSTOMWPID(String strValue) {
        this.SetParamValue(TAG_CUSTOMWPID, strValue);
    }

    public void setCUSTOMWPNAME(String strValue) {
        this.SetParamValue(TAG_CUSTOMWPNAME, strValue);
    }

    public void setCUSTOMWPTYPE(String strValue) {
        this.SetParamValue(TAG_CUSTOMWPTYPE, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getROWID() {
        return this.GetParamIntValue(TAG_ROWID, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setCUSTOMWPTYPE(int nValue) {
        this.SetParamValue(TAG_CUSTOMWPTYPE, nValue);
    }

    public void setROWID(int nValue) {
        this.SetParamValue(TAG_ROWID, nValue);
    }

    public void setCOLUMNID(int nValue) {
        this.SetParamValue(TAG_COLUMNID, nValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }
}

