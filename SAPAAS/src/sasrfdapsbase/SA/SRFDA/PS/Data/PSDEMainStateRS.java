/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMainStateRS
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSDEMAINSTATERSID = "PSDEMAINSTATERSID";
    public static final String TAG_PSDEMAINSTATERSNAME = "PSDEMAINSTATERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PREVPSDEMSID = "PREVPSDEMSID";
    public static final String TAG_PREVPSDEMSNAME = "PREVPSDEMSNAME";
    public static final String TAG_NEXTPSDEMSID = "NEXTPSDEMSID";
    public static final String TAG_NEXTPSDEMSNAME = "NEXTPSDEMSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ENTERPSDEACTIONID = "ENTERPSDEACTIONID";
    public static final String TAG_ENTERPSDEACTIONNAME = "ENTERPSDEACTIONNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSDEMAINSTATERSIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATERSID);
    }

    public final String getPSDEMAINSTATERSID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATERSID, "");
    }

    public final void setPSDEMAINSTATERSID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATERSID, strValue);
    }

    public final boolean isPSDEMAINSTATERSNAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATERSNAME);
    }

    public final String getPSDEMAINSTATERSNAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATERSNAME, "");
    }

    public final void setPSDEMAINSTATERSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATERSNAME, strValue);
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

    public final boolean isPREVPSDEMSIDNull() {
        return this.IsParamNull(TAG_PREVPSDEMSID);
    }

    public final String getPREVPSDEMSID() {
        return this.GetParamStringValue(TAG_PREVPSDEMSID, "");
    }

    public final void setPREVPSDEMSID(String strValue) {
        this.SetParamValue(TAG_PREVPSDEMSID, strValue);
    }

    public final boolean isPREVPSDEMSNAMENull() {
        return this.IsParamNull(TAG_PREVPSDEMSNAME);
    }

    public final String getPREVPSDEMSNAME() {
        return this.GetParamStringValue(TAG_PREVPSDEMSNAME, "");
    }

    public final void setPREVPSDEMSNAME(String strValue) {
        this.SetParamValue(TAG_PREVPSDEMSNAME, strValue);
    }

    public final boolean isNEXTPSDEMSIDNull() {
        return this.IsParamNull(TAG_NEXTPSDEMSID);
    }

    public final String getNEXTPSDEMSID() {
        return this.GetParamStringValue(TAG_NEXTPSDEMSID, "");
    }

    public final void setNEXTPSDEMSID(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEMSID, strValue);
    }

    public final boolean isNEXTPSDEMSNAMENull() {
        return this.IsParamNull(TAG_NEXTPSDEMSNAME);
    }

    public final String getNEXTPSDEMSNAME() {
        return this.GetParamStringValue(TAG_NEXTPSDEMSNAME, "");
    }

    public final void setNEXTPSDEMSNAME(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEMSNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isENTERPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_ENTERPSDEACTIONID);
    }

    public final String getENTERPSDEACTIONID() {
        return this.GetParamStringValue(TAG_ENTERPSDEACTIONID, "");
    }

    public final void setENTERPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_ENTERPSDEACTIONID, strValue);
    }

    public final boolean isENTERPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_ENTERPSDEACTIONNAME);
    }

    public final String getENTERPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_ENTERPSDEACTIONNAME, "");
    }

    public final void setENTERPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_ENTERPSDEACTIONNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }
}

