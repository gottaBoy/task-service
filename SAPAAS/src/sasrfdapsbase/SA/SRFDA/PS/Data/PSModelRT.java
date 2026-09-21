/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModelRT
extends BaseDataEntity {
    public static final String RTTYPE_PSOBJECT = "PSOBJECT";
    public static final String RTTYPE_METHOD = "METHOD";
    public static final String RTTYPE_VALUE = "VALUE";
    public static final String TAG_PSMODELRTID = "PSMODELRTID";
    public static final String TAG_PSMODELRTNAME = "PSMODELRTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PPSMODELRTID = "PPSMODELRTID";
    public static final String TAG_PPSMODELRTNAME = "PPSMODELRTNAME";
    public static final String TAG_LEAFFLAG = "LEAFFLAG";
    public static final String TAG_RTTYPE = "RTTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_METHODNAME = "METHODNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_RTDATA = "RTDATA";
    public static final String TAG_RTDATA2 = "RTDATA2";

    public final boolean isPSMODELRTIDNull() {
        return this.IsParamNull(TAG_PSMODELRTID);
    }

    public final String getPSMODELRTID() {
        return this.GetParamStringValue(TAG_PSMODELRTID, "");
    }

    public final void setPSMODELRTID(String strValue) {
        this.SetParamValue(TAG_PSMODELRTID, strValue);
    }

    public final boolean isPSMODELRTNAMENull() {
        return this.IsParamNull(TAG_PSMODELRTNAME);
    }

    public final String getPSMODELRTNAME() {
        return this.GetParamStringValue(TAG_PSMODELRTNAME, "");
    }

    public final void setPSMODELRTNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELRTNAME, strValue);
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

    public final boolean isPPSMODELRTIDNull() {
        return this.IsParamNull(TAG_PPSMODELRTID);
    }

    public final String getPPSMODELRTID() {
        return this.GetParamStringValue(TAG_PPSMODELRTID, "");
    }

    public final void setPPSMODELRTID(String strValue) {
        this.SetParamValue(TAG_PPSMODELRTID, strValue);
    }

    public final boolean isPPSMODELRTNAMENull() {
        return this.IsParamNull(TAG_PPSMODELRTNAME);
    }

    public final String getPPSMODELRTNAME() {
        return this.GetParamStringValue(TAG_PPSMODELRTNAME, "");
    }

    public final void setPPSMODELRTNAME(String strValue) {
        this.SetParamValue(TAG_PPSMODELRTNAME, strValue);
    }

    public final boolean isLEAFFLAGNull() {
        return this.IsParamNull(TAG_LEAFFLAG);
    }

    public final boolean getLEAFFLAG() {
        return this.GetParamIntValue(TAG_LEAFFLAG, 0) == 1;
    }

    public final void setLEAFFLAG(boolean bValue) {
        this.SetParamValue(TAG_LEAFFLAG, bValue ? 1 : 0);
    }

    public final boolean isRTTYPENull() {
        return this.IsParamNull(TAG_RTTYPE);
    }

    public final String getRTTYPE() {
        return this.GetParamStringValue(TAG_RTTYPE, "");
    }

    public final void setRTTYPE(String strValue) {
        this.SetParamValue(TAG_RTTYPE, strValue);
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

    public final boolean isMETHODNAMENull() {
        return this.IsParamNull(TAG_METHODNAME);
    }

    public final String getMETHODNAME() {
        return this.GetParamStringValue(TAG_METHODNAME, "");
    }

    public final void setMETHODNAME(String strValue) {
        this.SetParamValue(TAG_METHODNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public final void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isRTDATANull() {
        return this.IsParamNull(TAG_RTDATA);
    }

    public final String getRTDATA() {
        return this.GetParamStringValue(TAG_RTDATA, "");
    }

    public final void setRTDATA(String strValue) {
        this.SetParamValue(TAG_RTDATA, strValue);
    }

    public final boolean isRTDATA2Null() {
        return this.IsParamNull(TAG_RTDATA2);
    }

    public final String getRTDATA2() {
        return this.GetParamStringValue(TAG_RTDATA2, "");
    }

    public final void setRTDATA2(String strValue) {
        this.SetParamValue(TAG_RTDATA2, strValue);
    }
}

