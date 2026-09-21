/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemDBConfig
extends BaseDataEntity {
    public static final String PSSYSTEMDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String NULLVALORDER_FIRST = "FIRST";
    public static final String NULLVALORDER_LAST = "LAST";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String TAG_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String TAG_TABSPACE = "TABSPACE";
    public static final String TAG_TABSPACE2 = "TABSPACE2";
    public static final String TAG_TABSPACE3 = "TABSPACE3";
    public static final String TAG_TABSPACE4 = "TABSPACE4";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_NODBINSTMODE = "NODBINSTMODE";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_PUBCOMMENTFLAG = "PUBCOMMENTFLAG";
    public static final String TAG_PUBVIEWFLAG = "PUBVIEWFLAG";
    public static final String TAG_PUBFKEYFLAG = "PUBFKEYFLAG";
    public static final String TAG_PUBINDEXFLAG = "PUBINDEXFLAG";
    public static final String TAG_PUBDBMODELFLAG = "PUBDBMODELFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_OBJNAMECASE = "OBJNAMECASE";
    public static final String TAG_NULLVALORDER = "NULLVALORDER";

    public final boolean isPSSYSTEMDBCFGIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGID);
    }

    public final String getPSSYSTEMDBCFGID() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGID, "");
    }

    public final void setPSSYSTEMDBCFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGID, strValue);
    }

    public final boolean isPSSYSTEMDBCFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGNAME);
    }

    public final String getPSSYSTEMDBCFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGNAME, "");
    }

    public final void setPSSYSTEMDBCFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isPSDBDEVINSTIDNull() {
        return this.IsParamNull(TAG_PSDBDEVINSTID);
    }

    public final String getPSDBDEVINSTID() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTID, "");
    }

    public final void setPSDBDEVINSTID(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTID, strValue);
    }

    public final boolean isPSDBDEVINSTNAMENull() {
        return this.IsParamNull(TAG_PSDBDEVINSTNAME);
    }

    public final String getPSDBDEVINSTNAME() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTNAME, "");
    }

    public final void setPSDBDEVINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTNAME, strValue);
    }

    public final boolean isTABSPACENull() {
        return this.IsParamNull(TAG_TABSPACE);
    }

    public final String getTABSPACE() {
        return this.GetParamStringValue(TAG_TABSPACE, "");
    }

    public final void setTABSPACE(String strValue) {
        this.SetParamValue(TAG_TABSPACE, strValue);
    }

    public final boolean isTABSPACE2Null() {
        return this.IsParamNull(TAG_TABSPACE2);
    }

    public final String getTABSPACE2() {
        return this.GetParamStringValue(TAG_TABSPACE2, "");
    }

    public final void setTABSPACE2(String strValue) {
        this.SetParamValue(TAG_TABSPACE2, strValue);
    }

    public final boolean isTABSPACE3Null() {
        return this.IsParamNull(TAG_TABSPACE3);
    }

    public final String getTABSPACE3() {
        return this.GetParamStringValue(TAG_TABSPACE3, "");
    }

    public final void setTABSPACE3(String strValue) {
        this.SetParamValue(TAG_TABSPACE3, strValue);
    }

    public final boolean isTABSPACE4Null() {
        return this.IsParamNull(TAG_TABSPACE4);
    }

    public final String getTABSPACE4() {
        return this.GetParamStringValue(TAG_TABSPACE4, "");
    }

    public final void setTABSPACE4(String strValue) {
        this.SetParamValue(TAG_TABSPACE4, strValue);
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

    public final boolean isNODBINSTMODENull() {
        return this.IsParamNull(TAG_NODBINSTMODE);
    }

    public final boolean getNODBINSTMODE() {
        return this.GetParamIntValue(TAG_NODBINSTMODE, 0) == 1;
    }

    public final void setNODBINSTMODE(boolean bValue) {
        this.SetParamValue(TAG_NODBINSTMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDEVCENTERDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTID);
    }

    public final String getPSDEVCENTERDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTID, "");
    }

    public final void setPSDEVCENTERDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTID, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTNAME);
    }

    public final String getPSDEVCENTERDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTNAME, "");
    }

    public final void setPSDEVCENTERDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTNAME, strValue);
    }

    public final boolean isPUBCOMMENTFLAGNull() {
        return this.IsParamNull(TAG_PUBCOMMENTFLAG);
    }

    public final boolean getPUBCOMMENTFLAG() {
        return this.GetParamIntValue(TAG_PUBCOMMENTFLAG, 0) == 1;
    }

    public final void setPUBCOMMENTFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBCOMMENTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPUBVIEWFLAGNull() {
        return this.IsParamNull(TAG_PUBVIEWFLAG);
    }

    public final boolean getPUBVIEWFLAG() {
        return this.GetParamIntValue(TAG_PUBVIEWFLAG, 0) == 1;
    }

    public final void setPUBVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isPUBFKEYFLAGNull() {
        return this.IsParamNull(TAG_PUBFKEYFLAG);
    }

    public final boolean getPUBFKEYFLAG() {
        return this.GetParamIntValue(TAG_PUBFKEYFLAG, 0) == 1;
    }

    public final void setPUBFKEYFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBFKEYFLAG, bValue ? 1 : 0);
    }

    public final boolean isPUBINDEXFLAGNull() {
        return this.IsParamNull(TAG_PUBINDEXFLAG);
    }

    public final boolean getPUBINDEXFLAG() {
        return this.GetParamIntValue(TAG_PUBINDEXFLAG, 0) == 1;
    }

    public final void setPUBINDEXFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBINDEXFLAG, bValue ? 1 : 0);
    }

    public final boolean isPUBDBMODELFLAGNull() {
        return this.IsParamNull(TAG_PUBDBMODELFLAG);
    }

    public final boolean getPUBDBMODELFLAG() {
        return this.GetParamIntValue(TAG_PUBDBMODELFLAG, 0) == 1;
    }

    public final void setPUBDBMODELFLAG(boolean bValue) {
        this.SetParamValue(TAG_PUBDBMODELFLAG, bValue ? 1 : 0);
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

    public final boolean isOBJNAMECASENull() {
        return this.IsParamNull(TAG_OBJNAMECASE);
    }

    public final String getOBJNAMECASE() {
        return this.GetParamStringValue(TAG_OBJNAMECASE, "");
    }

    public final void setOBJNAMECASE(String strValue) {
        this.SetParamValue(TAG_OBJNAMECASE, strValue);
    }

    public final boolean isNULLVALORDERNull() {
        return this.IsParamNull(TAG_NULLVALORDER);
    }

    public final String getNULLVALORDER() {
        return this.GetParamStringValue(TAG_NULLVALORDER, "");
    }

    public final void setNULLVALORDER(String strValue) {
        this.SetParamValue(TAG_NULLVALORDER, strValue);
    }
}

