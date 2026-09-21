/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysPFPlugin
extends BaseDataEntity {
    public static final String PLUGINTYPE_GRID_COLRENDER = "GRID_COLRENDER";
    public static final String PLUGINTYPE_FORM_USERCONTROL = "FORM_USERCONTROL";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String TAG_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String TAG_PLUGINTYPE = "PLUGINTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PLUGINTAG = "PLUGINTAG";

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
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

    public final boolean isPSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSPFPLUGINID);
    }

    public final String getPSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSPFPLUGINID, "");
    }

    public final void setPSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINID, strValue);
    }

    public final boolean isPSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSPFPLUGINNAME);
    }

    public final String getPSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSPFPLUGINNAME, "");
    }

    public final void setPSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSPFPLUGINNAME, strValue);
    }

    public final boolean isPLUGINTYPENull() {
        return this.isParamNull(TAG_PLUGINTYPE);
    }

    public final String getPLUGINTYPE() {
        return this.getParamStringValue(TAG_PLUGINTYPE, "");
    }

    public final void setPLUGINTYPE(String strValue) {
        this.setParamValue(TAG_PLUGINTYPE, strValue);
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

    public final boolean isPLUGINTAGNull() {
        return this.isParamNull(TAG_PLUGINTAG);
    }

    public final String getPLUGINTAG() {
        return this.getParamStringValue(TAG_PLUGINTAG, "");
    }

    public final void setPLUGINTAG(String strValue) {
        this.setParamValue(TAG_PLUGINTAG, strValue);
    }
}

