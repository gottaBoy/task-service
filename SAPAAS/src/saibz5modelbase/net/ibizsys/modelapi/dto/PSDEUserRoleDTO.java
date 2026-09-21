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
import net.ibizsys.modelapi.dto.PSDEOPPrivRoleDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDEUserRoleDTO
extends PSModelDTOBase {
    public static final String FIELD_ALLDATAFLAG = "alldataflag";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_CUSTOMCOND = "customcond";
    public static final String FIELD_DEFAULTFLAG = "defaultflag";
    public static final String FIELD_ENABLEORGDR = "enableorgdr";
    public static final String FIELD_ENABLESECBC = "enablesecbc";
    public static final String FIELD_ENABLESECDR = "enablesecdr";
    public static final String FIELD_ENABLEUSERDR = "enableuserdr";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORGDR = "orgdr";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSDEUSERROLEID = "psdeuserroleid";
    public static final String FIELD_PSDEUSERROLENAME = "psdeuserrolename";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSUSERDRID = "pssysuserdrid";
    public static final String FIELD_PSSYSUSERDRID2 = "pssysuserdrid2";
    public static final String FIELD_PSSYSUSERDRNAME = "pssysuserdrname";
    public static final String FIELD_PSSYSUSERDRNAME2 = "pssysuserdrname2";
    public static final String FIELD_SECBC = "secbc";
    public static final String FIELD_SECDR = "secdr";
    public static final String FIELD_SYSTEMFLAG = "systemflag";
    public static final String FIELD_SYSUSERDR2PARAM = "sysuserdr2param";
    public static final String FIELD_SYSUSERDRPARAM = "sysuserdrparam";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERROLETAG = "userroletag";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VALIDFLAG = "validflag";
    private List<PSDEOPPrivRoleDTO> psdeopprivroles;

    @JsonIgnore
    public Integer getAllDataFlag() {
        Object objValue = this.get(FIELD_ALLDATAFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="alldataflag")
    public void setAllDataFlag(Integer allDataFlag) {
        this.set(FIELD_ALLDATAFLAG, allDataFlag);
    }

    @JsonIgnore
    public boolean isAllDataFlagDirty() {
        return this.contains(FIELD_ALLDATAFLAG);
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
    public Integer getDefaultFlag() {
        Object objValue = this.get(FIELD_DEFAULTFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultflag")
    public void setDefaultFlag(Integer defaultFlag) {
        this.set(FIELD_DEFAULTFLAG, defaultFlag);
    }

    @JsonIgnore
    public boolean isDefaultFlagDirty() {
        return this.contains(FIELD_DEFAULTFLAG);
    }

    @JsonIgnore
    public Integer getEnableOrgDR() {
        Object objValue = this.get(FIELD_ENABLEORGDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableorgdr")
    public void setEnableOrgDR(Integer enableOrgDR) {
        this.set(FIELD_ENABLEORGDR, enableOrgDR);
    }

    @JsonIgnore
    public boolean isEnableOrgDRDirty() {
        return this.contains(FIELD_ENABLEORGDR);
    }

    @JsonIgnore
    public Integer getEnableSecBC() {
        Object objValue = this.get(FIELD_ENABLESECBC);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesecbc")
    public void setEnableSecBC(Integer enableSecBC) {
        this.set(FIELD_ENABLESECBC, enableSecBC);
    }

    @JsonIgnore
    public boolean isEnableSecBCDirty() {
        return this.contains(FIELD_ENABLESECBC);
    }

    @JsonIgnore
    public Integer getEnableSecDR() {
        Object objValue = this.get(FIELD_ENABLESECDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablesecdr")
    public void setEnableSecDR(Integer enableSecDR) {
        this.set(FIELD_ENABLESECDR, enableSecDR);
    }

    @JsonIgnore
    public boolean isEnableSecDRDirty() {
        return this.contains(FIELD_ENABLESECDR);
    }

    @JsonIgnore
    public Integer getEnableUserDR() {
        Object objValue = this.get(FIELD_ENABLEUSERDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableuserdr")
    public void setEnableUserDR(Integer enableUserDR) {
        this.set(FIELD_ENABLEUSERDR, enableUserDR);
    }

    @JsonIgnore
    public boolean isEnableUserDRDirty() {
        return this.contains(FIELD_ENABLEUSERDR);
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
    public Integer getOrgDR() {
        Object objValue = this.get(FIELD_ORGDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="orgdr")
    public void setOrgDR(Integer orgDR) {
        this.set(FIELD_ORGDR, orgDR);
    }

    @JsonIgnore
    public boolean isOrgDRDirty() {
        return this.contains(FIELD_ORGDR);
    }

    @JsonIgnore
    public String getPSDEDSId() {
        Object objValue = this.get(FIELD_PSDEDSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsid")
    public void setPSDEDSId(String pSDEDSId) {
        this.set(FIELD_PSDEDSID, pSDEDSId);
    }

    @JsonIgnore
    public boolean isPSDEDSIdDirty() {
        return this.contains(FIELD_PSDEDSID);
    }

    @JsonIgnore
    public String getPSDEDSName() {
        Object objValue = this.get(FIELD_PSDEDSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdedsname")
    public void setPSDEDSName(String pSDEDSName) {
        this.set(FIELD_PSDEDSNAME, pSDEDSName);
    }

    @JsonIgnore
    public boolean isPSDEDSNameDirty() {
        return this.contains(FIELD_PSDEDSNAME);
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
    public String getPSDEUserRoleId() {
        Object objValue = this.get(FIELD_PSDEUSERROLEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuserroleid")
    public void setPSDEUserRoleId(String pSDEUserRoleId) {
        this.set(FIELD_PSDEUSERROLEID, pSDEUserRoleId);
    }

    @JsonIgnore
    public boolean isPSDEUserRoleIdDirty() {
        return this.contains(FIELD_PSDEUSERROLEID);
    }

    @JsonIgnore
    public String getPSDEUserRoleName() {
        Object objValue = this.get(FIELD_PSDEUSERROLENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdeuserrolename")
    public void setPSDEUserRoleName(String pSDEUserRoleName) {
        this.set(FIELD_PSDEUSERROLENAME, pSDEUserRoleName);
    }

    @JsonIgnore
    public boolean isPSDEUserRoleNameDirty() {
        return this.contains(FIELD_PSDEUSERROLENAME);
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
    public String getPSSysUserDRId() {
        Object objValue = this.get(FIELD_PSSYSUSERDRID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrid")
    public void setPSSysUserDRId(String pSSysUserDRId) {
        this.set(FIELD_PSSYSUSERDRID, pSSysUserDRId);
    }

    @JsonIgnore
    public boolean isPSSysUserDRIdDirty() {
        return this.contains(FIELD_PSSYSUSERDRID);
    }

    @JsonIgnore
    public String getPSSysUserDRId2() {
        Object objValue = this.get(FIELD_PSSYSUSERDRID2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrid2")
    public void setPSSysUserDRId2(String pSSysUserDRId2) {
        this.set(FIELD_PSSYSUSERDRID2, pSSysUserDRId2);
    }

    @JsonIgnore
    public boolean isPSSysUserDRId2Dirty() {
        return this.contains(FIELD_PSSYSUSERDRID2);
    }

    @JsonIgnore
    public String getPSSysUserDRName() {
        Object objValue = this.get(FIELD_PSSYSUSERDRNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrname")
    public void setPSSysUserDRName(String pSSysUserDRName) {
        this.set(FIELD_PSSYSUSERDRNAME, pSSysUserDRName);
    }

    @JsonIgnore
    public boolean isPSSysUserDRNameDirty() {
        return this.contains(FIELD_PSSYSUSERDRNAME);
    }

    @JsonIgnore
    public String getPSSysUserDRName2() {
        Object objValue = this.get(FIELD_PSSYSUSERDRNAME2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysuserdrname2")
    public void setPSSysUserDRName2(String pSSysUserDRName2) {
        this.set(FIELD_PSSYSUSERDRNAME2, pSSysUserDRName2);
    }

    @JsonIgnore
    public boolean isPSSysUserDRName2Dirty() {
        return this.contains(FIELD_PSSYSUSERDRNAME2);
    }

    @JsonIgnore
    public String getSecBC() {
        Object objValue = this.get(FIELD_SECBC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="secbc")
    public void setSecBC(String secBC) {
        this.set(FIELD_SECBC, secBC);
    }

    @JsonIgnore
    public boolean isSecBCDirty() {
        return this.contains(FIELD_SECBC);
    }

    @JsonIgnore
    public Integer getSecDR() {
        Object objValue = this.get(FIELD_SECDR);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="secdr")
    public void setSecDR(Integer secDR) {
        this.set(FIELD_SECDR, secDR);
    }

    @JsonIgnore
    public boolean isSecDRDirty() {
        return this.contains(FIELD_SECDR);
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
    public String getSysUserDR2Param() {
        Object objValue = this.get(FIELD_SYSUSERDR2PARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysuserdr2param")
    public void setSysUserDR2Param(String sysUserDR2Param) {
        this.set(FIELD_SYSUSERDR2PARAM, sysUserDR2Param);
    }

    @JsonIgnore
    public boolean isSysUserDR2ParamDirty() {
        return this.contains(FIELD_SYSUSERDR2PARAM);
    }

    @JsonIgnore
    public String getSysUserDRParam() {
        Object objValue = this.get(FIELD_SYSUSERDRPARAM);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="sysuserdrparam")
    public void setSysUserDRParam(String sysUserDRParam) {
        this.set(FIELD_SYSUSERDRPARAM, sysUserDRParam);
    }

    @JsonIgnore
    public boolean isSysUserDRParamDirty() {
        return this.contains(FIELD_SYSUSERDRPARAM);
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
    public String getUserRoleTag() {
        Object objValue = this.get(FIELD_USERROLETAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userroletag")
    public void setUserRoleTag(String userRoleTag) {
        this.set(FIELD_USERROLETAG, userRoleTag);
    }

    @JsonIgnore
    public boolean isUserRoleTagDirty() {
        return this.contains(FIELD_USERROLETAG);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDEUserRoleId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDEUserRoleId(strValue);
    }

    @JsonProperty(value="psdeopprivroles")
    public List<PSDEOPPrivRoleDTO> getPsdeopprivroles() {
        return this.psdeopprivroles;
    }

    @JsonProperty(value="psdeopprivroles")
    public void setPsdeopprivroles(List<PSDEOPPrivRoleDTO> psdeopprivroles) {
        this.psdeopprivroles = psdeopprivroles;
    }
}

