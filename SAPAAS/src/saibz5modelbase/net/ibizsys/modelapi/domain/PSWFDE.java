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

public class PSWFDE
extends PSModelBase {
    public static final String FIELD_ACTIONMOBPSDEVIEWID = "actionmobpsdeviewid";
    public static final String FIELD_ACTIONMOBPSDEVIEWNAME = "actionmobpsdeviewname";
    public static final String FIELD_ACTIONPSDEVIEWID = "actionpsdeviewid";
    public static final String FIELD_ACTIONPSDEVIEWNAME = "actionpsdeviewname";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITABLEWFSTEP = "editablewfstep";
    public static final String FIELD_ENABLE = "enable";
    public static final String FIELD_EXTCNTSTATES = "extcntstates";
    public static final String FIELD_FINISHPSDEACTIONID = "finishpsdeactionid";
    public static final String FIELD_FINISHPSDEACTIONNAME = "finishpsdeactionname";
    public static final String FIELD_INITPSDEACTIONID = "initpsdeactionid";
    public static final String FIELD_INITPSDEACTIONNAME = "initpsdeactionname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBPROXYDATA2PSDEVIEWID = "mobproxydata2psdeviewid";
    public static final String FIELD_MOBPROXYDATA2PSDEVIEWNAME = "mobproxydata2psdeviewname";
    public static final String FIELD_MOBPROXYDATAPSDEVIEWID = "mobproxydatapsdeviewid";
    public static final String FIELD_MOBPROXYDATAPSDEVIEWNAME = "mobproxydatapsdeviewname";
    public static final String FIELD_MYWFDATA = "mywfdata";
    public static final String FIELD_MYWFDATAPSLANRESID = "mywfdatapslanresid";
    public static final String FIELD_MYWFDATAPSLANRESNAME = "mywfdatapslanresname";
    public static final String FIELD_MYWFWORK = "mywfwork";
    public static final String FIELD_MYWFWORKPSLANRESID = "mywfworkpslanresid";
    public static final String FIELD_MYWFWORKPSLANRESNAME = "mywfworkpslanresname";
    public static final String FIELD_PROXYDATA2PSDEVIEWID = "proxydata2psdeviewid";
    public static final String FIELD_PROXYDATA2PSDEVIEWNAME = "proxydata2psdeviewname";
    public static final String FIELD_PROXYDATAPSDEFID = "proxydatapsdefid";
    public static final String FIELD_PROXYDATAPSDEFNAME = "proxydatapsdefname";
    public static final String FIELD_PROXYDATAPSDEVIEWID = "proxydatapsdeviewid";
    public static final String FIELD_PROXYDATAPSDEVIEWNAME = "proxydatapsdeviewname";
    public static final String FIELD_PROXYMODULEPSDEFID = "proxymodulepsdefid";
    public static final String FIELD_PROXYMODULEPSDEFNAME = "proxymodulepsdefname";
    public static final String FIELD_PROXYWFPSDEFID = "proxywfpsdefid";
    public static final String FIELD_PROXYWFPSDEFNAME = "proxywfpsdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    public static final String FIELD_PSWFDENAME = "pswfdename";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFNAME = "pswfname";
    public static final String FIELD_PWFINSTPSDEFID = "pwfinstpsdefid";
    public static final String FIELD_PWFINSTPSDEFNAME = "pwfinstpsdefname";
    public static final String FIELD_STARTMOBPSDEVIEWID = "startmobpsdeviewid";
    public static final String FIELD_STARTMOBPSDEVIEWNAME = "startmobpsdeviewname";
    public static final String FIELD_STARTPSDEVIEWID = "startpsdeviewid";
    public static final String FIELD_STARTPSDEVIEWNAME = "startpsdeviewname";
    public static final String FIELD_STATEPSDEFID = "statepsdefid";
    public static final String FIELD_STATEPSDEFNAME = "statepsdefname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERSTART = "userstart";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WFACTORPSDEFID = "wfactorpsdefid";
    public static final String FIELD_WFACTORPSDEFNAME = "wfactorpsdefname";
    public static final String FIELD_WFIDPSDEFID = "wfidpsdefid";
    public static final String FIELD_WFIDPSDEFNAME = "wfidpsdefname";
    public static final String FIELD_WFINSTPSDEFID = "wfinstpsdefid";
    public static final String FIELD_WFINSTPSDEFNAME = "wfinstpsdefname";
    public static final String FIELD_WFMODE = "wfmode";
    public static final String FIELD_WFPROXYMODE = "wfproxymode";
    public static final String FIELD_WFRETPSDEFID = "wfretpsdefid";
    public static final String FIELD_WFRETPSDEFNAME = "wfretpsdefname";
    public static final String FIELD_WFSTATEPSDEFID = "wfstatepsdefid";
    public static final String FIELD_WFSTATEPSDEFNAME = "wfstatepsdefname";
    public static final String FIELD_WFSTEPPSDEFID = "wfsteppsdefid";
    public static final String FIELD_WFSTEPPSDEFNAME = "wfsteppsdefname";
    public static final String FIELD_WFVERPSDEFID = "wfverpsdefid";
    public static final String FIELD_WFVERPSDEFNAME = "wfverpsdefname";

    @JsonIgnore
    public String getActionMobPSDEViewId() {
        Object objValue = this.get(FIELD_ACTIONMOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionmobpsdeviewid")
    public void setActionMobPSDEViewId(String actionMobPSDEViewId) {
        this.set(FIELD_ACTIONMOBPSDEVIEWID, actionMobPSDEViewId);
    }

    @JsonIgnore
    public boolean isActionMobPSDEViewIdDirty() {
        return this.contains(FIELD_ACTIONMOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getActionMobPSDEViewName() {
        Object objValue = this.get(FIELD_ACTIONMOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionmobpsdeviewname")
    public void setActionMobPSDEViewName(String actionMobPSDEViewName) {
        this.set(FIELD_ACTIONMOBPSDEVIEWNAME, actionMobPSDEViewName);
    }

    @JsonIgnore
    public boolean isActionMobPSDEViewNameDirty() {
        return this.contains(FIELD_ACTIONMOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getActionPSDEViewId() {
        Object objValue = this.get(FIELD_ACTIONPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpsdeviewid")
    public void setActionPSDEViewId(String actionPSDEViewId) {
        this.set(FIELD_ACTIONPSDEVIEWID, actionPSDEViewId);
    }

    @JsonIgnore
    public boolean isActionPSDEViewIdDirty() {
        return this.contains(FIELD_ACTIONPSDEVIEWID);
    }

    @JsonIgnore
    public String getActionPSDEViewName() {
        Object objValue = this.get(FIELD_ACTIONPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpsdeviewname")
    public void setActionPSDEViewName(String actionPSDEViewName) {
        this.set(FIELD_ACTIONPSDEVIEWNAME, actionPSDEViewName);
    }

    @JsonIgnore
    public boolean isActionPSDEViewNameDirty() {
        return this.contains(FIELD_ACTIONPSDEVIEWNAME);
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
    public String getEditableWFStep() {
        Object objValue = this.get(FIELD_EDITABLEWFSTEP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editablewfstep")
    public void setEditableWFStep(String editableWFStep) {
        this.set(FIELD_EDITABLEWFSTEP, editableWFStep);
    }

    @JsonIgnore
    public boolean isEditableWFStepDirty() {
        return this.contains(FIELD_EDITABLEWFSTEP);
    }

    @JsonIgnore
    public Integer getEnable() {
        Object objValue = this.get(FIELD_ENABLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enable")
    public void setEnable(Integer enable) {
        this.set(FIELD_ENABLE, enable);
    }

    @JsonIgnore
    public boolean isEnableDirty() {
        return this.contains(FIELD_ENABLE);
    }

    @JsonIgnore
    public String getExtCntStates() {
        Object objValue = this.get(FIELD_EXTCNTSTATES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extcntstates")
    public void setExtCntStates(String extCntStates) {
        this.set(FIELD_EXTCNTSTATES, extCntStates);
    }

    @JsonIgnore
    public boolean isExtCntStatesDirty() {
        return this.contains(FIELD_EXTCNTSTATES);
    }

    @JsonIgnore
    public String getFinishPSDEActionId() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionid")
    public void setFinishPSDEActionId(String finishPSDEActionId) {
        this.set(FIELD_FINISHPSDEACTIONID, finishPSDEActionId);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionIdDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONID);
    }

    @JsonIgnore
    public String getFinishPSDEActionName() {
        Object objValue = this.get(FIELD_FINISHPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="finishpsdeactionname")
    public void setFinishPSDEActionName(String finishPSDEActionName) {
        this.set(FIELD_FINISHPSDEACTIONNAME, finishPSDEActionName);
    }

    @JsonIgnore
    public boolean isFinishPSDEActionNameDirty() {
        return this.contains(FIELD_FINISHPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getInitPSDEActionId() {
        Object objValue = this.get(FIELD_INITPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpsdeactionid")
    public void setInitPSDEActionId(String initPSDEActionId) {
        this.set(FIELD_INITPSDEACTIONID, initPSDEActionId);
    }

    @JsonIgnore
    public boolean isInitPSDEActionIdDirty() {
        return this.contains(FIELD_INITPSDEACTIONID);
    }

    @JsonIgnore
    public String getInitPSDEActionName() {
        Object objValue = this.get(FIELD_INITPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpsdeactionname")
    public void setInitPSDEActionName(String initPSDEActionName) {
        this.set(FIELD_INITPSDEACTIONNAME, initPSDEActionName);
    }

    @JsonIgnore
    public boolean isInitPSDEActionNameDirty() {
        return this.contains(FIELD_INITPSDEACTIONNAME);
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
    public String getMobProxyData2PSDEViewId() {
        Object objValue = this.get(FIELD_MOBPROXYDATA2PSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobproxydata2psdeviewid")
    public void setMobProxyData2PSDEViewId(String mobProxyData2PSDEViewId) {
        this.set(FIELD_MOBPROXYDATA2PSDEVIEWID, mobProxyData2PSDEViewId);
    }

    @JsonIgnore
    public boolean isMobProxyData2PSDEViewIdDirty() {
        return this.contains(FIELD_MOBPROXYDATA2PSDEVIEWID);
    }

    @JsonIgnore
    public String getMobProxyData2PSDEViewName() {
        Object objValue = this.get(FIELD_MOBPROXYDATA2PSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobproxydata2psdeviewname")
    public void setMobProxyData2PSDEViewName(String mobProxyData2PSDEViewName) {
        this.set(FIELD_MOBPROXYDATA2PSDEVIEWNAME, mobProxyData2PSDEViewName);
    }

    @JsonIgnore
    public boolean isMobProxyData2PSDEViewNameDirty() {
        return this.contains(FIELD_MOBPROXYDATA2PSDEVIEWNAME);
    }

    @JsonIgnore
    public String getMobProxyDataPSDEViewId() {
        Object objValue = this.get(FIELD_MOBPROXYDATAPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobproxydatapsdeviewid")
    public void setMobProxyDataPSDEViewId(String mobProxyDataPSDEViewId) {
        this.set(FIELD_MOBPROXYDATAPSDEVIEWID, mobProxyDataPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobProxyDataPSDEViewIdDirty() {
        return this.contains(FIELD_MOBPROXYDATAPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobProxyDataPSDEViewName() {
        Object objValue = this.get(FIELD_MOBPROXYDATAPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobproxydatapsdeviewname")
    public void setMobProxyDataPSDEViewName(String mobProxyDataPSDEViewName) {
        this.set(FIELD_MOBPROXYDATAPSDEVIEWNAME, mobProxyDataPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobProxyDataPSDEViewNameDirty() {
        return this.contains(FIELD_MOBPROXYDATAPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getMyWFData() {
        Object objValue = this.get(FIELD_MYWFDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfdata")
    public void setMyWFData(String myWFData) {
        this.set(FIELD_MYWFDATA, myWFData);
    }

    @JsonIgnore
    public boolean isMyWFDataDirty() {
        return this.contains(FIELD_MYWFDATA);
    }

    @JsonIgnore
    public String getMyWFDataPSLanResId() {
        Object objValue = this.get(FIELD_MYWFDATAPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfdatapslanresid")
    public void setMyWFDataPSLanResId(String myWFDataPSLanResId) {
        this.set(FIELD_MYWFDATAPSLANRESID, myWFDataPSLanResId);
    }

    @JsonIgnore
    public boolean isMyWFDataPSLanResIdDirty() {
        return this.contains(FIELD_MYWFDATAPSLANRESID);
    }

    @JsonIgnore
    public String getMyWFDataPSLanResName() {
        Object objValue = this.get(FIELD_MYWFDATAPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfdatapslanresname")
    public void setMyWFDataPSLanResName(String myWFDataPSLanResName) {
        this.set(FIELD_MYWFDATAPSLANRESNAME, myWFDataPSLanResName);
    }

    @JsonIgnore
    public boolean isMyWFDataPSLanResNameDirty() {
        return this.contains(FIELD_MYWFDATAPSLANRESNAME);
    }

    @JsonIgnore
    public String getMyWFWork() {
        Object objValue = this.get(FIELD_MYWFWORK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfwork")
    public void setMyWFWork(String myWFWork) {
        this.set(FIELD_MYWFWORK, myWFWork);
    }

    @JsonIgnore
    public boolean isMyWFWorkDirty() {
        return this.contains(FIELD_MYWFWORK);
    }

    @JsonIgnore
    public String getMyWFWorkPSLanResId() {
        Object objValue = this.get(FIELD_MYWFWORKPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfworkpslanresid")
    public void setMyWFWorkPSLanResId(String myWFWorkPSLanResId) {
        this.set(FIELD_MYWFWORKPSLANRESID, myWFWorkPSLanResId);
    }

    @JsonIgnore
    public boolean isMyWFWorkPSLanResIdDirty() {
        return this.contains(FIELD_MYWFWORKPSLANRESID);
    }

    @JsonIgnore
    public String getMyWFWorkPSLanResName() {
        Object objValue = this.get(FIELD_MYWFWORKPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mywfworkpslanresname")
    public void setMyWFWorkPSLanResName(String myWFWorkPSLanResName) {
        this.set(FIELD_MYWFWORKPSLANRESNAME, myWFWorkPSLanResName);
    }

    @JsonIgnore
    public boolean isMyWFWorkPSLanResNameDirty() {
        return this.contains(FIELD_MYWFWORKPSLANRESNAME);
    }

    @JsonIgnore
    public String getProxyData2PSDEViewId() {
        Object objValue = this.get(FIELD_PROXYDATA2PSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydata2psdeviewid")
    public void setProxyData2PSDEViewId(String proxyData2PSDEViewId) {
        this.set(FIELD_PROXYDATA2PSDEVIEWID, proxyData2PSDEViewId);
    }

    @JsonIgnore
    public boolean isProxyData2PSDEViewIdDirty() {
        return this.contains(FIELD_PROXYDATA2PSDEVIEWID);
    }

    @JsonIgnore
    public String getProxyData2PSDEViewName() {
        Object objValue = this.get(FIELD_PROXYDATA2PSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydata2psdeviewname")
    public void setProxyData2PSDEViewName(String proxyData2PSDEViewName) {
        this.set(FIELD_PROXYDATA2PSDEVIEWNAME, proxyData2PSDEViewName);
    }

    @JsonIgnore
    public boolean isProxyData2PSDEViewNameDirty() {
        return this.contains(FIELD_PROXYDATA2PSDEVIEWNAME);
    }

    @JsonIgnore
    public String getProxyDataPSDEFId() {
        Object objValue = this.get(FIELD_PROXYDATAPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydatapsdefid")
    public void setProxyDataPSDEFId(String proxyDataPSDEFId) {
        this.set(FIELD_PROXYDATAPSDEFID, proxyDataPSDEFId);
    }

    @JsonIgnore
    public boolean isProxyDataPSDEFIdDirty() {
        return this.contains(FIELD_PROXYDATAPSDEFID);
    }

    @JsonIgnore
    public String getProxyDataPSDEFName() {
        Object objValue = this.get(FIELD_PROXYDATAPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydatapsdefname")
    public void setProxyDataPSDEFName(String proxyDataPSDEFName) {
        this.set(FIELD_PROXYDATAPSDEFNAME, proxyDataPSDEFName);
    }

    @JsonIgnore
    public boolean isProxyDataPSDEFNameDirty() {
        return this.contains(FIELD_PROXYDATAPSDEFNAME);
    }

    @JsonIgnore
    public String getProxyDataPSDEViewId() {
        Object objValue = this.get(FIELD_PROXYDATAPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydatapsdeviewid")
    public void setProxyDataPSDEViewId(String proxyDataPSDEViewId) {
        this.set(FIELD_PROXYDATAPSDEVIEWID, proxyDataPSDEViewId);
    }

    @JsonIgnore
    public boolean isProxyDataPSDEViewIdDirty() {
        return this.contains(FIELD_PROXYDATAPSDEVIEWID);
    }

    @JsonIgnore
    public String getProxyDataPSDEViewName() {
        Object objValue = this.get(FIELD_PROXYDATAPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxydatapsdeviewname")
    public void setProxyDataPSDEViewName(String proxyDataPSDEViewName) {
        this.set(FIELD_PROXYDATAPSDEVIEWNAME, proxyDataPSDEViewName);
    }

    @JsonIgnore
    public boolean isProxyDataPSDEViewNameDirty() {
        return this.contains(FIELD_PROXYDATAPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getProxyModulePSDEFId() {
        Object objValue = this.get(FIELD_PROXYMODULEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxymodulepsdefid")
    public void setProxyModulePSDEFId(String proxyModulePSDEFId) {
        this.set(FIELD_PROXYMODULEPSDEFID, proxyModulePSDEFId);
    }

    @JsonIgnore
    public boolean isProxyModulePSDEFIdDirty() {
        return this.contains(FIELD_PROXYMODULEPSDEFID);
    }

    @JsonIgnore
    public String getProxyModulePSDEFName() {
        Object objValue = this.get(FIELD_PROXYMODULEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxymodulepsdefname")
    public void setProxyModulePSDEFName(String proxyModulePSDEFName) {
        this.set(FIELD_PROXYMODULEPSDEFNAME, proxyModulePSDEFName);
    }

    @JsonIgnore
    public boolean isProxyModulePSDEFNameDirty() {
        return this.contains(FIELD_PROXYMODULEPSDEFNAME);
    }

    @JsonIgnore
    public String getProxyWFPSDEFId() {
        Object objValue = this.get(FIELD_PROXYWFPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxywfpsdefid")
    public void setProxyWFPSDEFId(String proxyWFPSDEFId) {
        this.set(FIELD_PROXYWFPSDEFID, proxyWFPSDEFId);
    }

    @JsonIgnore
    public boolean isProxyWFPSDEFIdDirty() {
        return this.contains(FIELD_PROXYWFPSDEFID);
    }

    @JsonIgnore
    public String getProxyWFPSDEFName() {
        Object objValue = this.get(FIELD_PROXYWFPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="proxywfpsdefname")
    public void setProxyWFPSDEFName(String proxyWFPSDEFName) {
        this.set(FIELD_PROXYWFPSDEFNAME, proxyWFPSDEFName);
    }

    @JsonIgnore
    public boolean isProxyWFPSDEFNameDirty() {
        return this.contains(FIELD_PROXYWFPSDEFNAME);
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
    public String getPSWFDEId() {
        Object objValue = this.get(FIELD_PSWFDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfdeid")
    public void setPSWFDEId(String pSWFDEId) {
        this.set(FIELD_PSWFDEID, pSWFDEId);
    }

    @JsonIgnore
    public boolean isPSWFDEIdDirty() {
        return this.contains(FIELD_PSWFDEID);
    }

    @JsonIgnore
    public String getPSWFDEName() {
        Object objValue = this.get(FIELD_PSWFDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfdename")
    public void setPSWFDEName(String pSWFDEName) {
        this.set(FIELD_PSWFDENAME, pSWFDEName);
    }

    @JsonIgnore
    public boolean isPSWFDENameDirty() {
        return this.contains(FIELD_PSWFDENAME);
    }

    @JsonIgnore
    public String getPSWFId() {
        Object objValue = this.get(FIELD_PSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfid")
    public void setPSWFId(String pSWFId) {
        this.set(FIELD_PSWFID, pSWFId);
    }

    @JsonIgnore
    public boolean isPSWFIdDirty() {
        return this.contains(FIELD_PSWFID);
    }

    @JsonIgnore
    public String getPSWFName() {
        Object objValue = this.get(FIELD_PSWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfname")
    public void setPSWFName(String pSWFName) {
        this.set(FIELD_PSWFNAME, pSWFName);
    }

    @JsonIgnore
    public boolean isPSWFNameDirty() {
        return this.contains(FIELD_PSWFNAME);
    }

    @JsonIgnore
    public String getPWFInstPSDEFId() {
        Object objValue = this.get(FIELD_PWFINSTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pwfinstpsdefid")
    public void setPWFInstPSDEFId(String pWFInstPSDEFId) {
        this.set(FIELD_PWFINSTPSDEFID, pWFInstPSDEFId);
    }

    @JsonIgnore
    public boolean isPWFInstPSDEFIdDirty() {
        return this.contains(FIELD_PWFINSTPSDEFID);
    }

    @JsonIgnore
    public String getPWFInstPSDEFName() {
        Object objValue = this.get(FIELD_PWFINSTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pwfinstpsdefname")
    public void setPWFInstPSDEFName(String pWFInstPSDEFName) {
        this.set(FIELD_PWFINSTPSDEFNAME, pWFInstPSDEFName);
    }

    @JsonIgnore
    public boolean isPWFInstPSDEFNameDirty() {
        return this.contains(FIELD_PWFINSTPSDEFNAME);
    }

    @JsonIgnore
    public String getStartMobPSDEViewId() {
        Object objValue = this.get(FIELD_STARTMOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startmobpsdeviewid")
    public void setStartMobPSDEViewId(String startMobPSDEViewId) {
        this.set(FIELD_STARTMOBPSDEVIEWID, startMobPSDEViewId);
    }

    @JsonIgnore
    public boolean isStartMobPSDEViewIdDirty() {
        return this.contains(FIELD_STARTMOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getStartMobPSDEViewName() {
        Object objValue = this.get(FIELD_STARTMOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startmobpsdeviewname")
    public void setStartMobPSDEViewName(String startMobPSDEViewName) {
        this.set(FIELD_STARTMOBPSDEVIEWNAME, startMobPSDEViewName);
    }

    @JsonIgnore
    public boolean isStartMobPSDEViewNameDirty() {
        return this.contains(FIELD_STARTMOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getStartPSDEViewId() {
        Object objValue = this.get(FIELD_STARTPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startpsdeviewid")
    public void setStartPSDEViewId(String startPSDEViewId) {
        this.set(FIELD_STARTPSDEVIEWID, startPSDEViewId);
    }

    @JsonIgnore
    public boolean isStartPSDEViewIdDirty() {
        return this.contains(FIELD_STARTPSDEVIEWID);
    }

    @JsonIgnore
    public String getStartPSDEViewName() {
        Object objValue = this.get(FIELD_STARTPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="startpsdeviewname")
    public void setStartPSDEViewName(String startPSDEViewName) {
        this.set(FIELD_STARTPSDEVIEWNAME, startPSDEViewName);
    }

    @JsonIgnore
    public boolean isStartPSDEViewNameDirty() {
        return this.contains(FIELD_STARTPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getStatePSDEFId() {
        Object objValue = this.get(FIELD_STATEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statepsdefid")
    public void setStatePSDEFId(String statePSDEFId) {
        this.set(FIELD_STATEPSDEFID, statePSDEFId);
    }

    @JsonIgnore
    public boolean isStatePSDEFIdDirty() {
        return this.contains(FIELD_STATEPSDEFID);
    }

    @JsonIgnore
    public String getStatePSDEFName() {
        Object objValue = this.get(FIELD_STATEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="statepsdefname")
    public void setStatePSDEFName(String statePSDEFName) {
        this.set(FIELD_STATEPSDEFNAME, statePSDEFName);
    }

    @JsonIgnore
    public boolean isStatePSDEFNameDirty() {
        return this.contains(FIELD_STATEPSDEFNAME);
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
    public Integer getUserStart() {
        Object objValue = this.get(FIELD_USERSTART);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userstart")
    public void setUserStart(Integer userStart) {
        this.set(FIELD_USERSTART, userStart);
    }

    @JsonIgnore
    public boolean isUserStartDirty() {
        return this.contains(FIELD_USERSTART);
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
    public String getWFActorPSDEFId() {
        Object objValue = this.get(FIELD_WFACTORPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfactorpsdefid")
    public void setWFActorPSDEFId(String wFActorPSDEFId) {
        this.set(FIELD_WFACTORPSDEFID, wFActorPSDEFId);
    }

    @JsonIgnore
    public boolean isWFActorPSDEFIdDirty() {
        return this.contains(FIELD_WFACTORPSDEFID);
    }

    @JsonIgnore
    public String getWFActorPSDEFName() {
        Object objValue = this.get(FIELD_WFACTORPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfactorpsdefname")
    public void setWFActorPSDEFName(String wFActorPSDEFName) {
        this.set(FIELD_WFACTORPSDEFNAME, wFActorPSDEFName);
    }

    @JsonIgnore
    public boolean isWFActorPSDEFNameDirty() {
        return this.contains(FIELD_WFACTORPSDEFNAME);
    }

    @JsonIgnore
    public String getWFIdPSDEFId() {
        Object objValue = this.get(FIELD_WFIDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfidpsdefid")
    public void setWFIdPSDEFId(String wFIdPSDEFId) {
        this.set(FIELD_WFIDPSDEFID, wFIdPSDEFId);
    }

    @JsonIgnore
    public boolean isWFIdPSDEFIdDirty() {
        return this.contains(FIELD_WFIDPSDEFID);
    }

    @JsonIgnore
    public String getWFIdPSDEFName() {
        Object objValue = this.get(FIELD_WFIDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfidpsdefname")
    public void setWFIdPSDEFName(String wFIdPSDEFName) {
        this.set(FIELD_WFIDPSDEFNAME, wFIdPSDEFName);
    }

    @JsonIgnore
    public boolean isWFIdPSDEFNameDirty() {
        return this.contains(FIELD_WFIDPSDEFNAME);
    }

    @JsonIgnore
    public String getWFInstPSDEFId() {
        Object objValue = this.get(FIELD_WFINSTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfinstpsdefid")
    public void setWFInstPSDEFId(String wFInstPSDEFId) {
        this.set(FIELD_WFINSTPSDEFID, wFInstPSDEFId);
    }

    @JsonIgnore
    public boolean isWFInstPSDEFIdDirty() {
        return this.contains(FIELD_WFINSTPSDEFID);
    }

    @JsonIgnore
    public String getWFInstPSDEFName() {
        Object objValue = this.get(FIELD_WFINSTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfinstpsdefname")
    public void setWFInstPSDEFName(String wFInstPSDEFName) {
        this.set(FIELD_WFINSTPSDEFNAME, wFInstPSDEFName);
    }

    @JsonIgnore
    public boolean isWFInstPSDEFNameDirty() {
        return this.contains(FIELD_WFINSTPSDEFNAME);
    }

    @JsonIgnore
    public String getWFMode() {
        Object objValue = this.get(FIELD_WFMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfmode")
    public void setWFMode(String wFMode) {
        this.set(FIELD_WFMODE, wFMode);
    }

    @JsonIgnore
    public boolean isWFModeDirty() {
        return this.contains(FIELD_WFMODE);
    }

    @JsonIgnore
    public Integer getWFProxyMode() {
        Object objValue = this.get(FIELD_WFPROXYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfproxymode")
    public void setWFProxyMode(Integer wFProxyMode) {
        this.set(FIELD_WFPROXYMODE, wFProxyMode);
    }

    @JsonIgnore
    public boolean isWFProxyModeDirty() {
        return this.contains(FIELD_WFPROXYMODE);
    }

    @JsonIgnore
    public String getWFRetPSDEFId() {
        Object objValue = this.get(FIELD_WFRETPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfretpsdefid")
    public void setWFRetPSDEFId(String wFRetPSDEFId) {
        this.set(FIELD_WFRETPSDEFID, wFRetPSDEFId);
    }

    @JsonIgnore
    public boolean isWFRetPSDEFIdDirty() {
        return this.contains(FIELD_WFRETPSDEFID);
    }

    @JsonIgnore
    public String getWFRetPSDEFName() {
        Object objValue = this.get(FIELD_WFRETPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfretpsdefname")
    public void setWFRetPSDEFName(String wFRetPSDEFName) {
        this.set(FIELD_WFRETPSDEFNAME, wFRetPSDEFName);
    }

    @JsonIgnore
    public boolean isWFRetPSDEFNameDirty() {
        return this.contains(FIELD_WFRETPSDEFNAME);
    }

    @JsonIgnore
    public String getWFStatePSDEFId() {
        Object objValue = this.get(FIELD_WFSTATEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstatepsdefid")
    public void setWFStatePSDEFId(String wFStatePSDEFId) {
        this.set(FIELD_WFSTATEPSDEFID, wFStatePSDEFId);
    }

    @JsonIgnore
    public boolean isWFStatePSDEFIdDirty() {
        return this.contains(FIELD_WFSTATEPSDEFID);
    }

    @JsonIgnore
    public String getWFStatePSDEFName() {
        Object objValue = this.get(FIELD_WFSTATEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstatepsdefname")
    public void setWFStatePSDEFName(String wFStatePSDEFName) {
        this.set(FIELD_WFSTATEPSDEFNAME, wFStatePSDEFName);
    }

    @JsonIgnore
    public boolean isWFStatePSDEFNameDirty() {
        return this.contains(FIELD_WFSTATEPSDEFNAME);
    }

    @JsonIgnore
    public String getWFStepPSDEFId() {
        Object objValue = this.get(FIELD_WFSTEPPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfsteppsdefid")
    public void setWFStepPSDEFId(String wFStepPSDEFId) {
        this.set(FIELD_WFSTEPPSDEFID, wFStepPSDEFId);
    }

    @JsonIgnore
    public boolean isWFStepPSDEFIdDirty() {
        return this.contains(FIELD_WFSTEPPSDEFID);
    }

    @JsonIgnore
    public String getWFStepPSDEFName() {
        Object objValue = this.get(FIELD_WFSTEPPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfsteppsdefname")
    public void setWFStepPSDEFName(String wFStepPSDEFName) {
        this.set(FIELD_WFSTEPPSDEFNAME, wFStepPSDEFName);
    }

    @JsonIgnore
    public boolean isWFStepPSDEFNameDirty() {
        return this.contains(FIELD_WFSTEPPSDEFNAME);
    }

    @JsonIgnore
    public String getWFVerPSDEFId() {
        Object objValue = this.get(FIELD_WFVERPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfverpsdefid")
    public void setWFVerPSDEFId(String wFVerPSDEFId) {
        this.set(FIELD_WFVERPSDEFID, wFVerPSDEFId);
    }

    @JsonIgnore
    public boolean isWFVerPSDEFIdDirty() {
        return this.contains(FIELD_WFVERPSDEFID);
    }

    @JsonIgnore
    public String getWFVerPSDEFName() {
        Object objValue = this.get(FIELD_WFVERPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfverpsdefname")
    public void setWFVerPSDEFName(String wFVerPSDEFName) {
        this.set(FIELD_WFVERPSDEFNAME, wFVerPSDEFName);
    }

    @JsonIgnore
    public boolean isWFVerPSDEFNameDirty() {
        return this.contains(FIELD_WFVERPSDEFNAME);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFDEId();
    }

    public void setSrfkey(String strValue) {
        this.setPSWFDEId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSWFDE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSWFDE item = (PSWFDE)MAPPER.readValue(new File(strJsonFilePath), PSWFDE.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSWFDE) {
            PSWFDE pSWFDE = (PSWFDE)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSWFDE) {
            PSWFDE pSWFDE = (PSWFDE)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

