/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class FtpSendQueue
extends BaseDataEntity {
    public static final String TAG_FTPSENDQUEUEID = "FTPSENDQUEUEID";
    public static final String TAG_FTPSENDQUEUENAME = "FTPSENDQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FTPSERVERID = "FTPSERVERID";
    public static final String TAG_FTPSERVERNAME = "FTPSERVERNAME";
    public static final String TAG_REMOTEFILE = "REMOTEFILE";
    public static final String TAG_LOCALFILE = "LOCALFILE";
    public static final String TAG_ISSEND = "ISSEND";
    public static final String TAG_ISERROR = "ISERROR";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_REMOTEFOLDER = "REMOTEFOLDER";

    public String getFTPSENDQUEUEID() {
        return this.GetParamStringValue(TAG_FTPSENDQUEUEID, "");
    }

    public void setFTPSENDQUEUEID(String strValue) {
        this.SetParamValue(TAG_FTPSENDQUEUEID, strValue);
    }

    public String getFTPSENDQUEUENAME() {
        return this.GetParamStringValue(TAG_FTPSENDQUEUENAME, "");
    }

    public void setFTPSENDQUEUENAME(String strValue) {
        this.SetParamValue(TAG_FTPSENDQUEUENAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getFTPSERVERID() {
        return this.GetParamStringValue(TAG_FTPSERVERID, "");
    }

    public void setFTPSERVERID(String strValue) {
        this.SetParamValue(TAG_FTPSERVERID, strValue);
    }

    public String getFTPSERVERNAME() {
        return this.GetParamStringValue(TAG_FTPSERVERNAME, "");
    }

    public void setFTPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_FTPSERVERNAME, strValue);
    }

    public String getREMOTEFILE() {
        return this.GetParamStringValue(TAG_REMOTEFILE, "");
    }

    public void setREMOTEFILE(String strValue) {
        this.SetParamValue(TAG_REMOTEFILE, strValue);
    }

    public String getLOCALFILE() {
        return this.GetParamStringValue(TAG_LOCALFILE, "");
    }

    public void setLOCALFILE(String strValue) {
        this.SetParamValue(TAG_LOCALFILE, strValue);
    }

    public boolean getISSEND() {
        return this.GetParamIntValue(TAG_ISSEND, 0) == 1;
    }

    public void setISSEND(boolean bValue) {
        this.SetParamValue(TAG_ISSEND, bValue ? 1 : 0);
    }

    public boolean getISERROR() {
        return this.GetParamIntValue(TAG_ISERROR, 0) == 1;
    }

    public void setISERROR(boolean bValue) {
        this.SetParamValue(TAG_ISERROR, bValue ? 1 : 0);
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public String getREMOTEFOLDER() {
        return this.GetParamStringValue(TAG_REMOTEFOLDER, "");
    }

    public void setREMOTEFOLDER(String strValue) {
        this.SetParamValue(TAG_REMOTEFOLDER, strValue);
    }
}

