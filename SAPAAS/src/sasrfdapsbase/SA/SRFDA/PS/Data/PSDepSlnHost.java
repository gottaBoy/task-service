/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnHost
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String TAG_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PWD = "PWD";

    public final boolean isPSDEPSLNHOSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTID);
    }

    public final String getPSDEPSLNHOSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTID, "");
    }

    public final void setPSDEPSLNHOSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTID, strValue);
    }

    public final boolean isPSDEPSLNHOSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTNAME);
    }

    public final String getPSDEPSLNHOSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTNAME, "");
    }

    public final void setPSDEPSLNHOSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTNAME, strValue);
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

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
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

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isPWDNull() {
        return this.IsParamNull(TAG_PWD);
    }

    public final String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public final void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }
}

