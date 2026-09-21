/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFLogicTempl
extends BaseDataEntity {
    public static final String TAG_PSSFLOGICTEMPLID = "PSSFLOGICTEMPLID";
    public static final String TAG_PSSFLOGICTEMPLNAME = "PSSFLOGICTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String TAG_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_PSSFPUBCODEID = "PSSFPUBCODEID";
    public static final String TAG_PSSFPUBCODENAME = "PSSFPUBCODENAME";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLFILEPATH = "TEMPLFILEPATH";
    public static final String TAG_CHECKMODELONLY = "CHECKMODELONLY";
    public static final String TAG_REMOVEEMPTYFILE = "REMOVEEMPTYFILE";

    public final boolean isPSSFLOGICTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSFLOGICTEMPLID);
    }

    public final String getPSSFLOGICTEMPLID() {
        return this.GetParamStringValue(TAG_PSSFLOGICTEMPLID, "");
    }

    public final void setPSSFLOGICTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSFLOGICTEMPLID, strValue);
    }

    public final boolean isPSSFLOGICTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSFLOGICTEMPLNAME);
    }

    public final String getPSSFLOGICTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSFLOGICTEMPLNAME, "");
    }

    public final void setPSSFLOGICTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSFLOGICTEMPLNAME, strValue);
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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isPSVIEWLOGICTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEID);
    }

    public final String getPSVIEWLOGICTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEID, "");
    }

    public final void setPSVIEWLOGICTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEID, strValue);
    }

    public final boolean isPSVIEWLOGICTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPENAME);
    }

    public final String getPSVIEWLOGICTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPENAME, "");
    }

    public final void setPSVIEWLOGICTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPENAME, strValue);
    }

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
    }

    public final boolean isPSSFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSSFPUBCODEID);
    }

    public final String getPSSFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSSFPUBCODEID, "");
    }

    public final void setPSSFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSSFPUBCODEID, strValue);
    }

    public final boolean isPSSFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSSFPUBCODENAME);
    }

    public final String getPSSFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSSFPUBCODENAME, "");
    }

    public final void setPSSFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSFPUBCODENAME, strValue);
    }

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.IsParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.GetParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.IsParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.GetParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE4, strValue);
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

    public final boolean isTEMPLFILEPATHNull() {
        return this.IsParamNull(TAG_TEMPLFILEPATH);
    }

    public final String getTEMPLFILEPATH() {
        return this.GetParamStringValue(TAG_TEMPLFILEPATH, "");
    }

    public final void setTEMPLFILEPATH(String strValue) {
        this.SetParamValue(TAG_TEMPLFILEPATH, strValue);
    }

    public final boolean isCHECKMODELONLYNull() {
        return this.IsParamNull(TAG_CHECKMODELONLY);
    }

    public final boolean getCHECKMODELONLY() {
        return this.GetParamIntValue(TAG_CHECKMODELONLY, 0) == 1;
    }

    public final void setCHECKMODELONLY(boolean bValue) {
        this.SetParamValue(TAG_CHECKMODELONLY, bValue ? 1 : 0);
    }

    public final boolean isREMOVEEMPTYFILENull() {
        return this.IsParamNull(TAG_REMOVEEMPTYFILE);
    }

    public final boolean getREMOVEEMPTYFILE() {
        return this.GetParamIntValue(TAG_REMOVEEMPTYFILE, 0) == 1;
    }

    public final void setREMOVEEMPTYFILE(boolean bValue) {
        this.SetParamValue(TAG_REMOVEEMPTYFILE, bValue ? 1 : 0);
    }
}

