/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[WXEntApp] 数据对象基类
 */
public abstract class WXEntAppBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXEntAppBase.class);
    /**
     * 属性[应用标识]
     */
    public final static String FIELD_AGENTID = "AGENTID";
    /**
     * 属性[AppSecret]
     */
    public final static String FIELD_APIAPPSECRET = "APIAPPSECRET";
    /**
     * 属性[APIENCODINGAESKEY]
     */
    public final static String FIELD_APIENCODINGAESKEY = "APIENCODINGAESKEY";
    /**
     * 属性[Token]
     */
    public final static String FIELD_APITOKEN = "APITOKEN";
    /**
     * 属性[API地址]
     */
    public final static String FIELD_APIURL = "APIURL";
    /**
     * 属性[应用类型]
     */
    public final static String FIELD_APPTYPE = "APPTYPE";
    /**
     * 属性[应用路径]
     */
    public final static String FIELD_APPURL = "APPURL";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[是否进入应用]
     */
    public final static String FIELD_REPENTERFLAG = "REPENTERFLAG";
    /**
     * 属性[是否上报位置]
     */
    public final static String FIELD_REPLOCATIONFLAG = "REPLOCATIONFLAG";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[保留字段3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[保留字段4]
     */
    public final static String FIELD_RESERVER4 = "RESERVER4";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[是否启用]
     */
    public final static String FIELD_VALIDFLAG = "VALIDFLAG";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTID = "WXACCOUNTID";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    /**
     * 属性[微信企业应用标识]
     */
    public final static String FIELD_WXENTAPPID = "WXENTAPPID";
    /**
     * 属性[微信企业应用名称]
     */
    public final static String FIELD_WXENTAPPNAME = "WXENTAPPNAME";

    private final static int INDEX_AGENTID = 0;
    private final static int INDEX_APIAPPSECRET = 1;
    private final static int INDEX_APIENCODINGAESKEY = 2;
    private final static int INDEX_APITOKEN = 3;
    private final static int INDEX_APIURL = 4;
    private final static int INDEX_APPTYPE = 5;
    private final static int INDEX_APPURL = 6;
    private final static int INDEX_CREATEDATE = 7;
    private final static int INDEX_CREATEMAN = 8;
    private final static int INDEX_MEMO = 9;
    private final static int INDEX_REPENTERFLAG = 10;
    private final static int INDEX_REPLOCATIONFLAG = 11;
    private final static int INDEX_RESERVER = 12;
    private final static int INDEX_RESERVER2 = 13;
    private final static int INDEX_RESERVER3 = 14;
    private final static int INDEX_RESERVER4 = 15;
    private final static int INDEX_UPDATEDATE = 16;
    private final static int INDEX_UPDATEMAN = 17;
    private final static int INDEX_VALIDFLAG = 18;
    private final static int INDEX_WXACCOUNTID = 19;
    private final static int INDEX_WXACCOUNTNAME = 20;
    private final static int INDEX_WXENTAPPID = 21;
    private final static int INDEX_WXENTAPPNAME = 22;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_AGENTID, INDEX_AGENTID);
        fieldIndexMap.put( FIELD_APIAPPSECRET, INDEX_APIAPPSECRET);
        fieldIndexMap.put( FIELD_APIENCODINGAESKEY, INDEX_APIENCODINGAESKEY);
        fieldIndexMap.put( FIELD_APITOKEN, INDEX_APITOKEN);
        fieldIndexMap.put( FIELD_APIURL, INDEX_APIURL);
        fieldIndexMap.put( FIELD_APPTYPE, INDEX_APPTYPE);
        fieldIndexMap.put( FIELD_APPURL, INDEX_APPURL);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_REPENTERFLAG, INDEX_REPENTERFLAG);
        fieldIndexMap.put( FIELD_REPLOCATIONFLAG, INDEX_REPLOCATIONFLAG);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VALIDFLAG, INDEX_VALIDFLAG);
        fieldIndexMap.put( FIELD_WXACCOUNTID, INDEX_WXACCOUNTID);
        fieldIndexMap.put( FIELD_WXACCOUNTNAME, INDEX_WXACCOUNTNAME);
        fieldIndexMap.put( FIELD_WXENTAPPID, INDEX_WXENTAPPID);
        fieldIndexMap.put( FIELD_WXENTAPPNAME, INDEX_WXENTAPPNAME);
    }

    private WXEntAppBase proxyWXEntAppBase = null;
    public WXEntAppBase() {
        super();
    }
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


    /**
     *  设置属性值[应用标识]
     *  @param agentid
     */
    public void setAgentId(Integer agentid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAgentId(agentid);
            return;
        }
        this.agentid = agentid;
        this.agentidDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用标识]
     */
    public Integer getAgentId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAgentId();
        }
        return this.agentid;
    }

    /**
     *  获取属性值[应用标识]是否修改
     */
    public boolean isAgentIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAgentIdDirty();
        }
        return this.agentidDirtyFlag;
    }

    /**
     *  重置属性值[应用标识]
     */
    public void resetAgentId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAgentId();
            return;
        }

        this.agentidDirtyFlag = false;
        this.agentid = null;
    }
    /**
     *  设置属性值[AppSecret]
     *  @param apiappsecret
     */
    public void setAPIAppSecret(String apiappsecret) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAPIAppSecret(apiappsecret);
            return;
        }
        if(apiappsecret!=null) {
            apiappsecret = StringHelper.trimRight(apiappsecret);
            if(apiappsecret.length()==0) {
                apiappsecret = null;
            }
        }
        this.apiappsecret = apiappsecret;
        this.apiappsecretDirtyFlag  = true;
    }

    /**
     *  获取属性值[AppSecret]
     */
    public String getAPIAppSecret() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAPIAppSecret();
        }
        return this.apiappsecret;
    }

    /**
     *  获取属性值[AppSecret]是否修改
     */
    public boolean isAPIAppSecretDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAPIAppSecretDirty();
        }
        return this.apiappsecretDirtyFlag;
    }

    /**
     *  重置属性值[AppSecret]
     */
    public void resetAPIAppSecret() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAPIAppSecret();
            return;
        }

        this.apiappsecretDirtyFlag = false;
        this.apiappsecret = null;
    }
    /**
     *  设置属性值[APIENCODINGAESKEY]
     *  @param apiencodingaeskey
     */
    public void setAPIEncodingAESKey(String apiencodingaeskey) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAPIEncodingAESKey(apiencodingaeskey);
            return;
        }
        if(apiencodingaeskey!=null) {
            apiencodingaeskey = StringHelper.trimRight(apiencodingaeskey);
            if(apiencodingaeskey.length()==0) {
                apiencodingaeskey = null;
            }
        }
        this.apiencodingaeskey = apiencodingaeskey;
        this.apiencodingaeskeyDirtyFlag  = true;
    }

    /**
     *  获取属性值[APIENCODINGAESKEY]
     */
    public String getAPIEncodingAESKey() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAPIEncodingAESKey();
        }
        return this.apiencodingaeskey;
    }

    /**
     *  获取属性值[APIENCODINGAESKEY]是否修改
     */
    public boolean isAPIEncodingAESKeyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAPIEncodingAESKeyDirty();
        }
        return this.apiencodingaeskeyDirtyFlag;
    }

    /**
     *  重置属性值[APIENCODINGAESKEY]
     */
    public void resetAPIEncodingAESKey() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAPIEncodingAESKey();
            return;
        }

        this.apiencodingaeskeyDirtyFlag = false;
        this.apiencodingaeskey = null;
    }
    /**
     *  设置属性值[Token]
     *  @param apitoken
     */
    public void setAPIToken(String apitoken) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAPIToken(apitoken);
            return;
        }
        if(apitoken!=null) {
            apitoken = StringHelper.trimRight(apitoken);
            if(apitoken.length()==0) {
                apitoken = null;
            }
        }
        this.apitoken = apitoken;
        this.apitokenDirtyFlag  = true;
    }

    /**
     *  获取属性值[Token]
     */
    public String getAPIToken() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAPIToken();
        }
        return this.apitoken;
    }

    /**
     *  获取属性值[Token]是否修改
     */
    public boolean isAPITokenDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAPITokenDirty();
        }
        return this.apitokenDirtyFlag;
    }

    /**
     *  重置属性值[Token]
     */
    public void resetAPIToken() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAPIToken();
            return;
        }

        this.apitokenDirtyFlag = false;
        this.apitoken = null;
    }
    /**
     *  设置属性值[API地址]
     *  @param apiurl
     */
    public void setAPIURL(String apiurl) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAPIURL(apiurl);
            return;
        }
        if(apiurl!=null) {
            apiurl = StringHelper.trimRight(apiurl);
            if(apiurl.length()==0) {
                apiurl = null;
            }
        }
        this.apiurl = apiurl;
        this.apiurlDirtyFlag  = true;
    }

    /**
     *  获取属性值[API地址]
     */
    public String getAPIURL() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAPIURL();
        }
        return this.apiurl;
    }

    /**
     *  获取属性值[API地址]是否修改
     */
    public boolean isAPIURLDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAPIURLDirty();
        }
        return this.apiurlDirtyFlag;
    }

    /**
     *  重置属性值[API地址]
     */
    public void resetAPIURL() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAPIURL();
            return;
        }

        this.apiurlDirtyFlag = false;
        this.apiurl = null;
    }
    /**
     *  设置属性值[应用类型]代码表：net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel
     *  @param apptype
     */
    public void setAppType(String apptype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAppType(apptype);
            return;
        }
        if(apptype!=null) {
            apptype = StringHelper.trimRight(apptype);
            if(apptype.length()==0) {
                apptype = null;
            }
        }
        this.apptype = apptype;
        this.apptypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用类型]代码表：net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel
     */
    public String getAppType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAppType();
        }
        return this.apptype;
    }

    /**
     *  获取属性值[应用类型]是否修改
     */
    public boolean isAppTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAppTypeDirty();
        }
        return this.apptypeDirtyFlag;
    }

    /**
     *  重置属性值[应用类型]
     */
    public void resetAppType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAppType();
            return;
        }

        this.apptypeDirtyFlag = false;
        this.apptype = null;
    }
    /**
     *  设置属性值[应用路径]
     *  @param appurl
     */
    public void setAppURL(String appurl) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAppURL(appurl);
            return;
        }
        if(appurl!=null) {
            appurl = StringHelper.trimRight(appurl);
            if(appurl.length()==0) {
                appurl = null;
            }
        }
        this.appurl = appurl;
        this.appurlDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用路径]
     */
    public String getAppURL() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAppURL();
        }
        return this.appurl;
    }

    /**
     *  获取属性值[应用路径]是否修改
     */
    public boolean isAppURLDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAppURLDirty();
        }
        return this.appurlDirtyFlag;
    }

    /**
     *  重置属性值[应用路径]
     */
    public void resetAppURL() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAppURL();
            return;
        }

        this.appurlDirtyFlag = false;
        this.appurl = null;
    }
    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[是否进入应用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param repenterflag
     */
    public void setREPENTERFlag(Integer repenterflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setREPENTERFlag(repenterflag);
            return;
        }
        this.repenterflag = repenterflag;
        this.repenterflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否进入应用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getREPENTERFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getREPENTERFlag();
        }
        return this.repenterflag;
    }

    /**
     *  获取属性值[是否进入应用]是否修改
     */
    public boolean isREPENTERFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isREPENTERFlagDirty();
        }
        return this.repenterflagDirtyFlag;
    }

    /**
     *  重置属性值[是否进入应用]
     */
    public void resetREPENTERFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetREPENTERFlag();
            return;
        }

        this.repenterflagDirtyFlag = false;
        this.repenterflag = null;
    }
    /**
     *  设置属性值[是否上报位置]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param replocationflag
     */
    public void setRepLocationFlag(Integer replocationflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRepLocationFlag(replocationflag);
            return;
        }
        this.replocationflag = replocationflag;
        this.replocationflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否上报位置]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getRepLocationFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRepLocationFlag();
        }
        return this.replocationflag;
    }

    /**
     *  获取属性值[是否上报位置]是否修改
     */
    public boolean isRepLocationFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRepLocationFlagDirty();
        }
        return this.replocationflagDirtyFlag;
    }

    /**
     *  重置属性值[是否上报位置]
     */
    public void resetRepLocationFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRepLocationFlag();
            return;
        }

        this.replocationflagDirtyFlag = false;
        this.replocationflag = null;
    }
    /**
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[保留字段3]
     *  @param reserver3
     */
    public void setReserver3(String reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if(reserver3!=null) {
            reserver3 = StringHelper.trimRight(reserver3);
            if(reserver3.length()==0) {
                reserver3 = null;
            }
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public String getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[保留字段3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[保留字段3]
     */
    public void resetReserver3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver3();
            return;
        }

        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }
    /**
     *  设置属性值[保留字段4]
     *  @param reserver4
     */
    public void setReserver4(String reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if(reserver4!=null) {
            reserver4 = StringHelper.trimRight(reserver4);
            if(reserver4.length()==0) {
                reserver4 = null;
            }
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public String getReserver4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    /**
     *  获取属性值[保留字段4]是否修改
     */
    public boolean isReserver4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    /**
     *  重置属性值[保留字段4]
     */
    public void resetReserver4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver4();
            return;
        }

        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param validflag
     */
    public void setValidFlag(Integer validflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否启用]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getValidFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    /**
     *  获取属性值[是否启用]是否修改
     */
    public boolean isValidFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    /**
     *  重置属性值[是否启用]
     */
    public void resetValidFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }

        this.validflagDirtyFlag = false;
        this.validflag = null;
    }
    /**
     *  设置属性值[微信公众号]
     *  @param wxaccountid
     */
    public void setWXAccountId(String wxaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccountId(wxaccountid);
            return;
        }
        if(wxaccountid!=null) {
            wxaccountid = StringHelper.trimRight(wxaccountid);
            if(wxaccountid.length()==0) {
                wxaccountid = null;
            }
        }
        this.wxaccountid = wxaccountid;
        this.wxaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信公众号]
     */
    public String getWXAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccountId();
        }
        return this.wxaccountid;
    }

    /**
     *  获取属性值[微信公众号]是否修改
     */
    public boolean isWXAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccountIdDirty();
        }
        return this.wxaccountidDirtyFlag;
    }

    /**
     *  重置属性值[微信公众号]
     */
    public void resetWXAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccountId();
            return;
        }

        this.wxaccountidDirtyFlag = false;
        this.wxaccountid = null;
    }
    /**
     *  设置属性值[微信公众号]
     *  @param wxaccountname
     */
    public void setWXAccountName(String wxaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccountName(wxaccountname);
            return;
        }
        if(wxaccountname!=null) {
            wxaccountname = StringHelper.trimRight(wxaccountname);
            if(wxaccountname.length()==0) {
                wxaccountname = null;
            }
        }
        this.wxaccountname = wxaccountname;
        this.wxaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信公众号]
     */
    public String getWXAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccountName();
        }
        return this.wxaccountname;
    }

    /**
     *  获取属性值[微信公众号]是否修改
     */
    public boolean isWXAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccountNameDirty();
        }
        return this.wxaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[微信公众号]
     */
    public void resetWXAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccountName();
            return;
        }

        this.wxaccountnameDirtyFlag = false;
        this.wxaccountname = null;
    }
    /**
     *  设置属性值[微信企业应用标识]
     *  @param wxentappid
     */
    public void setWXEntAppId(String wxentappid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXEntAppId(wxentappid);
            return;
        }
        if(wxentappid!=null) {
            wxentappid = StringHelper.trimRight(wxentappid);
            if(wxentappid.length()==0) {
                wxentappid = null;
            }
        }
        this.wxentappid = wxentappid;
        this.wxentappidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信企业应用标识]
     */
    public String getWXEntAppId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    /**
     *  获取属性值[微信企业应用标识]是否修改
     */
    public boolean isWXEntAppIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用标识]
     */
    public void resetWXEntAppId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXEntAppId();
            return;
        }

        this.wxentappidDirtyFlag = false;
        this.wxentappid = null;
    }
    /**
     *  设置属性值[微信企业应用名称]
     *  @param wxentappname
     */
    public void setWXEntAppName(String wxentappname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXEntAppName(wxentappname);
            return;
        }
        if(wxentappname!=null) {
            wxentappname = StringHelper.trimRight(wxentappname);
            if(wxentappname.length()==0) {
                wxentappname = null;
            }
        }
        this.wxentappname = wxentappname;
        this.wxentappnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信企业应用名称]
     */
    public String getWXEntAppName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    /**
     *  获取属性值[微信企业应用名称]是否修改
     */
    public boolean isWXEntAppNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用名称]
     */
    public void resetWXEntAppName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }

        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WXEntAppBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAgentIdDirty()) {
            params.put(FIELD_AGENTID,getAgentId());
        }
        if(!bDirtyOnly || isAPIAppSecretDirty()) {
            params.put(FIELD_APIAPPSECRET,getAPIAppSecret());
        }
        if(!bDirtyOnly || isAPIEncodingAESKeyDirty()) {
            params.put(FIELD_APIENCODINGAESKEY,getAPIEncodingAESKey());
        }
        if(!bDirtyOnly || isAPITokenDirty()) {
            params.put(FIELD_APITOKEN,getAPIToken());
        }
        if(!bDirtyOnly || isAPIURLDirty()) {
            params.put(FIELD_APIURL,getAPIURL());
        }
        if(!bDirtyOnly || isAppTypeDirty()) {
            params.put(FIELD_APPTYPE,getAppType());
        }
        if(!bDirtyOnly || isAppURLDirty()) {
            params.put(FIELD_APPURL,getAppURL());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isREPENTERFlagDirty()) {
            params.put(FIELD_REPENTERFLAG,getREPENTERFlag());
        }
        if(!bDirtyOnly || isRepLocationFlagDirty()) {
            params.put(FIELD_REPLOCATIONFLAG,getRepLocationFlag());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isReserver3Dirty()) {
            params.put(FIELD_RESERVER3,getReserver3());
        }
        if(!bDirtyOnly || isReserver4Dirty()) {
            params.put(FIELD_RESERVER4,getReserver4());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG,getValidFlag());
        }
        if(!bDirtyOnly || isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID,getWXAccountId());
        }
        if(!bDirtyOnly || isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME,getWXAccountName());
        }
        if(!bDirtyOnly || isWXEntAppIdDirty()) {
            params.put(FIELD_WXENTAPPID,getWXEntAppId());
        }
        if(!bDirtyOnly || isWXEntAppNameDirty()) {
            params.put(FIELD_WXENTAPPNAME,getWXEntAppName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  WXEntAppBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WXEntAppBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTID:
            return et.getAgentId();
        case INDEX_APIAPPSECRET:
            return et.getAPIAppSecret();
        case INDEX_APIENCODINGAESKEY:
            return et.getAPIEncodingAESKey();
        case INDEX_APITOKEN:
            return et.getAPIToken();
        case INDEX_APIURL:
            return et.getAPIURL();
        case INDEX_APPTYPE:
            return et.getAppType();
        case INDEX_APPURL:
            return et.getAppURL();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_REPENTERFLAG:
            return et.getREPENTERFlag();
        case INDEX_REPLOCATIONFLAG:
            return et.getRepLocationFlag();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VALIDFLAG:
            return et.getValidFlag();
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId();
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName();
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId();
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        WXEntAppBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WXEntAppBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_AGENTID:
            et.setAgentId(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_APIAPPSECRET:
            et.setAPIAppSecret(DataObject.getStringValue(obj));
            return ;
        case INDEX_APIENCODINGAESKEY:
            et.setAPIEncodingAESKey(DataObject.getStringValue(obj));
            return ;
        case INDEX_APITOKEN:
            et.setAPIToken(DataObject.getStringValue(obj));
            return ;
        case INDEX_APIURL:
            et.setAPIURL(DataObject.getStringValue(obj));
            return ;
        case INDEX_APPTYPE:
            et.setAppType(DataObject.getStringValue(obj));
            return ;
        case INDEX_APPURL:
            et.setAppURL(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_REPENTERFLAG:
            et.setREPENTERFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_REPLOCATIONFLAG:
            et.setRepLocationFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VALIDFLAG:
            et.setValidFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WXACCOUNTID:
            et.setWXAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCOUNTNAME:
            et.setWXAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXENTAPPID:
            et.setWXEntAppId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXENTAPPNAME:
            et.setWXEntAppName(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  WXEntAppBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WXEntAppBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTID:
            return et.getAgentId()==null;
        case INDEX_APIAPPSECRET:
            return et.getAPIAppSecret()==null;
        case INDEX_APIENCODINGAESKEY:
            return et.getAPIEncodingAESKey()==null;
        case INDEX_APITOKEN:
            return et.getAPIToken()==null;
        case INDEX_APIURL:
            return et.getAPIURL()==null;
        case INDEX_APPTYPE:
            return et.getAppType()==null;
        case INDEX_APPURL:
            return et.getAppURL()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_REPENTERFLAG:
            return et.getREPENTERFlag()==null;
        case INDEX_REPLOCATIONFLAG:
            return et.getRepLocationFlag()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VALIDFLAG:
            return et.getValidFlag()==null;
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId()==null;
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName()==null;
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId()==null;
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  WXEntAppBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WXEntAppBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AGENTID:
            return et.isAgentIdDirty();
        case INDEX_APIAPPSECRET:
            return et.isAPIAppSecretDirty();
        case INDEX_APIENCODINGAESKEY:
            return et.isAPIEncodingAESKeyDirty();
        case INDEX_APITOKEN:
            return et.isAPITokenDirty();
        case INDEX_APIURL:
            return et.isAPIURLDirty();
        case INDEX_APPTYPE:
            return et.isAppTypeDirty();
        case INDEX_APPURL:
            return et.isAppURLDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_REPENTERFLAG:
            return et.isREPENTERFlagDirty();
        case INDEX_REPLOCATIONFLAG:
            return et.isRepLocationFlagDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VALIDFLAG:
            return et.isValidFlagDirty();
        case INDEX_WXACCOUNTID:
            return et.isWXAccountIdDirty();
        case INDEX_WXACCOUNTNAME:
            return et.isWXAccountNameDirty();
        case INDEX_WXENTAPPID:
            return et.isWXEntAppIdDirty();
        case INDEX_WXENTAPPNAME:
            return et.isWXEntAppNameDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(WXEntAppBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAgentId()!=null) {
            JSONObjectHelper.put(json,"agentid",getJSONValue(et.getAgentId()),false);
        }
        if(bIncEmpty||et.getAPIAppSecret()!=null) {
            JSONObjectHelper.put(json,"apiappsecret",getJSONValue(et.getAPIAppSecret()),false);
        }
        if(bIncEmpty||et.getAPIEncodingAESKey()!=null) {
            JSONObjectHelper.put(json,"apiencodingaeskey",getJSONValue(et.getAPIEncodingAESKey()),false);
        }
        if(bIncEmpty||et.getAPIToken()!=null) {
            JSONObjectHelper.put(json,"apitoken",getJSONValue(et.getAPIToken()),false);
        }
        if(bIncEmpty||et.getAPIURL()!=null) {
            JSONObjectHelper.put(json,"apiurl",getJSONValue(et.getAPIURL()),false);
        }
        if(bIncEmpty||et.getAppType()!=null) {
            JSONObjectHelper.put(json,"apptype",getJSONValue(et.getAppType()),false);
        }
        if(bIncEmpty||et.getAppURL()!=null) {
            JSONObjectHelper.put(json,"appurl",getJSONValue(et.getAppURL()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getREPENTERFlag()!=null) {
            JSONObjectHelper.put(json,"repenterflag",getJSONValue(et.getREPENTERFlag()),false);
        }
        if(bIncEmpty||et.getRepLocationFlag()!=null) {
            JSONObjectHelper.put(json,"replocationflag",getJSONValue(et.getRepLocationFlag()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            JSONObjectHelper.put(json,"reserver3",getJSONValue(et.getReserver3()),false);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            JSONObjectHelper.put(json,"reserver4",getJSONValue(et.getReserver4()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            JSONObjectHelper.put(json,"validflag",getJSONValue(et.getValidFlag()),false);
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            JSONObjectHelper.put(json,"wxaccountid",getJSONValue(et.getWXAccountId()),false);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            JSONObjectHelper.put(json,"wxaccountname",getJSONValue(et.getWXAccountName()),false);
        }
        if(bIncEmpty||et.getWXEntAppId()!=null) {
            JSONObjectHelper.put(json,"wxentappid",getJSONValue(et.getWXEntAppId()),false);
        }
        if(bIncEmpty||et.getWXEntAppName()!=null) {
            JSONObjectHelper.put(json,"wxentappname",getJSONValue(et.getWXEntAppName()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(WXEntAppBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAgentId()!=null) {
            Object obj = et.getAgentId();
            node.setAttribute("AGENTID",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getAPIAppSecret()!=null) {
            Object obj = et.getAPIAppSecret();
            node.setAttribute("APIAPPSECRET",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAPIEncodingAESKey()!=null) {
            Object obj = et.getAPIEncodingAESKey();
            node.setAttribute("APIENCODINGAESKEY",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAPIToken()!=null) {
            Object obj = et.getAPIToken();
            node.setAttribute("APITOKEN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAPIURL()!=null) {
            Object obj = et.getAPIURL();
            node.setAttribute("APIURL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAppType()!=null) {
            Object obj = et.getAppType();
            node.setAttribute("APPTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAppURL()!=null) {
            Object obj = et.getAppURL();
            node.setAttribute("APPURL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getREPENTERFlag()!=null) {
            Object obj = et.getREPENTERFlag();
            node.setAttribute("REPENTERFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getRepLocationFlag()!=null) {
            Object obj = et.getRepLocationFlag();
            node.setAttribute("REPLOCATIONFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            Object obj = et.getReserver3();
            node.setAttribute("RESERVER3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getValidFlag()!=null) {
            Object obj = et.getValidFlag();
            node.setAttribute("VALIDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            Object obj = et.getWXAccountId();
            node.setAttribute("WXACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            Object obj = et.getWXAccountName();
            node.setAttribute("WXACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXEntAppId()!=null) {
            Object obj = et.getWXEntAppId();
            node.setAttribute("WXENTAPPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXEntAppName()!=null) {
            Object obj = et.getWXEntAppName();
            node.setAttribute("WXENTAPPNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXEntAppBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WXEntAppBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAgentIdDirty() && (bIncEmpty||et.getAgentId()!=null)) {
            dst.set(FIELD_AGENTID,et.getAgentId());
        }
        if(et.isAPIAppSecretDirty() && (bIncEmpty||et.getAPIAppSecret()!=null)) {
            dst.set(FIELD_APIAPPSECRET,et.getAPIAppSecret());
        }
        if(et.isAPIEncodingAESKeyDirty() && (bIncEmpty||et.getAPIEncodingAESKey()!=null)) {
            dst.set(FIELD_APIENCODINGAESKEY,et.getAPIEncodingAESKey());
        }
        if(et.isAPITokenDirty() && (bIncEmpty||et.getAPIToken()!=null)) {
            dst.set(FIELD_APITOKEN,et.getAPIToken());
        }
        if(et.isAPIURLDirty() && (bIncEmpty||et.getAPIURL()!=null)) {
            dst.set(FIELD_APIURL,et.getAPIURL());
        }
        if(et.isAppTypeDirty() && (bIncEmpty||et.getAppType()!=null)) {
            dst.set(FIELD_APPTYPE,et.getAppType());
        }
        if(et.isAppURLDirty() && (bIncEmpty||et.getAppURL()!=null)) {
            dst.set(FIELD_APPURL,et.getAppURL());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isREPENTERFlagDirty() && (bIncEmpty||et.getREPENTERFlag()!=null)) {
            dst.set(FIELD_REPENTERFLAG,et.getREPENTERFlag());
        }
        if(et.isRepLocationFlagDirty() && (bIncEmpty||et.getRepLocationFlag()!=null)) {
            dst.set(FIELD_REPLOCATIONFLAG,et.getRepLocationFlag());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isReserver3Dirty() && (bIncEmpty||et.getReserver3()!=null)) {
            dst.set(FIELD_RESERVER3,et.getReserver3());
        }
        if(et.isReserver4Dirty() && (bIncEmpty||et.getReserver4()!=null)) {
            dst.set(FIELD_RESERVER4,et.getReserver4());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isValidFlagDirty() && (bIncEmpty||et.getValidFlag()!=null)) {
            dst.set(FIELD_VALIDFLAG,et.getValidFlag());
        }
        if(et.isWXAccountIdDirty() && (bIncEmpty||et.getWXAccountId()!=null)) {
            dst.set(FIELD_WXACCOUNTID,et.getWXAccountId());
        }
        if(et.isWXAccountNameDirty() && (bIncEmpty||et.getWXAccountName()!=null)) {
            dst.set(FIELD_WXACCOUNTNAME,et.getWXAccountName());
        }
        if(et.isWXEntAppIdDirty() && (bIncEmpty||et.getWXEntAppId()!=null)) {
            dst.set(FIELD_WXENTAPPID,et.getWXEntAppId());
        }
        if(et.isWXEntAppNameDirty() && (bIncEmpty||et.getWXEntAppName()!=null)) {
            dst.set(FIELD_WXENTAPPNAME,et.getWXEntAppName());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  WXEntAppBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WXEntAppBase et,int index) throws Exception {
        switch(index) {
        case INDEX_AGENTID:
            et.resetAgentId();
            return true;
        case INDEX_APIAPPSECRET:
            et.resetAPIAppSecret();
            return true;
        case INDEX_APIENCODINGAESKEY:
            et.resetAPIEncodingAESKey();
            return true;
        case INDEX_APITOKEN:
            et.resetAPIToken();
            return true;
        case INDEX_APIURL:
            et.resetAPIURL();
            return true;
        case INDEX_APPTYPE:
            et.resetAppType();
            return true;
        case INDEX_APPURL:
            et.resetAppURL();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_REPENTERFLAG:
            et.resetREPENTERFlag();
            return true;
        case INDEX_REPLOCATIONFLAG:
            et.resetRepLocationFlag();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_RESERVER3:
            et.resetReserver3();
            return true;
        case INDEX_RESERVER4:
            et.resetReserver4();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VALIDFLAG:
            et.resetValidFlag();
            return true;
        case INDEX_WXACCOUNTID:
            et.resetWXAccountId();
            return true;
        case INDEX_WXACCOUNTNAME:
            et.resetWXAccountName();
            return true;
        case INDEX_WXENTAPPID:
            et.resetWXEntAppId();
            return true;
        case INDEX_WXENTAPPNAME:
            et.resetWXEntAppName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWXAccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.wx.entity.WXAccount wxaccount = null;
    /**
    * 获取父数据 微信公众号
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wx.entity.WXAccount getWXAccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccount();
        }

        if(this.getWXAccountId()==null)
            return null;
        synchronized(this.objWXAccountLock) {
            if(this.wxaccount!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWXAccountId(),wxaccount.getWXAccountId())!=0) {
                    this.wxaccount = null;
                }
            }


            if(this.wxaccount==null) {
                net.ibizsys.psrt.srv.wx.entity.WXAccount wxaccount = new net.ibizsys.psrt.srv.wx.entity.WXAccount();
                wxaccount.setWXAccountId(this.getWXAccountId());
                net.ibizsys.psrt.srv.wx.service.WXAccountService service = (net.ibizsys.psrt.srv.wx.service.WXAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXAccountService.class,this.getSessionFactory());
                service.autoGet(wxaccount);
                this.wxaccount = wxaccount;
            }
            return this.wxaccount;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WXEntAppBase getProxyEntity() {
        return this.proxyWXEntAppBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXEntAppBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WXEntAppBase) {
            this.proxyWXEntAppBase = (WXEntAppBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXEntAppService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}