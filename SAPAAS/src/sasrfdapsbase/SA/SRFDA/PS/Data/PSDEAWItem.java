/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEAWItem
extends BaseDataEntity {
    public static final String TAG_PSDEAWITEMID = "PSDEAWITEMID";
    public static final String TAG_PSDEAWITEMNAME = "PSDEAWITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String TAG_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ACTIONVALUE = "ACTIONVALUE";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MOREURL = "MOREURL";

    public final boolean isPSDEAWITEMIDNull() {
        return this.IsParamNull(TAG_PSDEAWITEMID);
    }

    public final String getPSDEAWITEMID() {
        return this.GetParamStringValue(TAG_PSDEAWITEMID, "");
    }

    public final void setPSDEAWITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEAWITEMID, strValue);
    }

    public final boolean isPSDEAWITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEAWITEMNAME);
    }

    public final String getPSDEAWITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEAWITEMNAME, "");
    }

    public final void setPSDEAWITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEAWITEMNAME, strValue);
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

    public final boolean isPSDEACTIONWIZARDIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDID);
    }

    public final String getPSDEACTIONWIZARDID() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDID, "");
    }

    public final void setPSDEACTIONWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDID, strValue);
    }

    public final boolean isPSDEACTIONWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDNAME);
    }

    public final String getPSDEACTIONWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDNAME, "");
    }

    public final void setPSDEACTIONWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
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

    public final boolean isACTIONVALUENull() {
        return this.IsParamNull(TAG_ACTIONVALUE);
    }

    public final String getACTIONVALUE() {
        return this.GetParamStringValue(TAG_ACTIONVALUE, "");
    }

    public final void setACTIONVALUE(String strValue) {
        this.SetParamValue(TAG_ACTIONVALUE, strValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
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

    public final boolean isMOREURLNull() {
        return this.IsParamNull(TAG_MOREURL);
    }

    public final String getMOREURL() {
        return this.GetParamStringValue(TAG_MOREURL, "");
    }

    public final void setMOREURL(String strValue) {
        this.SetParamValue(TAG_MOREURL, strValue);
    }
}

