/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEMainState
extends BaseDataEntity {
    public static final String ALLOWMODE_ALLOW = "ALLOW";
    public static final String ALLOWMODE_DENY = "DENY";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_ALLOWMODE = "ALLOWMODE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_MSTAG = "MSTAG";
    public static final String TAG_MSVALUE = "MSVALUE";
    public static final String TAG_MSVALUE2 = "MSVALUE2";
    public static final String TAG_MSVALUE3 = "MSVALUE3";
    public static final String TAG_EDITPSDEVIEWID = "EDITPSDEVIEWID";
    public static final String TAG_EDITPSDEVIEWNAME = "EDITPSDEVIEWNAME";
    public static final String TAG_INFOPSDEVIEWID = "INFOPSDEVIEWID";
    public static final String TAG_INFOPSDEVIEWNAME = "INFOPSDEVIEWNAME";
    public static final String TAG_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String TAG_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String TAG_WFSTATEMODE = "WFSTATEMODE";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_OPPRIVALLOWMODE = "OPPRIVALLOWMODE";

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.isParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.getParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.isParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.getParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isALLOWMODENull() {
        return this.isParamNull(TAG_ALLOWMODE);
    }

    public final String getALLOWMODE() {
        return this.getParamStringValue(TAG_ALLOWMODE, "");
    }

    public final void setALLOWMODE(String strValue) {
        this.setParamValue(TAG_ALLOWMODE, strValue);
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

    public final boolean isDEFAULTMODENull() {
        return this.isParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.getParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isMSTAGNull() {
        return this.isParamNull(TAG_MSTAG);
    }

    public final String getMSTAG() {
        return this.getParamStringValue(TAG_MSTAG, "");
    }

    public final void setMSTAG(String strValue) {
        this.setParamValue(TAG_MSTAG, strValue);
    }

    public final boolean isMSVALUENull() {
        return this.isParamNull(TAG_MSVALUE);
    }

    public final String getMSVALUE() {
        return this.getParamStringValue(TAG_MSVALUE, "");
    }

    public final void setMSVALUE(String strValue) {
        this.setParamValue(TAG_MSVALUE, strValue);
    }

    public final boolean isMSVALUE2Null() {
        return this.isParamNull(TAG_MSVALUE2);
    }

    public final String getMSVALUE2() {
        return this.getParamStringValue(TAG_MSVALUE2, "");
    }

    public final void setMSVALUE2(String strValue) {
        this.setParamValue(TAG_MSVALUE2, strValue);
    }

    public final boolean isMSVALUE3Null() {
        return this.isParamNull(TAG_MSVALUE3);
    }

    public final String getMSVALUE3() {
        return this.getParamStringValue(TAG_MSVALUE3, "");
    }

    public final void setMSVALUE3(String strValue) {
        this.setParamValue(TAG_MSVALUE3, strValue);
    }

    public final boolean isWFSTATEMODENull() {
        return this.isParamNull(TAG_WFSTATEMODE);
    }

    public final boolean getWFSTATEMODE() {
        return this.getParamIntValue(TAG_WFSTATEMODE, 0) == 1;
    }

    public final void setWFSTATEMODE(boolean bValue) {
        this.setParamValue(TAG_WFSTATEMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.isParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.getParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.setParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.isParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.getParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.setParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isOPPRIVALLOWMODENull() {
        return this.isParamNull(TAG_OPPRIVALLOWMODE);
    }

    public final String getOPPRIVALLOWMODE() {
        return this.getParamStringValue(TAG_OPPRIVALLOWMODE, "");
    }

    public final void setOPPRIVALLOWMODE(String strValue) {
        this.setParamValue(TAG_OPPRIVALLOWMODE, strValue);
    }
}

