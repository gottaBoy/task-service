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
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEDQCond
extends PSModelBase {
    public static final String FIELD_CONDTYPE = "condtype";
    public static final String FIELD_CONDVALUE = "condvalue";
    public static final String FIELD_CONDVALUETEXT = "condvaluetext";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_CUSTOMTYPE = "customtype";
    public static final String FIELD_GROUPNOTFLAG = "groupnotflag";
    public static final String FIELD_GROUPOP = "groupop";
    public static final String FIELD_IGNOREEMPTY = "ignoreempty";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PPSDEDQCONDID = "ppsdedqcondid";
    public static final String FIELD_PPSDEDQCONDNAME = "ppsdedqcondname";
    public static final String FIELD_PSDBVALUEOPID = "psdbvalueopid";
    public static final String FIELD_PSDBVALUEOPNAME = "psdbvalueopname";
    public static final String FIELD_PSDEDQCONDID = "psdedqcondid";
    public static final String FIELD_PSDEDQCONDNAME = "psdedqcondname";
    public static final String FIELD_PSDEDQID = "psdedqid";
    public static final String FIELD_PSDEDQJOINID = "psdedqjoinid";
    public static final String FIELD_PSDEDQJOINNAME = "psdedqjoinname";
    public static final String FIELD_PSDEDQNAME = "psdedqname";
    public static final String FIELD_PSDEDQPDCONDID = "psdedqpdcondid";
    public static final String FIELD_PSDEDQPDCONDNAME = "psdedqpdcondname";
    public static final String FIELD_PSDEFID = "psdefid";
    public static final String FIELD_PSDEFNAME = "psdefname";
    public static final String FIELD_PSSYSDBVFID = "pssysdbvfid";
    public static final String FIELD_PSSYSDBVFNAME = "pssysdbvfname";
    public static final String FIELD_PSVARTYPEID = "psvartypeid";
    public static final String FIELD_PSVARTYPENAME = "psvartypename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDEDQCond> psdedqconds;

    @JsonIgnore
    public String getCondType() {
        Object objValue = this.get(FIELD_CONDTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condtype")
    public void setCondType(String condType) {
        this.set(FIELD_CONDTYPE, condType);
    }

    @JsonIgnore
    public boolean isCondTypeDirty() {
        return this.contains(FIELD_CONDTYPE);
    }

    @JsonIgnore
    public String getCondValue() {
        Object objValue = this.get(FIELD_CONDVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condvalue")
    public void setCondValue(String condValue) {
        this.set(FIELD_CONDVALUE, condValue);
    }

    @JsonIgnore
    public boolean isCondValueDirty() {
        return this.contains(FIELD_CONDVALUE);
    }

    @JsonIgnore
    public String getCondValueText() {
        Object objValue = this.get(FIELD_CONDVALUETEXT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="condvaluetext")
    public void setCondValueText(String condValueText) {
        this.set(FIELD_CONDVALUETEXT, condValueText);
    }

    @JsonIgnore
    public boolean isCondValueTextDirty() {
        return this.contains(FIELD_CONDVALUETEXT);
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
    public String getCustomType() {
        Object objValue = this.get(FIELD_CUSTOMTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="customtype")
    public void setCustomType(String customType) {
        this.set(FIELD_CUSTOMTYPE, customType);
    }

    @JsonIgnore
    public boolean isCustomTypeDirty() {
        return this.contains(FIELD_CUSTOMTYPE);
    }

    @JsonIgnore
    public Integer getGroupNotFlag() {
        Object objValue = this.get(FIELD_GROUPNOTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="groupnotflag")
    public void setGroupNotFlag(Integer groupNotFlag) {
        this.set(FIELD_GROUPNOTFLAG, groupNotFlag);
    }

    @JsonIgnore
    public boolean isGroupNotFlagDirty() {
        return this.contains(FIELD_GROUPNOTFLAG);
    }

    @JsonIgnore
    public String getGroupOP() {
        Object objValue = this.get(FIELD_GROUPOP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="groupop")
    public void setGroupOP(String groupOP) {
        this.set(FIELD_GROUPOP, groupOP);
    }

    @JsonIgnore
    public boolean isGroupOPDirty() {
        return this.contains(FIELD_GROUPOP);
    }

    @JsonIgnore
    public Integer getIgnoreEmpty() {
        Object objValue = this.get(FIELD_IGNOREEMPTY);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ignoreempty")
    public void setIgnoreEmpty(Integer ignoreEmpty) {
        this.set(FIELD_IGNOREEMPTY, ignoreEmpty);
    }

    @JsonIgnore
    public boolean isIgnoreEmptyDirty() {
        return this.contains(FIELD_IGNOREEMPTY);
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
    public String getPPSDEDQCondId() {
        Object objValue = this.get(FIELD_PPSDEDQCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdedqcondid")
    public void setPPSDEDQCondId(String pPSDEDQCondId) {
        this.set(FIELD_PPSDEDQCONDID, pPSDEDQCondId);
    }

    @JsonIgnore
    public boolean isPPSDEDQCondIdDirty() {
        return this.contains(FIELD_PPSDEDQCONDID);
    }

    @JsonIgnore
    public String getPPSDEDQCondName() {
        Object objValue = this.get(FIELD_PPSDEDQCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ppsdedqcondname")
    public void setPPSDEDQCondName(String pPSDEDQCondName) {
        this.set(FIELD_PPSDEDQCONDNAME, pPSDEDQCondName);
    }

    @JsonIgnore
    public boolean isPPSDEDQCondNameDirty() {
        return this.contains(FIELD_PPSDEDQCONDNAME);
    }

    @JsonIgnore
    public String getPSDBValueOPId() {
        Object objValue = this.get(FIELD_PSDBVALUEOPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopid")
    public void setPSDBValueOPId(String pSDBValueOPId) {
        this.set(FIELD_PSDBVALUEOPID, pSDBValueOPId);
    }

    @JsonIgnore
    public boolean isPSDBValueOPIdDirty() {
        return this.contains(FIELD_PSDBVALUEOPID);
    }

    @JsonIgnore
    public String getPSDBValueOPName() {
        Object objValue = this.get(FIELD_PSDBVALUEOPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdbvalueopname")
    public void setPSDBValueOPName(String pSDBValueOPName) {
        this.set(FIELD_PSDBVALUEOPNAME, pSDBValueOPName);
    }

    @JsonIgnore
    public boolean isPSDBValueOPNameDirty() {
        return this.contains(FIELD_PSDBVALUEOPNAME);
    }

    @JsonIgnore
    public String getPSDEDQCondId() {
        Object objValue = this.get(FIELD_PSDEDQCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcondid")
    public void setPSDEDQCondId(String pSDEDQCondId) {
        this.set(FIELD_PSDEDQCONDID, pSDEDQCondId);
    }

    @JsonIgnore
    public boolean isPSDEDQCondIdDirty() {
        return this.contains(FIELD_PSDEDQCONDID);
    }

    @JsonIgnore
    public String getPSDEDQCondName() {
        Object objValue = this.get(FIELD_PSDEDQCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqcondname")
    public void setPSDEDQCondName(String pSDEDQCondName) {
        this.set(FIELD_PSDEDQCONDNAME, pSDEDQCondName);
    }

    @JsonIgnore
    public boolean isPSDEDQCondNameDirty() {
        return this.contains(FIELD_PSDEDQCONDNAME);
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
    public String getPSDEDQPDCondId() {
        Object objValue = this.get(FIELD_PSDEDQPDCONDID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqpdcondid")
    public void setPSDEDQPDCondId(String pSDEDQPDCondId) {
        this.set(FIELD_PSDEDQPDCONDID, pSDEDQPDCondId);
    }

    @JsonIgnore
    public boolean isPSDEDQPDCondIdDirty() {
        return this.contains(FIELD_PSDEDQPDCONDID);
    }

    @JsonIgnore
    public String getPSDEDQPDCondName() {
        Object objValue = this.get(FIELD_PSDEDQPDCONDNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedqpdcondname")
    public void setPSDEDQPDCondName(String pSDEDQPDCondName) {
        this.set(FIELD_PSDEDQPDCONDNAME, pSDEDQPDCondName);
    }

    @JsonIgnore
    public boolean isPSDEDQPDCondNameDirty() {
        return this.contains(FIELD_PSDEDQPDCONDNAME);
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
    public String getPSSysDBVFId() {
        Object objValue = this.get(FIELD_PSSYSDBVFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbvfid")
    public void setPSSysDBVFId(String pSSysDBVFId) {
        this.set(FIELD_PSSYSDBVFID, pSSysDBVFId);
    }

    @JsonIgnore
    public boolean isPSSysDBVFIdDirty() {
        return this.contains(FIELD_PSSYSDBVFID);
    }

    @JsonIgnore
    public String getPSSysDBVFName() {
        Object objValue = this.get(FIELD_PSSYSDBVFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdbvfname")
    public void setPSSysDBVFName(String pSSysDBVFName) {
        this.set(FIELD_PSSYSDBVFNAME, pSSysDBVFName);
    }

    @JsonIgnore
    public boolean isPSSysDBVFNameDirty() {
        return this.contains(FIELD_PSSYSDBVFNAME);
    }

    @JsonIgnore
    public String getPSVARTypeId() {
        Object objValue = this.get(FIELD_PSVARTYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psvartypeid")
    public void setPSVARTypeId(String pSVARTypeId) {
        this.set(FIELD_PSVARTYPEID, pSVARTypeId);
    }

    @JsonIgnore
    public boolean isPSVARTypeIdDirty() {
        return this.contains(FIELD_PSVARTYPEID);
    }

    @JsonIgnore
    public String getPSVARTypeName() {
        Object objValue = this.get(FIELD_PSVARTYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psvartypename")
    public void setPSVARTypeName(String pSVARTypeName) {
        this.set(FIELD_PSVARTYPENAME, pSVARTypeName);
    }

    @JsonIgnore
    public boolean isPSVARTypeNameDirty() {
        return this.contains(FIELD_PSVARTYPENAME);
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
        return this.getPSDEDQCondId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEDQCondId(strValue);
    }

    public List<PSDEDQCond> getPsdedqconds() {
        return this.psdedqconds;
    }

    public void setPsdedqconds(List<PSDEDQCond> psdedqconds) {
        this.psdedqconds = psdedqconds;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdedqconds")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdedqconds")) {
            this.init();
            return this.psdedqconds;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEDQCOND";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEDQCond item = (PSDEDQCond)MAPPER.readValue(new File(strJsonFilePath), PSDEDQCond.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEDQCond) {
            PSDEDQCond dst = (PSDEDQCond)target;
            if (!bSimple && this.getPsdedqconds() != null) {
                ArrayList<PSDEDQCond> psdedqconds = new ArrayList<PSDEDQCond>();
                for (PSDEDQCond item : this.getPsdedqconds()) {
                    if (bDeepMode) {
                        PSDEDQCond newitem = new PSDEDQCond();
                        item.to(newitem, false, bDeepMode);
                        psdedqconds.add(newitem);
                        continue;
                    }
                    psdedqconds.add(item);
                }
                dst.setPsdedqconds(psdedqconds);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEDQCond) {
            PSDEDQCond src = (PSDEDQCond)source;
            if (!bSimple && src.getPsdedqconds() != null) {
                ArrayList<PSDEDQCond> psdedqconds = new ArrayList<PSDEDQCond>();
                for (PSDEDQCond item : src.getPsdedqconds()) {
                    if (bDeepMode) {
                        PSDEDQCond newItem = new PSDEDQCond();
                        newItem.from(item, false, bDeepMode);
                        psdedqconds.add(newItem);
                        continue;
                    }
                    psdedqconds.add(item);
                }
                this.setPsdedqconds(psdedqconds);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

