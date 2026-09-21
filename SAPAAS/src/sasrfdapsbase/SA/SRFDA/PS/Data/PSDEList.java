/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEList
extends BaseDataEntity {
    public static final String MOBLISTSTYLE_ICONVIEW = "ICONVIEW";
    public static final String MOBLISTSTYLE_LISTVIEW = "LISTVIEW";
    public static final String MOBLISTSTYLE_SWIPERVIEW = "SWIPERVIEW";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SHOWHEADER = "SHOWHEADER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_APPENDDEITEMS = "APPENDDEITEMS";
    public static final String TAG_MOBLISTSTYLE = "MOBLISTSTYLE";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_ITEMPSSYSPFPLUGINID = "ITEMPSSYSPFPLUGINID";
    public static final String TAG_ITEMPSSYSPFPLUGINNAME = "ITEMPSSYSPFPLUGINNAME";
    public static final String TAG_GROUPLAYOUT = "GROUPLAYOUT";
    public static final String TAG_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String TAG_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String TAG_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String TAG_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String TAG_GROUPMODE = "GROUPMODE";
    public static final String TAG_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String TAG_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String TAG_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String TAG_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String TAG_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String TAG_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String TAG_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_MULTISELECT = "MULTISELECT";
    public static final String TAG_ENABLEEDIT = "ENABLEEDIT";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String TAG_GROUPBARCLOSEMODE = "GROUPBARCLOSEMODE";
    public static final String TAG_SWIMLANEPSCODELISTID = "SWIMLANEPSCODELISTID";
    public static final String TAG_SWIMLANEPSCODELISTNAME = "SWIMLANEPSCODELISTNAME";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_USERPSDEACTIONID = "USERPSDEACTIONID";
    public static final String TAG_USERPSDEACTIONNAME = "USERPSDEACTIONNAME";
    public static final String TAG_USER2PSDEACTIONID = "USER2PSDEACTIONID";
    public static final String TAG_USER2PSDEACTIONNAME = "USER2PSDEACTIONNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String TAG_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String TAG_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String TAG_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String TAG_GETDRAFTPSDEACTIONID = "GETDRAFTPSDEACTIONID";
    public static final String TAG_GETDRAFTPSDEACTIONNAME = "GETDRAFTPSDEACTIONNAME";
    public static final String TAG_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String TAG_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String TAG_COPYPSDEACTIONID = "COPYPSDEACTIONID";
    public static final String TAG_COPYPSDEACTIONNAME = "COPYPSDEACTIONNAME";
    public static final String TAG_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String TAG_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String TAG_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String TAG_GROUPPSSYSPFPLUGINID = "GROUPPSSYSPFPLUGINID";
    public static final String TAG_GROUPPSSYSPFPLUGINNAME = "GROUPPSSYSPFPLUGINNAME";
    public static final String TAG_GROUPPSSYSCSSID = "GROUPPSSYSCSSID";
    public static final String TAG_GROUPPSSYSCSSNAME = "GROUPPSSYSCSSNAME";
    public static final String TAG_GROUPPSDEUAGROUPID = "GROUPPSDEUAGROUPID";
    public static final String TAG_GROUPPSDEUAGROUPNAME = "GROUPPSDEUAGROUPNAME";
    public static final String TAG_GROUPSTYLE = "GROUPSTYLE";
    public static final String TAG_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String TAG_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String TAG_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String TAG_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";
    public static final String TAG_SWIMLANEPSDEFID = "SWIMLANEPSDEFID";
    public static final String TAG_SWIMLANEPSDEFNAME = "SWIMLANEPSDEFNAME";

    public final boolean isPSDELISTIDNull() {
        return this.IsParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.GetParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.SetParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.IsParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.GetParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSDELISTNAME, strValue);
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

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
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

    public final boolean isSHOWHEADERNull() {
        return this.IsParamNull(TAG_SHOWHEADER);
    }

    public final boolean getSHOWHEADER() {
        return this.GetParamIntValue(TAG_SHOWHEADER, 0) == 1;
    }

    public final void setSHOWHEADER(boolean bValue) {
        this.SetParamValue(TAG_SHOWHEADER, bValue ? 1 : 0);
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

    public final boolean isPAGESIZENull() {
        return this.IsParamNull(TAG_PAGESIZE);
    }

    public final int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public final void setPAGESIZE(int nValue) {
        this.SetParamValue(TAG_PAGESIZE, nValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.IsParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.GetParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isNOSORTNull() {
        return this.IsParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isAPPENDDEITEMSNull() {
        return this.IsParamNull(TAG_APPENDDEITEMS);
    }

    public final boolean getAPPENDDEITEMS() {
        return this.GetParamIntValue(TAG_APPENDDEITEMS, 0) == 1;
    }

    public final void setAPPENDDEITEMS(boolean bValue) {
        this.SetParamValue(TAG_APPENDDEITEMS, bValue ? 1 : 0);
    }

    public final boolean isMOBLISTSTYLENull() {
        return this.IsParamNull(TAG_MOBLISTSTYLE);
    }

    public final String getMOBLISTSTYLE() {
        return this.GetParamStringValue(TAG_MOBLISTSTYLE, "");
    }

    public final void setMOBLISTSTYLE(String strValue) {
        this.SetParamValue(TAG_MOBLISTSTYLE, strValue);
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

    public final boolean isADPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.GetParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isITEMPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_ITEMPSSYSPFPLUGINID);
    }

    public final String getITEMPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_ITEMPSSYSPFPLUGINID, "");
    }

    public final void setITEMPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_ITEMPSSYSPFPLUGINID, strValue);
    }

    public final boolean isITEMPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_ITEMPSSYSPFPLUGINNAME);
    }

    public final String getITEMPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_ITEMPSSYSPFPLUGINNAME, "");
    }

    public final void setITEMPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_ITEMPSSYSPFPLUGINNAME, strValue);
    }

    public final String getGROUPLAYOUT() {
        return this.GetParamStringValue(TAG_GROUPLAYOUT, "");
    }

    public final void setGROUPLAYOUT(String strValue) {
        this.SetParamValue(TAG_GROUPLAYOUT, strValue);
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

    public final boolean isGROUPMODENull() {
        return this.IsParamNull(TAG_GROUPMODE);
    }

    public final String getGROUPMODE() {
        return this.GetParamStringValue(TAG_GROUPMODE, "");
    }

    public final void setGROUPMODE(String strValue) {
        this.SetParamValue(TAG_GROUPMODE, strValue);
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

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO2PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPID);
    }

    public final String getNO2PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPID, "");
    }

    public final void setNO2PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPID, strValue);
    }

    public final boolean isNO2PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPNAME);
    }

    public final String getNO2PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPNAME, "");
    }

    public final void setNO2PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPNAME, strValue);
    }

    public final boolean isORDERVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFID);
    }

    public final String getORDERVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFID, "");
    }

    public final void setORDERVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFID, strValue);
    }

    public final boolean isORDERVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFNAME);
    }

    public final String getORDERVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFNAME, "");
    }

    public final void setORDERVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFNAME, strValue);
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

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isMULTISELECTNull() {
        return this.IsParamNull(TAG_MULTISELECT);
    }

    public final boolean getMULTISELECT() {
        return this.GetParamIntValue(TAG_MULTISELECT, 0) == 1;
    }

    public final void setMULTISELECT(boolean bValue) {
        this.SetParamValue(TAG_MULTISELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLEEDITNull() {
        return this.IsParamNull(TAG_ENABLEEDIT);
    }

    public final int getENABLEEDIT() {
        return this.GetParamIntValue(TAG_ENABLEEDIT, 0);
    }

    public final void setENABLEEDIT(int nValue) {
        this.SetParamValue(TAG_ENABLEEDIT, nValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.IsParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.GetParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isENABLEPAGINGBARNull() {
        return this.IsParamNull(TAG_ENABLEPAGINGBAR);
    }

    public final int getENABLEPAGINGBAR() {
        return this.GetParamIntValue(TAG_ENABLEPAGINGBAR, 0);
    }

    public final void setENABLEPAGINGBAR(int bValue) {
        this.SetParamValue(TAG_ENABLEPAGINGBAR, bValue);
    }

    public final boolean isGROUPBARCLOSEMODENull() {
        return this.IsParamNull(TAG_GROUPBARCLOSEMODE);
    }

    public final int getGROUPBARCLOSEMODE() {
        return this.GetParamIntValue(TAG_GROUPBARCLOSEMODE, 0);
    }

    public final void setGROUPBARCLOSEMODE(int nValue) {
        this.SetParamValue(TAG_GROUPBARCLOSEMODE, nValue);
    }

    public final boolean isSWIMLANEPSCODELISTIDNull() {
        return this.IsParamNull(TAG_SWIMLANEPSCODELISTID);
    }

    public final String getSWIMLANEPSCODELISTID() {
        return this.GetParamStringValue(TAG_SWIMLANEPSCODELISTID, "");
    }

    public final void setSWIMLANEPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_SWIMLANEPSCODELISTID, strValue);
    }

    public final boolean isSWIMLANEPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_SWIMLANEPSCODELISTNAME);
    }

    public final String getSWIMLANEPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_SWIMLANEPSCODELISTNAME, "");
    }

    public final void setSWIMLANEPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_SWIMLANEPSCODELISTNAME, strValue);
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

    public final boolean isMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_MOVEPSDEACTIONID);
    }

    public final String getMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_MOVEPSDEACTIONID, "");
    }

    public final void setMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEACTIONID, strValue);
    }

    public final boolean isMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_MOVEPSDEACTIONNAME);
    }

    public final String getMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_MOVEPSDEACTIONNAME, "");
    }

    public final void setMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isCUSTOMTYPENull() {
        return this.IsParamNull(TAG_CUSTOMTYPE);
    }

    public final String getCUSTOMTYPE() {
        return this.GetParamStringValue(TAG_CUSTOMTYPE, "");
    }

    public final void setCUSTOMTYPE(String strValue) {
        this.SetParamValue(TAG_CUSTOMTYPE, strValue);
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

    public final boolean isGROUPPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_GROUPPSDEUAGROUPID);
    }

    public final String getGROUPPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_GROUPPSDEUAGROUPID, "");
    }

    public final void setGROUPPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_GROUPPSDEUAGROUPID, strValue);
    }

    public final boolean isGROUPPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_GROUPPSDEUAGROUPNAME);
    }

    public final String getGROUPPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_GROUPPSDEUAGROUPNAME, "");
    }

    public final void setGROUPPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSDEUAGROUPNAME, strValue);
    }

    public final boolean isGROUPSTYLENull() {
        return this.IsParamNull(TAG_GROUPSTYLE);
    }

    public final String getGROUPSTYLE() {
        return this.GetParamStringValue(TAG_GROUPSTYLE, "");
    }

    public final void setGROUPSTYLE(String strValue) {
        this.SetParamValue(TAG_GROUPSTYLE, strValue);
    }

    public final boolean isASYNCPSDEDSIDNull() {
        return this.IsParamNull(TAG_ASYNCPSDEDSID);
    }

    public final String getASYNCPSDEDSID() {
        return this.GetParamStringValue(TAG_ASYNCPSDEDSID, "");
    }

    public final void setASYNCPSDEDSID(String strValue) {
        this.SetParamValue(TAG_ASYNCPSDEDSID, strValue);
    }

    public final boolean isASYNCPSDEDSNAMENull() {
        return this.IsParamNull(TAG_ASYNCPSDEDSNAME);
    }

    public final String getASYNCPSDEDSNAME() {
        return this.GetParamStringValue(TAG_ASYNCPSDEDSNAME, "");
    }

    public final void setASYNCPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_ASYNCPSDEDSNAME, strValue);
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

    public final boolean isSWIMLANEPSDEFIDNull() {
        return this.IsParamNull(TAG_SWIMLANEPSDEFID);
    }

    public final String getSWIMLANEPSDEFID() {
        return this.GetParamStringValue(TAG_SWIMLANEPSDEFID, "");
    }

    public final void setSWIMLANEPSDEFID(String strValue) {
        this.SetParamValue(TAG_SWIMLANEPSDEFID, strValue);
    }

    public final boolean isSWIMLANEPSDEFNAMENull() {
        return this.IsParamNull(TAG_SWIMLANEPSDEFNAME);
    }

    public final String getSWIMLANEPSDEFNAME() {
        return this.GetParamStringValue(TAG_SWIMLANEPSDEFNAME, "");
    }

    public final void setSWIMLANEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SWIMLANEPSDEFNAME, strValue);
    }
}

