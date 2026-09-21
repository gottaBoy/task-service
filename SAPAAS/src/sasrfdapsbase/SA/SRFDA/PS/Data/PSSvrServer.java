/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSvrServer
extends BaseDataEntity {
    public static final String TAG_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String TAG_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_TEMPL1ID = "TEMPL1ID";
    public static final String TAG_TEMPL2ID = "TEMPL2ID";
    public static final String TAG_TEMPL3ID = "TEMPL3ID";
    public static final String TAG_TEMPL4ID = "TEMPL4ID";
    public static final String TAG_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    public static final String TAG_LASTHTTPPORT = "LASTHTTPPORT";
    public static final String TAG_LASTSSHPORT = "LASTSSHPORT";

    public final boolean isPSSVRSERVERIDNull() {
        return this.IsParamNull(TAG_PSSVRSERVERID);
    }

    public final String getPSSVRSERVERID() {
        return this.GetParamStringValue(TAG_PSSVRSERVERID, "");
    }

    public final void setPSSVRSERVERID(String strValue) {
        this.SetParamValue(TAG_PSSVRSERVERID, strValue);
    }

    public final boolean isPSSVRSERVERNAMENull() {
        return this.IsParamNull(TAG_PSSVRSERVERNAME);
    }

    public final String getPSSVRSERVERNAME() {
        return this.GetParamStringValue(TAG_PSSVRSERVERNAME, "");
    }

    public final void setPSSVRSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRSERVERNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isPORTNull() {
        return this.IsParamNull(TAG_PORT);
    }

    public final int getPORT() {
        return this.GetParamIntValue(TAG_PORT, 0);
    }

    public final void setPORT(int nValue) {
        this.SetParamValue(TAG_PORT, nValue);
    }

    public final boolean isPSSVRDOMAINIDNull() {
        return this.IsParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.IsParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINNAME, strValue);
    }

    public final boolean isTEMPL1IDNull() {
        return this.IsParamNull(TAG_TEMPL1ID);
    }

    public final String getTEMPL1ID() {
        return this.GetParamStringValue(TAG_TEMPL1ID, "");
    }

    public final void setTEMPL1ID(String strValue) {
        this.SetParamValue(TAG_TEMPL1ID, strValue);
    }

    public final boolean isTEMPL2IDNull() {
        return this.IsParamNull(TAG_TEMPL2ID);
    }

    public final String getTEMPL2ID() {
        return this.GetParamStringValue(TAG_TEMPL2ID, "");
    }

    public final void setTEMPL2ID(String strValue) {
        this.SetParamValue(TAG_TEMPL2ID, strValue);
    }

    public final boolean isTEMPL3IDNull() {
        return this.IsParamNull(TAG_TEMPL3ID);
    }

    public final String getTEMPL3ID() {
        return this.GetParamStringValue(TAG_TEMPL3ID, "");
    }

    public final void setTEMPL3ID(String strValue) {
        this.SetParamValue(TAG_TEMPL3ID, strValue);
    }

    public final boolean isTEMPL4IDNull() {
        return this.IsParamNull(TAG_TEMPL4ID);
    }

    public final String getTEMPL4ID() {
        return this.GetParamStringValue(TAG_TEMPL4ID, "");
    }

    public final void setTEMPL4ID(String strValue) {
        this.SetParamValue(TAG_TEMPL4ID, strValue);
    }

    public final boolean isWEBCONSOLEPATHNull() {
        return this.IsParamNull(TAG_WEBCONSOLEPATH);
    }

    public final String getWEBCONSOLEPATH() {
        return this.GetParamStringValue(TAG_WEBCONSOLEPATH, "");
    }

    public final void setWEBCONSOLEPATH(String strValue) {
        this.SetParamValue(TAG_WEBCONSOLEPATH, strValue);
    }

    public final boolean isLASTHTTPPORTNull() {
        return this.IsParamNull(TAG_LASTHTTPPORT);
    }

    public final int getLASTHTTPPORT() {
        return this.GetParamIntValue(TAG_LASTHTTPPORT, 0);
    }

    public final void setLASTHTTPPORT(int nValue) {
        this.SetParamValue(TAG_LASTHTTPPORT, nValue);
    }

    public final boolean isLASTSSHPORTNull() {
        return this.IsParamNull(TAG_LASTSSHPORT);
    }

    public final int getLASTSSHPORT() {
        return this.GetParamIntValue(TAG_LASTSSHPORT, 0);
    }

    public final void setLASTSSHPORT(int nValue) {
        this.SetParamValue(TAG_LASTSSHPORT, nValue);
    }
}

