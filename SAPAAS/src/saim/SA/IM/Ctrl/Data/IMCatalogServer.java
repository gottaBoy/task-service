/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMCatalogServer
extends BaseDataEntity {
    public static final String TAG_IMCATALOGSERVERID = "IMCATALOGSERVERID";
    public static final String TAG_IMCATALOGSERVERNAME = "IMCATALOGSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_STUNIP = "STUNIP";
    public static final String TAG_STUNIP2 = "STUNIP2";
    public static final String TAG_STUNPORT = "STUNPORT";
    public static final String TAG_STUNPORT2 = "STUNPORT2";
    public static final String TAG_STARTSTUNSERVER = "STARTSTUNSERVER";
    public static final String TAG_STUNSERVERPATH = "STUNSERVERPATH";
    public static final String TAG_FTPPORT = "FTPPORT";
    public static final String TAG_FTPROOT = "FTPROOT";
    public static final String TAG_FTPSERVERPATH = "FTPSERVERPATH";
    public static final String TAG_FTPPASSIVEADDR = "FTPPASSIVEADDR";
    public static final String TAG_FTPPASSIVEPORT = "FTPPASSIVEPORT";
    public static final String TAG_IMDOMAIN = "IMDOMAIN";
    public static final String TAG_ENABLEFTPSERVER = "ENABLEFTPSERVER";

    public boolean isIMCATALOGSERVERIDNull() {
        return this.IsParamNull(TAG_IMCATALOGSERVERID);
    }

    public String getIMCATALOGSERVERID() {
        return this.GetParamStringValue(TAG_IMCATALOGSERVERID, "");
    }

    public void setIMCATALOGSERVERID(String strValue) {
        this.SetParamValue(TAG_IMCATALOGSERVERID, strValue);
    }

    public boolean isIMCATALOGSERVERNAMENull() {
        return this.IsParamNull(TAG_IMCATALOGSERVERNAME);
    }

    public String getIMCATALOGSERVERNAME() {
        return this.GetParamStringValue(TAG_IMCATALOGSERVERNAME, "");
    }

    public void setIMCATALOGSERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMCATALOGSERVERNAME, strValue);
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

    public boolean isSTUNIPNull() {
        return this.IsParamNull(TAG_STUNIP);
    }

    public String getSTUNIP() {
        return this.GetParamStringValue(TAG_STUNIP, "");
    }

    public void setSTUNIP(String strValue) {
        this.SetParamValue(TAG_STUNIP, strValue);
    }

    public boolean isSTUNIP2Null() {
        return this.IsParamNull(TAG_STUNIP2);
    }

    public String getSTUNIP2() {
        return this.GetParamStringValue(TAG_STUNIP2, "");
    }

    public void setSTUNIP2(String strValue) {
        this.SetParamValue(TAG_STUNIP2, strValue);
    }

    public boolean isSTUNPORTNull() {
        return this.IsParamNull(TAG_STUNPORT);
    }

    public int getSTUNPORT() {
        return this.GetParamIntValue(TAG_STUNPORT, 0);
    }

    public void setSTUNPORT(int nValue) {
        this.SetParamValue(TAG_STUNPORT, nValue);
    }

    public boolean isSTUNPORT2Null() {
        return this.IsParamNull(TAG_STUNPORT2);
    }

    public int getSTUNPORT2() {
        return this.GetParamIntValue(TAG_STUNPORT2, 0);
    }

    public void setSTUNPORT2(int nValue) {
        this.SetParamValue(TAG_STUNPORT2, nValue);
    }

    public boolean isSTARTSTUNSERVERNull() {
        return this.IsParamNull(TAG_STARTSTUNSERVER);
    }

    public boolean getSTARTSTUNSERVER() {
        return this.GetParamIntValue(TAG_STARTSTUNSERVER, 0) == 1;
    }

    public void setSTARTSTUNSERVER(boolean bValue) {
        this.SetParamValue(TAG_STARTSTUNSERVER, bValue ? 1 : 0);
    }

    public boolean isSTUNSERVERPATHNull() {
        return this.IsParamNull(TAG_STUNSERVERPATH);
    }

    public String getSTUNSERVERPATH() {
        return this.GetParamStringValue(TAG_STUNSERVERPATH, "");
    }

    public void setSTUNSERVERPATH(String strValue) {
        this.SetParamValue(TAG_STUNSERVERPATH, strValue);
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

