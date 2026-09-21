/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMUserFile
extends BaseDataEntity {
    public static final String TAG_IMUSERFILEID = "IMUSERFILEID";
    public static final String TAG_IMUSERFILENAME = "IMUSERFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_IMFILEID = "IMFILEID";
    public static final String TAG_IMFILENAME = "IMFILENAME";
    public static final String TAG_SENDERFLAG = "SENDERFLAG";
    public static final String TAG_RECVFLAG = "RECVFLAG";

    public boolean isIMUSERFILEIDNull() {
        return this.IsParamNull(TAG_IMUSERFILEID);
    }

    public String getIMUSERFILEID() {
        return this.GetParamStringValue(TAG_IMUSERFILEID, "");
    }

    public void setIMUSERFILEID(String strValue) {
        this.SetParamValue(TAG_IMUSERFILEID, strValue);
    }

    public boolean isIMUSERFILENAMENull() {
        return this.IsParamNull(TAG_IMUSERFILENAME);
    }

    public String getIMUSERFILENAME() {
        return this.GetParamStringValue(TAG_IMUSERFILENAME, "");
    }

    public void setIMUSERFILENAME(String strValue) {
        this.SetParamValue(TAG_IMUSERFILENAME, strValue);
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

    public boolean isIMFILEIDNull() {
        return this.IsParamNull(TAG_IMFILEID);
    }

    public String getIMFILEID() {
        return this.GetParamStringValue(TAG_IMFILEID, "");
    }

    public void setIMFILEID(String strValue) {
        this.SetParamValue(TAG_IMFILEID, strValue);
    }

    public boolean isIMFILENAMENull() {
        return this.IsParamNull(TAG_IMFILENAME);
    }

    public String getIMFILENAME() {
        return this.GetParamStringValue(TAG_IMFILENAME, "");
    }

    public void setIMFILENAME(String strValue) {
        this.SetParamValue(TAG_IMFILENAME, strValue);
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

