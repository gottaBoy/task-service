/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEReportItem
extends BaseDataEntity {
    public static final String TAG_PSDEREPITEMID = "PSDEREPITEMID";
    public static final String TAG_PSDEREPITEMNAME = "PSDEREPITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSDEREPORTID = "MAJORPSDEREPORTID";
    public static final String TAG_MAJORPSDEREPORTNAME = "MAJORPSDEREPORTNAME";
    public static final String TAG_MINORPSDEREPORTID = "MINORPSDEREPORTID";
    public static final String TAG_MINORPSDEREPORTNAME = "MINORPSDEREPORTNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEREPITEMIDNull() {
        return this.isParamNull(TAG_PSDEREPITEMID);
    }

    public final String getPSDEREPITEMID() {
        return this.getParamStringValue(TAG_PSDEREPITEMID, "");
    }

    public final void setPSDEREPITEMID(String strValue) {
        this.setParamValue(TAG_PSDEREPITEMID, strValue);
    }

    public final boolean isPSDEREPITEMNAMENull() {
        return this.isParamNull(TAG_PSDEREPITEMNAME);
    }

    public final String getPSDEREPITEMNAME() {
        return this.getParamStringValue(TAG_PSDEREPITEMNAME, "");
    }

    public final void setPSDEREPITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEREPITEMNAME, strValue);
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

    public final boolean isMAJORPSDEREPORTIDNull() {
        return this.isParamNull(TAG_MAJORPSDEREPORTID);
    }

    public final String getMAJORPSDEREPORTID() {
        return this.getParamStringValue(TAG_MAJORPSDEREPORTID, "");
    }

    public final void setMAJORPSDEREPORTID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEREPORTID, strValue);
    }

    public final boolean isMAJORPSDEREPORTNAMENull() {
        return this.isParamNull(TAG_MAJORPSDEREPORTNAME);
    }

    public final String getMAJORPSDEREPORTNAME() {
        return this.getParamStringValue(TAG_MAJORPSDEREPORTNAME, "");
    }

    public final void setMAJORPSDEREPORTNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDEREPORTNAME, strValue);
    }

    public final boolean isMINORPSDEREPORTIDNull() {
        return this.isParamNull(TAG_MINORPSDEREPORTID);
    }

    public final String getMINORPSDEREPORTID() {
        return this.getParamStringValue(TAG_MINORPSDEREPORTID, "");
    }

    public final void setMINORPSDEREPORTID(String strValue) {
        this.setParamValue(TAG_MINORPSDEREPORTID, strValue);
    }

    public final boolean isMINORPSDEREPORTNAMENull() {
        return this.isParamNull(TAG_MINORPSDEREPORTNAME);
    }

    public final String getMINORPSDEREPORTNAME() {
        return this.getParamStringValue(TAG_MINORPSDEREPORTNAME, "");
    }

    public final void setMINORPSDEREPORTNAME(String strValue) {
        this.setParamValue(TAG_MINORPSDEREPORTNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
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

