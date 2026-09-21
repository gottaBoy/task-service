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
import net.ibizsys.modelapi.dto.PSDEDQCondDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEDQJoinDTO
extends PSModelDTOBase {
    public static final String FIELD_ALIASNAME = "aliasname";
    public static final String FIELD_CONDFLAG = "condflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EXTCOLUMNS = "extcolumns";
    public static final String FIELD_JOINPSDEID = "joinpsdeid";
    public static final String FIELD_JOINPSDENAME = "joinpsdename";
    public static final String FIELD_JOINTAG = "jointag";
    public static final String FIELD_JOINTAG2 = "jointag2";
    public static final String FIELD_MAINFLAG = "mainflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MODELSTATE = "modelstate";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PJOINPSDEID = "pjoinpsdeid";
    public static final String FIELD_PPSDEDQJOINID = "ppsdedqjoinid";
    public static final String FIELD_PPSDEDQJOINNAME = "ppsdedqjoinname";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQJOINID = "psdedqjoinid";
    public static final String FIELD_PSDEDQJOINNAME = "psdedqjoinname";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEJOINTYPEID = "psdejointypeid";
    public static final String FIELD_PSDEJOINTYPENAME = "psdejointypename";
    public static final String FIELD_PSDERID = "psderid";
    public static final String FIELD_PSDERNAME = "psdername";
    public static final String FIELD_QUERYVIEWFLAG = "queryviewflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDEDQJoinDTO> psdedqjoins;
    private List<PSDEDQCondDTO> psdedqconds;

    @JsonIgnore
    public String getAliasName() {
        Object objValue = this.get(FIELD_ALIASNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="aliasname")
    public void setAliasName(String aliasName) {
        this.set(FIELD_ALIASNAME, aliasName);
    }

    @JsonIgnore
    public boolean isAliasNameDirty() {
        return this.contains(FIELD_ALIASNAME);
    }

    @JsonIgnore
    public Integer getCondFlag() {
        Object objValue = this.get(FIELD_CONDFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="condflag")
    public void setCondFlag(Integer condFlag) {
        this.set(FIELD_CONDFLAG, condFlag);
    }

    @JsonIgnore
    public boolean isCondFlagDirty() {
        return this.contains(FIELD_CONDFLAG);
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
    public String getExtColumns() {
        Object objValue = this.get(FIELD_EXTCOLUMNS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="extcolumns")
    public void setExtColumns(String extColumns) {
        this.set(FIELD_EXTCOLUMNS, extColumns);
    }

    @JsonIgnore
    public boolean isExtColumnsDirty() {
        return this.contains(FIELD_EXTCOLUMNS);
    }

    @JsonIgnore
    public String getJoinPSDEId() {
        Object objValue = this.get(FIELD_JOINPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="joinpsdeid")
    public void setJoinPSDEId(String joinPSDEId) {
        this.set(FIELD_JOINPSDEID, joinPSDEId);
    }

    @JsonIgnore
    public boolean isJoinPSDEIdDirty() {
        return this.contains(FIELD_JOINPSDEID);
    }

    @JsonIgnore
    public String getJoinPSDEName() {
        Object objValue = this.get(FIELD_JOINPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="joinpsdename")
    public void setJoinPSDEName(String joinPSDEName) {
        this.set(FIELD_JOINPSDENAME, joinPSDEName);
    }

    @JsonIgnore
    public boolean isJoinPSDENameDirty() {
        return this.contains(FIELD_JOINPSDENAME);
    }

    @JsonIgnore
    public String getJoinTag() {
        Object objValue = this.get(FIELD_JOINTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jointag")
    public void setJoinTag(String joinTag) {
        this.set(FIELD_JOINTAG, joinTag);
    }

    @JsonIgnore
    public boolean isJoinTagDirty() {
        return this.contains(FIELD_JOINTAG);
    }

    @JsonIgnore
    public String getJoinTag2() {
        Object objValue = this.get(FIELD_JOINTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="jointag2")
    public void setJoinTag2(String joinTag2) {
        this.set(FIELD_JOINTAG2, joinTag2);
    }

    @JsonIgnore
    public boolean isJoinTag2Dirty() {
        return this.contains(FIELD_JOINTAG2);
    }

    @JsonIgnore
    public Integer getMainFlag() {
        Object objValue = this.get(FIELD_MAINFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="mainflag")
    public void setMainFlag(Integer mainFlag) {
        this.set(FIELD_MAINFLAG, mainFlag);
    }

    @JsonIgnore
    public boolean isMainFlagDirty() {
        return this.contains(FIELD_MAINFLAG);
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
    public String getPJoinPSDEId() {
        Object objValue = this.get(FIELD_PJOINPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pjoinpsdeid")
    public void setPJoinPSDEId(String pJoinPSDEId) {
        this.set(FIELD_PJOINPSDEID, pJoinPSDEId);
    }

    @JsonIgnore
    public boolean isPJoinPSDEIdDirty() {
        return this.contains(FIELD_PJOINPSDEID);
    }

    @JsonIgnore
    public String getPPSDEDQJoinId() {
        Object objValue = this.get(FIELD_PPSDEDQJOINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdedqjoinid")
    public void setPPSDEDQJoinId(String pPSDEDQJoinId) {
        this.set(FIELD_PPSDEDQJOINID, pPSDEDQJoinId);
    }

    @JsonIgnore
    public boolean isPPSDEDQJoinIdDirty() {
        return this.contains(FIELD_PPSDEDQJOINID);
    }

    @JsonIgnore
    public String getPPSDEDQJoinName() {
        Object objValue = this.get(FIELD_PPSDEDQJOINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdedqjoinname")
    public void setPPSDEDQJoinName(String pPSDEDQJoinName) {
        this.set(FIELD_PPSDEDQJOINNAME, pPSDEDQJoinName);
    }

    @JsonIgnore
    public boolean isPPSDEDQJoinNameDirty() {
        return this.contains(FIELD_PPSDEDQJOINNAME);
    }

    @JsonIgnore
    public String getPSDEDQId() {
        Object objValue = this.get(FIELD_PSDEDQID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqid")
    public void setPSDEDQId(String pSDEDQId) {
        this.set(FIELD_PSDEDQID, pSDEDQId);
    }

    @JsonIgnore
    public boolean isPSDEDQIdDirty() {
        return this.contains(FIELD_PSDEDQID);
    }

    @JsonIgnore
    public String getPSDEDQJoinId() {
        Object objValue = this.get(FIELD_PSDEDQJOINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqjoinid")
    public void setPSDEDQJoinId(String pSDEDQJoinId) {
        this.set(FIELD_PSDEDQJOINID, pSDEDQJoinId);
    }

    @JsonIgnore
    public boolean isPSDEDQJoinIdDirty() {
        return this.contains(FIELD_PSDEDQJOINID);
    }

    @JsonIgnore
    public String getPSDEDQJoinName() {
        Object objValue = this.get(FIELD_PSDEDQJOINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqjoinname")
    public void setPSDEDQJoinName(String pSDEDQJoinName) {
        this.set(FIELD_PSDEDQJOINNAME, pSDEDQJoinName);
    }

    @JsonIgnore
    public boolean isPSDEDQJoinNameDirty() {
        return this.contains(FIELD_PSDEDQJOINNAME);
    }

    @JsonIgnore
    public String getPSDEDQName() {
        Object objValue = this.get(FIELD_PSDEDQNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqname")
    public void setPSDEDQName(String pSDEDQName) {
        this.set(FIELD_PSDEDQNAME, pSDEDQName);
    }

    @JsonIgnore
    public boolean isPSDEDQNameDirty() {
        return this.contains(FIELD_PSDEDQNAME);
    }

    @JsonIgnore
    public String getPSDEJoinTypeId() {
        Object objValue = this.get(FIELD_PSDEJOINTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdejointypeid")
    public void setPSDEJoinTypeId(String pSDEJoinTypeId) {
        this.set(FIELD_PSDEJOINTYPEID, pSDEJoinTypeId);
    }

    @JsonIgnore
    public boolean isPSDEJoinTypeIdDirty() {
        return this.contains(FIELD_PSDEJOINTYPEID);
    }

    @JsonIgnore
    public String getPSDEJoinTypeName() {
        Object objValue = this.get(FIELD_PSDEJOINTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdejointypename")
    public void setPSDEJoinTypeName(String pSDEJoinTypeName) {
        this.set(FIELD_PSDEJOINTYPENAME, pSDEJoinTypeName);
    }

    @JsonIgnore
    public boolean isPSDEJoinTypeNameDirty() {
        return this.contains(FIELD_PSDEJOINTYPENAME);
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
    public Integer getQueryViewFlag() {
        Object objValue = this.get(FIELD_QUERYVIEWFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="queryviewflag")
    public void setQueryViewFlag(Integer queryViewFlag) {
        this.set(FIELD_QUERYVIEWFLAG, queryViewFlag);
    }

    @JsonIgnore
    public boolean isQueryViewFlagDirty() {
        return this.contains(FIELD_QUERYVIEWFLAG);
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
        return this.getPSDEDQJoinId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEDQJoinId(strValue);
    }

    @JsonProperty(value="psdedqjoins")
    public List<PSDEDQJoinDTO> getPsdedqjoins() {
        return this.psdedqjoins;
    }

    @JsonProperty(value="psdedqjoins")
    public void setPsdedqjoins(List<PSDEDQJoinDTO> psdedqjoins) {
        this.psdedqjoins = psdedqjoins;
    }

    @JsonProperty(value="psdedqconds")
    public List<PSDEDQCondDTO> getPsdedqconds() {
        return this.psdedqconds;
    }

    @JsonProperty(value="psdedqconds")
    public void setPsdedqconds(List<PSDEDQCondDTO> psdedqconds) {
        this.psdedqconds = psdedqconds;
    }
}

