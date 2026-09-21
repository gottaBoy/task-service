/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppViewRef
extends BaseDataEntity {
    public static final String TAG_PSAPPVIEWREFID = "PSAPPVIEWREFID";
    public static final String TAG_PSAPPVIEWREFNAME = "PSAPPVIEWREFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSAPPVIEWID = "MAJORPSAPPVIEWID";
    public static final String TAG_MAJORPSAPPVIEWNAME = "MAJORPSAPPVIEWNAME";
    public static final String TAG_MINORPSAPPVIEWID = "MINORPSAPPVIEWID";
    public static final String TAG_MINORPSAPPVIEWNAME = "MINORPSAPPVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_REFMODETEXT = "REFMODETEXT";

    public final boolean isPSAPPVIEWREFIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWREFID);
    }

    public final String getPSAPPVIEWREFID() {
        return this.getParamStringValue(TAG_PSAPPVIEWREFID, "");
    }

    public final void setPSAPPVIEWREFID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWREFID, strValue);
    }

    public final boolean isPSAPPVIEWREFNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWREFNAME);
    }

    public final String getPSAPPVIEWREFNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWREFNAME, "");
    }

    public final void setPSAPPVIEWREFNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWREFNAME, strValue);
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

    public final boolean isMAJORPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_MAJORPSAPPVIEWID);
    }

    public final String getMAJORPSAPPVIEWID() {
        return this.getParamStringValue(TAG_MAJORPSAPPVIEWID, "");
    }

    public final void setMAJORPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_MAJORPSAPPVIEWID, strValue);
    }

    public final boolean isMAJORPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_MAJORPSAPPVIEWNAME);
    }

    public final String getMAJORPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_MAJORPSAPPVIEWNAME, "");
    }

    public final void setMAJORPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSAPPVIEWNAME, strValue);
    }

    public final boolean isMINORPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_MINORPSAPPVIEWID);
    }

    public final String getMINORPSAPPVIEWID() {
        return this.getParamStringValue(TAG_MINORPSAPPVIEWID, "");
    }

    public final void setMINORPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_MINORPSAPPVIEWID, strValue);
    }

    public final boolean isMINORPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_MINORPSAPPVIEWNAME);
    }

    public final String getMINORPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_MINORPSAPPVIEWNAME, "");
    }

    public final void setMINORPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_MINORPSAPPVIEWNAME, strValue);
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

    public final boolean isOPENMODENull() {
        return this.isParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.getParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.setParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isTITLENull() {
        return this.isParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.getParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.setParamValue(TAG_TITLE, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.isParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.getParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.setParamValue(TAG_VIEWPARAMS, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.isParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.getParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.isParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.getParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isREFMODETEXTNull() {
        return this.isParamNull(TAG_REFMODETEXT);
    }

    public final String getREFMODETEXT() {
        return this.getParamStringValue(TAG_REFMODETEXT, "");
    }

    public final void setREFMODETEXT(String strValue) {
        this.setParamValue(TAG_REFMODETEXT, strValue);
    }
}

