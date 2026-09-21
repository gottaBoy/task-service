/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFPluginTempl
extends BaseDataEntity {
    public static final String TAG_PSSFPLUGINTEMPLID = "PSSFPLUGINTEMPLID";
    public static final String TAG_PSSFPLUGINTEMPLNAME = "PSSFPLUGINTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String TAG_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSFPLUGINTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSFPLUGINTEMPLID);
    }

    public final String getPSSFPLUGINTEMPLID() {
        return this.GetParamStringValue(TAG_PSSFPLUGINTEMPLID, "");
    }

    public final void setPSSFPLUGINTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINTEMPLID, strValue);
    }

    public final boolean isPSSFPLUGINTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSFPLUGINTEMPLNAME);
    }

    public final String getPSSFPLUGINTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSFPLUGINTEMPLNAME, "");
    }

    public final void setPSSFPLUGINTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINTEMPLNAME, strValue);
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

    public final boolean isPSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSFPLUGINID);
    }

    public final String getPSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSFPLUGINID, "");
    }

    public final void setPSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINID, strValue);
    }

    public final boolean isPSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSFPLUGINNAME);
    }

    public final String getPSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSFPLUGINNAME, "");
    }

    public final void setPSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINNAME, strValue);
    }

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
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

