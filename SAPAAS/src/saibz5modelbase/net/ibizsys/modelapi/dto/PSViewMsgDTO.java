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

public class PSViewMsgDTO
extends PSModelDTOBase {
    public static final String FIELD_CACHESCOPE = "cachescope";
    public static final String FIELD_CACHETAG2PSDEFID = "cachetag2psdefid";
    public static final String FIELD_CACHETAG2PSDEFNAME = "cachetag2psdefname";
    public static final String FIELD_CACHETAGPSDEFID = "cachetagpsdefid";
    public static final String FIELD_CACHETAGPSDEFNAME = "cachetagpsdefname";
    public static final String FIELD_CACHETIMEOUT = "cachetimeout";
    public static final String FIELD_CLSPSDEFID = "clspsdefid";
    public static final String FIELD_CLSPSDEFNAME = "clspsdefname";
    public static final String FIELD_CODENAME = "codename";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_CONTENTPSDEFID = "contentpsdefid";
    public static final String FIELD_CONTENTPSDEFNAME = "contentpsdefname";
    public static final String FIELD_CONTENTPSLANRESID = "contentpslanresid";
    public static final String FIELD_CONTENTPSLANRESNAME = "contentpslanresname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DSLINK = "dslink";
    public static final String FIELD_DYNAMICMODE = "dynamicmode";
    public static final String FIELD_ENABLECACHE = "enablecache";
    public static final String FIELD_ENABLEREMOVE = "enableremove";
    public static final String FIELD_GROUPPSDEFID = "grouppsdefid";
    public static final String FIELD_GROUPPSDEFNAME = "grouppsdefname";
    public static final String FIELD_ICONPSDEFID = "iconpsdefid";
    public static final String FIELD_ICONPSDEFNAME = "iconpsdefname";
    public static final String FIELD_LOCKFLAG = "lockflag";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_MSGGROUP = "msggroup";
    public static final String FIELD_MSGPOS = "msgpos";
    public static final String FIELD_MSGPOSPSDEFID = "msgpospsdefid";
    public static final String FIELD_MSGPOSPSDEFNAME = "msgpospsdefname";
    public static final String FIELD_MSGTYPE = "msgtype";
    public static final String FIELD_MSGTYPEPSDEFID = "msgtypepsdefid";
    public static final String FIELD_MSGTYPEPSDEFNAME = "msgtypepsdefname";
    public static final String FIELD_ORDERVALUEPSDEFID = "ordervaluepsdefid";
    public static final String FIELD_ORDERVALUEPSDEFNAME = "ordervaluepsdefname";
    public static final String FIELD_PSDEDSID = "psdedsid";
    public static final String FIELD_PSDEDSNAME = "psdedsname";
    public static final String FIELD_PSDEID = "psdeid";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_PSDENAME = "psdename";
    public static final String FIELD_PSMODULEID = "psmoduleid";
    public static final String FIELD_PSMODULENAME = "psmodulename";
    public static final String FIELD_PSSYSCSSID = "pssyscssid";
    public static final String FIELD_PSSYSCSSNAME = "pssyscssname";
    public static final String FIELD_PSSYSDYNAMODELID = "pssysdynamodelid";
    public static final String FIELD_PSSYSDYNAMODELNAME = "pssysdynamodelname";
    public static final String FIELD_PSSYSIMAGEID = "pssysimageid";
    public static final String FIELD_PSSYSIMAGENAME = "pssysimagename";
    public static final String FIELD_PSSYSMSGTEMPLID = "pssysmsgtemplid";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "pssysmsgtemplname";
    public static final String FIELD_PSSYSTEMID = "pssystemid";
    public static final String FIELD_PSSYSTEMNAME = "pssystemname";
    public static final String FIELD_PSSYSVIEWPANELID = "pssysviewpanelid";
    public static final String FIELD_PSSYSVIEWPANELNAME = "pssysviewpanelname";
    public static final String FIELD_PSVIEWMSGID = "psviewmsgid";
    public static final String FIELD_PSVIEWMSGNAME = "psviewmsgname";
    public static final String FIELD_REMOVEPSDEFID = "removepsdefid";
    public static final String FIELD_REMOVEPSDEFNAME = "removepsdefname";
    public static final String FIELD_TIMEOUT = "timeout";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_TITLELANRESTAGPSDEFID = "titlelanrestagpsdefid";
    public static final String FIELD_TITLELANRESTAGPSDEFNAME = "titlelanrestagpsdefname";
    public static final String FIELD_TITLEPSDEFID = "titlepsdefid";
    public static final String FIELD_TITLEPSDEFNAME = "titlepsdefname";
    public static final String FIELD_TITLEPSLANRESID = "titlepslanresid";
    public static final String FIELD_TITLEPSLANRESNAME = "titlepslanresname";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";

    @JsonIgnore
    public String getCacheScope() {
        Object objValue = this.get(FIELD_CACHESCOPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachescope")
    public void setCacheScope(String cacheScope) {
        this.set(FIELD_CACHESCOPE, cacheScope);
    }

    @JsonIgnore
    public boolean isCacheScopeDirty() {
        return this.contains(FIELD_CACHESCOPE);
    }

    @JsonIgnore
    public String getCacheTag2PSDEFId() {
        Object objValue = this.get(FIELD_CACHETAG2PSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachetag2psdefid")
    public void setCacheTag2PSDEFId(String cacheTag2PSDEFId) {
        this.set(FIELD_CACHETAG2PSDEFID, cacheTag2PSDEFId);
    }

    @JsonIgnore
    public boolean isCacheTag2PSDEFIdDirty() {
        return this.contains(FIELD_CACHETAG2PSDEFID);
    }

    @JsonIgnore
    public String getCacheTag2PSDEFName() {
        Object objValue = this.get(FIELD_CACHETAG2PSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachetag2psdefname")
    public void setCacheTag2PSDEFName(String cacheTag2PSDEFName) {
        this.set(FIELD_CACHETAG2PSDEFNAME, cacheTag2PSDEFName);
    }

    @JsonIgnore
    public boolean isCacheTag2PSDEFNameDirty() {
        return this.contains(FIELD_CACHETAG2PSDEFNAME);
    }

    @JsonIgnore
    public String getCacheTagPSDEFId() {
        Object objValue = this.get(FIELD_CACHETAGPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachetagpsdefid")
    public void setCacheTagPSDEFId(String cacheTagPSDEFId) {
        this.set(FIELD_CACHETAGPSDEFID, cacheTagPSDEFId);
    }

    @JsonIgnore
    public boolean isCacheTagPSDEFIdDirty() {
        return this.contains(FIELD_CACHETAGPSDEFID);
    }

    @JsonIgnore
    public String getCacheTagPSDEFName() {
        Object objValue = this.get(FIELD_CACHETAGPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="cachetagpsdefname")
    public void setCacheTagPSDEFName(String cacheTagPSDEFName) {
        this.set(FIELD_CACHETAGPSDEFNAME, cacheTagPSDEFName);
    }

    @JsonIgnore
    public boolean isCacheTagPSDEFNameDirty() {
        return this.contains(FIELD_CACHETAGPSDEFNAME);
    }

    @JsonIgnore
    public Integer getCacheTimeout() {
        Object objValue = this.get(FIELD_CACHETIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="cachetimeout")
    public void setCacheTimeout(Integer cacheTimeout) {
        this.set(FIELD_CACHETIMEOUT, cacheTimeout);
    }

    @JsonIgnore
    public boolean isCacheTimeoutDirty() {
        return this.contains(FIELD_CACHETIMEOUT);
    }

    @JsonIgnore
    public String getClsPSDEFId() {
        Object objValue = this.get(FIELD_CLSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefid")
    public void setClsPSDEFId(String clsPSDEFId) {
        this.set(FIELD_CLSPSDEFID, clsPSDEFId);
    }

    @JsonIgnore
    public boolean isClsPSDEFIdDirty() {
        return this.contains(FIELD_CLSPSDEFID);
    }

    @JsonIgnore
    public String getClsPSDEFName() {
        Object objValue = this.get(FIELD_CLSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="clspsdefname")
    public void setClsPSDEFName(String clsPSDEFName) {
        this.set(FIELD_CLSPSDEFNAME, clsPSDEFName);
    }

    @JsonIgnore
    public boolean isClsPSDEFNameDirty() {
        return this.contains(FIELD_CLSPSDEFNAME);
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
    public String getContent() {
        Object objValue = this.get(FIELD_CONTENT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="content")
    public void setContent(String content) {
        this.set(FIELD_CONTENT, content);
    }

    @JsonIgnore
    public boolean isContentDirty() {
        return this.contains(FIELD_CONTENT);
    }

    @JsonIgnore
    public String getContentPSDEFId() {
        Object objValue = this.get(FIELD_CONTENTPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefid")
    public void setContentPSDEFId(String contentPSDEFId) {
        this.set(FIELD_CONTENTPSDEFID, contentPSDEFId);
    }

    @JsonIgnore
    public boolean isContentPSDEFIdDirty() {
        return this.contains(FIELD_CONTENTPSDEFID);
    }

    @JsonIgnore
    public String getContentPSDEFName() {
        Object objValue = this.get(FIELD_CONTENTPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpsdefname")
    public void setContentPSDEFName(String contentPSDEFName) {
        this.set(FIELD_CONTENTPSDEFNAME, contentPSDEFName);
    }

    @JsonIgnore
    public boolean isContentPSDEFNameDirty() {
        return this.contains(FIELD_CONTENTPSDEFNAME);
    }

    @JsonIgnore
    public String getContentPSLanResId() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresid")
    public void setContentPSLanResId(String contentPSLanResId) {
        this.set(FIELD_CONTENTPSLANRESID, contentPSLanResId);
    }

    @JsonIgnore
    public boolean isContentPSLanResIdDirty() {
        return this.contains(FIELD_CONTENTPSLANRESID);
    }

    @JsonIgnore
    public String getContentPSLanResName() {
        Object objValue = this.get(FIELD_CONTENTPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="contentpslanresname")
    public void setContentPSLanResName(String contentPSLanResName) {
        this.set(FIELD_CONTENTPSLANRESNAME, contentPSLanResName);
    }

    @JsonIgnore
    public boolean isContentPSLanResNameDirty() {
        return this.contains(FIELD_CONTENTPSLANRESNAME);
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
    public String getDSLink() {
        Object objValue = this.get(FIELD_DSLINK);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dslink")
    public void setDSLink(String dSLink) {
        this.set(FIELD_DSLINK, dSLink);
    }

    @JsonIgnore
    public boolean isDSLinkDirty() {
        return this.contains(FIELD_DSLINK);
    }

    @JsonIgnore
    public Integer getDynamicMode() {
        Object objValue = this.get(FIELD_DYNAMICMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamicmode")
    public void setDynamicMode(Integer dynamicMode) {
        this.set(FIELD_DYNAMICMODE, dynamicMode);
    }

    @JsonIgnore
    public boolean isDynamicModeDirty() {
        return this.contains(FIELD_DYNAMICMODE);
    }

    @JsonIgnore
    public Integer getEnableCache() {
        Object objValue = this.get(FIELD_ENABLECACHE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enablecache")
    public void setEnableCache(Integer enableCache) {
        this.set(FIELD_ENABLECACHE, enableCache);
    }

    @JsonIgnore
    public boolean isEnableCacheDirty() {
        return this.contains(FIELD_ENABLECACHE);
    }

    @JsonIgnore
    public Integer getEnableRemove() {
        Object objValue = this.get(FIELD_ENABLEREMOVE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="enableremove")
    public void setEnableRemove(Integer enableRemove) {
        this.set(FIELD_ENABLEREMOVE, enableRemove);
    }

    @JsonIgnore
    public boolean isEnableRemoveDirty() {
        return this.contains(FIELD_ENABLEREMOVE);
    }

    @JsonIgnore
    public String getGroupPSDEFId() {
        Object objValue = this.get(FIELD_GROUPPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefid")
    public void setGroupPSDEFId(String groupPSDEFId) {
        this.set(FIELD_GROUPPSDEFID, groupPSDEFId);
    }

    @JsonIgnore
    public boolean isGroupPSDEFIdDirty() {
        return this.contains(FIELD_GROUPPSDEFID);
    }

    @JsonIgnore
    public String getGroupPSDEFName() {
        Object objValue = this.get(FIELD_GROUPPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="grouppsdefname")
    public void setGroupPSDEFName(String groupPSDEFName) {
        this.set(FIELD_GROUPPSDEFNAME, groupPSDEFName);
    }

    @JsonIgnore
    public boolean isGroupPSDEFNameDirty() {
        return this.contains(FIELD_GROUPPSDEFNAME);
    }

    @JsonIgnore
    public String getIconPSDEFId() {
        Object objValue = this.get(FIELD_ICONPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpsdefid")
    public void setIconPSDEFId(String iconPSDEFId) {
        this.set(FIELD_ICONPSDEFID, iconPSDEFId);
    }

    @JsonIgnore
    public boolean isIconPSDEFIdDirty() {
        return this.contains(FIELD_ICONPSDEFID);
    }

    @JsonIgnore
    public String getIconPSDEFName() {
        Object objValue = this.get(FIELD_ICONPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="iconpsdefname")
    public void setIconPSDEFName(String iconPSDEFName) {
        this.set(FIELD_ICONPSDEFNAME, iconPSDEFName);
    }

    @JsonIgnore
    public boolean isIconPSDEFNameDirty() {
        return this.contains(FIELD_ICONPSDEFNAME);
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
    public String getMsgGroup() {
        Object objValue = this.get(FIELD_MSGGROUP);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msggroup")
    public void setMsgGroup(String msgGroup) {
        this.set(FIELD_MSGGROUP, msgGroup);
    }

    @JsonIgnore
    public boolean isMsgGroupDirty() {
        return this.contains(FIELD_MSGGROUP);
    }

    @JsonIgnore
    public String getMsgPos() {
        Object objValue = this.get(FIELD_MSGPOS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgpos")
    public void setMsgPos(String msgPos) {
        this.set(FIELD_MSGPOS, msgPos);
    }

    @JsonIgnore
    public boolean isMsgPosDirty() {
        return this.contains(FIELD_MSGPOS);
    }

    @JsonIgnore
    public String getMsgPosPSDEFId() {
        Object objValue = this.get(FIELD_MSGPOSPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgpospsdefid")
    public void setMsgPosPSDEFId(String msgPosPSDEFId) {
        this.set(FIELD_MSGPOSPSDEFID, msgPosPSDEFId);
    }

    @JsonIgnore
    public boolean isMsgPosPSDEFIdDirty() {
        return this.contains(FIELD_MSGPOSPSDEFID);
    }

    @JsonIgnore
    public String getMsgPosPSDEFName() {
        Object objValue = this.get(FIELD_MSGPOSPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgpospsdefname")
    public void setMsgPosPSDEFName(String msgPosPSDEFName) {
        this.set(FIELD_MSGPOSPSDEFNAME, msgPosPSDEFName);
    }

    @JsonIgnore
    public boolean isMsgPosPSDEFNameDirty() {
        return this.contains(FIELD_MSGPOSPSDEFNAME);
    }

    @JsonIgnore
    public String getMsgType() {
        Object objValue = this.get(FIELD_MSGTYPE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgtype")
    public void setMsgType(String msgType) {
        this.set(FIELD_MSGTYPE, msgType);
    }

    @JsonIgnore
    public boolean isMsgTypeDirty() {
        return this.contains(FIELD_MSGTYPE);
    }

    @JsonIgnore
    public String getMsgTypePSDEFId() {
        Object objValue = this.get(FIELD_MSGTYPEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgtypepsdefid")
    public void setMsgTypePSDEFId(String msgTypePSDEFId) {
        this.set(FIELD_MSGTYPEPSDEFID, msgTypePSDEFId);
    }

    @JsonIgnore
    public boolean isMsgTypePSDEFIdDirty() {
        return this.contains(FIELD_MSGTYPEPSDEFID);
    }

    @JsonIgnore
    public String getMsgTypePSDEFName() {
        Object objValue = this.get(FIELD_MSGTYPEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="msgtypepsdefname")
    public void setMsgTypePSDEFName(String msgTypePSDEFName) {
        this.set(FIELD_MSGTYPEPSDEFNAME, msgTypePSDEFName);
    }

    @JsonIgnore
    public boolean isMsgTypePSDEFNameDirty() {
        return this.contains(FIELD_MSGTYPEPSDEFNAME);
    }

    @JsonIgnore
    public String getOrderValuePSDEFId() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefid")
    public void setOrderValuePSDEFId(String orderValuePSDEFId) {
        this.set(FIELD_ORDERVALUEPSDEFID, orderValuePSDEFId);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFIdDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFID);
    }

    @JsonIgnore
    public String getOrderValuePSDEFName() {
        Object objValue = this.get(FIELD_ORDERVALUEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="ordervaluepsdefname")
    public void setOrderValuePSDEFName(String orderValuePSDEFName) {
        this.set(FIELD_ORDERVALUEPSDEFNAME, orderValuePSDEFName);
    }

    @JsonIgnore
    public boolean isOrderValuePSDEFNameDirty() {
        return this.contains(FIELD_ORDERVALUEPSDEFNAME);
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
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
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
    public String getPSSysCssId() {
        Object objValue = this.get(FIELD_PSSYSCSSID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssid")
    public void setPSSysCssId(String pSSysCssId) {
        this.set(FIELD_PSSYSCSSID, pSSysCssId);
    }

    @JsonIgnore
    public boolean isPSSysCssIdDirty() {
        return this.contains(FIELD_PSSYSCSSID);
    }

    @JsonIgnore
    public String getPSSysCssName() {
        Object objValue = this.get(FIELD_PSSYSCSSNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssyscssname")
    public void setPSSysCssName(String pSSysCssName) {
        this.set(FIELD_PSSYSCSSNAME, pSSysCssName);
    }

    @JsonIgnore
    public boolean isPSSysCssNameDirty() {
        return this.contains(FIELD_PSSYSCSSNAME);
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
    public String getPSSysImageId() {
        Object objValue = this.get(FIELD_PSSYSIMAGEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimageid")
    public void setPSSysImageId(String pSSysImageId) {
        this.set(FIELD_PSSYSIMAGEID, pSSysImageId);
    }

    @JsonIgnore
    public boolean isPSSysImageIdDirty() {
        return this.contains(FIELD_PSSYSIMAGEID);
    }

    @JsonIgnore
    public String getPSSysImageName() {
        Object objValue = this.get(FIELD_PSSYSIMAGENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysimagename")
    public void setPSSysImageName(String pSSysImageName) {
        this.set(FIELD_PSSYSIMAGENAME, pSSysImageName);
    }

    @JsonIgnore
    public boolean isPSSysImageNameDirty() {
        return this.contains(FIELD_PSSYSIMAGENAME);
    }

    @JsonIgnore
    public String getPSSysMsgTemplId() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplid")
    public void setPSSysMsgTemplId(String pSSysMsgTemplId) {
        this.set(FIELD_PSSYSMSGTEMPLID, pSSysMsgTemplId);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplIdDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLID);
    }

    @JsonIgnore
    public String getPSSysMsgTemplName() {
        Object objValue = this.get(FIELD_PSSYSMSGTEMPLNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysmsgtemplname")
    public void setPSSysMsgTemplName(String pSSysMsgTemplName) {
        this.set(FIELD_PSSYSMSGTEMPLNAME, pSSysMsgTemplName);
    }

    @JsonIgnore
    public boolean isPSSysMsgTemplNameDirty() {
        return this.contains(FIELD_PSSYSMSGTEMPLNAME);
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
    public String getPSSysViewPanelId() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelid")
    public void setPSSysViewPanelId(String pSSysViewPanelId) {
        this.set(FIELD_PSSYSVIEWPANELID, pSSysViewPanelId);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelIdDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELID);
    }

    @JsonIgnore
    public String getPSSysViewPanelName() {
        Object objValue = this.get(FIELD_PSSYSVIEWPANELNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="pssysviewpanelname")
    public void setPSSysViewPanelName(String pSSysViewPanelName) {
        this.set(FIELD_PSSYSVIEWPANELNAME, pSSysViewPanelName);
    }

    @JsonIgnore
    public boolean isPSSysViewPanelNameDirty() {
        return this.contains(FIELD_PSSYSVIEWPANELNAME);
    }

    @JsonIgnore
    public String getPSViewMsgId() {
        Object objValue = this.get(FIELD_PSVIEWMSGID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsgid")
    public void setPSViewMsgId(String pSViewMsgId) {
        this.set(FIELD_PSVIEWMSGID, pSViewMsgId);
    }

    @JsonIgnore
    public boolean isPSViewMsgIdDirty() {
        return this.contains(FIELD_PSVIEWMSGID);
    }

    @JsonIgnore
    public String getPSViewMsgName() {
        Object objValue = this.get(FIELD_PSVIEWMSGNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psviewmsgname")
    public void setPSViewMsgName(String pSViewMsgName) {
        this.set(FIELD_PSVIEWMSGNAME, pSViewMsgName);
    }

    @JsonIgnore
    public boolean isPSViewMsgNameDirty() {
        return this.contains(FIELD_PSVIEWMSGNAME);
    }

    @JsonIgnore
    public String getRemovePSDEFId() {
        Object objValue = this.get(FIELD_REMOVEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdefid")
    public void setRemovePSDEFId(String removePSDEFId) {
        this.set(FIELD_REMOVEPSDEFID, removePSDEFId);
    }

    @JsonIgnore
    public boolean isRemovePSDEFIdDirty() {
        return this.contains(FIELD_REMOVEPSDEFID);
    }

    @JsonIgnore
    public String getRemovePSDEFName() {
        Object objValue = this.get(FIELD_REMOVEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="removepsdefname")
    public void setRemovePSDEFName(String removePSDEFName) {
        this.set(FIELD_REMOVEPSDEFNAME, removePSDEFName);
    }

    @JsonIgnore
    public boolean isRemovePSDEFNameDirty() {
        return this.contains(FIELD_REMOVEPSDEFNAME);
    }

    @JsonIgnore
    public Integer getTimeout() {
        Object objValue = this.get(FIELD_TIMEOUT);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="timeout")
    public void setTimeout(Integer timeout) {
        this.set(FIELD_TIMEOUT, timeout);
    }

    @JsonIgnore
    public boolean isTimeoutDirty() {
        return this.contains(FIELD_TIMEOUT);
    }

    @JsonIgnore
    public String getTitle() {
        Object objValue = this.get(FIELD_TITLE);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="title")
    public void setTitle(String title) {
        this.set(FIELD_TITLE, title);
    }

    @JsonIgnore
    public boolean isTitleDirty() {
        return this.contains(FIELD_TITLE);
    }

    @JsonIgnore
    public String getTitleLanResTagPSDEFId() {
        Object objValue = this.get(FIELD_TITLELANRESTAGPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlelanrestagpsdefid")
    public void setTitleLanResTagPSDEFId(String titleLanResTagPSDEFId) {
        this.set(FIELD_TITLELANRESTAGPSDEFID, titleLanResTagPSDEFId);
    }

    @JsonIgnore
    public boolean isTitleLanResTagPSDEFIdDirty() {
        return this.contains(FIELD_TITLELANRESTAGPSDEFID);
    }

    @JsonIgnore
    public String getTitleLanResTagPSDEFName() {
        Object objValue = this.get(FIELD_TITLELANRESTAGPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlelanrestagpsdefname")
    public void setTitleLanResTagPSDEFName(String titleLanResTagPSDEFName) {
        this.set(FIELD_TITLELANRESTAGPSDEFNAME, titleLanResTagPSDEFName);
    }

    @JsonIgnore
    public boolean isTitleLanResTagPSDEFNameDirty() {
        return this.contains(FIELD_TITLELANRESTAGPSDEFNAME);
    }

    @JsonIgnore
    public String getTitlePSDEFId() {
        Object objValue = this.get(FIELD_TITLEPSDEFID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepsdefid")
    public void setTitlePSDEFId(String titlePSDEFId) {
        this.set(FIELD_TITLEPSDEFID, titlePSDEFId);
    }

    @JsonIgnore
    public boolean isTitlePSDEFIdDirty() {
        return this.contains(FIELD_TITLEPSDEFID);
    }

    @JsonIgnore
    public String getTitlePSDEFName() {
        Object objValue = this.get(FIELD_TITLEPSDEFNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepsdefname")
    public void setTitlePSDEFName(String titlePSDEFName) {
        this.set(FIELD_TITLEPSDEFNAME, titlePSDEFName);
    }

    @JsonIgnore
    public boolean isTitlePSDEFNameDirty() {
        return this.contains(FIELD_TITLEPSDEFNAME);
    }

    @JsonIgnore
    public String getTitlePSLanResId() {
        Object objValue = this.get(FIELD_TITLEPSLANRESID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresid")
    public void setTitlePSLanResId(String titlePSLanResId) {
        this.set(FIELD_TITLEPSLANRESID, titlePSLanResId);
    }

    @JsonIgnore
    public boolean isTitlePSLanResIdDirty() {
        return this.contains(FIELD_TITLEPSLANRESID);
    }

    @JsonIgnore
    public String getTitlePSLanResName() {
        Object objValue = this.get(FIELD_TITLEPSLANRESNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="titlepslanresname")
    public void setTitlePSLanResName(String titlePSLanResName) {
        this.set(FIELD_TITLEPSLANRESNAME, titlePSLanResName);
    }

    @JsonIgnore
    public boolean isTitlePSLanResNameDirty() {
        return this.contains(FIELD_TITLEPSLANRESNAME);
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

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSViewMsgId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSViewMsgId(strValue);
    }
}

