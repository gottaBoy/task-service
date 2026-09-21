/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEForm
extends BaseDataEntity {
    public static final String FORMTYPE_EDITFORM = "EDITFORM";
    public static final String FORMTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String FUNCMODE_WFACTION = "WFACTION";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FORMTYPE = "FORMTYPE";
    public static final String TAG_FORMMODEL = "FORMMODEL";
    public static final String TAG_FORMWIDTH = "FORMWIDTH";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_FORMSN = "FORMSN";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_LABELCOLSPAN = "LABELCOLSPAN";
    public static final String TAG_CTRLCOLSPAN = "CTRLCOLSPAN";
    public static final String TAG_LABELCOLSPAN2 = "LABELCOLSPAN2";
    public static final String TAG_FUNCMODE = "FUNCMODE";
    public static final String TAG_LABELWIDTH = "LABELWIDTH";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_ENABLEADVSEARCH = "ENABLEADVSEARCH";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_SHOWTABHEADER = "SHOWTABHEADER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_FORMNAVBAR = "FORMNAVBAR";
    public static final String TAG_FORMSTYLE = "FORMSTYLE";
    public static final String TAG_PDVTPARAM = "PDVTPARAM";
    public static final String TAG_INFOFORMFLAG = "INFOFORMFLAG";
    public static final String TAG_DETAILSTYLE = "DETAILSTYLE";
    public static final String TAG_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_SEARCHBTNSTYLE = "SEARCHBTNSTYLE";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_TABHEADERPOS = "TABHEADERPOS";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String TAG_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String TAG_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String TAG_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String TAG_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String TAG_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String TAG_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String TAG_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String TAG_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String TAG_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String TAG_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String TAG_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String TAG_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_SEARCHBTNPOS = "SEARCHBTNPOS";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_ENABLEAUTOSAVE = "ENABLEAUTOSAVE";
    public static final String TAG_ENABLEFILTERSAVE = "ENABLEFILTERSAVE";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_NAVBARPOS = "NAVBARPOS";
    public static final String TAG_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String TAG_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String TAG_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String TAG_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String TAG_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String TAG_ENABLEITEMFILTER = "ENABLEITEMFILTER";
    public static final String TAG_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String TAG_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
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

    public final boolean isFORMTYPENull() {
        return this.IsParamNull(TAG_FORMTYPE);
    }

    public final String getFORMTYPE() {
        return this.GetParamStringValue(TAG_FORMTYPE, "");
    }

    public final void setFORMTYPE(String strValue) {
        this.SetParamValue(TAG_FORMTYPE, strValue);
    }

    public final boolean isFORMMODELNull() {
        return this.IsParamNull(TAG_FORMMODEL);
    }

    public final String getFORMMODEL() {
        return this.GetParamStringValue(TAG_FORMMODEL, "");
    }

    public final void setFORMMODEL(String strValue) {
        this.SetParamValue(TAG_FORMMODEL, strValue);
    }

    public final boolean isFORMWIDTHNull() {
        return this.IsParamNull(TAG_FORMWIDTH);
    }

    public final int getFORMWIDTH() {
        return this.GetParamIntValue(TAG_FORMWIDTH, 0);
    }

    public final void setFORMWIDTH(int nValue) {
        this.SetParamValue(TAG_FORMWIDTH, nValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERNAME, strValue);
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

    public final boolean isFORMSNNull() {
        return this.IsParamNull(TAG_FORMSN);
    }

    public final String getFORMSN() {
        return this.GetParamStringValue(TAG_FORMSN, "");
    }

    public final void setFORMSN(String strValue) {
        this.SetParamValue(TAG_FORMSN, strValue);
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

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isLABELCOLSPANNull() {
        return this.IsParamNull(TAG_LABELCOLSPAN);
    }

    public final int getLABELCOLSPAN() {
        return this.GetParamIntValue(TAG_LABELCOLSPAN, 0);
    }

    public final void setLABELCOLSPAN(int nValue) {
        this.SetParamValue(TAG_LABELCOLSPAN, nValue);
    }

    public final boolean isCTRLCOLSPANNull() {
        return this.IsParamNull(TAG_CTRLCOLSPAN);
    }

    public final int getCTRLCOLSPAN() {
        return this.GetParamIntValue(TAG_CTRLCOLSPAN, 0);
    }

    public final void setCTRLCOLSPAN(int nValue) {
        this.SetParamValue(TAG_CTRLCOLSPAN, nValue);
    }

    public final boolean isLABELCOLSPAN2Null() {
        return this.IsParamNull(TAG_LABELCOLSPAN2);
    }

    public final int getLABELCOLSPAN2() {
        return this.GetParamIntValue(TAG_LABELCOLSPAN2, 0);
    }

    public final void setLABELCOLSPAN2(int nValue) {
        this.SetParamValue(TAG_LABELCOLSPAN2, nValue);
    }

    public final boolean isFUNCMODENull() {
        return this.IsParamNull(TAG_FUNCMODE);
    }

    public final String getFUNCMODE() {
        return this.GetParamStringValue(TAG_FUNCMODE, "");
    }

    public final void setFUNCMODE(String strValue) {
        this.SetParamValue(TAG_FUNCMODE, strValue);
    }

    public final boolean isLABELWIDTHNull() {
        return this.IsParamNull(TAG_LABELWIDTH);
    }

    public final int getLABELWIDTH() {
        return this.GetParamIntValue(TAG_LABELWIDTH, 0);
    }

    public final void setLABELWIDTH(int nValue) {
        this.SetParamValue(TAG_LABELWIDTH, nValue);
    }

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isENABLEADVSEARCHNull() {
        return this.IsParamNull(TAG_ENABLEADVSEARCH);
    }

    public final boolean getENABLEADVSEARCH() {
        return this.GetParamIntValue(TAG_ENABLEADVSEARCH, 0) == 1;
    }

    public final void setENABLEADVSEARCH(boolean bValue) {
        this.SetParamValue(TAG_ENABLEADVSEARCH, bValue ? 1 : 0);
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

    public final boolean isSHOWTABHEADERNull() {
        return this.IsParamNull(TAG_SHOWTABHEADER);
    }

    public final boolean getSHOWTABHEADER() {
        return this.GetParamIntValue(TAG_SHOWTABHEADER, 0) == 1;
    }

    public final void setSHOWTABHEADER(boolean bValue) {
        this.SetParamValue(TAG_SHOWTABHEADER, bValue ? 1 : 0);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSCTRLMSGIDNull() {
        return this.IsParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.GetParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.IsParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.GetParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGNAME, strValue);
    }

    public final boolean isFORMNAVBARNull() {
        return this.IsParamNull(TAG_FORMNAVBAR);
    }

    public final boolean getFORMNAVBAR() {
        return this.GetParamIntValue(TAG_FORMNAVBAR, 0) == 1;
    }

    public final void setFORMNAVBAR(boolean bValue) {
        this.SetParamValue(TAG_FORMNAVBAR, bValue ? 1 : 0);
    }

    public final boolean isFORMSTYLENull() {
        return this.IsParamNull(TAG_FORMSTYLE);
    }

    public final String getFORMSTYLE() {
        return this.GetParamStringValue(TAG_FORMSTYLE, "");
    }

    public final void setFORMSTYLE(String strValue) {
        this.SetParamValue(TAG_FORMSTYLE, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.IsParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.GetParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.SetParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isINFOFORMFLAGNull() {
        return this.IsParamNull(TAG_INFOFORMFLAG);
    }

    public final int getINFOFORMFLAG() {
        return this.GetParamIntValue(TAG_INFOFORMFLAG, 0);
    }

    public final void setINFOFORMFLAG(int nValue) {
        this.SetParamValue(TAG_INFOFORMFLAG, nValue);
    }

    public final boolean isDETAILSTYLENull() {
        return this.IsParamNull(TAG_DETAILSTYLE);
    }

    public final String getDETAILSTYLE() {
        return this.GetParamStringValue(TAG_DETAILSTYLE, "");
    }

    public final void setDETAILSTYLE(String strValue) {
        this.SetParamValue(TAG_DETAILSTYLE, strValue);
    }

    public final boolean isFORMITEMSTYLENull() {
        return this.IsParamNull(TAG_FORMITEMSTYLE);
    }

    public final String getFORMITEMSTYLE() {
        return this.GetParamStringValue(TAG_FORMITEMSTYLE, "");
    }

    public final void setFORMITEMSTYLE(String strValue) {
        this.SetParamValue(TAG_FORMITEMSTYLE, strValue);
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

    public final boolean isSEARCHBTNSTYLENull() {
        return this.IsParamNull(TAG_SEARCHBTNSTYLE);
    }

    public final String getSEARCHBTNSTYLE() {
        return this.GetParamStringValue(TAG_SEARCHBTNSTYLE, "");
    }

    public final void setSEARCHBTNSTYLE(String strValue) {
        this.SetParamValue(TAG_SEARCHBTNSTYLE, strValue);
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

    public final boolean isTABHEADERPOSNull() {
        return this.IsParamNull(TAG_TABHEADERPOS);
    }

    public final String getTABHEADERPOS() {
        return this.GetParamStringValue(TAG_TABHEADERPOS, "");
    }

    public final void setTABHEADERPOS(String strValue) {
        this.SetParamValue(TAG_TABHEADERPOS, strValue);
    }

    public final boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public final String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public final void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public final boolean isCOPYPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_COPYPSDEACTIONID);
    }

    public final String getCOPYPSDEACTIONID() {
        return this.GetParamStringValue(TAG_COPYPSDEACTIONID, "");
    }

    public final void setCOPYPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_COPYPSDEACTIONID, strValue);
    }

    public final boolean isCOPYPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_COPYPSDEACTIONNAME);
    }

    public final String getCOPYPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_COPYPSDEACTIONNAME, "");
    }

    public final void setCOPYPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_COPYPSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONID);
    }

    public final String getCREATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONID, "");
    }

    public final void setCREATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONID, strValue);
    }

    public final boolean isCREATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONNAME);
    }

    public final String getCREATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONNAME, "");
    }

    public final void setCREATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONNAME, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETDRAFTPSDEACTIONID);
    }

    public final String getGETDRAFTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETDRAFTPSDEACTIONID, "");
    }

    public final void setGETDRAFTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETDRAFTPSDEACTIONID, strValue);
    }

    public final boolean isGETDRAFTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETDRAFTPSDEACTIONNAME);
    }

    public final String getGETDRAFTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETDRAFTPSDEACTIONNAME, "");
    }

    public final void setGETDRAFTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETDRAFTPSDEACTIONNAME, strValue);
    }

    public final boolean isGETPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETPSDEACTIONID);
    }

    public final String getGETPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONID, "");
    }

    public final void setGETPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONID, strValue);
    }

    public final boolean isGETPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETPSDEACTIONNAME);
    }

    public final String getGETPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONNAME, "");
    }

    public final void setGETPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONNAME, strValue);
    }

    public final boolean isREMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONID);
    }

    public final String getREMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONID, "");
    }

    public final void setREMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONID, strValue);
    }

    public final boolean isREMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONNAME);
    }

    public final String getREMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONNAME, "");
    }

    public final void setREMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isUPDATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONID);
    }

    public final String getUPDATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONID, "");
    }

    public final void setUPDATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONID, strValue);
    }

    public final boolean isUPDATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONNAME);
    }

    public final String getUPDATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONNAME, "");
    }

    public final void setUPDATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONNAME, strValue);
    }

    public final boolean isUSER2PSDEACTIONIDNull() {
        return this.IsParamNull(TAG_USER2PSDEACTIONID);
    }

    public final String getUSER2PSDEACTIONID() {
        return this.GetParamStringValue(TAG_USER2PSDEACTIONID, "");
    }

    public final void setUSER2PSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_USER2PSDEACTIONID, strValue);
    }

    public final boolean isUSER2PSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_USER2PSDEACTIONNAME);
    }

    public final String getUSER2PSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_USER2PSDEACTIONNAME, "");
    }

    public final void setUSER2PSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_USER2PSDEACTIONNAME, strValue);
    }

    public final boolean isUSERPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_USERPSDEACTIONID);
    }

    public final String getUSERPSDEACTIONID() {
        return this.GetParamStringValue(TAG_USERPSDEACTIONID, "");
    }

    public final void setUSERPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_USERPSDEACTIONID, strValue);
    }

    public final boolean isUSERPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_USERPSDEACTIONNAME);
    }

    public final String getUSERPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_USERPSDEACTIONNAME, "");
    }

    public final void setUSERPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_USERPSDEACTIONNAME, strValue);
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
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

    public final boolean isSEARCHBTNPOSNull() {
        return this.IsParamNull(TAG_SEARCHBTNPOS);
    }

    public final String getSEARCHBTNPOS() {
        return this.GetParamStringValue(TAG_SEARCHBTNPOS, "");
    }

    public final void setSEARCHBTNPOS(String strValue) {
        this.SetParamValue(TAG_SEARCHBTNPOS, strValue);
    }

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isENABLEAUTOSAVENull() {
        return this.IsParamNull(TAG_ENABLEAUTOSAVE);
    }

    public final int getENABLEAUTOSAVE() {
        return this.GetParamIntValue(TAG_ENABLEAUTOSAVE, 0);
    }

    public final void setENABLEAUTOSAVE(int bValue) {
        this.SetParamValue(TAG_ENABLEAUTOSAVE, bValue);
    }

    public final boolean isENABLEFILTERSAVENull() {
        return this.IsParamNull(TAG_ENABLEFILTERSAVE);
    }

    public final boolean getENABLEFILTERSAVE() {
        return this.GetParamIntValue(TAG_ENABLEFILTERSAVE, 0) == 1;
    }

    public final void setENABLEFILTERSAVE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFILTERSAVE, bValue ? 1 : 0);
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

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final boolean getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0) == 1;
    }

    public final void setENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue ? 1 : 0);
    }

    public final boolean isNAVBARPOSNull() {
        return this.IsParamNull(TAG_NAVBARPOS);
    }

    public final String getNAVBARPOS() {
        return this.GetParamStringValue(TAG_NAVBARPOS, "");
    }

    public final void setNAVBARPOS(String strValue) {
        this.SetParamValue(TAG_NAVBARPOS, strValue);
    }

    public final boolean isNAVBARSTYLENull() {
        return this.IsParamNull(TAG_NAVBARSTYLE);
    }

    public final String getNAVBARSTYLE() {
        return this.GetParamStringValue(TAG_NAVBARSTYLE, "");
    }

    public final void setNAVBARSTYLE(String strValue) {
        this.SetParamValue(TAG_NAVBARSTYLE, strValue);
    }

    public final boolean isNAVBARHEIGHTNull() {
        return this.IsParamNull(TAG_NAVBARHEIGHT);
    }

    public final int getNAVBARHEIGHT() {
        return this.GetParamIntValue(TAG_NAVBARHEIGHT, 0);
    }

    public final void setNAVBARHEIGHT(int nValue) {
        this.SetParamValue(TAG_NAVBARHEIGHT, nValue);
    }

    public final boolean isNAVBARWIDTHNull() {
        return this.IsParamNull(TAG_NAVBARWIDTH);
    }

    public final int getNAVBARWIDTH() {
        return this.GetParamIntValue(TAG_NAVBARWIDTH, 0);
    }

    public final void setNAVBARWIDTH(int nValue) {
        this.SetParamValue(TAG_NAVBARWIDTH, nValue);
    }

    public final boolean isNAVBARPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_NAVBARPSSYSCSSID);
    }

    public final String getNAVBARPSSYSCSSID() {
        return this.GetParamStringValue(TAG_NAVBARPSSYSCSSID, "");
    }

    public final void setNAVBARPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_NAVBARPSSYSCSSID, strValue);
    }

    public final boolean isNAVBARPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_NAVBARPSSYSCSSNAME);
    }

    public final String getNAVBARPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_NAVBARPSSYSCSSNAME, "");
    }

    public final void setNAVBARPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_NAVBARPSSYSCSSNAME, strValue);
    }

    public final boolean isENABLEITEMFILTERNull() {
        return this.IsParamNull(TAG_ENABLEITEMFILTER);
    }

    public final boolean getENABLEITEMFILTER() {
        return this.GetParamIntValue(TAG_ENABLEITEMFILTER, 0) == 1;
    }

    public final void setENABLEITEMFILTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMFILTER, bValue ? 1 : 0);
    }

    public final boolean isPSDEFINPUTTIPSETIDNull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPSETID);
    }

    public final String getPSDEFINPUTTIPSETID() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPSETID, "");
    }

    public final void setPSDEFINPUTTIPSETID(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPSETID, strValue);
    }

    public final boolean isPSDEFINPUTTIPSETNAMENull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPSETNAME);
    }

    public final String getPSDEFINPUTTIPSETNAME() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPSETNAME, "");
    }

    public final void setPSDEFINPUTTIPSETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPSETNAME, strValue);
    }
}

