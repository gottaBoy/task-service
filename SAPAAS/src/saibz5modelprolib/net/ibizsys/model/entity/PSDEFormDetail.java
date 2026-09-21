/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSDEFDLogic;

public class PSDEFormDetail
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
    public static final String LAYOUTMODE_BORDER = "BORDER";
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
    public static final String TAG_DETAILSTYLE = "DETAILSTYLE";
    public static final String TAG_BL_POS = "BL_POS";
    public static final String TAG_BL_WIDTH = "BL_WIDTH";
    public static final String TAG_BL_HEIGHT = "BL_HEIGHT";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_WIDTH = "WIDTH";
    private ArrayList<PSDEFormDetail> childPSDEFormDetailList = null;
    private HashMap<String, ArrayList<PSDEFDLogic>> childPSDEFDLogicListMap = null;

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILNAME, strValue);
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

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
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

    public final boolean isPSDEFFORMITEMIDNull() {
        return this.isParamNull(TAG_PSDEFFORMITEMID);
    }

    public final String getPSDEFFORMITEMID() {
        return this.getParamStringValue(TAG_PSDEFFORMITEMID, "");
    }

    public final void setPSDEFFORMITEMID(String strValue) {
        this.setParamValue(TAG_PSDEFFORMITEMID, strValue);
    }

    public final boolean isPSDEFFORMITEMNAMENull() {
        return this.isParamNull(TAG_PSDEFFORMITEMNAME);
    }

    public final String getPSDEFFORMITEMNAME() {
        return this.getParamStringValue(TAG_PSDEFFORMITEMNAME, "");
    }

    public final void setPSDEFFORMITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFFORMITEMNAME, strValue);
    }

    public final boolean isDETAILTYPENull() {
        return this.isParamNull(TAG_DETAILTYPE);
    }

    public final String getDETAILTYPE() {
        return this.getParamStringValue(TAG_DETAILTYPE, "");
    }

    public final void setDETAILTYPE(String strValue) {
        this.setParamValue(TAG_DETAILTYPE, strValue);
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

    public final boolean isPPSDEFORMDETAILIDNull() {
        return this.isParamNull(TAG_PPSDEFORMDETAILID);
    }

    public final String getPPSDEFORMDETAILID() {
        return this.getParamStringValue(TAG_PPSDEFORMDETAILID, "");
    }

    public final void setPPSDEFORMDETAILID(String strValue) {
        this.setParamValue(TAG_PPSDEFORMDETAILID, strValue);
    }

    public final boolean isPPSDEFORMDETAILNAMENull() {
        return this.isParamNull(TAG_PPSDEFORMDETAILNAME);
    }

    public final String getPPSDEFORMDETAILNAME() {
        return this.getParamStringValue(TAG_PPSDEFORMDETAILNAME, "");
    }

    public final void setPPSDEFORMDETAILNAME(String strValue) {
        this.setParamValue(TAG_PPSDEFORMDETAILNAME, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.isParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.getParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.setParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.isParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.getParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.setParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isCTRLWIDTHNull() {
        return this.isParamNull(TAG_CTRLWIDTH);
    }

    public final int getCTRLWIDTH() {
        return this.getParamIntValue(TAG_CTRLWIDTH, 0);
    }

    public final void setCTRLWIDTH(int nValue) {
        this.setParamValue(TAG_CTRLWIDTH, nValue);
    }

    public final boolean isCTRLHEIGHTNull() {
        return this.isParamNull(TAG_CTRLHEIGHT);
    }

    public final int getCTRLHEIGHT() {
        return this.getParamIntValue(TAG_CTRLHEIGHT, 0);
    }

    public final void setCTRLHEIGHT(int nValue) {
        this.setParamValue(TAG_CTRLHEIGHT, nValue);
    }

    public final boolean isSHOWCAPTIONNull() {
        return this.isParamNull(TAG_SHOWCAPTION);
    }

    public final boolean getSHOWCAPTION() {
        return this.getParamIntValue(TAG_SHOWCAPTION, 0) == 1;
    }

    public final void setSHOWCAPTION(boolean bValue) {
        this.setParamValue(TAG_SHOWCAPTION, bValue ? 1 : 0);
    }

    public final boolean isCOLIDNull() {
        return this.isParamNull(TAG_COLID);
    }

    public final int getCOLID() {
        return this.getParamIntValue(TAG_COLID, 0);
    }

    public final void setCOLID(int nValue) {
        this.setParamValue(TAG_COLID, nValue);
    }

    public final boolean isCOLSPANNull() {
        return this.isParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.getParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.setParamValue(TAG_COLSPAN, nValue);
    }

    public final boolean isROWSPANNull() {
        return this.isParamNull(TAG_ROWSPAN);
    }

    public final int getROWSPAN() {
        return this.getParamIntValue(TAG_ROWSPAN, 0);
    }

    public final void setROWSPAN(int nValue) {
        this.setParamValue(TAG_ROWSPAN, nValue);
    }

    public final boolean isCOLMODELNull() {
        return this.isParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.getParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.setParamValue(TAG_COLMODEL, strValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.isParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.getParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.setParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isMARGINNull() {
        return this.isParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.getParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.setParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.isParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.getParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.setParamValue(TAG_PADDING, strValue);
    }

    public final boolean isLABELPOSNull() {
        return this.isParamNull(TAG_LABELPOS);
    }

    public final String getLABELPOS() {
        return this.getParamStringValue(TAG_LABELPOS, "");
    }

    public final void setLABELPOS(String strValue) {
        this.setParamValue(TAG_LABELPOS, strValue);
    }

    public final boolean isLABELWIDTHNull() {
        return this.isParamNull(TAG_LABELWIDTH);
    }

    public final int getLABELWIDTH() {
        return this.getParamIntValue(TAG_LABELWIDTH, 0);
    }

    public final void setLABELWIDTH(int nValue) {
        this.setParamValue(TAG_LABELWIDTH, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.isParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.getParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.setParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isLEVELNAMENull() {
        return this.isParamNull(TAG_LEVELNAME);
    }

    public final String getLEVELNAME() {
        return this.getParamStringValue(TAG_LEVELNAME, "");
    }

    public final void setLEVELNAME(String strValue) {
        this.setParamValue(TAG_LEVELNAME, strValue);
    }

    public final boolean isGRIDROWIDNull() {
        return this.isParamNull(TAG_GRIDROWID);
    }

    public final int getGRIDROWID() {
        return this.getParamIntValue(TAG_GRIDROWID, 0);
    }

    public final void setGRIDROWID(int nValue) {
        this.setParamValue(TAG_GRIDROWID, nValue);
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

    public final boolean isFORMTYPENull() {
        return this.isParamNull(TAG_FORMTYPE);
    }

    public final String getFORMTYPE() {
        return this.getParamStringValue(TAG_FORMTYPE, "");
    }

    public final void setFORMTYPE(String strValue) {
        this.setParamValue(TAG_FORMTYPE, strValue);
    }

    public final boolean isPSDEFSFITEMIDNull() {
        return this.isParamNull(TAG_PSDEFSFITEMID);
    }

    public final String getPSDEFSFITEMID() {
        return this.getParamStringValue(TAG_PSDEFSFITEMID, "");
    }

    public final void setPSDEFSFITEMID(String strValue) {
        this.setParamValue(TAG_PSDEFSFITEMID, strValue);
    }

    public final boolean isPSDEFSFITEMNAMENull() {
        return this.isParamNull(TAG_PSDEFSFITEMNAME);
    }

    public final String getPSDEFSFITEMNAME() {
        return this.getParamStringValue(TAG_PSDEFSFITEMNAME, "");
    }

    public final void setPSDEFSFITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFSFITEMNAME, strValue);
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

    public final boolean isPSDEDRITEMIDNull() {
        return this.isParamNull(TAG_PSDEDRITEMID);
    }

    public final String getPSDEDRITEMID() {
        return this.getParamStringValue(TAG_PSDEDRITEMID, "");
    }

    public final void setPSDEDRITEMID(String strValue) {
        this.setParamValue(TAG_PSDEDRITEMID, strValue);
    }

    public final boolean isPSDEDRITEMNAMENull() {
        return this.isParamNull(TAG_PSDEDRITEMNAME);
    }

    public final String getPSDEDRITEMNAME() {
        return this.getParamStringValue(TAG_PSDEDRITEMNAME, "");
    }

    public final void setPSDEDRITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEDRITEMNAME, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isENABLECONDNull() {
        return this.isParamNull(TAG_ENABLECOND);
    }

    public final int getENABLECOND() {
        return this.getParamIntValue(TAG_ENABLECOND, 0);
    }

    public final void setENABLECOND(int nValue) {
        this.setParamValue(TAG_ENABLECOND, nValue);
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

    public final boolean isCREATEDVNull() {
        return this.isParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.getParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.setParamValue(TAG_CREATEDV, strValue);
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

    public final boolean isCREATEDVTNull() {
        return this.isParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.getParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.setParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isPSDEFIUPDATEIDNull() {
        return this.isParamNull(TAG_PSDEFIUPDATEID);
    }

    public final String getPSDEFIUPDATEID() {
        return this.getParamStringValue(TAG_PSDEFIUPDATEID, "");
    }

    public final void setPSDEFIUPDATEID(String strValue) {
        this.setParamValue(TAG_PSDEFIUPDATEID, strValue);
    }

    public final boolean isPSDEFIUPDATENAMENull() {
        return this.isParamNull(TAG_PSDEFIUPDATENAME);
    }

    public final String getPSDEFIUPDATENAME() {
        return this.getParamStringValue(TAG_PSDEFIUPDATENAME, "");
    }

    public final void setPSDEFIUPDATENAME(String strValue) {
        this.setParamValue(TAG_PSDEFIUPDATENAME, strValue);
    }

    public final boolean isPSDEFORMRFIDNull() {
        return this.isParamNull(TAG_PSDEFORMRFID);
    }

    public final String getPSDEFORMRFID() {
        return this.getParamStringValue(TAG_PSDEFORMRFID, "");
    }

    public final void setPSDEFORMRFID(String strValue) {
        this.setParamValue(TAG_PSDEFORMRFID, strValue);
    }

    public final boolean isPSDEFORMRFNAMENull() {
        return this.isParamNull(TAG_PSDEFORMRFNAME);
    }

    public final String getPSDEFORMRFNAME() {
        return this.getParamStringValue(TAG_PSDEFORMRFNAME, "");
    }

    public final void setPSDEFORMRFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMRFNAME, strValue);
    }

    public final boolean isREFPSDEFORMIDNull() {
        return this.isParamNull(TAG_REFPSDEFORMID);
    }

    public final String getREFPSDEFORMID() {
        return this.getParamStringValue(TAG_REFPSDEFORMID, "");
    }

    public final void setREFPSDEFORMID(String strValue) {
        this.setParamValue(TAG_REFPSDEFORMID, strValue);
    }

    public final boolean isREFPSDEFORMDETAILIDNull() {
        return this.isParamNull(TAG_REFPSDEFORMDETAILID);
    }

    public final String getREFPSDEFORMDETAILID() {
        return this.getParamStringValue(TAG_REFPSDEFORMDETAILID, "");
    }

    public final void setREFPSDEFORMDETAILID(String strValue) {
        this.setParamValue(TAG_REFPSDEFORMDETAILID, strValue);
    }

    public final boolean isREFPSDEFORMDETAILNAMENull() {
        return this.isParamNull(TAG_REFPSDEFORMDETAILNAME);
    }

    public final String getREFPSDEFORMDETAILNAME() {
        return this.getParamStringValue(TAG_REFPSDEFORMDETAILNAME, "");
    }

    public final void setREFPSDEFORMDETAILNAME(String strValue) {
        this.setParamValue(TAG_REFPSDEFORMDETAILNAME, strValue);
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

    public final boolean isCSSTYLENull() {
        return this.isParamNull(TAG_CSSTYLE);
    }

    public final String getCSSTYLE() {
        return this.getParamStringValue(TAG_CSSTYLE, "");
    }

    public final void setCSSTYLE(String strValue) {
        this.setParamValue(TAG_CSSTYLE, strValue);
    }

    public final boolean isLABELCOLSPANNull() {
        return this.isParamNull(TAG_LABELCOLSPAN);
    }

    public final int getLABELCOLSPAN() {
        return this.getParamIntValue(TAG_LABELCOLSPAN, 0);
    }

    public final void setLABELCOLSPAN(int nValue) {
        this.setParamValue(TAG_LABELCOLSPAN, nValue);
    }

    public final boolean isCTRLCOLSPANNull() {
        return this.isParamNull(TAG_CTRLCOLSPAN);
    }

    public final int getCTRLCOLSPAN() {
        return this.getParamIntValue(TAG_CTRLCOLSPAN, 0);
    }

    public final void setCTRLCOLSPAN(int nValue) {
        this.setParamValue(TAG_CTRLCOLSPAN, nValue);
    }

    public final boolean isLABELCOLSPAN2Null() {
        return this.isParamNull(TAG_LABELCOLSPAN2);
    }

    public final int getLABELCOLSPAN2() {
        return this.getParamIntValue(TAG_LABELCOLSPAN2, 0);
    }

    public final void setLABELCOLSPAN2(int nValue) {
        this.setParamValue(TAG_LABELCOLSPAN2, nValue);
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

    public final boolean isVALUEITEMNAMENull() {
        return this.isParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.getParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.setParamValue(TAG_VALUEITEMNAME, strValue);
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

    public final boolean isCOL_XSNull() {
        return this.isParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.getParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.setParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.isParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.getParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.setParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.isParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.getParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.setParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.isParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.getParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.setParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.isParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.getParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.setParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.isParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.getParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.setParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.isParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.getParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.setParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.isParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.getParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.setParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCHILD_COL_XSNull() {
        return this.isParamNull(TAG_CHILD_COL_XS);
    }

    public final int getCHILD_COL_XS() {
        return this.getParamIntValue(TAG_CHILD_COL_XS, 0);
    }

    public final void setCHILD_COL_XS(int nValue) {
        this.setParamValue(TAG_CHILD_COL_XS, nValue);
    }

    public final boolean isCHILD_COL_SMNull() {
        return this.isParamNull(TAG_CHILD_COL_SM);
    }

    public final int getCHILD_COL_SM() {
        return this.getParamIntValue(TAG_CHILD_COL_SM, 0);
    }

    public final void setCHILD_COL_SM(int nValue) {
        this.setParamValue(TAG_CHILD_COL_SM, nValue);
    }

    public final boolean isCHILD_COL_MDNull() {
        return this.isParamNull(TAG_CHILD_COL_MD);
    }

    public final int getCHILD_COL_MD() {
        return this.getParamIntValue(TAG_CHILD_COL_MD, 0);
    }

    public final void setCHILD_COL_MD(int nValue) {
        this.setParamValue(TAG_CHILD_COL_MD, nValue);
    }

    public final boolean isCHILD_COL_LGNull() {
        return this.isParamNull(TAG_CHILD_COL_LG);
    }

    public final int getCHILD_COL_LG() {
        return this.getParamIntValue(TAG_CHILD_COL_LG, 0);
    }

    public final void setCHILD_COL_LG(int nValue) {
        this.setParamValue(TAG_CHILD_COL_LG, nValue);
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

    public final boolean isBTNACTIONTYPENull() {
        return this.isParamNull(TAG_BTNACTIONTYPE);
    }

    public final String getBTNACTIONTYPE() {
        return this.getParamStringValue(TAG_BTNACTIONTYPE, "");
    }

    public final void setBTNACTIONTYPE(String strValue) {
        this.setParamValue(TAG_BTNACTIONTYPE, strValue);
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

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.isParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.getParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isRAWCONTENTNull() {
        return this.isParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.getParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.setParamValue(TAG_RAWCONTENT, strValue);
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

    public final boolean isRESETITEMNAMENull() {
        return this.isParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.getParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.setParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isEMPTYCAPTIONNull() {
        return this.isParamNull(TAG_EMPTYCAPTION);
    }

    public final boolean getEMPTYCAPTION() {
        return this.getParamIntValue(TAG_EMPTYCAPTION, 0) == 1;
    }

    public final void setEMPTYCAPTION(boolean bValue) {
        this.setParamValue(TAG_EMPTYCAPTION, bValue ? 1 : 0);
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

    public final boolean isPLACEHOLDERNull() {
        return this.isParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.getParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.setParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.isParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.isParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isITEMPSACHANDLERIDNull() {
        return this.isParamNull(TAG_ITEMPSACHANDLERID);
    }

    public final String getITEMPSACHANDLERID() {
        return this.getParamStringValue(TAG_ITEMPSACHANDLERID, "");
    }

    public final void setITEMPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_ITEMPSACHANDLERID, strValue);
    }

    public final boolean isITEMPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_ITEMPSACHANDLERNAME);
    }

    public final String getITEMPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_ITEMPSACHANDLERNAME, "");
    }

    public final void setITEMPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_ITEMPSACHANDLERNAME, strValue);
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

    public final boolean isCODELISTCONFIGMODENull() {
        return this.isParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.getParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.setParamValue(TAG_CODELISTCONFIGMODE, nValue);
    }

    public final boolean isTITLEBARCLOSEMODENull() {
        return this.isParamNull(TAG_TITLEBARCLOSEMODE);
    }

    public final int getTITLEBARCLOSEMODE() {
        return this.getParamIntValue(TAG_TITLEBARCLOSEMODE, 0);
    }

    public final void setTITLEBARCLOSEMODE(int nValue) {
        this.setParamValue(TAG_TITLEBARCLOSEMODE, nValue);
    }

    public final boolean isUCPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_UCPSSYSPFPLUGINID);
    }

    public final String getUCPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_UCPSSYSPFPLUGINID, "");
    }

    public final void setUCPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_UCPSSYSPFPLUGINID, strValue);
    }

    public final boolean isUCPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_UCPSSYSPFPLUGINNAME);
    }

    public final String getUCPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_UCPSSYSPFPLUGINNAME, "");
    }

    public final void setUCPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_UCPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isLABELPSSYSCSSIDNull() {
        return this.isParamNull(TAG_LABELPSSYSCSSID);
    }

    public final String getLABELPSSYSCSSID() {
        return this.getParamStringValue(TAG_LABELPSSYSCSSID, "");
    }

    public final void setLABELPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_LABELPSSYSCSSID, strValue);
    }

    public final boolean isLABELPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_LABELPSSYSCSSNAME);
    }

    public final String getLABELPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_LABELPSSYSCSSNAME, "");
    }

    public final void setLABELPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_LABELPSSYSCSSNAME, strValue);
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

    public final boolean isCOL_WIDTHNull() {
        return this.isParamNull(TAG_COL_WIDTH);
    }

    public final int getCOL_WIDTH() {
        return this.getParamIntValue(TAG_COL_WIDTH, 0);
    }

    public final void setCOL_WIDTH(int nValue) {
        this.setParamValue(TAG_COL_WIDTH, nValue);
    }

    public final boolean isWBDEFMODENull() {
        return this.isParamNull(TAG_WBDEFMODE);
    }

    public final int getWBDEFMODE() {
        return this.getParamIntValue(TAG_WBDEFMODE, 0);
    }

    public final void setWBDEFMODE(int nValue) {
        this.setParamValue(TAG_WBDEFMODE, nValue);
    }

    public final boolean isCONVERTCITEXTNull() {
        return this.isParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.getParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.setParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isENABLEANCHORNull() {
        return this.isParamNull(TAG_ENABLEANCHOR);
    }

    public final boolean getENABLEANCHOR() {
        return this.getParamIntValue(TAG_ENABLEANCHOR, 0) == 1;
    }

    public final void setENABLEANCHOR(boolean bValue) {
        this.setParamValue(TAG_ENABLEANCHOR, bValue ? 1 : 0);
    }

    public final boolean isBUILDINACTIONNull() {
        return this.isParamNull(TAG_BUILDINACTION);
    }

    public final int getBUILDINACTION() {
        return this.getParamIntValue(TAG_BUILDINACTION, 0);
    }

    public final void setBUILDINACTION(int nValue) {
        this.setParamValue(TAG_BUILDINACTION, nValue);
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

    public final boolean isDETAILSTYLENull() {
        return this.isParamNull(TAG_DETAILSTYLE);
    }

    public final String getDETAILSTYLE() {
        return this.getParamStringValue(TAG_DETAILSTYLE, "");
    }

    public final void setDETAILSTYLE(String strValue) {
        this.setParamValue(TAG_DETAILSTYLE, strValue);
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

    public final boolean isBL_POSNull() {
        return this.isParamNull(TAG_BL_POS);
    }

    public final String getBL_POS() {
        return this.getParamStringValue(TAG_BL_POS, "");
    }

    public final void setBL_POS(String strValue) {
        this.setParamValue(TAG_BL_POS, strValue);
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

    public ArrayList<PSDEFormDetail> getChildPSDEFormDetails(boolean bCreated) {
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

