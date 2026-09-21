/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Counter
extends BaseDataEntity {
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_COUNTERNAME = "COUNTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COUNTERTYPE = "COUNTERTYPE";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_COUNTERPARAM = "COUNTERPARAM";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_ENABLEUSERDP = "ENABLEUSERDP";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isCOUNTERNAMENull() {
        return this.IsParamNull(TAG_COUNTERNAME);
    }

    public final String getCOUNTERNAME() {
        return this.GetParamStringValue(TAG_COUNTERNAME, "");
    }

    public final void setCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_COUNTERNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isCOUNTERTYPENull() {
        return this.IsParamNull(TAG_COUNTERTYPE);
    }

    public final String getCOUNTERTYPE() {
        return this.GetParamStringValue(TAG_COUNTERTYPE, "");
    }

    public final void setCOUNTERTYPE(String strValue) {
        this.SetParamValue(TAG_COUNTERTYPE, strValue);
    }

    public final boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public final String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public final void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public final boolean isCOUNTERPARAMNull() {
        return this.IsParamNull(TAG_COUNTERPARAM);
    }

    public final String getCOUNTERPARAM() {
        return this.GetParamStringValue(TAG_COUNTERPARAM, "");
    }

    public final void setCOUNTERPARAM(String strValue) {
        this.SetParamValue(TAG_COUNTERPARAM, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isQUERYMODELIDNull() {
        return this.IsParamNull(TAG_QUERYMODELID);
    }

    public final String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public final void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public final boolean isQUERYMODELNAMENull() {
        return this.IsParamNull(TAG_QUERYMODELNAME);
    }

    public final String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public final void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public final boolean isENABLEUSERDPNull() {
        return this.IsParamNull(TAG_ENABLEUSERDP);
    }

    public final boolean getENABLEUSERDP() {
        return this.GetParamIntValue(TAG_ENABLEUSERDP, 0) == 1;
    }

    public final void setENABLEUSERDP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUSERDP, bValue ? 1 : 0);
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
}

