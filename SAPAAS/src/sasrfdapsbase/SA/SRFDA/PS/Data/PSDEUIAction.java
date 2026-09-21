/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEUIAction
extends BaseDataEntity {
    public static final String UIACTIONTYPE_SYS = "SYS";
    public static final String UIACTIONTYPE_FRONT = "FRONT";
    public static final String UIACTIONTYPE_BACKEND = "BACKEND";
    public static final String UIACTIONTYPE_CUSTOM = "CUSTOM";
    public static final String FRONTPROTYPE_WIZARD = "WIZARD";
    public static final String FRONTPROTYPE_SHOWPAGE = "SHOWPAGE";
    public static final String FRONTPROTYPE_PRINT = "PRINT";
    public static final String FRONTPROTYPE_DATAIMP = "DATAIMP";
    public static final String FRONTPROTYPE_DATAEXP = "DATAEXP";
    public static final String FRONTPROTYPE_CHAT = "CHAT";
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
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
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
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_UATAG = "UATAG";
    public static final String TAG_UATAG2 = "UATAG2";
    public static final String TAG_UATAG3 = "UATAG3";
    public static final String TAG_UATAG4 = "UATAG4";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_REPPSSYSUIACTIONID = "REPPSSYSUIACTIONID";
    public static final String TAG_REPPSSYSUIACTIONNAME = "REPPSSYSUIACTIONNAME";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String TAG_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String TAG_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_UIACTIONPARAM = "UIACTIONPARAM";
    public static final String TAG_UIACTIONPARAM9 = "UIACTIONPARAM9";
    public static final String TAG_UIACTIONPARAM8 = "UIACTIONPARAM8";
    public static final String TAG_UIACTIONPARAM7 = "UIACTIONPARAM7";
    public static final String TAG_UIACTIONPARAM6 = "UIACTIONPARAM6";
    public static final String TAG_UIACTIONPARAM5 = "UIACTIONPARAM5";
    public static final String TAG_UIACTIONPARAM4 = "UIACTIONPARAM4";
    public static final String TAG_UIACTIONPARAM3 = "UIACTIONPARAM3";
    public static final String TAG_UIACTIONPARAM2 = "UIACTIONPARAM2";
    public static final String TAG_UIACTIONPARAM12 = "UIACTIONPARAM12";
    public static final String TAG_UIACTIONPARAM11 = "UIACTIONPARAM11";
    public static final String TAG_UIACTIONPARAM10 = "UIACTIONPARAM10";
    public static final String TAG_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String TAG_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String TAG_PSDEPRINTID = "PSDEPRINTID";
    public static final String TAG_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String TAG_NO2PSDEDATAEXPID = "NO2PSDEDATAEXPID";
    public static final String TAG_NO2PSDEDATAEXPNAME = "NO2PSDEDATAEXPNAME";
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String TAG_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String TAG_BUTTONSTYLE = "BUTTONSTYLE";

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
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

    public final boolean isUIACTIONCODENull() {
        return this.IsParamNull(TAG_UIACTIONCODE);
    }

    public final String getUIACTIONCODE() {
        return this.GetParamStringValue(TAG_UIACTIONCODE, "");
    }

    public final void setUIACTIONCODE(String strValue) {
        this.SetParamValue(TAG_UIACTIONCODE, strValue);
    }

    public final boolean isTEMPLMODENull() {
        return this.IsParamNull(TAG_TEMPLMODE);
    }

    public final boolean getTEMPLMODE() {
        return this.GetParamIntValue(TAG_TEMPLMODE, 0) == 1;
    }

    public final void setTEMPLMODE(boolean bValue) {
        this.SetParamValue(TAG_TEMPLMODE, bValue ? 1 : 0);
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

    public final boolean isUIACTIONTYPENull() {
        return this.IsParamNull(TAG_UIACTIONTYPE);
    }

    public final String getUIACTIONTYPE() {
        return this.GetParamStringValue(TAG_UIACTIONTYPE, "");
    }

    public final void setUIACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_UIACTIONTYPE, strValue);
    }

    public final boolean isPSSYSUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONID);
    }

    public final String getPSSYSUIACTIONID() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONID, "");
    }

    public final void setPSSYSUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONID, strValue);
    }

    public final boolean isPSSYSUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONNAME);
    }

    public final String getPSSYSUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONNAME, "");
    }

    public final void setPSSYSUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONNAME, strValue);
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

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isFRONTPROTYPENull() {
        return this.IsParamNull(TAG_FRONTPROTYPE);
    }

    public final String getFRONTPROTYPE() {
        return this.GetParamStringValue(TAG_FRONTPROTYPE, "");
    }

    public final void setFRONTPROTYPE(String strValue) {
        this.SetParamValue(TAG_FRONTPROTYPE, strValue);
    }

    public final boolean isACTIONTARGETNull() {
        return this.IsParamNull(TAG_ACTIONTARGET);
    }

    public final String getACTIONTARGET() {
        return this.GetParamStringValue(TAG_ACTIONTARGET, "");
    }

    public final void setACTIONTARGET(String strValue) {
        this.SetParamValue(TAG_ACTIONTARGET, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isTIMEOUTNull() {
        return this.IsParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.SetParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isSUCCESSINFONull() {
        return this.IsParamNull(TAG_SUCCESSINFO);
    }

    public final String getSUCCESSINFO() {
        return this.GetParamStringValue(TAG_SUCCESSINFO, "");
    }

    public final void setSUCCESSINFO(String strValue) {
        this.SetParamValue(TAG_SUCCESSINFO, strValue);
    }

    public final boolean isRELOADDATANull() {
        return this.IsParamNull(TAG_RELOADDATA);
    }

    public final boolean getRELOADDATA() {
        return this.GetParamIntValue(TAG_RELOADDATA, 0) == 1;
    }

    public final void setRELOADDATA(boolean bValue) {
        this.SetParamValue(TAG_RELOADDATA, bValue ? 1 : 0);
    }

    public final boolean isUSERCONFIRMNull() {
        return this.IsParamNull(TAG_USERCONFIRM);
    }

    public final boolean getUSERCONFIRM() {
        return this.GetParamIntValue(TAG_USERCONFIRM, 0) == 1;
    }

    public final void setUSERCONFIRM(boolean bValue) {
        this.SetParamValue(TAG_USERCONFIRM, bValue ? 1 : 0);
    }

    public final boolean isCONFIRMINFONull() {
        return this.IsParamNull(TAG_CONFIRMINFO);
    }

    public final String getCONFIRMINFO() {
        return this.GetParamStringValue(TAG_CONFIRMINFO, "");
    }

    public final void setCONFIRMINFO(String strValue) {
        this.SetParamValue(TAG_CONFIRMINFO, strValue);
    }

    public final boolean isITEMOBJNull() {
        return this.IsParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.GetParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ, strValue);
    }

    public final boolean isSYSITEMOBJNull() {
        return this.IsParamNull(TAG_SYSITEMOBJ);
    }

    public final String getSYSITEMOBJ() {
        return this.GetParamStringValue(TAG_SYSITEMOBJ, "");
    }

    public final void setSYSITEMOBJ(String strValue) {
        this.SetParamValue(TAG_SYSITEMOBJ, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isUIACTIONPARAMSNull() {
        return this.IsParamNull(TAG_UIACTIONPARAMS);
    }

    public final String getUIACTIONPARAMS() {
        return this.GetParamStringValue(TAG_UIACTIONPARAMS, "");
    }

    public final void setUIACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAMS, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.IsParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.GetParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSNAME, strValue);
    }

    public final boolean isPSWFPROCESSIDNull() {
        return this.IsParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.GetParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPLINKIDNull() {
        return this.IsParamNull(TAG_PSWFPLINKID);
    }

    public final String getPSWFPLINKID() {
        return this.GetParamStringValue(TAG_PSWFPLINKID, "");
    }

    public final void setPSWFPLINKID(String strValue) {
        this.SetParamValue(TAG_PSWFPLINKID, strValue);
    }

    public final boolean isPSWFPLINKNAMENull() {
        return this.IsParamNull(TAG_PSWFPLINKNAME);
    }

    public final String getPSWFPLINKNAME() {
        return this.GetParamStringValue(TAG_PSWFPLINKNAME, "");
    }

    public final void setPSWFPLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSWFPLINKNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
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

    public final boolean isHTMLPAGEURLNull() {
        return this.IsParamNull(TAG_HTMLPAGEURL);
    }

    public final String getHTMLPAGEURL() {
        return this.GetParamStringValue(TAG_HTMLPAGEURL, "");
    }

    public final void setHTMLPAGEURL(String strValue) {
        this.SetParamValue(TAG_HTMLPAGEURL, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isCLOSEEDITVIEWNull() {
        return this.IsParamNull(TAG_CLOSEEDITVIEW);
    }

    public final int getCLOSEEDITVIEW() {
        return this.GetParamIntValue(TAG_CLOSEEDITVIEW, 0);
    }

    public final void setCLOSEEDITVIEW(int bValue) {
        this.SetParamValue(TAG_CLOSEEDITVIEW, bValue);
    }

    public final boolean isPSSYSVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICID);
    }

    public final String getPSSYSVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICID, "");
    }

    public final void setPSSYSVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICNAME);
    }

    public final String getPSSYSVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICNAME, "");
    }

    public final void setPSSYSVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICNAME, strValue);
    }

    public final boolean isVLEXCEMODENull() {
        return this.IsParamNull(TAG_VLEXCEMODE);
    }

    public final String getVLEXCEMODE() {
        return this.GetParamStringValue(TAG_VLEXCEMODE, "");
    }

    public final void setVLEXCEMODE(String strValue) {
        this.SetParamValue(TAG_VLEXCEMODE, strValue);
    }

    public final boolean isVIEWLOGICTYPENull() {
        return this.IsParamNull(TAG_VIEWLOGICTYPE);
    }

    public final String getVIEWLOGICTYPE() {
        return this.GetParamStringValue(TAG_VIEWLOGICTYPE, "");
    }

    public final void setVIEWLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_VIEWLOGICTYPE, strValue);
    }

    public final boolean isPSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICID);
    }

    public final String getPSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICID, "");
    }

    public final void setPSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICID, strValue);
    }

    public final boolean isPSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICNAME);
    }

    public final String getPSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICNAME, "");
    }

    public final void setPSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isVLEXECMODENull() {
        return this.IsParamNull(TAG_VLEXECMODE);
    }

    public final String getVLEXECMODE() {
        return this.GetParamStringValue(TAG_VLEXECMODE, "");
    }

    public final void setVLEXECMODE(String strValue) {
        this.SetParamValue(TAG_VLEXECMODE, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
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

    public final boolean isCMPSLANRESIDNull() {
        return this.IsParamNull(TAG_CMPSLANRESID);
    }

    public final String getCMPSLANRESID() {
        return this.GetParamStringValue(TAG_CMPSLANRESID, "");
    }

    public final void setCMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESID, strValue);
    }

    public final boolean isCMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CMPSLANRESNAME);
    }

    public final String getCMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CMPSLANRESNAME, "");
    }

    public final void setCMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESNAME, strValue);
    }

    public final boolean isSMPSLANRESIDNull() {
        return this.IsParamNull(TAG_SMPSLANRESID);
    }

    public final String getSMPSLANRESID() {
        return this.GetParamStringValue(TAG_SMPSLANRESID, "");
    }

    public final void setSMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SMPSLANRESID, strValue);
    }

    public final boolean isSMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SMPSLANRESNAME);
    }

    public final String getSMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SMPSLANRESNAME, "");
    }

    public final void setSMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SMPSLANRESNAME, strValue);
    }

    public final boolean isNOPRIVDMNull() {
        return this.IsParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.GetParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isDATAITEMNull() {
        return this.IsParamNull(TAG_DATAITEM);
    }

    public final String getDATAITEM() {
        return this.GetParamStringValue(TAG_DATAITEM, "");
    }

    public final void setDATAITEM(String strValue) {
        this.SetParamValue(TAG_DATAITEM, strValue);
    }

    public final boolean isTEXTITEMNull() {
        return this.IsParamNull(TAG_TEXTITEM);
    }

    public final String getTEXTITEM() {
        return this.GetParamStringValue(TAG_TEXTITEM, "");
    }

    public final void setTEXTITEM(String strValue) {
        this.SetParamValue(TAG_TEXTITEM, strValue);
    }

    public final boolean isPARAMITEMNull() {
        return this.IsParamNull(TAG_PARAMITEM);
    }

    public final String getPARAMITEM() {
        return this.GetParamStringValue(TAG_PARAMITEM, "");
    }

    public final void setPARAMITEM(String strValue) {
        this.SetParamValue(TAG_PARAMITEM, strValue);
    }

    public final boolean isGLOBALFLAGNull() {
        return this.IsParamNull(TAG_GLOBALFLAG);
    }

    public final boolean getGLOBALFLAG() {
        return this.GetParamIntValue(TAG_GLOBALFLAG, 0) == 1;
    }

    public final void setGLOBALFLAG(boolean bValue) {
        this.SetParamValue(TAG_GLOBALFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLERTMODELNull() {
        return this.IsParamNull(TAG_ENABLERTMODEL);
    }

    public final boolean getENABLERTMODEL() {
        return this.GetParamIntValue(TAG_ENABLERTMODEL, 0) == 1;
    }

    public final void setENABLERTMODEL(boolean bValue) {
        this.SetParamValue(TAG_ENABLERTMODEL, bValue ? 1 : 0);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isNEXTPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_NEXTPSDEUIACTIONID);
    }

    public final String getNEXTPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_NEXTPSDEUIACTIONID, "");
    }

    public final void setNEXTPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEUIACTIONID, strValue);
    }

    public final boolean isNEXTPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_NEXTPSDEUIACTIONNAME);
    }

    public final String getNEXTPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_NEXTPSDEUIACTIONNAME, "");
    }

    public final void setNEXTPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEUIACTIONNAME, strValue);
    }

    public final boolean isPSSYSPDTVIEWIDNull() {
        return this.IsParamNull(TAG_PSSYSPDTVIEWID);
    }

    public final String getPSSYSPDTVIEWID() {
        return this.GetParamStringValue(TAG_PSSYSPDTVIEWID, "");
    }

    public final void setPSSYSPDTVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSYSPDTVIEWID, strValue);
    }

    public final boolean isPSSYSPDTVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSYSPDTVIEWNAME);
    }

    public final String getPSSYSPDTVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSYSPDTVIEWNAME, "");
    }

    public final void setPSSYSPDTVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPDTVIEWNAME, strValue);
    }

    public final boolean isPDTVIEWFLAGNull() {
        return this.IsParamNull(TAG_PDTVIEWFLAG);
    }

    public final boolean getPDTVIEWFLAG() {
        return this.GetParamIntValue(TAG_PDTVIEWFLAG, 0) == 1;
    }

    public final void setPDTVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_PDTVIEWFLAG, bValue ? 1 : 0);
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

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isUATAGNull() {
        return this.IsParamNull(TAG_UATAG);
    }

    public final String getUATAG() {
        return this.GetParamStringValue(TAG_UATAG, "");
    }

    public final void setUATAG(String strValue) {
        this.SetParamValue(TAG_UATAG, strValue);
    }

    public final boolean isUATAG2Null() {
        return this.IsParamNull(TAG_UATAG2);
    }

    public final String getUATAG2() {
        return this.GetParamStringValue(TAG_UATAG2, "");
    }

    public final void setUATAG2(String strValue) {
        this.SetParamValue(TAG_UATAG2, strValue);
    }

    public final boolean isUATAG3Null() {
        return this.IsParamNull(TAG_UATAG3);
    }

    public final String getUATAG3() {
        return this.GetParamStringValue(TAG_UATAG3, "");
    }

    public final void setUATAG3(String strValue) {
        this.SetParamValue(TAG_UATAG3, strValue);
    }

    public final boolean isUATAG4Null() {
        return this.IsParamNull(TAG_UATAG4);
    }

    public final String getUATAG4() {
        return this.GetParamStringValue(TAG_UATAG4, "");
    }

    public final void setUATAG4(String strValue) {
        this.SetParamValue(TAG_UATAG4, strValue);
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

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isREPPSSYSUIACTIONIDNull() {
        return this.IsParamNull(TAG_REPPSSYSUIACTIONID);
    }

    public final String getREPPSSYSUIACTIONID() {
        return this.GetParamStringValue(TAG_REPPSSYSUIACTIONID, "");
    }

    public final void setREPPSSYSUIACTIONID(String strValue) {
        this.SetParamValue(TAG_REPPSSYSUIACTIONID, strValue);
    }

    public final boolean isREPPSSYSUIACTIONNAMENull() {
        return this.IsParamNull(TAG_REPPSSYSUIACTIONNAME);
    }

    public final String getREPPSSYSUIACTIONNAME() {
        return this.GetParamStringValue(TAG_REPPSSYSUIACTIONNAME, "");
    }

    public final void setREPPSSYSUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REPPSSYSUIACTIONNAME, strValue);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.IsParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.GetParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.IsParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.GetParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.SetParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isACTIONLEVELNull() {
        return this.IsParamNull(TAG_ACTIONLEVEL);
    }

    public final int getACTIONLEVEL() {
        return this.GetParamIntValue(TAG_ACTIONLEVEL, 0);
    }

    public final void setACTIONLEVEL(int nValue) {
        this.SetParamValue(TAG_ACTIONLEVEL, nValue);
    }

    public final boolean isMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWID);
    }

    public final String getMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWID, "");
    }

    public final void setMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWID, strValue);
    }

    public final boolean isMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWNAME);
    }

    public final String getMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWNAME, "");
    }

    public final void setMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWNAME, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isUIACTIONPARAMNull() {
        return this.IsParamNull(TAG_UIACTIONPARAM);
    }

    public final String getUIACTIONPARAM() {
        return this.GetParamStringValue(TAG_UIACTIONPARAM, "");
    }

    public final void setUIACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAM, strValue);
    }

    public final boolean isUIACTIONPARAM9Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM9);
    }

    public final float getUIACTIONPARAM9() {
        return this.GetParamFloatValue(TAG_UIACTIONPARAM9, 0.0f);
    }

    public final void setUIACTIONPARAM9(float fValue) {
        this.SetParamValue(TAG_UIACTIONPARAM9, Float.valueOf(fValue));
    }

    public final boolean isUIACTIONPARAM8Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM8);
    }

    public final int getUIACTIONPARAM8() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM8, 0);
    }

    public final void setUIACTIONPARAM8(int nValue) {
        this.SetParamValue(TAG_UIACTIONPARAM8, nValue);
    }

    public final boolean isUIACTIONPARAM7Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM7);
    }

    public final int getUIACTIONPARAM7() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM7, 0);
    }

    public final void setUIACTIONPARAM7(int nValue) {
        this.SetParamValue(TAG_UIACTIONPARAM7, nValue);
    }

    public final boolean isUIACTIONPARAM6Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM6);
    }

    public final boolean getUIACTIONPARAM6() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM6, 0) == 1;
    }

    public final void setUIACTIONPARAM6(boolean bValue) {
        this.SetParamValue(TAG_UIACTIONPARAM6, bValue ? 1 : 0);
    }

    public final boolean isUIACTIONPARAM5Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM5);
    }

    public final boolean getUIACTIONPARAM5() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM5, 0) == 1;
    }

    public final void setUIACTIONPARAM5(boolean bValue) {
        this.SetParamValue(TAG_UIACTIONPARAM5, bValue ? 1 : 0);
    }

    public final boolean isUIACTIONPARAM4Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM4);
    }

    public final String getUIACTIONPARAM4() {
        return this.GetParamStringValue(TAG_UIACTIONPARAM4, "");
    }

    public final void setUIACTIONPARAM4(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAM4, strValue);
    }

    public final boolean isUIACTIONPARAM3Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM3);
    }

    public final String getUIACTIONPARAM3() {
        return this.GetParamStringValue(TAG_UIACTIONPARAM3, "");
    }

    public final void setUIACTIONPARAM3(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAM3, strValue);
    }

    public final boolean isUIACTIONPARAM2Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM2);
    }

    public final String getUIACTIONPARAM2() {
        return this.GetParamStringValue(TAG_UIACTIONPARAM2, "");
    }

    public final void setUIACTIONPARAM2(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAM2, strValue);
    }

    public final boolean isUIACTIONPARAM12Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM12);
    }

    public final int getUIACTIONPARAM12() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM12, 0);
    }

    public final void setUIACTIONPARAM12(int nValue) {
        this.SetParamValue(TAG_UIACTIONPARAM12, nValue);
    }

    public final boolean isUIACTIONPARAM11Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM11);
    }

    public final int getUIACTIONPARAM11() {
        return this.GetParamIntValue(TAG_UIACTIONPARAM11, 0);
    }

    public final void setUIACTIONPARAM11(int nValue) {
        this.SetParamValue(TAG_UIACTIONPARAM11, nValue);
    }

    public final boolean isUIACTIONPARAM10Null() {
        return this.IsParamNull(TAG_UIACTIONPARAM10);
    }

    public final float getUIACTIONPARAM10() {
        return this.GetParamFloatValue(TAG_UIACTIONPARAM10, 0.0f);
    }

    public final void setUIACTIONPARAM10(float fValue) {
        this.SetParamValue(TAG_UIACTIONPARAM10, Float.valueOf(fValue));
    }

    public final boolean isPSDEDATAIMPIDNull() {
        return this.IsParamNull(TAG_PSDEDATAIMPID);
    }

    public final String getPSDEDATAIMPID() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPID, "");
    }

    public final void setPSDEDATAIMPID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPID, strValue);
    }

    public final boolean isPSDEDATAIMPNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAIMPNAME);
    }

    public final String getPSDEDATAIMPNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPNAME, "");
    }

    public final void setPSDEDATAIMPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPNAME, strValue);
    }

    public final boolean isPSDEPRINTIDNull() {
        return this.IsParamNull(TAG_PSDEPRINTID);
    }

    public final String getPSDEPRINTID() {
        return this.GetParamStringValue(TAG_PSDEPRINTID, "");
    }

    public final void setPSDEPRINTID(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTID, strValue);
    }

    public final boolean isPSDEPRINTNAMENull() {
        return this.IsParamNull(TAG_PSDEPRINTNAME);
    }

    public final String getPSDEPRINTNAME() {
        return this.GetParamStringValue(TAG_PSDEPRINTNAME, "");
    }

    public final void setPSDEPRINTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTNAME, strValue);
    }

    public final boolean isNO2PSDEDATAEXPIDNull() {
        return this.IsParamNull(TAG_NO2PSDEDATAEXPID);
    }

    public final String getNO2PSDEDATAEXPID() {
        return this.GetParamStringValue(TAG_NO2PSDEDATAEXPID, "");
    }

    public final void setNO2PSDEDATAEXPID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEDATAEXPID, strValue);
    }

    public final boolean isNO2PSDEDATAEXPNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEDATAEXPNAME);
    }

    public final String getNO2PSDEDATAEXPNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEDATAEXPNAME, "");
    }

    public final void setNO2PSDEDATAEXPNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEDATAEXPNAME, strValue);
    }

    public final boolean isPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.GetParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEACMODENAME, strValue);
    }

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }

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

    public final boolean isMOBPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBPSDEFORMID);
    }

    public final String getMOBPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }

    public final boolean isBUTTONSTYLENull() {
        return this.IsParamNull(TAG_BUTTONSTYLE);
    }

    public final String getBUTTONSTYLE() {
        return this.GetParamStringValue(TAG_BUTTONSTYLE, "");
    }

    public final void setBUTTONSTYLE(String strValue) {
        this.SetParamValue(TAG_BUTTONSTYLE, strValue);
    }
}

