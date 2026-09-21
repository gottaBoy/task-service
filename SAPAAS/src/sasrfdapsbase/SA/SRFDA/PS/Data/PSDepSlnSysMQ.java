/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnSysMQ
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNSYSMQID = "PSDEPSLNSYSMQID";
    public static final String TAG_PSDEPSLNSYSMQNAME = "PSDEPSLNSYSMQNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String TAG_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String TAG_PSDEPSLNMQINSTID = "PSDEPSLNMQINSTID";
    public static final String TAG_PSDEPSLNMQINSTNAME = "PSDEPSLNMQINSTNAME";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";

    public final boolean isPSDEPSLNSYSMQIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSMQID);
    }

    public final String getPSDEPSLNSYSMQID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSMQID, "");
    }

    public final void setPSDEPSLNSYSMQID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSMQID, strValue);
    }

    public final boolean isPSDEPSLNSYSMQNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSMQNAME);
    }

    public final String getPSDEPSLNSYSMQNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSMQNAME, "");
    }

    public final void setPSDEPSLNSYSMQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSMQNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEPSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSID);
    }

    public final String getPSDEPSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSID, "");
    }

    public final void setPSDEPSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSID, strValue);
    }

    public final boolean isPSDEPSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSNAME);
    }

    public final String getPSDEPSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSNAME, "");
    }

    public final void setPSDEPSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSNAME, strValue);
    }

    public final boolean isPSDEPSLNMQINSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNMQINSTID);
    }

    public final String getPSDEPSLNMQINSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNMQINSTID, "");
    }

    public final void setPSDEPSLNMQINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNMQINSTID, strValue);
    }

    public final boolean isPSDEPSLNMQINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNMQINSTNAME);
    }

    public final String getPSDEPSLNMQINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNMQINSTNAME, "");
    }

    public final void setPSDEPSLNMQINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNMQINSTNAME, strValue);
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
}

