/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppModule
extends BaseDataEntity {
    public static final String TAG_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String TAG_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FROMOBJID = "FROMOBJID";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_MODULESN = "MODULESN";
    public static final String TAG_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String TAG_ENABLEMODULESTYLE = "ENABLEMODULESTYLE";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";

    public final boolean isPSAPPMODULEIDNull() {
        return this.isParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.getParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.setParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.isParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.getParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.setParamValue(TAG_PSAPPMODULENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
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

    public final boolean isFROMOBJIDNull() {
        return this.isParamNull(TAG_FROMOBJID);
    }

    public final String getFROMOBJID() {
        return this.getParamStringValue(TAG_FROMOBJID, "");
    }

    public final void setFROMOBJID(String strValue) {
        this.setParamValue(TAG_FROMOBJID, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isMODULESNNull() {
        return this.isParamNull(TAG_MODULESN);
    }

    public final String getMODULESN() {
        return this.getParamStringValue(TAG_MODULESN, "");
    }

    public final void setMODULESN(String strValue) {
        this.setParamValue(TAG_MODULESN, strValue);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.isParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.getParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.setParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isENABLEMODULESTYLENull() {
        return this.isParamNull(TAG_ENABLEMODULESTYLE);
    }

    public final boolean getENABLEMODULESTYLE() {
        return this.getParamIntValue(TAG_ENABLEMODULESTYLE, 0) == 1;
    }

    public final void setENABLEMODULESTYLE(boolean bValue) {
        this.setParamValue(TAG_ENABLEMODULESTYLE, bValue ? 1 : 0);
    }

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
    }
}

