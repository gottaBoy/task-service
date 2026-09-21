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
import net.ibizsys.modelapi.domain.PSDERepItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEReport
extends PSModelBase {
    public static final String FIELD_ADPSDELOGICID = "adpsdelogicid";
    public static final String FIELD_ADPSDELOGICNAME = "adpsdelogicname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENABLEAUDIT = "enableaudit";
    public static final String FIELD_ENABLELOG = "enablelog";
    public static final String FIELD_EXTENDMODE = "extendmode";
    public static final String FIELD_LAYOUTPANELMODE = "layoutpanelmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MULTIPAGE = "multipage";
    public static final String FIELD_POTIME = "potime";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSID2 = "psdedsid2";
    public static final String FIELD_PSDEDSID3 = "psdedsid3";
    public static final String FIELD_PSDEDSID4 = "psdedsid4";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEDSNAME2 = "psdedsname2";
    public static final String FIELD_PSDEDSNAME3 = "psdedsname3";
    public static final String FIELD_PSDEDSNAME4 = "psdedsname4";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEREPORTID = "psdereportid";
    public static final String FIELD_PSDEREPORTNAME = "psdereportname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_REPORTFILE = "reportfile";
    public static final String FIELD_REPORTMODEL = "reportmodel";
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
    private List<PSDERepItem> psderepitems;

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
    public Integer getEnableAudit() {
        Object objValue = this.get(FIELD_ENABLEAUDIT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableaudit")
    public void setEnableAudit(Integer enableAudit) {
        this.set(FIELD_ENABLEAUDIT, enableAudit);
    }

    @JsonIgnore
    public boolean isEnableAuditDirty() {
        return this.contains(FIELD_ENABLEAUDIT);
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
    public Integer getMultiPage() {
        Object objValue = this.get(FIELD_MULTIPAGE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="multipage")
    public void setMultiPage(Integer multiPage) {
        this.set(FIELD_MULTIPAGE, multiPage);
    }

    @JsonIgnore
    public boolean isMultiPageDirty() {
        return this.contains(FIELD_MULTIPAGE);
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
    public String getPSDEDSId2() {
        Object objValue = this.get(FIELD_PSDEDSID2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid2")
    public void setPSDEDSId2(String pSDEDSId2) {
        this.set(FIELD_PSDEDSID2, pSDEDSId2);
    }

    @JsonIgnore
    public boolean isPSDEDSId2Dirty() {
        return this.contains(FIELD_PSDEDSID2);
    }

    @JsonIgnore
    public String getPSDEDSId3() {
        Object objValue = this.get(FIELD_PSDEDSID3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid3")
    public void setPSDEDSId3(String pSDEDSId3) {
        this.set(FIELD_PSDEDSID3, pSDEDSId3);
    }

    @JsonIgnore
    public boolean isPSDEDSId3Dirty() {
        return this.contains(FIELD_PSDEDSID3);
    }

    @JsonIgnore
    public String getPSDEDSId4() {
        Object objValue = this.get(FIELD_PSDEDSID4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid4")
    public void setPSDEDSId4(String pSDEDSId4) {
        this.set(FIELD_PSDEDSID4, pSDEDSId4);
    }

    @JsonIgnore
    public boolean isPSDEDSId4Dirty() {
        return this.contains(FIELD_PSDEDSID4);
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
    public String getPSDEDSName2() {
        Object objValue = this.get(FIELD_PSDEDSNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname2")
    public void setPSDEDSName2(String pSDEDSName2) {
        this.set(FIELD_PSDEDSNAME2, pSDEDSName2);
    }

    @JsonIgnore
    public boolean isPSDEDSName2Dirty() {
        return this.contains(FIELD_PSDEDSNAME2);
    }

    @JsonIgnore
    public String getPSDEDSName3() {
        Object objValue = this.get(FIELD_PSDEDSNAME3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname3")
    public void setPSDEDSName3(String pSDEDSName3) {
        this.set(FIELD_PSDEDSNAME3, pSDEDSName3);
    }

    @JsonIgnore
    public boolean isPSDEDSName3Dirty() {
        return this.contains(FIELD_PSDEDSNAME3);
    }

    @JsonIgnore
    public String getPSDEDSName4() {
        Object objValue = this.get(FIELD_PSDEDSNAME4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname4")
    public void setPSDEDSName4(String pSDEDSName4) {
        this.set(FIELD_PSDEDSNAME4, pSDEDSName4);
    }

    @JsonIgnore
    public boolean isPSDEDSName4Dirty() {
        return this.contains(FIELD_PSDEDSNAME4);
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
    public String getPSDEReportId() {
        Object objValue = this.get(FIELD_PSDEREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportid")
    public void setPSDEReportId(String pSDEReportId) {
        this.set(FIELD_PSDEREPORTID, pSDEReportId);
    }

    @JsonIgnore
    public boolean isPSDEReportIdDirty() {
        return this.contains(FIELD_PSDEREPORTID);
    }

    @JsonIgnore
    public String getPSDEReportName() {
        Object objValue = this.get(FIELD_PSDEREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdereportname")
    public void setPSDEReportName(String pSDEReportName) {
        this.set(FIELD_PSDEREPORTNAME, pSDEReportName);
    }

    @JsonIgnore
    public boolean isPSDEReportNameDirty() {
        return this.contains(FIELD_PSDEREPORTNAME);
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
    public String getPSSysUniResId() {
        Object objValue = this.get(FIELD_PSSYSUNIRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresid")
    public void setPSSysUniResId(String pSSysUniResId) {
        this.set(FIELD_PSSYSUNIRESID, pSSysUniResId);
    }

    @JsonIgnore
    public boolean isPSSysUniResIdDirty() {
        return this.contains(FIELD_PSSYSUNIRESID);
    }

    @JsonIgnore
    public String getPSSysUniResName() {
        Object objValue = this.get(FIELD_PSSYSUNIRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuniresname")
    public void setPSSysUniResName(String pSSysUniResName) {
        this.set(FIELD_PSSYSUNIRESNAME, pSSysUniResName);
    }

    @JsonIgnore
    public boolean isPSSysUniResNameDirty() {
        return this.contains(FIELD_PSSYSUNIRESNAME);
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
    public String getReportModel() {
        Object objValue = this.get(FIELD_REPORTMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="reportmodel")
    public void setReportModel(String reportModel) {
        this.set(FIELD_REPORTMODEL, reportModel);
    }

    @JsonIgnore
    public boolean isReportModelDirty() {
        return this.contains(FIELD_REPORTMODEL);
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
        return this.getPSDEReportId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEReportId(strValue);
    }

    public List<PSDERepItem> getPsderepitems() {
        return this.psderepitems;
    }

    public void setPsderepitems(List<PSDERepItem> psderepitems) {
        this.psderepitems = psderepitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psderepitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psderepitems")) {
            this.init();
            return this.psderepitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEREPORT";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEReport item = (PSDEReport)MAPPER.readValue(new File(strJsonFilePath), PSDEReport.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEReport) {
            PSDEReport dst = (PSDEReport)target;
            if (!bSimple && this.getPsderepitems() != null) {
                ArrayList<PSDERepItem> psderepitems = new ArrayList<PSDERepItem>();
                for (PSDERepItem item : this.getPsderepitems()) {
                    if (bDeepMode) {
                        PSDERepItem newitem = new PSDERepItem();
                        item.to(newitem, false, bDeepMode);
                        psderepitems.add(newitem);
                        continue;
                    }
                    psderepitems.add(item);
                }
                dst.setPsderepitems(psderepitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEReport) {
            PSDEReport src = (PSDEReport)source;
            if (!bSimple && src.getPsderepitems() != null) {
                ArrayList<PSDERepItem> psderepitems = new ArrayList<PSDERepItem>();
                for (PSDERepItem item : src.getPsderepitems()) {
                    if (bDeepMode) {
                        PSDERepItem newItem = new PSDERepItem();
                        newItem.from(item, false, bDeepMode);
                        psderepitems.add(newItem);
                        continue;
                    }
                    psderepitems.add(item);
                }
                this.setPsderepitems(psderepitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

