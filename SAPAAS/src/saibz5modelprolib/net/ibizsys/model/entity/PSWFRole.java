/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFRole
extends BaseDataEntity {
    public static final String WFROLETYPE_USERGROUP = "USERGROUP";
    public static final String WFROLETYPE_CUSTOM = "CUSTOM";
    public static final String WFROLETYPE_DEDATASET = "DEDATASET";
    public static final String TAG_PSWFROLEID = "PSWFROLEID";
    public static final String TAG_PSWFROLENAME = "PSWFROLENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_WFROLETYPE = "WFROLETYPE";
    public static final String TAG_WFROLESN = "WFROLESN";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_WFUSERIDPSDEFID = "WFUSERIDPSDEFID";
    public static final String TAG_WFUSERIDPSDEFNAME = "WFUSERIDPSDEFNAME";
    public static final String TAG_WFUSERNAMEPSDEFID = "WFUSERNAMEPSDEFID";
    public static final String TAG_WFUSERNAMEPSDEFNAME = "WFUSERNAMEPSDEFNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";

    public final boolean isPSWFROLEIDNull() {
        return this.isParamNull(TAG_PSWFROLEID);
    }

    public final String getPSWFROLEID() {
        return this.getParamStringValue(TAG_PSWFROLEID, "");
    }

    public final void setPSWFROLEID(String strValue) {
        this.setParamValue(TAG_PSWFROLEID, strValue);
    }

    public final boolean isPSWFROLENAMENull() {
        return this.isParamNull(TAG_PSWFROLENAME);
    }

    public final String getPSWFROLENAME() {
        return this.getParamStringValue(TAG_PSWFROLENAME, "");
    }

    public final void setPSWFROLENAME(String strValue) {
        this.setParamValue(TAG_PSWFROLENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isWFROLETYPENull() {
        return this.isParamNull(TAG_WFROLETYPE);
    }

    public final String getWFROLETYPE() {
        return this.getParamStringValue(TAG_WFROLETYPE, "");
    }

    public final void setWFROLETYPE(String strValue) {
        this.setParamValue(TAG_WFROLETYPE, strValue);
    }

    public final boolean isWFROLESNNull() {
        return this.isParamNull(TAG_WFROLESN);
    }

    public final String getWFROLESN() {
        return this.getParamStringValue(TAG_WFROLESN, "");
    }

    public final void setWFROLESN(String strValue) {
        this.setParamValue(TAG_WFROLESN, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
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

    public final boolean isPSDEDSIDNull() {
        return this.isParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.getParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.setParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.isParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.getParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isWFUSERIDPSDEFIDNull() {
        return this.isParamNull(TAG_WFUSERIDPSDEFID);
    }

    public final String getWFUSERIDPSDEFID() {
        return this.getParamStringValue(TAG_WFUSERIDPSDEFID, "");
    }

    public final void setWFUSERIDPSDEFID(String strValue) {
        this.setParamValue(TAG_WFUSERIDPSDEFID, strValue);
    }

    public final boolean isWFUSERIDPSDEFNAMENull() {
        return this.isParamNull(TAG_WFUSERIDPSDEFNAME);
    }

    public final String getWFUSERIDPSDEFNAME() {
        return this.getParamStringValue(TAG_WFUSERIDPSDEFNAME, "");
    }

    public final void setWFUSERIDPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFUSERIDPSDEFNAME, strValue);
    }

    public final boolean isWFUSERNAMEPSDEFIDNull() {
        return this.isParamNull(TAG_WFUSERNAMEPSDEFID);
    }

    public final String getWFUSERNAMEPSDEFID() {
        return this.getParamStringValue(TAG_WFUSERNAMEPSDEFID, "");
    }

    public final void setWFUSERNAMEPSDEFID(String strValue) {
        this.setParamValue(TAG_WFUSERNAMEPSDEFID, strValue);
    }

    public final boolean isWFUSERNAMEPSDEFNAMENull() {
        return this.isParamNull(TAG_WFUSERNAMEPSDEFNAME);
    }

    public final String getWFUSERNAMEPSDEFNAME() {
        return this.getParamStringValue(TAG_WFUSERNAMEPSDEFNAME, "");
    }

    public final void setWFUSERNAMEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_WFUSERNAMEPSDEFNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.isParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.getParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.setParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.isParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.getParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.setParamValue(TAG_PSMODULENAME, strValue);
    }
}

