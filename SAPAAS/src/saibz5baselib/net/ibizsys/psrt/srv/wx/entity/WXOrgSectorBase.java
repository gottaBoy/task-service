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
 * 实体[WXOrgSector] 数据对象基类
 */
public abstract class WXOrgSectorBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXOrgSectorBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[部门编号]
     */
    public final static String FIELD_DEPTID = "DEPTID";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[机构部门]
     */
    public final static String FIELD_ORGSECTORID = "ORGSECTORID";
    /**
     * 属性[机构部门]
     */
    public final static String FIELD_ORGSECTORNAME = "ORGSECTORNAME";
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
     * 属性[微信部门标识]
     */
    public final static String FIELD_WXORGSECTORID = "WXORGSECTORID";
    /**
     * 属性[微信部门名称]
     */
    public final static String FIELD_WXORGSECTORNAME = "WXORGSECTORNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DEPTID = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_ORGSECTORID = 4;
    private final static int INDEX_ORGSECTORNAME = 5;
    private final static int INDEX_RESERVER = 6;
    private final static int INDEX_RESERVER2 = 7;
    private final static int INDEX_RESERVER3 = 8;
    private final static int INDEX_RESERVER4 = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;
    private final static int INDEX_WXACCOUNTID = 12;
    private final static int INDEX_WXACCOUNTNAME = 13;
    private final static int INDEX_WXORGSECTORID = 14;
    private final static int INDEX_WXORGSECTORNAME = 15;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEPTID, INDEX_DEPTID);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_ORGSECTORID, INDEX_ORGSECTORID);
        fieldIndexMap.put( FIELD_ORGSECTORNAME, INDEX_ORGSECTORNAME);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WXACCOUNTID, INDEX_WXACCOUNTID);
        fieldIndexMap.put( FIELD_WXACCOUNTNAME, INDEX_WXACCOUNTNAME);
        fieldIndexMap.put( FIELD_WXORGSECTORID, INDEX_WXORGSECTORID);
        fieldIndexMap.put( FIELD_WXORGSECTORNAME, INDEX_WXORGSECTORNAME);
    }

    private WXOrgSectorBase proxyWXOrgSectorBase = null;
    public WXOrgSectorBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deptidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgsectoridDirtyFlag = false;
    private boolean orgsectornameDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    private boolean wxorgsectoridDirtyFlag = false;
    private boolean wxorgsectornameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deptid")
    private Integer deptid;
    @Column(name="memo")
    private String memo;
    @Column(name="orgsectorid")
    private String orgsectorid;
    @Column(name="orgsectorname")
    private String orgsectorname;
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
    @Column(name="wxorgsectorid")
    private String wxorgsectorid;
    @Column(name="wxorgsectorname")
    private String wxorgsectorname;


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
     *  设置属性值[部门编号]
     *  @param deptid
     */
    public void setDeptId(Integer deptid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDeptId(deptid);
            return;
        }
        this.deptid = deptid;
        this.deptidDirtyFlag  = true;
    }

    /**
     *  获取属性值[部门编号]
     */
    public Integer getDeptId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDeptId();
        }
        return this.deptid;
    }

    /**
     *  获取属性值[部门编号]是否修改
     */
    public boolean isDeptIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDeptIdDirty();
        }
        return this.deptidDirtyFlag;
    }

    /**
     *  重置属性值[部门编号]
     */
    public void resetDeptId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDeptId();
            return;
        }

        this.deptidDirtyFlag = false;
        this.deptid = null;
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
     *  设置属性值[机构部门]
     *  @param orgsectorid
     */
    public void setOrgSectorId(String orgsectorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgSectorId(orgsectorid);
            return;
        }
        if(orgsectorid!=null) {
            orgsectorid = StringHelper.trimRight(orgsectorid);
            if(orgsectorid.length()==0) {
                orgsectorid = null;
            }
        }
        this.orgsectorid = orgsectorid;
        this.orgsectoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[机构部门]
     */
    public String getOrgSectorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgSectorId();
        }
        return this.orgsectorid;
    }

    /**
     *  获取属性值[机构部门]是否修改
     */
    public boolean isOrgSectorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgSectorIdDirty();
        }
        return this.orgsectoridDirtyFlag;
    }

    /**
     *  重置属性值[机构部门]
     */
    public void resetOrgSectorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgSectorId();
            return;
        }

        this.orgsectoridDirtyFlag = false;
        this.orgsectorid = null;
    }
    /**
     *  设置属性值[机构部门]
     *  @param orgsectorname
     */
    public void setOrgSectorName(String orgsectorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgSectorName(orgsectorname);
            return;
        }
        if(orgsectorname!=null) {
            orgsectorname = StringHelper.trimRight(orgsectorname);
            if(orgsectorname.length()==0) {
                orgsectorname = null;
            }
        }
        this.orgsectorname = orgsectorname;
        this.orgsectornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[机构部门]
     */
    public String getOrgSectorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgSectorName();
        }
        return this.orgsectorname;
    }

    /**
     *  获取属性值[机构部门]是否修改
     */
    public boolean isOrgSectorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgSectorNameDirty();
        }
        return this.orgsectornameDirtyFlag;
    }

    /**
     *  重置属性值[机构部门]
     */
    public void resetOrgSectorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgSectorName();
            return;
        }

        this.orgsectornameDirtyFlag = false;
        this.orgsectorname = null;
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
     *  设置属性值[微信部门标识]
     *  @param wxorgsectorid
     */
    public void setWXOrgSectorId(String wxorgsectorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXOrgSectorId(wxorgsectorid);
            return;
        }
        if(wxorgsectorid!=null) {
            wxorgsectorid = StringHelper.trimRight(wxorgsectorid);
            if(wxorgsectorid.length()==0) {
                wxorgsectorid = null;
            }
        }
        this.wxorgsectorid = wxorgsectorid;
        this.wxorgsectoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信部门标识]
     */
    public String getWXOrgSectorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXOrgSectorId();
        }
        return this.wxorgsectorid;
    }

    /**
     *  获取属性值[微信部门标识]是否修改
     */
    public boolean isWXOrgSectorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXOrgSectorIdDirty();
        }
        return this.wxorgsectoridDirtyFlag;
    }

    /**
     *  重置属性值[微信部门标识]
     */
    public void resetWXOrgSectorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXOrgSectorId();
            return;
        }

        this.wxorgsectoridDirtyFlag = false;
        this.wxorgsectorid = null;
    }
    /**
     *  设置属性值[微信部门名称]
     *  @param wxorgsectorname
     */
    public void setWXOrgSectorName(String wxorgsectorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXOrgSectorName(wxorgsectorname);
            return;
        }
        if(wxorgsectorname!=null) {
            wxorgsectorname = StringHelper.trimRight(wxorgsectorname);
            if(wxorgsectorname.length()==0) {
                wxorgsectorname = null;
            }
        }
        this.wxorgsectorname = wxorgsectorname;
        this.wxorgsectornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信部门名称]
     */
    public String getWXOrgSectorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXOrgSectorName();
        }
        return this.wxorgsectorname;
    }

    /**
     *  获取属性值[微信部门名称]是否修改
     */
    public boolean isWXOrgSectorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXOrgSectorNameDirty();
        }
        return this.wxorgsectornameDirtyFlag;
    }

    /**
     *  重置属性值[微信部门名称]
     */
    public void resetWXOrgSectorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXOrgSectorName();
            return;
        }

        this.wxorgsectornameDirtyFlag = false;
        this.wxorgsectorname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WXOrgSectorBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WXOrgSectorBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDeptId();
        et.resetMemo();
        et.resetOrgSectorId();
        et.resetOrgSectorName();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccountId();
        et.resetWXAccountName();
        et.resetWXOrgSectorId();
        et.resetWXOrgSectorName();
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
        if(!bDirtyOnly || isDeptIdDirty()) {
            params.put(FIELD_DEPTID,getDeptId());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOrgSectorIdDirty()) {
            params.put(FIELD_ORGSECTORID,getOrgSectorId());
        }
        if(!bDirtyOnly || isOrgSectorNameDirty()) {
            params.put(FIELD_ORGSECTORNAME,getOrgSectorName());
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
        if(!bDirtyOnly || isWXOrgSectorIdDirty()) {
            params.put(FIELD_WXORGSECTORID,getWXOrgSectorId());
        }
        if(!bDirtyOnly || isWXOrgSectorNameDirty()) {
            params.put(FIELD_WXORGSECTORNAME,getWXOrgSectorName());
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

        return  WXOrgSectorBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WXOrgSectorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEPTID:
            return et.getDeptId();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_ORGSECTORID:
            return et.getOrgSectorId();
        case INDEX_ORGSECTORNAME:
            return et.getOrgSectorName();
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
        case INDEX_WXORGSECTORID:
            return et.getWXOrgSectorId();
        case INDEX_WXORGSECTORNAME:
            return et.getWXOrgSectorName();
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

        WXOrgSectorBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WXOrgSectorBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEPTID:
            et.setDeptId(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGSECTORID:
            et.setOrgSectorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGSECTORNAME:
            et.setOrgSectorName(DataObject.getStringValue(obj));
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
        case INDEX_WXORGSECTORID:
            et.setWXOrgSectorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXORGSECTORNAME:
            et.setWXOrgSectorName(DataObject.getStringValue(obj));
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

        return  WXOrgSectorBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WXOrgSectorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEPTID:
            return et.getDeptId()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_ORGSECTORID:
            return et.getOrgSectorId()==null;
        case INDEX_ORGSECTORNAME:
            return et.getOrgSectorName()==null;
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
        case INDEX_WXORGSECTORID:
            return et.getWXOrgSectorId()==null;
        case INDEX_WXORGSECTORNAME:
            return et.getWXOrgSectorName()==null;
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
        return  WXOrgSectorBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WXOrgSectorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEPTID:
            return et.isDeptIdDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_ORGSECTORID:
            return et.isOrgSectorIdDirty();
        case INDEX_ORGSECTORNAME:
            return et.isOrgSectorNameDirty();
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
        case INDEX_WXORGSECTORID:
            return et.isWXOrgSectorIdDirty();
        case INDEX_WXORGSECTORNAME:
            return et.isWXOrgSectorNameDirty();
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
    private static  void fillJSONObject(WXOrgSectorBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDeptId()!=null) {
            JSONObjectHelper.put(json,"deptid",getJSONValue(et.getDeptId()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOrgSectorId()!=null) {
            JSONObjectHelper.put(json,"orgsectorid",getJSONValue(et.getOrgSectorId()),false);
        }
        if(bIncEmpty||et.getOrgSectorName()!=null) {
            JSONObjectHelper.put(json,"orgsectorname",getJSONValue(et.getOrgSectorName()),false);
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
        if(bIncEmpty||et.getWXOrgSectorId()!=null) {
            JSONObjectHelper.put(json,"wxorgsectorid",getJSONValue(et.getWXOrgSectorId()),false);
        }
        if(bIncEmpty||et.getWXOrgSectorName()!=null) {
            JSONObjectHelper.put(json,"wxorgsectorname",getJSONValue(et.getWXOrgSectorName()),false);
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
    private static void fillXmlNode(WXOrgSectorBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDeptId()!=null) {
            Object obj = et.getDeptId();
            node.setAttribute("DEPTID",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgSectorId()!=null) {
            Object obj = et.getOrgSectorId();
            node.setAttribute("ORGSECTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgSectorName()!=null) {
            Object obj = et.getOrgSectorName();
            node.setAttribute("ORGSECTORNAME",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getWXOrgSectorId()!=null) {
            Object obj = et.getWXOrgSectorId();
            node.setAttribute("WXORGSECTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXOrgSectorName()!=null) {
            Object obj = et.getWXOrgSectorName();
            node.setAttribute("WXORGSECTORNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXOrgSectorBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WXOrgSectorBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDeptIdDirty() && (bIncEmpty||et.getDeptId()!=null)) {
            dst.set(FIELD_DEPTID,et.getDeptId());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOrgSectorIdDirty() && (bIncEmpty||et.getOrgSectorId()!=null)) {
            dst.set(FIELD_ORGSECTORID,et.getOrgSectorId());
        }
        if(et.isOrgSectorNameDirty() && (bIncEmpty||et.getOrgSectorName()!=null)) {
            dst.set(FIELD_ORGSECTORNAME,et.getOrgSectorName());
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
        if(et.isWXOrgSectorIdDirty() && (bIncEmpty||et.getWXOrgSectorId()!=null)) {
            dst.set(FIELD_WXORGSECTORID,et.getWXOrgSectorId());
        }
        if(et.isWXOrgSectorNameDirty() && (bIncEmpty||et.getWXOrgSectorName()!=null)) {
            dst.set(FIELD_WXORGSECTORNAME,et.getWXOrgSectorName());
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
        return  WXOrgSectorBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WXOrgSectorBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DEPTID:
            et.resetDeptId();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_ORGSECTORID:
            et.resetOrgSectorId();
            return true;
        case INDEX_ORGSECTORNAME:
            et.resetOrgSectorName();
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
        case INDEX_WXORGSECTORID:
            et.resetWXOrgSectorId();
            return true;
        case INDEX_WXORGSECTORNAME:
            et.resetWXOrgSectorName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objOrgsectorLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.OrgSector orgsector = null;
    /**
    * 获取父数据 组织部门
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.OrgSector getOrgsector() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgsector();
        }

        if(this.getOrgSectorId()==null)
            return null;
        synchronized(this.objOrgsectorLock) {
            if(this.orgsector!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getOrgSectorId(),orgsector.getOrgSectorId())!=0) {
                    this.orgsector = null;
                }
            }


            if(this.orgsector==null) {
                net.ibizsys.psrt.srv.common.entity.OrgSector orgsector = new net.ibizsys.psrt.srv.common.entity.OrgSector();
                orgsector.setOrgSectorId(this.getOrgSectorId());
                net.ibizsys.psrt.srv.common.service.OrgSectorService service = (net.ibizsys.psrt.srv.common.service.OrgSectorService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.OrgSectorService.class,this.getSessionFactory());
                service.autoGet(orgsector);
                this.orgsector = orgsector;
            }
            return this.orgsector;
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
    private WXOrgSectorBase getProxyEntity() {
        return this.proxyWXOrgSectorBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXOrgSectorBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WXOrgSectorBase) {
            this.proxyWXOrgSectorBase = (WXOrgSectorBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXOrgSectorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}