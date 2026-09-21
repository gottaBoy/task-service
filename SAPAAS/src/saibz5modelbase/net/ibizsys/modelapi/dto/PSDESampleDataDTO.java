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

public class PSDESampleDataDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_DATA2 = "data2";
    public static final String FIELD_DATATYPE = "datatype";
    public static final String FIELD_LOGICMODE = "logicmode";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDEMAINSTATEID = "psdemainstateid";
    public static final String FIELD_PSDEMAINSTATENAME = "psdemainstatename";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDESAMPLEDATAID = "psdesampledataid";
    public static final String FIELD_PSDESAMPLEDATANAME = "psdesampledataname";
    public static final String FIELD_RANDOMCNT = "randomecnt";
    public static final String FIELD_RANDOMMODE = "randommode";
    public static final String FIELD_RANDOMPARAM = "randomparam";
    public static final String FIELD_RANDOMPARAM2 = "randomparam2";
    public static final String FIELD_RANDOMPARAM3 = "randomparam3";
    public static final String FIELD_RANDOMPARAM4 = "randomparam4";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

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
    public String getData() {
        Object objValue = this.get(FIELD_DATA);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data")
    public void setData(String data) {
        this.set(FIELD_DATA, data);
    }

    @JsonIgnore
    public boolean isDataDirty() {
        return this.contains(FIELD_DATA);
    }

    @JsonIgnore
    public String getData2() {
        Object objValue = this.get(FIELD_DATA2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="data2")
    public void setData2(String data2) {
        this.set(FIELD_DATA2, data2);
    }

    @JsonIgnore
    public boolean isData2Dirty() {
        return this.contains(FIELD_DATA2);
    }

    @JsonIgnore
    public String getDataType() {
        Object objValue = this.get(FIELD_DATATYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="datatype")
    public void setDataType(String dataType) {
        this.set(FIELD_DATATYPE, dataType);
    }

    @JsonIgnore
    public boolean isDataTypeDirty() {
        return this.contains(FIELD_DATATYPE);
    }

    @JsonIgnore
    public String getLogicMode() {
        Object objValue = this.get(FIELD_LOGICMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicmode")
    public void setLogicMode(String logicMode) {
        this.set(FIELD_LOGICMODE, logicMode);
    }

    @JsonIgnore
    public boolean isLogicModeDirty() {
        return this.contains(FIELD_LOGICMODE);
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
    public String getPSDESampleDataId() {
        Object objValue = this.get(FIELD_PSDESAMPLEDATAID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesampledataid")
    public void setPSDESampleDataId(String pSDESampleDataId) {
        this.set(FIELD_PSDESAMPLEDATAID, pSDESampleDataId);
    }

    @JsonIgnore
    public boolean isPSDESampleDataIdDirty() {
        return this.contains(FIELD_PSDESAMPLEDATAID);
    }

    @JsonIgnore
    public String getPSDESampleDataName() {
        Object objValue = this.get(FIELD_PSDESAMPLEDATANAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdesampledataname")
    public void setPSDESampleDataName(String pSDESampleDataName) {
        this.set(FIELD_PSDESAMPLEDATANAME, pSDESampleDataName);
    }

    @JsonIgnore
    public boolean isPSDESampleDataNameDirty() {
        return this.contains(FIELD_PSDESAMPLEDATANAME);
    }

    @JsonIgnore
    public Integer getRandomCnt() {
        Object objValue = this.get(FIELD_RANDOMCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="randomecnt")
    public void setRandomCnt(Integer randomCnt) {
        this.set(FIELD_RANDOMCNT, randomCnt);
    }

    @JsonIgnore
    public boolean isRandomCntDirty() {
        return this.contains(FIELD_RANDOMCNT);
    }

    @JsonIgnore
    public String getRandomMode() {
        Object objValue = this.get(FIELD_RANDOMMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="randommode")
    public void setRandomMode(String randomMode) {
        this.set(FIELD_RANDOMMODE, randomMode);
    }

    @JsonIgnore
    public boolean isRandomModeDirty() {
        return this.contains(FIELD_RANDOMMODE);
    }

    @JsonIgnore
    public String getRandomParam() {
        Object objValue = this.get(FIELD_RANDOMPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="randomparam")
    public void setRandomParam(String randomParam) {
        this.set(FIELD_RANDOMPARAM, randomParam);
    }

    @JsonIgnore
    public boolean isRandomParamDirty() {
        return this.contains(FIELD_RANDOMPARAM);
    }

    @JsonIgnore
    public String getRandomParam2() {
        Object objValue = this.get(FIELD_RANDOMPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="randomparam2")
    public void setRandomParam2(String randomParam2) {
        this.set(FIELD_RANDOMPARAM2, randomParam2);
    }

    @JsonIgnore
    public boolean isRandomParam2Dirty() {
        return this.contains(FIELD_RANDOMPARAM2);
    }

    @JsonIgnore
    public Integer getRandomParam3() {
        Object objValue = this.get(FIELD_RANDOMPARAM3);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="randomparam3")
    public void setRandomParam3(Integer randomParam3) {
        this.set(FIELD_RANDOMPARAM3, randomParam3);
    }

    @JsonIgnore
    public boolean isRandomParam3Dirty() {
        return this.contains(FIELD_RANDOMPARAM3);
    }

    @JsonIgnore
    public Integer getRandomParam4() {
        Object objValue = this.get(FIELD_RANDOMPARAM4);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="randomparam4")
    public void setRandomParam4(Integer randomParam4) {
        this.set(FIELD_RANDOMPARAM4, randomParam4);
    }

    @JsonIgnore
    public boolean isRandomParam4Dirty() {
        return this.contains(FIELD_RANDOMPARAM4);
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
        return this.getPSDESampleDataId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDESampleDataId(strValue);
    }
}

