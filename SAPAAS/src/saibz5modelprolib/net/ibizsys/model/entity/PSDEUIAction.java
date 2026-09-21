/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEUIAction
extends BaseDataEntity {
    public static final String UIACTIONTYPE_SYS = "SYS";
    public static final String UIACTIONTYPE_FRONT = "FRONT";
    public static final String UIACTIONTYPE_BACKEND = "BACKEND";
    public static final String FRONTPROTYPE_WIZARD = "WIZARD";
    public static final String FRONTPROTYPE_SHOWPAGE = "SHOWPAGE";
    public static final String FRONTPROTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String FRONTPROTYPE_OTHER = "OTHER";
    public static final String ACTIONTARGET_SINGLE = "SINGLE";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTI = "MULTI";
    public static final String ACTIONTARGET_ALL = "ALL";
    public static final String ACTIONTARGET_NONE = "NONE";
    public static final String VLEXCEMODE_REPLACE = "REPLACE";
    public static final String VLEXCEMODE_AFTER = "AFTER";
    public static final String VIEWLOGICTYPE_DELOGIC = "DELOGIC";
    public static final String VIEWLOGICTYPE_SYSVIEWLOGIC = "SYSVIEWLOGIC";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_UIACTIONCODE = "UIACTIONCODE";
    public static final String TAG_TEMPLMODE = "TEMPLMODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UIACTIONTYPE = "UIACTIONTYPE";
    public static final String TAG_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String TAG_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_FRONTPROTYPE = "FRONTPROTYPE";
    public static final String TAG_ACTIONTARGET = "ACTIONTARGET";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_SUCCESSINFO = "SUCCESSINFO";
    public static final String TAG_RELOADDATA = "RELOADDATA";
    public static final String TAG_USERCONFIRM = "USERCONFIRM";
    public static final String TAG_CONFIRMINFO = "CONFIRMINFO";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_SYSITEMOBJ = "SYSITEMOBJ";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPLINKID = "PSWFPLINKID";
    public static final String TAG_PSWFPLINKNAME = "PSWFPLINKNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_CLOSEEDITVIEW = "CLOSEEDITVIEW";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_VLEXCEMODE = "VLEXCEMODE";
    public static final String TAG_VIEWLOGICTYPE = "VIEWLOGICTYPE";
    public static final String TAG_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String TAG_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String TAG_VLEXECMODE = "VLEXECMODE";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_CMPSLANRESID = "CMPSLANRESID";
    public static final String TAG_CMPSLANRESNAME = "CMPSLANRESNAME";
    public static final String TAG_SMPSLANRESID = "SMPSLANRESID";
    public static final String TAG_SMPSLANRESNAME = "SMPSLANRESNAME";
    public static final String TAG_NOPRIVDM = "NOPRIVDM";
    public static final String TAG_DATAITEM = "DATAITEM";
    public static final String TAG_TEXTITEM = "TEXTITEM";
    public static final String TAG_PARAMITEM = "PARAMITEM";
    public static final String TAG_GLOBALFLAG = "GLOBALFLAG";
    public static final String TAG_ENABLERTMODEL = "ENABLERTMODEL";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_NEXTPSDEUIACTIONID = "NEXTPSDEUIACTIONID";
    public static final String TAG_NEXTPSDEUIACTIONNAME = "NEXTPSDEUIACTIONNAME";
    public static final String TAG_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String TAG_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String TAG_PDTVIEWFLAG = "PDTVIEWFLAG";

    public final boolean isPSDEUIACTIONIDNull() {
        return this.isParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.getParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONNAME, strValue);
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

    public final boolean isUIACTIONCODENull() {
        return this.isParamNull(TAG_UIACTIONCODE);
    }

    public final String getUIACTIONCODE() {
        return this.getParamStringValue(TAG_UIACTIONCODE, "");
    }

    public final void setUIACTIONCODE(String strValue) {
        this.setParamValue(TAG_UIACTIONCODE, strValue);
    }

    public final boolean isTEMPLMODENull() {
        return this.isParamNull(TAG_TEMPLMODE);
    }

    public final boolean getTEMPLMODE() {
        return this.getParamIntValue(TAG_TEMPLMODE, 0) == 1;
    }

    public final void setTEMPLMODE(boolean bValue) {
        this.setParamValue(TAG_TEMPLMODE, bValue ? 1 : 0);
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

    public final boolean isUIACTIONTYPENull() {
        return this.isParamNull(TAG_UIACTIONTYPE);
    }

    public final String getUIACTIONTYPE() {
        return this.getParamStringValue(TAG_UIACTIONTYPE, "");
    }

    public final void setUIACTIONTYPE(String strValue) {
        this.setParamValue(TAG_UIACTIONTYPE, strValue);
    }

    public final boolean isPSSYSUIACTIONIDNull() {
        return this.isParamNull(TAG_PSSYSUIACTIONID);
    }

    public final String getPSSYSUIACTIONID() {
        return this.getParamStringValue(TAG_PSSYSUIACTIONID, "");
    }

    public final void setPSSYSUIACTIONID(String strValue) {
        this.setParamValue(TAG_PSSYSUIACTIONID, strValue);
    }

    public final boolean isPSSYSUIACTIONNAMENull() {
        return this.isParamNull(TAG_PSSYSUIACTIONNAME);
    }

    public final String getPSSYSUIACTIONNAME() {
        return this.getParamStringValue(TAG_PSSYSUIACTIONNAME, "");
    }

    public final void setPSSYSUIACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUIACTIONNAME, strValue);
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

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isFRONTPROTYPENull() {
        return this.isParamNull(TAG_FRONTPROTYPE);
    }

    public final String getFRONTPROTYPE() {
        return this.getParamStringValue(TAG_FRONTPROTYPE, "");
    }

    public final void setFRONTPROTYPE(String strValue) {
        this.setParamValue(TAG_FRONTPROTYPE, strValue);
    }

    public final boolean isACTIONTARGETNull() {
        return this.isParamNull(TAG_ACTIONTARGET);
    }

    public final String getACTIONTARGET() {
        return this.getParamStringValue(TAG_ACTIONTARGET, "");
    }

    public final void setACTIONTARGET(String strValue) {
        this.setParamValue(TAG_ACTIONTARGET, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isTIMEOUTNull() {
        return this.isParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.getParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.setParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isSUCCESSINFONull() {
        return this.isParamNull(TAG_SUCCESSINFO);
    }

    public final String getSUCCESSINFO() {
        return this.getParamStringValue(TAG_SUCCESSINFO, "");
    }

    public final void setSUCCESSINFO(String strValue) {
        this.setParamValue(TAG_SUCCESSINFO, strValue);
    }

    public final boolean isRELOADDATANull() {
        return this.isParamNull(TAG_RELOADDATA);
    }

    public final boolean getRELOADDATA() {
        return this.getParamIntValue(TAG_RELOADDATA, 0) == 1;
    }

    public final void setRELOADDATA(boolean bValue) {
        this.setParamValue(TAG_RELOADDATA, bValue ? 1 : 0);
    }

    public final boolean isUSERCONFIRMNull() {
        return this.isParamNull(TAG_USERCONFIRM);
    }

    public final boolean getUSERCONFIRM() {
        return this.getParamIntValue(TAG_USERCONFIRM, 0) == 1;
    }

    public final void setUSERCONFIRM(boolean bValue) {
        this.setParamValue(TAG_USERCONFIRM, bValue ? 1 : 0);
    }

    public final boolean isCONFIRMINFONull() {
        return this.isParamNull(TAG_CONFIRMINFO);
    }

    public final String getCONFIRMINFO() {
        return this.getParamStringValue(TAG_CONFIRMINFO, "");
    }

    public final void setCONFIRMINFO(String strValue) {
        this.setParamValue(TAG_CONFIRMINFO, strValue);
    }

    public final boolean isITEMOBJNull() {
        return this.isParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.getParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.setParamValue(TAG_ITEMOBJ, strValue);
    }

    public final boolean isSYSITEMOBJNull() {
        return this.isParamNull(TAG_SYSITEMOBJ);
    }

    public final String getSYSITEMOBJ() {
        return this.getParamStringValue(TAG_SYSITEMOBJ, "");
    }

    public final void setSYSITEMOBJ(String strValue) {
        this.setParamValue(TAG_SYSITEMOBJ, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isUIACTIONPARAMSNull() {
        return this.isParamNull(TAG_UIACTIONPARAMS);
    }

    public final String getUIACTIONPARAMS() {
        return this.getParamStringValue(TAG_UIACTIONPARAMS, "");
    }

    public final void setUIACTIONPARAMS(String strValue) {
        this.setParamValue(TAG_UIACTIONPARAMS, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.isParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.getParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSNAME, strValue);
    }

    public final boolean isPSWFPROCESSIDNull() {
        return this.isParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.getParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPLINKIDNull() {
        return this.isParamNull(TAG_PSWFPLINKID);
    }

    public final String getPSWFPLINKID() {
        return this.getParamStringValue(TAG_PSWFPLINKID, "");
    }

    public final void setPSWFPLINKID(String strValue) {
        this.setParamValue(TAG_PSWFPLINKID, strValue);
    }

    public final boolean isPSWFPLINKNAMENull() {
        return this.isParamNull(TAG_PSWFPLINKNAME);
    }

    public final String getPSWFPLINKNAME() {
        return this.getParamStringValue(TAG_PSWFPLINKNAME, "");
    }

    public final void setPSWFPLINKNAME(String strValue) {
        this.setParamValue(TAG_PSWFPLINKNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.isParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.getParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.setParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isHTMLPAGEURLNull() {
        return this.isParamNull(TAG_HTMLPAGEURL);
    }

    public final String getHTMLPAGEURL() {
        return this.getParamStringValue(TAG_HTMLPAGEURL, "");
    }

    public final void setHTMLPAGEURL(String strValue) {
        this.setParamValue(TAG_HTMLPAGEURL, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isCLOSEEDITVIEWNull() {
        return this.isParamNull(TAG_CLOSEEDITVIEW);
    }

    public final boolean getCLOSEEDITVIEW() {
        return this.getParamIntValue(TAG_CLOSEEDITVIEW, 0) == 1;
    }

    public final void setCLOSEEDITVIEW(boolean bValue) {
        this.setParamValue(TAG_CLOSEEDITVIEW, bValue ? 1 : 0);
    }

    public final boolean isPSSYSVIEWLOGICIDNull() {
        return this.isParamNull(TAG_PSSYSVIEWLOGICID);
    }

    public final String getPSSYSVIEWLOGICID() {
        return this.getParamStringValue(TAG_PSSYSVIEWLOGICID, "");
    }

    public final void setPSSYSVIEWLOGICID(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWLOGICNAMENull() {
        return this.isParamNull(TAG_PSSYSVIEWLOGICNAME);
    }

    public final String getPSSYSVIEWLOGICNAME() {
        return this.getParamStringValue(TAG_PSSYSVIEWLOGICNAME, "");
    }

    public final void setPSSYSVIEWLOGICNAME(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWLOGICNAME, strValue);
    }

    public final boolean isVLEXCEMODENull() {
        return this.isParamNull(TAG_VLEXCEMODE);
    }

    public final String getVLEXCEMODE() {
        return this.getParamStringValue(TAG_VLEXCEMODE, "");
    }

    public final void setVLEXCEMODE(String strValue) {
        this.setParamValue(TAG_VLEXCEMODE, strValue);
    }

    public final boolean isVIEWLOGICTYPENull() {
        return this.isParamNull(TAG_VIEWLOGICTYPE);
    }

    public final String getVIEWLOGICTYPE() {
        return this.getParamStringValue(TAG_VIEWLOGICTYPE, "");
    }

    public final void setVIEWLOGICTYPE(String strValue) {
        this.setParamValue(TAG_VIEWLOGICTYPE, strValue);
    }

    public final boolean isPSDEVIEWLOGICIDNull() {
        return this.isParamNull(TAG_PSDEVIEWLOGICID);
    }

    public final String getPSDEVIEWLOGICID() {
        return this.getParamStringValue(TAG_PSDEVIEWLOGICID, "");
    }

    public final void setPSDEVIEWLOGICID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWLOGICID, strValue);
    }

    public final boolean isPSDEVIEWLOGICNAMENull() {
        return this.isParamNull(TAG_PSDEVIEWLOGICNAME);
    }

    public final String getPSDEVIEWLOGICNAME() {
        return this.getParamStringValue(TAG_PSDEVIEWLOGICNAME, "");
    }

    public final void setPSDEVIEWLOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isVLEXECMODENull() {
        return this.isParamNull(TAG_VLEXECMODE);
    }

    public final String getVLEXECMODE() {
        return this.getParamStringValue(TAG_VLEXECMODE, "");
    }

    public final void setVLEXECMODE(String strValue) {
        this.setParamValue(TAG_VLEXECMODE, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.getParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.isParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.getParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.setParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.isParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.getParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isCMPSLANRESIDNull() {
        return this.isParamNull(TAG_CMPSLANRESID);
    }

    public final String getCMPSLANRESID() {
        return this.getParamStringValue(TAG_CMPSLANRESID, "");
    }

    public final void setCMPSLANRESID(String strValue) {
        this.setParamValue(TAG_CMPSLANRESID, strValue);
    }

    public final boolean isCMPSLANRESNAMENull() {
        return this.isParamNull(TAG_CMPSLANRESNAME);
    }

    public final String getCMPSLANRESNAME() {
        return this.getParamStringValue(TAG_CMPSLANRESNAME, "");
    }

    public final void setCMPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CMPSLANRESNAME, strValue);
    }

    public final boolean isSMPSLANRESIDNull() {
        return this.isParamNull(TAG_SMPSLANRESID);
    }

    public final String getSMPSLANRESID() {
        return this.getParamStringValue(TAG_SMPSLANRESID, "");
    }

    public final void setSMPSLANRESID(String strValue) {
        this.setParamValue(TAG_SMPSLANRESID, strValue);
    }

    public final boolean isSMPSLANRESNAMENull() {
        return this.isParamNull(TAG_SMPSLANRESNAME);
    }

    public final String getSMPSLANRESNAME() {
        return this.getParamStringValue(TAG_SMPSLANRESNAME, "");
    }

    public final void setSMPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_SMPSLANRESNAME, strValue);
    }

    public final boolean isNOPRIVDMNull() {
        return this.isParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.getParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.setParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isDATAITEMNull() {
        return this.isParamNull(TAG_DATAITEM);
    }

    public final String getDATAITEM() {
        return this.getParamStringValue(TAG_DATAITEM, "");
    }

    public final void setDATAITEM(String strValue) {
        this.setParamValue(TAG_DATAITEM, strValue);
    }

    public final boolean isTEXTITEMNull() {
        return this.isParamNull(TAG_TEXTITEM);
    }

    public final String getTEXTITEM() {
        return this.getParamStringValue(TAG_TEXTITEM, "");
    }

    public final void setTEXTITEM(String strValue) {
        this.setParamValue(TAG_TEXTITEM, strValue);
    }

    public final boolean isPARAMITEMNull() {
        return this.isParamNull(TAG_PARAMITEM);
    }

    public final String getPARAMITEM() {
        return this.getParamStringValue(TAG_PARAMITEM, "");
    }

    public final void setPARAMITEM(String strValue) {
        this.setParamValue(TAG_PARAMITEM, strValue);
    }

    public final boolean isGLOBALFLAGNull() {
        return this.isParamNull(TAG_GLOBALFLAG);
    }

    public final boolean getGLOBALFLAG() {
        return this.getParamIntValue(TAG_GLOBALFLAG, 0) == 1;
    }

    public final void setGLOBALFLAG(boolean bValue) {
        this.setParamValue(TAG_GLOBALFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLERTMODELNull() {
        return this.isParamNull(TAG_ENABLERTMODEL);
    }

    public final boolean getENABLERTMODEL() {
        return this.getParamIntValue(TAG_ENABLERTMODEL, 0) == 1;
    }

    public final void setENABLERTMODEL(boolean bValue) {
        this.setParamValue(TAG_ENABLERTMODEL, bValue ? 1 : 0);
    }

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isNEXTPSDEUIACTIONIDNull() {
        return this.isParamNull(TAG_NEXTPSDEUIACTIONID);
    }

    public final String getNEXTPSDEUIACTIONID() {
        return this.getParamStringValue(TAG_NEXTPSDEUIACTIONID, "");
    }

    public final void setNEXTPSDEUIACTIONID(String strValue) {
        this.setParamValue(TAG_NEXTPSDEUIACTIONID, strValue);
    }

    public final boolean isNEXTPSDEUIACTIONNAMENull() {
        return this.isParamNull(TAG_NEXTPSDEUIACTIONNAME);
    }

    public final String getNEXTPSDEUIACTIONNAME() {
        return this.getParamStringValue(TAG_NEXTPSDEUIACTIONNAME, "");
    }

    public final void setNEXTPSDEUIACTIONNAME(String strValue) {
        this.setParamValue(TAG_NEXTPSDEUIACTIONNAME, strValue);
    }

    public final boolean isPSSYSPDTVIEWIDNull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWID);
    }

    public final String getPSSYSPDTVIEWID() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWID, "");
    }

    public final void setPSSYSPDTVIEWID(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWID, strValue);
    }

    public final boolean isPSSYSPDTVIEWNAMENull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWNAME);
    }

    public final String getPSSYSPDTVIEWNAME() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWNAME, "");
    }

    public final void setPSSYSPDTVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWNAME, strValue);
    }

    public final boolean isPDTVIEWFLAGNull() {
        return this.isParamNull(TAG_PDTVIEWFLAG);
    }

    public final boolean getPDTVIEWFLAG() {
        return this.getParamIntValue(TAG_PDTVIEWFLAG, 0) == 1;
    }

    public final void setPDTVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_PDTVIEWFLAG, bValue ? 1 : 0);
    }
}

