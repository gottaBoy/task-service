/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMUGDetail
extends BaseDataEntity {
    public static final String TAG_IMUGDETAILID = "IMUGDETAILID";
    public static final String TAG_IMUGDETAILNAME = "IMUGDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMUSERGROUPID = "IMUSERGROUPID";
    public static final String TAG_IMUSERGROUPNAME = "IMUSERGROUPNAME";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_USERLEVEL = "USERLEVEL";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";

    public boolean isIMUGDETAILIDNull() {
        return this.IsParamNull(TAG_IMUGDETAILID);
    }

    public String getIMUGDETAILID() {
        return this.GetParamStringValue(TAG_IMUGDETAILID, "");
    }

    public void setIMUGDETAILID(String strValue) {
        this.SetParamValue(TAG_IMUGDETAILID, strValue);
    }

    public boolean isIMUGDETAILNAMENull() {
        return this.IsParamNull(TAG_IMUGDETAILNAME);
    }

    public String getIMUGDETAILNAME() {
        return this.GetParamStringValue(TAG_IMUGDETAILNAME, "");
    }

    public void setIMUGDETAILNAME(String strValue) {
        this.SetParamValue(TAG_IMUGDETAILNAME, strValue);
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

    public boolean isIMUSERGROUPIDNull() {
        return this.IsParamNull(TAG_IMUSERGROUPID);
    }

    public String getIMUSERGROUPID() {
        return this.GetParamStringValue(TAG_IMUSERGROUPID, "");
    }

    public void setIMUSERGROUPID(String strValue) {
        this.SetParamValue(TAG_IMUSERGROUPID, strValue);
    }

    public boolean isIMUSERGROUPNAMENull() {
        return this.IsParamNull(TAG_IMUSERGROUPNAME);
    }

    public String getIMUSERGROUPNAME() {
        return this.GetParamStringValue(TAG_IMUSERGROUPNAME, "");
    }

    public void setIMUSERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERGROUPNAME, strValue);
    }

    public boolean isIMUSERIDNull() {
        return this.IsParamNull(TAG_IMUSERID);
    }

    public String getIMUSERID() {
        return this.GetParamStringValue(TAG_IMUSERID, "");
    }

    public void setIMUSERID(String strValue) {
        this.SetParamValue(TAG_IMUSERID, strValue);
    }

    public boolean isIMUSERNAMENull() {
        return this.IsParamNull(TAG_IMUSERNAME);
    }

    public String getIMUSERNAME() {
        return this.GetParamStringValue(TAG_IMUSERNAME, "");
    }

    public void setIMUSERNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERNAME, strValue);
    }

    public boolean isUSERLEVELNull() {
        return this.IsParamNull(TAG_USERLEVEL);
    }

    public int getUSERLEVEL() {
        return this.GetParamIntValue(TAG_USERLEVEL, 0);
    }

    public void setUSERLEVEL(int nValue) {
        this.SetParamValue(TAG_USERLEVEL, nValue);
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
}

