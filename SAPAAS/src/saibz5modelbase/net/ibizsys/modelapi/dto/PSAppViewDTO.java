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
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSAppViewDTO
extends PSModelDTOBase {
    public static final String FIELD_ACCUSERMODE = "accusermode";
    public static final String FIELD_APPVIEWSN = "appviewsn";
    public static final String FIELD_APPVIEWSTATE = "appviewstate";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_DYNCMODE = "dyncmode";
    public static final String FIELD_ENABLEVIEWSTYLE = "enableviewstyle";
    public static final String FIELD_LAYOUTPANELMODE = "layoutpanelmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_PREVENTXSS = "preventxss";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSAPPLOCALDEID = "psapplocaldeid";
    public static final String FIELD_PSAPPLOCALDENAME = "psapplocaldename";
    public static final String FIELD_PSAPPMODULEID = "psappmoduleid";
    public static final String FIELD_PSAPPMODULENAME = "psappmodulename";
    public static final String FIELD_PSAPPTITLEBARID = "psapptitlebarid";
    public static final String FIELD_PSAPPTITLEBARNAME = "psapptitlebarname";
    public static final String FIELD_PSAPPUTILVIEWTYPE = "psapputilviewtype";
    public static final String FIELD_PSAPPVIEWID = "psappviewid";
    public static final String FIELD_PSAPPVIEWNAME = "psappviewname";
    public static final String FIELD_PSAPPVIEWTYPE = "psappviewtype";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEVIEWTYPE = "psdeviewtype";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "psdynadeviewtemplid";
    public static final String FIELD_PSDYNADEVIEWTEMPLNAME = "psdynadeviewtemplname";
    public static final String FIELD_PSDYNADEVIEWTYPE = "psdynadeviewtype";
    public static final String FIELD_PSHELPMODULEID = "pshelpmoduleid";
    public static final String FIELD_PSHELPMODULENAME = "pshelpmodulename";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFSTYLEID = "pspfstyleid";
    public static final String FIELD_PSPFSTYLENAME = "pspfstylename";
    public static final String FIELD_PSSUBVIEWTYPEID = "pssubviewtypeid";
    public static final String FIELD_PSSUBVIEWTYPENAME = "pssubviewtypename";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_PSVIEWENGINEID = "psviewengineid";
    public static final String FIELD_PSVIEWENGINENAME = "psviewenginename";
    public static final String FIELD_PSVIEWMSGGROUPID = "psviewmsggroupid";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "psviewmsggroupname";
    public static final String FIELD_PSVIEWWIZARDGROUPID = "psviewwizardgroupid";
    public static final String FIELD_PSVIEWWIZARDGROUPNAME = "psviewwizardgroupname";
    public static final String FIELD_SHOWCAPTIONBAR = "showcaptionbar";
    public static final String FIELD_SUBCAPPSLANRESID = "subcappslanresid";
    public static final String FIELD_SUBCAPPSLANRESNAME = "subcappslanresname";
    public static final String FIELD_SUBCAPTION = "subcaption";
    public static final String FIELD_SYNCCODENAME = "synccodename";
    public static final String FIELD_SYSREFFLAG = "sysrefflag";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    public static final String FIELD_TODOTASK = "todotask";
    public static final String FIELD_UISTYLE = "uistyle";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERREFFLAG = "userrefflag";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getAccUserMode() {
        Object objValue = this.get(FIELD_ACCUSERMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="accusermode")
    public void setAccUserMode(String accUserMode) {
        this.set(FIELD_ACCUSERMODE, accUserMode);
    }

    @JsonIgnore
    public boolean isAccUserModeDirty() {
        return this.contains(FIELD_ACCUSERMODE);
    }

    @JsonIgnore
    public String getAppViewSN() {
        Object objValue = this.get(FIELD_APPVIEWSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="appviewsn")
    public void setAppViewSN(String appViewSN) {
        this.set(FIELD_APPVIEWSN, appViewSN);
    }

    @JsonIgnore
    public boolean isAppViewSNDirty() {
        return this.contains(FIELD_APPVIEWSN);
    }

    @JsonIgnore
    public Integer getAppViewState() {
        Object objValue = this.get(FIELD_APPVIEWSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="appviewstate")
    public void setAppViewState(Integer appViewState) {
        this.set(FIELD_APPVIEWSTATE, appViewState);
    }

    @JsonIgnore
    public boolean isAppViewStateDirty() {
        return this.contains(FIELD_APPVIEWSTATE);
    }

    @JsonIgnore
    public String getCapPSLanResId() {
        Object objValue = this.get(FIELD_CAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresid")
    public void setCapPSLanResId(String capPSLanResId) {
        this.set(FIELD_CAPPSLANRESID, capPSLanResId);
    }

    @JsonIgnore
    public boolean isCapPSLanResIdDirty() {
        return this.contains(FIELD_CAPPSLANRESID);
    }

    @JsonIgnore
    public String getCapPSLanResName() {
        Object objValue = this.get(FIELD_CAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cappslanresname")
    public void setCapPSLanResName(String capPSLanResName) {
        this.set(FIELD_CAPPSLANRESNAME, capPSLanResName);
    }

    @JsonIgnore
    public boolean isCapPSLanResNameDirty() {
        return this.contains(FIELD_CAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getCaption() {
        Object objValue = this.get(FIELD_CAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="caption")
    public void setCaption(String caption) {
        this.set(FIELD_CAPTION, caption);
    }

    @JsonIgnore
    public boolean isCaptionDirty() {
        return this.contains(FIELD_CAPTION);
    }

    @JsonIgnore
    public String getColor() {
        Object objValue = this.get(FIELD_COLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="color")
    public void setColor(String color) {
        this.set(FIELD_COLOR, color);
    }

    @JsonIgnore
    public boolean isColorDirty() {
        return this.contains(FIELD_COLOR);
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
    public Integer getDyncMode() {
        Object objValue = this.get(FIELD_DYNCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dyncmode")
    public void setDyncMode(Integer dyncMode) {
        this.set(FIELD_DYNCMODE, dyncMode);
    }

    @JsonIgnore
    public boolean isDyncModeDirty() {
        return this.contains(FIELD_DYNCMODE);
    }

    @JsonIgnore
    public Integer getEnableViewStyle() {
        Object objValue = this.get(FIELD_ENABLEVIEWSTYLE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableviewstyle")
    public void setEnableViewStyle(Integer enableViewStyle) {
        this.set(FIELD_ENABLEVIEWSTYLE, enableViewStyle);
    }

    @JsonIgnore
    public boolean isEnableViewStyleDirty() {
        return this.contains(FIELD_ENABLEVIEWSTYLE);
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
    public String getModColor() {
        Object objValue = this.get(FIELD_MODCOLOR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modcolor")
    public void setModColor(String modColor) {
        this.set(FIELD_MODCOLOR, modColor);
    }

    @JsonIgnore
    public boolean isModColorDirty() {
        return this.contains(FIELD_MODCOLOR);
    }

    @JsonIgnore
    public Integer getPreventXSS() {
        Object objValue = this.get(FIELD_PREVENTXSS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preventxss")
    public void setPreventXSS(Integer preventXSS) {
        this.set(FIELD_PREVENTXSS, preventXSS);
    }

    @JsonIgnore
    public boolean isPreventXSSDirty() {
        return this.contains(FIELD_PREVENTXSS);
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
    public String getPSAppModuleId() {
        Object objValue = this.get(FIELD_PSAPPMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmoduleid")
    public void setPSAppModuleId(String pSAppModuleId) {
        this.set(FIELD_PSAPPMODULEID, pSAppModuleId);
    }

    @JsonIgnore
    public boolean isPSAppModuleIdDirty() {
        return this.contains(FIELD_PSAPPMODULEID);
    }

    @JsonIgnore
    public String getPSAppModuleName() {
        Object objValue = this.get(FIELD_PSAPPMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappmodulename")
    public void setPSAppModuleName(String pSAppModuleName) {
        this.set(FIELD_PSAPPMODULENAME, pSAppModuleName);
    }

    @JsonIgnore
    public boolean isPSAppModuleNameDirty() {
        return this.contains(FIELD_PSAPPMODULENAME);
    }

    @JsonIgnore
    public String getPSAppTitleBarId() {
        Object objValue = this.get(FIELD_PSAPPTITLEBARID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapptitlebarid")
    public void setPSAppTitleBarId(String pSAppTitleBarId) {
        this.set(FIELD_PSAPPTITLEBARID, pSAppTitleBarId);
    }

    @JsonIgnore
    public boolean isPSAppTitleBarIdDirty() {
        return this.contains(FIELD_PSAPPTITLEBARID);
    }

    @JsonIgnore
    public String getPSAppTitleBarName() {
        Object objValue = this.get(FIELD_PSAPPTITLEBARNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapptitlebarname")
    public void setPSAppTitleBarName(String pSAppTitleBarName) {
        this.set(FIELD_PSAPPTITLEBARNAME, pSAppTitleBarName);
    }

    @JsonIgnore
    public boolean isPSAppTitleBarNameDirty() {
        return this.contains(FIELD_PSAPPTITLEBARNAME);
    }

    @JsonIgnore
    public String getPSAppUtilViewType() {
        Object objValue = this.get(FIELD_PSAPPUTILVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapputilviewtype")
    public void setPSAppUtilViewType(String pSAppUtilViewType) {
        this.set(FIELD_PSAPPUTILVIEWTYPE, pSAppUtilViewType);
    }

    @JsonIgnore
    public boolean isPSAppUtilViewTypeDirty() {
        return this.contains(FIELD_PSAPPUTILVIEWTYPE);
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
    public String getPSAppViewType() {
        Object objValue = this.get(FIELD_PSAPPVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psappviewtype")
    public void setPSAppViewType(String pSAppViewType) {
        this.set(FIELD_PSAPPVIEWTYPE, pSAppViewType);
    }

    @JsonIgnore
    public boolean isPSAppViewTypeDirty() {
        return this.contains(FIELD_PSAPPVIEWTYPE);
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
    public String getPSDEViewBaseId() {
        Object objValue = this.get(FIELD_PSDEVIEWBASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbaseid")
    public void setPSDEViewBaseId(String pSDEViewBaseId) {
        this.set(FIELD_PSDEVIEWBASEID, pSDEViewBaseId);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseIdDirty() {
        return this.contains(FIELD_PSDEVIEWBASEID);
    }

    @JsonIgnore
    public String getPSDEViewBaseName() {
        Object objValue = this.get(FIELD_PSDEVIEWBASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasename")
    public void setPSDEViewBaseName(String pSDEViewBaseName) {
        this.set(FIELD_PSDEVIEWBASENAME, pSDEViewBaseName);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseNameDirty() {
        return this.contains(FIELD_PSDEVIEWBASENAME);
    }

    @JsonIgnore
    public String getPSDEViewType() {
        Object objValue = this.get(FIELD_PSDEVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewtype")
    public void setPSDEViewType(String pSDEViewType) {
        this.set(FIELD_PSDEVIEWTYPE, pSDEViewType);
    }

    @JsonIgnore
    public boolean isPSDEViewTypeDirty() {
        return this.contains(FIELD_PSDEVIEWTYPE);
    }

    @JsonIgnore
    public String getPSDynaDEViewTemplId() {
        Object objValue = this.get(FIELD_PSDYNADEVIEWTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeviewtemplid")
    public void setPSDynaDEViewTemplId(String pSDynaDEViewTemplId) {
        this.set(FIELD_PSDYNADEVIEWTEMPLID, pSDynaDEViewTemplId);
    }

    @JsonIgnore
    public boolean isPSDynaDEViewTemplIdDirty() {
        return this.contains(FIELD_PSDYNADEVIEWTEMPLID);
    }

    @JsonIgnore
    public String getPSDynaDEViewTemplName() {
        Object objValue = this.get(FIELD_PSDYNADEVIEWTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeviewtemplname")
    public void setPSDynaDEViewTemplName(String pSDynaDEViewTemplName) {
        this.set(FIELD_PSDYNADEVIEWTEMPLNAME, pSDynaDEViewTemplName);
    }

    @JsonIgnore
    public boolean isPSDynaDEViewTemplNameDirty() {
        return this.contains(FIELD_PSDYNADEVIEWTEMPLNAME);
    }

    @JsonIgnore
    public String getPSDynaDEViewType() {
        Object objValue = this.get(FIELD_PSDYNADEVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeviewtype")
    public void setPSDynaDEViewType(String pSDynaDEViewType) {
        this.set(FIELD_PSDYNADEVIEWTYPE, pSDynaDEViewType);
    }

    @JsonIgnore
    public boolean isPSDynaDEViewTypeDirty() {
        return this.contains(FIELD_PSDYNADEVIEWTYPE);
    }

    @JsonIgnore
    public String getPSHelpModuleId() {
        Object objValue = this.get(FIELD_PSHELPMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmoduleid")
    public void setPSHelpModuleId(String pSHelpModuleId) {
        this.set(FIELD_PSHELPMODULEID, pSHelpModuleId);
    }

    @JsonIgnore
    public boolean isPSHelpModuleIdDirty() {
        return this.contains(FIELD_PSHELPMODULEID);
    }

    @JsonIgnore
    public String getPSHelpModuleName() {
        Object objValue = this.get(FIELD_PSHELPMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pshelpmodulename")
    public void setPSHelpModuleName(String pSHelpModuleName) {
        this.set(FIELD_PSHELPMODULENAME, pSHelpModuleName);
    }

    @JsonIgnore
    public boolean isPSHelpModuleNameDirty() {
        return this.contains(FIELD_PSHELPMODULENAME);
    }

    @JsonIgnore
    public String getPSPFId() {
        Object objValue = this.get(FIELD_PSPFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfid")
    public void setPSPFId(String pSPFId) {
        this.set(FIELD_PSPFID, pSPFId);
    }

    @JsonIgnore
    public boolean isPSPFIdDirty() {
        return this.contains(FIELD_PSPFID);
    }

    @JsonIgnore
    public String getPSPFStyleId() {
        Object objValue = this.get(FIELD_PSPFSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstyleid")
    public void setPSPFStyleId(String pSPFStyleId) {
        this.set(FIELD_PSPFSTYLEID, pSPFStyleId);
    }

    @JsonIgnore
    public boolean isPSPFStyleIdDirty() {
        return this.contains(FIELD_PSPFSTYLEID);
    }

    @JsonIgnore
    public String getPSPFStyleName() {
        Object objValue = this.get(FIELD_PSPFSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfstylename")
    public void setPSPFStyleName(String pSPFStyleName) {
        this.set(FIELD_PSPFSTYLENAME, pSPFStyleName);
    }

    @JsonIgnore
    public boolean isPSPFStyleNameDirty() {
        return this.contains(FIELD_PSPFSTYLENAME);
    }

    @JsonIgnore
    public String getPSSubViewTypeId() {
        Object objValue = this.get(FIELD_PSSUBVIEWTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubviewtypeid")
    public void setPSSubViewTypeId(String pSSubViewTypeId) {
        this.set(FIELD_PSSUBVIEWTYPEID, pSSubViewTypeId);
    }

    @JsonIgnore
    public boolean isPSSubViewTypeIdDirty() {
        return this.contains(FIELD_PSSUBVIEWTYPEID);
    }

    @JsonIgnore
    public String getPSSubViewTypeName() {
        Object objValue = this.get(FIELD_PSSUBVIEWTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubviewtypename")
    public void setPSSubViewTypeName(String pSSubViewTypeName) {
        this.set(FIELD_PSSUBVIEWTYPENAME, pSSubViewTypeName);
    }

    @JsonIgnore
    public boolean isPSSubViewTypeNameDirty() {
        return this.contains(FIELD_PSSUBVIEWTYPENAME);
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
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
    }

    @JsonIgnore
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
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
    public String getPSViewEngineId() {
        Object objValue = this.get(FIELD_PSVIEWENGINEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewengineid")
    public void setPSViewEngineId(String pSViewEngineId) {
        this.set(FIELD_PSVIEWENGINEID, pSViewEngineId);
    }

    @JsonIgnore
    public boolean isPSViewEngineIdDirty() {
        return this.contains(FIELD_PSVIEWENGINEID);
    }

    @JsonIgnore
    public String getPSViewEngineName() {
        Object objValue = this.get(FIELD_PSVIEWENGINENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewenginename")
    public void setPSViewEngineName(String pSViewEngineName) {
        this.set(FIELD_PSVIEWENGINENAME, pSViewEngineName);
    }

    @JsonIgnore
    public boolean isPSViewEngineNameDirty() {
        return this.contains(FIELD_PSVIEWENGINENAME);
    }

    @JsonIgnore
    public String getPSViewMsgGroupId() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupid")
    public void setPSViewMsgGroupId(String pSViewMsgGroupId) {
        this.set(FIELD_PSVIEWMSGGROUPID, pSViewMsgGroupId);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupIdDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPID);
    }

    @JsonIgnore
    public String getPSViewMsgGroupName() {
        Object objValue = this.get(FIELD_PSVIEWMSGGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsggroupname")
    public void setPSViewMsgGroupName(String pSViewMsgGroupName) {
        this.set(FIELD_PSVIEWMSGGROUPNAME, pSViewMsgGroupName);
    }

    @JsonIgnore
    public boolean isPSViewMsgGroupNameDirty() {
        return this.contains(FIELD_PSVIEWMSGGROUPNAME);
    }

    @JsonIgnore
    public String getPSViewWizardGroupId() {
        Object objValue = this.get(FIELD_PSVIEWWIZARDGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewwizardgroupid")
    public void setPSViewWizardGroupId(String pSViewWizardGroupId) {
        this.set(FIELD_PSVIEWWIZARDGROUPID, pSViewWizardGroupId);
    }

    @JsonIgnore
    public boolean isPSViewWizardGroupIdDirty() {
        return this.contains(FIELD_PSVIEWWIZARDGROUPID);
    }

    @JsonIgnore
    public String getPSViewWizardGroupName() {
        Object objValue = this.get(FIELD_PSVIEWWIZARDGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewwizardgroupname")
    public void setPSViewWizardGroupName(String pSViewWizardGroupName) {
        this.set(FIELD_PSVIEWWIZARDGROUPNAME, pSViewWizardGroupName);
    }

    @JsonIgnore
    public boolean isPSViewWizardGroupNameDirty() {
        return this.contains(FIELD_PSVIEWWIZARDGROUPNAME);
    }

    @JsonIgnore
    public Integer getShowCaptionBar() {
        Object objValue = this.get(FIELD_SHOWCAPTIONBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showcaptionbar")
    public void setShowCaptionBar(Integer showCaptionBar) {
        this.set(FIELD_SHOWCAPTIONBAR, showCaptionBar);
    }

    @JsonIgnore
    public boolean isShowCaptionBarDirty() {
        return this.contains(FIELD_SHOWCAPTIONBAR);
    }

    @JsonIgnore
    public String getSubCapPSLanResId() {
        Object objValue = this.get(FIELD_SUBCAPPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subcappslanresid")
    public void setSubCapPSLanResId(String subCapPSLanResId) {
        this.set(FIELD_SUBCAPPSLANRESID, subCapPSLanResId);
    }

    @JsonIgnore
    public boolean isSubCapPSLanResIdDirty() {
        return this.contains(FIELD_SUBCAPPSLANRESID);
    }

    @JsonIgnore
    public String getSubCapPSLanResName() {
        Object objValue = this.get(FIELD_SUBCAPPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subcappslanresname")
    public void setSubCapPSLanResName(String subCapPSLanResName) {
        this.set(FIELD_SUBCAPPSLANRESNAME, subCapPSLanResName);
    }

    @JsonIgnore
    public boolean isSubCapPSLanResNameDirty() {
        return this.contains(FIELD_SUBCAPPSLANRESNAME);
    }

    @JsonIgnore
    public String getSubCaption() {
        Object objValue = this.get(FIELD_SUBCAPTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="subcaption")
    public void setSubCaption(String subCaption) {
        this.set(FIELD_SUBCAPTION, subCaption);
    }

    @JsonIgnore
    public boolean isSubCaptionDirty() {
        return this.contains(FIELD_SUBCAPTION);
    }

    @JsonIgnore
    public Integer getSyncCodeName() {
        Object objValue = this.get(FIELD_SYNCCODENAME);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="synccodename")
    public void setSyncCodeName(Integer syncCodeName) {
        this.set(FIELD_SYNCCODENAME, syncCodeName);
    }

    @JsonIgnore
    public boolean isSyncCodeNameDirty() {
        return this.contains(FIELD_SYNCCODENAME);
    }

    @JsonIgnore
    public Integer getSysRefFlag() {
        Object objValue = this.get(FIELD_SYSREFFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sysrefflag")
    public void setSysRefFlag(Integer sysRefFlag) {
        this.set(FIELD_SYSREFFLAG, sysRefFlag);
    }

    @JsonIgnore
    public boolean isSysRefFlagDirty() {
        return this.contains(FIELD_SYSREFFLAG);
    }

    @JsonIgnore
    public String getTitle() {
        Object objValue = this.get(FIELD_TITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="title")
    public void setTitle(String title) {
        this.set(FIELD_TITLE, title);
    }

    @JsonIgnore
    public boolean isTitleDirty() {
        return this.contains(FIELD_TITLE);
    }

    @JsonIgnore
    public String getTitlePSLanResId() {
        Object objValue = this.get(FIELD_TITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresid")
    public void setTitlePSLanResId(String titlePSLanResId) {
        this.set(FIELD_TITLEPSLANRESID, titlePSLanResId);
    }

    @JsonIgnore
    public boolean isTitlePSLanResIdDirty() {
        return this.contains(FIELD_TITLEPSLANRESID);
    }

    @JsonIgnore
    public String getTitlePSLanResName() {
        Object objValue = this.get(FIELD_TITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresname")
    public void setTitlePSLanResName(String titlePSLanResName) {
        this.set(FIELD_TITLEPSLANRESNAME, titlePSLanResName);
    }

    @JsonIgnore
    public boolean isTitlePSLanResNameDirty() {
        return this.contains(FIELD_TITLEPSLANRESNAME);
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
    public String getUIStyle() {
        Object objValue = this.get(FIELD_UISTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uistyle")
    public void setUIStyle(String uIStyle) {
        this.set(FIELD_UISTYLE, uIStyle);
    }

    @JsonIgnore
    public boolean isUIStyleDirty() {
        return this.contains(FIELD_UISTYLE);
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

    @JsonIgnore
    public Integer getUserRefFlag() {
        Object objValue = this.get(FIELD_USERREFFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="userrefflag")
    public void setUserRefFlag(Integer userRefFlag) {
        this.set(FIELD_USERREFFLAG, userRefFlag);
    }

    @JsonIgnore
    public boolean isUserRefFlagDirty() {
        return this.contains(FIELD_USERREFFLAG);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSAppViewId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppViewId(strValue);
    }
}

