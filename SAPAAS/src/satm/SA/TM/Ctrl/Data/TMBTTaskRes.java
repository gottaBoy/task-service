/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMBTTaskRes
extends BaseDataEntity {
    public static final String TASKRESTYPE_TEACHER = "TEACHER";
    public static final String TASKRESTYPE_TEACHER2 = "TEACHER2";
    public static final String TASKRESTYPE_CLASSROOM = "CLASSROOM";
    public static final String TASKRESTYPE_SIMULATOR = "SIMULATOR";
    public static final String TASKRESTYPE_TEACHER3 = "TEACHER3";
    public static final String TASKRESTYPE_TEACHER4 = "TEACHER4";
    public static final String TASKRESTYPE_CABINDEVICE = "CABINDEVICE";
    public static final String TASKRESTYPE_CABINDEVICE2 = "CABINDEVICE2";
    public static final String TASKRESTYPE_CABINDEVICE3 = "CABINDEVICE3";
    public static final String TASKRESTYPE_CABINDEVICE4 = "CABINDEVICE4";
    public static final String TASKRESTYPE_CABINDEVICE5 = "CABINDEVICE5";
    public static final String TASKRESTYPE_CABINDEVICE6 = "CABINDEVICE6";
    public static final String TASKRESTYPE_CABINDEVICE7 = "CABINDEVICE7";
    public static final String TASKRESTYPE_CABINDEVICE8 = "CABINDEVICE8";
    public static final String TASKRESTYPE_CABINDEVICE9 = "CABINDEVICE9";
    public static final String TASKRESTYPE_TEACHER5 = "TEACHER5";
    public static final String TASKRESTYPE_TEACHER6 = "TEACHER6";
    public static final String TASKRESTYPE_TEACHER7 = "TEACHER7";
    public static final String TASKRESTYPE_TEACHER8 = "TEACHER8";
    public static final String TASKRESTYPE_TEACHER9 = "TEACHER9";
    public static final String TASKRESTYPE_CLASSROOM2 = "CLASSROOM2";
    public static final String TASKRESTYPE_CLASSROOM3 = "CLASSROOM3";
    public static final String TASKRESTYPE_CLASSROOM4 = "CLASSROOM4";
    public static final String TAG_TMBTTASKRESID = "TMBTTASKRESID";
    public static final String TAG_TMBTTASKRESNAME = "TMBTTASKRESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTTASKID = "TMBTTASKID";
    public static final String TAG_TMBTTASKNAME = "TMBTTASKNAME";
    public static final String TAG_TMRESCATALOGID = "TMRESCATALOGID";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";
    public static final String TAG_DURATION = "DURATION";
    public static final String TAG_TASKRESTYPE = "TASKRESTYPE";
    public static final String REQUIREMODE_NECESSARY = "NECESSARY";
    public static final String REQUIREMODE_OPTIONAL = "OPTIONAL";
    public static final String TAG_REQUIREMODE = "REQUIREMODE";

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

    public boolean isTMRESCATALOGIDNull() {
        return this.IsParamNull(TAG_TMRESCATALOGID);
    }

    public String getTMRESCATALOGID() {
        return this.GetParamStringValue(TAG_TMRESCATALOGID, "");
    }

    public void setTMRESCATALOGID(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGID, strValue);
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

    public boolean isDURATIONNull() {
        return this.IsParamNull(TAG_DURATION);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int nValue) {
        this.SetParamValue(TAG_DURATION, nValue);
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

    public boolean isREQUIREMODENull() {
        return this.IsParamNull(TAG_REQUIREMODE);
    }

    public String getREQUIREMODE() {
        return this.GetParamStringValue(TAG_REQUIREMODE, "");
    }

    public void setREQUIREMODE(String strValue) {
        this.SetParamValue(TAG_REQUIREMODE, strValue);
    }
}

