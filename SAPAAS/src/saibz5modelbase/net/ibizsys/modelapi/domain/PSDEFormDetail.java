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
import net.ibizsys.modelapi.domain.PSDEFDLogic;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEFormDetail
extends PSModelBase {
    public static final String FIELD_ALLOWEMPTY = "allowempty";
    public static final String FIELD_BL_POS = "bl_pos";
    public static final String FIELD_BORDERSTYLE = "borderstyle";
    public static final String FIELD_BTNACTIONTYPE = "btnactiontype";
    public static final String FIELD_BUILDINACTION = "buildinaction";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CHILD_COL_LG = "child_col_lg";
    public static final String FIELD_CHILD_COL_MD = "child_col_md";
    public static final String FIELD_CHILD_COL_SM = "child_col_sm";
    public static final String FIELD_CHILD_COL_XS = "child_col_xs";
    public static final String FIELD_CODELISTCONFIGMODE = "codelistconfigmode";
    public static final String FIELD_COLALIGN = "colalign";
    public static final String FIELD_COLID = "colid";
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
    public static final String FIELD_CONVERTCITEXT = "convertcitext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEDV = "createdv";
    public static final String FIELD_CREATEDVT = "createdvt";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLCOLSPAN = "ctrlcolspan";
    public static final String FIELD_CTRLDYNACLASS = "ctrldynaclass";
    public static final String FIELD_CTRLHEIGHT = "ctrlheight";
    public static final String FIELD_CTRLPSSYSCSSID = "ctrlpssyscssid";
    public static final String FIELD_CTRLPSSYSCSSNAME = "ctrlpssyscssname";
    public static final String FIELD_CTRLRAWCSSSTYLE = "ctrlrawcssstyle";
    public static final String FIELD_CTRLWIDTH = "ctrlwidth";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DETAILSTYLE = "detailstyle";
    public static final String FIELD_DETAILSTYLETEXT = "detailstyletext";
    public static final String FIELD_DETAILTAG = "detailtag";
    public static final String FIELD_DETAILTAG2 = "detailtag2";
    public static final String FIELD_DETAILTYPE = "detailtype";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITORPARAMS = "editorparams";
    public static final String FIELD_EDITORTYPE = "editortype";
    public static final String FIELD_EDITORTYPENAME = "editortypename";
    public static final String FIELD_EMPTYCAPTION = "emptycaption";
    public static final String FIELD_ENABLEANCHOR = "enableanchor";
    public static final String FIELD_ENABLECOND = "enablecond";
    public static final String FIELD_ENABLEITEMPRIV = "enableitempriv";
    public static final String FIELD_FIELDNAME = "fieldname";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXGROW = "flexgrow";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_FORMTYPE = "formtype";
    public static final String FIELD_GRIDROWID = "gridrowid";
    public static final String FIELD_HALIGN = "halign";
    public static final String FIELD_HALIGNSELF = "halignself";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HEIGHTMODE = "heightmode";
    public static final String FIELD_HTMLCONTENT = "htmlcontent";
    public static final String FIELD_HTMLPAGEURL = "htmlpageurl";
    public static final String FIELD_ICONALIGN = "iconalign";
    public static final String FIELD_IGNOREINPUT = "ignoreinput";
    public static final String FIELD_ITEMPSACHANDLERID = "itempsachandlerid";
    public static final String FIELD_ITEMPSACHANDLERNAME = "itempsachandlername";
    public static final String FIELD_ITEMSTATES = "itemstates";
    public static final String FIELD_LABELCOLSPAN = "labelcolspan";
    public static final String FIELD_LABELCOLSPAN2 = "labelcolspan2";
    public static final String FIELD_LABELDYNACLASS = "labeldynaclass";
    public static final String FIELD_LABELPOS = "labelpos";
    public static final String FIELD_LABELPSSYSCSSID = "labelpssyscssid";
    public static final String FIELD_LABELPSSYSCSSNAME = "labelpssyscssname";
    public static final String FIELD_LABELRAWCSSSTYLE = "labelrawcssstyle";
    public static final String FIELD_LABELWIDTH = "labelwidth";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_LEVELTAG = "leveltag";
    public static final String FIELD_LINKPSDEVIEWID = "linkpsdeviewid";
    public static final String FIELD_LINKPSDEVIEWNAME = "linkpsdeviewname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MARGIN = "margin";
    public static final String FIELD_MDCTRLTYPE = "mdctrltype";
    public static final String FIELD_MDPSDEDATAVIEWID = "mdpsdedataviewid";
    public static final String FIELD_MDPSDEDATAVIEWNAME = "mdpsdedataviewname";
    public static final String FIELD_MDPSDEFORMID = "mdpsdeformid";
    public static final String FIELD_MDPSDEFORMNAME = "mdpsdeformname";
    public static final String FIELD_MDPSDEGRIDID = "mdpsdegridid";
    public static final String FIELD_MDPSDEGRIDNAME = "mdpsdegridname";
    public static final String FIELD_MDPSDELISTID = "mdpsdelistid";
    public static final String FIELD_MDPSDELISTNAME = "mdpsdelistname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_NEEDCODELISTCONFIG = "needcodelistconfig";
    public static final String FIELD_NOPRIVDM = "noprivdm";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PADDING = "padding";
    public static final String FIELD_PHPSLANRESID = "phpslanresid";
    public static final String FIELD_PHPSLANRESNAME = "phpslanresname";
    public static final String FIELD_PICKUPPSDEVIEWID = "pickuppsdeviewid";
    public static final String FIELD_PICKUPPSDEVIEWNAME = "pickuppsdeviewname";
    public static final String FIELD_PLACEHOLDER = "placeholder";
    public static final String FIELD_PLAYOUTMODE = "playoutmode";
    public static final String FIELD_PPSDEFORMDETAILID = "ppsdeformdetailid";
    public static final String FIELD_PPSDEFORMDETAILNAME = "ppsdeformdetailname";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSCODELISTID = "pscodelistid";
    public static final String FIELD_PSCODELISTNAME = "pscodelistname";
    public static final String FIELD_PSDEDRITEMID = "psdedritemid";
    public static final String FIELD_PSDEDRITEMNAME = "psdedritemname";
    public static final String FIELD_PSDEFUIMODEID = "psdefformitemid";
    public static final String FIELD_PSDEFUIMODENAME = "psdefformitemname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFIUPDATEID = "psdefiupdateid";
    public static final String FIELD_PSDEFIUPDATENAME = "psdefiupdatename";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEFORMDETAILID = "psdeformdetailid";
    public static final String FIELD_PSDEFORMDETAILNAME = "psdeformdetailname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEFORMRFID = "psdeformrfid";
    public static final String FIELD_PSDEFORMRFNAME = "psdeformrfname";
    public static final String FIELD_PSDEFSFITEMID = "psdefsfitemid";
    public static final String FIELD_PSDEFSFITEMNAME = "psdefsfitemname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDICTCATID = "pssysdictcatid";
    public static final String FIELD_PSSYSDICTCATNAME = "pssysdictcatname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSRESOURCEID = "pssysresourceid";
    public static final String FIELD_PSSYSRESOURCENAME = "pssysresourcename";
    public static final String FIELD_RAWCONTENT = "rawcontent";
    public static final String FIELD_RAWCSSSTYLE = "rawcssstyle";
    public static final String FIELD_RAWSERVICEMETHOD = "rawservicemethod";
    public static final String FIELD_RAWSERVICEURL = "rawserviceurl";
    public static final String FIELD_REFPSDEACMODEID = "refpsdeacmodeid";
    public static final String FIELD_REFPSDEACMODENAME = "refpsdeacmodename";
    public static final String FIELD_REFPSDEDATASETID = "refpsdedatasetid";
    public static final String FIELD_REFPSDEDATASETNAME = "refpsdedatasetname";
    public static final String FIELD_REFPSDEFORMDETAILID = "refpsdeformdetailid";
    public static final String FIELD_REFPSDEFORMDETAILNAME = "refpsdeformdetailname";
    public static final String FIELD_REFPSDEFORMID = "refpsdeformid";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REFPSDERID = "refpsderid";
    public static final String FIELD_REFPSDERNAME = "refpsdername";
    public static final String FIELD_RENDERMODE = "rendermode";
    public static final String FIELD_RENDERMODETEXT = "rendermodetext";
    public static final String FIELD_RESETITEMNAME = "resetitemname";
    public static final String FIELD_ROWSPAN = "rowspan";
    public static final String FIELD_SHOWCAPTION = "showcaption";
    public static final String FIELD_SHOWMOREMODE = "showmoremode";
    public static final String FIELD_SPACINGBOTTOM = "spacingbottom";
    public static final String FIELD_SPACINGLEFT = "spacingleft";
    public static final String FIELD_SPACINGRIGHT = "spacingright";
    public static final String FIELD_SPACINGTOP = "spacingtop";
    public static final String FIELD_SWAPMODE = "swapmode";
    public static final String FIELD_TITLEBARCLOSEMODE = "titlebarclosemode";
    public static final String FIELD_TOGGLEMODE = "togglemode";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    public static final String FIELD_UCPSSYSPFPLUGINID = "ucpssyspfpluginid";
    public static final String FIELD_UCPSSYSPFPLUGINNAME = "ucpssyspfpluginname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEDV = "updatedv";
    public static final String FIELD_UPDATEDVT = "updatedvt";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALIGN = "valign";
    public static final String FIELD_VALIGNSELF = "valignself";
    public static final String FIELD_VALUEFORMAT = "valueformat";
    public static final String FIELD_VALUEITEMNAME = "valueitemname";
    public static final String FIELD_WBDEFMODE = "wbdefmode";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_WIDTHMODE = "widthmode";
    private List<PSDEFormDetail> psdeformdetails;
    private List<PSDEFDLogic> psdefdlogics;

    @JsonIgnore
    public Integer getAllowEmpty() {
        Object objValue = this.get(FIELD_ALLOWEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="allowempty")
    public void setAllowEmpty(Integer allowEmpty) {
        this.set(FIELD_ALLOWEMPTY, allowEmpty);
    }

    @JsonIgnore
    public boolean isAllowEmptyDirty() {
        return this.contains(FIELD_ALLOWEMPTY);
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
    public Integer getBuildInAction() {
        Object objValue = this.get(FIELD_BUILDINACTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="buildinaction")
    public void setBuildInAction(Integer buildInAction) {
        this.set(FIELD_BUILDINACTION, buildInAction);
    }

    @JsonIgnore
    public boolean isBuildInActionDirty() {
        return this.contains(FIELD_BUILDINACTION);
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
    public Integer getCodeListConfigMode() {
        Object objValue = this.get(FIELD_CODELISTCONFIGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="codelistconfigmode")
    public void setCodeListConfigMode(Integer codeListConfigMode) {
        this.set(FIELD_CODELISTCONFIGMODE, codeListConfigMode);
    }

    @JsonIgnore
    public boolean isCodeListConfigModeDirty() {
        return this.contains(FIELD_CODELISTCONFIGMODE);
    }

    @JsonIgnore
    public String getColAlign() {
        Object objValue = this.get(FIELD_COLALIGN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="colalign")
    public void setColAlign(String colAlign) {
        this.set(FIELD_COLALIGN, colAlign);
    }

    @JsonIgnore
    public boolean isColAlignDirty() {
        return this.contains(FIELD_COLALIGN);
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
    public Integer getConvertCIText() {
        Object objValue = this.get(FIELD_CONVERTCITEXT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="convertcitext")
    public void setConvertCIText(Integer convertCIText) {
        this.set(FIELD_CONVERTCITEXT, convertCIText);
    }

    @JsonIgnore
    public boolean isConvertCITextDirty() {
        return this.contains(FIELD_CONVERTCITEXT);
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
    public String getCreateDV() {
        Object objValue = this.get(FIELD_CREATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdv")
    public void setCreateDV(String createDV) {
        this.set(FIELD_CREATEDV, createDV);
    }

    @JsonIgnore
    public boolean isCreateDVDirty() {
        return this.contains(FIELD_CREATEDV);
    }

    @JsonIgnore
    public String getCreateDVT() {
        Object objValue = this.get(FIELD_CREATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createdvt")
    public void setCreateDVT(String createDVT) {
        this.set(FIELD_CREATEDVT, createDVT);
    }

    @JsonIgnore
    public boolean isCreateDVTDirty() {
        return this.contains(FIELD_CREATEDVT);
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
    public Integer getCtrlColSpan() {
        Object objValue = this.get(FIELD_CTRLCOLSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlcolspan")
    public void setCtrlColSpan(Integer ctrlColSpan) {
        this.set(FIELD_CTRLCOLSPAN, ctrlColSpan);
    }

    @JsonIgnore
    public boolean isCtrlColSpanDirty() {
        return this.contains(FIELD_CTRLCOLSPAN);
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
    public String getData() {
        Object objValue = this.get(FIELD_DATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data")
    public void setData(String data) {
        this.set(FIELD_DATA, data);
    }

    @JsonIgnore
    public boolean isDataDirty() {
        return this.contains(FIELD_DATA);
    }

    @JsonIgnore
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
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
    public String getDetailTag() {
        Object objValue = this.get(FIELD_DETAILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag")
    public void setDetailTag(String detailTag) {
        this.set(FIELD_DETAILTAG, detailTag);
    }

    @JsonIgnore
    public boolean isDetailTagDirty() {
        return this.contains(FIELD_DETAILTAG);
    }

    @JsonIgnore
    public String getDetailTag2() {
        Object objValue = this.get(FIELD_DETAILTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtag2")
    public void setDetailTag2(String detailTag2) {
        this.set(FIELD_DETAILTAG2, detailTag2);
    }

    @JsonIgnore
    public boolean isDetailTag2Dirty() {
        return this.contains(FIELD_DETAILTAG2);
    }

    @JsonIgnore
    public String getDetailType() {
        Object objValue = this.get(FIELD_DETAILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailtype")
    public void setDetailType(String detailType) {
        this.set(FIELD_DETAILTYPE, detailType);
    }

    @JsonIgnore
    public boolean isDetailTypeDirty() {
        return this.contains(FIELD_DETAILTYPE);
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
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getEditorParams() {
        Object objValue = this.get(FIELD_EDITORPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editorparams")
    public void setEditorParams(String editorParams) {
        this.set(FIELD_EDITORPARAMS, editorParams);
    }

    @JsonIgnore
    public boolean isEditorParamsDirty() {
        return this.contains(FIELD_EDITORPARAMS);
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
    public Integer getEnableCond() {
        Object objValue = this.get(FIELD_ENABLECOND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecond")
    public void setEnableCond(Integer enableCond) {
        this.set(FIELD_ENABLECOND, enableCond);
    }

    @JsonIgnore
    public boolean isEnableCondDirty() {
        return this.contains(FIELD_ENABLECOND);
    }

    @JsonIgnore
    public Integer getEnableItemPriv() {
        Object objValue = this.get(FIELD_ENABLEITEMPRIV);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableitempriv")
    public void setEnableItemPriv(Integer enableItemPriv) {
        this.set(FIELD_ENABLEITEMPRIV, enableItemPriv);
    }

    @JsonIgnore
    public boolean isEnableItemPrivDirty() {
        return this.contains(FIELD_ENABLEITEMPRIV);
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
    public String getFormType() {
        Object objValue = this.get(FIELD_FORMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtype")
    public void setFormType(String formType) {
        this.set(FIELD_FORMTYPE, formType);
    }

    @JsonIgnore
    public boolean isFormTypeDirty() {
        return this.contains(FIELD_FORMTYPE);
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
    public String getItemPSACHandlerId() {
        Object objValue = this.get(FIELD_ITEMPSACHANDLERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempsachandlerid")
    public void setItemPSACHandlerId(String itemPSACHandlerId) {
        this.set(FIELD_ITEMPSACHANDLERID, itemPSACHandlerId);
    }

    @JsonIgnore
    public boolean isItemPSACHandlerIdDirty() {
        return this.contains(FIELD_ITEMPSACHANDLERID);
    }

    @JsonIgnore
    public String getItemPSACHandlerName() {
        Object objValue = this.get(FIELD_ITEMPSACHANDLERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempsachandlername")
    public void setItemPSACHandlerName(String itemPSACHandlerName) {
        this.set(FIELD_ITEMPSACHANDLERNAME, itemPSACHandlerName);
    }

    @JsonIgnore
    public boolean isItemPSACHandlerNameDirty() {
        return this.contains(FIELD_ITEMPSACHANDLERNAME);
    }

    @JsonIgnore
    public Integer getItemStates() {
        Object objValue = this.get(FIELD_ITEMSTATES);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="itemstates")
    public void setItemStates(Integer itemStates) {
        this.set(FIELD_ITEMSTATES, itemStates);
    }

    @JsonIgnore
    public boolean isItemStatesDirty() {
        return this.contains(FIELD_ITEMSTATES);
    }

    @JsonIgnore
    public Integer getLabelColSpan() {
        Object objValue = this.get(FIELD_LABELCOLSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelcolspan")
    public void setLabelColSpan(Integer labelColSpan) {
        this.set(FIELD_LABELCOLSPAN, labelColSpan);
    }

    @JsonIgnore
    public boolean isLabelColSpanDirty() {
        return this.contains(FIELD_LABELCOLSPAN);
    }

    @JsonIgnore
    public Integer getLabelColSpan2() {
        Object objValue = this.get(FIELD_LABELCOLSPAN2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelcolspan2")
    public void setLabelColSpan2(Integer labelColSpan2) {
        this.set(FIELD_LABELCOLSPAN2, labelColSpan2);
    }

    @JsonIgnore
    public boolean isLabelColSpan2Dirty() {
        return this.contains(FIELD_LABELCOLSPAN2);
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
    public String getLabelPos() {
        Object objValue = this.get(FIELD_LABELPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="labelpos")
    public void setLabelPos(String labelPos) {
        this.set(FIELD_LABELPOS, labelPos);
    }

    @JsonIgnore
    public boolean isLabelPosDirty() {
        return this.contains(FIELD_LABELPOS);
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
    public Integer getLabelWidth() {
        Object objValue = this.get(FIELD_LABELWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelwidth")
    public void setLabelWidth(Integer labelWidth) {
        this.set(FIELD_LABELWIDTH, labelWidth);
    }

    @JsonIgnore
    public boolean isLabelWidthDirty() {
        return this.contains(FIELD_LABELWIDTH);
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
    public String getLevelTag() {
        Object objValue = this.get(FIELD_LEVELTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="leveltag")
    public void setLevelTag(String levelTag) {
        this.set(FIELD_LEVELTAG, levelTag);
    }

    @JsonIgnore
    public boolean isLevelTagDirty() {
        return this.contains(FIELD_LEVELTAG);
    }

    @JsonIgnore
    public String getLinkPSDEViewId() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewid")
    public void setLinkPSDEViewId(String linkPSDEViewId) {
        this.set(FIELD_LINKPSDEVIEWID, linkPSDEViewId);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewIdDirty() {
        return this.contains(FIELD_LINKPSDEVIEWID);
    }

    @JsonIgnore
    public String getLinkPSDEViewName() {
        Object objValue = this.get(FIELD_LINKPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkpsdeviewname")
    public void setLinkPSDEViewName(String linkPSDEViewName) {
        this.set(FIELD_LINKPSDEVIEWNAME, linkPSDEViewName);
    }

    @JsonIgnore
    public boolean isLinkPSDEViewNameDirty() {
        return this.contains(FIELD_LINKPSDEVIEWNAME);
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
    public String getMargin() {
        Object objValue = this.get(FIELD_MARGIN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="margin")
    public void setMargin(String margin) {
        this.set(FIELD_MARGIN, margin);
    }

    @JsonIgnore
    public boolean isMarginDirty() {
        return this.contains(FIELD_MARGIN);
    }

    @JsonIgnore
    public String getMDCtrlType() {
        Object objValue = this.get(FIELD_MDCTRLTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdctrltype")
    public void setMDCtrlType(String mDCtrlType) {
        this.set(FIELD_MDCTRLTYPE, mDCtrlType);
    }

    @JsonIgnore
    public boolean isMDCtrlTypeDirty() {
        return this.contains(FIELD_MDCTRLTYPE);
    }

    @JsonIgnore
    public String getMDPSDEDataViewId() {
        Object objValue = this.get(FIELD_MDPSDEDATAVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdedataviewid")
    public void setMDPSDEDataViewId(String mDPSDEDataViewId) {
        this.set(FIELD_MDPSDEDATAVIEWID, mDPSDEDataViewId);
    }

    @JsonIgnore
    public boolean isMDPSDEDataViewIdDirty() {
        return this.contains(FIELD_MDPSDEDATAVIEWID);
    }

    @JsonIgnore
    public String getMDPSDEDataViewName() {
        Object objValue = this.get(FIELD_MDPSDEDATAVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdedataviewname")
    public void setMDPSDEDataViewName(String mDPSDEDataViewName) {
        this.set(FIELD_MDPSDEDATAVIEWNAME, mDPSDEDataViewName);
    }

    @JsonIgnore
    public boolean isMDPSDEDataViewNameDirty() {
        return this.contains(FIELD_MDPSDEDATAVIEWNAME);
    }

    @JsonIgnore
    public String getMDPSDEFormId() {
        Object objValue = this.get(FIELD_MDPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeformid")
    public void setMDPSDEFormId(String mDPSDEFormId) {
        this.set(FIELD_MDPSDEFORMID, mDPSDEFormId);
    }

    @JsonIgnore
    public boolean isMDPSDEFormIdDirty() {
        return this.contains(FIELD_MDPSDEFORMID);
    }

    @JsonIgnore
    public String getMDPSDEFormName() {
        Object objValue = this.get(FIELD_MDPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdeformname")
    public void setMDPSDEFormName(String mDPSDEFormName) {
        this.set(FIELD_MDPSDEFORMNAME, mDPSDEFormName);
    }

    @JsonIgnore
    public boolean isMDPSDEFormNameDirty() {
        return this.contains(FIELD_MDPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMDPSDEGridId() {
        Object objValue = this.get(FIELD_MDPSDEGRIDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdegridid")
    public void setMDPSDEGridId(String mDPSDEGridId) {
        this.set(FIELD_MDPSDEGRIDID, mDPSDEGridId);
    }

    @JsonIgnore
    public boolean isMDPSDEGridIdDirty() {
        return this.contains(FIELD_MDPSDEGRIDID);
    }

    @JsonIgnore
    public String getMDPSDEGridName() {
        Object objValue = this.get(FIELD_MDPSDEGRIDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdegridname")
    public void setMDPSDEGridName(String mDPSDEGridName) {
        this.set(FIELD_MDPSDEGRIDNAME, mDPSDEGridName);
    }

    @JsonIgnore
    public boolean isMDPSDEGridNameDirty() {
        return this.contains(FIELD_MDPSDEGRIDNAME);
    }

    @JsonIgnore
    public String getMDPSDEListId() {
        Object objValue = this.get(FIELD_MDPSDELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdelistid")
    public void setMDPSDEListId(String mDPSDEListId) {
        this.set(FIELD_MDPSDELISTID, mDPSDEListId);
    }

    @JsonIgnore
    public boolean isMDPSDEListIdDirty() {
        return this.contains(FIELD_MDPSDELISTID);
    }

    @JsonIgnore
    public String getMDPSDEListName() {
        Object objValue = this.get(FIELD_MDPSDELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mdpsdelistname")
    public void setMDPSDEListName(String mDPSDEListName) {
        this.set(FIELD_MDPSDELISTNAME, mDPSDEListName);
    }

    @JsonIgnore
    public boolean isMDPSDEListNameDirty() {
        return this.contains(FIELD_MDPSDELISTNAME);
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
    public Integer getModelState() {
        Object objValue = this.get(FIELD_MODELSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelstate")
    public void setModelState(Integer modelState) {
        this.set(FIELD_MODELSTATE, modelState);
    }

    @JsonIgnore
    public boolean isModelStateDirty() {
        return this.contains(FIELD_MODELSTATE);
    }

    @JsonIgnore
    public Integer getNeedCodeListConfig() {
        Object objValue = this.get(FIELD_NEEDCODELISTCONFIG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="needcodelistconfig")
    public void setNeedCodeListConfig(Integer needCodeListConfig) {
        this.set(FIELD_NEEDCODELISTCONFIG, needCodeListConfig);
    }

    @JsonIgnore
    public boolean isNeedCodeListConfigDirty() {
        return this.contains(FIELD_NEEDCODELISTCONFIG);
    }

    @JsonIgnore
    public Integer getNoPrivDM() {
        Object objValue = this.get(FIELD_NOPRIVDM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noprivdm")
    public void setNoPrivDM(Integer noPrivDM) {
        this.set(FIELD_NOPRIVDM, noPrivDM);
    }

    @JsonIgnore
    public boolean isNoPrivDMDirty() {
        return this.contains(FIELD_NOPRIVDM);
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
    public String getPadding() {
        Object objValue = this.get(FIELD_PADDING);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="padding")
    public void setPadding(String padding) {
        this.set(FIELD_PADDING, padding);
    }

    @JsonIgnore
    public boolean isPaddingDirty() {
        return this.contains(FIELD_PADDING);
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
    public String getPickupPSDEViewId() {
        Object objValue = this.get(FIELD_PICKUPPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pickuppsdeviewid")
    public void setPickupPSDEViewId(String pickupPSDEViewId) {
        this.set(FIELD_PICKUPPSDEVIEWID, pickupPSDEViewId);
    }

    @JsonIgnore
    public boolean isPickupPSDEViewIdDirty() {
        return this.contains(FIELD_PICKUPPSDEVIEWID);
    }

    @JsonIgnore
    public String getPickupPSDEViewName() {
        Object objValue = this.get(FIELD_PICKUPPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pickuppsdeviewname")
    public void setPickupPSDEViewName(String pickupPSDEViewName) {
        this.set(FIELD_PICKUPPSDEVIEWNAME, pickupPSDEViewName);
    }

    @JsonIgnore
    public boolean isPickupPSDEViewNameDirty() {
        return this.contains(FIELD_PICKUPPSDEVIEWNAME);
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
    public String getPPSDEFormDetailId() {
        Object objValue = this.get(FIELD_PPSDEFORMDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdeformdetailid")
    public void setPPSDEFormDetailId(String pPSDEFormDetailId) {
        this.set(FIELD_PPSDEFORMDETAILID, pPSDEFormDetailId);
    }

    @JsonIgnore
    public boolean isPPSDEFormDetailIdDirty() {
        return this.contains(FIELD_PPSDEFORMDETAILID);
    }

    @JsonIgnore
    public String getPPSDEFormDetailName() {
        Object objValue = this.get(FIELD_PPSDEFORMDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdeformdetailname")
    public void setPPSDEFormDetailName(String pPSDEFormDetailName) {
        this.set(FIELD_PPSDEFORMDETAILNAME, pPSDEFormDetailName);
    }

    @JsonIgnore
    public boolean isPPSDEFormDetailNameDirty() {
        return this.contains(FIELD_PPSDEFORMDETAILNAME);
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
    public Integer getPreventXSS() {
        Object objValue = this.get(FIELD_PREVENTXSS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preventxss")
    public void setPreventXSS(Integer preventXSS) {
        this.set(FIELD_PREVENTXSS, preventXSS);
    }

    @JsonIgnore
    public boolean isPreventXSSDirty() {
        return this.contains(FIELD_PREVENTXSS);
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
    public String getPSDEFUIModeId() {
        Object objValue = this.get(FIELD_PSDEFUIMODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefformitemid")
    public void setPSDEFUIModeId(String pSDEFUIModeId) {
        this.set(FIELD_PSDEFUIMODEID, pSDEFUIModeId);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeIdDirty() {
        return this.contains(FIELD_PSDEFUIMODEID);
    }

    @JsonIgnore
    public String getPSDEFUIModeName() {
        Object objValue = this.get(FIELD_PSDEFUIMODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefformitemname")
    public void setPSDEFUIModeName(String pSDEFUIModeName) {
        this.set(FIELD_PSDEFUIMODENAME, pSDEFUIModeName);
    }

    @JsonIgnore
    public boolean isPSDEFUIModeNameDirty() {
        return this.contains(FIELD_PSDEFUIMODENAME);
    }

    @JsonIgnore
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFIUpdateId() {
        Object objValue = this.get(FIELD_PSDEFIUPDATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiupdateid")
    public void setPSDEFIUpdateId(String pSDEFIUpdateId) {
        this.set(FIELD_PSDEFIUPDATEID, pSDEFIUpdateId);
    }

    @JsonIgnore
    public boolean isPSDEFIUpdateIdDirty() {
        return this.contains(FIELD_PSDEFIUPDATEID);
    }

    @JsonIgnore
    public String getPSDEFIUpdateName() {
        Object objValue = this.get(FIELD_PSDEFIUPDATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefiupdatename")
    public void setPSDEFIUpdateName(String pSDEFIUpdateName) {
        this.set(FIELD_PSDEFIUPDATENAME, pSDEFIUpdateName);
    }

    @JsonIgnore
    public boolean isPSDEFIUpdateNameDirty() {
        return this.contains(FIELD_PSDEFIUPDATENAME);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
    }

    @JsonIgnore
    public String getPSDEFormDetailId() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailid")
    public void setPSDEFormDetailId(String pSDEFormDetailId) {
        this.set(FIELD_PSDEFORMDETAILID, pSDEFormDetailId);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailIdDirty() {
        return this.contains(FIELD_PSDEFORMDETAILID);
    }

    @JsonIgnore
    public String getPSDEFormDetailName() {
        Object objValue = this.get(FIELD_PSDEFORMDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformdetailname")
    public void setPSDEFormDetailName(String pSDEFormDetailName) {
        this.set(FIELD_PSDEFORMDETAILNAME, pSDEFormDetailName);
    }

    @JsonIgnore
    public boolean isPSDEFormDetailNameDirty() {
        return this.contains(FIELD_PSDEFORMDETAILNAME);
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
    public String getPSDEFormRFId() {
        Object objValue = this.get(FIELD_PSDEFORMRFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformrfid")
    public void setPSDEFormRFId(String pSDEFormRFId) {
        this.set(FIELD_PSDEFORMRFID, pSDEFormRFId);
    }

    @JsonIgnore
    public boolean isPSDEFormRFIdDirty() {
        return this.contains(FIELD_PSDEFORMRFID);
    }

    @JsonIgnore
    public String getPSDEFormRFName() {
        Object objValue = this.get(FIELD_PSDEFORMRFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformrfname")
    public void setPSDEFormRFName(String pSDEFormRFName) {
        this.set(FIELD_PSDEFORMRFNAME, pSDEFormRFName);
    }

    @JsonIgnore
    public boolean isPSDEFormRFNameDirty() {
        return this.contains(FIELD_PSDEFORMRFNAME);
    }

    @JsonIgnore
    public String getPSDEFSFItemId() {
        Object objValue = this.get(FIELD_PSDEFSFITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemid")
    public void setPSDEFSFItemId(String pSDEFSFItemId) {
        this.set(FIELD_PSDEFSFITEMID, pSDEFSFItemId);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemIdDirty() {
        return this.contains(FIELD_PSDEFSFITEMID);
    }

    @JsonIgnore
    public String getPSDEFSFItemName() {
        Object objValue = this.get(FIELD_PSDEFSFITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefsfitemname")
    public void setPSDEFSFItemName(String pSDEFSFItemName) {
        this.set(FIELD_PSDEFSFITEMNAME, pSDEFSFItemName);
    }

    @JsonIgnore
    public boolean isPSDEFSFItemNameDirty() {
        return this.contains(FIELD_PSDEFSFITEMNAME);
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
    public String getPSSysCounterId() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscounterid")
    public void setPSSysCounterId(String pSSysCounterId) {
        this.set(FIELD_PSSYSCOUNTERID, pSSysCounterId);
    }

    @JsonIgnore
    public boolean isPSSysCounterIdDirty() {
        return this.contains(FIELD_PSSYSCOUNTERID);
    }

    @JsonIgnore
    public String getPSSysCounterName() {
        Object objValue = this.get(FIELD_PSSYSCOUNTERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscountername")
    public void setPSSysCounterName(String pSSysCounterName) {
        this.set(FIELD_PSSYSCOUNTERNAME, pSSysCounterName);
    }

    @JsonIgnore
    public boolean isPSSysCounterNameDirty() {
        return this.contains(FIELD_PSSYSCOUNTERNAME);
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
    public String getPSSysDictCatId() {
        Object objValue = this.get(FIELD_PSSYSDICTCATID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatid")
    public void setPSSysDictCatId(String pSSysDictCatId) {
        this.set(FIELD_PSSYSDICTCATID, pSSysDictCatId);
    }

    @JsonIgnore
    public boolean isPSSysDictCatIdDirty() {
        return this.contains(FIELD_PSSYSDICTCATID);
    }

    @JsonIgnore
    public String getPSSysDictCatName() {
        Object objValue = this.get(FIELD_PSSYSDICTCATNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdictcatname")
    public void setPSSysDictCatName(String pSSysDictCatName) {
        this.set(FIELD_PSSYSDICTCATNAME, pSSysDictCatName);
    }

    @JsonIgnore
    public boolean isPSSysDictCatNameDirty() {
        return this.contains(FIELD_PSSYSDICTCATNAME);
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
    public String getRefPSDEFormDetailId() {
        Object objValue = this.get(FIELD_REFPSDEFORMDETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeformdetailid")
    public void setRefPSDEFormDetailId(String refPSDEFormDetailId) {
        this.set(FIELD_REFPSDEFORMDETAILID, refPSDEFormDetailId);
    }

    @JsonIgnore
    public boolean isRefPSDEFormDetailIdDirty() {
        return this.contains(FIELD_REFPSDEFORMDETAILID);
    }

    @JsonIgnore
    public String getRefPSDEFormDetailName() {
        Object objValue = this.get(FIELD_REFPSDEFORMDETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeformdetailname")
    public void setRefPSDEFormDetailName(String refPSDEFormDetailName) {
        this.set(FIELD_REFPSDEFORMDETAILNAME, refPSDEFormDetailName);
    }

    @JsonIgnore
    public boolean isRefPSDEFormDetailNameDirty() {
        return this.contains(FIELD_REFPSDEFORMDETAILNAME);
    }

    @JsonIgnore
    public String getRefPSDEFormId() {
        Object objValue = this.get(FIELD_REFPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeformid")
    public void setRefPSDEFormId(String refPSDEFormId) {
        this.set(FIELD_REFPSDEFORMID, refPSDEFormId);
    }

    @JsonIgnore
    public boolean isRefPSDEFormIdDirty() {
        return this.contains(FIELD_REFPSDEFORMID);
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
    public String getRefPSDERId() {
        Object objValue = this.get(FIELD_REFPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsderid")
    public void setRefPSDERId(String refPSDERId) {
        this.set(FIELD_REFPSDERID, refPSDERId);
    }

    @JsonIgnore
    public boolean isRefPSDERIdDirty() {
        return this.contains(FIELD_REFPSDERID);
    }

    @JsonIgnore
    public String getRefPSDERName() {
        Object objValue = this.get(FIELD_REFPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdername")
    public void setRefPSDERName(String refPSDERName) {
        this.set(FIELD_REFPSDERNAME, refPSDERName);
    }

    @JsonIgnore
    public boolean isRefPSDERNameDirty() {
        return this.contains(FIELD_REFPSDERNAME);
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
    public String getResetItemName() {
        Object objValue = this.get(FIELD_RESETITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="resetitemname")
    public void setResetItemName(String resetItemName) {
        this.set(FIELD_RESETITEMNAME, resetItemName);
    }

    @JsonIgnore
    public boolean isResetItemNameDirty() {
        return this.contains(FIELD_RESETITEMNAME);
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
    public Integer getShowMoreMode() {
        Object objValue = this.get(FIELD_SHOWMOREMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showmoremode")
    public void setShowMoreMode(Integer showMoreMode) {
        this.set(FIELD_SHOWMOREMODE, showMoreMode);
    }

    @JsonIgnore
    public boolean isShowMoreModeDirty() {
        return this.contains(FIELD_SHOWMOREMODE);
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
    public String getUCPSSysPFPluginId() {
        Object objValue = this.get(FIELD_UCPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ucpssyspfpluginid")
    public void setUCPSSysPFPluginId(String uCPSSysPFPluginId) {
        this.set(FIELD_UCPSSYSPFPLUGINID, uCPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isUCPSSysPFPluginIdDirty() {
        return this.contains(FIELD_UCPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getUCPSSysPFPluginName() {
        Object objValue = this.get(FIELD_UCPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ucpssyspfpluginname")
    public void setUCPSSysPFPluginName(String uCPSSysPFPluginName) {
        this.set(FIELD_UCPSSYSPFPLUGINNAME, uCPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isUCPSSysPFPluginNameDirty() {
        return this.contains(FIELD_UCPSSYSPFPLUGINNAME);
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
    public String getUpdateDV() {
        Object objValue = this.get(FIELD_UPDATEDV);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedv")
    public void setUpdateDV(String updateDV) {
        this.set(FIELD_UPDATEDV, updateDV);
    }

    @JsonIgnore
    public boolean isUpdateDVDirty() {
        return this.contains(FIELD_UPDATEDV);
    }

    @JsonIgnore
    public String getUpdateDVT() {
        Object objValue = this.get(FIELD_UPDATEDVT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatedvt")
    public void setUpdateDVT(String updateDVT) {
        this.set(FIELD_UPDATEDVT, updateDVT);
    }

    @JsonIgnore
    public boolean isUpdateDVTDirty() {
        return this.contains(FIELD_UPDATEDVT);
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
    public String getValueItemName() {
        Object objValue = this.get(FIELD_VALUEITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="valueitemname")
    public void setValueItemName(String valueItemName) {
        this.set(FIELD_VALUEITEMNAME, valueItemName);
    }

    @JsonIgnore
    public boolean isValueItemNameDirty() {
        return this.contains(FIELD_VALUEITEMNAME);
    }

    @JsonIgnore
    public Integer getWBDEFMode() {
        Object objValue = this.get(FIELD_WBDEFMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wbdefmode")
    public void setWBDEFMode(Integer wBDEFMode) {
        this.set(FIELD_WBDEFMODE, wBDEFMode);
    }

    @JsonIgnore
    public boolean isWBDEFModeDirty() {
        return this.contains(FIELD_WBDEFMODE);
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
        return this.getPSDEFormDetailId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFormDetailId(strValue);
    }

    public List<PSDEFormDetail> getPsdeformdetails() {
        return this.psdeformdetails;
    }

    public void setPsdeformdetails(List<PSDEFormDetail> psdeformdetails) {
        this.psdeformdetails = psdeformdetails;
    }

    public List<PSDEFDLogic> getPsdefdlogics() {
        return this.psdefdlogics;
    }

    public void setPsdefdlogics(List<PSDEFDLogic> psdefdlogics) {
        this.psdefdlogics = psdefdlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdeformdetails")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdefdlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdeformdetails")) {
            this.init();
            return this.psdeformdetails;
        }
        if (strName.equalsIgnoreCase("psdefdlogics")) {
            this.init();
            return this.psdefdlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEFORMDETAIL";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFormDetail item = (PSDEFormDetail)MAPPER.readValue(new File(strJsonFilePath), PSDEFormDetail.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFormDetail) {
            PSDEFormDetail dst = (PSDEFormDetail)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdeformdetails() != null) {
                    ArrayList<PSDEFormDetail> psdeformdetails = new ArrayList<PSDEFormDetail>();
                    for (PSDEFormDetail pSDEFormDetail : this.getPsdeformdetails()) {
                        if (bDeepMode) {
                            newitem = new PSDEFormDetail();
                            pSDEFormDetail.to(newitem, false, bDeepMode);
                            psdeformdetails.add((PSDEFormDetail)newitem);
                            continue;
                        }
                        psdeformdetails.add(pSDEFormDetail);
                    }
                    dst.setPsdeformdetails(psdeformdetails);
                }
                if (this.getPsdefdlogics() != null) {
                    ArrayList<PSDEFDLogic> psdefdlogics = new ArrayList<PSDEFDLogic>();
                    for (PSDEFDLogic pSDEFDLogic : this.getPsdefdlogics()) {
                        if (bDeepMode) {
                            newitem = new PSDEFDLogic();
                            pSDEFDLogic.to(newitem, false, bDeepMode);
                            psdefdlogics.add((PSDEFDLogic)newitem);
                            continue;
                        }
                        psdefdlogics.add(pSDEFDLogic);
                    }
                    dst.setPsdefdlogics(psdefdlogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFormDetail) {
            PSDEFormDetail src = (PSDEFormDetail)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdeformdetails() != null) {
                    ArrayList<PSDEFormDetail> psdeformdetails = new ArrayList<PSDEFormDetail>();
                    for (PSDEFormDetail pSDEFormDetail : src.getPsdeformdetails()) {
                        if (bDeepMode) {
                            newItem = new PSDEFormDetail();
                            ((PSDEFormDetail)newItem).from(pSDEFormDetail, false, bDeepMode);
                            psdeformdetails.add((PSDEFormDetail)newItem);
                            continue;
                        }
                        psdeformdetails.add(pSDEFormDetail);
                    }
                    this.setPsdeformdetails(psdeformdetails);
                }
                if (src.getPsdefdlogics() != null) {
                    ArrayList<PSDEFDLogic> psdefdlogics = new ArrayList<PSDEFDLogic>();
                    for (PSDEFDLogic pSDEFDLogic : src.getPsdefdlogics()) {
                        if (bDeepMode) {
                            newItem = new PSDEFDLogic();
                            ((PSDEFDLogic)newItem).from(pSDEFDLogic, false, bDeepMode);
                            psdefdlogics.add((PSDEFDLogic)newItem);
                            continue;
                        }
                        psdefdlogics.add(pSDEFDLogic);
                    }
                    this.setPsdefdlogics(psdefdlogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

