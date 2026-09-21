/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemAS
extends BaseDataEntity {
    public static final String ASID_AS01 = "AS01";
    public static final String ASID_AS02 = "AS02";
    public static final String ASID_AS03 = "AS03";
    public static final String ASID_AS04 = "AS04";
    public static final String ASTYPE_TOMCAT7 = "TOMCAT7";
    public static final String TAG_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String TAG_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String TAG_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ASID = "ASID";
    public static final String TAG_ASTYPE = "ASTYPE";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";

    public final boolean isPSSYSTEMASIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMASID);
    }

    public final String getPSSYSTEMASID() {
        return this.GetParamStringValue(TAG_PSSYSTEMASID, "");
    }

    public final void setPSSYSTEMASID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASID, strValue);
    }

    public final boolean isPSSYSTEMASNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMASNAME);
    }

    public final String getPSSYSTEMASNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMASNAME, "");
    }

    public final void setPSSYSTEMASNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isASIDNull() {
        return this.IsParamNull(TAG_ASID);
    }

    public final String getASID() {
        return this.GetParamStringValue(TAG_ASID, "");
    }

    public final void setASID(String strValue) {
        this.SetParamValue(TAG_ASID, strValue);
    }

    public final boolean isASTYPENull() {
        return this.IsParamNull(TAG_ASTYPE);
    }

    public final String getASTYPE() {
        return this.GetParamStringValue(TAG_ASTYPE, "");
    }

    public final void setASTYPE(String strValue) {
        this.SetParamValue(TAG_ASTYPE, strValue);
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
}

