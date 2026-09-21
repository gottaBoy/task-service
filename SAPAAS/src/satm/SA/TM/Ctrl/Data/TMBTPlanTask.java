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

public class TMBTPlanTask
extends BaseDataEntity {
    public static final String TAG_TMBTPLANTASKID = "TMBTPLANTASKID";
    public static final String TAG_TMBTPLANTASKNAME = "TMBTPLANTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTPLANID = "TMBTPLANID";
    public static final String TAG_TMBTPLANNAME = "TMBTPLANNAME";
    public static final String TAG_TMBTTASKID = "TMBTTASKID";
    public static final String TAG_TMBTTASKNAME = "TMBTTASKNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_TMBOOKINGTESTID = "TMBOOKINGTESTID";
    public static final String TAG_TASKSN = "TASKSN";
    public static final String TAG_TMBTPLANMTID = "TMBTPLANMTID";
    public static final String TAG_TMBTPLANMTNAME = "TMBTPLANMTNAME";
    public static final String TAG_IGNOREARRANGE = "IGNOREARRANGE";
    public static final String TAG_TASKRESINFO = "TASKRESINFO";

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

    public boolean isTMBTTASKIDNull() {
        return this.IsParamNull(TAG_TMBTTASKID);
    }

    public String getTMBTTASKID() {
        return this.GetParamStringValue(TAG_TMBTTASKID, "");
    }

    public void setTMBTTASKID(String strValue) {
        this.SetParamValue(TAG_TMBTTASKID, strValue);
    }

    public boolean isTMBTTASKNAMENull() {
        return this.IsParamNull(TAG_TMBTTASKNAME);
    }

    public String getTMBTTASKNAME() {
        return this.GetParamStringValue(TAG_TMBTTASKNAME, "");
    }

    public void setTMBTTASKNAME(String strValue) {
        this.SetParamValue(TAG_TMBTTASKNAME, strValue);
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

    public boolean isTMBOOKINGTESTIDNull() {
        return this.IsParamNull(TAG_TMBOOKINGTESTID);
    }

    public String getTMBOOKINGTESTID() {
        return this.GetParamStringValue(TAG_TMBOOKINGTESTID, "");
    }

    public void setTMBOOKINGTESTID(String strValue) {
        this.SetParamValue(TAG_TMBOOKINGTESTID, strValue);
    }

    public boolean isTASKSNNull() {
        return this.IsParamNull(TAG_TASKSN);
    }

    public String getTASKSN() {
        return this.GetParamStringValue(TAG_TASKSN, "");
    }

    public void setTASKSN(String strValue) {
        this.SetParamValue(TAG_TASKSN, strValue);
    }

    public boolean isTMBTPLANMTIDNull() {
        return this.IsParamNull(TAG_TMBTPLANMTID);
    }

    public String getTMBTPLANMTID() {
        return this.GetParamStringValue(TAG_TMBTPLANMTID, "");
    }

    public void setTMBTPLANMTID(String strValue) {
        this.SetParamValue(TAG_TMBTPLANMTID, strValue);
    }

    public boolean isTMBTPLANMTNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANMTNAME);
    }

    public String getTMBTPLANMTNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANMTNAME, "");
    }

    public void setTMBTPLANMTNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANMTNAME, strValue);
    }

    public boolean isIGNOREARRANGENull() {
        return this.IsParamNull(TAG_IGNOREARRANGE);
    }

    public boolean getIGNOREARRANGE() {
        return this.GetParamIntValue(TAG_IGNOREARRANGE, 0) == 1;
    }

    public void setIGNOREARRANGE(boolean bValue) {
        this.SetParamValue(TAG_IGNOREARRANGE, bValue ? 1 : 0);
    }

    public boolean isTASKRESINFONull() {
        return this.IsParamNull(TAG_TASKRESINFO);
    }

    public String getTASKRESINFO() {
        return this.GetParamStringValue(TAG_TASKRESINFO, "");
    }

    public void setTASKRESINFO(String strValue) {
        this.SetParamValue(TAG_TASKRESINFO, strValue);
    }
}

