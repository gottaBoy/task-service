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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import net.ibizsys.modelapi.dto.PSPanelEngineDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSSysViewPanelDTO
extends PSModelDTOBase {
    public static final String FIELD_BODYONLYFLAG = "bodyonlyflag";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATANAME = "dataname";
    public static final String FIELD_ENABLEPAGEFOOTER = "enablepagefooter";
    public static final String FIELD_ENABLEPAGEHEADER = "enablepageheader";
    public static final String FIELD_GETDATAMODE = "getdatamode";
    public static final String FIELD_GETDATATIMER = "getdatatimer";
    public static final String FIELD_GETPSDEACTIONID = "getpsdeactionid";
    public static final String FIELD_GETPSDEACTIONNAME = "getpsdeactionname";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_NAVBARHEIGHT = "navbarheight";
    public static final String FIELD_NAVBARPOS = "navbarpos";
    public static final String FIELD_NAVBARPSSYSCSSID = "navbarpssyscssid";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "navbarpssyscssname";
    public static final String FIELD_NAVBARSTYLE = "navbarstyle";
    public static final String FIELD_NAVBARWIDTH = "navbarwidth";
    public static final String FIELD_OWNERID = "ownerid";
    public static final String FIELD_OWNERTAG = "ownertag";
    public static final String FIELD_OWNERTYPE = "ownertype";
    public static final String FIELD_PAGEFORMAT = "pageformat";
    public static final String FIELD_PAGEHEIGHT = "pageheight";
    public static final String FIELD_PAGEMARGINBOTTOM = "pagemarginbottom";
    public static final String FIELD_PAGEMARGINLEFT = "pagemarginleft";
    public static final String FIELD_PAGEMARGINRIGHT = "pagemarginright";
    public static final String FIELD_PAGEMARGINTOP = "pagemargintop";
    public static final String FIELD_PAGEWIDTH = "pagewidth";
    public static final String FIELD_PANELHEIGHT = "panelheight";
    public static final String FIELD_PANELNAVBAR = "panelnavbar";
    public static final String FIELD_PANELSTYLE = "panelstyle";
    public static final String FIELD_PANELWIDTH = "panelwidth";
    public static final String FIELD_PPI = "ppi";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_PUBLICFLAG = "publicflag";
    public static final String FIELD_SHOWFOOTERFIRSTPAGE = "showfooterfirstpage";
    public static final String FIELD_SHOWHEADERFIRSTPAGE = "showheaderfirstpage";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_VIEWLAYOUTFLAG = "viewlayoutflag";
    private List<PSSysViewPanelLogicDTO> pssysviewpanellogics;
    private List<PSSysViewPanelModelDTO> pssysviewpanelmodels;
    private List<PSPanelEngineDTO> pspanelengines;
    private List<PSSysViewPanelItemDTO> pssysviewpanelitems;

    @JsonIgnore
    public Integer getBodyOnlyFlag() {
        Object objValue = this.get(FIELD_BODYONLYFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bodyonlyflag")
    public void setBodyOnlyFlag(Integer bodyOnlyFlag) {
        this.set(FIELD_BODYONLYFLAG, bodyOnlyFlag);
    }

    @JsonIgnore
    public boolean isBodyOnlyFlagDirty() {
        return this.contains(FIELD_BODYONLYFLAG);
    }

    @JsonIgnore
    public String getCodeName() {
        Object objValue = this.get(FIELD_CODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename")
    public void setCodeName(String codeName) {
        this.set(FIELD_CODENAME, codeName);
    }

    @JsonIgnore
    public boolean isCodeNameDirty() {
        return this.contains(FIELD_CODENAME);
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
    public String getDataName() {
        Object objValue = this.get(FIELD_DATANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataname")
    public void setDataName(String dataName) {
        this.set(FIELD_DATANAME, dataName);
    }

    @JsonIgnore
    public boolean isDataNameDirty() {
        return this.contains(FIELD_DATANAME);
    }

    @JsonIgnore
    public Integer getEnablePageFooter() {
        Object objValue = this.get(FIELD_ENABLEPAGEFOOTER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablepagefooter")
    public void setEnablePageFooter(Integer enablePageFooter) {
        this.set(FIELD_ENABLEPAGEFOOTER, enablePageFooter);
    }

    @JsonIgnore
    public boolean isEnablePageFooterDirty() {
        return this.contains(FIELD_ENABLEPAGEFOOTER);
    }

    @JsonIgnore
    public Integer getEnablePageHeader() {
        Object objValue = this.get(FIELD_ENABLEPAGEHEADER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablepageheader")
    public void setEnablePageHeader(Integer enablePageHeader) {
        this.set(FIELD_ENABLEPAGEHEADER, enablePageHeader);
    }

    @JsonIgnore
    public boolean isEnablePageHeaderDirty() {
        return this.contains(FIELD_ENABLEPAGEHEADER);
    }

    @JsonIgnore
    public Integer getGetDataMode() {
        Object objValue = this.get(FIELD_GETDATAMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="getdatamode")
    public void setGetDataMode(Integer getDataMode) {
        this.set(FIELD_GETDATAMODE, getDataMode);
    }

    @JsonIgnore
    public boolean isGetDataModeDirty() {
        return this.contains(FIELD_GETDATAMODE);
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
    public String getGetPSDEActionId() {
        Object objValue = this.get(FIELD_GETPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionid")
    public void setGetPSDEActionId(String getPSDEActionId) {
        this.set(FIELD_GETPSDEACTIONID, getPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetPSDEActionIdDirty() {
        return this.contains(FIELD_GETPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetPSDEActionName() {
        Object objValue = this.get(FIELD_GETPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionname")
    public void setGetPSDEActionName(String getPSDEActionName) {
        this.set(FIELD_GETPSDEACTIONNAME, getPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetPSDEActionNameDirty() {
        return this.contains(FIELD_GETPSDEACTIONNAME);
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
    public Integer getNavBarHeight() {
        Object objValue = this.get(FIELD_NAVBARHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="navbarheight")
    public void setNavBarHeight(Integer navBarHeight) {
        this.set(FIELD_NAVBARHEIGHT, navBarHeight);
    }

    @JsonIgnore
    public boolean isNavBarHeightDirty() {
        return this.contains(FIELD_NAVBARHEIGHT);
    }

    @JsonIgnore
    public String getNavBarPos() {
        Object objValue = this.get(FIELD_NAVBARPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpos")
    public void setNavBarPos(String navBarPos) {
        this.set(FIELD_NAVBARPOS, navBarPos);
    }

    @JsonIgnore
    public boolean isNavBarPosDirty() {
        return this.contains(FIELD_NAVBARPOS);
    }

    @JsonIgnore
    public String getNavBarPSSysCssId() {
        Object objValue = this.get(FIELD_NAVBARPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpssyscssid")
    public void setNavBarPSSysCssId(String navBarPSSysCssId) {
        this.set(FIELD_NAVBARPSSYSCSSID, navBarPSSysCssId);
    }

    @JsonIgnore
    public boolean isNavBarPSSysCssIdDirty() {
        return this.contains(FIELD_NAVBARPSSYSCSSID);
    }

    @JsonIgnore
    public String getNavBarPSSysCssName() {
        Object objValue = this.get(FIELD_NAVBARPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpssyscssname")
    public void setNavBarPSSysCssName(String navBarPSSysCssName) {
        this.set(FIELD_NAVBARPSSYSCSSNAME, navBarPSSysCssName);
    }

    @JsonIgnore
    public boolean isNavBarPSSysCssNameDirty() {
        return this.contains(FIELD_NAVBARPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getNavBarStyle() {
        Object objValue = this.get(FIELD_NAVBARSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarstyle")
    public void setNavBarStyle(String navBarStyle) {
        this.set(FIELD_NAVBARSTYLE, navBarStyle);
    }

    @JsonIgnore
    public boolean isNavBarStyleDirty() {
        return this.contains(FIELD_NAVBARSTYLE);
    }

    @JsonIgnore
    public Integer getNavBarWidth() {
        Object objValue = this.get(FIELD_NAVBARWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="navbarwidth")
    public void setNavBarWidth(Integer navBarWidth) {
        this.set(FIELD_NAVBARWIDTH, navBarWidth);
    }

    @JsonIgnore
    public boolean isNavBarWidthDirty() {
        return this.contains(FIELD_NAVBARWIDTH);
    }

    @JsonIgnore
    public String getOwnerId() {
        Object objValue = this.get(FIELD_OWNERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownerid")
    public void setOwnerId(String ownerId) {
        this.set(FIELD_OWNERID, ownerId);
    }

    @JsonIgnore
    public boolean isOwnerIdDirty() {
        return this.contains(FIELD_OWNERID);
    }

    @JsonIgnore
    public String getOwnerTag() {
        Object objValue = this.get(FIELD_OWNERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownertag")
    public void setOwnerTag(String ownerTag) {
        this.set(FIELD_OWNERTAG, ownerTag);
    }

    @JsonIgnore
    public boolean isOwnerTagDirty() {
        return this.contains(FIELD_OWNERTAG);
    }

    @JsonIgnore
    public String getOwnerType() {
        Object objValue = this.get(FIELD_OWNERTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ownertype")
    public void setOwnerType(String ownerType) {
        this.set(FIELD_OWNERTYPE, ownerType);
    }

    @JsonIgnore
    public boolean isOwnerTypeDirty() {
        return this.contains(FIELD_OWNERTYPE);
    }

    @JsonIgnore
    public String getPageFormat() {
        Object objValue = this.get(FIELD_PAGEFORMAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pageformat")
    public void setPageFormat(String pageFormat) {
        this.set(FIELD_PAGEFORMAT, pageFormat);
    }

    @JsonIgnore
    public boolean isPageFormatDirty() {
        return this.contains(FIELD_PAGEFORMAT);
    }

    @JsonIgnore
    public BigDecimal getPageHeight() {
        Object objValue = this.get(FIELD_PAGEHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pageheight")
    public void setPageHeight(BigDecimal pageHeight) {
        this.set(FIELD_PAGEHEIGHT, pageHeight);
    }

    @JsonIgnore
    public boolean isPageHeightDirty() {
        return this.contains(FIELD_PAGEHEIGHT);
    }

    @JsonIgnore
    public BigDecimal getPageMarginBottom() {
        Object objValue = this.get(FIELD_PAGEMARGINBOTTOM);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pagemarginbottom")
    public void setPageMarginBottom(BigDecimal pageMarginBottom) {
        this.set(FIELD_PAGEMARGINBOTTOM, pageMarginBottom);
    }

    @JsonIgnore
    public boolean isPageMarginBottomDirty() {
        return this.contains(FIELD_PAGEMARGINBOTTOM);
    }

    @JsonIgnore
    public BigDecimal getPageMarginLeft() {
        Object objValue = this.get(FIELD_PAGEMARGINLEFT);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pagemarginleft")
    public void setPageMarginLeft(BigDecimal pageMarginLeft) {
        this.set(FIELD_PAGEMARGINLEFT, pageMarginLeft);
    }

    @JsonIgnore
    public boolean isPageMarginLeftDirty() {
        return this.contains(FIELD_PAGEMARGINLEFT);
    }

    @JsonIgnore
    public BigDecimal getPageMarginRight() {
        Object objValue = this.get(FIELD_PAGEMARGINRIGHT);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pagemarginright")
    public void setPageMarginRight(BigDecimal pageMarginRight) {
        this.set(FIELD_PAGEMARGINRIGHT, pageMarginRight);
    }

    @JsonIgnore
    public boolean isPageMarginRightDirty() {
        return this.contains(FIELD_PAGEMARGINRIGHT);
    }

    @JsonIgnore
    public BigDecimal getPageMarginTop() {
        Object objValue = this.get(FIELD_PAGEMARGINTOP);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pagemargintop")
    public void setPageMarginTop(BigDecimal pageMarginTop) {
        this.set(FIELD_PAGEMARGINTOP, pageMarginTop);
    }

    @JsonIgnore
    public boolean isPageMarginTopDirty() {
        return this.contains(FIELD_PAGEMARGINTOP);
    }

    @JsonIgnore
    public BigDecimal getPageWidth() {
        Object objValue = this.get(FIELD_PAGEWIDTH);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="pagewidth")
    public void setPageWidth(BigDecimal pageWidth) {
        this.set(FIELD_PAGEWIDTH, pageWidth);
    }

    @JsonIgnore
    public boolean isPageWidthDirty() {
        return this.contains(FIELD_PAGEWIDTH);
    }

    @JsonIgnore
    public Integer getPanelHeight() {
        Object objValue = this.get(FIELD_PANELHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panelheight")
    public void setPanelHeight(Integer panelHeight) {
        this.set(FIELD_PANELHEIGHT, panelHeight);
    }

    @JsonIgnore
    public boolean isPanelHeightDirty() {
        return this.contains(FIELD_PANELHEIGHT);
    }

    @JsonIgnore
    public Integer getPanelNavBar() {
        Object objValue = this.get(FIELD_PANELNAVBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panelnavbar")
    public void setPanelNavBar(Integer panelNavBar) {
        this.set(FIELD_PANELNAVBAR, panelNavBar);
    }

    @JsonIgnore
    public boolean isPanelNavBarDirty() {
        return this.contains(FIELD_PANELNAVBAR);
    }

    @JsonIgnore
    public String getPanelStyle() {
        Object objValue = this.get(FIELD_PANELSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="panelstyle")
    public void setPanelStyle(String panelStyle) {
        this.set(FIELD_PANELSTYLE, panelStyle);
    }

    @JsonIgnore
    public boolean isPanelStyleDirty() {
        return this.contains(FIELD_PANELSTYLE);
    }

    @JsonIgnore
    public Integer getPanelWidth() {
        Object objValue = this.get(FIELD_PANELWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="panelwidth")
    public void setPanelWidth(Integer panelWidth) {
        this.set(FIELD_PANELWIDTH, panelWidth);
    }

    @JsonIgnore
    public boolean isPanelWidthDirty() {
        return this.contains(FIELD_PANELWIDTH);
    }

    @JsonIgnore
    public BigDecimal getPPI() {
        Object objValue = this.get(FIELD_PPI);
        if (objValue == null) {
            return null;
        }
        return (BigDecimal)objValue;
    }

    @JsonProperty(value="ppi")
    public void setPPI(BigDecimal pPI) {
        this.set(FIELD_PPI, pPI);
    }

    @JsonIgnore
    public boolean isPPIDirty() {
        return this.contains(FIELD_PPI);
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
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
    }

    @JsonIgnore
    public String getPSSysAppName() {
        Object objValue = this.get(FIELD_PSSYSAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappname")
    public void setPSSysAppName(String pSSysAppName) {
        this.set(FIELD_PSSYSAPPNAME, pSSysAppName);
    }

    @JsonIgnore
    public boolean isPSSysAppNameDirty() {
        return this.contains(FIELD_PSSYSAPPNAME);
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
    public String getPSSystemId() {
        Object objValue = this.get(FIELD_PSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemid")
    public void setPSSystemId(String pSSystemId) {
        this.set(FIELD_PSSYSTEMID, pSSystemId);
    }

    @JsonIgnore
    public boolean isPSSystemIdDirty() {
        return this.contains(FIELD_PSSYSTEMID);
    }

    @JsonIgnore
    public String getPSSystemName() {
        Object objValue = this.get(FIELD_PSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemname")
    public void setPSSystemName(String pSSystemName) {
        this.set(FIELD_PSSYSTEMNAME, pSSystemName);
    }

    @JsonIgnore
    public boolean isPSSystemNameDirty() {
        return this.contains(FIELD_PSSYSTEMNAME);
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
    public Integer getPublicFlag() {
        Object objValue = this.get(FIELD_PUBLICFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="publicflag")
    public void setPublicFlag(Integer publicFlag) {
        this.set(FIELD_PUBLICFLAG, publicFlag);
    }

    @JsonIgnore
    public boolean isPublicFlagDirty() {
        return this.contains(FIELD_PUBLICFLAG);
    }

    @JsonIgnore
    public Integer getShowFooterFirstPage() {
        Object objValue = this.get(FIELD_SHOWFOOTERFIRSTPAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showfooterfirstpage")
    public void setShowFooterFirstPage(Integer showFooterFirstPage) {
        this.set(FIELD_SHOWFOOTERFIRSTPAGE, showFooterFirstPage);
    }

    @JsonIgnore
    public boolean isShowFooterFirstPageDirty() {
        return this.contains(FIELD_SHOWFOOTERFIRSTPAGE);
    }

    @JsonIgnore
    public Integer getShowHeaderFirstPage() {
        Object objValue = this.get(FIELD_SHOWHEADERFIRSTPAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showheaderfirstpage")
    public void setShowHeaderFirstPage(Integer showHeaderFirstPage) {
        this.set(FIELD_SHOWHEADERFIRSTPAGE, showHeaderFirstPage);
    }

    @JsonIgnore
    public boolean isShowHeaderFirstPageDirty() {
        return this.contains(FIELD_SHOWHEADERFIRSTPAGE);
    }

    @JsonIgnore
    public String getToDoTask() {
        Object objValue = this.get(FIELD_TODOTASK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="todotask")
    public void setToDoTask(String toDoTask) {
        this.set(FIELD_TODOTASK, toDoTask);
    }

    @JsonIgnore
    public boolean isToDoTaskDirty() {
        return this.contains(FIELD_TODOTASK);
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
    public Integer getViewLayoutFlag() {
        Object objValue = this.get(FIELD_VIEWLAYOUTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewlayoutflag")
    public void setViewLayoutFlag(Integer viewLayoutFlag) {
        this.set(FIELD_VIEWLAYOUTFLAG, viewLayoutFlag);
    }

    @JsonIgnore
    public boolean isViewLayoutFlagDirty() {
        return this.contains(FIELD_VIEWLAYOUTFLAG);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysViewPanelId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysViewPanelId(strValue);
    }

    @JsonProperty(value="pssysviewpanellogics")
    public List<PSSysViewPanelLogicDTO> getPssysviewpanellogics() {
        return this.pssysviewpanellogics;
    }

    @JsonProperty(value="pssysviewpanellogics")
    public void setPssysviewpanellogics(List<PSSysViewPanelLogicDTO> pssysviewpanellogics) {
        this.pssysviewpanellogics = pssysviewpanellogics;
    }

    @JsonProperty(value="pssysviewpanelmodels")
    public List<PSSysViewPanelModelDTO> getPssysviewpanelmodels() {
        return this.pssysviewpanelmodels;
    }

    @JsonProperty(value="pssysviewpanelmodels")
    public void setPssysviewpanelmodels(List<PSSysViewPanelModelDTO> pssysviewpanelmodels) {
        this.pssysviewpanelmodels = pssysviewpanelmodels;
    }

    @JsonProperty(value="pspanelengines")
    public List<PSPanelEngineDTO> getPspanelengines() {
        return this.pspanelengines;
    }

    @JsonProperty(value="pspanelengines")
    public void setPspanelengines(List<PSPanelEngineDTO> pspanelengines) {
        this.pspanelengines = pspanelengines;
    }

    @JsonProperty(value="pssysviewpanelitems")
    public List<PSSysViewPanelItemDTO> getPssysviewpanelitems() {
        return this.pssysviewpanelitems;
    }

    @JsonProperty(value="pssysviewpanelitems")
    public void setPssysviewpanelitems(List<PSSysViewPanelItemDTO> pssysviewpanelitems) {
        this.pssysviewpanelitems = pssysviewpanelitems;
    }
}

