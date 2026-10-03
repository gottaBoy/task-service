/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.entity;


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
 * 实体[WFUserGroupDetail] 数据对象基类
 */
public abstract class WFUserGroupDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserGroupDetailBase.class);
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
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[工作流用户组成员标识]
     */
    public final static String FIELD_WFUSERGROUPDETAILID = "WFUSERGROUPDETAILID";
    /**
     * 属性[工作流用户名称]
     */
    public final static String FIELD_WFUSERGROUPDETAILNAME = "WFUSERGROUPDETAILNAME";
    /**
     * 属性[用户组]
     */
    public final static String FIELD_WFUSERGROUPID = "WFUSERGROUPID";
    /**
     * 属性[工作流用户组]
     */
    public final static String FIELD_WFUSERGROUPNAME = "WFUSERGROUPNAME";
    /**
     * 属性[用户]
     */
    public final static String FIELD_WFUSERID = "WFUSERID";
    /**
     * 属性[工作流用户]
     */
    public final static String FIELD_WFUSERNAME = "WFUSERNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MEMO = 2;
    private final static int INDEX_UPDATEDATE = 3;
    private final static int INDEX_UPDATEMAN = 4;
    private final static int INDEX_WFUSERGROUPDETAILID = 5;
    private final static int INDEX_WFUSERGROUPDETAILNAME = 6;
    private final static int INDEX_WFUSERGROUPID = 7;
    private final static int INDEX_WFUSERGROUPNAME = 8;
    private final static int INDEX_WFUSERID = 9;
    private final static int INDEX_WFUSERNAME = 10;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFUSERGROUPDETAILID, INDEX_WFUSERGROUPDETAILID);
        fieldIndexMap.put( FIELD_WFUSERGROUPDETAILNAME, INDEX_WFUSERGROUPDETAILNAME);
        fieldIndexMap.put( FIELD_WFUSERGROUPID, INDEX_WFUSERGROUPID);
        fieldIndexMap.put( FIELD_WFUSERGROUPNAME, INDEX_WFUSERGROUPNAME);
        fieldIndexMap.put( FIELD_WFUSERID, INDEX_WFUSERID);
        fieldIndexMap.put( FIELD_WFUSERNAME, INDEX_WFUSERNAME);
    }

    private WFUserGroupDetailBase proxyWFUserGroupDetailBase = null;
    public WFUserGroupDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfusergroupdetailidDirtyFlag = false;
    private boolean wfusergroupdetailnameDirtyFlag = false;
    private boolean wfusergroupidDirtyFlag = false;
    private boolean wfusergroupnameDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfusergroupdetailid")
    private String wfusergroupdetailid;
    @Column(name="wfusergroupdetailname")
    private String wfusergroupdetailname;
    @Column(name="wfusergroupid")
    private String wfusergroupid;
    @Column(name="wfusergroupname")
    private String wfusergroupname;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;


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
     *  设置属性值[工作流用户组成员标识]
     *  @param wfusergroupdetailid
     */
    public void setWFUserGroupDetailId(String wfusergroupdetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserGroupDetailId(wfusergroupdetailid);
            return;
        }
        if(wfusergroupdetailid!=null) {
            wfusergroupdetailid = StringHelper.trimRight(wfusergroupdetailid);
            if(wfusergroupdetailid.length()==0) {
                wfusergroupdetailid = null;
            }
        }
        this.wfusergroupdetailid = wfusergroupdetailid;
        this.wfusergroupdetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户组成员标识]
     */
    public String getWFUserGroupDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserGroupDetailId();
        }
        return this.wfusergroupdetailid;
    }

    /**
     *  获取属性值[工作流用户组成员标识]是否修改
     */
    public boolean isWFUserGroupDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserGroupDetailIdDirty();
        }
        return this.wfusergroupdetailidDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户组成员标识]
     */
    public void resetWFUserGroupDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserGroupDetailId();
            return;
        }

        this.wfusergroupdetailidDirtyFlag = false;
        this.wfusergroupdetailid = null;
    }
    /**
     *  设置属性值[工作流用户名称]
     *  @param wfusergroupdetailname
     */
    public void setWFUserGroupDetailName(String wfusergroupdetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserGroupDetailName(wfusergroupdetailname);
            return;
        }
        if(wfusergroupdetailname!=null) {
            wfusergroupdetailname = StringHelper.trimRight(wfusergroupdetailname);
            if(wfusergroupdetailname.length()==0) {
                wfusergroupdetailname = null;
            }
        }
        this.wfusergroupdetailname = wfusergroupdetailname;
        this.wfusergroupdetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户名称]
     */
    public String getWFUserGroupDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserGroupDetailName();
        }
        return this.wfusergroupdetailname;
    }

    /**
     *  获取属性值[工作流用户名称]是否修改
     */
    public boolean isWFUserGroupDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserGroupDetailNameDirty();
        }
        return this.wfusergroupdetailnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户名称]
     */
    public void resetWFUserGroupDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserGroupDetailName();
            return;
        }

        this.wfusergroupdetailnameDirtyFlag = false;
        this.wfusergroupdetailname = null;
    }
    /**
     *  设置属性值[用户组]
     *  @param wfusergroupid
     */
    public void setWFUserGroupId(String wfusergroupid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserGroupId(wfusergroupid);
            return;
        }
        if(wfusergroupid!=null) {
            wfusergroupid = StringHelper.trimRight(wfusergroupid);
            if(wfusergroupid.length()==0) {
                wfusergroupid = null;
            }
        }
        this.wfusergroupid = wfusergroupid;
        this.wfusergroupidDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户组]
     */
    public String getWFUserGroupId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserGroupId();
        }
        return this.wfusergroupid;
    }

    /**
     *  获取属性值[用户组]是否修改
     */
    public boolean isWFUserGroupIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserGroupIdDirty();
        }
        return this.wfusergroupidDirtyFlag;
    }

    /**
     *  重置属性值[用户组]
     */
    public void resetWFUserGroupId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserGroupId();
            return;
        }

        this.wfusergroupidDirtyFlag = false;
        this.wfusergroupid = null;
    }
    /**
     *  设置属性值[工作流用户组]
     *  @param wfusergroupname
     */
    public void setWFUserGroupName(String wfusergroupname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserGroupName(wfusergroupname);
            return;
        }
        if(wfusergroupname!=null) {
            wfusergroupname = StringHelper.trimRight(wfusergroupname);
            if(wfusergroupname.length()==0) {
                wfusergroupname = null;
            }
        }
        this.wfusergroupname = wfusergroupname;
        this.wfusergroupnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户组]
     */
    public String getWFUserGroupName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserGroupName();
        }
        return this.wfusergroupname;
    }

    /**
     *  获取属性值[工作流用户组]是否修改
     */
    public boolean isWFUserGroupNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserGroupNameDirty();
        }
        return this.wfusergroupnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户组]
     */
    public void resetWFUserGroupName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserGroupName();
            return;
        }

        this.wfusergroupnameDirtyFlag = false;
        this.wfusergroupname = null;
    }
    /**
     *  设置属性值[用户]
     *  @param wfuserid
     */
    public void setWFUserId(String wfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserId(wfuserid);
            return;
        }
        if(wfuserid!=null) {
            wfuserid = StringHelper.trimRight(wfuserid);
            if(wfuserid.length()==0) {
                wfuserid = null;
            }
        }
        this.wfuserid = wfuserid;
        this.wfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户]
     */
    public String getWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    /**
     *  获取属性值[用户]是否修改
     */
    public boolean isWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    /**
     *  重置属性值[用户]
     */
    public void resetWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserId();
            return;
        }

        this.wfuseridDirtyFlag = false;
        this.wfuserid = null;
    }
    /**
     *  设置属性值[工作流用户]
     *  @param wfusername
     */
    public void setWFUserName(String wfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFUserName(wfusername);
            return;
        }
        if(wfusername!=null) {
            wfusername = StringHelper.trimRight(wfusername);
            if(wfusername.length()==0) {
                wfusername = null;
            }
        }
        this.wfusername = wfusername;
        this.wfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户]
     */
    public String getWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
     */
    public void resetWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFUserName();
            return;
        }

        this.wfusernameDirtyFlag = false;
        this.wfusername = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFUserGroupDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFUserGroupDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFUserGroupDetailId();
        et.resetWFUserGroupDetailName();
        et.resetWFUserGroupId();
        et.resetWFUserGroupName();
        et.resetWFUserId();
        et.resetWFUserName();
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
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFUserGroupDetailIdDirty()) {
            params.put(FIELD_WFUSERGROUPDETAILID,getWFUserGroupDetailId());
        }
        if(!bDirtyOnly || isWFUserGroupDetailNameDirty()) {
            params.put(FIELD_WFUSERGROUPDETAILNAME,getWFUserGroupDetailName());
        }
        if(!bDirtyOnly || isWFUserGroupIdDirty()) {
            params.put(FIELD_WFUSERGROUPID,getWFUserGroupId());
        }
        if(!bDirtyOnly || isWFUserGroupNameDirty()) {
            params.put(FIELD_WFUSERGROUPNAME,getWFUserGroupName());
        }
        if(!bDirtyOnly || isWFUserIdDirty()) {
            params.put(FIELD_WFUSERID,getWFUserId());
        }
        if(!bDirtyOnly || isWFUserNameDirty()) {
            params.put(FIELD_WFUSERNAME,getWFUserName());
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

        return  WFUserGroupDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFUserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFUSERGROUPDETAILID:
            return et.getWFUserGroupDetailId();
        case INDEX_WFUSERGROUPDETAILNAME:
            return et.getWFUserGroupDetailName();
        case INDEX_WFUSERGROUPID:
            return et.getWFUserGroupId();
        case INDEX_WFUSERGROUPNAME:
            return et.getWFUserGroupName();
        case INDEX_WFUSERID:
            return et.getWFUserId();
        case INDEX_WFUSERNAME:
            return et.getWFUserName();
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

        WFUserGroupDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFUserGroupDetailBase et,int index,Object obj) throws Exception {
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
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERGROUPDETAILID:
            et.setWFUserGroupDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERGROUPDETAILNAME:
            et.setWFUserGroupDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERGROUPID:
            et.setWFUserGroupId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERGROUPNAME:
            et.setWFUserGroupName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERID:
            et.setWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFUSERNAME:
            et.setWFUserName(DataObject.getStringValue(obj));
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

        return  WFUserGroupDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFUserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFUSERGROUPDETAILID:
            return et.getWFUserGroupDetailId()==null;
        case INDEX_WFUSERGROUPDETAILNAME:
            return et.getWFUserGroupDetailName()==null;
        case INDEX_WFUSERGROUPID:
            return et.getWFUserGroupId()==null;
        case INDEX_WFUSERGROUPNAME:
            return et.getWFUserGroupName()==null;
        case INDEX_WFUSERID:
            return et.getWFUserId()==null;
        case INDEX_WFUSERNAME:
            return et.getWFUserName()==null;
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
        return  WFUserGroupDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFUserGroupDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFUSERGROUPDETAILID:
            return et.isWFUserGroupDetailIdDirty();
        case INDEX_WFUSERGROUPDETAILNAME:
            return et.isWFUserGroupDetailNameDirty();
        case INDEX_WFUSERGROUPID:
            return et.isWFUserGroupIdDirty();
        case INDEX_WFUSERGROUPNAME:
            return et.isWFUserGroupNameDirty();
        case INDEX_WFUSERID:
            return et.isWFUserIdDirty();
        case INDEX_WFUSERNAME:
            return et.isWFUserNameDirty();
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
    private static  void fillJSONObject(WFUserGroupDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFUserGroupDetailId()!=null) {
            JSONObjectHelper.put(json,"wfusergroupdetailid",getJSONValue(et.getWFUserGroupDetailId()),false);
        }
        if(bIncEmpty||et.getWFUserGroupDetailName()!=null) {
            JSONObjectHelper.put(json,"wfusergroupdetailname",getJSONValue(et.getWFUserGroupDetailName()),false);
        }
        if(bIncEmpty||et.getWFUserGroupId()!=null) {
            JSONObjectHelper.put(json,"wfusergroupid",getJSONValue(et.getWFUserGroupId()),false);
        }
        if(bIncEmpty||et.getWFUserGroupName()!=null) {
            JSONObjectHelper.put(json,"wfusergroupname",getJSONValue(et.getWFUserGroupName()),false);
        }
        if(bIncEmpty||et.getWFUserId()!=null) {
            JSONObjectHelper.put(json,"wfuserid",getJSONValue(et.getWFUserId()),false);
        }
        if(bIncEmpty||et.getWFUserName()!=null) {
            JSONObjectHelper.put(json,"wfusername",getJSONValue(et.getWFUserName()),false);
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
    private static void fillXmlNode(WFUserGroupDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserGroupDetailId()!=null) {
            Object obj = et.getWFUserGroupDetailId();
            node.setAttribute("WFUSERGROUPDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserGroupDetailName()!=null) {
            Object obj = et.getWFUserGroupDetailName();
            node.setAttribute("WFUSERGROUPDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserGroupId()!=null) {
            Object obj = et.getWFUserGroupId();
            node.setAttribute("WFUSERGROUPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserGroupName()!=null) {
            Object obj = et.getWFUserGroupName();
            node.setAttribute("WFUSERGROUPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserId()!=null) {
            Object obj = et.getWFUserId();
            node.setAttribute("WFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFUserName()!=null) {
            Object obj = et.getWFUserName();
            node.setAttribute("WFUSERNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUserGroupDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFUserGroupDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFUserGroupDetailIdDirty() && (bIncEmpty||et.getWFUserGroupDetailId()!=null)) {
            dst.set(FIELD_WFUSERGROUPDETAILID,et.getWFUserGroupDetailId());
        }
        if(et.isWFUserGroupDetailNameDirty() && (bIncEmpty||et.getWFUserGroupDetailName()!=null)) {
            dst.set(FIELD_WFUSERGROUPDETAILNAME,et.getWFUserGroupDetailName());
        }
        if(et.isWFUserGroupIdDirty() && (bIncEmpty||et.getWFUserGroupId()!=null)) {
            dst.set(FIELD_WFUSERGROUPID,et.getWFUserGroupId());
        }
        if(et.isWFUserGroupNameDirty() && (bIncEmpty||et.getWFUserGroupName()!=null)) {
            dst.set(FIELD_WFUSERGROUPNAME,et.getWFUserGroupName());
        }
        if(et.isWFUserIdDirty() && (bIncEmpty||et.getWFUserId()!=null)) {
            dst.set(FIELD_WFUSERID,et.getWFUserId());
        }
        if(et.isWFUserNameDirty() && (bIncEmpty||et.getWFUserName()!=null)) {
            dst.set(FIELD_WFUSERNAME,et.getWFUserName());
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
        return  WFUserGroupDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFUserGroupDetailBase et,int index) throws Exception {
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
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFUSERGROUPDETAILID:
            et.resetWFUserGroupDetailId();
            return true;
        case INDEX_WFUSERGROUPDETAILNAME:
            et.resetWFUserGroupDetailName();
            return true;
        case INDEX_WFUSERGROUPID:
            et.resetWFUserGroupId();
            return true;
        case INDEX_WFUSERGROUPNAME:
            et.resetWFUserGroupName();
            return true;
        case INDEX_WFUSERID:
            et.resetWFUserId();
            return true;
        case INDEX_WFUSERNAME:
            et.resetWFUserName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFUserGroupLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUserGroup wfusergroup = null;
    /**
    * 获取父数据 工作流用户组
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUserGroup getWFUserGroup() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUserGroup();
        }

        if(this.getWFUserGroupId()==null)
            return null;
        synchronized(this.objWFUserGroupLock) {
            if(this.wfusergroup!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFUserGroupId(),wfusergroup.getWFUserGroupId())!=0) {
                    this.wfusergroup = null;
                }
            }


            if(this.wfusergroup==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUserGroup wfusergroup = new net.ibizsys.psrt.srv.wf.entity.WFUserGroup();
                wfusergroup.setWFUserGroupId(this.getWFUserGroupId());
                net.ibizsys.psrt.srv.wf.service.WFUserGroupService service = (net.ibizsys.psrt.srv.wf.service.WFUserGroupService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserGroupService.class,this.getSessionFactory());
                service.autoGet(wfusergroup);
                this.wfusergroup = wfusergroup;
            }
            return this.wfusergroup;
        }
    }

    private Integer objWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser wfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFUser();
        }

        if(this.getWFUserId()==null)
            return null;
        synchronized(this.objWFUserLock) {
            if(this.wfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFUserId(),wfuser.getWFUserId())!=0) {
                    this.wfuser = null;
                }
            }


            if(this.wfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser wfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                wfuser.setWFUserId(this.getWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(wfuser);
                this.wfuser = wfuser;
            }
            return this.wfuser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFUserGroupDetailBase getProxyEntity() {
        return this.proxyWFUserGroupDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserGroupDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFUserGroupDetailBase) {
            this.proxyWFUserGroupDetailBase = (WFUserGroupDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}