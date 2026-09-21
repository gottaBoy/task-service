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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEPrint
extends PSModelBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_ENABLECOLPRIV = "enablecolpriv";
    public static final String FIELD_ENABLELOG = "enablelog";
    public static final String FIELD_ENABLEMP = "enablemp";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_GETDATAPSDEACTIONID = "getdatapsdeactionid";
    public static final String FIELD_GETDATAPSDEACTIONNAME = "getdatapsdeactionname";
    public static final String FIELD_LAYOUTPANELMODE = "layoutpanelmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_POTIME = "potime";
    public static final String FIELD_PRINTMODEL = "printmodel";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEPRINTID = "psdeprintid";
    public static final String FIELD_PSDEPRINTNAME = "psdeprintname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_READPSDEOPPRIVID = "readpsdeopprivid";
    public static final String FIELD_READPSDEOPPRIVNAME = "readpsdeopprivname";
    public static final String FIELD_REFPSDEID = "refpsdeid";
    public static final String FIELD_REFPSDENAME = "refpsdename";
    public static final String FIELD_REPORTFILE = "reportfile";
    public static final String FIELD_REPORTTYPE = "reporttype";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public Integer getEnableColPriv() {
        Object objValue = this.get(FIELD_ENABLECOLPRIV);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecolpriv")
    public void setEnableColPriv(Integer enableColPriv) {
        this.set(FIELD_ENABLECOLPRIV, enableColPriv);
    }

    @JsonIgnore
    public boolean isEnableColPrivDirty() {
        return this.contains(FIELD_ENABLECOLPRIV);
    }

    @JsonIgnore
    public Integer getEnableLog() {
        Object objValue = this.get(FIELD_ENABLELOG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablelog")
    public void setEnableLog(Integer enableLog) {
        this.set(FIELD_ENABLELOG, enableLog);
    }

    @JsonIgnore
    public boolean isEnableLogDirty() {
        return this.contains(FIELD_ENABLELOG);
    }

    @JsonIgnore
    public Integer getEnableMP() {
        Object objValue = this.get(FIELD_ENABLEMP);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemp")
    public void setEnableMP(Integer enableMP) {
        this.set(FIELD_ENABLEMP, enableMP);
    }

    @JsonIgnore
    public boolean isEnableMPDirty() {
        return this.contains(FIELD_ENABLEMP);
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
    public String getGetDataPSDEActionId() {
        Object objValue = this.get(FIELD_GETDATAPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdatapsdeactionid")
    public void setGetDataPSDEActionId(String getDataPSDEActionId) {
        this.set(FIELD_GETDATAPSDEACTIONID, getDataPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetDataPSDEActionIdDirty() {
        return this.contains(FIELD_GETDATAPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetDataPSDEActionName() {
        Object objValue = this.get(FIELD_GETDATAPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdatapsdeactionname")
    public void setGetDataPSDEActionName(String getDataPSDEActionName) {
        this.set(FIELD_GETDATAPSDEACTIONNAME, getDataPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetDataPSDEActionNameDirty() {
        return this.contains(FIELD_GETDATAPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getLayoutPanelMode() {
        Object objValue = this.get(FIELD_LAYOUTPANELMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="layoutpanelmode")
    public void setLayoutPanelMode(Integer layoutPanelMode) {
        this.set(FIELD_LAYOUTPANELMODE, layoutPanelMode);
    }

    @JsonIgnore
    public boolean isLayoutPanelModeDirty() {
        return this.contains(FIELD_LAYOUTPANELMODE);
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
    public String getPrintModel() {
        Object objValue = this.get(FIELD_PRINTMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="printmodel")
    public void setPrintModel(String printModel) {
        this.set(FIELD_PRINTMODEL, printModel);
    }

    @JsonIgnore
    public boolean isPrintModelDirty() {
        return this.contains(FIELD_PRINTMODEL);
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
    public String getPSDEPrintId() {
        Object objValue = this.get(FIELD_PSDEPRINTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintid")
    public void setPSDEPrintId(String pSDEPrintId) {
        this.set(FIELD_PSDEPRINTID, pSDEPrintId);
    }

    @JsonIgnore
    public boolean isPSDEPrintIdDirty() {
        return this.contains(FIELD_PSDEPRINTID);
    }

    @JsonIgnore
    public String getPSDEPrintName() {
        Object objValue = this.get(FIELD_PSDEPRINTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeprintname")
    public void setPSDEPrintName(String pSDEPrintName) {
        this.set(FIELD_PSDEPRINTNAME, pSDEPrintName);
    }

    @JsonIgnore
    public boolean isPSDEPrintNameDirty() {
        return this.contains(FIELD_PSDEPRINTNAME);
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
    public String getReadPSDEOPPrivId() {
        Object objValue = this.get(FIELD_READPSDEOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="readpsdeopprivid")
    public void setReadPSDEOPPrivId(String readPSDEOPPrivId) {
        this.set(FIELD_READPSDEOPPRIVID, readPSDEOPPrivId);
    }

    @JsonIgnore
    public boolean isReadPSDEOPPrivIdDirty() {
        return this.contains(FIELD_READPSDEOPPRIVID);
    }

    @JsonIgnore
    public String getReadPSDEOPPrivName() {
        Object objValue = this.get(FIELD_READPSDEOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="readpsdeopprivname")
    public void setReadPSDEOPPrivName(String readPSDEOPPrivName) {
        this.set(FIELD_READPSDEOPPRIVNAME, readPSDEOPPrivName);
    }

    @JsonIgnore
    public boolean isReadPSDEOPPrivNameDirty() {
        return this.contains(FIELD_READPSDEOPPRIVNAME);
    }

    @JsonIgnore
    public String getRefPSDEId() {
        Object objValue = this.get(FIELD_REFPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdeid")
    public void setRefPSDEId(String refPSDEId) {
        this.set(FIELD_REFPSDEID, refPSDEId);
    }

    @JsonIgnore
    public boolean isRefPSDEIdDirty() {
        return this.contains(FIELD_REFPSDEID);
    }

    @JsonIgnore
    public String getRefPSDEName() {
        Object objValue = this.get(FIELD_REFPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpsdename")
    public void setRefPSDEName(String refPSDEName) {
        this.set(FIELD_REFPSDENAME, refPSDEName);
    }

    @JsonIgnore
    public boolean isRefPSDENameDirty() {
        return this.contains(FIELD_REFPSDENAME);
    }

    @JsonIgnore
    public String getReportFile() {
        Object objValue = this.get(FIELD_REPORTFILE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reportfile")
    public void setReportFile(String reportFile) {
        this.set(FIELD_REPORTFILE, reportFile);
    }

    @JsonIgnore
    public boolean isReportFileDirty() {
        return this.contains(FIELD_REPORTFILE);
    }

    @JsonIgnore
    public String getReportType() {
        Object objValue = this.get(FIELD_REPORTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reporttype")
    public void setReportType(String reportType) {
        this.set(FIELD_REPORTTYPE, reportType);
    }

    @JsonIgnore
    public boolean isReportTypeDirty() {
        return this.contains(FIELD_REPORTTYPE);
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
    public String getSrfkey() {
        return this.getPSDEPrintId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEPrintId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDEPRINT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEPrint item = (PSDEPrint)MAPPER.readValue(new File(strJsonFilePath), PSDEPrint.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEPrint) {
            PSDEPrint pSDEPrint = (PSDEPrint)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEPrint) {
            PSDEPrint pSDEPrint = (PSDEPrint)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

