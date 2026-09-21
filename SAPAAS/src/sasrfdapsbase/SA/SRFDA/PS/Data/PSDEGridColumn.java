/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDEGridColumn
extends BaseDataEntity {
    public static final String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";
    public static final String GRIDCOLTYPE_UAGRIDCOLUMN = "UAGRIDCOLUMN";
    public static final String GRIDCOLTYPE_GROUPGRIDCOLUMN = "GROUPGRIDCOLUMN";
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
    public static final int ENABLELINK_NO = 0;
    public static final int ENABLELINK_YES = 1;
    public static final int ENABLELINK_AUTO = 2;
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
    public static final String TAG_TREEITEM = "TREEITEM";
    public static final String TAG_NOPRIVDM = "NOPRIVDM";
    public static final String TAG_AGGMODE = "AGGMODE";
    public static final String TAG_AGGFIELD = "AGGFIELD";
    public static final String TAG_ENABLELINK = "ENABLELINK";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_AGGVALUEFORMAT = "AGGVALUEFORMAT";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String TAG_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String TAG_RAWSERVICEMETHOD = "RAWSERVICEMETHOD";
    public static final String TAG_RAWSERVICEURL = "RAWSERVICEURL";
    public static final String TAG_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String TAG_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String TAG_ENABLEINPUTTIP = "ENABLEINPUTTIP";
    private ArrayList<PSDEGridColumn> childPSDEGridColumnList = null;

    public final boolean isPSDEGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLID);
    }

    public final String getPSDEGRIDCOLID() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLID, "");
    }

    public final void setPSDEGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLID, strValue);
    }

    public final boolean isPSDEGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLNAME);
    }

    public final String getPSDEGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLNAME, "");
    }

    public final void setPSDEGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLNAME, strValue);
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

    public final boolean isGRIDCOLTYPENull() {
        return this.IsParamNull(TAG_GRIDCOLTYPE);
    }

    public final String getGRIDCOLTYPE() {
        return this.GetParamStringValue(TAG_GRIDCOLTYPE, "");
    }

    public final void setGRIDCOLTYPE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLTYPE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isWIDTHUNITNull() {
        return this.IsParamNull(TAG_WIDTHUNIT);
    }

    public final String getWIDTHUNIT() {
        return this.GetParamStringValue(TAG_WIDTHUNIT, "");
    }

    public final void setWIDTHUNIT(String strValue) {
        this.SetParamValue(TAG_WIDTHUNIT, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPSDEFGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PSDEFGRIDCOLID);
    }

    public final String getPSDEFGRIDCOLID() {
        return this.GetParamStringValue(TAG_PSDEFGRIDCOLID, "");
    }

    public final void setPSDEFGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEFGRIDCOLID, strValue);
    }

    public final boolean isPSDEFGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEFGRIDCOLNAME);
    }

    public final String getPSDEFGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEFGRIDCOLNAME, "");
    }

    public final void setPSDEFGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGRIDCOLNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEFUIMODEIDNull() {
        return this.IsParamNull(TAG_PSDEFUIMODEID);
    }

    public final String getPSDEFUIMODEID() {
        return this.GetParamStringValue(TAG_PSDEFUIMODEID, "");
    }

    public final void setPSDEFUIMODEID(String strValue) {
        this.SetParamValue(TAG_PSDEFUIMODEID, strValue);
    }

    public final boolean isPSDEFUIMODENAMENull() {
        return this.IsParamNull(TAG_PSDEFUIMODENAME);
    }

    public final String getPSDEFUIMODENAME() {
        return this.GetParamStringValue(TAG_PSDEFUIMODENAME, "");
    }

    public final void setPSDEFUIMODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFUIMODENAME, strValue);
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

    public final boolean isNOSORTNull() {
        return this.IsParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isHIDDENDATAITEMNull() {
        return this.IsParamNull(TAG_HIDDENDATAITEM);
    }

    public final boolean getHIDDENDATAITEM() {
        return this.GetParamIntValue(TAG_HIDDENDATAITEM, 0) == 1;
    }

    public final void setHIDDENDATAITEM(boolean bValue) {
        this.SetParamValue(TAG_HIDDENDATAITEM, bValue ? 1 : 0);
    }

    public final boolean isALIGNNull() {
        return this.IsParamNull(TAG_ALIGN);
    }

    public final String getALIGN() {
        return this.GetParamStringValue(TAG_ALIGN, "");
    }

    public final void setALIGN(String strValue) {
        this.SetParamValue(TAG_ALIGN, strValue);
    }

    public final boolean isHIDEDEFAULTNull() {
        return this.IsParamNull(TAG_HIDEDEFAULT);
    }

    public final int getHIDEDEFAULT() {
        return this.GetParamIntValue(TAG_HIDEDEFAULT, 0);
    }

    public final void setHIDEDEFAULT(int bValue) {
        this.SetParamValue(TAG_HIDEDEFAULT, bValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isDATAITEMSNull() {
        return this.IsParamNull(TAG_DATAITEMS);
    }

    public final String getDATAITEMS() {
        return this.GetParamStringValue(TAG_DATAITEMS, "");
    }

    public final void setDATAITEMS(String strValue) {
        this.SetParamValue(TAG_DATAITEMS, strValue);
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

    public final boolean isENABLEROWEDITNull() {
        return this.IsParamNull(TAG_ENABLEROWEDIT);
    }

    public final boolean getENABLEROWEDIT() {
        return this.GetParamIntValue(TAG_ENABLEROWEDIT, 0) == 1;
    }

    public final void setENABLEROWEDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEROWEDIT, bValue ? 1 : 0);
    }

    public final boolean isEDITORTYPENull() {
        return this.IsParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.GetParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isEDITORPARAMSNull() {
        return this.IsParamNull(TAG_EDITORPARAMS);
    }

    public final String getEDITORPARAMS() {
        return this.GetParamStringValue(TAG_EDITORPARAMS, "");
    }

    public final void setEDITORPARAMS(String strValue) {
        this.SetParamValue(TAG_EDITORPARAMS, strValue);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
    }

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

    public final boolean isPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWID);
    }

    public final String getPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWID, "");
    }

    public final void setPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWID, strValue);
    }

    public final boolean isPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWNAME);
    }

    public final String getPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWNAME, "");
    }

    public final void setPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isPSDEGEIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDEGEIUPDATEID);
    }

    public final String getPSDEGEIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDEGEIUPDATEID, "");
    }

    public final void setPSDEGEIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUPDATEID, strValue);
    }

    public final boolean isPSDEGEIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDEGEIUPDATENAME);
    }

    public final String getPSDEGEIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDEGEIUPDATENAME, "");
    }

    public final void setPSDEGEIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUPDATENAME, strValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isENABLECONDNull() {
        return this.IsParamNull(TAG_ENABLECOND);
    }

    public final int getENABLECOND() {
        return this.GetParamIntValue(TAG_ENABLECOND, 0);
    }

    public final void setENABLECOND(int nValue) {
        this.SetParamValue(TAG_ENABLECOND, nValue);
    }

    public final boolean isPLACEHOLDERNull() {
        return this.IsParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.GetParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.SetParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isCREATEDVNull() {
        return this.IsParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.GetParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.SetParamValue(TAG_CREATEDV, strValue);
    }

    public final boolean isCREATEDVTNull() {
        return this.IsParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.GetParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.SetParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isUPDATEDVNull() {
        return this.IsParamNull(TAG_UPDATEDV);
    }

    public final String getUPDATEDV() {
        return this.GetParamStringValue(TAG_UPDATEDV, "");
    }

    public final void setUPDATEDV(String strValue) {
        this.SetParamValue(TAG_UPDATEDV, strValue);
    }

    public final boolean isUPDATEDVTNull() {
        return this.IsParamNull(TAG_UPDATEDVT);
    }

    public final String getUPDATEDVT() {
        return this.GetParamStringValue(TAG_UPDATEDVT, "");
    }

    public final void setUPDATEDVT(String strValue) {
        this.SetParamValue(TAG_UPDATEDVT, strValue);
    }

    public final boolean isIGNOREINPUTNull() {
        return this.IsParamNull(TAG_IGNOREINPUT);
    }

    public final int getIGNOREINPUT() {
        return this.GetParamIntValue(TAG_IGNOREINPUT, 0);
    }

    public final void setIGNOREINPUT(int nValue) {
        this.SetParamValue(TAG_IGNOREINPUT, nValue);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.IsParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.GetParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.SetParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isRESETITEMNAMENull() {
        return this.IsParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.GetParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.SetParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isPSSYSDICTCATIDNull() {
        return this.IsParamNull(TAG_PSSYSDICTCATID);
    }

    public final String getPSSYSDICTCATID() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATID, "");
    }

    public final void setPSSYSDICTCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATID, strValue);
    }

    public final boolean isPSSYSDICTCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSDICTCATNAME);
    }

    public final String getPSSYSDICTCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATNAME, "");
    }

    public final void setPSSYSDICTCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATNAME, strValue);
    }

    public final boolean isVALUEITEMNAMENull() {
        return this.IsParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.GetParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.SetParamValue(TAG_VALUEITEMNAME, strValue);
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

    public final boolean isPPSDEGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PPSDEGRIDCOLID);
    }

    public final String getPPSDEGRIDCOLID() {
        return this.GetParamStringValue(TAG_PPSDEGRIDCOLID, "");
    }

    public final void setPPSDEGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PPSDEGRIDCOLID, strValue);
    }

    public final boolean isPPSDEGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PPSDEGRIDCOLNAME);
    }

    public final String getPPSDEGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PPSDEGRIDCOLNAME, "");
    }

    public final void setPPSDEGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEGRIDCOLNAME, strValue);
    }

    public final boolean isGROUPITEMNull() {
        return this.IsParamNull(TAG_GROUPITEM);
    }

    public final String getGROUPITEM() {
        return this.GetParamStringValue(TAG_GROUPITEM, "");
    }

    public final void setGROUPITEM(String strValue) {
        this.SetParamValue(TAG_GROUPITEM, strValue);
    }

    public final boolean isCODELISTCONFIGMODENull() {
        return this.IsParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.GetParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.SetParamValue(TAG_CODELISTCONFIGMODE, nValue);
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

    public final boolean isPREVENTXSSNull() {
        return this.IsParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.GetParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.SetParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isGRIDCOLSTYLENull() {
        return this.IsParamNull(TAG_GRIDCOLSTYLE);
    }

    public final String getGRIDCOLSTYLE() {
        return this.GetParamStringValue(TAG_GRIDCOLSTYLE, "");
    }

    public final void setGRIDCOLSTYLE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLSTYLE, strValue);
    }

    public final boolean isCLCONVERTMODENull() {
        return this.IsParamNull(TAG_CLCONVERTMODE);
    }

    public final String getCLCONVERTMODE() {
        return this.GetParamStringValue(TAG_CLCONVERTMODE, "");
    }

    public final void setCLCONVERTMODE(String strValue) {
        this.SetParamValue(TAG_CLCONVERTMODE, strValue);
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

    public final boolean isHEADERPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_HEADERPSSYSCSSID);
    }

    public final String getHEADERPSSYSCSSID() {
        return this.GetParamStringValue(TAG_HEADERPSSYSCSSID, "");
    }

    public final void setHEADERPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSCSSID, strValue);
    }

    public final boolean isHEADERPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_HEADERPSSYSCSSNAME);
    }

    public final String getHEADERPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_HEADERPSSYSCSSNAME, "");
    }

    public final void setHEADERPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSCSSNAME, strValue);
    }

    public final boolean isCELLPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSID);
    }

    public final String getCELLPSSYSCSSID() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSID, "");
    }

    public final void setCELLPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSID, strValue);
    }

    public final boolean isCELLPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSNAME);
    }

    public final String getCELLPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSNAME, "");
    }

    public final void setCELLPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSNAME, strValue);
    }

    public final boolean isTREEITEMNull() {
        return this.IsParamNull(TAG_TREEITEM);
    }

    public final int getTREEITEM() {
        return this.GetParamIntValue(TAG_TREEITEM, 0);
    }

    public final void setTREEITEM(int nValue) {
        this.SetParamValue(TAG_TREEITEM, nValue);
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

    public final boolean isAGGMODENull() {
        return this.IsParamNull(TAG_AGGMODE);
    }

    public final String getAGGMODE() {
        return this.GetParamStringValue(TAG_AGGMODE, "");
    }

    public final void setAGGMODE(String strValue) {
        this.SetParamValue(TAG_AGGMODE, strValue);
    }

    public final boolean isAGGFIELDNull() {
        return this.IsParamNull(TAG_AGGFIELD);
    }

    public final String getAGGFIELD() {
        return this.GetParamStringValue(TAG_AGGFIELD, "");
    }

    public final void setAGGFIELD(String strValue) {
        this.SetParamValue(TAG_AGGFIELD, strValue);
    }

    public final boolean isENABLELINKNull() {
        return this.IsParamNull(TAG_ENABLELINK);
    }

    public final int getENABLELINK() {
        return this.GetParamIntValue(TAG_ENABLELINK, 0);
    }

    public final void setENABLELINK(int nValue) {
        this.SetParamValue(TAG_ENABLELINK, nValue);
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

    public final boolean isAGGVALUEFORMATNull() {
        return this.IsParamNull(TAG_AGGVALUEFORMAT);
    }

    public final String getAGGVALUEFORMAT() {
        return this.GetParamStringValue(TAG_AGGVALUEFORMAT, "");
    }

    public final void setAGGVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_AGGVALUEFORMAT, strValue);
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

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isREFPSDEIDNull() {
        return this.IsParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.GetParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.IsParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.GetParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDENAME, strValue);
    }

    public final boolean isREFPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_REFPSDEDATASETID);
    }

    public final String getREFPSDEDATASETID() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETID, "");
    }

    public final void setREFPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETID, strValue);
    }

    public final boolean isREFPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_REFPSDEDATASETNAME);
    }

    public final String getREFPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETNAME, "");
    }

    public final void setREFPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETNAME, strValue);
    }

    public final boolean isREFPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_REFPSDEACMODEID);
    }

    public final String getREFPSDEACMODEID() {
        return this.GetParamStringValue(TAG_REFPSDEACMODEID, "");
    }

    public final void setREFPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODEID, strValue);
    }

    public final boolean isREFPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_REFPSDEACMODENAME);
    }

    public final String getREFPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_REFPSDEACMODENAME, "");
    }

    public final void setREFPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODENAME, strValue);
    }

    public final boolean isRAWSERVICEMETHODNull() {
        return this.IsParamNull(TAG_RAWSERVICEMETHOD);
    }

    public final String getRAWSERVICEMETHOD() {
        return this.GetParamStringValue(TAG_RAWSERVICEMETHOD, "");
    }

    public final void setRAWSERVICEMETHOD(String strValue) {
        this.SetParamValue(TAG_RAWSERVICEMETHOD, strValue);
    }

    public final boolean isRAWSERVICEURLNull() {
        return this.IsParamNull(TAG_RAWSERVICEURL);
    }

    public final String getRAWSERVICEURL() {
        return this.GetParamStringValue(TAG_RAWSERVICEURL, "");
    }

    public final void setRAWSERVICEURL(String strValue) {
        this.SetParamValue(TAG_RAWSERVICEURL, strValue);
    }

    public final boolean isPSDEFSFITEMIDNull() {
        return this.IsParamNull(TAG_PSDEFSFITEMID);
    }

    public final String getPSDEFSFITEMID() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMID, "");
    }

    public final void setPSDEFSFITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMID, strValue);
    }

    public final boolean isPSDEFSFITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEFSFITEMNAME);
    }

    public final String getPSDEFSFITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMNAME, "");
    }

    public final void setPSDEFSFITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMNAME, strValue);
    }

    public final boolean isENABLEINPUTTIPNull() {
        return this.IsParamNull(TAG_ENABLEINPUTTIP);
    }

    public final boolean getENABLEINPUTTIP() {
        return this.GetParamIntValue(TAG_ENABLEINPUTTIP, 0) == 1;
    }

    public final void setENABLEINPUTTIP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEINPUTTIP, bValue ? 1 : 0);
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

