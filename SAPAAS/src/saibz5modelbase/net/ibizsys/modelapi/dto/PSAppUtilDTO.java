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

public class PSAppUtilDTO
extends PSModelDTOBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSAPPUTILID = "psapputilid";
    public static final String FIELD_PSAPPUTILNAME = "psapputilname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSPFPLUGINID = "pssyspfpluginid";
    public static final String FIELD_PSSYSPFPLUGINNAME = "pssyspfpluginname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_UTILOBJ = "utilobj";
    public static final String FIELD_UTILPARAM = "utilparam";
    public static final String FIELD_UTILPARAM10 = "utilparam10";
    public static final String FIELD_UTILPARAM11 = "utilparam11";
    public static final String FIELD_UTILPARAM12 = "utilparam12";
    public static final String FIELD_UTILPARAM2 = "utilparam2";
    public static final String FIELD_UTILPARAM3 = "utilparam3";
    public static final String FIELD_UTILPARAM4 = "utilparam4";
    public static final String FIELD_UTILPARAM5 = "utilparam5";
    public static final String FIELD_UTILPARAM6 = "utilparam6";
    public static final String FIELD_UTILPARAM7 = "utilparam7";
    public static final String FIELD_UTILPARAM8 = "utilparam8";
    public static final String FIELD_UTILPARAM9 = "utilparam9";
    public static final String FIELD_UTILPARAMS = "utilparams";
    public static final String FIELD_UTILPSDE2ID = "utilpsde2id";
    public static final String FIELD_UTILPSDE2NAME = "utilpsde2name";
    public static final String FIELD_UTILPSDE3ID = "utilpsde3id";
    public static final String FIELD_UTILPSDE3NAME = "utilpsde3name";
    public static final String FIELD_UTILPSDE4ID = "utilpsde4id";
    public static final String FIELD_UTILPSDE4NAME = "utilpsde4name";
    public static final String FIELD_UTILPSDE5ID = "utilpsde5id";
    public static final String FIELD_UTILPSDE5NAME = "utilpsde5name";
    public static final String FIELD_UTILPSDE6ID = "utilpsde6id";
    public static final String FIELD_UTILPSDE6NAME = "utilpsde6name";
    public static final String FIELD_UTILPSDE7ID = "utilpsde7id";
    public static final String FIELD_UTILPSDE7NAME = "utilpsde7name";
    public static final String FIELD_UTILPSDE8ID = "utilpsde8id";
    public static final String FIELD_UTILPSDE8NAME = "utilpsde8name";
    public static final String FIELD_UTILPSDE9ID = "utilpsde9id";
    public static final String FIELD_UTILPSDE9NAME = "utilpsde9name";
    public static final String FIELD_UTILPSDEID = "utilpsdeid";
    public static final String FIELD_UTILPSDENAME = "utilpsdename";
    public static final String FIELD_UTILTAG = "utiltag";
    public static final String FIELD_UTILTYPE = "utiltype";
    public static final String FIELD_VALIDFLAG = "validflag";

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
    public String getPSAppUtilId() {
        Object objValue = this.get(FIELD_PSAPPUTILID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapputilid")
    public void setPSAppUtilId(String pSAppUtilId) {
        this.set(FIELD_PSAPPUTILID, pSAppUtilId);
    }

    @JsonIgnore
    public boolean isPSAppUtilIdDirty() {
        return this.contains(FIELD_PSAPPUTILID);
    }

    @JsonIgnore
    public String getPSAppUtilName() {
        Object objValue = this.get(FIELD_PSAPPUTILNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psapputilname")
    public void setPSAppUtilName(String pSAppUtilName) {
        this.set(FIELD_PSAPPUTILNAME, pSAppUtilName);
    }

    @JsonIgnore
    public boolean isPSAppUtilNameDirty() {
        return this.contains(FIELD_PSAPPUTILNAME);
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
    public String getPSSysDynaModelId() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelid")
    public void setPSSysDynaModelId(String pSSysDynaModelId) {
        this.set(FIELD_PSSYSDYNAMODELID, pSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelIdDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getPSSysDynaModelName() {
        Object objValue = this.get(FIELD_PSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysdynamodelname")
    public void setPSSysDynaModelName(String pSSysDynaModelName) {
        this.set(FIELD_PSSYSDYNAMODELNAME, pSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isPSSysDynaModelNameDirty() {
        return this.contains(FIELD_PSSYSDYNAMODELNAME);
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
    public String getUtilObj() {
        Object objValue = this.get(FIELD_UTILOBJ);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilobj")
    public void setUtilObj(String utilObj) {
        this.set(FIELD_UTILOBJ, utilObj);
    }

    @JsonIgnore
    public boolean isUtilObjDirty() {
        return this.contains(FIELD_UTILOBJ);
    }

    @JsonIgnore
    public String getUtilParam() {
        Object objValue = this.get(FIELD_UTILPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam")
    public void setUtilParam(String utilParam) {
        this.set(FIELD_UTILPARAM, utilParam);
    }

    @JsonIgnore
    public boolean isUtilParamDirty() {
        return this.contains(FIELD_UTILPARAM);
    }

    @JsonIgnore
    public Integer getUtilParam10() {
        Object objValue = this.get(FIELD_UTILPARAM10);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam10")
    public void setUtilParam10(Integer utilParam10) {
        this.set(FIELD_UTILPARAM10, utilParam10);
    }

    @JsonIgnore
    public boolean isUtilParam10Dirty() {
        return this.contains(FIELD_UTILPARAM10);
    }

    @JsonIgnore
    public String getUtilParam11() {
        Object objValue = this.get(FIELD_UTILPARAM11);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam11")
    public void setUtilParam11(String utilParam11) {
        this.set(FIELD_UTILPARAM11, utilParam11);
    }

    @JsonIgnore
    public boolean isUtilParam11Dirty() {
        return this.contains(FIELD_UTILPARAM11);
    }

    @JsonIgnore
    public String getUtilParam12() {
        Object objValue = this.get(FIELD_UTILPARAM12);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam12")
    public void setUtilParam12(String utilParam12) {
        this.set(FIELD_UTILPARAM12, utilParam12);
    }

    @JsonIgnore
    public boolean isUtilParam12Dirty() {
        return this.contains(FIELD_UTILPARAM12);
    }

    @JsonIgnore
    public String getUtilParam2() {
        Object objValue = this.get(FIELD_UTILPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam2")
    public void setUtilParam2(String utilParam2) {
        this.set(FIELD_UTILPARAM2, utilParam2);
    }

    @JsonIgnore
    public boolean isUtilParam2Dirty() {
        return this.contains(FIELD_UTILPARAM2);
    }

    @JsonIgnore
    public String getUtilParam3() {
        Object objValue = this.get(FIELD_UTILPARAM3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam3")
    public void setUtilParam3(String utilParam3) {
        this.set(FIELD_UTILPARAM3, utilParam3);
    }

    @JsonIgnore
    public boolean isUtilParam3Dirty() {
        return this.contains(FIELD_UTILPARAM3);
    }

    @JsonIgnore
    public String getUtilParam4() {
        Object objValue = this.get(FIELD_UTILPARAM4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparam4")
    public void setUtilParam4(String utilParam4) {
        this.set(FIELD_UTILPARAM4, utilParam4);
    }

    @JsonIgnore
    public boolean isUtilParam4Dirty() {
        return this.contains(FIELD_UTILPARAM4);
    }

    @JsonIgnore
    public Integer getUtilParam5() {
        Object objValue = this.get(FIELD_UTILPARAM5);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam5")
    public void setUtilParam5(Integer utilParam5) {
        this.set(FIELD_UTILPARAM5, utilParam5);
    }

    @JsonIgnore
    public boolean isUtilParam5Dirty() {
        return this.contains(FIELD_UTILPARAM5);
    }

    @JsonIgnore
    public Integer getUtilParam6() {
        Object objValue = this.get(FIELD_UTILPARAM6);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam6")
    public void setUtilParam6(Integer utilParam6) {
        this.set(FIELD_UTILPARAM6, utilParam6);
    }

    @JsonIgnore
    public boolean isUtilParam6Dirty() {
        return this.contains(FIELD_UTILPARAM6);
    }

    @JsonIgnore
    public Integer getUtilParam7() {
        Object objValue = this.get(FIELD_UTILPARAM7);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam7")
    public void setUtilParam7(Integer utilParam7) {
        this.set(FIELD_UTILPARAM7, utilParam7);
    }

    @JsonIgnore
    public boolean isUtilParam7Dirty() {
        return this.contains(FIELD_UTILPARAM7);
    }

    @JsonIgnore
    public Integer getUtilParam8() {
        Object objValue = this.get(FIELD_UTILPARAM8);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam8")
    public void setUtilParam8(Integer utilParam8) {
        this.set(FIELD_UTILPARAM8, utilParam8);
    }

    @JsonIgnore
    public boolean isUtilParam8Dirty() {
        return this.contains(FIELD_UTILPARAM8);
    }

    @JsonIgnore
    public Integer getUtilParam9() {
        Object objValue = this.get(FIELD_UTILPARAM9);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="utilparam9")
    public void setUtilParam9(Integer utilParam9) {
        this.set(FIELD_UTILPARAM9, utilParam9);
    }

    @JsonIgnore
    public boolean isUtilParam9Dirty() {
        return this.contains(FIELD_UTILPARAM9);
    }

    @JsonIgnore
    public String getUtilParams() {
        Object objValue = this.get(FIELD_UTILPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilparams")
    public void setUtilParams(String utilParams) {
        this.set(FIELD_UTILPARAMS, utilParams);
    }

    @JsonIgnore
    public boolean isUtilParamsDirty() {
        return this.contains(FIELD_UTILPARAMS);
    }

    @JsonIgnore
    public String getUtilPSDE2Id() {
        Object objValue = this.get(FIELD_UTILPSDE2ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde2id")
    public void setUtilPSDE2Id(String utilPSDE2Id) {
        this.set(FIELD_UTILPSDE2ID, utilPSDE2Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE2IdDirty() {
        return this.contains(FIELD_UTILPSDE2ID);
    }

    @JsonIgnore
    public String getUtilPSDE2Name() {
        Object objValue = this.get(FIELD_UTILPSDE2NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde2name")
    public void setUtilPSDE2Name(String utilPSDE2Name) {
        this.set(FIELD_UTILPSDE2NAME, utilPSDE2Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE2NameDirty() {
        return this.contains(FIELD_UTILPSDE2NAME);
    }

    @JsonIgnore
    public String getUtilPSDE3Id() {
        Object objValue = this.get(FIELD_UTILPSDE3ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde3id")
    public void setUtilPSDE3Id(String utilPSDE3Id) {
        this.set(FIELD_UTILPSDE3ID, utilPSDE3Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE3IdDirty() {
        return this.contains(FIELD_UTILPSDE3ID);
    }

    @JsonIgnore
    public String getUtilPSDE3Name() {
        Object objValue = this.get(FIELD_UTILPSDE3NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde3name")
    public void setUtilPSDE3Name(String utilPSDE3Name) {
        this.set(FIELD_UTILPSDE3NAME, utilPSDE3Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE3NameDirty() {
        return this.contains(FIELD_UTILPSDE3NAME);
    }

    @JsonIgnore
    public String getUtilPSDE4Id() {
        Object objValue = this.get(FIELD_UTILPSDE4ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde4id")
    public void setUtilPSDE4Id(String utilPSDE4Id) {
        this.set(FIELD_UTILPSDE4ID, utilPSDE4Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE4IdDirty() {
        return this.contains(FIELD_UTILPSDE4ID);
    }

    @JsonIgnore
    public String getUtilPSDE4Name() {
        Object objValue = this.get(FIELD_UTILPSDE4NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde4name")
    public void setUtilPSDE4Name(String utilPSDE4Name) {
        this.set(FIELD_UTILPSDE4NAME, utilPSDE4Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE4NameDirty() {
        return this.contains(FIELD_UTILPSDE4NAME);
    }

    @JsonIgnore
    public String getUtilPSDE5Id() {
        Object objValue = this.get(FIELD_UTILPSDE5ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde5id")
    public void setUtilPSDE5Id(String utilPSDE5Id) {
        this.set(FIELD_UTILPSDE5ID, utilPSDE5Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE5IdDirty() {
        return this.contains(FIELD_UTILPSDE5ID);
    }

    @JsonIgnore
    public String getUtilPSDE5Name() {
        Object objValue = this.get(FIELD_UTILPSDE5NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde5name")
    public void setUtilPSDE5Name(String utilPSDE5Name) {
        this.set(FIELD_UTILPSDE5NAME, utilPSDE5Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE5NameDirty() {
        return this.contains(FIELD_UTILPSDE5NAME);
    }

    @JsonIgnore
    public String getUtilPSDE6Id() {
        Object objValue = this.get(FIELD_UTILPSDE6ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde6id")
    public void setUtilPSDE6Id(String utilPSDE6Id) {
        this.set(FIELD_UTILPSDE6ID, utilPSDE6Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE6IdDirty() {
        return this.contains(FIELD_UTILPSDE6ID);
    }

    @JsonIgnore
    public String getUtilPSDE6Name() {
        Object objValue = this.get(FIELD_UTILPSDE6NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde6name")
    public void setUtilPSDE6Name(String utilPSDE6Name) {
        this.set(FIELD_UTILPSDE6NAME, utilPSDE6Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE6NameDirty() {
        return this.contains(FIELD_UTILPSDE6NAME);
    }

    @JsonIgnore
    public String getUtilPSDE7Id() {
        Object objValue = this.get(FIELD_UTILPSDE7ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde7id")
    public void setUtilPSDE7Id(String utilPSDE7Id) {
        this.set(FIELD_UTILPSDE7ID, utilPSDE7Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE7IdDirty() {
        return this.contains(FIELD_UTILPSDE7ID);
    }

    @JsonIgnore
    public String getUtilPSDE7Name() {
        Object objValue = this.get(FIELD_UTILPSDE7NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde7name")
    public void setUtilPSDE7Name(String utilPSDE7Name) {
        this.set(FIELD_UTILPSDE7NAME, utilPSDE7Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE7NameDirty() {
        return this.contains(FIELD_UTILPSDE7NAME);
    }

    @JsonIgnore
    public String getUtilPSDE8Id() {
        Object objValue = this.get(FIELD_UTILPSDE8ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde8id")
    public void setUtilPSDE8Id(String utilPSDE8Id) {
        this.set(FIELD_UTILPSDE8ID, utilPSDE8Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE8IdDirty() {
        return this.contains(FIELD_UTILPSDE8ID);
    }

    @JsonIgnore
    public String getUtilPSDE8Name() {
        Object objValue = this.get(FIELD_UTILPSDE8NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde8name")
    public void setUtilPSDE8Name(String utilPSDE8Name) {
        this.set(FIELD_UTILPSDE8NAME, utilPSDE8Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE8NameDirty() {
        return this.contains(FIELD_UTILPSDE8NAME);
    }

    @JsonIgnore
    public String getUtilPSDE9Id() {
        Object objValue = this.get(FIELD_UTILPSDE9ID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde9id")
    public void setUtilPSDE9Id(String utilPSDE9Id) {
        this.set(FIELD_UTILPSDE9ID, utilPSDE9Id);
    }

    @JsonIgnore
    public boolean isUtilPSDE9IdDirty() {
        return this.contains(FIELD_UTILPSDE9ID);
    }

    @JsonIgnore
    public String getUtilPSDE9Name() {
        Object objValue = this.get(FIELD_UTILPSDE9NAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsde9name")
    public void setUtilPSDE9Name(String utilPSDE9Name) {
        this.set(FIELD_UTILPSDE9NAME, utilPSDE9Name);
    }

    @JsonIgnore
    public boolean isUtilPSDE9NameDirty() {
        return this.contains(FIELD_UTILPSDE9NAME);
    }

    @JsonIgnore
    public String getUtilPSDEId() {
        Object objValue = this.get(FIELD_UTILPSDEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdeid")
    public void setUtilPSDEId(String utilPSDEId) {
        this.set(FIELD_UTILPSDEID, utilPSDEId);
    }

    @JsonIgnore
    public boolean isUtilPSDEIdDirty() {
        return this.contains(FIELD_UTILPSDEID);
    }

    @JsonIgnore
    public String getUtilPSDEName() {
        Object objValue = this.get(FIELD_UTILPSDENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utilpsdename")
    public void setUtilPSDEName(String utilPSDEName) {
        this.set(FIELD_UTILPSDENAME, utilPSDEName);
    }

    @JsonIgnore
    public boolean isUtilPSDENameDirty() {
        return this.contains(FIELD_UTILPSDENAME);
    }

    @JsonIgnore
    public String getUtilTag() {
        Object objValue = this.get(FIELD_UTILTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltag")
    public void setUtilTag(String utilTag) {
        this.set(FIELD_UTILTAG, utilTag);
    }

    @JsonIgnore
    public boolean isUtilTagDirty() {
        return this.contains(FIELD_UTILTAG);
    }

    @JsonIgnore
    public String getUtilType() {
        Object objValue = this.get(FIELD_UTILTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="utiltype")
    public void setUtilType(String utilType) {
        this.set(FIELD_UTILTYPE, utilType);
    }

    @JsonIgnore
    public boolean isUtilTypeDirty() {
        return this.contains(FIELD_UTILTYPE);
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
        return this.getPSAppUtilId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSAppUtilId(strValue);
    }
}

