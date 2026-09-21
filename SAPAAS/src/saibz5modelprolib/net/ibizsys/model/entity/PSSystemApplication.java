/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSystemApplication
extends BaseDataEntity {
    public static final String UISTYLE_DEFAULT = "DEFAULT";
    public static final String UISTYLE_STYLE2 = "STYLE2";
    public static final String UISTYLE_STYLE3 = "STYLE3";
    public static final String UISTYLE_STYLE4 = "STYLE4";
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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSPFIDNull() {
        return this.isParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.getParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.setParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.isParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.getParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.setParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isPSPFSTYLEIDNull() {
        return this.isParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.getParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.setParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.isParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.getParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSPFSTYLENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isAPPPKGNAMENull() {
        return this.isParamNull(TAG_APPPKGNAME);
    }

    public final String getAPPPKGNAME() {
        return this.getParamStringValue(TAG_APPPKGNAME, "");
    }

    public final void setAPPPKGNAME(String strValue) {
        this.setParamValue(TAG_APPPKGNAME, strValue);
    }

    public final boolean isCODEFOLDERNull() {
        return this.isParamNull(TAG_CODEFOLDER);
    }

    public final String getCODEFOLDER() {
        return this.getParamStringValue(TAG_CODEFOLDER, "");
    }

    public final void setCODEFOLDER(String strValue) {
        this.setParamValue(TAG_CODEFOLDER, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isPFSTYLEPARAMNull() {
        return this.isParamNull(TAG_PFSTYLEPARAM);
    }

    public final String getPFSTYLEPARAM() {
        return this.getParamStringValue(TAG_PFSTYLEPARAM, "");
    }

    public final void setPFSTYLEPARAM(String strValue) {
        this.setParamValue(TAG_PFSTYLEPARAM, strValue);
    }

    public final boolean isDEFAULTPUBNull() {
        return this.isParamNull(TAG_DEFAULTPUB);
    }

    public final boolean getDEFAULTPUB() {
        return this.getParamIntValue(TAG_DEFAULTPUB, 0) == 1;
    }

    public final void setDEFAULTPUB(boolean bValue) {
        this.setParamValue(TAG_DEFAULTPUB, bValue ? 1 : 0);
    }

    public final boolean isAPPFOLDERNull() {
        return this.isParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.getParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.setParamValue(TAG_APPFOLDER, strValue);
    }

    public final boolean isPSAPPTYPEIDNull() {
        return this.isParamNull(TAG_PSAPPTYPEID);
    }

    public final String getPSAPPTYPEID() {
        return this.getParamStringValue(TAG_PSAPPTYPEID, "");
    }

    public final void setPSAPPTYPEID(String strValue) {
        this.setParamValue(TAG_PSAPPTYPEID, strValue);
    }

    public final boolean isPSAPPTYPENAMENull() {
        return this.isParamNull(TAG_PSAPPTYPENAME);
    }

    public final String getPSAPPTYPENAME() {
        return this.getParamStringValue(TAG_PSAPPTYPENAME, "");
    }

    public final void setPSAPPTYPENAME(String strValue) {
        this.setParamValue(TAG_PSAPPTYPENAME, strValue);
    }

    public final boolean isPSSYSSFPUBIDNull() {
        return this.isParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.getParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.setParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.isParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.getParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.setParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.isParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.getParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.setParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isPSPFCDNIDNull() {
        return this.isParamNull(TAG_PSPFCDNID);
    }

    public final String getPSPFCDNID() {
        return this.getParamStringValue(TAG_PSPFCDNID, "");
    }

    public final void setPSPFCDNID(String strValue) {
        this.setParamValue(TAG_PSPFCDNID, strValue);
    }

    public final boolean isPSPFCDNNAMENull() {
        return this.isParamNull(TAG_PSPFCDNNAME);
    }

    public final String getPSPFCDNNAME() {
        return this.getParamStringValue(TAG_PSPFCDNNAME, "");
    }

    public final void setPSPFCDNNAME(String strValue) {
        this.setParamValue(TAG_PSPFCDNNAME, strValue);
    }

    public final boolean isREMOVEFLAGNull() {
        return this.isParamNull(TAG_REMOVEFLAG);
    }

    public final int getREMOVEFLAG() {
        return this.getParamIntValue(TAG_REMOVEFLAG, 0);
    }

    public final void setREMOVEFLAG(int nValue) {
        this.setParamValue(TAG_REMOVEFLAG, nValue);
    }

    public final boolean isPUBSYSREFVIEWONLYNull() {
        return this.isParamNull(TAG_PUBSYSREFVIEWONLY);
    }

    public final boolean getPUBSYSREFVIEWONLY() {
        return this.getParamIntValue(TAG_PUBSYSREFVIEWONLY, 0) == 1;
    }

    public final void setPUBSYSREFVIEWONLY(boolean bValue) {
        this.setParamValue(TAG_PUBSYSREFVIEWONLY, bValue ? 1 : 0);
    }

    public final boolean isORIENTATIONMODENull() {
        return this.isParamNull(TAG_ORIENTATIONMODE);
    }

    public final String getORIENTATIONMODE() {
        return this.getParamStringValue(TAG_ORIENTATIONMODE, "");
    }

    public final void setORIENTATIONMODE(String strValue) {
        this.setParamValue(TAG_ORIENTATIONMODE, strValue);
    }

    public final boolean isICONFILENull() {
        return this.isParamNull(TAG_ICONFILE);
    }

    public final String getICONFILE() {
        return this.getParamStringValue(TAG_ICONFILE, "");
    }

    public final void setICONFILE(String strValue) {
        this.setParamValue(TAG_ICONFILE, strValue);
    }

    public final boolean isSTARTPAGEFILENull() {
        return this.isParamNull(TAG_STARTPAGEFILE);
    }

    public final String getSTARTPAGEFILE() {
        return this.getParamStringValue(TAG_STARTPAGEFILE, "");
    }

    public final void setSTARTPAGEFILE(String strValue) {
        this.setParamValue(TAG_STARTPAGEFILE, strValue);
    }

    public final boolean isBTNNOPRIVDMNull() {
        return this.isParamNull(TAG_BTNNOPRIVDM);
    }

    public final int getBTNNOPRIVDM() {
        return this.getParamIntValue(TAG_BTNNOPRIVDM, 0);
    }

    public final void setBTNNOPRIVDM(int nValue) {
        this.setParamValue(TAG_BTNNOPRIVDM, nValue);
    }

    public final boolean isENABLEC12TOC24Null() {
        return this.isParamNull(TAG_ENABLEC12TOC24);
    }

    public final boolean getENABLEC12TOC24() {
        return this.getParamIntValue(TAG_ENABLEC12TOC24, 0) == 1;
    }

    public final void setENABLEC12TOC24(boolean bValue) {
        this.setParamValue(TAG_ENABLEC12TOC24, bValue ? 1 : 0);
    }

    public final boolean isPUBREFVIEWONLYNull() {
        return this.isParamNull(TAG_PUBREFVIEWONLY);
    }

    public final boolean getPUBREFVIEWONLY() {
        return this.getParamIntValue(TAG_PUBREFVIEWONLY, 0) == 1;
    }

    public final void setPUBREFVIEWONLY(boolean bValue) {
        this.setParamValue(TAG_PUBREFVIEWONLY, bValue ? 1 : 0);
    }

    public final boolean isENALOCALSERVICENull() {
        return this.isParamNull(TAG_ENALOCALSERVICE);
    }

    public final boolean getENALOCALSERVICE() {
        return this.getParamIntValue(TAG_ENALOCALSERVICE, 0) == 1;
    }

    public final void setENALOCALSERVICE(boolean bValue) {
        this.setParamValue(TAG_ENALOCALSERVICE, bValue ? 1 : 0);
    }

    public final boolean isPSDEVSLNSYSAPPIDNull() {
        return this.isParamNull(TAG_PSDEVSLNSYSAPPID);
    }

    public final String getPSDEVSLNSYSAPPID() {
        return this.getParamStringValue(TAG_PSDEVSLNSYSAPPID, "");
    }

    public final void setPSDEVSLNSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSDEVSLNSYSAPPID, strValue);
    }

    public final boolean isAUTOADDAPPVIEWNull() {
        return this.isParamNull(TAG_AUTOADDAPPVIEW);
    }

    public final boolean getAUTOADDAPPVIEW() {
        return this.getParamIntValue(TAG_AUTOADDAPPVIEW, 0) == 1;
    }

    public final void setAUTOADDAPPVIEW(boolean bValue) {
        this.setParamValue(TAG_AUTOADDAPPVIEW, bValue ? 1 : 0);
    }

    public final boolean isGRIDFORCEFITNull() {
        return this.isParamNull(TAG_GRIDFORCEFIT);
    }

    public final boolean getGRIDFORCEFIT() {
        return this.getParamIntValue(TAG_GRIDFORCEFIT, 0) == 1;
    }

    public final void setGRIDFORCEFIT(boolean bValue) {
        this.setParamValue(TAG_GRIDFORCEFIT, bValue ? 1 : 0);
    }

    public final boolean isPREVENTXSSNull() {
        return this.isParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.getParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.setParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isGRIDROWACTIVEMODENull() {
        return this.isParamNull(TAG_GRIDROWACTIVEMODE);
    }

    public final int getGRIDROWACTIVEMODE() {
        return this.getParamIntValue(TAG_GRIDROWACTIVEMODE, 0);
    }

    public final void setGRIDROWACTIVEMODE(int nValue) {
        this.setParamValue(TAG_GRIDROWACTIVEMODE, nValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.isParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.getParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.setParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isUACLOGINNull() {
        return this.isParamNull(TAG_UACLOGIN);
    }

    public final boolean getUACLOGIN() {
        return this.getParamIntValue(TAG_UACLOGIN, 0) == 1;
    }

    public final void setUACLOGIN(boolean bValue) {
        this.setParamValue(TAG_UACLOGIN, bValue ? 1 : 0);
    }

    public final boolean isUISTYLENull() {
        return this.isParamNull(TAG_UISTYLE);
    }

    public final String getUISTYLE() {
        return this.getParamStringValue(TAG_UISTYLE, "");
    }

    public final void setUISTYLE(String strValue) {
        this.setParamValue(TAG_UISTYLE, strValue);
    }
}

