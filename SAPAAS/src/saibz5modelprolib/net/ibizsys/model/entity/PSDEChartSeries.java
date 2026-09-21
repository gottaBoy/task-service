/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEChartSeries
extends BaseDataEntity {
    public static final String CHARTTYPE_area = "area";
    public static final String CHARTTYPE_bar = "bar";
    public static final String CHARTTYPE_bar3d = "bar3d";
    public static final String CHARTTYPE_candlestick = "candlestick";
    public static final String CHARTTYPE_gauge = "gauge";
    public static final String CHARTTYPE_line = "line";
    public static final String CHARTTYPE_pie = "pie";
    public static final String CHARTTYPE_pie3d = "pie3d";
    public static final String CHARTTYPE_radar = "radar";
    public static final String CHARTTYPE_scatter = "scatter";
    public static final String TIMEGROUP_YEAR = "YEAR";
    public static final String TIMEGROUP_QUARTER = "QUARTER";
    public static final String TIMEGROUP_MONTH = "MONTH";
    public static final String TIMEGROUP_YEARWEEK = "YEARWEEK";
    public static final String TIMEGROUP_DAY = "DAY";
    public static final String TAG_PSDECHARTPARAMID = "PSDECHARTPARAMID";
    public static final String TAG_PSDECHARTPARAMNAME = "PSDECHARTPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CHARTTYPE = "CHARTTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_XFIELD = "XFIELD";
    public static final String TAG_YFIELD = "YFIELD";
    public static final String TAG_ZFIELD = "ZFIELD";
    public static final String TAG_XPSDECHARTAXESID = "XPSDECHARTAXESID";
    public static final String TAG_XPSDECHARTAXESNAME = "XPSDECHARTAXESNAME";
    public static final String TAG_YPSDECHARTAXESID = "YPSDECHARTAXESID";
    public static final String TAG_YPSDECHARTAXESNAME = "YPSDECHARTAXESNAME";
    public static final String TAG_SERIESFIELD = "SERIESFIELD";
    public static final String TAG_TIMEGROUP = "TIMEGROUP";
    public static final String TAG_SFPSCODELISTID = "SFPSCODELISTID";
    public static final String TAG_SFPSCODELISTNAME = "SFPSCODELISTNAME";
    public static final String TAG_XFPSCODELISTID = "XFPSCODELISTID";
    public static final String TAG_XFPSCODELISTNAME = "XFPSCODELISTNAME";
    public static final String TAG_EXTFIELD = "EXTFIELD";
    public static final String TAG_EXTFIELD2 = "EXTFIELD2";
    public static final String TAG_EXTFIELD3 = "EXTFIELD3";
    public static final String TAG_EXTFIELD4 = "EXTFIELD4";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";

    public final boolean isPSDECHARTPARAMIDNull() {
        return this.isParamNull(TAG_PSDECHARTPARAMID);
    }

    public final String getPSDECHARTPARAMID() {
        return this.getParamStringValue(TAG_PSDECHARTPARAMID, "");
    }

    public final void setPSDECHARTPARAMID(String strValue) {
        this.setParamValue(TAG_PSDECHARTPARAMID, strValue);
    }

    public final boolean isPSDECHARTPARAMNAMENull() {
        return this.isParamNull(TAG_PSDECHARTPARAMNAME);
    }

    public final String getPSDECHARTPARAMNAME() {
        return this.getParamStringValue(TAG_PSDECHARTPARAMNAME, "");
    }

    public final void setPSDECHARTPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTPARAMNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCHARTTYPENull() {
        return this.isParamNull(TAG_CHARTTYPE);
    }

    public final String getCHARTTYPE() {
        return this.getParamStringValue(TAG_CHARTTYPE, "");
    }

    public final void setCHARTTYPE(String strValue) {
        this.setParamValue(TAG_CHARTTYPE, strValue);
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

    public final boolean isXFIELDNull() {
        return this.isParamNull(TAG_XFIELD);
    }

    public final String getXFIELD() {
        return this.getParamStringValue(TAG_XFIELD, "");
    }

    public final void setXFIELD(String strValue) {
        this.setParamValue(TAG_XFIELD, strValue);
    }

    public final boolean isYFIELDNull() {
        return this.isParamNull(TAG_YFIELD);
    }

    public final String getYFIELD() {
        return this.getParamStringValue(TAG_YFIELD, "");
    }

    public final void setYFIELD(String strValue) {
        this.setParamValue(TAG_YFIELD, strValue);
    }

    public final boolean isZFIELDNull() {
        return this.isParamNull(TAG_ZFIELD);
    }

    public final String getZFIELD() {
        return this.getParamStringValue(TAG_ZFIELD, "");
    }

    public final void setZFIELD(String strValue) {
        this.setParamValue(TAG_ZFIELD, strValue);
    }

    public final boolean isXPSDECHARTAXESIDNull() {
        return this.isParamNull(TAG_XPSDECHARTAXESID);
    }

    public final String getXPSDECHARTAXESID() {
        return this.getParamStringValue(TAG_XPSDECHARTAXESID, "");
    }

    public final void setXPSDECHARTAXESID(String strValue) {
        this.setParamValue(TAG_XPSDECHARTAXESID, strValue);
    }

    public final boolean isXPSDECHARTAXESNAMENull() {
        return this.isParamNull(TAG_XPSDECHARTAXESNAME);
    }

    public final String getXPSDECHARTAXESNAME() {
        return this.getParamStringValue(TAG_XPSDECHARTAXESNAME, "");
    }

    public final void setXPSDECHARTAXESNAME(String strValue) {
        this.setParamValue(TAG_XPSDECHARTAXESNAME, strValue);
    }

    public final boolean isYPSDECHARTAXESIDNull() {
        return this.isParamNull(TAG_YPSDECHARTAXESID);
    }

    public final String getYPSDECHARTAXESID() {
        return this.getParamStringValue(TAG_YPSDECHARTAXESID, "");
    }

    public final void setYPSDECHARTAXESID(String strValue) {
        this.setParamValue(TAG_YPSDECHARTAXESID, strValue);
    }

    public final boolean isYPSDECHARTAXESNAMENull() {
        return this.isParamNull(TAG_YPSDECHARTAXESNAME);
    }

    public final String getYPSDECHARTAXESNAME() {
        return this.getParamStringValue(TAG_YPSDECHARTAXESNAME, "");
    }

    public final void setYPSDECHARTAXESNAME(String strValue) {
        this.setParamValue(TAG_YPSDECHARTAXESNAME, strValue);
    }

    public final boolean isSERIESFIELDNull() {
        return this.isParamNull(TAG_SERIESFIELD);
    }

    public final String getSERIESFIELD() {
        return this.getParamStringValue(TAG_SERIESFIELD, "");
    }

    public final void setSERIESFIELD(String strValue) {
        this.setParamValue(TAG_SERIESFIELD, strValue);
    }

    public final boolean isTIMEGROUPNull() {
        return this.isParamNull(TAG_TIMEGROUP);
    }

    public final String getTIMEGROUP() {
        return this.getParamStringValue(TAG_TIMEGROUP, "");
    }

    public final void setTIMEGROUP(String strValue) {
        this.setParamValue(TAG_TIMEGROUP, strValue);
    }

    public final boolean isSFPSCODELISTIDNull() {
        return this.isParamNull(TAG_SFPSCODELISTID);
    }

    public final String getSFPSCODELISTID() {
        return this.getParamStringValue(TAG_SFPSCODELISTID, "");
    }

    public final void setSFPSCODELISTID(String strValue) {
        this.setParamValue(TAG_SFPSCODELISTID, strValue);
    }

    public final boolean isSFPSCODELISTNAMENull() {
        return this.isParamNull(TAG_SFPSCODELISTNAME);
    }

    public final String getSFPSCODELISTNAME() {
        return this.getParamStringValue(TAG_SFPSCODELISTNAME, "");
    }

    public final void setSFPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_SFPSCODELISTNAME, strValue);
    }

    public final boolean isXFPSCODELISTIDNull() {
        return this.isParamNull(TAG_XFPSCODELISTID);
    }

    public final String getXFPSCODELISTID() {
        return this.getParamStringValue(TAG_XFPSCODELISTID, "");
    }

    public final void setXFPSCODELISTID(String strValue) {
        this.setParamValue(TAG_XFPSCODELISTID, strValue);
    }

    public final boolean isXFPSCODELISTNAMENull() {
        return this.isParamNull(TAG_XFPSCODELISTNAME);
    }

    public final String getXFPSCODELISTNAME() {
        return this.getParamStringValue(TAG_XFPSCODELISTNAME, "");
    }

    public final void setXFPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_XFPSCODELISTNAME, strValue);
    }

    public final boolean isEXTFIELDNull() {
        return this.isParamNull(TAG_EXTFIELD);
    }

    public final String getEXTFIELD() {
        return this.getParamStringValue(TAG_EXTFIELD, "");
    }

    public final void setEXTFIELD(String strValue) {
        this.setParamValue(TAG_EXTFIELD, strValue);
    }

    public final boolean isEXTFIELD2Null() {
        return this.isParamNull(TAG_EXTFIELD2);
    }

    public final String getEXTFIELD2() {
        return this.getParamStringValue(TAG_EXTFIELD2, "");
    }

    public final void setEXTFIELD2(String strValue) {
        this.setParamValue(TAG_EXTFIELD2, strValue);
    }

    public final boolean isEXTFIELD3Null() {
        return this.isParamNull(TAG_EXTFIELD3);
    }

    public final String getEXTFIELD3() {
        return this.getParamStringValue(TAG_EXTFIELD3, "");
    }

    public final void setEXTFIELD3(String strValue) {
        this.setParamValue(TAG_EXTFIELD3, strValue);
    }

    public final boolean isEXTFIELD4Null() {
        return this.isParamNull(TAG_EXTFIELD4);
    }

    public final String getEXTFIELD4() {
        return this.getParamStringValue(TAG_EXTFIELD4, "");
    }

    public final void setEXTFIELD4(String strValue) {
        this.setParamValue(TAG_EXTFIELD4, strValue);
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
}

