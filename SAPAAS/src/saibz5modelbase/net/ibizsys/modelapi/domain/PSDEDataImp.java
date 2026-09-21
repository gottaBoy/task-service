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
import net.ibizsys.modelapi.domain.PSDEDataImpItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDataImp
extends PSModelBase {
    public static final String FIELD_ACTIONHOLDER = "actionholder";
    public static final String FIELD_BATCHSIZE = "batchsize";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATEPSDEACTIONID = "createpsdeactionid";
    public static final String FIELD_CREATEPSDEACTIONNAME = "createpsdeactionname";
    public static final String FIELD_CREATEPSDEOPPRIVID = "createpsdeopprivid";
    public static final String FIELD_CREATEPSDEOPPRIVINAME = "createpsdeoppriviname";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_POTIME = "potime";
    public static final String FIELD_PSDEDATAIMPID = "psdedataimpid";
    public static final String FIELD_PSDEDATAIMPNAME = "psdedataimpname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_STOPWHENERROR = "stopwhenerror";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEPSDEACTIONID = "updatepsdeactionid";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "updatepsdeactionname";
    public static final String FIELD_UPDATEPSDEOPPRIVID = "updatepsdeopprivid";
    public static final String FIELD_UPDATEPSDEOPPRIVNAME = "updatepsdeopprivname";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDEDataImpItem> psdedataimpitems;

    @JsonIgnore
    public Integer getActionHolder() {
        Object objValue = this.get(FIELD_ACTIONHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="actionholder")
    public void setActionHolder(Integer actionHolder) {
        this.set(FIELD_ACTIONHOLDER, actionHolder);
    }

    @JsonIgnore
    public boolean isActionHolderDirty() {
        return this.contains(FIELD_ACTIONHOLDER);
    }

    @JsonIgnore
    public Integer getBatchSize() {
        Object objValue = this.get(FIELD_BATCHSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="batchsize")
    public void setBatchSize(Integer batchSize) {
        this.set(FIELD_BATCHSIZE, batchSize);
    }

    @JsonIgnore
    public boolean isBatchSizeDirty() {
        return this.contains(FIELD_BATCHSIZE);
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
    public String getCreatePSDEActionId() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionid")
    public void setCreatePSDEActionId(String createPSDEActionId) {
        this.set(FIELD_CREATEPSDEACTIONID, createPSDEActionId);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionIdDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getCreatePSDEActionName() {
        Object objValue = this.get(FIELD_CREATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeactionname")
    public void setCreatePSDEActionName(String createPSDEActionName) {
        this.set(FIELD_CREATEPSDEACTIONNAME, createPSDEActionName);
    }

    @JsonIgnore
    public boolean isCreatePSDEActionNameDirty() {
        return this.contains(FIELD_CREATEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getCreatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeopprivid")
    public void setCreatePSDEOPPrivId(String createPSDEOPPrivId) {
        this.set(FIELD_CREATEPSDEOPPRIVID, createPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getCreatePSDEOPPrivIName() {
        Object objValue = this.get(FIELD_CREATEPSDEOPPRIVINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createpsdeoppriviname")
    public void setCreatePSDEOPPrivIName(String createPSDEOPPrivIName) {
        this.set(FIELD_CREATEPSDEOPPRIVINAME, createPSDEOPPrivIName);
    }

    @JsonIgnore
    public boolean isCreatePSDEOPPrivINameDirty() {
        return this.contains(FIELD_CREATEPSDEOPPRIVINAME);
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
    public Integer getExtendMode() {
        Object objValue = this.get(FIELD_EXTENDMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendmode")
    public void setExtendMode(Integer extendMode) {
        this.set(FIELD_EXTENDMODE, extendMode);
    }

    @JsonIgnore
    public boolean isExtendModeDirty() {
        return this.contains(FIELD_EXTENDMODE);
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
    public Integer getPOTime() {
        Object objValue = this.get(FIELD_POTIME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="potime")
    public void setPOTime(Integer pOTime) {
        this.set(FIELD_POTIME, pOTime);
    }

    @JsonIgnore
    public boolean isPOTimeDirty() {
        return this.contains(FIELD_POTIME);
    }

    @JsonIgnore
    public String getPSDEDataImpId() {
        Object objValue = this.get(FIELD_PSDEDATAIMPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpid")
    public void setPSDEDataImpId(String pSDEDataImpId) {
        this.set(FIELD_PSDEDATAIMPID, pSDEDataImpId);
    }

    @JsonIgnore
    public boolean isPSDEDataImpIdDirty() {
        return this.contains(FIELD_PSDEDATAIMPID);
    }

    @JsonIgnore
    public String getPSDEDataImpName() {
        Object objValue = this.get(FIELD_PSDEDATAIMPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataimpname")
    public void setPSDEDataImpName(String pSDEDataImpName) {
        this.set(FIELD_PSDEDATAIMPNAME, pSDEDataImpName);
    }

    @JsonIgnore
    public boolean isPSDEDataImpNameDirty() {
        return this.contains(FIELD_PSDEDATAIMPNAME);
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
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
    }

    @JsonIgnore
    public Integer getStopWhenError() {
        Object objValue = this.get(FIELD_STOPWHENERROR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stopwhenerror")
    public void setStopWhenError(Integer stopWhenError) {
        this.set(FIELD_STOPWHENERROR, stopWhenError);
    }

    @JsonIgnore
    public boolean isStopWhenErrorDirty() {
        return this.contains(FIELD_STOPWHENERROR);
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
    public String getUpdatePSDEActionId() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionid")
    public void setUpdatePSDEActionId(String updatePSDEActionId) {
        this.set(FIELD_UPDATEPSDEACTIONID, updatePSDEActionId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionIdDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONID);
    }

    @JsonIgnore
    public String getUpdatePSDEActionName() {
        Object objValue = this.get(FIELD_UPDATEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeactionname")
    public void setUpdatePSDEActionName(String updatePSDEActionName) {
        this.set(FIELD_UPDATEPSDEACTIONNAME, updatePSDEActionName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEActionNameDirty() {
        return this.contains(FIELD_UPDATEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getUpdatePSDEOPPrivId() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivid")
    public void setUpdatePSDEOPPrivId(String updatePSDEOPPrivId) {
        this.set(FIELD_UPDATEPSDEOPPRIVID, updatePSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivIdDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getUpdatePSDEOPPrivName() {
        Object objValue = this.get(FIELD_UPDATEPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updatepsdeopprivname")
    public void setUpdatePSDEOPPrivName(String updatePSDEOPPrivName) {
        this.set(FIELD_UPDATEPSDEOPPRIVNAME, updatePSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isUpdatePSDEOPPrivNameDirty() {
        return this.contains(FIELD_UPDATEPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
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
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
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
    public String getSrfkey() {
        return this.getPSDEDataImpId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDataImpId(strValue);
    }

    public List<PSDEDataImpItem> getPsdedataimpitems() {
        return this.psdedataimpitems;
    }

    public void setPsdedataimpitems(List<PSDEDataImpItem> psdedataimpitems) {
        this.psdedataimpitems = psdedataimpitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdedataimpitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedataimpitems")) {
            this.init();
            return this.psdedataimpitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDATAIMP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDataImp item = (PSDEDataImp)MAPPER.readValue(new File(strJsonFilePath), PSDEDataImp.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDataImp) {
            PSDEDataImp dst = (PSDEDataImp)target;
            if (!bSimple && this.getPsdedataimpitems() != null) {
                ArrayList<PSDEDataImpItem> psdedataimpitems = new ArrayList<PSDEDataImpItem>();
                for (PSDEDataImpItem item : this.getPsdedataimpitems()) {
                    if (bDeepMode) {
                        PSDEDataImpItem newitem = new PSDEDataImpItem();
                        item.to(newitem, false, bDeepMode);
                        psdedataimpitems.add(newitem);
                        continue;
                    }
                    psdedataimpitems.add(item);
                }
                dst.setPsdedataimpitems(psdedataimpitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDataImp) {
            PSDEDataImp src = (PSDEDataImp)source;
            if (!bSimple && src.getPsdedataimpitems() != null) {
                ArrayList<PSDEDataImpItem> psdedataimpitems = new ArrayList<PSDEDataImpItem>();
                for (PSDEDataImpItem item : src.getPsdedataimpitems()) {
                    if (bDeepMode) {
                        PSDEDataImpItem newItem = new PSDEDataImpItem();
                        newItem.from(item, false, bDeepMode);
                        psdedataimpitems.add(newItem);
                        continue;
                    }
                    psdedataimpitems.add(item);
                }
                this.setPsdedataimpitems(psdedataimpitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

