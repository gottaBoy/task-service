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
import net.ibizsys.modelapi.domain.PSDEDataViewLogic;
import net.ibizsys.modelapi.domain.PSDEListItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDataView
extends PSModelBase {
    public static final String FIELD_APPENDDEITEMS = "appenddeitems";
    public static final String FIELD_BATPSDETOOLBARID = "batpsdetoolbarid";
    public static final String FIELD_BATPSDETOOLBARNAME = "batpsdetoolbarname";
    public static final String FIELD_CARDHEIGHT = "cardheight";
    public static final String FIELD_CARDWIDTH = "cardwidth";
    public static final String FIELD_CARD_COL_LG = "card_col_lg";
    public static final String FIELD_CARD_COL_MD = "card_col_md";
    public static final String FIELD_CARD_COL_SM = "card_col_sm";
    public static final String FIELD_CARD_COL_XS = "card_col_xs";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DATAVIEWSN = "dataviewsn";
    public static final String FIELD_DATAVIEWSTYLE = "dataviewstyle";
    public static final String FIELD_DVTAG = "dvtag";
    public static final String FIELD_DVTAG2 = "dvtag2";
    public static final String FIELD_DVTAG3 = "dvtag3";
    public static final String FIELD_DVTAG4 = "dvtag4";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_ENABLEPAGINGBAR = "enablepagingbar";
    public static final String FIELD_GROUPHEIGHT = "groupheight";
    public static final String FIELD_GROUPLAYOUT = "grouplayout";
    public static final String FIELD_GROUPMODE = "groupmode";
    public static final String FIELD_GROUPPSCODELISTID = "grouppscodelistid";
    public static final String FIELD_GROUPPSCODELISTNAME = "grouppscodelistname";
    public static final String FIELD_GROUPPSDEFID = "grouppsdefid";
    public static final String FIELD_GROUPPSDEFNAME = "grouppsdefname";
    public static final String FIELD_GROUPPSDEUAGROUPID = "grouppsdeuagroupid";
    public static final String FIELD_GROUPPSDEUAGROUPNAME = "grouppsdeuagroupname";
    public static final String FIELD_GROUPPSSYSCSSID = "grouppssyscssid";
    public static final String FIELD_GROUPPSSYSCSSNAME = "grouppssyscssname";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "grouppssyspfpluginid";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "grouppssyspfpluginname";
    public static final String FIELD_GROUPQUICKPSDETBID = "groupquickpsdetbid";
    public static final String FIELD_GROUPQUICKPSDETBNAME = "groupquickpsdetbname";
    public static final String FIELD_GROUPWIDTH = "groupwidth";
    public static final String FIELD_GROUP_COL_LG = "group_col_lg";
    public static final String FIELD_GROUP_COL_MD = "group_col_md";
    public static final String FIELD_GROUP_COL_SM = "group_col_sm";
    public static final String FIELD_GROUP_COL_XS = "group_col_xs";
    public static final String FIELD_ITEMPSSYSCSSID = "itempssyscssid";
    public static final String FIELD_ITEMPSSYSCSSNAME = "itempssyscssname";
    public static final String FIELD_ITEMPSSYSPFPLUGINID = "itempssyspfpluginid";
    public static final String FIELD_ITEMPSSYSPFPLUGINNAME = "itempssyspfpluginname";
    public static final String FIELD_KANBANFLAG = "kanbanflag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_MINORSORTPSDEFID = "minorsortpsdefid";
    public static final String FIELD_MINORSORTPSDEFNAME = "minorsortpsdefname";
    public static final String FIELD_NAVPSDERID = "navpsderid";
    public static final String FIELD_NAVPSDERNAME = "navpsdername";
    public static final String FIELD_NAVPSDEVIEWBASEID = "navpsdeviewbaseid";
    public static final String FIELD_NAVPSDEVIEWBASENAME = "navpsdeviewbasename";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_ORDERVALUEPSDEFID = "ordervaluepsdefid";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ordervaluepsdefname";
    public static final String FIELD_PAGINGSIZE = "pagingsize";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEDATAVIEWID = "psdedataviewid";
    public static final String FIELD_PSDEDATAVIEWNAME = "psdedataviewname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_QUICKPSDETOOLBARID = "quickpsdetoolbarid";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "quickpsdetoolbarname";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSDEListItem> psdelistitems;
    private List<PSDEDataViewLogic> psdedataviewlogics;

    @JsonIgnore
    public Integer getAppendDEItems() {
        Object objValue = this.get(FIELD_APPENDDEITEMS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appenddeitems")
    public void setAppendDEItems(Integer appendDEItems) {
        this.set(FIELD_APPENDDEITEMS, appendDEItems);
    }

    @JsonIgnore
    public boolean isAppendDEItemsDirty() {
        return this.contains(FIELD_APPENDDEITEMS);
    }

    @JsonIgnore
    public String getBatPSDEToolbarId() {
        Object objValue = this.get(FIELD_BATPSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="batpsdetoolbarid")
    public void setBatPSDEToolbarId(String batPSDEToolbarId) {
        this.set(FIELD_BATPSDETOOLBARID, batPSDEToolbarId);
    }

    @JsonIgnore
    public boolean isBatPSDEToolbarIdDirty() {
        return this.contains(FIELD_BATPSDETOOLBARID);
    }

    @JsonIgnore
    public String getBatPSDEToolbarName() {
        Object objValue = this.get(FIELD_BATPSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="batpsdetoolbarname")
    public void setBatPSDEToolbarName(String batPSDEToolbarName) {
        this.set(FIELD_BATPSDETOOLBARNAME, batPSDEToolbarName);
    }

    @JsonIgnore
    public boolean isBatPSDEToolbarNameDirty() {
        return this.contains(FIELD_BATPSDETOOLBARNAME);
    }

    @JsonIgnore
    public Integer getCardHeight() {
        Object objValue = this.get(FIELD_CARDHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cardheight")
    public void setCardHeight(Integer cardHeight) {
        this.set(FIELD_CARDHEIGHT, cardHeight);
    }

    @JsonIgnore
    public boolean isCardHeightDirty() {
        return this.contains(FIELD_CARDHEIGHT);
    }

    @JsonIgnore
    public Integer getCardWidth() {
        Object objValue = this.get(FIELD_CARDWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cardwidth")
    public void setCardWidth(Integer cardWidth) {
        this.set(FIELD_CARDWIDTH, cardWidth);
    }

    @JsonIgnore
    public boolean isCardWidthDirty() {
        return this.contains(FIELD_CARDWIDTH);
    }

    @JsonIgnore
    public Integer getCard_Col_LG() {
        Object objValue = this.get(FIELD_CARD_COL_LG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="card_col_lg")
    public void setCard_Col_LG(Integer card_Col_LG) {
        this.set(FIELD_CARD_COL_LG, card_Col_LG);
    }

    @JsonIgnore
    public boolean isCard_Col_LGDirty() {
        return this.contains(FIELD_CARD_COL_LG);
    }

    @JsonIgnore
    public Integer getCard_Col_MD() {
        Object objValue = this.get(FIELD_CARD_COL_MD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="card_col_md")
    public void setCard_Col_MD(Integer card_Col_MD) {
        this.set(FIELD_CARD_COL_MD, card_Col_MD);
    }

    @JsonIgnore
    public boolean isCard_Col_MDDirty() {
        return this.contains(FIELD_CARD_COL_MD);
    }

    @JsonIgnore
    public Integer getCard_Col_SM() {
        Object objValue = this.get(FIELD_CARD_COL_SM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="card_col_sm")
    public void setCard_Col_SM(Integer card_Col_SM) {
        this.set(FIELD_CARD_COL_SM, card_Col_SM);
    }

    @JsonIgnore
    public boolean isCard_Col_SMDirty() {
        return this.contains(FIELD_CARD_COL_SM);
    }

    @JsonIgnore
    public Integer getCard_Col_XS() {
        Object objValue = this.get(FIELD_CARD_COL_XS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="card_col_xs")
    public void setCard_Col_XS(Integer card_Col_XS) {
        this.set(FIELD_CARD_COL_XS, card_Col_XS);
    }

    @JsonIgnore
    public boolean isCard_Col_XSDirty() {
        return this.contains(FIELD_CARD_COL_XS);
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
    public String getCustomCond() {
        Object objValue = this.get(FIELD_CUSTOMCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcond")
    public void setCustomCond(String customCond) {
        this.set(FIELD_CUSTOMCOND, customCond);
    }

    @JsonIgnore
    public boolean isCustomCondDirty() {
        return this.contains(FIELD_CUSTOMCOND);
    }

    @JsonIgnore
    public String getDataViewSN() {
        Object objValue = this.get(FIELD_DATAVIEWSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataviewsn")
    public void setDataViewSN(String dataViewSN) {
        this.set(FIELD_DATAVIEWSN, dataViewSN);
    }

    @JsonIgnore
    public boolean isDataViewSNDirty() {
        return this.contains(FIELD_DATAVIEWSN);
    }

    @JsonIgnore
    public String getDataViewStyle() {
        Object objValue = this.get(FIELD_DATAVIEWSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dataviewstyle")
    public void setDataViewStyle(String dataViewStyle) {
        this.set(FIELD_DATAVIEWSTYLE, dataViewStyle);
    }

    @JsonIgnore
    public boolean isDataViewStyleDirty() {
        return this.contains(FIELD_DATAVIEWSTYLE);
    }

    @JsonIgnore
    public String getDVTag() {
        Object objValue = this.get(FIELD_DVTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvtag")
    public void setDVTag(String dVTag) {
        this.set(FIELD_DVTAG, dVTag);
    }

    @JsonIgnore
    public boolean isDVTagDirty() {
        return this.contains(FIELD_DVTAG);
    }

    @JsonIgnore
    public String getDVTag2() {
        Object objValue = this.get(FIELD_DVTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvtag2")
    public void setDVTag2(String dVTag2) {
        this.set(FIELD_DVTAG2, dVTag2);
    }

    @JsonIgnore
    public boolean isDVTag2Dirty() {
        return this.contains(FIELD_DVTAG2);
    }

    @JsonIgnore
    public String getDVTag3() {
        Object objValue = this.get(FIELD_DVTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvtag3")
    public void setDVTag3(String dVTag3) {
        this.set(FIELD_DVTAG3, dVTag3);
    }

    @JsonIgnore
    public boolean isDVTag3Dirty() {
        return this.contains(FIELD_DVTAG3);
    }

    @JsonIgnore
    public String getDVTag4() {
        Object objValue = this.get(FIELD_DVTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dvtag4")
    public void setDVTag4(String dVTag4) {
        this.set(FIELD_DVTAG4, dVTag4);
    }

    @JsonIgnore
    public boolean isDVTag4Dirty() {
        return this.contains(FIELD_DVTAG4);
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
    public String getEmptyText() {
        Object objValue = this.get(FIELD_EMPTYTEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytext")
    public void setEmptyText(String emptyText) {
        this.set(FIELD_EMPTYTEXT, emptyText);
    }

    @JsonIgnore
    public boolean isEmptyTextDirty() {
        return this.contains(FIELD_EMPTYTEXT);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResId() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresid")
    public void setEmptyTextPSLanResId(String emptyTextPSLanResId) {
        this.set(FIELD_EMPTYTEXTPSLANRESID, emptyTextPSLanResId);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResIdDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESID);
    }

    @JsonIgnore
    public String getEmptyTextPSLanResName() {
        Object objValue = this.get(FIELD_EMPTYTEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="emptytextpslanresname")
    public void setEmptyTextPSLanResName(String emptyTextPSLanResName) {
        this.set(FIELD_EMPTYTEXTPSLANRESNAME, emptyTextPSLanResName);
    }

    @JsonIgnore
    public boolean isEmptyTextPSLanResNameDirty() {
        return this.contains(FIELD_EMPTYTEXTPSLANRESNAME);
    }

    @JsonIgnore
    public Integer getEnablePagingBar() {
        Object objValue = this.get(FIELD_ENABLEPAGINGBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablepagingbar")
    public void setEnablePagingBar(Integer enablePagingBar) {
        this.set(FIELD_ENABLEPAGINGBAR, enablePagingBar);
    }

    @JsonIgnore
    public boolean isEnablePagingBarDirty() {
        return this.contains(FIELD_ENABLEPAGINGBAR);
    }

    @JsonIgnore
    public Integer getGroupHeight() {
        Object objValue = this.get(FIELD_GROUPHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupheight")
    public void setGroupHeight(Integer groupHeight) {
        this.set(FIELD_GROUPHEIGHT, groupHeight);
    }

    @JsonIgnore
    public boolean isGroupHeightDirty() {
        return this.contains(FIELD_GROUPHEIGHT);
    }

    @JsonIgnore
    public String getGroupLayout() {
        Object objValue = this.get(FIELD_GROUPLAYOUT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouplayout")
    public void setGroupLayout(String groupLayout) {
        this.set(FIELD_GROUPLAYOUT, groupLayout);
    }

    @JsonIgnore
    public boolean isGroupLayoutDirty() {
        return this.contains(FIELD_GROUPLAYOUT);
    }

    @JsonIgnore
    public String getGroupMode() {
        Object objValue = this.get(FIELD_GROUPMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupmode")
    public void setGroupMode(String groupMode) {
        this.set(FIELD_GROUPMODE, groupMode);
    }

    @JsonIgnore
    public boolean isGroupModeDirty() {
        return this.contains(FIELD_GROUPMODE);
    }

    @JsonIgnore
    public String getGroupPSCodeListId() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistid")
    public void setGroupPSCodeListId(String groupPSCodeListId) {
        this.set(FIELD_GROUPPSCODELISTID, groupPSCodeListId);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListIdDirty() {
        return this.contains(FIELD_GROUPPSCODELISTID);
    }

    @JsonIgnore
    public String getGroupPSCodeListName() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistname")
    public void setGroupPSCodeListName(String groupPSCodeListName) {
        this.set(FIELD_GROUPPSCODELISTNAME, groupPSCodeListName);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListNameDirty() {
        return this.contains(FIELD_GROUPPSCODELISTNAME);
    }

    @JsonIgnore
    public String getGroupPSDEFId() {
        Object objValue = this.get(FIELD_GROUPPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefid")
    public void setGroupPSDEFId(String groupPSDEFId) {
        this.set(FIELD_GROUPPSDEFID, groupPSDEFId);
    }

    @JsonIgnore
    public boolean isGroupPSDEFIdDirty() {
        return this.contains(FIELD_GROUPPSDEFID);
    }

    @JsonIgnore
    public String getGroupPSDEFName() {
        Object objValue = this.get(FIELD_GROUPPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefname")
    public void setGroupPSDEFName(String groupPSDEFName) {
        this.set(FIELD_GROUPPSDEFNAME, groupPSDEFName);
    }

    @JsonIgnore
    public boolean isGroupPSDEFNameDirty() {
        return this.contains(FIELD_GROUPPSDEFNAME);
    }

    @JsonIgnore
    public String getGroupPSDEUAGroupId() {
        Object objValue = this.get(FIELD_GROUPPSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdeuagroupid")
    public void setGroupPSDEUAGroupId(String groupPSDEUAGroupId) {
        this.set(FIELD_GROUPPSDEUAGROUPID, groupPSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isGroupPSDEUAGroupIdDirty() {
        return this.contains(FIELD_GROUPPSDEUAGROUPID);
    }

    @JsonIgnore
    public String getGroupPSDEUAGroupName() {
        Object objValue = this.get(FIELD_GROUPPSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdeuagroupname")
    public void setGroupPSDEUAGroupName(String groupPSDEUAGroupName) {
        this.set(FIELD_GROUPPSDEUAGROUPNAME, groupPSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isGroupPSDEUAGroupNameDirty() {
        return this.contains(FIELD_GROUPPSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getGroupPSSysCssId() {
        Object objValue = this.get(FIELD_GROUPPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyscssid")
    public void setGroupPSSysCssId(String groupPSSysCssId) {
        this.set(FIELD_GROUPPSSYSCSSID, groupPSSysCssId);
    }

    @JsonIgnore
    public boolean isGroupPSSysCssIdDirty() {
        return this.contains(FIELD_GROUPPSSYSCSSID);
    }

    @JsonIgnore
    public String getGroupPSSysCssName() {
        Object objValue = this.get(FIELD_GROUPPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyscssname")
    public void setGroupPSSysCssName(String groupPSSysCssName) {
        this.set(FIELD_GROUPPSSYSCSSNAME, groupPSSysCssName);
    }

    @JsonIgnore
    public boolean isGroupPSSysCssNameDirty() {
        return this.contains(FIELD_GROUPPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getGroupPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GROUPPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyspfpluginid")
    public void setGroupPSSysPFPluginId(String groupPSSysPFPluginId) {
        this.set(FIELD_GROUPPSSYSPFPLUGINID, groupPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGroupPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GROUPPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGroupPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GROUPPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppssyspfpluginname")
    public void setGroupPSSysPFPluginName(String groupPSSysPFPluginName) {
        this.set(FIELD_GROUPPSSYSPFPLUGINNAME, groupPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGroupPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GROUPPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getGroupQuickPSDETBId() {
        Object objValue = this.get(FIELD_GROUPQUICKPSDETBID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupquickpsdetbid")
    public void setGroupQuickPSDETBId(String groupQuickPSDETBId) {
        this.set(FIELD_GROUPQUICKPSDETBID, groupQuickPSDETBId);
    }

    @JsonIgnore
    public boolean isGroupQuickPSDETBIdDirty() {
        return this.contains(FIELD_GROUPQUICKPSDETBID);
    }

    @JsonIgnore
    public String getGroupQuickPSDETBName() {
        Object objValue = this.get(FIELD_GROUPQUICKPSDETBNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupquickpsdetbname")
    public void setGroupQuickPSDETBName(String groupQuickPSDETBName) {
        this.set(FIELD_GROUPQUICKPSDETBNAME, groupQuickPSDETBName);
    }

    @JsonIgnore
    public boolean isGroupQuickPSDETBNameDirty() {
        return this.contains(FIELD_GROUPQUICKPSDETBNAME);
    }

    @JsonIgnore
    public Integer getGroupWidth() {
        Object objValue = this.get(FIELD_GROUPWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupwidth")
    public void setGroupWidth(Integer groupWidth) {
        this.set(FIELD_GROUPWIDTH, groupWidth);
    }

    @JsonIgnore
    public boolean isGroupWidthDirty() {
        return this.contains(FIELD_GROUPWIDTH);
    }

    @JsonIgnore
    public Integer getGroup_Col_LG() {
        Object objValue = this.get(FIELD_GROUP_COL_LG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="group_col_lg")
    public void setGroup_Col_LG(Integer group_Col_LG) {
        this.set(FIELD_GROUP_COL_LG, group_Col_LG);
    }

    @JsonIgnore
    public boolean isGroup_Col_LGDirty() {
        return this.contains(FIELD_GROUP_COL_LG);
    }

    @JsonIgnore
    public Integer getGroup_Col_MD() {
        Object objValue = this.get(FIELD_GROUP_COL_MD);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="group_col_md")
    public void setGroup_Col_MD(Integer group_Col_MD) {
        this.set(FIELD_GROUP_COL_MD, group_Col_MD);
    }

    @JsonIgnore
    public boolean isGroup_Col_MDDirty() {
        return this.contains(FIELD_GROUP_COL_MD);
    }

    @JsonIgnore
    public Integer getGroup_Col_SM() {
        Object objValue = this.get(FIELD_GROUP_COL_SM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="group_col_sm")
    public void setGroup_Col_SM(Integer group_Col_SM) {
        this.set(FIELD_GROUP_COL_SM, group_Col_SM);
    }

    @JsonIgnore
    public boolean isGroup_Col_SMDirty() {
        return this.contains(FIELD_GROUP_COL_SM);
    }

    @JsonIgnore
    public Integer getGroup_Col_XS() {
        Object objValue = this.get(FIELD_GROUP_COL_XS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="group_col_xs")
    public void setGroup_Col_XS(Integer group_Col_XS) {
        this.set(FIELD_GROUP_COL_XS, group_Col_XS);
    }

    @JsonIgnore
    public boolean isGroup_Col_XSDirty() {
        return this.contains(FIELD_GROUP_COL_XS);
    }

    @JsonIgnore
    public String getItemPSSysCssId() {
        Object objValue = this.get(FIELD_ITEMPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyscssid")
    public void setItemPSSysCssId(String itemPSSysCssId) {
        this.set(FIELD_ITEMPSSYSCSSID, itemPSSysCssId);
    }

    @JsonIgnore
    public boolean isItemPSSysCssIdDirty() {
        return this.contains(FIELD_ITEMPSSYSCSSID);
    }

    @JsonIgnore
    public String getItemPSSysCssName() {
        Object objValue = this.get(FIELD_ITEMPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyscssname")
    public void setItemPSSysCssName(String itemPSSysCssName) {
        this.set(FIELD_ITEMPSSYSCSSNAME, itemPSSysCssName);
    }

    @JsonIgnore
    public boolean isItemPSSysCssNameDirty() {
        return this.contains(FIELD_ITEMPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getItemPSSysPFPluginId() {
        Object objValue = this.get(FIELD_ITEMPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyspfpluginid")
    public void setItemPSSysPFPluginId(String itemPSSysPFPluginId) {
        this.set(FIELD_ITEMPSSYSPFPLUGINID, itemPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isItemPSSysPFPluginIdDirty() {
        return this.contains(FIELD_ITEMPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getItemPSSysPFPluginName() {
        Object objValue = this.get(FIELD_ITEMPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="itempssyspfpluginname")
    public void setItemPSSysPFPluginName(String itemPSSysPFPluginName) {
        this.set(FIELD_ITEMPSSYSPFPLUGINNAME, itemPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isItemPSSysPFPluginNameDirty() {
        return this.contains(FIELD_ITEMPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public Integer getKanbanFlag() {
        Object objValue = this.get(FIELD_KANBANFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="kanbanflag")
    public void setKanbanFlag(Integer kanbanFlag) {
        this.set(FIELD_KANBANFLAG, kanbanFlag);
    }

    @JsonIgnore
    public boolean isKanbanFlagDirty() {
        return this.contains(FIELD_KANBANFLAG);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public String getMinorSortDir() {
        Object objValue = this.get(FIELD_MINORSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortdir")
    public void setMinorSortDir(String minorSortDir) {
        this.set(FIELD_MINORSORTDIR, minorSortDir);
    }

    @JsonIgnore
    public boolean isMinorSortDirDirty() {
        return this.contains(FIELD_MINORSORTDIR);
    }

    @JsonIgnore
    public String getMinorSortPSDEFId() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefid")
    public void setMinorSortPSDEFId(String minorSortPSDEFId) {
        this.set(FIELD_MINORSORTPSDEFID, minorSortPSDEFId);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFIdDirty() {
        return this.contains(FIELD_MINORSORTPSDEFID);
    }

    @JsonIgnore
    public String getMinorSortPSDEFName() {
        Object objValue = this.get(FIELD_MINORSORTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorsortpsdefname")
    public void setMinorSortPSDEFName(String minorSortPSDEFName) {
        this.set(FIELD_MINORSORTPSDEFNAME, minorSortPSDEFName);
    }

    @JsonIgnore
    public boolean isMinorSortPSDEFNameDirty() {
        return this.contains(FIELD_MINORSORTPSDEFNAME);
    }

    @JsonIgnore
    public String getNavPSDERId() {
        Object objValue = this.get(FIELD_NAVPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsderid")
    public void setNavPSDERId(String navPSDERId) {
        this.set(FIELD_NAVPSDERID, navPSDERId);
    }

    @JsonIgnore
    public boolean isNavPSDERIdDirty() {
        return this.contains(FIELD_NAVPSDERID);
    }

    @JsonIgnore
    public String getNavPSDERName() {
        Object objValue = this.get(FIELD_NAVPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdername")
    public void setNavPSDERName(String navPSDERName) {
        this.set(FIELD_NAVPSDERNAME, navPSDERName);
    }

    @JsonIgnore
    public boolean isNavPSDERNameDirty() {
        return this.contains(FIELD_NAVPSDERNAME);
    }

    @JsonIgnore
    public String getNavPSDEViewBaseId() {
        Object objValue = this.get(FIELD_NAVPSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdeviewbaseid")
    public void setNavPSDEViewBaseId(String navPSDEViewBaseId) {
        this.set(FIELD_NAVPSDEVIEWBASEID, navPSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isNavPSDEViewBaseIdDirty() {
        return this.contains(FIELD_NAVPSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getNavPSDEViewBaseName() {
        Object objValue = this.get(FIELD_NAVPSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navpsdeviewbasename")
    public void setNavPSDEViewBaseName(String navPSDEViewBaseName) {
        this.set(FIELD_NAVPSDEVIEWBASENAME, navPSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isNavPSDEViewBaseNameDirty() {
        return this.contains(FIELD_NAVPSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getNavViewFilter() {
        Object objValue = this.get(FIELD_NAVVIEWFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewfilter")
    public void setNavViewFilter(String navViewFilter) {
        this.set(FIELD_NAVVIEWFILTER, navViewFilter);
    }

    @JsonIgnore
    public boolean isNavViewFilterDirty() {
        return this.contains(FIELD_NAVVIEWFILTER);
    }

    @JsonIgnore
    public String getNavViewParam() {
        Object objValue = this.get(FIELD_NAVVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navviewparam")
    public void setNavViewParam(String navViewParam) {
        this.set(FIELD_NAVVIEWPARAM, navViewParam);
    }

    @JsonIgnore
    public boolean isNavViewParamDirty() {
        return this.contains(FIELD_NAVVIEWPARAM);
    }

    @JsonIgnore
    public Integer getNoSort() {
        Object objValue = this.get(FIELD_NOSORT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="nosort")
    public void setNoSort(Integer noSort) {
        this.set(FIELD_NOSORT, noSort);
    }

    @JsonIgnore
    public boolean isNoSortDirty() {
        return this.contains(FIELD_NOSORT);
    }

    @JsonIgnore
    public String getOrderValuePSDEFId() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefid")
    public void setOrderValuePSDEFId(String orderValuePSDEFId) {
        this.set(FIELD_ORDERVALUEPSDEFID, orderValuePSDEFId);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFIdDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFID);
    }

    @JsonIgnore
    public String getOrderValuePSDEFName() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefname")
    public void setOrderValuePSDEFName(String orderValuePSDEFName) {
        this.set(FIELD_ORDERVALUEPSDEFNAME, orderValuePSDEFName);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFNameDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFNAME);
    }

    @JsonIgnore
    public Integer getPagingSize() {
        Object objValue = this.get(FIELD_PAGINGSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pagingsize")
    public void setPagingSize(Integer pagingSize) {
        this.set(FIELD_PAGINGSIZE, pagingSize);
    }

    @JsonIgnore
    public boolean isPagingSizeDirty() {
        return this.contains(FIELD_PAGINGSIZE);
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
    public String getPSCtrlMsgId() {
        Object objValue = this.get(FIELD_PSCTRLMSGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgid")
    public void setPSCtrlMsgId(String pSCtrlMsgId) {
        this.set(FIELD_PSCTRLMSGID, pSCtrlMsgId);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgIdDirty() {
        return this.contains(FIELD_PSCTRLMSGID);
    }

    @JsonIgnore
    public String getPSCtrlMsgName() {
        Object objValue = this.get(FIELD_PSCTRLMSGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psctrlmsgname")
    public void setPSCtrlMsgName(String pSCtrlMsgName) {
        this.set(FIELD_PSCTRLMSGNAME, pSCtrlMsgName);
    }

    @JsonIgnore
    public boolean isPSCtrlMsgNameDirty() {
        return this.contains(FIELD_PSCTRLMSGNAME);
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
    public String getQuickPSDEToolbarId() {
        Object objValue = this.get(FIELD_QUICKPSDETOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdetoolbarid")
    public void setQuickPSDEToolbarId(String quickPSDEToolbarId) {
        this.set(FIELD_QUICKPSDETOOLBARID, quickPSDEToolbarId);
    }

    @JsonIgnore
    public boolean isQuickPSDEToolbarIdDirty() {
        return this.contains(FIELD_QUICKPSDETOOLBARID);
    }

    @JsonIgnore
    public String getQuickPSDEToolbarName() {
        Object objValue = this.get(FIELD_QUICKPSDETOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="quickpsdetoolbarname")
    public void setQuickPSDEToolbarName(String quickPSDEToolbarName) {
        this.set(FIELD_QUICKPSDETOOLBARNAME, quickPSDEToolbarName);
    }

    @JsonIgnore
    public boolean isQuickPSDEToolbarNameDirty() {
        return this.contains(FIELD_QUICKPSDETOOLBARNAME);
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
    public String getSrfkey() {
        return this.getPSDEDataViewId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDataViewId(strValue);
    }

    public List<PSDEListItem> getPsdelistitems() {
        return this.psdelistitems;
    }

    public void setPsdelistitems(List<PSDEListItem> psdelistitems) {
        this.psdelistitems = psdelistitems;
    }

    public List<PSDEDataViewLogic> getPsdedataviewlogics() {
        return this.psdedataviewlogics;
    }

    public void setPsdedataviewlogics(List<PSDEDataViewLogic> psdedataviewlogics) {
        this.psdedataviewlogics = psdedataviewlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdelistitems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedataviewlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdelistitems")) {
            this.init();
            return this.psdelistitems;
        }
        if (strName.equalsIgnoreCase("psdedataviewlogics")) {
            this.init();
            return this.psdedataviewlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDATAVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDataView item = (PSDEDataView)MAPPER.readValue(new File(strJsonFilePath), PSDEDataView.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDataView) {
            PSDEDataView dst = (PSDEDataView)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdelistitems() != null) {
                    ArrayList<PSDEListItem> psdelistitems = new ArrayList<PSDEListItem>();
                    for (PSDEListItem pSDEListItem : this.getPsdelistitems()) {
                        if (bDeepMode) {
                            newitem = new PSDEListItem();
                            pSDEListItem.to(newitem, false, bDeepMode);
                            psdelistitems.add((PSDEListItem)newitem);
                            continue;
                        }
                        psdelistitems.add(pSDEListItem);
                    }
                    dst.setPsdelistitems(psdelistitems);
                }
                if (this.getPsdedataviewlogics() != null) {
                    ArrayList<PSDEDataViewLogic> psdedataviewlogics = new ArrayList<PSDEDataViewLogic>();
                    for (PSDEDataViewLogic pSDEDataViewLogic : this.getPsdedataviewlogics()) {
                        if (bDeepMode) {
                            newitem = new PSDEDataViewLogic();
                            pSDEDataViewLogic.to(newitem, false, bDeepMode);
                            psdedataviewlogics.add((PSDEDataViewLogic)newitem);
                            continue;
                        }
                        psdedataviewlogics.add(pSDEDataViewLogic);
                    }
                    dst.setPsdedataviewlogics(psdedataviewlogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDataView) {
            PSDEDataView src = (PSDEDataView)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdelistitems() != null) {
                    ArrayList<PSDEListItem> psdelistitems = new ArrayList<PSDEListItem>();
                    for (PSDEListItem pSDEListItem : src.getPsdelistitems()) {
                        if (bDeepMode) {
                            newItem = new PSDEListItem();
                            ((PSDEListItem)newItem).from(pSDEListItem, false, bDeepMode);
                            psdelistitems.add((PSDEListItem)newItem);
                            continue;
                        }
                        psdelistitems.add(pSDEListItem);
                    }
                    this.setPsdelistitems(psdelistitems);
                }
                if (src.getPsdedataviewlogics() != null) {
                    ArrayList<PSDEDataViewLogic> psdedataviewlogics = new ArrayList<PSDEDataViewLogic>();
                    for (PSDEDataViewLogic pSDEDataViewLogic : src.getPsdedataviewlogics()) {
                        if (bDeepMode) {
                            newItem = new PSDEDataViewLogic();
                            ((PSDEDataViewLogic)newItem).from(pSDEDataViewLogic, false, bDeepMode);
                            psdedataviewlogics.add((PSDEDataViewLogic)newItem);
                            continue;
                        }
                        psdedataviewlogics.add(pSDEDataViewLogic);
                    }
                    this.setPsdedataviewlogics(psdedataviewlogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

