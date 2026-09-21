/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDSBooking
extends BaseDataEntity {
    public static final int BOOKINGSTATE_10 = 10;
    public static final int BOOKINGSTATE_20 = 20;
    public static final int BOOKINGSTATE_40 = 40;
    public static final int BOOKINGSTATE_41 = 41;
    public static final String BOOKINGTYPE_MAINTAIN = "MAINTAIN";
    public static final String BOOKINGTYPE_DCRES = "DCRES";
    public static final String TAG_PSDSBOOKINGID = "PSDSBOOKINGID";
    public static final String TAG_PSDSBOOKINGNAME = "PSDSBOOKINGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String TAG_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String TAG_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_BOOKINGINFO = "BOOKINGINFO";
    public static final String TAG_BOOKINGPARAM = "BOOKINGPARAM";
    public static final String TAG_BOOKINGPARAM2 = "BOOKINGPARAM2";
    public static final String TAG_BOOKINGPARAM3 = "BOOKINGPARAM3";
    public static final String TAG_BOOKINGPARAM4 = "BOOKINGPARAM4";
    public static final String TAG_BOOKINGSTATE = "BOOKINGSTATE";
    public static final String TAG_BOOKINGTYPE = "BOOKINGTYPE";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_HOURS = "HOURS";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDSBOOKINGIDNull() {
        return this.IsParamNull(TAG_PSDSBOOKINGID);
    }

    public final String getPSDSBOOKINGID() {
        return this.GetParamStringValue(TAG_PSDSBOOKINGID, "");
    }

    public final void setPSDSBOOKINGID(String strValue) {
        this.SetParamValue(TAG_PSDSBOOKINGID, strValue);
    }

    public final boolean isPSDSBOOKINGNAMENull() {
        return this.IsParamNull(TAG_PSDSBOOKINGNAME);
    }

    public final String getPSDSBOOKINGNAME() {
        return this.GetParamStringValue(TAG_PSDSBOOKINGNAME, "");
    }

    public final void setPSDSBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_PSDSBOOKINGNAME, strValue);
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

    public final boolean isPSDEVSERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVSERVERID);
    }

    public final String getPSDEVSERVERID() {
        return this.GetParamStringValue(TAG_PSDEVSERVERID, "");
    }

    public final void setPSDEVSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVSERVERID, strValue);
    }

    public final boolean isPSDEVSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVSERVERNAME);
    }

    public final String getPSDEVSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVSERVERNAME, "");
    }

    public final void setPSDEVSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSERVERNAME, strValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSDEVCENTERSERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERID);
    }

    public final String getPSDEVCENTERSERVERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERID, "");
    }

    public final void setPSDEVCENTERSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERID, strValue);
    }

    public final boolean isPSDEVCENTERSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERNAME);
    }

    public final String getPSDEVCENTERSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERNAME, "");
    }

    public final void setPSDEVCENTERSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERNAME, strValue);
    }

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public final boolean isBOOKINGINFONull() {
        return this.IsParamNull(TAG_BOOKINGINFO);
    }

    public final String getBOOKINGINFO() {
        return this.GetParamStringValue(TAG_BOOKINGINFO, "");
    }

    public final void setBOOKINGINFO(String strValue) {
        this.SetParamValue(TAG_BOOKINGINFO, strValue);
    }

    public final boolean isBOOKINGPARAMNull() {
        return this.IsParamNull(TAG_BOOKINGPARAM);
    }

    public final String getBOOKINGPARAM() {
        return this.GetParamStringValue(TAG_BOOKINGPARAM, "");
    }

    public final void setBOOKINGPARAM(String strValue) {
        this.SetParamValue(TAG_BOOKINGPARAM, strValue);
    }

    public final boolean isBOOKINGPARAM2Null() {
        return this.IsParamNull(TAG_BOOKINGPARAM2);
    }

    public final String getBOOKINGPARAM2() {
        return this.GetParamStringValue(TAG_BOOKINGPARAM2, "");
    }

    public final void setBOOKINGPARAM2(String strValue) {
        this.SetParamValue(TAG_BOOKINGPARAM2, strValue);
    }

    public final boolean isBOOKINGPARAM3Null() {
        return this.IsParamNull(TAG_BOOKINGPARAM3);
    }

    public final String getBOOKINGPARAM3() {
        return this.GetParamStringValue(TAG_BOOKINGPARAM3, "");
    }

    public final void setBOOKINGPARAM3(String strValue) {
        this.SetParamValue(TAG_BOOKINGPARAM3, strValue);
    }

    public final boolean isBOOKINGPARAM4Null() {
        return this.IsParamNull(TAG_BOOKINGPARAM4);
    }

    public final String getBOOKINGPARAM4() {
        return this.GetParamStringValue(TAG_BOOKINGPARAM4, "");
    }

    public final void setBOOKINGPARAM4(String strValue) {
        this.SetParamValue(TAG_BOOKINGPARAM4, strValue);
    }

    public final boolean isBOOKINGSTATENull() {
        return this.IsParamNull(TAG_BOOKINGSTATE);
    }

    public final int getBOOKINGSTATE() {
        return this.GetParamIntValue(TAG_BOOKINGSTATE, 0);
    }

    public final void setBOOKINGSTATE(int nValue) {
        this.SetParamValue(TAG_BOOKINGSTATE, nValue);
    }

    public final boolean isBOOKINGTYPENull() {
        return this.IsParamNull(TAG_BOOKINGTYPE);
    }

    public final String getBOOKINGTYPE() {
        return this.GetParamStringValue(TAG_BOOKINGTYPE, "");
    }

    public final void setBOOKINGTYPE(String strValue) {
        this.SetParamValue(TAG_BOOKINGTYPE, strValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public final boolean isHOURSNull() {
        return this.IsParamNull(TAG_HOURS);
    }

    public final int getHOURS() {
        return this.GetParamIntValue(TAG_HOURS, 0);
    }

    public final void setHOURS(int nValue) {
        this.SetParamValue(TAG_HOURS, nValue);
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
}

