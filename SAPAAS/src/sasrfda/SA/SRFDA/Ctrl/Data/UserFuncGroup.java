/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserFuncGroup
extends BaseDataEntity {
    public static final String TAG_USERFUNCGROUPID = "USERFUNCGROUPID";
    public static final String TAG_USERFUNCGROUPNAME = "USERFUNCGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUSERFUNCGROUPID = "PUSERFUNCGROUPID";
    public static final String TAG_PUSERFUNCGROUPNAME = "PUSERFUNCGROUPNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";

    public final boolean isUSERFUNCGROUPIDNull() {
        return this.IsParamNull(TAG_USERFUNCGROUPID);
    }

    public final String getUSERFUNCGROUPID() {
        return this.GetParamStringValue(TAG_USERFUNCGROUPID, "");
    }

    public final void setUSERFUNCGROUPID(String strValue) {
        this.SetParamValue(TAG_USERFUNCGROUPID, strValue);
    }

    public final boolean isUSERFUNCGROUPNAMENull() {
        return this.IsParamNull(TAG_USERFUNCGROUPNAME);
    }

    public final String getUSERFUNCGROUPNAME() {
        return this.GetParamStringValue(TAG_USERFUNCGROUPNAME, "");
    }

    public final void setUSERFUNCGROUPNAME(String strValue) {
        this.SetParamValue(TAG_USERFUNCGROUPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPUSERFUNCGROUPIDNull() {
        return this.IsParamNull(TAG_PUSERFUNCGROUPID);
    }

    public final String getPUSERFUNCGROUPID() {
        return this.GetParamStringValue(TAG_PUSERFUNCGROUPID, "");
    }

    public final void setPUSERFUNCGROUPID(String strValue) {
        this.SetParamValue(TAG_PUSERFUNCGROUPID, strValue);
    }

    public final boolean isPUSERFUNCGROUPNAMENull() {
        return this.IsParamNull(TAG_PUSERFUNCGROUPNAME);
    }

    public final String getPUSERFUNCGROUPNAME() {
        return this.GetParamStringValue(TAG_PUSERFUNCGROUPNAME, "");
    }

    public final void setPUSERFUNCGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PUSERFUNCGROUPNAME, strValue);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }
}

