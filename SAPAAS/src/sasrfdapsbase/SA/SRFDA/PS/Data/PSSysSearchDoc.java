/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSearchDoc
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String TAG_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String TAG_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_SHARDS = "SHARDS";
    public static final String TAG_REPLICAS = "REPLICAS";
    public static final String TAG_DOCTAG = "DOCTAG";
    public static final String TAG_DOCTAG2 = "DOCTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DOCPARAMS = "DOCPARAMS";

    public final boolean isPSSYSSEARCHDOCIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCID);
    }

    public final String getPSSYSSEARCHDOCID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCID, "");
    }

    public final void setPSSYSSEARCHDOCID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCID, strValue);
    }

    public final boolean isPSSYSSEARCHDOCNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCNAME);
    }

    public final String getPSSYSSEARCHDOCNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCNAME, "");
    }

    public final void setPSSYSSEARCHDOCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCNAME, strValue);
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

    public final boolean isPSSYSSEARCHSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMEID);
    }

    public final String getPSSYSSEARCHSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMEID, "");
    }

    public final void setPSSYSSEARCHSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMEID, strValue);
    }

    public final boolean isPSSYSSEARCHSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMENAME);
    }

    public final String getPSSYSSEARCHSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMENAME, "");
    }

    public final void setPSSYSSEARCHSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMENAME, strValue);
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

    public final boolean isSHARDSNull() {
        return this.IsParamNull(TAG_SHARDS);
    }

    public final int getSHARDS() {
        return this.GetParamIntValue(TAG_SHARDS, 0);
    }

    public final void setSHARDS(int nValue) {
        this.SetParamValue(TAG_SHARDS, nValue);
    }

    public final boolean isREPLICASNull() {
        return this.IsParamNull(TAG_REPLICAS);
    }

    public final int getREPLICAS() {
        return this.GetParamIntValue(TAG_REPLICAS, 0);
    }

    public final void setREPLICAS(int nValue) {
        this.SetParamValue(TAG_REPLICAS, nValue);
    }

    public final boolean isDOCTAGNull() {
        return this.IsParamNull(TAG_DOCTAG);
    }

    public final String getDOCTAG() {
        return this.GetParamStringValue(TAG_DOCTAG, "");
    }

    public final void setDOCTAG(String strValue) {
        this.SetParamValue(TAG_DOCTAG, strValue);
    }

    public final boolean isDOCTAG2Null() {
        return this.IsParamNull(TAG_DOCTAG2);
    }

    public final String getDOCTAG2() {
        return this.GetParamStringValue(TAG_DOCTAG2, "");
    }

    public final void setDOCTAG2(String strValue) {
        this.SetParamValue(TAG_DOCTAG2, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isDOCPARAMSNull() {
        return this.IsParamNull(TAG_DOCPARAMS);
    }

    public final String getDOCPARAMS() {
        return this.GetParamStringValue(TAG_DOCPARAMS, "");
    }

    public final void setDOCPARAMS(String strValue) {
        this.SetParamValue(TAG_DOCPARAMS, strValue);
    }
}

