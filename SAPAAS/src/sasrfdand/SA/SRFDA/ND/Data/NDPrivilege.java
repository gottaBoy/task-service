/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDPrivilege
extends BaseDataEntity {
    public static final int ABLILITY_FILEREAD = 1;
    public static final int ABLILITY_FILEWRITE = 2;
    public static final int ABLILITY_FILEREMOVE = 4;
    public static final int ABLILITY_DIRCREATE = 8;
    public static final int ABLILITY_DIRREMOVE = 16;
    public static final String TAG_NDPRIVILEGEID = "NDPRIVILEGEID";
    public static final String TAG_NDPRIVILEGENAME = "NDPRIVILEGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_NDSHAREID = "NDSHAREID";
    public static final String TAG_NDSHARENAME = "NDSHARENAME";
    public static final String TAG_NDUSEROBJECTID = "NDUSEROBJECTID";
    public static final String TAG_NDUSEROBJECTNAME = "NDUSEROBJECTNAME";
    public static final String TAG_ABLILITY = "ABLILITY";
    public static final String TAG_ORGUNITID = "ORGUNITID";
    public static final String TAG_ORGUNITNAME = "ORGUNITNAME";
    public static final String TAG_ORGTREENODEID = "ORGTREENODEID";
    public static final String TAG_ORGTREENODENAME = "ORGTREENODENAME";
    public static final String TAG_INCSUBDEPT = "INCSUBDEPT";
    public static final String TAG_DEPTMODE = "DEPTMODE";

    public final boolean isNDPRIVILEGEIDNull() {
        return this.IsParamNull(TAG_NDPRIVILEGEID);
    }

    public final String getNDPRIVILEGEID() {
        return this.GetParamStringValue(TAG_NDPRIVILEGEID, "");
    }

    public final void setNDPRIVILEGEID(String strValue) {
        this.SetParamValue(TAG_NDPRIVILEGEID, strValue);
    }

    public final boolean isNDPRIVILEGENAMENull() {
        return this.IsParamNull(TAG_NDPRIVILEGENAME);
    }

    public final String getNDPRIVILEGENAME() {
        return this.GetParamStringValue(TAG_NDPRIVILEGENAME, "");
    }

    public final void setNDPRIVILEGENAME(String strValue) {
        this.SetParamValue(TAG_NDPRIVILEGENAME, strValue);
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

    public final boolean isNDSHAREIDNull() {
        return this.IsParamNull(TAG_NDSHAREID);
    }

    public final String getNDSHAREID() {
        return this.GetParamStringValue(TAG_NDSHAREID, "");
    }

    public final void setNDSHAREID(String strValue) {
        this.SetParamValue(TAG_NDSHAREID, strValue);
    }

    public final boolean isNDSHARENAMENull() {
        return this.IsParamNull(TAG_NDSHARENAME);
    }

    public final String getNDSHARENAME() {
        return this.GetParamStringValue(TAG_NDSHARENAME, "");
    }

    public final void setNDSHARENAME(String strValue) {
        this.SetParamValue(TAG_NDSHARENAME, strValue);
    }

    public final boolean isNDUSEROBJECTIDNull() {
        return this.IsParamNull(TAG_NDUSEROBJECTID);
    }

    public final String getNDUSEROBJECTID() {
        return this.GetParamStringValue(TAG_NDUSEROBJECTID, "");
    }

    public final void setNDUSEROBJECTID(String strValue) {
        this.SetParamValue(TAG_NDUSEROBJECTID, strValue);
    }

    public final boolean isNDUSEROBJECTNAMENull() {
        return this.IsParamNull(TAG_NDUSEROBJECTNAME);
    }

    public final String getNDUSEROBJECTNAME() {
        return this.GetParamStringValue(TAG_NDUSEROBJECTNAME, "");
    }

    public final void setNDUSEROBJECTNAME(String strValue) {
        this.SetParamValue(TAG_NDUSEROBJECTNAME, strValue);
    }

    public final boolean isABLILITYNull() {
        return this.IsParamNull(TAG_ABLILITY);
    }

    public final int getABLILITY() {
        return this.GetParamIntValue(TAG_ABLILITY, 0);
    }

    public final void setABLILITY(int nValue) {
        this.SetParamValue(TAG_ABLILITY, nValue);
    }

    public final boolean isORGUNITIDNull() {
        return this.IsParamNull(TAG_ORGUNITID);
    }

    public final String getORGUNITID() {
        return this.GetParamStringValue(TAG_ORGUNITID, "");
    }

    public final void setORGUNITID(String strValue) {
        this.SetParamValue(TAG_ORGUNITID, strValue);
    }

    public final boolean isORGUNITNAMENull() {
        return this.IsParamNull(TAG_ORGUNITNAME);
    }

    public final String getORGUNITNAME() {
        return this.GetParamStringValue(TAG_ORGUNITNAME, "");
    }

    public final void setORGUNITNAME(String strValue) {
        this.SetParamValue(TAG_ORGUNITNAME, strValue);
    }

    public final boolean isORGTREENODEIDNull() {
        return this.IsParamNull(TAG_ORGTREENODEID);
    }

    public final String getORGTREENODEID() {
        return this.GetParamStringValue(TAG_ORGTREENODEID, "");
    }

    public final void setORGTREENODEID(String strValue) {
        this.SetParamValue(TAG_ORGTREENODEID, strValue);
    }

    public final boolean isORGTREENODENAMENull() {
        return this.IsParamNull(TAG_ORGTREENODENAME);
    }

    public final String getORGTREENODENAME() {
        return this.GetParamStringValue(TAG_ORGTREENODENAME, "");
    }

    public final void setORGTREENODENAME(String strValue) {
        this.SetParamValue(TAG_ORGTREENODENAME, strValue);
    }

    public final boolean isINCSUBDEPTNull() {
        return this.IsParamNull(TAG_INCSUBDEPT);
    }

    public final boolean getINCSUBDEPT() {
        return this.GetParamIntValue(TAG_INCSUBDEPT, 0) == 1;
    }

    public final void setINCSUBDEPT(boolean bValue) {
        this.SetParamValue(TAG_INCSUBDEPT, bValue ? 1 : 0);
    }

    public final boolean isDEPTMODENull() {
        return this.IsParamNull(TAG_DEPTMODE);
    }

    public final boolean getDEPTMODE() {
        return this.GetParamIntValue(TAG_DEPTMODE, 0) == 1;
    }

    public final void setDEPTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEPTMODE, bValue ? 1 : 0);
    }
}

