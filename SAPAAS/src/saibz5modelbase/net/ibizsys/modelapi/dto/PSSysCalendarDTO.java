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
import net.ibizsys.modelapi.dto.PSSysCalendarItemDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarLogicDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSSysCalendarDTO
extends PSModelDTOBase {
    public static final String FIELD_BATPSDETOOLBARID = "batpsdetoolbarid";
    public static final String FIELD_BATPSDETOOLBARNAME = "batpsdetoolbarname";
    public static final String FIELD_CALENDARSTYLE = "calendarstyle";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_GANTTFLAG = "ganttflag";
    public static final String FIELD_GANTTPSSYSPFPLUGINID = "ganttpssyspfpluginid";
    public static final String FIELD_GANTTPSSYSPFPLUGINNAME = "ganttpssyspfpluginname";
    public static final String FIELD_GANTTSTYLE = "ganttstyle";
    public static final String FIELD_GROUPHEIGHT = "groupheight";
    public static final String FIELD_GROUPLAYOUT = "grouplayout";
    public static final String FIELD_GROUPMODE = "groupmode";
    public static final String FIELD_GROUPPSCODELISTID = "grouppscodelistid";
    public static final String FIELD_GROUPPSCODELISTNAME = "grouppscodelistname";
    public static final String FIELD_GROUPPSDEFID = "grouppsdefid";
    public static final String FIELD_GROUPPSDEFNAME = "grouppsdefname";
    public static final String FIELD_GROUPPSSYSCSSID = "grouppssyscssid";
    public static final String FIELD_GROUPPSSYSCSSNAME = "grouppssyscssname";
    public static final String FIELD_GROUPPSSYSPFPLUGINID = "grouppssyspfpluginid";
    public static final String FIELD_GROUPPSSYSPFPLUGINNAME = "grouppssyspfpluginname";
    public static final String FIELD_GROUPWIDTH = "groupwidth";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCALENDARID = "pssyscalendarid";
    public static final String FIELD_PSSYSCALENDARNAME = "pssyscalendarname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_QUICKPSDETOOLBARID = "quickpsdetoolbarid";
    public static final String FIELD_QUICKPSDETOOLBARNAME = "quickpsdetoolbarname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSSysCalendarItemDTO> pssyscalendaritems;
    private List<PSSysCalendarLogicDTO> pssyscalendarlogics;

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
    public String getCalendarStyle() {
        Object objValue = this.get(FIELD_CALENDARSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="calendarstyle")
    public void setCalendarStyle(String calendarStyle) {
        this.set(FIELD_CALENDARSTYLE, calendarStyle);
    }

    @JsonIgnore
    public boolean isCalendarStyleDirty() {
        return this.contains(FIELD_CALENDARSTYLE);
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
    public Integer getGanttFlag() {
        Object objValue = this.get(FIELD_GANTTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ganttflag")
    public void setGanttFlag(Integer ganttFlag) {
        this.set(FIELD_GANTTFLAG, ganttFlag);
    }

    @JsonIgnore
    public boolean isGanttFlagDirty() {
        return this.contains(FIELD_GANTTFLAG);
    }

    @JsonIgnore
    public String getGanttPSSysPFPluginId() {
        Object objValue = this.get(FIELD_GANTTPSSYSPFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ganttpssyspfpluginid")
    public void setGanttPSSysPFPluginId(String ganttPSSysPFPluginId) {
        this.set(FIELD_GANTTPSSYSPFPLUGINID, ganttPSSysPFPluginId);
    }

    @JsonIgnore
    public boolean isGanttPSSysPFPluginIdDirty() {
        return this.contains(FIELD_GANTTPSSYSPFPLUGINID);
    }

    @JsonIgnore
    public String getGanttPSSysPFPluginName() {
        Object objValue = this.get(FIELD_GANTTPSSYSPFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ganttpssyspfpluginname")
    public void setGanttPSSysPFPluginName(String ganttPSSysPFPluginName) {
        this.set(FIELD_GANTTPSSYSPFPLUGINNAME, ganttPSSysPFPluginName);
    }

    @JsonIgnore
    public boolean isGanttPSSysPFPluginNameDirty() {
        return this.contains(FIELD_GANTTPSSYSPFPLUGINNAME);
    }

    @JsonIgnore
    public String getGanttStyle() {
        Object objValue = this.get(FIELD_GANTTSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ganttstyle")
    public void setGanttStyle(String ganttStyle) {
        this.set(FIELD_GANTTSTYLE, ganttStyle);
    }

    @JsonIgnore
    public boolean isGanttStyleDirty() {
        return this.contains(FIELD_GANTTSTYLE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysCalendarId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysCalendarId(strValue);
    }

    @JsonProperty(value="pssyscalendaritems")
    public List<PSSysCalendarItemDTO> getPssyscalendaritems() {
        return this.pssyscalendaritems;
    }

    @JsonProperty(value="pssyscalendaritems")
    public void setPssyscalendaritems(List<PSSysCalendarItemDTO> pssyscalendaritems) {
        this.pssyscalendaritems = pssyscalendaritems;
    }

    @JsonProperty(value="pssyscalendarlogics")
    public List<PSSysCalendarLogicDTO> getPssyscalendarlogics() {
        return this.pssyscalendarlogics;
    }

    @JsonProperty(value="pssyscalendarlogics")
    public void setPssyscalendarlogics(List<PSSysCalendarLogicDTO> pssyscalendarlogics) {
        this.pssyscalendarlogics = pssyscalendarlogics;
    }
}

