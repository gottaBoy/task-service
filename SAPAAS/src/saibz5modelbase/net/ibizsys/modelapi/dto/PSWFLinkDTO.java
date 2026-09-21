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
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.dto.PSWFLinkRoleDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSWFLinkDTO
extends PSModelDTOBase {
    public static final String FIELD_ACTIONFIELD = "actionfield";
    public static final String FIELD_ACTIONPSCODELISTID = "actionpscodelistid";
    public static final String FIELD_ACTIONPSCODELISTNAME = "actionpscodelistname";
    public static final String FIELD_ACTORFIELDS = "actorfields";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_CUSTOMCONDFLAG = "customcondflag";
    public static final String FIELD_DEFAULTLINK = "defaultlink";
    public static final String FIELD_DSTENDPOINT = "dstendpoint";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ENABLE = "enable";
    public static final String FIELD_ENABLEMOBILE = "enablemobile";
    public static final String FIELD_FORMCODENAME = "formcodename";
    public static final String FIELD_FROMPSWFPROCID = "frompswfprocid";
    public static final String FIELD_FROMPSWFPROCNAME = "frompswfprocname";
    public static final String FIELD_LABEL = "label";
    public static final String FIELD_LNPSLANRESID = "lnpslanresid";
    public static final String FIELD_LNPSLANRESNAME = "lnpslanresname";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MEMOFIELD = "memofield";
    public static final String FIELD_MOBFORMCODENAME = "mobformcodename";
    public static final String FIELD_MOBPSDEFORMID = "mobpsdeformid";
    public static final String FIELD_MOBPSDEFORMNAME = "mobpsdeformname";
    public static final String FIELD_MOBPSDEVIEWID = "mobpsdeviewid";
    public static final String FIELD_MOBPSDEVIEWNAME = "mobpsdeviewname";
    public static final String FIELD_MOBVIEWCODENAME = "mobviewcodename";
    public static final String FIELD_MODELID = "modelid";
    public static final String FIELD_NEXTCOND = "nextcond";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEVIEWBASEID = "psdeviewbaseid";
    public static final String FIELD_PSDEVIEWBASENAME = "psdeviewbasename";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    public static final String FIELD_PSWFID = "pswfid";
    public static final String FIELD_PSWFLINKID = "pswflinkid";
    public static final String FIELD_PSWFLINKNAME = "pswflinkname";
    public static final String FIELD_PSWFNAME = "pswfname";
    public static final String FIELD_PSWFROLEID = "pswfroleid";
    public static final String FIELD_PSWFROLENAME = "pswfrolename";
    public static final String FIELD_PSWFVERSIONID = "pswfversionid";
    public static final String FIELD_PSWFVERSIONNAME = "pswfversionname";
    public static final String FIELD_SHAPEPARAMS = "shapeparams";
    public static final String FIELD_SOMEROLEFLAG = "someroleflag";
    public static final String FIELD_SRCENDPOINT = "srcendpoint";
    public static final String FIELD_THREADFLAG = "threadflag";
    public static final String FIELD_THREADNAME = "threadname";
    public static final String FIELD_TIPPSLANRESID = "tippslanresid";
    public static final String FIELD_TIPPSLANRESNAME = "tippslanresname";
    public static final String FIELD_TOPSWFPROCID = "topswfprocid";
    public static final String FIELD_TOPSWFPROCNAME = "topswfprocname";
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
    public static final String FIELD_VIEWCODENAME = "viewcodename";
    public static final String FIELD_WFENGINETYPE = "wfenginetype";
    public static final String FIELD_WFLINKTYPE = "wflinktype";
    private List<PSWFLinkRoleDTO> pswflinkroles;
    private List<PSWFLinkCondDTO> pswflinkconds;

    @JsonIgnore
    public String getActionField() {
        Object objValue = this.get(FIELD_ACTIONFIELD);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionfield")
    public void setActionField(String actionField) {
        this.set(FIELD_ACTIONFIELD, actionField);
    }

    @JsonIgnore
    public boolean isActionFieldDirty() {
        return this.contains(FIELD_ACTIONFIELD);
    }

    @JsonIgnore
    public String getActionPSCodeListId() {
        Object objValue = this.get(FIELD_ACTIONPSCODELISTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpscodelistid")
    public void setActionPSCodeListId(String actionPSCodeListId) {
        this.set(FIELD_ACTIONPSCODELISTID, actionPSCodeListId);
    }

    @JsonIgnore
    public boolean isActionPSCodeListIdDirty() {
        return this.contains(FIELD_ACTIONPSCODELISTID);
    }

    @JsonIgnore
    public String getActionPSCodeListName() {
        Object objValue = this.get(FIELD_ACTIONPSCODELISTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actionpscodelistname")
    public void setActionPSCodeListName(String actionPSCodeListName) {
        this.set(FIELD_ACTIONPSCODELISTNAME, actionPSCodeListName);
    }

    @JsonIgnore
    public boolean isActionPSCodeListNameDirty() {
        return this.contains(FIELD_ACTIONPSCODELISTNAME);
    }

    @JsonIgnore
    public String getActorFields() {
        Object objValue = this.get(FIELD_ACTORFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="actorfields")
    public void setActorFields(String actorFields) {
        this.set(FIELD_ACTORFIELDS, actorFields);
    }

    @JsonIgnore
    public boolean isActorFieldsDirty() {
        return this.contains(FIELD_ACTORFIELDS);
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
    public String getCustomCond() {
        Object objValue = this.get(FIELD_CUSTOMCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcond")
    public void setCustomCond(String customCond) {
        this.set(FIELD_CUSTOMCOND, customCond);
    }

    @JsonIgnore
    public boolean isCustomCondDirty() {
        return this.contains(FIELD_CUSTOMCOND);
    }

    @JsonIgnore
    public Integer getCustomCondFlag() {
        Object objValue = this.get(FIELD_CUSTOMCONDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="customcondflag")
    public void setCustomCondFlag(Integer customCondFlag) {
        this.set(FIELD_CUSTOMCONDFLAG, customCondFlag);
    }

    @JsonIgnore
    public boolean isCustomCondFlagDirty() {
        return this.contains(FIELD_CUSTOMCONDFLAG);
    }

    @JsonIgnore
    public Integer getDefaultLink() {
        Object objValue = this.get(FIELD_DEFAULTLINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultlink")
    public void setDefaultLink(Integer defaultLink) {
        this.set(FIELD_DEFAULTLINK, defaultLink);
    }

    @JsonIgnore
    public boolean isDefaultLinkDirty() {
        return this.contains(FIELD_DEFAULTLINK);
    }

    @JsonIgnore
    public String getDstEndPoint() {
        Object objValue = this.get(FIELD_DSTENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstendpoint")
    public void setDstEndPoint(String dstEndPoint) {
        this.set(FIELD_DSTENDPOINT, dstEndPoint);
    }

    @JsonIgnore
    public boolean isDstEndPointDirty() {
        return this.contains(FIELD_DSTENDPOINT);
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
    public String getFromPSWFProcId() {
        Object objValue = this.get(FIELD_FROMPSWFPROCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="frompswfprocid")
    public void setFromPSWFProcId(String fromPSWFProcId) {
        this.set(FIELD_FROMPSWFPROCID, fromPSWFProcId);
    }

    @JsonIgnore
    public boolean isFromPSWFProcIdDirty() {
        return this.contains(FIELD_FROMPSWFPROCID);
    }

    @JsonIgnore
    public String getFromPSWFProcName() {
        Object objValue = this.get(FIELD_FROMPSWFPROCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="frompswfprocname")
    public void setFromPSWFProcName(String fromPSWFProcName) {
        this.set(FIELD_FROMPSWFPROCNAME, fromPSWFProcName);
    }

    @JsonIgnore
    public boolean isFromPSWFProcNameDirty() {
        return this.contains(FIELD_FROMPSWFPROCNAME);
    }

    @JsonIgnore
    public String getLabel() {
        Object objValue = this.get(FIELD_LABEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="label")
    public void setLabel(String label) {
        this.set(FIELD_LABEL, label);
    }

    @JsonIgnore
    public boolean isLabelDirty() {
        return this.contains(FIELD_LABEL);
    }

    @JsonIgnore
    public String getLNPSLanResId() {
        Object objValue = this.get(FIELD_LNPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresid")
    public void setLNPSLanResId(String lNPSLanResId) {
        this.set(FIELD_LNPSLANRESID, lNPSLanResId);
    }

    @JsonIgnore
    public boolean isLNPSLanResIdDirty() {
        return this.contains(FIELD_LNPSLANRESID);
    }

    @JsonIgnore
    public String getLNPSLanResName() {
        Object objValue = this.get(FIELD_LNPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="lnpslanresname")
    public void setLNPSLanResName(String lNPSLanResName) {
        this.set(FIELD_LNPSLANRESNAME, lNPSLanResName);
    }

    @JsonIgnore
    public boolean isLNPSLanResNameDirty() {
        return this.contains(FIELD_LNPSLANRESNAME);
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
    public String getMobViewCodeName() {
        Object objValue = this.get(FIELD_MOBVIEWCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="mobviewcodename")
    public void setMobViewCodeName(String mobViewCodeName) {
        this.set(FIELD_MOBVIEWCODENAME, mobViewCodeName);
    }

    @JsonIgnore
    public boolean isMobViewCodeNameDirty() {
        return this.contains(FIELD_MOBVIEWCODENAME);
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
    public String getNextCond() {
        Object objValue = this.get(FIELD_NEXTCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nextcond")
    public void setNextCond(String nextCond) {
        this.set(FIELD_NEXTCOND, nextCond);
    }

    @JsonIgnore
    public boolean isNextCondDirty() {
        return this.contains(FIELD_NEXTCOND);
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
    public String getPSWFLinkId() {
        Object objValue = this.get(FIELD_PSWFLINKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkid")
    public void setPSWFLinkId(String pSWFLinkId) {
        this.set(FIELD_PSWFLINKID, pSWFLinkId);
    }

    @JsonIgnore
    public boolean isPSWFLinkIdDirty() {
        return this.contains(FIELD_PSWFLINKID);
    }

    @JsonIgnore
    public String getPSWFLinkName() {
        Object objValue = this.get(FIELD_PSWFLINKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswflinkname")
    public void setPSWFLinkName(String pSWFLinkName) {
        this.set(FIELD_PSWFLINKNAME, pSWFLinkName);
    }

    @JsonIgnore
    public boolean isPSWFLinkNameDirty() {
        return this.contains(FIELD_PSWFLINKNAME);
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
    public String getPSWFRoleId() {
        Object objValue = this.get(FIELD_PSWFROLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfroleid")
    public void setPSWFRoleId(String pSWFRoleId) {
        this.set(FIELD_PSWFROLEID, pSWFRoleId);
    }

    @JsonIgnore
    public boolean isPSWFRoleIdDirty() {
        return this.contains(FIELD_PSWFROLEID);
    }

    @JsonIgnore
    public String getPSWFRoleName() {
        Object objValue = this.get(FIELD_PSWFROLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pswfrolename")
    public void setPSWFRoleName(String pSWFRoleName) {
        this.set(FIELD_PSWFROLENAME, pSWFRoleName);
    }

    @JsonIgnore
    public boolean isPSWFRoleNameDirty() {
        return this.contains(FIELD_PSWFROLENAME);
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
    public Integer getSomeRoleFlag() {
        Object objValue = this.get(FIELD_SOMEROLEFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="someroleflag")
    public void setSomeRoleFlag(Integer someRoleFlag) {
        this.set(FIELD_SOMEROLEFLAG, someRoleFlag);
    }

    @JsonIgnore
    public boolean isSomeRoleFlagDirty() {
        return this.contains(FIELD_SOMEROLEFLAG);
    }

    @JsonIgnore
    public String getSrcEndPoint() {
        Object objValue = this.get(FIELD_SRCENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcendpoint")
    public void setSrcEndPoint(String srcEndPoint) {
        this.set(FIELD_SRCENDPOINT, srcEndPoint);
    }

    @JsonIgnore
    public boolean isSrcEndPointDirty() {
        return this.contains(FIELD_SRCENDPOINT);
    }

    @JsonIgnore
    public Integer getThreadFlag() {
        Object objValue = this.get(FIELD_THREADFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="threadflag")
    public void setThreadFlag(Integer threadFlag) {
        this.set(FIELD_THREADFLAG, threadFlag);
    }

    @JsonIgnore
    public boolean isThreadFlagDirty() {
        return this.contains(FIELD_THREADFLAG);
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
    public String getToPSWFProcId() {
        Object objValue = this.get(FIELD_TOPSWFPROCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topswfprocid")
    public void setToPSWFProcId(String toPSWFProcId) {
        this.set(FIELD_TOPSWFPROCID, toPSWFProcId);
    }

    @JsonIgnore
    public boolean isToPSWFProcIdDirty() {
        return this.contains(FIELD_TOPSWFPROCID);
    }

    @JsonIgnore
    public String getToPSWFProcName() {
        Object objValue = this.get(FIELD_TOPSWFPROCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="topswfprocname")
    public void setToPSWFProcName(String toPSWFProcName) {
        this.set(FIELD_TOPSWFPROCNAME, toPSWFProcName);
    }

    @JsonIgnore
    public boolean isToPSWFProcNameDirty() {
        return this.contains(FIELD_TOPSWFPROCNAME);
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
    public String getViewCodeName() {
        Object objValue = this.get(FIELD_VIEWCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="viewcodename")
    public void setViewCodeName(String viewCodeName) {
        this.set(FIELD_VIEWCODENAME, viewCodeName);
    }

    @JsonIgnore
    public boolean isViewCodeNameDirty() {
        return this.contains(FIELD_VIEWCODENAME);
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
    public String getWFLinkType() {
        Object objValue = this.get(FIELD_WFLINKTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="wflinktype")
    public void setWFLinkType(String wFLinkType) {
        this.set(FIELD_WFLINKTYPE, wFLinkType);
    }

    @JsonIgnore
    public boolean isWFLinkTypeDirty() {
        return this.contains(FIELD_WFLINKTYPE);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSWFLinkId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSWFLinkId(strValue);
    }

    @JsonProperty(value="pswflinkroles")
    public List<PSWFLinkRoleDTO> getPswflinkroles() {
        return this.pswflinkroles;
    }

    @JsonProperty(value="pswflinkroles")
    public void setPswflinkroles(List<PSWFLinkRoleDTO> pswflinkroles) {
        this.pswflinkroles = pswflinkroles;
    }

    @JsonProperty(value="pswflinkconds")
    public List<PSWFLinkCondDTO> getPswflinkconds() {
        return this.pswflinkconds;
    }

    @JsonProperty(value="pswflinkconds")
    public void setPswflinkconds(List<PSWFLinkCondDTO> pswflinkconds) {
        this.pswflinkconds = pswflinkconds;
    }
}

