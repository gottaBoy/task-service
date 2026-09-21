/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETreeView
extends BaseDataEntity {
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SHOWROOT = "SHOWROOT";
    public static final String TAG_ROOTSELECT = "ROOTSELECT";
    public static final String TAG_ENABLESEARCH = "ENABLESEARCH";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_CATPSCODELISTID = "CATPSCODELISTID";
    public static final String TAG_CATPSCODELISTNAME = "CATPSCODELISTNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_TREEGRIDFLAG = "TREEGRIDFLAG";
    public static final String TAG_BUFFERRENDERERMODE = "BUFFERRENDERERMODE";
    public static final String TAG_TREEMODEL = "TREEMODEL";
    public static final String TAG_NOICONDEFAULT = "NOICONDEFAULT";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_ENABLEEDIT = "ENABLEEDIT";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_FROZENCOL = "FROZENCOL";
    public static final String TAG_FROZENLASTCOL = "FROZENLASTCOL";
    public static final String TAG_COLENABLEFILTER = "COLENABLEFILTER";
    public static final String TAG_COLENABLELINK = "COLENABLELINK";
    public static final String TAG_TREESTYLE = "TREESTYLE";

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
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

    public final boolean isSHOWROOTNull() {
        return this.IsParamNull(TAG_SHOWROOT);
    }

    public final boolean getSHOWROOT() {
        return this.GetParamIntValue(TAG_SHOWROOT, 0) == 1;
    }

    public final void setSHOWROOT(boolean bValue) {
        this.SetParamValue(TAG_SHOWROOT, bValue ? 1 : 0);
    }

    public final boolean isROOTSELECTNull() {
        return this.IsParamNull(TAG_ROOTSELECT);
    }

    public final boolean getROOTSELECT() {
        return this.GetParamIntValue(TAG_ROOTSELECT, 0) == 1;
    }

    public final void setROOTSELECT(boolean bValue) {
        this.SetParamValue(TAG_ROOTSELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLESEARCHNull() {
        return this.IsParamNull(TAG_ENABLESEARCH);
    }

    public final boolean getENABLESEARCH() {
        return this.GetParamIntValue(TAG_ENABLESEARCH, 0) == 1;
    }

    public final void setENABLESEARCH(boolean bValue) {
        this.SetParamValue(TAG_ENABLESEARCH, bValue ? 1 : 0);
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

    public final boolean isCATPSCODELISTIDNull() {
        return this.IsParamNull(TAG_CATPSCODELISTID);
    }

    public final String getCATPSCODELISTID() {
        return this.GetParamStringValue(TAG_CATPSCODELISTID, "");
    }

    public final void setCATPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_CATPSCODELISTID, strValue);
    }

    public final boolean isCATPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_CATPSCODELISTNAME);
    }

    public final String getCATPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_CATPSCODELISTNAME, "");
    }

    public final void setCATPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CATPSCODELISTNAME, strValue);
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

    public final boolean isTREEGRIDFLAGNull() {
        return this.IsParamNull(TAG_TREEGRIDFLAG);
    }

    public final int getTREEGRIDFLAG() {
        return this.GetParamIntValue(TAG_TREEGRIDFLAG, 0);
    }

    public final void setTREEGRIDFLAG(int nValue) {
        this.SetParamValue(TAG_TREEGRIDFLAG, nValue);
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

    public final boolean isTREEMODELNull() {
        return this.IsParamNull(TAG_TREEMODEL);
    }

    public final String getTREEMODEL() {
        return this.GetParamStringValue(TAG_TREEMODEL, "");
    }

    public final void setTREEMODEL(String strValue) {
        this.SetParamValue(TAG_TREEMODEL, strValue);
    }

    public final boolean isNOICONDEFAULTNull() {
        return this.IsParamNull(TAG_NOICONDEFAULT);
    }

    public final boolean getNOICONDEFAULT() {
        return this.GetParamIntValue(TAG_NOICONDEFAULT, 0) == 1;
    }

    public final void setNOICONDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_NOICONDEFAULT, bValue ? 1 : 0);
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

    public final boolean isENABLEITEMPRIVNull() {
        return this.IsParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.GetParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
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

    public final boolean isFROZENLASTCOLNull() {
        return this.IsParamNull(TAG_FROZENLASTCOL);
    }

    public final int getFROZENLASTCOL() {
        return this.GetParamIntValue(TAG_FROZENLASTCOL, 0);
    }

    public final void setFROZENLASTCOL(int nValue) {
        this.SetParamValue(TAG_FROZENLASTCOL, nValue);
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

    public final boolean isCOLENABLELINKNull() {
        return this.IsParamNull(TAG_COLENABLELINK);
    }

    public final int getCOLENABLELINK() {
        return this.GetParamIntValue(TAG_COLENABLELINK, 0);
    }

    public final void setCOLENABLELINK(int nValue) {
        this.SetParamValue(TAG_COLENABLELINK, nValue);
    }

    public final boolean isTREESTYLENull() {
        return this.IsParamNull(TAG_TREESTYLE);
    }

    public final String getTREESTYLE() {
        return this.GetParamStringValue(TAG_TREESTYLE, "");
    }

    public final void setTREESTYLE(String strValue) {
        this.SetParamValue(TAG_TREESTYLE, strValue);
    }
}

