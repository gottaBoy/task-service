/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


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
 * 实体[MsgAccountDetail] 数据对象基类
 */
public abstract class MsgAccountDetailBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgAccountDetailBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[组消息账户_组账户]
     */
    public final static String FIELD_MAJORMSGACCOUNTID = "MAJORMSGACCOUNTID";
    /**
     * 属性[组账户]
     */
    public final static String FIELD_MAJORMSGACCOUNTNAME = "MAJORMSGACCOUNTNAME";
    /**
     * 属性[组消息账户_明细账户]
     */
    public final static String FIELD_MINORMSGACCOUNTID = "MINORMSGACCOUNTID";
    /**
     * 属性[包含账户]
     */
    public final static String FIELD_MINORMSGACCOUNTNAME = "MINORMSGACCOUNTNAME";
    /**
     * 属性[组消息账户明细标识]
     */
    public final static String FIELD_MSGACCOUNTDETAILID = "MSGACCOUNTDETAILID";
    /**
     * 属性[组消息账户明细名称]
     */
    public final static String FIELD_MSGACCOUNTDETAILNAME = "MSGACCOUNTDETAILNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_MAJORMSGACCOUNTID = 2;
    private final static int INDEX_MAJORMSGACCOUNTNAME = 3;
    private final static int INDEX_MINORMSGACCOUNTID = 4;
    private final static int INDEX_MINORMSGACCOUNTNAME = 5;
    private final static int INDEX_MSGACCOUNTDETAILID = 6;
    private final static int INDEX_MSGACCOUNTDETAILNAME = 7;
    private final static int INDEX_UPDATEDATE = 8;
    private final static int INDEX_UPDATEMAN = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_MAJORMSGACCOUNTID, INDEX_MAJORMSGACCOUNTID);
        fieldIndexMap.put( FIELD_MAJORMSGACCOUNTNAME, INDEX_MAJORMSGACCOUNTNAME);
        fieldIndexMap.put( FIELD_MINORMSGACCOUNTID, INDEX_MINORMSGACCOUNTID);
        fieldIndexMap.put( FIELD_MINORMSGACCOUNTNAME, INDEX_MINORMSGACCOUNTNAME);
        fieldIndexMap.put( FIELD_MSGACCOUNTDETAILID, INDEX_MSGACCOUNTDETAILID);
        fieldIndexMap.put( FIELD_MSGACCOUNTDETAILNAME, INDEX_MSGACCOUNTDETAILNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private MsgAccountDetailBase proxyMsgAccountDetailBase = null;
    public MsgAccountDetailBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majormsgaccountidDirtyFlag = false;
    private boolean majormsgaccountnameDirtyFlag = false;
    private boolean minormsgaccountidDirtyFlag = false;
    private boolean minormsgaccountnameDirtyFlag = false;
    private boolean msgaccountdetailidDirtyFlag = false;
    private boolean msgaccountdetailnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majormsgaccountid")
    private String majormsgaccountid;
    @Column(name="majormsgaccountname")
    private String majormsgaccountname;
    @Column(name="minormsgaccountid")
    private String minormsgaccountid;
    @Column(name="minormsgaccountname")
    private String minormsgaccountname;
    @Column(name="msgaccountdetailid")
    private String msgaccountdetailid;
    @Column(name="msgaccountdetailname")
    private String msgaccountdetailname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


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
     *  设置属性值[组消息账户_组账户]
     *  @param majormsgaccountid
     */
    public void setMajorMsgAccountId(String majormsgaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMajorMsgAccountId(majormsgaccountid);
            return;
        }
        if(majormsgaccountid!=null) {
            majormsgaccountid = StringHelper.trimRight(majormsgaccountid);
            if(majormsgaccountid.length()==0) {
                majormsgaccountid = null;
            }
        }
        this.majormsgaccountid = majormsgaccountid;
        this.majormsgaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[组消息账户_组账户]
     */
    public String getMajorMsgAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorMsgAccountId();
        }
        return this.majormsgaccountid;
    }

    /**
     *  获取属性值[组消息账户_组账户]是否修改
     */
    public boolean isMajorMsgAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMajorMsgAccountIdDirty();
        }
        return this.majormsgaccountidDirtyFlag;
    }

    /**
     *  重置属性值[组消息账户_组账户]
     */
    public void resetMajorMsgAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMajorMsgAccountId();
            return;
        }

        this.majormsgaccountidDirtyFlag = false;
        this.majormsgaccountid = null;
    }
    /**
     *  设置属性值[组账户]
     *  @param majormsgaccountname
     */
    public void setMajorMsgAccountName(String majormsgaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMajorMsgAccountName(majormsgaccountname);
            return;
        }
        if(majormsgaccountname!=null) {
            majormsgaccountname = StringHelper.trimRight(majormsgaccountname);
            if(majormsgaccountname.length()==0) {
                majormsgaccountname = null;
            }
        }
        this.majormsgaccountname = majormsgaccountname;
        this.majormsgaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[组账户]
     */
    public String getMajorMsgAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorMsgAccountName();
        }
        return this.majormsgaccountname;
    }

    /**
     *  获取属性值[组账户]是否修改
     */
    public boolean isMajorMsgAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMajorMsgAccountNameDirty();
        }
        return this.majormsgaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[组账户]
     */
    public void resetMajorMsgAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMajorMsgAccountName();
            return;
        }

        this.majormsgaccountnameDirtyFlag = false;
        this.majormsgaccountname = null;
    }
    /**
     *  设置属性值[组消息账户_明细账户]
     *  @param minormsgaccountid
     */
    public void setMinorMsgAccountId(String minormsgaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorMsgAccountId(minormsgaccountid);
            return;
        }
        if(minormsgaccountid!=null) {
            minormsgaccountid = StringHelper.trimRight(minormsgaccountid);
            if(minormsgaccountid.length()==0) {
                minormsgaccountid = null;
            }
        }
        this.minormsgaccountid = minormsgaccountid;
        this.minormsgaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[组消息账户_明细账户]
     */
    public String getMinorMsgAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorMsgAccountId();
        }
        return this.minormsgaccountid;
    }

    /**
     *  获取属性值[组消息账户_明细账户]是否修改
     */
    public boolean isMinorMsgAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorMsgAccountIdDirty();
        }
        return this.minormsgaccountidDirtyFlag;
    }

    /**
     *  重置属性值[组消息账户_明细账户]
     */
    public void resetMinorMsgAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorMsgAccountId();
            return;
        }

        this.minormsgaccountidDirtyFlag = false;
        this.minormsgaccountid = null;
    }
    /**
     *  设置属性值[包含账户]
     *  @param minormsgaccountname
     */
    public void setMinorMsgAccountName(String minormsgaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMinorMsgAccountName(minormsgaccountname);
            return;
        }
        if(minormsgaccountname!=null) {
            minormsgaccountname = StringHelper.trimRight(minormsgaccountname);
            if(minormsgaccountname.length()==0) {
                minormsgaccountname = null;
            }
        }
        this.minormsgaccountname = minormsgaccountname;
        this.minormsgaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[包含账户]
     */
    public String getMinorMsgAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorMsgAccountName();
        }
        return this.minormsgaccountname;
    }

    /**
     *  获取属性值[包含账户]是否修改
     */
    public boolean isMinorMsgAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMinorMsgAccountNameDirty();
        }
        return this.minormsgaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[包含账户]
     */
    public void resetMinorMsgAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMinorMsgAccountName();
            return;
        }

        this.minormsgaccountnameDirtyFlag = false;
        this.minormsgaccountname = null;
    }
    /**
     *  设置属性值[组消息账户明细标识]
     *  @param msgaccountdetailid
     */
    public void setMsgAccountDetailId(String msgaccountdetailid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgAccountDetailId(msgaccountdetailid);
            return;
        }
        if(msgaccountdetailid!=null) {
            msgaccountdetailid = StringHelper.trimRight(msgaccountdetailid);
            if(msgaccountdetailid.length()==0) {
                msgaccountdetailid = null;
            }
        }
        this.msgaccountdetailid = msgaccountdetailid;
        this.msgaccountdetailidDirtyFlag  = true;
    }

    /**
     *  获取属性值[组消息账户明细标识]
     */
    public String getMsgAccountDetailId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgAccountDetailId();
        }
        return this.msgaccountdetailid;
    }

    /**
     *  获取属性值[组消息账户明细标识]是否修改
     */
    public boolean isMsgAccountDetailIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgAccountDetailIdDirty();
        }
        return this.msgaccountdetailidDirtyFlag;
    }

    /**
     *  重置属性值[组消息账户明细标识]
     */
    public void resetMsgAccountDetailId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgAccountDetailId();
            return;
        }

        this.msgaccountdetailidDirtyFlag = false;
        this.msgaccountdetailid = null;
    }
    /**
     *  设置属性值[组消息账户明细名称]
     *  @param msgaccountdetailname
     */
    public void setMsgAccountDetailName(String msgaccountdetailname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgAccountDetailName(msgaccountdetailname);
            return;
        }
        if(msgaccountdetailname!=null) {
            msgaccountdetailname = StringHelper.trimRight(msgaccountdetailname);
            if(msgaccountdetailname.length()==0) {
                msgaccountdetailname = null;
            }
        }
        this.msgaccountdetailname = msgaccountdetailname;
        this.msgaccountdetailnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[组消息账户明细名称]
     */
    public String getMsgAccountDetailName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgAccountDetailName();
        }
        return this.msgaccountdetailname;
    }

    /**
     *  获取属性值[组消息账户明细名称]是否修改
     */
    public boolean isMsgAccountDetailNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgAccountDetailNameDirty();
        }
        return this.msgaccountdetailnameDirtyFlag;
    }

    /**
     *  重置属性值[组消息账户明细名称]
     */
    public void resetMsgAccountDetailName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgAccountDetailName();
            return;
        }

        this.msgaccountdetailnameDirtyFlag = false;
        this.msgaccountdetailname = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        MsgAccountDetailBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(MsgAccountDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMajorMsgAccountId();
        et.resetMajorMsgAccountName();
        et.resetMinorMsgAccountId();
        et.resetMinorMsgAccountName();
        et.resetMsgAccountDetailId();
        et.resetMsgAccountDetailName();
        et.resetUpdateDate();
        et.resetUpdateMan();
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
        if(!bDirtyOnly || isMajorMsgAccountIdDirty()) {
            params.put(FIELD_MAJORMSGACCOUNTID,getMajorMsgAccountId());
        }
        if(!bDirtyOnly || isMajorMsgAccountNameDirty()) {
            params.put(FIELD_MAJORMSGACCOUNTNAME,getMajorMsgAccountName());
        }
        if(!bDirtyOnly || isMinorMsgAccountIdDirty()) {
            params.put(FIELD_MINORMSGACCOUNTID,getMinorMsgAccountId());
        }
        if(!bDirtyOnly || isMinorMsgAccountNameDirty()) {
            params.put(FIELD_MINORMSGACCOUNTNAME,getMinorMsgAccountName());
        }
        if(!bDirtyOnly || isMsgAccountDetailIdDirty()) {
            params.put(FIELD_MSGACCOUNTDETAILID,getMsgAccountDetailId());
        }
        if(!bDirtyOnly || isMsgAccountDetailNameDirty()) {
            params.put(FIELD_MSGACCOUNTDETAILNAME,getMsgAccountDetailName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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

        return  MsgAccountDetailBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(MsgAccountDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_MAJORMSGACCOUNTID:
            return et.getMajorMsgAccountId();
        case INDEX_MAJORMSGACCOUNTNAME:
            return et.getMajorMsgAccountName();
        case INDEX_MINORMSGACCOUNTID:
            return et.getMinorMsgAccountId();
        case INDEX_MINORMSGACCOUNTNAME:
            return et.getMinorMsgAccountName();
        case INDEX_MSGACCOUNTDETAILID:
            return et.getMsgAccountDetailId();
        case INDEX_MSGACCOUNTDETAILNAME:
            return et.getMsgAccountDetailName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
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

        MsgAccountDetailBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(MsgAccountDetailBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_MAJORMSGACCOUNTID:
            et.setMajorMsgAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MAJORMSGACCOUNTNAME:
            et.setMajorMsgAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORMSGACCOUNTID:
            et.setMinorMsgAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MINORMSGACCOUNTNAME:
            et.setMinorMsgAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGACCOUNTDETAILID:
            et.setMsgAccountDetailId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGACCOUNTDETAILNAME:
            et.setMsgAccountDetailName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
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

        return  MsgAccountDetailBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(MsgAccountDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_MAJORMSGACCOUNTID:
            return et.getMajorMsgAccountId()==null;
        case INDEX_MAJORMSGACCOUNTNAME:
            return et.getMajorMsgAccountName()==null;
        case INDEX_MINORMSGACCOUNTID:
            return et.getMinorMsgAccountId()==null;
        case INDEX_MINORMSGACCOUNTNAME:
            return et.getMinorMsgAccountName()==null;
        case INDEX_MSGACCOUNTDETAILID:
            return et.getMsgAccountDetailId()==null;
        case INDEX_MSGACCOUNTDETAILNAME:
            return et.getMsgAccountDetailName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
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
        return  MsgAccountDetailBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(MsgAccountDetailBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_MAJORMSGACCOUNTID:
            return et.isMajorMsgAccountIdDirty();
        case INDEX_MAJORMSGACCOUNTNAME:
            return et.isMajorMsgAccountNameDirty();
        case INDEX_MINORMSGACCOUNTID:
            return et.isMinorMsgAccountIdDirty();
        case INDEX_MINORMSGACCOUNTNAME:
            return et.isMinorMsgAccountNameDirty();
        case INDEX_MSGACCOUNTDETAILID:
            return et.isMsgAccountDetailIdDirty();
        case INDEX_MSGACCOUNTDETAILNAME:
            return et.isMsgAccountDetailNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
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
    private static  void fillJSONObject(MsgAccountDetailBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getMajorMsgAccountId()!=null) {
            JSONObjectHelper.put(json,"majormsgaccountid",getJSONValue(et.getMajorMsgAccountId()),false);
        }
        if(bIncEmpty||et.getMajorMsgAccountName()!=null) {
            JSONObjectHelper.put(json,"majormsgaccountname",getJSONValue(et.getMajorMsgAccountName()),false);
        }
        if(bIncEmpty||et.getMinorMsgAccountId()!=null) {
            JSONObjectHelper.put(json,"minormsgaccountid",getJSONValue(et.getMinorMsgAccountId()),false);
        }
        if(bIncEmpty||et.getMinorMsgAccountName()!=null) {
            JSONObjectHelper.put(json,"minormsgaccountname",getJSONValue(et.getMinorMsgAccountName()),false);
        }
        if(bIncEmpty||et.getMsgAccountDetailId()!=null) {
            JSONObjectHelper.put(json,"msgaccountdetailid",getJSONValue(et.getMsgAccountDetailId()),false);
        }
        if(bIncEmpty||et.getMsgAccountDetailName()!=null) {
            JSONObjectHelper.put(json,"msgaccountdetailname",getJSONValue(et.getMsgAccountDetailName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
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
    private static void fillXmlNode(MsgAccountDetailBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMajorMsgAccountId()!=null) {
            Object obj = et.getMajorMsgAccountId();
            node.setAttribute("MAJORMSGACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMajorMsgAccountName()!=null) {
            Object obj = et.getMajorMsgAccountName();
            node.setAttribute("MAJORMSGACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorMsgAccountId()!=null) {
            Object obj = et.getMinorMsgAccountId();
            node.setAttribute("MINORMSGACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMinorMsgAccountName()!=null) {
            Object obj = et.getMinorMsgAccountName();
            node.setAttribute("MINORMSGACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgAccountDetailId()!=null) {
            Object obj = et.getMsgAccountDetailId();
            node.setAttribute("MSGACCOUNTDETAILID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgAccountDetailName()!=null) {
            Object obj = et.getMsgAccountDetailName();
            node.setAttribute("MSGACCOUNTDETAILNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgAccountDetailBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(MsgAccountDetailBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isMajorMsgAccountIdDirty() && (bIncEmpty||et.getMajorMsgAccountId()!=null)) {
            dst.set(FIELD_MAJORMSGACCOUNTID,et.getMajorMsgAccountId());
        }
        if(et.isMajorMsgAccountNameDirty() && (bIncEmpty||et.getMajorMsgAccountName()!=null)) {
            dst.set(FIELD_MAJORMSGACCOUNTNAME,et.getMajorMsgAccountName());
        }
        if(et.isMinorMsgAccountIdDirty() && (bIncEmpty||et.getMinorMsgAccountId()!=null)) {
            dst.set(FIELD_MINORMSGACCOUNTID,et.getMinorMsgAccountId());
        }
        if(et.isMinorMsgAccountNameDirty() && (bIncEmpty||et.getMinorMsgAccountName()!=null)) {
            dst.set(FIELD_MINORMSGACCOUNTNAME,et.getMinorMsgAccountName());
        }
        if(et.isMsgAccountDetailIdDirty() && (bIncEmpty||et.getMsgAccountDetailId()!=null)) {
            dst.set(FIELD_MSGACCOUNTDETAILID,et.getMsgAccountDetailId());
        }
        if(et.isMsgAccountDetailNameDirty() && (bIncEmpty||et.getMsgAccountDetailName()!=null)) {
            dst.set(FIELD_MSGACCOUNTDETAILNAME,et.getMsgAccountDetailName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
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
        return  MsgAccountDetailBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(MsgAccountDetailBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_MAJORMSGACCOUNTID:
            et.resetMajorMsgAccountId();
            return true;
        case INDEX_MAJORMSGACCOUNTNAME:
            et.resetMajorMsgAccountName();
            return true;
        case INDEX_MINORMSGACCOUNTID:
            et.resetMinorMsgAccountId();
            return true;
        case INDEX_MINORMSGACCOUNTNAME:
            et.resetMinorMsgAccountName();
            return true;
        case INDEX_MSGACCOUNTDETAILID:
            et.resetMsgAccountDetailId();
            return true;
        case INDEX_MSGACCOUNTDETAILNAME:
            et.resetMsgAccountDetailName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objMajorMsgAccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.MsgAccount majormsgaccount = null;
    /**
    * 获取父数据 消息账户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.MsgAccount getMajorMsgAccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMajorMsgAccount();
        }

        if(this.getMajorMsgAccountId()==null)
            return null;
        synchronized(this.objMajorMsgAccountLock) {
            if(this.majormsgaccount!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getMajorMsgAccountId(),majormsgaccount.getMsgAccountId())!=0) {
                    this.majormsgaccount = null;
                }
            }


            if(this.majormsgaccount==null) {
                net.ibizsys.psrt.srv.common.entity.MsgAccount majormsgaccount = new net.ibizsys.psrt.srv.common.entity.MsgAccount();
                majormsgaccount.setMsgAccountId(this.getMajorMsgAccountId());
                net.ibizsys.psrt.srv.common.service.MsgAccountService service = (net.ibizsys.psrt.srv.common.service.MsgAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgAccountService.class,this.getSessionFactory());
                service.autoGet(majormsgaccount);
                this.majormsgaccount = majormsgaccount;
            }
            return this.majormsgaccount;
        }
    }

    private Integer objMinorMsgAccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.MsgAccount minormsgaccount = null;
    /**
    * 获取父数据 消息账户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.MsgAccount getMinorMsgAccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMinorMsgAccount();
        }

        if(this.getMinorMsgAccountId()==null)
            return null;
        synchronized(this.objMinorMsgAccountLock) {
            if(this.minormsgaccount!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getMinorMsgAccountId(),minormsgaccount.getMsgAccountId())!=0) {
                    this.minormsgaccount = null;
                }
            }


            if(this.minormsgaccount==null) {
                net.ibizsys.psrt.srv.common.entity.MsgAccount minormsgaccount = new net.ibizsys.psrt.srv.common.entity.MsgAccount();
                minormsgaccount.setMsgAccountId(this.getMinorMsgAccountId());
                net.ibizsys.psrt.srv.common.service.MsgAccountService service = (net.ibizsys.psrt.srv.common.service.MsgAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgAccountService.class,this.getSessionFactory());
                service.autoGet(minormsgaccount);
                this.minormsgaccount = minormsgaccount;
            }
            return this.minormsgaccount;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private MsgAccountDetailBase getProxyEntity() {
        return this.proxyMsgAccountDetailBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgAccountDetailBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof MsgAccountDetailBase) {
            this.proxyMsgAccountDetailBase = (MsgAccountDetailBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}