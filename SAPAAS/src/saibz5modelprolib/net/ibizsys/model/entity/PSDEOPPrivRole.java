/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEOPPrivRole
extends BaseDataEntity {
    public static final String ROLETYPE_SYSROLE = "SYSROLE";
    public static final String ROLETYPE_DEROLE = "DEROLE";
    public static final String TAG_PSDEOPPRIVROLEID = "PSDEOPPRIVROLEID";
    public static final String TAG_PSDEOPPRIVROLENAME = "PSDEOPPRIVROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_ROLETYPE = "ROLETYPE";
    public static final String TAG_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String TAG_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String TAG_PSDEUSERROLENAME = "PSDEUSERROLENAME";

    public final boolean isPSDEOPPRIVROLEIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVROLEID);
    }

    public final String getPSDEOPPRIVROLEID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVROLEID, "");
    }

    public final void setPSDEOPPRIVROLEID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVROLEID, strValue);
    }

    public final boolean isPSDEOPPRIVROLENAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVROLENAME);
    }

    public final String getPSDEOPPRIVROLENAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVROLENAME, "");
    }

    public final void setPSDEOPPRIVROLENAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVROLENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isROLETYPENull() {
        return this.isParamNull(TAG_ROLETYPE);
    }

    public final String getROLETYPE() {
        return this.getParamStringValue(TAG_ROLETYPE, "");
    }

    public final void setROLETYPE(String strValue) {
        this.setParamValue(TAG_ROLETYPE, strValue);
    }

    public final boolean isPSSYSOPPRIVIDNull() {
        return this.isParamNull(TAG_PSSYSOPPRIVID);
    }

    public final String getPSSYSOPPRIVID() {
        return this.getParamStringValue(TAG_PSSYSOPPRIVID, "");
    }

    public final void setPSSYSOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSSYSOPPRIVID, strValue);
    }

    public final boolean isPSSYSOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSSYSOPPRIVNAME);
    }

    public final String getPSSYSOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSSYSOPPRIVNAME, "");
    }

    public final void setPSSYSOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSSYSOPPRIVNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSDEUSERROLEIDNull() {
        return this.isParamNull(TAG_PSDEUSERROLEID);
    }

    public final String getPSDEUSERROLEID() {
        return this.getParamStringValue(TAG_PSDEUSERROLEID, "");
    }

    public final void setPSDEUSERROLEID(String strValue) {
        this.setParamValue(TAG_PSDEUSERROLEID, strValue);
    }

    public final boolean isPSDEUSERROLENAMENull() {
        return this.isParamNull(TAG_PSDEUSERROLENAME);
    }

    public final String getPSDEUSERROLENAME() {
        return this.getParamStringValue(TAG_PSDEUSERROLENAME, "");
    }

    public final void setPSDEUSERROLENAME(String strValue) {
        this.setParamValue(TAG_PSDEUSERROLENAME, strValue);
    }
}

