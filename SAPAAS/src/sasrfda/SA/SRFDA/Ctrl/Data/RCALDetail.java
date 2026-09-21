/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class RCALDetail
extends BaseDataEntity {
    public static final String TAG_RCALDETAILID = "RCALDETAILID";
    public static final String TAG_RCALDETAILNAME = "RCALDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RCACCLISTID = "RCACCLISTID";
    public static final String TAG_RCACCLISTNAME = "RCACCLISTNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_ENABLEINSERT = "ENABLEINSERT";
    public static final String TAG_ENABLEUPDATE = "ENABLEUPDATE";
    public static final String TAG_ENABLEREMOVE = "ENABLEREMOVE";
    public static final String TAG_ENABLESELECT = "ENABLESELECT";
    public static final String TAG_ENABLECUSTOMCALL = "ENABLECUSTOMCALL";
    public static final String TAG_CUSTOMCALLDETAIL = "CUSTOMCALLDETAIL";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isRCALDETAILIDNull() {
        return this.IsParamNull(TAG_RCALDETAILID);
    }

    public final String getRCALDETAILID() {
        return this.GetParamStringValue(TAG_RCALDETAILID, "");
    }

    public final void setRCALDETAILID(String strValue) {
        this.SetParamValue(TAG_RCALDETAILID, strValue);
    }

    public final boolean isRCALDETAILNAMENull() {
        return this.IsParamNull(TAG_RCALDETAILNAME);
    }

    public final String getRCALDETAILNAME() {
        return this.GetParamStringValue(TAG_RCALDETAILNAME, "");
    }

    public final void setRCALDETAILNAME(String strValue) {
        this.SetParamValue(TAG_RCALDETAILNAME, strValue);
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

    public final boolean isRCACCLISTIDNull() {
        return this.IsParamNull(TAG_RCACCLISTID);
    }

    public final String getRCACCLISTID() {
        return this.GetParamStringValue(TAG_RCACCLISTID, "");
    }

    public final void setRCACCLISTID(String strValue) {
        this.SetParamValue(TAG_RCACCLISTID, strValue);
    }

    public final boolean isRCACCLISTNAMENull() {
        return this.IsParamNull(TAG_RCACCLISTNAME);
    }

    public final String getRCACCLISTNAME() {
        return this.GetParamStringValue(TAG_RCACCLISTNAME, "");
    }

    public final void setRCACCLISTNAME(String strValue) {
        this.SetParamValue(TAG_RCACCLISTNAME, strValue);
    }

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isENABLEINSERTNull() {
        return this.IsParamNull(TAG_ENABLEINSERT);
    }

    public final boolean getENABLEINSERT() {
        return this.GetParamIntValue(TAG_ENABLEINSERT, 0) == 1;
    }

    public final void setENABLEINSERT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEINSERT, bValue ? 1 : 0);
    }

    public final boolean isENABLEUPDATENull() {
        return this.IsParamNull(TAG_ENABLEUPDATE);
    }

    public final boolean getENABLEUPDATE() {
        return this.GetParamIntValue(TAG_ENABLEUPDATE, 0) == 1;
    }

    public final void setENABLEUPDATE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUPDATE, bValue ? 1 : 0);
    }

    public final boolean isENABLEREMOVENull() {
        return this.IsParamNull(TAG_ENABLEREMOVE);
    }

    public final boolean getENABLEREMOVE() {
        return this.GetParamIntValue(TAG_ENABLEREMOVE, 0) == 1;
    }

    public final void setENABLEREMOVE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEREMOVE, bValue ? 1 : 0);
    }

    public final boolean isENABLESELECTNull() {
        return this.IsParamNull(TAG_ENABLESELECT);
    }

    public final boolean getENABLESELECT() {
        return this.GetParamIntValue(TAG_ENABLESELECT, 0) == 1;
    }

    public final void setENABLESELECT(boolean bValue) {
        this.SetParamValue(TAG_ENABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLECUSTOMCALLNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMCALL);
    }

    public final boolean getENABLECUSTOMCALL() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMCALL, 0) == 1;
    }

    public final void setENABLECUSTOMCALL(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMCALL, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMCALLDETAILNull() {
        return this.IsParamNull(TAG_CUSTOMCALLDETAIL);
    }

    public final String getCUSTOMCALLDETAIL() {
        return this.GetParamStringValue(TAG_CUSTOMCALLDETAIL, "");
    }

    public final void setCUSTOMCALLDETAIL(String strValue) {
        this.SetParamValue(TAG_CUSTOMCALLDETAIL, strValue);
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

