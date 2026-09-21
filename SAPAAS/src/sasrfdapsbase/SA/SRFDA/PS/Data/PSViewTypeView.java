/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewTypeView
extends BaseDataEntity {
    public static final String DEFVIEWTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String DEFVIEWTYPE_EDITVIEW = "EDITVIEW";
    public static final String DEFVIEWTYPE_INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";
    public static final String DEFVIEWTYPE_FORMPICKUPVIEW = "FORMPICKUPVIEW";
    public static final String DEFVIEWTYPE_MPICKUPVIEW = "MPICKUPVIEW";
    public static final String DEFVIEWTYPE_MDATAVIEW = "MDATAVIEW";
    public static final String DEFVIEWTYPE_WFEDITVIEW = "WFEDITVIEW";
    public static final String DEFVIEWTYPE_WFMDATAVIEW = "WFMDATAVIEW";
    public static final String DEFVIEWTYPE_REDIRECTVIEW = "REDIRECTVIEW";
    public static final String TAG_PSVTRVID = "PSVTRVID";
    public static final String TAG_PSVTRVNAME = "PSVTRVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DEFVIEWTYPE = "DEFVIEWTYPE";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_DYNADEFVIEWTYPE = "DYNADEFVIEWTYPE";
    public static final String TAG_ENABLEDYNATOOL = "ENABLEDYNATOOL";

    public final boolean isPSVTRVIDNull() {
        return this.IsParamNull(TAG_PSVTRVID);
    }

    public final String getPSVTRVID() {
        return this.GetParamStringValue(TAG_PSVTRVID, "");
    }

    public final void setPSVTRVID(String strValue) {
        this.SetParamValue(TAG_PSVTRVID, strValue);
    }

    public final boolean isPSVTRVNAMENull() {
        return this.IsParamNull(TAG_PSVTRVNAME);
    }

    public final String getPSVTRVNAME() {
        return this.GetParamStringValue(TAG_PSVTRVNAME, "");
    }

    public final void setPSVTRVNAME(String strValue) {
        this.SetParamValue(TAG_PSVTRVNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isDEFVIEWTYPENull() {
        return this.IsParamNull(TAG_DEFVIEWTYPE);
    }

    public final String getDEFVIEWTYPE() {
        return this.GetParamStringValue(TAG_DEFVIEWTYPE, "");
    }

    public final void setDEFVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_DEFVIEWTYPE, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isDYNADEFVIEWTYPENull() {
        return this.IsParamNull(TAG_DYNADEFVIEWTYPE);
    }

    public final String getDYNADEFVIEWTYPE() {
        return this.GetParamStringValue(TAG_DYNADEFVIEWTYPE, "");
    }

    public final void setDYNADEFVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_DYNADEFVIEWTYPE, strValue);
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

