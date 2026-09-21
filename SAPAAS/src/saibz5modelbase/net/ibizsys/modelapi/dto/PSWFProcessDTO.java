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
import net.ibizsys.modelapi.dto.PSWFProcParamDTO;
import net.ibizsys.modelapi.dto.PSWFProcRoleDTO;
import net.ibizsys.modelapi.dto.PSWFProcSubWFDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSWFProcessDTO
extends PSModelDTOBase {
    public static final String FIELD_ASYNCMODE = "asyncmode";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_EDITFIELDS = "editfields";
    public static final String FIELD_EDITFLAG = "editflag";
    public static final String FIELD_EDITPSDEFGROUPID = "editpsdefgroupid";
    public static final String FIELD_EDITPSDEFGROUPNAME = "editpsdefgroupname";
    public static final String FIELD_EMBEDPSDEDSID = "embedpsdedsid";
    public static final String FIELD_EMBEDPSDEDSNAME = "embedpsdedsname";
    public static final String FIELD_EMBEDPSDEID = "embedpsdeid";
    public static final String FIELD_EMBEDPSWFDEID = "embedpswfdeid";
    public static final String FIELD_EMBEDPSWFDENAME = "embedpswfdename";
    public static final String FIELD_EMBEDPSWFID = "embedpswfid";
    public static final String FIELD_EMBEDPSWFNAME = "embedpswfname";
    public static final String FIELD_ENABLE = "enable";
    public static final String FIELD_ENABLEMOBILE = "enablemobile";
    public static final String FIELD_ENABLETIMEOUT = "enabletimeout";
    public static final String FIELD_EXITSTATENAME = "exitstatename";
    public static final String FIELD_EXITSTATEVALUE = "exitstatevalue";
    public static final String FIELD_FORMCODENAME = "formcodename";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_ICONPATH = "iconpath";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MEMOFIELD = "memofield";
    public static final String FIELD_MOBFORMCODENAME = "mobformcodename";
    public static final String FIELD_MOBPSDEFORMID = "mobpsdeformid";
    public static final String FIELD_MOBPSDEFORMNAME = "mobpsdeformname";
    public static final String FIELD_MOBPSDEUAGROUPID = "mobpsdeuagroupid";
    public static final String FIELD_MOBPSDEUAGROUPNAME = "mobpsdeuagroupname";
    public static final String FIELD_MOBPSDEVIEWID = "mobpsdeviewid";
    public static final String FIELD_MOBPSDEVIEWNAME = "mobpsdeviewname";
    public static final String FIELD_MOBPSDYNADEVIEWTEMPLID = "mobpsdynadeviewtemplid";
    public static final String FIELD_MOBUAGROUPCODENAME = "mobuagroupcodename";
    public static final String FIELD_MOBUTIL2FORMCODENAME = "mobutil2formcodename";
    public static final String FIELD_MOBUTIL2PSDEFORMID = "mobutil2psdeformid";
    public static final String FIELD_MOBUTIL2PSDEFORMNAME = "mobutil2psdeformname";
    public static final String FIELD_MOBUTIL3FORMCODENAME = "mobutil3formcodename";
    public static final String FIELD_MOBUTIL3PSDEFORMID = "mobutil3psdeformid";
    public static final String FIELD_MOBUTIL3PSDEFORMNAME = "mobutil3psdeformname";
    public static final String FIELD_MOBUTIL4FORMCODENAME = "mobutil4formcodename";
    public static final String FIELD_MOBUTIL4PSDEFORMID = "mobutil4psdeformid";
    public static final String FIELD_MOBUTIL4PSDEFORMNAME = "mobutil4psdeformname";
    public static final String FIELD_MOBUTIL5FORMCODENAME = "mobutil5formcodename";
    public static final String FIELD_MOBUTIL5PSDEFORMID = "mobutil5psdeformid";
    public static final String FIELD_MOBUTIL5PSDEFORMNAME = "mobutil5psdeformname";
    public static final String FIELD_MOBUTILFORMCODENAME = "mobutilformcodename";
    public static final String FIELD_MOBUTILPSDEFORMID = "mobutilpsdeformid";
    public static final String FIELD_MOBUTILPSDEFORMNAME = "mobutilpsdeformname";
    public static final String FIELD_MOBWFEDITVIEWTYPE = "mobwfeditviewtype";
    public static final String FIELD_MODELID = "modelid";
    public static final String FIELD_MSGTYPE = "msgtype";
    public static final String FIELD_MULTIINSTMODE = "multiinstmode";
    public static final String FIELD_NAMEPSLANRESID = "namepslanresid";
    public static final String FIELD_NAMEPSLANRESNAME = "namepslanresname";
    public static final String FIELD_NORMALPROCTYPE = "normalproctype";
    public static final String FIELD_PREDEFINEDACTIONS = "predefinedactions";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEUAGROUPID = "psdeuagroupid";
    public static final String FIELD_PSDEUAGROUPNAME = "psdeuagroupname";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSDYNADEVIEWTEMPLID = "psdynadeviewtemplid";
    public static final String FIELD_PSSYSMSGTEMPLID = "pssysmsgtemplid";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "pssysmsgtemplname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    public static final String FIELD_PSWFDENAME = "pswfdename";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFNAME = "pswfname";
    public static final String FIELD_PSWFPROCESSID = "pswfprocessid";
    public static final String FIELD_PSWFPROCESSNAME = "pswfprocessname";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_PSWFWORKTIMEID = "pswfworktimeid";
    public static final String FIELD_PSWFWORKTIMENAME = "pswfworktimename";
    public static final String FIELD_REFPSWFVERSIONID = "refpswfversionid";
    public static final String FIELD_REFPSWFVERSIONNAME = "refpswfversionname";
    public static final String FIELD_SENDINFORM = "sendinform";
    public static final String FIELD_SHAPEPARAMS = "shapeparams";
    public static final String FIELD_THREADNAME = "threadname";
    public static final String FIELD_THREADSN = "threadsn";
    public static final String FIELD_TIMEOUT = "timeout";
    public static final String FIELD_TIMEOUTPSDEFID = "timeoutpsdefid";
    public static final String FIELD_TIMEOUTPSDEFNAME = "timeoutpsdefname";
    public static final String FIELD_TIMEOUTTYPE = "timeouttype";
    public static final String FIELD_TOPPOS = "toppos";
    public static final String FIELD_UAGROUPCODENAME = "uagroupcodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERDATA = "userdata";
    public static final String FIELD_USERDATA2 = "userdata2";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTIL2FORMCODENAME = "util2formcodename";
    public static final String FIELD_UTIL2PSDEFORMID = "util2psdeformid";
    public static final String FIELD_UTIL2PSDEFORMNAME = "util2psdeformname";
    public static final String FIELD_UTIL3FORMCODENAME = "util3formcodename";
    public static final String FIELD_UTIL3PSDEFORMID = "util3psdeformid";
    public static final String FIELD_UTIL3PSDEFORMNAME = "util3psdeformname";
    public static final String FIELD_UTIL4FORMCODENAME = "util4formcodename";
    public static final String FIELD_UTIL4PSDEFORMID = "util4psdeformid";
    public static final String FIELD_UTIL4PSDEFORMNAME = "util4psdeformname";
    public static final String FIELD_UTIL5FORMCODENAME = "util5formcodename";
    public static final String FIELD_UTIL5PSDEFORMID = "util5psdeformid";
    public static final String FIELD_UTIL5PSDEFORMNAME = "util5psdeformname";
    public static final String FIELD_UTILFORMCODENAME = "utilformcodename";
    public static final String FIELD_UTILPSDEFORMID = "utilpsdeformid";
    public static final String FIELD_UTILPSDEFORMNAME = "utilpsdeformname";
    public static final String FIELD_WFEDITVIEWTYPE = "wfeditviewtype";
    public static final String FIELD_WFENGINETYPE = "wfenginetype";
    public static final String FIELD_WFPROCESSTYPE = "wfprocesstype";
    public static final String FIELD_WFSTEPNAME = "wfstepname";
    public static final String FIELD_WFSTEPVALUE = "wfstepvalue";
    public static final String FIELD_WIDTH = "width";
    private List<PSWFProcRoleDTO> pswfprocroles;
    private List<PSWFProcSubWFDTO> pswfprocsubwfs;
    private List<PSWFProcParamDTO> pswfprocparams;

    @JsonIgnore
    public Integer getAsyncMode() {
        Object objValue = this.get(FIELD_ASYNCMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="asyncmode")
    public void setAsyncMode(Integer asyncMode) {
        this.set(FIELD_ASYNCMODE, asyncMode);
    }

    @JsonIgnore
    public boolean isAsyncModeDirty() {
        return this.contains(FIELD_ASYNCMODE);
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
    public String getEditFields() {
        Object objValue = this.get(FIELD_EDITFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editfields")
    public void setEditFields(String editFields) {
        this.set(FIELD_EDITFIELDS, editFields);
    }

    @JsonIgnore
    public boolean isEditFieldsDirty() {
        return this.contains(FIELD_EDITFIELDS);
    }

    @JsonIgnore
    public Integer getEditFlag() {
        Object objValue = this.get(FIELD_EDITFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="editflag")
    public void setEditFlag(Integer editFlag) {
        this.set(FIELD_EDITFLAG, editFlag);
    }

    @JsonIgnore
    public boolean isEditFlagDirty() {
        return this.contains(FIELD_EDITFLAG);
    }

    @JsonIgnore
    public String getEditPSDEFGroupId() {
        Object objValue = this.get(FIELD_EDITPSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editpsdefgroupid")
    public void setEditPSDEFGroupId(String editPSDEFGroupId) {
        this.set(FIELD_EDITPSDEFGROUPID, editPSDEFGroupId);
    }

    @JsonIgnore
    public boolean isEditPSDEFGroupIdDirty() {
        return this.contains(FIELD_EDITPSDEFGROUPID);
    }

    @JsonIgnore
    public String getEditPSDEFGroupName() {
        Object objValue = this.get(FIELD_EDITPSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="editpsdefgroupname")
    public void setEditPSDEFGroupName(String editPSDEFGroupName) {
        this.set(FIELD_EDITPSDEFGROUPNAME, editPSDEFGroupName);
    }

    @JsonIgnore
    public boolean isEditPSDEFGroupNameDirty() {
        return this.contains(FIELD_EDITPSDEFGROUPNAME);
    }

    @JsonIgnore
    public String getEmbedPSDEDSId() {
        Object objValue = this.get(FIELD_EMBEDPSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdedsid")
    public void setEmbedPSDEDSId(String embedPSDEDSId) {
        this.set(FIELD_EMBEDPSDEDSID, embedPSDEDSId);
    }

    @JsonIgnore
    public boolean isEmbedPSDEDSIdDirty() {
        return this.contains(FIELD_EMBEDPSDEDSID);
    }

    @JsonIgnore
    public String getEmbedPSDEDSName() {
        Object objValue = this.get(FIELD_EMBEDPSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdedsname")
    public void setEmbedPSDEDSName(String embedPSDEDSName) {
        this.set(FIELD_EMBEDPSDEDSNAME, embedPSDEDSName);
    }

    @JsonIgnore
    public boolean isEmbedPSDEDSNameDirty() {
        return this.contains(FIELD_EMBEDPSDEDSNAME);
    }

    @JsonIgnore
    public String getEmbedPSDEId() {
        Object objValue = this.get(FIELD_EMBEDPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpsdeid")
    public void setEmbedPSDEId(String embedPSDEId) {
        this.set(FIELD_EMBEDPSDEID, embedPSDEId);
    }

    @JsonIgnore
    public boolean isEmbedPSDEIdDirty() {
        return this.contains(FIELD_EMBEDPSDEID);
    }

    @JsonIgnore
    public String getEmbedPSWFDEId() {
        Object objValue = this.get(FIELD_EMBEDPSWFDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfdeid")
    public void setEmbedPSWFDEId(String embedPSWFDEId) {
        this.set(FIELD_EMBEDPSWFDEID, embedPSWFDEId);
    }

    @JsonIgnore
    public boolean isEmbedPSWFDEIdDirty() {
        return this.contains(FIELD_EMBEDPSWFDEID);
    }

    @JsonIgnore
    public String getEmbedPSWFDEName() {
        Object objValue = this.get(FIELD_EMBEDPSWFDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfdename")
    public void setEmbedPSWFDEName(String embedPSWFDEName) {
        this.set(FIELD_EMBEDPSWFDENAME, embedPSWFDEName);
    }

    @JsonIgnore
    public boolean isEmbedPSWFDENameDirty() {
        return this.contains(FIELD_EMBEDPSWFDENAME);
    }

    @JsonIgnore
    public String getEmbedPSWFId() {
        Object objValue = this.get(FIELD_EMBEDPSWFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfid")
    public void setEmbedPSWFId(String embedPSWFId) {
        this.set(FIELD_EMBEDPSWFID, embedPSWFId);
    }

    @JsonIgnore
    public boolean isEmbedPSWFIdDirty() {
        return this.contains(FIELD_EMBEDPSWFID);
    }

    @JsonIgnore
    public String getEmbedPSWFName() {
        Object objValue = this.get(FIELD_EMBEDPSWFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="embedpswfname")
    public void setEmbedPSWFName(String embedPSWFName) {
        this.set(FIELD_EMBEDPSWFNAME, embedPSWFName);
    }

    @JsonIgnore
    public boolean isEmbedPSWFNameDirty() {
        return this.contains(FIELD_EMBEDPSWFNAME);
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
    public Integer getEnableMobile() {
        Object objValue = this.get(FIELD_ENABLEMOBILE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablemobile")
    public void setEnableMobile(Integer enableMobile) {
        this.set(FIELD_ENABLEMOBILE, enableMobile);
    }

    @JsonIgnore
    public boolean isEnableMobileDirty() {
        return this.contains(FIELD_ENABLEMOBILE);
    }

    @JsonIgnore
    public Integer getEnableTimeout() {
        Object objValue = this.get(FIELD_ENABLETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enabletimeout")
    public void setEnableTimeout(Integer enableTimeout) {
        this.set(FIELD_ENABLETIMEOUT, enableTimeout);
    }

    @JsonIgnore
    public boolean isEnableTimeoutDirty() {
        return this.contains(FIELD_ENABLETIMEOUT);
    }

    @JsonIgnore
    public String getExitStateName() {
        Object objValue = this.get(FIELD_EXITSTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exitstatename")
    public void setExitStateName(String exitStateName) {
        this.set(FIELD_EXITSTATENAME, exitStateName);
    }

    @JsonIgnore
    public boolean isExitStateNameDirty() {
        return this.contains(FIELD_EXITSTATENAME);
    }

    @JsonIgnore
    public String getExitStateValue() {
        Object objValue = this.get(FIELD_EXITSTATEVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exitstatevalue")
    public void setExitStateValue(String exitStateValue) {
        this.set(FIELD_EXITSTATEVALUE, exitStateValue);
    }

    @JsonIgnore
    public boolean isExitStateValueDirty() {
        return this.contains(FIELD_EXITSTATEVALUE);
    }

    @JsonIgnore
    public String getFormCodeName() {
        Object objValue = this.get(FIELD_FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="formcodename")
    public void setFormCodeName(String formCodeName) {
        this.set(FIELD_FORMCODENAME, formCodeName);
    }

    @JsonIgnore
    public boolean isFormCodeNameDirty() {
        return this.contains(FIELD_FORMCODENAME);
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
    public String getIconPath() {
        Object objValue = this.get(FIELD_ICONPATH);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpath")
    public void setIconPath(String iconPath) {
        this.set(FIELD_ICONPATH, iconPath);
    }

    @JsonIgnore
    public boolean isIconPathDirty() {
        return this.contains(FIELD_ICONPATH);
    }

    @JsonIgnore
    public Integer getLeftPos() {
        Object objValue = this.get(FIELD_LEFTPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="leftpos")
    public void setLeftPos(Integer leftPos) {
        this.set(FIELD_LEFTPOS, leftPos);
    }

    @JsonIgnore
    public boolean isLeftPosDirty() {
        return this.contains(FIELD_LEFTPOS);
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
    public String getMemoField() {
        Object objValue = this.get(FIELD_MEMOFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memofield")
    public void setMemoField(String memoField) {
        this.set(FIELD_MEMOFIELD, memoField);
    }

    @JsonIgnore
    public boolean isMemoFieldDirty() {
        return this.contains(FIELD_MEMOFIELD);
    }

    @JsonIgnore
    public String getMobFormCodeName() {
        Object objValue = this.get(FIELD_MOBFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobformcodename")
    public void setMobFormCodeName(String mobFormCodeName) {
        this.set(FIELD_MOBFORMCODENAME, mobFormCodeName);
    }

    @JsonIgnore
    public boolean isMobFormCodeNameDirty() {
        return this.contains(FIELD_MOBFORMCODENAME);
    }

    @JsonIgnore
    public String getMobPSDEFormId() {
        Object objValue = this.get(FIELD_MOBPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeformid")
    public void setMobPSDEFormId(String mobPSDEFormId) {
        this.set(FIELD_MOBPSDEFORMID, mobPSDEFormId);
    }

    @JsonIgnore
    public boolean isMobPSDEFormIdDirty() {
        return this.contains(FIELD_MOBPSDEFORMID);
    }

    @JsonIgnore
    public String getMobPSDEFormName() {
        Object objValue = this.get(FIELD_MOBPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeformname")
    public void setMobPSDEFormName(String mobPSDEFormName) {
        this.set(FIELD_MOBPSDEFORMNAME, mobPSDEFormName);
    }

    @JsonIgnore
    public boolean isMobPSDEFormNameDirty() {
        return this.contains(FIELD_MOBPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobPSDEUAGroupId() {
        Object objValue = this.get(FIELD_MOBPSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeuagroupid")
    public void setMobPSDEUAGroupId(String mobPSDEUAGroupId) {
        this.set(FIELD_MOBPSDEUAGROUPID, mobPSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isMobPSDEUAGroupIdDirty() {
        return this.contains(FIELD_MOBPSDEUAGROUPID);
    }

    @JsonIgnore
    public String getMobPSDEUAGroupName() {
        Object objValue = this.get(FIELD_MOBPSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeuagroupname")
    public void setMobPSDEUAGroupName(String mobPSDEUAGroupName) {
        this.set(FIELD_MOBPSDEUAGROUPNAME, mobPSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isMobPSDEUAGroupNameDirty() {
        return this.contains(FIELD_MOBPSDEUAGROUPNAME);
    }

    @JsonIgnore
    public String getMobPSDEViewId() {
        Object objValue = this.get(FIELD_MOBPSDEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeviewid")
    public void setMobPSDEViewId(String mobPSDEViewId) {
        this.set(FIELD_MOBPSDEVIEWID, mobPSDEViewId);
    }

    @JsonIgnore
    public boolean isMobPSDEViewIdDirty() {
        return this.contains(FIELD_MOBPSDEVIEWID);
    }

    @JsonIgnore
    public String getMobPSDEViewName() {
        Object objValue = this.get(FIELD_MOBPSDEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdeviewname")
    public void setMobPSDEViewName(String mobPSDEViewName) {
        this.set(FIELD_MOBPSDEVIEWNAME, mobPSDEViewName);
    }

    @JsonIgnore
    public boolean isMobPSDEViewNameDirty() {
        return this.contains(FIELD_MOBPSDEVIEWNAME);
    }

    @JsonIgnore
    public String getMobPSDynaDEViewTemplId() {
        Object objValue = this.get(FIELD_MOBPSDYNADEVIEWTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobpsdynadeviewtemplid")
    public void setMobPSDynaDEViewTemplId(String mobPSDynaDEViewTemplId) {
        this.set(FIELD_MOBPSDYNADEVIEWTEMPLID, mobPSDynaDEViewTemplId);
    }

    @JsonIgnore
    public boolean isMobPSDynaDEViewTemplIdDirty() {
        return this.contains(FIELD_MOBPSDYNADEVIEWTEMPLID);
    }

    @JsonIgnore
    public String getMobUAGroupCodeName() {
        Object objValue = this.get(FIELD_MOBUAGROUPCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobuagroupcodename")
    public void setMobUAGroupCodeName(String mobUAGroupCodeName) {
        this.set(FIELD_MOBUAGROUPCODENAME, mobUAGroupCodeName);
    }

    @JsonIgnore
    public boolean isMobUAGroupCodeNameDirty() {
        return this.contains(FIELD_MOBUAGROUPCODENAME);
    }

    @JsonIgnore
    public String getMobUtil2FormCodeName() {
        Object objValue = this.get(FIELD_MOBUTIL2FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil2formcodename")
    public void setMobUtil2FormCodeName(String mobUtil2FormCodeName) {
        this.set(FIELD_MOBUTIL2FORMCODENAME, mobUtil2FormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtil2FormCodeNameDirty() {
        return this.contains(FIELD_MOBUTIL2FORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtil2PSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTIL2PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil2psdeformid")
    public void setMobUtil2PSDEFormId(String mobUtil2PSDEFormId) {
        this.set(FIELD_MOBUTIL2PSDEFORMID, mobUtil2PSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtil2PSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTIL2PSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtil2PSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTIL2PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil2psdeformname")
    public void setMobUtil2PSDEFormName(String mobUtil2PSDEFormName) {
        this.set(FIELD_MOBUTIL2PSDEFORMNAME, mobUtil2PSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtil2PSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTIL2PSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobUtil3FormCodeName() {
        Object objValue = this.get(FIELD_MOBUTIL3FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil3formcodename")
    public void setMobUtil3FormCodeName(String mobUtil3FormCodeName) {
        this.set(FIELD_MOBUTIL3FORMCODENAME, mobUtil3FormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtil3FormCodeNameDirty() {
        return this.contains(FIELD_MOBUTIL3FORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtil3PSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTIL3PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil3psdeformid")
    public void setMobUtil3PSDEFormId(String mobUtil3PSDEFormId) {
        this.set(FIELD_MOBUTIL3PSDEFORMID, mobUtil3PSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtil3PSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTIL3PSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtil3PSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTIL3PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil3psdeformname")
    public void setMobUtil3PSDEFormName(String mobUtil3PSDEFormName) {
        this.set(FIELD_MOBUTIL3PSDEFORMNAME, mobUtil3PSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtil3PSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTIL3PSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobUtil4FormCodeName() {
        Object objValue = this.get(FIELD_MOBUTIL4FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil4formcodename")
    public void setMobUtil4FormCodeName(String mobUtil4FormCodeName) {
        this.set(FIELD_MOBUTIL4FORMCODENAME, mobUtil4FormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtil4FormCodeNameDirty() {
        return this.contains(FIELD_MOBUTIL4FORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtil4PSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTIL4PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil4psdeformid")
    public void setMobUtil4PSDEFormId(String mobUtil4PSDEFormId) {
        this.set(FIELD_MOBUTIL4PSDEFORMID, mobUtil4PSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtil4PSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTIL4PSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtil4PSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTIL4PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil4psdeformname")
    public void setMobUtil4PSDEFormName(String mobUtil4PSDEFormName) {
        this.set(FIELD_MOBUTIL4PSDEFORMNAME, mobUtil4PSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtil4PSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTIL4PSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobUtil5FormCodeName() {
        Object objValue = this.get(FIELD_MOBUTIL5FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil5formcodename")
    public void setMobUtil5FormCodeName(String mobUtil5FormCodeName) {
        this.set(FIELD_MOBUTIL5FORMCODENAME, mobUtil5FormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtil5FormCodeNameDirty() {
        return this.contains(FIELD_MOBUTIL5FORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtil5PSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTIL5PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil5psdeformid")
    public void setMobUtil5PSDEFormId(String mobUtil5PSDEFormId) {
        this.set(FIELD_MOBUTIL5PSDEFORMID, mobUtil5PSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtil5PSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTIL5PSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtil5PSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTIL5PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutil5psdeformname")
    public void setMobUtil5PSDEFormName(String mobUtil5PSDEFormName) {
        this.set(FIELD_MOBUTIL5PSDEFORMNAME, mobUtil5PSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtil5PSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTIL5PSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobUtilFormCodeName() {
        Object objValue = this.get(FIELD_MOBUTILFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilformcodename")
    public void setMobUtilFormCodeName(String mobUtilFormCodeName) {
        this.set(FIELD_MOBUTILFORMCODENAME, mobUtilFormCodeName);
    }

    @JsonIgnore
    public boolean isMobUtilFormCodeNameDirty() {
        return this.contains(FIELD_MOBUTILFORMCODENAME);
    }

    @JsonIgnore
    public String getMobUtilPSDEFormId() {
        Object objValue = this.get(FIELD_MOBUTILPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilpsdeformid")
    public void setMobUtilPSDEFormId(String mobUtilPSDEFormId) {
        this.set(FIELD_MOBUTILPSDEFORMID, mobUtilPSDEFormId);
    }

    @JsonIgnore
    public boolean isMobUtilPSDEFormIdDirty() {
        return this.contains(FIELD_MOBUTILPSDEFORMID);
    }

    @JsonIgnore
    public String getMobUtilPSDEFormName() {
        Object objValue = this.get(FIELD_MOBUTILPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobutilpsdeformname")
    public void setMobUtilPSDEFormName(String mobUtilPSDEFormName) {
        this.set(FIELD_MOBUTILPSDEFORMNAME, mobUtilPSDEFormName);
    }

    @JsonIgnore
    public boolean isMobUtilPSDEFormNameDirty() {
        return this.contains(FIELD_MOBUTILPSDEFORMNAME);
    }

    @JsonIgnore
    public String getMobWFEditViewType() {
        Object objValue = this.get(FIELD_MOBWFEDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobwfeditviewtype")
    public void setMobWFEditViewType(String mobWFEditViewType) {
        this.set(FIELD_MOBWFEDITVIEWTYPE, mobWFEditViewType);
    }

    @JsonIgnore
    public boolean isMobWFEditViewTypeDirty() {
        return this.contains(FIELD_MOBWFEDITVIEWTYPE);
    }

    @JsonIgnore
    public String getModelId() {
        Object objValue = this.get(FIELD_MODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="modelid")
    public void setModelId(String modelId) {
        this.set(FIELD_MODELID, modelId);
    }

    @JsonIgnore
    public boolean isModelIdDirty() {
        return this.contains(FIELD_MODELID);
    }

    @JsonIgnore
    public Integer getMsgType() {
        Object objValue = this.get(FIELD_MSGTYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="msgtype")
    public void setMsgType(Integer msgType) {
        this.set(FIELD_MSGTYPE, msgType);
    }

    @JsonIgnore
    public boolean isMsgTypeDirty() {
        return this.contains(FIELD_MSGTYPE);
    }

    @JsonIgnore
    public String getMultiInstMode() {
        Object objValue = this.get(FIELD_MULTIINSTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="multiinstmode")
    public void setMultiInstMode(String multiInstMode) {
        this.set(FIELD_MULTIINSTMODE, multiInstMode);
    }

    @JsonIgnore
    public boolean isMultiInstModeDirty() {
        return this.contains(FIELD_MULTIINSTMODE);
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
    public String getNormalProcType() {
        Object objValue = this.get(FIELD_NORMALPROCTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="normalproctype")
    public void setNormalProcType(String normalProcType) {
        this.set(FIELD_NORMALPROCTYPE, normalProcType);
    }

    @JsonIgnore
    public boolean isNormalProcTypeDirty() {
        return this.contains(FIELD_NORMALPROCTYPE);
    }

    @JsonIgnore
    public String getPredefinedActions() {
        Object objValue = this.get(FIELD_PREDEFINEDACTIONS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="predefinedactions")
    public void setPredefinedActions(String predefinedActions) {
        this.set(FIELD_PREDEFINEDACTIONS, predefinedActions);
    }

    @JsonIgnore
    public boolean isPredefinedActionsDirty() {
        return this.contains(FIELD_PREDEFINEDACTIONS);
    }

    @JsonIgnore
    public String getPSDEActionId() {
        Object objValue = this.get(FIELD_PSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionid")
    public void setPSDEActionId(String pSDEActionId) {
        this.set(FIELD_PSDEACTIONID, pSDEActionId);
    }

    @JsonIgnore
    public boolean isPSDEActionIdDirty() {
        return this.contains(FIELD_PSDEACTIONID);
    }

    @JsonIgnore
    public String getPSDEActionName() {
        Object objValue = this.get(FIELD_PSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionname")
    public void setPSDEActionName(String pSDEActionName) {
        this.set(FIELD_PSDEACTIONNAME, pSDEActionName);
    }

    @JsonIgnore
    public boolean isPSDEActionNameDirty() {
        return this.contains(FIELD_PSDEACTIONNAME);
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
    public String getPSDEUAGroupId() {
        Object objValue = this.get(FIELD_PSDEUAGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupid")
    public void setPSDEUAGroupId(String pSDEUAGroupId) {
        this.set(FIELD_PSDEUAGROUPID, pSDEUAGroupId);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupIdDirty() {
        return this.contains(FIELD_PSDEUAGROUPID);
    }

    @JsonIgnore
    public String getPSDEUAGroupName() {
        Object objValue = this.get(FIELD_PSDEUAGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuagroupname")
    public void setPSDEUAGroupName(String pSDEUAGroupName) {
        this.set(FIELD_PSDEUAGROUPNAME, pSDEUAGroupName);
    }

    @JsonIgnore
    public boolean isPSDEUAGroupNameDirty() {
        return this.contains(FIELD_PSDEUAGROUPNAME);
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
    public String getPSSysMsgTemplId() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplid")
    public void setPSSysMsgTemplId(String pSSysMsgTemplId) {
        this.set(FIELD_PSSYSMSGTEMPLID, pSSysMsgTemplId);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplIdDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLID);
    }

    @JsonIgnore
    public String getPSSysMsgTemplName() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplname")
    public void setPSSysMsgTemplName(String pSSysMsgTemplName) {
        this.set(FIELD_PSSYSMSGTEMPLNAME, pSSysMsgTemplName);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplNameDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLNAME);
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
    public String getPSWFProcessId() {
        Object objValue = this.get(FIELD_PSWFPROCESSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessid")
    public void setPSWFProcessId(String pSWFProcessId) {
        this.set(FIELD_PSWFPROCESSID, pSWFProcessId);
    }

    @JsonIgnore
    public boolean isPSWFProcessIdDirty() {
        return this.contains(FIELD_PSWFPROCESSID);
    }

    @JsonIgnore
    public String getPSWFProcessName() {
        Object objValue = this.get(FIELD_PSWFPROCESSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfprocessname")
    public void setPSWFProcessName(String pSWFProcessName) {
        this.set(FIELD_PSWFPROCESSNAME, pSWFProcessName);
    }

    @JsonIgnore
    public boolean isPSWFProcessNameDirty() {
        return this.contains(FIELD_PSWFPROCESSNAME);
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
    public String getPSWFWorkTimeId() {
        Object objValue = this.get(FIELD_PSWFWORKTIMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfworktimeid")
    public void setPSWFWorkTimeId(String pSWFWorkTimeId) {
        this.set(FIELD_PSWFWORKTIMEID, pSWFWorkTimeId);
    }

    @JsonIgnore
    public boolean isPSWFWorkTimeIdDirty() {
        return this.contains(FIELD_PSWFWORKTIMEID);
    }

    @JsonIgnore
    public String getPSWFWorkTimeName() {
        Object objValue = this.get(FIELD_PSWFWORKTIMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfworktimename")
    public void setPSWFWorkTimeName(String pSWFWorkTimeName) {
        this.set(FIELD_PSWFWORKTIMENAME, pSWFWorkTimeName);
    }

    @JsonIgnore
    public boolean isPSWFWorkTimeNameDirty() {
        return this.contains(FIELD_PSWFWORKTIMENAME);
    }

    @JsonIgnore
    public String getRefPSWFVersionId() {
        Object objValue = this.get(FIELD_REFPSWFVERSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpswfversionid")
    public void setRefPSWFVersionId(String refPSWFVersionId) {
        this.set(FIELD_REFPSWFVERSIONID, refPSWFVersionId);
    }

    @JsonIgnore
    public boolean isRefPSWFVersionIdDirty() {
        return this.contains(FIELD_REFPSWFVERSIONID);
    }

    @JsonIgnore
    public String getRefPSWFVersionName() {
        Object objValue = this.get(FIELD_REFPSWFVERSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="refpswfversionname")
    public void setRefPSWFVersionName(String refPSWFVersionName) {
        this.set(FIELD_REFPSWFVERSIONNAME, refPSWFVersionName);
    }

    @JsonIgnore
    public boolean isRefPSWFVersionNameDirty() {
        return this.contains(FIELD_REFPSWFVERSIONNAME);
    }

    @JsonIgnore
    public Integer getSendInform() {
        Object objValue = this.get(FIELD_SENDINFORM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="sendinform")
    public void setSendInform(Integer sendInform) {
        this.set(FIELD_SENDINFORM, sendInform);
    }

    @JsonIgnore
    public boolean isSendInformDirty() {
        return this.contains(FIELD_SENDINFORM);
    }

    @JsonIgnore
    public String getShapeParams() {
        Object objValue = this.get(FIELD_SHAPEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="shapeparams")
    public void setShapeParams(String shapeParams) {
        this.set(FIELD_SHAPEPARAMS, shapeParams);
    }

    @JsonIgnore
    public boolean isShapeParamsDirty() {
        return this.contains(FIELD_SHAPEPARAMS);
    }

    @JsonIgnore
    public String getThreadName() {
        Object objValue = this.get(FIELD_THREADNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="threadname")
    public void setThreadName(String threadName) {
        this.set(FIELD_THREADNAME, threadName);
    }

    @JsonIgnore
    public boolean isThreadNameDirty() {
        return this.contains(FIELD_THREADNAME);
    }

    @JsonIgnore
    public Integer getThreadSN() {
        Object objValue = this.get(FIELD_THREADSN);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="threadsn")
    public void setThreadSN(Integer threadSN) {
        this.set(FIELD_THREADSN, threadSN);
    }

    @JsonIgnore
    public boolean isThreadSNDirty() {
        return this.contains(FIELD_THREADSN);
    }

    @JsonIgnore
    public Integer getTimeout() {
        Object objValue = this.get(FIELD_TIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="timeout")
    public void setTimeout(Integer timeout) {
        this.set(FIELD_TIMEOUT, timeout);
    }

    @JsonIgnore
    public boolean isTimeoutDirty() {
        return this.contains(FIELD_TIMEOUT);
    }

    @JsonIgnore
    public String getTimeoutPSDEFId() {
        Object objValue = this.get(FIELD_TIMEOUTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timeoutpsdefid")
    public void setTimeoutPSDEFId(String timeoutPSDEFId) {
        this.set(FIELD_TIMEOUTPSDEFID, timeoutPSDEFId);
    }

    @JsonIgnore
    public boolean isTimeoutPSDEFIdDirty() {
        return this.contains(FIELD_TIMEOUTPSDEFID);
    }

    @JsonIgnore
    public String getTimeoutPSDEFName() {
        Object objValue = this.get(FIELD_TIMEOUTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timeoutpsdefname")
    public void setTimeoutPSDEFName(String timeoutPSDEFName) {
        this.set(FIELD_TIMEOUTPSDEFNAME, timeoutPSDEFName);
    }

    @JsonIgnore
    public boolean isTimeoutPSDEFNameDirty() {
        return this.contains(FIELD_TIMEOUTPSDEFNAME);
    }

    @JsonIgnore
    public String getTimeoutType() {
        Object objValue = this.get(FIELD_TIMEOUTTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="timeouttype")
    public void setTimeoutType(String timeoutType) {
        this.set(FIELD_TIMEOUTTYPE, timeoutType);
    }

    @JsonIgnore
    public boolean isTimeoutTypeDirty() {
        return this.contains(FIELD_TIMEOUTTYPE);
    }

    @JsonIgnore
    public Integer getTopPos() {
        Object objValue = this.get(FIELD_TOPPOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="toppos")
    public void setTopPos(Integer topPos) {
        this.set(FIELD_TOPPOS, topPos);
    }

    @JsonIgnore
    public boolean isTopPosDirty() {
        return this.contains(FIELD_TOPPOS);
    }

    @JsonIgnore
    public String getUAGroupCodeName() {
        Object objValue = this.get(FIELD_UAGROUPCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="uagroupcodename")
    public void setUAGroupCodeName(String uAGroupCodeName) {
        this.set(FIELD_UAGROUPCODENAME, uAGroupCodeName);
    }

    @JsonIgnore
    public boolean isUAGroupCodeNameDirty() {
        return this.contains(FIELD_UAGROUPCODENAME);
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
    public String getUtil2FormCodeName() {
        Object objValue = this.get(FIELD_UTIL2FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util2formcodename")
    public void setUtil2FormCodeName(String util2FormCodeName) {
        this.set(FIELD_UTIL2FORMCODENAME, util2FormCodeName);
    }

    @JsonIgnore
    public boolean isUtil2FormCodeNameDirty() {
        return this.contains(FIELD_UTIL2FORMCODENAME);
    }

    @JsonIgnore
    public String getUtil2PSDEFormId() {
        Object objValue = this.get(FIELD_UTIL2PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util2psdeformid")
    public void setUtil2PSDEFormId(String util2PSDEFormId) {
        this.set(FIELD_UTIL2PSDEFORMID, util2PSDEFormId);
    }

    @JsonIgnore
    public boolean isUtil2PSDEFormIdDirty() {
        return this.contains(FIELD_UTIL2PSDEFORMID);
    }

    @JsonIgnore
    public String getUtil2PSDEFormName() {
        Object objValue = this.get(FIELD_UTIL2PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util2psdeformname")
    public void setUtil2PSDEFormName(String util2PSDEFormName) {
        this.set(FIELD_UTIL2PSDEFORMNAME, util2PSDEFormName);
    }

    @JsonIgnore
    public boolean isUtil2PSDEFormNameDirty() {
        return this.contains(FIELD_UTIL2PSDEFORMNAME);
    }

    @JsonIgnore
    public String getUtil3FormCodeName() {
        Object objValue = this.get(FIELD_UTIL3FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util3formcodename")
    public void setUtil3FormCodeName(String util3FormCodeName) {
        this.set(FIELD_UTIL3FORMCODENAME, util3FormCodeName);
    }

    @JsonIgnore
    public boolean isUtil3FormCodeNameDirty() {
        return this.contains(FIELD_UTIL3FORMCODENAME);
    }

    @JsonIgnore
    public String getUtil3PSDEFormId() {
        Object objValue = this.get(FIELD_UTIL3PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util3psdeformid")
    public void setUtil3PSDEFormId(String util3PSDEFormId) {
        this.set(FIELD_UTIL3PSDEFORMID, util3PSDEFormId);
    }

    @JsonIgnore
    public boolean isUtil3PSDEFormIdDirty() {
        return this.contains(FIELD_UTIL3PSDEFORMID);
    }

    @JsonIgnore
    public String getUtil3PSDEFormName() {
        Object objValue = this.get(FIELD_UTIL3PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util3psdeformname")
    public void setUtil3PSDEFormName(String util3PSDEFormName) {
        this.set(FIELD_UTIL3PSDEFORMNAME, util3PSDEFormName);
    }

    @JsonIgnore
    public boolean isUtil3PSDEFormNameDirty() {
        return this.contains(FIELD_UTIL3PSDEFORMNAME);
    }

    @JsonIgnore
    public String getUtil4FormCodeName() {
        Object objValue = this.get(FIELD_UTIL4FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util4formcodename")
    public void setUtil4FormCodeName(String util4FormCodeName) {
        this.set(FIELD_UTIL4FORMCODENAME, util4FormCodeName);
    }

    @JsonIgnore
    public boolean isUtil4FormCodeNameDirty() {
        return this.contains(FIELD_UTIL4FORMCODENAME);
    }

    @JsonIgnore
    public String getUtil4PSDEFormId() {
        Object objValue = this.get(FIELD_UTIL4PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util4psdeformid")
    public void setUtil4PSDEFormId(String util4PSDEFormId) {
        this.set(FIELD_UTIL4PSDEFORMID, util4PSDEFormId);
    }

    @JsonIgnore
    public boolean isUtil4PSDEFormIdDirty() {
        return this.contains(FIELD_UTIL4PSDEFORMID);
    }

    @JsonIgnore
    public String getUtil4PSDEFormName() {
        Object objValue = this.get(FIELD_UTIL4PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util4psdeformname")
    public void setUtil4PSDEFormName(String util4PSDEFormName) {
        this.set(FIELD_UTIL4PSDEFORMNAME, util4PSDEFormName);
    }

    @JsonIgnore
    public boolean isUtil4PSDEFormNameDirty() {
        return this.contains(FIELD_UTIL4PSDEFORMNAME);
    }

    @JsonIgnore
    public String getUtil5FormCodeName() {
        Object objValue = this.get(FIELD_UTIL5FORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util5formcodename")
    public void setUtil5FormCodeName(String util5FormCodeName) {
        this.set(FIELD_UTIL5FORMCODENAME, util5FormCodeName);
    }

    @JsonIgnore
    public boolean isUtil5FormCodeNameDirty() {
        return this.contains(FIELD_UTIL5FORMCODENAME);
    }

    @JsonIgnore
    public String getUtil5PSDEFormId() {
        Object objValue = this.get(FIELD_UTIL5PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util5psdeformid")
    public void setUtil5PSDEFormId(String util5PSDEFormId) {
        this.set(FIELD_UTIL5PSDEFORMID, util5PSDEFormId);
    }

    @JsonIgnore
    public boolean isUtil5PSDEFormIdDirty() {
        return this.contains(FIELD_UTIL5PSDEFORMID);
    }

    @JsonIgnore
    public String getUtil5PSDEFormName() {
        Object objValue = this.get(FIELD_UTIL5PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="util5psdeformname")
    public void setUtil5PSDEFormName(String util5PSDEFormName) {
        this.set(FIELD_UTIL5PSDEFORMNAME, util5PSDEFormName);
    }

    @JsonIgnore
    public boolean isUtil5PSDEFormNameDirty() {
        return this.contains(FIELD_UTIL5PSDEFORMNAME);
    }

    @JsonIgnore
    public String getUtilFormCodeName() {
        Object objValue = this.get(FIELD_UTILFORMCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilformcodename")
    public void setUtilFormCodeName(String utilFormCodeName) {
        this.set(FIELD_UTILFORMCODENAME, utilFormCodeName);
    }

    @JsonIgnore
    public boolean isUtilFormCodeNameDirty() {
        return this.contains(FIELD_UTILFORMCODENAME);
    }

    @JsonIgnore
    public String getUtilPSDEFormId() {
        Object objValue = this.get(FIELD_UTILPSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeformid")
    public void setUtilPSDEFormId(String utilPSDEFormId) {
        this.set(FIELD_UTILPSDEFORMID, utilPSDEFormId);
    }

    @JsonIgnore
    public boolean isUtilPSDEFormIdDirty() {
        return this.contains(FIELD_UTILPSDEFORMID);
    }

    @JsonIgnore
    public String getUtilPSDEFormName() {
        Object objValue = this.get(FIELD_UTILPSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeformname")
    public void setUtilPSDEFormName(String utilPSDEFormName) {
        this.set(FIELD_UTILPSDEFORMNAME, utilPSDEFormName);
    }

    @JsonIgnore
    public boolean isUtilPSDEFormNameDirty() {
        return this.contains(FIELD_UTILPSDEFORMNAME);
    }

    @JsonIgnore
    public String getWFEditViewType() {
        Object objValue = this.get(FIELD_WFEDITVIEWTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfeditviewtype")
    public void setWFEditViewType(String wFEditViewType) {
        this.set(FIELD_WFEDITVIEWTYPE, wFEditViewType);
    }

    @JsonIgnore
    public boolean isWFEditViewTypeDirty() {
        return this.contains(FIELD_WFEDITVIEWTYPE);
    }

    @JsonIgnore
    public String getWFEngineType() {
        Object objValue = this.get(FIELD_WFENGINETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfenginetype")
    public void setWFEngineType(String wFEngineType) {
        this.set(FIELD_WFENGINETYPE, wFEngineType);
    }

    @JsonIgnore
    public boolean isWFEngineTypeDirty() {
        return this.contains(FIELD_WFENGINETYPE);
    }

    @JsonIgnore
    public String getWFProcessType() {
        Object objValue = this.get(FIELD_WFPROCESSTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfprocesstype")
    public void setWFProcessType(String wFProcessType) {
        this.set(FIELD_WFPROCESSTYPE, wFProcessType);
    }

    @JsonIgnore
    public boolean isWFProcessTypeDirty() {
        return this.contains(FIELD_WFPROCESSTYPE);
    }

    @JsonIgnore
    public String getWFStepName() {
        Object objValue = this.get(FIELD_WFSTEPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstepname")
    public void setWFStepName(String wFStepName) {
        this.set(FIELD_WFSTEPNAME, wFStepName);
    }

    @JsonIgnore
    public boolean isWFStepNameDirty() {
        return this.contains(FIELD_WFSTEPNAME);
    }

    @JsonIgnore
    public String getWFStepValue() {
        Object objValue = this.get(FIELD_WFSTEPVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wfstepvalue")
    public void setWFStepValue(String wFStepValue) {
        this.set(FIELD_WFSTEPVALUE, wFStepValue);
    }

    @JsonIgnore
    public boolean isWFStepValueDirty() {
        return this.contains(FIELD_WFSTEPVALUE);
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
        return this.getPSWFProcessId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWFProcessId(strValue);
    }

    @JsonProperty(value="pswfprocroles")
    public List<PSWFProcRoleDTO> getPswfprocroles() {
        return this.pswfprocroles;
    }

    @JsonProperty(value="pswfprocroles")
    public void setPswfprocroles(List<PSWFProcRoleDTO> pswfprocroles) {
        this.pswfprocroles = pswfprocroles;
    }

    @JsonProperty(value="pswfprocsubwfs")
    public List<PSWFProcSubWFDTO> getPswfprocsubwfs() {
        return this.pswfprocsubwfs;
    }

    @JsonProperty(value="pswfprocsubwfs")
    public void setPswfprocsubwfs(List<PSWFProcSubWFDTO> pswfprocsubwfs) {
        this.pswfprocsubwfs = pswfprocsubwfs;
    }

    @JsonProperty(value="pswfprocparams")
    public List<PSWFProcParamDTO> getPswfprocparams() {
        return this.pswfprocparams;
    }

    @JsonProperty(value="pswfprocparams")
    public void setPswfprocparams(List<PSWFProcParamDTO> pswfprocparams) {
        this.pswfprocparams = pswfprocparams;
    }
}

