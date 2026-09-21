/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWFProcSubWF
extends BaseDataEntity {
    public static final String TAG_PSWFPROCSUBWFID = "PSWFPROCSUBWFID";
    public static final String TAG_PSWFPROCSUBWFNAME = "PSWFPROCSUBWFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_EMBEDPSWFID = "EMBEDPSWFID";
    public static final String TAG_EMBEDPSWFNAME = "EMBEDPSWFNAME";
    public static final String TAG_EMBEDPSWFDEID = "EMBEDPSWFDEID";
    public static final String TAG_EMBEDPSWFDENAME = "EMBEDPSWFDENAME";
    public static final String TAG_EMBEDPSDEDSID = "EMBEDPSDEDSID";
    public static final String TAG_EMBEDPSDEDSNAME = "EMBEDPSDEDSNAME";
    public static final String TAG_EMBEDPSDEID = "EMBEDPSDEID";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_SUSPENDDEFAULT = "SUSPENDDEFAULT";
    public static final String TAG_EMBEDPSWFVERID = "EMBEDPSWFVERID";
    public static final String TAG_EMBEDPSWFVERNAME = "EMBEDPSWFVERNAME";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA = "USERDATA";

    public final boolean isPSWFPROCSUBWFIDNull() {
        return this.IsParamNull(TAG_PSWFPROCSUBWFID);
    }

    public final String getPSWFPROCSUBWFID() {
        return this.GetParamStringValue(TAG_PSWFPROCSUBWFID, "");
    }

    public final void setPSWFPROCSUBWFID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCSUBWFID, strValue);
    }

    public final boolean isPSWFPROCSUBWFNAMENull() {
        return this.IsParamNull(TAG_PSWFPROCSUBWFNAME);
    }

    public final String getPSWFPROCSUBWFNAME() {
        return this.GetParamStringValue(TAG_PSWFPROCSUBWFNAME, "");
    }

    public final void setPSWFPROCSUBWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFPROCSUBWFNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isEMBEDPSWFIDNull() {
        return this.IsParamNull(TAG_EMBEDPSWFID);
    }

    public final String getEMBEDPSWFID() {
        return this.GetParamStringValue(TAG_EMBEDPSWFID, "");
    }

    public final void setEMBEDPSWFID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFID, strValue);
    }

    public final boolean isEMBEDPSWFNAMENull() {
        return this.IsParamNull(TAG_EMBEDPSWFNAME);
    }

    public final String getEMBEDPSWFNAME() {
        return this.GetParamStringValue(TAG_EMBEDPSWFNAME, "");
    }

    public final void setEMBEDPSWFNAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFNAME, strValue);
    }

    public final boolean isEMBEDPSWFDEIDNull() {
        return this.IsParamNull(TAG_EMBEDPSWFDEID);
    }

    public final String getEMBEDPSWFDEID() {
        return this.GetParamStringValue(TAG_EMBEDPSWFDEID, "");
    }

    public final void setEMBEDPSWFDEID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFDEID, strValue);
    }

    public final boolean isEMBEDPSWFDENAMENull() {
        return this.IsParamNull(TAG_EMBEDPSWFDENAME);
    }

    public final String getEMBEDPSWFDENAME() {
        return this.GetParamStringValue(TAG_EMBEDPSWFDENAME, "");
    }

    public final void setEMBEDPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFDENAME, strValue);
    }

    public final boolean isEMBEDPSDEDSIDNull() {
        return this.IsParamNull(TAG_EMBEDPSDEDSID);
    }

    public final String getEMBEDPSDEDSID() {
        return this.GetParamStringValue(TAG_EMBEDPSDEDSID, "");
    }

    public final void setEMBEDPSDEDSID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEDSID, strValue);
    }

    public final boolean isEMBEDPSDEDSNAMENull() {
        return this.IsParamNull(TAG_EMBEDPSDEDSNAME);
    }

    public final String getEMBEDPSDEDSNAME() {
        return this.GetParamStringValue(TAG_EMBEDPSDEDSNAME, "");
    }

    public final void setEMBEDPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEDSNAME, strValue);
    }

    public final boolean isEMBEDPSDEIDNull() {
        return this.IsParamNull(TAG_EMBEDPSDEID);
    }

    public final String getEMBEDPSDEID() {
        return this.GetParamStringValue(TAG_EMBEDPSDEID, "");
    }

    public final void setEMBEDPSDEID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEID, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isSUSPENDDEFAULTNull() {
        return this.IsParamNull(TAG_SUSPENDDEFAULT);
    }

    public final boolean getSUSPENDDEFAULT() {
        return this.GetParamIntValue(TAG_SUSPENDDEFAULT, 0) == 1;
    }

    public final void setSUSPENDDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_SUSPENDDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isEMBEDPSWFVERIDNull() {
        return this.IsParamNull(TAG_EMBEDPSWFVERID);
    }

    public final String getEMBEDPSWFVERID() {
        return this.GetParamStringValue(TAG_EMBEDPSWFVERID, "");
    }

    public final void setEMBEDPSWFVERID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFVERID, strValue);
    }

    public final boolean isEMBEDPSWFVERNAMENull() {
        return this.IsParamNull(TAG_EMBEDPSWFVERNAME);
    }

    public final String getEMBEDPSWFVERNAME() {
        return this.GetParamStringValue(TAG_EMBEDPSWFVERNAME, "");
    }

    public final void setEMBEDPSWFVERNAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFVERNAME, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }
}

