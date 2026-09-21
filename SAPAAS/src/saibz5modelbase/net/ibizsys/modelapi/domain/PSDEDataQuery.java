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
import net.ibizsys.modelapi.domain.PSDEDQCode;
import net.ibizsys.modelapi.domain.PSDEDQJoin;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDataQuery
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DQSN = "dqsn";
    public static final String FIELD_DQTAG = "dqtag";
    public static final String FIELD_DQTAG2 = "dqtag2";
    public static final String FIELD_DQTAG3 = "dqtag3";
    public static final String FIELD_DQTAG4 = "dqtag4";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PRIVMODE = "privmode";
    public static final String FIELD_PSDEDATAQUERYID = "psdedataqueryid";
    public static final String FIELD_PSDEDATAQUERYNAME = "psdedataqueryname";
    public static final String FIELD_PSDEFGROUPID = "psdefgroupid";
    public static final String FIELD_PSDEFGROUPNAME = "psdefgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PUBMODE = "pubmode";
    public static final String FIELD_QUERYVIEWFLAG = "queryviewflag";
    public static final String FIELD_REQUESTMETHOD = "requestmethod";
    public static final String FIELD_REQUESTPATH = "requestpath";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_VIEWCOLLEVEL = "viewcollevel";
    private List<PSDEDQCode> psdedqcodes;
    private List<PSDEDQJoin> psdedqjoins;

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
    public Integer getCustomMode() {
        Object objValue = this.get(FIELD_CUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="custommode")
    public void setCustomMode(Integer customMode) {
        this.set(FIELD_CUSTOMMODE, customMode);
    }

    @JsonIgnore
    public boolean isCustomModeDirty() {
        return this.contains(FIELD_CUSTOMMODE);
    }

    @JsonIgnore
    public Integer getDefaultMode() {
        Object objValue = this.get(FIELD_DEFAULTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultmode")
    public void setDefaultMode(Integer defaultMode) {
        this.set(FIELD_DEFAULTMODE, defaultMode);
    }

    @JsonIgnore
    public boolean isDefaultModeDirty() {
        return this.contains(FIELD_DEFAULTMODE);
    }

    @JsonIgnore
    public String getDQSN() {
        Object objValue = this.get(FIELD_DQSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dqsn")
    public void setDQSN(String dQSN) {
        this.set(FIELD_DQSN, dQSN);
    }

    @JsonIgnore
    public boolean isDQSNDirty() {
        return this.contains(FIELD_DQSN);
    }

    @JsonIgnore
    public String getDQTag() {
        Object objValue = this.get(FIELD_DQTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dqtag")
    public void setDQTag(String dQTag) {
        this.set(FIELD_DQTAG, dQTag);
    }

    @JsonIgnore
    public boolean isDQTagDirty() {
        return this.contains(FIELD_DQTAG);
    }

    @JsonIgnore
    public String getDQTag2() {
        Object objValue = this.get(FIELD_DQTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dqtag2")
    public void setDQTag2(String dQTag2) {
        this.set(FIELD_DQTAG2, dQTag2);
    }

    @JsonIgnore
    public boolean isDQTag2Dirty() {
        return this.contains(FIELD_DQTAG2);
    }

    @JsonIgnore
    public String getDQTag3() {
        Object objValue = this.get(FIELD_DQTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dqtag3")
    public void setDQTag3(String dQTag3) {
        this.set(FIELD_DQTAG3, dQTag3);
    }

    @JsonIgnore
    public boolean isDQTag3Dirty() {
        return this.contains(FIELD_DQTAG3);
    }

    @JsonIgnore
    public String getDQTag4() {
        Object objValue = this.get(FIELD_DQTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dqtag4")
    public void setDQTag4(String dQTag4) {
        this.set(FIELD_DQTAG4, dQTag4);
    }

    @JsonIgnore
    public boolean isDQTag4Dirty() {
        return this.contains(FIELD_DQTAG4);
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
    public Integer getPrivMode() {
        Object objValue = this.get(FIELD_PRIVMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="privmode")
    public void setPrivMode(Integer privMode) {
        this.set(FIELD_PRIVMODE, privMode);
    }

    @JsonIgnore
    public boolean isPrivModeDirty() {
        return this.contains(FIELD_PRIVMODE);
    }

    @JsonIgnore
    public String getPSDEDataQueryId() {
        Object objValue = this.get(FIELD_PSDEDATAQUERYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataqueryid")
    public void setPSDEDataQueryId(String pSDEDataQueryId) {
        this.set(FIELD_PSDEDATAQUERYID, pSDEDataQueryId);
    }

    @JsonIgnore
    public boolean isPSDEDataQueryIdDirty() {
        return this.contains(FIELD_PSDEDATAQUERYID);
    }

    @JsonIgnore
    public String getPSDEDataQueryName() {
        Object objValue = this.get(FIELD_PSDEDATAQUERYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedataqueryname")
    public void setPSDEDataQueryName(String pSDEDataQueryName) {
        this.set(FIELD_PSDEDATAQUERYNAME, pSDEDataQueryName);
    }

    @JsonIgnore
    public boolean isPSDEDataQueryNameDirty() {
        return this.contains(FIELD_PSDEDATAQUERYNAME);
    }

    @JsonIgnore
    public String getPSDEFGroupId() {
        Object objValue = this.get(FIELD_PSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupid")
    public void setPSDEFGroupId(String pSDEFGroupId) {
        this.set(FIELD_PSDEFGROUPID, pSDEFGroupId);
    }

    @JsonIgnore
    public boolean isPSDEFGroupIdDirty() {
        return this.contains(FIELD_PSDEFGROUPID);
    }

    @JsonIgnore
    public String getPSDEFGroupName() {
        Object objValue = this.get(FIELD_PSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupname")
    public void setPSDEFGroupName(String pSDEFGroupName) {
        this.set(FIELD_PSDEFGROUPNAME, pSDEFGroupName);
    }

    @JsonIgnore
    public boolean isPSDEFGroupNameDirty() {
        return this.contains(FIELD_PSDEFGROUPNAME);
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
    public String getPSDEMainStateId() {
        Object objValue = this.get(FIELD_PSDEMAINSTATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstateid")
    public void setPSDEMainStateId(String pSDEMainStateId) {
        this.set(FIELD_PSDEMAINSTATEID, pSDEMainStateId);
    }

    @JsonIgnore
    public boolean isPSDEMainStateIdDirty() {
        return this.contains(FIELD_PSDEMAINSTATEID);
    }

    @JsonIgnore
    public String getPSDEMainStateName() {
        Object objValue = this.get(FIELD_PSDEMAINSTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdemainstatename")
    public void setPSDEMainStateName(String pSDEMainStateName) {
        this.set(FIELD_PSDEMAINSTATENAME, pSDEMainStateName);
    }

    @JsonIgnore
    public boolean isPSDEMainStateNameDirty() {
        return this.contains(FIELD_PSDEMAINSTATENAME);
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
    public Integer getPubMode() {
        Object objValue = this.get(FIELD_PUBMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pubmode")
    public void setPubMode(Integer pubMode) {
        this.set(FIELD_PUBMODE, pubMode);
    }

    @JsonIgnore
    public boolean isPubModeDirty() {
        return this.contains(FIELD_PUBMODE);
    }

    @JsonIgnore
    public Integer getQueryViewFlag() {
        Object objValue = this.get(FIELD_QUERYVIEWFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="queryviewflag")
    public void setQueryViewFlag(Integer queryViewFlag) {
        this.set(FIELD_QUERYVIEWFLAG, queryViewFlag);
    }

    @JsonIgnore
    public boolean isQueryViewFlagDirty() {
        return this.contains(FIELD_QUERYVIEWFLAG);
    }

    @JsonIgnore
    public String getRequestMethod() {
        Object objValue = this.get(FIELD_REQUESTMETHOD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestmethod")
    public void setRequestMethod(String requestMethod) {
        this.set(FIELD_REQUESTMETHOD, requestMethod);
    }

    @JsonIgnore
    public boolean isRequestMethodDirty() {
        return this.contains(FIELD_REQUESTMETHOD);
    }

    @JsonIgnore
    public String getRequestPath() {
        Object objValue = this.get(FIELD_REQUESTPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="requestpath")
    public void setRequestPath(String requestPath) {
        this.set(FIELD_REQUESTPATH, requestPath);
    }

    @JsonIgnore
    public boolean isRequestPathDirty() {
        return this.contains(FIELD_REQUESTPATH);
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
    public Integer getViewColLevel() {
        Object objValue = this.get(FIELD_VIEWCOLLEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewcollevel")
    public void setViewColLevel(Integer viewColLevel) {
        this.set(FIELD_VIEWCOLLEVEL, viewColLevel);
    }

    @JsonIgnore
    public boolean isViewColLevelDirty() {
        return this.contains(FIELD_VIEWCOLLEVEL);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEDataQueryId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDataQueryId(strValue);
    }

    public List<PSDEDQCode> getPsdedqcodes() {
        return this.psdedqcodes;
    }

    public void setPsdedqcodes(List<PSDEDQCode> psdedqcodes) {
        this.psdedqcodes = psdedqcodes;
    }

    public List<PSDEDQJoin> getPsdedqjoins() {
        return this.psdedqjoins;
    }

    public void setPsdedqjoins(List<PSDEDQJoin> psdedqjoins) {
        this.psdedqjoins = psdedqjoins;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("psdedqcodes")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdedqjoins")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedqcodes")) {
            this.init();
            return this.psdedqcodes;
        }
        if (strName.equalsIgnoreCase("psdedqjoins")) {
            this.init();
            return this.psdedqjoins;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDATAQUERY";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDataQuery item = (PSDEDataQuery)MAPPER.readValue(new File(strJsonFilePath), PSDEDataQuery.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDataQuery) {
            PSDEDataQuery dst = (PSDEDataQuery)target;
            if (!bSimple && this.getPsdedqjoins() != null) {
                ArrayList<PSDEDQJoin> psdedqjoins = new ArrayList<PSDEDQJoin>();
                for (PSDEDQJoin item : this.getPsdedqjoins()) {
                    if (bDeepMode) {
                        PSDEDQJoin newitem = new PSDEDQJoin();
                        item.to(newitem, false, bDeepMode);
                        psdedqjoins.add(newitem);
                        continue;
                    }
                    psdedqjoins.add(item);
                }
                dst.setPsdedqjoins(psdedqjoins);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDataQuery) {
            PSDEDataQuery src = (PSDEDataQuery)source;
            if (!bSimple && src.getPsdedqjoins() != null) {
                ArrayList<PSDEDQJoin> psdedqjoins = new ArrayList<PSDEDQJoin>();
                for (PSDEDQJoin item : src.getPsdedqjoins()) {
                    if (bDeepMode) {
                        PSDEDQJoin newItem = new PSDEDQJoin();
                        newItem.from(item, false, bDeepMode);
                        psdedqjoins.add(newItem);
                        continue;
                    }
                    psdedqjoins.add(item);
                }
                this.setPsdedqjoins(psdedqjoins);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

