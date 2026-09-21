/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMBTType
extends BaseDataEntity {
    public static final String TAG_TMBTTYPEID = "TMBTTYPEID";
    public static final String TAG_TMBTTYPENAME = "TMBTTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_OBJECTHELPER = "OBJECTHELPER";
    public static final String TAG_TASKOBJECT = "TASKOBJECT";
    public static final String TAG_TASKOBJECTPARAM = "TASKOBJECTPARAM";
    public static final String TAG_TASKINSTOBJECT = "TASKINSTOBJECT";
    public static final String TAG_TASKINSTOBJECTPARAM = "TASKINSTOBJECTPARAM";

    public boolean isTMBTTYPEIDNull() {
        return this.IsParamNull(TAG_TMBTTYPEID);
    }

    public String getTMBTTYPEID() {
        return this.GetParamStringValue(TAG_TMBTTYPEID, "");
    }

    public void setTMBTTYPEID(String strValue) {
        this.SetParamValue(TAG_TMBTTYPEID, strValue);
    }

    public boolean isTMBTTYPENAMENull() {
        return this.IsParamNull(TAG_TMBTTYPENAME);
    }

    public String getTMBTTYPENAME() {
        return this.GetParamStringValue(TAG_TMBTTYPENAME, "");
    }

    public void setTMBTTYPENAME(String strValue) {
        this.SetParamValue(TAG_TMBTTYPENAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isOBJECTHELPERNull() {
        return this.IsParamNull(TAG_OBJECTHELPER);
    }

    public String getOBJECTHELPER() {
        return this.GetParamStringValue(TAG_OBJECTHELPER, "");
    }

    public void setOBJECTHELPER(String strValue) {
        this.SetParamValue(TAG_OBJECTHELPER, strValue);
    }

    public boolean isTASKOBJECTNull() {
        return this.IsParamNull(TAG_TASKOBJECT);
    }

    public String getTASKOBJECT() {
        return this.GetParamStringValue(TAG_TASKOBJECT, "");
    }

    public void setTASKOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKOBJECT, strValue);
    }

    public boolean isTASKOBJECTPARAMNull() {
        return this.IsParamNull(TAG_TASKOBJECTPARAM);
    }

    public String getTASKOBJECTPARAM() {
        return this.GetParamStringValue(TAG_TASKOBJECTPARAM, "");
    }

    public void setTASKOBJECTPARAM(String strValue) {
        this.SetParamValue(TAG_TASKOBJECTPARAM, strValue);
    }

    public boolean isTASKINSTOBJECTNull() {
        return this.IsParamNull(TAG_TASKINSTOBJECT);
    }

    public String getTASKINSTOBJECT() {
        return this.GetParamStringValue(TAG_TASKINSTOBJECT, "");
    }

    public void setTASKINSTOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKINSTOBJECT, strValue);
    }

    public boolean isTASKINSTOBJECTPARAMNull() {
        return this.IsParamNull(TAG_TASKINSTOBJECTPARAM);
    }

    public String getTASKINSTOBJECTPARAM() {
        return this.GetParamStringValue(TAG_TASKINSTOBJECTPARAM, "");
    }

    public void setTASKINSTOBJECTPARAM(String strValue) {
        this.SetParamValue(TAG_TASKINSTOBJECTPARAM, strValue);
    }
}

