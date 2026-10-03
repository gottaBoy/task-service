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
 * 实体[WXMedia] 数据对象基类
 */
public abstract class WXMediaBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXMediaBase.class);
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
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTID = "WXACCOUNTID";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    /**
     * 属性[微信企业应用]
     */
    public final static String FIELD_WXENTAPPID = "WXENTAPPID";
    /**
     * 属性[微信企业应用]
     */
    public final static String FIELD_WXENTAPPNAME = "WXENTAPPNAME";
    /**
     * 属性[微信多媒体内容标识]
     */
    public final static String FIELD_WXMEDIAID = "WXMEDIAID";
    /**
     * 属性[微信多媒体内容名称]
     */
    public final static String FIELD_WXMEDIANAME = "WXMEDIANAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MEMO = 2;
    private final static int INDEX_RESERVER = 3;
    private final static int INDEX_RESERVER2 = 4;
    private final static int INDEX_RESERVER3 = 5;
    private final static int INDEX_RESERVER4 = 6;
    private final static int INDEX_UPDATEDATE = 7;
    private final static int INDEX_UPDATEMAN = 8;
    private final static int INDEX_WXACCOUNTID = 9;
    private final static int INDEX_WXACCOUNTNAME = 10;
    private final static int INDEX_WXENTAPPID = 11;
    private final static int INDEX_WXENTAPPNAME = 12;
    private final static int INDEX_WXMEDIAID = 13;
    private final static int INDEX_WXMEDIANAME = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WXACCOUNTID, INDEX_WXACCOUNTID);
        fieldIndexMap.put( FIELD_WXACCOUNTNAME, INDEX_WXACCOUNTNAME);
        fieldIndexMap.put( FIELD_WXENTAPPID, INDEX_WXENTAPPID);
        fieldIndexMap.put( FIELD_WXENTAPPNAME, INDEX_WXENTAPPNAME);
        fieldIndexMap.put( FIELD_WXMEDIAID, INDEX_WXMEDIAID);
        fieldIndexMap.put( FIELD_WXMEDIANAME, INDEX_WXMEDIANAME);
    }

    private WXMediaBase proxyWXMediaBase = null;
    public WXMediaBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    private boolean wxentappidDirtyFlag = false;
    private boolean wxentappnameDirtyFlag = false;
    private boolean wxmediaidDirtyFlag = false;
    private boolean wxmedianameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
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
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;
    @Column(name="wxentappid")
    private String wxentappid;
    @Column(name="wxentappname")
    private String wxentappname;
    @Column(name="wxmediaid")
    private String wxmediaid;
    @Column(name="wxmedianame")
    private String wxmedianame;


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
     *  设置属性值[微信企业应用]
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
     *  获取属性值[微信企业应用]
     */
    public String getWXEntAppId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    /**
     *  获取属性值[微信企业应用]是否修改
     */
    public boolean isWXEntAppIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用]
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
     *  设置属性值[微信企业应用]
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
     *  获取属性值[微信企业应用]
     */
    public String getWXEntAppName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    /**
     *  获取属性值[微信企业应用]是否修改
     */
    public boolean isWXEntAppNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用]
     */
    public void resetWXEntAppName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }

        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }
    /**
     *  设置属性值[微信多媒体内容标识]
     *  @param wxmediaid
     */
    public void setWXMediaId(String wxmediaid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXMediaId(wxmediaid);
            return;
        }
        if(wxmediaid!=null) {
            wxmediaid = StringHelper.trimRight(wxmediaid);
            if(wxmediaid.length()==0) {
                wxmediaid = null;
            }
        }
        this.wxmediaid = wxmediaid;
        this.wxmediaidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信多媒体内容标识]
     */
    public String getWXMediaId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXMediaId();
        }
        return this.wxmediaid;
    }

    /**
     *  获取属性值[微信多媒体内容标识]是否修改
     */
    public boolean isWXMediaIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXMediaIdDirty();
        }
        return this.wxmediaidDirtyFlag;
    }

    /**
     *  重置属性值[微信多媒体内容标识]
     */
    public void resetWXMediaId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXMediaId();
            return;
        }

        this.wxmediaidDirtyFlag = false;
        this.wxmediaid = null;
    }
    /**
     *  设置属性值[微信多媒体内容名称]
     *  @param wxmedianame
     */
    public void setWXMediaName(String wxmedianame) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXMediaName(wxmedianame);
            return;
        }
        if(wxmedianame!=null) {
            wxmedianame = StringHelper.trimRight(wxmedianame);
            if(wxmedianame.length()==0) {
                wxmedianame = null;
            }
        }
        this.wxmedianame = wxmedianame;
        this.wxmedianameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信多媒体内容名称]
     */
    public String getWXMediaName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXMediaName();
        }
        return this.wxmedianame;
    }

    /**
     *  获取属性值[微信多媒体内容名称]是否修改
     */
    public boolean isWXMediaNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXMediaNameDirty();
        }
        return this.wxmedianameDirtyFlag;
    }

    /**
     *  重置属性值[微信多媒体内容名称]
     */
    public void resetWXMediaName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXMediaName();
            return;
        }

        this.wxmedianameDirtyFlag = false;
        this.wxmedianame = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WXMediaBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WXMediaBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccountId();
        et.resetWXAccountName();
        et.resetWXEntAppId();
        et.resetWXEntAppName();
        et.resetWXMediaId();
        et.resetWXMediaName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
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
        if(!bDirtyOnly || isWXMediaIdDirty()) {
            params.put(FIELD_WXMEDIAID,getWXMediaId());
        }
        if(!bDirtyOnly || isWXMediaNameDirty()) {
            params.put(FIELD_WXMEDIANAME,getWXMediaName());
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

        return  WXMediaBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WXMediaBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
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
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId();
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName();
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId();
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName();
        case INDEX_WXMEDIAID:
            return et.getWXMediaId();
        case INDEX_WXMEDIANAME:
            return et.getWXMediaName();
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

        WXMediaBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WXMediaBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
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
        case INDEX_WXMEDIAID:
            et.setWXMediaId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXMEDIANAME:
            et.setWXMediaName(DataObject.getStringValue(obj));
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

        return  WXMediaBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WXMediaBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
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
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId()==null;
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName()==null;
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId()==null;
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName()==null;
        case INDEX_WXMEDIAID:
            return et.getWXMediaId()==null;
        case INDEX_WXMEDIANAME:
            return et.getWXMediaName()==null;
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
        return  WXMediaBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WXMediaBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
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
        case INDEX_WXACCOUNTID:
            return et.isWXAccountIdDirty();
        case INDEX_WXACCOUNTNAME:
            return et.isWXAccountNameDirty();
        case INDEX_WXENTAPPID:
            return et.isWXEntAppIdDirty();
        case INDEX_WXENTAPPNAME:
            return et.isWXEntAppNameDirty();
        case INDEX_WXMEDIAID:
            return et.isWXMediaIdDirty();
        case INDEX_WXMEDIANAME:
            return et.isWXMediaNameDirty();
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
    private static  void fillJSONObject(WXMediaBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
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
        if(bIncEmpty||et.getWXMediaId()!=null) {
            JSONObjectHelper.put(json,"wxmediaid",getJSONValue(et.getWXMediaId()),false);
        }
        if(bIncEmpty||et.getWXMediaName()!=null) {
            JSONObjectHelper.put(json,"wxmedianame",getJSONValue(et.getWXMediaName()),false);
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
    private static void fillXmlNode(WXMediaBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWXMediaId()!=null) {
            Object obj = et.getWXMediaId();
            node.setAttribute("WXMEDIAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXMediaName()!=null) {
            Object obj = et.getWXMediaName();
            node.setAttribute("WXMEDIANAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXMediaBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WXMediaBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
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
        if(et.isWXMediaIdDirty() && (bIncEmpty||et.getWXMediaId()!=null)) {
            dst.set(FIELD_WXMEDIAID,et.getWXMediaId());
        }
        if(et.isWXMediaNameDirty() && (bIncEmpty||et.getWXMediaName()!=null)) {
            dst.set(FIELD_WXMEDIANAME,et.getWXMediaName());
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
        return  WXMediaBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WXMediaBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
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
        case INDEX_WXMEDIAID:
            et.resetWXMediaId();
            return true;
        case INDEX_WXMEDIANAME:
            et.resetWXMediaName();
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

    private Integer objWXEntAppLock = new Integer(1);
    private net.ibizsys.psrt.srv.wx.entity.WXEntApp wxentapp = null;
    /**
    * 获取父数据 微信企业应用
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wx.entity.WXEntApp getWXEntApp() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntApp();
        }

        if(this.getWXEntAppId()==null)
            return null;
        synchronized(this.objWXEntAppLock) {
            if(this.wxentapp!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWXEntAppId(),wxentapp.getWXEntAppId())!=0) {
                    this.wxentapp = null;
                }
            }


            if(this.wxentapp==null) {
                net.ibizsys.psrt.srv.wx.entity.WXEntApp wxentapp = new net.ibizsys.psrt.srv.wx.entity.WXEntApp();
                wxentapp.setWXEntAppId(this.getWXEntAppId());
                net.ibizsys.psrt.srv.wx.service.WXEntAppService service = (net.ibizsys.psrt.srv.wx.service.WXEntAppService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXEntAppService.class,this.getSessionFactory());
                service.autoGet(wxentapp);
                this.wxentapp = wxentapp;
            }
            return this.wxentapp;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WXMediaBase getProxyEntity() {
        return this.proxyWXMediaBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXMediaBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WXMediaBase) {
            this.proxyWXMediaBase = (WXMediaBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXMediaService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}