/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSMavenServer
extends BaseDataEntity {
    public static final String MAVENSERVERTYPE_NEXUS = "NEXUS";
    public static final String TAG_PSMAVENSERVERID = "PSMAVENSERVERID";
    public static final String TAG_PSMAVENSERVERNAME = "PSMAVENSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_MAVENUSERNAME = "MAVENUSERNAME";
    public static final String TAG_MAVENURL = "MAVENURL";
    public static final String TAG_MAVENPASSWD = "MAVENPASSWD";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_MAVENSERVERTYPE = "MAVENSERVERTYPE";
    public static final String TAG_APIPATH = "APIPATH";

    public final boolean isPSMAVENSERVERIDNull() {
        return this.IsParamNull(TAG_PSMAVENSERVERID);
    }

    public final String getPSMAVENSERVERID() {
        return this.GetParamStringValue(TAG_PSMAVENSERVERID, "");
    }

    public final void setPSMAVENSERVERID(String strValue) {
        this.SetParamValue(TAG_PSMAVENSERVERID, strValue);
    }

    public final boolean isPSMAVENSERVERNAMENull() {
        return this.IsParamNull(TAG_PSMAVENSERVERNAME);
    }

    public final String getPSMAVENSERVERNAME() {
        return this.GetParamStringValue(TAG_PSMAVENSERVERNAME, "");
    }

    public final void setPSMAVENSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSMAVENSERVERNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isMAVENUSERNAMENull() {
        return this.IsParamNull(TAG_MAVENUSERNAME);
    }

    public final String getMAVENUSERNAME() {
        return this.GetParamStringValue(TAG_MAVENUSERNAME, "");
    }

    public final void setMAVENUSERNAME(String strValue) {
        this.SetParamValue(TAG_MAVENUSERNAME, strValue);
    }

    public final boolean isMAVENURLNull() {
        return this.IsParamNull(TAG_MAVENURL);
    }

    public final String getMAVENURL() {
        return this.GetParamStringValue(TAG_MAVENURL, "");
    }

    public final void setMAVENURL(String strValue) {
        this.SetParamValue(TAG_MAVENURL, strValue);
    }

    public final boolean isMAVENPASSWDNull() {
        return this.IsParamNull(TAG_MAVENPASSWD);
    }

    public final String getMAVENPASSWD() {
        return this.GetParamStringValue(TAG_MAVENPASSWD, "");
    }

    public final void setMAVENPASSWD(String strValue) {
        this.SetParamValue(TAG_MAVENPASSWD, strValue);
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

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
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

    public final boolean isIPADDR2Null() {
        return this.IsParamNull(TAG_IPADDR2);
    }

    public final String getIPADDR2() {
        return this.GetParamStringValue(TAG_IPADDR2, "");
    }

    public final void setIPADDR2(String strValue) {
        this.SetParamValue(TAG_IPADDR2, strValue);
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

    public final boolean isMAVENSERVERTYPENull() {
        return this.IsParamNull(TAG_MAVENSERVERTYPE);
    }

    public final String getMAVENSERVERTYPE() {
        return this.GetParamStringValue(TAG_MAVENSERVERTYPE, "");
    }

    public final void setMAVENSERVERTYPE(String strValue) {
        this.SetParamValue(TAG_MAVENSERVERTYPE, strValue);
    }

    public final boolean isAPIPATHNull() {
        return this.IsParamNull(TAG_APIPATH);
    }

    public final String getAPIPATH() {
        return this.GetParamStringValue(TAG_APIPATH, "");
    }

    public final void setAPIPATH(String strValue) {
        this.SetParamValue(TAG_APIPATH, strValue);
    }
}

