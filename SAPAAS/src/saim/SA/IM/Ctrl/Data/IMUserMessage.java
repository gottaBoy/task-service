/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMUserMessage
extends BaseDataEntity {
    public static final String TAG_IMUSERMESSAGEID = "IMUSERMESSAGEID";
    public static final String TAG_IMUSERMESSAGENAME = "IMUSERMESSAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_IMMESSAGELOGID = "IMMESSAGELOGID";
    public static final String TAG_IMMESSAGELOGNAME = "IMMESSAGELOGNAME";
    public static final String TAG_SENDERFLAG = "SENDERFLAG";
    public static final String TAG_RECVFLAG = "RECVFLAG";

    public boolean isIMUSERMESSAGEIDNull() {
        return this.IsParamNull(TAG_IMUSERMESSAGEID);
    }

    public String getIMUSERMESSAGEID() {
        return this.GetParamStringValue(TAG_IMUSERMESSAGEID, "");
    }

    public void setIMUSERMESSAGEID(String strValue) {
        this.SetParamValue(TAG_IMUSERMESSAGEID, strValue);
    }

    public boolean isIMUSERMESSAGENAMENull() {
        return this.IsParamNull(TAG_IMUSERMESSAGENAME);
    }

    public String getIMUSERMESSAGENAME() {
        return this.GetParamStringValue(TAG_IMUSERMESSAGENAME, "");
    }

    public void setIMUSERMESSAGENAME(String strValue) {
        this.SetParamValue(TAG_IMUSERMESSAGENAME, strValue);
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

    public boolean isIMMESSAGELOGIDNull() {
        return this.IsParamNull(TAG_IMMESSAGELOGID);
    }

    public String getIMMESSAGELOGID() {
        return this.GetParamStringValue(TAG_IMMESSAGELOGID, "");
    }

    public void setIMMESSAGELOGID(String strValue) {
        this.SetParamValue(TAG_IMMESSAGELOGID, strValue);
    }

    public boolean isIMMESSAGELOGNAMENull() {
        return this.IsParamNull(TAG_IMMESSAGELOGNAME);
    }

    public String getIMMESSAGELOGNAME() {
        return this.GetParamStringValue(TAG_IMMESSAGELOGNAME, "");
    }

    public void setIMMESSAGELOGNAME(String strValue) {
        this.SetParamValue(TAG_IMMESSAGELOGNAME, strValue);
    }

    public boolean isSENDERFLAGNull() {
        return this.IsParamNull(TAG_SENDERFLAG);
    }

    public boolean getSENDERFLAG() {
        return this.GetParamIntValue(TAG_SENDERFLAG, 0) == 1;
    }

    public void setSENDERFLAG(boolean bValue) {
        this.SetParamValue(TAG_SENDERFLAG, bValue ? 1 : 0);
    }

    public boolean isRECVFLAGNull() {
        return this.IsParamNull(TAG_RECVFLAG);
    }

    public boolean getRECVFLAG() {
        return this.GetParamIntValue(TAG_RECVFLAG, 0) == 1;
    }

    public void setRECVFLAG(boolean bValue) {
        this.SetParamValue(TAG_RECVFLAG, bValue ? 1 : 0);
    }
}

