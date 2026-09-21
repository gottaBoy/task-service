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
import net.ibizsys.modelapi.domain.PSDETreeCol;
import net.ibizsys.modelapi.domain.PSDETreeLogic;
import net.ibizsys.modelapi.domain.PSDETreeNode;
import net.ibizsys.modelapi.domain.PSDETreeNodeCol;
import net.ibizsys.modelapi.domain.PSDETreeNodeRS;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDETreeView
extends PSModelBase {
    public static final String FIELD_BUFFERRENDERERMODE = "bufferrenderermode";
    public static final String FIELD_CATPSCODELISTID = "catpscodelistid";
    public static final String FIELD_CATPSCODELISTNAME = "catpscodelistname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EMPTYTEXT = "emptytext";
    public static final String FIELD_EMPTYTEXTPSLANRESID = "emptytextpslanresid";
    public static final String FIELD_EMPTYTEXTPSLANRESNAME = "emptytextpslanresname";
    public static final String FIELD_ENABLESEARCH = "enablesearch";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NOICONDEFAULT = "noicondefault";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_ROOTSELECT = "rootselect";
    public static final String FIELD_SHOWROOT = "showroot";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_TREEGRIDFLAG = "treegridflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    private List<PSDETreeCol> psdetreecols;
    private List<PSDETreeNode> psdetreenodes;
    private List<PSDETreeNodeRS> psdetreenoders;
    private List<PSDETreeLogic> psdetreelogics;
    private List<PSDETreeNodeCol> psdetreenodecols;

    @JsonIgnore
    public Integer getBufferRendererMode() {
        Object objValue = this.get(FIELD_BUFFERRENDERERMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="bufferrenderermode")
    public void setBufferRendererMode(Integer bufferRendererMode) {
        this.set(FIELD_BUFFERRENDERERMODE, bufferRendererMode);
    }

    @JsonIgnore
    public boolean isBufferRendererModeDirty() {
        return this.contains(FIELD_BUFFERRENDERERMODE);
    }

    @JsonIgnore
    public String getCatPSCodeListId() {
        Object objValue = this.get(FIELD_CATPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="catpscodelistid")
    public void setCatPSCodeListId(String catPSCodeListId) {
        this.set(FIELD_CATPSCODELISTID, catPSCodeListId);
    }

    @JsonIgnore
    public boolean isCatPSCodeListIdDirty() {
        return this.contains(FIELD_CATPSCODELISTID);
    }

    @JsonIgnore
    public String getCatPSCodeListName() {
        Object objValue = this.get(FIELD_CATPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="catpscodelistname")
    public void setCatPSCodeListName(String catPSCodeListName) {
        this.set(FIELD_CATPSCODELISTNAME, catPSCodeListName);
    }

    @JsonIgnore
    public boolean isCatPSCodeListNameDirty() {
        return this.contains(FIELD_CATPSCODELISTNAME);
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
    public Integer getEnableSearch() {
        Object objValue = this.get(FIELD_ENABLESEARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesearch")
    public void setEnableSearch(Integer enableSearch) {
        this.set(FIELD_ENABLESEARCH, enableSearch);
    }

    @JsonIgnore
    public boolean isEnableSearchDirty() {
        return this.contains(FIELD_ENABLESEARCH);
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
    public Integer getNoIconDefault() {
        Object objValue = this.get(FIELD_NOICONDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="noicondefault")
    public void setNoIconDefault(Integer noIconDefault) {
        this.set(FIELD_NOICONDEFAULT, noIconDefault);
    }

    @JsonIgnore
    public boolean isNoIconDefaultDirty() {
        return this.contains(FIELD_NOICONDEFAULT);
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
    public Integer getRootSelect() {
        Object objValue = this.get(FIELD_ROOTSELECT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rootselect")
    public void setRootSelect(Integer rootSelect) {
        this.set(FIELD_ROOTSELECT, rootSelect);
    }

    @JsonIgnore
    public boolean isRootSelectDirty() {
        return this.contains(FIELD_ROOTSELECT);
    }

    @JsonIgnore
    public Integer getShowRoot() {
        Object objValue = this.get(FIELD_SHOWROOT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showroot")
    public void setShowRoot(Integer showRoot) {
        this.set(FIELD_SHOWROOT, showRoot);
    }

    @JsonIgnore
    public boolean isShowRootDirty() {
        return this.contains(FIELD_SHOWROOT);
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
    public Integer getTreeGridFlag() {
        Object objValue = this.get(FIELD_TREEGRIDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="treegridflag")
    public void setTreeGridFlag(Integer treeGridFlag) {
        this.set(FIELD_TREEGRIDFLAG, treeGridFlag);
    }

    @JsonIgnore
    public boolean isTreeGridFlagDirty() {
        return this.contains(FIELD_TREEGRIDFLAG);
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
        return this.getPSDETreeViewId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDETreeViewId(strValue);
    }

    public List<PSDETreeCol> getPsdetreecols() {
        return this.psdetreecols;
    }

    public void setPsdetreecols(List<PSDETreeCol> psdetreecols) {
        this.psdetreecols = psdetreecols;
    }

    public List<PSDETreeNode> getPsdetreenodes() {
        return this.psdetreenodes;
    }

    public void setPsdetreenodes(List<PSDETreeNode> psdetreenodes) {
        this.psdetreenodes = psdetreenodes;
    }

    public List<PSDETreeNodeRS> getPsdetreenoders() {
        return this.psdetreenoders;
    }

    public void setPsdetreenoders(List<PSDETreeNodeRS> psdetreenoders) {
        this.psdetreenoders = psdetreenoders;
    }

    public List<PSDETreeLogic> getPsdetreelogics() {
        return this.psdetreelogics;
    }

    public void setPsdetreelogics(List<PSDETreeLogic> psdetreelogics) {
        this.psdetreelogics = psdetreelogics;
    }

    public List<PSDETreeNodeCol> getPsdetreenodecols() {
        return this.psdetreenodecols;
    }

    public void setPsdetreenodecols(List<PSDETreeNodeCol> psdetreenodecols) {
        this.psdetreenodecols = psdetreenodecols;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdetreecols")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetreenodes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetreenoders")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetreelogics")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdetreenodecols")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdetreecols")) {
            this.init();
            return this.psdetreecols;
        }
        if (strName.equalsIgnoreCase("psdetreenodes")) {
            this.init();
            return this.psdetreenodes;
        }
        if (strName.equalsIgnoreCase("psdetreenoders")) {
            this.init();
            return this.psdetreenoders;
        }
        if (strName.equalsIgnoreCase("psdetreelogics")) {
            this.init();
            return this.psdetreelogics;
        }
        if (strName.equalsIgnoreCase("psdetreenodecols")) {
            this.init();
            return this.psdetreenodecols;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDETREEVIEW";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDETreeView item = (PSDETreeView)MAPPER.readValue(new File(strJsonFilePath), PSDETreeView.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDETreeView) {
            PSDETreeView dst = (PSDETreeView)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPsdetreecols() != null) {
                    ArrayList<PSDETreeCol> psdetreecols = new ArrayList<PSDETreeCol>();
                    for (PSDETreeCol pSDETreeCol : this.getPsdetreecols()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeCol();
                            pSDETreeCol.to(newitem, false, bDeepMode);
                            psdetreecols.add((PSDETreeCol)newitem);
                            continue;
                        }
                        psdetreecols.add(pSDETreeCol);
                    }
                    dst.setPsdetreecols(psdetreecols);
                }
                if (this.getPsdetreenodes() != null) {
                    ArrayList<PSDETreeNode> psdetreenodes = new ArrayList<PSDETreeNode>();
                    for (PSDETreeNode pSDETreeNode : this.getPsdetreenodes()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeNode();
                            pSDETreeNode.to(newitem, false, bDeepMode);
                            psdetreenodes.add((PSDETreeNode)newitem);
                            continue;
                        }
                        psdetreenodes.add(pSDETreeNode);
                    }
                    dst.setPsdetreenodes(psdetreenodes);
                }
                if (this.getPsdetreenoders() != null) {
                    ArrayList<PSDETreeNodeRS> psdetreenoders = new ArrayList<PSDETreeNodeRS>();
                    for (PSDETreeNodeRS pSDETreeNodeRS : this.getPsdetreenoders()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeNodeRS();
                            pSDETreeNodeRS.to(newitem, false, bDeepMode);
                            psdetreenoders.add((PSDETreeNodeRS)newitem);
                            continue;
                        }
                        psdetreenoders.add(pSDETreeNodeRS);
                    }
                    dst.setPsdetreenoders(psdetreenoders);
                }
                if (this.getPsdetreelogics() != null) {
                    ArrayList<PSDETreeLogic> psdetreelogics = new ArrayList<PSDETreeLogic>();
                    for (PSDETreeLogic pSDETreeLogic : this.getPsdetreelogics()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeLogic();
                            pSDETreeLogic.to(newitem, false, bDeepMode);
                            psdetreelogics.add((PSDETreeLogic)newitem);
                            continue;
                        }
                        psdetreelogics.add(pSDETreeLogic);
                    }
                    dst.setPsdetreelogics(psdetreelogics);
                }
                if (this.getPsdetreenodecols() != null) {
                    ArrayList<PSDETreeNodeCol> psdetreenodecols = new ArrayList<PSDETreeNodeCol>();
                    for (PSDETreeNodeCol pSDETreeNodeCol : this.getPsdetreenodecols()) {
                        if (bDeepMode) {
                            newitem = new PSDETreeNodeCol();
                            pSDETreeNodeCol.to(newitem, false, bDeepMode);
                            psdetreenodecols.add((PSDETreeNodeCol)newitem);
                            continue;
                        }
                        psdetreenodecols.add(pSDETreeNodeCol);
                    }
                    dst.setPsdetreenodecols(psdetreenodecols);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDETreeView) {
            PSDETreeView src = (PSDETreeView)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPsdetreecols() != null) {
                    ArrayList<PSDETreeCol> psdetreecols = new ArrayList<PSDETreeCol>();
                    for (PSDETreeCol pSDETreeCol : src.getPsdetreecols()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeCol();
                            ((PSDETreeCol)newItem).from(pSDETreeCol, false, bDeepMode);
                            psdetreecols.add((PSDETreeCol)newItem);
                            continue;
                        }
                        psdetreecols.add(pSDETreeCol);
                    }
                    this.setPsdetreecols(psdetreecols);
                }
                if (src.getPsdetreenodes() != null) {
                    ArrayList<PSDETreeNode> psdetreenodes = new ArrayList<PSDETreeNode>();
                    for (PSDETreeNode pSDETreeNode : src.getPsdetreenodes()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeNode();
                            ((PSDETreeNode)newItem).from(pSDETreeNode, false, bDeepMode);
                            psdetreenodes.add((PSDETreeNode)newItem);
                            continue;
                        }
                        psdetreenodes.add(pSDETreeNode);
                    }
                    this.setPsdetreenodes(psdetreenodes);
                }
                if (src.getPsdetreenoders() != null) {
                    ArrayList<PSDETreeNodeRS> psdetreenoders = new ArrayList<PSDETreeNodeRS>();
                    for (PSDETreeNodeRS pSDETreeNodeRS : src.getPsdetreenoders()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeNodeRS();
                            ((PSDETreeNodeRS)newItem).from(pSDETreeNodeRS, false, bDeepMode);
                            psdetreenoders.add((PSDETreeNodeRS)newItem);
                            continue;
                        }
                        psdetreenoders.add(pSDETreeNodeRS);
                    }
                    this.setPsdetreenoders(psdetreenoders);
                }
                if (src.getPsdetreelogics() != null) {
                    ArrayList<PSDETreeLogic> psdetreelogics = new ArrayList<PSDETreeLogic>();
                    for (PSDETreeLogic pSDETreeLogic : src.getPsdetreelogics()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeLogic();
                            ((PSDETreeLogic)newItem).from(pSDETreeLogic, false, bDeepMode);
                            psdetreelogics.add((PSDETreeLogic)newItem);
                            continue;
                        }
                        psdetreelogics.add(pSDETreeLogic);
                    }
                    this.setPsdetreelogics(psdetreelogics);
                }
                if (src.getPsdetreenodecols() != null) {
                    ArrayList<PSDETreeNodeCol> psdetreenodecols = new ArrayList<PSDETreeNodeCol>();
                    for (PSDETreeNodeCol pSDETreeNodeCol : src.getPsdetreenodecols()) {
                        if (bDeepMode) {
                            newItem = new PSDETreeNodeCol();
                            ((PSDETreeNodeCol)newItem).from(pSDETreeNodeCol, false, bDeepMode);
                            psdetreenodecols.add((PSDETreeNodeCol)newItem);
                            continue;
                        }
                        psdetreenodecols.add(pSDETreeNodeCol);
                    }
                    this.setPsdetreenodecols(psdetreenodecols);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

