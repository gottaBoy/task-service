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
 * 实体[WFDynamicUser] 数据对象基类
 */
public abstract class WFDynamicUserBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFDynamicUserBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[处理变量]
     */
    public final static String FIELD_PARAMS = "PARAMS";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[用户处理对象]
     */
    public final static String FIELD_USEROBJECT = "USEROBJECT";
    /**
     * 属性[用户类型]
     */
    public final static String FIELD_USERTYPE = "USERTYPE";
    /**
     * 属性[工作流动态用户标识]
     */
    public final static String FIELD_WFDYNAMICUSERID = "WFDYNAMICUSERID";
    /**
     * 属性[工作流动态用户名称]
     */
    public final static String FIELD_WFDYNAMICUSERNAME = "WFDYNAMICUSERNAME";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_PARAMS = 2;
    private final static int INDEX_UPDATEDATE = 3;
    private final static int INDEX_UPDATEMAN = 4;
    private final static int INDEX_USEROBJECT = 5;
    private final static int INDEX_USERTYPE = 6;
    private final static int INDEX_WFDYNAMICUSERID = 7;
    private final static int INDEX_WFDYNAMICUSERNAME = 8;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_PARAMS, INDEX_PARAMS);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USEROBJECT, INDEX_USEROBJECT);
        fieldIndexMap.put( FIELD_USERTYPE, INDEX_USERTYPE);
        fieldIndexMap.put( FIELD_WFDYNAMICUSERID, INDEX_WFDYNAMICUSERID);
        fieldIndexMap.put( FIELD_WFDYNAMICUSERNAME, INDEX_WFDYNAMICUSERNAME);
    }

    private WFDynamicUserBase proxyWFDynamicUserBase = null;
    public WFDynamicUserBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userobjectDirtyFlag = false;
    private boolean usertypeDirtyFlag = false;
    private boolean wfdynamicuseridDirtyFlag = false;
    private boolean wfdynamicusernameDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="params")
    private String params;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userobject")
    private String userobject;
    @Column(name="usertype")
    private String usertype;
    @Column(name="wfdynamicuserid")
    private String wfdynamicuserid;
    @Column(name="wfdynamicusername")
    private String wfdynamicusername;


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
     *  设置属性值[处理变量]
     *  @param params
     */
    public void setParams(String params) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParams(params);
            return;
        }
        if(params!=null) {
            params = StringHelper.trimRight(params);
            if(params.length()==0) {
                params = null;
            }
        }
        this.params = params;
        this.paramsDirtyFlag  = true;
    }

    /**
     *  获取属性值[处理变量]
     */
    public String getParams() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParams();
        }
        return this.params;
    }

    /**
     *  获取属性值[处理变量]是否修改
     */
    public boolean isParamsDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParamsDirty();
        }
        return this.paramsDirtyFlag;
    }

    /**
     *  重置属性值[处理变量]
     */
    public void resetParams() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParams();
            return;
        }

        this.paramsDirtyFlag = false;
        this.params = null;
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
     *  设置属性值[用户处理对象]
     *  @param userobject
     */
    public void setUserObject(String userobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserObject(userobject);
            return;
        }
        if(userobject!=null) {
            userobject = StringHelper.trimRight(userobject);
            if(userobject.length()==0) {
                userobject = null;
            }
        }
        this.userobject = userobject;
        this.userobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户处理对象]
     */
    public String getUserObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserObject();
        }
        return this.userobject;
    }

    /**
     *  获取属性值[用户处理对象]是否修改
     */
    public boolean isUserObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserObjectDirty();
        }
        return this.userobjectDirtyFlag;
    }

    /**
     *  重置属性值[用户处理对象]
     */
    public void resetUserObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserObject();
            return;
        }

        this.userobjectDirtyFlag = false;
        this.userobject = null;
    }
    /**
     *  设置属性值[用户类型]
     *  @param usertype
     */
    public void setUserType(String usertype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserType(usertype);
            return;
        }
        if(usertype!=null) {
            usertype = StringHelper.trimRight(usertype);
            if(usertype.length()==0) {
                usertype = null;
            }
        }
        this.usertype = usertype;
        this.usertypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户类型]
     */
    public String getUserType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserType();
        }
        return this.usertype;
    }

    /**
     *  获取属性值[用户类型]是否修改
     */
    public boolean isUserTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserTypeDirty();
        }
        return this.usertypeDirtyFlag;
    }

    /**
     *  重置属性值[用户类型]
     */
    public void resetUserType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserType();
            return;
        }

        this.usertypeDirtyFlag = false;
        this.usertype = null;
    }
    /**
     *  设置属性值[工作流动态用户标识]
     *  @param wfdynamicuserid
     */
    public void setWFDynamicUserId(String wfdynamicuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFDynamicUserId(wfdynamicuserid);
            return;
        }
        if(wfdynamicuserid!=null) {
            wfdynamicuserid = StringHelper.trimRight(wfdynamicuserid);
            if(wfdynamicuserid.length()==0) {
                wfdynamicuserid = null;
            }
        }
        this.wfdynamicuserid = wfdynamicuserid;
        this.wfdynamicuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流动态用户标识]
     */
    public String getWFDynamicUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFDynamicUserId();
        }
        return this.wfdynamicuserid;
    }

    /**
     *  获取属性值[工作流动态用户标识]是否修改
     */
    public boolean isWFDynamicUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFDynamicUserIdDirty();
        }
        return this.wfdynamicuseridDirtyFlag;
    }

    /**
     *  重置属性值[工作流动态用户标识]
     */
    public void resetWFDynamicUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFDynamicUserId();
            return;
        }

        this.wfdynamicuseridDirtyFlag = false;
        this.wfdynamicuserid = null;
    }
    /**
     *  设置属性值[工作流动态用户名称]
     *  @param wfdynamicusername
     */
    public void setWFDynamicUserName(String wfdynamicusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFDynamicUserName(wfdynamicusername);
            return;
        }
        if(wfdynamicusername!=null) {
            wfdynamicusername = StringHelper.trimRight(wfdynamicusername);
            if(wfdynamicusername.length()==0) {
                wfdynamicusername = null;
            }
        }
        this.wfdynamicusername = wfdynamicusername;
        this.wfdynamicusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流动态用户名称]
     */
    public String getWFDynamicUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFDynamicUserName();
        }
        return this.wfdynamicusername;
    }

    /**
     *  获取属性值[工作流动态用户名称]是否修改
     */
    public boolean isWFDynamicUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFDynamicUserNameDirty();
        }
        return this.wfdynamicusernameDirtyFlag;
    }

    /**
     *  重置属性值[工作流动态用户名称]
     */
    public void resetWFDynamicUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFDynamicUserName();
            return;
        }

        this.wfdynamicusernameDirtyFlag = false;
        this.wfdynamicusername = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFDynamicUserBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFDynamicUserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetParams();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserObject();
        et.resetUserType();
        et.resetWFDynamicUserId();
        et.resetWFDynamicUserName();
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
        if(!bDirtyOnly || isParamsDirty()) {
            params.put(FIELD_PARAMS,getParams());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isUserObjectDirty()) {
            params.put(FIELD_USEROBJECT,getUserObject());
        }
        if(!bDirtyOnly || isUserTypeDirty()) {
            params.put(FIELD_USERTYPE,getUserType());
        }
        if(!bDirtyOnly || isWFDynamicUserIdDirty()) {
            params.put(FIELD_WFDYNAMICUSERID,getWFDynamicUserId());
        }
        if(!bDirtyOnly || isWFDynamicUserNameDirty()) {
            params.put(FIELD_WFDYNAMICUSERNAME,getWFDynamicUserName());
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

        return  WFDynamicUserBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFDynamicUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_PARAMS:
            return et.getParams();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USEROBJECT:
            return et.getUserObject();
        case INDEX_USERTYPE:
            return et.getUserType();
        case INDEX_WFDYNAMICUSERID:
            return et.getWFDynamicUserId();
        case INDEX_WFDYNAMICUSERNAME:
            return et.getWFDynamicUserName();
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

        WFDynamicUserBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFDynamicUserBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARAMS:
            et.setParams(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_USEROBJECT:
            et.setUserObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERTYPE:
            et.setUserType(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFDYNAMICUSERID:
            et.setWFDynamicUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFDYNAMICUSERNAME:
            et.setWFDynamicUserName(DataObject.getStringValue(obj));
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

        return  WFDynamicUserBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFDynamicUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_PARAMS:
            return et.getParams()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USEROBJECT:
            return et.getUserObject()==null;
        case INDEX_USERTYPE:
            return et.getUserType()==null;
        case INDEX_WFDYNAMICUSERID:
            return et.getWFDynamicUserId()==null;
        case INDEX_WFDYNAMICUSERNAME:
            return et.getWFDynamicUserName()==null;
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
        return  WFDynamicUserBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFDynamicUserBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_PARAMS:
            return et.isParamsDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USEROBJECT:
            return et.isUserObjectDirty();
        case INDEX_USERTYPE:
            return et.isUserTypeDirty();
        case INDEX_WFDYNAMICUSERID:
            return et.isWFDynamicUserIdDirty();
        case INDEX_WFDYNAMICUSERNAME:
            return et.isWFDynamicUserNameDirty();
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
    private static  void fillJSONObject(WFDynamicUserBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getParams()!=null) {
            JSONObjectHelper.put(json,"params",getJSONValue(et.getParams()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getUserObject()!=null) {
            JSONObjectHelper.put(json,"userobject",getJSONValue(et.getUserObject()),false);
        }
        if(bIncEmpty||et.getUserType()!=null) {
            JSONObjectHelper.put(json,"usertype",getJSONValue(et.getUserType()),false);
        }
        if(bIncEmpty||et.getWFDynamicUserId()!=null) {
            JSONObjectHelper.put(json,"wfdynamicuserid",getJSONValue(et.getWFDynamicUserId()),false);
        }
        if(bIncEmpty||et.getWFDynamicUserName()!=null) {
            JSONObjectHelper.put(json,"wfdynamicusername",getJSONValue(et.getWFDynamicUserName()),false);
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
    private static void fillXmlNode(WFDynamicUserBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParams()!=null) {
            Object obj = et.getParams();
            node.setAttribute("PARAMS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserObject()!=null) {
            Object obj = et.getUserObject();
            node.setAttribute("USEROBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserType()!=null) {
            Object obj = et.getUserType();
            node.setAttribute("USERTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFDynamicUserId()!=null) {
            Object obj = et.getWFDynamicUserId();
            node.setAttribute("WFDYNAMICUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFDynamicUserName()!=null) {
            Object obj = et.getWFDynamicUserName();
            node.setAttribute("WFDYNAMICUSERNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFDynamicUserBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFDynamicUserBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isParamsDirty() && (bIncEmpty||et.getParams()!=null)) {
            dst.set(FIELD_PARAMS,et.getParams());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isUserObjectDirty() && (bIncEmpty||et.getUserObject()!=null)) {
            dst.set(FIELD_USEROBJECT,et.getUserObject());
        }
        if(et.isUserTypeDirty() && (bIncEmpty||et.getUserType()!=null)) {
            dst.set(FIELD_USERTYPE,et.getUserType());
        }
        if(et.isWFDynamicUserIdDirty() && (bIncEmpty||et.getWFDynamicUserId()!=null)) {
            dst.set(FIELD_WFDYNAMICUSERID,et.getWFDynamicUserId());
        }
        if(et.isWFDynamicUserNameDirty() && (bIncEmpty||et.getWFDynamicUserName()!=null)) {
            dst.set(FIELD_WFDYNAMICUSERNAME,et.getWFDynamicUserName());
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
        return  WFDynamicUserBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFDynamicUserBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_PARAMS:
            et.resetParams();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_USEROBJECT:
            et.resetUserObject();
            return true;
        case INDEX_USERTYPE:
            et.resetUserType();
            return true;
        case INDEX_WFDYNAMICUSERID:
            et.resetWFDynamicUserId();
            return true;
        case INDEX_WFDYNAMICUSERNAME:
            et.resetWFDynamicUserName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private WFDynamicUserBase getProxyEntity() {
        return this.proxyWFDynamicUserBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFDynamicUserBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFDynamicUserBase) {
            this.proxyWFDynamicUserBase = (WFDynamicUserBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFDynamicUserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}