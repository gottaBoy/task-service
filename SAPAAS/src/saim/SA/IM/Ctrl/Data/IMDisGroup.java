/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMDisGroup
extends BaseDataEntity {
    public static final String DISGROUPTYPE_PUBLIC = "PUBLIC";
    public static final String DISGROUPTYPE_PRIVATE = "PRIVATE";
    public static final String TAG_IMDISGROUPID = "IMDISGROUPID";
    public static final String TAG_IMDISGROUPNAME = "IMDISGROUPNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_LOCKEDFLAG = "LOCKEDFLAG";
    public static final String TAG_DISGROUPTYPE = "DISGROUPTYPE";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";

    public final boolean isIMDISGROUPIDNull() {
        return this.IsParamNull(TAG_IMDISGROUPID);
    }

    public final String getIMDISGROUPID() {
        return this.GetParamStringValue(TAG_IMDISGROUPID, "");
    }

    public final void setIMDISGROUPID(String strValue) {
        this.SetParamValue(TAG_IMDISGROUPID, strValue);
    }

    public final boolean isIMDISGROUPNAMENull() {
        return this.IsParamNull(TAG_IMDISGROUPNAME);
    }

    public final String getIMDISGROUPNAME() {
        return this.GetParamStringValue(TAG_IMDISGROUPNAME, "");
    }

    public final void setIMDISGROUPNAME(String strValue) {
        this.SetParamValue(TAG_IMDISGROUPNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
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

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isLOCKEDFLAGNull() {
        return this.IsParamNull(TAG_LOCKEDFLAG);
    }

    public final boolean getLOCKEDFLAG() {
        return this.GetParamIntValue(TAG_LOCKEDFLAG, 0) == 1;
    }

    public final void setLOCKEDFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKEDFLAG, bValue ? 1 : 0);
    }

    public final boolean isDISGROUPTYPENull() {
        return this.IsParamNull(TAG_DISGROUPTYPE);
    }

    public final String getDISGROUPTYPE() {
        return this.GetParamStringValue(TAG_DISGROUPTYPE, "");
    }

    public final void setDISGROUPTYPE(String strValue) {
        this.SetParamValue(TAG_DISGROUPTYPE, strValue);
    }

    public final boolean isIMUSERIDNull() {
        return this.IsParamNull(TAG_IMUSERID);
    }

    public final String getIMUSERID() {
        return this.GetParamStringValue(TAG_IMUSERID, "");
    }

    public final void setIMUSERID(String strValue) {
        this.SetParamValue(TAG_IMUSERID, strValue);
    }

    public final boolean isIMUSERNAMENull() {
        return this.IsParamNull(TAG_IMUSERNAME);
    }

    public final String getIMUSERNAME() {
        return this.GetParamStringValue(TAG_IMUSERNAME, "");
    }

    public final void setIMUSERNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERNAME, strValue);
    }
}

