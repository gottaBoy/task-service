/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMMTServer
extends BaseDataEntity {
    public static final String IMSERVERTYPE_STATESERVER = "STATESERVER";
    public static final String IMSERVERTYPE_MEETINGSERVER = "MEETINGSERVER";
    public static final String IMSERVERTYPE_CATALOGSERVER = "CATALOGSERVER";
    public static final String TAG_IMMTSERVERID = "IMMTSERVERID";
    public static final String TAG_IMMTSERVERNAME = "IMMTSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_IMSERVERTYPE = "IMSERVERTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FTPPORT = "FTPPORT";
    public static final String TAG_FTPROOT = "FTPROOT";
    public static final String TAG_FTPSERVERPATH = "FTPSERVERPATH";
    public static final String TAG_FTPPASSIVEADDR = "FTPPASSIVEADDR";
    public static final String TAG_FTPPASSIVEPORT = "FTPPASSIVEPORT";
    public static final String TAG_IMDOMAIN = "IMDOMAIN";
    public static final String TAG_ENABLEFTPSERVER = "ENABLEFTPSERVER";

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

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public boolean isIMSERVERTYPENull() {
        return this.IsParamNull(TAG_IMSERVERTYPE);
    }

    public String getIMSERVERTYPE() {
        return this.GetParamStringValue(TAG_IMSERVERTYPE, "");
    }

    public void setIMSERVERTYPE(String strValue) {
        this.SetParamValue(TAG_IMSERVERTYPE, strValue);
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

    public boolean isFTPPORTNull() {
        return this.IsParamNull(TAG_FTPPORT);
    }

    public int getFTPPORT() {
        return this.GetParamIntValue(TAG_FTPPORT, 0);
    }

    public void setFTPPORT(int nValue) {
        this.SetParamValue(TAG_FTPPORT, nValue);
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

    public boolean isFTPSERVERPATHNull() {
        return this.IsParamNull(TAG_FTPSERVERPATH);
    }

    public String getFTPSERVERPATH() {
        return this.GetParamStringValue(TAG_FTPSERVERPATH, "");
    }

    public void setFTPSERVERPATH(String strValue) {
        this.SetParamValue(TAG_FTPSERVERPATH, strValue);
    }

    public boolean isFTPPASSIVEADDRNull() {
        return this.IsParamNull(TAG_FTPPASSIVEADDR);
    }

    public String getFTPPASSIVEADDR() {
        return this.GetParamStringValue(TAG_FTPPASSIVEADDR, "");
    }

    public void setFTPPASSIVEADDR(String strValue) {
        this.SetParamValue(TAG_FTPPASSIVEADDR, strValue);
    }

    public boolean isFTPPASSIVEPORTNull() {
        return this.IsParamNull(TAG_FTPPASSIVEPORT);
    }

    public String getFTPPASSIVEPORT() {
        return this.GetParamStringValue(TAG_FTPPASSIVEPORT, "");
    }

    public void setFTPPASSIVEPORT(String strValue) {
        this.SetParamValue(TAG_FTPPASSIVEPORT, strValue);
    }

    public final boolean isIMDOMAINNull() {
        return this.IsParamNull(TAG_IMDOMAIN);
    }

    public final String getIMDOMAIN() {
        return this.GetParamStringValue(TAG_IMDOMAIN, "");
    }

    public final void setIMDOMAIN(String strValue) {
        this.SetParamValue(TAG_IMDOMAIN, strValue);
    }

    public final boolean isENABLEFTPSERVERNull() {
        return this.IsParamNull(TAG_ENABLEFTPSERVER);
    }

    public final boolean getENABLEFTPSERVER() {
        return this.GetParamIntValue(TAG_ENABLEFTPSERVER, 0) == 1;
    }

    public final void setENABLEFTPSERVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFTPSERVER, bValue ? 1 : 0);
    }
}

