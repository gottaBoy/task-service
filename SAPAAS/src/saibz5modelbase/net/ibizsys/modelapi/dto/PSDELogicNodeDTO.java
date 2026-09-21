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
import net.ibizsys.modelapi.dto.PSDELNParamDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDELogicNodeDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMDSTPARAM = "customdstparam";
    public static final String FIELD_CUSTOMSRCPARAM = "customsrcparam";
    public static final String FIELD_DEBUGMODE = "debugmode";
    public static final String FIELD_DSTINDEX = "dstindex";
    public static final String FIELD_DSTPARAMACTION = "dstparamaction";
    public static final String FIELD_DSTPSDEACTIONID = "dstpsdeactionid";
    public static final String FIELD_DSTPSDEACTIONNAME = "dstpsdeactionname";
    public static final String FIELD_DSTPSDEDATAEXPID = "dstpsdedataexpid";
    public static final String FIELD_DSTPSDEDATAEXPNAME = "dstpsdedataexpname";
    public static final String FIELD_DSTPSDEDATAIMPID = "dstpsdedataimpid";
    public static final String FIELD_DSTPSDEDATAIMPNAME = "dstpsdedataimpname";
    public static final String FIELD_DSTPSDEDATAQUERYID = "dstpsdedataqueryid";
    public static final String FIELD_DSTPSDEDATAQUERYNAME = "dstpsdedataqueryname";
    public static final String FIELD_DSTPSDEDATASETID = "dstpsdedatasetid";
    public static final String FIELD_DSTPSDEDATASETNAME = "dstpsdedatasetname";
    public static final String FIELD_DSTPSDEDATASYNCID = "dstpsdedatasyncid";
    public static final String FIELD_DSTPSDEDATASYNCNAME = "dstpsdedatasyncname";
    public static final String FIELD_DSTPSDEDTSQUEUEID = "dstpsdedtsqueueid";
    public static final String FIELD_DSTPSDEDTSQUEUENAME = "dstpsdedtsqueuename";
    public static final String FIELD_DSTPSDEFVALUERULEID = "dstpsdefvalueruleid";
    public static final String FIELD_DSTPSDEFVALUERULENAME = "dstpsdefvaluerulename";
    public static final String FIELD_DSTPSDEID = "dstpsdeid";
    public static final String FIELD_DSTPSDELOGICID = "dstpsdelogicid";
    public static final String FIELD_DSTPSDELOGICNAME = "dstpsdelogicname";
    public static final String FIELD_DSTPSDEMAPID = "dstpsdemapid";
    public static final String FIELD_DSTPSDEMAPNAME = "dstpsdemapname";
    public static final String FIELD_DSTPSDENAME = "dstpsdename";
    public static final String FIELD_DSTPSDENOTIFYID = "dstpsdenotifyid";
    public static final String FIELD_DSTPSDENOTIFYNAME = "dstpsdenotifyname";
    public static final String FIELD_DSTPSDEPRINTID = "dstpsdeprintid";
    public static final String FIELD_DSTPSDEPRINTNAME = "dstpsdeprintname";
    public static final String FIELD_DSTPSDEREPORTID = "dstpsdereportid";
    public static final String FIELD_DSTPSDEREPORTNAME = "dstpsdereportname";
    public static final String FIELD_DSTPSDEVRGROUPID = "dstpsdevrgroupid";
    public static final String FIELD_DSTPSDEVRGROUPNAME = "dstpsdevrgroupname";
    public static final String FIELD_DSTPSDLPARAMID = "dstpsdlparamid";
    public static final String FIELD_DSTPSDLPARAMNAME = "dstpsdlparamname";
    public static final String FIELD_DSTSORTDIR = "dstsortdir";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_ISPSDLPARAMID = "ispsdlparamid";
    public static final String FIELD_ISPSDLPARAMNAME = "ispsdlparamname";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_LOGICNODESUBTYPE = "logicnodesubtype";
    public static final String FIELD_LOGICNODETYPE = "logicnodetype";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MSGPSLANRESID = "msgpslanresid";
    public static final String FIELD_MSGPSLANRESNAME = "msgpslanresname";
    public static final String FIELD_NODEPARAMS = "nodeparams";
    public static final String FIELD_OSPSDLPARAMID = "ospsdlparamid";
    public static final String FIELD_OSPSDLPARAMNAME = "ospsdlparamname";
    public static final String FIELD_PARALLELOUTPUT = "paralleloutput";
    public static final String FIELD_PARAM1 = "param1";
    public static final String FIELD_PARAM10 = "param10";
    public static final String FIELD_PARAM11 = "param11";
    public static final String FIELD_PARAM12 = "param12";
    public static final String FIELD_PARAM13 = "param13";
    public static final String FIELD_PARAM14 = "param14";
    public static final String FIELD_PARAM2 = "param2";
    public static final String FIELD_PARAM3 = "param3";
    public static final String FIELD_PARAM4 = "param4";
    public static final String FIELD_PARAM5 = "param5";
    public static final String FIELD_PARAM6 = "param6";
    public static final String FIELD_PARAM7 = "param7";
    public static final String FIELD_PARAM8 = "param8";
    public static final String FIELD_PARAM9 = "param9";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDELOGICNODEID = "psdelogicnodeid";
    public static final String FIELD_PSDELOGICNODENAME = "psdelogicnodename";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDEUIACTIONID = "psdeuiactionid";
    public static final String FIELD_PSDEUIACTIONNAME = "psdeuiactionname";
    public static final String FIELD_PSSUBSYSSADETAILID = "pssubsyssadetailid";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "pssubsyssadetailname";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSBACKSERVICEID = "pssysbackserviceid";
    public static final String FIELD_PSSYSBACKSERVICENAME = "pssysbackservicename";
    public static final String FIELD_PSSYSBDSCHEMEID = "pssysbdschemeid";
    public static final String FIELD_PSSYSBDSCHEMENAME = "pssysbdschemename";
    public static final String FIELD_PSSYSBDTABLEID = "pssysbdtableid";
    public static final String FIELD_PSSYSBDTABLENAME = "pssysbdtablename";
    public static final String FIELD_PSSYSBIREPORTID = "pssysbireportid";
    public static final String FIELD_PSSYSBIREPORTNAME = "pssysbireportname";
    public static final String FIELD_PSSYSBISCHEMEID = "pssysbischemeid";
    public static final String FIELD_PSSYSBISCHEMENAME = "pssysbischemename";
    public static final String FIELD_PSSYSDATASYNCAGENTID = "pssysdatasyncagentid";
    public static final String FIELD_PSSYSDATASYNCAGENTNAME = "pssysdatasyncagentname";
    public static final String FIELD_PSSYSDBSCHEMEID = "pssysdbschemeid";
    public static final String FIELD_PSSYSDBSCHEMENAME = "pssysdbschemename";
    public static final String FIELD_PSSYSDBTABLEID = "pssysdbtableid";
    public static final String FIELD_PSSYSDBTABLENAME = "pssysdbtablename";
    public static final String FIELD_PSSYSDELOGICNODEID = "pssysdelogicnodeid";
    public static final String FIELD_PSSYSDELOGICNODENAME = "pssysdelogicnodename";
    public static final String FIELD_PSSYSEAIELEMENTID = "pssyseaielementid";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "pssyseaielementname";
    public static final String FIELD_PSSYSEAISCHEMEID = "pssyseaischemeid";
    public static final String FIELD_PSSYSEAISCHEMENAME = "pssyseaischemename";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    public static final String FIELD_PSSYSSEARCHDOCID = "pssyssearchdocid";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "pssyssearchdocname";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "pssyssearchschemeid";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "pssyssearchschemename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSSQLCMDID = "pssyssqlcmdid";
    public static final String FIELD_PSSYSSQLCMDNAME = "pssyssqlcmdname";
    public static final String FIELD_PSSYSUNISTATEID = "pssysunistateid";
    public static final String FIELD_PSSYSUNISTATENAME = "pssysunistatename";
    public static final String FIELD_PSSYSUTILDEID = "pssysutildeid";
    public static final String FIELD_PSSYSUTILDENAME = "pssysutildename";
    public static final String FIELD_PSWFDEID = "pswfdeid";
    public static final String FIELD_PSWFDENAME = "pswfdename";
    public static final String FIELD_PSWORKFLOWID = "psworkflowid";
    public static final String FIELD_PSWORKFLOWNAME = "psworkflowname";
    public static final String FIELD_RETPSDLPARAMID = "retpsdlparamid";
    public static final String FIELD_RETPSDLPARAMNAME = "retpsdlparamname";
    public static final String FIELD_SHAPEPARAMS = "shapeparams";
    public static final String FIELD_SRCINDEX = "srcindex";
    public static final String FIELD_SRCPSDLPARAMID = "srcpsdlparamid";
    public static final String FIELD_SRCPSDLPARAMNAME = "srcpsdlparamname";
    public static final String FIELD_SRCSIZE = "srcsize";
    public static final String FIELD_THREADRUNMODE = "threadrunmode";
    public static final String FIELD_THREADRUNTIMER = "threadruntimer";
    public static final String FIELD_TOPPOS = "toppos";
    public static final String FIELD_TSMODE = "tsmode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDELNParamDTO> psdelnparams;

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
    public String getCustomDSTParam() {
        Object objValue = this.get(FIELD_CUSTOMDSTPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customdstparam")
    public void setCustomDSTParam(String customDSTParam) {
        this.set(FIELD_CUSTOMDSTPARAM, customDSTParam);
    }

    @JsonIgnore
    public boolean isCustomDSTParamDirty() {
        return this.contains(FIELD_CUSTOMDSTPARAM);
    }

    @JsonIgnore
    public String getCustomSrcParam() {
        Object objValue = this.get(FIELD_CUSTOMSRCPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customsrcparam")
    public void setCustomSrcParam(String customSrcParam) {
        this.set(FIELD_CUSTOMSRCPARAM, customSrcParam);
    }

    @JsonIgnore
    public boolean isCustomSrcParamDirty() {
        return this.contains(FIELD_CUSTOMSRCPARAM);
    }

    @JsonIgnore
    public Integer getDebugMode() {
        Object objValue = this.get(FIELD_DEBUGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="debugmode")
    public void setDebugMode(Integer debugMode) {
        this.set(FIELD_DEBUGMODE, debugMode);
    }

    @JsonIgnore
    public boolean isDebugModeDirty() {
        return this.contains(FIELD_DEBUGMODE);
    }

    @JsonIgnore
    public Integer getDstIndex() {
        Object objValue = this.get(FIELD_DSTINDEX);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dstindex")
    public void setDstIndex(Integer dstIndex) {
        this.set(FIELD_DSTINDEX, dstIndex);
    }

    @JsonIgnore
    public boolean isDstIndexDirty() {
        return this.contains(FIELD_DSTINDEX);
    }

    @JsonIgnore
    public String getDstParamAction() {
        Object objValue = this.get(FIELD_DSTPARAMACTION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstparamaction")
    public void setDstParamAction(String dstParamAction) {
        this.set(FIELD_DSTPARAMACTION, dstParamAction);
    }

    @JsonIgnore
    public boolean isDstParamActionDirty() {
        return this.contains(FIELD_DSTPARAMACTION);
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
    public String getDstPSDEDataExpId() {
        Object objValue = this.get(FIELD_DSTPSDEDATAEXPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataexpid")
    public void setDstPSDEDataExpId(String dstPSDEDataExpId) {
        this.set(FIELD_DSTPSDEDATAEXPID, dstPSDEDataExpId);
    }

    @JsonIgnore
    public boolean isDstPSDEDataExpIdDirty() {
        return this.contains(FIELD_DSTPSDEDATAEXPID);
    }

    @JsonIgnore
    public String getDstPSDEDataExpName() {
        Object objValue = this.get(FIELD_DSTPSDEDATAEXPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataexpname")
    public void setDstPSDEDataExpName(String dstPSDEDataExpName) {
        this.set(FIELD_DSTPSDEDATAEXPNAME, dstPSDEDataExpName);
    }

    @JsonIgnore
    public boolean isDstPSDEDataExpNameDirty() {
        return this.contains(FIELD_DSTPSDEDATAEXPNAME);
    }

    @JsonIgnore
    public String getDstPSDEDataImpId() {
        Object objValue = this.get(FIELD_DSTPSDEDATAIMPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataimpid")
    public void setDstPSDEDataImpId(String dstPSDEDataImpId) {
        this.set(FIELD_DSTPSDEDATAIMPID, dstPSDEDataImpId);
    }

    @JsonIgnore
    public boolean isDstPSDEDataImpIdDirty() {
        return this.contains(FIELD_DSTPSDEDATAIMPID);
    }

    @JsonIgnore
    public String getDstPSDEDataImpName() {
        Object objValue = this.get(FIELD_DSTPSDEDATAIMPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedataimpname")
    public void setDstPSDEDataImpName(String dstPSDEDataImpName) {
        this.set(FIELD_DSTPSDEDATAIMPNAME, dstPSDEDataImpName);
    }

    @JsonIgnore
    public boolean isDstPSDEDataImpNameDirty() {
        return this.contains(FIELD_DSTPSDEDATAIMPNAME);
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
    public String getDstPSDEDataSyncId() {
        Object objValue = this.get(FIELD_DSTPSDEDATASYNCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedatasyncid")
    public void setDstPSDEDataSyncId(String dstPSDEDataSyncId) {
        this.set(FIELD_DSTPSDEDATASYNCID, dstPSDEDataSyncId);
    }

    @JsonIgnore
    public boolean isDstPSDEDataSyncIdDirty() {
        return this.contains(FIELD_DSTPSDEDATASYNCID);
    }

    @JsonIgnore
    public String getDstPSDEDataSyncName() {
        Object objValue = this.get(FIELD_DSTPSDEDATASYNCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedatasyncname")
    public void setDstPSDEDataSyncName(String dstPSDEDataSyncName) {
        this.set(FIELD_DSTPSDEDATASYNCNAME, dstPSDEDataSyncName);
    }

    @JsonIgnore
    public boolean isDstPSDEDataSyncNameDirty() {
        return this.contains(FIELD_DSTPSDEDATASYNCNAME);
    }

    @JsonIgnore
    public String getDstPSDEDTSQueueId() {
        Object objValue = this.get(FIELD_DSTPSDEDTSQUEUEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedtsqueueid")
    public void setDstPSDEDTSQueueId(String dstPSDEDTSQueueId) {
        this.set(FIELD_DSTPSDEDTSQUEUEID, dstPSDEDTSQueueId);
    }

    @JsonIgnore
    public boolean isDstPSDEDTSQueueIdDirty() {
        return this.contains(FIELD_DSTPSDEDTSQUEUEID);
    }

    @JsonIgnore
    public String getDstPSDEDTSQueueName() {
        Object objValue = this.get(FIELD_DSTPSDEDTSQUEUENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdedtsqueuename")
    public void setDstPSDEDTSQueueName(String dstPSDEDTSQueueName) {
        this.set(FIELD_DSTPSDEDTSQUEUENAME, dstPSDEDTSQueueName);
    }

    @JsonIgnore
    public boolean isDstPSDEDTSQueueNameDirty() {
        return this.contains(FIELD_DSTPSDEDTSQUEUENAME);
    }

    @JsonIgnore
    public String getDstPSDEFValueRuleId() {
        Object objValue = this.get(FIELD_DSTPSDEFVALUERULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdefvalueruleid")
    public void setDstPSDEFValueRuleId(String dstPSDEFValueRuleId) {
        this.set(FIELD_DSTPSDEFVALUERULEID, dstPSDEFValueRuleId);
    }

    @JsonIgnore
    public boolean isDstPSDEFValueRuleIdDirty() {
        return this.contains(FIELD_DSTPSDEFVALUERULEID);
    }

    @JsonIgnore
    public String getDstPSDEFValueRuleName() {
        Object objValue = this.get(FIELD_DSTPSDEFVALUERULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdefvaluerulename")
    public void setDstPSDEFValueRuleName(String dstPSDEFValueRuleName) {
        this.set(FIELD_DSTPSDEFVALUERULENAME, dstPSDEFValueRuleName);
    }

    @JsonIgnore
    public boolean isDstPSDEFValueRuleNameDirty() {
        return this.contains(FIELD_DSTPSDEFVALUERULENAME);
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
    public String getDstPSDELogicId() {
        Object objValue = this.get(FIELD_DSTPSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdelogicid")
    public void setDstPSDELogicId(String dstPSDELogicId) {
        this.set(FIELD_DSTPSDELOGICID, dstPSDELogicId);
    }

    @JsonIgnore
    public boolean isDstPSDELogicIdDirty() {
        return this.contains(FIELD_DSTPSDELOGICID);
    }

    @JsonIgnore
    public String getDstPSDELogicName() {
        Object objValue = this.get(FIELD_DSTPSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdelogicname")
    public void setDstPSDELogicName(String dstPSDELogicName) {
        this.set(FIELD_DSTPSDELOGICNAME, dstPSDELogicName);
    }

    @JsonIgnore
    public boolean isDstPSDELogicNameDirty() {
        return this.contains(FIELD_DSTPSDELOGICNAME);
    }

    @JsonIgnore
    public String getDstPSDEMapId() {
        Object objValue = this.get(FIELD_DSTPSDEMAPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdemapid")
    public void setDstPSDEMapId(String dstPSDEMapId) {
        this.set(FIELD_DSTPSDEMAPID, dstPSDEMapId);
    }

    @JsonIgnore
    public boolean isDstPSDEMapIdDirty() {
        return this.contains(FIELD_DSTPSDEMAPID);
    }

    @JsonIgnore
    public String getDstPSDEMapName() {
        Object objValue = this.get(FIELD_DSTPSDEMAPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdemapname")
    public void setDstPSDEMapName(String dstPSDEMapName) {
        this.set(FIELD_DSTPSDEMAPNAME, dstPSDEMapName);
    }

    @JsonIgnore
    public boolean isDstPSDEMapNameDirty() {
        return this.contains(FIELD_DSTPSDEMAPNAME);
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
    public String getDstPSDENotifyId() {
        Object objValue = this.get(FIELD_DSTPSDENOTIFYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdenotifyid")
    public void setDstPSDENotifyId(String dstPSDENotifyId) {
        this.set(FIELD_DSTPSDENOTIFYID, dstPSDENotifyId);
    }

    @JsonIgnore
    public boolean isDstPSDENotifyIdDirty() {
        return this.contains(FIELD_DSTPSDENOTIFYID);
    }

    @JsonIgnore
    public String getDstPSDENotifyName() {
        Object objValue = this.get(FIELD_DSTPSDENOTIFYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdenotifyname")
    public void setDstPSDENotifyName(String dstPSDENotifyName) {
        this.set(FIELD_DSTPSDENOTIFYNAME, dstPSDENotifyName);
    }

    @JsonIgnore
    public boolean isDstPSDENotifyNameDirty() {
        return this.contains(FIELD_DSTPSDENOTIFYNAME);
    }

    @JsonIgnore
    public String getDstPSDEPrintId() {
        Object objValue = this.get(FIELD_DSTPSDEPRINTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeprintid")
    public void setDstPSDEPrintId(String dstPSDEPrintId) {
        this.set(FIELD_DSTPSDEPRINTID, dstPSDEPrintId);
    }

    @JsonIgnore
    public boolean isDstPSDEPrintIdDirty() {
        return this.contains(FIELD_DSTPSDEPRINTID);
    }

    @JsonIgnore
    public String getDstPSDEPrintName() {
        Object objValue = this.get(FIELD_DSTPSDEPRINTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdeprintname")
    public void setDstPSDEPrintName(String dstPSDEPrintName) {
        this.set(FIELD_DSTPSDEPRINTNAME, dstPSDEPrintName);
    }

    @JsonIgnore
    public boolean isDstPSDEPrintNameDirty() {
        return this.contains(FIELD_DSTPSDEPRINTNAME);
    }

    @JsonIgnore
    public String getDstPSDEReportId() {
        Object objValue = this.get(FIELD_DSTPSDEREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdereportid")
    public void setDstPSDEReportId(String dstPSDEReportId) {
        this.set(FIELD_DSTPSDEREPORTID, dstPSDEReportId);
    }

    @JsonIgnore
    public boolean isDstPSDEReportIdDirty() {
        return this.contains(FIELD_DSTPSDEREPORTID);
    }

    @JsonIgnore
    public String getDstPSDEReportName() {
        Object objValue = this.get(FIELD_DSTPSDEREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdereportname")
    public void setDstPSDEReportName(String dstPSDEReportName) {
        this.set(FIELD_DSTPSDEREPORTNAME, dstPSDEReportName);
    }

    @JsonIgnore
    public boolean isDstPSDEReportNameDirty() {
        return this.contains(FIELD_DSTPSDEREPORTNAME);
    }

    @JsonIgnore
    public String getDstPSDEVRGroupId() {
        Object objValue = this.get(FIELD_DSTPSDEVRGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdevrgroupid")
    public void setDstPSDEVRGroupId(String dstPSDEVRGroupId) {
        this.set(FIELD_DSTPSDEVRGROUPID, dstPSDEVRGroupId);
    }

    @JsonIgnore
    public boolean isDstPSDEVRGroupIdDirty() {
        return this.contains(FIELD_DSTPSDEVRGROUPID);
    }

    @JsonIgnore
    public String getDstPSDEVRGroupName() {
        Object objValue = this.get(FIELD_DSTPSDEVRGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdevrgroupname")
    public void setDstPSDEVRGroupName(String dstPSDEVRGroupName) {
        this.set(FIELD_DSTPSDEVRGROUPNAME, dstPSDEVRGroupName);
    }

    @JsonIgnore
    public boolean isDstPSDEVRGroupNameDirty() {
        return this.contains(FIELD_DSTPSDEVRGROUPNAME);
    }

    @JsonIgnore
    public String getDstPSDLParamId() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamid")
    public void setDstPSDLParamId(String dstPSDLParamId) {
        this.set(FIELD_DSTPSDLPARAMID, dstPSDLParamId);
    }

    @JsonIgnore
    public boolean isDstPSDLParamIdDirty() {
        return this.contains(FIELD_DSTPSDLPARAMID);
    }

    @JsonIgnore
    public String getDstPSDLParamName() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamname")
    public void setDstPSDLParamName(String dstPSDLParamName) {
        this.set(FIELD_DSTPSDLPARAMNAME, dstPSDLParamName);
    }

    @JsonIgnore
    public boolean isDstPSDLParamNameDirty() {
        return this.contains(FIELD_DSTPSDLPARAMNAME);
    }

    @JsonIgnore
    public String getDstSortDir() {
        Object objValue = this.get(FIELD_DSTSORTDIR);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstsortdir")
    public void setDstSortDir(String dstSortDir) {
        this.set(FIELD_DSTSORTDIR, dstSortDir);
    }

    @JsonIgnore
    public boolean isDstSortDirDirty() {
        return this.contains(FIELD_DSTSORTDIR);
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
    public String getISPSDLParamId() {
        Object objValue = this.get(FIELD_ISPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ispsdlparamid")
    public void setISPSDLParamId(String iSPSDLParamId) {
        this.set(FIELD_ISPSDLPARAMID, iSPSDLParamId);
    }

    @JsonIgnore
    public boolean isISPSDLParamIdDirty() {
        return this.contains(FIELD_ISPSDLPARAMID);
    }

    @JsonIgnore
    public String getISPSDLParamName() {
        Object objValue = this.get(FIELD_ISPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ispsdlparamname")
    public void setISPSDLParamName(String iSPSDLParamName) {
        this.set(FIELD_ISPSDLPARAMNAME, iSPSDLParamName);
    }

    @JsonIgnore
    public boolean isISPSDLParamNameDirty() {
        return this.contains(FIELD_ISPSDLPARAMNAME);
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
    public String getLogicNodeSubType() {
        Object objValue = this.get(FIELD_LOGICNODESUBTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicnodesubtype")
    public void setLogicNodeSubType(String logicNodeSubType) {
        this.set(FIELD_LOGICNODESUBTYPE, logicNodeSubType);
    }

    @JsonIgnore
    public boolean isLogicNodeSubTypeDirty() {
        return this.contains(FIELD_LOGICNODESUBTYPE);
    }

    @JsonIgnore
    public String getLogicNodeType() {
        Object objValue = this.get(FIELD_LOGICNODETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicnodetype")
    public void setLogicNodeType(String logicNodeType) {
        this.set(FIELD_LOGICNODETYPE, logicNodeType);
    }

    @JsonIgnore
    public boolean isLogicNodeTypeDirty() {
        return this.contains(FIELD_LOGICNODETYPE);
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
    public String getMsgPSLanResId() {
        Object objValue = this.get(FIELD_MSGPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgpslanresid")
    public void setMsgPSLanResId(String msgPSLanResId) {
        this.set(FIELD_MSGPSLANRESID, msgPSLanResId);
    }

    @JsonIgnore
    public boolean isMsgPSLanResIdDirty() {
        return this.contains(FIELD_MSGPSLANRESID);
    }

    @JsonIgnore
    public String getMsgPSLanResName() {
        Object objValue = this.get(FIELD_MSGPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgpslanresname")
    public void setMsgPSLanResName(String msgPSLanResName) {
        this.set(FIELD_MSGPSLANRESNAME, msgPSLanResName);
    }

    @JsonIgnore
    public boolean isMsgPSLanResNameDirty() {
        return this.contains(FIELD_MSGPSLANRESNAME);
    }

    @JsonIgnore
    public String getNodeParams() {
        Object objValue = this.get(FIELD_NODEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodeparams")
    public void setNodeParams(String nodeParams) {
        this.set(FIELD_NODEPARAMS, nodeParams);
    }

    @JsonIgnore
    public boolean isNodeParamsDirty() {
        return this.contains(FIELD_NODEPARAMS);
    }

    @JsonIgnore
    public String getOSPSDLParamId() {
        Object objValue = this.get(FIELD_OSPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ospsdlparamid")
    public void setOSPSDLParamId(String oSPSDLParamId) {
        this.set(FIELD_OSPSDLPARAMID, oSPSDLParamId);
    }

    @JsonIgnore
    public boolean isOSPSDLParamIdDirty() {
        return this.contains(FIELD_OSPSDLPARAMID);
    }

    @JsonIgnore
    public String getOSPSDLParamName() {
        Object objValue = this.get(FIELD_OSPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ospsdlparamname")
    public void setOSPSDLParamName(String oSPSDLParamName) {
        this.set(FIELD_OSPSDLPARAMNAME, oSPSDLParamName);
    }

    @JsonIgnore
    public boolean isOSPSDLParamNameDirty() {
        return this.contains(FIELD_OSPSDLPARAMNAME);
    }

    @JsonIgnore
    public Integer getParallelOutput() {
        Object objValue = this.get(FIELD_PARALLELOUTPUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="paralleloutput")
    public void setParallelOutput(Integer parallelOutput) {
        this.set(FIELD_PARALLELOUTPUT, parallelOutput);
    }

    @JsonIgnore
    public boolean isParallelOutputDirty() {
        return this.contains(FIELD_PARALLELOUTPUT);
    }

    @JsonIgnore
    public String getParam1() {
        Object objValue = this.get(FIELD_PARAM1);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param1")
    public void setParam1(String param1) {
        this.set(FIELD_PARAM1, param1);
    }

    @JsonIgnore
    public boolean isParam1Dirty() {
        return this.contains(FIELD_PARAM1);
    }

    @JsonIgnore
    public Integer getParam10() {
        Object objValue = this.get(FIELD_PARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param10")
    public void setParam10(Integer param10) {
        this.set(FIELD_PARAM10, param10);
    }

    @JsonIgnore
    public boolean isParam10Dirty() {
        return this.contains(FIELD_PARAM10);
    }

    @JsonIgnore
    public String getParam11() {
        Object objValue = this.get(FIELD_PARAM11);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param11")
    public void setParam11(String param11) {
        this.set(FIELD_PARAM11, param11);
    }

    @JsonIgnore
    public boolean isParam11Dirty() {
        return this.contains(FIELD_PARAM11);
    }

    @JsonIgnore
    public String getParam12() {
        Object objValue = this.get(FIELD_PARAM12);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param12")
    public void setParam12(String param12) {
        this.set(FIELD_PARAM12, param12);
    }

    @JsonIgnore
    public boolean isParam12Dirty() {
        return this.contains(FIELD_PARAM12);
    }

    @JsonIgnore
    public String getParam13() {
        Object objValue = this.get(FIELD_PARAM13);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param13")
    public void setParam13(String param13) {
        this.set(FIELD_PARAM13, param13);
    }

    @JsonIgnore
    public boolean isParam13Dirty() {
        return this.contains(FIELD_PARAM13);
    }

    @JsonIgnore
    public String getParam14() {
        Object objValue = this.get(FIELD_PARAM14);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param14")
    public void setParam14(String param14) {
        this.set(FIELD_PARAM14, param14);
    }

    @JsonIgnore
    public boolean isParam14Dirty() {
        return this.contains(FIELD_PARAM14);
    }

    @JsonIgnore
    public String getParam2() {
        Object objValue = this.get(FIELD_PARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param2")
    public void setParam2(String param2) {
        this.set(FIELD_PARAM2, param2);
    }

    @JsonIgnore
    public boolean isParam2Dirty() {
        return this.contains(FIELD_PARAM2);
    }

    @JsonIgnore
    public String getParam3() {
        Object objValue = this.get(FIELD_PARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param3")
    public void setParam3(String param3) {
        this.set(FIELD_PARAM3, param3);
    }

    @JsonIgnore
    public boolean isParam3Dirty() {
        return this.contains(FIELD_PARAM3);
    }

    @JsonIgnore
    public String getParam4() {
        Object objValue = this.get(FIELD_PARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param4")
    public void setParam4(String param4) {
        this.set(FIELD_PARAM4, param4);
    }

    @JsonIgnore
    public boolean isParam4Dirty() {
        return this.contains(FIELD_PARAM4);
    }

    @JsonIgnore
    public String getParam5() {
        Object objValue = this.get(FIELD_PARAM5);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param5")
    public void setParam5(String param5) {
        this.set(FIELD_PARAM5, param5);
    }

    @JsonIgnore
    public boolean isParam5Dirty() {
        return this.contains(FIELD_PARAM5);
    }

    @JsonIgnore
    public String getParam6() {
        Object objValue = this.get(FIELD_PARAM6);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="param6")
    public void setParam6(String param6) {
        this.set(FIELD_PARAM6, param6);
    }

    @JsonIgnore
    public boolean isParam6Dirty() {
        return this.contains(FIELD_PARAM6);
    }

    @JsonIgnore
    public Integer getParam7() {
        Object objValue = this.get(FIELD_PARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param7")
    public void setParam7(Integer param7) {
        this.set(FIELD_PARAM7, param7);
    }

    @JsonIgnore
    public boolean isParam7Dirty() {
        return this.contains(FIELD_PARAM7);
    }

    @JsonIgnore
    public Integer getParam8() {
        Object objValue = this.get(FIELD_PARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param8")
    public void setParam8(Integer param8) {
        this.set(FIELD_PARAM8, param8);
    }

    @JsonIgnore
    public boolean isParam8Dirty() {
        return this.contains(FIELD_PARAM8);
    }

    @JsonIgnore
    public Integer getParam9() {
        Object objValue = this.get(FIELD_PARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="param9")
    public void setParam9(Integer param9) {
        this.set(FIELD_PARAM9, param9);
    }

    @JsonIgnore
    public boolean isParam9Dirty() {
        return this.contains(FIELD_PARAM9);
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
    public String getPSDELogicNodeId() {
        Object objValue = this.get(FIELD_PSDELOGICNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicnodeid")
    public void setPSDELogicNodeId(String pSDELogicNodeId) {
        this.set(FIELD_PSDELOGICNODEID, pSDELogicNodeId);
    }

    @JsonIgnore
    public boolean isPSDELogicNodeIdDirty() {
        return this.contains(FIELD_PSDELOGICNODEID);
    }

    @JsonIgnore
    public String getPSDELogicNodeName() {
        Object objValue = this.get(FIELD_PSDELOGICNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicnodename")
    public void setPSDELogicNodeName(String pSDELogicNodeName) {
        this.set(FIELD_PSDELOGICNODENAME, pSDELogicNodeName);
    }

    @JsonIgnore
    public boolean isPSDELogicNodeNameDirty() {
        return this.contains(FIELD_PSDELOGICNODENAME);
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
    public String getPSSubSysSADetailId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADETAILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadetailid")
    public void setPSSubSysSADetailId(String pSSubSysSADetailId) {
        this.set(FIELD_PSSUBSYSSADETAILID, pSSubSysSADetailId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADetailIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADETAILID);
    }

    @JsonIgnore
    public String getPSSubSysSADetailName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADETAILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadetailname")
    public void setPSSubSysSADetailName(String pSSubSysSADetailName) {
        this.set(FIELD_PSSUBSYSSADETAILNAME, pSSubSysSADetailName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADetailNameDirty() {
        return this.contains(FIELD_PSSUBSYSSADETAILNAME);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiid")
    public void setPSSubSysServiceAPIId(String pSSubSysServiceAPIId) {
        this.set(FIELD_PSSUBSYSSERVICEAPIID, pSSubSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSubSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSUBSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsysserviceapiname")
    public void setPSSubSysServiceAPIName(String pSSubSysServiceAPIName) {
        this.set(FIELD_PSSUBSYSSERVICEAPINAME, pSSubSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSubSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSUBSYSSERVICEAPINAME);
    }

    @JsonIgnore
    public String getPSSysBackServiceId() {
        Object objValue = this.get(FIELD_PSSYSBACKSERVICEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbackserviceid")
    public void setPSSysBackServiceId(String pSSysBackServiceId) {
        this.set(FIELD_PSSYSBACKSERVICEID, pSSysBackServiceId);
    }

    @JsonIgnore
    public boolean isPSSysBackServiceIdDirty() {
        return this.contains(FIELD_PSSYSBACKSERVICEID);
    }

    @JsonIgnore
    public String getPSSysBackServiceName() {
        Object objValue = this.get(FIELD_PSSYSBACKSERVICENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbackservicename")
    public void setPSSysBackServiceName(String pSSysBackServiceName) {
        this.set(FIELD_PSSYSBACKSERVICENAME, pSSysBackServiceName);
    }

    @JsonIgnore
    public boolean isPSSysBackServiceNameDirty() {
        return this.contains(FIELD_PSSYSBACKSERVICENAME);
    }

    @JsonIgnore
    public String getPSSysBDSchemeId() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemeid")
    public void setPSSysBDSchemeId(String pSSysBDSchemeId) {
        this.set(FIELD_PSSYSBDSCHEMEID, pSSysBDSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeIdDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysBDSchemeName() {
        Object objValue = this.get(FIELD_PSSYSBDSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdschemename")
    public void setPSSysBDSchemeName(String pSSysBDSchemeName) {
        this.set(FIELD_PSSYSBDSCHEMENAME, pSSysBDSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysBDSchemeNameDirty() {
        return this.contains(FIELD_PSSYSBDSCHEMENAME);
    }

    @JsonIgnore
    public String getPSSysBDTableId() {
        Object objValue = this.get(FIELD_PSSYSBDTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtableid")
    public void setPSSysBDTableId(String pSSysBDTableId) {
        this.set(FIELD_PSSYSBDTABLEID, pSSysBDTableId);
    }

    @JsonIgnore
    public boolean isPSSysBDTableIdDirty() {
        return this.contains(FIELD_PSSYSBDTABLEID);
    }

    @JsonIgnore
    public String getPSSysBDTableName() {
        Object objValue = this.get(FIELD_PSSYSBDTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbdtablename")
    public void setPSSysBDTableName(String pSSysBDTableName) {
        this.set(FIELD_PSSYSBDTABLENAME, pSSysBDTableName);
    }

    @JsonIgnore
    public boolean isPSSysBDTableNameDirty() {
        return this.contains(FIELD_PSSYSBDTABLENAME);
    }

    @JsonIgnore
    public String getPSSysBIReportId() {
        Object objValue = this.get(FIELD_PSSYSBIREPORTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbireportid")
    public void setPSSysBIReportId(String pSSysBIReportId) {
        this.set(FIELD_PSSYSBIREPORTID, pSSysBIReportId);
    }

    @JsonIgnore
    public boolean isPSSysBIReportIdDirty() {
        return this.contains(FIELD_PSSYSBIREPORTID);
    }

    @JsonIgnore
    public String getPSSysBIReportName() {
        Object objValue = this.get(FIELD_PSSYSBIREPORTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbireportname")
    public void setPSSysBIReportName(String pSSysBIReportName) {
        this.set(FIELD_PSSYSBIREPORTNAME, pSSysBIReportName);
    }

    @JsonIgnore
    public boolean isPSSysBIReportNameDirty() {
        return this.contains(FIELD_PSSYSBIREPORTNAME);
    }

    @JsonIgnore
    public String getPSSysBISchemeId() {
        Object objValue = this.get(FIELD_PSSYSBISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbischemeid")
    public void setPSSysBISchemeId(String pSSysBISchemeId) {
        this.set(FIELD_PSSYSBISCHEMEID, pSSysBISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysBISchemeIdDirty() {
        return this.contains(FIELD_PSSYSBISCHEMEID);
    }

    @JsonIgnore
    public String getPSSysBISchemeName() {
        Object objValue = this.get(FIELD_PSSYSBISCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbischemename")
    public void setPSSysBISchemeName(String pSSysBISchemeName) {
        this.set(FIELD_PSSYSBISCHEMENAME, pSSysBISchemeName);
    }

    @JsonIgnore
    public boolean isPSSysBISchemeNameDirty() {
        return this.contains(FIELD_PSSYSBISCHEMENAME);
    }

    @JsonIgnore
    public String getPSSysDataSyncAgentId() {
        Object objValue = this.get(FIELD_PSSYSDATASYNCAGENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdatasyncagentid")
    public void setPSSysDataSyncAgentId(String pSSysDataSyncAgentId) {
        this.set(FIELD_PSSYSDATASYNCAGENTID, pSSysDataSyncAgentId);
    }

    @JsonIgnore
    public boolean isPSSysDataSyncAgentIdDirty() {
        return this.contains(FIELD_PSSYSDATASYNCAGENTID);
    }

    @JsonIgnore
    public String getPSSysDataSyncAgentName() {
        Object objValue = this.get(FIELD_PSSYSDATASYNCAGENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdatasyncagentname")
    public void setPSSysDataSyncAgentName(String pSSysDataSyncAgentName) {
        this.set(FIELD_PSSYSDATASYNCAGENTNAME, pSSysDataSyncAgentName);
    }

    @JsonIgnore
    public boolean isPSSysDataSyncAgentNameDirty() {
        return this.contains(FIELD_PSSYSDATASYNCAGENTNAME);
    }

    @JsonIgnore
    public String getPSSysDBSchemeId() {
        Object objValue = this.get(FIELD_PSSYSDBSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbschemeid")
    public void setPSSysDBSchemeId(String pSSysDBSchemeId) {
        this.set(FIELD_PSSYSDBSCHEMEID, pSSysDBSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysDBSchemeIdDirty() {
        return this.contains(FIELD_PSSYSDBSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysDBSchemeName() {
        Object objValue = this.get(FIELD_PSSYSDBSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbschemename")
    public void setPSSysDBSchemeName(String pSSysDBSchemeName) {
        this.set(FIELD_PSSYSDBSCHEMENAME, pSSysDBSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysDBSchemeNameDirty() {
        return this.contains(FIELD_PSSYSDBSCHEMENAME);
    }

    @JsonIgnore
    public String getPSSysDBTableId() {
        Object objValue = this.get(FIELD_PSSYSDBTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbtableid")
    public void setPSSysDBTableId(String pSSysDBTableId) {
        this.set(FIELD_PSSYSDBTABLEID, pSSysDBTableId);
    }

    @JsonIgnore
    public boolean isPSSysDBTableIdDirty() {
        return this.contains(FIELD_PSSYSDBTABLEID);
    }

    @JsonIgnore
    public String getPSSysDBTableName() {
        Object objValue = this.get(FIELD_PSSYSDBTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbtablename")
    public void setPSSysDBTableName(String pSSysDBTableName) {
        this.set(FIELD_PSSYSDBTABLENAME, pSSysDBTableName);
    }

    @JsonIgnore
    public boolean isPSSysDBTableNameDirty() {
        return this.contains(FIELD_PSSYSDBTABLENAME);
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
    public String getPSSysEAIElementId() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementid")
    public void setPSSysEAIElementId(String pSSysEAIElementId) {
        this.set(FIELD_PSSYSEAIELEMENTID, pSSysEAIElementId);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementIdDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTID);
    }

    @JsonIgnore
    public String getPSSysEAIElementName() {
        Object objValue = this.get(FIELD_PSSYSEAIELEMENTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaielementname")
    public void setPSSysEAIElementName(String pSSysEAIElementName) {
        this.set(FIELD_PSSYSEAIELEMENTNAME, pSSysEAIElementName);
    }

    @JsonIgnore
    public boolean isPSSysEAIElementNameDirty() {
        return this.contains(FIELD_PSSYSEAIELEMENTNAME);
    }

    @JsonIgnore
    public String getPSSysEAISchemeId() {
        Object objValue = this.get(FIELD_PSSYSEAISCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaischemeid")
    public void setPSSysEAISchemeId(String pSSysEAISchemeId) {
        this.set(FIELD_PSSYSEAISCHEMEID, pSSysEAISchemeId);
    }

    @JsonIgnore
    public boolean isPSSysEAISchemeIdDirty() {
        return this.contains(FIELD_PSSYSEAISCHEMEID);
    }

    @JsonIgnore
    public String getPSSysEAISchemeName() {
        Object objValue = this.get(FIELD_PSSYSEAISCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaischemename")
    public void setPSSysEAISchemeName(String pSSysEAISchemeName) {
        this.set(FIELD_PSSYSEAISCHEMENAME, pSSysEAISchemeName);
    }

    @JsonIgnore
    public boolean isPSSysEAISchemeNameDirty() {
        return this.contains(FIELD_PSSYSEAISCHEMENAME);
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
    public String getPSSysSearchDocId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHDOCID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchdocid")
    public void setPSSysSearchDocId(String pSSysSearchDocId) {
        this.set(FIELD_PSSYSSEARCHDOCID, pSSysSearchDocId);
    }

    @JsonIgnore
    public boolean isPSSysSearchDocIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHDOCID);
    }

    @JsonIgnore
    public String getPSSysSearchDocName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHDOCNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchdocname")
    public void setPSSysSearchDocName(String pSSysSearchDocName) {
        this.set(FIELD_PSSYSSEARCHDOCNAME, pSSysSearchDocName);
    }

    @JsonIgnore
    public boolean isPSSysSearchDocNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHDOCNAME);
    }

    @JsonIgnore
    public String getPSSysSearchSchemeId() {
        Object objValue = this.get(FIELD_PSSYSSEARCHSCHEMEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchschemeid")
    public void setPSSysSearchSchemeId(String pSSysSearchSchemeId) {
        this.set(FIELD_PSSYSSEARCHSCHEMEID, pSSysSearchSchemeId);
    }

    @JsonIgnore
    public boolean isPSSysSearchSchemeIdDirty() {
        return this.contains(FIELD_PSSYSSEARCHSCHEMEID);
    }

    @JsonIgnore
    public String getPSSysSearchSchemeName() {
        Object objValue = this.get(FIELD_PSSYSSEARCHSCHEMENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssearchschemename")
    public void setPSSysSearchSchemeName(String pSSysSearchSchemeName) {
        this.set(FIELD_PSSYSSEARCHSCHEMENAME, pSSysSearchSchemeName);
    }

    @JsonIgnore
    public boolean isPSSysSearchSchemeNameDirty() {
        return this.contains(FIELD_PSSYSSEARCHSCHEMENAME);
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
    public String getPSSysSQLCmdId() {
        Object objValue = this.get(FIELD_PSSYSSQLCMDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssqlcmdid")
    public void setPSSysSQLCmdId(String pSSysSQLCmdId) {
        this.set(FIELD_PSSYSSQLCMDID, pSSysSQLCmdId);
    }

    @JsonIgnore
    public boolean isPSSysSQLCmdIdDirty() {
        return this.contains(FIELD_PSSYSSQLCMDID);
    }

    @JsonIgnore
    public String getPSSysSQLCmdName() {
        Object objValue = this.get(FIELD_PSSYSSQLCMDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssqlcmdname")
    public void setPSSysSQLCmdName(String pSSysSQLCmdName) {
        this.set(FIELD_PSSYSSQLCMDNAME, pSSysSQLCmdName);
    }

    @JsonIgnore
    public boolean isPSSysSQLCmdNameDirty() {
        return this.contains(FIELD_PSSYSSQLCMDNAME);
    }

    @JsonIgnore
    public String getPSSysUniStateId() {
        Object objValue = this.get(FIELD_PSSYSUNISTATEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistateid")
    public void setPSSysUniStateId(String pSSysUniStateId) {
        this.set(FIELD_PSSYSUNISTATEID, pSSysUniStateId);
    }

    @JsonIgnore
    public boolean isPSSysUniStateIdDirty() {
        return this.contains(FIELD_PSSYSUNISTATEID);
    }

    @JsonIgnore
    public String getPSSysUniStateName() {
        Object objValue = this.get(FIELD_PSSYSUNISTATENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysunistatename")
    public void setPSSysUniStateName(String pSSysUniStateName) {
        this.set(FIELD_PSSYSUNISTATENAME, pSSysUniStateName);
    }

    @JsonIgnore
    public boolean isPSSysUniStateNameDirty() {
        return this.contains(FIELD_PSSYSUNISTATENAME);
    }

    @JsonIgnore
    public String getPSSysUtilDEId() {
        Object objValue = this.get(FIELD_PSSYSUTILDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysutildeid")
    public void setPSSysUtilDEId(String pSSysUtilDEId) {
        this.set(FIELD_PSSYSUTILDEID, pSSysUtilDEId);
    }

    @JsonIgnore
    public boolean isPSSysUtilDEIdDirty() {
        return this.contains(FIELD_PSSYSUTILDEID);
    }

    @JsonIgnore
    public String getPSSysUtilDEName() {
        Object objValue = this.get(FIELD_PSSYSUTILDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysutildename")
    public void setPSSysUtilDEName(String pSSysUtilDEName) {
        this.set(FIELD_PSSYSUTILDENAME, pSSysUtilDEName);
    }

    @JsonIgnore
    public boolean isPSSysUtilDENameDirty() {
        return this.contains(FIELD_PSSYSUTILDENAME);
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
    public String getPSWorkflowId() {
        Object objValue = this.get(FIELD_PSWORKFLOWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psworkflowid")
    public void setPSWorkflowId(String pSWorkflowId) {
        this.set(FIELD_PSWORKFLOWID, pSWorkflowId);
    }

    @JsonIgnore
    public boolean isPSWorkflowIdDirty() {
        return this.contains(FIELD_PSWORKFLOWID);
    }

    @JsonIgnore
    public String getPSWorkflowName() {
        Object objValue = this.get(FIELD_PSWORKFLOWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psworkflowname")
    public void setPSWorkflowName(String pSWorkflowName) {
        this.set(FIELD_PSWORKFLOWNAME, pSWorkflowName);
    }

    @JsonIgnore
    public boolean isPSWorkflowNameDirty() {
        return this.contains(FIELD_PSWORKFLOWNAME);
    }

    @JsonIgnore
    public String getRetPSDLParamId() {
        Object objValue = this.get(FIELD_RETPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retpsdlparamid")
    public void setRetPSDLParamId(String retPSDLParamId) {
        this.set(FIELD_RETPSDLPARAMID, retPSDLParamId);
    }

    @JsonIgnore
    public boolean isRetPSDLParamIdDirty() {
        return this.contains(FIELD_RETPSDLPARAMID);
    }

    @JsonIgnore
    public String getRetPSDLParamName() {
        Object objValue = this.get(FIELD_RETPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="retpsdlparamname")
    public void setRetPSDLParamName(String retPSDLParamName) {
        this.set(FIELD_RETPSDLPARAMNAME, retPSDLParamName);
    }

    @JsonIgnore
    public boolean isRetPSDLParamNameDirty() {
        return this.contains(FIELD_RETPSDLPARAMNAME);
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
    public Integer getSrcIndex() {
        Object objValue = this.get(FIELD_SRCINDEX);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="srcindex")
    public void setSrcIndex(Integer srcIndex) {
        this.set(FIELD_SRCINDEX, srcIndex);
    }

    @JsonIgnore
    public boolean isSrcIndexDirty() {
        return this.contains(FIELD_SRCINDEX);
    }

    @JsonIgnore
    public String getSrcPSDLParamId() {
        Object objValue = this.get(FIELD_SRCPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdlparamid")
    public void setSrcPSDLParamId(String srcPSDLParamId) {
        this.set(FIELD_SRCPSDLPARAMID, srcPSDLParamId);
    }

    @JsonIgnore
    public boolean isSrcPSDLParamIdDirty() {
        return this.contains(FIELD_SRCPSDLPARAMID);
    }

    @JsonIgnore
    public String getSrcPSDLParamName() {
        Object objValue = this.get(FIELD_SRCPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdlparamname")
    public void setSrcPSDLParamName(String srcPSDLParamName) {
        this.set(FIELD_SRCPSDLPARAMNAME, srcPSDLParamName);
    }

    @JsonIgnore
    public boolean isSrcPSDLParamNameDirty() {
        return this.contains(FIELD_SRCPSDLPARAMNAME);
    }

    @JsonIgnore
    public Integer getSrcSize() {
        Object objValue = this.get(FIELD_SRCSIZE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="srcsize")
    public void setSrcSize(Integer srcSize) {
        this.set(FIELD_SRCSIZE, srcSize);
    }

    @JsonIgnore
    public boolean isSrcSizeDirty() {
        return this.contains(FIELD_SRCSIZE);
    }

    @JsonIgnore
    public Integer getThreadRunMode() {
        Object objValue = this.get(FIELD_THREADRUNMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="threadrunmode")
    public void setThreadRunMode(Integer threadRunMode) {
        this.set(FIELD_THREADRUNMODE, threadRunMode);
    }

    @JsonIgnore
    public boolean isThreadRunModeDirty() {
        return this.contains(FIELD_THREADRUNMODE);
    }

    @JsonIgnore
    public Integer getThreadRunTimer() {
        Object objValue = this.get(FIELD_THREADRUNTIMER);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="threadruntimer")
    public void setThreadRunTimer(Integer threadRunTimer) {
        this.set(FIELD_THREADRUNTIMER, threadRunTimer);
    }

    @JsonIgnore
    public boolean isThreadRunTimerDirty() {
        return this.contains(FIELD_THREADRUNTIMER);
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
    public Integer getTSMode() {
        Object objValue = this.get(FIELD_TSMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tsmode")
    public void setTSMode(Integer tSMode) {
        this.set(FIELD_TSMODE, tSMode);
    }

    @JsonIgnore
    public boolean isTSModeDirty() {
        return this.contains(FIELD_TSMODE);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDELogicNodeId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDELogicNodeId(strValue);
    }

    @JsonProperty(value="psdelnparams")
    public List<PSDELNParamDTO> getPsdelnparams() {
        return this.psdelnparams;
    }

    @JsonProperty(value="psdelnparams")
    public void setPsdelnparams(List<PSDELNParamDTO> psdelnparams) {
        this.psdelnparams = psdelnparams;
    }
}

