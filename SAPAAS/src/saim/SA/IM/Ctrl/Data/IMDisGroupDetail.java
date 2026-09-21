/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMDisGroupDetail
extends BaseDataEntity {
    public static final String TAG_IMDISGRPDETAILID = "IMDISGRPDETAILID";
    public static final String TAG_IMDISGRPDETAILNAME = "IMDISGRPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMDISGROUPID = "IMDISGROUPID";
    public static final String TAG_IMDISGROUPNAME = "IMDISGROUPNAME";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_ADMINFLAG = "ADMINFLAG";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isIMDISGRPDETAILIDNull() {
        return this.IsParamNull(TAG_IMDISGRPDETAILID);
    }

    public final String getIMDISGRPDETAILID() {
        return this.GetParamStringValue(TAG_IMDISGRPDETAILID, "");
    }

    public final void setIMDISGRPDETAILID(String strValue) {
        this.SetParamValue(TAG_IMDISGRPDETAILID, strValue);
    }

    public final boolean isIMDISGRPDETAILNAMENull() {
        return this.IsParamNull(TAG_IMDISGRPDETAILNAME);
    }

    public final String getIMDISGRPDETAILNAME() {
        return this.GetParamStringValue(TAG_IMDISGRPDETAILNAME, "");
    }

    public final void setIMDISGRPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_IMDISGRPDETAILNAME, strValue);
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

    public final boolean isIMDISGROUPIDNull() {
        return this.IsParamNull(TAG_IMDISGROUPID);
    }

    public final String getIMDISGROUPID() {
        return this.GetParamStringValue(TAG_IMDISGROUPID, "");
    }

    public final void setIMDISGROUPID(String strValue) {
        this.SetParamValue(TAG_IMDISGROUPID, strValue);
    }

    public final boolean isIMDISGROUPNAMENull() {
        return this.IsParamNull(TAG_IMDISGROUPNAME);
    }

    public final String getIMDISGROUPNAME() {
        return this.GetParamStringValue(TAG_IMDISGROUPNAME, "");
    }

    public final void setIMDISGROUPNAME(String strValue) {
        this.SetParamValue(TAG_IMDISGROUPNAME, strValue);
    }

    public final boolean isIMUSERIDNull() {
        return this.IsParamNull(TAG_IMUSERID);
    }

    public final String getIMUSERID() {
        return this.GetParamStringValue(TAG_IMUSERID, "");
    }

    public final void setIMUSERID(String strValue) {
        this.SetParamValue(TAG_IMUSERID, strValue);
    }

    public final boolean isIMUSERNAMENull() {
        return this.IsParamNull(TAG_IMUSERNAME);
    }

    public final String getIMUSERNAME() {
        return this.GetParamStringValue(TAG_IMUSERNAME, "");
    }

    public final void setIMUSERNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERNAME, strValue);
    }

    public final boolean isADMINFLAGNull() {
        return this.IsParamNull(TAG_ADMINFLAG);
    }

    public final boolean getADMINFLAG() {
        return this.GetParamIntValue(TAG_ADMINFLAG, 0) == 1;
    }

    public final void setADMINFLAG(boolean bValue) {
        this.SetParamValue(TAG_ADMINFLAG, bValue ? 1 : 0);
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

