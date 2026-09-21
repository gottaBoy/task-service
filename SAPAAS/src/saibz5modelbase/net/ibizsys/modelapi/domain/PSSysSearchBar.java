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
import net.ibizsys.modelapi.domain.PSSysSearchBarItem;
import net.ibizsys.modelapi.domain.PSSysSearchBarLogic;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysSearchBar
extends PSModelBase {
    public static final String FIELD_BARSTYLE = "barstyle";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENABLEQUICKSEARCH = "enablequicksearch";
    public static final String FIELD_GROUPMORETEXT = "groupmoretext";
    public static final String FIELD_GROUPMORETEXTPSLANRESID = "groupmoretextpslanresid";
    public static final String FIELD_GROUPMORETEXTPSLANRESNAME = "groupmoretextpslanresname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSEARCHBARID = "pssyssearchbarid";
    public static final String FIELD_PSSYSSEARCHBARNAME = "pssyssearchbarname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_QUICKGROUPCNT = "quickgroupcnt";
    public static final String FIELD_QUICKSEARCHWIDTH = "quicksearchwidth";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    private List<PSSysSearchBarItem> pssyssearchbaritems;
    private List<PSSysSearchBarLogic> pssyssearchbarlogics;

    @JsonIgnore
    public String getBarStyle() {
        Object objValue = this.get(FIELD_BARSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="barstyle")
    public void setBarStyle(String barStyle) {
        this.set(FIELD_BARSTYLE, barStyle);
    }

    @JsonIgnore
    public boolean isBarStyleDirty() {
        return this.contains(FIELD_BARSTYLE);
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
    public Integer getEnableQuickSearch() {
        Object objValue = this.get(FIELD_ENABLEQUICKSEARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablequicksearch")
    public void setEnableQuickSearch(Integer enableQuickSearch) {
        this.set(FIELD_ENABLEQUICKSEARCH, enableQuickSearch);
    }

    @JsonIgnore
    public boolean isEnableQuickSearchDirty() {
        return this.contains(FIELD_ENABLEQUICKSEARCH);
    }

    @JsonIgnore
    public String getGroupMoreText() {
        Object objValue = this.get(FIELD_GROUPMORETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupmoretext")
    public void setGroupMoreText(String groupMoreText) {
        this.set(FIELD_GROUPMORETEXT, groupMoreText);
    }

    @JsonIgnore
    public boolean isGroupMoreTextDirty() {
        return this.contains(FIELD_GROUPMORETEXT);
    }

    @JsonIgnore
    public String getGroupMoreTextPSLanResId() {
        Object objValue = this.get(FIELD_GROUPMORETEXTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupmoretextpslanresid")
    public void setGroupMoreTextPSLanResId(String groupMoreTextPSLanResId) {
        this.set(FIELD_GROUPMORETEXTPSLANRESID, groupMoreTextPSLanResId);
    }

    @JsonIgnore
    public boolean isGroupMoreTextPSLanResIdDirty() {
        return this.contains(FIELD_GROUPMORETEXTPSLANRESID);
    }

    @JsonIgnore
    public String getGroupMoreTextPSLanResName() {
        Object objValue = this.get(FIELD_GROUPMORETEXTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupmoretextpslanresname")
    public void setGroupMoreTextPSLanResName(String groupMoreTextPSLanResName) {
        this.set(FIELD_GROUPMORETEXTPSLANRESNAME, groupMoreTextPSLanResName);
    }

    @JsonIgnore
    public boolean isGroupMoreTextPSLanResNameDirty() {
        return this.contains(FIELD_GROUPMORETEXTPSLANRESNAME);
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
    public Integer getQuickGroupCnt() {
        Object objValue = this.get(FIELD_QUICKGROUPCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="quickgroupcnt")
    public void setQuickGroupCnt(Integer quickGroupCnt) {
        this.set(FIELD_QUICKGROUPCNT, quickGroupCnt);
    }

    @JsonIgnore
    public boolean isQuickGroupCntDirty() {
        return this.contains(FIELD_QUICKGROUPCNT);
    }

    @JsonIgnore
    public Integer getQuickSearchWidth() {
        Object objValue = this.get(FIELD_QUICKSEARCHWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="quicksearchwidth")
    public void setQuickSearchWidth(Integer quickSearchWidth) {
        this.set(FIELD_QUICKSEARCHWIDTH, quickSearchWidth);
    }

    @JsonIgnore
    public boolean isQuickSearchWidthDirty() {
        return this.contains(FIELD_QUICKSEARCHWIDTH);
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
    public String getSrfkey() {
        return this.getPSSysSearchBarId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysSearchBarId(strValue);
    }

    public List<PSSysSearchBarItem> getPssyssearchbaritems() {
        return this.pssyssearchbaritems;
    }

    public void setPssyssearchbaritems(List<PSSysSearchBarItem> pssyssearchbaritems) {
        this.pssyssearchbaritems = pssyssearchbaritems;
    }

    public List<PSSysSearchBarLogic> getPssyssearchbarlogics() {
        return this.pssyssearchbarlogics;
    }

    public void setPssyssearchbarlogics(List<PSSysSearchBarLogic> pssyssearchbarlogics) {
        this.pssyssearchbarlogics = pssyssearchbarlogics;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyssearchbaritems")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssyssearchbarlogics")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyssearchbaritems")) {
            this.init();
            return this.pssyssearchbaritems;
        }
        if (strName.equalsIgnoreCase("pssyssearchbarlogics")) {
            this.init();
            return this.pssyssearchbarlogics;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSSEARCHBAR";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysSearchBar item = (PSSysSearchBar)MAPPER.readValue(new File(strJsonFilePath), PSSysSearchBar.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysSearchBar) {
            PSSysSearchBar dst = (PSSysSearchBar)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssyssearchbaritems() != null) {
                    ArrayList<PSSysSearchBarItem> pssyssearchbaritems = new ArrayList<PSSysSearchBarItem>();
                    for (PSSysSearchBarItem pSSysSearchBarItem : this.getPssyssearchbaritems()) {
                        if (bDeepMode) {
                            newitem = new PSSysSearchBarItem();
                            pSSysSearchBarItem.to(newitem, false, bDeepMode);
                            pssyssearchbaritems.add((PSSysSearchBarItem)newitem);
                            continue;
                        }
                        pssyssearchbaritems.add(pSSysSearchBarItem);
                    }
                    dst.setPssyssearchbaritems(pssyssearchbaritems);
                }
                if (this.getPssyssearchbarlogics() != null) {
                    ArrayList<PSSysSearchBarLogic> pssyssearchbarlogics = new ArrayList<PSSysSearchBarLogic>();
                    for (PSSysSearchBarLogic pSSysSearchBarLogic : this.getPssyssearchbarlogics()) {
                        if (bDeepMode) {
                            newitem = new PSSysSearchBarLogic();
                            pSSysSearchBarLogic.to(newitem, false, bDeepMode);
                            pssyssearchbarlogics.add((PSSysSearchBarLogic)newitem);
                            continue;
                        }
                        pssyssearchbarlogics.add(pSSysSearchBarLogic);
                    }
                    dst.setPssyssearchbarlogics(pssyssearchbarlogics);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysSearchBar) {
            PSSysSearchBar src = (PSSysSearchBar)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssyssearchbaritems() != null) {
                    ArrayList<PSSysSearchBarItem> pssyssearchbaritems = new ArrayList<PSSysSearchBarItem>();
                    for (PSSysSearchBarItem pSSysSearchBarItem : src.getPssyssearchbaritems()) {
                        if (bDeepMode) {
                            newItem = new PSSysSearchBarItem();
                            ((PSSysSearchBarItem)newItem).from(pSSysSearchBarItem, false, bDeepMode);
                            pssyssearchbaritems.add((PSSysSearchBarItem)newItem);
                            continue;
                        }
                        pssyssearchbaritems.add(pSSysSearchBarItem);
                    }
                    this.setPssyssearchbaritems(pssyssearchbaritems);
                }
                if (src.getPssyssearchbarlogics() != null) {
                    ArrayList<PSSysSearchBarLogic> pssyssearchbarlogics = new ArrayList<PSSysSearchBarLogic>();
                    for (PSSysSearchBarLogic pSSysSearchBarLogic : src.getPssyssearchbarlogics()) {
                        if (bDeepMode) {
                            newItem = new PSSysSearchBarLogic();
                            ((PSSysSearchBarLogic)newItem).from(pSSysSearchBarLogic, false, bDeepMode);
                            pssyssearchbarlogics.add((PSSysSearchBarLogic)newItem);
                            continue;
                        }
                        pssyssearchbarlogics.add(pSSysSearchBarLogic);
                    }
                    this.setPssyssearchbarlogics(pssyssearchbarlogics);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

