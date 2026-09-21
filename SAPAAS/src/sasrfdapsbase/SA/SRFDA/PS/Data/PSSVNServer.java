/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSVNServer
extends BaseDataEntity {
    public static final String SVNTYPE_SVN = "SVN";
    public static final String SVNTYPE_GIT = "GIT";
    public static final String TAG_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String TAG_PSSVNSERVERNAME = "PSSVNSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_SVNURL = "SVNURL";
    public static final String TAG_SVNROOT = "SVNROOT";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_AUTHZCFG = "AUTHZCFG";
    public static final String TAG_SLAVEIPADDR = "SLAVEIPADDR";
    public static final String TAG_SLAVEIPADDR2 = "SLAVEIPADDR2";
    public static final String TAG_SLAVEPASSWD = "SLAVEPASSWD";
    public static final String TAG_SLAVEPORT = "SLAVEPORT";
    public static final String TAG_SLAVESVNROOT = "SLAVESVNROOT";
    public static final String TAG_SLAVESVNURL = "SLAVESVNURL";
    public static final String TAG_SLAVEUSERNAME = "SLAVEUSERNAME";
    public static final String TAG_SLAVESVNUSERNAME = "SLAVESVNUSERNAME";
    public static final String TAG_SLAVESVNPASSWD = "SLAVESVNPASSWD";
    public static final String TAG_SVNUSERNAME = "SVNUSERNAME";
    public static final String TAG_SVNPASSWD = "SVNPASSWD";
    public static final String TAG_SVNTYPE = "SVNTYPE";
    public static final String TAG_GITPRJ = "GITPRJ";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_GITUSERNAME = "GITUSERNAME";
    public static final String TAG_GITPASSWORD = "GITPASSWORD";
    public static final String TAG_GITADMINUSER = "GITADMINUSER";
    public static final String TAG_GITADMINPASS = "GITADMINPASS";
    public static final String TAG_GITTOKEN = "GITTOKEN";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";

    public final boolean isPSSVNSERVERIDNull() {
        return this.IsParamNull(TAG_PSSVNSERVERID);
    }

    public final String getPSSVNSERVERID() {
        return this.GetParamStringValue(TAG_PSSVNSERVERID, "");
    }

    public final void setPSSVNSERVERID(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERID, strValue);
    }

    public final boolean isPSSVNSERVERNAMENull() {
        return this.IsParamNull(TAG_PSSVNSERVERNAME);
    }

    public final String getPSSVNSERVERNAME() {
        return this.GetParamStringValue(TAG_PSSVNSERVERNAME, "");
    }

    public final void setPSSVNSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERNAME, strValue);
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

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
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

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isSVNURLNull() {
        return this.IsParamNull(TAG_SVNURL);
    }

    public final String getSVNURL() {
        return this.GetParamStringValue(TAG_SVNURL, "");
    }

    public final void setSVNURL(String strValue) {
        this.SetParamValue(TAG_SVNURL, strValue);
    }

    public final boolean isSVNROOTNull() {
        return this.IsParamNull(TAG_SVNROOT);
    }

    public final String getSVNROOT() {
        return this.GetParamStringValue(TAG_SVNROOT, "");
    }

    public final void setSVNROOT(String strValue) {
        this.SetParamValue(TAG_SVNROOT, strValue);
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

    public final boolean isAUTHZCFGNull() {
        return this.IsParamNull(TAG_AUTHZCFG);
    }

    public final String getAUTHZCFG() {
        return this.GetParamStringValue(TAG_AUTHZCFG, "");
    }

    public final void setAUTHZCFG(String strValue) {
        this.SetParamValue(TAG_AUTHZCFG, strValue);
    }

    public final boolean isSLAVEIPADDRNull() {
        return this.IsParamNull(TAG_SLAVEIPADDR);
    }

    public final String getSLAVEIPADDR() {
        return this.GetParamStringValue(TAG_SLAVEIPADDR, "");
    }

    public final void setSLAVEIPADDR(String strValue) {
        this.SetParamValue(TAG_SLAVEIPADDR, strValue);
    }

    public final boolean isSLAVEIPADDR2Null() {
        return this.IsParamNull(TAG_SLAVEIPADDR2);
    }

    public final String getSLAVEIPADDR2() {
        return this.GetParamStringValue(TAG_SLAVEIPADDR2, "");
    }

    public final void setSLAVEIPADDR2(String strValue) {
        this.SetParamValue(TAG_SLAVEIPADDR2, strValue);
    }

    public final boolean isSLAVEPASSWDNull() {
        return this.IsParamNull(TAG_SLAVEPASSWD);
    }

    public final String getSLAVEPASSWD() {
        return this.GetParamStringValue(TAG_SLAVEPASSWD, "");
    }

    public final void setSLAVEPASSWD(String strValue) {
        this.SetParamValue(TAG_SLAVEPASSWD, strValue);
    }

    public final boolean isSLAVEPORTNull() {
        return this.IsParamNull(TAG_SLAVEPORT);
    }

    public final int getSLAVEPORT() {
        return this.GetParamIntValue(TAG_SLAVEPORT, 0);
    }

    public final void setSLAVEPORT(int nValue) {
        this.SetParamValue(TAG_SLAVEPORT, nValue);
    }

    public final boolean isSLAVESVNROOTNull() {
        return this.IsParamNull(TAG_SLAVESVNROOT);
    }

    public final String getSLAVESVNROOT() {
        return this.GetParamStringValue(TAG_SLAVESVNROOT, "");
    }

    public final void setSLAVESVNROOT(String strValue) {
        this.SetParamValue(TAG_SLAVESVNROOT, strValue);
    }

    public final boolean isSLAVESVNURLNull() {
        return this.IsParamNull(TAG_SLAVESVNURL);
    }

    public final String getSLAVESVNURL() {
        return this.GetParamStringValue(TAG_SLAVESVNURL, "");
    }

    public final void setSLAVESVNURL(String strValue) {
        this.SetParamValue(TAG_SLAVESVNURL, strValue);
    }

    public final boolean isSLAVEUSERNAMENull() {
        return this.IsParamNull(TAG_SLAVEUSERNAME);
    }

    public final String getSLAVEUSERNAME() {
        return this.GetParamStringValue(TAG_SLAVEUSERNAME, "");
    }

    public final void setSLAVEUSERNAME(String strValue) {
        this.SetParamValue(TAG_SLAVEUSERNAME, strValue);
    }

    public final boolean isSLAVESVNUSERNAMENull() {
        return this.IsParamNull(TAG_SLAVESVNUSERNAME);
    }

    public final String getSLAVESVNUSERNAME() {
        return this.GetParamStringValue(TAG_SLAVESVNUSERNAME, "");
    }

    public final void setSLAVESVNUSERNAME(String strValue) {
        this.SetParamValue(TAG_SLAVESVNUSERNAME, strValue);
    }

    public final boolean isSLAVESVNPASSWDNull() {
        return this.IsParamNull(TAG_SLAVESVNPASSWD);
    }

    public final String getSLAVESVNPASSWD() {
        return this.GetParamStringValue(TAG_SLAVESVNPASSWD, "");
    }

    public final void setSLAVESVNPASSWD(String strValue) {
        this.SetParamValue(TAG_SLAVESVNPASSWD, strValue);
    }

    public final boolean isSVNUSERNAMENull() {
        return this.IsParamNull(TAG_SVNUSERNAME);
    }

    public final String getSVNUSERNAME() {
        return this.GetParamStringValue(TAG_SVNUSERNAME, "");
    }

    public final void setSVNUSERNAME(String strValue) {
        this.SetParamValue(TAG_SVNUSERNAME, strValue);
    }

    public final boolean isSVNPASSWDNull() {
        return this.IsParamNull(TAG_SVNPASSWD);
    }

    public final String getSVNPASSWD() {
        return this.GetParamStringValue(TAG_SVNPASSWD, "");
    }

    public final void setSVNPASSWD(String strValue) {
        this.SetParamValue(TAG_SVNPASSWD, strValue);
    }

    public final boolean isSVNTYPENull() {
        return this.IsParamNull(TAG_SVNTYPE);
    }

    public final String getSVNTYPE() {
        return this.GetParamStringValue(TAG_SVNTYPE, "");
    }

    public final void setSVNTYPE(String strValue) {
        this.SetParamValue(TAG_SVNTYPE, strValue);
    }

    public final boolean isGITPRJNull() {
        return this.IsParamNull(TAG_GITPRJ);
    }

    public final String getGITPRJ() {
        return this.GetParamStringValue(TAG_GITPRJ, "");
    }

    public final void setGITPRJ(String strValue) {
        this.SetParamValue(TAG_GITPRJ, strValue);
    }

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
    }

    public final boolean isGITUSERNAMENull() {
        return this.IsParamNull(TAG_GITUSERNAME);
    }

    public final String getGITUSERNAME() {
        return this.GetParamStringValue(TAG_GITUSERNAME, "");
    }

    public final void setGITUSERNAME(String strValue) {
        this.SetParamValue(TAG_GITUSERNAME, strValue);
    }

    public final boolean isGITPASSWORDNull() {
        return this.IsParamNull(TAG_GITPASSWORD);
    }

    public final String getGITPASSWORD() {
        return this.GetParamStringValue(TAG_GITPASSWORD, "");
    }

    public final void setGITPASSWORD(String strValue) {
        this.SetParamValue(TAG_GITPASSWORD, strValue);
    }

    public final boolean isGITADMINUSERNull() {
        return this.IsParamNull(TAG_GITADMINUSER);
    }

    public final String getGITADMINUSER() {
        return this.GetParamStringValue(TAG_GITADMINUSER, "");
    }

    public final void setGITADMINUSER(String strValue) {
        this.SetParamValue(TAG_GITADMINUSER, strValue);
    }

    public final boolean isGITADMINPASSNull() {
        return this.IsParamNull(TAG_GITADMINPASS);
    }

    public final String getGITADMINPASS() {
        return this.GetParamStringValue(TAG_GITADMINPASS, "");
    }

    public final void setGITADMINPASS(String strValue) {
        this.SetParamValue(TAG_GITADMINPASS, strValue);
    }

    public final boolean isGITTOKENNull() {
        return this.IsParamNull(TAG_GITTOKEN);
    }

    public final String getGITTOKEN() {
        return this.GetParamStringValue(TAG_GITTOKEN, "");
    }

    public final void setGITTOKEN(String strValue) {
        this.SetParamValue(TAG_GITTOKEN, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }
}

