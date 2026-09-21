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

public class TMBookingTest
extends BaseDataEntity {
    public static final String TMBOOKINGTESTTYPE_MAINTASK_TRAINING = "MAINTASK_TRAINING";
    public static final String TAG_TMBOOKINGTESTID = "TMBOOKINGTESTID";
    public static final String TAG_TMBOOKINGTESTNAME = "TMBOOKINGTESTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBOOKINGTESTTYPE = "TMBOOKINGTESTTYPE";
    public static final String TAG_TMBTPRJINSTID = "TMBTPRJINSTID";
    public static final String TAG_TMBTPRJINSTNAME = "TMBTPRJINSTNAME";
    public static final String TAG_TMBTPRJMTID = "TMBTPRJMTID";
    public static final String TAG_TMBTPRJMTNAME = "TMBTPRJMTNAME";
    public static final String TAG_EXTRACTFLAG = "EXTRACTFLAG";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_MAXDURATION = "MAXDURATION";

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

    public boolean isTMBOOKINGTESTTYPENull() {
        return this.IsParamNull(TAG_TMBOOKINGTESTTYPE);
    }

    public String getTMBOOKINGTESTTYPE() {
        return this.GetParamStringValue(TAG_TMBOOKINGTESTTYPE, "");
    }

    public void setTMBOOKINGTESTTYPE(String strValue) {
        this.SetParamValue(TAG_TMBOOKINGTESTTYPE, strValue);
    }

    public boolean isTMBTPRJINSTIDNull() {
        return this.IsParamNull(TAG_TMBTPRJINSTID);
    }

    public String getTMBTPRJINSTID() {
        return this.GetParamStringValue(TAG_TMBTPRJINSTID, "");
    }

    public void setTMBTPRJINSTID(String strValue) {
        this.SetParamValue(TAG_TMBTPRJINSTID, strValue);
    }

    public boolean isTMBTPRJINSTNAMENull() {
        return this.IsParamNull(TAG_TMBTPRJINSTNAME);
    }

    public String getTMBTPRJINSTNAME() {
        return this.GetParamStringValue(TAG_TMBTPRJINSTNAME, "");
    }

    public void setTMBTPRJINSTNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPRJINSTNAME, strValue);
    }

    public boolean isTMBTPRJMTIDNull() {
        return this.IsParamNull(TAG_TMBTPRJMTID);
    }

    public String getTMBTPRJMTID() {
        return this.GetParamStringValue(TAG_TMBTPRJMTID, "");
    }

    public void setTMBTPRJMTID(String strValue) {
        this.SetParamValue(TAG_TMBTPRJMTID, strValue);
    }

    public boolean isTMBTPRJMTNAMENull() {
        return this.IsParamNull(TAG_TMBTPRJMTNAME);
    }

    public String getTMBTPRJMTNAME() {
        return this.GetParamStringValue(TAG_TMBTPRJMTNAME, "");
    }

    public void setTMBTPRJMTNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPRJMTNAME, strValue);
    }

    public boolean isEXTRACTFLAGNull() {
        return this.IsParamNull(TAG_EXTRACTFLAG);
    }

    public boolean getEXTRACTFLAG() {
        return this.GetParamIntValue(TAG_EXTRACTFLAG, 0) == 1;
    }

    public void setEXTRACTFLAG(boolean bValue) {
        this.SetParamValue(TAG_EXTRACTFLAG, bValue ? 1 : 0);
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

