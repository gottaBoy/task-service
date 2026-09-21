/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
        return this.isParamNull(TAG_PSDEDQCODEID);
    }

    public final String getPSDEDQCODEID() {
        return this.getParamStringValue(TAG_PSDEDQCODEID, "");
    }

    public final void setPSDEDQCODEID(String strValue) {
        this.setParamValue(TAG_PSDEDQCODEID, strValue);
    }

    public final boolean isPSDEDQCODENAMENull() {
        return this.isParamNull(TAG_PSDEDQCODENAME);
    }

    public final String getPSDEDQCODENAME() {
        return this.getParamStringValue(TAG_PSDEDQCODENAME, "");
    }

    public final void setPSDEDQCODENAME(String strValue) {
        this.setParamValue(TAG_PSDEDQCODENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEDQIDNull() {
        return this.isParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.getParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.setParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.isParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.getParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.setParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isDBTYPENull() {
        return this.isParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.getParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.setParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isQUERYCODENull() {
        return this.isParamNull(TAG_QUERYCODE);
    }

    public final String getQUERYCODE() {
        return this.getParamStringValue(TAG_QUERYCODE, "");
    }

    public final void setQUERYCODE(String strValue) {
        this.setParamValue(TAG_QUERYCODE, strValue);
    }

    public final boolean isUSERQUERYCODENull() {
        return this.isParamNull(TAG_USERQUERYCODE);
    }

    public final String getUSERQUERYCODE() {
        return this.getParamStringValue(TAG_USERQUERYCODE, "");
    }

    public final void setUSERQUERYCODE(String strValue) {
        this.setParamValue(TAG_USERQUERYCODE, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isQUERYCODETEMPNull() {
        return this.isParamNull(TAG_QUERYCODETEMP);
    }

    public final String getQUERYCODETEMP() {
        return this.getParamStringValue(TAG_QUERYCODETEMP, "");
    }

    public final void setQUERYCODETEMP(String strValue) {
        this.setParamValue(TAG_QUERYCODETEMP, strValue);
    }

    public final boolean isUSERQUERYCODE2Null() {
        return this.isParamNull(TAG_USERQUERYCODE2);
    }

    public final String getUSERQUERYCODE2() {
        return this.getParamStringValue(TAG_USERQUERYCODE2, "");
    }

    public final void setUSERQUERYCODE2(String strValue) {
        this.setParamValue(TAG_USERQUERYCODE2, strValue);
    }
}

