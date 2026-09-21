/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class FtpServer
extends BaseDataEntity {
    public static final String TAG_FTPSERVERID = "FTPSERVERID";
    public static final String TAG_FTPSERVERNAME = "FTPSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SERVERPATH = "SERVERPATH";
    public static final String TAG_SERVERPORT = "SERVERPORT";
    public static final String TAG_FTPUSER = "FTPUSER";
    public static final String TAG_FTPPWD = "FTPPWD";
    public static final String TAG_INITPATH = "INITPATH";
    public static final String TAG_LOCALPASSIVE = "LOCALPASSIVE";
    public static final String TAG_EPSVWITHIP4 = "EPSVWITHIP4";

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

    public String getSERVERPATH() {
        return this.GetParamStringValue(TAG_SERVERPATH, "");
    }

    public void setSERVERPATH(String strValue) {
        this.SetParamValue(TAG_SERVERPATH, strValue);
    }

    public int getSERVERPORT() {
        return this.GetParamIntValue(TAG_SERVERPORT, 0);
    }

    public void setSERVERPORT(int strValue) {
        this.SetParamValue(TAG_SERVERPORT, strValue);
    }

    public String getFTPUSER() {
        return this.GetParamStringValue(TAG_FTPUSER, "");
    }

    public void setFTPUSER(String strValue) {
        this.SetParamValue(TAG_FTPUSER, strValue);
    }

    public String getFTPPWD() {
        return this.GetParamStringValue(TAG_FTPPWD, "");
    }

    public void setFTPPWD(String strValue) {
        this.SetParamValue(TAG_FTPPWD, strValue);
    }

    public String getINITPATH() {
        return this.GetParamStringValue(TAG_INITPATH, "");
    }

    public void setINITPATH(String strValue) {
        this.SetParamValue(TAG_INITPATH, strValue);
    }

    public boolean getLOCALPASSIVE() {
        return this.GetParamIntValue(TAG_LOCALPASSIVE, 0) == 1;
    }

    public void setLOCALPASSIVE(boolean bValue) {
        this.SetParamValue(TAG_LOCALPASSIVE, bValue ? 1 : 0);
    }

    public boolean getEPSVWITHIP4() {
        return this.GetParamIntValue(TAG_EPSVWITHIP4, 0) == 1;
    }

    public void setEPSVWITHIP4(boolean bValue) {
        this.SetParamValue(TAG_EPSVWITHIP4, bValue ? 1 : 0);
    }
}

