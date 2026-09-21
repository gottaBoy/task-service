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
import net.ibizsys.modelapi.dto.PSDEFDLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEFIVRDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFormLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFormRFDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEFormDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_COPYPSDEACTIONID = "copypsdeactionid";
    public static final String FIELD_COPYPSDEACTIONNAME = "copypsdeactionname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CREATEPSDEACTIONID = "createpsdeactionid";
    public static final String FIELD_CREATEPSDEACTIONNAME = "createpsdeactionname";
    public static final String FIELD_CTRLCOLSPAN = "ctrlcolspan";
    public static final String FIELD_DATATYPE = "datatype";
    public static final String FIELD_DETAILSTYLE = "detailstyle";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_DYNASYSREFMODE = "dynasysrefmode";
    public static final String FIELD_ENABLEADVSEARCH = "enableadvsearch";
    public static final String FIELD_FORMITEMSTYLE = "formitemstyle";
    public static final String FIELD_FORMNAVBAR = "formnavbar";
    public static final String FIELD_FORMSN = "formsn";
    public static final String FIELD_FORMSTYLE = "formstyle";
    public static final String FIELD_FORMTAG = "formtag";
    public static final String FIELD_FORMTAG2 = "formtag2";
    public static final String FIELD_FORMTAG3 = "formtag3";
    public static final String FIELD_FORMTAG4 = "formtag4";
    public static final String FIELD_FORMTYPE = "formtype";
    public static final String FIELD_FORMWIDTH = "formwidth";
    public static final String FIELD_FUNCMODE = "funcmode";
    public static final String FIELD_GETDRAFTPSDEACTIONID = "getdraftpsdeactionid";
    public static final String FIELD_GETDRAFTPSDEACTIONNAME = "getdraftpsdeactionname";
    public static final String FIELD_GETPSDEACTIONID = "getpsdeactionid";
    public static final String FIELD_GETPSDEACTIONNAME = "getpsdeactionname";
    public static final String FIELD_INFOFORMFLAG = "infoformflag";
    public static final String FIELD_LABELCOLSPAN = "labelcolspan";
    public static final String FIELD_LABELCOLSPAN2 = "labelcolspan2";
    public static final String FIELD_LABELWIDTH = "labelwidth";
    public static final String FIELD_LAYOUTMODE = "layoutmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MOBFLAG = "mobflag";
    public static final String FIELD_NAVBARHEIGHT = "navbarheight";
    public static final String FIELD_NAVBARPOS = "navbarpos";
    public static final String FIELD_NAVBARPSSYSCSSID = "navbarpssyscssid";
    public static final String FIELD_NAVBARPSSYSCSSNAME = "navbarpssyscssname";
    public static final String FIELD_NAVBARSTYLE = "navbarstyle";
    public static final String FIELD_NAVBARWIDTH = "navbarwidth";
    public static final String FIELD_PDVTPARAM = "pdvtparam";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSCTRLMSGID = "psctrlmsgid";
    public static final String FIELD_PSCTRLMSGNAME = "psctrlmsgname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDYNADEFORMID = "psdynadeformid";
    public static final String FIELD_PSDYNADEFORMINSTID = "psdynadeforminstid";
    public static final String FIELD_PSDYNADEFORMINSTNAME = "psdynadeforminstname";
    public static final String FIELD_PSDYNADEFORMNAME = "psdynadeformname";
    public static final String FIELD_PSDYNAINSTNAME = "psdynainstname";
    public static final String FIELD_PSPFID = "pspfid";
    public static final String FIELD_PSPFNAME = "pspfname";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_REMOVEPSDEACTIONID = "removepsdeactionid";
    public static final String FIELD_REMOVEPSDEACTIONNAME = "removepsdeactionname";
    public static final String FIELD_SEARCHBTNPOS = "searchbtnpos";
    public static final String FIELD_SEARCHBTNSTYLE = "searchbtnstyle";
    public static final String FIELD_SHOWTABHEADER = "showtabheader";
    public static final String FIELD_TABHEADERPOS = "tabheaderpos";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_UPDATEPSDEACTIONID = "updatepsdeactionid";
    public static final String FIELD_UPDATEPSDEACTIONNAME = "updatepsdeactionname";
    public static final String FIELD_USER2PSDEACTIONID = "user2psdeactionid";
    public static final String FIELD_USER2PSDEACTIONNAME = "user2psdeactionname";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERPSDEACTIONID = "userpsdeactionid";
    public static final String FIELD_USERPSDEACTIONNAME = "userpsdeactionname";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    private List<PSDEFormDetailDTO> psdeformdetails;
    private List<PSDEFormRFDTO> psdeformrves;
    private List<PSDEFDLogicDTO> psdefdlogics;
    private List<PSDEFIUDetailDTO> psdefiudetails;
    private List<PSDEFIUpdateDTO> psdefiupdates;
    private List<PSDEFIVRDTO> psdefivrs;
    private List<PSDEFormLogicDTO> psdeformlogics;

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
    public String getCopyPSDEActionId() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionid")
    public void setCopyPSDEActionId(String copyPSDEActionId) {
        this.set(FIELD_COPYPSDEACTIONID, copyPSDEActionId);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionIdDirty() {
        return this.contains(FIELD_COPYPSDEACTIONID);
    }

    @JsonIgnore
    public String getCopyPSDEActionName() {
        Object objValue = this.get(FIELD_COPYPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="copypsdeactionname")
    public void setCopyPSDEActionName(String copyPSDEActionName) {
        this.set(FIELD_COPYPSDEACTIONNAME, copyPSDEActionName);
    }

    @JsonIgnore
    public boolean isCopyPSDEActionNameDirty() {
        return this.contains(FIELD_COPYPSDEACTIONNAME);
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
    public Integer getCtrlColSpan() {
        Object objValue = this.get(FIELD_CTRLCOLSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlcolspan")
    public void setCtrlColSpan(Integer ctrlColSpan) {
        this.set(FIELD_CTRLCOLSPAN, ctrlColSpan);
    }

    @JsonIgnore
    public boolean isCtrlColSpanDirty() {
        return this.contains(FIELD_CTRLCOLSPAN);
    }

    @JsonIgnore
    public String getDataType() {
        Object objValue = this.get(FIELD_DATATYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatype")
    public void setDataType(String dataType) {
        this.set(FIELD_DATATYPE, dataType);
    }

    @JsonIgnore
    public boolean isDataTypeDirty() {
        return this.contains(FIELD_DATATYPE);
    }

    @JsonIgnore
    public String getDetailStyle() {
        Object objValue = this.get(FIELD_DETAILSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="detailstyle")
    public void setDetailStyle(String detailStyle) {
        this.set(FIELD_DETAILSTYLE, detailStyle);
    }

    @JsonIgnore
    public boolean isDetailStyleDirty() {
        return this.contains(FIELD_DETAILSTYLE);
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
    public Integer getDynaSysRefMode() {
        Object objValue = this.get(FIELD_DYNASYSREFMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynasysrefmode")
    public void setDynaSysRefMode(Integer dynaSysRefMode) {
        this.set(FIELD_DYNASYSREFMODE, dynaSysRefMode);
    }

    @JsonIgnore
    public boolean isDynaSysRefModeDirty() {
        return this.contains(FIELD_DYNASYSREFMODE);
    }

    @JsonIgnore
    public Integer getEnableAdvSearch() {
        Object objValue = this.get(FIELD_ENABLEADVSEARCH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableadvsearch")
    public void setEnableAdvSearch(Integer enableAdvSearch) {
        this.set(FIELD_ENABLEADVSEARCH, enableAdvSearch);
    }

    @JsonIgnore
    public boolean isEnableAdvSearchDirty() {
        return this.contains(FIELD_ENABLEADVSEARCH);
    }

    @JsonIgnore
    public String getFormItemStyle() {
        Object objValue = this.get(FIELD_FORMITEMSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formitemstyle")
    public void setFormItemStyle(String formItemStyle) {
        this.set(FIELD_FORMITEMSTYLE, formItemStyle);
    }

    @JsonIgnore
    public boolean isFormItemStyleDirty() {
        return this.contains(FIELD_FORMITEMSTYLE);
    }

    @JsonIgnore
    public Integer getFormNavBar() {
        Object objValue = this.get(FIELD_FORMNAVBAR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="formnavbar")
    public void setFormNavBar(Integer formNavBar) {
        this.set(FIELD_FORMNAVBAR, formNavBar);
    }

    @JsonIgnore
    public boolean isFormNavBarDirty() {
        return this.contains(FIELD_FORMNAVBAR);
    }

    @JsonIgnore
    public String getFormSN() {
        Object objValue = this.get(FIELD_FORMSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formsn")
    public void setFormSN(String formSN) {
        this.set(FIELD_FORMSN, formSN);
    }

    @JsonIgnore
    public boolean isFormSNDirty() {
        return this.contains(FIELD_FORMSN);
    }

    @JsonIgnore
    public String getFormStyle() {
        Object objValue = this.get(FIELD_FORMSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formstyle")
    public void setFormStyle(String formStyle) {
        this.set(FIELD_FORMSTYLE, formStyle);
    }

    @JsonIgnore
    public boolean isFormStyleDirty() {
        return this.contains(FIELD_FORMSTYLE);
    }

    @JsonIgnore
    public String getFormTag() {
        Object objValue = this.get(FIELD_FORMTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtag")
    public void setFormTag(String formTag) {
        this.set(FIELD_FORMTAG, formTag);
    }

    @JsonIgnore
    public boolean isFormTagDirty() {
        return this.contains(FIELD_FORMTAG);
    }

    @JsonIgnore
    public String getFormTag2() {
        Object objValue = this.get(FIELD_FORMTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtag2")
    public void setFormTag2(String formTag2) {
        this.set(FIELD_FORMTAG2, formTag2);
    }

    @JsonIgnore
    public boolean isFormTag2Dirty() {
        return this.contains(FIELD_FORMTAG2);
    }

    @JsonIgnore
    public String getFormTag3() {
        Object objValue = this.get(FIELD_FORMTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtag3")
    public void setFormTag3(String formTag3) {
        this.set(FIELD_FORMTAG3, formTag3);
    }

    @JsonIgnore
    public boolean isFormTag3Dirty() {
        return this.contains(FIELD_FORMTAG3);
    }

    @JsonIgnore
    public String getFormTag4() {
        Object objValue = this.get(FIELD_FORMTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtag4")
    public void setFormTag4(String formTag4) {
        this.set(FIELD_FORMTAG4, formTag4);
    }

    @JsonIgnore
    public boolean isFormTag4Dirty() {
        return this.contains(FIELD_FORMTAG4);
    }

    @JsonIgnore
    public String getFormType() {
        Object objValue = this.get(FIELD_FORMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formtype")
    public void setFormType(String formType) {
        this.set(FIELD_FORMTYPE, formType);
    }

    @JsonIgnore
    public boolean isFormTypeDirty() {
        return this.contains(FIELD_FORMTYPE);
    }

    @JsonIgnore
    public Integer getFormWidth() {
        Object objValue = this.get(FIELD_FORMWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="formwidth")
    public void setFormWidth(Integer formWidth) {
        this.set(FIELD_FORMWIDTH, formWidth);
    }

    @JsonIgnore
    public boolean isFormWidthDirty() {
        return this.contains(FIELD_FORMWIDTH);
    }

    @JsonIgnore
    public String getFuncMode() {
        Object objValue = this.get(FIELD_FUNCMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="funcmode")
    public void setFuncMode(String funcMode) {
        this.set(FIELD_FUNCMODE, funcMode);
    }

    @JsonIgnore
    public boolean isFuncModeDirty() {
        return this.contains(FIELD_FUNCMODE);
    }

    @JsonIgnore
    public String getGetDraftPSDEActionId() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionid")
    public void setGetDraftPSDEActionId(String getDraftPSDEActionId) {
        this.set(FIELD_GETDRAFTPSDEACTIONID, getDraftPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionIdDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetDraftPSDEActionName() {
        Object objValue = this.get(FIELD_GETDRAFTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getdraftpsdeactionname")
    public void setGetDraftPSDEActionName(String getDraftPSDEActionName) {
        this.set(FIELD_GETDRAFTPSDEACTIONNAME, getDraftPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetDraftPSDEActionNameDirty() {
        return this.contains(FIELD_GETDRAFTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getGetPSDEActionId() {
        Object objValue = this.get(FIELD_GETPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionid")
    public void setGetPSDEActionId(String getPSDEActionId) {
        this.set(FIELD_GETPSDEACTIONID, getPSDEActionId);
    }

    @JsonIgnore
    public boolean isGetPSDEActionIdDirty() {
        return this.contains(FIELD_GETPSDEACTIONID);
    }

    @JsonIgnore
    public String getGetPSDEActionName() {
        Object objValue = this.get(FIELD_GETPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="getpsdeactionname")
    public void setGetPSDEActionName(String getPSDEActionName) {
        this.set(FIELD_GETPSDEACTIONNAME, getPSDEActionName);
    }

    @JsonIgnore
    public boolean isGetPSDEActionNameDirty() {
        return this.contains(FIELD_GETPSDEACTIONNAME);
    }

    @JsonIgnore
    public Integer getInfoFormFlag() {
        Object objValue = this.get(FIELD_INFOFORMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="infoformflag")
    public void setInfoFormFlag(Integer infoFormFlag) {
        this.set(FIELD_INFOFORMFLAG, infoFormFlag);
    }

    @JsonIgnore
    public boolean isInfoFormFlagDirty() {
        return this.contains(FIELD_INFOFORMFLAG);
    }

    @JsonIgnore
    public Integer getLabelColSpan() {
        Object objValue = this.get(FIELD_LABELCOLSPAN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelcolspan")
    public void setLabelColSpan(Integer labelColSpan) {
        this.set(FIELD_LABELCOLSPAN, labelColSpan);
    }

    @JsonIgnore
    public boolean isLabelColSpanDirty() {
        return this.contains(FIELD_LABELCOLSPAN);
    }

    @JsonIgnore
    public Integer getLabelColSpan2() {
        Object objValue = this.get(FIELD_LABELCOLSPAN2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelcolspan2")
    public void setLabelColSpan2(Integer labelColSpan2) {
        this.set(FIELD_LABELCOLSPAN2, labelColSpan2);
    }

    @JsonIgnore
    public boolean isLabelColSpan2Dirty() {
        return this.contains(FIELD_LABELCOLSPAN2);
    }

    @JsonIgnore
    public Integer getLabelWidth() {
        Object objValue = this.get(FIELD_LABELWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="labelwidth")
    public void setLabelWidth(Integer labelWidth) {
        this.set(FIELD_LABELWIDTH, labelWidth);
    }

    @JsonIgnore
    public boolean isLabelWidthDirty() {
        return this.contains(FIELD_LABELWIDTH);
    }

    @JsonIgnore
    public String getLayoutMode() {
        Object objValue = this.get(FIELD_LAYOUTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="layoutmode")
    public void setLayoutMode(String layoutMode) {
        this.set(FIELD_LAYOUTMODE, layoutMode);
    }

    @JsonIgnore
    public boolean isLayoutModeDirty() {
        return this.contains(FIELD_LAYOUTMODE);
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
    public Integer getNavBarHeight() {
        Object objValue = this.get(FIELD_NAVBARHEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="navbarheight")
    public void setNavBarHeight(Integer navBarHeight) {
        this.set(FIELD_NAVBARHEIGHT, navBarHeight);
    }

    @JsonIgnore
    public boolean isNavBarHeightDirty() {
        return this.contains(FIELD_NAVBARHEIGHT);
    }

    @JsonIgnore
    public String getNavBarPos() {
        Object objValue = this.get(FIELD_NAVBARPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpos")
    public void setNavBarPos(String navBarPos) {
        this.set(FIELD_NAVBARPOS, navBarPos);
    }

    @JsonIgnore
    public boolean isNavBarPosDirty() {
        return this.contains(FIELD_NAVBARPOS);
    }

    @JsonIgnore
    public String getNavBarPSSysCssId() {
        Object objValue = this.get(FIELD_NAVBARPSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpssyscssid")
    public void setNavBarPSSysCssId(String navBarPSSysCssId) {
        this.set(FIELD_NAVBARPSSYSCSSID, navBarPSSysCssId);
    }

    @JsonIgnore
    public boolean isNavBarPSSysCssIdDirty() {
        return this.contains(FIELD_NAVBARPSSYSCSSID);
    }

    @JsonIgnore
    public String getNavBarPSSysCssName() {
        Object objValue = this.get(FIELD_NAVBARPSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarpssyscssname")
    public void setNavBarPSSysCssName(String navBarPSSysCssName) {
        this.set(FIELD_NAVBARPSSYSCSSNAME, navBarPSSysCssName);
    }

    @JsonIgnore
    public boolean isNavBarPSSysCssNameDirty() {
        return this.contains(FIELD_NAVBARPSSYSCSSNAME);
    }

    @JsonIgnore
    public String getNavBarStyle() {
        Object objValue = this.get(FIELD_NAVBARSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="navbarstyle")
    public void setNavBarStyle(String navBarStyle) {
        this.set(FIELD_NAVBARSTYLE, navBarStyle);
    }

    @JsonIgnore
    public boolean isNavBarStyleDirty() {
        return this.contains(FIELD_NAVBARSTYLE);
    }

    @JsonIgnore
    public Integer getNavBarWidth() {
        Object objValue = this.get(FIELD_NAVBARWIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="navbarwidth")
    public void setNavBarWidth(Integer navBarWidth) {
        this.set(FIELD_NAVBARWIDTH, navBarWidth);
    }

    @JsonIgnore
    public boolean isNavBarWidthDirty() {
        return this.contains(FIELD_NAVBARWIDTH);
    }

    @JsonIgnore
    public String getPDVTParam() {
        Object objValue = this.get(FIELD_PDVTPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pdvtparam")
    public void setPDVTParam(String pDVTParam) {
        this.set(FIELD_PDVTPARAM, pDVTParam);
    }

    @JsonIgnore
    public boolean isPDVTParamDirty() {
        return this.contains(FIELD_PDVTPARAM);
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
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
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
    public String getPSDynaDEFormId() {
        Object objValue = this.get(FIELD_PSDYNADEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeformid")
    public void setPSDynaDEFormId(String pSDynaDEFormId) {
        this.set(FIELD_PSDYNADEFORMID, pSDynaDEFormId);
    }

    @JsonIgnore
    public boolean isPSDynaDEFormIdDirty() {
        return this.contains(FIELD_PSDYNADEFORMID);
    }

    @JsonIgnore
    public String getPSDynaDEFormInstId() {
        Object objValue = this.get(FIELD_PSDYNADEFORMINSTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeforminstid")
    public void setPSDynaDEFormInstId(String pSDynaDEFormInstId) {
        this.set(FIELD_PSDYNADEFORMINSTID, pSDynaDEFormInstId);
    }

    @JsonIgnore
    public boolean isPSDynaDEFormInstIdDirty() {
        return this.contains(FIELD_PSDYNADEFORMINSTID);
    }

    @JsonIgnore
    public String getPSDynaDEFormInstName() {
        Object objValue = this.get(FIELD_PSDYNADEFORMINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeforminstname")
    public void setPSDynaDEFormInstName(String pSDynaDEFormInstName) {
        this.set(FIELD_PSDYNADEFORMINSTNAME, pSDynaDEFormInstName);
    }

    @JsonIgnore
    public boolean isPSDynaDEFormInstNameDirty() {
        return this.contains(FIELD_PSDYNADEFORMINSTNAME);
    }

    @JsonIgnore
    public String getPSDynaDEFormName() {
        Object objValue = this.get(FIELD_PSDYNADEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynadeformname")
    public void setPSDynaDEFormName(String pSDynaDEFormName) {
        this.set(FIELD_PSDYNADEFORMNAME, pSDynaDEFormName);
    }

    @JsonIgnore
    public boolean isPSDynaDEFormNameDirty() {
        return this.contains(FIELD_PSDYNADEFORMNAME);
    }

    @JsonIgnore
    public String getPSDynaInstName() {
        Object objValue = this.get(FIELD_PSDYNAINSTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdynainstname")
    public void setPSDynaInstName(String pSDynaInstName) {
        this.set(FIELD_PSDYNAINSTNAME, pSDynaInstName);
    }

    @JsonIgnore
    public boolean isPSDynaInstNameDirty() {
        return this.contains(FIELD_PSDYNAINSTNAME);
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
    public String getPSPFName() {
        Object objValue = this.get(FIELD_PSPFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pspfname")
    public void setPSPFName(String pSPFName) {
        this.set(FIELD_PSPFNAME, pSPFName);
    }

    @JsonIgnore
    public boolean isPSPFNameDirty() {
        return this.contains(FIELD_PSPFNAME);
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
    public String getRemovePSDEActionId() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionid")
    public void setRemovePSDEActionId(String removePSDEActionId) {
        this.set(FIELD_REMOVEPSDEACTIONID, removePSDEActionId);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionIdDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONID);
    }

    @JsonIgnore
    public String getRemovePSDEActionName() {
        Object objValue = this.get(FIELD_REMOVEPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdeactionname")
    public void setRemovePSDEActionName(String removePSDEActionName) {
        this.set(FIELD_REMOVEPSDEACTIONNAME, removePSDEActionName);
    }

    @JsonIgnore
    public boolean isRemovePSDEActionNameDirty() {
        return this.contains(FIELD_REMOVEPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getSearchBtnPos() {
        Object objValue = this.get(FIELD_SEARCHBTNPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchbtnpos")
    public void setSearchBtnPos(String searchBtnPos) {
        this.set(FIELD_SEARCHBTNPOS, searchBtnPos);
    }

    @JsonIgnore
    public boolean isSearchBtnPosDirty() {
        return this.contains(FIELD_SEARCHBTNPOS);
    }

    @JsonIgnore
    public String getSearchBtnStyle() {
        Object objValue = this.get(FIELD_SEARCHBTNSTYLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="searchbtnstyle")
    public void setSearchBtnStyle(String searchBtnStyle) {
        this.set(FIELD_SEARCHBTNSTYLE, searchBtnStyle);
    }

    @JsonIgnore
    public boolean isSearchBtnStyleDirty() {
        return this.contains(FIELD_SEARCHBTNSTYLE);
    }

    @JsonIgnore
    public Integer getShowTabHeader() {
        Object objValue = this.get(FIELD_SHOWTABHEADER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="showtabheader")
    public void setShowTabHeader(Integer showTabHeader) {
        this.set(FIELD_SHOWTABHEADER, showTabHeader);
    }

    @JsonIgnore
    public boolean isShowTabHeaderDirty() {
        return this.contains(FIELD_SHOWTABHEADER);
    }

    @JsonIgnore
    public String getTabHeaderPos() {
        Object objValue = this.get(FIELD_TABHEADERPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="tabheaderpos")
    public void setTabHeaderPos(String tabHeaderPos) {
        this.set(FIELD_TABHEADERPOS, tabHeaderPos);
    }

    @JsonIgnore
    public boolean isTabHeaderPosDirty() {
        return this.contains(FIELD_TABHEADERPOS);
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
    public String getUser2PSDEActionId() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionid")
    public void setUser2PSDEActionId(String user2PSDEActionId) {
        this.set(FIELD_USER2PSDEACTIONID, user2PSDEActionId);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionIdDirty() {
        return this.contains(FIELD_USER2PSDEACTIONID);
    }

    @JsonIgnore
    public String getUser2PSDEActionName() {
        Object objValue = this.get(FIELD_USER2PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="user2psdeactionname")
    public void setUser2PSDEActionName(String user2PSDEActionName) {
        this.set(FIELD_USER2PSDEACTIONNAME, user2PSDEActionName);
    }

    @JsonIgnore
    public boolean isUser2PSDEActionNameDirty() {
        return this.contains(FIELD_USER2PSDEACTIONNAME);
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
    public String getUserPSDEActionId() {
        Object objValue = this.get(FIELD_USERPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionid")
    public void setUserPSDEActionId(String userPSDEActionId) {
        this.set(FIELD_USERPSDEACTIONID, userPSDEActionId);
    }

    @JsonIgnore
    public boolean isUserPSDEActionIdDirty() {
        return this.contains(FIELD_USERPSDEACTIONID);
    }

    @JsonIgnore
    public String getUserPSDEActionName() {
        Object objValue = this.get(FIELD_USERPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userpsdeactionname")
    public void setUserPSDEActionName(String userPSDEActionName) {
        this.set(FIELD_USERPSDEACTIONNAME, userPSDEActionName);
    }

    @JsonIgnore
    public boolean isUserPSDEActionNameDirty() {
        return this.contains(FIELD_USERPSDEACTIONNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEFormId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEFormId(strValue);
    }

    @JsonProperty(value="psdeformdetails")
    public List<PSDEFormDetailDTO> getPsdeformdetails() {
        return this.psdeformdetails;
    }

    @JsonProperty(value="psdeformdetails")
    public void setPsdeformdetails(List<PSDEFormDetailDTO> psdeformdetails) {
        this.psdeformdetails = psdeformdetails;
    }

    @JsonProperty(value="psdeformrves")
    public List<PSDEFormRFDTO> getPsdeformrves() {
        return this.psdeformrves;
    }

    @JsonProperty(value="psdeformrves")
    public void setPsdeformrves(List<PSDEFormRFDTO> psdeformrves) {
        this.psdeformrves = psdeformrves;
    }

    @JsonProperty(value="psdefdlogics")
    public List<PSDEFDLogicDTO> getPsdefdlogics() {
        return this.psdefdlogics;
    }

    @JsonProperty(value="psdefdlogics")
    public void setPsdefdlogics(List<PSDEFDLogicDTO> psdefdlogics) {
        this.psdefdlogics = psdefdlogics;
    }

    @JsonProperty(value="psdefiudetails")
    public List<PSDEFIUDetailDTO> getPsdefiudetails() {
        return this.psdefiudetails;
    }

    @JsonProperty(value="psdefiudetails")
    public void setPsdefiudetails(List<PSDEFIUDetailDTO> psdefiudetails) {
        this.psdefiudetails = psdefiudetails;
    }

    @JsonProperty(value="psdefiupdates")
    public List<PSDEFIUpdateDTO> getPsdefiupdates() {
        return this.psdefiupdates;
    }

    @JsonProperty(value="psdefiupdates")
    public void setPsdefiupdates(List<PSDEFIUpdateDTO> psdefiupdates) {
        this.psdefiupdates = psdefiupdates;
    }

    @JsonProperty(value="psdefivrs")
    public List<PSDEFIVRDTO> getPsdefivrs() {
        return this.psdefivrs;
    }

    @JsonProperty(value="psdefivrs")
    public void setPsdefivrs(List<PSDEFIVRDTO> psdefivrs) {
        this.psdefivrs = psdefivrs;
    }

    @JsonProperty(value="psdeformlogics")
    public List<PSDEFormLogicDTO> getPsdeformlogics() {
        return this.psdeformlogics;
    }

    @JsonProperty(value="psdeformlogics")
    public void setPsdeformlogics(List<PSDEFormLogicDTO> psdeformlogics) {
        this.psdeformlogics = psdeformlogics;
    }
}

