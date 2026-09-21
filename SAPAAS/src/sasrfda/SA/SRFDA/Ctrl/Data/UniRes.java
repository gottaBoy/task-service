/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class UniRes
extends BaseDataEntity {
    public static final String TAG_UNIRESID = "UNIRESID";
    public static final String TAG_UNIRESNAME = "UNIRESNAME";
    public static final String TAG_UNIRESTYPE = "UNIRESTYPE";
    public static final String TAG_UNIRESPATH = "UNIRESPATH";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_ISALLOW = "ISALLOW";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISMODELSTYLE = "ISMODELSTYLE";
    public static final String TAG_WINDOWSTYLE = "WINDOWSTYLE";
    public static final String TAG_WTPARAM = "WTPARAM";
    public static final String TAG_UNIRESPARAM = "UNIRESPARAM";
    public static final String TAG_UNIRESTEMPLID = "UNIRESTEMPLID";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_UDVERSION = "UDVERSION";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_UNIRESTYPE_CUSTOM = "CUSTOM";
    public static final String TAG_UNIRESTYPE_PAGE = "PAGE";
    public static final String TAG_UNIRESTYPE_REPORT = "REPORT";
    public static final String TAG_UNIRESTYPE_DEDATA = "DEDATA";

    public String getUNIRESID() {
        return this.GetParamStringValue(TAG_UNIRESID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getUNIRESNAME() {
        return this.GetParamStringValue(TAG_UNIRESNAME, "");
    }

    public String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
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

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getWINDOWSTYLE() {
        return this.GetParamStringValue(TAG_WINDOWSTYLE, "");
    }

    public String getWTPARAM() {
        return this.GetParamStringValue(TAG_WTPARAM, "");
    }

    public String getUNIRESPARAM() {
        return this.GetParamStringValue(TAG_UNIRESPARAM, "");
    }

    public String getTOOLBAR() {
        return this.GetParamStringValue(TAG_TOOLBAR, "");
    }

    public void setUNIRESID(String strValue) {
        this.SetParamValue(TAG_UNIRESID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_UNIRESNAME, strValue);
    }

    public void setUNIRESPATH(String strValue) {
        this.SetParamValue(TAG_UNIRESPATH, strValue);
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

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setWINDOWSTYLE(String strValue) {
        this.SetParamValue(TAG_WINDOWSTYLE, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isALLOW() {
        return this.GetParamIntValue(TAG_ISALLOW, 0) == 1;
    }

    public void setMODELSTYLE(boolean value) {
        this.SetParamValue(TAG_ISMODELSTYLE, value ? 1 : 0);
    }

    public int getUNIRESTYPE() {
        return this.GetParamIntValue(TAG_UNIRESTYPE, 0);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setUNIRESTYPE(int nValue) {
        this.SetParamValue(TAG_UNIRESTYPE, nValue);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public int getUDVERSION() {
        return this.GetParamIntValue(TAG_UDVERSION, 1);
    }

    public void setUDVERSION(int nValue) {
        this.SetParamValue(TAG_UDVERSION, nValue);
    }
}

