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
import net.ibizsys.modelapi.domain.PSSysEAIDataTypeItem;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysEAIDataType
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_EAIDATATYPETAG = "eaidatatypetag";
    public static final String FIELD_EAIDATATYPETAG2 = "eaidatatypetag2";
    public static final String FIELD_ENABLEENUM = "enableenum";
    public static final String FIELD_INCMAXVALUE = "incmaxvalue";
    public static final String FIELD_INCMINVALUE = "incminvalue";
    public static final String FIELD_MAXSTRLENGTH = "maxstrlength";
    public static final String FIELD_MAXVALUE = "maxvalue";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MINSTRLENGTH = "minstrlength";
    public static final String FIELD_MINVALUE = "minvalue";
    public static final String FIELD_PRECISION2 = "precision2";
    public static final String FIELD_PSSYSEAIDATATYPEID = "pssyseaidatatypeid";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "pssyseaidatatypename";
    public static final String FIELD_PSSYSEAISCHEMEID = "pssyseaischemeid";
    public static final String FIELD_PSSYSEAISCHEMENAME = "pssyseaischemename";
    public static final String FIELD_REGEXPCODE = "regexpcode";
    public static final String FIELD_STDDATATYPE = "stddatatype";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSSysEAIDataTypeItem> pssyseaidatatypeitems;

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
    public String getEAIDataTypeTag() {
        Object objValue = this.get(FIELD_EAIDATATYPETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidatatypetag")
    public void setEAIDataTypeTag(String eAIDataTypeTag) {
        this.set(FIELD_EAIDATATYPETAG, eAIDataTypeTag);
    }

    @JsonIgnore
    public boolean isEAIDataTypeTagDirty() {
        return this.contains(FIELD_EAIDATATYPETAG);
    }

    @JsonIgnore
    public String getEAIDataTypeTag2() {
        Object objValue = this.get(FIELD_EAIDATATYPETAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="eaidatatypetag2")
    public void setEAIDataTypeTag2(String eAIDataTypeTag2) {
        this.set(FIELD_EAIDATATYPETAG2, eAIDataTypeTag2);
    }

    @JsonIgnore
    public boolean isEAIDataTypeTag2Dirty() {
        return this.contains(FIELD_EAIDATATYPETAG2);
    }

    @JsonIgnore
    public Integer getEnableEnum() {
        Object objValue = this.get(FIELD_ENABLEENUM);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableenum")
    public void setEnableEnum(Integer enableEnum) {
        this.set(FIELD_ENABLEENUM, enableEnum);
    }

    @JsonIgnore
    public boolean isEnableEnumDirty() {
        return this.contains(FIELD_ENABLEENUM);
    }

    @JsonIgnore
    public Integer getIncMaxValue() {
        Object objValue = this.get(FIELD_INCMAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incmaxvalue")
    public void setIncMaxValue(Integer incMaxValue) {
        this.set(FIELD_INCMAXVALUE, incMaxValue);
    }

    @JsonIgnore
    public boolean isIncMaxValueDirty() {
        return this.contains(FIELD_INCMAXVALUE);
    }

    @JsonIgnore
    public Integer getIncMinValue() {
        Object objValue = this.get(FIELD_INCMINVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="incminvalue")
    public void setIncMinValue(Integer incMinValue) {
        this.set(FIELD_INCMINVALUE, incMinValue);
    }

    @JsonIgnore
    public boolean isIncMinValueDirty() {
        return this.contains(FIELD_INCMINVALUE);
    }

    @JsonIgnore
    public Integer getMaxStrLength() {
        Object objValue = this.get(FIELD_MAXSTRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="maxstrlength")
    public void setMaxStrLength(Integer maxStrLength) {
        this.set(FIELD_MAXSTRLENGTH, maxStrLength);
    }

    @JsonIgnore
    public boolean isMaxStrLengthDirty() {
        return this.contains(FIELD_MAXSTRLENGTH);
    }

    @JsonIgnore
    public String getMaxValue() {
        Object objValue = this.get(FIELD_MAXVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="maxvalue")
    public void setMaxValue(String maxValue) {
        this.set(FIELD_MAXVALUE, maxValue);
    }

    @JsonIgnore
    public boolean isMaxValueDirty() {
        return this.contains(FIELD_MAXVALUE);
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
    public Integer getMinStrLength() {
        Object objValue = this.get(FIELD_MINSTRLENGTH);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="minstrlength")
    public void setMinStrLength(Integer minStrLength) {
        this.set(FIELD_MINSTRLENGTH, minStrLength);
    }

    @JsonIgnore
    public boolean isMinStrLengthDirty() {
        return this.contains(FIELD_MINSTRLENGTH);
    }

    @JsonIgnore
    public String getMinValue() {
        Object objValue = this.get(FIELD_MINVALUE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="minvalue")
    public void setMinValue(String minValue) {
        this.set(FIELD_MINVALUE, minValue);
    }

    @JsonIgnore
    public boolean isMinValueDirty() {
        return this.contains(FIELD_MINVALUE);
    }

    @JsonIgnore
    public Integer getPrecision2() {
        Object objValue = this.get(FIELD_PRECISION2);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="precision2")
    public void setPrecision2(Integer precision2) {
        this.set(FIELD_PRECISION2, precision2);
    }

    @JsonIgnore
    public boolean isPrecision2Dirty() {
        return this.contains(FIELD_PRECISION2);
    }

    @JsonIgnore
    public String getPSSysEAIDataTypeId() {
        Object objValue = this.get(FIELD_PSSYSEAIDATATYPEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidatatypeid")
    public void setPSSysEAIDataTypeId(String pSSysEAIDataTypeId) {
        this.set(FIELD_PSSYSEAIDATATYPEID, pSSysEAIDataTypeId);
    }

    @JsonIgnore
    public boolean isPSSysEAIDataTypeIdDirty() {
        return this.contains(FIELD_PSSYSEAIDATATYPEID);
    }

    @JsonIgnore
    public String getPSSysEAIDataTypeName() {
        Object objValue = this.get(FIELD_PSSYSEAIDATATYPENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyseaidatatypename")
    public void setPSSysEAIDataTypeName(String pSSysEAIDataTypeName) {
        this.set(FIELD_PSSYSEAIDATATYPENAME, pSSysEAIDataTypeName);
    }

    @JsonIgnore
    public boolean isPSSysEAIDataTypeNameDirty() {
        return this.contains(FIELD_PSSYSEAIDATATYPENAME);
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
    public String getRegExpCode() {
        Object objValue = this.get(FIELD_REGEXPCODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="regexpcode")
    public void setRegExpCode(String regExpCode) {
        this.set(FIELD_REGEXPCODE, regExpCode);
    }

    @JsonIgnore
    public boolean isRegExpCodeDirty() {
        return this.contains(FIELD_REGEXPCODE);
    }

    @JsonIgnore
    public Integer getStdDataType() {
        Object objValue = this.get(FIELD_STDDATATYPE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="stddatatype")
    public void setStdDataType(Integer stdDataType) {
        this.set(FIELD_STDDATATYPE, stdDataType);
    }

    @JsonIgnore
    public boolean isStdDataTypeDirty() {
        return this.contains(FIELD_STDDATATYPE);
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
        return this.getPSSysEAIDataTypeId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysEAIDataTypeId(strValue);
    }

    public List<PSSysEAIDataTypeItem> getPssyseaidatatypeitems() {
        return this.pssyseaidatatypeitems;
    }

    public void setPssyseaidatatypeitems(List<PSSysEAIDataTypeItem> pssyseaidatatypeitems) {
        this.pssyseaidatatypeitems = pssyseaidatatypeitems;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssyseaidatatypeitems")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyseaidatatypeitems")) {
            this.init();
            return this.pssyseaidatatypeitems;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSEAIDATATYPE";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysEAIDataType item = (PSSysEAIDataType)MAPPER.readValue(new File(strJsonFilePath), PSSysEAIDataType.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysEAIDataType) {
            PSSysEAIDataType dst = (PSSysEAIDataType)target;
            if (!bSimple && this.getPssyseaidatatypeitems() != null) {
                ArrayList<PSSysEAIDataTypeItem> pssyseaidatatypeitems = new ArrayList<PSSysEAIDataTypeItem>();
                for (PSSysEAIDataTypeItem item : this.getPssyseaidatatypeitems()) {
                    if (bDeepMode) {
                        PSSysEAIDataTypeItem newitem = new PSSysEAIDataTypeItem();
                        item.to(newitem, false, bDeepMode);
                        pssyseaidatatypeitems.add(newitem);
                        continue;
                    }
                    pssyseaidatatypeitems.add(item);
                }
                dst.setPssyseaidatatypeitems(pssyseaidatatypeitems);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysEAIDataType) {
            PSSysEAIDataType src = (PSSysEAIDataType)source;
            if (!bSimple && src.getPssyseaidatatypeitems() != null) {
                ArrayList<PSSysEAIDataTypeItem> pssyseaidatatypeitems = new ArrayList<PSSysEAIDataTypeItem>();
                for (PSSysEAIDataTypeItem item : src.getPssyseaidatatypeitems()) {
                    if (bDeepMode) {
                        PSSysEAIDataTypeItem newItem = new PSSysEAIDataTypeItem();
                        newItem.from(item, false, bDeepMode);
                        pssyseaidatatypeitems.add(newItem);
                        continue;
                    }
                    pssyseaidatatypeitems.add(item);
                }
                this.setPssyseaidatatypeitems(pssyseaidatatypeitems);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

