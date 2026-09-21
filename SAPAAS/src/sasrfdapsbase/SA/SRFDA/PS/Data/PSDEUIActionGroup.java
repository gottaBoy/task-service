/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEUIActionGroup
extends BaseDataEntity {
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UAGROUPPARAM = "UAGROUPPARAM";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_UAGTAG = "UAGTAG";
    public static final String TAG_UAGTAG2 = "UAGTAG2";
    public static final String TAG_UAGTAG3 = "UAGTAG3";
    public static final String TAG_UAGTAG4 = "UAGTAG4";

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUAGROUPPARAMNull() {
        return this.IsParamNull(TAG_UAGROUPPARAM);
    }

    public final String getUAGROUPPARAM() {
        return this.GetParamStringValue(TAG_UAGROUPPARAM, "");
    }

    public final void setUAGROUPPARAM(String strValue) {
        this.SetParamValue(TAG_UAGROUPPARAM, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFPROCESSIDNull() {
        return this.IsParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.GetParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.IsParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.GetParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUAGTAGNull() {
        return this.IsParamNull(TAG_UAGTAG);
    }

    public final String getUAGTAG() {
        return this.GetParamStringValue(TAG_UAGTAG, "");
    }

    public final void setUAGTAG(String strValue) {
        this.SetParamValue(TAG_UAGTAG, strValue);
    }

    public final boolean isUAGTAG2Null() {
        return this.IsParamNull(TAG_UAGTAG2);
    }

    public final String getUAGTAG2() {
        return this.GetParamStringValue(TAG_UAGTAG2, "");
    }

    public final void setUAGTAG2(String strValue) {
        this.SetParamValue(TAG_UAGTAG2, strValue);
    }

    public final boolean isUAGTAG3Null() {
        return this.IsParamNull(TAG_UAGTAG3);
    }

    public final String getUAGTAG3() {
        return this.GetParamStringValue(TAG_UAGTAG3, "");
    }

    public final void setUAGTAG3(String strValue) {
        this.SetParamValue(TAG_UAGTAG3, strValue);
    }

    public final boolean isUAGTAG4Null() {
        return this.IsParamNull(TAG_UAGTAG4);
    }

    public final String getUAGTAG4() {
        return this.GetParamStringValue(TAG_UAGTAG4, "");
    }

    public final void setUAGTAG4(String strValue) {
        this.SetParamValue(TAG_UAGTAG4, strValue);
    }
}

