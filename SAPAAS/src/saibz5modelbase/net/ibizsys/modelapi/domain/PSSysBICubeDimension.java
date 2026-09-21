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
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBICubeLevel;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysBICubeDimension
extends PSModelBase {
    public static final String FIELD_BICUBEDIMENSIONTAG = "bicubedimensiontag";
    public static final String FIELD_BICUBEDIMENSIONTAG2 = "bicubedimensiontag2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "pssysbicubedimensionid";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "pssysbicubedimensionname";
    public static final String FIELD_PSSYSBICUBEID = "pssysbicubeid";
    public static final String FIELD_PSSYSBICUBENAME = "pssysbicubename";
    public static final String FIELD_PSSYSBIDIMENSIONID = "pssysbidimensionid";
    public static final String FIELD_PSSYSBIDIMENSIONNAME = "pssysbidimensionname";
    public static final String FIELD_PSSYSBISCHEMEID = "pssysbischemeid";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysBICubeLevel> pssysbicubelevels;

    @JsonIgnore
    public String getBICubeDimensionTag() {
        Object objValue = this.get(FIELD_BICUBEDIMENSIONTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubedimensiontag")
    public void setBICubeDimensionTag(String bICubeDimensionTag) {
        this.set(FIELD_BICUBEDIMENSIONTAG, bICubeDimensionTag);
    }

    @JsonIgnore
    public boolean isBICubeDimensionTagDirty() {
        return this.contains(FIELD_BICUBEDIMENSIONTAG);
    }

    @JsonIgnore
    public String getBICubeDimensionTag2() {
        Object objValue = this.get(FIELD_BICUBEDIMENSIONTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="bicubedimensiontag2")
    public void setBICubeDimensionTag2(String bICubeDimensionTag2) {
        this.set(FIELD_BICUBEDIMENSIONTAG2, bICubeDimensionTag2);
    }

    @JsonIgnore
    public boolean isBICubeDimensionTag2Dirty() {
        return this.contains(FIELD_BICUBEDIMENSIONTAG2);
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
    public String getPSSysBICubeDimensionId() {
        Object objValue = this.get(FIELD_PSSYSBICUBEDIMENSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubedimensionid")
    public void setPSSysBICubeDimensionId(String pSSysBICubeDimensionId) {
        this.set(FIELD_PSSYSBICUBEDIMENSIONID, pSSysBICubeDimensionId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeDimensionIdDirty() {
        return this.contains(FIELD_PSSYSBICUBEDIMENSIONID);
    }

    @JsonIgnore
    public String getPSSysBICubeDimensionName() {
        Object objValue = this.get(FIELD_PSSYSBICUBEDIMENSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubedimensionname")
    public void setPSSysBICubeDimensionName(String pSSysBICubeDimensionName) {
        this.set(FIELD_PSSYSBICUBEDIMENSIONNAME, pSSysBICubeDimensionName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeDimensionNameDirty() {
        return this.contains(FIELD_PSSYSBICUBEDIMENSIONNAME);
    }

    @JsonIgnore
    public String getPSSysBICubeId() {
        Object objValue = this.get(FIELD_PSSYSBICUBEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubeid")
    public void setPSSysBICubeId(String pSSysBICubeId) {
        this.set(FIELD_PSSYSBICUBEID, pSSysBICubeId);
    }

    @JsonIgnore
    public boolean isPSSysBICubeIdDirty() {
        return this.contains(FIELD_PSSYSBICUBEID);
    }

    @JsonIgnore
    public String getPSSysBICubeName() {
        Object objValue = this.get(FIELD_PSSYSBICUBENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbicubename")
    public void setPSSysBICubeName(String pSSysBICubeName) {
        this.set(FIELD_PSSYSBICUBENAME, pSSysBICubeName);
    }

    @JsonIgnore
    public boolean isPSSysBICubeNameDirty() {
        return this.contains(FIELD_PSSYSBICUBENAME);
    }

    @JsonIgnore
    public String getPSSysBIDimensionId() {
        Object objValue = this.get(FIELD_PSSYSBIDIMENSIONID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbidimensionid")
    public void setPSSysBIDimensionId(String pSSysBIDimensionId) {
        this.set(FIELD_PSSYSBIDIMENSIONID, pSSysBIDimensionId);
    }

    @JsonIgnore
    public boolean isPSSysBIDimensionIdDirty() {
        return this.contains(FIELD_PSSYSBIDIMENSIONID);
    }

    @JsonIgnore
    public String getPSSysBIDimensionName() {
        Object objValue = this.get(FIELD_PSSYSBIDIMENSIONNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbidimensionname")
    public void setPSSysBIDimensionName(String pSSysBIDimensionName) {
        this.set(FIELD_PSSYSBIDIMENSIONNAME, pSSysBIDimensionName);
    }

    @JsonIgnore
    public boolean isPSSysBIDimensionNameDirty() {
        return this.contains(FIELD_PSSYSBIDIMENSIONNAME);
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

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSSysBICubeDimensionId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBICubeDimensionId(strValue);
    }

    public List<PSSysBICubeLevel> getPssysbicubelevels() {
        return this.pssysbicubelevels;
    }

    public void setPssysbicubelevels(List<PSSysBICubeLevel> pssysbicubelevels) {
        this.pssysbicubelevels = pssysbicubelevels;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysbicubelevels")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysbicubelevels")) {
            this.init();
            return this.pssysbicubelevels;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBICUBEDIMENSION";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBICubeDimension item = (PSSysBICubeDimension)MAPPER.readValue(new File(strJsonFilePath), PSSysBICubeDimension.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBICubeDimension) {
            PSSysBICubeDimension dst = (PSSysBICubeDimension)target;
            if (!bSimple && this.getPssysbicubelevels() != null) {
                ArrayList<PSSysBICubeLevel> pssysbicubelevels = new ArrayList<PSSysBICubeLevel>();
                for (PSSysBICubeLevel item : this.getPssysbicubelevels()) {
                    if (bDeepMode) {
                        PSSysBICubeLevel newitem = new PSSysBICubeLevel();
                        item.to(newitem, false, bDeepMode);
                        pssysbicubelevels.add(newitem);
                        continue;
                    }
                    pssysbicubelevels.add(item);
                }
                dst.setPssysbicubelevels(pssysbicubelevels);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBICubeDimension) {
            PSSysBICubeDimension src = (PSSysBICubeDimension)source;
            if (!bSimple && src.getPssysbicubelevels() != null) {
                ArrayList<PSSysBICubeLevel> pssysbicubelevels = new ArrayList<PSSysBICubeLevel>();
                for (PSSysBICubeLevel item : src.getPssysbicubelevels()) {
                    if (bDeepMode) {
                        PSSysBICubeLevel newItem = new PSSysBICubeLevel();
                        newItem.from(item, false, bDeepMode);
                        pssysbicubelevels.add(newItem);
                        continue;
                    }
                    pssysbicubelevels.add(item);
                }
                this.setPssysbicubelevels(pssysbicubelevels);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

