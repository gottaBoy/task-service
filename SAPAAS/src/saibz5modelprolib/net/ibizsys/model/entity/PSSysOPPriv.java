/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysOPPriv
extends BaseDataEntity {
    public static final String PRIVTYPE_CUSTOM = "CUSTOM";
    public static final String PRIVTYPE_DEDATASET = "DEDATASET";
    public static final String TAG_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String TAG_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PRIVID = "PRIVID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PRIVTYPE = "PRIVTYPE";
    public static final String TAG_DEOPPRIV = "DEOPPRIV";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";

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

    public final boolean isPRIVIDNull() {
        return this.isParamNull(TAG_PRIVID);
    }

    public final String getPRIVID() {
        return this.getParamStringValue(TAG_PRIVID, "");
    }

    public final void setPRIVID(String strValue) {
        this.setParamValue(TAG_PRIVID, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPRIVTYPENull() {
        return this.isParamNull(TAG_PRIVTYPE);
    }

    public final String getPRIVTYPE() {
        return this.getParamStringValue(TAG_PRIVTYPE, "");
    }

    public final void setPRIVTYPE(String strValue) {
        this.setParamValue(TAG_PRIVTYPE, strValue);
    }

    public final boolean isDEOPPRIVNull() {
        return this.isParamNull(TAG_DEOPPRIV);
    }

    public final String getDEOPPRIV() {
        return this.getParamStringValue(TAG_DEOPPRIV, "");
    }

    public final void setDEOPPRIV(String strValue) {
        this.setParamValue(TAG_DEOPPRIV, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
    }
}

