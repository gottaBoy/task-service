/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFCodeType
extends BaseDataEntity {
    public static final String TAG_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String TAG_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String TAG_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String TAG_TYPECODE = "TYPECODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_FULLCODENAME = "FULLCODENAME";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_CODETEMPL = "CODETEMPL";
    public static final String TAG_FILEEXT = "FILEEXT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_GLOBALFLAG = "GLOBALFLAG";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSMODELID = "PSMODELID";
    public static final String TAG_PSMODELNAME = "PSMODELNAME";
    public static final String TAG_MODELLIST = "MODELLIST";
    public static final String TAG_DEBUGMODE = "DEBUGMODE";
    public static final String TAG_SECURITYTEMPL = "SECURITYTEMPL";
    public static final String TAG_HEADERCODE = "HEADERCODE";
    public static final String TAG_DEFAULTPUB = "DEFAULTPUB";
    public static final String TAG_CHECKMODELONLY = "CHECKMODELONLY";
    public static final String TAG_REMOVEEMPTYFILE = "REMOVEEMPTYFILE";

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

    public final boolean isPSSFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERID);
    }

    public final String getPSSFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERID, "");
    }

    public final void setPSSFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERID, strValue);
    }

    public final boolean isPSSFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERNAME);
    }

    public final String getPSSFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERNAME, "");
    }

    public final void setPSSFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isCODEPATHNull() {
        return this.IsParamNull(TAG_CODEPATH);
    }

    public final String getCODEPATH() {
        return this.GetParamStringValue(TAG_CODEPATH, "");
    }

    public final void setCODEPATH(String strValue) {
        this.SetParamValue(TAG_CODEPATH, strValue);
    }

    public final boolean isFULLCODENAMENull() {
        return this.IsParamNull(TAG_FULLCODENAME);
    }

    public final String getFULLCODENAME() {
        return this.GetParamStringValue(TAG_FULLCODENAME, "");
    }

    public final void setFULLCODENAME(String strValue) {
        this.SetParamValue(TAG_FULLCODENAME, strValue);
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

    public final boolean isCODETEMPLNull() {
        return this.IsParamNull(TAG_CODETEMPL);
    }

    public final String getCODETEMPL() {
        return this.GetParamStringValue(TAG_CODETEMPL, "");
    }

    public final void setCODETEMPL(String strValue) {
        this.SetParamValue(TAG_CODETEMPL, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final int getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0);
    }

    public final void setVALIDFLAG(int nValue) {
        this.SetParamValue(TAG_VALIDFLAG, nValue);
    }

    public final boolean isGLOBALFLAGNull() {
        return this.IsParamNull(TAG_GLOBALFLAG);
    }

    public final boolean getGLOBALFLAG() {
        return this.GetParamIntValue(TAG_GLOBALFLAG, 0) == 1;
    }

    public final void setGLOBALFLAG(boolean bValue) {
        this.SetParamValue(TAG_GLOBALFLAG, bValue ? 1 : 0);
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

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSMODELIDNull() {
        return this.IsParamNull(TAG_PSMODELID);
    }

    public final String getPSMODELID() {
        return this.GetParamStringValue(TAG_PSMODELID, "");
    }

    public final void setPSMODELID(String strValue) {
        this.SetParamValue(TAG_PSMODELID, strValue);
    }

    public final boolean isPSMODELNAMENull() {
        return this.IsParamNull(TAG_PSMODELNAME);
    }

    public final String getPSMODELNAME() {
        return this.GetParamStringValue(TAG_PSMODELNAME, "");
    }

    public final void setPSMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELNAME, strValue);
    }

    public final boolean isMODELLISTNull() {
        return this.IsParamNull(TAG_MODELLIST);
    }

    public final String getMODELLIST() {
        return this.GetParamStringValue(TAG_MODELLIST, "");
    }

    public final void setMODELLIST(String strValue) {
        this.SetParamValue(TAG_MODELLIST, strValue);
    }

    public final boolean isDEBUGMODENull() {
        return this.IsParamNull(TAG_DEBUGMODE);
    }

    public final boolean getDEBUGMODE() {
        return this.GetParamIntValue(TAG_DEBUGMODE, 0) == 1;
    }

    public final void setDEBUGMODE(boolean bValue) {
        this.SetParamValue(TAG_DEBUGMODE, bValue ? 1 : 0);
    }

    public final boolean isSECURITYTEMPLNull() {
        return this.IsParamNull(TAG_SECURITYTEMPL);
    }

    public final boolean getSECURITYTEMPL() {
        return this.GetParamIntValue(TAG_SECURITYTEMPL, 0) == 1;
    }

    public final void setSECURITYTEMPL(boolean bValue) {
        this.SetParamValue(TAG_SECURITYTEMPL, bValue ? 1 : 0);
    }

    public final boolean isHEADERCODENull() {
        return this.IsParamNull(TAG_HEADERCODE);
    }

    public final String getHEADERCODE() {
        return this.GetParamStringValue(TAG_HEADERCODE, "");
    }

    public final void setHEADERCODE(String strValue) {
        this.SetParamValue(TAG_HEADERCODE, strValue);
    }

    public final boolean isDEFAULTPUBNull() {
        return this.IsParamNull(TAG_DEFAULTPUB);
    }

    public final boolean getDEFAULTPUB() {
        return this.GetParamIntValue(TAG_DEFAULTPUB, 0) == 1;
    }

    public final void setDEFAULTPUB(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPUB, bValue ? 1 : 0);
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

