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

public class PSDENotifyTarget
extends PSModelBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_FILTER = "filter";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENOTIFYID = "psdenotifyid";
    public static final String FIELD_PSDENOTIFYNAME = "psdenotifyname";
    public static final String FIELD_PSDENOTIFYTARGETID = "psdenotifytargetid";
    public static final String FIELD_PSDENOTIFYTARGETNAME = "psdenotifytargetname";
    public static final String FIELD_PSSYSMSGTARGETID = "pssysmsgtargetid";
    public static final String FIELD_PSSYSMSGTARGETNAME = "pssysmsgtargetname";
    public static final String FIELD_TARGETPSDEFID = "targetpsdefid";
    public static final String FIELD_TARGETPSDEFNAME = "targetpsdefname";
    public static final String FIELD_TARGETTYPE = "targettype";
    public static final String FIELD_TARGETTYPEPSDEFID = "targettypepsdefid";
    public static final String FIELD_TARGETTYPEPSDEFNAME = "targettypepsdefname";
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
    public String getFilter() {
        Object objValue = this.get(FIELD_FILTER);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="filter")
    public void setFilter(String filter) {
        this.set(FIELD_FILTER, filter);
    }

    @JsonIgnore
    public boolean isFilterDirty() {
        return this.contains(FIELD_FILTER);
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
    public String getPSDENotifyId() {
        Object objValue = this.get(FIELD_PSDENOTIFYID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyid")
    public void setPSDENotifyId(String pSDENotifyId) {
        this.set(FIELD_PSDENOTIFYID, pSDENotifyId);
    }

    @JsonIgnore
    public boolean isPSDENotifyIdDirty() {
        return this.contains(FIELD_PSDENOTIFYID);
    }

    @JsonIgnore
    public String getPSDENotifyName() {
        Object objValue = this.get(FIELD_PSDENOTIFYNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifyname")
    public void setPSDENotifyName(String pSDENotifyName) {
        this.set(FIELD_PSDENOTIFYNAME, pSDENotifyName);
    }

    @JsonIgnore
    public boolean isPSDENotifyNameDirty() {
        return this.contains(FIELD_PSDENOTIFYNAME);
    }

    @JsonIgnore
    public String getPSDENotifyTargetId() {
        Object objValue = this.get(FIELD_PSDENOTIFYTARGETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifytargetid")
    public void setPSDENotifyTargetId(String pSDENotifyTargetId) {
        this.set(FIELD_PSDENOTIFYTARGETID, pSDENotifyTargetId);
    }

    @JsonIgnore
    public boolean isPSDENotifyTargetIdDirty() {
        return this.contains(FIELD_PSDENOTIFYTARGETID);
    }

    @JsonIgnore
    public String getPSDENotifyTargetName() {
        Object objValue = this.get(FIELD_PSDENOTIFYTARGETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdenotifytargetname")
    public void setPSDENotifyTargetName(String pSDENotifyTargetName) {
        this.set(FIELD_PSDENOTIFYTARGETNAME, pSDENotifyTargetName);
    }

    @JsonIgnore
    public boolean isPSDENotifyTargetNameDirty() {
        return this.contains(FIELD_PSDENOTIFYTARGETNAME);
    }

    @JsonIgnore
    public String getPSSysMsgTargetId() {
        Object objValue = this.get(FIELD_PSSYSMSGTARGETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtargetid")
    public void setPSSysMsgTargetId(String pSSysMsgTargetId) {
        this.set(FIELD_PSSYSMSGTARGETID, pSSysMsgTargetId);
    }

    @JsonIgnore
    public boolean isPSSysMsgTargetIdDirty() {
        return this.contains(FIELD_PSSYSMSGTARGETID);
    }

    @JsonIgnore
    public String getPSSysMsgTargetName() {
        Object objValue = this.get(FIELD_PSSYSMSGTARGETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtargetname")
    public void setPSSysMsgTargetName(String pSSysMsgTargetName) {
        this.set(FIELD_PSSYSMSGTARGETNAME, pSSysMsgTargetName);
    }

    @JsonIgnore
    public boolean isPSSysMsgTargetNameDirty() {
        return this.contains(FIELD_PSSYSMSGTARGETNAME);
    }

    @JsonIgnore
    public String getTargetPSDEFId() {
        Object objValue = this.get(FIELD_TARGETPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetpsdefid")
    public void setTargetPSDEFId(String targetPSDEFId) {
        this.set(FIELD_TARGETPSDEFID, targetPSDEFId);
    }

    @JsonIgnore
    public boolean isTargetPSDEFIdDirty() {
        return this.contains(FIELD_TARGETPSDEFID);
    }

    @JsonIgnore
    public String getTargetPSDEFName() {
        Object objValue = this.get(FIELD_TARGETPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targetpsdefname")
    public void setTargetPSDEFName(String targetPSDEFName) {
        this.set(FIELD_TARGETPSDEFNAME, targetPSDEFName);
    }

    @JsonIgnore
    public boolean isTargetPSDEFNameDirty() {
        return this.contains(FIELD_TARGETPSDEFNAME);
    }

    @JsonIgnore
    public String getTargetType() {
        Object objValue = this.get(FIELD_TARGETTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettype")
    public void setTargetType(String targetType) {
        this.set(FIELD_TARGETTYPE, targetType);
    }

    @JsonIgnore
    public boolean isTargetTypeDirty() {
        return this.contains(FIELD_TARGETTYPE);
    }

    @JsonIgnore
    public String getTargetTypePSDEFId() {
        Object objValue = this.get(FIELD_TARGETTYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettypepsdefid")
    public void setTargetTypePSDEFId(String targetTypePSDEFId) {
        this.set(FIELD_TARGETTYPEPSDEFID, targetTypePSDEFId);
    }

    @JsonIgnore
    public boolean isTargetTypePSDEFIdDirty() {
        return this.contains(FIELD_TARGETTYPEPSDEFID);
    }

    @JsonIgnore
    public String getTargetTypePSDEFName() {
        Object objValue = this.get(FIELD_TARGETTYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="targettypepsdefname")
    public void setTargetTypePSDEFName(String targetTypePSDEFName) {
        this.set(FIELD_TARGETTYPEPSDEFNAME, targetTypePSDEFName);
    }

    @JsonIgnore
    public boolean isTargetTypePSDEFNameDirty() {
        return this.contains(FIELD_TARGETTYPEPSDEFNAME);
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
        return this.getPSDENotifyTargetId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDENotifyTargetId(strValue);
    }

    @Override
    public String getSrfType() {
        return "PSDENOTIFYTARGET";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDENotifyTarget item = (PSDENotifyTarget)MAPPER.readValue(new File(strJsonFilePath), PSDENotifyTarget.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDENotifyTarget) {
            PSDENotifyTarget pSDENotifyTarget = (PSDENotifyTarget)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDENotifyTarget) {
            PSDENotifyTarget pSDENotifyTarget = (PSDENotifyTarget)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

