/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMBTTask
extends BaseDataEntity {
    public static final String TMBTTASKTYPE_BOOKINGPLAN_TRAINING = "BOOKINGPLAN_TRAINING";
    public static final String TMBTTASKTYPE_CRMCLASSTASK = "CRMCLASSTASK";
    public static final String TMBTTASKTYPE_CRMTRAININGTASK = "CRMTRAININGTASK";
    public static final int IMPORTANCEFLAG_0 = 0;
    public static final int IMPORTANCEFLAG_50 = 50;
    public static final int IMPORTANCEFLAG_100 = 100;
    public static final int IMPORTANCEFLAG_150 = 150;
    public static final int IMPORTANCEFLAG_200 = 200;
    public static final String TAG_TMBTTASKID = "TMBTTASKID";
    public static final String TAG_TMBTTASKNAME = "TMBTTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBOOKINGTESTNAME = "TMBOOKINGTESTNAME";
    public static final String TAG_TMBOOKINGTESTID = "TMBOOKINGTESTID";
    public static final String TAG_TMBTTASKGROUPID = "TMBTTASKGROUPID";
    public static final String TAG_TMBTTASKGROUPNAME = "TMBTTASKGROUPNAME";
    public static final String TAG_TASKSN = "TASKSN";
    public static final String TAG_FRONTTASKSN = "FRONTTASKSN";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_TMBTTASKTYPE = "TMBTTASKTYPE";
    public static final String TAG_DURATION = "DURATION";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_IGNOREARRANGE = "IGNOREARRANGE";

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

    public boolean isTMBOOKINGTESTNAMENull() {
        return this.IsParamNull(TAG_TMBOOKINGTESTNAME);
    }

    public String getTMBOOKINGTESTNAME() {
        return this.GetParamStringValue(TAG_TMBOOKINGTESTNAME, "");
    }

    public void setTMBOOKINGTESTNAME(String strValue) {
        this.SetParamValue(TAG_TMBOOKINGTESTNAME, strValue);
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

    public boolean isTMBTTASKGROUPIDNull() {
        return this.IsParamNull(TAG_TMBTTASKGROUPID);
    }

    public String getTMBTTASKGROUPID() {
        return this.GetParamStringValue(TAG_TMBTTASKGROUPID, "");
    }

    public void setTMBTTASKGROUPID(String strValue) {
        this.SetParamValue(TAG_TMBTTASKGROUPID, strValue);
    }

    public boolean isTMBTTASKGROUPNAMENull() {
        return this.IsParamNull(TAG_TMBTTASKGROUPNAME);
    }

    public String getTMBTTASKGROUPNAME() {
        return this.GetParamStringValue(TAG_TMBTTASKGROUPNAME, "");
    }

    public void setTMBTTASKGROUPNAME(String strValue) {
        this.SetParamValue(TAG_TMBTTASKGROUPNAME, strValue);
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

    public boolean isFRONTTASKSNNull() {
        return this.IsParamNull(TAG_FRONTTASKSN);
    }

    public String getFRONTTASKSN() {
        return this.GetParamStringValue(TAG_FRONTTASKSN, "");
    }

    public void setFRONTTASKSN(String strValue) {
        this.SetParamValue(TAG_FRONTTASKSN, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isTMBTTASKTYPENull() {
        return this.IsParamNull(TAG_TMBTTASKTYPE);
    }

    public String getTMBTTASKTYPE() {
        return this.GetParamStringValue(TAG_TMBTTASKTYPE, "");
    }

    public void setTMBTTASKTYPE(String strValue) {
        this.SetParamValue(TAG_TMBTTASKTYPE, strValue);
    }

    public boolean isDURATIONNull() {
        return this.IsParamNull(TAG_DURATION);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int nValue) {
        this.SetParamValue(TAG_DURATION, nValue);
    }

    public boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setIMPORTANCEFLAG(int nValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, nValue);
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
}

