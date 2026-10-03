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
 * 实体[WXAccessToken] 数据对象基类
 */
public abstract class WXAccessTokenBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXAccessTokenBase.class);
    /**
     * 属性[票据]
     */
    public final static String FIELD_ACCESSTOKEN = "ACCESSTOKEN";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[过期时间]
     */
    public final static String FIELD_EXPIREDTIME = "EXPIREDTIME";
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
     * 属性[微信访问票据标识]
     */
    public final static String FIELD_WXACCESSTOKENID = "WXACCESSTOKENID";
    /**
     * 属性[微信访问票据名称]
     */
    public final static String FIELD_WXACCESSTOKENNAME = "WXACCESSTOKENNAME";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTID = "WXACCOUNTID";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";

    private final static int INDEX_ACCESSTOKEN = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_EXPIREDTIME = 3;
    private final static int INDEX_RESERVER = 4;
    private final static int INDEX_RESERVER2 = 5;
    private final static int INDEX_RESERVER3 = 6;
    private final static int INDEX_RESERVER4 = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;
    private final static int INDEX_WXACCESSTOKENID = 10;
    private final static int INDEX_WXACCESSTOKENNAME = 11;
    private final static int INDEX_WXACCOUNTID = 12;
    private final static int INDEX_WXACCOUNTNAME = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACCESSTOKEN, INDEX_ACCESSTOKEN);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_EXPIREDTIME, INDEX_EXPIREDTIME);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WXACCESSTOKENID, INDEX_WXACCESSTOKENID);
        fieldIndexMap.put( FIELD_WXACCESSTOKENNAME, INDEX_WXACCESSTOKENNAME);
        fieldIndexMap.put( FIELD_WXACCOUNTID, INDEX_WXACCOUNTID);
        fieldIndexMap.put( FIELD_WXACCOUNTNAME, INDEX_WXACCOUNTNAME);
    }

    private WXAccessTokenBase proxyWXAccessTokenBase = null;
    public WXAccessTokenBase() {
        super();
    }
    private boolean accesstokenDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expiredtimeDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccesstokenidDirtyFlag = false;
    private boolean wxaccesstokennameDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;

    @Column(name="accesstoken")
    private String accesstoken;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expiredtime")
    private Timestamp expiredtime;
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
    @Column(name="wxaccesstokenid")
    private String wxaccesstokenid;
    @Column(name="wxaccesstokenname")
    private String wxaccesstokenname;
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;


    /**
     *  设置属性值[票据]
     *  @param accesstoken
     */
    public void setAccessToken(String accesstoken) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAccessToken(accesstoken);
            return;
        }
        if(accesstoken!=null) {
            accesstoken = StringHelper.trimRight(accesstoken);
            if(accesstoken.length()==0) {
                accesstoken = null;
            }
        }
        this.accesstoken = accesstoken;
        this.accesstokenDirtyFlag  = true;
    }

    /**
     *  获取属性值[票据]
     */
    public String getAccessToken() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAccessToken();
        }
        return this.accesstoken;
    }

    /**
     *  获取属性值[票据]是否修改
     */
    public boolean isAccessTokenDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAccessTokenDirty();
        }
        return this.accesstokenDirtyFlag;
    }

    /**
     *  重置属性值[票据]
     */
    public void resetAccessToken() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAccessToken();
            return;
        }

        this.accesstokenDirtyFlag = false;
        this.accesstoken = null;
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
     *  设置属性值[过期时间]
     *  @param expiredtime
     */
    public void setExpiredTime(Timestamp expiredtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setExpiredTime(expiredtime);
            return;
        }
        this.expiredtime = expiredtime;
        this.expiredtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[过期时间]
     */
    public Timestamp getExpiredTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getExpiredTime();
        }
        return this.expiredtime;
    }

    /**
     *  获取属性值[过期时间]是否修改
     */
    public boolean isExpiredTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isExpiredTimeDirty();
        }
        return this.expiredtimeDirtyFlag;
    }

    /**
     *  重置属性值[过期时间]
     */
    public void resetExpiredTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetExpiredTime();
            return;
        }

        this.expiredtimeDirtyFlag = false;
        this.expiredtime = null;
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
     *  设置属性值[微信访问票据标识]
     *  @param wxaccesstokenid
     */
    public void setWXAccessTokenId(String wxaccesstokenid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccessTokenId(wxaccesstokenid);
            return;
        }
        if(wxaccesstokenid!=null) {
            wxaccesstokenid = StringHelper.trimRight(wxaccesstokenid);
            if(wxaccesstokenid.length()==0) {
                wxaccesstokenid = null;
            }
        }
        this.wxaccesstokenid = wxaccesstokenid;
        this.wxaccesstokenidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信访问票据标识]
     */
    public String getWXAccessTokenId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccessTokenId();
        }
        return this.wxaccesstokenid;
    }

    /**
     *  获取属性值[微信访问票据标识]是否修改
     */
    public boolean isWXAccessTokenIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccessTokenIdDirty();
        }
        return this.wxaccesstokenidDirtyFlag;
    }

    /**
     *  重置属性值[微信访问票据标识]
     */
    public void resetWXAccessTokenId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccessTokenId();
            return;
        }

        this.wxaccesstokenidDirtyFlag = false;
        this.wxaccesstokenid = null;
    }
    /**
     *  设置属性值[微信访问票据名称]
     *  @param wxaccesstokenname
     */
    public void setWXAccessTokenName(String wxaccesstokenname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccessTokenName(wxaccesstokenname);
            return;
        }
        if(wxaccesstokenname!=null) {
            wxaccesstokenname = StringHelper.trimRight(wxaccesstokenname);
            if(wxaccesstokenname.length()==0) {
                wxaccesstokenname = null;
            }
        }
        this.wxaccesstokenname = wxaccesstokenname;
        this.wxaccesstokennameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信访问票据名称]
     */
    public String getWXAccessTokenName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccessTokenName();
        }
        return this.wxaccesstokenname;
    }

    /**
     *  获取属性值[微信访问票据名称]是否修改
     */
    public boolean isWXAccessTokenNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccessTokenNameDirty();
        }
        return this.wxaccesstokennameDirtyFlag;
    }

    /**
     *  重置属性值[微信访问票据名称]
     */
    public void resetWXAccessTokenName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccessTokenName();
            return;
        }

        this.wxaccesstokennameDirtyFlag = false;
        this.wxaccesstokenname = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WXAccessTokenBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WXAccessTokenBase et) {
        et.resetAccessToken();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetExpiredTime();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccessTokenId();
        et.resetWXAccessTokenName();
        et.resetWXAccountId();
        et.resetWXAccountName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAccessTokenDirty()) {
            params.put(FIELD_ACCESSTOKEN,getAccessToken());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isExpiredTimeDirty()) {
            params.put(FIELD_EXPIREDTIME,getExpiredTime());
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
        if(!bDirtyOnly || isWXAccessTokenIdDirty()) {
            params.put(FIELD_WXACCESSTOKENID,getWXAccessTokenId());
        }
        if(!bDirtyOnly || isWXAccessTokenNameDirty()) {
            params.put(FIELD_WXACCESSTOKENNAME,getWXAccessTokenName());
        }
        if(!bDirtyOnly || isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID,getWXAccountId());
        }
        if(!bDirtyOnly || isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME,getWXAccountName());
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

        return  WXAccessTokenBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WXAccessTokenBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACCESSTOKEN:
            return et.getAccessToken();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_EXPIREDTIME:
            return et.getExpiredTime();
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
        case INDEX_WXACCESSTOKENID:
            return et.getWXAccessTokenId();
        case INDEX_WXACCESSTOKENNAME:
            return et.getWXAccessTokenName();
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId();
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName();
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

        WXAccessTokenBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WXAccessTokenBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACCESSTOKEN:
            et.setAccessToken(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_EXPIREDTIME:
            et.setExpiredTime(DataObject.getTimestampValue(obj));
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
        case INDEX_WXACCESSTOKENID:
            et.setWXAccessTokenId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCESSTOKENNAME:
            et.setWXAccessTokenName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCOUNTID:
            et.setWXAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCOUNTNAME:
            et.setWXAccountName(DataObject.getStringValue(obj));
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

        return  WXAccessTokenBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WXAccessTokenBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACCESSTOKEN:
            return et.getAccessToken()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_EXPIREDTIME:
            return et.getExpiredTime()==null;
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
        case INDEX_WXACCESSTOKENID:
            return et.getWXAccessTokenId()==null;
        case INDEX_WXACCESSTOKENNAME:
            return et.getWXAccessTokenName()==null;
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId()==null;
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName()==null;
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
        return  WXAccessTokenBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WXAccessTokenBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACCESSTOKEN:
            return et.isAccessTokenDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_EXPIREDTIME:
            return et.isExpiredTimeDirty();
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
        case INDEX_WXACCESSTOKENID:
            return et.isWXAccessTokenIdDirty();
        case INDEX_WXACCESSTOKENNAME:
            return et.isWXAccessTokenNameDirty();
        case INDEX_WXACCOUNTID:
            return et.isWXAccountIdDirty();
        case INDEX_WXACCOUNTNAME:
            return et.isWXAccountNameDirty();
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
    private static  void fillJSONObject(WXAccessTokenBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAccessToken()!=null) {
            JSONObjectHelper.put(json,"accesstoken",getJSONValue(et.getAccessToken()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getExpiredTime()!=null) {
            JSONObjectHelper.put(json,"expiredtime",getJSONValue(et.getExpiredTime()),false);
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
        if(bIncEmpty||et.getWXAccessTokenId()!=null) {
            JSONObjectHelper.put(json,"wxaccesstokenid",getJSONValue(et.getWXAccessTokenId()),false);
        }
        if(bIncEmpty||et.getWXAccessTokenName()!=null) {
            JSONObjectHelper.put(json,"wxaccesstokenname",getJSONValue(et.getWXAccessTokenName()),false);
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            JSONObjectHelper.put(json,"wxaccountid",getJSONValue(et.getWXAccountId()),false);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            JSONObjectHelper.put(json,"wxaccountname",getJSONValue(et.getWXAccountName()),false);
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
    private static void fillXmlNode(WXAccessTokenBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAccessToken()!=null) {
            Object obj = et.getAccessToken();
            node.setAttribute("ACCESSTOKEN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getExpiredTime()!=null) {
            Object obj = et.getExpiredTime();
            node.setAttribute("EXPIREDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
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
        if(bIncEmpty||et.getWXAccessTokenId()!=null) {
            Object obj = et.getWXAccessTokenId();
            node.setAttribute("WXACCESSTOKENID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccessTokenName()!=null) {
            Object obj = et.getWXAccessTokenName();
            node.setAttribute("WXACCESSTOKENNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            Object obj = et.getWXAccountId();
            node.setAttribute("WXACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            Object obj = et.getWXAccountName();
            node.setAttribute("WXACCOUNTNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXAccessTokenBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WXAccessTokenBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAccessTokenDirty() && (bIncEmpty||et.getAccessToken()!=null)) {
            dst.set(FIELD_ACCESSTOKEN,et.getAccessToken());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isExpiredTimeDirty() && (bIncEmpty||et.getExpiredTime()!=null)) {
            dst.set(FIELD_EXPIREDTIME,et.getExpiredTime());
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
        if(et.isWXAccessTokenIdDirty() && (bIncEmpty||et.getWXAccessTokenId()!=null)) {
            dst.set(FIELD_WXACCESSTOKENID,et.getWXAccessTokenId());
        }
        if(et.isWXAccessTokenNameDirty() && (bIncEmpty||et.getWXAccessTokenName()!=null)) {
            dst.set(FIELD_WXACCESSTOKENNAME,et.getWXAccessTokenName());
        }
        if(et.isWXAccountIdDirty() && (bIncEmpty||et.getWXAccountId()!=null)) {
            dst.set(FIELD_WXACCOUNTID,et.getWXAccountId());
        }
        if(et.isWXAccountNameDirty() && (bIncEmpty||et.getWXAccountName()!=null)) {
            dst.set(FIELD_WXACCOUNTNAME,et.getWXAccountName());
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
        return  WXAccessTokenBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WXAccessTokenBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACCESSTOKEN:
            et.resetAccessToken();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_EXPIREDTIME:
            et.resetExpiredTime();
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
        case INDEX_WXACCESSTOKENID:
            et.resetWXAccessTokenId();
            return true;
        case INDEX_WXACCESSTOKENNAME:
            et.resetWXAccessTokenName();
            return true;
        case INDEX_WXACCOUNTID:
            et.resetWXAccountId();
            return true;
        case INDEX_WXACCOUNTNAME:
            et.resetWXAccountName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWxaccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.wx.entity.WXAccount wxaccount = null;
    /**
    * 获取父数据 微信公众号
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wx.entity.WXAccount getWxaccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWxaccount();
        }

        if(this.getWXAccountId()==null)
            return null;
        synchronized(this.objWxaccountLock) {
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
    private WXAccessTokenBase getProxyEntity() {
        return this.proxyWXAccessTokenBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXAccessTokenBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WXAccessTokenBase) {
            this.proxyWXAccessTokenBase = (WXAccessTokenBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXAccessTokenService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}