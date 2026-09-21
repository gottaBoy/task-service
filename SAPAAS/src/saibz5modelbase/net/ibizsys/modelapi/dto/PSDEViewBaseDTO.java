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
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.dto.PSDEViewEngineDTO;
import net.ibizsys.modelapi.dto.PSDEViewLogicDTO;
import net.ibizsys.modelapi.dto.PSDEViewRVDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEViewBaseDTO
extends PSModelDTOBase {
    public static final String FIELD_ACCUSERMODE = "accusermode";
    public static final String FIELD_BOTTOMINFO = "bottominfo";
    public static final String FIELD_CAPPSLANRESID = "cappslanresid";
    public static final String FIELD_CAPPSLANRESNAME = "cappslanresname";
    public static final String FIELD_CAPTION = "caption";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEVIEWTAG = "deviewtag";
    public static final String FIELD_DEVIEWTAG2 = "deviewtag2";
    public static final String FIELD_DEVIEWTAG3 = "deviewtag3";
    public static final String FIELD_DEVIEWTAG4 = "deviewtag4";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_DYNCMODE = "dyncmode";
    public static final String FIELD_ENABLEVIEWACTIONS = "enableviewactions";
    public static final String FIELD_GROUPPSCODELISTID = "grouppscodelistid";
    public static final String FIELD_GROUPPSCODELISTNAME = "grouppscodelistname";
    public static final String FIELD_HEADERINFO = "headerinfo";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_LAYOUTPANELMODE = "layoutpanelmode";
    public static final String FIELD_LOADDEFAULT = "loaddefault";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_OPENMODE = "openmode";
    public static final String FIELD_PDTPARAMPRE = "pdtparampre";
    public static final String FIELD_PDVTPARAM = "pdvtparam";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "predefineviewtype";
    public static final String FIELD_PSACHANDLERID = "psachandlerid";
    public static final String FIELD_PSACHANDLERNAME = "psachandlername";
    public static final String FIELD_PSCTRLLOGICGROUPID = "psctrllogicgroupid";
    public static final String FIELD_PSCTRLLOGICGROUPNAME = "psctrllogicgroupname";
    public static final String FIELD_PSDEAWGROUPID = "psdeawgroupid";
    public static final String FIELD_PSDEAWGROUPNAME = "psdeawgroupname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDEVIEWBASETYPE = "psdeviewbasetype";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "psdynadeviewtemplid";
    public static final String FIELD_PSDYNADEVIEWTEMPLNAME = "psdynadeviewtemplname";
    public static final String FIELD_PSHELPMODULEID = "pshelpmoduleid";
    public static final String FIELD_PSHELPMODULENAME = "pshelpmodulename";
    public static final String FIELD_PSSUBVIEWTYPEID = "pssubviewtypeid";
    public static final String FIELD_PSSUBVIEWTYPENAME = "pssubviewtypename";
    public static final String FIELD_PSSYSCOUNTERID = "pssyscounterid";
    public static final String FIELD_PSSYSCOUNTERNAME = "pssyscountername";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSREQITEMID = "pssysreqitemid";
    public static final String FIELD_PSSYSREQITEMNAME = "pssysreqitemname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSUNIRESID = "pssysuniresid";
    public static final String FIELD_PSSYSUNIRESNAME = "pssysuniresname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_PSVIEWENGINEID = "psviewengineid";
    public static final String FIELD_PSVIEWENGINENAME = "psviewenginename";
    public static final String FIELD_PSVIEWMSGGROUPID = "psviewmsggroupid";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "psviewmsggroupname";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    public static final String FIELD_PSWFDENAME = "pswfdename";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_READONLYMODE = "readonlymode";
    public static final String FIELD_SHOWCAPTIONBAR = "showcaptionbar";
    public static final String FIELD_SUBCAPPSLANRESID = "subcappslanresid";
    public static final String FIELD_SUBCAPPSLANRESNAME = "subcappslanresname";
    public static final String FIELD_SUBCAPTION = "subcaption";
    public static final String FIELD_TEMPMODE = "tempmode";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    public static final String FIELD_TODOTASK = "todotask";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_VIEWACTIONS = "viewactions";
    public static final String FIELD_VIEWPARAM = "viewparam";
    public static final String FIELD_VIEWPARAM10 = "viewparam10";
    public static final String FIELD_VIEWPARAM2 = "viewparam2";
    public static final String FIELD_VIEWPARAM3 = "viewparam3";
    public static final String FIELD_VIEWPARAM4 = "viewparam4";
    public static final String FIELD_VIEWPARAM5 = "viewparam5";
    public static final String FIELD_VIEWPARAM6 = "viewparam6";
    public static final String FIELD_VIEWPARAM7 = "viewparam7";
    public static final String FIELD_VIEWPARAM8 = "viewparam8";
    public static final String FIELD_VIEWPARAM9 = "viewparam9";
    public static final String FIELD_VIEWPARAMS = "viewparams";
    public static final String FIELD_VIEWSN = "viewsn";
    public static final String FIELD_WFVIEWPARAM = "wfviewparam";
    public static final String FIELD_WFVIEWPARAM2 = "wfviewparam2";
    public static final String FIELD_WFVIEWPARAM3 = "wfviewparam3";
    public static final String FIELD_WFVIEWPARAM4 = "wfviewparam4";
    public static final String FIELD_WIDTH = "width";
    private List<PSDEViewCtrlDTO> psdeviewctrls;
    private List<PSDEViewEngineDTO> psdeviewengines;
    private List<PSDEViewLogicDTO> psdeviewlogics;
    private List<PSDEViewRVDTO> psdeviewrvs;

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
    public String getBottomInfo() {
        Object objValue = this.get(FIELD_BOTTOMINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bottominfo")
    public void setBottomInfo(String bottomInfo) {
        this.set(FIELD_BOTTOMINFO, bottomInfo);
    }

    @JsonIgnore
    public boolean isBottomInfoDirty() {
        return this.contains(FIELD_BOTTOMINFO);
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
    public String getDEViewTag() {
        Object objValue = this.get(FIELD_DEVIEWTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewtag")
    public void setDEViewTag(String dEViewTag) {
        this.set(FIELD_DEVIEWTAG, dEViewTag);
    }

    @JsonIgnore
    public boolean isDEViewTagDirty() {
        return this.contains(FIELD_DEVIEWTAG);
    }

    @JsonIgnore
    public String getDEViewTag2() {
        Object objValue = this.get(FIELD_DEVIEWTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewtag2")
    public void setDEViewTag2(String dEViewTag2) {
        this.set(FIELD_DEVIEWTAG2, dEViewTag2);
    }

    @JsonIgnore
    public boolean isDEViewTag2Dirty() {
        return this.contains(FIELD_DEVIEWTAG2);
    }

    @JsonIgnore
    public String getDEViewTag3() {
        Object objValue = this.get(FIELD_DEVIEWTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewtag3")
    public void setDEViewTag3(String dEViewTag3) {
        this.set(FIELD_DEVIEWTAG3, dEViewTag3);
    }

    @JsonIgnore
    public boolean isDEViewTag3Dirty() {
        return this.contains(FIELD_DEVIEWTAG3);
    }

    @JsonIgnore
    public String getDEViewTag4() {
        Object objValue = this.get(FIELD_DEVIEWTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="deviewtag4")
    public void setDEViewTag4(String dEViewTag4) {
        this.set(FIELD_DEVIEWTAG4, dEViewTag4);
    }

    @JsonIgnore
    public boolean isDEViewTag4Dirty() {
        return this.contains(FIELD_DEVIEWTAG4);
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
    public Integer getEnableViewActions() {
        Object objValue = this.get(FIELD_ENABLEVIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableviewactions")
    public void setEnableViewActions(Integer enableViewActions) {
        this.set(FIELD_ENABLEVIEWACTIONS, enableViewActions);
    }

    @JsonIgnore
    public boolean isEnableViewActionsDirty() {
        return this.contains(FIELD_ENABLEVIEWACTIONS);
    }

    @JsonIgnore
    public String getGroupPSCodeListId() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistid")
    public void setGroupPSCodeListId(String groupPSCodeListId) {
        this.set(FIELD_GROUPPSCODELISTID, groupPSCodeListId);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListIdDirty() {
        return this.contains(FIELD_GROUPPSCODELISTID);
    }

    @JsonIgnore
    public String getGroupPSCodeListName() {
        Object objValue = this.get(FIELD_GROUPPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppscodelistname")
    public void setGroupPSCodeListName(String groupPSCodeListName) {
        this.set(FIELD_GROUPPSCODELISTNAME, groupPSCodeListName);
    }

    @JsonIgnore
    public boolean isGroupPSCodeListNameDirty() {
        return this.contains(FIELD_GROUPPSCODELISTNAME);
    }

    @JsonIgnore
    public String getHeaderInfo() {
        Object objValue = this.get(FIELD_HEADERINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="headerinfo")
    public void setHeaderInfo(String headerInfo) {
        this.set(FIELD_HEADERINFO, headerInfo);
    }

    @JsonIgnore
    public boolean isHeaderInfoDirty() {
        return this.contains(FIELD_HEADERINFO);
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
    public Integer getLoadDefault() {
        Object objValue = this.get(FIELD_LOADDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="loaddefault")
    public void setLoadDefault(Integer loadDefault) {
        this.set(FIELD_LOADDEFAULT, loadDefault);
    }

    @JsonIgnore
    public boolean isLoadDefaultDirty() {
        return this.contains(FIELD_LOADDEFAULT);
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
    public Integer getModelState() {
        Object objValue = this.get(FIELD_MODELSTATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="modelstate")
    public void setModelState(Integer modelState) {
        this.set(FIELD_MODELSTATE, modelState);
    }

    @JsonIgnore
    public boolean isModelStateDirty() {
        return this.contains(FIELD_MODELSTATE);
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
    public String getPDTParamPre() {
        Object objValue = this.get(FIELD_PDTPARAMPRE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pdtparampre")
    public void setPDTParamPre(String pDTParamPre) {
        this.set(FIELD_PDTPARAMPRE, pDTParamPre);
    }

    @JsonIgnore
    public boolean isPDTParamPreDirty() {
        return this.contains(FIELD_PDTPARAMPRE);
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
    public String getPredefinedViewType() {
        Object objValue = this.get(FIELD_PREDEFINEDVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefineviewtype")
    public void setPredefinedViewType(String predefinedViewType) {
        this.set(FIELD_PREDEFINEDVIEWTYPE, predefinedViewType);
    }

    @JsonIgnore
    public boolean isPredefinedViewTypeDirty() {
        return this.contains(FIELD_PREDEFINEDVIEWTYPE);
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
    public String getPSDEAWGroupId() {
        Object objValue = this.get(FIELD_PSDEAWGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeawgroupid")
    public void setPSDEAWGroupId(String pSDEAWGroupId) {
        this.set(FIELD_PSDEAWGROUPID, pSDEAWGroupId);
    }

    @JsonIgnore
    public boolean isPSDEAWGroupIdDirty() {
        return this.contains(FIELD_PSDEAWGROUPID);
    }

    @JsonIgnore
    public String getPSDEAWGroupName() {
        Object objValue = this.get(FIELD_PSDEAWGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeawgroupname")
    public void setPSDEAWGroupName(String pSDEAWGroupName) {
        this.set(FIELD_PSDEAWGROUPNAME, pSDEAWGroupName);
    }

    @JsonIgnore
    public boolean isPSDEAWGroupNameDirty() {
        return this.contains(FIELD_PSDEAWGROUPNAME);
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
    public String getPSDERId() {
        Object objValue = this.get(FIELD_PSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psderid")
    public void setPSDERId(String pSDERId) {
        this.set(FIELD_PSDERID, pSDERId);
    }

    @JsonIgnore
    public boolean isPSDERIdDirty() {
        return this.contains(FIELD_PSDERID);
    }

    @JsonIgnore
    public String getPSDERName() {
        Object objValue = this.get(FIELD_PSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdername")
    public void setPSDERName(String pSDERName) {
        this.set(FIELD_PSDERNAME, pSDERName);
    }

    @JsonIgnore
    public boolean isPSDERNameDirty() {
        return this.contains(FIELD_PSDERNAME);
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
    public String getPSDEViewBaseType() {
        Object objValue = this.get(FIELD_PSDEVIEWBASETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeviewbasetype")
    public void setPSDEViewBaseType(String pSDEViewBaseType) {
        this.set(FIELD_PSDEVIEWBASETYPE, pSDEViewBaseType);
    }

    @JsonIgnore
    public boolean isPSDEViewBaseTypeDirty() {
        return this.contains(FIELD_PSDEVIEWBASETYPE);
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
    public String getPSWFVersionId() {
        Object objValue = this.get(FIELD_PSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionid")
    public void setPSWFVersionId(String pSWFVersionId) {
        this.set(FIELD_PSWFVERSIONID, pSWFVersionId);
    }

    @JsonIgnore
    public boolean isPSWFVersionIdDirty() {
        return this.contains(FIELD_PSWFVERSIONID);
    }

    @JsonIgnore
    public String getPSWFVersionName() {
        Object objValue = this.get(FIELD_PSWFVERSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfversionname")
    public void setPSWFVersionName(String pSWFVersionName) {
        this.set(FIELD_PSWFVERSIONNAME, pSWFVersionName);
    }

    @JsonIgnore
    public boolean isPSWFVersionNameDirty() {
        return this.contains(FIELD_PSWFVERSIONNAME);
    }

    @JsonIgnore
    public Integer getReadOnlyMode() {
        Object objValue = this.get(FIELD_READONLYMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="readonlymode")
    public void setReadOnlyMode(Integer readOnlyMode) {
        this.set(FIELD_READONLYMODE, readOnlyMode);
    }

    @JsonIgnore
    public boolean isReadOnlyModeDirty() {
        return this.contains(FIELD_READONLYMODE);
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
    public Integer getTempMode() {
        Object objValue = this.get(FIELD_TEMPMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tempmode")
    public void setTempMode(Integer tempMode) {
        this.set(FIELD_TEMPMODE, tempMode);
    }

    @JsonIgnore
    public boolean isTempModeDirty() {
        return this.contains(FIELD_TEMPMODE);
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
    public Integer getViewActions() {
        Object objValue = this.get(FIELD_VIEWACTIONS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewactions")
    public void setViewActions(Integer viewActions) {
        this.set(FIELD_VIEWACTIONS, viewActions);
    }

    @JsonIgnore
    public boolean isViewActionsDirty() {
        return this.contains(FIELD_VIEWACTIONS);
    }

    @JsonIgnore
    public String getViewParam() {
        Object objValue = this.get(FIELD_VIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam")
    public void setViewParam(String viewParam) {
        this.set(FIELD_VIEWPARAM, viewParam);
    }

    @JsonIgnore
    public boolean isViewParamDirty() {
        return this.contains(FIELD_VIEWPARAM);
    }

    @JsonIgnore
    public Integer getViewParam10() {
        Object objValue = this.get(FIELD_VIEWPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam10")
    public void setViewParam10(Integer viewParam10) {
        this.set(FIELD_VIEWPARAM10, viewParam10);
    }

    @JsonIgnore
    public boolean isViewParam10Dirty() {
        return this.contains(FIELD_VIEWPARAM10);
    }

    @JsonIgnore
    public String getViewParam2() {
        Object objValue = this.get(FIELD_VIEWPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam2")
    public void setViewParam2(String viewParam2) {
        this.set(FIELD_VIEWPARAM2, viewParam2);
    }

    @JsonIgnore
    public boolean isViewParam2Dirty() {
        return this.contains(FIELD_VIEWPARAM2);
    }

    @JsonIgnore
    public Integer getViewParam3() {
        Object objValue = this.get(FIELD_VIEWPARAM3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam3")
    public void setViewParam3(Integer viewParam3) {
        this.set(FIELD_VIEWPARAM3, viewParam3);
    }

    @JsonIgnore
    public boolean isViewParam3Dirty() {
        return this.contains(FIELD_VIEWPARAM3);
    }

    @JsonIgnore
    public Integer getViewParam4() {
        Object objValue = this.get(FIELD_VIEWPARAM4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam4")
    public void setViewParam4(Integer viewParam4) {
        this.set(FIELD_VIEWPARAM4, viewParam4);
    }

    @JsonIgnore
    public boolean isViewParam4Dirty() {
        return this.contains(FIELD_VIEWPARAM4);
    }

    @JsonIgnore
    public Integer getViewParam5() {
        Object objValue = this.get(FIELD_VIEWPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam5")
    public void setViewParam5(Integer viewParam5) {
        this.set(FIELD_VIEWPARAM5, viewParam5);
    }

    @JsonIgnore
    public boolean isViewParam5Dirty() {
        return this.contains(FIELD_VIEWPARAM5);
    }

    @JsonIgnore
    public Integer getViewParam6() {
        Object objValue = this.get(FIELD_VIEWPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam6")
    public void setViewParam6(Integer viewParam6) {
        this.set(FIELD_VIEWPARAM6, viewParam6);
    }

    @JsonIgnore
    public boolean isViewParam6Dirty() {
        return this.contains(FIELD_VIEWPARAM6);
    }

    @JsonIgnore
    public String getViewParam7() {
        Object objValue = this.get(FIELD_VIEWPARAM7);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam7")
    public void setViewParam7(String viewParam7) {
        this.set(FIELD_VIEWPARAM7, viewParam7);
    }

    @JsonIgnore
    public boolean isViewParam7Dirty() {
        return this.contains(FIELD_VIEWPARAM7);
    }

    @JsonIgnore
    public String getViewParam8() {
        Object objValue = this.get(FIELD_VIEWPARAM8);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparam8")
    public void setViewParam8(String viewParam8) {
        this.set(FIELD_VIEWPARAM8, viewParam8);
    }

    @JsonIgnore
    public boolean isViewParam8Dirty() {
        return this.contains(FIELD_VIEWPARAM8);
    }

    @JsonIgnore
    public Integer getViewParam9() {
        Object objValue = this.get(FIELD_VIEWPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="viewparam9")
    public void setViewParam9(Integer viewParam9) {
        this.set(FIELD_VIEWPARAM9, viewParam9);
    }

    @JsonIgnore
    public boolean isViewParam9Dirty() {
        return this.contains(FIELD_VIEWPARAM9);
    }

    @JsonIgnore
    public String getViewParams() {
        Object objValue = this.get(FIELD_VIEWPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewparams")
    public void setViewParams(String viewParams) {
        this.set(FIELD_VIEWPARAMS, viewParams);
    }

    @JsonIgnore
    public boolean isViewParamsDirty() {
        return this.contains(FIELD_VIEWPARAMS);
    }

    @JsonIgnore
    public String getViewSN() {
        Object objValue = this.get(FIELD_VIEWSN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewsn")
    public void setViewSN(String viewSN) {
        this.set(FIELD_VIEWSN, viewSN);
    }

    @JsonIgnore
    public boolean isViewSNDirty() {
        return this.contains(FIELD_VIEWSN);
    }

    @JsonIgnore
    public Integer getWFViewParam() {
        Object objValue = this.get(FIELD_WFVIEWPARAM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfviewparam")
    public void setWFViewParam(Integer wFViewParam) {
        this.set(FIELD_WFVIEWPARAM, wFViewParam);
    }

    @JsonIgnore
    public boolean isWFViewParamDirty() {
        return this.contains(FIELD_WFVIEWPARAM);
    }

    @JsonIgnore
    public Integer getWFViewParam2() {
        Object objValue = this.get(FIELD_WFVIEWPARAM2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="wfviewparam2")
    public void setWFViewParam2(Integer wFViewParam2) {
        this.set(FIELD_WFVIEWPARAM2, wFViewParam2);
    }

    @JsonIgnore
    public boolean isWFViewParam2Dirty() {
        return this.contains(FIELD_WFVIEWPARAM2);
    }

    @JsonIgnore
    public String getWFViewParam3() {
        Object objValue = this.get(FIELD_WFVIEWPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfviewparam3")
    public void setWFViewParam3(String wFViewParam3) {
        this.set(FIELD_WFVIEWPARAM3, wFViewParam3);
    }

    @JsonIgnore
    public boolean isWFViewParam3Dirty() {
        return this.contains(FIELD_WFVIEWPARAM3);
    }

    @JsonIgnore
    public String getWFViewParam4() {
        Object objValue = this.get(FIELD_WFVIEWPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfviewparam4")
    public void setWFViewParam4(String wFViewParam4) {
        this.set(FIELD_WFVIEWPARAM4, wFViewParam4);
    }

    @JsonIgnore
    public boolean isWFViewParam4Dirty() {
        return this.contains(FIELD_WFVIEWPARAM4);
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
        return this.getPSDEViewBaseId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEViewBaseId(strValue);
    }

    @JsonProperty(value="psdeviewctrls")
    public List<PSDEViewCtrlDTO> getPsdeviewctrls() {
        return this.psdeviewctrls;
    }

    @JsonProperty(value="psdeviewctrls")
    public void setPsdeviewctrls(List<PSDEViewCtrlDTO> psdeviewctrls) {
        this.psdeviewctrls = psdeviewctrls;
    }

    @JsonProperty(value="psdeviewengines")
    public List<PSDEViewEngineDTO> getPsdeviewengines() {
        return this.psdeviewengines;
    }

    @JsonProperty(value="psdeviewengines")
    public void setPsdeviewengines(List<PSDEViewEngineDTO> psdeviewengines) {
        this.psdeviewengines = psdeviewengines;
    }

    @JsonProperty(value="psdeviewlogics")
    public List<PSDEViewLogicDTO> getPsdeviewlogics() {
        return this.psdeviewlogics;
    }

    @JsonProperty(value="psdeviewlogics")
    public void setPsdeviewlogics(List<PSDEViewLogicDTO> psdeviewlogics) {
        this.psdeviewlogics = psdeviewlogics;
    }

    @JsonProperty(value="psdeviewrvs")
    public List<PSDEViewRVDTO> getPsdeviewrvs() {
        return this.psdeviewrvs;
    }

    @JsonProperty(value="psdeviewrvs")
    public void setPsdeviewrvs(List<PSDEViewRVDTO> psdeviewrvs) {
        this.psdeviewrvs = psdeviewrvs;
    }
}

