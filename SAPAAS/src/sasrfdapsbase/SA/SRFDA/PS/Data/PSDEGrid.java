/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEGrid
extends BaseDataEntity {
    public static final String GRIDSTYLE_TREEGRID = "TREEGRID";
    public static final String GRIDSTYLE_GROUPGRID = "GROUPGRID";
    public static final String GRIDSTYLE_LIST = "LIST";
    public static final String GRIDSTYLE_LIST_SORT = "LIST_SORT";
    public static final String MINORSORTDIR_ASC = "ASC";
    public static final String MINORSORTDIR_DESC = "DESC";
    public static final int IGNOREDSITEM_FKEY = 1;
    public static final int IGNOREDSITEM_DATAACCACTION = 1024;
    public static final String SORTMODE_REMOTE = "REMOTE";
    public static final String SORTMODE_LOCAL = "LOCAL";
    public static final String AGGMODE_NONE = "NONE";
    public static final String AGGMODE_CURPAGE = "CURPAGE";
    public static final String AGGMODE_ALL = "ALL";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String TAG_PAGINGSIZE = "PAGINGSIZE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_GRIDSN = "GRIDSN";
    public static final String TAG_FORCEFIT = "FORCEFIT";
    public static final String TAG_GRIDMODEL = "GRIDMODEL";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_GRIDSTYLE = "GRIDSTYLE";
    public static final String TAG_TREEPPSDEFID = "TREEPPSDEFID";
    public static final String TAG_TREEPPSDEFNAME = "TREEPPSDEFNAME";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_SHOWHEADER = "SHOWHEADER";
    public static final String TAG_SRFSYSPUB = "SRFSYSPUB";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_IGNOREDSITEM = "IGNOREDSITEM";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_BUFFERRENDERERMODE = "BUFFERRENDERERMODE";
    public static final String TAG_SORTMODE = "SORTMODE";
    public static final String TAG_AGGMODE = "AGGMODE";
    public static final String TAG_AGGPSDEID = "AGGPSDEID";
    public static final String TAG_AGGPSDENAME = "AGGPSDENAME";
    public static final String TAG_AGGPSDEACTIONID = "AGGPSDEACTIONID";
    public static final String TAG_AGGPSDEACTIONNAME = "AGGPSDEACTIONNAME";
    public static final String TAG_NAVPSDEVIEWBASEID = "NAVPSDEVIEWBASEID";
    public static final String TAG_NAVPSDEVIEWBASENAME = "NAVPSDEVIEWBASENAME";
    public static final String TAG_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String TAG_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String TAG_NAVPSDERID = "NAVPSDERID";
    public static final String TAG_NAVPSDERNAME = "NAVPSDERNAME";
    public static final String TAG_COLENABLELINK = "COLENABLELINK";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_ITEMPSSYSCSSID = "ITEMPSSYSCSSID";
    public static final String TAG_ITEMPSSYSCSSNAME = "ITEMPSSYSCSSNAME";
    public static final String TAG_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String TAG_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String TAG_QUICKPSDETOOLBARID = "QUICKPSDETOOLBARID";
    public static final String TAG_QUICKPSDETOOLBARNAME = "QUICKPSDETOOLBARNAME";
    public static final String TAG_BATPSDETOOLBARID = "BATPSDETOOLBARID";
    public static final String TAG_BATPSDETOOLBARNAME = "BATPSDETOOLBARNAME";
    public static final String TAG_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String TAG_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String TAG_GROUPPSDEFID = "GROUPPSDEFID";
    public static final String TAG_GROUPPSDEFNAME = "GROUPPSDEFNAME";
    public static final String TAG_GROUPMODE = "GROUPMODE";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
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
    public static final String TAG_AGGPSDEDSID = "AGGPSDEDSID";
    public static final String TAG_AGGPSDEDSNAME = "AGGPSDEDSNAME";
    public static final String TAG_AGGPSSYSVIEWPANELID = "AGGPSSYSVIEWPANELID";
    public static final String TAG_AGGPSSYSVIEWPANELNAME = "AGGPSSYSVIEWPANELNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_COLENABLEFILTER = "COLENABLEFILTER";
    public static final String TAG_FROZENLASTCOL = "FROZENLASTCOL";
    public static final String TAG_FROZENCOL = "FROZENCOL";
    public static final String TAG_ENABLEEDIT = "ENABLEEDIT";
    public static final String TAG_MULTISELECT = "MULTISELECT";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String TAG_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String TAG_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String TAG_GROUPSTYLE = "GROUPSTYLE";
    public static final String TAG_ASYNCPSDEDSID = "ASYNCPSDEDSID";
    public static final String TAG_ASYNCPSDEDSNAME = "ASYNCPSDEDSNAME";
    public static final String TAG_PSDEFINPUTTIPSETID = "PSDEFINPUTTIPSETID";
    public static final String TAG_PSDEFINPUTTIPSETNAME = "PSDEFINPUTTIPSETNAME";
    public static final String TAG_GROUPTEXTPSDEFID = "GROUPTEXTPSDEFID";
    public static final String TAG_GROUPTEXTPSDEFNAME = "GROUPTEXTPSDEFNAME";

    public final boolean isPSDEGRIDIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.GetParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDNAME, strValue);
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

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
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

    public final boolean isPAGINGSIZENull() {
        return this.IsParamNull(TAG_PAGINGSIZE);
    }

    public final int getPAGINGSIZE() {
        return this.GetParamIntValue(TAG_PAGINGSIZE, 0);
    }

    public final void setPAGINGSIZE(int nValue) {
        this.SetParamValue(TAG_PAGINGSIZE, nValue);
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

    public final boolean isGRIDSNNull() {
        return this.IsParamNull(TAG_GRIDSN);
    }

    public final String getGRIDSN() {
        return this.GetParamStringValue(TAG_GRIDSN, "");
    }

    public final void setGRIDSN(String strValue) {
        this.SetParamValue(TAG_GRIDSN, strValue);
    }

    public final boolean isFORCEFITNull() {
        return this.IsParamNull(TAG_FORCEFIT);
    }

    public final boolean getFORCEFIT() {
        return this.GetParamIntValue(TAG_FORCEFIT, 0) == 1;
    }

    public final void setFORCEFIT(boolean bValue) {
        this.SetParamValue(TAG_FORCEFIT, bValue ? 1 : 0);
    }

    public final boolean isGRIDMODELNull() {
        return this.IsParamNull(TAG_GRIDMODEL);
    }

    public final String getGRIDMODEL() {
        return this.GetParamStringValue(TAG_GRIDMODEL, "");
    }

    public final void setGRIDMODEL(String strValue) {
        this.SetParamValue(TAG_GRIDMODEL, strValue);
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

    public final boolean isGRIDSTYLENull() {
        return this.IsParamNull(TAG_GRIDSTYLE);
    }

    public final String getGRIDSTYLE() {
        return this.GetParamStringValue(TAG_GRIDSTYLE, "");
    }

    public final void setGRIDSTYLE(String strValue) {
        this.SetParamValue(TAG_GRIDSTYLE, strValue);
    }

    public final boolean isTREEPPSDEFIDNull() {
        return this.IsParamNull(TAG_TREEPPSDEFID);
    }

    public final String getTREEPPSDEFID() {
        return this.GetParamStringValue(TAG_TREEPPSDEFID, "");
    }

    public final void setTREEPPSDEFID(String strValue) {
        this.SetParamValue(TAG_TREEPPSDEFID, strValue);
    }

    public final boolean isTREEPPSDEFNAMENull() {
        return this.IsParamNull(TAG_TREEPPSDEFNAME);
    }

    public final String getTREEPPSDEFNAME() {
        return this.GetParamStringValue(TAG_TREEPPSDEFNAME, "");
    }

    public final void setTREEPPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TREEPPSDEFNAME, strValue);
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

    public final boolean isSHOWHEADERNull() {
        return this.IsParamNull(TAG_SHOWHEADER);
    }

    public final boolean getSHOWHEADER() {
        return this.GetParamIntValue(TAG_SHOWHEADER, 0) == 1;
    }

    public final void setSHOWHEADER(boolean bValue) {
        this.SetParamValue(TAG_SHOWHEADER, bValue ? 1 : 0);
    }

    public final boolean isSRFSYSPUBNull() {
        return this.IsParamNull(TAG_SRFSYSPUB);
    }

    public final boolean getSRFSYSPUB() {
        return this.GetParamIntValue(TAG_SRFSYSPUB, 0) == 1;
    }

    public final void setSRFSYSPUB(boolean bValue) {
        this.SetParamValue(TAG_SRFSYSPUB, bValue ? 1 : 0);
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

    public final boolean isIGNOREDSITEMNull() {
        return this.IsParamNull(TAG_IGNOREDSITEM);
    }

    public final int getIGNOREDSITEM() {
        return this.GetParamIntValue(TAG_IGNOREDSITEM, 0);
    }

    public final void setIGNOREDSITEM(int nValue) {
        this.SetParamValue(TAG_IGNOREDSITEM, nValue);
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

    public final boolean isBUFFERRENDERERMODENull() {
        return this.IsParamNull(TAG_BUFFERRENDERERMODE);
    }

    public final boolean getBUFFERRENDERERMODE() {
        return this.GetParamIntValue(TAG_BUFFERRENDERERMODE, 0) == 1;
    }

    public final void setBUFFERRENDERERMODE(boolean bValue) {
        this.SetParamValue(TAG_BUFFERRENDERERMODE, bValue ? 1 : 0);
    }

    public final boolean isSORTMODENull() {
        return this.IsParamNull(TAG_SORTMODE);
    }

    public final String getSORTMODE() {
        return this.GetParamStringValue(TAG_SORTMODE, "");
    }

    public final void setSORTMODE(String strValue) {
        this.SetParamValue(TAG_SORTMODE, strValue);
    }

    public final boolean isAGGMODENull() {
        return this.IsParamNull(TAG_AGGMODE);
    }

    public final String getAGGMODE() {
        return this.GetParamStringValue(TAG_AGGMODE, "");
    }

    public final void setAGGMODE(String strValue) {
        this.SetParamValue(TAG_AGGMODE, strValue);
    }

    public final boolean isAGGPSDEIDNull() {
        return this.IsParamNull(TAG_AGGPSDEID);
    }

    public final String getAGGPSDEID() {
        return this.GetParamStringValue(TAG_AGGPSDEID, "");
    }

    public final void setAGGPSDEID(String strValue) {
        this.SetParamValue(TAG_AGGPSDEID, strValue);
    }

    public final boolean isAGGPSDENAMENull() {
        return this.IsParamNull(TAG_AGGPSDENAME);
    }

    public final String getAGGPSDENAME() {
        return this.GetParamStringValue(TAG_AGGPSDENAME, "");
    }

    public final void setAGGPSDENAME(String strValue) {
        this.SetParamValue(TAG_AGGPSDENAME, strValue);
    }

    public final boolean isAGGPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_AGGPSDEACTIONID);
    }

    public final String getAGGPSDEACTIONID() {
        return this.GetParamStringValue(TAG_AGGPSDEACTIONID, "");
    }

    public final void setAGGPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_AGGPSDEACTIONID, strValue);
    }

    public final boolean isAGGPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_AGGPSDEACTIONNAME);
    }

    public final String getAGGPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_AGGPSDEACTIONNAME, "");
    }

    public final void setAGGPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_AGGPSDEACTIONNAME, strValue);
    }

    public final boolean isNAVPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_NAVPSDEVIEWBASEID);
    }

    public final String getNAVPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_NAVPSDEVIEWBASEID, "");
    }

    public final void setNAVPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_NAVPSDEVIEWBASEID, strValue);
    }

    public final boolean isNAVPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_NAVPSDEVIEWBASENAME);
    }

    public final String getNAVPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_NAVPSDEVIEWBASENAME, "");
    }

    public final void setNAVPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_NAVPSDEVIEWBASENAME, strValue);
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

    public final boolean isNAVVIEWFILTERNull() {
        return this.IsParamNull(TAG_NAVVIEWFILTER);
    }

    public final String getNAVVIEWFILTER() {
        return this.GetParamStringValue(TAG_NAVVIEWFILTER, "");
    }

    public final void setNAVVIEWFILTER(String strValue) {
        this.SetParamValue(TAG_NAVVIEWFILTER, strValue);
    }

    public final boolean isNAVPSDERIDNull() {
        return this.IsParamNull(TAG_NAVPSDERID);
    }

    public final String getNAVPSDERID() {
        return this.GetParamStringValue(TAG_NAVPSDERID, "");
    }

    public final void setNAVPSDERID(String strValue) {
        this.SetParamValue(TAG_NAVPSDERID, strValue);
    }

    public final boolean isNAVPSDERNAMENull() {
        return this.IsParamNull(TAG_NAVPSDERNAME);
    }

    public final String getNAVPSDERNAME() {
        return this.GetParamStringValue(TAG_NAVPSDERNAME, "");
    }

    public final void setNAVPSDERNAME(String strValue) {
        this.SetParamValue(TAG_NAVPSDERNAME, strValue);
    }

    public final boolean isCOLENABLELINKNull() {
        return this.IsParamNull(TAG_COLENABLELINK);
    }

    public final int getCOLENABLELINK() {
        return this.GetParamIntValue(TAG_COLENABLELINK, 0);
    }

    public final void setCOLENABLELINK(int nValue) {
        this.SetParamValue(TAG_COLENABLELINK, nValue);
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

    public final boolean isITEMPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_ITEMPSSYSCSSID);
    }

    public final String getITEMPSSYSCSSID() {
        return this.GetParamStringValue(TAG_ITEMPSSYSCSSID, "");
    }

    public final void setITEMPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_ITEMPSSYSCSSID, strValue);
    }

    public final boolean isITEMPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_ITEMPSSYSCSSNAME);
    }

    public final String getITEMPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_ITEMPSSYSCSSNAME, "");
    }

    public final void setITEMPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_ITEMPSSYSCSSNAME, strValue);
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

    public final boolean isGROUPMODENull() {
        return this.IsParamNull(TAG_GROUPMODE);
    }

    public final String getGROUPMODE() {
        return this.GetParamStringValue(TAG_GROUPMODE, "");
    }

    public final void setGROUPMODE(String strValue) {
        this.SetParamValue(TAG_GROUPMODE, strValue);
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

    public final boolean isAGGPSDEDSIDNull() {
        return this.IsParamNull(TAG_AGGPSDEDSID);
    }

    public final String getAGGPSDEDSID() {
        return this.GetParamStringValue(TAG_AGGPSDEDSID, "");
    }

    public final void setAGGPSDEDSID(String strValue) {
        this.SetParamValue(TAG_AGGPSDEDSID, strValue);
    }

    public final boolean isAGGPSDEDSNAMENull() {
        return this.IsParamNull(TAG_AGGPSDEDSNAME);
    }

    public final String getAGGPSDEDSNAME() {
        return this.GetParamStringValue(TAG_AGGPSDEDSNAME, "");
    }

    public final void setAGGPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_AGGPSDEDSNAME, strValue);
    }

    public final boolean isAGGPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_AGGPSSYSVIEWPANELID);
    }

    public final String getAGGPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_AGGPSSYSVIEWPANELID, "");
    }

    public final void setAGGPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_AGGPSSYSVIEWPANELID, strValue);
    }

    public final boolean isAGGPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_AGGPSSYSVIEWPANELNAME);
    }

    public final String getAGGPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_AGGPSSYSVIEWPANELNAME, "");
    }

    public final void setAGGPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_AGGPSSYSVIEWPANELNAME, strValue);
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

    public final boolean isCOLENABLEFILTERNull() {
        return this.IsParamNull(TAG_COLENABLEFILTER);
    }

    public final int getCOLENABLEFILTER() {
        return this.GetParamIntValue(TAG_COLENABLEFILTER, 0);
    }

    public final void setCOLENABLEFILTER(int nValue) {
        this.SetParamValue(TAG_COLENABLEFILTER, nValue);
    }

    public final boolean isFROZENLASTCOLNull() {
        return this.IsParamNull(TAG_FROZENLASTCOL);
    }

    public final int getFROZENLASTCOL() {
        return this.GetParamIntValue(TAG_FROZENLASTCOL, 0);
    }

    public final void setFROZENLASTCOL(int nValue) {
        this.SetParamValue(TAG_FROZENLASTCOL, nValue);
    }

    public final boolean isFROZENCOLNull() {
        return this.IsParamNull(TAG_FROZENCOL);
    }

    public final int getFROZENCOL() {
        return this.GetParamIntValue(TAG_FROZENCOL, 0);
    }

    public final void setFROZENCOL(int nValue) {
        this.SetParamValue(TAG_FROZENCOL, nValue);
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

    public final boolean isMULTISELECTNull() {
        return this.IsParamNull(TAG_MULTISELECT);
    }

    public final boolean getMULTISELECT() {
        return this.GetParamIntValue(TAG_MULTISELECT, 0) == 1;
    }

    public final void setMULTISELECT(boolean bValue) {
        this.SetParamValue(TAG_MULTISELECT, bValue ? 1 : 0);
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

