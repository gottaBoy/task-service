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

public class PSAppFunc
extends PSModelBase {
    public static final String FIELD_APPFUNCTYPE = "appfunctype";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAINSTTAG = "dynainsttag";
    public static final String FIELD_DYNAINSTTAG2 = "dynainsttag2";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_FROMOBJID = "fromobjid";
    public static final String FIELD_FUNCSN = "funcsn";
    public static final String FIELD_JSCODE = "jscode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NAMEPSLANRESID = "namepslanresid";
    public static final String FIELD_NAMEPSLANRESNAME = "namepslanresname";
    public static final String FIELD_OPENMODE = "openmode";
    public static final String FIELD_OPENVIEWPARAM = "openviewparam";
    public static final String FIELD_PAGEURL = "pageurl";
    public static final String FIELD_PSAPPFUNCID = "psappfuncid";
    public static final String FIELD_PSAPPFUNCNAME = "psappfuncname";
    public static final String FIELD_PSAPPLOCALDEID = "psapplocaldeid";
    public static final String FIELD_PSAPPLOCALDENAME = "psapplocaldename";
    public static final String FIELD_PSAPPSUBAPPID = "psappsubappid";
    public static final String FIELD_PSAPPSUBAPPNAME = "psappsubappname";
    public static final String FIELD_PSAPPVIEWID = "psappviewid";
    public static final String FIELD_PSAPPVIEWNAME = "psappviewname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSDYNAAPPID = "psdynaappid";
    public static final String FIELD_PSDYNAAPPNAME = "psdynaappname";
    public static final String FIELD_PSPDTAPPFUNCID = "pspdtappfuncid";
    public static final String FIELD_PSPDTAPPFUNCNAME = "pspdtappfuncname";
    public static final String FIELD_PSSUBAPPID = "pssubappid";
    public static final String FIELD_PSSUBAPPNAME = "pssubappname";
    public static final String FIELD_PSSUBAPPVIEWID = "pssubappviewid";
    public static final String FIELD_PSSUBAPPVIEWNAME = "pssubappviewname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_SYSTEMFLAG = "systemflag";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TOOLTIPINFO = "tooltipinfo";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getAppFuncType() {
        Object objValue = this.get(FIELD_APPFUNCTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appfunctype")
    public void setAppFuncType(String appFuncType) {
        this.set(FIELD_APPFUNCTYPE, appFuncType);
    }

    @JsonIgnore
    public boolean isAppFuncTypeDirty() {
        return this.contains(FIELD_APPFUNCTYPE);
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
    public String getDynaInstTag() {
        Object objValue = this.get(FIELD_DYNAINSTTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag")
    public void setDynaInstTag(String dynaInstTag) {
        this.set(FIELD_DYNAINSTTAG, dynaInstTag);
    }

    @JsonIgnore
    public boolean isDynaInstTagDirty() {
        return this.contains(FIELD_DYNAINSTTAG);
    }

    @JsonIgnore
    public String getDynaInstTag2() {
        Object objValue = this.get(FIELD_DYNAINSTTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dynainsttag2")
    public void setDynaInstTag2(String dynaInstTag2) {
        this.set(FIELD_DYNAINSTTAG2, dynaInstTag2);
    }

    @JsonIgnore
    public boolean isDynaInstTag2Dirty() {
        return this.contains(FIELD_DYNAINSTTAG2);
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
    public String getFromObjId() {
        Object objValue = this.get(FIELD_FROMOBJID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="fromobjid")
    public void setFromObjId(String fromObjId) {
        this.set(FIELD_FROMOBJID, fromObjId);
    }

    @JsonIgnore
    public boolean isFromObjIdDirty() {
        return this.contains(FIELD_FROMOBJID);
    }

    @JsonIgnore
    public String getFuncSN() {
        Object objValue = this.get(FIELD_FUNCSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="funcsn")
    public void setFuncSN(String funcSN) {
        this.set(FIELD_FUNCSN, funcSN);
    }

    @JsonIgnore
    public boolean isFuncSNDirty() {
        return this.contains(FIELD_FUNCSN);
    }

    @JsonIgnore
    public String getJSCode() {
        Object objValue = this.get(FIELD_JSCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jscode")
    public void setJSCode(String jSCode) {
        this.set(FIELD_JSCODE, jSCode);
    }

    @JsonIgnore
    public boolean isJSCodeDirty() {
        return this.contains(FIELD_JSCODE);
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
    public String getNamePSLanResId() {
        Object objValue = this.get(FIELD_NAMEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresid")
    public void setNamePSLanResId(String namePSLanResId) {
        this.set(FIELD_NAMEPSLANRESID, namePSLanResId);
    }

    @JsonIgnore
    public boolean isNamePSLanResIdDirty() {
        return this.contains(FIELD_NAMEPSLANRESID);
    }

    @JsonIgnore
    public String getNamePSLanResName() {
        Object objValue = this.get(FIELD_NAMEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="namepslanresname")
    public void setNamePSLanResName(String namePSLanResName) {
        this.set(FIELD_NAMEPSLANRESNAME, namePSLanResName);
    }

    @JsonIgnore
    public boolean isNamePSLanResNameDirty() {
        return this.contains(FIELD_NAMEPSLANRESNAME);
    }

    @JsonIgnore
    public String getOpenMode() {
        Object objValue = this.get(FIELD_OPENMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openmode")
    public void setOpenMode(String openMode) {
        this.set(FIELD_OPENMODE, openMode);
    }

    @JsonIgnore
    public boolean isOpenModeDirty() {
        return this.contains(FIELD_OPENMODE);
    }

    @JsonIgnore
    public String getOpenViewParam() {
        Object objValue = this.get(FIELD_OPENVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="openviewparam")
    public void setOpenViewParam(String openViewParam) {
        this.set(FIELD_OPENVIEWPARAM, openViewParam);
    }

    @JsonIgnore
    public boolean isOpenViewParamDirty() {
        return this.contains(FIELD_OPENVIEWPARAM);
    }

    @JsonIgnore
    public String getPageUrl() {
        Object objValue = this.get(FIELD_PAGEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pageurl")
    public void setPageUrl(String pageUrl) {
        this.set(FIELD_PAGEURL, pageUrl);
    }

    @JsonIgnore
    public boolean isPageUrlDirty() {
        return this.contains(FIELD_PAGEURL);
    }

    @JsonIgnore
    public String getPSAppFuncId() {
        Object objValue = this.get(FIELD_PSAPPFUNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncid")
    public void setPSAppFuncId(String pSAppFuncId) {
        this.set(FIELD_PSAPPFUNCID, pSAppFuncId);
    }

    @JsonIgnore
    public boolean isPSAppFuncIdDirty() {
        return this.contains(FIELD_PSAPPFUNCID);
    }

    @JsonIgnore
    public String getPSAppFuncName() {
        Object objValue = this.get(FIELD_PSAPPFUNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappfuncname")
    public void setPSAppFuncName(String pSAppFuncName) {
        this.set(FIELD_PSAPPFUNCNAME, pSAppFuncName);
    }

    @JsonIgnore
    public boolean isPSAppFuncNameDirty() {
        return this.contains(FIELD_PSAPPFUNCNAME);
    }

    @JsonIgnore
    public String getPSAppLocalDEId() {
        Object objValue = this.get(FIELD_PSAPPLOCALDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldeid")
    public void setPSAppLocalDEId(String pSAppLocalDEId) {
        this.set(FIELD_PSAPPLOCALDEID, pSAppLocalDEId);
    }

    @JsonIgnore
    public boolean isPSAppLocalDEIdDirty() {
        return this.contains(FIELD_PSAPPLOCALDEID);
    }

    @JsonIgnore
    public String getPSAppLocalDEName() {
        Object objValue = this.get(FIELD_PSAPPLOCALDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapplocaldename")
    public void setPSAppLocalDEName(String pSAppLocalDEName) {
        this.set(FIELD_PSAPPLOCALDENAME, pSAppLocalDEName);
    }

    @JsonIgnore
    public boolean isPSAppLocalDENameDirty() {
        return this.contains(FIELD_PSAPPLOCALDENAME);
    }

    @JsonIgnore
    public String getPSAppSubAppId() {
        Object objValue = this.get(FIELD_PSAPPSUBAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsubappid")
    public void setPSAppSubAppId(String pSAppSubAppId) {
        this.set(FIELD_PSAPPSUBAPPID, pSAppSubAppId);
    }

    @JsonIgnore
    public boolean isPSAppSubAppIdDirty() {
        return this.contains(FIELD_PSAPPSUBAPPID);
    }

    @JsonIgnore
    public String getPSAppSubAppName() {
        Object objValue = this.get(FIELD_PSAPPSUBAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappsubappname")
    public void setPSAppSubAppName(String pSAppSubAppName) {
        this.set(FIELD_PSAPPSUBAPPNAME, pSAppSubAppName);
    }

    @JsonIgnore
    public boolean isPSAppSubAppNameDirty() {
        return this.contains(FIELD_PSAPPSUBAPPNAME);
    }

    @JsonIgnore
    public String getPSAppViewId() {
        Object objValue = this.get(FIELD_PSAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewid")
    public void setPSAppViewId(String pSAppViewId) {
        this.set(FIELD_PSAPPVIEWID, pSAppViewId);
    }

    @JsonIgnore
    public boolean isPSAppViewIdDirty() {
        return this.contains(FIELD_PSAPPVIEWID);
    }

    @JsonIgnore
    public String getPSAppViewName() {
        Object objValue = this.get(FIELD_PSAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewname")
    public void setPSAppViewName(String pSAppViewName) {
        this.set(FIELD_PSAPPVIEWNAME, pSAppViewName);
    }

    @JsonIgnore
    public boolean isPSAppViewNameDirty() {
        return this.contains(FIELD_PSAPPVIEWNAME);
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
    public String getPSDEUIActionId() {
        Object objValue = this.get(FIELD_PSDEUIACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionid")
    public void setPSDEUIActionId(String pSDEUIActionId) {
        this.set(FIELD_PSDEUIACTIONID, pSDEUIActionId);
    }

    @JsonIgnore
    public boolean isPSDEUIActionIdDirty() {
        return this.contains(FIELD_PSDEUIACTIONID);
    }

    @JsonIgnore
    public String getPSDEUIActionName() {
        Object objValue = this.get(FIELD_PSDEUIACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuiactionname")
    public void setPSDEUIActionName(String pSDEUIActionName) {
        this.set(FIELD_PSDEUIACTIONNAME, pSDEUIActionName);
    }

    @JsonIgnore
    public boolean isPSDEUIActionNameDirty() {
        return this.contains(FIELD_PSDEUIACTIONNAME);
    }

    @JsonIgnore
    public String getPSDynaAppId() {
        Object objValue = this.get(FIELD_PSDYNAAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynaappid")
    public void setPSDynaAppId(String pSDynaAppId) {
        this.set(FIELD_PSDYNAAPPID, pSDynaAppId);
    }

    @JsonIgnore
    public boolean isPSDynaAppIdDirty() {
        return this.contains(FIELD_PSDYNAAPPID);
    }

    @JsonIgnore
    public String getPSDynaAppName() {
        Object objValue = this.get(FIELD_PSDYNAAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynaappname")
    public void setPSDynaAppName(String pSDynaAppName) {
        this.set(FIELD_PSDYNAAPPNAME, pSDynaAppName);
    }

    @JsonIgnore
    public boolean isPSDynaAppNameDirty() {
        return this.contains(FIELD_PSDYNAAPPNAME);
    }

    @JsonIgnore
    public String getPSPDTAppFuncId() {
        Object objValue = this.get(FIELD_PSPDTAPPFUNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspdtappfuncid")
    public void setPSPDTAppFuncId(String pSPDTAppFuncId) {
        this.set(FIELD_PSPDTAPPFUNCID, pSPDTAppFuncId);
    }

    @JsonIgnore
    public boolean isPSPDTAppFuncIdDirty() {
        return this.contains(FIELD_PSPDTAPPFUNCID);
    }

    @JsonIgnore
    public String getPSPDTAppFuncName() {
        Object objValue = this.get(FIELD_PSPDTAPPFUNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspdtappfuncname")
    public void setPSPDTAppFuncName(String pSPDTAppFuncName) {
        this.set(FIELD_PSPDTAPPFUNCNAME, pSPDTAppFuncName);
    }

    @JsonIgnore
    public boolean isPSPDTAppFuncNameDirty() {
        return this.contains(FIELD_PSPDTAPPFUNCNAME);
    }

    @JsonIgnore
    public String getPSSubAppId() {
        Object objValue = this.get(FIELD_PSSUBAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubappid")
    public void setPSSubAppId(String pSSubAppId) {
        this.set(FIELD_PSSUBAPPID, pSSubAppId);
    }

    @JsonIgnore
    public boolean isPSSubAppIdDirty() {
        return this.contains(FIELD_PSSUBAPPID);
    }

    @JsonIgnore
    public String getPSSubAppName() {
        Object objValue = this.get(FIELD_PSSUBAPPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubappname")
    public void setPSSubAppName(String pSSubAppName) {
        this.set(FIELD_PSSUBAPPNAME, pSSubAppName);
    }

    @JsonIgnore
    public boolean isPSSubAppNameDirty() {
        return this.contains(FIELD_PSSUBAPPNAME);
    }

    @JsonIgnore
    public String getPSSubAppViewId() {
        Object objValue = this.get(FIELD_PSSUBAPPVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubappviewid")
    public void setPSSubAppViewId(String pSSubAppViewId) {
        this.set(FIELD_PSSUBAPPVIEWID, pSSubAppViewId);
    }

    @JsonIgnore
    public boolean isPSSubAppViewIdDirty() {
        return this.contains(FIELD_PSSUBAPPVIEWID);
    }

    @JsonIgnore
    public String getPSSubAppViewName() {
        Object objValue = this.get(FIELD_PSSUBAPPVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubappviewname")
    public void setPSSubAppViewName(String pSSubAppViewName) {
        this.set(FIELD_PSSUBAPPVIEWNAME, pSSubAppViewName);
    }

    @JsonIgnore
    public boolean isPSSubAppViewNameDirty() {
        return this.contains(FIELD_PSSUBAPPVIEWNAME);
    }

    @JsonIgnore
    public String getPSSysAppId() {
        Object objValue = this.get(FIELD_PSSYSAPPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysappid")
    public void setPSSysAppId(String pSSysAppId) {
        this.set(FIELD_PSSYSAPPID, pSSysAppId);
    }

    @JsonIgnore
    public boolean isPSSysAppIdDirty() {
        return this.contains(FIELD_PSSYSAPPID);
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
    public Integer getSystemFlag() {
        Object objValue = this.get(FIELD_SYSTEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="systemflag")
    public void setSystemFlag(Integer systemFlag) {
        this.set(FIELD_SYSTEMFLAG, systemFlag);
    }

    @JsonIgnore
    public boolean isSystemFlagDirty() {
        return this.contains(FIELD_SYSTEMFLAG);
    }

    @JsonIgnore
    public String getTipPSLanResId() {
        Object objValue = this.get(FIELD_TIPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresid")
    public void setTipPSLanResId(String tipPSLanResId) {
        this.set(FIELD_TIPPSLANRESID, tipPSLanResId);
    }

    @JsonIgnore
    public boolean isTipPSLanResIdDirty() {
        return this.contains(FIELD_TIPPSLANRESID);
    }

    @JsonIgnore
    public String getTipPSLanResName() {
        Object objValue = this.get(FIELD_TIPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tippslanresname")
    public void setTipPSLanResName(String tipPSLanResName) {
        this.set(FIELD_TIPPSLANRESNAME, tipPSLanResName);
    }

    @JsonIgnore
    public boolean isTipPSLanResNameDirty() {
        return this.contains(FIELD_TIPPSLANRESNAME);
    }

    @JsonIgnore
    public String getTooltipInfo() {
        Object objValue = this.get(FIELD_TOOLTIPINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tooltipinfo")
    public void setTooltipInfo(String tooltipInfo) {
        this.set(FIELD_TOOLTIPINFO, tooltipInfo);
    }

    @JsonIgnore
    public boolean isTooltipInfoDirty() {
        return this.contains(FIELD_TOOLTIPINFO);
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
    public String getUserData() {
        Object objValue = this.get(FIELD_USERDATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata")
    public void setUserData(String userData) {
        this.set(FIELD_USERDATA, userData);
    }

    @JsonIgnore
    public boolean isUserDataDirty() {
        return this.contains(FIELD_USERDATA);
    }

    @JsonIgnore
    public String getUserData2() {
        Object objValue = this.get(FIELD_USERDATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userdata2")
    public void setUserData2(String userData2) {
        this.set(FIELD_USERDATA2, userData2);
    }

    @JsonIgnore
    public boolean isUserData2Dirty() {
        return this.contains(FIELD_USERDATA2);
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
        return this.getPSAppFuncId();
    }

    public void setSrfkey(String strValue) {
        this.setPSAppFuncId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSAPPFUNC";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSAppFunc item = (PSAppFunc)MAPPER.readValue(new File(strJsonFilePath), PSAppFunc.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSAppFunc) {
            PSAppFunc pSAppFunc = (PSAppFunc)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSAppFunc) {
            PSAppFunc pSAppFunc = (PSAppFunc)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

