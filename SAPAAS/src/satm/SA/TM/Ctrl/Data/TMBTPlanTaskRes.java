/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class TMBTPlanTaskRes
extends BaseDataEntity {
    public static final String TAG_TMBTPLANTASKRESID = "TMBTPLANTASKRESID";
    public static final String TAG_TMBTPLANTASKRESNAME = "TMBTPLANTASKRESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTPLANTASKID = "TMBTPLANTASKID";
    public static final String TAG_TMBTPLANTASKNAME = "TMBTPLANTASKNAME";
    public static final String TAG_TMBTPLANID = "TMBTPLANID";
    public static final String TAG_TMBTPLANNAME = "TMBTPLANNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_CUSTOMTRTIME = "CUSTOMTRTIME";
    public static final String TAG_TMBTTASKRESID = "TMBTTASKRESID";
    public static final String TAG_TMBTTASKRESNAME = "TMBTTASKRESNAME";
    public static final String TAG_TMRESCDID = "TMRESCDID";
    public static final String TAG_TMRESCDNAME = "TMRESCDNAME";
    public static final String TAG_TMBTPLANCALID = "TMBTPLANCALID";
    public static final String TAG_TMBTPLANCALNAME = "TMBTPLANCALNAME";
    public static final String TAG_TASKRESTYPE = "TASKRESTYPE";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";

    public boolean isTMBTPLANTASKRESIDNull() {
        return this.IsParamNull(TAG_TMBTPLANTASKRESID);
    }

    public String getTMBTPLANTASKRESID() {
        return this.GetParamStringValue(TAG_TMBTPLANTASKRESID, "");
    }

    public void setTMBTPLANTASKRESID(String strValue) {
        this.SetParamValue(TAG_TMBTPLANTASKRESID, strValue);
    }

    public boolean isTMBTPLANTASKRESNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANTASKRESNAME);
    }

    public String getTMBTPLANTASKRESNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANTASKRESNAME, "");
    }

    public void setTMBTPLANTASKRESNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANTASKRESNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isTMBTPLANTASKIDNull() {
        return this.IsParamNull(TAG_TMBTPLANTASKID);
    }

    public String getTMBTPLANTASKID() {
        return this.GetParamStringValue(TAG_TMBTPLANTASKID, "");
    }

    public void setTMBTPLANTASKID(String strValue) {
        this.SetParamValue(TAG_TMBTPLANTASKID, strValue);
    }

    public boolean isTMBTPLANTASKNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANTASKNAME);
    }

    public String getTMBTPLANTASKNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANTASKNAME, "");
    }

    public void setTMBTPLANTASKNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANTASKNAME, strValue);
    }

    public boolean isTMBTPLANIDNull() {
        return this.IsParamNull(TAG_TMBTPLANID);
    }

    public String getTMBTPLANID() {
        return this.GetParamStringValue(TAG_TMBTPLANID, "");
    }

    public void setTMBTPLANID(String strValue) {
        this.SetParamValue(TAG_TMBTPLANID, strValue);
    }

    public boolean isTMBTPLANNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANNAME);
    }

    public String getTMBTPLANNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANNAME, "");
    }

    public void setTMBTPLANNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANNAME, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Timestamp getBEGINTIME() {
        return this.GetParamTimestampValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Timestamp getENDTIME() {
        return this.GetParamTimestampValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public boolean isCUSTOMTRTIMENull() {
        return this.IsParamNull(TAG_CUSTOMTRTIME);
    }

    public boolean getCUSTOMTRTIME() {
        return this.GetParamIntValue(TAG_CUSTOMTRTIME, 0) == 1;
    }

    public void setCUSTOMTRTIME(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMTRTIME, bValue ? 1 : 0);
    }

    public boolean isTMBTTASKRESIDNull() {
        return this.IsParamNull(TAG_TMBTTASKRESID);
    }

    public String getTMBTTASKRESID() {
        return this.GetParamStringValue(TAG_TMBTTASKRESID, "");
    }

    public void setTMBTTASKRESID(String strValue) {
        this.SetParamValue(TAG_TMBTTASKRESID, strValue);
    }

    public boolean isTMBTTASKRESNAMENull() {
        return this.IsParamNull(TAG_TMBTTASKRESNAME);
    }

    public String getTMBTTASKRESNAME() {
        return this.GetParamStringValue(TAG_TMBTTASKRESNAME, "");
    }

    public void setTMBTTASKRESNAME(String strValue) {
        this.SetParamValue(TAG_TMBTTASKRESNAME, strValue);
    }

    public boolean isTMRESCDIDNull() {
        return this.IsParamNull(TAG_TMRESCDID);
    }

    public String getTMRESCDID() {
        return this.GetParamStringValue(TAG_TMRESCDID, "");
    }

    public void setTMRESCDID(String strValue) {
        this.SetParamValue(TAG_TMRESCDID, strValue);
    }

    public boolean isTMRESCDNAMENull() {
        return this.IsParamNull(TAG_TMRESCDNAME);
    }

    public String getTMRESCDNAME() {
        return this.GetParamStringValue(TAG_TMRESCDNAME, "");
    }

    public void setTMRESCDNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCDNAME, strValue);
    }

    public boolean isTMBTPLANCALIDNull() {
        return this.IsParamNull(TAG_TMBTPLANCALID);
    }

    public String getTMBTPLANCALID() {
        return this.GetParamStringValue(TAG_TMBTPLANCALID, "");
    }

    public void setTMBTPLANCALID(String strValue) {
        this.SetParamValue(TAG_TMBTPLANCALID, strValue);
    }

    public boolean isTMBTPLANCALNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANCALNAME);
    }

    public String getTMBTPLANCALNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANCALNAME, "");
    }

    public void setTMBTPLANCALNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANCALNAME, strValue);
    }

    public boolean isTASKRESTYPENull() {
        return this.IsParamNull(TAG_TASKRESTYPE);
    }

    public String getTASKRESTYPE() {
        return this.GetParamStringValue(TAG_TASKRESTYPE, "");
    }

    public void setTASKRESTYPE(String strValue) {
        this.SetParamValue(TAG_TASKRESTYPE, strValue);
    }

    public boolean isTMRESCATALOGNAMENull() {
        return this.IsParamNull(TAG_TMRESCATALOGNAME);
    }

    public String getTMRESCATALOGNAME() {
        return this.GetParamStringValue(TAG_TMRESCATALOGNAME, "");
    }

    public void setTMRESCATALOGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGNAME, strValue);
    }
}

