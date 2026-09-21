/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wx.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.service.OrgService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXAccountBase.class);
    public static final String FIELD_APIAPPID = "APIAPPID";
    public static final String FIELD_APIAPPSECRET = "APIAPPSECRET";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_APIURL = "APIURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORGID = "ORGID";
    public static final String FIELD_ORGNAME = "ORGNAME";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WXACCOUNTID = "WXACCOUNTID";
    public static final String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    private static final int INDEX_APIAPPID = 0;
    private static final int INDEX_APIAPPSECRET = 1;
    private static final int INDEX_APITOKEN = 2;
    private static final int INDEX_APIURL = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORGID = 7;
    private static final int INDEX_ORGNAME = 8;
    private static final int INDEX_RESERVER = 9;
    private static final int INDEX_RESERVER2 = 10;
    private static final int INDEX_RESERVER3 = 11;
    private static final int INDEX_RESERVER4 = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VALIDFLAG = 15;
    private static final int INDEX_WXACCOUNTID = 16;
    private static final int INDEX_WXACCOUNTNAME = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WXAccountBase proxyWXAccountBase = null;
    private boolean apiappidDirtyFlag = false;
    private boolean apiappsecretDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean apiurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgidDirtyFlag = false;
    private boolean orgnameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    @Column(name="apiappid")
    private String apiappid;
    @Column(name="apiappsecret")
    private String apiappsecret;
    @Column(name="apitoken")
    private String apitoken;
    @Column(name="apiurl")
    private String apiurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="orgid")
    private String orgid;
    @Column(name="orgname")
    private String orgname;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;
    private Integer objOrgLock = new Integer(1);
    private Org org = null;

    static {
        fieldIndexMap.put(FIELD_APIAPPID, 0);
        fieldIndexMap.put(FIELD_APIAPPSECRET, 1);
        fieldIndexMap.put(FIELD_APITOKEN, 2);
        fieldIndexMap.put(FIELD_APIURL, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORGID, 7);
        fieldIndexMap.put(FIELD_ORGNAME, 8);
        fieldIndexMap.put(FIELD_RESERVER, 9);
        fieldIndexMap.put(FIELD_RESERVER2, 10);
        fieldIndexMap.put(FIELD_RESERVER3, 11);
        fieldIndexMap.put(FIELD_RESERVER4, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VALIDFLAG, 15);
        fieldIndexMap.put(FIELD_WXACCOUNTID, 16);
        fieldIndexMap.put(FIELD_WXACCOUNTNAME, 17);
    }

    public void setAPIAppId(String apiappid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIAppId(apiappid);
            return;
        }
        if (apiappid != null && (apiappid = StringHelper.trimRight(apiappid)).length() == 0) {
            apiappid = null;
        }
        this.apiappid = apiappid;
        this.apiappidDirtyFlag = true;
    }

    public String getAPIAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIAppId();
        }
        return this.apiappid;
    }

    public boolean isAPIAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIAppIdDirty();
        }
        return this.apiappidDirtyFlag;
    }

    public void resetAPIAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIAppId();
            return;
        }
        this.apiappidDirtyFlag = false;
        this.apiappid = null;
    }

    public void setAPIAppSecret(String apiappsecret) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIAppSecret(apiappsecret);
            return;
        }
        if (apiappsecret != null && (apiappsecret = StringHelper.trimRight(apiappsecret)).length() == 0) {
            apiappsecret = null;
        }
        this.apiappsecret = apiappsecret;
        this.apiappsecretDirtyFlag = true;
    }

    public String getAPIAppSecret() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIAppSecret();
        }
        return this.apiappsecret;
    }

    public boolean isAPIAppSecretDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIAppSecretDirty();
        }
        return this.apiappsecretDirtyFlag;
    }

    public void resetAPIAppSecret() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIAppSecret();
            return;
        }
        this.apiappsecretDirtyFlag = false;
        this.apiappsecret = null;
    }

    public void setAPIToken(String apitoken) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIToken(apitoken);
            return;
        }
        if (apitoken != null && (apitoken = StringHelper.trimRight(apitoken)).length() == 0) {
            apitoken = null;
        }
        this.apitoken = apitoken;
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

    public void setAPIURL(String apiurl) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIURL(apiurl);
            return;
        }
        if (apiurl != null && (apiurl = StringHelper.trimRight(apiurl)).length() == 0) {
            apiurl = null;
        }
        this.apiurl = apiurl;
        this.apiurlDirtyFlag = true;
    }

    public String getAPIURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIURL();
        }
        return this.apiurl;
    }

    public boolean isAPIURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIURLDirty();
        }
        return this.apiurlDirtyFlag;
    }

    public void resetAPIURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIURL();
            return;
        }
        this.apiurlDirtyFlag = false;
        this.apiurl = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setOrgId(String orgid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgId(orgid);
            return;
        }
        if (orgid != null && (orgid = StringHelper.trimRight(orgid)).length() == 0) {
            orgid = null;
        }
        this.orgid = orgid;
        this.orgidDirtyFlag = true;
    }

    public String getOrgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgId();
        }
        return this.orgid;
    }

    public boolean isOrgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgIdDirty();
        }
        return this.orgidDirtyFlag;
    }

    public void resetOrgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgId();
            return;
        }
        this.orgidDirtyFlag = false;
        this.orgid = null;
    }

    public void setOrgName(String orgname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgName(orgname);
            return;
        }
        if (orgname != null && (orgname = StringHelper.trimRight(orgname)).length() == 0) {
            orgname = null;
        }
        this.orgname = orgname;
        this.orgnameDirtyFlag = true;
    }

    public String getOrgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgName();
        }
        return this.orgname;
    }

    public boolean isOrgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgNameDirty();
        }
        return this.orgnameDirtyFlag;
    }

    public void resetOrgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgName();
            return;
        }
        this.orgnameDirtyFlag = false;
        this.orgname = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
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

    public void setWXAccountId(String wxaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountId(wxaccountid);
            return;
        }
        if (wxaccountid != null && (wxaccountid = StringHelper.trimRight(wxaccountid)).length() == 0) {
            wxaccountid = null;
        }
        this.wxaccountid = wxaccountid;
        this.wxaccountidDirtyFlag = true;
    }

    public String getWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountId();
        }
        return this.wxaccountid;
    }

    public boolean isWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountIdDirty();
        }
        return this.wxaccountidDirtyFlag;
    }

    public void resetWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountId();
            return;
        }
        this.wxaccountidDirtyFlag = false;
        this.wxaccountid = null;
    }

    public void setWXAccountName(String wxaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountName(wxaccountname);
            return;
        }
        if (wxaccountname != null && (wxaccountname = StringHelper.trimRight(wxaccountname)).length() == 0) {
            wxaccountname = null;
        }
        this.wxaccountname = wxaccountname;
        this.wxaccountnameDirtyFlag = true;
    }

    public String getWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountName();
        }
        return this.wxaccountname;
    }

    public boolean isWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountNameDirty();
        }
        return this.wxaccountnameDirtyFlag;
    }

    public void resetWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountName();
            return;
        }
        this.wxaccountnameDirtyFlag = false;
        this.wxaccountname = null;
    }

    @Override
    protected void onReset() {
        WXAccountBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WXAccountBase et) {
        et.resetAPIAppId();
        et.resetAPIAppSecret();
        et.resetAPIToken();
        et.resetAPIURL();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetOrgId();
        et.resetOrgName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
        et.resetWXAccountId();
        et.resetWXAccountName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAPIAppIdDirty()) {
            params.put(FIELD_APIAPPID, this.getAPIAppId());
        }
        if (!bDirtyOnly || this.isAPIAppSecretDirty()) {
            params.put(FIELD_APIAPPSECRET, this.getAPIAppSecret());
        }
        if (!bDirtyOnly || this.isAPITokenDirty()) {
            params.put(FIELD_APITOKEN, this.getAPIToken());
        }
        if (!bDirtyOnly || this.isAPIURLDirty()) {
            params.put(FIELD_APIURL, this.getAPIURL());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOrgIdDirty()) {
            params.put(FIELD_ORGID, this.getOrgId());
        }
        if (!bDirtyOnly || this.isOrgNameDirty()) {
            params.put(FIELD_ORGNAME, this.getOrgName());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bDirtyOnly || this.isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID, this.getWXAccountId());
        }
        if (!bDirtyOnly || this.isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME, this.getWXAccountName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WXAccountBase.get(this, index);
    }

    private static Object get(WXAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAPIAppId();
            }
            case 1: {
                return et.getAPIAppSecret();
            }
            case 2: {
                return et.getAPIToken();
            }
            case 3: {
                return et.getAPIURL();
            }
            case 4: {
                return et.getCreateDate();
            }
            case 5: {
                return et.getCreateMan();
            }
            case 6: {
                return et.getMemo();
            }
            case 7: {
                return et.getOrgId();
            }
            case 8: {
                return et.getOrgName();
            }
            case 9: {
                return et.getReserver();
            }
            case 10: {
                return et.getReserver2();
            }
            case 11: {
                return et.getReserver3();
            }
            case 12: {
                return et.getReserver4();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
                return et.getUpdateMan();
            }
            case 15: {
                return et.getValidFlag();
            }
            case 16: {
                return et.getWXAccountId();
            }
            case 17: {
                return et.getWXAccountName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WXAccountBase.set(this, index, objValue);
    }

    private static void set(WXAccountBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAPIAppId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setAPIAppSecret(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setAPIToken(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setAPIURL(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setOrgId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setOrgName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 14: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 16: {
                et.setWXAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWXAccountName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WXAccountBase.isNull(this, index);
    }

    private static boolean isNull(WXAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAPIAppId() == null;
            }
            case 1: {
                return et.getAPIAppSecret() == null;
            }
            case 2: {
                return et.getAPIToken() == null;
            }
            case 3: {
                return et.getAPIURL() == null;
            }
            case 4: {
                return et.getCreateDate() == null;
            }
            case 5: {
                return et.getCreateMan() == null;
            }
            case 6: {
                return et.getMemo() == null;
            }
            case 7: {
                return et.getOrgId() == null;
            }
            case 8: {
                return et.getOrgName() == null;
            }
            case 9: {
                return et.getReserver() == null;
            }
            case 10: {
                return et.getReserver2() == null;
            }
            case 11: {
                return et.getReserver3() == null;
            }
            case 12: {
                return et.getReserver4() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
                return et.getUpdateMan() == null;
            }
            case 15: {
                return et.getValidFlag() == null;
            }
            case 16: {
                return et.getWXAccountId() == null;
            }
            case 17: {
                return et.getWXAccountName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WXAccountBase.contains(this, index);
    }

    private static boolean contains(WXAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAPIAppIdDirty();
            }
            case 1: {
                return et.isAPIAppSecretDirty();
            }
            case 2: {
                return et.isAPITokenDirty();
            }
            case 3: {
                return et.isAPIURLDirty();
            }
            case 4: {
                return et.isCreateDateDirty();
            }
            case 5: {
                return et.isCreateManDirty();
            }
            case 6: {
                return et.isMemoDirty();
            }
            case 7: {
                return et.isOrgIdDirty();
            }
            case 8: {
                return et.isOrgNameDirty();
            }
            case 9: {
                return et.isReserverDirty();
            }
            case 10: {
                return et.isReserver2Dirty();
            }
            case 11: {
                return et.isReserver3Dirty();
            }
            case 12: {
                return et.isReserver4Dirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
            case 15: {
                return et.isValidFlagDirty();
            }
            case 16: {
                return et.isWXAccountIdDirty();
            }
            case 17: {
                return et.isWXAccountNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WXAccountBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WXAccountBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAPIAppId() != null) {
            JSONObjectHelper.put(json, "apiappid", WXAccountBase.getJSONValue(et.getAPIAppId()), false);
        }
        if (bIncEmpty || et.getAPIAppSecret() != null) {
            JSONObjectHelper.put(json, "apiappsecret", WXAccountBase.getJSONValue(et.getAPIAppSecret()), false);
        }
        if (bIncEmpty || et.getAPIToken() != null) {
            JSONObjectHelper.put(json, "apitoken", WXAccountBase.getJSONValue(et.getAPIToken()), false);
        }
        if (bIncEmpty || et.getAPIURL() != null) {
            JSONObjectHelper.put(json, "apiurl", WXAccountBase.getJSONValue(et.getAPIURL()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WXAccountBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WXAccountBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WXAccountBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrgId() != null) {
            JSONObjectHelper.put(json, "orgid", WXAccountBase.getJSONValue(et.getOrgId()), false);
        }
        if (bIncEmpty || et.getOrgName() != null) {
            JSONObjectHelper.put(json, "orgname", WXAccountBase.getJSONValue(et.getOrgName()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WXAccountBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WXAccountBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", WXAccountBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", WXAccountBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WXAccountBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WXAccountBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", WXAccountBase.getJSONValue(et.getValidFlag()), false);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            JSONObjectHelper.put(json, "wxaccountid", WXAccountBase.getJSONValue(et.getWXAccountId()), false);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            JSONObjectHelper.put(json, "wxaccountname", WXAccountBase.getJSONValue(et.getWXAccountName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WXAccountBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WXAccountBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAPIAppId() != null) {
            obj = et.getAPIAppId();
            node.setAttribute(FIELD_APIAPPID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAPIAppSecret() != null) {
            obj = et.getAPIAppSecret();
            node.setAttribute(FIELD_APIAPPSECRET, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAPIToken() != null) {
            obj = et.getAPIToken();
            node.setAttribute(FIELD_APITOKEN, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAPIURL() != null) {
            obj = et.getAPIURL();
            node.setAttribute(FIELD_APIURL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgId() != null) {
            obj = et.getOrgId();
            node.setAttribute(FIELD_ORGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgName() != null) {
            obj = et.getOrgName();
            node.setAttribute(FIELD_ORGNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            obj = et.getWXAccountId();
            node.setAttribute(FIELD_WXACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            obj = et.getWXAccountName();
            node.setAttribute(FIELD_WXACCOUNTNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXAccountBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WXAccountBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAPIAppIdDirty() && (bIncEmpty || et.getAPIAppId() != null)) {
            dst.set(FIELD_APIAPPID, et.getAPIAppId());
        }
        if (et.isAPIAppSecretDirty() && (bIncEmpty || et.getAPIAppSecret() != null)) {
            dst.set(FIELD_APIAPPSECRET, et.getAPIAppSecret());
        }
        if (et.isAPITokenDirty() && (bIncEmpty || et.getAPIToken() != null)) {
            dst.set(FIELD_APITOKEN, et.getAPIToken());
        }
        if (et.isAPIURLDirty() && (bIncEmpty || et.getAPIURL() != null)) {
            dst.set(FIELD_APIURL, et.getAPIURL());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrgIdDirty() && (bIncEmpty || et.getOrgId() != null)) {
            dst.set(FIELD_ORGID, et.getOrgId());
        }
        if (et.isOrgNameDirty() && (bIncEmpty || et.getOrgName() != null)) {
            dst.set(FIELD_ORGNAME, et.getOrgName());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
        }
        if (et.isWXAccountIdDirty() && (bIncEmpty || et.getWXAccountId() != null)) {
            dst.set(FIELD_WXACCOUNTID, et.getWXAccountId());
        }
        if (et.isWXAccountNameDirty() && (bIncEmpty || et.getWXAccountName() != null)) {
            dst.set(FIELD_WXACCOUNTNAME, et.getWXAccountName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WXAccountBase.remove(this, index);
    }

    private static boolean remove(WXAccountBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAPIAppId();
                return true;
            }
            case 1: {
                et.resetAPIAppSecret();
                return true;
            }
            case 2: {
                et.resetAPIToken();
                return true;
            }
            case 3: {
                et.resetAPIURL();
                return true;
            }
            case 4: {
                et.resetCreateDate();
                return true;
            }
            case 5: {
                et.resetCreateMan();
                return true;
            }
            case 6: {
                et.resetMemo();
                return true;
            }
            case 7: {
                et.resetOrgId();
                return true;
            }
            case 8: {
                et.resetOrgName();
                return true;
            }
            case 9: {
                et.resetReserver();
                return true;
            }
            case 10: {
                et.resetReserver2();
                return true;
            }
            case 11: {
                et.resetReserver3();
                return true;
            }
            case 12: {
                et.resetReserver4();
                return true;
            }
            case 13: {
                et.resetUpdateDate();
                return true;
            }
            case 14: {
                et.resetUpdateMan();
                return true;
            }
            case 15: {
                et.resetValidFlag();
                return true;
            }
            case 16: {
                et.resetWXAccountId();
                return true;
            }
            case 17: {
                et.resetWXAccountName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Org getOrg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrg();
        }
        if (this.getOrgId() == null) {
            return null;
        }
        Integer n = this.objOrgLock;
        synchronized (n) {
            if (this.org != null && DataTypeHelper.compare(25, (Object)this.getOrgId(), (Object)this.org.getOrgId()) != 0L) {
                this.org = null;
            }
            if (this.org == null) {
                Org org = new Org();
                org.setOrgId(this.getOrgId());
                OrgService service = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
                service.autoGet(org);
                this.org = org;
            }
            return this.org;
        }
    }

    private WXAccountBase getProxyEntity() {
        return this.proxyWXAccountBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXAccountBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WXAccountBase) {
            this.proxyWXAccountBase = (WXAccountBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXAccountService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

