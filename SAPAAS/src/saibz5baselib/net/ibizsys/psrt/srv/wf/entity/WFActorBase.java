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
 * 实体[WFActor] 数据对象基类
 */
public abstract class WFActorBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFActorBase.class);
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
     * 属性[工作流操作者标识]
     */
    public final static String FIELD_WFACTORID = "WFACTORID";
    /**
     * 属性[工作流操作者名称]
     */
    public final static String FIELD_WFACTORNAME = "WFACTORNAME";
    /**
     * 属性[操作者参数]
     */
    public final static String FIELD_WFACTORPARAM = "WFACTORPARAM";
    /**
     * 属性[操作者参数2]
     */
    public final static String FIELD_WFACTORPARAM2 = "WFACTORPARAM2";
    /**
     * 属性[角色类型]
     */
    public final static String FIELD_WFACTORTYPE = "WFACTORTYPE";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_PARAMS = 2;
    private final static int INDEX_UPDATEDATE = 3;
    private final static int INDEX_UPDATEMAN = 4;
    private final static int INDEX_WFACTORID = 5;
    private final static int INDEX_WFACTORNAME = 6;
    private final static int INDEX_WFACTORPARAM = 7;
    private final static int INDEX_WFACTORPARAM2 = 8;
    private final static int INDEX_WFACTORTYPE = 9;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_PARAMS, INDEX_PARAMS);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFACTORID, INDEX_WFACTORID);
        fieldIndexMap.put( FIELD_WFACTORNAME, INDEX_WFACTORNAME);
        fieldIndexMap.put( FIELD_WFACTORPARAM, INDEX_WFACTORPARAM);
        fieldIndexMap.put( FIELD_WFACTORPARAM2, INDEX_WFACTORPARAM2);
        fieldIndexMap.put( FIELD_WFACTORTYPE, INDEX_WFACTORTYPE);
    }

    private WFActorBase proxyWFActorBase = null;
    public WFActorBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfactoridDirtyFlag = false;
    private boolean wfactornameDirtyFlag = false;
    private boolean wfactorparamDirtyFlag = false;
    private boolean wfactorparam2DirtyFlag = false;
    private boolean wfactortypeDirtyFlag = false;

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
    @Column(name="wfactorid")
    private String wfactorid;
    @Column(name="wfactorname")
    private String wfactorname;
    @Column(name="wfactorparam")
    private String wfactorparam;
    @Column(name="wfactorparam2")
    private String wfactorparam2;
    @Column(name="wfactortype")
    private String wfactortype;


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
     *  设置属性值[工作流操作者标识]
     *  @param wfactorid
     */
    public void setWFActorId(String wfactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorId(wfactorid);
            return;
        }
        if(wfactorid!=null) {
            wfactorid = StringHelper.trimRight(wfactorid);
            if(wfactorid.length()==0) {
                wfactorid = null;
            }
        }
        this.wfactorid = wfactorid;
        this.wfactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流操作者标识]
     */
    public String getWFActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorId();
        }
        return this.wfactorid;
    }

    /**
     *  获取属性值[工作流操作者标识]是否修改
     */
    public boolean isWFActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorIdDirty();
        }
        return this.wfactoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流操作者标识]
     */
    public void resetWFActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorId();
            return;
        }

        this.wfactoridDirtyFlag = false;
        this.wfactorid = null;
    }
    /**
     *  设置属性值[工作流操作者名称]
     *  @param wfactorname
     */
    public void setWFActorName(String wfactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorName(wfactorname);
            return;
        }
        if(wfactorname!=null) {
            wfactorname = StringHelper.trimRight(wfactorname);
            if(wfactorname.length()==0) {
                wfactorname = null;
            }
        }
        this.wfactorname = wfactorname;
        this.wfactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流操作者名称]
     */
    public String getWFActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorName();
        }
        return this.wfactorname;
    }

    /**
     *  获取属性值[工作流操作者名称]是否修改
     */
    public boolean isWFActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorNameDirty();
        }
        return this.wfactornameDirtyFlag;
    }

    /**
     *  重置属性值[工作流操作者名称]
     */
    public void resetWFActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorName();
            return;
        }

        this.wfactornameDirtyFlag = false;
        this.wfactorname = null;
    }
    /**
     *  设置属性值[操作者参数]
     *  @param wfactorparam
     */
    public void setWFActorParam(String wfactorparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorParam(wfactorparam);
            return;
        }
        if(wfactorparam!=null) {
            wfactorparam = StringHelper.trimRight(wfactorparam);
            if(wfactorparam.length()==0) {
                wfactorparam = null;
            }
        }
        this.wfactorparam = wfactorparam;
        this.wfactorparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作者参数]
     */
    public String getWFActorParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorParam();
        }
        return this.wfactorparam;
    }

    /**
     *  获取属性值[操作者参数]是否修改
     */
    public boolean isWFActorParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorParamDirty();
        }
        return this.wfactorparamDirtyFlag;
    }

    /**
     *  重置属性值[操作者参数]
     */
    public void resetWFActorParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorParam();
            return;
        }

        this.wfactorparamDirtyFlag = false;
        this.wfactorparam = null;
    }
    /**
     *  设置属性值[操作者参数2]
     *  @param wfactorparam2
     */
    public void setWFActorParam2(String wfactorparam2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorParam2(wfactorparam2);
            return;
        }
        if(wfactorparam2!=null) {
            wfactorparam2 = StringHelper.trimRight(wfactorparam2);
            if(wfactorparam2.length()==0) {
                wfactorparam2 = null;
            }
        }
        this.wfactorparam2 = wfactorparam2;
        this.wfactorparam2DirtyFlag  = true;
    }

    /**
     *  获取属性值[操作者参数2]
     */
    public String getWFActorParam2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorParam2();
        }
        return this.wfactorparam2;
    }

    /**
     *  获取属性值[操作者参数2]是否修改
     */
    public boolean isWFActorParam2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorParam2Dirty();
        }
        return this.wfactorparam2DirtyFlag;
    }

    /**
     *  重置属性值[操作者参数2]
     */
    public void resetWFActorParam2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorParam2();
            return;
        }

        this.wfactorparam2DirtyFlag = false;
        this.wfactorparam2 = null;
    }
    /**
     *  设置属性值[角色类型]代码表：net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel
     *  @param wfactortype
     */
    public void setWFActorType(String wfactortype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFActorType(wfactortype);
            return;
        }
        if(wfactortype!=null) {
            wfactortype = StringHelper.trimRight(wfactortype);
            if(wfactortype.length()==0) {
                wfactortype = null;
            }
        }
        this.wfactortype = wfactortype;
        this.wfactortypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[角色类型]代码表：net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel
     */
    public String getWFActorType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFActorType();
        }
        return this.wfactortype;
    }

    /**
     *  获取属性值[角色类型]是否修改
     */
    public boolean isWFActorTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFActorTypeDirty();
        }
        return this.wfactortypeDirtyFlag;
    }

    /**
     *  重置属性值[角色类型]
     */
    public void resetWFActorType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFActorType();
            return;
        }

        this.wfactortypeDirtyFlag = false;
        this.wfactortype = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFActorBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFActorBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetParams();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFActorId();
        et.resetWFActorName();
        et.resetWFActorParam();
        et.resetWFActorParam2();
        et.resetWFActorType();
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
        if(!bDirtyOnly || isWFActorIdDirty()) {
            params.put(FIELD_WFACTORID,getWFActorId());
        }
        if(!bDirtyOnly || isWFActorNameDirty()) {
            params.put(FIELD_WFACTORNAME,getWFActorName());
        }
        if(!bDirtyOnly || isWFActorParamDirty()) {
            params.put(FIELD_WFACTORPARAM,getWFActorParam());
        }
        if(!bDirtyOnly || isWFActorParam2Dirty()) {
            params.put(FIELD_WFACTORPARAM2,getWFActorParam2());
        }
        if(!bDirtyOnly || isWFActorTypeDirty()) {
            params.put(FIELD_WFACTORTYPE,getWFActorType());
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

        return  WFActorBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFActorBase et,int index) throws Exception {

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
        case INDEX_WFACTORID:
            return et.getWFActorId();
        case INDEX_WFACTORNAME:
            return et.getWFActorName();
        case INDEX_WFACTORPARAM:
            return et.getWFActorParam();
        case INDEX_WFACTORPARAM2:
            return et.getWFActorParam2();
        case INDEX_WFACTORTYPE:
            return et.getWFActorType();
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

        WFActorBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFActorBase et,int index,Object obj) throws Exception {
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
        case INDEX_WFACTORID:
            et.setWFActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORNAME:
            et.setWFActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORPARAM:
            et.setWFActorParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORPARAM2:
            et.setWFActorParam2(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFACTORTYPE:
            et.setWFActorType(DataObject.getStringValue(obj));
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

        return  WFActorBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFActorBase et,int index) throws Exception {

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
        case INDEX_WFACTORID:
            return et.getWFActorId()==null;
        case INDEX_WFACTORNAME:
            return et.getWFActorName()==null;
        case INDEX_WFACTORPARAM:
            return et.getWFActorParam()==null;
        case INDEX_WFACTORPARAM2:
            return et.getWFActorParam2()==null;
        case INDEX_WFACTORTYPE:
            return et.getWFActorType()==null;
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
        return  WFActorBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFActorBase et,int index) throws Exception {

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
        case INDEX_WFACTORID:
            return et.isWFActorIdDirty();
        case INDEX_WFACTORNAME:
            return et.isWFActorNameDirty();
        case INDEX_WFACTORPARAM:
            return et.isWFActorParamDirty();
        case INDEX_WFACTORPARAM2:
            return et.isWFActorParam2Dirty();
        case INDEX_WFACTORTYPE:
            return et.isWFActorTypeDirty();
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
    private static  void fillJSONObject(WFActorBase et,JSONObject json, boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFActorId()!=null) {
            JSONObjectHelper.put(json,"wfactorid",getJSONValue(et.getWFActorId()),false);
        }
        if(bIncEmpty||et.getWFActorName()!=null) {
            JSONObjectHelper.put(json,"wfactorname",getJSONValue(et.getWFActorName()),false);
        }
        if(bIncEmpty||et.getWFActorParam()!=null) {
            JSONObjectHelper.put(json,"wfactorparam",getJSONValue(et.getWFActorParam()),false);
        }
        if(bIncEmpty||et.getWFActorParam2()!=null) {
            JSONObjectHelper.put(json,"wfactorparam2",getJSONValue(et.getWFActorParam2()),false);
        }
        if(bIncEmpty||et.getWFActorType()!=null) {
            JSONObjectHelper.put(json,"wfactortype",getJSONValue(et.getWFActorType()),false);
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
    private static void fillXmlNode(WFActorBase et,XmlNode node,boolean bIncEmpty) throws Exception {
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
        if(bIncEmpty||et.getWFActorId()!=null) {
            Object obj = et.getWFActorId();
            node.setAttribute("WFACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorName()!=null) {
            Object obj = et.getWFActorName();
            node.setAttribute("WFACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorParam()!=null) {
            Object obj = et.getWFActorParam();
            node.setAttribute("WFACTORPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorParam2()!=null) {
            Object obj = et.getWFActorParam2();
            node.setAttribute("WFACTORPARAM2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFActorType()!=null) {
            Object obj = et.getWFActorType();
            node.setAttribute("WFACTORTYPE",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFActorBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFActorBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
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
        if(et.isWFActorIdDirty() && (bIncEmpty||et.getWFActorId()!=null)) {
            dst.set(FIELD_WFACTORID,et.getWFActorId());
        }
        if(et.isWFActorNameDirty() && (bIncEmpty||et.getWFActorName()!=null)) {
            dst.set(FIELD_WFACTORNAME,et.getWFActorName());
        }
        if(et.isWFActorParamDirty() && (bIncEmpty||et.getWFActorParam()!=null)) {
            dst.set(FIELD_WFACTORPARAM,et.getWFActorParam());
        }
        if(et.isWFActorParam2Dirty() && (bIncEmpty||et.getWFActorParam2()!=null)) {
            dst.set(FIELD_WFACTORPARAM2,et.getWFActorParam2());
        }
        if(et.isWFActorTypeDirty() && (bIncEmpty||et.getWFActorType()!=null)) {
            dst.set(FIELD_WFACTORTYPE,et.getWFActorType());
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
        return  WFActorBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFActorBase et,int index) throws Exception {
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
        case INDEX_WFACTORID:
            et.resetWFActorId();
            return true;
        case INDEX_WFACTORNAME:
            et.resetWFActorName();
            return true;
        case INDEX_WFACTORPARAM:
            et.resetWFActorParam();
            return true;
        case INDEX_WFACTORPARAM2:
            et.resetWFActorParam2();
            return true;
        case INDEX_WFACTORTYPE:
            et.resetWFActorType();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }




    /**
     *  获取代理的数据对象
     */
    private WFActorBase getProxyEntity() {
        return this.proxyWFActorBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFActorBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFActorBase) {
            this.proxyWFActorBase = (WFActorBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}