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
import net.ibizsys.modelapi.dto.PSDEListItemDTO;
import net.ibizsys.modelapi.dto.PSDEListLogicDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEListDTO
extends PSModelDTOBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_APPENDDEITEMS = "appenddeitems";
    public static final String FIELD_BATPSDETOOLBARID = "batpsdetoolbarid";
    public static final String FIELD_BATPSDETOOLBARNAME = "batpsdetoolbarname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
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
    public static final String FIELD_ITEMPSSYSCSSID = "itempssyscssid";
    public static final String FIELD_ITEMPSSYSCSSNAME = "itempssyscssname";
    public static final String FIELD_ITEMPSSYSPFPLUGINID = "itempssyspfpluginid";
    public static final String FIELD_ITEMPSSYSPFPLUGINNAME = "itempssyspfpluginname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_LVTAG = "lvtag";
    public static final String FIELD_LVTAG2 = "lvtag2";
    public static final String FIELD_LVTAG3 = "lvtag3";
    public static final String FIELD_LVTAG4 = "lvtag4";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORSORTDIR = "minorsortdir";
    public static final String FIELD_MINORSORTPSDEFID = "minorsortpsdefid";
    public static final String FIELD_MINORSORTPSDEFNAME = "minorsortpsdefname";
    public static final String FIELD_MOBLISTSTYLE = "mobliststyle";
    public static final String FIELD_NAVPSDERID = "navpsderid";
    public static final String FIELD_NAVPSDERNAME = "navpsdername";
    public static final String FIELD_NAVPSDEVIEWBASEID = "navpsdeviewbaseid";
    public static final String FIELD_NAVPSDEVIEWBASENAME = "navpsdeviewbasename";
    public static final String FIELD_NAVVIEWFILTER = "navviewfilter";
    public static final String FIELD_NAVVIEWPARAM = "navviewparam";
    public static final String FIELD_NO2PSDEUAGROUPID = "no2psdeuagroupid";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "no2psdeuagroupname";
    public static final String FIELD_NOSORT = "nosort";
    public static final String FIELD_ORDERVALUEPSDEFID = "ordervaluepsdefid";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ordervaluepsdefname";
    public static final String FIELD_PAGESIZE = "pagesize";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELISTID = "psdelistid";
    public static final String FIELD_PSDELISTNAME = "psdelistname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_QUICKPSDETOOLBARID = "quickpsdetoolbarid";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "quickpsdetoolbarname";
    public static final String FIELD_SHOWHEADER = "showheader";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    private List<PSDEListItemDTO> psdelistitems;
    private List<PSDEListLogicDTO> psdelistlogics;

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
    public String getLVTag() {
        Object objValue = this.get(FIELD_LVTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lvtag")
    public void setLVTag(String lVTag) {
        this.set(FIELD_LVTAG, lVTag);
    }

    @JsonIgnore
    public boolean isLVTagDirty() {
        return this.contains(FIELD_LVTAG);
    }

    @JsonIgnore
    public String getLVTag2() {
        Object objValue = this.get(FIELD_LVTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lvtag2")
    public void setLVTag2(String lVTag2) {
        this.set(FIELD_LVTAG2, lVTag2);
    }

    @JsonIgnore
    public boolean isLVTag2Dirty() {
        return this.contains(FIELD_LVTAG2);
    }

    @JsonIgnore
    public String getLVTag3() {
        Object objValue = this.get(FIELD_LVTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lvtag3")
    public void setLVTag3(String lVTag3) {
        this.set(FIELD_LVTAG3, lVTag3);
    }

    @JsonIgnore
    public boolean isLVTag3Dirty() {
        return this.contains(FIELD_LVTAG3);
    }

    @JsonIgnore
    public String getLVTag4() {
        Object objValue = this.get(FIELD_LVTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lvtag4")
    public void setLVTag4(String lVTag4) {
        this.set(FIELD_LVTAG4, lVTag4);
    }

    @JsonIgnore
    public boolean isLVTag4Dirty() {
        return this.contains(FIELD_LVTAG4);
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
    public String getMobListStyle() {
        Object objValue = this.get(FIELD_MOBLISTSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobliststyle")
    public void setMobListStyle(String mobListStyle) {
        this.set(FIELD_MOBLISTSTYLE, mobListStyle);
    }

    @JsonIgnore
    public boolean isMobListStyleDirty() {
        return this.contains(FIELD_MOBLISTSTYLE);
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
    public String getNo2PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupid")
    public void setNo2PSDEUAGroupId(String no2PSDEUAGroupId) {
        this.set(FIELD_NO2PSDEUAGROUPID, no2PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo2PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo2PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO2PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no2psdeuagroupname")
    public void setNo2PSDEUAGroupName(String no2PSDEUAGroupName) {
        this.set(FIELD_NO2PSDEUAGROUPNAME, no2PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo2PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO2PSDEUAGROUPNAME);
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
    public Integer getPageSize() {
        Object objValue = this.get(FIELD_PAGESIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pagesize")
    public void setPageSize(Integer pageSize) {
        this.set(FIELD_PAGESIZE, pageSize);
    }

    @JsonIgnore
    public boolean isPageSizeDirty() {
        return this.contains(FIELD_PAGESIZE);
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
    public String getPSDEDSId() {
        Object objValue = this.get(FIELD_PSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid")
    public void setPSDEDSId(String pSDEDSId) {
        this.set(FIELD_PSDEDSID, pSDEDSId);
    }

    @JsonIgnore
    public boolean isPSDEDSIdDirty() {
        return this.contains(FIELD_PSDEDSID);
    }

    @JsonIgnore
    public String getPSDEDSName() {
        Object objValue = this.get(FIELD_PSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname")
    public void setPSDEDSName(String pSDEDSName) {
        this.set(FIELD_PSDEDSNAME, pSDEDSName);
    }

    @JsonIgnore
    public boolean isPSDEDSNameDirty() {
        return this.contains(FIELD_PSDEDSNAME);
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
    public String getPSSysReqItemId() {
        Object objValue = this.get(FIELD_PSSYSREQITEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemid")
    public void setPSSysReqItemId(String pSSysReqItemId) {
        this.set(FIELD_PSSYSREQITEMID, pSSysReqItemId);
    }

    @JsonIgnore
    public boolean isPSSysReqItemIdDirty() {
        return this.contains(FIELD_PSSYSREQITEMID);
    }

    @JsonIgnore
    public String getPSSysReqItemName() {
        Object objValue = this.get(FIELD_PSSYSREQITEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysreqitemname")
    public void setPSSysReqItemName(String pSSysReqItemName) {
        this.set(FIELD_PSSYSREQITEMNAME, pSSysReqItemName);
    }

    @JsonIgnore
    public boolean isPSSysReqItemNameDirty() {
        return this.contains(FIELD_PSSYSREQITEMNAME);
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
    public Integer getShowHeader() {
        Object objValue = this.get(FIELD_SHOWHEADER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showheader")
    public void setShowHeader(Integer showHeader) {
        this.set(FIELD_SHOWHEADER, showHeader);
    }

    @JsonIgnore
    public boolean isShowHeaderDirty() {
        return this.contains(FIELD_SHOWHEADER);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEListId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEListId(strValue);
    }

    @JsonProperty(value="psdelistitems")
    public List<PSDEListItemDTO> getPsdelistitems() {
        return this.psdelistitems;
    }

    @JsonProperty(value="psdelistitems")
    public void setPsdelistitems(List<PSDEListItemDTO> psdelistitems) {
        this.psdelistitems = psdelistitems;
    }

    @JsonProperty(value="psdelistlogics")
    public List<PSDEListLogicDTO> getPsdelistlogics() {
        return this.psdelistlogics;
    }

    @JsonProperty(value="psdelistlogics")
    public void setPsdelistlogics(List<PSDEListLogicDTO> psdelistlogics) {
        this.psdelistlogics = psdelistlogics;
    }
}

