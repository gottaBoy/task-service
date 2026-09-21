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

public class PSSysEditorStyleDTO
extends PSModelDTOBase {
    public static final String FIELD_AJAXHANDLER = "ajaxhandler";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTAINERTYPE = "containertype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CTRLPARAM = "ctrlparam";
    public static final String FIELD_CTRLPARAM10 = "ctrlparam10";
    public static final String FIELD_CTRLPARAM11 = "ctrlparam11";
    public static final String FIELD_CTRLPARAM12 = "ctrlparam12";
    public static final String FIELD_CTRLPARAM2 = "ctrlparam2";
    public static final String FIELD_CTRLPARAM3 = "ctrlparam3";
    public static final String FIELD_CTRLPARAM4 = "ctrlparam4";
    public static final String FIELD_CTRLPARAM5 = "ctrlparam5";
    public static final String FIELD_CTRLPARAM6 = "ctrlparam6";
    public static final String FIELD_CTRLPARAM7 = "ctrlparam7";
    public static final String FIELD_CTRLPARAM8 = "ctrlparam8";
    public static final String FIELD_CTRLPARAM9 = "ctrlparam9";
    public static final String FIELD_CTRLPARAMS = "ctrlparams";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EXTENDSTYLEONLY = "extendstyleonly";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_LINKVIEWSHOWMODE = "linkviewshowmode";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PREVIEWHTML = "previewhtml";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSEDITORSTYLEID = "pseditorstyleid";
    public static final String FIELD_PSEDITORSTYLENAME = "pseditorstylename";
    public static final String FIELD_PSEDITORTYPEID = "pseditortypeid";
    public static final String FIELD_PSEDITORTYPENAME = "pseditortypename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSEDITORSTYLEID = "pssyseditorstyleid";
    public static final String FIELD_PSSYSEDITORSTYLENAME = "pssyseditorstylename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_REFVIEWSHOWMODE = "refviewshowmode";
    public static final String FIELD_REPDEFAULT = "repdefault";
    public static final String FIELD_STUDIOICON = "studioicon";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    public static final String FIELD_WIDTH = "width";

    @JsonIgnore
    public String getAjaxHandler() {
        Object objValue = this.get(FIELD_AJAXHANDLER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ajaxhandler")
    public void setAjaxHandler(String ajaxHandler) {
        this.set(FIELD_AJAXHANDLER, ajaxHandler);
    }

    @JsonIgnore
    public boolean isAjaxHandlerDirty() {
        return this.contains(FIELD_AJAXHANDLER);
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
    public String getContainerType() {
        Object objValue = this.get(FIELD_CONTAINERTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="containertype")
    public void setContainerType(String containerType) {
        this.set(FIELD_CONTAINERTYPE, containerType);
    }

    @JsonIgnore
    public boolean isContainerTypeDirty() {
        return this.contains(FIELD_CONTAINERTYPE);
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
    public String getCtrlParam() {
        Object objValue = this.get(FIELD_CTRLPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam")
    public void setCtrlParam(String ctrlParam) {
        this.set(FIELD_CTRLPARAM, ctrlParam);
    }

    @JsonIgnore
    public boolean isCtrlParamDirty() {
        return this.contains(FIELD_CTRLPARAM);
    }

    @JsonIgnore
    public Double getCtrlParam10() {
        Object objValue = this.get(FIELD_CTRLPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="ctrlparam10")
    public void setCtrlParam10(Double ctrlParam10) {
        this.set(FIELD_CTRLPARAM10, ctrlParam10);
    }

    @JsonIgnore
    public boolean isCtrlParam10Dirty() {
        return this.contains(FIELD_CTRLPARAM10);
    }

    @JsonIgnore
    public Integer getCtrlParam11() {
        Object objValue = this.get(FIELD_CTRLPARAM11);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam11")
    public void setCtrlParam11(Integer ctrlParam11) {
        this.set(FIELD_CTRLPARAM11, ctrlParam11);
    }

    @JsonIgnore
    public boolean isCtrlParam11Dirty() {
        return this.contains(FIELD_CTRLPARAM11);
    }

    @JsonIgnore
    public Integer getCtrlParam12() {
        Object objValue = this.get(FIELD_CTRLPARAM12);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam12")
    public void setCtrlParam12(Integer ctrlParam12) {
        this.set(FIELD_CTRLPARAM12, ctrlParam12);
    }

    @JsonIgnore
    public boolean isCtrlParam12Dirty() {
        return this.contains(FIELD_CTRLPARAM12);
    }

    @JsonIgnore
    public String getCtrlParam2() {
        Object objValue = this.get(FIELD_CTRLPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam2")
    public void setCtrlParam2(String ctrlParam2) {
        this.set(FIELD_CTRLPARAM2, ctrlParam2);
    }

    @JsonIgnore
    public boolean isCtrlParam2Dirty() {
        return this.contains(FIELD_CTRLPARAM2);
    }

    @JsonIgnore
    public String getCtrlParam3() {
        Object objValue = this.get(FIELD_CTRLPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam3")
    public void setCtrlParam3(String ctrlParam3) {
        this.set(FIELD_CTRLPARAM3, ctrlParam3);
    }

    @JsonIgnore
    public boolean isCtrlParam3Dirty() {
        return this.contains(FIELD_CTRLPARAM3);
    }

    @JsonIgnore
    public String getCtrlParam4() {
        Object objValue = this.get(FIELD_CTRLPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparam4")
    public void setCtrlParam4(String ctrlParam4) {
        this.set(FIELD_CTRLPARAM4, ctrlParam4);
    }

    @JsonIgnore
    public boolean isCtrlParam4Dirty() {
        return this.contains(FIELD_CTRLPARAM4);
    }

    @JsonIgnore
    public Integer getCtrlParam5() {
        Object objValue = this.get(FIELD_CTRLPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam5")
    public void setCtrlParam5(Integer ctrlParam5) {
        this.set(FIELD_CTRLPARAM5, ctrlParam5);
    }

    @JsonIgnore
    public boolean isCtrlParam5Dirty() {
        return this.contains(FIELD_CTRLPARAM5);
    }

    @JsonIgnore
    public Integer getCtrlParam6() {
        Object objValue = this.get(FIELD_CTRLPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam6")
    public void setCtrlParam6(Integer ctrlParam6) {
        this.set(FIELD_CTRLPARAM6, ctrlParam6);
    }

    @JsonIgnore
    public boolean isCtrlParam6Dirty() {
        return this.contains(FIELD_CTRLPARAM6);
    }

    @JsonIgnore
    public Integer getCtrlParam7() {
        Object objValue = this.get(FIELD_CTRLPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam7")
    public void setCtrlParam7(Integer ctrlParam7) {
        this.set(FIELD_CTRLPARAM7, ctrlParam7);
    }

    @JsonIgnore
    public boolean isCtrlParam7Dirty() {
        return this.contains(FIELD_CTRLPARAM7);
    }

    @JsonIgnore
    public Integer getCtrlParam8() {
        Object objValue = this.get(FIELD_CTRLPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ctrlparam8")
    public void setCtrlParam8(Integer ctrlParam8) {
        this.set(FIELD_CTRLPARAM8, ctrlParam8);
    }

    @JsonIgnore
    public boolean isCtrlParam8Dirty() {
        return this.contains(FIELD_CTRLPARAM8);
    }

    @JsonIgnore
    public Double getCtrlParam9() {
        Object objValue = this.get(FIELD_CTRLPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Double)objValue;
    }

    @JsonProperty(value="ctrlparam9")
    public void setCtrlParam9(Double ctrlParam9) {
        this.set(FIELD_CTRLPARAM9, ctrlParam9);
    }

    @JsonIgnore
    public boolean isCtrlParam9Dirty() {
        return this.contains(FIELD_CTRLPARAM9);
    }

    @JsonIgnore
    public String getCtrlParams() {
        Object objValue = this.get(FIELD_CTRLPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ctrlparams")
    public void setCtrlParams(String ctrlParams) {
        this.set(FIELD_CTRLPARAMS, ctrlParams);
    }

    @JsonIgnore
    public boolean isCtrlParamsDirty() {
        return this.contains(FIELD_CTRLPARAMS);
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
    public Integer getExtendStyleOnly() {
        Object objValue = this.get(FIELD_EXTENDSTYLEONLY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="extendstyleonly")
    public void setExtendStyleOnly(Integer extendStyleOnly) {
        this.set(FIELD_EXTENDSTYLEONLY, extendStyleOnly);
    }

    @JsonIgnore
    public boolean isExtendStyleOnlyDirty() {
        return this.contains(FIELD_EXTENDSTYLEONLY);
    }

    @JsonIgnore
    public Integer getHeight() {
        Object objValue = this.get(FIELD_HEIGHT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="height")
    public void setHeight(Integer height) {
        this.set(FIELD_HEIGHT, height);
    }

    @JsonIgnore
    public boolean isHeightDirty() {
        return this.contains(FIELD_HEIGHT);
    }

    @JsonIgnore
    public String getLinkViewShowMode() {
        Object objValue = this.get(FIELD_LINKVIEWSHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkviewshowmode")
    public void setLinkViewShowMode(String linkViewShowMode) {
        this.set(FIELD_LINKVIEWSHOWMODE, linkViewShowMode);
    }

    @JsonIgnore
    public boolean isLinkViewShowModeDirty() {
        return this.contains(FIELD_LINKVIEWSHOWMODE);
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
    public String getPreviewHtml() {
        Object objValue = this.get(FIELD_PREVIEWHTML);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="previewhtml")
    public void setPreviewHtml(String previewHtml) {
        this.set(FIELD_PREVIEWHTML, previewHtml);
    }

    @JsonIgnore
    public boolean isPreviewHtmlDirty() {
        return this.contains(FIELD_PREVIEWHTML);
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
    public String getPSEditorStyleId() {
        Object objValue = this.get(FIELD_PSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditorstyleid")
    public void setPSEditorStyleId(String pSEditorStyleId) {
        this.set(FIELD_PSEDITORSTYLEID, pSEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSEditorStyleIdDirty() {
        return this.contains(FIELD_PSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSEditorStyleName() {
        Object objValue = this.get(FIELD_PSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditorstylename")
    public void setPSEditorStyleName(String pSEditorStyleName) {
        this.set(FIELD_PSEDITORSTYLENAME, pSEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSEditorStyleNameDirty() {
        return this.contains(FIELD_PSEDITORSTYLENAME);
    }

    @JsonIgnore
    public String getPSEditorTypeId() {
        Object objValue = this.get(FIELD_PSEDITORTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditortypeid")
    public void setPSEditorTypeId(String pSEditorTypeId) {
        this.set(FIELD_PSEDITORTYPEID, pSEditorTypeId);
    }

    @JsonIgnore
    public boolean isPSEditorTypeIdDirty() {
        return this.contains(FIELD_PSEDITORTYPEID);
    }

    @JsonIgnore
    public String getPSEditorTypeName() {
        Object objValue = this.get(FIELD_PSEDITORTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pseditortypename")
    public void setPSEditorTypeName(String pSEditorTypeName) {
        this.set(FIELD_PSEDITORTYPENAME, pSEditorTypeName);
    }

    @JsonIgnore
    public boolean isPSEditorTypeNameDirty() {
        return this.contains(FIELD_PSEDITORTYPENAME);
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
    public String getPSSysEditorStyleId() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstyleid")
    public void setPSSysEditorStyleId(String pSSysEditorStyleId) {
        this.set(FIELD_PSSYSEDITORSTYLEID, pSSysEditorStyleId);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleIdDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLEID);
    }

    @JsonIgnore
    public String getPSSysEditorStyleName() {
        Object objValue = this.get(FIELD_PSSYSEDITORSTYLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseditorstylename")
    public void setPSSysEditorStyleName(String pSSysEditorStyleName) {
        this.set(FIELD_PSSYSEDITORSTYLENAME, pSSysEditorStyleName);
    }

    @JsonIgnore
    public boolean isPSSysEditorStyleNameDirty() {
        return this.contains(FIELD_PSSYSEDITORSTYLENAME);
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
    public String getRefViewShowMode() {
        Object objValue = this.get(FIELD_REFVIEWSHOWMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refviewshowmode")
    public void setRefViewShowMode(String refViewShowMode) {
        this.set(FIELD_REFVIEWSHOWMODE, refViewShowMode);
    }

    @JsonIgnore
    public boolean isRefViewShowModeDirty() {
        return this.contains(FIELD_REFVIEWSHOWMODE);
    }

    @JsonIgnore
    public Integer getRepDefault() {
        Object objValue = this.get(FIELD_REPDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="repdefault")
    public void setRepDefault(Integer repDefault) {
        this.set(FIELD_REPDEFAULT, repDefault);
    }

    @JsonIgnore
    public boolean isRepDefaultDirty() {
        return this.contains(FIELD_REPDEFAULT);
    }

    @JsonIgnore
    public String getStudioIcon() {
        Object objValue = this.get(FIELD_STUDIOICON);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="studioicon")
    public void setStudioIcon(String studioIcon) {
        this.set(FIELD_STUDIOICON, studioIcon);
    }

    @JsonIgnore
    public boolean isStudioIconDirty() {
        return this.contains(FIELD_STUDIOICON);
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
    public Integer getWidth() {
        Object objValue = this.get(FIELD_WIDTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="width")
    public void setWidth(Integer width) {
        this.set(FIELD_WIDTH, width);
    }

    @JsonIgnore
    public boolean isWidthDirty() {
        return this.contains(FIELD_WIDTH);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysEditorStyleId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysEditorStyleId(strValue);
    }
}

