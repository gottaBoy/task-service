/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUAWizard
extends BaseDataEntity {
    public static final String TAG_PSUAWIZARDID = "PSUAWIZARDID";
    public static final String TAG_PSUAWIZARDNAME = "PSUAWIZARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String TAG_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String TAG_ACTIONDATA = "ACTIONDATA";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_WIZARDPARAM = "WIZARDPARAM";
    public static final String TAG_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String TAG_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String TAG_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String TAG_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String TAG_WIZARDPARAM6 = "WIZARDPARAM6";

    public final boolean isPSUAWIZARDIDNull() {
        return this.IsParamNull(TAG_PSUAWIZARDID);
    }

    public final String getPSUAWIZARDID() {
        return this.GetParamStringValue(TAG_PSUAWIZARDID, "");
    }

    public final void setPSUAWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSUAWIZARDID, strValue);
    }

    public final boolean isPSUAWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSUAWIZARDNAME);
    }

    public final String getPSUAWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSUAWIZARDNAME, "");
    }

    public final void setPSUAWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSUAWIZARDNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSAPPMODULEIDNull() {
        return this.IsParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.GetParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.IsParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.GetParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULENAME, strValue);
    }

    public final boolean isACTIONDATANull() {
        return this.IsParamNull(TAG_ACTIONDATA);
    }

    public final String getACTIONDATA() {
        return this.GetParamStringValue(TAG_ACTIONDATA, "");
    }

    public final void setACTIONDATA(String strValue) {
        this.SetParamValue(TAG_ACTIONDATA, strValue);
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

    public final boolean getWIZARDPARAM() {
        return this.GetParamIntValue(TAG_WIZARDPARAM, 0) == 1;
    }

    public final void setWIZARDPARAM(boolean bValue) {
        this.SetParamValue(TAG_WIZARDPARAM, bValue ? 1 : 0);
    }

    public final boolean isWIZARDPARAM2Null() {
        return this.IsParamNull(TAG_WIZARDPARAM2);
    }

    public final boolean getWIZARDPARAM2() {
        return this.GetParamIntValue(TAG_WIZARDPARAM2, 0) == 1;
    }

    public final void setWIZARDPARAM2(boolean bValue) {
        this.SetParamValue(TAG_WIZARDPARAM2, bValue ? 1 : 0);
    }

    public final boolean isWIZARDPARAM3Null() {
        return this.IsParamNull(TAG_WIZARDPARAM3);
    }

    public final String getWIZARDPARAM3() {
        return this.GetParamStringValue(TAG_WIZARDPARAM3, "");
    }

    public final void setWIZARDPARAM3(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM3, strValue);
    }

    public final boolean isWIZARDPARAM4Null() {
        return this.IsParamNull(TAG_WIZARDPARAM4);
    }

    public final String getWIZARDPARAM4() {
        return this.GetParamStringValue(TAG_WIZARDPARAM4, "");
    }

    public final void setWIZARDPARAM4(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM4, strValue);
    }

    public final boolean isWIZARDPARAM5Null() {
        return this.IsParamNull(TAG_WIZARDPARAM5);
    }

    public final String getWIZARDPARAM5() {
        return this.GetParamStringValue(TAG_WIZARDPARAM5, "");
    }

    public final void setWIZARDPARAM5(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM5, strValue);
    }

    public final boolean isWIZARDPARAM6Null() {
        return this.IsParamNull(TAG_WIZARDPARAM6);
    }

    public final String getWIZARDPARAM6() {
        return this.GetParamStringValue(TAG_WIZARDPARAM6, "");
    }

    public final void setWIZARDPARAM6(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM6, strValue);
    }
}

