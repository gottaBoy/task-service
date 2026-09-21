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

public class PSDEActionLogicDTO
extends PSModelDTOBase {
    public static final String FIELD_ATTACHMODE = "attachmode";
    public static final String FIELD_CLONEPARAMFLAG = "cloneparamflag";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_DSTPSDEACTIONID = "dstpsdeactionid";
    public static final String FIELD_DSTPSDEACTIONNAME = "dstpsdeactionname";
    public static final String FIELD_DSTPSDEDATAQUERYID = "dstpsdedataqueryid";
    public static final String FIELD_DSTPSDEDATAQUERYNAME = "dstpsdedataqueryname";
    public static final String FIELD_DSTPSDEDATASETID = "dstpsdedatasetid";
    public static final String FIELD_DSTPSDEDATASETNAME = "dstpsdedatasetname";
    public static final String FIELD_DSTPSDEID = "dstpsdeid";
    public static final String FIELD_DSTPSDENAME = "dstpsdename";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ERRORCODE = "errorcode";
    public static final String FIELD_ERRORMSG = "errormsg";
    public static final String FIELD_ERRORPSLANRESID = "errorpslanresid";
    public static final String FIELD_ERRORPSLANRESNAME = "errorpslanresname";
    public static final String FIELD_EXCEPTIONOBJ = "exceptionobj";
    public static final String FIELD_IGNOREEXCEPTION = "ignoreexception";
    public static final String FIELD_INTERNALLOGIC = "internallogic";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_LOGICHOLDER = "logicholder";
    public static final String FIELD_MAJORPSDERID = "majorpsderid";
    public static final String FIELD_MAJORPSDERNAME = "majorpsdername";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINORPSDERID = "minorpsderid";
    public static final String FIELD_MINORPSDERNAME = "minorpsdername";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PREPARELAST = "preparelast";
    public static final String FIELD_PROPERTYMAP = "propertymap";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONLOGICID = "psdeactionlogicid";
    public static final String FIELD_PSDEACTIONLOGICNAME = "psdeactionlogicname";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDEDATASYNCID = "psdedatasyncid";
    public static final String FIELD_PSDEDATASYNCNAME = "psdedatasyncname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEFVALUERULEID = "psdefvalueruleid";
    public static final String FIELD_PSDEFVALUERULENAME = "psdefvaluerulename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDENOTIFYID = "psdenotifyid";
    public static final String FIELD_PSDENOTIFYNAME = "psdenotifyname";
    public static final String FIELD_PSSYSDELOGICNODEID = "pssysdelogicnodeid";
    public static final String FIELD_PSSYSDELOGICNODENAME = "pssysdelogicnodename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSEQUENCEID = "pssyssequenceid";
    public static final String FIELD_PSSYSSEQUENCENAME = "pssyssequencename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTRANSLATORID = "pssystranslatorid";
    public static final String FIELD_PSSYSTRANSLATORNAME = "pssystranslatorname";
    public static final String FIELD_PSSYSVALUERULEID = "pssysvalueruleid";
    public static final String FIELD_PSSYSVALUERULENAME = "pssysvaluerulename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";

    @JsonIgnore
    public String getAttachMode() {
        Object objValue = this.get(FIELD_ATTACHMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="attachmode")
    public void setAttachMode(String attachMode) {
        this.set(FIELD_ATTACHMODE, attachMode);
    }

    @JsonIgnore
    public boolean isAttachModeDirty() {
        return this.contains(FIELD_ATTACHMODE);
    }

    @JsonIgnore
    public Integer getCloneParamFlag() {
        Object objValue = this.get(FIELD_CLONEPARAMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cloneparamflag")
    public void setCloneParamFlag(Integer cloneParamFlag) {
        this.set(FIELD_CLONEPARAMFLAG, cloneParamFlag);
    }

    @JsonIgnore
    public boolean isCloneParamFlagDirty() {
        return this.contains(FIELD_CLONEPARAMFLAG);
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
    public String getCustomCode() {
        Object objValue = this.get(FIELD_CUSTOMCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customcode")
    public void setCustomCode(String customCode) {
        this.set(FIELD_CUSTOMCODE, customCode);
    }

    @JsonIgnore
    public boolean isCustomCodeDirty() {
        return this.contains(FIELD_CUSTOMCODE);
    }

    @JsonIgnore
    public String getDstPSDEActionId() {
        Object objValue = this.get(FIELD_DSTPSDEACTIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeactionid")
    public void setDstPSDEActionId(String dstPSDEActionId) {
        this.set(FIELD_DSTPSDEACTIONID, dstPSDEActionId);
    }

    @JsonIgnore
    public boolean isDstPSDEActionIdDirty() {
        return this.contains(FIELD_DSTPSDEACTIONID);
    }

    @JsonIgnore
    public String getDstPSDEActionName() {
        Object objValue = this.get(FIELD_DSTPSDEACTIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeactionname")
    public void setDstPSDEActionName(String dstPSDEActionName) {
        this.set(FIELD_DSTPSDEACTIONNAME, dstPSDEActionName);
    }

    @JsonIgnore
    public boolean isDstPSDEActionNameDirty() {
        return this.contains(FIELD_DSTPSDEACTIONNAME);
    }

    @JsonIgnore
    public String getDstPSDEDataQueryId() {
        Object objValue = this.get(FIELD_DSTPSDEDATAQUERYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataqueryid")
    public void setDstPSDEDataQueryId(String dstPSDEDataQueryId) {
        this.set(FIELD_DSTPSDEDATAQUERYID, dstPSDEDataQueryId);
    }

    @JsonIgnore
    public boolean isDstPSDEDataQueryIdDirty() {
        return this.contains(FIELD_DSTPSDEDATAQUERYID);
    }

    @JsonIgnore
    public String getDstPSDEDataQueryName() {
        Object objValue = this.get(FIELD_DSTPSDEDATAQUERYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataqueryname")
    public void setDstPSDEDataQueryName(String dstPSDEDataQueryName) {
        this.set(FIELD_DSTPSDEDATAQUERYNAME, dstPSDEDataQueryName);
    }

    @JsonIgnore
    public boolean isDstPSDEDataQueryNameDirty() {
        return this.contains(FIELD_DSTPSDEDATAQUERYNAME);
    }

    @JsonIgnore
    public String getDstPSDEDataSetId() {
        Object objValue = this.get(FIELD_DSTPSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedatasetid")
    public void setDstPSDEDataSetId(String dstPSDEDataSetId) {
        this.set(FIELD_DSTPSDEDATASETID, dstPSDEDataSetId);
    }

    @JsonIgnore
    public boolean isDstPSDEDataSetIdDirty() {
        return this.contains(FIELD_DSTPSDEDATASETID);
    }

    @JsonIgnore
    public String getDstPSDEDataSetName() {
        Object objValue = this.get(FIELD_DSTPSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedatasetname")
    public void setDstPSDEDataSetName(String dstPSDEDataSetName) {
        this.set(FIELD_DSTPSDEDATASETNAME, dstPSDEDataSetName);
    }

    @JsonIgnore
    public boolean isDstPSDEDataSetNameDirty() {
        return this.contains(FIELD_DSTPSDEDATASETNAME);
    }

    @JsonIgnore
    public String getDstPSDEId() {
        Object objValue = this.get(FIELD_DSTPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeid")
    public void setDstPSDEId(String dstPSDEId) {
        this.set(FIELD_DSTPSDEID, dstPSDEId);
    }

    @JsonIgnore
    public boolean isDstPSDEIdDirty() {
        return this.contains(FIELD_DSTPSDEID);
    }

    @JsonIgnore
    public String getDstPSDEName() {
        Object objValue = this.get(FIELD_DSTPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdename")
    public void setDstPSDEName(String dstPSDEName) {
        this.set(FIELD_DSTPSDENAME, dstPSDEName);
    }

    @JsonIgnore
    public boolean isDstPSDENameDirty() {
        return this.contains(FIELD_DSTPSDENAME);
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
    public Integer getErrorCode() {
        Object objValue = this.get(FIELD_ERRORCODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="errorcode")
    public void setErrorCode(Integer errorCode) {
        this.set(FIELD_ERRORCODE, errorCode);
    }

    @JsonIgnore
    public boolean isErrorCodeDirty() {
        return this.contains(FIELD_ERRORCODE);
    }

    @JsonIgnore
    public String getErrorMsg() {
        Object objValue = this.get(FIELD_ERRORMSG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errormsg")
    public void setErrorMsg(String errorMsg) {
        this.set(FIELD_ERRORMSG, errorMsg);
    }

    @JsonIgnore
    public boolean isErrorMsgDirty() {
        return this.contains(FIELD_ERRORMSG);
    }

    @JsonIgnore
    public String getErrorPSLanResId() {
        Object objValue = this.get(FIELD_ERRORPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errorpslanresid")
    public void setErrorPSLanResId(String errorPSLanResId) {
        this.set(FIELD_ERRORPSLANRESID, errorPSLanResId);
    }

    @JsonIgnore
    public boolean isErrorPSLanResIdDirty() {
        return this.contains(FIELD_ERRORPSLANRESID);
    }

    @JsonIgnore
    public String getErrorPSLanResName() {
        Object objValue = this.get(FIELD_ERRORPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="errorpslanresname")
    public void setErrorPSLanResName(String errorPSLanResName) {
        this.set(FIELD_ERRORPSLANRESNAME, errorPSLanResName);
    }

    @JsonIgnore
    public boolean isErrorPSLanResNameDirty() {
        return this.contains(FIELD_ERRORPSLANRESNAME);
    }

    @JsonIgnore
    public String getExceptionObj() {
        Object objValue = this.get(FIELD_EXCEPTIONOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="exceptionobj")
    public void setExceptionObj(String exceptionObj) {
        this.set(FIELD_EXCEPTIONOBJ, exceptionObj);
    }

    @JsonIgnore
    public boolean isExceptionObjDirty() {
        return this.contains(FIELD_EXCEPTIONOBJ);
    }

    @JsonIgnore
    public Integer getIgnoreException() {
        Object objValue = this.get(FIELD_IGNOREEXCEPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoreexception")
    public void setIgnoreException(Integer ignoreException) {
        this.set(FIELD_IGNOREEXCEPTION, ignoreException);
    }

    @JsonIgnore
    public boolean isIgnoreExceptionDirty() {
        return this.contains(FIELD_IGNOREEXCEPTION);
    }

    @JsonIgnore
    public Integer getInternalLogic() {
        Object objValue = this.get(FIELD_INTERNALLOGIC);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="internallogic")
    public void setInternalLogic(Integer internalLogic) {
        this.set(FIELD_INTERNALLOGIC, internalLogic);
    }

    @JsonIgnore
    public boolean isInternalLogicDirty() {
        return this.contains(FIELD_INTERNALLOGIC);
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
    public Integer getLogicHolder() {
        Object objValue = this.get(FIELD_LOGICHOLDER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="logicholder")
    public void setLogicHolder(Integer logicHolder) {
        this.set(FIELD_LOGICHOLDER, logicHolder);
    }

    @JsonIgnore
    public boolean isLogicHolderDirty() {
        return this.contains(FIELD_LOGICHOLDER);
    }

    @JsonIgnore
    public String getMajorPSDERId() {
        Object objValue = this.get(FIELD_MAJORPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsderid")
    public void setMajorPSDERId(String majorPSDERId) {
        this.set(FIELD_MAJORPSDERID, majorPSDERId);
    }

    @JsonIgnore
    public boolean isMajorPSDERIdDirty() {
        return this.contains(FIELD_MAJORPSDERID);
    }

    @JsonIgnore
    public String getMajorPSDERName() {
        Object objValue = this.get(FIELD_MAJORPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="majorpsdername")
    public void setMajorPSDERName(String majorPSDERName) {
        this.set(FIELD_MAJORPSDERNAME, majorPSDERName);
    }

    @JsonIgnore
    public boolean isMajorPSDERNameDirty() {
        return this.contains(FIELD_MAJORPSDERNAME);
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
    public String getMinorPSDERId() {
        Object objValue = this.get(FIELD_MINORPSDERID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsderid")
    public void setMinorPSDERId(String minorPSDERId) {
        this.set(FIELD_MINORPSDERID, minorPSDERId);
    }

    @JsonIgnore
    public boolean isMinorPSDERIdDirty() {
        return this.contains(FIELD_MINORPSDERID);
    }

    @JsonIgnore
    public String getMinorPSDERName() {
        Object objValue = this.get(FIELD_MINORPSDERNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minorpsdername")
    public void setMinorPSDERName(String minorPSDERName) {
        this.set(FIELD_MINORPSDERNAME, minorPSDERName);
    }

    @JsonIgnore
    public boolean isMinorPSDERNameDirty() {
        return this.contains(FIELD_MINORPSDERNAME);
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
    public Integer getPrepareLast() {
        Object objValue = this.get(FIELD_PREPARELAST);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="preparelast")
    public void setPrepareLast(Integer prepareLast) {
        this.set(FIELD_PREPARELAST, prepareLast);
    }

    @JsonIgnore
    public boolean isPrepareLastDirty() {
        return this.contains(FIELD_PREPARELAST);
    }

    @JsonIgnore
    public String getPropertyMap() {
        Object objValue = this.get(FIELD_PROPERTYMAP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="propertymap")
    public void setPropertyMap(String propertyMap) {
        this.set(FIELD_PROPERTYMAP, propertyMap);
    }

    @JsonIgnore
    public boolean isPropertyMapDirty() {
        return this.contains(FIELD_PROPERTYMAP);
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
    public String getPSDEActionLogicId() {
        Object objValue = this.get(FIELD_PSDEACTIONLOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionlogicid")
    public void setPSDEActionLogicId(String pSDEActionLogicId) {
        this.set(FIELD_PSDEACTIONLOGICID, pSDEActionLogicId);
    }

    @JsonIgnore
    public boolean isPSDEActionLogicIdDirty() {
        return this.contains(FIELD_PSDEACTIONLOGICID);
    }

    @JsonIgnore
    public String getPSDEActionLogicName() {
        Object objValue = this.get(FIELD_PSDEACTIONLOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeactionlogicname")
    public void setPSDEActionLogicName(String pSDEActionLogicName) {
        this.set(FIELD_PSDEACTIONLOGICNAME, pSDEActionLogicName);
    }

    @JsonIgnore
    public boolean isPSDEActionLogicNameDirty() {
        return this.contains(FIELD_PSDEACTIONLOGICNAME);
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
    public String getPSDEDataSyncId() {
        Object objValue = this.get(FIELD_PSDEDATASYNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasyncid")
    public void setPSDEDataSyncId(String pSDEDataSyncId) {
        this.set(FIELD_PSDEDATASYNCID, pSDEDataSyncId);
    }

    @JsonIgnore
    public boolean isPSDEDataSyncIdDirty() {
        return this.contains(FIELD_PSDEDATASYNCID);
    }

    @JsonIgnore
    public String getPSDEDataSyncName() {
        Object objValue = this.get(FIELD_PSDEDATASYNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasyncname")
    public void setPSDEDataSyncName(String pSDEDataSyncName) {
        this.set(FIELD_PSDEDATASYNCNAME, pSDEDataSyncName);
    }

    @JsonIgnore
    public boolean isPSDEDataSyncNameDirty() {
        return this.contains(FIELD_PSDEDATASYNCNAME);
    }

    @JsonIgnore
    public String getPSDEFId() {
        Object objValue = this.get(FIELD_PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefid")
    public void setPSDEFId(String pSDEFId) {
        this.set(FIELD_PSDEFID, pSDEFId);
    }

    @JsonIgnore
    public boolean isPSDEFIdDirty() {
        return this.contains(FIELD_PSDEFID);
    }

    @JsonIgnore
    public String getPSDEFName() {
        Object objValue = this.get(FIELD_PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefname")
    public void setPSDEFName(String pSDEFName) {
        this.set(FIELD_PSDEFNAME, pSDEFName);
    }

    @JsonIgnore
    public boolean isPSDEFNameDirty() {
        return this.contains(FIELD_PSDEFNAME);
    }

    @JsonIgnore
    public String getPSDEFValueRuleId() {
        Object objValue = this.get(FIELD_PSDEFVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvalueruleid")
    public void setPSDEFValueRuleId(String pSDEFValueRuleId) {
        this.set(FIELD_PSDEFVALUERULEID, pSDEFValueRuleId);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleIdDirty() {
        return this.contains(FIELD_PSDEFVALUERULEID);
    }

    @JsonIgnore
    public String getPSDEFValueRuleName() {
        Object objValue = this.get(FIELD_PSDEFVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefvaluerulename")
    public void setPSDEFValueRuleName(String pSDEFValueRuleName) {
        this.set(FIELD_PSDEFVALUERULENAME, pSDEFValueRuleName);
    }

    @JsonIgnore
    public boolean isPSDEFValueRuleNameDirty() {
        return this.contains(FIELD_PSDEFVALUERULENAME);
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
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
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
    public String getPSDENotifyId() {
        Object objValue = this.get(FIELD_PSDENOTIFYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyid")
    public void setPSDENotifyId(String pSDENotifyId) {
        this.set(FIELD_PSDENOTIFYID, pSDENotifyId);
    }

    @JsonIgnore
    public boolean isPSDENotifyIdDirty() {
        return this.contains(FIELD_PSDENOTIFYID);
    }

    @JsonIgnore
    public String getPSDENotifyName() {
        Object objValue = this.get(FIELD_PSDENOTIFYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyname")
    public void setPSDENotifyName(String pSDENotifyName) {
        this.set(FIELD_PSDENOTIFYNAME, pSDENotifyName);
    }

    @JsonIgnore
    public boolean isPSDENotifyNameDirty() {
        return this.contains(FIELD_PSDENOTIFYNAME);
    }

    @JsonIgnore
    public String getPSSysDELogicNodeId() {
        Object objValue = this.get(FIELD_PSSYSDELOGICNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdelogicnodeid")
    public void setPSSysDELogicNodeId(String pSSysDELogicNodeId) {
        this.set(FIELD_PSSYSDELOGICNODEID, pSSysDELogicNodeId);
    }

    @JsonIgnore
    public boolean isPSSysDELogicNodeIdDirty() {
        return this.contains(FIELD_PSSYSDELOGICNODEID);
    }

    @JsonIgnore
    public String getPSSysDELogicNodeName() {
        Object objValue = this.get(FIELD_PSSYSDELOGICNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdelogicnodename")
    public void setPSSysDELogicNodeName(String pSSysDELogicNodeName) {
        this.set(FIELD_PSSYSDELOGICNODENAME, pSSysDELogicNodeName);
    }

    @JsonIgnore
    public boolean isPSSysDELogicNodeNameDirty() {
        return this.contains(FIELD_PSSYSDELOGICNODENAME);
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
    public String getPSSysSequenceId() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequenceid")
    public void setPSSysSequenceId(String pSSysSequenceId) {
        this.set(FIELD_PSSYSSEQUENCEID, pSSysSequenceId);
    }

    @JsonIgnore
    public boolean isPSSysSequenceIdDirty() {
        return this.contains(FIELD_PSSYSSEQUENCEID);
    }

    @JsonIgnore
    public String getPSSysSequenceName() {
        Object objValue = this.get(FIELD_PSSYSSEQUENCENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssequencename")
    public void setPSSysSequenceName(String pSSysSequenceName) {
        this.set(FIELD_PSSYSSEQUENCENAME, pSSysSequenceName);
    }

    @JsonIgnore
    public boolean isPSSysSequenceNameDirty() {
        return this.contains(FIELD_PSSYSSEQUENCENAME);
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
    public String getPSSysTranslatorId() {
        Object objValue = this.get(FIELD_PSSYSTRANSLATORID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystranslatorid")
    public void setPSSysTranslatorId(String pSSysTranslatorId) {
        this.set(FIELD_PSSYSTRANSLATORID, pSSysTranslatorId);
    }

    @JsonIgnore
    public boolean isPSSysTranslatorIdDirty() {
        return this.contains(FIELD_PSSYSTRANSLATORID);
    }

    @JsonIgnore
    public String getPSSysTranslatorName() {
        Object objValue = this.get(FIELD_PSSYSTRANSLATORNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystranslatorname")
    public void setPSSysTranslatorName(String pSSysTranslatorName) {
        this.set(FIELD_PSSYSTRANSLATORNAME, pSSysTranslatorName);
    }

    @JsonIgnore
    public boolean isPSSysTranslatorNameDirty() {
        return this.contains(FIELD_PSSYSTRANSLATORNAME);
    }

    @JsonIgnore
    public String getPSSysValueRuleId() {
        Object objValue = this.get(FIELD_PSSYSVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvalueruleid")
    public void setPSSysValueRuleId(String pSSysValueRuleId) {
        this.set(FIELD_PSSYSVALUERULEID, pSSysValueRuleId);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleIdDirty() {
        return this.contains(FIELD_PSSYSVALUERULEID);
    }

    @JsonIgnore
    public String getPSSysValueRuleName() {
        Object objValue = this.get(FIELD_PSSYSVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysvaluerulename")
    public void setPSSysValueRuleName(String pSSysValueRuleName) {
        this.set(FIELD_PSSYSVALUERULENAME, pSSysValueRuleName);
    }

    @JsonIgnore
    public boolean isPSSysValueRuleNameDirty() {
        return this.contains(FIELD_PSSYSVALUERULENAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEActionLogicId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEActionLogicId(strValue);
    }
}

