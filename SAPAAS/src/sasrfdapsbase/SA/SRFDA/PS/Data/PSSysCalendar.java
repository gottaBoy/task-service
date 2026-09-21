/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysCalendar
extends BaseDataEntity {
    public static final String CALENDARSTYLE_DAY = "DAY";
    public static final String CALENDARSTYLE_WEEK = "WEEK";
    public static final String CALENDARSTYLE_MONTH = "MONTH";
    public static final String CALENDARSTYLE_USER = "USER";
    public static final String CALENDARSTYLE_USER2 = "USER2";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String TAG_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CALENDARSTYLE = "CALENDARSTYLE";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_GANTTFLAG = "GANTTFLAG";
    public static final String TAG_GANTTSTYLE = "GANTTSTYLE";
    public static final String TAG_GANTTPSSYSPFPLUGINID = "GANTTPSSYSPFPLUGINID";
    public static final String TAG_GANTTPSSYSPFPLUGINNAME = "GANTTPSSYSPFPLUGINNAME";
    public static final String TAG_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String TAG_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String TAG_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String TAG_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String TAG_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String TAG_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String TAG_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String TAG_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String TAG_GROUPPSSYSCSSID = "GROUPPSSYSCSSID";
    public static final String TAG_GROUPPSSYSCSSNAME = "GROUPPSSYSCSSNAME";
    public static final String TAG_GROUPLAYOUT = "GROUPLAYOUT";
    public static final String TAG_GROUPMODE = "GROUPMODE";
    public static final String TAG_GROUPWIDTH = "GROUPWIDTH";
    public static final String TAG_GROUPHEIGHT = "GROUPHEIGHT";
    public static final String TAG_GROUPPSSYSPFPLUGINID = "GROUPPSSYSPFPLUGINID";
    public static final String TAG_GROUPPSSYSPFPLUGINNAME = "GROUPPSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String TAG_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_ENABLEEDIT = "ENABLEEDIT";
    public static final String TAG_NAVVIEWPOS = "NAVVIEWPOS";
    public static final String TAG_NAVVIEWSHOWMODE = "NAVVIEWSHOWMODE";
    public static final String TAG_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String TAG_NAVVIEWWIDTH = "NAVVIEWWIDTH";
    public static final String TAG_NAVVIEWMINWIDTH = "NAVVIEWMINWIDTH";
    public static final String TAG_NAVVIEWMAXWIDTH = "NAVVIEWMAXWIDTH";
    public static final String TAG_NAVVIEWMAXHEIGHT = "NAVVIEWMAXHEIGHT";
    public static final String TAG_NAVVIEWMINHEIGHT = "NAVVIEWMINHEIGHT";
    public static final String TAG_NAVVIEWHEIGHT = "NAVVIEWHEIGHT";
    public static final String TAG_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String TAG_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";

    public final boolean isPSSYSCALENDARIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARID, strValue);
    }

    public final boolean isPSSYSCALENDARNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARNAME);
    }

    public final String getPSSYSCALENDARNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARNAME, "");
    }

    public final void setPSSYSCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARNAME, strValue);
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

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.IsParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.GetParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXT, strValue);
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

    public final boolean isCALENDARSTYLENull() {
        return this.IsParamNull(TAG_CALENDARSTYLE);
    }

    public final String getCALENDARSTYLE() {
        return this.GetParamStringValue(TAG_CALENDARSTYLE, "");
    }

    public final void setCALENDARSTYLE(String strValue) {
        this.SetParamValue(TAG_CALENDARSTYLE, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
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

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
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

    public final boolean isGANTTFLAGNull() {
        return this.IsParamNull(TAG_GANTTFLAG);
    }

    public final boolean getGANTTFLAG() {
        return this.GetParamIntValue(TAG_GANTTFLAG, 0) == 1;
    }

    public final void setGANTTFLAG(boolean bValue) {
        this.SetParamValue(TAG_GANTTFLAG, bValue ? 1 : 0);
    }

    public final boolean isGANTTSTYLENull() {
        return this.IsParamNull(TAG_GANTTSTYLE);
    }

    public final String getGANTTSTYLE() {
        return this.GetParamStringValue(TAG_GANTTSTYLE, "");
    }

    public final void setGANTTSTYLE(String strValue) {
        this.SetParamValue(TAG_GANTTSTYLE, strValue);
    }

    public final boolean isGANTTPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GANTTPSSYSPFPLUGINID);
    }

    public final String getGANTTPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GANTTPSSYSPFPLUGINID, "");
    }

    public final void setGANTTPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GANTTPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGANTTPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GANTTPSSYSPFPLUGINNAME);
    }

    public final String getGANTTPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GANTTPSSYSPFPLUGINNAME, "");
    }

    public final void setGANTTPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GANTTPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isQUICKPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_QUICKPSDETOOLBARID);
    }

    public final String getQUICKPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_QUICKPSDETOOLBARID, "");
    }

    public final void setQUICKPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_QUICKPSDETOOLBARID, strValue);
    }

    public final boolean isQUICKPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_QUICKPSDETOOLBARNAME);
    }

    public final String getQUICKPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_QUICKPSDETOOLBARNAME, "");
    }

    public final void setQUICKPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_QUICKPSDETOOLBARNAME, strValue);
    }

    public final boolean isBATPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_BATPSDETOOLBARID);
    }

    public final String getBATPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_BATPSDETOOLBARID, "");
    }

    public final void setBATPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_BATPSDETOOLBARID, strValue);
    }

    public final boolean isBATPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_BATPSDETOOLBARNAME);
    }

    public final String getBATPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_BATPSDETOOLBARNAME, "");
    }

    public final void setBATPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_BATPSDETOOLBARNAME, strValue);
    }

    public final boolean isGROUPPSCODELISTIDNull() {
        return this.IsParamNull(TAG_GROUPPSCODELISTID);
    }

    public final String getGROUPPSCODELISTID() {
        return this.GetParamStringValue(TAG_GROUPPSCODELISTID, "");
    }

    public final void setGROUPPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_GROUPPSCODELISTID, strValue);
    }

    public final boolean isGROUPPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_GROUPPSCODELISTNAME);
    }

    public final String getGROUPPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_GROUPPSCODELISTNAME, "");
    }

    public final void setGROUPPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSCODELISTNAME, strValue);
    }

    public final boolean isGROUPPSDEFIDNull() {
        return this.IsParamNull(TAG_GROUPPSDEFID);
    }

    public final String getGROUPPSDEFID() {
        return this.GetParamStringValue(TAG_GROUPPSDEFID, "");
    }

    public final void setGROUPPSDEFID(String strValue) {
        this.SetParamValue(TAG_GROUPPSDEFID, strValue);
    }

    public final boolean isGROUPPSDEFNAMENull() {
        return this.IsParamNull(TAG_GROUPPSDEFNAME);
    }

    public final String getGROUPPSDEFNAME() {
        return this.GetParamStringValue(TAG_GROUPPSDEFNAME, "");
    }

    public final void setGROUPPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSDEFNAME, strValue);
    }

    public final boolean isGROUPPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_GROUPPSSYSCSSID);
    }

    public final String getGROUPPSSYSCSSID() {
        return this.GetParamStringValue(TAG_GROUPPSSYSCSSID, "");
    }

    public final void setGROUPPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_GROUPPSSYSCSSID, strValue);
    }

    public final boolean isGROUPPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_GROUPPSSYSCSSNAME);
    }

    public final String getGROUPPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_GROUPPSSYSCSSNAME, "");
    }

    public final void setGROUPPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSSYSCSSNAME, strValue);
    }

    public final boolean isGROUPLAYOUTNull() {
        return this.IsParamNull(TAG_GROUPLAYOUT);
    }

    public final String getGROUPLAYOUT() {
        return this.GetParamStringValue(TAG_GROUPLAYOUT, "");
    }

    public final void setGROUPLAYOUT(String strValue) {
        this.SetParamValue(TAG_GROUPLAYOUT, strValue);
    }

    public final boolean isGROUPMODENull() {
        return this.IsParamNull(TAG_GROUPMODE);
    }

    public final String getGROUPMODE() {
        return this.GetParamStringValue(TAG_GROUPMODE, "");
    }

    public final void setGROUPMODE(String strValue) {
        this.SetParamValue(TAG_GROUPMODE, strValue);
    }

    public final boolean isGROUPWIDTHNull() {
        return this.IsParamNull(TAG_GROUPWIDTH);
    }

    public final int getGROUPWIDTH() {
        return this.GetParamIntValue(TAG_GROUPWIDTH, 0);
    }

    public final void setGROUPWIDTH(int nValue) {
        this.SetParamValue(TAG_GROUPWIDTH, nValue);
    }

    public final boolean isGROUPHEIGHTNull() {
        return this.IsParamNull(TAG_GROUPHEIGHT);
    }

    public final int getGROUPHEIGHT() {
        return this.GetParamIntValue(TAG_GROUPHEIGHT, 0);
    }

    public final void setGROUPHEIGHT(int nValue) {
        this.SetParamValue(TAG_GROUPHEIGHT, nValue);
    }

    public final boolean isGROUPPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GROUPPSSYSPFPLUGINID);
    }

    public final String getGROUPPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GROUPPSSYSPFPLUGINID, "");
    }

    public final void setGROUPPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GROUPPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGROUPPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GROUPPSSYSPFPLUGINNAME);
    }

    public final String getGROUPPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GROUPPSSYSPFPLUGINNAME, "");
    }

    public final void setGROUPPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSSYSPFPLUGINNAME, strValue);
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

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVID);
    }

    public final String getUPDATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVID, "");
    }

    public final void setUPDATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVID, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVNAME);
    }

    public final String getUPDATEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVNAME, "");
    }

    public final void setUPDATEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVNAME, strValue);
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

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isENABLEEDITNull() {
        return this.IsParamNull(TAG_ENABLEEDIT);
    }

    public final boolean getENABLEEDIT() {
        return this.GetParamIntValue(TAG_ENABLEEDIT, 0) == 1;
    }

    public final void setENABLEEDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEEDIT, bValue ? 1 : 0);
    }

    public final boolean isNAVVIEWPOSNull() {
        return this.IsParamNull(TAG_NAVVIEWPOS);
    }

    public final String getNAVVIEWPOS() {
        return this.GetParamStringValue(TAG_NAVVIEWPOS, "");
    }

    public final void setNAVVIEWPOS(String strValue) {
        this.SetParamValue(TAG_NAVVIEWPOS, strValue);
    }

    public final boolean isNAVVIEWSHOWMODENull() {
        return this.IsParamNull(TAG_NAVVIEWSHOWMODE);
    }

    public final int getNAVVIEWSHOWMODE() {
        return this.GetParamIntValue(TAG_NAVVIEWSHOWMODE, 0);
    }

    public final void setNAVVIEWSHOWMODE(int nValue) {
        this.SetParamValue(TAG_NAVVIEWSHOWMODE, nValue);
    }

    public final boolean isNAVVIEWPARAMNull() {
        return this.IsParamNull(TAG_NAVVIEWPARAM);
    }

    public final String getNAVVIEWPARAM() {
        return this.GetParamStringValue(TAG_NAVVIEWPARAM, "");
    }

    public final void setNAVVIEWPARAM(String strValue) {
        this.SetParamValue(TAG_NAVVIEWPARAM, strValue);
    }

    public final boolean isNAVVIEWWIDTHNull() {
        return this.IsParamNull(TAG_NAVVIEWWIDTH);
    }

    public final float getNAVVIEWWIDTH() {
        return this.GetParamFloatValue(TAG_NAVVIEWWIDTH, 0.0f);
    }

    public final void setNAVVIEWWIDTH(float fValue) {
        this.SetParamValue(TAG_NAVVIEWWIDTH, Float.valueOf(fValue));
    }

    public final boolean isNAVVIEWMINWIDTHNull() {
        return this.IsParamNull(TAG_NAVVIEWMINWIDTH);
    }

    public final float getNAVVIEWMINWIDTH() {
        return this.GetParamFloatValue(TAG_NAVVIEWMINWIDTH, 0.0f);
    }

    public final void setNAVVIEWMINWIDTH(float fValue) {
        this.SetParamValue(TAG_NAVVIEWMINWIDTH, Float.valueOf(fValue));
    }

    public final boolean isNAVVIEWMAXWIDTHNull() {
        return this.IsParamNull(TAG_NAVVIEWMAXWIDTH);
    }

    public final float getNAVVIEWMAXWIDTH() {
        return this.GetParamFloatValue(TAG_NAVVIEWMAXWIDTH, 0.0f);
    }

    public final void setNAVVIEWMAXWIDTH(float fValue) {
        this.SetParamValue(TAG_NAVVIEWMAXWIDTH, Float.valueOf(fValue));
    }

    public final boolean isNAVVIEWMAXHEIGHTNull() {
        return this.IsParamNull(TAG_NAVVIEWMAXHEIGHT);
    }

    public final float getNAVVIEWMAXHEIGHT() {
        return this.GetParamFloatValue(TAG_NAVVIEWMAXHEIGHT, 0.0f);
    }

    public final void setNAVVIEWMAXHEIGHT(float fValue) {
        this.SetParamValue(TAG_NAVVIEWMAXHEIGHT, Float.valueOf(fValue));
    }

    public final boolean isNAVVIEWMINHEIGHTNull() {
        return this.IsParamNull(TAG_NAVVIEWMINHEIGHT);
    }

    public final float getNAVVIEWMINHEIGHT() {
        return this.GetParamFloatValue(TAG_NAVVIEWMINHEIGHT, 0.0f);
    }

    public final void setNAVVIEWMINHEIGHT(float fValue) {
        this.SetParamValue(TAG_NAVVIEWMINHEIGHT, Float.valueOf(fValue));
    }

    public final boolean isNAVVIEWHEIGHTNull() {
        return this.IsParamNull(TAG_NAVVIEWHEIGHT);
    }

    public final float getNAVVIEWHEIGHT() {
        return this.GetParamFloatValue(TAG_NAVVIEWHEIGHT, 0.0f);
    }

    public final void setNAVVIEWHEIGHT(float fValue) {
        this.SetParamValue(TAG_NAVVIEWHEIGHT, Float.valueOf(fValue));
    }

    public final boolean isGROUPTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_GROUPTEXTPSDEFID);
    }

    public final String getGROUPTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_GROUPTEXTPSDEFID, "");
    }

    public final void setGROUPTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_GROUPTEXTPSDEFID, strValue);
    }

    public final boolean isGROUPTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_GROUPTEXTPSDEFNAME);
    }

    public final String getGROUPTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_GROUPTEXTPSDEFNAME, "");
    }

    public final void setGROUPTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_GROUPTEXTPSDEFNAME, strValue);
    }
}

