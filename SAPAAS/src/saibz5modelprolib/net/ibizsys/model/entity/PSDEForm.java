/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isFORMTYPENull() {
        return this.isParamNull(TAG_FORMTYPE);
    }

    public final String getFORMTYPE() {
        return this.getParamStringValue(TAG_FORMTYPE, "");
    }

    public final void setFORMTYPE(String strValue) {
        this.setParamValue(TAG_FORMTYPE, strValue);
    }

    public final boolean isFORMMODELNull() {
        return this.isParamNull(TAG_FORMMODEL);
    }

    public final String getFORMMODEL() {
        return this.getParamStringValue(TAG_FORMMODEL, "");
    }

    public final void setFORMMODEL(String strValue) {
        this.setParamValue(TAG_FORMMODEL, strValue);
    }

    public final boolean isFORMWIDTHNull() {
        return this.isParamNull(TAG_FORMWIDTH);
    }

    public final int getFORMWIDTH() {
        return this.getParamIntValue(TAG_FORMWIDTH, 0);
    }

    public final void setFORMWIDTH(int nValue) {
        this.setParamValue(TAG_FORMWIDTH, nValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isFORMSNNull() {
        return this.isParamNull(TAG_FORMSN);
    }

    public final String getFORMSN() {
        return this.getParamStringValue(TAG_FORMSN, "");
    }

    public final void setFORMSN(String strValue) {
        this.setParamValue(TAG_FORMSN, strValue);
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

    public final boolean isLAYOUTMODENull() {
        return this.isParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.getParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.setParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isLABELCOLSPANNull() {
        return this.isParamNull(TAG_LABELCOLSPAN);
    }

    public final int getLABELCOLSPAN() {
        return this.getParamIntValue(TAG_LABELCOLSPAN, 0);
    }

    public final void setLABELCOLSPAN(int nValue) {
        this.setParamValue(TAG_LABELCOLSPAN, nValue);
    }

    public final boolean isCTRLCOLSPANNull() {
        return this.isParamNull(TAG_CTRLCOLSPAN);
    }

    public final int getCTRLCOLSPAN() {
        return this.getParamIntValue(TAG_CTRLCOLSPAN, 0);
    }

    public final void setCTRLCOLSPAN(int nValue) {
        this.setParamValue(TAG_CTRLCOLSPAN, nValue);
    }

    public final boolean isLABELCOLSPAN2Null() {
        return this.isParamNull(TAG_LABELCOLSPAN2);
    }

    public final int getLABELCOLSPAN2() {
        return this.getParamIntValue(TAG_LABELCOLSPAN2, 0);
    }

    public final void setLABELCOLSPAN2(int nValue) {
        this.setParamValue(TAG_LABELCOLSPAN2, nValue);
    }

    public final boolean isFUNCMODENull() {
        return this.isParamNull(TAG_FUNCMODE);
    }

    public final String getFUNCMODE() {
        return this.getParamStringValue(TAG_FUNCMODE, "");
    }

    public final void setFUNCMODE(String strValue) {
        this.setParamValue(TAG_FUNCMODE, strValue);
    }

    public final boolean isLABELWIDTHNull() {
        return this.isParamNull(TAG_LABELWIDTH);
    }

    public final int getLABELWIDTH() {
        return this.getParamIntValue(TAG_LABELWIDTH, 0);
    }

    public final void setLABELWIDTH(int nValue) {
        this.setParamValue(TAG_LABELWIDTH, nValue);
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

    public final boolean isENABLEADVSEARCHNull() {
        return this.isParamNull(TAG_ENABLEADVSEARCH);
    }

    public final boolean getENABLEADVSEARCH() {
        return this.getParamIntValue(TAG_ENABLEADVSEARCH, 0) == 1;
    }

    public final void setENABLEADVSEARCH(boolean bValue) {
        this.setParamValue(TAG_ENABLEADVSEARCH, bValue ? 1 : 0);
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

    public final boolean isSHOWTABHEADERNull() {
        return this.isParamNull(TAG_SHOWTABHEADER);
    }

    public final boolean getSHOWTABHEADER() {
        return this.getParamIntValue(TAG_SHOWTABHEADER, 0) == 1;
    }

    public final void setSHOWTABHEADER(boolean bValue) {
        this.setParamValue(TAG_SHOWTABHEADER, bValue ? 1 : 0);
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

    public final boolean isPSCTRLMSGIDNull() {
        return this.isParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.getParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.setParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.isParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.getParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.setParamValue(TAG_PSCTRLMSGNAME, strValue);
    }

    public final boolean isFORMNAVBARNull() {
        return this.isParamNull(TAG_FORMNAVBAR);
    }

    public final boolean getFORMNAVBAR() {
        return this.getParamIntValue(TAG_FORMNAVBAR, 0) == 1;
    }

    public final void setFORMNAVBAR(boolean bValue) {
        this.setParamValue(TAG_FORMNAVBAR, bValue ? 1 : 0);
    }

    public final boolean isFORMSTYLENull() {
        return this.isParamNull(TAG_FORMSTYLE);
    }

    public final String getFORMSTYLE() {
        return this.getParamStringValue(TAG_FORMSTYLE, "");
    }

    public final void setFORMSTYLE(String strValue) {
        this.setParamValue(TAG_FORMSTYLE, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.isParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.getParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.setParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isINFOFORMFLAGNull() {
        return this.isParamNull(TAG_INFOFORMFLAG);
    }

    public final boolean getINFOFORMFLAG() {
        return this.getParamIntValue(TAG_INFOFORMFLAG, 0) == 1;
    }

    public final void setINFOFORMFLAG(boolean bValue) {
        this.setParamValue(TAG_INFOFORMFLAG, bValue ? 1 : 0);
    }
}

