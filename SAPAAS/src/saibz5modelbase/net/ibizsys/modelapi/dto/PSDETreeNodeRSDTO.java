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

public class PSDETreeNodeRSDTO
extends PSModelDTOBase {
    public static final String FIELD_CHILDFILTER = "childfilter";
    public static final String FIELD_CHILDFILTERDESC = "childfilterdesc";
    public static final String FIELD_CMCREATE = "cmcreate";
    public static final String FIELD_CPSDETREENODEID = "cpsdetreenodeid";
    public static final String FIELD_CPSDETREENODENAME = "cpsdetreenodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCODE = "customcode";
    public static final String FIELD_CUSTOMMODE = "custommode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSDETREENODEID = "ppsdetreenodeid";
    public static final String FIELD_PPSDETREENODENAME = "ppsdetreenodename";
    public static final String FIELD_PROCESSPARAM = "processparam";
    public static final String FIELD_PSDEACTIONID = "psdeactionid";
    public static final String FIELD_PSDEACTIONNAME = "psdeactionname";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_PSDETREENODERSID = "psdetreenodersid";
    public static final String FIELD_PSDETREENODERSNAME = "psdetreenodersname";
    public static final String FIELD_PSDETREEVIEWID = "psdetreeviewid";
    public static final String FIELD_PSDETREEVIEWNAME = "psdetreeviewname";
    public static final String FIELD_PVALUELEVEL = "pvaluelevel";
    public static final String FIELD_SEARCHMODE = "searchmode";
    public static final String FIELD_TYPEFILTER = "typefilter";
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
    public String getChildFilter() {
        Object objValue = this.get(FIELD_CHILDFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childfilter")
    public void setChildFilter(String childFilter) {
        this.set(FIELD_CHILDFILTER, childFilter);
    }

    @JsonIgnore
    public boolean isChildFilterDirty() {
        return this.contains(FIELD_CHILDFILTER);
    }

    @JsonIgnore
    public String getChildFilterDesc() {
        Object objValue = this.get(FIELD_CHILDFILTERDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="childfilterdesc")
    public void setChildFilterDesc(String childFilterDesc) {
        this.set(FIELD_CHILDFILTERDESC, childFilterDesc);
    }

    @JsonIgnore
    public boolean isChildFilterDescDirty() {
        return this.contains(FIELD_CHILDFILTERDESC);
    }

    @JsonIgnore
    public Integer getCMCreate() {
        Object objValue = this.get(FIELD_CMCREATE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cmcreate")
    public void setCMCreate(Integer cMCreate) {
        this.set(FIELD_CMCREATE, cMCreate);
    }

    @JsonIgnore
    public boolean isCMCreateDirty() {
        return this.contains(FIELD_CMCREATE);
    }

    @JsonIgnore
    public String getCPSDETreeNodeId() {
        Object objValue = this.get(FIELD_CPSDETREENODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsdetreenodeid")
    public void setCPSDETreeNodeId(String cPSDETreeNodeId) {
        this.set(FIELD_CPSDETREENODEID, cPSDETreeNodeId);
    }

    @JsonIgnore
    public boolean isCPSDETreeNodeIdDirty() {
        return this.contains(FIELD_CPSDETREENODEID);
    }

    @JsonIgnore
    public String getCPSDETreeNodeName() {
        Object objValue = this.get(FIELD_CPSDETREENODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cpsdetreenodename")
    public void setCPSDETreeNodeName(String cPSDETreeNodeName) {
        this.set(FIELD_CPSDETREENODENAME, cPSDETreeNodeName);
    }

    @JsonIgnore
    public boolean isCPSDETreeNodeNameDirty() {
        return this.contains(FIELD_CPSDETREENODENAME);
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
    public Integer getCustomMode() {
        Object objValue = this.get(FIELD_CUSTOMMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="custommode")
    public void setCustomMode(Integer customMode) {
        this.set(FIELD_CUSTOMMODE, customMode);
    }

    @JsonIgnore
    public boolean isCustomModeDirty() {
        return this.contains(FIELD_CUSTOMMODE);
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
    public String getPPSDETreeNodeId() {
        Object objValue = this.get(FIELD_PPSDETREENODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdetreenodeid")
    public void setPPSDETreeNodeId(String pPSDETreeNodeId) {
        this.set(FIELD_PPSDETREENODEID, pPSDETreeNodeId);
    }

    @JsonIgnore
    public boolean isPPSDETreeNodeIdDirty() {
        return this.contains(FIELD_PPSDETREENODEID);
    }

    @JsonIgnore
    public String getPPSDETreeNodeName() {
        Object objValue = this.get(FIELD_PPSDETREENODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdetreenodename")
    public void setPPSDETreeNodeName(String pPSDETreeNodeName) {
        this.set(FIELD_PPSDETREENODENAME, pPSDETreeNodeName);
    }

    @JsonIgnore
    public boolean isPPSDETreeNodeNameDirty() {
        return this.contains(FIELD_PPSDETREENODENAME);
    }

    @JsonIgnore
    public String getProcessParam() {
        Object objValue = this.get(FIELD_PROCESSPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="processparam")
    public void setProcessParam(String processParam) {
        this.set(FIELD_PROCESSPARAM, processParam);
    }

    @JsonIgnore
    public boolean isProcessParamDirty() {
        return this.contains(FIELD_PROCESSPARAM);
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
    public String getPSDETreeNodeRSId() {
        Object objValue = this.get(FIELD_PSDETREENODERSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodersid")
    public void setPSDETreeNodeRSId(String pSDETreeNodeRSId) {
        this.set(FIELD_PSDETREENODERSID, pSDETreeNodeRSId);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeRSIdDirty() {
        return this.contains(FIELD_PSDETREENODERSID);
    }

    @JsonIgnore
    public String getPSDETreeNodeRSName() {
        Object objValue = this.get(FIELD_PSDETREENODERSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreenodersname")
    public void setPSDETreeNodeRSName(String pSDETreeNodeRSName) {
        this.set(FIELD_PSDETREENODERSNAME, pSDETreeNodeRSName);
    }

    @JsonIgnore
    public boolean isPSDETreeNodeRSNameDirty() {
        return this.contains(FIELD_PSDETREENODERSNAME);
    }

    @JsonIgnore
    public String getPSDETreeViewId() {
        Object objValue = this.get(FIELD_PSDETREEVIEWID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewid")
    public void setPSDETreeViewId(String pSDETreeViewId) {
        this.set(FIELD_PSDETREEVIEWID, pSDETreeViewId);
    }

    @JsonIgnore
    public boolean isPSDETreeViewIdDirty() {
        return this.contains(FIELD_PSDETREEVIEWID);
    }

    @JsonIgnore
    public String getPSDETreeViewName() {
        Object objValue = this.get(FIELD_PSDETREEVIEWNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdetreeviewname")
    public void setPSDETreeViewName(String pSDETreeViewName) {
        this.set(FIELD_PSDETREEVIEWNAME, pSDETreeViewName);
    }

    @JsonIgnore
    public boolean isPSDETreeViewNameDirty() {
        return this.contains(FIELD_PSDETREEVIEWNAME);
    }

    @JsonIgnore
    public Integer getPValueLevel() {
        Object objValue = this.get(FIELD_PVALUELEVEL);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="pvaluelevel")
    public void setPValueLevel(Integer pValueLevel) {
        this.set(FIELD_PVALUELEVEL, pValueLevel);
    }

    @JsonIgnore
    public boolean isPValueLevelDirty() {
        return this.contains(FIELD_PVALUELEVEL);
    }

    @JsonIgnore
    public Integer getSearchMode() {
        Object objValue = this.get(FIELD_SEARCHMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="searchmode")
    public void setSearchMode(Integer searchMode) {
        this.set(FIELD_SEARCHMODE, searchMode);
    }

    @JsonIgnore
    public boolean isSearchModeDirty() {
        return this.contains(FIELD_SEARCHMODE);
    }

    @JsonIgnore
    public String getTypeFilter() {
        Object objValue = this.get(FIELD_TYPEFILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="typefilter")
    public void setTypeFilter(String typeFilter) {
        this.set(FIELD_TYPEFILTER, typeFilter);
    }

    @JsonIgnore
    public boolean isTypeFilterDirty() {
        return this.contains(FIELD_TYPEFILTER);
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
        return this.getPSDETreeNodeRSId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDETreeNodeRSId(strValue);
    }
}

