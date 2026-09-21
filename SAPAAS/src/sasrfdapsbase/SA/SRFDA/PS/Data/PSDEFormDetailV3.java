/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PSDEFormDetailV3
extends BaseDataEntity {
    public static final String FORMTYPE_FORM = "FORM";
    public static final String DETAILTYPE_FORMPAGE = "FORMPAGE";
    public static final String DETAILTYPE_TABPANEL = "TABPANEL";
    public static final String DETAILTYPE_TABPAGE = "TABPAGE";
    public static final String DETAILTYPE_DATAGRID = "DATAGRID";
    public static final String DETAILTYPE_FORMITEM = "FORMITEM";
    public static final String DETAILTYPE_USERCONTROL = "USERCONTROL";
    public static final String DETAILTYPE_FORMPART = "FORMPART";
    public static final String DETAILTYPE_GROUPPANEL = "GROUPPANEL";
    public static final String DETAILTYPE_DRUIPART = "DRUIPART";
    public static final String LAYOUTMODE_AUTOTABLE = "AUTOTABLE";
    public static final String LAYOUTMODE_TABLE = "TABLE";
    public static final String LAYOUTMODE_TABLE_12COL = "TABLE_12COL";
    public static final String LAYOUTMODE_TABLE_24COL = "TABLE_24COL";
    public static final String LABELPOS_LEFT = "LEFT";
    public static final String LABELPOS_TOP = "TOP";
    public static final String LABELPOS_RIGHT = "RIGHT";
    public static final String LABELPOS_BOTTOM = "BOTTOM";
    public static final String LABELPOS_NONE = "NONE";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String FORMTYPE_EDITFORM = "EDITFORM";
    public static final String FORMTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String BTNACTIONTYPE_UIACTION = "UIACTION";
    public static final String BTNACTIONTYPE_FIUPDATE = "FIUPDATE";
    public static final int ENABLECOND_NONE = 0;
    public static final int ENABLECOND_CREATE = 1;
    public static final int ENABLECOND_UPDATE = 2;
    public static final int ENABLECOND_ALL = 3;
    public static final int IGNOREINPUT_NONE = 0;
    public static final int IGNOREINPUT_CREATE = 1;
    public static final int IGNOREINPUT_UPDATE = 2;
    public static final int IGNOREINPUT_ALL = 3;
    public static final String UPDATEDVT_SESSION = "SESSION";
    public static final String UPDATEDVT_APPLICATION = "APPLICATION";
    public static final String UPDATEDVT_UNIQUEID = "UNIQUEID";
    public static final String UPDATEDVT_CONTEXT = "CONTEXT";
    public static final String UPDATEDVT_PARAM = "PARAM";
    public static final String UPDATEDVT_OPERATOR = "OPERATOR";
    public static final String UPDATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String UPDATEDVT_CURTIME = "CURTIME";
    public static final String CREATEDVT_SESSION = "SESSION";
    public static final String CREATEDVT_APPLICATION = "APPLICATION";
    public static final String CREATEDVT_UNIQUEID = "UNIQUEID";
    public static final String CREATEDVT_CONTEXT = "CONTEXT";
    public static final String CREATEDVT_PARAM = "PARAM";
    public static final String CREATEDVT_OPERATOR = "OPERATOR";
    public static final String CREATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String CREATEDVT_CURTIME = "CURTIME";
    public static final int CODELISTCONFIGMODE_NONE = 0;
    public static final int CODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int CODELISTCONFIGMODE_INCLUDECHILD = 2;
    public static final int TITLEBARCLOSEMODE_NONE = 0;
    public static final int TITLEBARCLOSEMODE_OPENDEFAULT = 1;
    public static final int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;
    public static final int BUILDINACTION_NEW = 1;
    public static final int BUILDINACTION_MORE = 2;
    public static final String TAG_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String TAG_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSDEFFORMITEMID = "PSDEFFORMITEMID";
    public static final String TAG_PSDEFFORMITEMNAME = "PSDEFFORMITEMNAME";
    public static final String TAG_DETAILTYPE = "DETAILTYPE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PPSDEFORMDETAILID = "PPSDEFORMDETAILID";
    public static final String TAG_PPSDEFORMDETAILNAME = "PPSDEFORMDETAILNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_CTRLWIDTH = "CTRLWIDTH";
    public static final String TAG_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_COLID = "COLID";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_ROWSPAN = "ROWSPAN";
    public static final String TAG_COLMODEL = "COLMODEL";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_MARGIN = "MARGIN";
    public static final String TAG_PADDING = "PADDING";
    public static final String TAG_LABELPOS = "LABELPOS";
    public static final String TAG_LABELWIDTH = "LABELWIDTH";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_LEVELNAME = "LEVELNAME";
    public static final String TAG_GRIDROWID = "GRIDROWID";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_FORMTYPE = "FORMTYPE";
    public static final String TAG_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String TAG_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String TAG_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_UPDATEDV = "UPDATEDV";
    public static final String TAG_CREATEDV = "CREATEDV";
    public static final String TAG_UPDATEDVT = "UPDATEDVT";
    public static final String TAG_CREATEDVT = "CREATEDVT";
    public static final String TAG_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String TAG_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String TAG_PSDEFORMRFID = "PSDEFORMRFID";
    public static final String TAG_PSDEFORMRFNAME = "PSDEFORMRFNAME";
    public static final String TAG_REFPSDEFORMID = "REFPSDEFORMID";
    public static final String TAG_REFPSDEFORMDETAILID = "REFPSDEFORMDETAILID";
    public static final String TAG_REFPSDEFORMDETAILNAME = "REFPSDEFORMDETAILNAME";
    public static final String TAG_IGNOREINPUT = "IGNOREINPUT";
    public static final String TAG_CSSTYLE = "CSSTYLE";
    public static final String TAG_LABELCOLSPAN = "LABELCOLSPAN";
    public static final String TAG_CTRLCOLSPAN = "CTRLCOLSPAN";
    public static final String TAG_LABELCOLSPAN2 = "LABELCOLSPAN2";
    public static final String TAG_EDITORPARAMS = "EDITORPARAMS";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_CHILD_COL_XS = "CHILD_COL_XS";
    public static final String TAG_CHILD_COL_SM = "CHILD_COL_SM";
    public static final String TAG_CHILD_COL_MD = "CHILD_COL_MD";
    public static final String TAG_CHILD_COL_LG = "CHILD_COL_LG";
    public static final String TAG_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String TAG_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String TAG_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String TAG_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String TAG_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_EMPTYCAPTION = "EMPTYCAPTION";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_ITEMPSACHANDLERID = "ITEMPSACHANDLERID";
    public static final String TAG_ITEMPSACHANDLERNAME = "ITEMPSACHANDLERNAME";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String TAG_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String TAG_UCPSSYSPFPLUGINID = "UCPSSYSPFPLUGINID";
    public static final String TAG_UCPSSYSPFPLUGINNAME = "UCPSSYSPFPLUGINNAME";
    public static final String TAG_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String TAG_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_COL_WIDTH = "COL_WIDTH";
    public static final String TAG_WBDEFMODE = "WBDEFMODE";
    public static final String TAG_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String TAG_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String TAG_BUILDINACTION = "BUILDINACTION";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    private ArrayList<PSDEFormDetailV3> childPSDEFormDetailList = null;
    private HashMap<String, ArrayList<PSDEFDLogic>> childPSDEFDLogicListMap = null;

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILNAME, strValue);
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

    public final boolean isPSDEFFORMITEMIDNull() {
        return this.IsParamNull(TAG_PSDEFFORMITEMID);
    }

    public final String getPSDEFFORMITEMID() {
        return this.GetParamStringValue(TAG_PSDEFFORMITEMID, "");
    }

    public final void setPSDEFFORMITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEFFORMITEMID, strValue);
    }

    public final boolean isPSDEFFORMITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEFFORMITEMNAME);
    }

    public final String getPSDEFFORMITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEFFORMITEMNAME, "");
    }

    public final void setPSDEFFORMITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFFORMITEMNAME, strValue);
    }

    public final boolean isDETAILTYPENull() {
        return this.IsParamNull(TAG_DETAILTYPE);
    }

    public final String getDETAILTYPE() {
        return this.GetParamStringValue(TAG_DETAILTYPE, "");
    }

    public final void setDETAILTYPE(String strValue) {
        this.SetParamValue(TAG_DETAILTYPE, strValue);
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

    public final boolean isPPSDEFORMDETAILIDNull() {
        return this.IsParamNull(TAG_PPSDEFORMDETAILID);
    }

    public final String getPPSDEFORMDETAILID() {
        return this.GetParamStringValue(TAG_PPSDEFORMDETAILID, "");
    }

    public final void setPPSDEFORMDETAILID(String strValue) {
        this.SetParamValue(TAG_PPSDEFORMDETAILID, strValue);
    }

    public final boolean isPPSDEFORMDETAILNAMENull() {
        return this.IsParamNull(TAG_PPSDEFORMDETAILNAME);
    }

    public final String getPPSDEFORMDETAILNAME() {
        return this.GetParamStringValue(TAG_PPSDEFORMDETAILNAME, "");
    }

    public final void setPPSDEFORMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEFORMDETAILNAME, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isCTRLWIDTHNull() {
        return this.IsParamNull(TAG_CTRLWIDTH);
    }

    public final int getCTRLWIDTH() {
        return this.GetParamIntValue(TAG_CTRLWIDTH, 0);
    }

    public final void setCTRLWIDTH(int nValue) {
        this.SetParamValue(TAG_CTRLWIDTH, nValue);
    }

    public final boolean isCTRLHEIGHTNull() {
        return this.IsParamNull(TAG_CTRLHEIGHT);
    }

    public final int getCTRLHEIGHT() {
        return this.GetParamIntValue(TAG_CTRLHEIGHT, 0);
    }

    public final void setCTRLHEIGHT(int nValue) {
        this.SetParamValue(TAG_CTRLHEIGHT, nValue);
    }

    public final boolean isSHOWCAPTIONNull() {
        return this.IsParamNull(TAG_SHOWCAPTION);
    }

    public final boolean getSHOWCAPTION() {
        return this.GetParamIntValue(TAG_SHOWCAPTION, 0) == 1;
    }

    public final void setSHOWCAPTION(boolean bValue) {
        this.SetParamValue(TAG_SHOWCAPTION, bValue ? 1 : 0);
    }

    public final boolean isCOLIDNull() {
        return this.IsParamNull(TAG_COLID);
    }

    public final int getCOLID() {
        return this.GetParamIntValue(TAG_COLID, 0);
    }

    public final void setCOLID(int nValue) {
        this.SetParamValue(TAG_COLID, nValue);
    }

    public final boolean isCOLSPANNull() {
        return this.IsParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.GetParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.SetParamValue(TAG_COLSPAN, nValue);
    }

    public final boolean isROWSPANNull() {
        return this.IsParamNull(TAG_ROWSPAN);
    }

    public final int getROWSPAN() {
        return this.GetParamIntValue(TAG_ROWSPAN, 0);
    }

    public final void setROWSPAN(int nValue) {
        this.SetParamValue(TAG_ROWSPAN, nValue);
    }

    public final boolean isCOLMODELNull() {
        return this.IsParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.GetParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.SetParamValue(TAG_COLMODEL, strValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isMARGINNull() {
        return this.IsParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.GetParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.SetParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.IsParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.GetParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.SetParamValue(TAG_PADDING, strValue);
    }

    public final boolean isLABELPOSNull() {
        return this.IsParamNull(TAG_LABELPOS);
    }

    public final String getLABELPOS() {
        return this.GetParamStringValue(TAG_LABELPOS, "");
    }

    public final void setLABELPOS(String strValue) {
        this.SetParamValue(TAG_LABELPOS, strValue);
    }

    public final boolean isLABELWIDTHNull() {
        return this.IsParamNull(TAG_LABELWIDTH);
    }

    public final int getLABELWIDTH() {
        return this.GetParamIntValue(TAG_LABELWIDTH, 0);
    }

    public final void setLABELWIDTH(int nValue) {
        this.SetParamValue(TAG_LABELWIDTH, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isLEVELNAMENull() {
        return this.IsParamNull(TAG_LEVELNAME);
    }

    public final String getLEVELNAME() {
        return this.GetParamStringValue(TAG_LEVELNAME, "");
    }

    public final void setLEVELNAME(String strValue) {
        this.SetParamValue(TAG_LEVELNAME, strValue);
    }

    public final boolean isGRIDROWIDNull() {
        return this.IsParamNull(TAG_GRIDROWID);
    }

    public final int getGRIDROWID() {
        return this.GetParamIntValue(TAG_GRIDROWID, 0);
    }

    public final void setGRIDROWID(int nValue) {
        this.SetParamValue(TAG_GRIDROWID, nValue);
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

    public final boolean isFORMTYPENull() {
        return this.IsParamNull(TAG_FORMTYPE);
    }

    public final String getFORMTYPE() {
        return this.GetParamStringValue(TAG_FORMTYPE, "");
    }

    public final void setFORMTYPE(String strValue) {
        this.SetParamValue(TAG_FORMTYPE, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDEDRITEMIDNull() {
        return this.IsParamNull(TAG_PSDEDRITEMID);
    }

    public final String getPSDEDRITEMID() {
        return this.GetParamStringValue(TAG_PSDEDRITEMID, "");
    }

    public final void setPSDEDRITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEDRITEMID, strValue);
    }

    public final boolean isPSDEDRITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEDRITEMNAME);
    }

    public final String getPSDEDRITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEDRITEMNAME, "");
    }

    public final void setPSDEDRITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDRITEMNAME, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isENABLECONDNull() {
        return this.IsParamNull(TAG_ENABLECOND);
    }

    public final int getENABLECOND() {
        return this.GetParamIntValue(TAG_ENABLECOND, 0);
    }

    public final void setENABLECOND(int nValue) {
        this.SetParamValue(TAG_ENABLECOND, nValue);
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

    public final boolean isCREATEDVNull() {
        return this.IsParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.GetParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.SetParamValue(TAG_CREATEDV, strValue);
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

    public final boolean isCREATEDVTNull() {
        return this.IsParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.GetParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.SetParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isPSDEFIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDEFIUPDATEID);
    }

    public final String getPSDEFIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDEFIUPDATEID, "");
    }

    public final void setPSDEFIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDEFIUPDATEID, strValue);
    }

    public final boolean isPSDEFIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDEFIUPDATENAME);
    }

    public final String getPSDEFIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDEFIUPDATENAME, "");
    }

    public final void setPSDEFIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIUPDATENAME, strValue);
    }

    public final boolean isPSDEFORMRFIDNull() {
        return this.IsParamNull(TAG_PSDEFORMRFID);
    }

    public final String getPSDEFORMRFID() {
        return this.GetParamStringValue(TAG_PSDEFORMRFID, "");
    }

    public final void setPSDEFORMRFID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMRFID, strValue);
    }

    public final boolean isPSDEFORMRFNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMRFNAME);
    }

    public final String getPSDEFORMRFNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMRFNAME, "");
    }

    public final void setPSDEFORMRFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMRFNAME, strValue);
    }

    public final boolean isREFPSDEFORMIDNull() {
        return this.IsParamNull(TAG_REFPSDEFORMID);
    }

    public final String getREFPSDEFORMID() {
        return this.GetParamStringValue(TAG_REFPSDEFORMID, "");
    }

    public final void setREFPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_REFPSDEFORMID, strValue);
    }

    public final boolean isREFPSDEFORMDETAILIDNull() {
        return this.IsParamNull(TAG_REFPSDEFORMDETAILID);
    }

    public final String getREFPSDEFORMDETAILID() {
        return this.GetParamStringValue(TAG_REFPSDEFORMDETAILID, "");
    }

    public final void setREFPSDEFORMDETAILID(String strValue) {
        this.SetParamValue(TAG_REFPSDEFORMDETAILID, strValue);
    }

    public final boolean isREFPSDEFORMDETAILNAMENull() {
        return this.IsParamNull(TAG_REFPSDEFORMDETAILNAME);
    }

    public final String getREFPSDEFORMDETAILNAME() {
        return this.GetParamStringValue(TAG_REFPSDEFORMDETAILNAME, "");
    }

    public final void setREFPSDEFORMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEFORMDETAILNAME, strValue);
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

    public final boolean isCSSTYLENull() {
        return this.IsParamNull(TAG_CSSTYLE);
    }

    public final String getCSSTYLE() {
        return this.GetParamStringValue(TAG_CSSTYLE, "");
    }

    public final void setCSSTYLE(String strValue) {
        this.SetParamValue(TAG_CSSTYLE, strValue);
    }

    public final boolean isLABELCOLSPANNull() {
        return this.IsParamNull(TAG_LABELCOLSPAN);
    }

    public final int getLABELCOLSPAN() {
        return this.GetParamIntValue(TAG_LABELCOLSPAN, 0);
    }

    public final void setLABELCOLSPAN(int nValue) {
        this.SetParamValue(TAG_LABELCOLSPAN, nValue);
    }

    public final boolean isCTRLCOLSPANNull() {
        return this.IsParamNull(TAG_CTRLCOLSPAN);
    }

    public final int getCTRLCOLSPAN() {
        return this.GetParamIntValue(TAG_CTRLCOLSPAN, 0);
    }

    public final void setCTRLCOLSPAN(int nValue) {
        this.SetParamValue(TAG_CTRLCOLSPAN, nValue);
    }

    public final boolean isLABELCOLSPAN2Null() {
        return this.IsParamNull(TAG_LABELCOLSPAN2);
    }

    public final int getLABELCOLSPAN2() {
        return this.GetParamIntValue(TAG_LABELCOLSPAN2, 0);
    }

    public final void setLABELCOLSPAN2(int nValue) {
        this.SetParamValue(TAG_LABELCOLSPAN2, nValue);
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

    public final boolean isVALUEITEMNAMENull() {
        return this.IsParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.GetParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.SetParamValue(TAG_VALUEITEMNAME, strValue);
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

    public final boolean isCOL_XSNull() {
        return this.IsParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.GetParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.SetParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.IsParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.GetParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.SetParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.IsParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.GetParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.SetParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.IsParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.GetParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.SetParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.IsParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.GetParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.SetParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.IsParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.GetParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.SetParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.IsParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.GetParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.SetParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.IsParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.GetParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.SetParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCHILD_COL_XSNull() {
        return this.IsParamNull(TAG_CHILD_COL_XS);
    }

    public final int getCHILD_COL_XS() {
        return this.GetParamIntValue(TAG_CHILD_COL_XS, 0);
    }

    public final void setCHILD_COL_XS(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_XS, nValue);
    }

    public final boolean isCHILD_COL_SMNull() {
        return this.IsParamNull(TAG_CHILD_COL_SM);
    }

    public final int getCHILD_COL_SM() {
        return this.GetParamIntValue(TAG_CHILD_COL_SM, 0);
    }

    public final void setCHILD_COL_SM(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_SM, nValue);
    }

    public final boolean isCHILD_COL_MDNull() {
        return this.IsParamNull(TAG_CHILD_COL_MD);
    }

    public final int getCHILD_COL_MD() {
        return this.GetParamIntValue(TAG_CHILD_COL_MD, 0);
    }

    public final void setCHILD_COL_MD(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_MD, nValue);
    }

    public final boolean isCHILD_COL_LGNull() {
        return this.IsParamNull(TAG_CHILD_COL_LG);
    }

    public final int getCHILD_COL_LG() {
        return this.GetParamIntValue(TAG_CHILD_COL_LG, 0);
    }

    public final void setCHILD_COL_LG(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_LG, nValue);
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

    public final boolean isBTNACTIONTYPENull() {
        return this.IsParamNull(TAG_BTNACTIONTYPE);
    }

    public final String getBTNACTIONTYPE() {
        return this.GetParamStringValue(TAG_BTNACTIONTYPE, "");
    }

    public final void setBTNACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_BTNACTIONTYPE, strValue);
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

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
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

    public final boolean isRESETITEMNAMENull() {
        return this.IsParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.GetParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.SetParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isEMPTYCAPTIONNull() {
        return this.IsParamNull(TAG_EMPTYCAPTION);
    }

    public final boolean getEMPTYCAPTION() {
        return this.GetParamIntValue(TAG_EMPTYCAPTION, 0) == 1;
    }

    public final void setEMPTYCAPTION(boolean bValue) {
        this.SetParamValue(TAG_EMPTYCAPTION, bValue ? 1 : 0);
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

    public final boolean isPLACEHOLDERNull() {
        return this.IsParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.GetParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.SetParamValue(TAG_PLACEHOLDER, strValue);
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

    public final boolean isITEMPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_ITEMPSACHANDLERID);
    }

    public final String getITEMPSACHANDLERID() {
        return this.GetParamStringValue(TAG_ITEMPSACHANDLERID, "");
    }

    public final void setITEMPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_ITEMPSACHANDLERID, strValue);
    }

    public final boolean isITEMPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_ITEMPSACHANDLERNAME);
    }

    public final String getITEMPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_ITEMPSACHANDLERNAME, "");
    }

    public final void setITEMPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_ITEMPSACHANDLERNAME, strValue);
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

    public final boolean isCODELISTCONFIGMODENull() {
        return this.IsParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.GetParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.SetParamValue(TAG_CODELISTCONFIGMODE, nValue);
    }

    public final boolean isTITLEBARCLOSEMODENull() {
        return this.IsParamNull(TAG_TITLEBARCLOSEMODE);
    }

    public final int getTITLEBARCLOSEMODE() {
        return this.GetParamIntValue(TAG_TITLEBARCLOSEMODE, 0);
    }

    public final void setTITLEBARCLOSEMODE(int nValue) {
        this.SetParamValue(TAG_TITLEBARCLOSEMODE, nValue);
    }

    public final boolean isUCPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_UCPSSYSPFPLUGINID);
    }

    public final String getUCPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_UCPSSYSPFPLUGINID, "");
    }

    public final void setUCPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_UCPSSYSPFPLUGINID, strValue);
    }

    public final boolean isUCPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_UCPSSYSPFPLUGINNAME);
    }

    public final String getUCPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_UCPSSYSPFPLUGINNAME, "");
    }

    public final void setUCPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_UCPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isLABELPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_LABELPSSYSCSSID);
    }

    public final String getLABELPSSYSCSSID() {
        return this.GetParamStringValue(TAG_LABELPSSYSCSSID, "");
    }

    public final void setLABELPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_LABELPSSYSCSSID, strValue);
    }

    public final boolean isLABELPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_LABELPSSYSCSSNAME);
    }

    public final String getLABELPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_LABELPSSYSCSSNAME, "");
    }

    public final void setLABELPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_LABELPSSYSCSSNAME, strValue);
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

    public final boolean isCOL_WIDTHNull() {
        return this.IsParamNull(TAG_COL_WIDTH);
    }

    public final int getCOL_WIDTH() {
        return this.GetParamIntValue(TAG_COL_WIDTH, 0);
    }

    public final void setCOL_WIDTH(int nValue) {
        this.SetParamValue(TAG_COL_WIDTH, nValue);
    }

    public final boolean isWBDEFMODENull() {
        return this.IsParamNull(TAG_WBDEFMODE);
    }

    public final int getWBDEFMODE() {
        return this.GetParamIntValue(TAG_WBDEFMODE, 0);
    }

    public final void setWBDEFMODE(int nValue) {
        this.SetParamValue(TAG_WBDEFMODE, nValue);
    }

    public final boolean isCONVERTCITEXTNull() {
        return this.IsParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.GetParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.SetParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isENABLEANCHORNull() {
        return this.IsParamNull(TAG_ENABLEANCHOR);
    }

    public final boolean getENABLEANCHOR() {
        return this.GetParamIntValue(TAG_ENABLEANCHOR, 0) == 1;
    }

    public final void setENABLEANCHOR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEANCHOR, bValue ? 1 : 0);
    }

    public final boolean isBUILDINACTIONNull() {
        return this.IsParamNull(TAG_BUILDINACTION);
    }

    public final int getBUILDINACTION() {
        return this.GetParamIntValue(TAG_BUILDINACTION, 0);
    }

    public final void setBUILDINACTION(int nValue) {
        this.SetParamValue(TAG_BUILDINACTION, nValue);
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

    public ArrayList<PSDEFormDetailV3> getChildPSDEFormDetails(boolean bCreated) {
        if (this.childPSDEFormDetailList != null) {
            return this.childPSDEFormDetailList;
        }
        if (bCreated) {
            this.childPSDEFormDetailList = new ArrayList();
        }
        return this.childPSDEFormDetailList;
    }

    public ArrayList<PSDEFDLogic> getChildPSDEFDLogics(String strLogicCat, boolean bCreated) {
        ArrayList<PSDEFDLogic> childPSDEFDLogicList;
        if (this.childPSDEFDLogicListMap == null) {
            if (!bCreated) {
                return null;
            }
            this.childPSDEFDLogicListMap = new HashMap();
        }
        if ((childPSDEFDLogicList = this.childPSDEFDLogicListMap.get(strLogicCat)) != null) {
            return childPSDEFDLogicList;
        }
        if (bCreated) {
            childPSDEFDLogicList = new ArrayList();
            this.childPSDEFDLogicListMap.put(strLogicCat, childPSDEFDLogicList);
        }
        return childPSDEFDLogicList;
    }

    public void resetChildDatas() {
        if (this.childPSDEFormDetailList != null) {
            this.childPSDEFormDetailList.clear();
            this.childPSDEFormDetailList = null;
        }
        if (this.childPSDEFDLogicListMap != null) {
            this.childPSDEFDLogicListMap.clear();
            this.childPSDEFDLogicListMap = null;
        }
    }
}

