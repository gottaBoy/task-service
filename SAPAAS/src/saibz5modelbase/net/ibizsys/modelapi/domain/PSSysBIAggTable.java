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
import net.ibizsys.modelapi.domain.PSSysBIAggColumn;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysBIAggTable
extends PSModelBase {
    public static final String FIELD_BIAGGTABLETAG = "biaggtabletag";
    public static final String FIELD_BIAGGTABLETAG2 = "biaggtabletag2";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSSYSBIAGGTABLEID = "pssysbiaggtableid";
    public static final String FIELD_PSSYSBIAGGTABLENAME = "pssysbiaggtablename";
    public static final String FIELD_PSSYSBICUBEID = "pssysbicubeid";
    public static final String FIELD_PSSYSBICUBENAME = "pssysbicubename";
    public static final String FIELD_PSSYSBISCHEMEID = "pssysbischemeid";
    public static final String FIELD_PSSYSBISCHEMENAME = "pssysbischemename";
    public static final String FIELD_REALTIMEMODE = "realtimemode";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysBIAggColumn> pssysbiaggcolumns;

    @JsonIgnore
    public String getBIAggTableTag() {
        Object objValue = this.get(FIELD_BIAGGTABLETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biaggtabletag")
    public void setBIAggTableTag(String bIAggTableTag) {
        this.set(FIELD_BIAGGTABLETAG, bIAggTableTag);
    }

    @JsonIgnore
    public boolean isBIAggTableTagDirty() {
        return this.contains(FIELD_BIAGGTABLETAG);
    }

    @JsonIgnore
    public String getBIAggTableTag2() {
        Object objValue = this.get(FIELD_BIAGGTABLETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="biaggtabletag2")
    public void setBIAggTableTag2(String bIAggTableTag2) {
        this.set(FIELD_BIAGGTABLETAG2, bIAggTableTag2);
    }

    @JsonIgnore
    public boolean isBIAggTableTag2Dirty() {
        return this.contains(FIELD_BIAGGTABLETAG2);
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
    public String getPSSysBIAggTableId() {
        Object objValue = this.get(FIELD_PSSYSBIAGGTABLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggtableid")
    public void setPSSysBIAggTableId(String pSSysBIAggTableId) {
        this.set(FIELD_PSSYSBIAGGTABLEID, pSSysBIAggTableId);
    }

    @JsonIgnore
    public boolean isPSSysBIAggTableIdDirty() {
        return this.contains(FIELD_PSSYSBIAGGTABLEID);
    }

    @JsonIgnore
    public String getPSSysBIAggTableName() {
        Object objValue = this.get(FIELD_PSSYSBIAGGTABLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysbiaggtablename")
    public void setPSSysBIAggTableName(String pSSysBIAggTableName) {
        this.set(FIELD_PSSYSBIAGGTABLENAME, pSSysBIAggTableName);
    }

    @JsonIgnore
    public boolean isPSSysBIAggTableNameDirty() {
        return this.contains(FIELD_PSSYSBIAGGTABLENAME);
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
    public Integer getRealTimeMode() {
        Object objValue = this.get(FIELD_REALTIMEMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="realtimemode")
    public void setRealTimeMode(Integer realTimeMode) {
        this.set(FIELD_REALTIMEMODE, realTimeMode);
    }

    @JsonIgnore
    public boolean isRealTimeModeDirty() {
        return this.contains(FIELD_REALTIMEMODE);
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
        return this.getPSSysBIAggTableId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysBIAggTableId(strValue);
    }

    public List<PSSysBIAggColumn> getPssysbiaggcolumns() {
        return this.pssysbiaggcolumns;
    }

    public void setPssysbiaggcolumns(List<PSSysBIAggColumn> pssysbiaggcolumns) {
        this.pssysbiaggcolumns = pssysbiaggcolumns;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysbiaggcolumns")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysbiaggcolumns")) {
            this.init();
            return this.pssysbiaggcolumns;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSBIAGGTABLE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysBIAggTable item = (PSSysBIAggTable)MAPPER.readValue(new File(strJsonFilePath), PSSysBIAggTable.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysBIAggTable) {
            PSSysBIAggTable dst = (PSSysBIAggTable)target;
            if (!bSimple && this.getPssysbiaggcolumns() != null) {
                ArrayList<PSSysBIAggColumn> pssysbiaggcolumns = new ArrayList<PSSysBIAggColumn>();
                for (PSSysBIAggColumn item : this.getPssysbiaggcolumns()) {
                    if (bDeepMode) {
                        PSSysBIAggColumn newitem = new PSSysBIAggColumn();
                        item.to(newitem, false, bDeepMode);
                        pssysbiaggcolumns.add(newitem);
                        continue;
                    }
                    pssysbiaggcolumns.add(item);
                }
                dst.setPssysbiaggcolumns(pssysbiaggcolumns);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysBIAggTable) {
            PSSysBIAggTable src = (PSSysBIAggTable)source;
            if (!bSimple && src.getPssysbiaggcolumns() != null) {
                ArrayList<PSSysBIAggColumn> pssysbiaggcolumns = new ArrayList<PSSysBIAggColumn>();
                for (PSSysBIAggColumn item : src.getPssysbiaggcolumns()) {
                    if (bDeepMode) {
                        PSSysBIAggColumn newItem = new PSSysBIAggColumn();
                        newItem.from(item, false, bDeepMode);
                        pssysbiaggcolumns.add(newItem);
                        continue;
                    }
                    pssysbiaggcolumns.add(item);
                }
                this.setPssysbiaggcolumns(pssysbiaggcolumns);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

