/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUWCreateDE
extends BaseDataEntity {
    public static final String TAG_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String TAG_PSUWCREATEDENAME = "PSUWCREATEDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOGICVALID = "LOGICVALID";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_WIZARDPARAM = "WIZARDPARAM";
    public static final String TAG_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String TAG_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String TAG_WIZARDPARAM4 = "WIZARDPARAM4";

    public final boolean isPSUWCREATEDEIDNull() {
        return this.IsParamNull(TAG_PSUWCREATEDEID);
    }

    public final String getPSUWCREATEDEID() {
        return this.GetParamStringValue(TAG_PSUWCREATEDEID, "");
    }

    public final void setPSUWCREATEDEID(String strValue) {
        this.SetParamValue(TAG_PSUWCREATEDEID, strValue);
    }

    public final boolean isPSUWCREATEDENAMENull() {
        return this.IsParamNull(TAG_PSUWCREATEDENAME);
    }

    public final String getPSUWCREATEDENAME() {
        return this.GetParamStringValue(TAG_PSUWCREATEDENAME, "");
    }

    public final void setPSUWCREATEDENAME(String strValue) {
        this.SetParamValue(TAG_PSUWCREATEDENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOGICVALIDNull() {
        return this.IsParamNull(TAG_LOGICVALID);
    }

    public final boolean getLOGICVALID() {
        return this.GetParamIntValue(TAG_LOGICVALID, 0) == 1;
    }

    public final void setLOGICVALID(boolean bValue) {
        this.SetParamValue(TAG_LOGICVALID, bValue ? 1 : 0);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDATAENTITYNAMENull() {
        return this.IsParamNull(TAG_PSDATAENTITYNAME);
    }

    public final String getPSDATAENTITYNAME() {
        return this.GetParamStringValue(TAG_PSDATAENTITYNAME, "");
    }

    public final void setPSDATAENTITYNAME(String strValue) {
        this.SetParamValue(TAG_PSDATAENTITYNAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isWIZARDMODENull() {
        return this.IsParamNull(TAG_WIZARDMODE);
    }

    public final String getWIZARDMODE() {
        return this.GetParamStringValue(TAG_WIZARDMODE, "");
    }

    public final void setWIZARDMODE(String strValue) {
        this.SetParamValue(TAG_WIZARDMODE, strValue);
    }

    public final boolean isWIZARDPARAMNull() {
        return this.IsParamNull(TAG_WIZARDPARAM);
    }

    public final String getWIZARDPARAM() {
        return this.GetParamStringValue(TAG_WIZARDPARAM, "");
    }

    public final void setWIZARDPARAM(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM, strValue);
    }

    public final boolean isWIZARDPARAM2Null() {
        return this.IsParamNull(TAG_WIZARDPARAM2);
    }

    public final String getWIZARDPARAM2() {
        return this.GetParamStringValue(TAG_WIZARDPARAM2, "");
    }

    public final void setWIZARDPARAM2(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM2, strValue);
    }

    public final boolean isWIZARDPARAM3Null() {
        return this.IsParamNull(TAG_WIZARDPARAM3);
    }

    public final int getWIZARDPARAM3() {
        return this.GetParamIntValue(TAG_WIZARDPARAM3, 0);
    }

    public final void setWIZARDPARAM3(int nValue) {
        this.SetParamValue(TAG_WIZARDPARAM3, nValue);
    }

    public final boolean isWIZARDPARAM4Null() {
        return this.IsParamNull(TAG_WIZARDPARAM4);
    }

    public final int getWIZARDPARAM4() {
        return this.GetParamIntValue(TAG_WIZARDPARAM4, 0);
    }

    public final void setWIZARDPARAM4(int nValue) {
        this.SetParamValue(TAG_WIZARDPARAM4, nValue);
    }
}

