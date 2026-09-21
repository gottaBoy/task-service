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
import net.ibizsys.modelapi.domain.PSDEFGroupDetail;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSDEFGroup
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CODENAME2 = "codename2";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DTOCODENAME = "dtocodename";
    public static final String FIELD_GROUPTAG = "grouptag";
    public static final String FIELD_GROUPTAG2 = "grouptag2";
    public static final String FIELD_GROUPTYPE = "grouptype";
    public static final String FIELD_INITPSSYSDYNAMODELID = "initpssysdynamodelid";
    public static final String FIELD_INITPSSYSDYNAMODELNAME = "initpssysdynamodelname";
    public static final String FIELD_LOGICMODE = "logicmode";
    public static final String FIELD_LOGICPARAM = "logicparam";
    public static final String FIELD_LOGICPARAM2 = "logicparam2";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDEFGROUPID = "psdefgroupid";
    public static final String FIELD_PSDEFGROUPNAME = "psdefgroupname";
    public static final String FIELD_PSDEFORMID = "psdeformid";
    public static final String FIELD_PSDEFORMNAME = "psdeformname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEVRGROUPID = "psdevrgroupid";
    public static final String FIELD_PSDEVRGROUPNAME = "psdevrgroupname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDEFGroupDetail> psdefgroupdetails;

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
    public String getCodeName2() {
        Object objValue = this.get(FIELD_CODENAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="codename2")
    public void setCodeName2(String codeName2) {
        this.set(FIELD_CODENAME2, codeName2);
    }

    @JsonIgnore
    public boolean isCodeName2Dirty() {
        return this.contains(FIELD_CODENAME2);
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
    public String getDTOCodeName() {
        Object objValue = this.get(FIELD_DTOCODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dtocodename")
    public void setDTOCodeName(String dTOCodeName) {
        this.set(FIELD_DTOCODENAME, dTOCodeName);
    }

    @JsonIgnore
    public boolean isDTOCodeNameDirty() {
        return this.contains(FIELD_DTOCODENAME);
    }

    @JsonIgnore
    public String getGroupTag() {
        Object objValue = this.get(FIELD_GROUPTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag")
    public void setGroupTag(String groupTag) {
        this.set(FIELD_GROUPTAG, groupTag);
    }

    @JsonIgnore
    public boolean isGroupTagDirty() {
        return this.contains(FIELD_GROUPTAG);
    }

    @JsonIgnore
    public String getGroupTag2() {
        Object objValue = this.get(FIELD_GROUPTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptag2")
    public void setGroupTag2(String groupTag2) {
        this.set(FIELD_GROUPTAG2, groupTag2);
    }

    @JsonIgnore
    public boolean isGroupTag2Dirty() {
        return this.contains(FIELD_GROUPTAG2);
    }

    @JsonIgnore
    public String getGroupType() {
        Object objValue = this.get(FIELD_GROUPTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouptype")
    public void setGroupType(String groupType) {
        this.set(FIELD_GROUPTYPE, groupType);
    }

    @JsonIgnore
    public boolean isGroupTypeDirty() {
        return this.contains(FIELD_GROUPTYPE);
    }

    @JsonIgnore
    public String getInitPSSysDynaModelId() {
        Object objValue = this.get(FIELD_INITPSSYSDYNAMODELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpssysdynamodelid")
    public void setInitPSSysDynaModelId(String initPSSysDynaModelId) {
        this.set(FIELD_INITPSSYSDYNAMODELID, initPSSysDynaModelId);
    }

    @JsonIgnore
    public boolean isInitPSSysDynaModelIdDirty() {
        return this.contains(FIELD_INITPSSYSDYNAMODELID);
    }

    @JsonIgnore
    public String getInitPSSysDynaModelName() {
        Object objValue = this.get(FIELD_INITPSSYSDYNAMODELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="initpssysdynamodelname")
    public void setInitPSSysDynaModelName(String initPSSysDynaModelName) {
        this.set(FIELD_INITPSSYSDYNAMODELNAME, initPSSysDynaModelName);
    }

    @JsonIgnore
    public boolean isInitPSSysDynaModelNameDirty() {
        return this.contains(FIELD_INITPSSYSDYNAMODELNAME);
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
    public String getLogicParam() {
        Object objValue = this.get(FIELD_LOGICPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicparam")
    public void setLogicParam(String logicParam) {
        this.set(FIELD_LOGICPARAM, logicParam);
    }

    @JsonIgnore
    public boolean isLogicParamDirty() {
        return this.contains(FIELD_LOGICPARAM);
    }

    @JsonIgnore
    public String getLogicParam2() {
        Object objValue = this.get(FIELD_LOGICPARAM2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="logicparam2")
    public void setLogicParam2(String logicParam2) {
        this.set(FIELD_LOGICPARAM2, logicParam2);
    }

    @JsonIgnore
    public boolean isLogicParam2Dirty() {
        return this.contains(FIELD_LOGICPARAM2);
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
    public String getPSDEFGroupId() {
        Object objValue = this.get(FIELD_PSDEFGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupid")
    public void setPSDEFGroupId(String pSDEFGroupId) {
        this.set(FIELD_PSDEFGROUPID, pSDEFGroupId);
    }

    @JsonIgnore
    public boolean isPSDEFGroupIdDirty() {
        return this.contains(FIELD_PSDEFGROUPID);
    }

    @JsonIgnore
    public String getPSDEFGroupName() {
        Object objValue = this.get(FIELD_PSDEFGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdefgroupname")
    public void setPSDEFGroupName(String pSDEFGroupName) {
        this.set(FIELD_PSDEFGROUPNAME, pSDEFGroupName);
    }

    @JsonIgnore
    public boolean isPSDEFGroupNameDirty() {
        return this.contains(FIELD_PSDEFGROUPNAME);
    }

    @JsonIgnore
    public String getPSDEFormId() {
        Object objValue = this.get(FIELD_PSDEFORMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformid")
    public void setPSDEFormId(String pSDEFormId) {
        this.set(FIELD_PSDEFORMID, pSDEFormId);
    }

    @JsonIgnore
    public boolean isPSDEFormIdDirty() {
        return this.contains(FIELD_PSDEFORMID);
    }

    @JsonIgnore
    public String getPSDEFormName() {
        Object objValue = this.get(FIELD_PSDEFORMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeformname")
    public void setPSDEFormName(String pSDEFormName) {
        this.set(FIELD_PSDEFORMNAME, pSDEFormName);
    }

    @JsonIgnore
    public boolean isPSDEFormNameDirty() {
        return this.contains(FIELD_PSDEFORMNAME);
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
    public String getPSDEVRGroupId() {
        Object objValue = this.get(FIELD_PSDEVRGROUPID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevrgroupid")
    public void setPSDEVRGroupId(String pSDEVRGroupId) {
        this.set(FIELD_PSDEVRGROUPID, pSDEVRGroupId);
    }

    @JsonIgnore
    public boolean isPSDEVRGroupIdDirty() {
        return this.contains(FIELD_PSDEVRGROUPID);
    }

    @JsonIgnore
    public String getPSDEVRGroupName() {
        Object objValue = this.get(FIELD_PSDEVRGROUPNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdevrgroupname")
    public void setPSDEVRGroupName(String pSDEVRGroupName) {
        this.set(FIELD_PSDEVRGROUPNAME, pSDEVRGroupName);
    }

    @JsonIgnore
    public boolean isPSDEVRGroupNameDirty() {
        return this.contains(FIELD_PSDEVRGROUPNAME);
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
        return this.getPSDEFGroupId();
    }

    public void setSrfkey(String strValue) {
        this.setPSDEFGroupId(strValue);
    }

    public List<PSDEFGroupDetail> getPsdefgroupdetails() {
        return this.psdefgroupdetails;
    }

    public void setPsdefgroupdetails(List<PSDEFGroupDetail> psdefgroupdetails) {
        this.psdefgroupdetails = psdefgroupdetails;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("psdefgroupdetails")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("psdefgroupdetails")) {
            this.init();
            return this.psdefgroupdetails;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSDEFGROUP";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSDEFGroup item = (PSDEFGroup)MAPPER.readValue(new File(strJsonFilePath), PSDEFGroup.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSDEFGroup) {
            PSDEFGroup dst = (PSDEFGroup)target;
            if (!bSimple && this.getPsdefgroupdetails() != null) {
                ArrayList<PSDEFGroupDetail> psdefgroupdetails = new ArrayList<PSDEFGroupDetail>();
                for (PSDEFGroupDetail item : this.getPsdefgroupdetails()) {
                    if (bDeepMode) {
                        PSDEFGroupDetail newitem = new PSDEFGroupDetail();
                        item.to(newitem, false, bDeepMode);
                        psdefgroupdetails.add(newitem);
                        continue;
                    }
                    psdefgroupdetails.add(item);
                }
                dst.setPsdefgroupdetails(psdefgroupdetails);
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSDEFGroup) {
            PSDEFGroup src = (PSDEFGroup)source;
            if (!bSimple && src.getPsdefgroupdetails() != null) {
                ArrayList<PSDEFGroupDetail> psdefgroupdetails = new ArrayList<PSDEFGroupDetail>();
                for (PSDEFGroupDetail item : src.getPsdefgroupdetails()) {
                    if (bDeepMode) {
                        PSDEFGroupDetail newItem = new PSDEFGroupDetail();
                        newItem.from(item, false, bDeepMode);
                        psdefgroupdetails.add(newItem);
                        continue;
                    }
                    psdefgroupdetails.add(item);
                }
                this.setPsdefgroupdetails(psdefgroupdetails);
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

