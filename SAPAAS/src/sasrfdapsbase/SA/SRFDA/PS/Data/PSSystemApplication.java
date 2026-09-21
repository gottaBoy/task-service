/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemApplication
extends BaseDataEntity {
    public static final String UISTYLE_DEFAULT = "DEFAULT";
    public static final String UISTYLE_STYLE2 = "STYLE2";
    public static final String UISTYLE_STYLE3 = "STYLE3";
    public static final String UISTYLE_STYLE4 = "STYLE4";
    public static final String APPMODE_DEFAULT = "DEFAULT";
    public static final String APPMODE_WFAPP = "WFAPP";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_APPPKGNAME = "APPPKGNAME";
    public static final String TAG_CODEFOLDER = "CODEFOLDER";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String TAG_DEFAULTPUB = "DEFAULTPUB";
    public static final String TAG_APPFOLDER = "APPFOLDER";
    public static final String TAG_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String TAG_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String TAG_PSPFCDNID = "PSPFCDNID";
    public static final String TAG_PSPFCDNNAME = "PSPFCDNNAME";
    public static final String TAG_REMOVEFLAG = "REMOVEFLAG";
    public static final String TAG_PUBSYSREFVIEWONLY = "PUBSYSREFVIEWONLY";
    public static final String TAG_ORIENTATIONMODE = "ORIENTATIONMODE";
    public static final String TAG_ICONFILE = "ICONFILE";
    public static final String TAG_STARTPAGEFILE = "STARTPAGEFILE";
    public static final String TAG_BTNNOPRIVDM = "BTNNOPRIVDM";
    public static final String TAG_ENABLEC12TOC24 = "ENABLEC12TOC24";
    public static final String TAG_PUBREFVIEWONLY = "PUBREFVIEWONLY";
    public static final String TAG_ENALOCALSERVICE = "ENALOCALSERVICE";
    public static final String TAG_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String TAG_AUTOADDAPPVIEW = "AUTOADDAPPVIEW";
    public static final String TAG_GRIDFORCEFIT = "GRIDFORCEFIT";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_GRIDROWACTIVEMODE = "GRIDROWACTIVEMODE";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_UACLOGIN = "UACLOGIN";
    public static final String TAG_UISTYLE = "UISTYLE";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String TAG_FINOPRIVDM = "FINOPRIVDM";
    public static final String TAG_GCNOPRIVDM = "GCNOPRIVDM";
    public static final String TAG_FIUPDATEPRIVTAG = "FIUPDATEPRIVTAG";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_APPMODE = "APPMODE";
    public static final String TAG_GRIDCOLENABLELINK = "GRIDCOLENABLELINK";
    public static final String TAG_DEFAULTPORT = "DEFAULTPORT";
    public static final String TAG_MDCTRLEMPTYTEXT = "MDCTRLEMPTYTEXT";
    public static final String TAG_MDCTRLEMPTYTEXTPSLANRESID = "MDCTRLEMPTYTEXTPSLANRESID";
    public static final String TAG_MDCTRLEMPTYTEXTPSLANRESNAME = "MDCTRLEMPTYTEXTPSLANRESNAME";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_BOTTOMINFO = "BOTTOMINFO";
    public static final String TAG_HEADERINFO = "HEADERINFO";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_GRIDENABLECUSTOMIZED = "GRIDENABLECUSTOMIZED";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_FIEMPTYTEXT = "FIEMPTYTEXT";
    public static final String TAG_SERVICEDTOFLAG = "SERVICEDTOFLAG";
    public static final String TAG_ACMINCHARS = "ACMINCHARS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String TAG_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String TAG_APPTAG = "APPTAG";
    public static final String TAG_APPTAG2 = "APPTAG2";
    public static final String TAG_APPTAG3 = "APPTAG3";
    public static final String TAG_APPTAG4 = "APPTAG4";
    public static final String TAG_GRIDCOLENABLEFILTER = "GRIDCOLENABLEFILTER";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
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

    public final boolean isAPPPKGNAMENull() {
        return this.IsParamNull(TAG_APPPKGNAME);
    }

    public final String getAPPPKGNAME() {
        return this.GetParamStringValue(TAG_APPPKGNAME, "");
    }

    public final void setAPPPKGNAME(String strValue) {
        this.SetParamValue(TAG_APPPKGNAME, strValue);
    }

    public final boolean isCODEFOLDERNull() {
        return this.IsParamNull(TAG_CODEFOLDER);
    }

    public final String getCODEFOLDER() {
        return this.GetParamStringValue(TAG_CODEFOLDER, "");
    }

    public final void setCODEFOLDER(String strValue) {
        this.SetParamValue(TAG_CODEFOLDER, strValue);
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

    public final boolean isPFSTYLEPARAMNull() {
        return this.IsParamNull(TAG_PFSTYLEPARAM);
    }

    public final String getPFSTYLEPARAM() {
        return this.GetParamStringValue(TAG_PFSTYLEPARAM, "");
    }

    public final void setPFSTYLEPARAM(String strValue) {
        this.SetParamValue(TAG_PFSTYLEPARAM, strValue);
    }

    public final boolean isDEFAULTPUBNull() {
        return this.IsParamNull(TAG_DEFAULTPUB);
    }

    public final boolean getDEFAULTPUB() {
        return this.GetParamIntValue(TAG_DEFAULTPUB, 0) == 1;
    }

    public final void setDEFAULTPUB(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPUB, bValue ? 1 : 0);
    }

    public final boolean isAPPFOLDERNull() {
        return this.IsParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.GetParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.SetParamValue(TAG_APPFOLDER, strValue);
    }

    public final boolean isPSAPPTYPEIDNull() {
        return this.IsParamNull(TAG_PSAPPTYPEID);
    }

    public final String getPSAPPTYPEID() {
        return this.GetParamStringValue(TAG_PSAPPTYPEID, "");
    }

    public final void setPSAPPTYPEID(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPEID, strValue);
    }

    public final boolean isPSAPPTYPENAMENull() {
        return this.IsParamNull(TAG_PSAPPTYPENAME);
    }

    public final String getPSAPPTYPENAME() {
        return this.GetParamStringValue(TAG_PSAPPTYPENAME, "");
    }

    public final void setPSAPPTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPTYPENAME, strValue);
    }

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.IsParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.GetParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.SetParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isPSPFCDNIDNull() {
        return this.IsParamNull(TAG_PSPFCDNID);
    }

    public final String getPSPFCDNID() {
        return this.GetParamStringValue(TAG_PSPFCDNID, "");
    }

    public final void setPSPFCDNID(String strValue) {
        this.SetParamValue(TAG_PSPFCDNID, strValue);
    }

    public final boolean isPSPFCDNNAMENull() {
        return this.IsParamNull(TAG_PSPFCDNNAME);
    }

    public final String getPSPFCDNNAME() {
        return this.GetParamStringValue(TAG_PSPFCDNNAME, "");
    }

    public final void setPSPFCDNNAME(String strValue) {
        this.SetParamValue(TAG_PSPFCDNNAME, strValue);
    }

    public final boolean isREMOVEFLAGNull() {
        return this.IsParamNull(TAG_REMOVEFLAG);
    }

    public final int getREMOVEFLAG() {
        return this.GetParamIntValue(TAG_REMOVEFLAG, 0);
    }

    public final void setREMOVEFLAG(int nValue) {
        this.SetParamValue(TAG_REMOVEFLAG, nValue);
    }

    public final boolean isPUBSYSREFVIEWONLYNull() {
        return this.IsParamNull(TAG_PUBSYSREFVIEWONLY);
    }

    public final boolean getPUBSYSREFVIEWONLY() {
        return this.GetParamIntValue(TAG_PUBSYSREFVIEWONLY, 0) == 1;
    }

    public final void setPUBSYSREFVIEWONLY(boolean bValue) {
        this.SetParamValue(TAG_PUBSYSREFVIEWONLY, bValue ? 1 : 0);
    }

    public final boolean isORIENTATIONMODENull() {
        return this.IsParamNull(TAG_ORIENTATIONMODE);
    }

    public final String getORIENTATIONMODE() {
        return this.GetParamStringValue(TAG_ORIENTATIONMODE, "");
    }

    public final void setORIENTATIONMODE(String strValue) {
        this.SetParamValue(TAG_ORIENTATIONMODE, strValue);
    }

    public final boolean isICONFILENull() {
        return this.IsParamNull(TAG_ICONFILE);
    }

    public final String getICONFILE() {
        return this.GetParamStringValue(TAG_ICONFILE, "");
    }

    public final void setICONFILE(String strValue) {
        this.SetParamValue(TAG_ICONFILE, strValue);
    }

    public final boolean isSTARTPAGEFILENull() {
        return this.IsParamNull(TAG_STARTPAGEFILE);
    }

    public final String getSTARTPAGEFILE() {
        return this.GetParamStringValue(TAG_STARTPAGEFILE, "");
    }

    public final void setSTARTPAGEFILE(String strValue) {
        this.SetParamValue(TAG_STARTPAGEFILE, strValue);
    }

    public final boolean isBTNNOPRIVDMNull() {
        return this.IsParamNull(TAG_BTNNOPRIVDM);
    }

    public final int getBTNNOPRIVDM() {
        return this.GetParamIntValue(TAG_BTNNOPRIVDM, 0);
    }

    public final void setBTNNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_BTNNOPRIVDM, nValue);
    }

    public final boolean isENABLEC12TOC24Null() {
        return this.IsParamNull(TAG_ENABLEC12TOC24);
    }

    public final boolean getENABLEC12TOC24() {
        return this.GetParamIntValue(TAG_ENABLEC12TOC24, 0) == 1;
    }

    public final void setENABLEC12TOC24(boolean bValue) {
        this.SetParamValue(TAG_ENABLEC12TOC24, bValue ? 1 : 0);
    }

    public final boolean isPUBREFVIEWONLYNull() {
        return this.IsParamNull(TAG_PUBREFVIEWONLY);
    }

    public final boolean getPUBREFVIEWONLY() {
        return this.GetParamIntValue(TAG_PUBREFVIEWONLY, 0) == 1;
    }

    public final void setPUBREFVIEWONLY(boolean bValue) {
        this.SetParamValue(TAG_PUBREFVIEWONLY, bValue ? 1 : 0);
    }

    public final boolean isENALOCALSERVICENull() {
        return this.IsParamNull(TAG_ENALOCALSERVICE);
    }

    public final boolean getENALOCALSERVICE() {
        return this.GetParamIntValue(TAG_ENALOCALSERVICE, 0) == 1;
    }

    public final void setENALOCALSERVICE(boolean bValue) {
        this.SetParamValue(TAG_ENALOCALSERVICE, bValue ? 1 : 0);
    }

    public final boolean isPSDEVSLNSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPID);
    }

    public final String getPSDEVSLNSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPID, "");
    }

    public final void setPSDEVSLNSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPID, strValue);
    }

    public final boolean isAUTOADDAPPVIEWNull() {
        return this.IsParamNull(TAG_AUTOADDAPPVIEW);
    }

    public final boolean getAUTOADDAPPVIEW() {
        return this.GetParamIntValue(TAG_AUTOADDAPPVIEW, 0) == 1;
    }

    public final void setAUTOADDAPPVIEW(boolean bValue) {
        this.SetParamValue(TAG_AUTOADDAPPVIEW, bValue ? 1 : 0);
    }

    public final boolean isGRIDFORCEFITNull() {
        return this.IsParamNull(TAG_GRIDFORCEFIT);
    }

    public final boolean getGRIDFORCEFIT() {
        return this.GetParamIntValue(TAG_GRIDFORCEFIT, 0) == 1;
    }

    public final void setGRIDFORCEFIT(boolean bValue) {
        this.SetParamValue(TAG_GRIDFORCEFIT, bValue ? 1 : 0);
    }

    public final boolean isPREVENTXSSNull() {
        return this.IsParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.GetParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.SetParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isGRIDROWACTIVEMODENull() {
        return this.IsParamNull(TAG_GRIDROWACTIVEMODE);
    }

    public final int getGRIDROWACTIVEMODE() {
        return this.GetParamIntValue(TAG_GRIDROWACTIVEMODE, 0);
    }

    public final void setGRIDROWACTIVEMODE(int nValue) {
        this.SetParamValue(TAG_GRIDROWACTIVEMODE, nValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isUACLOGINNull() {
        return this.IsParamNull(TAG_UACLOGIN);
    }

    public final boolean getUACLOGIN() {
        return this.GetParamIntValue(TAG_UACLOGIN, 0) == 1;
    }

    public final void setUACLOGIN(boolean bValue) {
        this.SetParamValue(TAG_UACLOGIN, bValue ? 1 : 0);
    }

    public final boolean isUISTYLENull() {
        return this.IsParamNull(TAG_UISTYLE);
    }

    public final String getUISTYLE() {
        return this.GetParamStringValue(TAG_UISTYLE, "");
    }

    public final void setUISTYLE(String strValue) {
        this.SetParamValue(TAG_UISTYLE, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }

    public final boolean isFINOPRIVDMNull() {
        return this.IsParamNull(TAG_FINOPRIVDM);
    }

    public final int getFINOPRIVDM() {
        return this.GetParamIntValue(TAG_FINOPRIVDM, 0);
    }

    public final void setFINOPRIVDM(int nValue) {
        this.SetParamValue(TAG_FINOPRIVDM, nValue);
    }

    public final boolean isGCNOPRIVDMNull() {
        return this.IsParamNull(TAG_GCNOPRIVDM);
    }

    public final int getGCNOPRIVDM() {
        return this.GetParamIntValue(TAG_GCNOPRIVDM, 0);
    }

    public final void setGCNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_GCNOPRIVDM, nValue);
    }

    public final boolean isFIUPDATEPRIVTAGNull() {
        return this.IsParamNull(TAG_FIUPDATEPRIVTAG);
    }

    public final boolean getFIUPDATEPRIVTAG() {
        return this.GetParamIntValue(TAG_FIUPDATEPRIVTAG, 0) == 1;
    }

    public final void setFIUPDATEPRIVTAG(boolean bValue) {
        this.SetParamValue(TAG_FIUPDATEPRIVTAG, bValue ? 1 : 0);
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

    public final boolean isAPPMODENull() {
        return this.IsParamNull(TAG_APPMODE);
    }

    public final String getAPPMODE() {
        return this.GetParamStringValue(TAG_APPMODE, "");
    }

    public final void setAPPMODE(String strValue) {
        this.SetParamValue(TAG_APPMODE, strValue);
    }

    public final boolean isGRIDCOLENABLELINKNull() {
        return this.IsParamNull(TAG_GRIDCOLENABLELINK);
    }

    public final int getGRIDCOLENABLELINK() {
        return this.GetParamIntValue(TAG_GRIDCOLENABLELINK, 0);
    }

    public final void setGRIDCOLENABLELINK(int nValue) {
        this.SetParamValue(TAG_GRIDCOLENABLELINK, nValue);
    }

    public final boolean isDEFAULTPORTNull() {
        return this.IsParamNull(TAG_DEFAULTPORT);
    }

    public final int getDEFAULTPORT() {
        return this.GetParamIntValue(TAG_DEFAULTPORT, 0);
    }

    public final void setDEFAULTPORT(int nValue) {
        this.SetParamValue(TAG_DEFAULTPORT, nValue);
    }

    public final boolean isMDCTRLEMPTYTEXTNull() {
        return this.IsParamNull(TAG_MDCTRLEMPTYTEXT);
    }

    public final String getMDCTRLEMPTYTEXT() {
        return this.GetParamStringValue(TAG_MDCTRLEMPTYTEXT, "");
    }

    public final void setMDCTRLEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_MDCTRLEMPTYTEXT, strValue);
    }

    public final boolean isMDCTRLEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_MDCTRLEMPTYTEXTPSLANRESID);
    }

    public final String getMDCTRLEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_MDCTRLEMPTYTEXTPSLANRESID, "");
    }

    public final void setMDCTRLEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_MDCTRLEMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isMDCTRLEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_MDCTRLEMPTYTEXTPSLANRESNAME);
    }

    public final String getMDCTRLEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_MDCTRLEMPTYTEXTPSLANRESNAME, "");
    }

    public final void setMDCTRLEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_MDCTRLEMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.IsParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.GetParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.SetParamValue(TAG_SUBCAPTION, strValue);
    }

    public final boolean isBOTTOMINFONull() {
        return this.IsParamNull(TAG_BOTTOMINFO);
    }

    public final String getBOTTOMINFO() {
        return this.GetParamStringValue(TAG_BOTTOMINFO, "");
    }

    public final void setBOTTOMINFO(String strValue) {
        this.SetParamValue(TAG_BOTTOMINFO, strValue);
    }

    public final boolean isHEADERINFONull() {
        return this.IsParamNull(TAG_HEADERINFO);
    }

    public final String getHEADERINFO() {
        return this.GetParamStringValue(TAG_HEADERINFO, "");
    }

    public final void setHEADERINFO(String strValue) {
        this.SetParamValue(TAG_HEADERINFO, strValue);
    }

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
    }

    public final boolean isGRIDENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_GRIDENABLECUSTOMIZED);
    }

    public final boolean getGRIDENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_GRIDENABLECUSTOMIZED, 0) == 1;
    }

    public final void setGRIDENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_GRIDENABLECUSTOMIZED, bValue ? 1 : 0);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPID);
    }

    public final String getPSCTRLLOGICGROUPID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPID, "");
    }

    public final void setPSCTRLLOGICGROUPID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPID, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPNAME);
    }

    public final String getPSCTRLLOGICGROUPNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPNAME, "");
    }

    public final void setPSCTRLLOGICGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPNAME, strValue);
    }

    public final boolean isFIEMPTYTEXTNull() {
        return this.IsParamNull(TAG_FIEMPTYTEXT);
    }

    public final String getFIEMPTYTEXT() {
        return this.GetParamStringValue(TAG_FIEMPTYTEXT, "");
    }

    public final void setFIEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_FIEMPTYTEXT, strValue);
    }

    public final boolean isSERVICEDTOFLAGNull() {
        return this.IsParamNull(TAG_SERVICEDTOFLAG);
    }

    public final boolean getSERVICEDTOFLAG() {
        return this.GetParamIntValue(TAG_SERVICEDTOFLAG, 0) == 1;
    }

    public final void setSERVICEDTOFLAG(boolean bValue) {
        this.SetParamValue(TAG_SERVICEDTOFLAG, bValue ? 1 : 0);
    }

    public final boolean isACMINCHARSNull() {
        return this.IsParamNull(TAG_ACMINCHARS);
    }

    public final int getACMINCHARS() {
        return this.GetParamIntValue(TAG_ACMINCHARS, 0);
    }

    public final void setACMINCHARS(int nValue) {
        this.SetParamValue(TAG_ACMINCHARS, nValue);
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

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
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

    public final boolean isDEPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINID);
    }

    public final String getDEPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINID, "");
    }

    public final void setDEPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINID, strValue);
    }

    public final boolean isDEPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINNAME);
    }

    public final String getDEPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINNAME, "");
    }

    public final void setDEPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isAPPTAGNull() {
        return this.IsParamNull(TAG_APPTAG);
    }

    public final String getAPPTAG() {
        return this.GetParamStringValue(TAG_APPTAG, "");
    }

    public final void setAPPTAG(String strValue) {
        this.SetParamValue(TAG_APPTAG, strValue);
    }

    public final boolean isAPPTAG2Null() {
        return this.IsParamNull(TAG_APPTAG2);
    }

    public final String getAPPTAG2() {
        return this.GetParamStringValue(TAG_APPTAG2, "");
    }

    public final void setAPPTAG2(String strValue) {
        this.SetParamValue(TAG_APPTAG2, strValue);
    }

    public final boolean isAPPTAG3Null() {
        return this.IsParamNull(TAG_APPTAG3);
    }

    public final String getAPPTAG3() {
        return this.GetParamStringValue(TAG_APPTAG3, "");
    }

    public final void setAPPTAG3(String strValue) {
        this.SetParamValue(TAG_APPTAG3, strValue);
    }

    public final boolean isAPPTAG4Null() {
        return this.IsParamNull(TAG_APPTAG4);
    }

    public final String getAPPTAG4() {
        return this.GetParamStringValue(TAG_APPTAG4, "");
    }

    public final void setAPPTAG4(String strValue) {
        this.SetParamValue(TAG_APPTAG4, strValue);
    }

    public final boolean isGRIDCOLENABLEFILTERNull() {
        return this.IsParamNull(TAG_GRIDCOLENABLEFILTER);
    }

    public final int getGRIDCOLENABLEFILTER() {
        return this.GetParamIntValue(TAG_GRIDCOLENABLEFILTER, 0);
    }

    public final void setGRIDCOLENABLEFILTER(int nValue) {
        this.SetParamValue(TAG_GRIDCOLENABLEFILTER, nValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isCODENAMEMODENull() {
        return this.IsParamNull(TAG_CODENAMEMODE);
    }

    public final String getCODENAMEMODE() {
        return this.GetParamStringValue(TAG_CODENAMEMODE, "");
    }

    public final void setCODENAMEMODE(String strValue) {
        this.SetParamValue(TAG_CODENAMEMODE, strValue);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

