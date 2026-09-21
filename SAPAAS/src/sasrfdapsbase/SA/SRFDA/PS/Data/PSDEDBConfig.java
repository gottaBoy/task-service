/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBConfig
extends BaseDataEntity {
    public static final String PSDEDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String TAG_PSDEDBCFGID = "PSDEDBCFGID";
    public static final String TAG_PSDEDBCFGNAME = "PSDEDBCFGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBMODEL = "PUBMODEL";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_EXTABLENAME = "EXTABLENAME";
    public static final String TAG_VIEWNAME = "VIEWNAME";
    public static final String TAG_VIEWNAME2 = "VIEWNAME2";
    public static final String TAG_VIEWNAME3 = "VIEWNAME3";
    public static final String TAG_VIEWNAME4 = "VIEWNAME4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_OBJNAMECASE = "OBJNAMECASE";

    public final boolean isPSDEDBCFGIDNull() {
        return this.IsParamNull(TAG_PSDEDBCFGID);
    }

    public final String getPSDEDBCFGID() {
        return this.GetParamStringValue(TAG_PSDEDBCFGID, "");
    }

    public final void setPSDEDBCFGID(String strValue) {
        this.SetParamValue(TAG_PSDEDBCFGID, strValue);
    }

    public final boolean isPSDEDBCFGNAMENull() {
        return this.IsParamNull(TAG_PSDEDBCFGNAME);
    }

    public final String getPSDEDBCFGNAME() {
        return this.GetParamStringValue(TAG_PSDEDBCFGNAME, "");
    }

    public final void setPSDEDBCFGNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDBCFGNAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isPUBMODELNull() {
        return this.IsParamNull(TAG_PUBMODEL);
    }

    public final boolean getPUBMODEL() {
        return this.GetParamIntValue(TAG_PUBMODEL, 0) == 1;
    }

    public final void setPUBMODEL(boolean bValue) {
        this.SetParamValue(TAG_PUBMODEL, bValue ? 1 : 0);
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

    public final boolean isTABLENAMENull() {
        return this.IsParamNull(TAG_TABLENAME);
    }

    public final String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public final void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public final boolean isEXTABLENAMENull() {
        return this.IsParamNull(TAG_EXTABLENAME);
    }

    public final String getEXTABLENAME() {
        return this.GetParamStringValue(TAG_EXTABLENAME, "");
    }

    public final void setEXTABLENAME(String strValue) {
        this.SetParamValue(TAG_EXTABLENAME, strValue);
    }

    public final boolean isVIEWNAMENull() {
        return this.IsParamNull(TAG_VIEWNAME);
    }

    public final String getVIEWNAME() {
        return this.GetParamStringValue(TAG_VIEWNAME, "");
    }

    public final void setVIEWNAME(String strValue) {
        this.SetParamValue(TAG_VIEWNAME, strValue);
    }

    public final boolean isVIEWNAME2Null() {
        return this.IsParamNull(TAG_VIEWNAME2);
    }

    public final String getVIEWNAME2() {
        return this.GetParamStringValue(TAG_VIEWNAME2, "");
    }

    public final void setVIEWNAME2(String strValue) {
        this.SetParamValue(TAG_VIEWNAME2, strValue);
    }

    public final boolean isVIEWNAME3Null() {
        return this.IsParamNull(TAG_VIEWNAME3);
    }

    public final String getVIEWNAME3() {
        return this.GetParamStringValue(TAG_VIEWNAME3, "");
    }

    public final void setVIEWNAME3(String strValue) {
        this.SetParamValue(TAG_VIEWNAME3, strValue);
    }

    public final boolean isVIEWNAME4Null() {
        return this.IsParamNull(TAG_VIEWNAME4);
    }

    public final String getVIEWNAME4() {
        return this.GetParamStringValue(TAG_VIEWNAME4, "");
    }

    public final void setVIEWNAME4(String strValue) {
        this.SetParamValue(TAG_VIEWNAME4, strValue);
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
}

