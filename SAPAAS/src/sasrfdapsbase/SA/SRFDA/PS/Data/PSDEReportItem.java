/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEReportItem
extends BaseDataEntity {
    public static final String TAG_PSDEREPITEMID = "PSDEREPITEMID";
    public static final String TAG_PSDEREPITEMNAME = "PSDEREPITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSDEREPORTID = "MAJORPSDEREPORTID";
    public static final String TAG_MAJORPSDEREPORTNAME = "MAJORPSDEREPORTNAME";
    public static final String TAG_MINORPSDEREPORTID = "MINORPSDEREPORTID";
    public static final String TAG_MINORPSDEREPORTNAME = "MINORPSDEREPORTNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSDEID = "PSDEID";

    public final boolean isPSDEREPITEMIDNull() {
        return this.IsParamNull(TAG_PSDEREPITEMID);
    }

    public final String getPSDEREPITEMID() {
        return this.GetParamStringValue(TAG_PSDEREPITEMID, "");
    }

    public final void setPSDEREPITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEREPITEMID, strValue);
    }

    public final boolean isPSDEREPITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEREPITEMNAME);
    }

    public final String getPSDEREPITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEREPITEMNAME, "");
    }

    public final void setPSDEREPITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEREPITEMNAME, strValue);
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

    public final boolean isMAJORPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEREPORTID);
    }

    public final String getMAJORPSDEREPORTID() {
        return this.GetParamStringValue(TAG_MAJORPSDEREPORTID, "");
    }

    public final void setMAJORPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEREPORTID, strValue);
    }

    public final boolean isMAJORPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEREPORTNAME);
    }

    public final String getMAJORPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEREPORTNAME, "");
    }

    public final void setMAJORPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEREPORTNAME, strValue);
    }

    public final boolean isMINORPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_MINORPSDEREPORTID);
    }

    public final String getMINORPSDEREPORTID() {
        return this.GetParamStringValue(TAG_MINORPSDEREPORTID, "");
    }

    public final void setMINORPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEREPORTID, strValue);
    }

    public final boolean isMINORPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEREPORTNAME);
    }

    public final String getMINORPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEREPORTNAME, "");
    }

    public final void setMINORPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEREPORTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }
}

