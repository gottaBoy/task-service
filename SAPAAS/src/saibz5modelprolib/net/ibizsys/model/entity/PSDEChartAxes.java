/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEChartAxes
extends BaseDataEntity {
    public static final String AXESPOS_left = "left";
    public static final String AXESPOS_bottom = "bottom";
    public static final String AXESPOS_right = "right";
    public static final String AXESPOS_top = "top";
    public static final String AXESPOS_radial = "radial";
    public static final String AXESPOS_angular = "angular";
    public static final String AXESTYPE_numeric = "numeric";
    public static final String AXESTYPE_time = "time";
    public static final String AXESTYPE_category = "category";
    public static final String TAG_PSDECHARTAXESID = "PSDECHARTAXESID";
    public static final String TAG_PSDECHARTAXESNAME = "PSDECHARTAXESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_AXESPOS = "AXESPOS";
    public static final String TAG_AXESTYPE = "AXESTYPE";
    public static final String TAG_AXESMAXVALUE = "AXESMAXVALUE";
    public static final String TAG_AXESMINVALUE = "AXESMINVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_FIELDS = "FIELDS";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_DATASHOWMODE = "DATASHOWMODE";

    public final boolean isPSDECHARTAXESIDNull() {
        return this.isParamNull(TAG_PSDECHARTAXESID);
    }

    public final String getPSDECHARTAXESID() {
        return this.getParamStringValue(TAG_PSDECHARTAXESID, "");
    }

    public final void setPSDECHARTAXESID(String strValue) {
        this.setParamValue(TAG_PSDECHARTAXESID, strValue);
    }

    public final boolean isPSDECHARTAXESNAMENull() {
        return this.isParamNull(TAG_PSDECHARTAXESNAME);
    }

    public final String getPSDECHARTAXESNAME() {
        return this.getParamStringValue(TAG_PSDECHARTAXESNAME, "");
    }

    public final void setPSDECHARTAXESNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTAXESNAME, strValue);
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

    public final boolean isPSDECHARTIDNull() {
        return this.isParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.getParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.setParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.isParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.getParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTNAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
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

    public final boolean isAXESPOSNull() {
        return this.isParamNull(TAG_AXESPOS);
    }

    public final String getAXESPOS() {
        return this.getParamStringValue(TAG_AXESPOS, "");
    }

    public final void setAXESPOS(String strValue) {
        this.setParamValue(TAG_AXESPOS, strValue);
    }

    public final boolean isAXESTYPENull() {
        return this.isParamNull(TAG_AXESTYPE);
    }

    public final String getAXESTYPE() {
        return this.getParamStringValue(TAG_AXESTYPE, "");
    }

    public final void setAXESTYPE(String strValue) {
        this.setParamValue(TAG_AXESTYPE, strValue);
    }

    public final boolean isAXESMAXVALUENull() {
        return this.isParamNull(TAG_AXESMAXVALUE);
    }

    public final String getAXESMAXVALUE() {
        return this.getParamStringValue(TAG_AXESMAXVALUE, "");
    }

    public final void setAXESMAXVALUE(String strValue) {
        this.setParamValue(TAG_AXESMAXVALUE, strValue);
    }

    public final boolean isAXESMINVALUENull() {
        return this.isParamNull(TAG_AXESMINVALUE);
    }

    public final String getAXESMINVALUE() {
        return this.getParamStringValue(TAG_AXESMINVALUE, "");
    }

    public final void setAXESMINVALUE(String strValue) {
        this.setParamValue(TAG_AXESMINVALUE, strValue);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isFIELDSNull() {
        return this.isParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.getParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.setParamValue(TAG_FIELDS, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.getParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isDATASHOWMODENull() {
        return this.isParamNull(TAG_DATASHOWMODE);
    }

    public final int getDATASHOWMODE() {
        return this.getParamIntValue(TAG_DATASHOWMODE, 0);
    }

    public final void setDATASHOWMODE(int nValue) {
        this.setParamValue(TAG_DATASHOWMODE, nValue);
    }
}

