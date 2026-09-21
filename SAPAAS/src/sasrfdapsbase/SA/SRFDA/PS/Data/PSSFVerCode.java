/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFVerCode
extends BaseDataEntity {
    public static final int VALIDFLAG_0 = 0;
    public static final int VALIDFLAG_1 = 1;
    public static final int VALIDFLAG_2 = 2;
    public static final String TAG_PSSFVERCODEID = "PSSFVERCODEID";
    public static final String TAG_PSSFVERCODENAME = "PSSFVERCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String TAG_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String TAG_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String TAG_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODETEMPL = "CODETEMPL";
    public static final String TAG_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String TAG_TYPECODE = "TYPECODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_FILEEXT = "FILEEXT";
    public static final String TAG_ENABLECUSTOMTYPECODE = "ENABLECUSTOMTYPECODE";
    public static final String TAG_CUSTOMTYPECODE = "CUSTOMTYPECODE";
    public static final String TAG_ENABLECUSTOMFILENAME = "ENABLECUSTOMFILENAME";
    public static final String TAG_CUSTOMTYPECODEDESC = "CUSTOMTYPECODEDESC";
    public static final String TAG_REALPSSFSTYLEID = "REALPSSFSTYLEID";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_ENABLECUSTOMCODEPATH = "ENABLECUSTOMCODEPATH";

    public final boolean isPSSFVERCODEIDNull() {
        return this.IsParamNull(TAG_PSSFVERCODEID);
    }

    public final String getPSSFVERCODEID() {
        return this.GetParamStringValue(TAG_PSSFVERCODEID, "");
    }

    public final void setPSSFVERCODEID(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODEID, strValue);
    }

    public final boolean isPSSFVERCODENAMENull() {
        return this.IsParamNull(TAG_PSSFVERCODENAME);
    }

    public final String getPSSFVERCODENAME() {
        return this.GetParamStringValue(TAG_PSSFVERCODENAME, "");
    }

    public final void setPSSFVERCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODENAME, strValue);
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

    public final boolean isPSSFSTYLEVERIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERID);
    }

    public final String getPSSFSTYLEVERID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERID, "");
    }

    public final void setPSSFSTYLEVERID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERID, strValue);
    }

    public final boolean isPSSFSTYLEVERNAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERNAME);
    }

    public final String getPSSFSTYLEVERNAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERNAME, "");
    }

    public final void setPSSFSTYLEVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERNAME, strValue);
    }

    public final boolean isPSSFCODETYPEIDNull() {
        return this.IsParamNull(TAG_PSSFCODETYPEID);
    }

    public final String getPSSFCODETYPEID() {
        return this.GetParamStringValue(TAG_PSSFCODETYPEID, "");
    }

    public final void setPSSFCODETYPEID(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPEID, strValue);
    }

    public final boolean isPSSFCODETYPENAMENull() {
        return this.IsParamNull(TAG_PSSFCODETYPENAME);
    }

    public final String getPSSFCODETYPENAME() {
        return this.GetParamStringValue(TAG_PSSFCODETYPENAME, "");
    }

    public final void setPSSFCODETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCODETEMPLNull() {
        return this.IsParamNull(TAG_CODETEMPL);
    }

    public final String getCODETEMPL() {
        return this.GetParamStringValue(TAG_CODETEMPL, "");
    }

    public final void setCODETEMPL(String strValue) {
        this.SetParamValue(TAG_CODETEMPL, strValue);
    }

    public final boolean isPSSFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERID);
    }

    public final String getPSSFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERID, "");
    }

    public final void setPSSFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERID, strValue);
    }

    public final boolean isTYPECODENull() {
        return this.IsParamNull(TAG_TYPECODE);
    }

    public final String getTYPECODE() {
        return this.GetParamStringValue(TAG_TYPECODE, "");
    }

    public final void setTYPECODE(String strValue) {
        this.SetParamValue(TAG_TYPECODE, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final int getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0);
    }

    public final void setVALIDFLAG(int nValue) {
        this.SetParamValue(TAG_VALIDFLAG, nValue);
    }

    public final boolean isFILENAMENull() {
        return this.IsParamNull(TAG_FILENAME);
    }

    public final String getFILENAME() {
        return this.GetParamStringValue(TAG_FILENAME, "");
    }

    public final void setFILENAME(String strValue) {
        this.SetParamValue(TAG_FILENAME, strValue);
    }

    public final boolean isFILEEXTNull() {
        return this.IsParamNull(TAG_FILEEXT);
    }

    public final String getFILEEXT() {
        return this.GetParamStringValue(TAG_FILEEXT, "");
    }

    public final void setFILEEXT(String strValue) {
        this.SetParamValue(TAG_FILEEXT, strValue);
    }

    public final boolean isENABLECUSTOMTYPECODENull() {
        return this.IsParamNull(TAG_ENABLECUSTOMTYPECODE);
    }

    public final boolean getENABLECUSTOMTYPECODE() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMTYPECODE, 0) == 1;
    }

    public final void setENABLECUSTOMTYPECODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMTYPECODE, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMTYPECODENull() {
        return this.IsParamNull(TAG_CUSTOMTYPECODE);
    }

    public final String getCUSTOMTYPECODE() {
        return this.GetParamStringValue(TAG_CUSTOMTYPECODE, "");
    }

    public final void setCUSTOMTYPECODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMTYPECODE, strValue);
    }

    public final boolean isENABLECUSTOMFILENAMENull() {
        return this.IsParamNull(TAG_ENABLECUSTOMFILENAME);
    }

    public final boolean getENABLECUSTOMFILENAME() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMFILENAME, 0) == 1;
    }

    public final void setENABLECUSTOMFILENAME(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMFILENAME, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMTYPECODEDESCNull() {
        return this.IsParamNull(TAG_CUSTOMTYPECODEDESC);
    }

    public final String getCUSTOMTYPECODEDESC() {
        return this.GetParamStringValue(TAG_CUSTOMTYPECODEDESC, "");
    }

    public final void setCUSTOMTYPECODEDESC(String strValue) {
        this.SetParamValue(TAG_CUSTOMTYPECODEDESC, strValue);
    }

    public final boolean isREALPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_REALPSSFSTYLEID);
    }

    public final String getREALPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_REALPSSFSTYLEID, "");
    }

    public final void setREALPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_REALPSSFSTYLEID, strValue);
    }

    public final boolean isCODEPATHNull() {
        return this.IsParamNull(TAG_CODEPATH);
    }

    public final String getCODEPATH() {
        return this.GetParamStringValue(TAG_CODEPATH, "");
    }

    public final void setCODEPATH(String strValue) {
        this.SetParamValue(TAG_CODEPATH, strValue);
    }

    public final boolean isENABLECUSTOMCODEPATHNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMCODEPATH);
    }

    public final boolean getENABLECUSTOMCODEPATH() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMCODEPATH, 0) == 1;
    }

    public final void setENABLECUSTOMCODEPATH(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMCODEPATH, bValue ? 1 : 0);
    }
}

