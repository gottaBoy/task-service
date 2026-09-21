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

public class TMBTPlanMT
extends BaseDataEntity {
    public static final String TAG_TMBTPLANMTID = "TMBTPLANMTID";
    public static final String TAG_TMBTPLANMTNAME = "TMBTPLANMTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_TMBTPLANID = "TMBTPLANID";
    public static final String TAG_TMBTPLANNAME = "TMBTPLANNAME";
    public static final String TAG_TMBOOKINGTESTID = "TMBOOKINGTESTID";
    public static final String TAG_TMBOOKINGTESTNAME = "TMBOOKINGTESTNAME";
    public static final String TAG_PTMBTPLANID = "PTMBTPLANID";
    public static final String TAG_MAXDURATION = "MAXDURATION";

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

    public boolean isTMBOOKINGTESTIDNull() {
        return this.IsParamNull(TAG_TMBOOKINGTESTID);
    }

    public String getTMBOOKINGTESTID() {
        return this.GetParamStringValue(TAG_TMBOOKINGTESTID, "");
    }

    public void setTMBOOKINGTESTID(String strValue) {
        this.SetParamValue(TAG_TMBOOKINGTESTID, strValue);
    }

    public boolean isTMBOOKINGTESTNAMENull() {
        return this.IsParamNull(TAG_TMBOOKINGTESTNAME);
    }

    public String getTMBOOKINGTESTNAME() {
        return this.GetParamStringValue(TAG_TMBOOKINGTESTNAME, "");
    }

    public void setTMBOOKINGTESTNAME(String strValue) {
        this.SetParamValue(TAG_TMBOOKINGTESTNAME, strValue);
    }

    public boolean isPTMBTPLANIDNull() {
        return this.IsParamNull(TAG_PTMBTPLANID);
    }

    public String getPTMBTPLANID() {
        return this.GetParamStringValue(TAG_PTMBTPLANID, "");
    }

    public void setPTMBTPLANID(String strValue) {
        this.SetParamValue(TAG_PTMBTPLANID, strValue);
    }

    public boolean isMAXDURATIONNull() {
        return this.IsParamNull(TAG_MAXDURATION);
    }

    public int getMAXDURATION() {
        return this.GetParamIntValue(TAG_MAXDURATION, 0);
    }

    public void setMAXDURATION(int nValue) {
        this.SetParamValue(TAG_MAXDURATION, nValue);
    }
}

