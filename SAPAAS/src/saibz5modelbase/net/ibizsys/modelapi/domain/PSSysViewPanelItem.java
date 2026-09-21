/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSPanelItemLogic;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysViewPanelItem
extends PSModelBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_AL_POS = "al_pos";
    public static final String FIELD_BL_POS = "bl_pos";
    public static final String FIELD_BORDERSTYLE = "borderstyle";
    public static final String FIELD_BOTTOMPOS = "bottompos";
    public static final String FIELD_BTNACTIONTYPE = "btnactiontype";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CAPTIONPOS = "captionpos";
    public static final String FIELD_CHILD_COL_LG = "child_col_lg";
    public static final String FIELD_CHILD_COL_MD = "child_col_md";
    public static final String FIELD_CHILD_COL_SM = "child_col_sm";
    public static final String FIELD_CHILD_COL_XS = "child_col_xs";
    public static final String FIELD_COLID = "colid";
    public static final String FIELD_COLLAPSIBLEFLAG = "collapsibleflag";
    public static final String FIELD_COLMODEL = "colmodel";
    public static final String FIELD_COLSPAN = "colspan";
    public static final String FIELD_COL_LG = "col_lg";
    public static final String FIELD_COL_LG_OS = "col_lg_os";
    public static final String FIELD_COL_MD = "col_md";
    public static final String FIELD_COL_MD_OS = "col_md_os";
    public static final String FIELD_COL_SM = "col_sm";
    public static final String FIELD_COL_SM_OS = "col_sm_os";
    public static final String FIELD_COL_WIDTH = "col_width";
    public static final String FIELD_COL_XS = "col_xs";
    public static final String FIELD_COL_XS_OS = "col_xs_os";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLDYNACLASS = "ctrldynaclass";
    public static final String FIELD_CTRLHEIGHT = "ctrlheight";
    public static final String FIELD_CTRLPSSYSCSSID = "ctrlpssyscssid";
    public static final String FIELD_CTRLPSSYSCSSNAME = "ctrlpssyscssname";
    public static final String FIELD_CTRLRAWCSSSTYLE = "ctrlrawcssstyle";
    public static final String FIELD_CTRLTYPE = "ctrltype";
    public static final String FIELD_CTRLWIDTH = "ctrlwidth";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DATAPANELMODE = "datapanelmode";
    public static final String FIELD_DATASOURCE = "datasource";
    public static final String FIELD_DATASOURCETEXT = "datasourcetext";
    public static final String FIELD_DETAILSTYLE = "detailstyle";
    public static final String FIELD_DETAILSTYLETEXT = "detailstyletext";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORTYPENAME = "editortypename";
    public static final String FIELD_EMPTYCAPTION = "emptycaption";
    public static final String FIELD_ENABLEANCHOR = "enableanchor";
    public static final String FIELD_FIELDNAME = "fieldname";
    public static final String FIELD_FIELDSTATES = "fieldstates";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXGROW = "flexgrow";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_GETDATATIMER = "getdatatimer";
    public static final String FIELD_GRIDROWID = "gridrowid";
    public static final String FIELD_HALIGN = "halign";
    public static final String FIELD_HALIGNSELF = "halignself";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HEIGHTMODE = "heightmode";
    public static final String FIELD_HTMLCONTENT = "htmlcontent";
    public static final String FIELD_HTMLPAGEURL = "htmlpageurl";
    public static final String FIELD_ICONALIGN = "iconalign";
    public static final String FIELD_IGNOREINPUT = "ignoreinput";
    public static final String FIELD_ITEMPARAM = "itemparam";
    public static final String FIELD_ITEMPARAM10 = "itemparam10";
    public static final String FIELD_ITEMPARAM11 = "itemparam11";
    public static final String FIELD_ITEMPARAM12 = "itemparam12";
    public static final String FIELD_ITEMPARAM2 = "itemparam2";
    public static final String FIELD_ITEMPARAM3 = "itemparam3";
    public static final String FIELD_ITEMPARAM4 = "itemparam4";
    public static final String FIELD_ITEMPARAM5 = "itemparam5";
    public static final String FIELD_ITEMPARAM6 = "itemparam6";
    public static final String FIELD_ITEMPARAM7 = "itemparam7";
    public static final String FIELD_ITEMPARAM8 = "itemparam8";
    public static final String FIELD_ITEMPARAM9 = "itemparam9";
    public static final String FIELD_ITEMPARAMS = "itemparams";
    public static final String FIELD_ITEMTYPE = "itemtype";
    public static final String FIELD_LABELDYNACLASS = "labeldynaclass";
    public static final String FIELD_LABELPSSYSCSSID = "labelpssyscssid";
    public static final String FIELD_LABELPSSYSCSSNAME = "labelpssyscssname";
    public static final String FIELD_LABELRAWCSSSTYLE = "labelrawcssstyle";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_OPENPSAPPVIEWID = "openpsappviewid";
    public static final String FIELD_OPENPSAPPVIEWNAME = "openpsappviewname";
    public static final String FIELD_OPENPSDEVIEWID = "openpsdeviewid";
    public static final String FIELD_OPENPSDEVIEWNAME = "openpsdeviewname";
    public static final String FIELD_OPENPSSYSPDTVIEWID = "openpssyspdtviewid";
    public static final String FIELD_OPENPSSYSPDTVIEWNAME = "openpssyspdtviewname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_ORIENTATIONMODE = "orientationmode";
    public static final String FIELD_PHPSLANRESID = "phpslanresid";
    public static final String FIELD_PHPSLANRESNAME = "phpslanresname";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PLAYOUTMODE = "playoutmode";
    public static final String FIELD_PPSSYSVIEWPANELITEMID = "ppssysviewpanelitemid";
    public static final String FIELD_PPSSYSVIEWPANELITEMNAME = "ppssysviewpanelitemname";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSAPPMENUID = "psappmenuid";
    public static final String FIELD_PSAPPMENUNAME = "psappmenuname";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSCTRLID = "psctrlid";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLNAME = "psctrlname";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDECHARTID = "psdechartid";
    public static final String FIELD_PSDECHARTNAME = "psdechartname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEDATAVIEWID = "psdedataviewid";
    public static final String FIELD_PSDEDATAVIEWNAME = "psdedataviewname";
    public static final String FIELD_PSDEDRID = "psdedrid";
    public static final String FIELD_PSDEDRITEMID = "psdedritemid";
    public static final String FIELD_PSDEDRITEMNAME = "psdedritemname";
    public static final String FIELD_PSDEDRNAME = "psdedrname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEGRIDID = "psdegridid";
    public static final String FIELD_PSDEGRIDNAME = "psdegridname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELISTID = "psdelistid";
    public static final String FIELD_PSDELISTNAME = "psdelistname";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEPANELID = "psdepanelid";
    public static final String FIELD_PSDEPANELNAME = "psdepanelname";
    public static final String FIELD_PSDEREPORTID = "psdereportid";
    public static final String FIELD_PSDEREPORTNAME = "psdereportname";
    public static final String FIELD_PSDESEARCHFORMID = "psdesearchformid";
    public static final String FIELD_PSDESEARCHFORMNAME = "psdesearchformname";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEWIZARDID = "psdewizardid";
    public static final String FIELD_PSDEWIZARDNAME = "psdewizardname";
    public static final String FIELD_PSSYSCALENDARID = "pssyscalendarid";
    public static final String FIELD_PSSYSCALENDARNAME = "pssyscalendarname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDASHBOARDID = "pssysdashboardid";
    public static final String FIELD_PSSYSDASHBOARDNAME = "pssysdashboardname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSMAPVIEWID = "pssysmapviewid";
    public static final String FIELD_PSSYSMAPVIEWNAME = "pssysmapviewname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSRESOURCEID = "pssysresourceid";
    public static final String FIELD_PSSYSRESOURCENAME = "pssysresourcename";
    public static final String FIELD_PSSYSSEARCHBARID = "pssyssearchbarid";
    public static final String FIELD_PSSYSSEARCHBARNAME = "pssyssearchbarname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "pssysviewpanelitemid";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "pssysviewpanelitemname";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_RAWCONTENT = "rawcontent";
    public static final String FIELD_RAWCSSSTYLE = "rawcssstyle";
    public static final String FIELD_RAWSERVICEMETHOD = "rawservicemethod";
    public static final String FIELD_RAWSERVICEURL = "rawserviceurl";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_REFCTRL2NAME = "refctrl2name";
    public static final String FIELD_REFCTRL2USAGE = "refctrl2usage";
    public static final String FIELD_REFCTRL2USAGETEXT = "refctrl2usagetext";
    public static final String FIELD_REFCTRLNAME = "refctrlname";
    public static final String FIELD_REFCTRLUSAGE = "refctrlusage";
    public static final String FIELD_REFCTRLUSAGETEXT = "refctrlusagetext";
    public static final String FIELD_REFLINKPSDEVIEWID = "reflinkpsdeviewid";
    public static final String FIELD_REFLINKPSDEVIEWNAME = "reflinkpsdeviewname";
    public static final String FIELD_REFPICKUPPSDEVIEWID = "refpickuppsdeviewid";
    public static final String FIELD_REFPICKUPPSDEVIEWNAME = "refpickuppsdeviewname";
    public static final String FIELD_REFPSDEACMODEID = "refpsdeacmodeid";
    public static final String FIELD_REFPSDEACMODENAME = "refpsdeacmodename";
    public static final String FIELD_REFPSDEDATASETID = "refpsdedatasetid";
    public static final String FIELD_REFPSDEDATASETNAME = "refpsdedatasetname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_RENDERMODE = "rendermode";
    public static final String FIELD_RENDERMODETEXT = "rendermodetext";
    public static final String FIELD_RIGHTPOS = "rightpos";
    public static final String FIELD_ROWSPAN = "rowspan";
    public static final String FIELD_SHOWCAPTION = "showcaption";
    public static final String FIELD_SPACINGBOTTOM = "spacingbottom";
    public static final String FIELD_SPACINGLEFT = "spacingleft";
    public static final String FIELD_SPACINGRIGHT = "spacingright";
    public static final String FIELD_SPACINGTOP = "spacingtop";
    public static final String FIELD_SWAPMODE = "swapmode";
    public static final String FIELD_TABINDEX = "tabindex";
    public static final String FIELD_TARGETID = "targetid";
    public static final String FIELD_TARGETNAME = "targetname";
    public static final String FIELD_TARGETTYPE = "targettype";
    public static final String FIELD_TITLEBARCLOSEMODE = "titlebarclosemode";
    public static final String FIELD_TOGGLEMODE = "togglemode";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    public static final String FIELD_TOPPOS = "toppos";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALIGN = "valign";
    public static final String FIELD_VALIGNSELF = "valignself";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_WIDTHMODE = "widthmode";
    private List<PSSysViewPanelItem> pssysviewpanelitems;
    private List<PSPanelItemLogic> pspanelitemlogics;

    @JsonIgnore
    public String getADPSDELogicId() {
        Object objValue = this.get(FIELD_ADPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicid")
    public void setADPSDELogicId(String aDPSDELogicId) {
        this.set(FIELD_ADPSDELOGICID, aDPSDELogicId);
    }

    @JsonIgnore
    public boolean isADPSDELogicIdDirty() {
        return this.contains(FIELD_ADPSDELOGICID);
    }

    @JsonIgnore
    public String getADPSDELogicName() {
        Object objValue = this.get(FIELD_ADPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="adpsdelogicname")
    public void setADPSDELogicName(String aDPSDELogicName) {
        this.set(FIELD_ADPSDELOGICNAME, aDPSDELogicName);
    }

    @JsonIgnore
    public boolean isADPSDELogicNameDirty() {
        return this.contains(FIELD_ADPSDELOGICNAME);
    }

    @JsonIgnore
    public String getAL_Pos() {
        Object objValue = this.get(FIELD_AL_POS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="al_pos")
    public void setAL_Pos(String aL_Pos) {
        this.set(FIELD_AL_POS, aL_Pos);
    }

    @JsonIgnore
    public boolean isAL_PosDirty() {
        return this.contains(FIELD_AL_POS);
    }

    @JsonIgnore
    public String getBL_Pos() {
        Object objValue = this.get(FIELD_BL_POS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bl_pos")
    public void setBL_Pos(String bL_Pos) {
        this.set(FIELD_BL_POS, bL_Pos);
    }

    @JsonIgnore
    public boolean isBL_PosDirty() {
        return this.contains(FIELD_BL_POS);
    }

    @JsonIgnore
    public String getBorderStyle() {
        Object objValue = this.get(FIELD_BORDERSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="borderstyle")
    public void setBorderStyle(String borderStyle) {
        this.set(FIELD_BORDERSTYLE, borderStyle);
    }

    @JsonIgnore
    public boolean isBorderStyleDirty() {
        return this.contains(FIELD_BORDERSTYLE);
    }

    @JsonIgnore
    public Integer getBottomPos() {
        Object objValue = this.get(FIELD_BOTTOMPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bottompos")
    public void setBottomPos(Integer bottomPos) {
        this.set(FIELD_BOTTOMPOS, bottomPos);
    }

    @JsonIgnore
    public boolean isBottomPosDirty() {
        return this.contains(FIELD_BOTTOMPOS);
    }

    @JsonIgnore
    public String getBtnActionType() {
        Object objValue = this.get(FIELD_BTNACTIONTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="btnactiontype")
    public void setBtnActionType(String btnActionType) {
        this.set(FIELD_BTNACTIONTYPE, btnActionType);
    }

    @JsonIgnore
    public boolean isBtnActionTypeDirty() {
        return this.contains(FIELD_BTNACTIONTYPE);
    }

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public String getCaptionPos() {
        Object objValue = this.get(FIELD_CAPTIONPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="captionpos")
    public void setCaptionPos(String captionPos) {
        this.set(FIELD_CAPTIONPOS, captionPos);
    }

    @JsonIgnore
    public boolean isCaptionPosDirty() {
        return this.contains(FIELD_CAPTIONPOS);
    }

    @JsonIgnore
    public Integer getChild_Col_LG() {
        Object objValue = this.get(FIELD_CHILD_COL_LG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="child_col_lg")
    public void setChild_Col_LG(Integer child_Col_LG) {
        this.set(FIELD_CHILD_COL_LG, child_Col_LG);
    }

    @JsonIgnore
    public boolean isChild_Col_LGDirty() {
        return this.contains(FIELD_CHILD_COL_LG);
    }

    @JsonIgnore
    public Integer getChild_Col_MD() {
        Object objValue = this.get(FIELD_CHILD_COL_MD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="child_col_md")
    public void setChild_Col_MD(Integer child_Col_MD) {
        this.set(FIELD_CHILD_COL_MD, child_Col_MD);
    }

    @JsonIgnore
    public boolean isChild_Col_MDDirty() {
        return this.contains(FIELD_CHILD_COL_MD);
    }

    @JsonIgnore
    public Integer getChild_Col_SM() {
        Object objValue = this.get(FIELD_CHILD_COL_SM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="child_col_sm")
    public void setChild_Col_SM(Integer child_Col_SM) {
        this.set(FIELD_CHILD_COL_SM, child_Col_SM);
    }

    @JsonIgnore
    public boolean isChild_Col_SMDirty() {
        return this.contains(FIELD_CHILD_COL_SM);
    }

    @JsonIgnore
    public Integer getChild_Col_XS() {
        Object objValue = this.get(FIELD_CHILD_COL_XS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="child_col_xs")
    public void setChild_Col_XS(Integer child_Col_XS) {
        this.set(FIELD_CHILD_COL_XS, child_Col_XS);
    }

    @JsonIgnore
    public boolean isChild_Col_XSDirty() {
        return this.contains(FIELD_CHILD_COL_XS);
    }

    @JsonIgnore
    public Integer getColId() {
        Object objValue = this.get(FIELD_COLID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="colid")
    public void setColId(Integer colId) {
        this.set(FIELD_COLID, colId);
    }

    @JsonIgnore
    public boolean isColIdDirty() {
        return this.contains(FIELD_COLID);
    }

    @JsonIgnore
    public Integer getCollapsibleFlag() {
        Object objValue = this.get(FIELD_COLLAPSIBLEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="collapsibleflag")
    public void setCollapsibleFlag(Integer collapsibleFlag) {
        this.set(FIELD_COLLAPSIBLEFLAG, collapsibleFlag);
    }

    @JsonIgnore
    public boolean isCollapsibleFlagDirty() {
        return this.contains(FIELD_COLLAPSIBLEFLAG);
    }

    @JsonIgnore
    public String getColModel() {
        Object objValue = this.get(FIELD_COLMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colmodel")
    public void setColModel(String colModel) {
        this.set(FIELD_COLMODEL, colModel);
    }

    @JsonIgnore
    public boolean isColModelDirty() {
        return this.contains(FIELD_COLMODEL);
    }

    @JsonIgnore
    public Integer getColSpan() {
        Object objValue = this.get(FIELD_COLSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="colspan")
    public void setColSpan(Integer colSpan) {
        this.set(FIELD_COLSPAN, colSpan);
    }

    @JsonIgnore
    public boolean isColSpanDirty() {
        return this.contains(FIELD_COLSPAN);
    }

    @JsonIgnore
    public Integer getCol_LG() {
        Object objValue = this.get(FIELD_COL_LG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_lg")
    public void setCol_LG(Integer col_LG) {
        this.set(FIELD_COL_LG, col_LG);
    }

    @JsonIgnore
    public boolean isCol_LGDirty() {
        return this.contains(FIELD_COL_LG);
    }

    @JsonIgnore
    public Integer getCol_LG_OS() {
        Object objValue = this.get(FIELD_COL_LG_OS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_lg_os")
    public void setCol_LG_OS(Integer col_LG_OS) {
        this.set(FIELD_COL_LG_OS, col_LG_OS);
    }

    @JsonIgnore
    public boolean isCol_LG_OSDirty() {
        return this.contains(FIELD_COL_LG_OS);
    }

    @JsonIgnore
    public Integer getCol_MD() {
        Object objValue = this.get(FIELD_COL_MD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_md")
    public void setCol_MD(Integer col_MD) {
        this.set(FIELD_COL_MD, col_MD);
    }

    @JsonIgnore
    public boolean isCol_MDDirty() {
        return this.contains(FIELD_COL_MD);
    }

    @JsonIgnore
    public Integer getCol_MD_OS() {
        Object objValue = this.get(FIELD_COL_MD_OS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_md_os")
    public void setCol_MD_OS(Integer col_MD_OS) {
        this.set(FIELD_COL_MD_OS, col_MD_OS);
    }

    @JsonIgnore
    public boolean isCol_MD_OSDirty() {
        return this.contains(FIELD_COL_MD_OS);
    }

    @JsonIgnore
    public Integer getCol_SM() {
        Object objValue = this.get(FIELD_COL_SM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_sm")
    public void setCol_SM(Integer col_SM) {
        this.set(FIELD_COL_SM, col_SM);
    }

    @JsonIgnore
    public boolean isCol_SMDirty() {
        return this.contains(FIELD_COL_SM);
    }

    @JsonIgnore
    public Integer getCol_SM_OS() {
        Object objValue = this.get(FIELD_COL_SM_OS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_sm_os")
    public void setCol_SM_OS(Integer col_SM_OS) {
        this.set(FIELD_COL_SM_OS, col_SM_OS);
    }

    @JsonIgnore
    public boolean isCol_SM_OSDirty() {
        return this.contains(FIELD_COL_SM_OS);
    }

    @JsonIgnore
    public Integer getCol_Width() {
        Object objValue = this.get(FIELD_COL_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_width")
    public void setCol_Width(Integer col_Width) {
        this.set(FIELD_COL_WIDTH, col_Width);
    }

    @JsonIgnore
    public boolean isCol_WidthDirty() {
        return this.contains(FIELD_COL_WIDTH);
    }

    @JsonIgnore
    public Integer getCol_XS() {
        Object objValue = this.get(FIELD_COL_XS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_xs")
    public void setCol_XS(Integer col_XS) {
        this.set(FIELD_COL_XS, col_XS);
    }

    @JsonIgnore
    public boolean isCol_XSDirty() {
        return this.contains(FIELD_COL_XS);
    }

    @JsonIgnore
    public Integer getCol_XS_OS() {
        Object objValue = this.get(FIELD_COL_XS_OS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="col_xs_os")
    public void setCol_XS_OS(Integer col_XS_OS) {
        this.set(FIELD_COL_XS_OS, col_XS_OS);
    }

    @JsonIgnore
    public boolean isCol_XS_OSDirty() {
        return this.contains(FIELD_COL_XS_OS);
    }

    @JsonIgnore
    public String getContentType() {
        Object objValue = this.get(FIELD_CONTENTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contenttype")
    public void setContentType(String contentType) {
        this.set(FIELD_CONTENTTYPE, contentType);
    }

    @JsonIgnore
    public boolean isContentTypeDirty() {
        return this.contains(FIELD_CONTENTTYPE);
    }

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public String getCtrlDynaClass() {
        Object objValue = this.get(FIELD_CTRLDYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrldynaclass")
    public void setCtrlDynaClass(String ctrlDynaClass) {
        this.set(FIELD_CTRLDYNACLASS, ctrlDynaClass);
    }

    @JsonIgnore
    public boolean isCtrlDynaClassDirty() {
        return this.contains(FIELD_CTRLDYNACLASS);
    }

    @JsonIgnore
    public Integer getCtrlHeight() {
        Object objValue = this.get(FIELD_CTRLHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlheight")
    public void setCtrlHeight(Integer ctrlHeight) {
        this.set(FIELD_CTRLHEIGHT, ctrlHeight);
    }

    @JsonIgnore
    public boolean isCtrlHeightDirty() {
        return this.contains(FIELD_CTRLHEIGHT);
    }

    @JsonIgnore
    public String getCtrlPSSysCssId() {
        Object objValue = this.get(FIELD_CTRLPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlpssyscssid")
    public void setCtrlPSSysCssId(String ctrlPSSysCssId) {
        this.set(FIELD_CTRLPSSYSCSSID, ctrlPSSysCssId);
    }

    @JsonIgnore
    public boolean isCtrlPSSysCssIdDirty() {
        return this.contains(FIELD_CTRLPSSYSCSSID);
    }

    @JsonIgnore
    public String getCtrlPSSysCssName() {
        Object objValue = this.get(FIELD_CTRLPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlpssyscssname")
    public void setCtrlPSSysCssName(String ctrlPSSysCssName) {
        this.set(FIELD_CTRLPSSYSCSSNAME, ctrlPSSysCssName);
    }

    @JsonIgnore
    public boolean isCtrlPSSysCssNameDirty() {
        return this.contains(FIELD_CTRLPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getCtrlRawCssStyle() {
        Object objValue = this.get(FIELD_CTRLRAWCSSSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlrawcssstyle")
    public void setCtrlRawCssStyle(String ctrlRawCssStyle) {
        this.set(FIELD_CTRLRAWCSSSTYLE, ctrlRawCssStyle);
    }

    @JsonIgnore
    public boolean isCtrlRawCssStyleDirty() {
        return this.contains(FIELD_CTRLRAWCSSSTYLE);
    }

    @JsonIgnore
    public String getCtrlType() {
        Object objValue = this.get(FIELD_CTRLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrltype")
    public void setCtrlType(String ctrlType) {
        this.set(FIELD_CTRLTYPE, ctrlType);
    }

    @JsonIgnore
    public boolean isCtrlTypeDirty() {
        return this.contains(FIELD_CTRLTYPE);
    }

    @JsonIgnore
    public Integer getCtrlWidth() {
        Object objValue = this.get(FIELD_CTRLWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlwidth")
    public void setCtrlWidth(Integer ctrlWidth) {
        this.set(FIELD_CTRLWIDTH, ctrlWidth);
    }

    @JsonIgnore
    public boolean isCtrlWidthDirty() {
        return this.contains(FIELD_CTRLWIDTH);
    }

    @JsonIgnore
    public String getCustomCode() {
        Object objValue = this.get(FIELD_CUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcode")
    public void setCustomCode(String customCode) {
        this.set(FIELD_CUSTOMCODE, customCode);
    }

    @JsonIgnore
    public boolean isCustomCodeDirty() {
        return this.contains(FIELD_CUSTOMCODE);
    }

    @JsonIgnore
    public Integer getCustomMode() {
        Object objValue = this.get(FIELD_CUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="custommode")
    public void setCustomMode(Integer customMode) {
        this.set(FIELD_CUSTOMMODE, customMode);
    }

    @JsonIgnore
    public boolean isCustomModeDirty() {
        return this.contains(FIELD_CUSTOMMODE);
    }

    @JsonIgnore
    public String getDataPanelMode() {
        Object objValue = this.get(FIELD_DATAPANELMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datapanelmode")
    public void setDataPanelMode(String dataPanelMode) {
        this.set(FIELD_DATAPANELMODE, dataPanelMode);
    }

    @JsonIgnore
    public boolean isDataPanelModeDirty() {
        return this.contains(FIELD_DATAPANELMODE);
    }

    @JsonIgnore
    public String getDataSource() {
        Object objValue = this.get(FIELD_DATASOURCE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datasource")
    public void setDataSource(String dataSource) {
        this.set(FIELD_DATASOURCE, dataSource);
    }

    @JsonIgnore
    public boolean isDataSourceDirty() {
        return this.contains(FIELD_DATASOURCE);
    }

    @JsonIgnore
    public String getDataSourceText() {
        Object objValue = this.get(FIELD_DATASOURCETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datasourcetext")
    public void setDataSourceText(String dataSourceText) {
        this.set(FIELD_DATASOURCETEXT, dataSourceText);
    }

    @JsonIgnore
    public boolean isDataSourceTextDirty() {
        return this.contains(FIELD_DATASOURCETEXT);
    }

    @JsonIgnore
    public String getDetailStyle() {
        Object objValue = this.get(FIELD_DETAILSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailstyle")
    public void setDetailStyle(String detailStyle) {
        this.set(FIELD_DETAILSTYLE, detailStyle);
    }

    @JsonIgnore
    public boolean isDetailStyleDirty() {
        return this.contains(FIELD_DETAILSTYLE);
    }

    @JsonIgnore
    public String getDetailStyleText() {
        Object objValue = this.get(FIELD_DETAILSTYLETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailstyletext")
    public void setDetailStyleText(String detailStyleText) {
        this.set(FIELD_DETAILSTYLETEXT, detailStyleText);
    }

    @JsonIgnore
    public boolean isDetailStyleTextDirty() {
        return this.contains(FIELD_DETAILSTYLETEXT);
    }

    @JsonIgnore
    public String getDynaClass() {
        Object objValue = this.get(FIELD_DYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynaclass")
    public void setDynaClass(String dynaClass) {
        this.set(FIELD_DYNACLASS, dynaClass);
    }

    @JsonIgnore
    public boolean isDynaClassDirty() {
        return this.contains(FIELD_DYNACLASS);
    }

    @JsonIgnore
    public String getEditorType() {
        Object objValue = this.get(FIELD_EDITORTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortype")
    public void setEditorType(String editorType) {
        this.set(FIELD_EDITORTYPE, editorType);
    }

    @JsonIgnore
    public boolean isEditorTypeDirty() {
        return this.contains(FIELD_EDITORTYPE);
    }

    @JsonIgnore
    public String getEditorTypeName() {
        Object objValue = this.get(FIELD_EDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editortypename")
    public void setEditorTypeName(String editorTypeName) {
        this.set(FIELD_EDITORTYPENAME, editorTypeName);
    }

    @JsonIgnore
    public boolean isEditorTypeNameDirty() {
        return this.contains(FIELD_EDITORTYPENAME);
    }

    @JsonIgnore
    public Integer getEmptyCaption() {
        Object objValue = this.get(FIELD_EMPTYCAPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="emptycaption")
    public void setEmptyCaption(Integer emptyCaption) {
        this.set(FIELD_EMPTYCAPTION, emptyCaption);
    }

    @JsonIgnore
    public boolean isEmptyCaptionDirty() {
        return this.contains(FIELD_EMPTYCAPTION);
    }

    @JsonIgnore
    public Integer getEnableAnchor() {
        Object objValue = this.get(FIELD_ENABLEANCHOR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableanchor")
    public void setEnableAnchor(Integer enableAnchor) {
        this.set(FIELD_ENABLEANCHOR, enableAnchor);
    }

    @JsonIgnore
    public boolean isEnableAnchorDirty() {
        return this.contains(FIELD_ENABLEANCHOR);
    }

    @JsonIgnore
    public String getFieldName() {
        Object objValue = this.get(FIELD_FIELDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fieldname")
    public void setFieldName(String fieldName) {
        this.set(FIELD_FIELDNAME, fieldName);
    }

    @JsonIgnore
    public boolean isFieldNameDirty() {
        return this.contains(FIELD_FIELDNAME);
    }

    @JsonIgnore
    public Integer getFieldStates() {
        Object objValue = this.get(FIELD_FIELDSTATES);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="fieldstates")
    public void setFieldStates(Integer fieldStates) {
        this.set(FIELD_FIELDSTATES, fieldStates);
    }

    @JsonIgnore
    public boolean isFieldStatesDirty() {
        return this.contains(FIELD_FIELDSTATES);
    }

    @JsonIgnore
    public String getFlexAlign() {
        Object objValue = this.get(FIELD_FLEXALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexalign")
    public void setFlexAlign(String flexAlign) {
        this.set(FIELD_FLEXALIGN, flexAlign);
    }

    @JsonIgnore
    public boolean isFlexAlignDirty() {
        return this.contains(FIELD_FLEXALIGN);
    }

    @JsonIgnore
    public String getFlexDir() {
        Object objValue = this.get(FIELD_FLEXDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexdir")
    public void setFlexDir(String flexDir) {
        this.set(FIELD_FLEXDIR, flexDir);
    }

    @JsonIgnore
    public boolean isFlexDirDirty() {
        return this.contains(FIELD_FLEXDIR);
    }

    @JsonIgnore
    public Integer getFlexGrow() {
        Object objValue = this.get(FIELD_FLEXGROW);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="flexgrow")
    public void setFlexGrow(Integer flexGrow) {
        this.set(FIELD_FLEXGROW, flexGrow);
    }

    @JsonIgnore
    public boolean isFlexGrowDirty() {
        return this.contains(FIELD_FLEXGROW);
    }

    @JsonIgnore
    public String getFlexVAlign() {
        Object objValue = this.get(FIELD_FLEXVALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="flexvalign")
    public void setFlexVAlign(String flexVAlign) {
        this.set(FIELD_FLEXVALIGN, flexVAlign);
    }

    @JsonIgnore
    public boolean isFlexVAlignDirty() {
        return this.contains(FIELD_FLEXVALIGN);
    }

    @JsonIgnore
    public Integer getGetDataTimer() {
        Object objValue = this.get(FIELD_GETDATATIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="getdatatimer")
    public void setGetDataTimer(Integer getDataTimer) {
        this.set(FIELD_GETDATATIMER, getDataTimer);
    }

    @JsonIgnore
    public boolean isGetDataTimerDirty() {
        return this.contains(FIELD_GETDATATIMER);
    }

    @JsonIgnore
    public Integer getGridRowId() {
        Object objValue = this.get(FIELD_GRIDROWID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="gridrowid")
    public void setGridRowId(Integer gridRowId) {
        this.set(FIELD_GRIDROWID, gridRowId);
    }

    @JsonIgnore
    public boolean isGridRowIdDirty() {
        return this.contains(FIELD_GRIDROWID);
    }

    @JsonIgnore
    public String getHAlign() {
        Object objValue = this.get(FIELD_HALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="halign")
    public void setHAlign(String hAlign) {
        this.set(FIELD_HALIGN, hAlign);
    }

    @JsonIgnore
    public boolean isHAlignDirty() {
        return this.contains(FIELD_HALIGN);
    }

    @JsonIgnore
    public String getHAlignSelf() {
        Object objValue = this.get(FIELD_HALIGNSELF);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="halignself")
    public void setHAlignSelf(String hAlignSelf) {
        this.set(FIELD_HALIGNSELF, hAlignSelf);
    }

    @JsonIgnore
    public boolean isHAlignSelfDirty() {
        return this.contains(FIELD_HALIGNSELF);
    }

    @JsonIgnore
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getHeightMode() {
        Object objValue = this.get(FIELD_HEIGHTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="heightmode")
    public void setHeightMode(String heightMode) {
        this.set(FIELD_HEIGHTMODE, heightMode);
    }

    @JsonIgnore
    public boolean isHeightModeDirty() {
        return this.contains(FIELD_HEIGHTMODE);
    }

    @JsonIgnore
    public String getHtmlContent() {
        Object objValue = this.get(FIELD_HTMLCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlcontent")
    public void setHtmlContent(String htmlContent) {
        this.set(FIELD_HTMLCONTENT, htmlContent);
    }

    @JsonIgnore
    public boolean isHtmlContentDirty() {
        return this.contains(FIELD_HTMLCONTENT);
    }

    @JsonIgnore
    public String getHtmlPageUrl() {
        Object objValue = this.get(FIELD_HTMLPAGEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="htmlpageurl")
    public void setHtmlPageUrl(String htmlPageUrl) {
        this.set(FIELD_HTMLPAGEURL, htmlPageUrl);
    }

    @JsonIgnore
    public boolean isHtmlPageUrlDirty() {
        return this.contains(FIELD_HTMLPAGEURL);
    }

    @JsonIgnore
    public String getIconAlign() {
        Object objValue = this.get(FIELD_ICONALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconalign")
    public void setIconAlign(String iconAlign) {
        this.set(FIELD_ICONALIGN, iconAlign);
    }

    @JsonIgnore
    public boolean isIconAlignDirty() {
        return this.contains(FIELD_ICONALIGN);
    }

    @JsonIgnore
    public Integer getIgnoreInput() {
        Object objValue = this.get(FIELD_IGNOREINPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoreinput")
    public void setIgnoreInput(Integer ignoreInput) {
        this.set(FIELD_IGNOREINPUT, ignoreInput);
    }

    @JsonIgnore
    public boolean isIgnoreInputDirty() {
        return this.contains(FIELD_IGNOREINPUT);
    }

    @JsonIgnore
    public String getItemParam() {
        Object objValue = this.get(FIELD_ITEMPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemparam")
    public void setItemParam(String itemParam) {
        this.set(FIELD_ITEMPARAM, itemParam);
    }

    @JsonIgnore
    public boolean isItemParamDirty() {
        return this.contains(FIELD_ITEMPARAM);
    }

    @JsonIgnore
    public Double getItemParam10() {
        Object objValue = this.get(FIELD_ITEMPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="itemparam10")
    public void setItemParam10(Double itemParam10) {
        this.set(FIELD_ITEMPARAM10, itemParam10);
    }

    @JsonIgnore
    public boolean isItemParam10Dirty() {
        return this.contains(FIELD_ITEMPARAM10);
    }

    @JsonIgnore
    public Integer getItemParam11() {
        Object objValue = this.get(FIELD_ITEMPARAM11);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam11")
    public void setItemParam11(Integer itemParam11) {
        this.set(FIELD_ITEMPARAM11, itemParam11);
    }

    @JsonIgnore
    public boolean isItemParam11Dirty() {
        return this.contains(FIELD_ITEMPARAM11);
    }

    @JsonIgnore
    public Integer getItemParam12() {
        Object objValue = this.get(FIELD_ITEMPARAM12);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam12")
    public void setItemParam12(Integer itemParam12) {
        this.set(FIELD_ITEMPARAM12, itemParam12);
    }

    @JsonIgnore
    public boolean isItemParam12Dirty() {
        return this.contains(FIELD_ITEMPARAM12);
    }

    @JsonIgnore
    public String getItemParam2() {
        Object objValue = this.get(FIELD_ITEMPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemparam2")
    public void setItemParam2(String itemParam2) {
        this.set(FIELD_ITEMPARAM2, itemParam2);
    }

    @JsonIgnore
    public boolean isItemParam2Dirty() {
        return this.contains(FIELD_ITEMPARAM2);
    }

    @JsonIgnore
    public String getItemParam3() {
        Object objValue = this.get(FIELD_ITEMPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemparam3")
    public void setItemParam3(String itemParam3) {
        this.set(FIELD_ITEMPARAM3, itemParam3);
    }

    @JsonIgnore
    public boolean isItemParam3Dirty() {
        return this.contains(FIELD_ITEMPARAM3);
    }

    @JsonIgnore
    public String getItemParam4() {
        Object objValue = this.get(FIELD_ITEMPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemparam4")
    public void setItemParam4(String itemParam4) {
        this.set(FIELD_ITEMPARAM4, itemParam4);
    }

    @JsonIgnore
    public boolean isItemParam4Dirty() {
        return this.contains(FIELD_ITEMPARAM4);
    }

    @JsonIgnore
    public Integer getItemParam5() {
        Object objValue = this.get(FIELD_ITEMPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam5")
    public void setItemParam5(Integer itemParam5) {
        this.set(FIELD_ITEMPARAM5, itemParam5);
    }

    @JsonIgnore
    public boolean isItemParam5Dirty() {
        return this.contains(FIELD_ITEMPARAM5);
    }

    @JsonIgnore
    public Integer getItemParam6() {
        Object objValue = this.get(FIELD_ITEMPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam6")
    public void setItemParam6(Integer itemParam6) {
        this.set(FIELD_ITEMPARAM6, itemParam6);
    }

    @JsonIgnore
    public boolean isItemParam6Dirty() {
        return this.contains(FIELD_ITEMPARAM6);
    }

    @JsonIgnore
    public Integer getItemParam7() {
        Object objValue = this.get(FIELD_ITEMPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam7")
    public void setItemParam7(Integer itemParam7) {
        this.set(FIELD_ITEMPARAM7, itemParam7);
    }

    @JsonIgnore
    public boolean isItemParam7Dirty() {
        return this.contains(FIELD_ITEMPARAM7);
    }

    @JsonIgnore
    public Integer getItemParam8() {
        Object objValue = this.get(FIELD_ITEMPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemparam8")
    public void setItemParam8(Integer itemParam8) {
        this.set(FIELD_ITEMPARAM8, itemParam8);
    }

    @JsonIgnore
    public boolean isItemParam8Dirty() {
        return this.contains(FIELD_ITEMPARAM8);
    }

    @JsonIgnore
    public Double getItemParam9() {
        Object objValue = this.get(FIELD_ITEMPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="itemparam9")
    public void setItemParam9(Double itemParam9) {
        this.set(FIELD_ITEMPARAM9, itemParam9);
    }

    @JsonIgnore
    public boolean isItemParam9Dirty() {
        return this.contains(FIELD_ITEMPARAM9);
    }

    @JsonIgnore
    public String getItemParams() {
        Object objValue = this.get(FIELD_ITEMPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemparams")
    public void setItemParams(String itemParams) {
        this.set(FIELD_ITEMPARAMS, itemParams);
    }

    @JsonIgnore
    public boolean isItemParamsDirty() {
        return this.contains(FIELD_ITEMPARAMS);
    }

    @JsonIgnore
    public String getItemType() {
        Object objValue = this.get(FIELD_ITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemtype")
    public void setItemType(String itemType) {
        this.set(FIELD_ITEMTYPE, itemType);
    }

    @JsonIgnore
    public boolean isItemTypeDirty() {
        return this.contains(FIELD_ITEMTYPE);
    }

    @JsonIgnore
    public String getLabelDynaClass() {
        Object objValue = this.get(FIELD_LABELDYNACLASS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="labeldynaclass")
    public void setLabelDynaClass(String labelDynaClass) {
        this.set(FIELD_LABELDYNACLASS, labelDynaClass);
    }

    @JsonIgnore
    public boolean isLabelDynaClassDirty() {
        return this.contains(FIELD_LABELDYNACLASS);
    }

    @JsonIgnore
    public String getLabelPSSysCssId() {
        Object objValue = this.get(FIELD_LABELPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="labelpssyscssid")
    public void setLabelPSSysCssId(String labelPSSysCssId) {
        this.set(FIELD_LABELPSSYSCSSID, labelPSSysCssId);
    }

    @JsonIgnore
    public boolean isLabelPSSysCssIdDirty() {
        return this.contains(FIELD_LABELPSSYSCSSID);
    }

    @JsonIgnore
    public String getLabelPSSysCssName() {
        Object objValue = this.get(FIELD_LABELPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="labelpssyscssname")
    public void setLabelPSSysCssName(String labelPSSysCssName) {
        this.set(FIELD_LABELPSSYSCSSNAME, labelPSSysCssName);
    }

    @JsonIgnore
    public boolean isLabelPSSysCssNameDirty() {
        return this.contains(FIELD_LABELPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getLabelRawCssStyle() {
        Object objValue = this.get(FIELD_LABELRAWCSSSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="labelrawcssstyle")
    public void setLabelRawCssStyle(String labelRawCssStyle) {
        this.set(FIELD_LABELRAWCSSSTYLE, labelRawCssStyle);
    }

    @JsonIgnore
    public boolean isLabelRawCssStyleDirty() {
        return this.contains(FIELD_LABELRAWCSSSTYLE);
    }

    @JsonIgnore
    public String getLayoutMode() {
        Object objValue = this.get(FIELD_LAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="layoutmode")
    public void setLayoutMode(String layoutMode) {
        this.set(FIELD_LAYOUTMODE, layoutMode);
    }

    @JsonIgnore
    public boolean isLayoutModeDirty() {
        return this.contains(FIELD_LAYOUTMODE);
    }

    @JsonIgnore
    public Integer getLeftPos() {
        Object objValue = this.get(FIELD_LEFTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="leftpos")
    public void setLeftPos(Integer leftPos) {
        this.set(FIELD_LEFTPOS, leftPos);
    }

    @JsonIgnore
    public boolean isLeftPosDirty() {
        return this.contains(FIELD_LEFTPOS);
    }

    @JsonIgnore
    public String getLogicName() {
        Object objValue = this.get(FIELD_LOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicname")
    public void setLogicName(String logicName) {
        this.set(FIELD_LOGICNAME, logicName);
    }

    @JsonIgnore
    public boolean isLogicNameDirty() {
        return this.contains(FIELD_LOGICNAME);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getMobFlag() {
        Object objValue = this.get(FIELD_MOBFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mobflag")
    public void setMobFlag(Integer mobFlag) {
        this.set(FIELD_MOBFLAG, mobFlag);
    }

    @JsonIgnore
    public boolean isMobFlagDirty() {
        return this.contains(FIELD_MOBFLAG);
    }

    @JsonIgnore
    public String getOpenPSAppViewId() {
        Object objValue = this.get(FIELD_OPENPSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsappviewid")
    public void setOpenPSAppViewId(String openPSAppViewId) {
        this.set(FIELD_OPENPSAPPVIEWID, openPSAppViewId);
    }

    @JsonIgnore
    public boolean isOpenPSAppViewIdDirty() {
        return this.contains(FIELD_OPENPSAPPVIEWID);
    }

    @JsonIgnore
    public String getOpenPSAppViewName() {
        Object objValue = this.get(FIELD_OPENPSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsappviewname")
    public void setOpenPSAppViewName(String openPSAppViewName) {
        this.set(FIELD_OPENPSAPPVIEWNAME, openPSAppViewName);
    }

    @JsonIgnore
    public boolean isOpenPSAppViewNameDirty() {
        return this.contains(FIELD_OPENPSAPPVIEWNAME);
    }

    @JsonIgnore
    public String getOpenPSDEViewId() {
        Object objValue = this.get(FIELD_OPENPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsdeviewid")
    public void setOpenPSDEViewId(String openPSDEViewId) {
        this.set(FIELD_OPENPSDEVIEWID, openPSDEViewId);
    }

    @JsonIgnore
    public boolean isOpenPSDEViewIdDirty() {
        return this.contains(FIELD_OPENPSDEVIEWID);
    }

    @JsonIgnore
    public String getOpenPSDEViewName() {
        Object objValue = this.get(FIELD_OPENPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpsdeviewname")
    public void setOpenPSDEViewName(String openPSDEViewName) {
        this.set(FIELD_OPENPSDEVIEWNAME, openPSDEViewName);
    }

    @JsonIgnore
    public boolean isOpenPSDEViewNameDirty() {
        return this.contains(FIELD_OPENPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getOpenPSSysPDTViewId() {
        Object objValue = this.get(FIELD_OPENPSSYSPDTVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpssyspdtviewid")
    public void setOpenPSSysPDTViewId(String openPSSysPDTViewId) {
        this.set(FIELD_OPENPSSYSPDTVIEWID, openPSSysPDTViewId);
    }

    @JsonIgnore
    public boolean isOpenPSSysPDTViewIdDirty() {
        return this.contains(FIELD_OPENPSSYSPDTVIEWID);
    }

    @JsonIgnore
    public String getOpenPSSysPDTViewName() {
        Object objValue = this.get(FIELD_OPENPSSYSPDTVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openpssyspdtviewname")
    public void setOpenPSSysPDTViewName(String openPSSysPDTViewName) {
        this.set(FIELD_OPENPSSYSPDTVIEWNAME, openPSSysPDTViewName);
    }

    @JsonIgnore
    public boolean isOpenPSSysPDTViewNameDirty() {
        return this.contains(FIELD_OPENPSSYSPDTVIEWNAME);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public String getOrientationMode() {
        Object objValue = this.get(FIELD_ORIENTATIONMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="orientationmode")
    public void setOrientationMode(String orientationMode) {
        this.set(FIELD_ORIENTATIONMODE, orientationMode);
    }

    @JsonIgnore
    public boolean isOrientationModeDirty() {
        return this.contains(FIELD_ORIENTATIONMODE);
    }

    @JsonIgnore
    public String getPHPSLanResId() {
        Object objValue = this.get(FIELD_PHPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresid")
    public void setPHPSLanResId(String pHPSLanResId) {
        this.set(FIELD_PHPSLANRESID, pHPSLanResId);
    }

    @JsonIgnore
    public boolean isPHPSLanResIdDirty() {
        return this.contains(FIELD_PHPSLANRESID);
    }

    @JsonIgnore
    public String getPHPSLanResName() {
        Object objValue = this.get(FIELD_PHPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="phpslanresname")
    public void setPHPSLanResName(String pHPSLanResName) {
        this.set(FIELD_PHPSLANRESNAME, pHPSLanResName);
    }

    @JsonIgnore
    public boolean isPHPSLanResNameDirty() {
        return this.contains(FIELD_PHPSLANRESNAME);
    }

    @JsonIgnore
    public String getPlaceHolder() {
        Object objValue = this.get(FIELD_PLACEHOLDER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="placeholder")
    public void setPlaceHolder(String placeHolder) {
        this.set(FIELD_PLACEHOLDER, placeHolder);
    }

    @JsonIgnore
    public boolean isPlaceHolderDirty() {
        return this.contains(FIELD_PLACEHOLDER);
    }

    @JsonIgnore
    public String getPLayoutMode() {
        Object objValue = this.get(FIELD_PLAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="playoutmode")
    public void setPLayoutMode(String pLayoutMode) {
        this.set(FIELD_PLAYOUTMODE, pLayoutMode);
    }

    @JsonIgnore
    public boolean isPLayoutModeDirty() {
        return this.contains(FIELD_PLAYOUTMODE);
    }

    @JsonIgnore
    public String getPPSSysViewPanelItemId() {
        Object objValue = this.get(FIELD_PPSSYSVIEWPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysviewpanelitemid")
    public void setPPSSysViewPanelItemId(String pPSSysViewPanelItemId) {
        this.set(FIELD_PPSSYSVIEWPANELITEMID, pPSSysViewPanelItemId);
    }

    @JsonIgnore
    public boolean isPPSSysViewPanelItemIdDirty() {
        return this.contains(FIELD_PPSSYSVIEWPANELITEMID);
    }

    @JsonIgnore
    public String getPPSSysViewPanelItemName() {
        Object objValue = this.get(FIELD_PPSSYSVIEWPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysviewpanelitemname")
    public void setPPSSysViewPanelItemName(String pPSSysViewPanelItemName) {
        this.set(FIELD_PPSSYSVIEWPANELITEMNAME, pPSSysViewPanelItemName);
    }

    @JsonIgnore
    public boolean isPPSSysViewPanelItemNameDirty() {
        return this.contains(FIELD_PPSSYSVIEWPANELITEMNAME);
    }

    @JsonIgnore
    public String getPredefinedType() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtype")
    public void setPredefinedType(String predefinedType) {
        this.set(FIELD_PREDEFINEDTYPE, predefinedType);
    }

    @JsonIgnore
    public boolean isPredefinedTypeDirty() {
        return this.contains(FIELD_PREDEFINEDTYPE);
    }

    @JsonIgnore
    public String getPredefinedTypeText() {
        Object objValue = this.get(FIELD_PREDEFINEDTYPETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedtypetext")
    public void setPredefinedTypeText(String predefinedTypeText) {
        this.set(FIELD_PREDEFINEDTYPETEXT, predefinedTypeText);
    }

    @JsonIgnore
    public boolean isPredefinedTypeTextDirty() {
        return this.contains(FIELD_PREDEFINEDTYPETEXT);
    }

    @JsonIgnore
    public String getPSACHandlerId() {
        Object objValue = this.get(FIELD_PSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlerid")
    public void setPSACHandlerId(String pSACHandlerId) {
        this.set(FIELD_PSACHANDLERID, pSACHandlerId);
    }

    @JsonIgnore
    public boolean isPSACHandlerIdDirty() {
        return this.contains(FIELD_PSACHANDLERID);
    }

    @JsonIgnore
    public String getPSACHandlerName() {
        Object objValue = this.get(FIELD_PSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psachandlername")
    public void setPSACHandlerName(String pSACHandlerName) {
        this.set(FIELD_PSACHANDLERNAME, pSACHandlerName);
    }

    @JsonIgnore
    public boolean isPSACHandlerNameDirty() {
        return this.contains(FIELD_PSACHANDLERNAME);
    }

    @JsonIgnore
    public String getPSAppMenuId() {
        Object objValue = this.get(FIELD_PSAPPMENUID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuid")
    public void setPSAppMenuId(String pSAppMenuId) {
        this.set(FIELD_PSAPPMENUID, pSAppMenuId);
    }

    @JsonIgnore
    public boolean isPSAppMenuIdDirty() {
        return this.contains(FIELD_PSAPPMENUID);
    }

    @JsonIgnore
    public String getPSAppMenuName() {
        Object objValue = this.get(FIELD_PSAPPMENUNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuname")
    public void setPSAppMenuName(String pSAppMenuName) {
        this.set(FIELD_PSAPPMENUNAME, pSAppMenuName);
    }

    @JsonIgnore
    public boolean isPSAppMenuNameDirty() {
        return this.contains(FIELD_PSAPPMENUNAME);
    }

    @JsonIgnore
    public String getPSCodeListId() {
        Object objValue = this.get(FIELD_PSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistid")
    public void setPSCodeListId(String pSCodeListId) {
        this.set(FIELD_PSCODELISTID, pSCodeListId);
    }

    @JsonIgnore
    public boolean isPSCodeListIdDirty() {
        return this.contains(FIELD_PSCODELISTID);
    }

    @JsonIgnore
    public String getPSCodeListName() {
        Object objValue = this.get(FIELD_PSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pscodelistname")
    public void setPSCodeListName(String pSCodeListName) {
        this.set(FIELD_PSCODELISTNAME, pSCodeListName);
    }

    @JsonIgnore
    public boolean isPSCodeListNameDirty() {
        return this.contains(FIELD_PSCODELISTNAME);
    }

    @JsonIgnore
    public String getPSCtrlId() {
        Object objValue = this.get(FIELD_PSCTRLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlid")
    public void setPSCtrlId(String pSCtrlId) {
        this.set(FIELD_PSCTRLID, pSCtrlId);
    }

    @JsonIgnore
    public boolean isPSCtrlIdDirty() {
        return this.contains(FIELD_PSCTRLID);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupId() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupid")
    public void setPSCtrlLogicGroupId(String pSCtrlLogicGroupId) {
        this.set(FIELD_PSCTRLLOGICGROUPID, pSCtrlLogicGroupId);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupIdDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPID);
    }

    @JsonIgnore
    public String getPSCtrlLogicGroupName() {
        Object objValue = this.get(FIELD_PSCTRLLOGICGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrllogicgroupname")
    public void setPSCtrlLogicGroupName(String pSCtrlLogicGroupName) {
        this.set(FIELD_PSCTRLLOGICGROUPNAME, pSCtrlLogicGroupName);
    }

    @JsonIgnore
    public boolean isPSCtrlLogicGroupNameDirty() {
        return this.contains(FIELD_PSCTRLLOGICGROUPNAME);
    }

    @JsonIgnore
    public String getPSCtrlName() {
        Object objValue = this.get(FIELD_PSCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlname")
    public void setPSCtrlName(String pSCtrlName) {
        this.set(FIELD_PSCTRLNAME, pSCtrlName);
    }

    @JsonIgnore
    public boolean isPSCtrlNameDirty() {
        return this.contains(FIELD_PSCTRLNAME);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEChartId() {
        Object objValue = this.get(FIELD_PSDECHARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartid")
    public void setPSDEChartId(String pSDEChartId) {
        this.set(FIELD_PSDECHARTID, pSDEChartId);
    }

    @JsonIgnore
    public boolean isPSDEChartIdDirty() {
        return this.contains(FIELD_PSDECHARTID);
    }

    @JsonIgnore
    public String getPSDEChartName() {
        Object objValue = this.get(FIELD_PSDECHARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdechartname")
    public void setPSDEChartName(String pSDEChartName) {
        this.set(FIELD_PSDECHARTNAME, pSDEChartName);
    }

    @JsonIgnore
    public boolean isPSDEChartNameDirty() {
        return this.contains(FIELD_PSDECHARTNAME);
    }

    @JsonIgnore
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
    }

    @JsonIgnore
    public String getPSDEDataViewId() {
        Object objValue = this.get(FIELD_PSDEDATAVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataviewid")
    public void setPSDEDataViewId(String pSDEDataViewId) {
        this.set(FIELD_PSDEDATAVIEWID, pSDEDataViewId);
    }

    @JsonIgnore
    public boolean isPSDEDataViewIdDirty() {
        return this.contains(FIELD_PSDEDATAVIEWID);
    }

    @JsonIgnore
    public String getPSDEDataViewName() {
        Object objValue = this.get(FIELD_PSDEDATAVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataviewname")
    public void setPSDEDataViewName(String pSDEDataViewName) {
        this.set(FIELD_PSDEDATAVIEWNAME, pSDEDataViewName);
    }

    @JsonIgnore
    public boolean isPSDEDataViewNameDirty() {
        return this.contains(FIELD_PSDEDATAVIEWNAME);
    }

    @JsonIgnore
    public String getPSDEDRId() {
        Object objValue = this.get(FIELD_PSDEDRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrid")
    public void setPSDEDRId(String pSDEDRId) {
        this.set(FIELD_PSDEDRID, pSDEDRId);
    }

    @JsonIgnore
    public boolean isPSDEDRIdDirty() {
        return this.contains(FIELD_PSDEDRID);
    }

    @JsonIgnore
    public String getPSDEDRItemId() {
        Object objValue = this.get(FIELD_PSDEDRITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedritemid")
    public void setPSDEDRItemId(String pSDEDRItemId) {
        this.set(FIELD_PSDEDRITEMID, pSDEDRItemId);
    }

    @JsonIgnore
    public boolean isPSDEDRItemIdDirty() {
        return this.contains(FIELD_PSDEDRITEMID);
    }

    @JsonIgnore
    public String getPSDEDRItemName() {
        Object objValue = this.get(FIELD_PSDEDRITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedritemname")
    public void setPSDEDRItemName(String pSDEDRItemName) {
        this.set(FIELD_PSDEDRITEMNAME, pSDEDRItemName);
    }

    @JsonIgnore
    public boolean isPSDEDRItemNameDirty() {
        return this.contains(FIELD_PSDEDRITEMNAME);
    }

    @JsonIgnore
    public String getPSDEDRName() {
        Object objValue = this.get(FIELD_PSDEDRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedrname")
    public void setPSDEDRName(String pSDEDRName) {
        this.set(FIELD_PSDEDRNAME, pSDEDRName);
    }

    @JsonIgnore
    public boolean isPSDEDRNameDirty() {
        return this.contains(FIELD_PSDEDRNAME);
    }

    @JsonIgnore
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
    }

    @JsonIgnore
    public String getPSDEGridId() {
        Object objValue = this.get(FIELD_PSDEGRIDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridid")
    public void setPSDEGridId(String pSDEGridId) {
        this.set(FIELD_PSDEGRIDID, pSDEGridId);
    }

    @JsonIgnore
    public boolean isPSDEGridIdDirty() {
        return this.contains(FIELD_PSDEGRIDID);
    }

    @JsonIgnore
    public String getPSDEGridName() {
        Object objValue = this.get(FIELD_PSDEGRIDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdegridname")
    public void setPSDEGridName(String pSDEGridName) {
        this.set(FIELD_PSDEGRIDNAME, pSDEGridName);
    }

    @JsonIgnore
    public boolean isPSDEGridNameDirty() {
        return this.contains(FIELD_PSDEGRIDNAME);
    }

    @JsonIgnore
    public String getPSDEId() {
        Object objValue = this.get(FIELD_PSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeid")
    public void setPSDEId(String pSDEId) {
        this.set(FIELD_PSDEID, pSDEId);
    }

    @JsonIgnore
    public boolean isPSDEIdDirty() {
        return this.contains(FIELD_PSDEID);
    }

    @JsonIgnore
    public String getPSDEListId() {
        Object objValue = this.get(FIELD_PSDELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistid")
    public void setPSDEListId(String pSDEListId) {
        this.set(FIELD_PSDELISTID, pSDEListId);
    }

    @JsonIgnore
    public boolean isPSDEListIdDirty() {
        return this.contains(FIELD_PSDELISTID);
    }

    @JsonIgnore
    public String getPSDEListName() {
        Object objValue = this.get(FIELD_PSDELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelistname")
    public void setPSDEListName(String pSDEListName) {
        this.set(FIELD_PSDELISTNAME, pSDEListName);
    }

    @JsonIgnore
    public boolean isPSDEListNameDirty() {
        return this.contains(FIELD_PSDELISTNAME);
    }

    @JsonIgnore
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
    }

    @JsonIgnore
    public String getPSDEName() {
        Object objValue = this.get(FIELD_PSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdename")
    public void setPSDEName(String pSDEName) {
        this.set(FIELD_PSDENAME, pSDEName);
    }

    @JsonIgnore
    public boolean isPSDENameDirty() {
        return this.contains(FIELD_PSDENAME);
    }

    @JsonIgnore
    public String getPSDEPanelId() {
        Object objValue = this.get(FIELD_PSDEPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdepanelid")
    public void setPSDEPanelId(String pSDEPanelId) {
        this.set(FIELD_PSDEPANELID, pSDEPanelId);
    }

    @JsonIgnore
    public boolean isPSDEPanelIdDirty() {
        return this.contains(FIELD_PSDEPANELID);
    }

    @JsonIgnore
    public String getPSDEPanelName() {
        Object objValue = this.get(FIELD_PSDEPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdepanelname")
    public void setPSDEPanelName(String pSDEPanelName) {
        this.set(FIELD_PSDEPANELNAME, pSDEPanelName);
    }

    @JsonIgnore
    public boolean isPSDEPanelNameDirty() {
        return this.contains(FIELD_PSDEPANELNAME);
    }

    @JsonIgnore
    public String getPSDEReportId() {
        Object objValue = this.get(FIELD_PSDEREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportid")
    public void setPSDEReportId(String pSDEReportId) {
        this.set(FIELD_PSDEREPORTID, pSDEReportId);
    }

    @JsonIgnore
    public boolean isPSDEReportIdDirty() {
        return this.contains(FIELD_PSDEREPORTID);
    }

    @JsonIgnore
    public String getPSDEReportName() {
        Object objValue = this.get(FIELD_PSDEREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportname")
    public void setPSDEReportName(String pSDEReportName) {
        this.set(FIELD_PSDEREPORTNAME, pSDEReportName);
    }

    @JsonIgnore
    public boolean isPSDEReportNameDirty() {
        return this.contains(FIELD_PSDEREPORTNAME);
    }

    @JsonIgnore
    public String getPSDESearchFormId() {
        Object objValue = this.get(FIELD_PSDESEARCHFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesearchformid")
    public void setPSDESearchFormId(String pSDESearchFormId) {
        this.set(FIELD_PSDESEARCHFORMID, pSDESearchFormId);
    }

    @JsonIgnore
    public boolean isPSDESearchFormIdDirty() {
        return this.contains(FIELD_PSDESEARCHFORMID);
    }

    @JsonIgnore
    public String getPSDESearchFormName() {
        Object objValue = this.get(FIELD_PSDESEARCHFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesearchformname")
    public void setPSDESearchFormName(String pSDESearchFormName) {
        this.set(FIELD_PSDESEARCHFORMNAME, pSDESearchFormName);
    }

    @JsonIgnore
    public boolean isPSDESearchFormNameDirty() {
        return this.contains(FIELD_PSDESEARCHFORMNAME);
    }

    @JsonIgnore
    public String getPSDEToolbarId() {
        Object objValue = this.get(FIELD_PSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetoolbarid")
    public void setPSDEToolbarId(String pSDEToolbarId) {
        this.set(FIELD_PSDETOOLBARID, pSDEToolbarId);
    }

    @JsonIgnore
    public boolean isPSDEToolbarIdDirty() {
        return this.contains(FIELD_PSDETOOLBARID);
    }

    @JsonIgnore
    public String getPSDEToolbarName() {
        Object objValue = this.get(FIELD_PSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetoolbarname")
    public void setPSDEToolbarName(String pSDEToolbarName) {
        this.set(FIELD_PSDETOOLBARNAME, pSDEToolbarName);
    }

    @JsonIgnore
    public boolean isPSDEToolbarNameDirty() {
        return this.contains(FIELD_PSDETOOLBARNAME);
    }

    @JsonIgnore
    public String getPSDETreeViewId() {
        Object objValue = this.get(FIELD_PSDETREEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewid")
    public void setPSDETreeViewId(String pSDETreeViewId) {
        this.set(FIELD_PSDETREEVIEWID, pSDETreeViewId);
    }

    @JsonIgnore
    public boolean isPSDETreeViewIdDirty() {
        return this.contains(FIELD_PSDETREEVIEWID);
    }

    @JsonIgnore
    public String getPSDETreeViewName() {
        Object objValue = this.get(FIELD_PSDETREEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewname")
    public void setPSDETreeViewName(String pSDETreeViewName) {
        this.set(FIELD_PSDETREEVIEWNAME, pSDETreeViewName);
    }

    @JsonIgnore
    public boolean isPSDETreeViewNameDirty() {
        return this.contains(FIELD_PSDETREEVIEWNAME);
    }

    @JsonIgnore
    public String getPSDEUAGroupId() {
        Object objValue = this.get(FIELD_PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupid")
    public void setPSDEUAGroupId(String pSDEUAGroupId) {
        this.set(FIELD_PSDEUAGROUPID, pSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupIdDirty() {
        return this.contains(FIELD_PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getPSDEUAGroupName() {
        Object objValue = this.get(FIELD_PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupname")
    public void setPSDEUAGroupName(String pSDEUAGroupName) {
        this.set(FIELD_PSDEUAGROUPNAME, pSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupNameDirty() {
        return this.contains(FIELD_PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getPSDEUIActionId() {
        Object objValue = this.get(FIELD_PSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionid")
    public void setPSDEUIActionId(String pSDEUIActionId) {
        this.set(FIELD_PSDEUIACTIONID, pSDEUIActionId);
    }

    @JsonIgnore
    public boolean isPSDEUIActionIdDirty() {
        return this.contains(FIELD_PSDEUIACTIONID);
    }

    @JsonIgnore
    public String getPSDEUIActionName() {
        Object objValue = this.get(FIELD_PSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionname")
    public void setPSDEUIActionName(String pSDEUIActionName) {
        this.set(FIELD_PSDEUIACTIONNAME, pSDEUIActionName);
    }

    @JsonIgnore
    public boolean isPSDEUIActionNameDirty() {
        return this.contains(FIELD_PSDEUIACTIONNAME);
    }

    @JsonIgnore
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getPSDEWizardId() {
        Object objValue = this.get(FIELD_PSDEWIZARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardid")
    public void setPSDEWizardId(String pSDEWizardId) {
        this.set(FIELD_PSDEWIZARDID, pSDEWizardId);
    }

    @JsonIgnore
    public boolean isPSDEWizardIdDirty() {
        return this.contains(FIELD_PSDEWIZARDID);
    }

    @JsonIgnore
    public String getPSDEWizardName() {
        Object objValue = this.get(FIELD_PSDEWIZARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdewizardname")
    public void setPSDEWizardName(String pSDEWizardName) {
        this.set(FIELD_PSDEWIZARDNAME, pSDEWizardName);
    }

    @JsonIgnore
    public boolean isPSDEWizardNameDirty() {
        return this.contains(FIELD_PSDEWIZARDNAME);
    }

    @JsonIgnore
    public String getPSSysCalendarId() {
        Object objValue = this.get(FIELD_PSSYSCALENDARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendarid")
    public void setPSSysCalendarId(String pSSysCalendarId) {
        this.set(FIELD_PSSYSCALENDARID, pSSysCalendarId);
    }

    @JsonIgnore
    public boolean isPSSysCalendarIdDirty() {
        return this.contains(FIELD_PSSYSCALENDARID);
    }

    @JsonIgnore
    public String getPSSysCalendarName() {
        Object objValue = this.get(FIELD_PSSYSCALENDARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscalendarname")
    public void setPSSysCalendarName(String pSSysCalendarName) {
        this.set(FIELD_PSSYSCALENDARNAME, pSSysCalendarName);
    }

    @JsonIgnore
    public boolean isPSSysCalendarNameDirty() {
        return this.contains(FIELD_PSSYSCALENDARNAME);
    }

    @JsonIgnore
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
    }

    @JsonIgnore
    public String getPSSysDashboardId() {
        Object objValue = this.get(FIELD_PSSYSDASHBOARDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdashboardid")
    public void setPSSysDashboardId(String pSSysDashboardId) {
        this.set(FIELD_PSSYSDASHBOARDID, pSSysDashboardId);
    }

    @JsonIgnore
    public boolean isPSSysDashboardIdDirty() {
        return this.contains(FIELD_PSSYSDASHBOARDID);
    }

    @JsonIgnore
    public String getPSSysDashboardName() {
        Object objValue = this.get(FIELD_PSSYSDASHBOARDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdashboardname")
    public void setPSSysDashboardName(String pSSysDashboardName) {
        this.set(FIELD_PSSYSDASHBOARDNAME, pSSysDashboardName);
    }

    @JsonIgnore
    public boolean isPSSysDashboardNameDirty() {
        return this.contains(FIELD_PSSYSDASHBOARDNAME);
    }

    @JsonIgnore
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysEditorStyleId() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstyleid")
    public void setPSSysEditorStyleId(String pSSysEditorStyleId) {
        this.set(FIELD_PSSYSEDITORSTYLEID, pSSysEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleIdDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSSysEditorStyleName() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstylename")
    public void setPSSysEditorStyleName(String pSSysEditorStyleName) {
        this.set(FIELD_PSSYSEDITORSTYLENAME, pSSysEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleNameDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLENAME);
    }

    @JsonIgnore
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getPSSysMapViewId() {
        Object objValue = this.get(FIELD_PSSYSMAPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmapviewid")
    public void setPSSysMapViewId(String pSSysMapViewId) {
        this.set(FIELD_PSSYSMAPVIEWID, pSSysMapViewId);
    }

    @JsonIgnore
    public boolean isPSSysMapViewIdDirty() {
        return this.contains(FIELD_PSSYSMAPVIEWID);
    }

    @JsonIgnore
    public String getPSSysMapViewName() {
        Object objValue = this.get(FIELD_PSSYSMAPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmapviewname")
    public void setPSSysMapViewName(String pSSysMapViewName) {
        this.set(FIELD_PSSYSMAPVIEWNAME, pSSysMapViewName);
    }

    @JsonIgnore
    public boolean isPSSysMapViewNameDirty() {
        return this.contains(FIELD_PSSYSMAPVIEWNAME);
    }

    @JsonIgnore
    public String getPSSysPFPluginId() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginid")
    public void setPSSysPFPluginId(String pSSysPFPluginId) {
        this.set(FIELD_PSSYSPFPLUGINID, pSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginIdDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysPFPluginName() {
        Object objValue = this.get(FIELD_PSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyspfpluginname")
    public void setPSSysPFPluginName(String pSSysPFPluginName) {
        this.set(FIELD_PSSYSPFPLUGINNAME, pSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysPFPluginNameDirty() {
        return this.contains(FIELD_PSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getPSSysResourceId() {
        Object objValue = this.get(FIELD_PSSYSRESOURCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysresourceid")
    public void setPSSysResourceId(String pSSysResourceId) {
        this.set(FIELD_PSSYSRESOURCEID, pSSysResourceId);
    }

    @JsonIgnore
    public boolean isPSSysResourceIdDirty() {
        return this.contains(FIELD_PSSYSRESOURCEID);
    }

    @JsonIgnore
    public String getPSSysResourceName() {
        Object objValue = this.get(FIELD_PSSYSRESOURCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysresourcename")
    public void setPSSysResourceName(String pSSysResourceName) {
        this.set(FIELD_PSSYSRESOURCENAME, pSSysResourceName);
    }

    @JsonIgnore
    public boolean isPSSysResourceNameDirty() {
        return this.contains(FIELD_PSSYSRESOURCENAME);
    }

    @JsonIgnore
    public String getPSSysSearchBarId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchbarid")
    public void setPSSysSearchBarId(String pSSysSearchBarId) {
        this.set(FIELD_PSSYSSEARCHBARID, pSSysSearchBarId);
    }

    @JsonIgnore
    public boolean isPSSysSearchBarIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHBARID);
    }

    @JsonIgnore
    public String getPSSysSearchBarName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchbarname")
    public void setPSSysSearchBarName(String pSSysSearchBarName) {
        this.set(FIELD_PSSYSSEARCHBARNAME, pSSysSearchBarName);
    }

    @JsonIgnore
    public boolean isPSSysSearchBarNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHBARNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelid")
    public void setPSSysViewPanelId(String pSSysViewPanelId) {
        this.set(FIELD_PSSYSVIEWPANELID, pSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemid")
    public void setPSSysViewPanelItemId(String pSSysViewPanelItemId) {
        this.set(FIELD_PSSYSVIEWPANELITEMID, pSSysViewPanelItemId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMID);
    }

    @JsonIgnore
    public String getPSSysViewPanelItemName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelitemname")
    public void setPSSysViewPanelItemName(String pSSysViewPanelItemName) {
        this.set(FIELD_PSSYSVIEWPANELITEMNAME, pSSysViewPanelItemName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelItemNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELITEMNAME);
    }

    @JsonIgnore
    public String getPSSysViewPanelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelname")
    public void setPSSysViewPanelName(String pSSysViewPanelName) {
        this.set(FIELD_PSSYSVIEWPANELNAME, pSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELNAME);
    }

    @JsonIgnore
    public String getRawContent() {
        Object objValue = this.get(FIELD_RAWCONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawcontent")
    public void setRawContent(String rawContent) {
        this.set(FIELD_RAWCONTENT, rawContent);
    }

    @JsonIgnore
    public boolean isRawContentDirty() {
        return this.contains(FIELD_RAWCONTENT);
    }

    @JsonIgnore
    public String getRawCssStyle() {
        Object objValue = this.get(FIELD_RAWCSSSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawcssstyle")
    public void setRawCssStyle(String rawCssStyle) {
        this.set(FIELD_RAWCSSSTYLE, rawCssStyle);
    }

    @JsonIgnore
    public boolean isRawCssStyleDirty() {
        return this.contains(FIELD_RAWCSSSTYLE);
    }

    @JsonIgnore
    public String getRawServiceMethod() {
        Object objValue = this.get(FIELD_RAWSERVICEMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawservicemethod")
    public void setRawServiceMethod(String rawServiceMethod) {
        this.set(FIELD_RAWSERVICEMETHOD, rawServiceMethod);
    }

    @JsonIgnore
    public boolean isRawServiceMethodDirty() {
        return this.contains(FIELD_RAWSERVICEMETHOD);
    }

    @JsonIgnore
    public String getRawServiceUrl() {
        Object objValue = this.get(FIELD_RAWSERVICEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rawserviceurl")
    public void setRawServiceUrl(String rawServiceUrl) {
        this.set(FIELD_RAWSERVICEURL, rawServiceUrl);
    }

    @JsonIgnore
    public boolean isRawServiceUrlDirty() {
        return this.contains(FIELD_RAWSERVICEURL);
    }

    @JsonIgnore
    public Integer getReadOnlyMode() {
        Object objValue = this.get(FIELD_READONLYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="readonlymode")
    public void setReadOnlyMode(Integer readOnlyMode) {
        this.set(FIELD_READONLYMODE, readOnlyMode);
    }

    @JsonIgnore
    public boolean isReadOnlyModeDirty() {
        return this.contains(FIELD_READONLYMODE);
    }

    @JsonIgnore
    public String getRefCtrl2Name() {
        Object objValue = this.get(FIELD_REFCTRL2NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2name")
    public void setRefCtrl2Name(String refCtrl2Name) {
        this.set(FIELD_REFCTRL2NAME, refCtrl2Name);
    }

    @JsonIgnore
    public boolean isRefCtrl2NameDirty() {
        return this.contains(FIELD_REFCTRL2NAME);
    }

    @JsonIgnore
    public String getRefCtrl2Usage() {
        Object objValue = this.get(FIELD_REFCTRL2USAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2usage")
    public void setRefCtrl2Usage(String refCtrl2Usage) {
        this.set(FIELD_REFCTRL2USAGE, refCtrl2Usage);
    }

    @JsonIgnore
    public boolean isRefCtrl2UsageDirty() {
        return this.contains(FIELD_REFCTRL2USAGE);
    }

    @JsonIgnore
    public String getRefCtrl2UsageText() {
        Object objValue = this.get(FIELD_REFCTRL2USAGETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrl2usagetext")
    public void setRefCtrl2UsageText(String refCtrl2UsageText) {
        this.set(FIELD_REFCTRL2USAGETEXT, refCtrl2UsageText);
    }

    @JsonIgnore
    public boolean isRefCtrl2UsageTextDirty() {
        return this.contains(FIELD_REFCTRL2USAGETEXT);
    }

    @JsonIgnore
    public String getRefCtrlName() {
        Object objValue = this.get(FIELD_REFCTRLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlname")
    public void setRefCtrlName(String refCtrlName) {
        this.set(FIELD_REFCTRLNAME, refCtrlName);
    }

    @JsonIgnore
    public boolean isRefCtrlNameDirty() {
        return this.contains(FIELD_REFCTRLNAME);
    }

    @JsonIgnore
    public String getRefCtrlUsage() {
        Object objValue = this.get(FIELD_REFCTRLUSAGE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlusage")
    public void setRefCtrlUsage(String refCtrlUsage) {
        this.set(FIELD_REFCTRLUSAGE, refCtrlUsage);
    }

    @JsonIgnore
    public boolean isRefCtrlUsageDirty() {
        return this.contains(FIELD_REFCTRLUSAGE);
    }

    @JsonIgnore
    public String getRefCtrlUsageText() {
        Object objValue = this.get(FIELD_REFCTRLUSAGETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refctrlusagetext")
    public void setRefCtrlUsageText(String refCtrlUsageText) {
        this.set(FIELD_REFCTRLUSAGETEXT, refCtrlUsageText);
    }

    @JsonIgnore
    public boolean isRefCtrlUsageTextDirty() {
        return this.contains(FIELD_REFCTRLUSAGETEXT);
    }

    @JsonIgnore
    public String getRefLinkPSDEViewId() {
        Object objValue = this.get(FIELD_REFLINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reflinkpsdeviewid")
    public void setRefLinkPSDEViewId(String refLinkPSDEViewId) {
        this.set(FIELD_REFLINKPSDEVIEWID, refLinkPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefLinkPSDEViewIdDirty() {
        return this.contains(FIELD_REFLINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefLinkPSDEViewName() {
        Object objValue = this.get(FIELD_REFLINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reflinkpsdeviewname")
    public void setRefLinkPSDEViewName(String refLinkPSDEViewName) {
        this.set(FIELD_REFLINKPSDEVIEWNAME, refLinkPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefLinkPSDEViewNameDirty() {
        return this.contains(FIELD_REFLINKPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewId() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewid")
    public void setRefPickupPSDEViewId(String refPickupPSDEViewId) {
        this.set(FIELD_REFPICKUPPSDEVIEWID, refPickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewIdDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getRefPickupPSDEViewName() {
        Object objValue = this.get(FIELD_REFPICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpickuppsdeviewname")
    public void setRefPickupPSDEViewName(String refPickupPSDEViewName) {
        this.set(FIELD_REFPICKUPPSDEVIEWNAME, refPickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isRefPickupPSDEViewNameDirty() {
        return this.contains(FIELD_REFPICKUPPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getRefPSDEACModeId() {
        Object objValue = this.get(FIELD_REFPSDEACMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodeid")
    public void setRefPSDEACModeId(String refPSDEACModeId) {
        this.set(FIELD_REFPSDEACMODEID, refPSDEACModeId);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeIdDirty() {
        return this.contains(FIELD_REFPSDEACMODEID);
    }

    @JsonIgnore
    public String getRefPSDEACModeName() {
        Object objValue = this.get(FIELD_REFPSDEACMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeacmodename")
    public void setRefPSDEACModeName(String refPSDEACModeName) {
        this.set(FIELD_REFPSDEACMODENAME, refPSDEACModeName);
    }

    @JsonIgnore
    public boolean isRefPSDEACModeNameDirty() {
        return this.contains(FIELD_REFPSDEACMODENAME);
    }

    @JsonIgnore
    public String getRefPSDEDataSetId() {
        Object objValue = this.get(FIELD_REFPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetid")
    public void setRefPSDEDataSetId(String refPSDEDataSetId) {
        this.set(FIELD_REFPSDEDATASETID, refPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetIdDirty() {
        return this.contains(FIELD_REFPSDEDATASETID);
    }

    @JsonIgnore
    public String getRefPSDEDataSetName() {
        Object objValue = this.get(FIELD_REFPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdedatasetname")
    public void setRefPSDEDataSetName(String refPSDEDataSetName) {
        this.set(FIELD_REFPSDEDATASETNAME, refPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isRefPSDEDataSetNameDirty() {
        return this.contains(FIELD_REFPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getRenderMode() {
        Object objValue = this.get(FIELD_RENDERMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rendermode")
    public void setRenderMode(String renderMode) {
        this.set(FIELD_RENDERMODE, renderMode);
    }

    @JsonIgnore
    public boolean isRenderModeDirty() {
        return this.contains(FIELD_RENDERMODE);
    }

    @JsonIgnore
    public String getRenderModeText() {
        Object objValue = this.get(FIELD_RENDERMODETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rendermodetext")
    public void setRenderModeText(String renderModeText) {
        this.set(FIELD_RENDERMODETEXT, renderModeText);
    }

    @JsonIgnore
    public boolean isRenderModeTextDirty() {
        return this.contains(FIELD_RENDERMODETEXT);
    }

    @JsonIgnore
    public Integer getRightPos() {
        Object objValue = this.get(FIELD_RIGHTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rightpos")
    public void setRightPos(Integer rightPos) {
        this.set(FIELD_RIGHTPOS, rightPos);
    }

    @JsonIgnore
    public boolean isRightPosDirty() {
        return this.contains(FIELD_RIGHTPOS);
    }

    @JsonIgnore
    public Integer getRowSpan() {
        Object objValue = this.get(FIELD_ROWSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rowspan")
    public void setRowSpan(Integer rowSpan) {
        this.set(FIELD_ROWSPAN, rowSpan);
    }

    @JsonIgnore
    public boolean isRowSpanDirty() {
        return this.contains(FIELD_ROWSPAN);
    }

    @JsonIgnore
    public Integer getShowCaption() {
        Object objValue = this.get(FIELD_SHOWCAPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showcaption")
    public void setShowCaption(Integer showCaption) {
        this.set(FIELD_SHOWCAPTION, showCaption);
    }

    @JsonIgnore
    public boolean isShowCaptionDirty() {
        return this.contains(FIELD_SHOWCAPTION);
    }

    @JsonIgnore
    public String getSpacingBottom() {
        Object objValue = this.get(FIELD_SPACINGBOTTOM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="spacingbottom")
    public void setSpacingBottom(String spacingBottom) {
        this.set(FIELD_SPACINGBOTTOM, spacingBottom);
    }

    @JsonIgnore
    public boolean isSpacingBottomDirty() {
        return this.contains(FIELD_SPACINGBOTTOM);
    }

    @JsonIgnore
    public String getSpacingLeft() {
        Object objValue = this.get(FIELD_SPACINGLEFT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="spacingleft")
    public void setSpacingLeft(String spacingLeft) {
        this.set(FIELD_SPACINGLEFT, spacingLeft);
    }

    @JsonIgnore
    public boolean isSpacingLeftDirty() {
        return this.contains(FIELD_SPACINGLEFT);
    }

    @JsonIgnore
    public String getSpacingRight() {
        Object objValue = this.get(FIELD_SPACINGRIGHT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="spacingright")
    public void setSpacingRight(String spacingRight) {
        this.set(FIELD_SPACINGRIGHT, spacingRight);
    }

    @JsonIgnore
    public boolean isSpacingRightDirty() {
        return this.contains(FIELD_SPACINGRIGHT);
    }

    @JsonIgnore
    public String getSpacingTop() {
        Object objValue = this.get(FIELD_SPACINGTOP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="spacingtop")
    public void setSpacingTop(String spacingTop) {
        this.set(FIELD_SPACINGTOP, spacingTop);
    }

    @JsonIgnore
    public boolean isSpacingTopDirty() {
        return this.contains(FIELD_SPACINGTOP);
    }

    @JsonIgnore
    public String getSwapMode() {
        Object objValue = this.get(FIELD_SWAPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="swapmode")
    public void setSwapMode(String swapMode) {
        this.set(FIELD_SWAPMODE, swapMode);
    }

    @JsonIgnore
    public boolean isSwapModeDirty() {
        return this.contains(FIELD_SWAPMODE);
    }

    @JsonIgnore
    public Integer getTabIndex() {
        Object objValue = this.get(FIELD_TABINDEX);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tabindex")
    public void setTabIndex(Integer tabIndex) {
        this.set(FIELD_TABINDEX, tabIndex);
    }

    @JsonIgnore
    public boolean isTabIndexDirty() {
        return this.contains(FIELD_TABINDEX);
    }

    @JsonIgnore
    public String getTargetId() {
        Object objValue = this.get(FIELD_TARGETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetid")
    public void setTargetId(String targetId) {
        this.set(FIELD_TARGETID, targetId);
    }

    @JsonIgnore
    public boolean isTargetIdDirty() {
        return this.contains(FIELD_TARGETID);
    }

    @JsonIgnore
    public String getTargetName() {
        Object objValue = this.get(FIELD_TARGETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetname")
    public void setTargetName(String targetName) {
        this.set(FIELD_TARGETNAME, targetName);
    }

    @JsonIgnore
    public boolean isTargetNameDirty() {
        return this.contains(FIELD_TARGETNAME);
    }

    @JsonIgnore
    public String getTargetType() {
        Object objValue = this.get(FIELD_TARGETTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettype")
    public void setTargetType(String targetType) {
        this.set(FIELD_TARGETTYPE, targetType);
    }

    @JsonIgnore
    public boolean isTargetTypeDirty() {
        return this.contains(FIELD_TARGETTYPE);
    }

    @JsonIgnore
    public Integer getTitleBarCloseMode() {
        Object objValue = this.get(FIELD_TITLEBARCLOSEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="titlebarclosemode")
    public void setTitleBarCloseMode(Integer titleBarCloseMode) {
        this.set(FIELD_TITLEBARCLOSEMODE, titleBarCloseMode);
    }

    @JsonIgnore
    public boolean isTitleBarCloseModeDirty() {
        return this.contains(FIELD_TITLEBARCLOSEMODE);
    }

    @JsonIgnore
    public String getToggleMode() {
        Object objValue = this.get(FIELD_TOGGLEMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="togglemode")
    public void setToggleMode(String toggleMode) {
        this.set(FIELD_TOGGLEMODE, toggleMode);
    }

    @JsonIgnore
    public boolean isToggleModeDirty() {
        return this.contains(FIELD_TOGGLEMODE);
    }

    @JsonIgnore
    public String getTooltipInfo() {
        Object objValue = this.get(FIELD_TOOLTIPINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tooltipinfo")
    public void setTooltipInfo(String tooltipInfo) {
        this.set(FIELD_TOOLTIPINFO, tooltipInfo);
    }

    @JsonIgnore
    public boolean isTooltipInfoDirty() {
        return this.contains(FIELD_TOOLTIPINFO);
    }

    @JsonIgnore
    public Integer getTopPos() {
        Object objValue = this.get(FIELD_TOPPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="toppos")
    public void setTopPos(Integer topPos) {
        this.set(FIELD_TOPPOS, topPos);
    }

    @JsonIgnore
    public boolean isTopPosDirty() {
        return this.contains(FIELD_TOPPOS);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getVAlign() {
        Object objValue = this.get(FIELD_VALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valign")
    public void setVAlign(String vAlign) {
        this.set(FIELD_VALIGN, vAlign);
    }

    @JsonIgnore
    public boolean isVAlignDirty() {
        return this.contains(FIELD_VALIGN);
    }

    @JsonIgnore
    public String getVAlignSelf() {
        Object objValue = this.get(FIELD_VALIGNSELF);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valignself")
    public void setVAlignSelf(String vAlignSelf) {
        this.set(FIELD_VALIGNSELF, vAlignSelf);
    }

    @JsonIgnore
    public boolean isVAlignSelfDirty() {
        return this.contains(FIELD_VALIGNSELF);
    }

    @JsonIgnore
    public String getValueFormat() {
        Object objValue = this.get(FIELD_VALUEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueformat")
    public void setValueFormat(String valueFormat) {
        this.set(FIELD_VALUEFORMAT, valueFormat);
    }

    @JsonIgnore
    public boolean isValueFormatDirty() {
        return this.contains(FIELD_VALUEFORMAT);
    }

    @JsonIgnore
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @JsonIgnore
    public String getWidthMode() {
        Object objValue = this.get(FIELD_WIDTHMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="widthmode")
    public void setWidthMode(String widthMode) {
        this.set(FIELD_WIDTHMODE, widthMode);
    }

    @JsonIgnore
    public boolean isWidthModeDirty() {
        return this.contains(FIELD_WIDTHMODE);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysViewPanelItemId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysViewPanelItemId(strValue);
    }

    public List<PSSysViewPanelItem> getPssysviewpanelitems() {
        return this.pssysviewpanelitems;
    }

    public void setPssysviewpanelitems(List<PSSysViewPanelItem> pssysviewpanelitems) {
        this.pssysviewpanelitems = pssysviewpanelitems;
    }

    public List<PSPanelItemLogic> getPspanelitemlogics() {
        return this.pspanelitemlogics;
    }

    public void setPspanelitemlogics(List<PSPanelItemLogic> pspanelitemlogics) {
        this.pspanelitemlogics = pspanelitemlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysviewpanelitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pspanelitemlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysviewpanelitems")) {
            this.init();
            return this.pssysviewpanelitems;
        }
        if (strName.equalsIgnoreCase("pspanelitemlogics")) {
            this.init();
            return this.pspanelitemlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSVIEWPANELITEM";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysViewPanelItem item = (PSSysViewPanelItem)MAPPER.readValue(new File(strJsonFilePath), PSSysViewPanelItem.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysViewPanelItem) {
            PSSysViewPanelItem dst = (PSSysViewPanelItem)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssysviewpanelitems() != null) {
                    ArrayList<PSSysViewPanelItem> pssysviewpanelitems = new ArrayList<PSSysViewPanelItem>();
                    for (PSSysViewPanelItem pSSysViewPanelItem : this.getPssysviewpanelitems()) {
                        if (bDeepMode) {
                            newitem = new PSSysViewPanelItem();
                            pSSysViewPanelItem.to(newitem, false, bDeepMode);
                            pssysviewpanelitems.add((PSSysViewPanelItem)newitem);
                            continue;
                        }
                        pssysviewpanelitems.add(pSSysViewPanelItem);
                    }
                    dst.setPssysviewpanelitems(pssysviewpanelitems);
                }
                if (this.getPspanelitemlogics() != null) {
                    ArrayList<PSPanelItemLogic> pspanelitemlogics = new ArrayList<PSPanelItemLogic>();
                    for (PSPanelItemLogic pSPanelItemLogic : this.getPspanelitemlogics()) {
                        if (bDeepMode) {
                            newitem = new PSPanelItemLogic();
                            pSPanelItemLogic.to(newitem, false, bDeepMode);
                            pspanelitemlogics.add((PSPanelItemLogic)newitem);
                            continue;
                        }
                        pspanelitemlogics.add(pSPanelItemLogic);
                    }
                    dst.setPspanelitemlogics(pspanelitemlogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysViewPanelItem) {
            PSSysViewPanelItem src = (PSSysViewPanelItem)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssysviewpanelitems() != null) {
                    ArrayList<PSSysViewPanelItem> pssysviewpanelitems = new ArrayList<PSSysViewPanelItem>();
                    for (PSSysViewPanelItem pSSysViewPanelItem : src.getPssysviewpanelitems()) {
                        if (bDeepMode) {
                            newItem = new PSSysViewPanelItem();
                            ((PSSysViewPanelItem)newItem).from(pSSysViewPanelItem, false, bDeepMode);
                            pssysviewpanelitems.add((PSSysViewPanelItem)newItem);
                            continue;
                        }
                        pssysviewpanelitems.add(pSSysViewPanelItem);
                    }
                    this.setPssysviewpanelitems(pssysviewpanelitems);
                }
                if (src.getPspanelitemlogics() != null) {
                    ArrayList<PSPanelItemLogic> pspanelitemlogics = new ArrayList<PSPanelItemLogic>();
                    for (PSPanelItemLogic pSPanelItemLogic : src.getPspanelitemlogics()) {
                        if (bDeepMode) {
                            newItem = new PSPanelItemLogic();
                            ((PSPanelItemLogic)newItem).from(pSPanelItemLogic, false, bDeepMode);
                            pspanelitemlogics.add((PSPanelItemLogic)newItem);
                            continue;
                        }
                        pspanelitemlogics.add(pSPanelItemLogic);
                    }
                    this.setPspanelitemlogics(pspanelitemlogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

