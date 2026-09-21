/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMBTPlanCal
extends BaseDataEntity {
    public static final String RESBOOKINGTYPE_TASKRESBOOKING = "TASKRESBOOKING";
    public static final String RESBOOKINGTYPE_COMPLEXRESBOOKING = "COMPLEXRESBOOKING";
    public static final String RESBOOKINGTYPE_MAINTAINBOOKING = "MAINTAINBOOKING";
    public static final String RESBOOKINGTYPE_VACATIONBOOKING = "VACATIONBOOKING";
    public static final String TAG_TMBTPLANCALID = "TMBTPLANCALID";
    public static final String TAG_TMBTPLANCALNAME = "TMBTPLANCALNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTPLANNAME = "TMBTPLANNAME";
    public static final String TAG_TMBTPLANID = "TMBTPLANID";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";
    public static final String TAG_TMBTTASKID = "TMBTTASKID";
    public static final String TAG_TMBTTASKNAME = "TMBTTASKNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_EXCLUSIVEFLAG = "EXCLUSIVEFLAG";
    public static final String TAG_RESBOOKINGTYPE = "RESBOOKINGTYPE";
    public static final String TAG_TMTASKBASEID = "TMTASKBASEID";
    public static final String TAG_TMTASKBASENAME = "TMTASKBASENAME";
    public static final String TAG_TMRESBOOKINGID = "TMRESBOOKINGID";
    public static final String TAG_TMRESBOOKINGNAME = "TMRESBOOKINGNAME";
    public static final String TAG_PTMBTPLANCALID = "PTMBTPLANCALID";
    public static final String TAG_PTMBTPLANCALNAME = "PTMBTPLANCALNAME";

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

    public boolean isTMBTPLANNAMENull() {
        return this.IsParamNull(TAG_TMBTPLANNAME);
    }

    public String getTMBTPLANNAME() {
        return this.GetParamStringValue(TAG_TMBTPLANNAME, "");
    }

    public void setTMBTPLANNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPLANNAME, strValue);
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

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
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

    public boolean isEXCLUSIVEFLAGNull() {
        return this.IsParamNull(TAG_EXCLUSIVEFLAG);
    }

    public boolean getEXCLUSIVEFLAG() {
        return this.GetParamIntValue(TAG_EXCLUSIVEFLAG, 0) == 1;
    }

    public void setEXCLUSIVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_EXCLUSIVEFLAG, bValue ? 1 : 0);
    }

    public boolean isRESBOOKINGTYPENull() {
        return this.IsParamNull(TAG_RESBOOKINGTYPE);
    }

    public String getRESBOOKINGTYPE() {
        return this.GetParamStringValue(TAG_RESBOOKINGTYPE, "");
    }

    public void setRESBOOKINGTYPE(String strValue) {
        this.SetParamValue(TAG_RESBOOKINGTYPE, strValue);
    }

    public boolean isTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_TMTASKBASEID);
    }

    public String getTMTASKBASEID() {
        return this.GetParamStringValue(TAG_TMTASKBASEID, "");
    }

    public void setTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_TMTASKBASEID, strValue);
    }

    public boolean isTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_TMTASKBASENAME);
    }

    public String getTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_TMTASKBASENAME, "");
    }

    public void setTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKBASENAME, strValue);
    }

    public boolean isTMRESBOOKINGIDNull() {
        return this.IsParamNull(TAG_TMRESBOOKINGID);
    }

    public String getTMRESBOOKINGID() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGID, "");
    }

    public void setTMRESBOOKINGID(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGID, strValue);
    }

    public boolean isTMRESBOOKINGNAMENull() {
        return this.IsParamNull(TAG_TMRESBOOKINGNAME);
    }

    public String getTMRESBOOKINGNAME() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGNAME, "");
    }

    public void setTMRESBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGNAME, strValue);
    }

    public boolean isPTMBTPLANCALIDNull() {
        return this.IsParamNull(TAG_PTMBTPLANCALID);
    }

    public String getPTMBTPLANCALID() {
        return this.GetParamStringValue(TAG_PTMBTPLANCALID, "");
    }

    public void setPTMBTPLANCALID(String strValue) {
        this.SetParamValue(TAG_PTMBTPLANCALID, strValue);
    }

    public boolean isPTMBTPLANCALNAMENull() {
        return this.IsParamNull(TAG_PTMBTPLANCALNAME);
    }

    public String getPTMBTPLANCALNAME() {
        return this.GetParamStringValue(TAG_PTMBTPLANCALNAME, "");
    }

    public void setPTMBTPLANCALNAME(String strValue) {
        this.SetParamValue(TAG_PTMBTPLANCALNAME, strValue);
    }
}

