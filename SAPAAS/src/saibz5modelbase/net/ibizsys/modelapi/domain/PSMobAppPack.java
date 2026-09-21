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
import java.util.List;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSMobAppPack
extends PSModelBase {
    public static final String FIELD_ANDROIDPERMISSIONS = "androidpermissions";
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_ENABLEANDROID = "enableandroid";
    public static final String FIELD_ENABLEENCRYPTION = "enableencryption";
    public static final String FIELD_ENABLEIOS = "enableios";
    public static final String FIELD_IOSDEVICES = "iosdevices";
    public static final String FIELD_IOSPRIVACIES = "iosprivacies";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_OSTYPE = "ostype";
    public static final String FIELD_OSTYPES = "ostypes";
    public static final String FIELD_PACKTYPE = "packtype";
    public static final String FIELD_PKGNAME = "pkgname";
    public static final String FIELD_PSDCMOBPACKCERTID = "psdcmobpackcertid";
    public static final String FIELD_PSDCMOBPACKCERTNAME = "psdcmobpackcertname";
    public static final String FIELD_PSMOBAPPPACKID = "psmobapppackid";
    public static final String FIELD_PSMOBAPPPACKNAME = "psmobapppackname";
    public static final String FIELD_PSSYSAPPID = "pssysappid";
    public static final String FIELD_PSSYSAPPNAME = "pssysappname";
    public static final String FIELD_SERVICEURL = "serviceurl";
    public static final String FIELD_TDCNT = "tdcnt";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERPARAMS = "userparams";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    public static final String FIELD_VERSION = "version";

    @JsonIgnore
    public String getAndroidPermissions() {
        Object objValue = this.get(FIELD_ANDROIDPERMISSIONS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="androidpermissions")
    public void setAndroidPermissions(String androidPermissions) {
        this.set(FIELD_ANDROIDPERMISSIONS, androidPermissions);
    }

    @JsonIgnore
    public boolean isAndroidPermissionsDirty() {
        return this.contains(FIELD_ANDROIDPERMISSIONS);
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
    public Integer getEnableAndroid() {
        Object objValue = this.get(FIELD_ENABLEANDROID);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableandroid")
    public void setEnableAndroid(Integer enableAndroid) {
        this.set(FIELD_ENABLEANDROID, enableAndroid);
    }

    @JsonIgnore
    public boolean isEnableAndroidDirty() {
        return this.contains(FIELD_ENABLEANDROID);
    }

    @JsonIgnore
    public Integer getEnableEncryption() {
        Object objValue = this.get(FIELD_ENABLEENCRYPTION);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableencryption")
    public void setEnableEncryption(Integer enableEncryption) {
        this.set(FIELD_ENABLEENCRYPTION, enableEncryption);
    }

    @JsonIgnore
    public boolean isEnableEncryptionDirty() {
        return this.contains(FIELD_ENABLEENCRYPTION);
    }

    @JsonIgnore
    public Integer getEnableIOS() {
        Object objValue = this.get(FIELD_ENABLEIOS);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableios")
    public void setEnableIOS(Integer enableIOS) {
        this.set(FIELD_ENABLEIOS, enableIOS);
    }

    @JsonIgnore
    public boolean isEnableIOSDirty() {
        return this.contains(FIELD_ENABLEIOS);
    }

    @JsonIgnore
    public String getIOSDevices() {
        Object objValue = this.get(FIELD_IOSDEVICES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iosdevices")
    public void setIOSDevices(String iOSDevices) {
        this.set(FIELD_IOSDEVICES, iOSDevices);
    }

    @JsonIgnore
    public boolean isIOSDevicesDirty() {
        return this.contains(FIELD_IOSDEVICES);
    }

    @JsonIgnore
    public String getIOSPrivacies() {
        Object objValue = this.get(FIELD_IOSPRIVACIES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iosprivacies")
    public void setIOSPrivacies(String iOSPrivacies) {
        this.set(FIELD_IOSPRIVACIES, iOSPrivacies);
    }

    @JsonIgnore
    public boolean isIOSPrivaciesDirty() {
        return this.contains(FIELD_IOSPRIVACIES);
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
    public String getOSType() {
        Object objValue = this.get(FIELD_OSTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ostype")
    public void setOSType(String oSType) {
        this.set(FIELD_OSTYPE, oSType);
    }

    @JsonIgnore
    public boolean isOSTypeDirty() {
        return this.contains(FIELD_OSTYPE);
    }

    @JsonIgnore
    public String getOSTypes() {
        Object objValue = this.get(FIELD_OSTYPES);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ostypes")
    public void setOSTypes(String oSTypes) {
        this.set(FIELD_OSTYPES, oSTypes);
    }

    @JsonIgnore
    public boolean isOSTypesDirty() {
        return this.contains(FIELD_OSTYPES);
    }

    @JsonIgnore
    public String getPackType() {
        Object objValue = this.get(FIELD_PACKTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="packtype")
    public void setPackType(String packType) {
        this.set(FIELD_PACKTYPE, packType);
    }

    @JsonIgnore
    public boolean isPackTypeDirty() {
        return this.contains(FIELD_PACKTYPE);
    }

    @JsonIgnore
    public String getPkgName() {
        Object objValue = this.get(FIELD_PKGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pkgname")
    public void setPkgName(String pkgName) {
        this.set(FIELD_PKGNAME, pkgName);
    }

    @JsonIgnore
    public boolean isPkgNameDirty() {
        return this.contains(FIELD_PKGNAME);
    }

    @JsonIgnore
    public String getPSDCMobPackCertId() {
        Object objValue = this.get(FIELD_PSDCMOBPACKCERTID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdcmobpackcertid")
    public void setPSDCMobPackCertId(String pSDCMobPackCertId) {
        this.set(FIELD_PSDCMOBPACKCERTID, pSDCMobPackCertId);
    }

    @JsonIgnore
    public boolean isPSDCMobPackCertIdDirty() {
        return this.contains(FIELD_PSDCMOBPACKCERTID);
    }

    @JsonIgnore
    public String getPSDCMobPackCertName() {
        Object objValue = this.get(FIELD_PSDCMOBPACKCERTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdcmobpackcertname")
    public void setPSDCMobPackCertName(String pSDCMobPackCertName) {
        this.set(FIELD_PSDCMOBPACKCERTNAME, pSDCMobPackCertName);
    }

    @JsonIgnore
    public boolean isPSDCMobPackCertNameDirty() {
        return this.contains(FIELD_PSDCMOBPACKCERTNAME);
    }

    @JsonIgnore
    public String getPSMobAppPackId() {
        Object objValue = this.get(FIELD_PSMOBAPPPACKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmobapppackid")
    public void setPSMobAppPackId(String pSMobAppPackId) {
        this.set(FIELD_PSMOBAPPPACKID, pSMobAppPackId);
    }

    @JsonIgnore
    public boolean isPSMobAppPackIdDirty() {
        return this.contains(FIELD_PSMOBAPPPACKID);
    }

    @JsonIgnore
    public String getPSMobAppPackName() {
        Object objValue = this.get(FIELD_PSMOBAPPPACKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psmobapppackname")
    public void setPSMobAppPackName(String pSMobAppPackName) {
        this.set(FIELD_PSMOBAPPPACKNAME, pSMobAppPackName);
    }

    @JsonIgnore
    public boolean isPSMobAppPackNameDirty() {
        return this.contains(FIELD_PSMOBAPPPACKNAME);
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
    public String getServiceUrl() {
        Object objValue = this.get(FIELD_SERVICEURL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="serviceurl")
    public void setServiceUrl(String serviceUrl) {
        this.set(FIELD_SERVICEURL, serviceUrl);
    }

    @JsonIgnore
    public boolean isServiceUrlDirty() {
        return this.contains(FIELD_SERVICEURL);
    }

    @JsonIgnore
    public Integer getTDCnt() {
        Object objValue = this.get(FIELD_TDCNT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="tdcnt")
    public void setTDCnt(Integer tDCnt) {
        this.set(FIELD_TDCNT, tDCnt);
    }

    @JsonIgnore
    public boolean isTDCntDirty() {
        return this.contains(FIELD_TDCNT);
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
    public String getUserParams() {
        Object objValue = this.get(FIELD_USERPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="userparams")
    public void setUserParams(String userParams) {
        this.set(FIELD_USERPARAMS, userParams);
    }

    @JsonIgnore
    public boolean isUserParamsDirty() {
        return this.contains(FIELD_USERPARAMS);
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
    public String getVersion() {
        Object objValue = this.get(FIELD_VERSION);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="version")
    public void setVersion(String version) {
        this.set(FIELD_VERSION, version);
    }

    @JsonIgnore
    public boolean isVersionDirty() {
        return this.contains(FIELD_VERSION);
    }

    @JsonIgnore
    public String getSrfkey() {
        return this.getPSMobAppPackId();
    }

    public void setSrfkey(String strValue) {
        this.setPSMobAppPackId(strValue);
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSMOBAPPPACK";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSMobAppPack item = (PSMobAppPack)MAPPER.readValue(new File(strJsonFilePath), PSMobAppPack.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSMobAppPack) {
            PSMobAppPack pSMobAppPack = (PSMobAppPack)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSMobAppPack) {
            PSMobAppPack pSMobAppPack = (PSMobAppPack)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

