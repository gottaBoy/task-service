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

public class PSSysERMapNode
extends PSModelBase {
    public static final String FIELD_COLOR = "color";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DETAILMODE = "detailmode";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_LOGICNAME = "logicname";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODCOLOR = "modcolor";
    public static final String FIELD_NODETAG = "nodetag";
    public static final String FIELD_NODETAG2 = "nodetag2";
    public static final String FIELD_NODETYPE = "nodetype";
    public static final String FIELD_PSAPPLOCALDEID = "psapplocaldeid";
    public static final String FIELD_PSAPPLOCALDENAME = "psapplocaldename";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDESERVICEAPIID = "psdeserviceapiid";
    public static final String FIELD_PSDESERVICEAPINAME = "psdeserviceapiname";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSUBSYSSADEID = "pssubsyssadeid";
    public static final String FIELD_PSSUBSYSSADENAME = "pssubsyssadename";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "pssubsysserviceapiid";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "pssubsysserviceapiname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSBDSCHEMEID = "pssysbdschemeid";
    public static final String FIELD_PSSYSBDSCHEMENAME = "pssysbdschemename";
    public static final String FIELD_PSSYSBDTABLEID = "pssysbdtableid";
    public static final String FIELD_PSSYSBDTABLENAME = "pssysbdtablename";
    public static final String FIELD_PSSYSDBSCHEMEID = "pssysdbschemeid";
    public static final String FIELD_PSSYSDBSCHEMENAME = "pssysdbschemename";
    public static final String FIELD_PSSYSDBTABLEID = "pssysdbtableid";
    public static final String FIELD_PSSYSDBTABLENAME = "pssysdbtablename";
    public static final String FIELD_PSSYSERMAPID = "pssysermapid";
    public static final String FIELD_PSSYSERMAPNAME = "pssysermapname";
    public static final String FIELD_PSSYSERMAPNODEID = "pssysermapnodeid";
    public static final String FIELD_PSSYSERMAPNODENAME = "pssysermapnodename";
    public static final String FIELD_PSSYSSEARCHDOCID = "pssyssearchdocid";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "pssyssearchdocname";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "pssyssearchschemeid";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "pssyssearchschemename";
    public static final String FIELD_PSSYSSERVICEAPIID = "pssysserviceapiid";
    public static final String FIELD_PSSYSSERVICEAPINAME = "pssysserviceapiname";
    public static final String FIELD_SHAPEPARAMS = "shapeparams";
    public static final String FIELD_SHOWDEFIELDS = "showdefields";
    public static final String FIELD_TOPPOS = "toppos";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public Integer getDetailMode() {
        Object objValue = this.get(FIELD_DETAILMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="detailmode")
    public void setDetailMode(Integer detailMode) {
        this.set(FIELD_DETAILMODE, detailMode);
    }

    @JsonIgnore
    public boolean isDetailModeDirty() {
        return this.contains(FIELD_DETAILMODE);
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
    public String getNodeTag() {
        Object objValue = this.get(FIELD_NODETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodetag")
    public void setNodeTag(String nodeTag) {
        this.set(FIELD_NODETAG, nodeTag);
    }

    @JsonIgnore
    public boolean isNodeTagDirty() {
        return this.contains(FIELD_NODETAG);
    }

    @JsonIgnore
    public String getNodeTag2() {
        Object objValue = this.get(FIELD_NODETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodetag2")
    public void setNodeTag2(String nodeTag2) {
        this.set(FIELD_NODETAG2, nodeTag2);
    }

    @JsonIgnore
    public boolean isNodeTag2Dirty() {
        return this.contains(FIELD_NODETAG2);
    }

    @JsonIgnore
    public String getNodeType() {
        Object objValue = this.get(FIELD_NODETYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="nodetype")
    public void setNodeType(String nodeType) {
        this.set(FIELD_NODETYPE, nodeType);
    }

    @JsonIgnore
    public boolean isNodeTypeDirty() {
        return this.contains(FIELD_NODETYPE);
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
    public String getPSDEServiceAPIId() {
        Object objValue = this.get(FIELD_PSDESERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiid")
    public void setPSDEServiceAPIId(String pSDEServiceAPIId) {
        this.set(FIELD_PSDESERVICEAPIID, pSDEServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPIIdDirty() {
        return this.contains(FIELD_PSDESERVICEAPIID);
    }

    @JsonIgnore
    public String getPSDEServiceAPIName() {
        Object objValue = this.get(FIELD_PSDESERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeserviceapiname")
    public void setPSDEServiceAPIName(String pSDEServiceAPIName) {
        this.set(FIELD_PSDESERVICEAPINAME, pSDEServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSDEServiceAPINameDirty() {
        return this.contains(FIELD_PSDESERVICEAPINAME);
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
    public String getPSSubSysSADEId() {
        Object objValue = this.get(FIELD_PSSUBSYSSADEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadeid")
    public void setPSSubSysSADEId(String pSSubSysSADEId) {
        this.set(FIELD_PSSUBSYSSADEID, pSSubSysSADEId);
    }

    @JsonIgnore
    public boolean isPSSubSysSADEIdDirty() {
        return this.contains(FIELD_PSSUBSYSSADEID);
    }

    @JsonIgnore
    public String getPSSubSysSADEName() {
        Object objValue = this.get(FIELD_PSSUBSYSSADENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssubsyssadename")
    public void setPSSubSysSADEName(String pSSubSysSADEName) {
        this.set(FIELD_PSSUBSYSSADENAME, pSSubSysSADEName);
    }

    @JsonIgnore
    public boolean isPSSubSysSADENameDirty() {
        return this.contains(FIELD_PSSUBSYSSADENAME);
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
    public String getPSSysERMapId() {
        Object objValue = this.get(FIELD_PSSYSERMAPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysermapid")
    public void setPSSysERMapId(String pSSysERMapId) {
        this.set(FIELD_PSSYSERMAPID, pSSysERMapId);
    }

    @JsonIgnore
    public boolean isPSSysERMapIdDirty() {
        return this.contains(FIELD_PSSYSERMAPID);
    }

    @JsonIgnore
    public String getPSSysERMapName() {
        Object objValue = this.get(FIELD_PSSYSERMAPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysermapname")
    public void setPSSysERMapName(String pSSysERMapName) {
        this.set(FIELD_PSSYSERMAPNAME, pSSysERMapName);
    }

    @JsonIgnore
    public boolean isPSSysERMapNameDirty() {
        return this.contains(FIELD_PSSYSERMAPNAME);
    }

    @JsonIgnore
    public String getPSSysERMapNodeId() {
        Object objValue = this.get(FIELD_PSSYSERMAPNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysermapnodeid")
    public void setPSSysERMapNodeId(String pSSysERMapNodeId) {
        this.set(FIELD_PSSYSERMAPNODEID, pSSysERMapNodeId);
    }

    @JsonIgnore
    public boolean isPSSysERMapNodeIdDirty() {
        return this.contains(FIELD_PSSYSERMAPNODEID);
    }

    @JsonIgnore
    public String getPSSysERMapNodeName() {
        Object objValue = this.get(FIELD_PSSYSERMAPNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysermapnodename")
    public void setPSSysERMapNodeName(String pSSysERMapNodeName) {
        this.set(FIELD_PSSYSERMAPNODENAME, pSSysERMapNodeName);
    }

    @JsonIgnore
    public boolean isPSSysERMapNodeNameDirty() {
        return this.contains(FIELD_PSSYSERMAPNODENAME);
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
    public String getPSSysServiceAPIId() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPIID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiid")
    public void setPSSysServiceAPIId(String pSSysServiceAPIId) {
        this.set(FIELD_PSSYSSERVICEAPIID, pSSysServiceAPIId);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPIIdDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPIID);
    }

    @JsonIgnore
    public String getPSSysServiceAPIName() {
        Object objValue = this.get(FIELD_PSSYSSERVICEAPINAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysserviceapiname")
    public void setPSSysServiceAPIName(String pSSysServiceAPIName) {
        this.set(FIELD_PSSYSSERVICEAPINAME, pSSysServiceAPIName);
    }

    @JsonIgnore
    public boolean isPSSysServiceAPINameDirty() {
        return this.contains(FIELD_PSSYSSERVICEAPINAME);
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
    public String getShowDEFields() {
        Object objValue = this.get(FIELD_SHOWDEFIELDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="showdefields")
    public void setShowDEFields(String showDEFields) {
        this.set(FIELD_SHOWDEFIELDS, showDEFields);
    }

    @JsonIgnore
    public boolean isShowDEFieldsDirty() {
        return this.contains(FIELD_SHOWDEFIELDS);
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
    public String getSrfkey() {
        return this.getPSSysERMapNodeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysERMapNodeId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSSYSERMAPNODE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysERMapNode item = (PSSysERMapNode)MAPPER.readValue(new File(strJsonFilePath), PSSysERMapNode.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysERMapNode) {
            PSSysERMapNode pSSysERMapNode = (PSSysERMapNode)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysERMapNode) {
            PSSysERMapNode pSSysERMapNode = (PSSysERMapNode)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

