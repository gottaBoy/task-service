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
 * 实体[WFAppSetting] 数据对象基类
 */
public abstract class WFAppSettingBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFAppSettingBase.class);
    /**
     * 属性[APPLICATIONID]
     */
    public final static String FIELD_APPLICATIONID = "APPLICATIONID";
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
     * 属性[催办消息模板]
     */
    public final static String FIELD_REMINDMSGTEMPLID = "REMINDMSGTEMPID";
    /**
     * 属性[催办消息模板]
     */
    public final static String FIELD_REMINDMSGTEMPLNAME = "REMINDMSGTEMPLNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[工作流应用设定标识]
     */
    public final static String FIELD_WFAPPSETTINGID = "WFAPPSETTINGID";
    /**
     * 属性[系统工作流设定]
     */
    public final static String FIELD_WFAPPSETTINGNAME = "WFAPPSETTINGNAME";

    private final static int INDEX_APPLICATIONID = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_MEMO = 3;
    private final static int INDEX_REMINDMSGTEMPLID = 4;
    private final static int INDEX_REMINDMSGTEMPLNAME = 5;
    private final static int INDEX_UPDATEDATE = 6;
    private final static int INDEX_UPDATEMAN = 7;
    private final static int INDEX_WFAPPSETTINGID = 8;
    private final static int INDEX_WFAPPSETTINGNAME = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_APPLICATIONID, INDEX_APPLICATIONID);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_REMINDMSGTEMPLID, INDEX_REMINDMSGTEMPLID);
        fieldIndexMap.put( FIELD_REMINDMSGTEMPLNAME, INDEX_REMINDMSGTEMPLNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFAPPSETTINGID, INDEX_WFAPPSETTINGID);
        fieldIndexMap.put( FIELD_WFAPPSETTINGNAME, INDEX_WFAPPSETTINGNAME);
    }

    private WFAppSettingBase proxyWFAppSettingBase = null;
    public WFAppSettingBase() {
        super();
    }
    private boolean applicationidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean remindmsgtemplidDirtyFlag = false;
    private boolean remindmsgtemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfappsettingidDirtyFlag = false;
    private boolean wfappsettingnameDirtyFlag = false;

    @Column(name="applicationid")
    private String applicationid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="remindmsgtemplid")
    private String remindmsgtemplid;
    @Column(name="remindmsgtemplname")
    private String remindmsgtemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfappsettingid")
    private String wfappsettingid;
    @Column(name="wfappsettingname")
    private String wfappsettingname;


    /**
     *  设置属性值[APPLICATIONID]
     *  @param applicationid
     */
    public void setApplicationId(String applicationid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setApplicationId(applicationid);
            return;
        }
        if(applicationid!=null) {
            applicationid = StringHelper.trimRight(applicationid);
            if(applicationid.length()==0) {
                applicationid = null;
            }
        }
        this.applicationid = applicationid;
        this.applicationidDirtyFlag  = true;
    }

    /**
     *  获取属性值[APPLICATIONID]
     */
    public String getApplicationId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getApplicationId();
        }
        return this.applicationid;
    }

    /**
     *  获取属性值[APPLICATIONID]是否修改
     */
    public boolean isApplicationIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isApplicationIdDirty();
        }
        return this.applicationidDirtyFlag;
    }

    /**
     *  重置属性值[APPLICATIONID]
     */
    public void resetApplicationId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetApplicationId();
            return;
        }

        this.applicationidDirtyFlag = false;
        this.applicationid = null;
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
     *  设置属性值[催办消息模板]
     *  @param remindmsgtemplid
     */
    public void setRemindMsgTemplId(String remindmsgtemplid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRemindMsgTemplId(remindmsgtemplid);
            return;
        }
        if(remindmsgtemplid!=null) {
            remindmsgtemplid = StringHelper.trimRight(remindmsgtemplid);
            if(remindmsgtemplid.length()==0) {
                remindmsgtemplid = null;
            }
        }
        this.remindmsgtemplid = remindmsgtemplid;
        this.remindmsgtemplidDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办消息模板]
     */
    public String getRemindMsgTemplId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTemplId();
        }
        return this.remindmsgtemplid;
    }

    /**
     *  获取属性值[催办消息模板]是否修改
     */
    public boolean isRemindMsgTemplIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRemindMsgTemplIdDirty();
        }
        return this.remindmsgtemplidDirtyFlag;
    }

    /**
     *  重置属性值[催办消息模板]
     */
    public void resetRemindMsgTemplId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRemindMsgTemplId();
            return;
        }

        this.remindmsgtemplidDirtyFlag = false;
        this.remindmsgtemplid = null;
    }
    /**
     *  设置属性值[催办消息模板]
     *  @param remindmsgtemplname
     */
    public void setRemindMsgTemplName(String remindmsgtemplname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRemindMsgTemplName(remindmsgtemplname);
            return;
        }
        if(remindmsgtemplname!=null) {
            remindmsgtemplname = StringHelper.trimRight(remindmsgtemplname);
            if(remindmsgtemplname.length()==0) {
                remindmsgtemplname = null;
            }
        }
        this.remindmsgtemplname = remindmsgtemplname;
        this.remindmsgtemplnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[催办消息模板]
     */
    public String getRemindMsgTemplName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTemplName();
        }
        return this.remindmsgtemplname;
    }

    /**
     *  获取属性值[催办消息模板]是否修改
     */
    public boolean isRemindMsgTemplNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRemindMsgTemplNameDirty();
        }
        return this.remindmsgtemplnameDirtyFlag;
    }

    /**
     *  重置属性值[催办消息模板]
     */
    public void resetRemindMsgTemplName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRemindMsgTemplName();
            return;
        }

        this.remindmsgtemplnameDirtyFlag = false;
        this.remindmsgtemplname = null;
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
     *  设置属性值[工作流应用设定标识]
     *  @param wfappsettingid
     */
    public void setWFAppSettingId(String wfappsettingid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFAppSettingId(wfappsettingid);
            return;
        }
        if(wfappsettingid!=null) {
            wfappsettingid = StringHelper.trimRight(wfappsettingid);
            if(wfappsettingid.length()==0) {
                wfappsettingid = null;
            }
        }
        this.wfappsettingid = wfappsettingid;
        this.wfappsettingidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流应用设定标识]
     */
    public String getWFAppSettingId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFAppSettingId();
        }
        return this.wfappsettingid;
    }

    /**
     *  获取属性值[工作流应用设定标识]是否修改
     */
    public boolean isWFAppSettingIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFAppSettingIdDirty();
        }
        return this.wfappsettingidDirtyFlag;
    }

    /**
     *  重置属性值[工作流应用设定标识]
     */
    public void resetWFAppSettingId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFAppSettingId();
            return;
        }

        this.wfappsettingidDirtyFlag = false;
        this.wfappsettingid = null;
    }
    /**
     *  设置属性值[系统工作流设定]
     *  @param wfappsettingname
     */
    public void setWFAppSettingName(String wfappsettingname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFAppSettingName(wfappsettingname);
            return;
        }
        if(wfappsettingname!=null) {
            wfappsettingname = StringHelper.trimRight(wfappsettingname);
            if(wfappsettingname.length()==0) {
                wfappsettingname = null;
            }
        }
        this.wfappsettingname = wfappsettingname;
        this.wfappsettingnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统工作流设定]
     */
    public String getWFAppSettingName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFAppSettingName();
        }
        return this.wfappsettingname;
    }

    /**
     *  获取属性值[系统工作流设定]是否修改
     */
    public boolean isWFAppSettingNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFAppSettingNameDirty();
        }
        return this.wfappsettingnameDirtyFlag;
    }

    /**
     *  重置属性值[系统工作流设定]
     */
    public void resetWFAppSettingName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFAppSettingName();
            return;
        }

        this.wfappsettingnameDirtyFlag = false;
        this.wfappsettingname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFAppSettingBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFAppSettingBase et) {
        et.resetApplicationId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetRemindMsgTemplId();
        et.resetRemindMsgTemplName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFAppSettingId();
        et.resetWFAppSettingName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isApplicationIdDirty()) {
            params.put(FIELD_APPLICATIONID,getApplicationId());
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
        if(!bDirtyOnly || isRemindMsgTemplIdDirty()) {
            params.put(FIELD_REMINDMSGTEMPLID,getRemindMsgTemplId());
        }
        if(!bDirtyOnly || isRemindMsgTemplNameDirty()) {
            params.put(FIELD_REMINDMSGTEMPLNAME,getRemindMsgTemplName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFAppSettingIdDirty()) {
            params.put(FIELD_WFAPPSETTINGID,getWFAppSettingId());
        }
        if(!bDirtyOnly || isWFAppSettingNameDirty()) {
            params.put(FIELD_WFAPPSETTINGNAME,getWFAppSettingName());
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

        return  WFAppSettingBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFAppSettingBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPLICATIONID:
            return et.getApplicationId();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_REMINDMSGTEMPLID:
            return et.getRemindMsgTemplId();
        case INDEX_REMINDMSGTEMPLNAME:
            return et.getRemindMsgTemplName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFAPPSETTINGID:
            return et.getWFAppSettingId();
        case INDEX_WFAPPSETTINGNAME:
            return et.getWFAppSettingName();
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

        WFAppSettingBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFAppSettingBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_APPLICATIONID:
            et.setApplicationId(DataObject.getStringValue(obj));
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
        case INDEX_REMINDMSGTEMPLID:
            et.setRemindMsgTemplId(DataObject.getStringValue(obj));
            return ;
        case INDEX_REMINDMSGTEMPLNAME:
            et.setRemindMsgTemplName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFAPPSETTINGID:
            et.setWFAppSettingId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFAPPSETTINGNAME:
            et.setWFAppSettingName(DataObject.getStringValue(obj));
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

        return  WFAppSettingBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFAppSettingBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPLICATIONID:
            return et.getApplicationId()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_REMINDMSGTEMPLID:
            return et.getRemindMsgTemplId()==null;
        case INDEX_REMINDMSGTEMPLNAME:
            return et.getRemindMsgTemplName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFAPPSETTINGID:
            return et.getWFAppSettingId()==null;
        case INDEX_WFAPPSETTINGNAME:
            return et.getWFAppSettingName()==null;
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
        return  WFAppSettingBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFAppSettingBase et,int index) throws Exception {

        switch(index) {
        case INDEX_APPLICATIONID:
            return et.isApplicationIdDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_REMINDMSGTEMPLID:
            return et.isRemindMsgTemplIdDirty();
        case INDEX_REMINDMSGTEMPLNAME:
            return et.isRemindMsgTemplNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFAPPSETTINGID:
            return et.isWFAppSettingIdDirty();
        case INDEX_WFAPPSETTINGNAME:
            return et.isWFAppSettingNameDirty();
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
    private static  void fillJSONObject(WFAppSettingBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getApplicationId()!=null) {
            JSONObjectHelper.put(json,"applicationid",getJSONValue(et.getApplicationId()),false);
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
        if(bIncEmpty||et.getRemindMsgTemplId()!=null) {
            JSONObjectHelper.put(json,"remindmsgtempid",getJSONValue(et.getRemindMsgTemplId()),false);
        }
        if(bIncEmpty||et.getRemindMsgTemplName()!=null) {
            JSONObjectHelper.put(json,"remindmsgtemplname",getJSONValue(et.getRemindMsgTemplName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFAppSettingId()!=null) {
            JSONObjectHelper.put(json,"wfappsettingid",getJSONValue(et.getWFAppSettingId()),false);
        }
        if(bIncEmpty||et.getWFAppSettingName()!=null) {
            JSONObjectHelper.put(json,"wfappsettingname",getJSONValue(et.getWFAppSettingName()),false);
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
    private static void fillXmlNode(WFAppSettingBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getApplicationId()!=null) {
            Object obj = et.getApplicationId();
            node.setAttribute("APPLICATIONID",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getRemindMsgTemplId()!=null) {
            Object obj = et.getRemindMsgTemplId();
            node.setAttribute("REMINDMSGTEMPLID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRemindMsgTemplName()!=null) {
            Object obj = et.getRemindMsgTemplName();
            node.setAttribute("REMINDMSGTEMPLNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFAppSettingId()!=null) {
            Object obj = et.getWFAppSettingId();
            node.setAttribute("WFAPPSETTINGID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFAppSettingName()!=null) {
            Object obj = et.getWFAppSettingName();
            node.setAttribute("WFAPPSETTINGNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFAppSettingBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFAppSettingBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isApplicationIdDirty() && (bIncEmpty||et.getApplicationId()!=null)) {
            dst.set(FIELD_APPLICATIONID,et.getApplicationId());
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
        if(et.isRemindMsgTemplIdDirty() && (bIncEmpty||et.getRemindMsgTemplId()!=null)) {
            dst.set(FIELD_REMINDMSGTEMPLID,et.getRemindMsgTemplId());
        }
        if(et.isRemindMsgTemplNameDirty() && (bIncEmpty||et.getRemindMsgTemplName()!=null)) {
            dst.set(FIELD_REMINDMSGTEMPLNAME,et.getRemindMsgTemplName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFAppSettingIdDirty() && (bIncEmpty||et.getWFAppSettingId()!=null)) {
            dst.set(FIELD_WFAPPSETTINGID,et.getWFAppSettingId());
        }
        if(et.isWFAppSettingNameDirty() && (bIncEmpty||et.getWFAppSettingName()!=null)) {
            dst.set(FIELD_WFAPPSETTINGNAME,et.getWFAppSettingName());
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
        return  WFAppSettingBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFAppSettingBase et,int index) throws Exception {
        switch(index) {
        case INDEX_APPLICATIONID:
            et.resetApplicationId();
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
        case INDEX_REMINDMSGTEMPLID:
            et.resetRemindMsgTemplId();
            return true;
        case INDEX_REMINDMSGTEMPLNAME:
            et.resetRemindMsgTemplName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFAPPSETTINGID:
            et.resetWFAppSettingId();
            return true;
        case INDEX_WFAPPSETTINGNAME:
            et.resetWFAppSettingName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objRemindMsgTemplLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.MsgTemplate remindmsgtempl = null;
    /**
    * 获取父数据 消息模板
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.MsgTemplate getRemindMsgTempl() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemindMsgTempl();
        }

        if(this.getRemindMsgTemplId()==null)
            return null;
        synchronized(this.objRemindMsgTemplLock) {
            if(this.remindmsgtempl!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getRemindMsgTemplId(),remindmsgtempl.getMsgTemplateId())!=0) {
                    this.remindmsgtempl = null;
                }
            }


            if(this.remindmsgtempl==null) {
                net.ibizsys.psrt.srv.common.entity.MsgTemplate remindmsgtempl = new net.ibizsys.psrt.srv.common.entity.MsgTemplate();
                remindmsgtempl.setMsgTemplateId(this.getRemindMsgTemplId());
                net.ibizsys.psrt.srv.common.service.MsgTemplateService service = (net.ibizsys.psrt.srv.common.service.MsgTemplateService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgTemplateService.class,this.getSessionFactory());
                service.autoGet(remindmsgtempl);
                this.remindmsgtempl = remindmsgtempl;
            }
            return this.remindmsgtempl;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFAppSettingBase getProxyEntity() {
        return this.proxyWFAppSettingBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFAppSettingBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFAppSettingBase) {
            this.proxyWFAppSettingBase = (WFAppSettingBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFAppSettingService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}