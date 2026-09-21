/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSASBooking
extends BaseDataEntity {
    public static final int BOOKINGSTATE_10 = 10;
    public static final int BOOKINGSTATE_20 = 20;
    public static final int BOOKINGSTATE_40 = 40;
    public static final int BOOKINGSTATE_41 = 41;
    public static final String BOOKINGTYPE_MAINTAIN = "MAINTAIN";
    public static final String BOOKINGTYPE_DCRES = "DCRES";
    public static final String TAG_PSASBOOKINGID = "PSASBOOKINGID";
    public static final String TAG_PSASBOOKINGNAME = "PSASBOOKINGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String TAG_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String TAG_BOOKINGSTATE = "BOOKINGSTATE";
    public static final String TAG_BOOKINGTYPE = "BOOKINGTYPE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_HOURS = "HOURS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_BOOKINGINFO = "BOOKINGINFO";
    public static final String TAG_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String TAG_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_BOOKINGPARAM = "BOOKINGPARAM";
    public static final String TAG_BOOKINGPARAM2 = "BOOKINGPARAM2";
    public static final String TAG_BOOKINGPARAM3 = "BOOKINGPARAM3";
    public static final String TAG_BOOKINGPARAM4 = "BOOKINGPARAM4";

    public final boolean isPSASBOOKINGIDNull() {
        return this.IsParamNull(TAG_PSASBOOKINGID);
    }

    public final String getPSASBOOKINGID() {
        return this.GetParamStringValue(TAG_PSASBOOKINGID, "");
    }

    public final void setPSASBOOKINGID(String strValue) {
        this.SetParamValue(TAG_PSASBOOKINGID, strValue);
    }

    public final boolean isPSASBOOKINGNAMENull() {
        return this.IsParamNull(TAG_PSASBOOKINGNAME);
    }

    public final String getPSASBOOKINGNAME() {
        return this.GetParamStringValue(TAG_PSASBOOKINGNAME, "");
    }

    public final void setPSASBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_PSASBOOKINGNAME, strValue);
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

    public final boolean isPSAPPSERVERIDNull() {
        return this.IsParamNull(TAG_PSAPPSERVERID);
    }

    public final String getPSAPPSERVERID() {
        return this.GetParamStringValue(TAG_PSAPPSERVERID, "");
    }

    public final void setPSAPPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERID, strValue);
    }

    public final boolean isPSAPPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSAPPSERVERNAME);
    }

    public final String getPSAPPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSAPPSERVERNAME, "");
    }

    public final void setPSAPPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERNAME, strValue);
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

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
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

    public final boolean isBOOKINGINFONull() {
        return this.IsParamNull(TAG_BOOKINGINFO);
    }

    public final String getBOOKINGINFO() {
        return this.GetParamStringValue(TAG_BOOKINGINFO, "");
    }

    public final void setBOOKINGINFO(String strValue) {
        this.SetParamValue(TAG_BOOKINGINFO, strValue);
    }

    public final boolean isPSDEVCENTERASIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERASID);
    }

    public final String getPSDEVCENTERASID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID, "");
    }

    public final void setPSDEVCENTERASID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID, strValue);
    }

    public final boolean isPSDEVCENTERASNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME);
    }

    public final String getPSDEVCENTERASNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME, "");
    }

    public final void setPSDEVCENTERASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME, strValue);
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
}

