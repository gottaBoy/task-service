/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.List;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSAppMenuItemDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONLEVEL = "actionlevel";
    public static final String FIELD_AMITEMTYPE = "amitemtype";
    public static final String FIELD_BL_POS = "bl_pos";
    public static final String FIELD_BORDERSTYLE = "borderstyle";
    public static final String FIELD_BTNACTIONTYPE = "btnactiontype";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_COL_LG = "col_lg";
    public static final String FIELD_COL_LG_OS = "col_lg_os";
    public static final String FIELD_COL_MD = "col_md";
    public static final String FIELD_COL_MD_OS = "col_md_os";
    public static final String FIELD_COL_SM = "col_sm";
    public static final String FIELD_COL_SM_OS = "col_sm_os";
    public static final String FIELD_COL_XS = "col_xs";
    public static final String FIELD_COL_XS_OS = "col_xs_os";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    public static final String FIELD_COUNTERID = "counterid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_DISABLECLOSE = "disableclose";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLEMODE = "enablemode";
    public static final String FIELD_EXPAND = "expand";
    public static final String FIELD_FILLEROBJ = "fillerobj";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXGROW = "flexgrow";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HIDDENITEM = "hiddenitem";
    public static final String FIELD_HIDESIDEBAR = "hidesidebar";
    public static final String FIELD_HTMLCONTENT = "htmlcontent";
    public static final String FIELD_HTMLPAGEURL = "htmlpageurl";
    public static final String FIELD_INFORMTAG = "informtag";
    public static final String FIELD_INFORMTAG2 = "informtag2";
    public static final String FIELD_ITEMSTYLE = "itemstyle";
    public static final String FIELD_ITEMSTYLETEXT = "itemstyletext";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MENUITEMSTATE = "menuitemstate";
    public static final String FIELD_OPENDEFAULT = "opendefault";
    public static final String FIELD_OPENPSAPPVIEWID = "openpsappviewid";
    public static final String FIELD_OPENPSAPPVIEWNAME = "openpsappviewname";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSAPPMENUITEMID = "ppsappmenuitemid";
    public static final String FIELD_PPSAPPMENUITEMNAME = "ppsappmenuitemname";
    public static final String FIELD_PREDEFINEDTYPE = "predefinedtype";
    public static final String FIELD_PREDEFINEDTYPETEXT = "predefinedtypetext";
    public static final String FIELD_PSAPPFUNCID = "psappfuncid";
    public static final String FIELD_PSAPPFUNCNAME = "psappfuncname";
    public static final String FIELD_PSAPPLOCALDEID = "psapplocaldeid";
    public static final String FIELD_PSAPPLOCALDENAME = "psapplocaldename";
    public static final String FIELD_PSAPPMENUID = "psappmenuid";
    public static final String FIELD_PSAPPMENUITEMID = "psappmenuitemid";
    public static final String FIELD_PSAPPMENUITEMNAME = "psappmenuitemname";
    public static final String FIELD_PSAPPMENUNAME = "psappmenuname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSRESOURCEID = "pssysresourceid";
    public static final String FIELD_PSSYSRESOURCENAME = "pssysresourcename";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_RAWCONTENT = "rawcontent";
    public static final String FIELD_RAWCSSSTYLE = "rawcssstyle";
    public static final String FIELD_REFPSAPPMENUID = "refpsappmenuid";
    public static final String FIELD_REFPSAPPMENUNAME = "refpsappmenuname";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TITLEBARCLOSEMODE = "titlebarclosemode";
    public static final String FIELD_TOGGLEMODE = "togglemode";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_WIDTH = "width";
    private List<PSAppMenuItemDTO> psappmenuitems;

    @JsonIgnore
    public Integer getActionLevel() {
        Object objValue = this.get(FIELD_ACTIONLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionlevel")
    public void setActionLevel(Integer actionLevel) {
        this.set(FIELD_ACTIONLEVEL, actionLevel);
    }

    @JsonIgnore
    public boolean isActionLevelDirty() {
        return this.contains(FIELD_ACTIONLEVEL);
    }

    @JsonIgnore
    public String getAMItemType() {
        Object objValue = this.get(FIELD_AMITEMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="amitemtype")
    public void setAMItemType(String aMItemType) {
        this.set(FIELD_AMITEMTYPE, aMItemType);
    }

    @JsonIgnore
    public boolean isAMItemTypeDirty() {
        return this.contains(FIELD_AMITEMTYPE);
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
    public String getCounterId() {
        Object objValue = this.get(FIELD_COUNTERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="counterid")
    public void setCounterId(String counterId) {
        this.set(FIELD_COUNTERID, counterId);
    }

    @JsonIgnore
    public boolean isCounterIdDirty() {
        return this.contains(FIELD_COUNTERID);
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
    public Integer getDisableClose() {
        Object objValue = this.get(FIELD_DISABLECLOSE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="disableclose")
    public void setDisableClose(Integer disableClose) {
        this.set(FIELD_DISABLECLOSE, disableClose);
    }

    @JsonIgnore
    public boolean isDisableCloseDirty() {
        return this.contains(FIELD_DISABLECLOSE);
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
    public Integer getEnableMode() {
        Object objValue = this.get(FIELD_ENABLEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemode")
    public void setEnableMode(Integer enableMode) {
        this.set(FIELD_ENABLEMODE, enableMode);
    }

    @JsonIgnore
    public boolean isEnableModeDirty() {
        return this.contains(FIELD_ENABLEMODE);
    }

    @JsonIgnore
    public Integer getExpand() {
        Object objValue = this.get(FIELD_EXPAND);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="expand")
    public void setExpand(Integer expand) {
        this.set(FIELD_EXPAND, expand);
    }

    @JsonIgnore
    public boolean isExpandDirty() {
        return this.contains(FIELD_EXPAND);
    }

    @JsonIgnore
    public String getFillerObj() {
        Object objValue = this.get(FIELD_FILLEROBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fillerobj")
    public void setFillerObj(String fillerObj) {
        this.set(FIELD_FILLEROBJ, fillerObj);
    }

    @JsonIgnore
    public boolean isFillerObjDirty() {
        return this.contains(FIELD_FILLEROBJ);
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
    public Integer getHiddenItem() {
        Object objValue = this.get(FIELD_HIDDENITEM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hiddenitem")
    public void setHiddenItem(Integer hiddenItem) {
        this.set(FIELD_HIDDENITEM, hiddenItem);
    }

    @JsonIgnore
    public boolean isHiddenItemDirty() {
        return this.contains(FIELD_HIDDENITEM);
    }

    @JsonIgnore
    public Integer getHIdeSideBar() {
        Object objValue = this.get(FIELD_HIDESIDEBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="hidesidebar")
    public void setHIdeSideBar(Integer hIdeSideBar) {
        this.set(FIELD_HIDESIDEBAR, hIdeSideBar);
    }

    @JsonIgnore
    public boolean isHIdeSideBarDirty() {
        return this.contains(FIELD_HIDESIDEBAR);
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
    public String getInformTag() {
        Object objValue = this.get(FIELD_INFORMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="informtag")
    public void setInformTag(String informTag) {
        this.set(FIELD_INFORMTAG, informTag);
    }

    @JsonIgnore
    public boolean isInformTagDirty() {
        return this.contains(FIELD_INFORMTAG);
    }

    @JsonIgnore
    public String getInformTag2() {
        Object objValue = this.get(FIELD_INFORMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="informtag2")
    public void setInformTag2(String informTag2) {
        this.set(FIELD_INFORMTAG2, informTag2);
    }

    @JsonIgnore
    public boolean isInformTag2Dirty() {
        return this.contains(FIELD_INFORMTAG2);
    }

    @JsonIgnore
    public String getItemStyle() {
        Object objValue = this.get(FIELD_ITEMSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemstyle")
    public void setItemStyle(String itemStyle) {
        this.set(FIELD_ITEMSTYLE, itemStyle);
    }

    @JsonIgnore
    public boolean isItemStyleDirty() {
        return this.contains(FIELD_ITEMSTYLE);
    }

    @JsonIgnore
    public String getItemStyleText() {
        Object objValue = this.get(FIELD_ITEMSTYLETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itemstyletext")
    public void setItemStyleText(String itemStyleText) {
        this.set(FIELD_ITEMSTYLETEXT, itemStyleText);
    }

    @JsonIgnore
    public boolean isItemStyleTextDirty() {
        return this.contains(FIELD_ITEMSTYLETEXT);
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
    public Integer getMenuItemState() {
        Object objValue = this.get(FIELD_MENUITEMSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="menuitemstate")
    public void setMenuItemState(Integer menuItemState) {
        this.set(FIELD_MENUITEMSTATE, menuItemState);
    }

    @JsonIgnore
    public boolean isMenuItemStateDirty() {
        return this.contains(FIELD_MENUITEMSTATE);
    }

    @JsonIgnore
    public Integer getOpenDefault() {
        Object objValue = this.get(FIELD_OPENDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="opendefault")
    public void setOpenDefault(Integer openDefault) {
        this.set(FIELD_OPENDEFAULT, openDefault);
    }

    @JsonIgnore
    public boolean isOpenDefaultDirty() {
        return this.contains(FIELD_OPENDEFAULT);
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
    public String getPPSAppMenuItemId() {
        Object objValue = this.get(FIELD_PPSAPPMENUITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsappmenuitemid")
    public void setPPSAppMenuItemId(String pPSAppMenuItemId) {
        this.set(FIELD_PPSAPPMENUITEMID, pPSAppMenuItemId);
    }

    @JsonIgnore
    public boolean isPPSAppMenuItemIdDirty() {
        return this.contains(FIELD_PPSAPPMENUITEMID);
    }

    @JsonIgnore
    public String getPPSAppMenuItemName() {
        Object objValue = this.get(FIELD_PPSAPPMENUITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsappmenuitemname")
    public void setPPSAppMenuItemName(String pPSAppMenuItemName) {
        this.set(FIELD_PPSAPPMENUITEMNAME, pPSAppMenuItemName);
    }

    @JsonIgnore
    public boolean isPPSAppMenuItemNameDirty() {
        return this.contains(FIELD_PPSAPPMENUITEMNAME);
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
    public String getPSAppFuncId() {
        Object objValue = this.get(FIELD_PSAPPFUNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncid")
    public void setPSAppFuncId(String pSAppFuncId) {
        this.set(FIELD_PSAPPFUNCID, pSAppFuncId);
    }

    @JsonIgnore
    public boolean isPSAppFuncIdDirty() {
        return this.contains(FIELD_PSAPPFUNCID);
    }

    @JsonIgnore
    public String getPSAppFuncName() {
        Object objValue = this.get(FIELD_PSAPPFUNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncname")
    public void setPSAppFuncName(String pSAppFuncName) {
        this.set(FIELD_PSAPPFUNCNAME, pSAppFuncName);
    }

    @JsonIgnore
    public boolean isPSAppFuncNameDirty() {
        return this.contains(FIELD_PSAPPFUNCNAME);
    }

    @JsonIgnore
    public String getPSAppLocalDEId() {
        Object objValue = this.get(FIELD_PSAPPLOCALDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldeid")
    public void setPSAppLocalDEId(String pSAppLocalDEId) {
        this.set(FIELD_PSAPPLOCALDEID, pSAppLocalDEId);
    }

    @JsonIgnore
    public boolean isPSAppLocalDEIdDirty() {
        return this.contains(FIELD_PSAPPLOCALDEID);
    }

    @JsonIgnore
    public String getPSAppLocalDEName() {
        Object objValue = this.get(FIELD_PSAPPLOCALDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldename")
    public void setPSAppLocalDEName(String pSAppLocalDEName) {
        this.set(FIELD_PSAPPLOCALDENAME, pSAppLocalDEName);
    }

    @JsonIgnore
    public boolean isPSAppLocalDENameDirty() {
        return this.contains(FIELD_PSAPPLOCALDENAME);
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
    public String getPSAppMenuItemId() {
        Object objValue = this.get(FIELD_PSAPPMENUITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuitemid")
    public void setPSAppMenuItemId(String pSAppMenuItemId) {
        this.set(FIELD_PSAPPMENUITEMID, pSAppMenuItemId);
    }

    @JsonIgnore
    public boolean isPSAppMenuItemIdDirty() {
        return this.contains(FIELD_PSAPPMENUITEMID);
    }

    @JsonIgnore
    public String getPSAppMenuItemName() {
        Object objValue = this.get(FIELD_PSAPPMENUITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmenuitemname")
    public void setPSAppMenuItemName(String pSAppMenuItemName) {
        this.set(FIELD_PSAPPMENUITEMNAME, pSAppMenuItemName);
    }

    @JsonIgnore
    public boolean isPSAppMenuItemNameDirty() {
        return this.contains(FIELD_PSAPPMENUITEMNAME);
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
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
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
    public String getPSSysUniResId() {
        Object objValue = this.get(FIELD_PSSYSUNIRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresid")
    public void setPSSysUniResId(String pSSysUniResId) {
        this.set(FIELD_PSSYSUNIRESID, pSSysUniResId);
    }

    @JsonIgnore
    public boolean isPSSysUniResIdDirty() {
        return this.contains(FIELD_PSSYSUNIRESID);
    }

    @JsonIgnore
    public String getPSSysUniResName() {
        Object objValue = this.get(FIELD_PSSYSUNIRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresname")
    public void setPSSysUniResName(String pSSysUniResName) {
        this.set(FIELD_PSSYSUNIRESNAME, pSSysUniResName);
    }

    @JsonIgnore
    public boolean isPSSysUniResNameDirty() {
        return this.contains(FIELD_PSSYSUNIRESNAME);
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
    public String getRefPSAppMenuId() {
        Object objValue = this.get(FIELD_REFPSAPPMENUID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsappmenuid")
    public void setRefPSAppMenuId(String refPSAppMenuId) {
        this.set(FIELD_REFPSAPPMENUID, refPSAppMenuId);
    }

    @JsonIgnore
    public boolean isRefPSAppMenuIdDirty() {
        return this.contains(FIELD_REFPSAPPMENUID);
    }

    @JsonIgnore
    public String getRefPSAppMenuName() {
        Object objValue = this.get(FIELD_REFPSAPPMENUNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsappmenuname")
    public void setRefPSAppMenuName(String refPSAppMenuName) {
        this.set(FIELD_REFPSAPPMENUNAME, refPSAppMenuName);
    }

    @JsonIgnore
    public boolean isRefPSAppMenuNameDirty() {
        return this.contains(FIELD_REFPSAPPMENUNAME);
    }

    @JsonIgnore
    public String getTipPSLanResId() {
        Object objValue = this.get(FIELD_TIPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresid")
    public void setTipPSLanResId(String tipPSLanResId) {
        this.set(FIELD_TIPPSLANRESID, tipPSLanResId);
    }

    @JsonIgnore
    public boolean isTipPSLanResIdDirty() {
        return this.contains(FIELD_TIPPSLANRESID);
    }

    @JsonIgnore
    public String getTipPSLanResName() {
        Object objValue = this.get(FIELD_TIPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresname")
    public void setTipPSLanResName(String tipPSLanResName) {
        this.set(FIELD_TIPPSLANRESNAME, tipPSLanResName);
    }

    @JsonIgnore
    public boolean isTipPSLanResNameDirty() {
        return this.contains(FIELD_TIPPSLANRESNAME);
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
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSAppMenuItemId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppMenuItemId(strValue);
    }

    @JsonProperty(value="psappmenuitems")
    public List<PSAppMenuItemDTO> getPsappmenuitems() {
        return this.psappmenuitems;
    }

    @JsonProperty(value="psappmenuitems")
    public void setPsappmenuitems(List<PSAppMenuItemDTO> psappmenuitems) {
        this.psappmenuitems = psappmenuitems;
    }
}

