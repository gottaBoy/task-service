/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenter
extends BaseDataEntity {
    public static final String DCTYPE_DEVCENTER = "DEVCENTER";
    public static final String DCTYPE_SPCENTER = "SPCENTER";
    public static final String DCTYPE_RUNCENTER = "RUNCENTER";
    public static final int DCLEVEL_COMMUNITY = 100;
    public static final int DCLEVEL_PROFESSION = 200;
    public static final int DCLEVEL_ENTERPRISE = 300;
    public static final int DCLEVEL_ADVANCE = 400;
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DOMAINNAME = "DOMAINNAME";
    public static final String TAG_DCTYPE = "DCTYPE";
    public static final String TAG_SPFLAG = "SPFLAG";
    public static final String TAG_PSSVRPROVIDERID = "PSSVRPROVIDERID";
    public static final String TAG_PSSVRPROVIDERNAME = "PSSVRPROVIDERNAME";
    public static final String TAG_PSDCINSTID = "PSDCINSTID";
    public static final String TAG_PSDCINSTNAME = "PSDCINSTNAME";
    public static final String TAG_FULLDOMAINNAME = "FULLDOMAINNAME";
    public static final String TAG_PSSVNINSTREPOID = "PSSVNINSTREPOID";
    public static final String TAG_PSSVNINSTREPONAME = "PSSVNINSTREPONAME";
    public static final String TAG_WEBFOLDER = "WEBFOLDER";
    public static final String TAG_WEBSITEURL = "WEBSITEURL";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_MAXSYSCNT = "MAXSYSCNT";
    public static final String TAG_SYSCNT = "SYSCNT";
    public static final String TAG_MAXENTITYCNT = "MAXENTITYCNT";
    public static final String TAG_ENTITYCNT = "ENTITYCNT";
    public static final String TAG_ROPSSVNINSTREPOID = "ROPSSVNINSTREPOID";
    public static final String TAG_ROPSSVNINSTREPONAME = "ROPSSVNINSTREPONAME";
    public static final String TAG_MAXACTIVEUSERCNT = "MAXACTIVEUSERCNT";
    public static final String TAG_DCLEVEL = "DCLEVEL";
    public static final String TAG_TOTALENERGY = "TOTALENERGY";
    public static final String TAG_EXPERIENCE = "EXPERIENCE";
    public static final String TAG_PSRTWXACCOUNTID = "PSRTWXACCOUNTID";
    public static final String TAG_PSRTWXACCOUNTNAME = "PSRTWXACCOUNTNAME";
    public static final String TAG_WXDEPTID = "WXDEPTID";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ROBOTCHGTIME = "ROBOTCHGTIME";
    public static final String TAG_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String TAG_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String TAG_DCROWKEY = "DCROWKEY";
    public static final String TAG_SYSSN = "SYSSN";
    public static final String TAG_DCTAG = "DCTAG";
    public static final String TAG_DCTAG2 = "DCTAG2";
    public static final String TAG_IPADDRS = "IPADDRS";
    public static final String TAG_ENABLEWORKSPACE = "ENABLEWORKSPACE";
    public static final String TAG_DCTAG3 = "DCTAG3";
    public static final String TAG_DCTAG4 = "DCTAG4";
    public static final String TAG_STUDIOVER = "STUDIOVER";
    public static final String TAG_STUDIOTAG2 = "STUDIOTAG2";
    public static final String TAG_STUDIOTAG = "STUDIOTAG";
    public static final String TAG_V6PSSVNINSTREPOID = "V6PSSVNINSTREPOID";
    public static final String TAG_V6PSSVNINSTREPONAME = "V6PSSVNINSTREPONAME";

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isDOMAINNAMENull() {
        return this.IsParamNull(TAG_DOMAINNAME);
    }

    public final String getDOMAINNAME() {
        return this.GetParamStringValue(TAG_DOMAINNAME, "");
    }

    public final void setDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_DOMAINNAME, strValue);
    }

    public final boolean isDCTYPENull() {
        return this.IsParamNull(TAG_DCTYPE);
    }

    public final String getDCTYPE() {
        return this.GetParamStringValue(TAG_DCTYPE, "");
    }

    public final void setDCTYPE(String strValue) {
        this.SetParamValue(TAG_DCTYPE, strValue);
    }

    public final boolean isSPFLAGNull() {
        return this.IsParamNull(TAG_SPFLAG);
    }

    public final boolean getSPFLAG() {
        return this.GetParamIntValue(TAG_SPFLAG, 0) == 1;
    }

    public final void setSPFLAG(boolean bValue) {
        this.SetParamValue(TAG_SPFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSVRPROVIDERIDNull() {
        return this.IsParamNull(TAG_PSSVRPROVIDERID);
    }

    public final String getPSSVRPROVIDERID() {
        return this.GetParamStringValue(TAG_PSSVRPROVIDERID, "");
    }

    public final void setPSSVRPROVIDERID(String strValue) {
        this.SetParamValue(TAG_PSSVRPROVIDERID, strValue);
    }

    public final boolean isPSSVRPROVIDERNAMENull() {
        return this.IsParamNull(TAG_PSSVRPROVIDERNAME);
    }

    public final String getPSSVRPROVIDERNAME() {
        return this.GetParamStringValue(TAG_PSSVRPROVIDERNAME, "");
    }

    public final void setPSSVRPROVIDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRPROVIDERNAME, strValue);
    }

    public final boolean isPSDCINSTIDNull() {
        return this.IsParamNull(TAG_PSDCINSTID);
    }

    public final String getPSDCINSTID() {
        return this.GetParamStringValue(TAG_PSDCINSTID, "");
    }

    public final void setPSDCINSTID(String strValue) {
        this.SetParamValue(TAG_PSDCINSTID, strValue);
    }

    public final boolean isPSDCINSTNAMENull() {
        return this.IsParamNull(TAG_PSDCINSTNAME);
    }

    public final String getPSDCINSTNAME() {
        return this.GetParamStringValue(TAG_PSDCINSTNAME, "");
    }

    public final void setPSDCINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCINSTNAME, strValue);
    }

    public final boolean isFULLDOMAINNAMENull() {
        return this.IsParamNull(TAG_FULLDOMAINNAME);
    }

    public final String getFULLDOMAINNAME() {
        return this.GetParamStringValue(TAG_FULLDOMAINNAME, "");
    }

    public final void setFULLDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_FULLDOMAINNAME, strValue);
    }

    public final boolean isPSSVNINSTREPOIDNull() {
        return this.IsParamNull(TAG_PSSVNINSTREPOID);
    }

    public final String getPSSVNINSTREPOID() {
        return this.GetParamStringValue(TAG_PSSVNINSTREPOID, "");
    }

    public final void setPSSVNINSTREPOID(String strValue) {
        this.SetParamValue(TAG_PSSVNINSTREPOID, strValue);
    }

    public final boolean isPSSVNINSTREPONAMENull() {
        return this.IsParamNull(TAG_PSSVNINSTREPONAME);
    }

    public final String getPSSVNINSTREPONAME() {
        return this.GetParamStringValue(TAG_PSSVNINSTREPONAME, "");
    }

    public final void setPSSVNINSTREPONAME(String strValue) {
        this.SetParamValue(TAG_PSSVNINSTREPONAME, strValue);
    }

    public final boolean isWEBFOLDERNull() {
        return this.IsParamNull(TAG_WEBFOLDER);
    }

    public final String getWEBFOLDER() {
        return this.GetParamStringValue(TAG_WEBFOLDER, "");
    }

    public final void setWEBFOLDER(String strValue) {
        this.SetParamValue(TAG_WEBFOLDER, strValue);
    }

    public final boolean isWEBSITEURLNull() {
        return this.IsParamNull(TAG_WEBSITEURL);
    }

    public final String getWEBSITEURL() {
        return this.GetParamStringValue(TAG_WEBSITEURL, "");
    }

    public final void setWEBSITEURL(String strValue) {
        this.SetParamValue(TAG_WEBSITEURL, strValue);
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

    public final boolean isMAXSYSCNTNull() {
        return this.IsParamNull(TAG_MAXSYSCNT);
    }

    public final int getMAXSYSCNT() {
        return this.GetParamIntValue(TAG_MAXSYSCNT, 0);
    }

    public final void setMAXSYSCNT(int nValue) {
        this.SetParamValue(TAG_MAXSYSCNT, nValue);
    }

    public final boolean isSYSCNTNull() {
        return this.IsParamNull(TAG_SYSCNT);
    }

    public final int getSYSCNT() {
        return this.GetParamIntValue(TAG_SYSCNT, 0);
    }

    public final void setSYSCNT(int nValue) {
        this.SetParamValue(TAG_SYSCNT, nValue);
    }

    public final boolean isMAXENTITYCNTNull() {
        return this.IsParamNull(TAG_MAXENTITYCNT);
    }

    public final int getMAXENTITYCNT() {
        return this.GetParamIntValue(TAG_MAXENTITYCNT, 0);
    }

    public final void setMAXENTITYCNT(int nValue) {
        this.SetParamValue(TAG_MAXENTITYCNT, nValue);
    }

    public final boolean isENTITYCNTNull() {
        return this.IsParamNull(TAG_ENTITYCNT);
    }

    public final int getENTITYCNT() {
        return this.GetParamIntValue(TAG_ENTITYCNT, 0);
    }

    public final void setENTITYCNT(int nValue) {
        this.SetParamValue(TAG_ENTITYCNT, nValue);
    }

    public final boolean isROPSSVNINSTREPOIDNull() {
        return this.IsParamNull(TAG_ROPSSVNINSTREPOID);
    }

    public final String getROPSSVNINSTREPOID() {
        return this.GetParamStringValue(TAG_ROPSSVNINSTREPOID, "");
    }

    public final void setROPSSVNINSTREPOID(String strValue) {
        this.SetParamValue(TAG_ROPSSVNINSTREPOID, strValue);
    }

    public final boolean isROPSSVNINSTREPONAMENull() {
        return this.IsParamNull(TAG_ROPSSVNINSTREPONAME);
    }

    public final String getROPSSVNINSTREPONAME() {
        return this.GetParamStringValue(TAG_ROPSSVNINSTREPONAME, "");
    }

    public final void setROPSSVNINSTREPONAME(String strValue) {
        this.SetParamValue(TAG_ROPSSVNINSTREPONAME, strValue);
    }

    public final boolean isMAXACTIVEUSERCNTNull() {
        return this.IsParamNull(TAG_MAXACTIVEUSERCNT);
    }

    public final int getMAXACTIVEUSERCNT() {
        return this.GetParamIntValue(TAG_MAXACTIVEUSERCNT, 0);
    }

    public final void setMAXACTIVEUSERCNT(int nValue) {
        this.SetParamValue(TAG_MAXACTIVEUSERCNT, nValue);
    }

    public final boolean isDCLEVELNull() {
        return this.IsParamNull(TAG_DCLEVEL);
    }

    public final int getDCLEVEL() {
        return this.GetParamIntValue(TAG_DCLEVEL, 0);
    }

    public final void setDCLEVEL(int nValue) {
        this.SetParamValue(TAG_DCLEVEL, nValue);
    }

    public final boolean isTOTALENERGYNull() {
        return this.IsParamNull(TAG_TOTALENERGY);
    }

    public final int getTOTALENERGY() {
        return this.GetParamIntValue(TAG_TOTALENERGY, 0);
    }

    public final void setTOTALENERGY(int nValue) {
        this.SetParamValue(TAG_TOTALENERGY, nValue);
    }

    public final boolean isEXPERIENCENull() {
        return this.IsParamNull(TAG_EXPERIENCE);
    }

    public final int getEXPERIENCE() {
        return this.GetParamIntValue(TAG_EXPERIENCE, 0);
    }

    public final void setEXPERIENCE(int nValue) {
        this.SetParamValue(TAG_EXPERIENCE, nValue);
    }

    public final boolean isPSRTWXACCOUNTIDNull() {
        return this.IsParamNull(TAG_PSRTWXACCOUNTID);
    }

    public final String getPSRTWXACCOUNTID() {
        return this.GetParamStringValue(TAG_PSRTWXACCOUNTID, "");
    }

    public final void setPSRTWXACCOUNTID(String strValue) {
        this.SetParamValue(TAG_PSRTWXACCOUNTID, strValue);
    }

    public final boolean isPSRTWXACCOUNTNAMENull() {
        return this.IsParamNull(TAG_PSRTWXACCOUNTNAME);
    }

    public final String getPSRTWXACCOUNTNAME() {
        return this.GetParamStringValue(TAG_PSRTWXACCOUNTNAME, "");
    }

    public final void setPSRTWXACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_PSRTWXACCOUNTNAME, strValue);
    }

    public final boolean isWXDEPTIDNull() {
        return this.IsParamNull(TAG_WXDEPTID);
    }

    public final int getWXDEPTID() {
        return this.GetParamIntValue(TAG_WXDEPTID, 0);
    }

    public final void setWXDEPTID(int nValue) {
        this.SetParamValue(TAG_WXDEPTID, nValue);
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

    public final boolean isROBOTCHGTIMENull() {
        return this.IsParamNull(TAG_ROBOTCHGTIME);
    }

    public final Date getROBOTCHGTIME() {
        return this.GetParamDateValue(TAG_ROBOTCHGTIME, null);
    }

    public final void setROBOTCHGTIME(Date dtValue) {
        this.SetParamValue(TAG_ROBOTCHGTIME, dtValue);
    }

    public final boolean isENABLEWSSERVERNull() {
        return this.IsParamNull(TAG_ENABLEWSSERVER);
    }

    public final boolean getENABLEWSSERVER() {
        return this.GetParamIntValue(TAG_ENABLEWSSERVER, 0) == 1;
    }

    public final void setENABLEWSSERVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEWSSERVER, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEPLOYCENTERNull() {
        return this.IsParamNull(TAG_ENABLEDEPLOYCENTER);
    }

    public final boolean getENABLEDEPLOYCENTER() {
        return this.GetParamIntValue(TAG_ENABLEDEPLOYCENTER, 0) == 1;
    }

    public final void setENABLEDEPLOYCENTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEPLOYCENTER, bValue ? 1 : 0);
    }

    public final boolean isDCROWKEYNull() {
        return this.IsParamNull(TAG_DCROWKEY);
    }

    public final String getDCROWKEY() {
        return this.GetParamStringValue(TAG_DCROWKEY, "");
    }

    public final void setDCROWKEY(String strValue) {
        this.SetParamValue(TAG_DCROWKEY, strValue);
    }

    public final boolean isSYSSNNull() {
        return this.IsParamNull(TAG_SYSSN);
    }

    public final int getSYSSN() {
        return this.GetParamIntValue(TAG_SYSSN, 0);
    }

    public final void setSYSSN(int nValue) {
        this.SetParamValue(TAG_SYSSN, nValue);
    }

    public final boolean isDCTAGNull() {
        return this.IsParamNull(TAG_DCTAG);
    }

    public final String getDCTAG() {
        return this.GetParamStringValue(TAG_DCTAG, "");
    }

    public final void setDCTAG(String strValue) {
        this.SetParamValue(TAG_DCTAG, strValue);
    }

    public final boolean isDCTAG2Null() {
        return this.IsParamNull(TAG_DCTAG2);
    }

    public final String getDCTAG2() {
        return this.GetParamStringValue(TAG_DCTAG2, "");
    }

    public final void setDCTAG2(String strValue) {
        this.SetParamValue(TAG_DCTAG2, strValue);
    }

    public final boolean isIPADDRSNull() {
        return this.IsParamNull(TAG_IPADDRS);
    }

    public final String getIPADDRS() {
        return this.GetParamStringValue(TAG_IPADDRS, "");
    }

    public final void setIPADDRS(String strValue) {
        this.SetParamValue(TAG_IPADDRS, strValue);
    }

    public final boolean isENABLEWORKSPACENull() {
        return this.IsParamNull(TAG_ENABLEWORKSPACE);
    }

    public final boolean getENABLEWORKSPACE() {
        return this.GetParamIntValue(TAG_ENABLEWORKSPACE, 0) == 1;
    }

    public final void setENABLEWORKSPACE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEWORKSPACE, bValue ? 1 : 0);
    }

    public final boolean isDCTAG3Null() {
        return this.IsParamNull(TAG_DCTAG3);
    }

    public final String getDCTAG3() {
        return this.GetParamStringValue(TAG_DCTAG3, "");
    }

    public final void setDCTAG3(String strValue) {
        this.SetParamValue(TAG_DCTAG3, strValue);
    }

    public final boolean isDCTAG4Null() {
        return this.IsParamNull(TAG_DCTAG4);
    }

    public final String getDCTAG4() {
        return this.GetParamStringValue(TAG_DCTAG4, "");
    }

    public final void setDCTAG4(String strValue) {
        this.SetParamValue(TAG_DCTAG4, strValue);
    }

    public final boolean isSTUDIOVERNull() {
        return this.IsParamNull(TAG_STUDIOVER);
    }

    public final String getSTUDIOVER() {
        return this.GetParamStringValue(TAG_STUDIOVER, "");
    }

    public final void setSTUDIOVER(String strValue) {
        this.SetParamValue(TAG_STUDIOVER, strValue);
    }

    public final boolean isSTUDIOTAG2Null() {
        return this.IsParamNull(TAG_STUDIOTAG2);
    }

    public final String getSTUDIOTAG2() {
        return this.GetParamStringValue(TAG_STUDIOTAG2, "");
    }

    public final void setSTUDIOTAG2(String strValue) {
        this.SetParamValue(TAG_STUDIOTAG2, strValue);
    }

    public final boolean isSTUDIOTAGNull() {
        return this.IsParamNull(TAG_STUDIOTAG);
    }

    public final String getSTUDIOTAG() {
        return this.GetParamStringValue(TAG_STUDIOTAG, "");
    }

    public final void setSTUDIOTAG(String strValue) {
        this.SetParamValue(TAG_STUDIOTAG, strValue);
    }

    public final boolean isV6PSSVNINSTREPOIDNull() {
        return this.IsParamNull(TAG_V6PSSVNINSTREPOID);
    }

    public final String getV6PSSVNINSTREPOID() {
        return this.GetParamStringValue(TAG_V6PSSVNINSTREPOID, "");
    }

    public final void setV6PSSVNINSTREPOID(String strValue) {
        this.SetParamValue(TAG_V6PSSVNINSTREPOID, strValue);
    }

    public final boolean isV6PSSVNINSTREPONAMENull() {
        return this.IsParamNull(TAG_V6PSSVNINSTREPONAME);
    }

    public final String getV6PSSVNINSTREPONAME() {
        return this.GetParamStringValue(TAG_V6PSSVNINSTREPONAME, "");
    }

    public final void setV6PSSVNINSTREPONAME(String strValue) {
        this.SetParamValue(TAG_V6PSSVNINSTREPONAME, strValue);
    }
}

