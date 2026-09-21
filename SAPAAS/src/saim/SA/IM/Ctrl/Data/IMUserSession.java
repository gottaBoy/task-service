/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class IMUserSession
extends BaseDataEntity {
    public static final String TAG_IMUSERSESSIONID = "IMUSERSESSIONID";
    public static final String TAG_IMUSERSESSIONNAME = "IMUSERSESSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_IMSTATESERVERID = "IMSTATESERVERID";
    public static final String TAG_IMSTATESERVERNAME = "IMSTATESERVERNAME";
    public static final String TAG_LOGINTIME = "LOGINTIME";
    public static final String TAG_LOGOUTTIME = "LOGOUTTIME";
    public static final String TAG_TALKLEVEL = "TALKLEVEL";
    public static final String TAG_USERLEVEL = "USERLEVEL";
    public static final String TAG_CLIENTINFO = "CLIENTINFO";
    public static final String TAG_REMOTEADDR = "REMOTEADDR";
    public static final String TAG_IMVERSION = "IMVERSION";
    public static final String TAG_LASTINFORMTIME = "LASTINFORMTIME";

    public boolean isIMUSERSESSIONIDNull() {
        return this.IsParamNull(TAG_IMUSERSESSIONID);
    }

    public String getIMUSERSESSIONID() {
        return this.GetParamStringValue(TAG_IMUSERSESSIONID, "");
    }

    public void setIMUSERSESSIONID(String strValue) {
        this.SetParamValue(TAG_IMUSERSESSIONID, strValue);
    }

    public boolean isIMUSERSESSIONNAMENull() {
        return this.IsParamNull(TAG_IMUSERSESSIONNAME);
    }

    public String getIMUSERSESSIONNAME() {
        return this.GetParamStringValue(TAG_IMUSERSESSIONNAME, "");
    }

    public void setIMUSERSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERSESSIONNAME, strValue);
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

    public boolean isIMSTATESERVERIDNull() {
        return this.IsParamNull(TAG_IMSTATESERVERID);
    }

    public String getIMSTATESERVERID() {
        return this.GetParamStringValue(TAG_IMSTATESERVERID, "");
    }

    public void setIMSTATESERVERID(String strValue) {
        this.SetParamValue(TAG_IMSTATESERVERID, strValue);
    }

    public boolean isIMSTATESERVERNAMENull() {
        return this.IsParamNull(TAG_IMSTATESERVERNAME);
    }

    public String getIMSTATESERVERNAME() {
        return this.GetParamStringValue(TAG_IMSTATESERVERNAME, "");
    }

    public void setIMSTATESERVERNAME(String strValue) {
        this.SetParamValue(TAG_IMSTATESERVERNAME, strValue);
    }

    public boolean isLOGINTIMENull() {
        return this.IsParamNull(TAG_LOGINTIME);
    }

    public Date getLOGINTIME() {
        return this.GetParamDateValue(TAG_LOGINTIME, null);
    }

    public void setLOGINTIME(Date dtValue) {
        this.SetParamValue(TAG_LOGINTIME, dtValue);
    }

    public boolean isLOGOUTTIMENull() {
        return this.IsParamNull(TAG_LOGOUTTIME);
    }

    public Date getLOGOUTTIME() {
        return this.GetParamDateValue(TAG_LOGOUTTIME, null);
    }

    public void setLOGOUTTIME(Date dtValue) {
        this.SetParamValue(TAG_LOGOUTTIME, dtValue);
    }

    public boolean isTALKLEVELNull() {
        return this.IsParamNull(TAG_TALKLEVEL);
    }

    public int getTALKLEVEL() {
        return this.GetParamIntValue(TAG_TALKLEVEL, 0);
    }

    public void setTALKLEVEL(int nValue) {
        this.SetParamValue(TAG_TALKLEVEL, nValue);
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

    public boolean isCLIENTINFONull() {
        return this.IsParamNull(TAG_CLIENTINFO);
    }

    public String getCLIENTINFO() {
        return this.GetParamStringValue(TAG_CLIENTINFO, "");
    }

    public void setCLIENTINFO(String strValue) {
        this.SetParamValue(TAG_CLIENTINFO, strValue);
    }

    public boolean isREMOTEADDRNull() {
        return this.IsParamNull(TAG_REMOTEADDR);
    }

    public String getREMOTEADDR() {
        return this.GetParamStringValue(TAG_REMOTEADDR, "");
    }

    public void setREMOTEADDR(String strValue) {
        this.SetParamValue(TAG_REMOTEADDR, strValue);
    }

    public boolean isIMVERSIONNull() {
        return this.IsParamNull(TAG_IMVERSION);
    }

    public String getIMVERSION() {
        return this.GetParamStringValue(TAG_IMVERSION, "");
    }

    public void setIMVERSION(String strValue) {
        this.SetParamValue(TAG_IMVERSION, strValue);
    }

    public final boolean isLASTINFORMTIMENull() {
        return this.IsParamNull(TAG_LASTINFORMTIME);
    }

    public final Timestamp getLASTINFORMTIME() {
        return this.GetParamTimestampValue(TAG_LASTINFORMTIME, null);
    }

    public final void setLASTINFORMTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_LASTINFORMTIME, dtValue);
    }
}

