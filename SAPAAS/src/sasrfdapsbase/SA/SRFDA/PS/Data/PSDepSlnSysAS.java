/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnSysAS
extends BaseDataEntity {
    public static final String SERVICECONTAINER_SC01 = "SC01";
    public static final String SERVICECONTAINER_SC02 = "SC02";
    public static final String SERVICECONTAINER_SC03 = "SC03";
    public static final String SERVICECONTAINER_SC04 = "SC04";
    public static final String CONTAINERTYPE_AS = "AS";
    public static final String CONTAINERTYPE_ASGROUP = "ASGROUP";
    public static final String TAG_PSDEPSLNSYSASID = "PSDEPSLNSYSASID";
    public static final String TAG_PSDEPSLNSYSASNAME = "PSDEPSLNSYSASNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String TAG_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String TAG_SERVICECONTAINER = "SERVICECONTAINER";
    public static final String TAG_PSDEPSLNASGRPID = "PSDEPSLNASGRPID";
    public static final String TAG_PSDEPSLNASGRPNAME = "PSDEPSLNASGRPNAME";
    public static final String TAG_PSDEPSYSAPPID = "PSDEPSYSAPPID";
    public static final String TAG_PSDEPSYSAPPNAME = "PSDEPSYSAPPNAME";
    public static final String TAG_NO2PSDEPSYSAPPID = "NO2PSDEPSYSAPPID";
    public static final String TAG_NO2PSDEPSYSAPPNAME = "NO2PSDEPSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String TAG_PSDEPSLNASID = "PSDEPSLNASID";
    public static final String TAG_PSDEPSLNASNAME = "PSDEPSLNASNAME";

    public final boolean isPSDEPSLNSYSASIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSASID);
    }

    public final String getPSDEPSLNSYSASID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSASID, "");
    }

    public final void setPSDEPSLNSYSASID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSASID, strValue);
    }

    public final boolean isPSDEPSLNSYSASNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSASNAME);
    }

    public final String getPSDEPSLNSYSASNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSASNAME, "");
    }

    public final void setPSDEPSLNSYSASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSASNAME, strValue);
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

    public final boolean isSERVICECONTAINERNull() {
        return this.IsParamNull(TAG_SERVICECONTAINER);
    }

    public final String getSERVICECONTAINER() {
        return this.GetParamStringValue(TAG_SERVICECONTAINER, "");
    }

    public final void setSERVICECONTAINER(String strValue) {
        this.SetParamValue(TAG_SERVICECONTAINER, strValue);
    }

    public final boolean isPSDEPSLNASGRPIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNASGRPID);
    }

    public final String getPSDEPSLNASGRPID() {
        return this.GetParamStringValue(TAG_PSDEPSLNASGRPID, "");
    }

    public final void setPSDEPSLNASGRPID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASGRPID, strValue);
    }

    public final boolean isPSDEPSLNASGRPNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNASGRPNAME);
    }

    public final String getPSDEPSLNASGRPNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNASGRPNAME, "");
    }

    public final void setPSDEPSLNASGRPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASGRPNAME, strValue);
    }

    public final boolean isPSDEPSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSAPPID);
    }

    public final String getPSDEPSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEPSYSAPPID, "");
    }

    public final void setPSDEPSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSAPPID, strValue);
    }

    public final boolean isPSDEPSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSAPPNAME);
    }

    public final String getPSDEPSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSAPPNAME, "");
    }

    public final void setPSDEPSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSAPPNAME, strValue);
    }

    public final boolean isNO2PSDEPSYSAPPIDNull() {
        return this.IsParamNull(TAG_NO2PSDEPSYSAPPID);
    }

    public final String getNO2PSDEPSYSAPPID() {
        return this.GetParamStringValue(TAG_NO2PSDEPSYSAPPID, "");
    }

    public final void setNO2PSDEPSYSAPPID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEPSYSAPPID, strValue);
    }

    public final boolean isNO2PSDEPSYSAPPNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEPSYSAPPNAME);
    }

    public final String getNO2PSDEPSYSAPPNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEPSYSAPPNAME, "");
    }

    public final void setNO2PSDEPSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEPSYSAPPNAME, strValue);
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

    public final boolean isPSDEPSLNASIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNASID);
    }

    public final String getPSDEPSLNASID() {
        return this.GetParamStringValue(TAG_PSDEPSLNASID, "");
    }

    public final void setPSDEPSLNASID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASID, strValue);
    }

    public final boolean isPSDEPSLNASNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNASNAME);
    }

    public final String getPSDEPSLNASNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNASNAME, "");
    }

    public final void setPSDEPSLNASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNASNAME, strValue);
    }

    public final boolean isCONTAINERTYPENull() {
        return this.IsParamNull(TAG_CONTAINERTYPE);
    }

    public final String getCONTAINERTYPE() {
        return this.GetParamStringValue(TAG_CONTAINERTYPE, "");
    }

    public final void setCONTAINERTYPE(String strValue) {
        this.SetParamValue(TAG_CONTAINERTYPE, strValue);
    }
}

