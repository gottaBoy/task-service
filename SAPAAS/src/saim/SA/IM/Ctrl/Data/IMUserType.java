/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMUserType
extends BaseDataEntity {
    public static final String TAG_IMUSERTYPEID = "IMUSERTYPEID";
    public static final String TAG_IMUSERTYPENAME = "IMUSERTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARTICIPANTOBJ = "PARTICIPANTOBJ";
    public static final String TAG_SESSIONOBJ = "SESSIONOBJ";

    public boolean isIMUSERTYPEIDNull() {
        return this.IsParamNull(TAG_IMUSERTYPEID);
    }

    public String getIMUSERTYPEID() {
        return this.GetParamStringValue(TAG_IMUSERTYPEID, "");
    }

    public void setIMUSERTYPEID(String strValue) {
        this.SetParamValue(TAG_IMUSERTYPEID, strValue);
    }

    public boolean isIMUSERTYPENAMENull() {
        return this.IsParamNull(TAG_IMUSERTYPENAME);
    }

    public String getIMUSERTYPENAME() {
        return this.GetParamStringValue(TAG_IMUSERTYPENAME, "");
    }

    public void setIMUSERTYPENAME(String strValue) {
        this.SetParamValue(TAG_IMUSERTYPENAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public boolean isPARTICIPANTOBJNull() {
        return this.IsParamNull(TAG_PARTICIPANTOBJ);
    }

    public String getPARTICIPANTOBJ() {
        return this.GetParamStringValue(TAG_PARTICIPANTOBJ, "");
    }

    public void setPARTICIPANTOBJ(String strValue) {
        this.SetParamValue(TAG_PARTICIPANTOBJ, strValue);
    }

    public boolean isSESSIONOBJNull() {
        return this.IsParamNull(TAG_SESSIONOBJ);
    }

    public String getSESSIONOBJ() {
        return this.GetParamStringValue(TAG_SESSIONOBJ, "");
    }

    public void setSESSIONOBJ(String strValue) {
        this.SetParamValue(TAG_SESSIONOBJ, strValue);
    }
}

