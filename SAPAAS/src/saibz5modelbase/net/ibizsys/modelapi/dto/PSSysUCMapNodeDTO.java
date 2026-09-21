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

public class PSSysUCMapNodeDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_LEFTPOS = "leftpos";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_NODETYPE = "nodetype";
    public static final String FIELD_PSSYSACTORID = "pssysactorid";
    public static final String FIELD_PSSYSACTORNAME = "pssysactorname";
    public static final String FIELD_PSSYSUCMAPID = "pssysucmapid";
    public static final String FIELD_PSSYSUCMAPNAME = "pssysucmapname";
    public static final String FIELD_PSSYSUCMAPNODEID = "pssysucmapnodeid";
    public static final String FIELD_PSSYSUCMAPNODENAME = "pssysucmapnodename";
    public static final String FIELD_PSSYSUSERCASEID = "pssysusercaseid";
    public static final String FIELD_PSSYSUSERCASENAME = "pssysusercasename";
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
    public String getPSSysActorId() {
        Object objValue = this.get(FIELD_PSSYSACTORID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysactorid")
    public void setPSSysActorId(String pSSysActorId) {
        this.set(FIELD_PSSYSACTORID, pSSysActorId);
    }

    @JsonIgnore
    public boolean isPSSysActorIdDirty() {
        return this.contains(FIELD_PSSYSACTORID);
    }

    @JsonIgnore
    public String getPSSysActorName() {
        Object objValue = this.get(FIELD_PSSYSACTORNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysactorname")
    public void setPSSysActorName(String pSSysActorName) {
        this.set(FIELD_PSSYSACTORNAME, pSSysActorName);
    }

    @JsonIgnore
    public boolean isPSSysActorNameDirty() {
        return this.contains(FIELD_PSSYSACTORNAME);
    }

    @JsonIgnore
    public String getPSSysUCMapId() {
        Object objValue = this.get(FIELD_PSSYSUCMAPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysucmapid")
    public void setPSSysUCMapId(String pSSysUCMapId) {
        this.set(FIELD_PSSYSUCMAPID, pSSysUCMapId);
    }

    @JsonIgnore
    public boolean isPSSysUCMapIdDirty() {
        return this.contains(FIELD_PSSYSUCMAPID);
    }

    @JsonIgnore
    public String getPSSysUCMapName() {
        Object objValue = this.get(FIELD_PSSYSUCMAPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysucmapname")
    public void setPSSysUCMapName(String pSSysUCMapName) {
        this.set(FIELD_PSSYSUCMAPNAME, pSSysUCMapName);
    }

    @JsonIgnore
    public boolean isPSSysUCMapNameDirty() {
        return this.contains(FIELD_PSSYSUCMAPNAME);
    }

    @JsonIgnore
    public String getPSSysUCMapNodeId() {
        Object objValue = this.get(FIELD_PSSYSUCMAPNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysucmapnodeid")
    public void setPSSysUCMapNodeId(String pSSysUCMapNodeId) {
        this.set(FIELD_PSSYSUCMAPNODEID, pSSysUCMapNodeId);
    }

    @JsonIgnore
    public boolean isPSSysUCMapNodeIdDirty() {
        return this.contains(FIELD_PSSYSUCMAPNODEID);
    }

    @JsonIgnore
    public String getPSSysUCMapNodeName() {
        Object objValue = this.get(FIELD_PSSYSUCMAPNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysucmapnodename")
    public void setPSSysUCMapNodeName(String pSSysUCMapNodeName) {
        this.set(FIELD_PSSYSUCMAPNODENAME, pSSysUCMapNodeName);
    }

    @JsonIgnore
    public boolean isPSSysUCMapNodeNameDirty() {
        return this.contains(FIELD_PSSYSUCMAPNODENAME);
    }

    @JsonIgnore
    public String getPSSysUserCaseId() {
        Object objValue = this.get(FIELD_PSSYSUSERCASEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercaseid")
    public void setPSSysUserCaseId(String pSSysUserCaseId) {
        this.set(FIELD_PSSYSUSERCASEID, pSSysUserCaseId);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseIdDirty() {
        return this.contains(FIELD_PSSYSUSERCASEID);
    }

    @JsonIgnore
    public String getPSSysUserCaseName() {
        Object objValue = this.get(FIELD_PSSYSUSERCASENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysusercasename")
    public void setPSSysUserCaseName(String pSSysUserCaseName) {
        this.set(FIELD_PSSYSUSERCASENAME, pSSysUserCaseName);
    }

    @JsonIgnore
    public boolean isPSSysUserCaseNameDirty() {
        return this.contains(FIELD_PSSYSUSERCASENAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysUCMapNodeId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSSysUCMapNodeId(strValue);
    }
}

