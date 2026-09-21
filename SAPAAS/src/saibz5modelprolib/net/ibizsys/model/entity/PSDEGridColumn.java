/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEGridColumn
extends BaseDataEntity {
    public static final String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";
    public static final String GRIDCOLTYPE_UAGRIDCOLUMN = "UAGRIDCOLUMN";
    public static final String WIDTHUNIT_PX = "PX";
    public static final String WIDTHUNIT_STAR = "STAR";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";
    public static final String GROUPITEM_GROUP1 = "GROUP1";
    public static final String GROUPITEM_GROUP2 = "GROUP2";
    public static final String GROUPITEM_GROUP3 = "GROUP3";
    public static final String GROUPITEM_GROUP4 = "GROUP4";
    public static final int CODELISTCONFIGMODE_NONE = 0;
    public static final int CODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int CODELISTCONFIGMODE_INCLUDECHILD = 2;
    public static final String GRIDCOLSTYLE_USER = "USER";
    public static final String GRIDCOLSTYLE_USER2 = "USER2";
    public static final String TAG_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String TAG_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_GRIDCOLTYPE = "GRIDCOLTYPE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_WIDTHUNIT = "WIDTHUNIT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSDEFGRIDCOLID = "PSDEFGRIDCOLID";
    public static final String TAG_PSDEFGRIDCOLNAME = "PSDEFGRIDCOLNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEFUIMODEID = "PSDEFUIMODEID";
    public static final String TAG_PSDEFUIMODENAME = "PSDEFUIMODENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String TAG_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String TAG_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_HIDEDEFAULT = "HIDEDEFAULT";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_DATAITEMS = "DATAITEMS";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_ENABLEROWEDIT = "ENABLEROWEDIT";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_EDITORPARAMS = "EDITORPARAMS";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String TAG_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String TAG_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_CREATEDV = "CREATEDV";
    public static final String TAG_CREATEDVT = "CREATEDVT";
    public static final String TAG_UPDATEDV = "UPDATEDV";
    public static final String TAG_UPDATEDVT = "UPDATEDVT";
    public static final String TAG_IGNOREINPUT = "IGNOREINPUT";
    public static final String TAG_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String TAG_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_PPSDEGRIDCOLID = "PPSDEGRIDCOLID";
    public static final String TAG_PPSDEGRIDCOLNAME = "PPSDEGRIDCOLNAME";
    public static final String TAG_GROUPITEM = "GROUPITEM";
    public static final String TAG_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String TAG_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_HEADERPSSYSCSSID = "HEADERPSSYSCSSID";
    public static final String TAG_HEADERPSSYSCSSNAME = "HEADERPSSYSCSSNAME";
    public static final String TAG_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String TAG_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    private ArrayList<PSDEGridColumn> childPSDEGridColumnList = null;

    public final boolean isPSDEGRIDCOLIDNull() {
        return this.isParamNull(TAG_PSDEGRIDCOLID);
    }

    public final String getPSDEGRIDCOLID() {
        return this.getParamStringValue(TAG_PSDEGRIDCOLID, "");
    }

    public final void setPSDEGRIDCOLID(String strValue) {
        this.setParamValue(TAG_PSDEGRIDCOLID, strValue);
    }

    public final boolean isPSDEGRIDCOLNAMENull() {
        return this.isParamNull(TAG_PSDEGRIDCOLNAME);
    }

    public final String getPSDEGRIDCOLNAME() {
        return this.getParamStringValue(TAG_PSDEGRIDCOLNAME, "");
    }

    public final void setPSDEGRIDCOLNAME(String strValue) {
        this.setParamValue(TAG_PSDEGRIDCOLNAME, strValue);
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

    public final boolean isGRIDCOLTYPENull() {
        return this.isParamNull(TAG_GRIDCOLTYPE);
    }

    public final String getGRIDCOLTYPE() {
        return this.getParamStringValue(TAG_GRIDCOLTYPE, "");
    }

    public final void setGRIDCOLTYPE(String strValue) {
        this.setParamValue(TAG_GRIDCOLTYPE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isWIDTHUNITNull() {
        return this.isParamNull(TAG_WIDTHUNIT);
    }

    public final String getWIDTHUNIT() {
        return this.getParamStringValue(TAG_WIDTHUNIT, "");
    }

    public final void setWIDTHUNIT(String strValue) {
        this.setParamValue(TAG_WIDTHUNIT, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPSDEFGRIDCOLIDNull() {
        return this.isParamNull(TAG_PSDEFGRIDCOLID);
    }

    public final String getPSDEFGRIDCOLID() {
        return this.getParamStringValue(TAG_PSDEFGRIDCOLID, "");
    }

    public final void setPSDEFGRIDCOLID(String strValue) {
        this.setParamValue(TAG_PSDEFGRIDCOLID, strValue);
    }

    public final boolean isPSDEFGRIDCOLNAMENull() {
        return this.isParamNull(TAG_PSDEFGRIDCOLNAME);
    }

    public final String getPSDEFGRIDCOLNAME() {
        return this.getParamStringValue(TAG_PSDEFGRIDCOLNAME, "");
    }

    public final void setPSDEFGRIDCOLNAME(String strValue) {
        this.setParamValue(TAG_PSDEFGRIDCOLNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEFUIMODEIDNull() {
        return this.isParamNull(TAG_PSDEFUIMODEID);
    }

    public final String getPSDEFUIMODEID() {
        return this.getParamStringValue(TAG_PSDEFUIMODEID, "");
    }

    public final void setPSDEFUIMODEID(String strValue) {
        this.setParamValue(TAG_PSDEFUIMODEID, strValue);
    }

    public final boolean isPSDEFUIMODENAMENull() {
        return this.isParamNull(TAG_PSDEFUIMODENAME);
    }

    public final String getPSDEFUIMODENAME() {
        return this.getParamStringValue(TAG_PSDEFUIMODENAME, "");
    }

    public final void setPSDEFUIMODENAME(String strValue) {
        this.setParamValue(TAG_PSDEFUIMODENAME, strValue);
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

    public final boolean isNOSORTNull() {
        return this.isParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.getParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.setParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isHIDDENDATAITEMNull() {
        return this.isParamNull(TAG_HIDDENDATAITEM);
    }

    public final boolean getHIDDENDATAITEM() {
        return this.getParamIntValue(TAG_HIDDENDATAITEM, 0) == 1;
    }

    public final void setHIDDENDATAITEM(boolean bValue) {
        this.setParamValue(TAG_HIDDENDATAITEM, bValue ? 1 : 0);
    }

    public final boolean isALIGNNull() {
        return this.isParamNull(TAG_ALIGN);
    }

    public final String getALIGN() {
        return this.getParamStringValue(TAG_ALIGN, "");
    }

    public final void setALIGN(String strValue) {
        this.setParamValue(TAG_ALIGN, strValue);
    }

    public final boolean isHIDEDEFAULTNull() {
        return this.isParamNull(TAG_HIDEDEFAULT);
    }

    public final boolean getHIDEDEFAULT() {
        return this.getParamIntValue(TAG_HIDEDEFAULT, 0) == 1;
    }

    public final void setHIDEDEFAULT(boolean bValue) {
        this.setParamValue(TAG_HIDEDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isDATAITEMSNull() {
        return this.isParamNull(TAG_DATAITEMS);
    }

    public final String getDATAITEMS() {
        return this.getParamStringValue(TAG_DATAITEMS, "");
    }

    public final void setDATAITEMS(String strValue) {
        this.setParamValue(TAG_DATAITEMS, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.getParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isENABLEROWEDITNull() {
        return this.isParamNull(TAG_ENABLEROWEDIT);
    }

    public final boolean getENABLEROWEDIT() {
        return this.getParamIntValue(TAG_ENABLEROWEDIT, 0) == 1;
    }

    public final void setENABLEROWEDIT(boolean bValue) {
        this.setParamValue(TAG_ENABLEROWEDIT, bValue ? 1 : 0);
    }

    public final boolean isEDITORTYPENull() {
        return this.isParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.getParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.setParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isEDITORPARAMSNull() {
        return this.isParamNull(TAG_EDITORPARAMS);
    }

    public final String getEDITORPARAMS() {
        return this.getParamStringValue(TAG_EDITORPARAMS, "");
    }

    public final void setEDITORPARAMS(String strValue) {
        this.setParamValue(TAG_EDITORPARAMS, strValue);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
    }

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

    public final boolean isPICKUPPSDEVIEWIDNull() {
        return this.isParamNull(TAG_PICKUPPSDEVIEWID);
    }

    public final String getPICKUPPSDEVIEWID() {
        return this.getParamStringValue(TAG_PICKUPPSDEVIEWID, "");
    }

    public final void setPICKUPPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_PICKUPPSDEVIEWID, strValue);
    }

    public final boolean isPICKUPPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_PICKUPPSDEVIEWNAME);
    }

    public final String getPICKUPPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_PICKUPPSDEVIEWNAME, "");
    }

    public final void setPICKUPPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.isParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.getParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isPSDEGEIUPDATEIDNull() {
        return this.isParamNull(TAG_PSDEGEIUPDATEID);
    }

    public final String getPSDEGEIUPDATEID() {
        return this.getParamStringValue(TAG_PSDEGEIUPDATEID, "");
    }

    public final void setPSDEGEIUPDATEID(String strValue) {
        this.setParamValue(TAG_PSDEGEIUPDATEID, strValue);
    }

    public final boolean isPSDEGEIUPDATENAMENull() {
        return this.isParamNull(TAG_PSDEGEIUPDATENAME);
    }

    public final String getPSDEGEIUPDATENAME() {
        return this.getParamStringValue(TAG_PSDEGEIUPDATENAME, "");
    }

    public final void setPSDEGEIUPDATENAME(String strValue) {
        this.setParamValue(TAG_PSDEGEIUPDATENAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.isParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.getParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.setParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isENABLECONDNull() {
        return this.isParamNull(TAG_ENABLECOND);
    }

    public final int getENABLECOND() {
        return this.getParamIntValue(TAG_ENABLECOND, 0);
    }

    public final void setENABLECOND(int nValue) {
        this.setParamValue(TAG_ENABLECOND, nValue);
    }

    public final boolean isPLACEHOLDERNull() {
        return this.isParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.getParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.setParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isCREATEDVNull() {
        return this.isParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.getParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.setParamValue(TAG_CREATEDV, strValue);
    }

    public final boolean isCREATEDVTNull() {
        return this.isParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.getParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.setParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isUPDATEDVNull() {
        return this.isParamNull(TAG_UPDATEDV);
    }

    public final String getUPDATEDV() {
        return this.getParamStringValue(TAG_UPDATEDV, "");
    }

    public final void setUPDATEDV(String strValue) {
        this.setParamValue(TAG_UPDATEDV, strValue);
    }

    public final boolean isUPDATEDVTNull() {
        return this.isParamNull(TAG_UPDATEDVT);
    }

    public final String getUPDATEDVT() {
        return this.getParamStringValue(TAG_UPDATEDVT, "");
    }

    public final void setUPDATEDVT(String strValue) {
        this.setParamValue(TAG_UPDATEDVT, strValue);
    }

    public final boolean isIGNOREINPUTNull() {
        return this.isParamNull(TAG_IGNOREINPUT);
    }

    public final int getIGNOREINPUT() {
        return this.getParamIntValue(TAG_IGNOREINPUT, 0);
    }

    public final void setIGNOREINPUT(int nValue) {
        this.setParamValue(TAG_IGNOREINPUT, nValue);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.isParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.getParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.setParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isRESETITEMNAMENull() {
        return this.isParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.getParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.setParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isPSSYSDICTCATIDNull() {
        return this.isParamNull(TAG_PSSYSDICTCATID);
    }

    public final String getPSSYSDICTCATID() {
        return this.getParamStringValue(TAG_PSSYSDICTCATID, "");
    }

    public final void setPSSYSDICTCATID(String strValue) {
        this.setParamValue(TAG_PSSYSDICTCATID, strValue);
    }

    public final boolean isPSSYSDICTCATNAMENull() {
        return this.isParamNull(TAG_PSSYSDICTCATNAME);
    }

    public final String getPSSYSDICTCATNAME() {
        return this.getParamStringValue(TAG_PSSYSDICTCATNAME, "");
    }

    public final void setPSSYSDICTCATNAME(String strValue) {
        this.setParamValue(TAG_PSSYSDICTCATNAME, strValue);
    }

    public final boolean isVALUEITEMNAMENull() {
        return this.isParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.getParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.setParamValue(TAG_VALUEITEMNAME, strValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.isParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.getParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.setParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isPPSDEGRIDCOLIDNull() {
        return this.isParamNull(TAG_PPSDEGRIDCOLID);
    }

    public final String getPPSDEGRIDCOLID() {
        return this.getParamStringValue(TAG_PPSDEGRIDCOLID, "");
    }

    public final void setPPSDEGRIDCOLID(String strValue) {
        this.setParamValue(TAG_PPSDEGRIDCOLID, strValue);
    }

    public final boolean isPPSDEGRIDCOLNAMENull() {
        return this.isParamNull(TAG_PPSDEGRIDCOLNAME);
    }

    public final String getPPSDEGRIDCOLNAME() {
        return this.getParamStringValue(TAG_PPSDEGRIDCOLNAME, "");
    }

    public final void setPPSDEGRIDCOLNAME(String strValue) {
        this.setParamValue(TAG_PPSDEGRIDCOLNAME, strValue);
    }

    public final boolean isGROUPITEMNull() {
        return this.isParamNull(TAG_GROUPITEM);
    }

    public final String getGROUPITEM() {
        return this.getParamStringValue(TAG_GROUPITEM, "");
    }

    public final void setGROUPITEM(String strValue) {
        this.setParamValue(TAG_GROUPITEM, strValue);
    }

    public final boolean isCODELISTCONFIGMODENull() {
        return this.isParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.getParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.setParamValue(TAG_CODELISTCONFIGMODE, nValue);
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

    public final boolean isPREVENTXSSNull() {
        return this.isParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.getParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.setParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isGRIDCOLSTYLENull() {
        return this.isParamNull(TAG_GRIDCOLSTYLE);
    }

    public final String getGRIDCOLSTYLE() {
        return this.getParamStringValue(TAG_GRIDCOLSTYLE, "");
    }

    public final void setGRIDCOLSTYLE(String strValue) {
        this.setParamValue(TAG_GRIDCOLSTYLE, strValue);
    }

    public final boolean isCLCONVERTMODENull() {
        return this.isParamNull(TAG_CLCONVERTMODE);
    }

    public final String getCLCONVERTMODE() {
        return this.getParamStringValue(TAG_CLCONVERTMODE, "");
    }

    public final void setCLCONVERTMODE(String strValue) {
        this.setParamValue(TAG_CLCONVERTMODE, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.isParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.getParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.setParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.isParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.getParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.setParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isHEADERPSSYSCSSIDNull() {
        return this.isParamNull(TAG_HEADERPSSYSCSSID);
    }

    public final String getHEADERPSSYSCSSID() {
        return this.getParamStringValue(TAG_HEADERPSSYSCSSID, "");
    }

    public final void setHEADERPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_HEADERPSSYSCSSID, strValue);
    }

    public final boolean isHEADERPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_HEADERPSSYSCSSNAME);
    }

    public final String getHEADERPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_HEADERPSSYSCSSNAME, "");
    }

    public final void setHEADERPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_HEADERPSSYSCSSNAME, strValue);
    }

    public final boolean isCELLPSSYSCSSIDNull() {
        return this.isParamNull(TAG_CELLPSSYSCSSID);
    }

    public final String getCELLPSSYSCSSID() {
        return this.getParamStringValue(TAG_CELLPSSYSCSSID, "");
    }

    public final void setCELLPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_CELLPSSYSCSSID, strValue);
    }

    public final boolean isCELLPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_CELLPSSYSCSSNAME);
    }

    public final String getCELLPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_CELLPSSYSCSSNAME, "");
    }

    public final void setCELLPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_CELLPSSYSCSSNAME, strValue);
    }

    public ArrayList<PSDEGridColumn> getChildPSDEGridColumns(boolean bCreated) {
        if (this.childPSDEGridColumnList != null) {
            return this.childPSDEGridColumnList;
        }
        if (bCreated) {
            this.childPSDEGridColumnList = new ArrayList();
        }
        return this.childPSDEGridColumnList;
    }

    public void resetChildDatas() {
        if (this.childPSDEGridColumnList != null) {
            this.childPSDEGridColumnList.clear();
            this.childPSDEGridColumnList = null;
        }
    }
}

