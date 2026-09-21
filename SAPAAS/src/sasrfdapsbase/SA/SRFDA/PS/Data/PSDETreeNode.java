/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDETreeNode
extends BaseDataEntity {
    public static final String TREENODETYPE_STATIC = "STATIC";
    public static final String TREENODETYPE_DE = "DE";
    public static final String TREENODETYPE_CODELIST = "CODELIST";
    public static final String NODEACTION_PAGELINK = "PAGELINK";
    public static final String NODEACTION_JAVASCRIPT = "JAVASCRIPT";
    public static final String SORTDIR_ASC = "ASC";
    public static final String SORTDIR_DESC = "DESC";
    public static final int COUNTERMODE_0 = 0;
    public static final int COUNTERMODE_1 = 1;
    public static final String TAG_PSDETREENODEID = "PSDETREENODEID";
    public static final String TAG_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TREENODETYPE = "TREENODETYPE";
    public static final String TAG_ENABLEUP = "ENABLEUP";
    public static final String TAG_ROOTNODE = "ROOTNODE";
    public static final String TAG_EXPAND = "EXPAND";
    public static final String TAG_NODEACTION = "NODEACTION";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_NODEVALUE = "NODEVALUE";
    public static final String TAG_APPENDPNODEID = "APPENDPNODEID";
    public static final String TAG_ENABLECHECK = "ENABLECHECK";
    public static final String TAG_CHECKED = "CHECKED";
    public static final String TAG_DISTINCTMODE = "DISTINCTMODE";
    public static final String TAG_CMREMOVE = "CMREMOVE";
    public static final String TAG_CMREFRESH = "CMREFRESH";
    public static final String TAG_NODETYPE = "NODETYPE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_SORTPSDEFID = "SORTPSDEFID";
    public static final String TAG_SORTPSDEFNAME = "SORTPSDEFNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String TAG_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";
    public static final String TAG_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String TAG_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_NAVVIEWPARAM = "NAVVIEWPARAM";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_ICONPSDEFID = "ICONPSDEFID";
    public static final String TAG_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String TAG_CHILDCNTPSDEFID = "CHILDCNTPSDEFID";
    public static final String TAG_CHILDCNTPSDEFNAME = "CHILDCNTPSDEFNAME";
    public static final String TAG_NODEIDPSDEFID = "NODEIDPSDEFID";
    public static final String TAG_NODEIDPSDEFNAME = "NODEIDPSDEFNAME";
    public static final String TAG_NODEID2PSDEFID = "NODEID2PSDEFID";
    public static final String TAG_NODEID2PSDEFNAME = "NODEID2PSDEFNAME";
    public static final String TAG_NODEID3PSDEFID = "NODEID3PSDEFID";
    public static final String TAG_NODEID3PSDEFNAME = "NODEID3PSDEFNAME";
    public static final String TAG_NODEID4PSDEFID = "NODEID4PSDEFID";
    public static final String TAG_NODEID4PSDEFNAME = "NODEID4PSDEFNAME";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String TAG_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String TAG_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String TAG_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String TAG_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String TAG_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_NODEDATATYPE = "NODEDATATYPE";
    public static final String TAG_DATATYPEPSDEFID = "DATATYPEPSDEFID";
    public static final String TAG_DATATYPEPSDEFNAME = "DATATYPEPSDEFNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_LEAFFLAGPSDEFID = "LEAFFLAGPSDEFID";
    public static final String TAG_LEAFFLAGPSDEFNAME = "LEAFFLAGPSDEFNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_ENABLEQUICKSEARCH = "ENABLEQUICKSEARCH";
    public static final String TAG_MODELOBJ = "MODELOBJ";
    public static final String TAG_MAXSIZE = "MAXSIZE";
    public static final String TAG_TIPSPSDEFID = "TIPSPSDEFID";
    public static final String TAG_TIPSPSDEFNAME = "TIPSPSDEFNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_APPENDCAPFLAG = "APPENDCAPFLAG";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_NAVVIEWFILTER = "NAVVIEWFILTER";
    public static final String TAG_NAVVIEWFILTERDESC = "NAVVIEWFILTERDESC";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_DISABLESELECT = "DISABLESELECT";
    public static final String TAG_SELECTED = "SELECTED";
    public static final String TAG_NEWDATAMODE = "NEWDATAMODE";
    public static final String TAG_EDITDATAMODE = "EDITDATAMODE";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_EDITMODE = "EDITMODE";
    public static final String TAG_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String TAG_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_CLSPSDEFID = "CLSPSDEFID";
    public static final String TAG_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_LINKPSDEFID = "LINKPSDEFID";
    public static final String TAG_LINKPSDEFNAME = "LINKPSDEFNAME";
    public static final String TAG_DATA2PSDEFID = "DATA2PSDEFID";
    public static final String TAG_DATA2PSDEFNAME = "DATA2PSDEFNAME";
    public static final String TAG_DATAPSDEFID = "DATAPSDEFID";
    public static final String TAG_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_ENABLEPAGING = "ENABLEPAGING";
    public static final String TAG_SHAPEDYNACLASS = "SHAPEDYNACLASS";
    public static final String TAG_SHAPEPSSYSCSSID = "SHAPEPSSYSCSSID";
    public static final String TAG_SHAPEPSSYSCSSNAME = "SHAPEPSSYSCSSNAME";
    public static final String TAG_SHAPECLSPSDEFID = "SHAPECLSPSDEFID";
    public static final String TAG_SHAPECLSPSDEFNAME = "SHAPECLSPSDEFNAME";
    public static final String TAG_MOVEPSDEOPPRIVID = "MOVEPSDEOPPRIVID";
    public static final String TAG_MOVEPSDEOPPRIVNAME = "MOVEPSDEOPPRIVNAME";
    public static final String TAG_MOVEPSDEACTIONID = "MOVEPSDEACTIONID";
    public static final String TAG_MOVEPSDEACTIONNAME = "MOVEPSDEACTIONNAME";
    public static final String TAG_DATASOURCE = "DATASOURCE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_FIELDNAME = "FIELDNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    private ArrayList<PSDETreeNodeRV> psDETreeNodeRVList = null;
    private ArrayList<PSDETreeNodeColumn> psDETreeNodeColumnList = null;

    public final boolean isPSDETREENODEIDNull() {
        return this.IsParamNull(TAG_PSDETREENODEID);
    }

    public final String getPSDETREENODEID() {
        return this.GetParamStringValue(TAG_PSDETREENODEID, "");
    }

    public final void setPSDETREENODEID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODEID, strValue);
    }

    public final boolean isPSDETREENODENAMENull() {
        return this.IsParamNull(TAG_PSDETREENODENAME);
    }

    public final String getPSDETREENODENAME() {
        return this.GetParamStringValue(TAG_PSDETREENODENAME, "");
    }

    public final void setPSDETREENODENAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODENAME, strValue);
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

    public final boolean isTREENODETYPENull() {
        return this.IsParamNull(TAG_TREENODETYPE);
    }

    public final String getTREENODETYPE() {
        return this.GetParamStringValue(TAG_TREENODETYPE, "");
    }

    public final void setTREENODETYPE(String strValue) {
        this.SetParamValue(TAG_TREENODETYPE, strValue);
    }

    public final boolean isENABLEUPNull() {
        return this.IsParamNull(TAG_ENABLEUP);
    }

    public final boolean getENABLEUP() {
        return this.GetParamIntValue(TAG_ENABLEUP, 0) == 1;
    }

    public final void setENABLEUP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUP, bValue ? 1 : 0);
    }

    public final boolean isROOTNODENull() {
        return this.IsParamNull(TAG_ROOTNODE);
    }

    public final boolean getROOTNODE() {
        return this.GetParamIntValue(TAG_ROOTNODE, 0) == 1;
    }

    public final void setROOTNODE(boolean bValue) {
        this.SetParamValue(TAG_ROOTNODE, bValue ? 1 : 0);
    }

    public final boolean isEXPANDNull() {
        return this.IsParamNull(TAG_EXPAND);
    }

    public final int getEXPAND() {
        return this.GetParamIntValue(TAG_EXPAND, 0);
    }

    public final void setEXPAND(boolean bValue) {
        this.SetParamValue(TAG_EXPAND, bValue ? 1 : 0);
    }

    public final boolean isNODEACTIONNull() {
        return this.IsParamNull(TAG_NODEACTION);
    }

    public final String getNODEACTION() {
        return this.GetParamStringValue(TAG_NODEACTION, "");
    }

    public final void setNODEACTION(String strValue) {
        this.SetParamValue(TAG_NODEACTION, strValue);
    }

    public final boolean isACTIONPARAMNull() {
        return this.IsParamNull(TAG_ACTIONPARAM);
    }

    public final String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public final void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public final boolean isNODEVALUENull() {
        return this.IsParamNull(TAG_NODEVALUE);
    }

    public final String getNODEVALUE() {
        return this.GetParamStringValue(TAG_NODEVALUE, "");
    }

    public final void setNODEVALUE(String strValue) {
        this.SetParamValue(TAG_NODEVALUE, strValue);
    }

    public final boolean isAPPENDPNODEIDNull() {
        return this.IsParamNull(TAG_APPENDPNODEID);
    }

    public final boolean getAPPENDPNODEID() {
        return this.GetParamIntValue(TAG_APPENDPNODEID, 0) == 1;
    }

    public final void setAPPENDPNODEID(boolean bValue) {
        this.SetParamValue(TAG_APPENDPNODEID, bValue ? 1 : 0);
    }

    public final boolean isENABLECHECKNull() {
        return this.IsParamNull(TAG_ENABLECHECK);
    }

    public final boolean getENABLECHECK() {
        return this.GetParamIntValue(TAG_ENABLECHECK, 0) == 1;
    }

    public final void setENABLECHECK(boolean bValue) {
        this.SetParamValue(TAG_ENABLECHECK, bValue ? 1 : 0);
    }

    public final boolean isCHECKEDNull() {
        return this.IsParamNull(TAG_CHECKED);
    }

    public final boolean getCHECKED() {
        return this.GetParamIntValue(TAG_CHECKED, 0) == 1;
    }

    public final void setCHECKED(boolean bValue) {
        this.SetParamValue(TAG_CHECKED, bValue ? 1 : 0);
    }

    public final boolean isDISTINCTMODENull() {
        return this.IsParamNull(TAG_DISTINCTMODE);
    }

    public final boolean getDISTINCTMODE() {
        return this.GetParamIntValue(TAG_DISTINCTMODE, 0) == 1;
    }

    public final void setDISTINCTMODE(boolean bValue) {
        this.SetParamValue(TAG_DISTINCTMODE, bValue ? 1 : 0);
    }

    public final boolean isCMREMOVENull() {
        return this.IsParamNull(TAG_CMREMOVE);
    }

    public final boolean getCMREMOVE() {
        return this.GetParamIntValue(TAG_CMREMOVE, 0) == 1;
    }

    public final void setCMREMOVE(boolean bValue) {
        this.SetParamValue(TAG_CMREMOVE, bValue ? 1 : 0);
    }

    public final boolean isCMREFRESHNull() {
        return this.IsParamNull(TAG_CMREFRESH);
    }

    public final boolean getCMREFRESH() {
        return this.GetParamIntValue(TAG_CMREFRESH, 0) == 1;
    }

    public final void setCMREFRESH(boolean bValue) {
        this.SetParamValue(TAG_CMREFRESH, bValue ? 1 : 0);
    }

    public final boolean isNODETYPENull() {
        return this.IsParamNull(TAG_NODETYPE);
    }

    public final String getNODETYPE() {
        return this.GetParamStringValue(TAG_NODETYPE, "");
    }

    public final void setNODETYPE(String strValue) {
        this.SetParamValue(TAG_NODETYPE, strValue);
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

    public final boolean isSORTPSDEFIDNull() {
        return this.IsParamNull(TAG_SORTPSDEFID);
    }

    public final String getSORTPSDEFID() {
        return this.GetParamStringValue(TAG_SORTPSDEFID, "");
    }

    public final void setSORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_SORTPSDEFID, strValue);
    }

    public final boolean isSORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_SORTPSDEFNAME);
    }

    public final String getSORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_SORTPSDEFNAME, "");
    }

    public final void setSORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SORTPSDEFNAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isKEYPSDEFIDNull() {
        return this.IsParamNull(TAG_KEYPSDEFID);
    }

    public final String getKEYPSDEFID() {
        return this.GetParamStringValue(TAG_KEYPSDEFID, "");
    }

    public final void setKEYPSDEFID(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFID, strValue);
    }

    public final boolean isKEYPSDEFNAMENull() {
        return this.IsParamNull(TAG_KEYPSDEFNAME);
    }

    public final String getKEYPSDEFNAME() {
        return this.GetParamStringValue(TAG_KEYPSDEFNAME, "");
    }

    public final void setKEYPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFNAME, strValue);
    }

    public final boolean isFILTERPSDEDSIDNull() {
        return this.IsParamNull(TAG_FILTERPSDEDSID);
    }

    public final String getFILTERPSDEDSID() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSID, "");
    }

    public final void setFILTERPSDEDSID(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSID, strValue);
    }

    public final boolean isFILTERPSDEDSNAMENull() {
        return this.IsParamNull(TAG_FILTERPSDEDSNAME);
    }

    public final String getFILTERPSDEDSNAME() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSNAME, "");
    }

    public final void setFILTERPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isSORTDIRNull() {
        return this.IsParamNull(TAG_SORTDIR);
    }

    public final String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public final void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
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

    public final boolean isNAVVIEWPARAMNull() {
        return this.IsParamNull(TAG_NAVVIEWPARAM);
    }

    public final String getNAVVIEWPARAM() {
        return this.GetParamStringValue(TAG_NAVVIEWPARAM, "");
    }

    public final void setNAVVIEWPARAM(String strValue) {
        this.SetParamValue(TAG_NAVVIEWPARAM, strValue);
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

    public final boolean isICONPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONPSDEFID);
    }

    public final String getICONPSDEFID() {
        return this.GetParamStringValue(TAG_ICONPSDEFID, "");
    }

    public final void setICONPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFID, strValue);
    }

    public final boolean isICONPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONPSDEFNAME);
    }

    public final String getICONPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONPSDEFNAME, "");
    }

    public final void setICONPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFNAME, strValue);
    }

    public final boolean isCHILDCNTPSDEFIDNull() {
        return this.IsParamNull(TAG_CHILDCNTPSDEFID);
    }

    public final String getCHILDCNTPSDEFID() {
        return this.GetParamStringValue(TAG_CHILDCNTPSDEFID, "");
    }

    public final void setCHILDCNTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CHILDCNTPSDEFID, strValue);
    }

    public final boolean isCHILDCNTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CHILDCNTPSDEFNAME);
    }

    public final String getCHILDCNTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CHILDCNTPSDEFNAME, "");
    }

    public final void setCHILDCNTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CHILDCNTPSDEFNAME, strValue);
    }

    public final boolean isNODEIDPSDEFIDNull() {
        return this.IsParamNull(TAG_NODEIDPSDEFID);
    }

    public final String getNODEIDPSDEFID() {
        return this.GetParamStringValue(TAG_NODEIDPSDEFID, "");
    }

    public final void setNODEIDPSDEFID(String strValue) {
        this.SetParamValue(TAG_NODEIDPSDEFID, strValue);
    }

    public final boolean isNODEIDPSDEFNAMENull() {
        return this.IsParamNull(TAG_NODEIDPSDEFNAME);
    }

    public final String getNODEIDPSDEFNAME() {
        return this.GetParamStringValue(TAG_NODEIDPSDEFNAME, "");
    }

    public final void setNODEIDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NODEIDPSDEFNAME, strValue);
    }

    public final boolean isNODEID2PSDEFIDNull() {
        return this.IsParamNull(TAG_NODEID2PSDEFID);
    }

    public final String getNODEID2PSDEFID() {
        return this.GetParamStringValue(TAG_NODEID2PSDEFID, "");
    }

    public final void setNODEID2PSDEFID(String strValue) {
        this.SetParamValue(TAG_NODEID2PSDEFID, strValue);
    }

    public final boolean isNODEID2PSDEFNAMENull() {
        return this.IsParamNull(TAG_NODEID2PSDEFNAME);
    }

    public final String getNODEID2PSDEFNAME() {
        return this.GetParamStringValue(TAG_NODEID2PSDEFNAME, "");
    }

    public final void setNODEID2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NODEID2PSDEFNAME, strValue);
    }

    public final boolean isNODEID3PSDEFIDNull() {
        return this.IsParamNull(TAG_NODEID3PSDEFID);
    }

    public final String getNODEID3PSDEFID() {
        return this.GetParamStringValue(TAG_NODEID3PSDEFID, "");
    }

    public final void setNODEID3PSDEFID(String strValue) {
        this.SetParamValue(TAG_NODEID3PSDEFID, strValue);
    }

    public final boolean isNODEID3PSDEFNAMENull() {
        return this.IsParamNull(TAG_NODEID3PSDEFNAME);
    }

    public final String getNODEID3PSDEFNAME() {
        return this.GetParamStringValue(TAG_NODEID3PSDEFNAME, "");
    }

    public final void setNODEID3PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NODEID3PSDEFNAME, strValue);
    }

    public final boolean isNODEID4PSDEFIDNull() {
        return this.IsParamNull(TAG_NODEID4PSDEFID);
    }

    public final String getNODEID4PSDEFID() {
        return this.GetParamStringValue(TAG_NODEID4PSDEFID, "");
    }

    public final void setNODEID4PSDEFID(String strValue) {
        this.SetParamValue(TAG_NODEID4PSDEFID, strValue);
    }

    public final boolean isNODEID4PSDEFNAMENull() {
        return this.IsParamNull(TAG_NODEID4PSDEFNAME);
    }

    public final String getNODEID4PSDEFNAME() {
        return this.GetParamStringValue(TAG_NODEID4PSDEFNAME, "");
    }

    public final void setNODEID4PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NODEID4PSDEFNAME, strValue);
    }

    public final boolean isPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARNAME, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVID);
    }

    public final String getREMOVEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVID, "");
    }

    public final void setREMOVEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVID, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVNAME);
    }

    public final String getREMOVEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVNAME, "");
    }

    public final void setREMOVEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVNAME, strValue);
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

    public final boolean isNAMEPSLANRESIDNull() {
        return this.IsParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESNAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
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

    public final boolean isCOUNTERMODENull() {
        return this.IsParamNull(TAG_COUNTERMODE);
    }

    public final int getCOUNTERMODE() {
        return this.GetParamIntValue(TAG_COUNTERMODE, 0);
    }

    public final void setCOUNTERMODE(int nValue) {
        this.SetParamValue(TAG_COUNTERMODE, nValue);
    }

    public final boolean isNODEDATATYPENull() {
        return this.IsParamNull(TAG_NODEDATATYPE);
    }

    public final String getNODEDATATYPE() {
        return this.GetParamStringValue(TAG_NODEDATATYPE, "");
    }

    public final void setNODEDATATYPE(String strValue) {
        this.SetParamValue(TAG_NODEDATATYPE, strValue);
    }

    public final boolean isDATATYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_DATATYPEPSDEFID);
    }

    public final String getDATATYPEPSDEFID() {
        return this.GetParamStringValue(TAG_DATATYPEPSDEFID, "");
    }

    public final void setDATATYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_DATATYPEPSDEFID, strValue);
    }

    public final boolean isDATATYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_DATATYPEPSDEFNAME);
    }

    public final String getDATATYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_DATATYPEPSDEFNAME, "");
    }

    public final void setDATATYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATATYPEPSDEFNAME, strValue);
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

    public final boolean isPREVENTXSSNull() {
        return this.IsParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.GetParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.SetParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isLEAFFLAGPSDEFIDNull() {
        return this.IsParamNull(TAG_LEAFFLAGPSDEFID);
    }

    public final String getLEAFFLAGPSDEFID() {
        return this.GetParamStringValue(TAG_LEAFFLAGPSDEFID, "");
    }

    public final void setLEAFFLAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_LEAFFLAGPSDEFID, strValue);
    }

    public final boolean isLEAFFLAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_LEAFFLAGPSDEFNAME);
    }

    public final String getLEAFFLAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_LEAFFLAGPSDEFNAME, "");
    }

    public final void setLEAFFLAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LEAFFLAGPSDEFNAME, strValue);
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

    public final boolean isENABLEQUICKSEARCHNull() {
        return this.IsParamNull(TAG_ENABLEQUICKSEARCH);
    }

    public final boolean getENABLEQUICKSEARCH() {
        return this.GetParamIntValue(TAG_ENABLEQUICKSEARCH, 0) == 1;
    }

    public final void setENABLEQUICKSEARCH(boolean bValue) {
        this.SetParamValue(TAG_ENABLEQUICKSEARCH, bValue ? 1 : 0);
    }

    public final boolean isMODELOBJNull() {
        return this.IsParamNull(TAG_MODELOBJ);
    }

    public final String getMODELOBJ() {
        return this.GetParamStringValue(TAG_MODELOBJ, "");
    }

    public final void setMODELOBJ(String strValue) {
        this.SetParamValue(TAG_MODELOBJ, strValue);
    }

    public final boolean isMAXSIZENull() {
        return this.IsParamNull(TAG_MAXSIZE);
    }

    public final int getMAXSIZE() {
        return this.GetParamIntValue(TAG_MAXSIZE, 0);
    }

    public final void setMAXSIZE(int nValue) {
        this.SetParamValue(TAG_MAXSIZE, nValue);
    }

    public final boolean isTIPSPSDEFIDNull() {
        return this.IsParamNull(TAG_TIPSPSDEFID);
    }

    public final String getTIPSPSDEFID() {
        return this.GetParamStringValue(TAG_TIPSPSDEFID, "");
    }

    public final void setTIPSPSDEFID(String strValue) {
        this.SetParamValue(TAG_TIPSPSDEFID, strValue);
    }

    public final boolean isTIPSPSDEFNAMENull() {
        return this.IsParamNull(TAG_TIPSPSDEFNAME);
    }

    public final String getTIPSPSDEFNAME() {
        return this.GetParamStringValue(TAG_TIPSPSDEFNAME, "");
    }

    public final void setTIPSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIPSPSDEFNAME, strValue);
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

    public final boolean isAPPENDCAPFLAGNull() {
        return this.IsParamNull(TAG_APPENDCAPFLAG);
    }

    public final boolean getAPPENDCAPFLAG() {
        return this.GetParamIntValue(TAG_APPENDCAPFLAG, 0) == 1;
    }

    public final void setAPPENDCAPFLAG(boolean bValue) {
        this.SetParamValue(TAG_APPENDCAPFLAG, bValue ? 1 : 0);
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

    public final boolean isNAVVIEWFILTERNull() {
        return this.IsParamNull(TAG_NAVVIEWFILTER);
    }

    public final String getNAVVIEWFILTER() {
        return this.GetParamStringValue(TAG_NAVVIEWFILTER, "");
    }

    public final void setNAVVIEWFILTER(String strValue) {
        this.SetParamValue(TAG_NAVVIEWFILTER, strValue);
    }

    public final boolean isNAVVIEWFILTERDESCNull() {
        return this.IsParamNull(TAG_NAVVIEWFILTERDESC);
    }

    public final String getNAVVIEWFILTERDESC() {
        return this.GetParamStringValue(TAG_NAVVIEWFILTERDESC, "");
    }

    public final void setNAVVIEWFILTERDESC(String strValue) {
        this.SetParamValue(TAG_NAVVIEWFILTERDESC, strValue);
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

    public final boolean isDISABLESELECTNull() {
        return this.IsParamNull(TAG_DISABLESELECT);
    }

    public final boolean getDISABLESELECT() {
        return this.GetParamIntValue(TAG_DISABLESELECT, 0) == 1;
    }

    public final void setDISABLESELECT(boolean bValue) {
        this.SetParamValue(TAG_DISABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isSELECTEDNull() {
        return this.IsParamNull(TAG_SELECTED);
    }

    public final int getSELECTED() {
        return this.GetParamIntValue(TAG_SELECTED, 0);
    }

    public final void setSELECTED(boolean bValue) {
        this.SetParamValue(TAG_SELECTED, bValue ? 1 : 0);
    }

    public final boolean isNEWDATAMODENull() {
        return this.IsParamNull(TAG_NEWDATAMODE);
    }

    public final String getNEWDATAMODE() {
        return this.GetParamStringValue(TAG_NEWDATAMODE, "");
    }

    public final void setNEWDATAMODE(String strValue) {
        this.SetParamValue(TAG_NEWDATAMODE, strValue);
    }

    public final boolean isEDITDATAMODENull() {
        return this.IsParamNull(TAG_EDITDATAMODE);
    }

    public final String getEDITDATAMODE() {
        return this.GetParamStringValue(TAG_EDITDATAMODE, "");
    }

    public final void setEDITDATAMODE(String strValue) {
        this.SetParamValue(TAG_EDITDATAMODE, strValue);
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

    public final boolean isEDITMODENull() {
        return this.IsParamNull(TAG_EDITMODE);
    }

    public final int getEDITMODE() {
        return this.GetParamIntValue(TAG_EDITMODE, 0);
    }

    public final void setEDITMODE(int nValue) {
        this.SetParamValue(TAG_EDITMODE, nValue);
    }

    public final boolean isCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_CLSPSDEFID);
    }

    public final String getCLSPSDEFID() {
        return this.GetParamStringValue(TAG_CLSPSDEFID, "");
    }

    public final void setCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFID, strValue);
    }

    public final boolean isCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_CLSPSDEFNAME);
    }

    public final String getCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_CLSPSDEFNAME, "");
    }

    public final void setCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFNAME, strValue);
    }

    public final boolean isDYNACLASSNull() {
        return this.IsParamNull(TAG_DYNACLASS);
    }

    public final String getDYNACLASS() {
        return this.GetParamStringValue(TAG_DYNACLASS, "");
    }

    public final void setDYNACLASS(String strValue) {
        this.SetParamValue(TAG_DYNACLASS, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isLINKPSDEFIDNull() {
        return this.IsParamNull(TAG_LINKPSDEFID);
    }

    public final String getLINKPSDEFID() {
        return this.GetParamStringValue(TAG_LINKPSDEFID, "");
    }

    public final void setLINKPSDEFID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFID, strValue);
    }

    public final boolean isLINKPSDEFNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEFNAME);
    }

    public final String getLINKPSDEFNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEFNAME, "");
    }

    public final void setLINKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFNAME, strValue);
    }

    public final boolean isDATA2PSDEFIDNull() {
        return this.IsParamNull(TAG_DATA2PSDEFID);
    }

    public final String getDATA2PSDEFID() {
        return this.GetParamStringValue(TAG_DATA2PSDEFID, "");
    }

    public final void setDATA2PSDEFID(String strValue) {
        this.SetParamValue(TAG_DATA2PSDEFID, strValue);
    }

    public final boolean isDATA2PSDEFNAMENull() {
        return this.IsParamNull(TAG_DATA2PSDEFNAME);
    }

    public final String getDATA2PSDEFNAME() {
        return this.GetParamStringValue(TAG_DATA2PSDEFNAME, "");
    }

    public final void setDATA2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATA2PSDEFNAME, strValue);
    }

    public final boolean isDATAPSDEFIDNull() {
        return this.IsParamNull(TAG_DATAPSDEFID);
    }

    public final String getDATAPSDEFID() {
        return this.GetParamStringValue(TAG_DATAPSDEFID, "");
    }

    public final void setDATAPSDEFID(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFID, strValue);
    }

    public final boolean isDATAPSDEFNAMENull() {
        return this.IsParamNull(TAG_DATAPSDEFNAME);
    }

    public final String getDATAPSDEFNAME() {
        return this.GetParamStringValue(TAG_DATAPSDEFNAME, "");
    }

    public final void setDATAPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFNAME, strValue);
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

    public final boolean isENABLEPAGINGNull() {
        return this.IsParamNull(TAG_ENABLEPAGING);
    }

    public final boolean getENABLEPAGING() {
        return this.GetParamIntValue(TAG_ENABLEPAGING, 0) == 1;
    }

    public final void setENABLEPAGING(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPAGING, bValue ? 1 : 0);
    }

    public final boolean isSHAPEDYNACLASSNull() {
        return this.IsParamNull(TAG_SHAPEDYNACLASS);
    }

    public final String getSHAPEDYNACLASS() {
        return this.GetParamStringValue(TAG_SHAPEDYNACLASS, "");
    }

    public final void setSHAPEDYNACLASS(String strValue) {
        this.SetParamValue(TAG_SHAPEDYNACLASS, strValue);
    }

    public final boolean isSHAPEPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_SHAPEPSSYSCSSID);
    }

    public final String getSHAPEPSSYSCSSID() {
        return this.GetParamStringValue(TAG_SHAPEPSSYSCSSID, "");
    }

    public final void setSHAPEPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_SHAPEPSSYSCSSID, strValue);
    }

    public final boolean isSHAPEPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_SHAPEPSSYSCSSNAME);
    }

    public final String getSHAPEPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_SHAPEPSSYSCSSNAME, "");
    }

    public final void setSHAPEPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_SHAPEPSSYSCSSNAME, strValue);
    }

    public final boolean isSHAPECLSPSDEFIDNull() {
        return this.IsParamNull(TAG_SHAPECLSPSDEFID);
    }

    public final String getSHAPECLSPSDEFID() {
        return this.GetParamStringValue(TAG_SHAPECLSPSDEFID, "");
    }

    public final void setSHAPECLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_SHAPECLSPSDEFID, strValue);
    }

    public final boolean isSHAPECLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_SHAPECLSPSDEFNAME);
    }

    public final String getSHAPECLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_SHAPECLSPSDEFNAME, "");
    }

    public final void setSHAPECLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SHAPECLSPSDEFNAME, strValue);
    }

    public final boolean isMOVEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_MOVEPSDEOPPRIVID);
    }

    public final String getMOVEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_MOVEPSDEOPPRIVID, "");
    }

    public final void setMOVEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEOPPRIVID, strValue);
    }

    public final boolean isMOVEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_MOVEPSDEOPPRIVNAME);
    }

    public final String getMOVEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_MOVEPSDEOPPRIVNAME, "");
    }

    public final void setMOVEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_MOVEPSDEOPPRIVNAME, strValue);
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

    public final boolean isDATASOURCENull() {
        return this.IsParamNull(TAG_DATASOURCE);
    }

    public final String getDATASOURCE() {
        return this.GetParamStringValue(TAG_DATASOURCE, "");
    }

    public final void setDATASOURCE(String strValue) {
        this.SetParamValue(TAG_DATASOURCE, strValue);
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

    public final boolean isFIELDNAMENull() {
        return this.IsParamNull(TAG_FIELDNAME);
    }

    public final String getFIELDNAME() {
        return this.GetParamStringValue(TAG_FIELDNAME, "");
    }

    public final void setFIELDNAME(String strValue) {
        this.SetParamValue(TAG_FIELDNAME, strValue);
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

    public ArrayList<PSDETreeNodeRV> getPSDETreeNodeRVs(boolean bCreated) {
        if (this.psDETreeNodeRVList != null) {
            return this.psDETreeNodeRVList;
        }
        if (bCreated) {
            this.psDETreeNodeRVList = new ArrayList();
        }
        return this.psDETreeNodeRVList;
    }

    public ArrayList<PSDETreeNodeColumn> getPSDETreeNodeColumns(boolean bCreated) {
        if (this.psDETreeNodeColumnList != null) {
            return this.psDETreeNodeColumnList;
        }
        if (bCreated) {
            this.psDETreeNodeColumnList = new ArrayList();
        }
        return this.psDETreeNodeColumnList;
    }

    public void resetChildDatas() {
        if (this.psDETreeNodeRVList != null) {
            this.psDETreeNodeRVList.clear();
            this.psDETreeNodeRVList = null;
        }
        if (this.psDETreeNodeColumnList != null) {
            this.psDETreeNodeColumnList.clear();
            this.psDETreeNodeColumnList = null;
        }
    }
}

