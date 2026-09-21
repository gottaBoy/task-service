/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFVerCodeItem
extends BaseDataEntity {
    public static final String TAG_PSSFVERCODEITEMID = "PSSFVERCODEITEMID";
    public static final String TAG_PSSFVERCODEITEMNAME = "PSSFVERCODEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFVERCODEID = "PSSFVERCODEID";
    public static final String TAG_PSSFVERCODENAME = "PSSFVERCODENAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSFVERCODEITEMIDNull() {
        return this.IsParamNull(TAG_PSSFVERCODEITEMID);
    }

    public final String getPSSFVERCODEITEMID() {
        return this.GetParamStringValue(TAG_PSSFVERCODEITEMID, "");
    }

    public final void setPSSFVERCODEITEMID(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODEITEMID, strValue);
    }

    public final boolean isPSSFVERCODEITEMNAMENull() {
        return this.IsParamNull(TAG_PSSFVERCODEITEMNAME);
    }

    public final String getPSSFVERCODEITEMNAME() {
        return this.GetParamStringValue(TAG_PSSFVERCODEITEMNAME, "");
    }

    public final void setPSSFVERCODEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODEITEMNAME, strValue);
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

    public final boolean isPSSFVERCODEIDNull() {
        return this.IsParamNull(TAG_PSSFVERCODEID);
    }

    public final String getPSSFVERCODEID() {
        return this.GetParamStringValue(TAG_PSSFVERCODEID, "");
    }

    public final void setPSSFVERCODEID(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODEID, strValue);
    }

    public final boolean isPSSFVERCODENAMENull() {
        return this.IsParamNull(TAG_PSSFVERCODENAME);
    }

    public final String getPSSFVERCODENAME() {
        return this.GetParamStringValue(TAG_PSSFVERCODENAME, "");
    }

    public final void setPSSFVERCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSFVERCODENAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
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

