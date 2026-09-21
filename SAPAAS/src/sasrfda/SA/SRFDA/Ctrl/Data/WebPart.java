/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class WebPart
extends BaseDataEntity {
    public static final String TAG_WEBPARTID = "WEBPARTID";
    public static final String TAG_WEBPARTNAME = "WEBPARTNAME";
    public static final String TAG_WEBPARTTYPE = "WEBPARTTYPE";
    public static final String TAG_ROWID2 = "ROWID2";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_REFRESHTIME = "REFRESHTIME";
    public static final String TAG_WEBPARTTYPE_CHART = "CHART";
    public static final String TAG_WEBPARTTYPE_LIST = "LIST";
    public static final String TAG_WEBPARTTYPE_CUSTOMWP = "CUSTOMWP";
    public static final String TAG_CAPLANRESID = "CAPLANRESID";
    public static final String TAG_CAPLANRESNAME = "CAPLANRESNAME";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    public static final String TAG_USERDATA5 = "USERDATA5";
    public static final String TAG_USERDATA6 = "USERDATA6";
    public static final String TAG_USERDATA7 = "USERDATA7";
    public static final String TAG_USERDATA8 = "USERDATA8";

    public String getWEBPARTNAME() {
        return this.GetParamStringValue(TAG_WEBPARTNAME, "");
    }

    public String getWEBPARTID() {
        return this.GetParamStringValue(TAG_WEBPARTID, "");
    }

    public String getWEBPARTTYPE() {
        return this.GetParamStringValue(TAG_WEBPARTTYPE, "");
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

    public String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public int getPARAM4() {
        return this.GetParamIntValue(TAG_PARAM4, 0);
    }

    public void setWEBPARTID(String strValue) {
        this.SetParamValue(TAG_WEBPARTID, strValue);
    }

    public void setWEBPARTNAME(String strValue) {
        this.SetParamValue(TAG_WEBPARTNAME, strValue);
    }

    public void setWEBPARTTYPE(String strValue) {
        this.SetParamValue(TAG_WEBPARTTYPE, strValue);
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

    public void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getROWID2() {
        return this.GetParamIntValue(TAG_ROWID2, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setWEBPARTTYPE(int nValue) {
        this.SetParamValue(TAG_WEBPARTTYPE, nValue);
    }

    public void setROWID2(int nValue) {
        this.SetParamValue(TAG_ROWID2, nValue);
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

    public int getREFRESHTIME() {
        return this.GetParamIntValue(TAG_REFRESHTIME, 0);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public void setREFRESHTIME(int nValue) {
        this.SetParamValue(TAG_REFRESHTIME, nValue);
    }

    public int getUSERDATA5() {
        return this.GetParamIntValue(TAG_USERDATA5, 0);
    }

    public int getUSERDATA6() {
        return this.GetParamIntValue(TAG_USERDATA6, 0);
    }

    public void setUSERDATA6(int strValue) {
        this.SetParamValue(TAG_USERDATA6, strValue);
    }

    public String getUSERDATA7() {
        return this.GetParamStringValue(TAG_USERDATA7, "");
    }

    public void setUSERDATA7(String strValue) {
        this.SetParamValue(TAG_USERDATA7, strValue);
    }

    public String getUSERDATA8() {
        return this.GetParamStringValue(TAG_USERDATA8, "");
    }

    public void setUSERDATA8(String strValue) {
        this.SetParamValue(TAG_USERDATA8, strValue);
    }

    public boolean isCAPLANRESIDNull() {
        return this.IsParamNull(TAG_CAPLANRESID);
    }

    public String getCAPLANRESID() {
        return this.GetParamStringValue(TAG_CAPLANRESID, "");
    }

    public void setCAPLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPLANRESID, strValue);
    }

    public boolean isCAPLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPLANRESNAME);
    }

    public String getCAPLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPLANRESNAME, "");
    }

    public void setCAPLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPLANRESNAME, strValue);
    }
}

