/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewType
extends BaseDataEntity {
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_APPVIEWOBJ = "APPVIEWOBJ";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_VIEWDEID = "VIEWDEID";
    public static final String TAG_VIEWDENAME = "VIEWDENAME";
    public static final String TAG_DEVIEWOBJ = "DEVIEWOBJ";
    public static final String TAG_DEVIEWMODE = "DEVIEWMODE";
    public static final String TAG_EMBEDVIEWFLAG = "EMBEDVIEWFLAG";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_ENABLEDYNATOOL = "ENABLEDYNATOOL";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_TITLE = "TITLE";

    public final boolean isPSVIEWTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWTYPEID);
    }

    public final String getPSVIEWTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWTYPEID, "");
    }

    public final void setPSVIEWTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPEID, strValue);
    }

    public final boolean isPSVIEWTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWTYPENAME);
    }

    public final String getPSVIEWTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWTYPENAME, "");
    }

    public final void setPSVIEWTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isAPPVIEWOBJNull() {
        return this.IsParamNull(TAG_APPVIEWOBJ);
    }

    public final String getAPPVIEWOBJ() {
        return this.GetParamStringValue(TAG_APPVIEWOBJ, "");
    }

    public final void setAPPVIEWOBJ(String strValue) {
        this.SetParamValue(TAG_APPVIEWOBJ, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isVIEWDEIDNull() {
        return this.IsParamNull(TAG_VIEWDEID);
    }

    public final String getVIEWDEID() {
        return this.GetParamStringValue(TAG_VIEWDEID, "");
    }

    public final void setVIEWDEID(String strValue) {
        this.SetParamValue(TAG_VIEWDEID, strValue);
    }

    public final boolean isVIEWDENAMENull() {
        return this.IsParamNull(TAG_VIEWDENAME);
    }

    public final String getVIEWDENAME() {
        return this.GetParamStringValue(TAG_VIEWDENAME, "");
    }

    public final void setVIEWDENAME(String strValue) {
        this.SetParamValue(TAG_VIEWDENAME, strValue);
    }

    public final boolean isDEVIEWOBJNull() {
        return this.IsParamNull(TAG_DEVIEWOBJ);
    }

    public final String getDEVIEWOBJ() {
        return this.GetParamStringValue(TAG_DEVIEWOBJ, "");
    }

    public final void setDEVIEWOBJ(String strValue) {
        this.SetParamValue(TAG_DEVIEWOBJ, strValue);
    }

    public final boolean isDEVIEWMODENull() {
        return this.IsParamNull(TAG_DEVIEWMODE);
    }

    public final boolean getDEVIEWMODE() {
        return this.GetParamIntValue(TAG_DEVIEWMODE, 0) == 1;
    }

    public final void setDEVIEWMODE(boolean bValue) {
        this.SetParamValue(TAG_DEVIEWMODE, bValue ? 1 : 0);
    }

    public final boolean isEMBEDVIEWFLAGNull() {
        return this.IsParamNull(TAG_EMBEDVIEWFLAG);
    }

    public final boolean getEMBEDVIEWFLAG() {
        return this.GetParamIntValue(TAG_EMBEDVIEWFLAG, 0) == 1;
    }

    public final void setEMBEDVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_EMBEDVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isENABLEDYNATOOLNull() {
        return this.IsParamNull(TAG_ENABLEDYNATOOL);
    }

    public final boolean getENABLEDYNATOOL() {
        return this.GetParamIntValue(TAG_ENABLEDYNATOOL, 0) == 1;
    }

    public final void setENABLEDYNATOOL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNATOOL, bValue ? 1 : 0);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }
}

