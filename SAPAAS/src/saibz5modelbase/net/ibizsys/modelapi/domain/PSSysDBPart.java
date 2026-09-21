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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysDBPart
extends PSModelBase {
    public static final String FIELD_BL_POS = "bl_pos";
    public static final String FIELD_COLID = "colid";
    public static final String FIELD_COLSPAN = "colspan";
    public static final String FIELD_COL_LG = "col_lg";
    public static final String FIELD_COL_LG_OS = "col_lg_os";
    public static final String FIELD_COL_MD = "col_md";
    public static final String FIELD_COL_MD_OS = "col_md_os";
    public static final String FIELD_COL_SM = "col_sm";
    public static final String FIELD_COL_SM_OS = "col_sm_os";
    public static final String FIELD_COL_XS = "col_xs";
    public static final String FIELD_COL_XS_OS = "col_xs_os";
    public static final String FIELD_CONTENTTYPE = "contenttype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DBPARTTYPE = "dbparttype";
    public static final String FIELD_DYNACLASS = "dynaclass";
    public static final String FIELD_FLEXALIGN = "flexalign";
    public static final String FIELD_FLEXDIR = "flexdir";
    public static final String FIELD_FLEXGROW = "flexgrow";
    public static final String FIELD_FLEXVALIGN = "flexvalign";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_HTMLCONTENT = "htmlcontent";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NEWROWMODE = "newrowmode";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PARTPARAMS = "partparams";
    public static final String FIELD_PARTSTYLE = "partstyle";
    public static final String FIELD_PORTLETTYPE = "portlettype";
    public static final String FIELD_POSINFO = "posinfo";
    public static final String FIELD_PPSSYSDBPARTID = "ppssysdbpartid";
    public static final String FIELD_PPSSYSDBPARTNAME = "ppssysdbpartname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDASHBOARDID = "pssysdashboardid";
    public static final String FIELD_PSSYSDASHBOARDNAME = "pssysdashboardname";
    public static final String FIELD_PSSYSDBPARTID = "pssysdbpartid";
    public static final String FIELD_PSSYSDBPARTNAME = "pssysdbpartname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSPORTLETID = "pssysportletid";
    public static final String FIELD_PSSYSPORTLETNAME = "pssysportletname";
    public static final String FIELD_PSSYSRESOURCEID = "pssysresourceid";
    public static final String FIELD_PSSYSRESOURCENAME = "pssysresourcename";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_RAWCONTENT = "rawcontent";
    public static final String FIELD_RAWCSSSTYLE = "rawcssstyle";
    public static final String FIELD_SHOWTITLEBAR = "showtitlebar";
    public static final String FIELD_SWAPMODE = "swapmode";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_TITLEBARCLOSEMODE = "titlebarclosemode";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WIDTH = "width";
    private List<PSSysDBPart> pssysdbparts;

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
    public String getDBPartType() {
        Object objValue = this.get(FIELD_DBPARTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dbparttype")
    public void setDBPartType(String dBPartType) {
        this.set(FIELD_DBPARTTYPE, dBPartType);
    }

    @JsonIgnore
    public boolean isDBPartTypeDirty() {
        return this.contains(FIELD_DBPARTTYPE);
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
    public Integer getNewRowMode() {
        Object objValue = this.get(FIELD_NEWROWMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="newrowmode")
    public void setNewRowMode(Integer newRowMode) {
        this.set(FIELD_NEWROWMODE, newRowMode);
    }

    @JsonIgnore
    public boolean isNewRowModeDirty() {
        return this.contains(FIELD_NEWROWMODE);
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
    public String getPartParams() {
        Object objValue = this.get(FIELD_PARTPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="partparams")
    public void setPartParams(String partParams) {
        this.set(FIELD_PARTPARAMS, partParams);
    }

    @JsonIgnore
    public boolean isPartParamsDirty() {
        return this.contains(FIELD_PARTPARAMS);
    }

    @JsonIgnore
    public String getPartStyle() {
        Object objValue = this.get(FIELD_PARTSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="partstyle")
    public void setPartStyle(String partStyle) {
        this.set(FIELD_PARTSTYLE, partStyle);
    }

    @JsonIgnore
    public boolean isPartStyleDirty() {
        return this.contains(FIELD_PARTSTYLE);
    }

    @JsonIgnore
    public String getPortletType() {
        Object objValue = this.get(FIELD_PORTLETTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="portlettype")
    public void setPortletType(String portletType) {
        this.set(FIELD_PORTLETTYPE, portletType);
    }

    @JsonIgnore
    public boolean isPortletTypeDirty() {
        return this.contains(FIELD_PORTLETTYPE);
    }

    @JsonIgnore
    public String getPosInfo() {
        Object objValue = this.get(FIELD_POSINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="posinfo")
    public void setPosInfo(String posInfo) {
        this.set(FIELD_POSINFO, posInfo);
    }

    @JsonIgnore
    public boolean isPosInfoDirty() {
        return this.contains(FIELD_POSINFO);
    }

    @JsonIgnore
    public String getPPSSysDBPartId() {
        Object objValue = this.get(FIELD_PPSSYSDBPARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysdbpartid")
    public void setPPSSysDBPartId(String pPSSysDBPartId) {
        this.set(FIELD_PPSSYSDBPARTID, pPSSysDBPartId);
    }

    @JsonIgnore
    public boolean isPPSSysDBPartIdDirty() {
        return this.contains(FIELD_PPSSYSDBPARTID);
    }

    @JsonIgnore
    public String getPPSSysDBPartName() {
        Object objValue = this.get(FIELD_PPSSYSDBPARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppssysdbpartname")
    public void setPPSSysDBPartName(String pPSSysDBPartName) {
        this.set(FIELD_PPSSYSDBPARTNAME, pPSSysDBPartName);
    }

    @JsonIgnore
    public boolean isPPSSysDBPartNameDirty() {
        return this.contains(FIELD_PPSSYSDBPARTNAME);
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
    public String getPSSysDBPartId() {
        Object objValue = this.get(FIELD_PSSYSDBPARTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbpartid")
    public void setPSSysDBPartId(String pSSysDBPartId) {
        this.set(FIELD_PSSYSDBPARTID, pSSysDBPartId);
    }

    @JsonIgnore
    public boolean isPSSysDBPartIdDirty() {
        return this.contains(FIELD_PSSYSDBPARTID);
    }

    @JsonIgnore
    public String getPSSysDBPartName() {
        Object objValue = this.get(FIELD_PSSYSDBPARTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbpartname")
    public void setPSSysDBPartName(String pSSysDBPartName) {
        this.set(FIELD_PSSYSDBPARTNAME, pSSysDBPartName);
    }

    @JsonIgnore
    public boolean isPSSysDBPartNameDirty() {
        return this.contains(FIELD_PSSYSDBPARTNAME);
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
    public String getPSSysPortletId() {
        Object objValue = this.get(FIELD_PSSYSPORTLETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletid")
    public void setPSSysPortletId(String pSSysPortletId) {
        this.set(FIELD_PSSYSPORTLETID, pSSysPortletId);
    }

    @JsonIgnore
    public boolean isPSSysPortletIdDirty() {
        return this.contains(FIELD_PSSYSPORTLETID);
    }

    @JsonIgnore
    public String getPSSysPortletName() {
        Object objValue = this.get(FIELD_PSSYSPORTLETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysportletname")
    public void setPSSysPortletName(String pSSysPortletName) {
        this.set(FIELD_PSSYSPORTLETNAME, pSSysPortletName);
    }

    @JsonIgnore
    public boolean isPSSysPortletNameDirty() {
        return this.contains(FIELD_PSSYSPORTLETNAME);
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
    public Integer getShowTitleBar() {
        Object objValue = this.get(FIELD_SHOWTITLEBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showtitlebar")
    public void setShowTitleBar(Integer showTitleBar) {
        this.set(FIELD_SHOWTITLEBAR, showTitleBar);
    }

    @JsonIgnore
    public boolean isShowTitleBarDirty() {
        return this.contains(FIELD_SHOWTITLEBAR);
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
    public String getTitle() {
        Object objValue = this.get(FIELD_TITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="title")
    public void setTitle(String title) {
        this.set(FIELD_TITLE, title);
    }

    @JsonIgnore
    public boolean isTitleDirty() {
        return this.contains(FIELD_TITLE);
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
    public String getTitlePSLanResId() {
        Object objValue = this.get(FIELD_TITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresid")
    public void setTitlePSLanResId(String titlePSLanResId) {
        this.set(FIELD_TITLEPSLANRESID, titlePSLanResId);
    }

    @JsonIgnore
    public boolean isTitlePSLanResIdDirty() {
        return this.contains(FIELD_TITLEPSLANRESID);
    }

    @JsonIgnore
    public String getTitlePSLanResName() {
        Object objValue = this.get(FIELD_TITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresname")
    public void setTitlePSLanResName(String titlePSLanResName) {
        this.set(FIELD_TITLEPSLANRESNAME, titlePSLanResName);
    }

    @JsonIgnore
    public boolean isTitlePSLanResNameDirty() {
        return this.contains(FIELD_TITLEPSLANRESNAME);
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
    public Integer getValidFlag() {
        Object objValue = this.get(FIELD_VALIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="validflag")
    public void setValidFlag(Integer validFlag) {
        this.set(FIELD_VALIDFLAG, validFlag);
    }

    @JsonIgnore
    public boolean isValidFlagDirty() {
        return this.contains(FIELD_VALIDFLAG);
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
    public String getSrfkey() {
        return this.getPSSysDBPartId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysDBPartId(strValue);
    }

    public List<PSSysDBPart> getPssysdbparts() {
        return this.pssysdbparts;
    }

    public void setPssysdbparts(List<PSSysDBPart> pssysdbparts) {
        this.pssysdbparts = pssysdbparts;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysdbparts")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysdbparts")) {
            this.init();
            return this.pssysdbparts;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSDBPART";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysDBPart item = (PSSysDBPart)MAPPER.readValue(new File(strJsonFilePath), PSSysDBPart.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysDBPart) {
            PSSysDBPart dst = (PSSysDBPart)target;
            if (!bSimple && this.getPssysdbparts() != null) {
                ArrayList<PSSysDBPart> pssysdbparts = new ArrayList<PSSysDBPart>();
                for (PSSysDBPart item : this.getPssysdbparts()) {
                    if (bDeepMode) {
                        PSSysDBPart newitem = new PSSysDBPart();
                        item.to(newitem, false, bDeepMode);
                        pssysdbparts.add(newitem);
                        continue;
                    }
                    pssysdbparts.add(item);
                }
                dst.setPssysdbparts(pssysdbparts);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysDBPart) {
            PSSysDBPart src = (PSSysDBPart)source;
            if (!bSimple && src.getPssysdbparts() != null) {
                ArrayList<PSSysDBPart> pssysdbparts = new ArrayList<PSSysDBPart>();
                for (PSSysDBPart item : src.getPssysdbparts()) {
                    if (bDeepMode) {
                        PSSysDBPart newItem = new PSSysDBPart();
                        newItem.from(item, false, bDeepMode);
                        pssysdbparts.add(newItem);
                        continue;
                    }
                    pssysdbparts.add(item);
                }
                this.setPssysdbparts(pssysdbparts);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

