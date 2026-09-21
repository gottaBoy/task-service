/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSPanelItemLogic;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PSSysPanelItem
extends BaseDataEntity {
    public static final String LAYOUTMODE_AUTOTABLE = "AUTOTABLE";
    public static final String LAYOUTMODE_TABLE = "TABLE";
    public static final String LAYOUTMODE_TABLE_12COL = "TABLE_12COL";
    public static final String LAYOUTMODE_TABLE_24COL = "TABLE_24COL";
    public static final String LAYOUTMODE_BORDER = "BORDER";
    public static final String ITEMTYPE_PANEL = "PANEL";
    public static final String ITEMTYPE_CTRL = "CTRL";
    public static final String ITEMTYPE_RAWITEM = "RAWITEM";
    public static final String ITEMTYPE_TABPANEL = "TABPANEL";
    public static final String ITEMTYPE_TAGPAGE = "TAGPAGE";
    public static final String ITEMTYPE_PANELPART = "PANELPART";
    public static final String ITEMTYPE_CONTAINER = "CONTAINER";
    public static final String CAPTIONPOS_LEFT = "LEFT";
    public static final String CAPTIONPOS_TOP = "TOP";
    public static final String CAPTIONPOS_RIGHT = "RIGHT";
    public static final String CAPTIONPOS_BOTTOM = "BOTTOM";
    public static final String CAPTIONPOS_NONE = "NONE";
    public static final String BL_POS_NORTH = "NORTH";
    public static final String BL_POS_WEST = "WEST";
    public static final String BL_POS_EAST = "EAST";
    public static final String BL_POS_SOUTH = "SOUTH";
    public static final String BL_POS_CENTER = "CENTER";
    public static final String DETAILSTYLE_DEFAULT = "DEFAULT";
    public static final String DETAILSTYLE_STYLE2 = "STYLE2";
    public static final String DETAILSTYLE_STYLE3 = "STYLE3";
    public static final String DETAILSTYLE_STYLE4 = "STYLE4";
    public static final String CTRLTYPE_TOOLBAR = "TOOLBAR";
    public static final String CTRLTYPE_GRID = "GRID";
    public static final String CTRLTYPE_FORM = "FORM";
    public static final String CTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String CTRLTYPE_DRBAR = "DRBAR";
    public static final String CTRLTYPE_DRTAB = "DRTAB";
    public static final String CTRLTYPE_VIEWPANEL = "VIEWPANEL";
    public static final String CTRLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String CTRLTYPE_DATAVIEW = "DATAVIEW";
    public static final String CTRLTYPE_EXPBAR = "EXPBAR";
    public static final String CTRLTYPE_WFEXPBAR = "WFEXPBAR";
    public static final String CTRLTYPE_TREEGRID = "TREEGRID";
    public static final String CTRLTYPE_TREEVIEW = "TREEVIEW";
    public static final String CTRLTYPE_TABVIEWPANEL = "TABVIEWPANEL";
    public static final String CTRLTYPE_TREEEXPBAR = "TREEEXPBAR";
    public static final String CTRLTYPE_CHART = "CHART";
    public static final String CTRLTYPE_REPORTPANEL = "REPORTPANEL";
    public static final String CTRLTYPE_LIST = "LIST";
    public static final String CTRLTYPE_MOBMDCTRL = "MOBMDCTRL";
    public static final String CTRLTYPE_MULTIEDITVIEWPANEL = "MULTIEDITVIEWPANEL";
    public static final String CTRLTYPE_WIZARDPANEL = "WIZARDPANEL";
    public static final String CTRLTYPE_DASHBOARD = "DASHBOARD";
    public static final String CTRLTYPE_CALENDAR = "CALENDAR";
    public static final String EDITORTYPE_AC = "AC";
    public static final String EDITORTYPE_AC_FS = "AC_FS";
    public static final String EDITORTYPE_AC_FS_NOBUTTON = "AC_FS_NOBUTTON";
    public static final String EDITORTYPE_AC_NOBUTTON = "AC_NOBUTTON";
    public static final String EDITORTYPE_ADDRESSPICKUP = "ADDRESSPICKUP";
    public static final String EDITORTYPE_ADDRESSPICKUP_AC = "ADDRESSPICKUP_AC";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_DATEPICKEREX = "DATEPICKEREX";
    public static final String EDITORTYPE_DATEPICKEREX_HOUR = "DATEPICKEREX_HOUR";
    public static final String EDITORTYPE_DATEPICKEREX_MINUTE = "DATEPICKEREX_MINUTE";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY = "DATEPICKEREX_NODAY";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY_NOSECOND = "DATEPICKEREX_NODAY_NOSECOND";
    public static final String EDITORTYPE_DATEPICKEREX_NOTIME = "DATEPICKEREX_NOTIME";
    public static final String EDITORTYPE_DATEPICKEREX_SECOND = "DATEPICKEREX_SECOND";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_DROPDOWNLIST_100 = "DROPDOWNLIST_100";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_LISTBOXPICKUP = "LISTBOXPICKUP";
    public static final String EDITORTYPE_OFFICEEDITOR = "OFFICEEDITOR";
    public static final String EDITORTYPE_OFFICEEDITOR2 = "OFFICEEDITOR2";
    public static final String EDITORTYPE_PASSWORD = "PASSWORD";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_PICKEREX_LINK = "PICKEREX_LINK";
    public static final String EDITORTYPE_PICKEREX_NOAC = "PICKEREX_NOAC";
    public static final String EDITORTYPE_PICKEREX_NOAC_LINK = "PICKEREX_NOAC_LINK";
    public static final String EDITORTYPE_PICKEREX_NOBUTTON = "PICKEREX_NOBUTTON";
    public static final String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String EDITORTYPE_PICKEREX_TRIGGER_LINK = "PICKEREX_TRIGGER_LINK";
    public static final String EDITORTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String EDITORTYPE_PICTURE = "PICTURE";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_SPANEX = "SPANEX";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_TEXTAREA_10 = "TEXTAREA_10";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final int COLLAPSIBLEFLAG_UNSUPPORTED = 0;
    public static final int COLLAPSIBLEFLAG_SUPPORTED = 1;
    public static final int COLLAPSIBLEFLAG_SUPPORTEDANDHIDEDEFAULT = 2;
    public static final int TITLEBARCLOSEMODE_UNSUPPORTED = 0;
    public static final int TITLEBARCLOSEMODE_SUPPORTED = 1;
    public static final int TITLEBARCLOSEMODE_SUPPORTEDANDHIDEDEFAULT = 2;
    public static final String TAG_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String TAG_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PPSSYSVIEWPANELITEMID = "PPSSYSVIEWPANELITEMID";
    public static final String TAG_PPSSYSVIEWPANELITEMNAME = "PPSSYSVIEWPANELITEMNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_RIGHTPOS = "RIGHTPOS";
    public static final String TAG_BOTTOMPOS = "BOTTOMPOS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_EMPTYCAPTION = "EMPTYCAPTION";
    public static final String TAG_CAPTIONPOS = "CAPTIONPOS";
    public static final String TAG_BL_POS = "BL_POS";
    public static final String TAG_DETAILSTYLE = "DETAILSTYLE";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_COL_WIDTH = "COL_WIDTH";
    public static final String TAG_CHILD_COL_LG = "CHILD_COL_LG";
    public static final String TAG_CHILD_COL_MD = "CHILD_COL_MD";
    public static final String TAG_CHILD_COL_SM = "CHILD_COL_SM";
    public static final String TAG_CHILD_COL_XS = "CHILD_COL_XS";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COLMODEL = "COLMODEL";
    public static final String TAG_ROWSPAN = "ROWSPAN";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_COLID = "COLID";
    public static final String TAG_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String TAG_CTRLWIDTH = "CTRLWIDTH";
    public static final String TAG_CTRLTYPE = "CTRLTYPE";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String TAG_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String TAG_GRIDROWID = "GRIDROWID";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_HTMLCONTENT = "HTMLCONTENT";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_FIELDNAME = "FIELDNAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_COLLAPSIBLEFLAG = "COLLAPSIBLEFLAG";
    public static final String TAG_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_FLEXGROW = "FLEXGROW";
    public static final String TAG_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String TAG_ENABLELOGIC = "ENABLELOGIC";
    public static final String TAG_BLANKLOGIC = "BLANKLOGIC";
    public static final String TAG_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String TAG_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String TAG_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String TAG_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_PSDESEARCHFORMID = "PSDESEARCHFORMID";
    public static final String TAG_PSDESEARCHFORMNAME = "PSDESEARCHFORMNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_ITEMPARAM = "ITEMPARAM";
    public static final String TAG_ITEMPARAM10 = "ITEMPARAM10";
    public static final String TAG_ITEMPARAM11 = "ITEMPARAM11";
    public static final String TAG_ITEMPARAM12 = "ITEMPARAM12";
    public static final String TAG_ITEMPARAM2 = "ITEMPARAM2";
    public static final String TAG_ITEMPARAM3 = "ITEMPARAM3";
    public static final String TAG_ITEMPARAM4 = "ITEMPARAM4";
    public static final String TAG_ITEMPARAM5 = "ITEMPARAM5";
    public static final String TAG_ITEMPARAM6 = "ITEMPARAM6";
    public static final String TAG_ITEMPARAM7 = "ITEMPARAM7";
    public static final String TAG_ITEMPARAM8 = "ITEMPARAM8";
    public static final String TAG_ITEMPARAM9 = "ITEMPARAM9";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String TAG_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String TAG_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String TAG_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_ITEMPARAMS = "ITEMPARAMS";
    public static final String TAG_AL_POS = "AL_POS";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String TAG_PHPSLANRESID = "PHPSLANRESID";
    public static final String TAG_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String TAG_PSDEPANELID = "PSDEPANELID";
    public static final String TAG_PSDEPANELNAME = "PSDEPANELNAME";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String TAG_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String TAG_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String TAG_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String TAG_REFLINKPSDEVIEWID = "REFLINKPSDEVIEWID";
    public static final String TAG_REFLINKPSDEVIEWNAME = "REFLINKPSDEVIEWNAME";
    public static final String TAG_IGNOREINPUT = "IGNOREINPUT";
    public static final String TAG_FIELDSTATES = "FIELDSTATES";
    public static final String TAG_SPACINGTOP = "SPACINGTOP";
    public static final String TAG_SPACINGBOTTOM = "SPACINGBOTTOM";
    public static final String TAG_SPACINGLEFT = "SPACINGLEFT";
    public static final String TAG_SPACINGRIGHT = "SPACINGRIGHT";
    public static final String TAG_REFCTRL2USAGE = "REFCTRL2USAGE";
    public static final String TAG_REFCTRLUSAGE = "REFCTRLUSAGE";
    public static final String TAG_REFCTRL2NAME = "REFCTRL2NAME";
    public static final String TAG_REFCTRLNAME = "REFCTRLNAME";
    public static final String TAG_VALIGN = "VALIGN";
    public static final String TAG_HALIGN = "HALIGN";
    public static final String TAG_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String TAG_LABELRAWCSSSTYLE = "LABELRAWCSSSTYLE";
    public static final String TAG_LABELDYNACLASS = "LABELDYNACLASS";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_HALIGNSELF = "HALIGNSELF";
    public static final String TAG_VALIGNSELF = "VALIGNSELF";
    public static final String TAG_DETAILSTYLETEXT = "DETAILSTYLETEXT";
    public static final String TAG_RENDERMODE = "RENDERMODE";
    public static final String TAG_RENDERMODETEXT = "RENDERMODETEXT";
    public static final String TAG_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String TAG_TOGGLEMODE = "TOGGLEMODE";
    public static final String TAG_BORDERSTYLE = "BORDERSTYLE";
    public static final String TAG_ORIENTATIONMODE = "ORIENTATIONMODE";
    public static final String TAG_ICONALIGN = "ICONALIGN";
    public static final String TAG_REFCTRLUSAGETEXT = "REFCTRLUSAGETEXT";
    public static final String TAG_REFCTRL2USAGETEXT = "REFCTRL2USAGETEXT";
    public static final String TAG_TABINDEX = "TABINDEX";
    public static final String TAG_HEIGHTMODE = "HEIGHTMODE";
    public static final String TAG_WIDTHMODE = "WIDTHMODE";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String TAG_SWAPMODE = "SWAPMODE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_DATAPANELMODE = "DATAPANELMODE";
    public static final String TAG_DATASOURCE = "DATASOURCE";
    public static final String TAG_GETDATATIMER = "GETDATATIMER";
    public static final String TAG_OPENPSDEVIEWID = "OPENPSDEVIEWID";
    public static final String TAG_OPENPSDEVIEWNAME = "OPENPSDEVIEWNAME";
    public static final String TAG_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String TAG_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String TAG_OPENPSSYSPDTVIEWID = "OPENPSSYSPDTVIEWID";
    public static final String TAG_OPENPSSYSPDTVIEWNAME = "OPENPSSYSPDTVIEWNAME";
    public static final String TAG_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_CTRLPSSYSCSSID = "CTRLPSSYSCSSID";
    public static final String TAG_CTRLPSSYSCSSNAME = "CTRLPSSYSCSSNAME";
    public static final String TAG_CTRLDYNACLASS = "CTRLDYNACLASS";
    public static final String TAG_CTRLRAWCSSSTYLE = "CTRLRAWCSSSTYLE";
    public static final String TAG_LOCALMODE = "LOCALMODE";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_ACTIVEDATAMODE = "ACTIVEDATAMODE";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_COUNTERID = "COUNTERID";
    private ArrayList<PSSysPanelItem> childPSSysPanelItemList = null;
    private HashMap<String, ArrayList<PSPanelItemLogic>> childPSPanelItemLogicListMap = null;

    public final boolean isPSSYSVIEWPANELITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMID);
    }

    public final String getPSSYSVIEWPANELITEMID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMID, "");
    }

    public final void setPSSYSVIEWPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMID, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMNAME);
    }

    public final String getPSSYSVIEWPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMNAME, "");
    }

    public final void setPSSYSVIEWPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMNAME, strValue);
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

    public final boolean isPPSSYSVIEWPANELITEMIDNull() {
        return this.IsParamNull(TAG_PPSSYSVIEWPANELITEMID);
    }

    public final String getPPSSYSVIEWPANELITEMID() {
        return this.GetParamStringValue(TAG_PPSSYSVIEWPANELITEMID, "");
    }

    public final void setPPSSYSVIEWPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PPSSYSVIEWPANELITEMID, strValue);
    }

    public final boolean isPPSSYSVIEWPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PPSSYSVIEWPANELITEMNAME);
    }

    public final String getPPSSYSVIEWPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PPSSYSVIEWPANELITEMNAME, "");
    }

    public final void setPPSSYSVIEWPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSVIEWPANELITEMNAME, strValue);
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

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isRIGHTPOSNull() {
        return this.IsParamNull(TAG_RIGHTPOS);
    }

    public final int getRIGHTPOS() {
        return this.GetParamIntValue(TAG_RIGHTPOS, 0);
    }

    public final void setRIGHTPOS(int nValue) {
        this.SetParamValue(TAG_RIGHTPOS, nValue);
    }

    public final boolean isBOTTOMPOSNull() {
        return this.IsParamNull(TAG_BOTTOMPOS);
    }

    public final int getBOTTOMPOS() {
        return this.GetParamIntValue(TAG_BOTTOMPOS, 0);
    }

    public final void setBOTTOMPOS(int nValue) {
        this.SetParamValue(TAG_BOTTOMPOS, nValue);
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

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
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

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
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

    public final boolean isPSDECHARTIDNull() {
        return this.IsParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.GetParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
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

    public final boolean isEMPTYCAPTIONNull() {
        return this.IsParamNull(TAG_EMPTYCAPTION);
    }

    public final boolean getEMPTYCAPTION() {
        return this.GetParamIntValue(TAG_EMPTYCAPTION, 0) == 1;
    }

    public final void setEMPTYCAPTION(boolean bValue) {
        this.SetParamValue(TAG_EMPTYCAPTION, bValue ? 1 : 0);
    }

    public final boolean isCAPTIONPOSNull() {
        return this.IsParamNull(TAG_CAPTIONPOS);
    }

    public final String getCAPTIONPOS() {
        return this.GetParamStringValue(TAG_CAPTIONPOS, "");
    }

    public final void setCAPTIONPOS(String strValue) {
        this.SetParamValue(TAG_CAPTIONPOS, strValue);
    }

    public final boolean isBL_POSNull() {
        return this.IsParamNull(TAG_BL_POS);
    }

    public final String getBL_POS() {
        return this.GetParamStringValue(TAG_BL_POS, "");
    }

    public final void setBL_POS(String strValue) {
        this.SetParamValue(TAG_BL_POS, strValue);
    }

    public final boolean isDETAILSTYLENull() {
        return this.IsParamNull(TAG_DETAILSTYLE);
    }

    public final String getDETAILSTYLE() {
        return this.GetParamStringValue(TAG_DETAILSTYLE, "");
    }

    public final void setDETAILSTYLE(String strValue) {
        this.SetParamValue(TAG_DETAILSTYLE, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isCHILD_COL_LGNull() {
        return this.IsParamNull(TAG_CHILD_COL_LG);
    }

    public final int getCHILD_COL_LG() {
        return this.GetParamIntValue(TAG_CHILD_COL_LG, 0);
    }

    public final void setCHILD_COL_LG(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_LG, nValue);
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

    public final boolean isCHILD_COL_SMNull() {
        return this.IsParamNull(TAG_CHILD_COL_SM);
    }

    public final int getCHILD_COL_SM() {
        return this.GetParamIntValue(TAG_CHILD_COL_SM, 0);
    }

    public final void setCHILD_COL_SM(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_SM, nValue);
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

    public final boolean isCOL_MD_OSNull() {
        return this.IsParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.GetParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.SetParamValue(TAG_COL_MD_OS, nValue);
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

    public final boolean isCOL_XS_OSNull() {
        return this.IsParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.GetParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.SetParamValue(TAG_COL_XS_OS, nValue);
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

    public final boolean isCOL_LGNull() {
        return this.IsParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.GetParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.SetParamValue(TAG_COL_LG, nValue);
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

    public final boolean isCOL_SMNull() {
        return this.IsParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.GetParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.SetParamValue(TAG_COL_SM, nValue);
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

    public final boolean isCOLMODELNull() {
        return this.IsParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.GetParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.SetParamValue(TAG_COLMODEL, strValue);
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

    public final boolean isCOLSPANNull() {
        return this.IsParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.GetParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.SetParamValue(TAG_COLSPAN, nValue);
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

    public final boolean isCTRLHEIGHTNull() {
        return this.IsParamNull(TAG_CTRLHEIGHT);
    }

    public final int getCTRLHEIGHT() {
        return this.GetParamIntValue(TAG_CTRLHEIGHT, 0);
    }

    public final void setCTRLHEIGHT(int nValue) {
        this.SetParamValue(TAG_CTRLHEIGHT, nValue);
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

    public final boolean isCTRLTYPENull() {
        return this.IsParamNull(TAG_CTRLTYPE);
    }

    public final String getCTRLTYPE() {
        return this.GetParamStringValue(TAG_CTRLTYPE, "");
    }

    public final void setCTRLTYPE(String strValue) {
        this.SetParamValue(TAG_CTRLTYPE, strValue);
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

    public final boolean isGRIDROWIDNull() {
        return this.IsParamNull(TAG_GRIDROWID);
    }

    public final int getGRIDROWID() {
        return this.GetParamIntValue(TAG_GRIDROWID, 0);
    }

    public final void setGRIDROWID(int nValue) {
        this.SetParamValue(TAG_GRIDROWID, nValue);
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

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
    }

    public final boolean isHTMLCONTENTNull() {
        return this.IsParamNull(TAG_HTMLCONTENT);
    }

    public final String getHTMLCONTENT() {
        return this.GetParamStringValue(TAG_HTMLCONTENT, "");
    }

    public final void setHTMLCONTENT(String strValue) {
        this.SetParamValue(TAG_HTMLCONTENT, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
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

    public final boolean isCOLLAPSIBLEFLAGNull() {
        return this.IsParamNull(TAG_COLLAPSIBLEFLAG);
    }

    public final int getCOLLAPSIBLEFLAG() {
        return this.GetParamIntValue(TAG_COLLAPSIBLEFLAG, 0);
    }

    public final void setCOLLAPSIBLEFLAG(int nValue) {
        this.SetParamValue(TAG_COLLAPSIBLEFLAG, nValue);
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

    public final boolean isFLEXDIRNull() {
        return this.IsParamNull(TAG_FLEXDIR);
    }

    public final String getFLEXDIR() {
        return this.GetParamStringValue(TAG_FLEXDIR, "");
    }

    public final void setFLEXDIR(String strValue) {
        this.SetParamValue(TAG_FLEXDIR, strValue);
    }

    public final boolean isFLEXALIGNNull() {
        return this.IsParamNull(TAG_FLEXALIGN);
    }

    public final String getFLEXALIGN() {
        return this.GetParamStringValue(TAG_FLEXALIGN, "");
    }

    public final void setFLEXALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXALIGN, strValue);
    }

    public final boolean isFLEXVALIGNNull() {
        return this.IsParamNull(TAG_FLEXVALIGN);
    }

    public final String getFLEXVALIGN() {
        return this.GetParamStringValue(TAG_FLEXVALIGN, "");
    }

    public final void setFLEXVALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXVALIGN, strValue);
    }

    public final boolean isFLEXGROWNull() {
        return this.IsParamNull(TAG_FLEXGROW);
    }

    public final int getFLEXGROW() {
        return this.GetParamIntValue(TAG_FLEXGROW, 0);
    }

    public final void setFLEXGROW(int nValue) {
        this.SetParamValue(TAG_FLEXGROW, nValue);
    }

    public final boolean isVISIBLELOGICNull() {
        return this.IsParamNull(TAG_VISIBLELOGIC);
    }

    public final String getVISIBLELOGIC() {
        return this.GetParamStringValue(TAG_VISIBLELOGIC, "");
    }

    public final void setVISIBLELOGIC(String strValue) {
        this.SetParamValue(TAG_VISIBLELOGIC, strValue);
    }

    public final boolean isENABLELOGICNull() {
        return this.IsParamNull(TAG_ENABLELOGIC);
    }

    public final String getENABLELOGIC() {
        return this.GetParamStringValue(TAG_ENABLELOGIC, "");
    }

    public final void setENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_ENABLELOGIC, strValue);
    }

    public final boolean isBLANKLOGICNull() {
        return this.IsParamNull(TAG_BLANKLOGIC);
    }

    public final String getBLANKLOGIC() {
        return this.GetParamStringValue(TAG_BLANKLOGIC, "");
    }

    public final void setBLANKLOGIC(String strValue) {
        this.SetParamValue(TAG_BLANKLOGIC, strValue);
    }

    public final boolean isPSSYSDASHBOARDIDNull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDID);
    }

    public final String getPSSYSDASHBOARDID() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDID, "");
    }

    public final void setPSSYSDASHBOARDID(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDID, strValue);
    }

    public final boolean isPSSYSDASHBOARDNAMENull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDNAME);
    }

    public final String getPSSYSDASHBOARDNAME() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDNAME, "");
    }

    public final void setPSSYSDASHBOARDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDNAME, strValue);
    }

    public final boolean isPSSYSCALENDARIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARID, strValue);
    }

    public final boolean isPSSYSCALENDARNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARNAME);
    }

    public final String getPSSYSCALENDARNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARNAME, "");
    }

    public final void setPSSYSCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARNAME, strValue);
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

    public final boolean isPSDEDATAVIEWIDNull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWID);
    }

    public final String getPSDEDATAVIEWID() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWID, "");
    }

    public final void setPSDEDATAVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWID, strValue);
    }

    public final boolean isPSDEDATAVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWNAME);
    }

    public final String getPSDEDATAVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWNAME, "");
    }

    public final void setPSDEDATAVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWNAME, strValue);
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

    public final boolean isPSDESEARCHFORMIDNull() {
        return this.IsParamNull(TAG_PSDESEARCHFORMID);
    }

    public final String getPSDESEARCHFORMID() {
        return this.GetParamStringValue(TAG_PSDESEARCHFORMID, "");
    }

    public final void setPSDESEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_PSDESEARCHFORMID, strValue);
    }

    public final boolean isPSDESEARCHFORMNAMENull() {
        return this.IsParamNull(TAG_PSDESEARCHFORMNAME);
    }

    public final String getPSDESEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_PSDESEARCHFORMNAME, "");
    }

    public final void setPSDESEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDESEARCHFORMNAME, strValue);
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

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isITEMPARAMNull() {
        return this.IsParamNull(TAG_ITEMPARAM);
    }

    public final String getITEMPARAM() {
        return this.GetParamStringValue(TAG_ITEMPARAM, "");
    }

    public final void setITEMPARAM(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM, strValue);
    }

    public final boolean isITEMPARAM10Null() {
        return this.IsParamNull(TAG_ITEMPARAM10);
    }

    public final float getITEMPARAM10() {
        return this.GetParamFloatValue(TAG_ITEMPARAM10, 0.0f);
    }

    public final void setITEMPARAM10(float fValue) {
        this.SetParamValue(TAG_ITEMPARAM10, Float.valueOf(fValue));
    }

    public final boolean isITEMPARAM11Null() {
        return this.IsParamNull(TAG_ITEMPARAM11);
    }

    public final int getITEMPARAM11() {
        return this.GetParamIntValue(TAG_ITEMPARAM11, 0);
    }

    public final void setITEMPARAM11(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM11, nValue);
    }

    public final boolean isITEMPARAM12Null() {
        return this.IsParamNull(TAG_ITEMPARAM12);
    }

    public final int getITEMPARAM12() {
        return this.GetParamIntValue(TAG_ITEMPARAM12, 0);
    }

    public final void setITEMPARAM12(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM12, nValue);
    }

    public final boolean isITEMPARAM2Null() {
        return this.IsParamNull(TAG_ITEMPARAM2);
    }

    public final String getITEMPARAM2() {
        return this.GetParamStringValue(TAG_ITEMPARAM2, "");
    }

    public final void setITEMPARAM2(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM2, strValue);
    }

    public final boolean isITEMPARAM3Null() {
        return this.IsParamNull(TAG_ITEMPARAM3);
    }

    public final String getITEMPARAM3() {
        return this.GetParamStringValue(TAG_ITEMPARAM3, "");
    }

    public final void setITEMPARAM3(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM3, strValue);
    }

    public final boolean isITEMPARAM4Null() {
        return this.IsParamNull(TAG_ITEMPARAM4);
    }

    public final String getITEMPARAM4() {
        return this.GetParamStringValue(TAG_ITEMPARAM4, "");
    }

    public final void setITEMPARAM4(String strValue) {
        this.SetParamValue(TAG_ITEMPARAM4, strValue);
    }

    public final boolean isITEMPARAM5Null() {
        return this.IsParamNull(TAG_ITEMPARAM5);
    }

    public final boolean getITEMPARAM5() {
        return this.GetParamIntValue(TAG_ITEMPARAM5, 0) == 1;
    }

    public final void setITEMPARAM5(boolean bValue) {
        this.SetParamValue(TAG_ITEMPARAM5, bValue ? 1 : 0);
    }

    public final boolean isITEMPARAM6Null() {
        return this.IsParamNull(TAG_ITEMPARAM6);
    }

    public final boolean getITEMPARAM6() {
        return this.GetParamIntValue(TAG_ITEMPARAM6, 0) == 1;
    }

    public final void setITEMPARAM6(boolean bValue) {
        this.SetParamValue(TAG_ITEMPARAM6, bValue ? 1 : 0);
    }

    public final boolean isITEMPARAM7Null() {
        return this.IsParamNull(TAG_ITEMPARAM7);
    }

    public final int getITEMPARAM7() {
        return this.GetParamIntValue(TAG_ITEMPARAM7, 0);
    }

    public final void setITEMPARAM7(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM7, nValue);
    }

    public final boolean isITEMPARAM8Null() {
        return this.IsParamNull(TAG_ITEMPARAM8);
    }

    public final int getITEMPARAM8() {
        return this.GetParamIntValue(TAG_ITEMPARAM8, 0);
    }

    public final void setITEMPARAM8(int nValue) {
        this.SetParamValue(TAG_ITEMPARAM8, nValue);
    }

    public final boolean isITEMPARAM9Null() {
        return this.IsParamNull(TAG_ITEMPARAM9);
    }

    public final float getITEMPARAM9() {
        return this.GetParamFloatValue(TAG_ITEMPARAM9, 0.0f);
    }

    public final void setITEMPARAM9(float fValue) {
        this.SetParamValue(TAG_ITEMPARAM9, Float.valueOf(fValue));
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

    public final boolean isPSSYSMAPVIEWIDNull() {
        return this.IsParamNull(TAG_PSSYSMAPVIEWID);
    }

    public final String getPSSYSMAPVIEWID() {
        return this.GetParamStringValue(TAG_PSSYSMAPVIEWID, "");
    }

    public final void setPSSYSMAPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSYSMAPVIEWID, strValue);
    }

    public final boolean isPSSYSMAPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSYSMAPVIEWNAME);
    }

    public final String getPSSYSMAPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSYSMAPVIEWNAME, "");
    }

    public final void setPSSYSMAPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMAPVIEWNAME, strValue);
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
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

    public final boolean isITEMPARAMSNull() {
        return this.IsParamNull(TAG_ITEMPARAMS);
    }

    public final String getITEMPARAMS() {
        return this.GetParamStringValue(TAG_ITEMPARAMS, "");
    }

    public final void setITEMPARAMS(String strValue) {
        this.SetParamValue(TAG_ITEMPARAMS, strValue);
    }

    public final boolean isAL_POSNull() {
        return this.IsParamNull(TAG_AL_POS);
    }

    public final String getAL_POS() {
        return this.GetParamStringValue(TAG_AL_POS, "");
    }

    public final void setAL_POS(String strValue) {
        this.SetParamValue(TAG_AL_POS, strValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
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

    public final boolean isPHPSLANRESIDNull() {
        return this.IsParamNull(TAG_PHPSLANRESID);
    }

    public final String getPHPSLANRESID() {
        return this.GetParamStringValue(TAG_PHPSLANRESID, "");
    }

    public final void setPHPSLANRESID(String strValue) {
        this.SetParamValue(TAG_PHPSLANRESID, strValue);
    }

    public final boolean isPHPSLANRESNAMENull() {
        return this.IsParamNull(TAG_PHPSLANRESNAME);
    }

    public final String getPHPSLANRESNAME() {
        return this.GetParamStringValue(TAG_PHPSLANRESNAME, "");
    }

    public final void setPHPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PHPSLANRESNAME, strValue);
    }

    public final boolean isPSDEPANELIDNull() {
        return this.IsParamNull(TAG_PSDEPANELID);
    }

    public final String getPSDEPANELID() {
        return this.GetParamStringValue(TAG_PSDEPANELID, "");
    }

    public final void setPSDEPANELID(String strValue) {
        this.SetParamValue(TAG_PSDEPANELID, strValue);
    }

    public final boolean isPSDEPANELNAMENull() {
        return this.IsParamNull(TAG_PSDEPANELNAME);
    }

    public final String getPSDEPANELNAME() {
        return this.GetParamStringValue(TAG_PSDEPANELNAME, "");
    }

    public final void setPSDEPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPANELNAME, strValue);
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

    public final boolean isREFPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFPICKUPPSDEVIEWID);
    }

    public final String getREFPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFPICKUPPSDEVIEWID, "");
    }

    public final void setREFPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFPICKUPPSDEVIEWNAME);
    }

    public final String getREFPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isREFLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFLINKPSDEVIEWID);
    }

    public final String getREFLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFLINKPSDEVIEWID, "");
    }

    public final void setREFLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFLINKPSDEVIEWID, strValue);
    }

    public final boolean isREFLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFLINKPSDEVIEWNAME);
    }

    public final String getREFLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFLINKPSDEVIEWNAME, "");
    }

    public final void setREFLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFLINKPSDEVIEWNAME, strValue);
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

    public final boolean isFIELDSTATESNull() {
        return this.IsParamNull(TAG_FIELDSTATES);
    }

    public final int getFIELDSTATES() {
        return this.GetParamIntValue(TAG_FIELDSTATES, 0);
    }

    public final void setFIELDSTATES(int nValue) {
        this.SetParamValue(TAG_FIELDSTATES, nValue);
    }

    public final boolean isSPACINGTOPNull() {
        return this.IsParamNull(TAG_SPACINGTOP);
    }

    public final String getSPACINGTOP() {
        return this.GetParamStringValue(TAG_SPACINGTOP, "");
    }

    public final void setSPACINGTOP(String strValue) {
        this.SetParamValue(TAG_SPACINGTOP, strValue);
    }

    public final boolean isSPACINGBOTTOMNull() {
        return this.IsParamNull(TAG_SPACINGBOTTOM);
    }

    public final String getSPACINGBOTTOM() {
        return this.GetParamStringValue(TAG_SPACINGBOTTOM, "");
    }

    public final void setSPACINGBOTTOM(String strValue) {
        this.SetParamValue(TAG_SPACINGBOTTOM, strValue);
    }

    public final boolean isSPACINGLEFTNull() {
        return this.IsParamNull(TAG_SPACINGLEFT);
    }

    public final String getSPACINGLEFT() {
        return this.GetParamStringValue(TAG_SPACINGLEFT, "");
    }

    public final void setSPACINGLEFT(String strValue) {
        this.SetParamValue(TAG_SPACINGLEFT, strValue);
    }

    public final boolean isSPACINGRIGHTNull() {
        return this.IsParamNull(TAG_SPACINGRIGHT);
    }

    public final String getSPACINGRIGHT() {
        return this.GetParamStringValue(TAG_SPACINGRIGHT, "");
    }

    public final void setSPACINGRIGHT(String strValue) {
        this.SetParamValue(TAG_SPACINGRIGHT, strValue);
    }

    public final boolean isREFCTRL2USAGENull() {
        return this.IsParamNull(TAG_REFCTRL2USAGE);
    }

    public final String getREFCTRL2USAGE() {
        return this.GetParamStringValue(TAG_REFCTRL2USAGE, "");
    }

    public final void setREFCTRL2USAGE(String strValue) {
        this.SetParamValue(TAG_REFCTRL2USAGE, strValue);
    }

    public final boolean isREFCTRLUSAGENull() {
        return this.IsParamNull(TAG_REFCTRLUSAGE);
    }

    public final String getREFCTRLUSAGE() {
        return this.GetParamStringValue(TAG_REFCTRLUSAGE, "");
    }

    public final void setREFCTRLUSAGE(String strValue) {
        this.SetParamValue(TAG_REFCTRLUSAGE, strValue);
    }

    public final boolean isREFCTRL2NAMENull() {
        return this.IsParamNull(TAG_REFCTRL2NAME);
    }

    public final String getREFCTRL2NAME() {
        return this.GetParamStringValue(TAG_REFCTRL2NAME, "");
    }

    public final void setREFCTRL2NAME(String strValue) {
        this.SetParamValue(TAG_REFCTRL2NAME, strValue);
    }

    public final boolean isREFCTRLNAMENull() {
        return this.IsParamNull(TAG_REFCTRLNAME);
    }

    public final String getREFCTRLNAME() {
        return this.GetParamStringValue(TAG_REFCTRLNAME, "");
    }

    public final void setREFCTRLNAME(String strValue) {
        this.SetParamValue(TAG_REFCTRLNAME, strValue);
    }

    public final boolean isVALIGNNull() {
        return this.IsParamNull(TAG_VALIGN);
    }

    public final String getVALIGN() {
        return this.GetParamStringValue(TAG_VALIGN, "");
    }

    public final void setVALIGN(String strValue) {
        this.SetParamValue(TAG_VALIGN, strValue);
    }

    public final boolean isHALIGNNull() {
        return this.IsParamNull(TAG_HALIGN);
    }

    public final String getHALIGN() {
        return this.GetParamStringValue(TAG_HALIGN, "");
    }

    public final void setHALIGN(String strValue) {
        this.SetParamValue(TAG_HALIGN, strValue);
    }

    public final boolean isRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_RAWCSSSTYLE);
    }

    public final String getRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_RAWCSSSTYLE, "");
    }

    public final void setRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_RAWCSSSTYLE, strValue);
    }

    public final boolean isLABELRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_LABELRAWCSSSTYLE);
    }

    public final String getLABELRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_LABELRAWCSSSTYLE, "");
    }

    public final void setLABELRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_LABELRAWCSSSTYLE, strValue);
    }

    public final boolean isLABELDYNACLASSNull() {
        return this.IsParamNull(TAG_LABELDYNACLASS);
    }

    public final String getLABELDYNACLASS() {
        return this.GetParamStringValue(TAG_LABELDYNACLASS, "");
    }

    public final void setLABELDYNACLASS(String strValue) {
        this.SetParamValue(TAG_LABELDYNACLASS, strValue);
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

    public final boolean isHALIGNSELFNull() {
        return this.IsParamNull(TAG_HALIGNSELF);
    }

    public final String getHALIGNSELF() {
        return this.GetParamStringValue(TAG_HALIGNSELF, "");
    }

    public final void setHALIGNSELF(String strValue) {
        this.SetParamValue(TAG_HALIGNSELF, strValue);
    }

    public final boolean isVALIGNSELFNull() {
        return this.IsParamNull(TAG_VALIGNSELF);
    }

    public final String getVALIGNSELF() {
        return this.GetParamStringValue(TAG_VALIGNSELF, "");
    }

    public final void setVALIGNSELF(String strValue) {
        this.SetParamValue(TAG_VALIGNSELF, strValue);
    }

    public final boolean isDETAILSTYLETEXTNull() {
        return this.IsParamNull(TAG_DETAILSTYLETEXT);
    }

    public final String getDETAILSTYLETEXT() {
        return this.GetParamStringValue(TAG_DETAILSTYLETEXT, "");
    }

    public final void setDETAILSTYLETEXT(String strValue) {
        this.SetParamValue(TAG_DETAILSTYLETEXT, strValue);
    }

    public final boolean isRENDERMODENull() {
        return this.IsParamNull(TAG_RENDERMODE);
    }

    public final String getRENDERMODE() {
        return this.GetParamStringValue(TAG_RENDERMODE, "");
    }

    public final void setRENDERMODE(String strValue) {
        this.SetParamValue(TAG_RENDERMODE, strValue);
    }

    public final boolean isRENDERMODETEXTNull() {
        return this.IsParamNull(TAG_RENDERMODETEXT);
    }

    public final String getRENDERMODETEXT() {
        return this.GetParamStringValue(TAG_RENDERMODETEXT, "");
    }

    public final void setRENDERMODETEXT(String strValue) {
        this.SetParamValue(TAG_RENDERMODETEXT, strValue);
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

    public final boolean isTOGGLEMODENull() {
        return this.IsParamNull(TAG_TOGGLEMODE);
    }

    public final String getTOGGLEMODE() {
        return this.GetParamStringValue(TAG_TOGGLEMODE, "");
    }

    public final void setTOGGLEMODE(String strValue) {
        this.SetParamValue(TAG_TOGGLEMODE, strValue);
    }

    public final boolean isBORDERSTYLENull() {
        return this.IsParamNull(TAG_BORDERSTYLE);
    }

    public final String getBORDERSTYLE() {
        return this.GetParamStringValue(TAG_BORDERSTYLE, "");
    }

    public final void setBORDERSTYLE(String strValue) {
        this.SetParamValue(TAG_BORDERSTYLE, strValue);
    }

    public final boolean isORIENTATIONMODENull() {
        return this.IsParamNull(TAG_ORIENTATIONMODE);
    }

    public final String getORIENTATIONMODE() {
        return this.GetParamStringValue(TAG_ORIENTATIONMODE, "");
    }

    public final void setORIENTATIONMODE(String strValue) {
        this.SetParamValue(TAG_ORIENTATIONMODE, strValue);
    }

    public final boolean isICONALIGNNull() {
        return this.IsParamNull(TAG_ICONALIGN);
    }

    public final String getICONALIGN() {
        return this.GetParamStringValue(TAG_ICONALIGN, "");
    }

    public final void setICONALIGN(String strValue) {
        this.SetParamValue(TAG_ICONALIGN, strValue);
    }

    public final boolean isREFCTRLUSAGETEXTNull() {
        return this.IsParamNull(TAG_REFCTRLUSAGETEXT);
    }

    public final String getREFCTRLUSAGETEXT() {
        return this.GetParamStringValue(TAG_REFCTRLUSAGETEXT, "");
    }

    public final void setREFCTRLUSAGETEXT(String strValue) {
        this.SetParamValue(TAG_REFCTRLUSAGETEXT, strValue);
    }

    public final boolean isREFCTRL2USAGETEXTNull() {
        return this.IsParamNull(TAG_REFCTRL2USAGETEXT);
    }

    public final String getREFCTRL2USAGETEXT() {
        return this.GetParamStringValue(TAG_REFCTRL2USAGETEXT, "");
    }

    public final void setREFCTRL2USAGETEXT(String strValue) {
        this.SetParamValue(TAG_REFCTRL2USAGETEXT, strValue);
    }

    public final boolean isTABINDEXNull() {
        return this.IsParamNull(TAG_TABINDEX);
    }

    public final int getTABINDEX() {
        return this.GetParamIntValue(TAG_TABINDEX, 0);
    }

    public final void setTABINDEX(int nValue) {
        this.SetParamValue(TAG_TABINDEX, nValue);
    }

    public final boolean isHEIGHTMODENull() {
        return this.IsParamNull(TAG_HEIGHTMODE);
    }

    public final String getHEIGHTMODE() {
        return this.GetParamStringValue(TAG_HEIGHTMODE, "");
    }

    public final void setHEIGHTMODE(String strValue) {
        this.SetParamValue(TAG_HEIGHTMODE, strValue);
    }

    public final boolean isWIDTHMODENull() {
        return this.IsParamNull(TAG_WIDTHMODE);
    }

    public final String getWIDTHMODE() {
        return this.GetParamStringValue(TAG_WIDTHMODE, "");
    }

    public final void setWIDTHMODE(String strValue) {
        this.SetParamValue(TAG_WIDTHMODE, strValue);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPETEXTNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPETEXT);
    }

    public final String getPREDEFINEDTYPETEXT() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPETEXT, "");
    }

    public final void setPREDEFINEDTYPETEXT(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPETEXT, strValue);
    }

    public final boolean isSWAPMODENull() {
        return this.IsParamNull(TAG_SWAPMODE);
    }

    public final String getSWAPMODE() {
        return this.GetParamStringValue(TAG_SWAPMODE, "");
    }

    public final void setSWAPMODE(String strValue) {
        this.SetParamValue(TAG_SWAPMODE, strValue);
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

    public final boolean isDATAPANELMODENull() {
        return this.IsParamNull(TAG_DATAPANELMODE);
    }

    public final String getDATAPANELMODE() {
        return this.GetParamStringValue(TAG_DATAPANELMODE, "");
    }

    public final void setDATAPANELMODE(String strValue) {
        this.SetParamValue(TAG_DATAPANELMODE, strValue);
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

    public final boolean isGETDATATIMERNull() {
        return this.IsParamNull(TAG_GETDATATIMER);
    }

    public final int getGETDATATIMER() {
        return this.GetParamIntValue(TAG_GETDATATIMER, 0);
    }

    public final void setGETDATATIMER(int nValue) {
        this.SetParamValue(TAG_GETDATATIMER, nValue);
    }

    public final boolean isOPENPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSDEVIEWID);
    }

    public final String getOPENPSDEVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSDEVIEWID, "");
    }

    public final void setOPENPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSDEVIEWID, strValue);
    }

    public final boolean isOPENPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSDEVIEWNAME);
    }

    public final String getOPENPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSDEVIEWNAME, "");
    }

    public final void setOPENPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSDEVIEWNAME, strValue);
    }

    public final boolean isOPENPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSAPPVIEWID);
    }

    public final String getOPENPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSAPPVIEWID, "");
    }

    public final void setOPENPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSAPPVIEWID, strValue);
    }

    public final boolean isOPENPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSAPPVIEWNAME);
    }

    public final String getOPENPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSAPPVIEWNAME, "");
    }

    public final void setOPENPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSAPPVIEWNAME, strValue);
    }

    public final boolean isOPENPSSYSPDTVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSSYSPDTVIEWID);
    }

    public final String getOPENPSSYSPDTVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSSYSPDTVIEWID, "");
    }

    public final void setOPENPSSYSPDTVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSSYSPDTVIEWID, strValue);
    }

    public final boolean isOPENPSSYSPDTVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSSYSPDTVIEWNAME);
    }

    public final String getOPENPSSYSPDTVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSSYSPDTVIEWNAME, "");
    }

    public final void setOPENPSSYSPDTVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSSYSPDTVIEWNAME, strValue);
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

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isCTRLPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_CTRLPSSYSCSSID);
    }

    public final String getCTRLPSSYSCSSID() {
        return this.GetParamStringValue(TAG_CTRLPSSYSCSSID, "");
    }

    public final void setCTRLPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_CTRLPSSYSCSSID, strValue);
    }

    public final boolean isCTRLPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_CTRLPSSYSCSSNAME);
    }

    public final String getCTRLPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_CTRLPSSYSCSSNAME, "");
    }

    public final void setCTRLPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_CTRLPSSYSCSSNAME, strValue);
    }

    public final boolean isCTRLDYNACLASSNull() {
        return this.IsParamNull(TAG_CTRLDYNACLASS);
    }

    public final String getCTRLDYNACLASS() {
        return this.GetParamStringValue(TAG_CTRLDYNACLASS, "");
    }

    public final void setCTRLDYNACLASS(String strValue) {
        this.SetParamValue(TAG_CTRLDYNACLASS, strValue);
    }

    public final boolean isCTRLRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_CTRLRAWCSSSTYLE);
    }

    public final String getCTRLRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_CTRLRAWCSSSTYLE, "");
    }

    public final void setCTRLRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_CTRLRAWCSSSTYLE, strValue);
    }

    public final boolean isLOCALMODENull() {
        return this.IsParamNull(TAG_LOCALMODE);
    }

    public final boolean getLOCALMODE() {
        return this.GetParamIntValue(TAG_LOCALMODE, 0) == 1;
    }

    public final void setLOCALMODE(boolean bValue) {
        this.SetParamValue(TAG_LOCALMODE, bValue ? 1 : 0);
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

    public final boolean isACTIVEDATAMODENull() {
        return this.IsParamNull(TAG_ACTIVEDATAMODE);
    }

    public final boolean getACTIVEDATAMODE() {
        return this.GetParamIntValue(TAG_ACTIVEDATAMODE, 0) == 1;
    }

    public final void setACTIVEDATAMODE(boolean bValue) {
        this.SetParamValue(TAG_ACTIVEDATAMODE, bValue ? 1 : 0);
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

    public final boolean isTEMPLATEMODENull() {
        return this.IsParamNull(TAG_TEMPLATEMODE);
    }

    public final int getTEMPLATEMODE() {
        return this.GetParamIntValue(TAG_TEMPLATEMODE, 0);
    }

    public final void setTEMPLATEMODE(int nValue) {
        this.SetParamValue(TAG_TEMPLATEMODE, nValue);
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

    public final boolean isVALUEITEMNAMENull() {
        return this.IsParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.GetParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.SetParamValue(TAG_VALUEITEMNAME, strValue);
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

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
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

    public ArrayList<PSSysPanelItem> getChildPSSysPanelItems(boolean bCreated) {
        if (this.childPSSysPanelItemList != null) {
            return this.childPSSysPanelItemList;
        }
        if (bCreated) {
            this.childPSSysPanelItemList = new ArrayList();
        }
        return this.childPSSysPanelItemList;
    }

    public ArrayList<PSPanelItemLogic> getChildPSPanelItemLogics(String strLogicCat, boolean bCreated) {
        ArrayList<PSPanelItemLogic> childPSPanelItemLogicList;
        if (this.childPSPanelItemLogicListMap == null) {
            if (!bCreated) {
                return null;
            }
            this.childPSPanelItemLogicListMap = new HashMap();
        }
        if ((childPSPanelItemLogicList = this.childPSPanelItemLogicListMap.get(strLogicCat)) != null) {
            return childPSPanelItemLogicList;
        }
        if (bCreated) {
            childPSPanelItemLogicList = new ArrayList();
            this.childPSPanelItemLogicListMap.put(strLogicCat, childPSPanelItemLogicList);
        }
        return childPSPanelItemLogicList;
    }

    public void resetChildDatas() {
        if (this.childPSSysPanelItemList != null) {
            this.childPSSysPanelItemList.clear();
            this.childPSSysPanelItemList = null;
        }
        if (this.childPSPanelItemLogicListMap != null) {
            this.childPSPanelItemLogicListMap.clear();
            this.childPSPanelItemLogicListMap = null;
        }
    }
}

