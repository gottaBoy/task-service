/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class WTUser
extends BaseDataEntity {
    public static final String WTUSEROBJECTTYPE_USER = "USER";
    public static final String WTUSEROBJECTTYPE_USERGROUP = "USERGROUP";
    public static final String VALIDFLAG_1 = "1";
    public static final String VALIDFLAG_0 = "0";
    public static final int SEX_0 = 0;
    public static final int SEX_1 = 1;
    public static final int SEX_2 = 2;
    public static final String TAG_WTUSERID = "WTUSERID";
    public static final String TAG_WTUSERNAME = "WTUSERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_WTUSEROBJECTTYPE = "WTUSEROBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_WTUSEROBJECTNO = "WTUSEROBJECTNO";
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_SUBSCRIBEFLAG = "SUBSCRIBEFLAG";
    public static final String TAG_SEX = "SEX";
    public static final String TAG_LANGUAGE = "LANGUAGE";
    public static final String TAG_CITY = "CITY";
    public static final String TAG_PROVINCE = "PROVINCE";
    public static final String TAG_COUNTRY = "COUNTRY";
    public static final String TAG_HEADIMGURL = "HEADIMGURL";
    public static final String TAG_SUBSCRIBETIME = "SUBSCRIBETIME";
    public static final String TAG_LASTSESSIONID = "LASTSESSIONID";
    public static final String TAG_LASTSESSIONNAME = "LASTSESSIONNAME";
    public static final String TAG_LASTSESSIONSTEPID = "LASTSESSIONSTEPID";
    public static final String TAG_LASTSESSIONSTEPNAME = "LASTSESSIONSTEPNAME";
    public static final String TAG_LASTSESSIONTIME = "LASTSESSIONTIME";
    public static final String TAG_REALPERSONID = "REALPERSONID";
    public static final String TAG_REALPERSONNAME = "REALPERSONNAME";
    public static final String TAG_MOBILENO = "MOBILENO";
    public static final String TAG_MOBILENO2 = "MOBILENO2";
    public static final String TAG_VERIFYFLAG = "VERIFYFLAG";

    public final boolean isWTUSERIDNull() {
        return this.IsParamNull(TAG_WTUSERID);
    }

    public final String getWTUSERID() {
        return this.GetParamStringValue(TAG_WTUSERID, "");
    }

    public final void setWTUSERID(String strValue) {
        this.SetParamValue(TAG_WTUSERID, strValue);
    }

    public final boolean isWTUSERNAMENull() {
        return this.IsParamNull(TAG_WTUSERNAME);
    }

    public final String getWTUSERNAME() {
        return this.GetParamStringValue(TAG_WTUSERNAME, "");
    }

    public final void setWTUSERNAME(String strValue) {
        this.SetParamValue(TAG_WTUSERNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isWTUSEROBJECTTYPENull() {
        return this.IsParamNull(TAG_WTUSEROBJECTTYPE);
    }

    public final String getWTUSEROBJECTTYPE() {
        return this.GetParamStringValue(TAG_WTUSEROBJECTTYPE, "");
    }

    public final void setWTUSEROBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_WTUSEROBJECTTYPE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isWTUSEROBJECTNONull() {
        return this.IsParamNull(TAG_WTUSEROBJECTNO);
    }

    public final String getWTUSEROBJECTNO() {
        return this.GetParamStringValue(TAG_WTUSEROBJECTNO, "");
    }

    public final void setWTUSEROBJECTNO(String strValue) {
        this.SetParamValue(TAG_WTUSEROBJECTNO, strValue);
    }

    public final boolean isWTACCOUNTIDNull() {
        return this.IsParamNull(TAG_WTACCOUNTID);
    }

    public final String getWTACCOUNTID() {
        return this.GetParamStringValue(TAG_WTACCOUNTID, "");
    }

    public final void setWTACCOUNTID(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTID, strValue);
    }

    public final boolean isWTACCOUNTNAMENull() {
        return this.IsParamNull(TAG_WTACCOUNTNAME);
    }

    public final String getWTACCOUNTNAME() {
        return this.GetParamStringValue(TAG_WTACCOUNTNAME, "");
    }

    public final void setWTACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTNAME, strValue);
    }

    public final boolean isSUBSCRIBEFLAGNull() {
        return this.IsParamNull(TAG_SUBSCRIBEFLAG);
    }

    public final boolean getSUBSCRIBEFLAG() {
        return this.GetParamIntValue(TAG_SUBSCRIBEFLAG, 0) == 1;
    }

    public final void setSUBSCRIBEFLAG(boolean bValue) {
        this.SetParamValue(TAG_SUBSCRIBEFLAG, bValue ? 1 : 0);
    }

    public final boolean isSEXNull() {
        return this.IsParamNull(TAG_SEX);
    }

    public final int getSEX() {
        return this.GetParamIntValue(TAG_SEX, 0);
    }

    public final void setSEX(int nValue) {
        this.SetParamValue(TAG_SEX, nValue);
    }

    public final boolean isLANGUAGENull() {
        return this.IsParamNull(TAG_LANGUAGE);
    }

    public final String getLANGUAGE() {
        return this.GetParamStringValue(TAG_LANGUAGE, "");
    }

    public final void setLANGUAGE(String strValue) {
        this.SetParamValue(TAG_LANGUAGE, strValue);
    }

    public final boolean isCITYNull() {
        return this.IsParamNull(TAG_CITY);
    }

    public final String getCITY() {
        return this.GetParamStringValue(TAG_CITY, "");
    }

    public final void setCITY(String strValue) {
        this.SetParamValue(TAG_CITY, strValue);
    }

    public final boolean isPROVINCENull() {
        return this.IsParamNull(TAG_PROVINCE);
    }

    public final String getPROVINCE() {
        return this.GetParamStringValue(TAG_PROVINCE, "");
    }

    public final void setPROVINCE(String strValue) {
        this.SetParamValue(TAG_PROVINCE, strValue);
    }

    public final boolean isCOUNTRYNull() {
        return this.IsParamNull(TAG_COUNTRY);
    }

    public final String getCOUNTRY() {
        return this.GetParamStringValue(TAG_COUNTRY, "");
    }

    public final void setCOUNTRY(String strValue) {
        this.SetParamValue(TAG_COUNTRY, strValue);
    }

    public final boolean isHEADIMGURLNull() {
        return this.IsParamNull(TAG_HEADIMGURL);
    }

    public final String getHEADIMGURL() {
        return this.GetParamStringValue(TAG_HEADIMGURL, "");
    }

    public final void setHEADIMGURL(String strValue) {
        this.SetParamValue(TAG_HEADIMGURL, strValue);
    }

    public final boolean isSUBSCRIBETIMENull() {
        return this.IsParamNull(TAG_SUBSCRIBETIME);
    }

    public final Timestamp getSUBSCRIBETIME() {
        return this.GetParamTimestampValue(TAG_SUBSCRIBETIME, null);
    }

    public final void setSUBSCRIBETIME(Timestamp dtValue) {
        this.SetParamValue(TAG_SUBSCRIBETIME, dtValue);
    }

    public final boolean isLASTSESSIONIDNull() {
        return this.IsParamNull(TAG_LASTSESSIONID);
    }

    public final String getLASTSESSIONID() {
        return this.GetParamStringValue(TAG_LASTSESSIONID, "");
    }

    public final void setLASTSESSIONID(String strValue) {
        this.SetParamValue(TAG_LASTSESSIONID, strValue);
    }

    public final boolean isLASTSESSIONNAMENull() {
        return this.IsParamNull(TAG_LASTSESSIONNAME);
    }

    public final String getLASTSESSIONNAME() {
        return this.GetParamStringValue(TAG_LASTSESSIONNAME, "");
    }

    public final void setLASTSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_LASTSESSIONNAME, strValue);
    }

    public final boolean isLASTSESSIONSTEPIDNull() {
        return this.IsParamNull(TAG_LASTSESSIONSTEPID);
    }

    public final String getLASTSESSIONSTEPID() {
        return this.GetParamStringValue(TAG_LASTSESSIONSTEPID, "");
    }

    public final void setLASTSESSIONSTEPID(String strValue) {
        this.SetParamValue(TAG_LASTSESSIONSTEPID, strValue);
    }

    public final boolean isLASTSESSIONSTEPNAMENull() {
        return this.IsParamNull(TAG_LASTSESSIONSTEPNAME);
    }

    public final String getLASTSESSIONSTEPNAME() {
        return this.GetParamStringValue(TAG_LASTSESSIONSTEPNAME, "");
    }

    public final void setLASTSESSIONSTEPNAME(String strValue) {
        this.SetParamValue(TAG_LASTSESSIONSTEPNAME, strValue);
    }

    public final boolean isLASTSESSIONTIMENull() {
        return this.IsParamNull(TAG_LASTSESSIONTIME);
    }

    public final Timestamp getLASTSESSIONTIME() {
        return this.GetParamTimestampValue(TAG_LASTSESSIONTIME, null);
    }

    public final void setLASTSESSIONTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_LASTSESSIONTIME, dtValue);
    }

    public final boolean isREALPERSONIDNull() {
        return this.IsParamNull(TAG_REALPERSONID);
    }

    public final String getREALPERSONID() {
        return this.GetParamStringValue(TAG_REALPERSONID, "");
    }

    public final void setREALPERSONID(String strValue) {
        this.SetParamValue(TAG_REALPERSONID, strValue);
    }

    public final boolean isREALPERSONNAMENull() {
        return this.IsParamNull(TAG_REALPERSONNAME);
    }

    public final String getREALPERSONNAME() {
        return this.GetParamStringValue(TAG_REALPERSONNAME, "");
    }

    public final void setREALPERSONNAME(String strValue) {
        this.SetParamValue(TAG_REALPERSONNAME, strValue);
    }

    public final boolean isMOBILENONull() {
        return this.IsParamNull(TAG_MOBILENO);
    }

    public final String getMOBILENO() {
        return this.GetParamStringValue(TAG_MOBILENO, "");
    }

    public final void setMOBILENO(String strValue) {
        this.SetParamValue(TAG_MOBILENO, strValue);
    }

    public final boolean isMOBILENO2Null() {
        return this.IsParamNull(TAG_MOBILENO2);
    }

    public final String getMOBILENO2() {
        return this.GetParamStringValue(TAG_MOBILENO2, "");
    }

    public final void setMOBILENO2(String strValue) {
        this.SetParamValue(TAG_MOBILENO2, strValue);
    }

    public final boolean isVERIFYFLAGNull() {
        return this.IsParamNull(TAG_VERIFYFLAG);
    }

    public final boolean getVERIFYFLAG() {
        return this.GetParamIntValue(TAG_VERIFYFLAG, 0) == 1;
    }

    public final void setVERIFYFLAG(boolean bValue) {
        this.SetParamValue(TAG_VERIFYFLAG, bValue ? 1 : 0);
    }
}

