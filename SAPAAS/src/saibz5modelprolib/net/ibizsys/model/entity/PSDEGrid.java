/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDEGRIDIDNull() {
        return this.isParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.getParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.setParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.isParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.getParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.setParamValue(TAG_PSDEGRIDNAME, strValue);
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

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isENABLEPAGINGBARNull() {
        return this.isParamNull(TAG_ENABLEPAGINGBAR);
    }

    public final boolean getENABLEPAGINGBAR() {
        return this.getParamIntValue(TAG_ENABLEPAGINGBAR, 0) == 1;
    }

    public final void setENABLEPAGINGBAR(boolean bValue) {
        this.setParamValue(TAG_ENABLEPAGINGBAR, bValue ? 1 : 0);
    }

    public final boolean isPAGINGSIZENull() {
        return this.isParamNull(TAG_PAGINGSIZE);
    }

    public final int getPAGINGSIZE() {
        return this.getParamIntValue(TAG_PAGINGSIZE, 0);
    }

    public final void setPAGINGSIZE(int nValue) {
        this.setParamValue(TAG_PAGINGSIZE, nValue);
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

    public final boolean isGRIDSNNull() {
        return this.isParamNull(TAG_GRIDSN);
    }

    public final String getGRIDSN() {
        return this.getParamStringValue(TAG_GRIDSN, "");
    }

    public final void setGRIDSN(String strValue) {
        this.setParamValue(TAG_GRIDSN, strValue);
    }

    public final boolean isFORCEFITNull() {
        return this.isParamNull(TAG_FORCEFIT);
    }

    public final boolean getFORCEFIT() {
        return this.getParamIntValue(TAG_FORCEFIT, 0) == 1;
    }

    public final void setFORCEFIT(boolean bValue) {
        this.setParamValue(TAG_FORCEFIT, bValue ? 1 : 0);
    }

    public final boolean isGRIDMODELNull() {
        return this.isParamNull(TAG_GRIDMODEL);
    }

    public final String getGRIDMODEL() {
        return this.getParamStringValue(TAG_GRIDMODEL, "");
    }

    public final void setGRIDMODEL(String strValue) {
        this.setParamValue(TAG_GRIDMODEL, strValue);
    }

    public final boolean isNOSORTNull() {
        return this.isParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.getParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.setParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isGRIDSTYLENull() {
        return this.isParamNull(TAG_GRIDSTYLE);
    }

    public final String getGRIDSTYLE() {
        return this.getParamStringValue(TAG_GRIDSTYLE, "");
    }

    public final void setGRIDSTYLE(String strValue) {
        this.setParamValue(TAG_GRIDSTYLE, strValue);
    }

    public final boolean isTREEPPSDEFIDNull() {
        return this.isParamNull(TAG_TREEPPSDEFID);
    }

    public final String getTREEPPSDEFID() {
        return this.getParamStringValue(TAG_TREEPPSDEFID, "");
    }

    public final void setTREEPPSDEFID(String strValue) {
        this.setParamValue(TAG_TREEPPSDEFID, strValue);
    }

    public final boolean isTREEPPSDEFNAMENull() {
        return this.isParamNull(TAG_TREEPPSDEFNAME);
    }

    public final String getTREEPPSDEFNAME() {
        return this.getParamStringValue(TAG_TREEPPSDEFNAME, "");
    }

    public final void setTREEPPSDEFNAME(String strValue) {
        this.setParamValue(TAG_TREEPPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.isParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.isParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.isParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.getParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.setParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isSHOWHEADERNull() {
        return this.isParamNull(TAG_SHOWHEADER);
    }

    public final boolean getSHOWHEADER() {
        return this.getParamIntValue(TAG_SHOWHEADER, 0) == 1;
    }

    public final void setSHOWHEADER(boolean bValue) {
        this.setParamValue(TAG_SHOWHEADER, bValue ? 1 : 0);
    }

    public final boolean isSRFSYSPUBNull() {
        return this.isParamNull(TAG_SRFSYSPUB);
    }

    public final boolean getSRFSYSPUB() {
        return this.getParamIntValue(TAG_SRFSYSPUB, 0) == 1;
    }

    public final void setSRFSYSPUB(boolean bValue) {
        this.setParamValue(TAG_SRFSYSPUB, bValue ? 1 : 0);
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

    public final boolean isIGNOREDSITEMNull() {
        return this.isParamNull(TAG_IGNOREDSITEM);
    }

    public final int getIGNOREDSITEM() {
        return this.getParamIntValue(TAG_IGNOREDSITEM, 0);
    }

    public final void setIGNOREDSITEM(int nValue) {
        this.setParamValue(TAG_IGNOREDSITEM, nValue);
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

    public final boolean isBUFFERRENDERERMODENull() {
        return this.isParamNull(TAG_BUFFERRENDERERMODE);
    }

    public final boolean getBUFFERRENDERERMODE() {
        return this.getParamIntValue(TAG_BUFFERRENDERERMODE, 0) == 1;
    }

    public final void setBUFFERRENDERERMODE(boolean bValue) {
        this.setParamValue(TAG_BUFFERRENDERERMODE, bValue ? 1 : 0);
    }

    public final boolean isSORTMODENull() {
        return this.isParamNull(TAG_SORTMODE);
    }

    public final String getSORTMODE() {
        return this.getParamStringValue(TAG_SORTMODE, "");
    }

    public final void setSORTMODE(String strValue) {
        this.setParamValue(TAG_SORTMODE, strValue);
    }
}

