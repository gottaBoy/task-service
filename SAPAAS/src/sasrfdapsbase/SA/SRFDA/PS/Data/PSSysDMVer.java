/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDMVer
extends BaseDataEntity {
    public static final String TAG_PSSYSDMVERID = "PSSYSDMVERID";
    public static final String TAG_PSSYSDMVERNAME = "PSSYSDMVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_DMVER = "DMVER";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ACTIVEFLAG = "ACTIVEFLAG";

    public final boolean isPSSYSDMVERIDNull() {
        return this.IsParamNull(TAG_PSSYSDMVERID);
    }

    public final String getPSSYSDMVERID() {
        return this.GetParamStringValue(TAG_PSSYSDMVERID, "");
    }

    public final void setPSSYSDMVERID(String strValue) {
        this.SetParamValue(TAG_PSSYSDMVERID, strValue);
    }

    public final boolean isPSSYSDMVERNAMENull() {
        return this.IsParamNull(TAG_PSSYSDMVERNAME);
    }

    public final String getPSSYSDMVERNAME() {
        return this.GetParamStringValue(TAG_PSSYSDMVERNAME, "");
    }

    public final void setPSSYSDMVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDMVERNAME, strValue);
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

    public final boolean isDMVERNull() {
        return this.IsParamNull(TAG_DMVER);
    }

    public final int getDMVER() {
        return this.GetParamIntValue(TAG_DMVER, 0);
    }

    public final void setDMVER(int nValue) {
        this.SetParamValue(TAG_DMVER, nValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isACTIVEFLAGNull() {
        return this.IsParamNull(TAG_ACTIVEFLAG);
    }

    public final boolean getACTIVEFLAG() {
        return this.GetParamIntValue(TAG_ACTIVEFLAG, 0) == 1;
    }

    public final void setACTIVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_ACTIVEFLAG, bValue ? 1 : 0);
    }
}

