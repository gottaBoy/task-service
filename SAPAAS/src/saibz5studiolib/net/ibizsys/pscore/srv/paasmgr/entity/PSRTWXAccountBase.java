/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSRTWXAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRTWXAccountBase.class);
    public static final String FIELD_APPID = "APIAPPID";
    public static final String FIELD_APPSECRET = "APIAPPSECRET";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_APIURL = "APIURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURUSERCNT = "CURUSERCNT";
    public static final String FIELD_MAXUSERCNT = "MAXUSERCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSRTWXACCOUNTID = "PSRTWXACCOUNTID";
    public static final String FIELD_PSRTWXACCOUNTNAME = "PSRTWXACCOUNTNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APPID = 0;
    private static final int INDEX_APPSECRET = 1;
    private static final int INDEX_APITOKEN = 2;
    private static final int INDEX_APIURL = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CURUSERCNT = 6;
    private static final int INDEX_MAXUSERCNT = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PSRTWXACCOUNTID = 9;
    private static final int INDEX_PSRTWXACCOUNTNAME = 10;
    private static final int INDEX_PSSVRDOMAINID = 11;
    private static final int INDEX_PSSVRDOMAINNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRTWXAccountBase proxyPSRTWXAccountBase = null;
    private boolean appidDirtyFlag = false;
    private boolean appsecretDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean apiurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curusercntDirtyFlag = false;
    private boolean maxusercntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrtwxaccountidDirtyFlag = false;
    private boolean psrtwxaccountnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="appid")
    private String appid;
    @Column(name="appsecret")
    private String appsecret;
    @Column(name="apitoken")
    private String apitoken;
    @Column(name="apiurl")
    private String apiurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curusercnt")
    private Integer curusercnt;
    @Column(name="maxusercnt")
    private Integer maxusercnt;
    @Column(name="memo")
    private String memo;
    @Column(name="psrtwxaccountid")
    private String psrtwxaccountid;
    @Column(name="psrtwxaccountname")
    private String psrtwxaccountname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;

    public void setAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appid = string;
        this.appidDirtyFlag = true;
    }

    public String getAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppId();
        }
        return this.appid;
    }

    public boolean isAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppIdDirty();
        }
        return this.appidDirtyFlag;
    }

    public void resetAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppId();
            return;
        }
        this.appidDirtyFlag = false;
        this.appid = null;
    }

    public void setAppSecret(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppSecret(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appsecret = string;
        this.appsecretDirtyFlag = true;
    }

    public String getAppSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppSecret();
        }
        return this.appsecret;
    }

    public boolean isAppSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppSecretDirty();
        }
        return this.appsecretDirtyFlag;
    }

    public void resetAppSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppSecret();
            return;
        }
        this.appsecretDirtyFlag = false;
        this.appsecret = null;
    }

    public void setAPIToken(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIToken(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apitoken = string;
        this.apitokenDirtyFlag = true;
    }

    public String getAPIToken() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIToken();
        }
        return this.apitoken;
    }

    public boolean isAPITokenDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPITokenDirty();
        }
        return this.apitokenDirtyFlag;
    }

    public void resetAPIToken() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIToken();
            return;
        }
        this.apitokenDirtyFlag = false;
        this.apitoken = null;
    }

    public void setAPIUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apiurl = string;
        this.apiurlDirtyFlag = true;
    }

    public String getAPIUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIUrl();
        }
        return this.apiurl;
    }

    public boolean isAPIUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIUrlDirty();
        }
        return this.apiurlDirtyFlag;
    }

    public void resetAPIUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIUrl();
            return;
        }
        this.apiurlDirtyFlag = false;
        this.apiurl = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCurUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurUserCnt(n);
            return;
        }
        this.curusercnt = n;
        this.curusercntDirtyFlag = true;
    }

    public Integer getCurUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurUserCnt();
        }
        return this.curusercnt;
    }

    public boolean isCurUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurUserCntDirty();
        }
        return this.curusercntDirtyFlag;
    }

    public void resetCurUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurUserCnt();
            return;
        }
        this.curusercntDirtyFlag = false;
        this.curusercnt = null;
    }

    public void setMaxUserCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxUserCnt(n);
            return;
        }
        this.maxusercnt = n;
        this.maxusercntDirtyFlag = true;
    }

    public Integer getMaxUserCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxUserCnt();
        }
        return this.maxusercnt;
    }

    public boolean isMaxUserCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxUserCntDirty();
        }
        return this.maxusercntDirtyFlag;
    }

    public void resetMaxUserCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxUserCnt();
            return;
        }
        this.maxusercntDirtyFlag = false;
        this.maxusercnt = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setPSRTWXAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRTWXAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrtwxaccountid = string;
        this.psrtwxaccountidDirtyFlag = true;
    }

    public String getPSRTWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRTWXAccountId();
        }
        return this.psrtwxaccountid;
    }

    public boolean isPSRTWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRTWXAccountIdDirty();
        }
        return this.psrtwxaccountidDirtyFlag;
    }

    public void resetPSRTWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRTWXAccountId();
            return;
        }
        this.psrtwxaccountidDirtyFlag = false;
        this.psrtwxaccountid = null;
    }

    public void setPSRTWXAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRTWXAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrtwxaccountname = string;
        this.psrtwxaccountnameDirtyFlag = true;
    }

    public String getPSRTWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRTWXAccountName();
        }
        return this.psrtwxaccountname;
    }

    public boolean isPSRTWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRTWXAccountNameDirty();
        }
        return this.psrtwxaccountnameDirtyFlag;
    }

    public void resetPSRTWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRTWXAccountName();
            return;
        }
        this.psrtwxaccountnameDirtyFlag = false;
        this.psrtwxaccountname = null;
    }

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSRTWXAccountBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRTWXAccountBase pSRTWXAccountBase) {
        pSRTWXAccountBase.resetAppId();
        pSRTWXAccountBase.resetAppSecret();
        pSRTWXAccountBase.resetAPIToken();
        pSRTWXAccountBase.resetAPIUrl();
        pSRTWXAccountBase.resetCreateDate();
        pSRTWXAccountBase.resetCreateMan();
        pSRTWXAccountBase.resetCurUserCnt();
        pSRTWXAccountBase.resetMaxUserCnt();
        pSRTWXAccountBase.resetMemo();
        pSRTWXAccountBase.resetPSRTWXAccountId();
        pSRTWXAccountBase.resetPSRTWXAccountName();
        pSRTWXAccountBase.resetPSSvrDomainId();
        pSRTWXAccountBase.resetPSSvrDomainName();
        pSRTWXAccountBase.resetUpdateDate();
        pSRTWXAccountBase.resetUpdateMan();
        pSRTWXAccountBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppIdDirty()) {
            hashMap.put(FIELD_APPID, this.getAppId());
        }
        if (!bl || this.isAppSecretDirty()) {
            hashMap.put(FIELD_APPSECRET, this.getAppSecret());
        }
        if (!bl || this.isAPITokenDirty()) {
            hashMap.put(FIELD_APITOKEN, this.getAPIToken());
        }
        if (!bl || this.isAPIUrlDirty()) {
            hashMap.put(FIELD_APIURL, this.getAPIUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurUserCntDirty()) {
            hashMap.put(FIELD_CURUSERCNT, this.getCurUserCnt());
        }
        if (!bl || this.isMaxUserCntDirty()) {
            hashMap.put(FIELD_MAXUSERCNT, this.getMaxUserCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSRTWXAccountIdDirty()) {
            hashMap.put(FIELD_PSRTWXACCOUNTID, this.getPSRTWXAccountId());
        }
        if (!bl || this.isPSRTWXAccountNameDirty()) {
            hashMap.put(FIELD_PSRTWXACCOUNTNAME, this.getPSRTWXAccountName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSRTWXAccountBase.get(this, n);
    }

    private static Object get(PSRTWXAccountBase pSRTWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRTWXAccountBase.getAppId();
            }
            case 1: {
                return pSRTWXAccountBase.getAppSecret();
            }
            case 2: {
                return pSRTWXAccountBase.getAPIToken();
            }
            case 3: {
                return pSRTWXAccountBase.getAPIUrl();
            }
            case 4: {
                return pSRTWXAccountBase.getCreateDate();
            }
            case 5: {
                return pSRTWXAccountBase.getCreateMan();
            }
            case 6: {
                return pSRTWXAccountBase.getCurUserCnt();
            }
            case 7: {
                return pSRTWXAccountBase.getMaxUserCnt();
            }
            case 8: {
                return pSRTWXAccountBase.getMemo();
            }
            case 9: {
                return pSRTWXAccountBase.getPSRTWXAccountId();
            }
            case 10: {
                return pSRTWXAccountBase.getPSRTWXAccountName();
            }
            case 11: {
                return pSRTWXAccountBase.getPSSvrDomainId();
            }
            case 12: {
                return pSRTWXAccountBase.getPSSvrDomainName();
            }
            case 13: {
                return pSRTWXAccountBase.getUpdateDate();
            }
            case 14: {
                return pSRTWXAccountBase.getUpdateMan();
            }
            case 15: {
                return pSRTWXAccountBase.getValidFlag();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSRTWXAccountBase.set(this, n, object);
    }

    private static void set(PSRTWXAccountBase pSRTWXAccountBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRTWXAccountBase.setAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSRTWXAccountBase.setAppSecret(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRTWXAccountBase.setAPIToken(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRTWXAccountBase.setAPIUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRTWXAccountBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSRTWXAccountBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRTWXAccountBase.setCurUserCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSRTWXAccountBase.setMaxUserCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSRTWXAccountBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSRTWXAccountBase.setPSRTWXAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSRTWXAccountBase.setPSRTWXAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSRTWXAccountBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSRTWXAccountBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSRTWXAccountBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSRTWXAccountBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSRTWXAccountBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSRTWXAccountBase.isNull(this, n);
    }

    private static boolean isNull(PSRTWXAccountBase pSRTWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRTWXAccountBase.getAppId() == null;
            }
            case 1: {
                return pSRTWXAccountBase.getAppSecret() == null;
            }
            case 2: {
                return pSRTWXAccountBase.getAPIToken() == null;
            }
            case 3: {
                return pSRTWXAccountBase.getAPIUrl() == null;
            }
            case 4: {
                return pSRTWXAccountBase.getCreateDate() == null;
            }
            case 5: {
                return pSRTWXAccountBase.getCreateMan() == null;
            }
            case 6: {
                return pSRTWXAccountBase.getCurUserCnt() == null;
            }
            case 7: {
                return pSRTWXAccountBase.getMaxUserCnt() == null;
            }
            case 8: {
                return pSRTWXAccountBase.getMemo() == null;
            }
            case 9: {
                return pSRTWXAccountBase.getPSRTWXAccountId() == null;
            }
            case 10: {
                return pSRTWXAccountBase.getPSRTWXAccountName() == null;
            }
            case 11: {
                return pSRTWXAccountBase.getPSSvrDomainId() == null;
            }
            case 12: {
                return pSRTWXAccountBase.getPSSvrDomainName() == null;
            }
            case 13: {
                return pSRTWXAccountBase.getUpdateDate() == null;
            }
            case 14: {
                return pSRTWXAccountBase.getUpdateMan() == null;
            }
            case 15: {
                return pSRTWXAccountBase.getValidFlag() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSRTWXAccountBase.contains(this, n);
    }

    private static boolean contains(PSRTWXAccountBase pSRTWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRTWXAccountBase.isAppIdDirty();
            }
            case 1: {
                return pSRTWXAccountBase.isAppSecretDirty();
            }
            case 2: {
                return pSRTWXAccountBase.isAPITokenDirty();
            }
            case 3: {
                return pSRTWXAccountBase.isAPIUrlDirty();
            }
            case 4: {
                return pSRTWXAccountBase.isCreateDateDirty();
            }
            case 5: {
                return pSRTWXAccountBase.isCreateManDirty();
            }
            case 6: {
                return pSRTWXAccountBase.isCurUserCntDirty();
            }
            case 7: {
                return pSRTWXAccountBase.isMaxUserCntDirty();
            }
            case 8: {
                return pSRTWXAccountBase.isMemoDirty();
            }
            case 9: {
                return pSRTWXAccountBase.isPSRTWXAccountIdDirty();
            }
            case 10: {
                return pSRTWXAccountBase.isPSRTWXAccountNameDirty();
            }
            case 11: {
                return pSRTWXAccountBase.isPSSvrDomainIdDirty();
            }
            case 12: {
                return pSRTWXAccountBase.isPSSvrDomainNameDirty();
            }
            case 13: {
                return pSRTWXAccountBase.isUpdateDateDirty();
            }
            case 14: {
                return pSRTWXAccountBase.isUpdateManDirty();
            }
            case 15: {
                return pSRTWXAccountBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRTWXAccountBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRTWXAccountBase pSRTWXAccountBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRTWXAccountBase.getAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiappid", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getAppId()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getAppSecret() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiappsecret", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getAppSecret()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getAPIToken() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apitoken", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getAPIToken()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getAPIUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apiurl", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getAPIUrl()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getCurUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curusercnt", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getCurUserCnt()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getMaxUserCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxusercnt", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getMaxUserCnt()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getMemo()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getPSRTWXAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrtwxaccountid", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getPSRTWXAccountId()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getPSRTWXAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrtwxaccountname", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getPSRTWXAccountName()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRTWXAccountBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRTWXAccountBase.getJSONValue((Object)pSRTWXAccountBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRTWXAccountBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRTWXAccountBase pSRTWXAccountBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRTWXAccountBase.getAppId() != null) {
            object = pSRTWXAccountBase.getAppId();
            xmlNode.setAttribute("APPID", (String)(object == null ? "" : object));
        }
        if (bl || pSRTWXAccountBase.getAppSecret() != null) {
            object = pSRTWXAccountBase.getAppSecret();
            xmlNode.setAttribute("APPSECRET", (String)(object == null ? "" : object));
        }
        if (bl || pSRTWXAccountBase.getAPIToken() != null) {
            object = pSRTWXAccountBase.getAPIToken();
            xmlNode.setAttribute(FIELD_APITOKEN, (String)(object == null ? "" : object));
        }
        if (bl || pSRTWXAccountBase.getAPIUrl() != null) {
            object = pSRTWXAccountBase.getAPIUrl();
            xmlNode.setAttribute(FIELD_APIURL, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getCreateDate() != null) {
            object = pSRTWXAccountBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRTWXAccountBase.getCreateMan() != null) {
            object = pSRTWXAccountBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getCurUserCnt() != null) {
            object = pSRTWXAccountBase.getCurUserCnt();
            xmlNode.setAttribute(FIELD_CURUSERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRTWXAccountBase.getMaxUserCnt() != null) {
            object = pSRTWXAccountBase.getMaxUserCnt();
            xmlNode.setAttribute(FIELD_MAXUSERCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSRTWXAccountBase.getMemo() != null) {
            object = pSRTWXAccountBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getPSRTWXAccountId() != null) {
            object = pSRTWXAccountBase.getPSRTWXAccountId();
            xmlNode.setAttribute(FIELD_PSRTWXACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getPSRTWXAccountName() != null) {
            object = pSRTWXAccountBase.getPSRTWXAccountName();
            xmlNode.setAttribute(FIELD_PSRTWXACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getPSSvrDomainId() != null) {
            object = pSRTWXAccountBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getPSSvrDomainName() != null) {
            object = pSRTWXAccountBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getUpdateDate() != null) {
            object = pSRTWXAccountBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRTWXAccountBase.getUpdateMan() != null) {
            object = pSRTWXAccountBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRTWXAccountBase.getValidFlag() != null) {
            object = pSRTWXAccountBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRTWXAccountBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRTWXAccountBase pSRTWXAccountBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRTWXAccountBase.isAppIdDirty() && (bl || pSRTWXAccountBase.getAppId() != null)) {
            iDataObject.set(FIELD_APPID, (Object)pSRTWXAccountBase.getAppId());
        }
        if (pSRTWXAccountBase.isAppSecretDirty() && (bl || pSRTWXAccountBase.getAppSecret() != null)) {
            iDataObject.set(FIELD_APPSECRET, (Object)pSRTWXAccountBase.getAppSecret());
        }
        if (pSRTWXAccountBase.isAPITokenDirty() && (bl || pSRTWXAccountBase.getAPIToken() != null)) {
            iDataObject.set(FIELD_APITOKEN, (Object)pSRTWXAccountBase.getAPIToken());
        }
        if (pSRTWXAccountBase.isAPIUrlDirty() && (bl || pSRTWXAccountBase.getAPIUrl() != null)) {
            iDataObject.set(FIELD_APIURL, (Object)pSRTWXAccountBase.getAPIUrl());
        }
        if (pSRTWXAccountBase.isCreateDateDirty() && (bl || pSRTWXAccountBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRTWXAccountBase.getCreateDate());
        }
        if (pSRTWXAccountBase.isCreateManDirty() && (bl || pSRTWXAccountBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRTWXAccountBase.getCreateMan());
        }
        if (pSRTWXAccountBase.isCurUserCntDirty() && (bl || pSRTWXAccountBase.getCurUserCnt() != null)) {
            iDataObject.set(FIELD_CURUSERCNT, (Object)pSRTWXAccountBase.getCurUserCnt());
        }
        if (pSRTWXAccountBase.isMaxUserCntDirty() && (bl || pSRTWXAccountBase.getMaxUserCnt() != null)) {
            iDataObject.set(FIELD_MAXUSERCNT, (Object)pSRTWXAccountBase.getMaxUserCnt());
        }
        if (pSRTWXAccountBase.isMemoDirty() && (bl || pSRTWXAccountBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRTWXAccountBase.getMemo());
        }
        if (pSRTWXAccountBase.isPSRTWXAccountIdDirty() && (bl || pSRTWXAccountBase.getPSRTWXAccountId() != null)) {
            iDataObject.set(FIELD_PSRTWXACCOUNTID, (Object)pSRTWXAccountBase.getPSRTWXAccountId());
        }
        if (pSRTWXAccountBase.isPSRTWXAccountNameDirty() && (bl || pSRTWXAccountBase.getPSRTWXAccountName() != null)) {
            iDataObject.set(FIELD_PSRTWXACCOUNTNAME, (Object)pSRTWXAccountBase.getPSRTWXAccountName());
        }
        if (pSRTWXAccountBase.isPSSvrDomainIdDirty() && (bl || pSRTWXAccountBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSRTWXAccountBase.getPSSvrDomainId());
        }
        if (pSRTWXAccountBase.isPSSvrDomainNameDirty() && (bl || pSRTWXAccountBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSRTWXAccountBase.getPSSvrDomainName());
        }
        if (pSRTWXAccountBase.isUpdateDateDirty() && (bl || pSRTWXAccountBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRTWXAccountBase.getUpdateDate());
        }
        if (pSRTWXAccountBase.isUpdateManDirty() && (bl || pSRTWXAccountBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRTWXAccountBase.getUpdateMan());
        }
        if (pSRTWXAccountBase.isValidFlagDirty() && (bl || pSRTWXAccountBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRTWXAccountBase.getValidFlag());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSRTWXAccountBase.remove(this, n);
    }

    private static boolean remove(PSRTWXAccountBase pSRTWXAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRTWXAccountBase.resetAppId();
                return true;
            }
            case 1: {
                pSRTWXAccountBase.resetAppSecret();
                return true;
            }
            case 2: {
                pSRTWXAccountBase.resetAPIToken();
                return true;
            }
            case 3: {
                pSRTWXAccountBase.resetAPIUrl();
                return true;
            }
            case 4: {
                pSRTWXAccountBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSRTWXAccountBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSRTWXAccountBase.resetCurUserCnt();
                return true;
            }
            case 7: {
                pSRTWXAccountBase.resetMaxUserCnt();
                return true;
            }
            case 8: {
                pSRTWXAccountBase.resetMemo();
                return true;
            }
            case 9: {
                pSRTWXAccountBase.resetPSRTWXAccountId();
                return true;
            }
            case 10: {
                pSRTWXAccountBase.resetPSRTWXAccountName();
                return true;
            }
            case 11: {
                pSRTWXAccountBase.resetPSSvrDomainId();
                return true;
            }
            case 12: {
                pSRTWXAccountBase.resetPSSvrDomainName();
                return true;
            }
            case 13: {
                pSRTWXAccountBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSRTWXAccountBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSRTWXAccountBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet((IEntity)pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
        }
    }

    private PSRTWXAccountBase getProxyEntity() {
        return this.proxyPSRTWXAccountBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRTWXAccountBase = null;
        if (iDataObject != null && iDataObject instanceof PSRTWXAccountBase) {
            this.proxyPSRTWXAccountBase = (PSRTWXAccountBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSRTWXAccountService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPID, 0);
        fieldIndexMap.put(FIELD_APPSECRET, 1);
        fieldIndexMap.put(FIELD_APITOKEN, 2);
        fieldIndexMap.put(FIELD_APIURL, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CURUSERCNT, 6);
        fieldIndexMap.put(FIELD_MAXUSERCNT, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PSRTWXACCOUNTID, 9);
        fieldIndexMap.put(FIELD_PSRTWXACCOUNTNAME, 10);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 11);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
    }
}

