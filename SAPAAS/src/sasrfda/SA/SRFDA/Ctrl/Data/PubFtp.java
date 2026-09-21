/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PubFtp
extends BaseDataEntity {
    public static final String TAG_PUBFTPID = "PUBFTPID";
    public static final String TAG_PUBFTPNAME = "PUBFTPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PUBITEMTYPE = "PUBITEMTYPE";
    public static final String TAG_PUBGROUPID = "PUBGROUPID";
    public static final String TAG_PUBGROUPNAME = "PUBGROUPNAME";
    public static final String TAG_FTPSERVERID = "FTPSERVERID";
    public static final String TAG_FTPSERVERNAME = "FTPSERVERNAME";
    public static final String TAG_FTPFOLDER = "FTPFOLDER";

    public String getPUBFTPID() {
        return this.GetParamStringValue(TAG_PUBFTPID, "");
    }

    public void setPUBFTPID(String strValue) {
        this.SetParamValue(TAG_PUBFTPID, strValue);
    }

    public String getPUBFTPNAME() {
        return this.GetParamStringValue(TAG_PUBFTPNAME, "");
    }

    public void setPUBFTPNAME(String strValue) {
        this.SetParamValue(TAG_PUBFTPNAME, strValue);
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

    public String getPUBITEMTYPE() {
        return this.GetParamStringValue(TAG_PUBITEMTYPE, "");
    }

    public void setPUBITEMTYPE(String strValue) {
        this.SetParamValue(TAG_PUBITEMTYPE, strValue);
    }

    public String getPUBGROUPID() {
        return this.GetParamStringValue(TAG_PUBGROUPID, "");
    }

    public void setPUBGROUPID(String strValue) {
        this.SetParamValue(TAG_PUBGROUPID, strValue);
    }

    public String getPUBGROUPNAME() {
        return this.GetParamStringValue(TAG_PUBGROUPNAME, "");
    }

    public void setPUBGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PUBGROUPNAME, strValue);
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

    public String getFTPFOLDER() {
        return this.GetParamStringValue(TAG_FTPFOLDER, "");
    }

    public void setFTPFOLDER(String strValue) {
        this.SetParamValue(TAG_FTPFOLDER, strValue);
    }
}

