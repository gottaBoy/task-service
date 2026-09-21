/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAIFtpSendQueue
extends BaseDataEntity {
    public static final String TAG_EAIFTPSENDQUEUEID = "EAIFTPSENDQUEUEID";
    public static final String TAG_EAIFTPSENDQUEUENAME = "EAIFTPSENDQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FTPPATH = "FTPPATH";
    public static final String TAG_LOCALPATH = "LOCALPATH";
    public static final String TAG_REMOTEFILENAME = "REMOTEFILENAME";
    public static final String TAG_SENDTIME = "SENDTIME";
    public static final String TAG_FINISHTIME = "FINISHTIME";
    public static final String TAG_ISERROR = "ISERROR";
    public static final String TAG_ISBINARY = "ISBINARY";
    public static final String TAG_ISPASSIVE = "ISPASSIVE";

    public String getEAIFTPSENDQUEUEID() {
        return this.GetParamStringValue(TAG_EAIFTPSENDQUEUEID, "");
    }

    public void setEAIFTPSENDQUEUEID(String strValue) {
        this.SetParamValue(TAG_EAIFTPSENDQUEUEID, strValue);
    }

    public String getEAIFTPSENDQUEUENAME() {
        return this.GetParamStringValue(TAG_EAIFTPSENDQUEUENAME, "");
    }

    public void setEAIFTPSENDQUEUENAME(String strValue) {
        this.SetParamValue(TAG_EAIFTPSENDQUEUENAME, strValue);
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

    public String getFTPPATH() {
        return this.GetParamStringValue(TAG_FTPPATH, "");
    }

    public void setFTPPATH(String strValue) {
        this.SetParamValue(TAG_FTPPATH, strValue);
    }

    public String getLOCALPATH() {
        return this.GetParamStringValue(TAG_LOCALPATH, "");
    }

    public void setLOCALPATH(String strValue) {
        this.SetParamValue(TAG_LOCALPATH, strValue);
    }

    public String getREMOTEFILENAME() {
        return this.GetParamStringValue(TAG_REMOTEFILENAME, "");
    }

    public void setREMOTEFILENAME(String strValue) {
        this.SetParamValue(TAG_REMOTEFILENAME, strValue);
    }

    public Date getSENDTIME() {
        return this.GetParamDateValue(TAG_SENDTIME, null);
    }

    public void setSENDTIME(Date strValue) {
        this.SetParamValue(TAG_SENDTIME, strValue);
    }

    public Date getFINISHTIME() {
        return this.GetParamDateValue(TAG_FINISHTIME, null);
    }

    public void setFINISHTIME(Date strValue) {
        this.SetParamValue(TAG_FINISHTIME, strValue);
    }

    public boolean getISERROR() {
        return this.GetParamIntValue(TAG_ISERROR, 0) == 1;
    }

    public void setISERROR(boolean bValue) {
        this.SetParamValue(TAG_ISERROR, bValue ? 1 : 0);
    }

    public boolean getISBINARY() {
        return this.GetParamIntValue(TAG_ISBINARY, 0) == 1;
    }

    public void setISBINARY(boolean bValue) {
        this.SetParamValue(TAG_ISBINARY, bValue ? 1 : 0);
    }

    public boolean getISPASSIVE() {
        return this.GetParamIntValue(TAG_ISPASSIVE, 0) == 1;
    }

    public void setISPASSIVE(boolean bValue) {
        this.SetParamValue(TAG_ISPASSIVE, bValue ? 1 : 0);
    }
}

