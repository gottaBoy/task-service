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
import net.ibizsys.modelapi.domain.PSDEOPPrivRole;
import net.ibizsys.modelapi.domain.PSSysUserRoleData;
import net.ibizsys.modelapi.domain.PSSysUserRoleRes;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysOPPriv
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEFAULTMODE = "defaultmode";
    public static final String FIELD_GLOBALFLAG = "globalflag";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PRIVID = "privid";
    public static final String FIELD_PRIVTYPE = "privtype";
    public static final String FIELD_PSDEDATASETID = "psdedatasetid";
    public static final String FIELD_PSDEDATASETNAME = "psdedatasetname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSOPPRIVID = "pssysopprivid";
    public static final String FIELD_PSSYSOPPRIVNAME = "pssysopprivname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_SYSTEMFLAG = "systemflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERIDPSDEFID = "useridpsdefid";
    public static final String FIELD_USERIDPSDEFNAME = "useridpsdefname";
    public static final String FIELD_USERROLESN = "userrolesn";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSSysUserRoleRes> pssysuserroleres;
    private List<PSDEOPPrivRole> psdeopprivroles;
    private List<PSSysUserRoleData> pssysuserroledata;

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
    public String getDefaultMode() {
        Object objValue = this.get(FIELD_DEFAULTMODE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="defaultmode")
    public void setDefaultMode(String defaultMode) {
        this.set(FIELD_DEFAULTMODE, defaultMode);
    }

    @JsonIgnore
    public boolean isDefaultModeDirty() {
        return this.contains(FIELD_DEFAULTMODE);
    }

    @JsonIgnore
    public Integer getGlobalFlag() {
        Object objValue = this.get(FIELD_GLOBALFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="globalflag")
    public void setGlobalFlag(Integer globalFlag) {
        this.set(FIELD_GLOBALFLAG, globalFlag);
    }

    @JsonIgnore
    public boolean isGlobalFlagDirty() {
        return this.contains(FIELD_GLOBALFLAG);
    }

    @JsonIgnore
    public Integer getLockFlag() {
        Object objValue = this.get(FIELD_LOCKFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="lockflag")
    public void setLockFlag(Integer lockFlag) {
        this.set(FIELD_LOCKFLAG, lockFlag);
    }

    @JsonIgnore
    public boolean isLockFlagDirty() {
        return this.contains(FIELD_LOCKFLAG);
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
    public String getPrivId() {
        Object objValue = this.get(FIELD_PRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="privid")
    public void setPrivId(String privId) {
        this.set(FIELD_PRIVID, privId);
    }

    @JsonIgnore
    public boolean isPrivIdDirty() {
        return this.contains(FIELD_PRIVID);
    }

    @JsonIgnore
    public String getPrivType() {
        Object objValue = this.get(FIELD_PRIVTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="privtype")
    public void setPrivType(String privType) {
        this.set(FIELD_PRIVTYPE, privType);
    }

    @JsonIgnore
    public boolean isPrivTypeDirty() {
        return this.contains(FIELD_PRIVTYPE);
    }

    @JsonIgnore
    public String getPSDEDataSetId() {
        Object objValue = this.get(FIELD_PSDEDATASETID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetid")
    public void setPSDEDataSetId(String pSDEDataSetId) {
        this.set(FIELD_PSDEDATASETID, pSDEDataSetId);
    }

    @JsonIgnore
    public boolean isPSDEDataSetIdDirty() {
        return this.contains(FIELD_PSDEDATASETID);
    }

    @JsonIgnore
    public String getPSDEDataSetName() {
        Object objValue = this.get(FIELD_PSDEDATASETNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedatasetname")
    public void setPSDEDataSetName(String pSDEDataSetName) {
        this.set(FIELD_PSDEDATASETNAME, pSDEDataSetName);
    }

    @JsonIgnore
    public boolean isPSDEDataSetNameDirty() {
        return this.contains(FIELD_PSDEDATASETNAME);
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
    public String getPSModuleId() {
        Object objValue = this.get(FIELD_PSMODULEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmoduleid")
    public void setPSModuleId(String pSModuleId) {
        this.set(FIELD_PSMODULEID, pSModuleId);
    }

    @JsonIgnore
    public boolean isPSModuleIdDirty() {
        return this.contains(FIELD_PSMODULEID);
    }

    @JsonIgnore
    public String getPSModuleName() {
        Object objValue = this.get(FIELD_PSMODULENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmodulename")
    public void setPSModuleName(String pSModuleName) {
        this.set(FIELD_PSMODULENAME, pSModuleName);
    }

    @JsonIgnore
    public boolean isPSModuleNameDirty() {
        return this.contains(FIELD_PSMODULENAME);
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
    public String getPSSysOPPrivId() {
        Object objValue = this.get(FIELD_PSSYSOPPRIVID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysopprivid")
    public void setPSSysOPPrivId(String pSSysOPPrivId) {
        this.set(FIELD_PSSYSOPPRIVID, pSSysOPPrivId);
    }

    @JsonIgnore
    public boolean isPSSysOPPrivIdDirty() {
        return this.contains(FIELD_PSSYSOPPRIVID);
    }

    @JsonIgnore
    public String getPSSysOPPrivName() {
        Object objValue = this.get(FIELD_PSSYSOPPRIVNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysopprivname")
    public void setPSSysOPPrivName(String pSSysOPPrivName) {
        this.set(FIELD_PSSYSOPPRIVNAME, pSSysOPPrivName);
    }

    @JsonIgnore
    public boolean isPSSysOPPrivNameDirty() {
        return this.contains(FIELD_PSSYSOPPRIVNAME);
    }

    @JsonIgnore
    public String getPSSysSFPluginId() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginid")
    public void setPSSysSFPluginId(String pSSysSFPluginId) {
        this.set(FIELD_PSSYSSFPLUGINID, pSSysSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginIdDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSysSFPluginName() {
        Object objValue = this.get(FIELD_PSSYSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyssfpluginname")
    public void setPSSysSFPluginName(String pSSysSFPluginName) {
        this.set(FIELD_PSSYSSFPLUGINNAME, pSSysSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSysSFPluginNameDirty() {
        return this.contains(FIELD_PSSYSSFPLUGINNAME);
    }

    @JsonIgnore
    public String getPSSystemId() {
        Object objValue = this.get(FIELD_PSSYSTEMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemid")
    public void setPSSystemId(String pSSystemId) {
        this.set(FIELD_PSSYSTEMID, pSSystemId);
    }

    @JsonIgnore
    public boolean isPSSystemIdDirty() {
        return this.contains(FIELD_PSSYSTEMID);
    }

    @JsonIgnore
    public String getPSSystemName() {
        Object objValue = this.get(FIELD_PSSYSTEMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssystemname")
    public void setPSSystemName(String pSSystemName) {
        this.set(FIELD_PSSYSTEMNAME, pSSystemName);
    }

    @JsonIgnore
    public boolean isPSSystemNameDirty() {
        return this.contains(FIELD_PSSYSTEMNAME);
    }

    @JsonIgnore
    public Integer getSystemFlag() {
        Object objValue = this.get(FIELD_SYSTEMFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="systemflag")
    public void setSystemFlag(Integer systemFlag) {
        this.set(FIELD_SYSTEMFLAG, systemFlag);
    }

    @JsonIgnore
    public boolean isSystemFlagDirty() {
        return this.contains(FIELD_SYSTEMFLAG);
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
    public String getUserIdPSDEFId() {
        Object objValue = this.get(FIELD_USERIDPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="useridpsdefid")
    public void setUserIdPSDEFId(String userIdPSDEFId) {
        this.set(FIELD_USERIDPSDEFID, userIdPSDEFId);
    }

    @JsonIgnore
    public boolean isUserIdPSDEFIdDirty() {
        return this.contains(FIELD_USERIDPSDEFID);
    }

    @JsonIgnore
    public String getUserIdPSDEFName() {
        Object objValue = this.get(FIELD_USERIDPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="useridpsdefname")
    public void setUserIdPSDEFName(String userIdPSDEFName) {
        this.set(FIELD_USERIDPSDEFNAME, userIdPSDEFName);
    }

    @JsonIgnore
    public boolean isUserIdPSDEFNameDirty() {
        return this.contains(FIELD_USERIDPSDEFNAME);
    }

    @JsonIgnore
    public String getUserRoleSN() {
        Object objValue = this.get(FIELD_USERROLESN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userrolesn")
    public void setUserRoleSN(String userRoleSN) {
        this.set(FIELD_USERROLESN, userRoleSN);
    }

    @JsonIgnore
    public boolean isUserRoleSNDirty() {
        return this.contains(FIELD_USERROLESN);
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
        return this.getPSSysOPPrivId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysOPPrivId(strValue);
    }

    public List<PSSysUserRoleRes> getPssysuserroleres() {
        return this.pssysuserroleres;
    }

    public void setPssysuserroleres(List<PSSysUserRoleRes> pssysuserroleres) {
        this.pssysuserroleres = pssysuserroleres;
    }

    public List<PSDEOPPrivRole> getPsdeopprivroles() {
        return this.psdeopprivroles;
    }

    public void setPsdeopprivroles(List<PSDEOPPrivRole> psdeopprivroles) {
        this.psdeopprivroles = psdeopprivroles;
    }

    public List<PSSysUserRoleData> getPssysuserroledata() {
        return this.pssysuserroledata;
    }

    public void setPssysuserroledata(List<PSSysUserRoleData> pssysuserroledata) {
        this.pssysuserroledata = pssysuserroledata;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (strName.equalsIgnoreCase("pssysuserroleres")) {
            return true;
        }
        if (strName.equalsIgnoreCase("psdeopprivroles")) {
            return true;
        }
        if (strName.equalsIgnoreCase("pssysuserroledata")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssysuserroleres")) {
            this.init();
            return this.pssysuserroleres;
        }
        if (strName.equalsIgnoreCase("psdeopprivroles")) {
            this.init();
            return this.psdeopprivroles;
        }
        if (strName.equalsIgnoreCase("pssysuserroledata")) {
            this.init();
            return this.pssysuserroledata;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSOPPRIV";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysOPPriv item = (PSSysOPPriv)MAPPER.readValue(new File(strJsonFilePath), PSSysOPPriv.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysOPPriv) {
            PSSysOPPriv dst = (PSSysOPPriv)target;
            if (!bSimple) {
                PSModelBase newitem;
                if (this.getPssysuserroleres() != null) {
                    ArrayList<PSSysUserRoleRes> pssysuserroleres = new ArrayList<PSSysUserRoleRes>();
                    for (PSSysUserRoleRes pSSysUserRoleRes : this.getPssysuserroleres()) {
                        if (bDeepMode) {
                            newitem = new PSSysUserRoleRes();
                            pSSysUserRoleRes.to(newitem, false, bDeepMode);
                            pssysuserroleres.add((PSSysUserRoleRes)newitem);
                            continue;
                        }
                        pssysuserroleres.add(pSSysUserRoleRes);
                    }
                    dst.setPssysuserroleres(pssysuserroleres);
                }
                if (this.getPsdeopprivroles() != null) {
                    ArrayList<PSDEOPPrivRole> psdeopprivroles = new ArrayList<PSDEOPPrivRole>();
                    for (PSDEOPPrivRole pSDEOPPrivRole : this.getPsdeopprivroles()) {
                        if (bDeepMode) {
                            newitem = new PSDEOPPrivRole();
                            pSDEOPPrivRole.to(newitem, false, bDeepMode);
                            psdeopprivroles.add((PSDEOPPrivRole)newitem);
                            continue;
                        }
                        psdeopprivroles.add(pSDEOPPrivRole);
                    }
                    dst.setPsdeopprivroles(psdeopprivroles);
                }
                if (this.getPssysuserroledata() != null) {
                    ArrayList<PSSysUserRoleData> pssysuserroledata = new ArrayList<PSSysUserRoleData>();
                    for (PSSysUserRoleData pSSysUserRoleData : this.getPssysuserroledata()) {
                        if (bDeepMode) {
                            newitem = new PSSysUserRoleData();
                            pSSysUserRoleData.to(newitem, false, bDeepMode);
                            pssysuserroledata.add((PSSysUserRoleData)newitem);
                            continue;
                        }
                        pssysuserroledata.add(pSSysUserRoleData);
                    }
                    dst.setPssysuserroledata(pssysuserroledata);
                }
            }
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysOPPriv) {
            PSSysOPPriv src = (PSSysOPPriv)source;
            if (!bSimple) {
                PSModelBase newItem;
                if (src.getPssysuserroleres() != null) {
                    ArrayList<PSSysUserRoleRes> pssysuserroleres = new ArrayList<PSSysUserRoleRes>();
                    for (PSSysUserRoleRes pSSysUserRoleRes : src.getPssysuserroleres()) {
                        if (bDeepMode) {
                            newItem = new PSSysUserRoleRes();
                            ((PSSysUserRoleRes)newItem).from(pSSysUserRoleRes, false, bDeepMode);
                            pssysuserroleres.add((PSSysUserRoleRes)newItem);
                            continue;
                        }
                        pssysuserroleres.add(pSSysUserRoleRes);
                    }
                    this.setPssysuserroleres(pssysuserroleres);
                }
                if (src.getPsdeopprivroles() != null) {
                    ArrayList<PSDEOPPrivRole> psdeopprivroles = new ArrayList<PSDEOPPrivRole>();
                    for (PSDEOPPrivRole pSDEOPPrivRole : src.getPsdeopprivroles()) {
                        if (bDeepMode) {
                            newItem = new PSDEOPPrivRole();
                            ((PSDEOPPrivRole)newItem).from(pSDEOPPrivRole, false, bDeepMode);
                            psdeopprivroles.add((PSDEOPPrivRole)newItem);
                            continue;
                        }
                        psdeopprivroles.add(pSDEOPPrivRole);
                    }
                    this.setPsdeopprivroles(psdeopprivroles);
                }
                if (src.getPssysuserroledata() != null) {
                    ArrayList<PSSysUserRoleData> pssysuserroledata = new ArrayList<PSSysUserRoleData>();
                    for (PSSysUserRoleData pSSysUserRoleData : src.getPssysuserroledata()) {
                        if (bDeepMode) {
                            newItem = new PSSysUserRoleData();
                            ((PSSysUserRoleData)newItem).from(pSSysUserRoleData, false, bDeepMode);
                            pssysuserroledata.add((PSSysUserRoleData)newItem);
                            continue;
                        }
                        pssysuserroledata.add(pSSysUserRoleData);
                    }
                    this.setPssysuserroledata(pssysuserroledata);
                }
            }
        }
        super.from(source, bSimple, bDeepMode);
    }
}

