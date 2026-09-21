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
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXEntAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXEntAppBase.class);
    public static final String FIELD_AGENTID = "AGENTID";
    public static final String FIELD_APIAPPSECRET = "APIAPPSECRET";
    public static final String FIELD_APIENCODINGAESKEY = "APIENCODINGAESKEY";
    public static final String FIELD_APITOKEN = "APITOKEN";
    public static final String FIELD_APIURL = "APIURL";
    public static final String FIELD_APPTYPE = "APPTYPE";
    public static final String FIELD_APPURL = "APPURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_REPENTERFLAG = "REPENTERFLAG";
    public static final String FIELD_REPLOCATIONFLAG = "REPLOCATIONFLAG";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WXACCOUNTID = "WXACCOUNTID";
    public static final String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    public static final String FIELD_WXENTAPPID = "WXENTAPPID";
    public static final String FIELD_WXENTAPPNAME = "WXENTAPPNAME";
    private static final int INDEX_AGENTID = 0;
    private static final int INDEX_APIAPPSECRET = 1;
    private static final int INDEX_APIENCODINGAESKEY = 2;
    private static final int INDEX_APITOKEN = 3;
    private static final int INDEX_APIURL = 4;
    private static final int INDEX_APPTYPE = 5;
    private static final int INDEX_APPURL = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_REPENTERFLAG = 10;
    private static final int INDEX_REPLOCATIONFLAG = 11;
    private static final int INDEX_RESERVER = 12;
    private static final int INDEX_RESERVER2 = 13;
    private static final int INDEX_RESERVER3 = 14;
    private static final int INDEX_RESERVER4 = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final int INDEX_WXACCOUNTID = 19;
    private static final int INDEX_WXACCOUNTNAME = 20;
    private static final int INDEX_WXENTAPPID = 21;
    private static final int INDEX_WXENTAPPNAME = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WXEntAppBase proxyWXEntAppBase = null;
    private boolean agentidDirtyFlag = false;
    private boolean apiappsecretDirtyFlag = false;
    private boolean apiencodingaeskeyDirtyFlag = false;
    private boolean apitokenDirtyFlag = false;
    private boolean apiurlDirtyFlag = false;
    private boolean apptypeDirtyFlag = false;
    private boolean appurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean repenterflagDirtyFlag = false;
    private boolean replocationflagDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    private boolean wxentappidDirtyFlag = false;
    private boolean wxentappnameDirtyFlag = false;
    @Column(name="agentid")
    private Integer agentid;
    @Column(name="apiappsecret")
    private String apiappsecret;
    @Column(name="apiencodingaeskey")
    private String apiencodingaeskey;
    @Column(name="apitoken")
    private String apitoken;
    @Column(name="apiurl")
    private String apiurl;
    @Column(name="apptype")
    private String apptype;
    @Column(name="appurl")
    private String appurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="repenterflag")
    private Integer repenterflag;
    @Column(name="replocationflag")
    private Integer replocationflag;
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
    @Column(name="wxentappid")
    private String wxentappid;
    @Column(name="wxentappname")
    private String wxentappname;
    private Integer objWXAccountLock = new Integer(1);
    private WXAccount wxaccount = null;

    static {
        fieldIndexMap.put(FIELD_AGENTID, 0);
        fieldIndexMap.put(FIELD_APIAPPSECRET, 1);
        fieldIndexMap.put(FIELD_APIENCODINGAESKEY, 2);
        fieldIndexMap.put(FIELD_APITOKEN, 3);
        fieldIndexMap.put(FIELD_APIURL, 4);
        fieldIndexMap.put(FIELD_APPTYPE, 5);
        fieldIndexMap.put(FIELD_APPURL, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_REPENTERFLAG, 10);
        fieldIndexMap.put(FIELD_REPLOCATIONFLAG, 11);
        fieldIndexMap.put(FIELD_RESERVER, 12);
        fieldIndexMap.put(FIELD_RESERVER2, 13);
        fieldIndexMap.put(FIELD_RESERVER3, 14);
        fieldIndexMap.put(FIELD_RESERVER4, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
        fieldIndexMap.put(FIELD_WXACCOUNTID, 19);
        fieldIndexMap.put(FIELD_WXACCOUNTNAME, 20);
        fieldIndexMap.put(FIELD_WXENTAPPID, 21);
        fieldIndexMap.put(FIELD_WXENTAPPNAME, 22);
    }

    public void setAgentId(Integer agentid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentId(agentid);
            return;
        }
        this.agentid = agentid;
        this.agentidDirtyFlag = true;
    }

    public Integer getAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentId();
        }
        return this.agentid;
    }

    public boolean isAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentIdDirty();
        }
        return this.agentidDirtyFlag;
    }

    public void resetAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentId();
            return;
        }
        this.agentidDirtyFlag = false;
        this.agentid = null;
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

    public void setAPIEncodingAESKey(String apiencodingaeskey) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPIEncodingAESKey(apiencodingaeskey);
            return;
        }
        if (apiencodingaeskey != null && (apiencodingaeskey = StringHelper.trimRight(apiencodingaeskey)).length() == 0) {
            apiencodingaeskey = null;
        }
        this.apiencodingaeskey = apiencodingaeskey;
        this.apiencodingaeskeyDirtyFlag = true;
    }

    public String getAPIEncodingAESKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPIEncodingAESKey();
        }
        return this.apiencodingaeskey;
    }

    public boolean isAPIEncodingAESKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPIEncodingAESKeyDirty();
        }
        return this.apiencodingaeskeyDirtyFlag;
    }

    public void resetAPIEncodingAESKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPIEncodingAESKey();
            return;
        }
        this.apiencodingaeskeyDirtyFlag = false;
        this.apiencodingaeskey = null;
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

    public void setAppType(String apptype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppType(apptype);
            return;
        }
        if (apptype != null && (apptype = StringHelper.trimRight(apptype)).length() == 0) {
            apptype = null;
        }
        this.apptype = apptype;
        this.apptypeDirtyFlag = true;
    }

    public String getAppType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppType();
        }
        return this.apptype;
    }

    public boolean isAppTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppTypeDirty();
        }
        return this.apptypeDirtyFlag;
    }

    public void resetAppType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppType();
            return;
        }
        this.apptypeDirtyFlag = false;
        this.apptype = null;
    }

    public void setAppURL(String appurl) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppURL(appurl);
            return;
        }
        if (appurl != null && (appurl = StringHelper.trimRight(appurl)).length() == 0) {
            appurl = null;
        }
        this.appurl = appurl;
        this.appurlDirtyFlag = true;
    }

    public String getAppURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppURL();
        }
        return this.appurl;
    }

    public boolean isAppURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppURLDirty();
        }
        return this.appurlDirtyFlag;
    }

    public void resetAppURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppURL();
            return;
        }
        this.appurlDirtyFlag = false;
        this.appurl = null;
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

    public void setREPENTERFlag(Integer repenterflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setREPENTERFlag(repenterflag);
            return;
        }
        this.repenterflag = repenterflag;
        this.repenterflagDirtyFlag = true;
    }

    public Integer getREPENTERFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getREPENTERFlag();
        }
        return this.repenterflag;
    }

    public boolean isREPENTERFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isREPENTERFlagDirty();
        }
        return this.repenterflagDirtyFlag;
    }

    public void resetREPENTERFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetREPENTERFlag();
            return;
        }
        this.repenterflagDirtyFlag = false;
        this.repenterflag = null;
    }

    public void setRepLocationFlag(Integer replocationflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRepLocationFlag(replocationflag);
            return;
        }
        this.replocationflag = replocationflag;
        this.replocationflagDirtyFlag = true;
    }

    public Integer getRepLocationFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRepLocationFlag();
        }
        return this.replocationflag;
    }

    public boolean isRepLocationFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRepLocationFlagDirty();
        }
        return this.replocationflagDirtyFlag;
    }

    public void resetRepLocationFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRepLocationFlag();
            return;
        }
        this.replocationflagDirtyFlag = false;
        this.replocationflag = null;
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

    public void setWXEntAppId(String wxentappid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppId(wxentappid);
            return;
        }
        if (wxentappid != null && (wxentappid = StringHelper.trimRight(wxentappid)).length() == 0) {
            wxentappid = null;
        }
        this.wxentappid = wxentappid;
        this.wxentappidDirtyFlag = true;
    }

    public String getWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    public boolean isWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    public void resetWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppId();
            return;
        }
        this.wxentappidDirtyFlag = false;
        this.wxentappid = null;
    }

    public void setWXEntAppName(String wxentappname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppName(wxentappname);
            return;
        }
        if (wxentappname != null && (wxentappname = StringHelper.trimRight(wxentappname)).length() == 0) {
            wxentappname = null;
        }
        this.wxentappname = wxentappname;
        this.wxentappnameDirtyFlag = true;
    }

    public String getWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    public boolean isWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    public void resetWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }
        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }

    @Override
    protected void onReset() {
        WXEntAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WXEntAppBase et) {
        et.resetAgentId();
        et.resetAPIAppSecret();
        et.resetAPIEncodingAESKey();
        et.resetAPIToken();
        et.resetAPIURL();
        et.resetAppType();
        et.resetAppURL();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetREPENTERFlag();
        et.resetRepLocationFlag();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValidFlag();
        et.resetWXAccountId();
        et.resetWXAccountName();
        et.resetWXEntAppId();
        et.resetWXEntAppName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAgentIdDirty()) {
            params.put(FIELD_AGENTID, this.getAgentId());
        }
        if (!bDirtyOnly || this.isAPIAppSecretDirty()) {
            params.put(FIELD_APIAPPSECRET, this.getAPIAppSecret());
        }
        if (!bDirtyOnly || this.isAPIEncodingAESKeyDirty()) {
            params.put(FIELD_APIENCODINGAESKEY, this.getAPIEncodingAESKey());
        }
        if (!bDirtyOnly || this.isAPITokenDirty()) {
            params.put(FIELD_APITOKEN, this.getAPIToken());
        }
        if (!bDirtyOnly || this.isAPIURLDirty()) {
            params.put(FIELD_APIURL, this.getAPIURL());
        }
        if (!bDirtyOnly || this.isAppTypeDirty()) {
            params.put(FIELD_APPTYPE, this.getAppType());
        }
        if (!bDirtyOnly || this.isAppURLDirty()) {
            params.put(FIELD_APPURL, this.getAppURL());
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
        if (!bDirtyOnly || this.isREPENTERFlagDirty()) {
            params.put(FIELD_REPENTERFLAG, this.getREPENTERFlag());
        }
        if (!bDirtyOnly || this.isRepLocationFlagDirty()) {
            params.put(FIELD_REPLOCATIONFLAG, this.getRepLocationFlag());
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
        if (!bDirtyOnly || this.isWXEntAppIdDirty()) {
            params.put(FIELD_WXENTAPPID, this.getWXEntAppId());
        }
        if (!bDirtyOnly || this.isWXEntAppNameDirty()) {
            params.put(FIELD_WXENTAPPNAME, this.getWXEntAppName());
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
        return WXEntAppBase.get(this, index);
    }

    private static Object get(WXEntAppBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAgentId();
            }
            case 1: {
                return et.getAPIAppSecret();
            }
            case 2: {
                return et.getAPIEncodingAESKey();
            }
            case 3: {
                return et.getAPIToken();
            }
            case 4: {
                return et.getAPIURL();
            }
            case 5: {
                return et.getAppType();
            }
            case 6: {
                return et.getAppURL();
            }
            case 7: {
                return et.getCreateDate();
            }
            case 8: {
                return et.getCreateMan();
            }
            case 9: {
                return et.getMemo();
            }
            case 10: {
                return et.getREPENTERFlag();
            }
            case 11: {
                return et.getRepLocationFlag();
            }
            case 12: {
                return et.getReserver();
            }
            case 13: {
                return et.getReserver2();
            }
            case 14: {
                return et.getReserver3();
            }
            case 15: {
                return et.getReserver4();
            }
            case 16: {
                return et.getUpdateDate();
            }
            case 17: {
                return et.getUpdateMan();
            }
            case 18: {
                return et.getValidFlag();
            }
            case 19: {
                return et.getWXAccountId();
            }
            case 20: {
                return et.getWXAccountName();
            }
            case 21: {
                return et.getWXEntAppId();
            }
            case 22: {
                return et.getWXEntAppName();
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
        WXEntAppBase.set(this, index, objValue);
    }

    private static void set(WXEntAppBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAgentId(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setAPIAppSecret(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setAPIEncodingAESKey(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setAPIToken(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setAPIURL(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setAppType(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setAppURL(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setREPENTERFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setRepLocationFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 17: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 19: {
                et.setWXAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWXAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWXEntAppId(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setWXEntAppName(DataObject.getStringValue(obj));
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
        return WXEntAppBase.isNull(this, index);
    }

    private static boolean isNull(WXEntAppBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAgentId() == null;
            }
            case 1: {
                return et.getAPIAppSecret() == null;
            }
            case 2: {
                return et.getAPIEncodingAESKey() == null;
            }
            case 3: {
                return et.getAPIToken() == null;
            }
            case 4: {
                return et.getAPIURL() == null;
            }
            case 5: {
                return et.getAppType() == null;
            }
            case 6: {
                return et.getAppURL() == null;
            }
            case 7: {
                return et.getCreateDate() == null;
            }
            case 8: {
                return et.getCreateMan() == null;
            }
            case 9: {
                return et.getMemo() == null;
            }
            case 10: {
                return et.getREPENTERFlag() == null;
            }
            case 11: {
                return et.getRepLocationFlag() == null;
            }
            case 12: {
                return et.getReserver() == null;
            }
            case 13: {
                return et.getReserver2() == null;
            }
            case 14: {
                return et.getReserver3() == null;
            }
            case 15: {
                return et.getReserver4() == null;
            }
            case 16: {
                return et.getUpdateDate() == null;
            }
            case 17: {
                return et.getUpdateMan() == null;
            }
            case 18: {
                return et.getValidFlag() == null;
            }
            case 19: {
                return et.getWXAccountId() == null;
            }
            case 20: {
                return et.getWXAccountName() == null;
            }
            case 21: {
                return et.getWXEntAppId() == null;
            }
            case 22: {
                return et.getWXEntAppName() == null;
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
        return WXEntAppBase.contains(this, index);
    }

    private static boolean contains(WXEntAppBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAgentIdDirty();
            }
            case 1: {
                return et.isAPIAppSecretDirty();
            }
            case 2: {
                return et.isAPIEncodingAESKeyDirty();
            }
            case 3: {
                return et.isAPITokenDirty();
            }
            case 4: {
                return et.isAPIURLDirty();
            }
            case 5: {
                return et.isAppTypeDirty();
            }
            case 6: {
                return et.isAppURLDirty();
            }
            case 7: {
                return et.isCreateDateDirty();
            }
            case 8: {
                return et.isCreateManDirty();
            }
            case 9: {
                return et.isMemoDirty();
            }
            case 10: {
                return et.isREPENTERFlagDirty();
            }
            case 11: {
                return et.isRepLocationFlagDirty();
            }
            case 12: {
                return et.isReserverDirty();
            }
            case 13: {
                return et.isReserver2Dirty();
            }
            case 14: {
                return et.isReserver3Dirty();
            }
            case 15: {
                return et.isReserver4Dirty();
            }
            case 16: {
                return et.isUpdateDateDirty();
            }
            case 17: {
                return et.isUpdateManDirty();
            }
            case 18: {
                return et.isValidFlagDirty();
            }
            case 19: {
                return et.isWXAccountIdDirty();
            }
            case 20: {
                return et.isWXAccountNameDirty();
            }
            case 21: {
                return et.isWXEntAppIdDirty();
            }
            case 22: {
                return et.isWXEntAppNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WXEntAppBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WXEntAppBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAgentId() != null) {
            JSONObjectHelper.put(json, "agentid", WXEntAppBase.getJSONValue(et.getAgentId()), false);
        }
        if (bIncEmpty || et.getAPIAppSecret() != null) {
            JSONObjectHelper.put(json, "apiappsecret", WXEntAppBase.getJSONValue(et.getAPIAppSecret()), false);
        }
        if (bIncEmpty || et.getAPIEncodingAESKey() != null) {
            JSONObjectHelper.put(json, "apiencodingaeskey", WXEntAppBase.getJSONValue(et.getAPIEncodingAESKey()), false);
        }
        if (bIncEmpty || et.getAPIToken() != null) {
            JSONObjectHelper.put(json, "apitoken", WXEntAppBase.getJSONValue(et.getAPIToken()), false);
        }
        if (bIncEmpty || et.getAPIURL() != null) {
            JSONObjectHelper.put(json, "apiurl", WXEntAppBase.getJSONValue(et.getAPIURL()), false);
        }
        if (bIncEmpty || et.getAppType() != null) {
            JSONObjectHelper.put(json, "apptype", WXEntAppBase.getJSONValue(et.getAppType()), false);
        }
        if (bIncEmpty || et.getAppURL() != null) {
            JSONObjectHelper.put(json, "appurl", WXEntAppBase.getJSONValue(et.getAppURL()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WXEntAppBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WXEntAppBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WXEntAppBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getREPENTERFlag() != null) {
            JSONObjectHelper.put(json, "repenterflag", WXEntAppBase.getJSONValue(et.getREPENTERFlag()), false);
        }
        if (bIncEmpty || et.getRepLocationFlag() != null) {
            JSONObjectHelper.put(json, "replocationflag", WXEntAppBase.getJSONValue(et.getRepLocationFlag()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WXEntAppBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WXEntAppBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", WXEntAppBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", WXEntAppBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WXEntAppBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WXEntAppBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", WXEntAppBase.getJSONValue(et.getValidFlag()), false);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            JSONObjectHelper.put(json, "wxaccountid", WXEntAppBase.getJSONValue(et.getWXAccountId()), false);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            JSONObjectHelper.put(json, "wxaccountname", WXEntAppBase.getJSONValue(et.getWXAccountName()), false);
        }
        if (bIncEmpty || et.getWXEntAppId() != null) {
            JSONObjectHelper.put(json, "wxentappid", WXEntAppBase.getJSONValue(et.getWXEntAppId()), false);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            JSONObjectHelper.put(json, "wxentappname", WXEntAppBase.getJSONValue(et.getWXEntAppName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WXEntAppBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WXEntAppBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAgentId() != null) {
            obj = et.getAgentId();
            node.setAttribute(FIELD_AGENTID, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getAPIAppSecret() != null) {
            obj = et.getAPIAppSecret();
            node.setAttribute(FIELD_APIAPPSECRET, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getAPIEncodingAESKey() != null) {
            obj = et.getAPIEncodingAESKey();
            node.setAttribute(FIELD_APIENCODINGAESKEY, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getAPIToken() != null) {
            obj = et.getAPIToken();
            node.setAttribute(FIELD_APITOKEN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getAPIURL() != null) {
            obj = et.getAPIURL();
            node.setAttribute(FIELD_APIURL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getAppType() != null) {
            obj = et.getAppType();
            node.setAttribute(FIELD_APPTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getAppURL() != null) {
            obj = et.getAppURL();
            node.setAttribute(FIELD_APPURL, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getREPENTERFlag() != null) {
            obj = et.getREPENTERFlag();
            node.setAttribute(FIELD_REPENTERFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getRepLocationFlag() != null) {
            obj = et.getRepLocationFlag();
            node.setAttribute(FIELD_REPLOCATIONFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
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
        if (bIncEmpty || et.getWXEntAppId() != null) {
            obj = et.getWXEntAppId();
            node.setAttribute(FIELD_WXENTAPPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            obj = et.getWXEntAppName();
            node.setAttribute(FIELD_WXENTAPPNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXEntAppBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WXEntAppBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAgentIdDirty() && (bIncEmpty || et.getAgentId() != null)) {
            dst.set(FIELD_AGENTID, et.getAgentId());
        }
        if (et.isAPIAppSecretDirty() && (bIncEmpty || et.getAPIAppSecret() != null)) {
            dst.set(FIELD_APIAPPSECRET, et.getAPIAppSecret());
        }
        if (et.isAPIEncodingAESKeyDirty() && (bIncEmpty || et.getAPIEncodingAESKey() != null)) {
            dst.set(FIELD_APIENCODINGAESKEY, et.getAPIEncodingAESKey());
        }
        if (et.isAPITokenDirty() && (bIncEmpty || et.getAPIToken() != null)) {
            dst.set(FIELD_APITOKEN, et.getAPIToken());
        }
        if (et.isAPIURLDirty() && (bIncEmpty || et.getAPIURL() != null)) {
            dst.set(FIELD_APIURL, et.getAPIURL());
        }
        if (et.isAppTypeDirty() && (bIncEmpty || et.getAppType() != null)) {
            dst.set(FIELD_APPTYPE, et.getAppType());
        }
        if (et.isAppURLDirty() && (bIncEmpty || et.getAppURL() != null)) {
            dst.set(FIELD_APPURL, et.getAppURL());
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
        if (et.isREPENTERFlagDirty() && (bIncEmpty || et.getREPENTERFlag() != null)) {
            dst.set(FIELD_REPENTERFLAG, et.getREPENTERFlag());
        }
        if (et.isRepLocationFlagDirty() && (bIncEmpty || et.getRepLocationFlag() != null)) {
            dst.set(FIELD_REPLOCATIONFLAG, et.getRepLocationFlag());
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
        if (et.isWXEntAppIdDirty() && (bIncEmpty || et.getWXEntAppId() != null)) {
            dst.set(FIELD_WXENTAPPID, et.getWXEntAppId());
        }
        if (et.isWXEntAppNameDirty() && (bIncEmpty || et.getWXEntAppName() != null)) {
            dst.set(FIELD_WXENTAPPNAME, et.getWXEntAppName());
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
        return WXEntAppBase.remove(this, index);
    }

    private static boolean remove(WXEntAppBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAgentId();
                return true;
            }
            case 1: {
                et.resetAPIAppSecret();
                return true;
            }
            case 2: {
                et.resetAPIEncodingAESKey();
                return true;
            }
            case 3: {
                et.resetAPIToken();
                return true;
            }
            case 4: {
                et.resetAPIURL();
                return true;
            }
            case 5: {
                et.resetAppType();
                return true;
            }
            case 6: {
                et.resetAppURL();
                return true;
            }
            case 7: {
                et.resetCreateDate();
                return true;
            }
            case 8: {
                et.resetCreateMan();
                return true;
            }
            case 9: {
                et.resetMemo();
                return true;
            }
            case 10: {
                et.resetREPENTERFlag();
                return true;
            }
            case 11: {
                et.resetRepLocationFlag();
                return true;
            }
            case 12: {
                et.resetReserver();
                return true;
            }
            case 13: {
                et.resetReserver2();
                return true;
            }
            case 14: {
                et.resetReserver3();
                return true;
            }
            case 15: {
                et.resetReserver4();
                return true;
            }
            case 16: {
                et.resetUpdateDate();
                return true;
            }
            case 17: {
                et.resetUpdateMan();
                return true;
            }
            case 18: {
                et.resetValidFlag();
                return true;
            }
            case 19: {
                et.resetWXAccountId();
                return true;
            }
            case 20: {
                et.resetWXAccountName();
                return true;
            }
            case 21: {
                et.resetWXEntAppId();
                return true;
            }
            case 22: {
                et.resetWXEntAppName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXAccount getWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccount();
        }
        if (this.getWXAccountId() == null) {
            return null;
        }
        Integer n = this.objWXAccountLock;
        synchronized (n) {
            if (this.wxaccount != null && DataTypeHelper.compare(25, (Object)this.getWXAccountId(), (Object)this.wxaccount.getWXAccountId()) != 0L) {
                this.wxaccount = null;
            }
            if (this.wxaccount == null) {
                WXAccount wxaccount = new WXAccount();
                wxaccount.setWXAccountId(this.getWXAccountId());
                WXAccountService service = (WXAccountService)ServiceGlobal.getService(WXAccountService.class, this.getSessionFactory());
                service.autoGet(wxaccount);
                this.wxaccount = wxaccount;
            }
            return this.wxaccount;
        }
    }

    private WXEntAppBase getProxyEntity() {
        return this.proxyWXEntAppBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXEntAppBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WXEntAppBase) {
            this.proxyWXEntAppBase = (WXEntAppBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXEntAppService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

