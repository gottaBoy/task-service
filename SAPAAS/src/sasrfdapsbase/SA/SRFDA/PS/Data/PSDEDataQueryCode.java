/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataQueryCode
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String TAG_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String TAG_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_QUERYCODE = "QUERYCODE";
    public static final String TAG_USERQUERYCODE = "USERQUERYCODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_QUERYCODETEMP = "QUERYCODETEMP";
    public static final String TAG_USERQUERYCODE2 = "USERQUERYCODE2";

    public final boolean isPSDEDQCODEIDNull() {
        return this.IsParamNull(TAG_PSDEDQCODEID);
    }

    public final String getPSDEDQCODEID() {
        return this.GetParamStringValue(TAG_PSDEDQCODEID, "");
    }

    public final void setPSDEDQCODEID(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODEID, strValue);
    }

    public final boolean isPSDEDQCODENAMENull() {
        return this.IsParamNull(TAG_PSDEDQCODENAME);
    }

    public final String getPSDEDQCODENAME() {
        return this.GetParamStringValue(TAG_PSDEDQCODENAME, "");
    }

    public final void setPSDEDQCODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQCODENAME, strValue);
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

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isQUERYCODENull() {
        return this.IsParamNull(TAG_QUERYCODE);
    }

    public final String getQUERYCODE() {
        return this.GetParamStringValue(TAG_QUERYCODE, "");
    }

    public final void setQUERYCODE(String strValue) {
        this.SetParamValue(TAG_QUERYCODE, strValue);
    }

    public final boolean isUSERQUERYCODENull() {
        return this.IsParamNull(TAG_USERQUERYCODE);
    }

    public final String getUSERQUERYCODE() {
        return this.GetParamStringValue(TAG_USERQUERYCODE, "");
    }

    public final void setUSERQUERYCODE(String strValue) {
        this.SetParamValue(TAG_USERQUERYCODE, strValue);
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

    public final boolean isQUERYCODETEMPNull() {
        return this.IsParamNull(TAG_QUERYCODETEMP);
    }

    public final String getQUERYCODETEMP() {
        return this.GetParamStringValue(TAG_QUERYCODETEMP, "");
    }

    public final void setQUERYCODETEMP(String strValue) {
        this.SetParamValue(TAG_QUERYCODETEMP, strValue);
    }

    public final boolean isUSERQUERYCODE2Null() {
        return this.IsParamNull(TAG_USERQUERYCODE2);
    }

    public final String getUSERQUERYCODE2() {
        return this.GetParamStringValue(TAG_USERQUERYCODE2, "");
    }

    public final void setUSERQUERYCODE2(String strValue) {
        this.SetParamValue(TAG_USERQUERYCODE2, strValue);
    }
}

