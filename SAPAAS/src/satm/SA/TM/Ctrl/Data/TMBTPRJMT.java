/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMBTPRJMT
extends BaseDataEntity {
    public static final String TMBTPRJMTTYPE_BOOKINGPLAN_TRAINING = "BOOKINGPLAN_TRAINING";
    public static final String TMBTPRJMTTYPE_CRMCLASSTASK = "CRMCLASSTASK";
    public static final String TMBTPRJMTTYPE_CRMTRAININGTASK = "CRMTRAININGTASK";
    public static final String TAG_TMBTPRJMTID = "TMBTPRJMTID";
    public static final String TAG_TMBTPRJMTNAME = "TMBTPRJMTNAME";
    public static final String TAG_TMBTPRJMTTYPE = "TMBTPRJMTTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTPRJID = "TMBTPRJID";
    public static final String TAG_TMBTPRJNAME = "TMBTPRJNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_EXTRACTFLAG = "EXTRACTFLAG";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_FLYCNT = "FLYCNT";
    public static final String TAG_CREWCNT = "CREWCNT";
    public static final String TAG_SECURITYCNT = "SECURITYCNT";
    public static final String TAG_CRMCOURSEID = "CRMCOURSEID";
    public static final String TAG_CRMCOURSENAME = "CRMCOURSENAME";

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

    public boolean isTMBTPRJMTTYPENull() {
        return this.IsParamNull(TAG_TMBTPRJMTTYPE);
    }

    public String getTMBTPRJMTTYPE() {
        return this.GetParamStringValue(TAG_TMBTPRJMTTYPE, "");
    }

    public void setTMBTPRJMTTYPE(String strValue) {
        this.SetParamValue(TAG_TMBTPRJMTTYPE, strValue);
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

    public boolean isTMBTPRJIDNull() {
        return this.IsParamNull(TAG_TMBTPRJID);
    }

    public String getTMBTPRJID() {
        return this.GetParamStringValue(TAG_TMBTPRJID, "");
    }

    public void setTMBTPRJID(String strValue) {
        this.SetParamValue(TAG_TMBTPRJID, strValue);
    }

    public boolean isTMBTPRJNAMENull() {
        return this.IsParamNull(TAG_TMBTPRJNAME);
    }

    public String getTMBTPRJNAME() {
        return this.GetParamStringValue(TAG_TMBTPRJNAME, "");
    }

    public void setTMBTPRJNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPRJNAME, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
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

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public boolean isFLYCNTNull() {
        return this.IsParamNull(TAG_FLYCNT);
    }

    public int getFLYCNT() {
        return this.GetParamIntValue(TAG_FLYCNT, 0);
    }

    public void setFLYCNT(int nValue) {
        this.SetParamValue(TAG_FLYCNT, nValue);
    }

    public boolean isCREWCNTNull() {
        return this.IsParamNull(TAG_CREWCNT);
    }

    public int getCREWCNT() {
        return this.GetParamIntValue(TAG_CREWCNT, 0);
    }

    public void setCREWCNT(int nValue) {
        this.SetParamValue(TAG_CREWCNT, nValue);
    }

    public boolean isSECURITYCNTNull() {
        return this.IsParamNull(TAG_SECURITYCNT);
    }

    public int getSECURITYCNT() {
        return this.GetParamIntValue(TAG_SECURITYCNT, 0);
    }

    public void setSECURITYCNT(int nValue) {
        this.SetParamValue(TAG_SECURITYCNT, nValue);
    }

    public boolean isCRMCOURSEIDNull() {
        return this.IsParamNull(TAG_CRMCOURSEID);
    }

    public String getCRMCOURSEID() {
        return this.GetParamStringValue(TAG_CRMCOURSEID, "");
    }

    public void setCRMCOURSEID(String strValue) {
        this.SetParamValue(TAG_CRMCOURSEID, strValue);
    }

    public boolean isCRMCOURSENAMENull() {
        return this.IsParamNull(TAG_CRMCOURSENAME);
    }

    public String getCRMCOURSENAME() {
        return this.GetParamStringValue(TAG_CRMCOURSENAME, "");
    }

    public void setCRMCOURSENAME(String strValue) {
        this.SetParamValue(TAG_CRMCOURSENAME, strValue);
    }
}

