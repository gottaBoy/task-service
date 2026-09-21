/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSFPluginTempl
extends BaseDataEntity {
    public static final String TAG_PSSYSSFPITEMPLID = "PSSYSSFPITEMPLID";
    public static final String TAG_PSSYSSFPITEMPLNAME = "PSSYSSFPITEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String TAG_TEMPLCODEEX = "TEMPLCODEEX";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_TEMPLCODE5 = "TEMPLCODE5";
    public static final String TAG_TEMPLCODE6 = "TEMPLCODE6";
    public static final String TAG_CODEMAP = "CODEMAP";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";

    public final boolean isPSSYSSFPITEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPITEMPLID);
    }

    public final String getPSSYSSFPITEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSSFPITEMPLID, "");
    }

    public final void setPSSYSSFPITEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPITEMPLID, strValue);
    }

    public final boolean isPSSYSSFPITEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPITEMPLNAME);
    }

    public final String getPSSYSSFPITEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPITEMPLNAME, "");
    }

    public final void setPSSYSSFPITEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPITEMPLNAME, strValue);
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

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
    }

    public final boolean isTEMPLCODE2EXNull() {
        return this.IsParamNull(TAG_TEMPLCODE2EX);
    }

    public final String getTEMPLCODE2EX() {
        return this.GetParamStringValue(TAG_TEMPLCODE2EX, "");
    }

    public final void setTEMPLCODE2EX(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2EX, strValue);
    }

    public final boolean isTEMPLCODEEXNull() {
        return this.IsParamNull(TAG_TEMPLCODEEX);
    }

    public final String getTEMPLCODEEX() {
        return this.GetParamStringValue(TAG_TEMPLCODEEX, "");
    }

    public final void setTEMPLCODEEX(String strValue) {
        this.SetParamValue(TAG_TEMPLCODEEX, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.IsParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.GetParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.IsParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.GetParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE4, strValue);
    }

    public final boolean isTEMPLCODE5Null() {
        return this.IsParamNull(TAG_TEMPLCODE5);
    }

    public final String getTEMPLCODE5() {
        return this.GetParamStringValue(TAG_TEMPLCODE5, "");
    }

    public final void setTEMPLCODE5(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE5, strValue);
    }

    public final boolean isTEMPLCODE6Null() {
        return this.IsParamNull(TAG_TEMPLCODE6);
    }

    public final String getTEMPLCODE6() {
        return this.GetParamStringValue(TAG_TEMPLCODE6, "");
    }

    public final void setTEMPLCODE6(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE6, strValue);
    }

    public final boolean isCODEMAPNull() {
        return this.IsParamNull(TAG_CODEMAP);
    }

    public final String getCODEMAP() {
        return this.GetParamStringValue(TAG_CODEMAP, "");
    }

    public final void setCODEMAP(String strValue) {
        this.SetParamValue(TAG_CODEMAP, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }
}

