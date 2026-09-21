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
import net.ibizsys.modelapi.dto.PSDETBItemDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarLogicDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEToolbarDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ICONALIGN = "iconalign";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_NO2PSDEUAGROUPID = "no2psdeuagroupid";
    public static final String FIELD_NO2PSDEUAGROUPNAME = "no2psdeuagroupname";
    public static final String FIELD_NO3PSDEUAGROUPID = "no3psdeuagroupid";
    public static final String FIELD_NO3PSDEUAGROUPNAME = "no3psdeuagroupname";
    public static final String FIELD_NO4PSDEUAGROUPID = "no4psdeuagroupid";
    public static final String FIELD_NO4PSDEUAGROUPNAME = "no4psdeuagroupname";
    public static final String FIELD_NO5PSDEUAGROUPID = "no5psdeuagroupid";
    public static final String FIELD_NO5PSDEUAGROUPNAME = "no5psdeuagroupname";
    public static final String FIELD_NO6PSDEUAGROUPID = "no6psdeuagroupid";
    public static final String FIELD_NO6PSDEUAGROUPNAME = "no6psdeuagroupname";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDETOOLBARID = "psdetoolbarid";
    public static final String FIELD_PSDETOOLBARNAME = "psdetoolbarname";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSTOOLBARID = "pssystoolbarid";
    public static final String FIELD_PSSYSTOOLBARNAME = "pssystoolbarname";
    public static final String FIELD_TEMPLTOOLBAR = "templtoolbar";
    public static final String FIELD_TOOLBARSN = "toolbarsn";
    public static final String FIELD_TOOLBARSTYLE = "toolbarstyle";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    private List<PSDETBItemDTO> psdetbitems;
    private List<PSDEToolbarLogicDTO> psdetoolbarlogics;

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
    public String getNo3PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO3PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeuagroupid")
    public void setNo3PSDEUAGroupId(String no3PSDEUAGroupId) {
        this.set(FIELD_NO3PSDEUAGROUPID, no3PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo3PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO3PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo3PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO3PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no3psdeuagroupname")
    public void setNo3PSDEUAGroupName(String no3PSDEUAGroupName) {
        this.set(FIELD_NO3PSDEUAGROUPNAME, no3PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo3PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO3PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNo4PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO4PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeuagroupid")
    public void setNo4PSDEUAGroupId(String no4PSDEUAGroupId) {
        this.set(FIELD_NO4PSDEUAGROUPID, no4PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo4PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO4PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo4PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO4PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no4psdeuagroupname")
    public void setNo4PSDEUAGroupName(String no4PSDEUAGroupName) {
        this.set(FIELD_NO4PSDEUAGROUPNAME, no4PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo4PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO4PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNo5PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO5PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no5psdeuagroupid")
    public void setNo5PSDEUAGroupId(String no5PSDEUAGroupId) {
        this.set(FIELD_NO5PSDEUAGROUPID, no5PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo5PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO5PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo5PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO5PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no5psdeuagroupname")
    public void setNo5PSDEUAGroupName(String no5PSDEUAGroupName) {
        this.set(FIELD_NO5PSDEUAGROUPNAME, no5PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo5PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO5PSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getNo6PSDEUAGroupId() {
        Object objValue = this.get(FIELD_NO6PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no6psdeuagroupid")
    public void setNo6PSDEUAGroupId(String no6PSDEUAGroupId) {
        this.set(FIELD_NO6PSDEUAGROUPID, no6PSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isNo6PSDEUAGroupIdDirty() {
        return this.contains(FIELD_NO6PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getNo6PSDEUAGroupName() {
        Object objValue = this.get(FIELD_NO6PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="no6psdeuagroupname")
    public void setNo6PSDEUAGroupName(String no6PSDEUAGroupName) {
        this.set(FIELD_NO6PSDEUAGROUPNAME, no6PSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isNo6PSDEUAGroupNameDirty() {
        return this.contains(FIELD_NO6PSDEUAGROUPNAME);
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
    public String getPSSysToolbarId() {
        Object objValue = this.get(FIELD_PSSYSTOOLBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystoolbarid")
    public void setPSSysToolbarId(String pSSysToolbarId) {
        this.set(FIELD_PSSYSTOOLBARID, pSSysToolbarId);
    }

    @JsonIgnore
    public boolean isPSSysToolbarIdDirty() {
        return this.contains(FIELD_PSSYSTOOLBARID);
    }

    @JsonIgnore
    public String getPSSysToolbarName() {
        Object objValue = this.get(FIELD_PSSYSTOOLBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystoolbarname")
    public void setPSSysToolbarName(String pSSysToolbarName) {
        this.set(FIELD_PSSYSTOOLBARNAME, pSSysToolbarName);
    }

    @JsonIgnore
    public boolean isPSSysToolbarNameDirty() {
        return this.contains(FIELD_PSSYSTOOLBARNAME);
    }

    @JsonIgnore
    public Integer getTemplToolbar() {
        Object objValue = this.get(FIELD_TEMPLTOOLBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="templtoolbar")
    public void setTemplToolbar(Integer templToolbar) {
        this.set(FIELD_TEMPLTOOLBAR, templToolbar);
    }

    @JsonIgnore
    public boolean isTemplToolbarDirty() {
        return this.contains(FIELD_TEMPLTOOLBAR);
    }

    @JsonIgnore
    public String getToolbarSN() {
        Object objValue = this.get(FIELD_TOOLBARSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="toolbarsn")
    public void setToolbarSN(String toolbarSN) {
        this.set(FIELD_TOOLBARSN, toolbarSN);
    }

    @JsonIgnore
    public boolean isToolbarSNDirty() {
        return this.contains(FIELD_TOOLBARSN);
    }

    @JsonIgnore
    public String getToolbarStyle() {
        Object objValue = this.get(FIELD_TOOLBARSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="toolbarstyle")
    public void setToolbarStyle(String toolbarStyle) {
        this.set(FIELD_TOOLBARSTYLE, toolbarStyle);
    }

    @JsonIgnore
    public boolean isToolbarStyleDirty() {
        return this.contains(FIELD_TOOLBARSTYLE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEToolbarId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEToolbarId(strValue);
    }

    @JsonProperty(value="psdetbitems")
    public List<PSDETBItemDTO> getPsdetbitems() {
        return this.psdetbitems;
    }

    @JsonProperty(value="psdetbitems")
    public void setPsdetbitems(List<PSDETBItemDTO> psdetbitems) {
        this.psdetbitems = psdetbitems;
    }

    @JsonProperty(value="psdetoolbarlogics")
    public List<PSDEToolbarLogicDTO> getPsdetoolbarlogics() {
        return this.psdetoolbarlogics;
    }

    @JsonProperty(value="psdetoolbarlogics")
    public void setPsdetoolbarlogics(List<PSDEToolbarLogicDTO> psdetoolbarlogics) {
        this.psdetoolbarlogics = psdetoolbarlogics;
    }
}

