/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFUserCandidate
extends BaseDataEntity {
    public static final String TAG_WFUSERCANDIDATEID = "WFUSERCANDIDATEID";
    public static final String TAG_WFUSERCANDIDATENAME = "WFUSERCANDIDATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WFMAJORUSERID = "WFMAJORUSERID";
    public static final String TAG_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    public static final String TAG_WFMINORUSERID = "WFMINORUSERID";
    public static final String TAG_WFMINORUSERNAME = "WFMINORUSERNAME";
    public static final String TAG_CANDIDATEORDER = "CANDIDATEORDER";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isWFUSERCANDIDATEIDNull() {
        return this.IsParamNull(TAG_WFUSERCANDIDATEID);
    }

    public final String getWFUSERCANDIDATEID() {
        return this.GetParamStringValue(TAG_WFUSERCANDIDATEID, "");
    }

    public final void setWFUSERCANDIDATEID(String strValue) {
        this.SetParamValue(TAG_WFUSERCANDIDATEID, strValue);
    }

    public final boolean isWFUSERCANDIDATENAMENull() {
        return this.IsParamNull(TAG_WFUSERCANDIDATENAME);
    }

    public final String getWFUSERCANDIDATENAME() {
        return this.GetParamStringValue(TAG_WFUSERCANDIDATENAME, "");
    }

    public final void setWFUSERCANDIDATENAME(String strValue) {
        this.SetParamValue(TAG_WFUSERCANDIDATENAME, strValue);
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

    public final boolean isWFMAJORUSERIDNull() {
        return this.IsParamNull(TAG_WFMAJORUSERID);
    }

    public final String getWFMAJORUSERID() {
        return this.GetParamStringValue(TAG_WFMAJORUSERID, "");
    }

    public final void setWFMAJORUSERID(String strValue) {
        this.SetParamValue(TAG_WFMAJORUSERID, strValue);
    }

    public final boolean isWFMAJORUSERNAMENull() {
        return this.IsParamNull(TAG_WFMAJORUSERNAME);
    }

    public final String getWFMAJORUSERNAME() {
        return this.GetParamStringValue(TAG_WFMAJORUSERNAME, "");
    }

    public final void setWFMAJORUSERNAME(String strValue) {
        this.SetParamValue(TAG_WFMAJORUSERNAME, strValue);
    }

    public final boolean isWFMINORUSERIDNull() {
        return this.IsParamNull(TAG_WFMINORUSERID);
    }

    public final String getWFMINORUSERID() {
        return this.GetParamStringValue(TAG_WFMINORUSERID, "");
    }

    public final void setWFMINORUSERID(String strValue) {
        this.SetParamValue(TAG_WFMINORUSERID, strValue);
    }

    public final boolean isWFMINORUSERNAMENull() {
        return this.IsParamNull(TAG_WFMINORUSERNAME);
    }

    public final String getWFMINORUSERNAME() {
        return this.GetParamStringValue(TAG_WFMINORUSERNAME, "");
    }

    public final void setWFMINORUSERNAME(String strValue) {
        this.SetParamValue(TAG_WFMINORUSERNAME, strValue);
    }

    public final boolean isCANDIDATEORDERNull() {
        return this.IsParamNull(TAG_CANDIDATEORDER);
    }

    public final int getCANDIDATEORDER() {
        return this.GetParamIntValue(TAG_CANDIDATEORDER, 0);
    }

    public final void setCANDIDATEORDER(int nValue) {
        this.SetParamValue(TAG_CANDIDATEORDER, nValue);
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

