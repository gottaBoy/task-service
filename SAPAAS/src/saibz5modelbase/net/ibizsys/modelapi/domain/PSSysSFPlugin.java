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
import net.ibizsys.modelapi.domain.PSSysSFPITempl;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;

public class PSSysSFPlugin
extends PSModelBase {
    public static final String FIELD_CODENAME = "codename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_KEYWORDS = "keywords";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_PARAMDESC = "paramdesc";
    public static final String FIELD_PLUGINMODEL = "pluginmodel";
    public static final String FIELD_PLUGINPARAMS = "pluginparams";
    public static final String FIELD_PLUGINTYPE = "plugintype";
    public static final String FIELD_PREVIEWHTML = "previewhtml";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSFPLUGINID = "pssfpluginid";
    public static final String FIELD_PSSFPLUGINNAME = "pssfpluginname";
    public static final String FIELD_PSSYSSFPLUGINID = "pssyssfpluginid";
    public static final String FIELD_PSSYSSFPLUGINNAME = "pssyssfpluginname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_REPDEFAULT = "repdefault";
    public static final String FIELD_RTOBJECTMODE = "rtobjectmode";
    public static final String FIELD_RTOBJECTNAME = "rtobjectname";
    public static final String FIELD_RTOBJECTREPO = "rtobjectrepo";
    public static final String FIELD_STUDIOICON = "studioicon";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSSysSFPITempl> pssyssfpitempls;

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
    public String getKeywords() {
        Object objValue = this.get(FIELD_KEYWORDS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="keywords")
    public void setKeywords(String keywords) {
        this.set(FIELD_KEYWORDS, keywords);
    }

    @JsonIgnore
    public boolean isKeywordsDirty() {
        return this.contains(FIELD_KEYWORDS);
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
    public String getParamDesc() {
        Object objValue = this.get(FIELD_PARAMDESC);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="paramdesc")
    public void setParamDesc(String paramDesc) {
        this.set(FIELD_PARAMDESC, paramDesc);
    }

    @JsonIgnore
    public boolean isParamDescDirty() {
        return this.contains(FIELD_PARAMDESC);
    }

    @JsonIgnore
    public String getPluginModel() {
        Object objValue = this.get(FIELD_PLUGINMODEL);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pluginmodel")
    public void setPluginModel(String pluginModel) {
        this.set(FIELD_PLUGINMODEL, pluginModel);
    }

    @JsonIgnore
    public boolean isPluginModelDirty() {
        return this.contains(FIELD_PLUGINMODEL);
    }

    @JsonIgnore
    public String getPluginParams() {
        Object objValue = this.get(FIELD_PLUGINPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pluginparams")
    public void setPluginParams(String pluginParams) {
        this.set(FIELD_PLUGINPARAMS, pluginParams);
    }

    @JsonIgnore
    public boolean isPluginParamsDirty() {
        return this.contains(FIELD_PLUGINPARAMS);
    }

    @JsonIgnore
    public String getPluginType() {
        Object objValue = this.get(FIELD_PLUGINTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="plugintype")
    public void setPluginType(String pluginType) {
        this.set(FIELD_PLUGINTYPE, pluginType);
    }

    @JsonIgnore
    public boolean isPluginTypeDirty() {
        return this.contains(FIELD_PLUGINTYPE);
    }

    @JsonIgnore
    public String getPreviewHtml() {
        Object objValue = this.get(FIELD_PREVIEWHTML);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="previewhtml")
    public void setPreviewHtml(String previewHtml) {
        this.set(FIELD_PREVIEWHTML, previewHtml);
    }

    @JsonIgnore
    public boolean isPreviewHtmlDirty() {
        return this.contains(FIELD_PREVIEWHTML);
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
    public String getPSSFPluginId() {
        Object objValue = this.get(FIELD_PSSFPLUGINID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpluginid")
    public void setPSSFPluginId(String pSSFPluginId) {
        this.set(FIELD_PSSFPLUGINID, pSSFPluginId);
    }

    @JsonIgnore
    public boolean isPSSFPluginIdDirty() {
        return this.contains(FIELD_PSSFPLUGINID);
    }

    @JsonIgnore
    public String getPSSFPluginName() {
        Object objValue = this.get(FIELD_PSSFPLUGINNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssfpluginname")
    public void setPSSFPluginName(String pSSFPluginName) {
        this.set(FIELD_PSSFPLUGINNAME, pSSFPluginName);
    }

    @JsonIgnore
    public boolean isPSSFPluginNameDirty() {
        return this.contains(FIELD_PSSFPLUGINNAME);
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
    public Integer getRepDefault() {
        Object objValue = this.get(FIELD_REPDEFAULT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="repdefault")
    public void setRepDefault(Integer repDefault) {
        this.set(FIELD_REPDEFAULT, repDefault);
    }

    @JsonIgnore
    public boolean isRepDefaultDirty() {
        return this.contains(FIELD_REPDEFAULT);
    }

    @JsonIgnore
    public Integer getRTObjectMode() {
        Object objValue = this.get(FIELD_RTOBJECTMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="rtobjectmode")
    public void setRTObjectMode(Integer rTObjectMode) {
        this.set(FIELD_RTOBJECTMODE, rTObjectMode);
    }

    @JsonIgnore
    public boolean isRTObjectModeDirty() {
        return this.contains(FIELD_RTOBJECTMODE);
    }

    @JsonIgnore
    public String getRTObjectName() {
        Object objValue = this.get(FIELD_RTOBJECTNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rtobjectname")
    public void setRTObjectName(String rTObjectName) {
        this.set(FIELD_RTOBJECTNAME, rTObjectName);
    }

    @JsonIgnore
    public boolean isRTObjectNameDirty() {
        return this.contains(FIELD_RTOBJECTNAME);
    }

    @JsonIgnore
    public String getRTObjectRepo() {
        Object objValue = this.get(FIELD_RTOBJECTREPO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="rtobjectrepo")
    public void setRTObjectRepo(String rTObjectRepo) {
        this.set(FIELD_RTOBJECTREPO, rTObjectRepo);
    }

    @JsonIgnore
    public boolean isRTObjectRepoDirty() {
        return this.contains(FIELD_RTOBJECTREPO);
    }

    @JsonIgnore
    public String getStudioIcon() {
        Object objValue = this.get(FIELD_STUDIOICON);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="studioicon")
    public void setStudioIcon(String studioIcon) {
        this.set(FIELD_STUDIOICON, studioIcon);
    }

    @JsonIgnore
    public boolean isStudioIconDirty() {
        return this.contains(FIELD_STUDIOICON);
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
        return this.getPSSysSFPluginId();
    }

    public void setSrfkey(String strValue) {
        this.setPSSysSFPluginId(strValue);
    }

    public List<PSSysSFPITempl> getPssyssfpitempls() {
        return this.pssyssfpitempls;
    }

    public void setPssyssfpitempls(List<PSSysSFPITempl> pssyssfpitempls) {
        this.pssyssfpitempls = pssyssfpitempls;
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        if (bFullMode && strName.equalsIgnoreCase("pssyssfpitempls")) {
            return true;
        }
        return super.containsPSModels(strName, bFullMode);
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        if (strName.equalsIgnoreCase("pssyssfpitempls")) {
            this.init();
            return this.pssyssfpitempls;
        }
        return super.getPSModels(strName);
    }

    @Override
    public String getSrfType() {
        return "PSSYSSFPLUGIN";
    }

    @Override
    protected void onLoad(String strJsonFilePath) throws Exception {
        PSSysSFPlugin item = (PSSysSFPlugin)MAPPER.readValue(new File(strJsonFilePath), PSSysSFPlugin.class);
        item.to(this, false, false);
    }

    @Override
    public void to(IPSModel target, boolean bSimple, boolean bDeepMode) throws Exception {
        if (target instanceof PSSysSFPlugin) {
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)target;
        }
        super.to(target, bSimple, bDeepMode);
    }

    @Override
    public void from(IPSModel source, boolean bSimple, boolean bDeepMode) throws Exception {
        if (source instanceof PSSysSFPlugin) {
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)source;
        }
        super.from(source, bSimple, bDeepMode);
    }
}

