/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PrivObjType
extends BaseDataEntity {
    public static final String TAG_PRIVOBJTYPEID = "PRIVOBJTYPEID";
    public static final String TAG_PRIVOBJTYPENAME = "PRIVOBJTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TYPEHELPER = "TYPEHELPER";
    public static final String TAG_OBJHELPER = "OBJHELPER";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPRIVOBJTYPEIDNull() {
        return this.IsParamNull(TAG_PRIVOBJTYPEID);
    }

    public final String getPRIVOBJTYPEID() {
        return this.GetParamStringValue(TAG_PRIVOBJTYPEID, "");
    }

    public final void setPRIVOBJTYPEID(String strValue) {
        this.SetParamValue(TAG_PRIVOBJTYPEID, strValue);
    }

    public final boolean isPRIVOBJTYPENAMENull() {
        return this.IsParamNull(TAG_PRIVOBJTYPENAME);
    }

    public final String getPRIVOBJTYPENAME() {
        return this.GetParamStringValue(TAG_PRIVOBJTYPENAME, "");
    }

    public final void setPRIVOBJTYPENAME(String strValue) {
        this.SetParamValue(TAG_PRIVOBJTYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isTYPEHELPERNull() {
        return this.IsParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.GetParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.SetParamValue(TAG_TYPEHELPER, strValue);
    }

    public final boolean isOBJHELPERNull() {
        return this.IsParamNull(TAG_OBJHELPER);
    }

    public final String getOBJHELPER() {
        return this.GetParamStringValue(TAG_OBJHELPER, "");
    }

    public final void setOBJHELPER(String strValue) {
        this.SetParamValue(TAG_OBJHELPER, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

