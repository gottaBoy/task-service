/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSUWProject
extends BaseDataEntity {
    public static final String TAG_PSUWPROJECTID = "PSUWPROJECTID";
    public static final String TAG_PSUWPROJECTNAME = "PSUWPROJECTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_PROJECTNAME = "PROJECTNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_SOURCETYPE = "SOURCETYPE";
    public static final String TAG_SOURCE = "SOURCE";
    public static final String TAG_SOURCENAME = "SOURCENAME";
    public static final String TAG_WIZARDPARAM = "WIZARDPARAM";
    public static final String TAG_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String TAG_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String TAG_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String TAG_ERRORCODE = "ERRORCODE";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String TAG_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String TAG_AUTOCREATESLN = "AUTOCREATESLN";
    public static final String TAG_REALPROJECTID = "REALPROJECTID";
    public static final String TAG_WIZARDSTATE = "WIZARDSTATE";
    public static final String TAG_WIZARDSTEP = "WIZARDSTEP";
    public static final String TAG_WIZARDTAG = "WIZARDTAG";
    public static final String TAG_WIZARDTAG2 = "WIZARDTAG2";
    public static final String TAG_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String TAG_WIZARDPARAM6 = "WIZARDPARAM6";

    public final boolean isPSUWPROJECTIDNull() {
        return this.IsParamNull(TAG_PSUWPROJECTID);
    }

    public final String getPSUWPROJECTID() {
        return this.GetParamStringValue(TAG_PSUWPROJECTID, "");
    }

    public final void setPSUWPROJECTID(String strValue) {
        this.SetParamValue(TAG_PSUWPROJECTID, strValue);
    }

    public final boolean isPSUWPROJECTNAMENull() {
        return this.IsParamNull(TAG_PSUWPROJECTNAME);
    }

    public final String getPSUWPROJECTNAME() {
        return this.GetParamStringValue(TAG_PSUWPROJECTNAME, "");
    }

    public final void setPSUWPROJECTNAME(String strValue) {
        this.SetParamValue(TAG_PSUWPROJECTNAME, strValue);
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

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isWIZARDMODENull() {
        return this.IsParamNull(TAG_WIZARDMODE);
    }

    public final String getWIZARDMODE() {
        return this.GetParamStringValue(TAG_WIZARDMODE, "");
    }

    public final void setWIZARDMODE(String strValue) {
        this.SetParamValue(TAG_WIZARDMODE, strValue);
    }

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
    }

    public final boolean isPROJECTNAMENull() {
        return this.IsParamNull(TAG_PROJECTNAME);
    }

    public final String getPROJECTNAME() {
        return this.GetParamStringValue(TAG_PROJECTNAME, "");
    }

    public final void setPROJECTNAME(String strValue) {
        this.SetParamValue(TAG_PROJECTNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isSOURCETYPENull() {
        return this.IsParamNull(TAG_SOURCETYPE);
    }

    public final String getSOURCETYPE() {
        return this.GetParamStringValue(TAG_SOURCETYPE, "");
    }

    public final void setSOURCETYPE(String strValue) {
        this.SetParamValue(TAG_SOURCETYPE, strValue);
    }

    public final boolean isSOURCENull() {
        return this.IsParamNull(TAG_SOURCE);
    }

    public final String getSOURCE() {
        return this.GetParamStringValue(TAG_SOURCE, "");
    }

    public final void setSOURCE(String strValue) {
        this.SetParamValue(TAG_SOURCE, strValue);
    }

    public final boolean isSOURCENAMENull() {
        return this.IsParamNull(TAG_SOURCENAME);
    }

    public final String getSOURCENAME() {
        return this.GetParamStringValue(TAG_SOURCENAME, "");
    }

    public final void setSOURCENAME(String strValue) {
        this.SetParamValue(TAG_SOURCENAME, strValue);
    }

    public final boolean isWIZARDPARAMNull() {
        return this.IsParamNull(TAG_WIZARDPARAM);
    }

    public final String getWIZARDPARAM() {
        return this.GetParamStringValue(TAG_WIZARDPARAM, "");
    }

    public final void setWIZARDPARAM(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM, strValue);
    }

    public final boolean isWIZARDPARAM2Null() {
        return this.IsParamNull(TAG_WIZARDPARAM2);
    }

    public final String getWIZARDPARAM2() {
        return this.GetParamStringValue(TAG_WIZARDPARAM2, "");
    }

    public final void setWIZARDPARAM2(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM2, strValue);
    }

    public final boolean isWIZARDPARAM3Null() {
        return this.IsParamNull(TAG_WIZARDPARAM3);
    }

    public final String getWIZARDPARAM3() {
        return this.GetParamStringValue(TAG_WIZARDPARAM3, "");
    }

    public final void setWIZARDPARAM3(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM3, strValue);
    }

    public final boolean isWIZARDPARAM4Null() {
        return this.IsParamNull(TAG_WIZARDPARAM4);
    }

    public final String getWIZARDPARAM4() {
        return this.GetParamStringValue(TAG_WIZARDPARAM4, "");
    }

    public final void setWIZARDPARAM4(String strValue) {
        this.SetParamValue(TAG_WIZARDPARAM4, strValue);
    }

    public final boolean isERRORCODENull() {
        return this.IsParamNull(TAG_ERRORCODE);
    }

    public final int getERRORCODE() {
        return this.GetParamIntValue(TAG_ERRORCODE, 0);
    }

    public final void setERRORCODE(int nValue) {
        this.SetParamValue(TAG_ERRORCODE, nValue);
    }

    public final boolean isERRORINFONull() {
        return this.IsParamNull(TAG_ERRORINFO);
    }

    public final String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public final void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

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

    public final boolean isPSDCWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEID);
    }

    public final String getPSDCWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEID, "");
    }

    public final void setPSDCWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEID, strValue);
    }

    public final boolean isPSDCWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACENAME);
    }

    public final String getPSDCWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACENAME, "");
    }

    public final void setPSDCWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACENAME, strValue);
    }

    public final boolean isAUTOCREATESLNNull() {
        return this.IsParamNull(TAG_AUTOCREATESLN);
    }

    public final boolean getAUTOCREATESLN() {
        return this.GetParamIntValue(TAG_AUTOCREATESLN, 0) == 1;
    }

    public final void setAUTOCREATESLN(boolean bValue) {
        this.SetParamValue(TAG_AUTOCREATESLN, bValue ? 1 : 0);
    }

    public final boolean isREALPROJECTIDNull() {
        return this.IsParamNull(TAG_REALPROJECTID);
    }

    public final String getREALPROJECTID() {
        return this.GetParamStringValue(TAG_REALPROJECTID, "");
    }

    public final void setREALPROJECTID(String strValue) {
        this.SetParamValue(TAG_REALPROJECTID, strValue);
    }

    public final boolean isWIZARDSTATENull() {
        return this.IsParamNull(TAG_WIZARDSTATE);
    }

    public final int getWIZARDSTATE() {
        return this.GetParamIntValue(TAG_WIZARDSTATE, 0);
    }

    public final void setWIZARDSTATE(int nValue) {
        this.SetParamValue(TAG_WIZARDSTATE, nValue);
    }

    public final boolean isWIZARDSTEPNull() {
        return this.IsParamNull(TAG_WIZARDSTEP);
    }

    public final String getWIZARDSTEP() {
        return this.GetParamStringValue(TAG_WIZARDSTEP, "");
    }

    public final void setWIZARDSTEP(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEP, strValue);
    }

    public final boolean isWIZARDTAGNull() {
        return this.IsParamNull(TAG_WIZARDTAG);
    }

    public final String getWIZARDTAG() {
        return this.GetParamStringValue(TAG_WIZARDTAG, "");
    }

    public final void setWIZARDTAG(String strValue) {
        this.SetParamValue(TAG_WIZARDTAG, strValue);
    }

    public final boolean isWIZARDTAG2Null() {
        return this.IsParamNull(TAG_WIZARDTAG2);
    }

    public final String getWIZARDTAG2() {
        return this.GetParamStringValue(TAG_WIZARDTAG2, "");
    }

    public final void setWIZARDTAG2(String strValue) {
        this.SetParamValue(TAG_WIZARDTAG2, strValue);
    }

    public final boolean isWIZARDPARAM5Null() {
        return this.IsParamNull(TAG_WIZARDPARAM5);
    }

    public final int getWIZARDPARAM5() {
        return this.GetParamIntValue(TAG_WIZARDPARAM5, 0);
    }

    public final void setWIZARDPARAM5(int nValue) {
        this.SetParamValue(TAG_WIZARDPARAM5, nValue);
    }

    public final boolean isWIZARDPARAM6Null() {
        return this.IsParamNull(TAG_WIZARDPARAM6);
    }

    public final int getWIZARDPARAM6() {
        return this.GetParamIntValue(TAG_WIZARDPARAM6, 0);
    }

    public final void setWIZARDPARAM6(int nValue) {
        this.SetParamValue(TAG_WIZARDPARAM6, nValue);
    }
}

