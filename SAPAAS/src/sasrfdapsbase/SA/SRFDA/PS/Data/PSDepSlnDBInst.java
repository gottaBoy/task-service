/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnDBInst
extends BaseDataEntity {
    public static final String PSDEPSLNDBINSTNAME_DEFAULT = "DEFAULT";
    public static final String PSDEPSLNDBINSTNAME_DB2 = "DB2";
    public static final String PSDEPSLNDBINSTNAME_DB3 = "DB3";
    public static final String PSDEPSLNDBINSTNAME_DB4 = "DB4";
    public static final String TAG_PSDEPSLNDBINSTID = "PSDEPSLNDBINSTID";
    public static final String TAG_PSDEPSLNDBINSTNAME = "PSDEPSLNDBINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String TAG_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String TAG_ENABLELOCALMODE = "ENABLELOCALMODE";

    public final boolean isPSDEPSLNDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNDBINSTID);
    }

    public final String getPSDEPSLNDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNDBINSTID, "");
    }

    public final void setPSDEPSLNDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNDBINSTID, strValue);
    }

    public final boolean isPSDEPSLNDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNDBINSTNAME);
    }

    public final String getPSDEPSLNDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNDBINSTNAME, "");
    }

    public final void setPSDEPSLNDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNDBINSTNAME, strValue);
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

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
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

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isPSDEPSLNHOSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTID);
    }

    public final String getPSDEPSLNHOSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTID, "");
    }

    public final void setPSDEPSLNHOSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTID, strValue);
    }

    public final boolean isPSDEPSLNHOSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTNAME);
    }

    public final String getPSDEPSLNHOSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTNAME, "");
    }

    public final void setPSDEPSLNHOSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTNAME, strValue);
    }

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isENABLEREMOTEMODENull() {
        return this.IsParamNull(TAG_ENABLEREMOTEMODE);
    }

    public final boolean getENABLEREMOTEMODE() {
        return this.GetParamIntValue(TAG_ENABLEREMOTEMODE, 0) == 1;
    }

    public final void setENABLEREMOTEMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEREMOTEMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLELOCALMODENull() {
        return this.IsParamNull(TAG_ENABLELOCALMODE);
    }

    public final boolean getENABLELOCALMODE() {
        return this.GetParamIntValue(TAG_ENABLELOCALMODE, 0) == 1;
    }

    public final void setENABLELOCALMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLELOCALMODE, bValue ? 1 : 0);
    }
}

