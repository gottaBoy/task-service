/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class PPMWebPart
extends BaseDataEntity {
    public static final String TAG_PPMWEBPARTID = "PPMWEBPARTID";
    public static final String TAG_PPMWEBPARTNAME = "PPMWEBPARTNAME";
    public static final String TAG_WEBPARTID = "WEBPARTID";
    public static final String TAG_ROWID2 = "ROWID2";
    public static final String TAG_COLUMNID = "COLUMNID";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_PPMODELID = "PPMODELID";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_WEBPARTID_CHART = "CHART";

    public String getPPMWEBPARTNAME() {
        return this.GetParamStringValue(TAG_PPMWEBPARTNAME, "");
    }

    public String getPPMWEBPARTID() {
        return this.GetParamStringValue(TAG_PPMWEBPARTID, "");
    }

    public String getWEBPARTID() {
        return this.GetParamStringValue(TAG_WEBPARTID, "");
    }

    public String getPPMODELID() {
        return this.GetParamStringValue(TAG_PPMODELID, "");
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

    public void setPPMWEBPARTID(String strValue) {
        this.SetParamValue(TAG_PPMWEBPARTID, strValue);
    }

    public void setPPMWEBPARTNAME(String strValue) {
        this.SetParamValue(TAG_PPMWEBPARTNAME, strValue);
    }

    public void setWEBPARTID(String strValue) {
        this.SetParamValue(TAG_WEBPARTID, strValue);
    }

    public void setPPMODELID(String strValue) {
        this.SetParamValue(TAG_PPMODELID, strValue);
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

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getROWID2() {
        return this.GetParamIntValue(TAG_ROWID2, 0);
    }

    public int getCOLUMNID() {
        return this.GetParamIntValue(TAG_COLUMNID, 0);
    }

    public void setWEBPARTID(int nValue) {
        this.SetParamValue(TAG_WEBPARTID, nValue);
    }

    public void setROWID2(Object object) {
        this.SetParamValue(TAG_ROWID2, object);
    }

    public void setCOLUMNID(Object object) {
        this.SetParamValue(TAG_COLUMNID, object);
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

