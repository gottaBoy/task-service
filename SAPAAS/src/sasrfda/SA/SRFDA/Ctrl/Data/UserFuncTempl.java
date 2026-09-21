/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserFuncTempl
extends BaseDataEntity {
    public static final String TAG_USERFUNCTEMPLID = "USERFUNCTEMPLID";
    public static final String TAG_USERFUNCTEMPLNAME = "USERFUNCTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERFUNCGROUPID = "USERFUNCGROUPID";
    public static final String TAG_USERFUNCGROUPNAME = "USERFUNCGROUPNAME";
    public static final String TAG_ABILITYCLID = "ABILITYCLID";
    public static final String TAG_ABILITYCLNAME = "ABILITYCLNAME";
    public static final String TAG_DATARANGECLID = "DATARANGECLID";
    public static final String TAG_DATARANGECLNAME = "DATARANGECLNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FUNCSN = "FUNCSN";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_SHORTNAME = "SHORTNAME";

    public final boolean isUSERFUNCTEMPLIDNull() {
        return this.IsParamNull(TAG_USERFUNCTEMPLID);
    }

    public final String getUSERFUNCTEMPLID() {
        return this.GetParamStringValue(TAG_USERFUNCTEMPLID, "");
    }

    public final void setUSERFUNCTEMPLID(String strValue) {
        this.SetParamValue(TAG_USERFUNCTEMPLID, strValue);
    }

    public final boolean isUSERFUNCTEMPLNAMENull() {
        return this.IsParamNull(TAG_USERFUNCTEMPLNAME);
    }

    public final String getUSERFUNCTEMPLNAME() {
        return this.GetParamStringValue(TAG_USERFUNCTEMPLNAME, "");
    }

    public final void setUSERFUNCTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_USERFUNCTEMPLNAME, strValue);
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

    public final boolean isABILITYCLIDNull() {
        return this.IsParamNull(TAG_ABILITYCLID);
    }

    public final String getABILITYCLID() {
        return this.GetParamStringValue(TAG_ABILITYCLID, "");
    }

    public final void setABILITYCLID(String strValue) {
        this.SetParamValue(TAG_ABILITYCLID, strValue);
    }

    public final boolean isABILITYCLNAMENull() {
        return this.IsParamNull(TAG_ABILITYCLNAME);
    }

    public final String getABILITYCLNAME() {
        return this.GetParamStringValue(TAG_ABILITYCLNAME, "");
    }

    public final void setABILITYCLNAME(String strValue) {
        this.SetParamValue(TAG_ABILITYCLNAME, strValue);
    }

    public final boolean isDATARANGECLIDNull() {
        return this.IsParamNull(TAG_DATARANGECLID);
    }

    public final String getDATARANGECLID() {
        return this.GetParamStringValue(TAG_DATARANGECLID, "");
    }

    public final void setDATARANGECLID(String strValue) {
        this.SetParamValue(TAG_DATARANGECLID, strValue);
    }

    public final boolean isDATARANGECLNAMENull() {
        return this.IsParamNull(TAG_DATARANGECLNAME);
    }

    public final String getDATARANGECLNAME() {
        return this.GetParamStringValue(TAG_DATARANGECLNAME, "");
    }

    public final void setDATARANGECLNAME(String strValue) {
        this.SetParamValue(TAG_DATARANGECLNAME, strValue);
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

    public final boolean isFUNCSNNull() {
        return this.IsParamNull(TAG_FUNCSN);
    }

    public final String getFUNCSN() {
        return this.GetParamStringValue(TAG_FUNCSN, "");
    }

    public final void setFUNCSN(String strValue) {
        this.SetParamValue(TAG_FUNCSN, strValue);
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

    public final boolean isSHORTNAMENull() {
        return this.IsParamNull(TAG_SHORTNAME);
    }

    public final String getSHORTNAME() {
        return this.GetParamStringValue(TAG_SHORTNAME, "");
    }

    public final void setSHORTNAME(String strValue) {
        this.SetParamValue(TAG_SHORTNAME, strValue);
    }
}

