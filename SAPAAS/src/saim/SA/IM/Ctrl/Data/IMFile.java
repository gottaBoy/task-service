/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMFile
extends BaseDataEntity {
    public static final String TAG_IMFILEID = "IMFILEID";
    public static final String TAG_IMFILENAME = "IMFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMMEETINGID = "IMMEETINGID";
    public static final String TAG_IMMEETINGNAME = "IMMEETINGNAME";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_UPLOADFINISH = "UPLOADFINISH";
    public static final String TAG_IMMTSERVERID = "IMMTSERVERID";
    public static final String TAG_IMMTSERVERNAME = "IMMTSERVERNAME";
    public static final String TAG_FTPROOT = "FTPROOT";
    public static final String TAG_SENDTIME = "SENDTIME";

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

    public boolean isIMMEETINGIDNull() {
        return this.IsParamNull(TAG_IMMEETINGID);
    }

    public String getIMMEETINGID() {
        return this.GetParamStringValue(TAG_IMMEETINGID, "");
    }

    public void setIMMEETINGID(String strValue) {
        this.SetParamValue(TAG_IMMEETINGID, strValue);
    }

    public boolean isIMMEETINGNAMENull() {
        return this.IsParamNull(TAG_IMMEETINGNAME);
    }

    public String getIMMEETINGNAME() {
        return this.GetParamStringValue(TAG_IMMEETINGNAME, "");
    }

    public void setIMMEETINGNAME(String strValue) {
        this.SetParamValue(TAG_IMMEETINGNAME, strValue);
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

    public boolean isUPLOADFINISHNull() {
        return this.IsParamNull(TAG_UPLOADFINISH);
    }

    public boolean getUPLOADFINISH() {
        return this.GetParamIntValue(TAG_UPLOADFINISH, 0) == 1;
    }

    public void setUPLOADFINISH(boolean bValue) {
        this.SetParamValue(TAG_UPLOADFINISH, bValue ? 1 : 0);
    }

    public boolean isIMMTSERVERIDNull() {
        return this.IsParamNull(TAG_IMMTSERVERID);
    }

    public String getIMMTSERVERID() {
        return this.GetParamStringValue(TAG_IMMTSERVERID, "");
    }

    public void setIMMTSERVERID(String strValue) {
        this.SetParamValue(TAG_IMMTSERVERID, strValue);
    }

    public boolean isIMMTSERVERNAMENull() {
        return this.IsParamNull(TAG_IMMTSERVERNAME);
    }

    public String getIMMTSERVERNAME() {
        return this.GetParamStringValue(TAG_IMMTSERVERNAME, "");
    }

    public void setIMMTSERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMMTSERVERNAME, strValue);
    }

    public boolean isFTPROOTNull() {
        return this.IsParamNull(TAG_FTPROOT);
    }

    public String getFTPROOT() {
        return this.GetParamStringValue(TAG_FTPROOT, "");
    }

    public void setFTPROOT(String strValue) {
        this.SetParamValue(TAG_FTPROOT, strValue);
    }

    public boolean isSENDTIMENull() {
        return this.IsParamNull(TAG_SENDTIME);
    }

    public Date getSENDTIME() {
        return this.GetParamDateValue(TAG_SENDTIME, null);
    }

    public void setSENDTIME(Date dtValue) {
        this.SetParamValue(TAG_SENDTIME, dtValue);
    }
}

