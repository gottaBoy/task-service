/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysPortlet
extends BaseDataEntity {
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String PORTLETTYPE_APPMENU = "APPMENU";
    public static final String PORTLETTYPE_INFO = "INFO";
    public static final String PORTLETTYPE_EDITFORM = "EDITFORM";
    public static final String PORTLETTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String HTMLSHOWMODE_INNER = "INNER";
    public static final String HTMLSHOWMODE_IFRAME = "IFRAME";
    public static final String TAG_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String TAG_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PORTLETTYPE = "PORTLETTYPE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSDEVIEWID = "PSDEVIEWID";
    public static final String TAG_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String TAG_HTMLURL = "HTMLURL";
    public static final String TAG_RELOADTIMER = "RELOADTIMER";
    public static final String TAG_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String TAG_TITLEPSSYSPFPLUGINID = "TITLEPSSYSPFPLUGINID";
    public static final String TAG_TITLEPSSYSPFPLUGINNAME = "TITLEPSSYSPFPLUGINNAME";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_HTMLSHOWMODE = "HTMLSHOWMODE";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";

    public final boolean isPSSYSPORTLETIDNull() {
        return this.isParamNull(TAG_PSSYSPORTLETID);
    }

    public final String getPSSYSPORTLETID() {
        return this.getParamStringValue(TAG_PSSYSPORTLETID, "");
    }

    public final void setPSSYSPORTLETID(String strValue) {
        this.setParamValue(TAG_PSSYSPORTLETID, strValue);
    }

    public final boolean isPSSYSPORTLETNAMENull() {
        return this.isParamNull(TAG_PSSYSPORTLETNAME);
    }

    public final String getPSSYSPORTLETNAME() {
        return this.getParamStringValue(TAG_PSSYSPORTLETNAME, "");
    }

    public final void setPSSYSPORTLETNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPORTLETNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPORTLETTYPENull() {
        return this.isParamNull(TAG_PORTLETTYPE);
    }

    public final String getPORTLETTYPE() {
        return this.getParamStringValue(TAG_PORTLETTYPE, "");
    }

    public final void setPORTLETTYPE(String strValue) {
        this.setParamValue(TAG_PORTLETTYPE, strValue);
    }

    public final boolean isPSDECHARTIDNull() {
        return this.isParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.getParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.setParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.isParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.getParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isPSDELISTIDNull() {
        return this.isParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.getParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.setParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.isParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.getParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.setParamValue(TAG_PSDELISTNAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSDEVIEWIDNull() {
        return this.isParamNull(TAG_PSDEVIEWID);
    }

    public final String getPSDEVIEWID() {
        return this.getParamStringValue(TAG_PSDEVIEWID, "");
    }

    public final void setPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWID, strValue);
    }

    public final boolean isPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_PSDEVIEWNAME);
    }

    public final String getPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_PSDEVIEWNAME, "");
    }

    public final void setPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWNAME, strValue);
    }

    public final boolean isHTMLURLNull() {
        return this.isParamNull(TAG_HTMLURL);
    }

    public final String getHTMLURL() {
        return this.getParamStringValue(TAG_HTMLURL, "");
    }

    public final void setHTMLURL(String strValue) {
        this.setParamValue(TAG_HTMLURL, strValue);
    }

    public final boolean isRELOADTIMERNull() {
        return this.isParamNull(TAG_RELOADTIMER);
    }

    public final int getRELOADTIMER() {
        return this.getParamIntValue(TAG_RELOADTIMER, 0);
    }

    public final void setRELOADTIMER(int nValue) {
        this.setParamValue(TAG_RELOADTIMER, nValue);
    }

    public final boolean isSHOWTITLEBARNull() {
        return this.isParamNull(TAG_SHOWTITLEBAR);
    }

    public final boolean getSHOWTITLEBAR() {
        return this.getParamIntValue(TAG_SHOWTITLEBAR, 0) == 1;
    }

    public final void setSHOWTITLEBAR(boolean bValue) {
        this.setParamValue(TAG_SHOWTITLEBAR, bValue ? 1 : 0);
    }

    public final boolean isTITLEPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_TITLEPSSYSPFPLUGINID);
    }

    public final String getTITLEPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_TITLEPSSYSPFPLUGINID, "");
    }

    public final void setTITLEPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_TITLEPSSYSPFPLUGINID, strValue);
    }

    public final boolean isTITLEPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_TITLEPSSYSPFPLUGINNAME);
    }

    public final String getTITLEPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_TITLEPSSYSPFPLUGINNAME, "");
    }

    public final void setTITLEPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_TITLEPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.isParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.getParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.setParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.isParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.getParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.isParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.getParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isTODOTASKNull() {
        return this.isParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.getParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.setParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.isParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.getParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.isParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.getParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isHTMLSHOWMODENull() {
        return this.isParamNull(TAG_HTMLSHOWMODE);
    }

    public final String getHTMLSHOWMODE() {
        return this.getParamStringValue(TAG_HTMLSHOWMODE, "");
    }

    public final void setHTMLSHOWMODE(String strValue) {
        this.setParamValue(TAG_HTMLSHOWMODE, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.isParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.getParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.setParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.isParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.getParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isADPSDELOGICIDNull() {
        return this.isParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.getParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.isParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.getParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICNAME, strValue);
    }
}

