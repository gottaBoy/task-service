/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCRobotAbility
extends BaseDataEntity {
    public static final String ROBOTWORKTYPE_C_A = "C_A";
    public static final String TAG_PSDCROBOTABILITYID = "PSDCROBOTABILITYID";
    public static final String TAG_PSDCROBOTABILITYNAME = "PSDCROBOTABILITYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCROBOTID = "PSDCROBOTID";
    public static final String TAG_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String TAG_ROBOTWORKTYPE = "ROBOTWORKTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ENERGY = "ENERGY";

    public final boolean isPSDCROBOTABILITYIDNull() {
        return this.IsParamNull(TAG_PSDCROBOTABILITYID);
    }

    public final String getPSDCROBOTABILITYID() {
        return this.GetParamStringValue(TAG_PSDCROBOTABILITYID, "");
    }

    public final void setPSDCROBOTABILITYID(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTABILITYID, strValue);
    }

    public final boolean isPSDCROBOTABILITYNAMENull() {
        return this.IsParamNull(TAG_PSDCROBOTABILITYNAME);
    }

    public final String getPSDCROBOTABILITYNAME() {
        return this.GetParamStringValue(TAG_PSDCROBOTABILITYNAME, "");
    }

    public final void setPSDCROBOTABILITYNAME(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTABILITYNAME, strValue);
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

    public final boolean isPSDCROBOTIDNull() {
        return this.IsParamNull(TAG_PSDCROBOTID);
    }

    public final String getPSDCROBOTID() {
        return this.GetParamStringValue(TAG_PSDCROBOTID, "");
    }

    public final void setPSDCROBOTID(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTID, strValue);
    }

    public final boolean isPSDCROBOTNAMENull() {
        return this.IsParamNull(TAG_PSDCROBOTNAME);
    }

    public final String getPSDCROBOTNAME() {
        return this.GetParamStringValue(TAG_PSDCROBOTNAME, "");
    }

    public final void setPSDCROBOTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCROBOTNAME, strValue);
    }

    public final boolean isROBOTWORKTYPENull() {
        return this.IsParamNull(TAG_ROBOTWORKTYPE);
    }

    public final String getROBOTWORKTYPE() {
        return this.GetParamStringValue(TAG_ROBOTWORKTYPE, "");
    }

    public final void setROBOTWORKTYPE(String strValue) {
        this.SetParamValue(TAG_ROBOTWORKTYPE, strValue);
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

    public final boolean isEXPIREDTIMENull() {
        return this.IsParamNull(TAG_EXPIREDTIME);
    }

    public final Date getEXPIREDTIME() {
        return this.GetParamDateValue(TAG_EXPIREDTIME, null);
    }

    public final void setEXPIREDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPIREDTIME, dtValue);
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

    public final boolean isENERGYNull() {
        return this.IsParamNull(TAG_ENERGY);
    }

    public final int getENERGY() {
        return this.GetParamIntValue(TAG_ENERGY, 0);
    }

    public final void setENERGY(int nValue) {
        this.SetParamValue(TAG_ENERGY, nValue);
    }
}

