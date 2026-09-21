/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppLocalDE
extends BaseDataEntity {
    public static final String TAG_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String TAG_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ENABLESTORAGE = "ENABLESTORAGE";
    public static final String TAG_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String TAG_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_MAJORFLAG = "MAJORFLAG";
    public static final String TAG_PPSAPPLOCALDEID = "PPSAPPLOCALDEID";
    public static final String TAG_PPSAPPLOCALDENAME = "PPSAPPLOCALDENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DELOGICNAME = "DELOGICNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_ACCCTRLARCH = "ACCCTRLARCH";
    public static final String TAG_DATAACCMODE = "DATAACCMODE";
    public static final String TAG_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String TAG_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String TAG_DEFGROUPMODE = "DEFGROUPMODE";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String TAG_AUTOADDMETHODMODE = "AUTOADDMETHODMODE";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String TAG_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String TAG_SDPSDEVIEWID = "SDPSDEVIEWID";
    public static final String TAG_SDPSDEVIEWNAME = "SDPSDEVIEWNAME";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_USERACTION = "USERACTION";
    public static final String TAG_CUSTOMUSERACTION = "CUSTOMUSERACTION";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";

    public final boolean isPSAPPLOCALDEIDNull() {
        return this.IsParamNull(TAG_PSAPPLOCALDEID);
    }

    public final String getPSAPPLOCALDEID() {
        return this.GetParamStringValue(TAG_PSAPPLOCALDEID, "");
    }

    public final void setPSAPPLOCALDEID(String strValue) {
        this.SetParamValue(TAG_PSAPPLOCALDEID, strValue);
    }

    public final boolean isPSAPPLOCALDENAMENull() {
        return this.IsParamNull(TAG_PSAPPLOCALDENAME);
    }

    public final String getPSAPPLOCALDENAME() {
        return this.GetParamStringValue(TAG_PSAPPLOCALDENAME, "");
    }

    public final void setPSAPPLOCALDENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPLOCALDENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLESTORAGENull() {
        return this.IsParamNull(TAG_ENABLESTORAGE);
    }

    public final boolean getENABLESTORAGE() {
        return this.GetParamIntValue(TAG_ENABLESTORAGE, 0) == 1;
    }

    public final void setENABLESTORAGE(boolean bValue) {
        this.SetParamValue(TAG_ENABLESTORAGE, bValue ? 1 : 0);
    }

    public final boolean isPSAPPMODULEIDNull() {
        return this.IsParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.GetParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.IsParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.GetParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULENAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isPPSAPPLOCALDEIDNull() {
        return this.IsParamNull(TAG_PPSAPPLOCALDEID);
    }

    public final String getPPSAPPLOCALDEID() {
        return this.GetParamStringValue(TAG_PPSAPPLOCALDEID, "");
    }

    public final void setPPSAPPLOCALDEID(String strValue) {
        this.SetParamValue(TAG_PPSAPPLOCALDEID, strValue);
    }

    public final boolean isPPSAPPLOCALDENAMENull() {
        return this.IsParamNull(TAG_PPSAPPLOCALDENAME);
    }

    public final String getPPSAPPLOCALDENAME() {
        return this.GetParamStringValue(TAG_PPSAPPLOCALDENAME, "");
    }

    public final void setPPSAPPLOCALDENAME(String strValue) {
        this.SetParamValue(TAG_PPSAPPLOCALDENAME, strValue);
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

    public final boolean isDELOGICNAMENull() {
        return this.IsParamNull(TAG_DELOGICNAME);
    }

    public final String getDELOGICNAME() {
        return this.GetParamStringValue(TAG_DELOGICNAME, "");
    }

    public final void setDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DELOGICNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
    }

    public final boolean isMAJORFLAGNull() {
        return this.IsParamNull(TAG_MAJORFLAG);
    }

    public final int getMAJORFLAG() {
        return this.GetParamIntValue(TAG_MAJORFLAG, 0);
    }

    public final void setMAJORFLAG(int nValue) {
        this.SetParamValue(TAG_MAJORFLAG, nValue);
    }

    public final boolean isACCCTRLARCHNull() {
        return this.IsParamNull(TAG_ACCCTRLARCH);
    }

    public final int getACCCTRLARCH() {
        return this.GetParamIntValue(TAG_ACCCTRLARCH, 0);
    }

    public final void setACCCTRLARCH(int nValue) {
        this.SetParamValue(TAG_ACCCTRLARCH, nValue);
    }

    public final boolean isDATAACCMODENull() {
        return this.IsParamNull(TAG_DATAACCMODE);
    }

    public final int getDATAACCMODE() {
        return this.GetParamIntValue(TAG_DATAACCMODE, 0);
    }

    public final void setDATAACCMODE(int nValue) {
        this.SetParamValue(TAG_DATAACCMODE, nValue);
    }

    public final boolean isPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSDESERVICEAPIID);
    }

    public final String getPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPIID, "");
    }

    public final void setPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPIID, strValue);
    }

    public final boolean isPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSDESERVICEAPINAME);
    }

    public final String getPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPINAME, "");
    }

    public final void setPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPINAME, strValue);
    }

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }

    public final boolean isDEFGROUPMODENull() {
        return this.IsParamNull(TAG_DEFGROUPMODE);
    }

    public final String getDEFGROUPMODE() {
        return this.GetParamStringValue(TAG_DEFGROUPMODE, "");
    }

    public final void setDEFGROUPMODE(String strValue) {
        this.SetParamValue(TAG_DEFGROUPMODE, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isMDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MDPSDEVIEWID);
    }

    public final String getMDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MDPSDEVIEWID, "");
    }

    public final void setMDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MDPSDEVIEWID, strValue);
    }

    public final boolean isMDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MDPSDEVIEWNAME);
    }

    public final String getMDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MDPSDEVIEWNAME, "");
    }

    public final void setMDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MDPSDEVIEWNAME, strValue);
    }

    public final boolean isSDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_SDPSDEVIEWID);
    }

    public final String getSDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWID, "");
    }

    public final void setSDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWID, strValue);
    }

    public final boolean isSDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_SDPSDEVIEWNAME);
    }

    public final String getSDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWNAME, "");
    }

    public final void setSDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWNAME, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPINAME);
    }

    public final String getPSSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPINAME, "");
    }

    public final void setPSSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPINAME, strValue);
    }

    public final boolean isUSERACTIONNull() {
        return this.IsParamNull(TAG_USERACTION);
    }

    public final int getUSERACTION() {
        return this.GetParamIntValue(TAG_USERACTION, 0);
    }

    public final void setUSERACTION(int nValue) {
        this.SetParamValue(TAG_USERACTION, nValue);
    }

    public final boolean isCUSTOMUSERACTIONNull() {
        return this.IsParamNull(TAG_CUSTOMUSERACTION);
    }

    public final boolean getCUSTOMUSERACTION() {
        return this.GetParamIntValue(TAG_CUSTOMUSERACTION, 0) == 1;
    }

    public final void setCUSTOMUSERACTION(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMUSERACTION, bValue ? 1 : 0);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.IsParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.GetParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.IsParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.GetParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }
}

