/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewTypeCtrl
extends BaseDataEntity {
    public static final String CTRLTYPE_TOOLBAR = "TOOLBAR";
    public static final String CTRLTYPE_GRID = "GRID";
    public static final String CTRLTYPE_FORM = "FORM";
    public static final String CTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String CTRLTYPE_DRBAR = "DRBAR";
    public static final String CTRLTYPE_VIEWPANEL = "VIEWPANEL";
    public static final String CTRLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String TAG_PSVTCTRLID = "PSVTCTRLID";
    public static final String TAG_PSVTCTRLNAME = "PSVTCTRLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_CTRLTYPE = "CTRLTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSACHANDLERID = "PSSYSACHANDLERID";
    public static final String TAG_PSSYSACHANDLERNAME = "PSSYSACHANDLERNAME";
    public static final String TAG_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String TAG_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_ENABLEDYNATOOL = "ENABLEDYNATOOL";
    public static final String TAG_CTRLPARAM = "CTRLPARAM";
    public static final String TAG_CTRLPARAM2 = "CTRLPARAM2";
    public static final String TAG_CTRLPARAM3 = "CTRLPARAM3";
    public static final String TAG_CTRLPARAM4 = "CTRLPARAM4";
    public static final String TAG_CTRLPARAM5 = "CTRLPARAM5";
    public static final String TAG_CTRLPARAM6 = "CTRLPARAM6";
    public static final String TAG_CTRLPARAM7 = "CTRLPARAM7";
    public static final String TAG_CTRLPARAM8 = "CTRLPARAM8";
    public static final String TAG_CTRLPARAM9 = "CTRLPARAM9";
    public static final String TAG_CTRLPARAM10 = "CTRLPARAM10";
    public static final String TAG_CTRLPARAM11 = "CTRLPARAM11";
    public static final String TAG_CTRLPARAM12 = "CTRLPARAM12";

    public final boolean isPSVTCTRLIDNull() {
        return this.IsParamNull(TAG_PSVTCTRLID);
    }

    public final String getPSVTCTRLID() {
        return this.GetParamStringValue(TAG_PSVTCTRLID, "");
    }

    public final void setPSVTCTRLID(String strValue) {
        this.SetParamValue(TAG_PSVTCTRLID, strValue);
    }

    public final boolean isPSVTCTRLNAMENull() {
        return this.IsParamNull(TAG_PSVTCTRLNAME);
    }

    public final String getPSVTCTRLNAME() {
        return this.GetParamStringValue(TAG_PSVTCTRLNAME, "");
    }

    public final void setPSVTCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PSVTCTRLNAME, strValue);
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

    public final boolean isCTRLTYPENull() {
        return this.IsParamNull(TAG_CTRLTYPE);
    }

    public final String getCTRLTYPE() {
        return this.GetParamStringValue(TAG_CTRLTYPE, "");
    }

    public final void setCTRLTYPE(String strValue) {
        this.SetParamValue(TAG_CTRLTYPE, strValue);
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

    public final boolean isPSSYSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSYSACHANDLERID);
    }

    public final String getPSSYSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSSYSACHANDLERID, "");
    }

    public final void setPSSYSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSYSACHANDLERID, strValue);
    }

    public final boolean isPSSYSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSYSACHANDLERNAME);
    }

    public final String getPSSYSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSYSACHANDLERNAME, "");
    }

    public final void setPSSYSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSACHANDLERNAME, strValue);
    }

    public final boolean isPSSYSTOOLBARIDNull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARID);
    }

    public final String getPSSYSTOOLBARID() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARID, "");
    }

    public final void setPSSYSTOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARID, strValue);
    }

    public final boolean isPSSYSTOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARNAME);
    }

    public final String getPSSYSTOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARNAME, "");
    }

    public final void setPSSYSTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARNAME, strValue);
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

    public final boolean isENABLEDYNATOOLNull() {
        return this.IsParamNull(TAG_ENABLEDYNATOOL);
    }

    public final boolean getENABLEDYNATOOL() {
        return this.GetParamIntValue(TAG_ENABLEDYNATOOL, 0) == 1;
    }

    public final void setENABLEDYNATOOL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNATOOL, bValue ? 1 : 0);
    }
}

