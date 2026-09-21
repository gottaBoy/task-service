/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFormItemVR
extends BaseDataEntity {
    public static final int CHECKMODE_FRONT = 1;
    public static final int CHECKMODE_BACKEND = 2;
    public static final int CHECKMODE_ALL = 3;
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";
    public static final String TAG_PSDEFIVRID = "PSDEFIVRID";
    public static final String TAG_PSDEFIVRNAME = "PSDEFIVRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFIID = "PSDEFIID";
    public static final String TAG_PSDEFINAME = "PSDEFINAME";
    public static final String TAG_PSDEFVRID = "PSDEFVRID";
    public static final String TAG_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CHECKMODE = "CHECKMODE";
    public static final String TAG_VRTYPE = "VRTYPE";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_MODELSTATE = "MODELSTATE";

    public final boolean isPSDEFIVRIDNull() {
        return this.IsParamNull(TAG_PSDEFIVRID);
    }

    public final String getPSDEFIVRID() {
        return this.GetParamStringValue(TAG_PSDEFIVRID, "");
    }

    public final void setPSDEFIVRID(String strValue) {
        this.SetParamValue(TAG_PSDEFIVRID, strValue);
    }

    public final boolean isPSDEFIVRNAMENull() {
        return this.IsParamNull(TAG_PSDEFIVRNAME);
    }

    public final String getPSDEFIVRNAME() {
        return this.GetParamStringValue(TAG_PSDEFIVRNAME, "");
    }

    public final void setPSDEFIVRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIVRNAME, strValue);
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

    public final boolean isPSDEFIIDNull() {
        return this.IsParamNull(TAG_PSDEFIID);
    }

    public final String getPSDEFIID() {
        return this.GetParamStringValue(TAG_PSDEFIID, "");
    }

    public final void setPSDEFIID(String strValue) {
        this.SetParamValue(TAG_PSDEFIID, strValue);
    }

    public final boolean isPSDEFINAMENull() {
        return this.IsParamNull(TAG_PSDEFINAME);
    }

    public final String getPSDEFINAME() {
        return this.GetParamStringValue(TAG_PSDEFINAME, "");
    }

    public final void setPSDEFINAME(String strValue) {
        this.SetParamValue(TAG_PSDEFINAME, strValue);
    }

    public final boolean isPSDEFVRIDNull() {
        return this.IsParamNull(TAG_PSDEFVRID);
    }

    public final String getPSDEFVRID() {
        return this.GetParamStringValue(TAG_PSDEFVRID, "");
    }

    public final void setPSDEFVRID(String strValue) {
        this.SetParamValue(TAG_PSDEFVRID, strValue);
    }

    public final boolean isPSDEFVRNAMENull() {
        return this.IsParamNull(TAG_PSDEFVRNAME);
    }

    public final String getPSDEFVRNAME() {
        return this.GetParamStringValue(TAG_PSDEFVRNAME, "");
    }

    public final void setPSDEFVRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVRNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
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

    public final boolean isCHECKMODENull() {
        return this.IsParamNull(TAG_CHECKMODE);
    }

    public final int getCHECKMODE() {
        return this.GetParamIntValue(TAG_CHECKMODE, 0);
    }

    public final void setCHECKMODE(int nValue) {
        this.SetParamValue(TAG_CHECKMODE, nValue);
    }

    public final boolean isVRTYPENull() {
        return this.IsParamNull(TAG_VRTYPE);
    }

    public final String getVRTYPE() {
        return this.GetParamStringValue(TAG_VRTYPE, "");
    }

    public final void setVRTYPE(String strValue) {
        this.SetParamValue(TAG_VRTYPE, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isMODELSTATENull() {
        return this.IsParamNull(TAG_MODELSTATE);
    }

    public final int getMODELSTATE() {
        return this.GetParamIntValue(TAG_MODELSTATE, 0);
    }

    public final void setMODELSTATE(int nValue) {
        this.SetParamValue(TAG_MODELSTATE, nValue);
    }
}

