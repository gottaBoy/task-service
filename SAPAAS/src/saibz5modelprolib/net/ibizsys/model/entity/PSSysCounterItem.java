/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysCounterItem
extends BaseDataEntity {
    public static final String TAG_PSSYSCOUNTERITEMID = "PSSYSCOUNTERITEMID";
    public static final String TAG_PSSYSCOUNTERITEMNAME = "PSSYSCOUNTERITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSCOUNTERITEMIDNull() {
        return this.isParamNull(TAG_PSSYSCOUNTERITEMID);
    }

    public final String getPSSYSCOUNTERITEMID() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERITEMID, "");
    }

    public final void setPSSYSCOUNTERITEMID(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERITEMID, strValue);
    }

    public final boolean isPSSYSCOUNTERITEMNAMENull() {
        return this.isParamNull(TAG_PSSYSCOUNTERITEMNAME);
    }

    public final String getPSSYSCOUNTERITEMNAME() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERITEMNAME, "");
    }

    public final void setPSSYSCOUNTERITEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERITEMNAME, strValue);
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

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.isParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.isParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
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
}

