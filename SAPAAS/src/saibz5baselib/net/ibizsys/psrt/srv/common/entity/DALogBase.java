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
 * 实体[DALog] 数据对象基类
 */
public abstract class DALogBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DALogBase.class);
    /**
     * 属性[日志时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[DA日志标识]
     */
    public final static String FIELD_DALOG_ID = "DALOG_ID";
    /**
     * 属性[DA日志名称]
     */
    public final static String FIELD_DALOG_NAME = "DALOG_NAME";
    /**
     * 属性[日志信息]
     */
    public final static String FIELD_LOGINFO = "LOGINFO";
    /**
     * 属性[日志序列]
     */
    public final static String FIELD_LOGSN = "LOGSN";
    /**
     * 属性[日志类型]
     */
    public final static String FIELD_LOGTYPE = "LOGTYPE";
    /**
     * 属性[对象标识]
     */
    public final static String FIELD_OBJECTID = "OBJECTID";
    /**
     * 属性[对象类型]
     */
    public final static String FIELD_OBJECTTYPE = "OBJECTTYPE";
    /**
     * 属性[远程地址]
     */
    public final static String FIELD_REMOTEADDR = "REMOTEADDR";
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
    private final static int INDEX_DALOG_ID = 2;
    private final static int INDEX_DALOG_NAME = 3;
    private final static int INDEX_LOGINFO = 4;
    private final static int INDEX_LOGSN = 5;
    private final static int INDEX_LOGTYPE = 6;
    private final static int INDEX_OBJECTID = 7;
    private final static int INDEX_OBJECTTYPE = 8;
    private final static int INDEX_REMOTEADDR = 9;
    private final static int INDEX_UPDATEDATE = 10;
    private final static int INDEX_UPDATEMAN = 11;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DALOG_ID, INDEX_DALOG_ID);
        fieldIndexMap.put( FIELD_DALOG_NAME, INDEX_DALOG_NAME);
        fieldIndexMap.put( FIELD_LOGINFO, INDEX_LOGINFO);
        fieldIndexMap.put( FIELD_LOGSN, INDEX_LOGSN);
        fieldIndexMap.put( FIELD_LOGTYPE, INDEX_LOGTYPE);
        fieldIndexMap.put( FIELD_OBJECTID, INDEX_OBJECTID);
        fieldIndexMap.put( FIELD_OBJECTTYPE, INDEX_OBJECTTYPE);
        fieldIndexMap.put( FIELD_REMOTEADDR, INDEX_REMOTEADDR);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private DALogBase proxyDALogBase = null;
    public DALogBase() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dalog_idDirtyFlag = false;
    private boolean dalog_nameDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean logsnDirtyFlag = false;
    private boolean logtypeDirtyFlag = false;
    private boolean objectidDirtyFlag = false;
    private boolean objecttypeDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dalog_id")
    private String dalog_id;
    @Column(name="dalog_name")
    private String dalog_name;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="logsn")
    private Integer logsn;
    @Column(name="logtype")
    private String logtype;
    @Column(name="objectid")
    private String objectid;
    @Column(name="objecttype")
    private String objecttype;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[日志时间]
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
     *  获取属性值[日志时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[日志时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[日志时间]
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
     *  设置属性值[DA日志标识]
     *  @param dalog_id
     */
    public void setDALOG_Id(String dalog_id) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDALOG_Id(dalog_id);
            return;
        }
        if(dalog_id!=null) {
            dalog_id = StringHelper.trimRight(dalog_id);
            if(dalog_id.length()==0) {
                dalog_id = null;
            }
        }
        this.dalog_id = dalog_id;
        this.dalog_idDirtyFlag  = true;
    }

    /**
     *  获取属性值[DA日志标识]
     */
    public String getDALOG_Id() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDALOG_Id();
        }
        return this.dalog_id;
    }

    /**
     *  获取属性值[DA日志标识]是否修改
     */
    public boolean isDALOG_IdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDALOG_IdDirty();
        }
        return this.dalog_idDirtyFlag;
    }

    /**
     *  重置属性值[DA日志标识]
     */
    public void resetDALOG_Id() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDALOG_Id();
            return;
        }

        this.dalog_idDirtyFlag = false;
        this.dalog_id = null;
    }
    /**
     *  设置属性值[DA日志名称]
     *  @param dalog_name
     */
    public void setDALOG_Name(String dalog_name) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDALOG_Name(dalog_name);
            return;
        }
        if(dalog_name!=null) {
            dalog_name = StringHelper.trimRight(dalog_name);
            if(dalog_name.length()==0) {
                dalog_name = null;
            }
        }
        this.dalog_name = dalog_name;
        this.dalog_nameDirtyFlag  = true;
    }

    /**
     *  获取属性值[DA日志名称]
     */
    public String getDALOG_Name() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDALOG_Name();
        }
        return this.dalog_name;
    }

    /**
     *  获取属性值[DA日志名称]是否修改
     */
    public boolean isDALOG_NameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDALOG_NameDirty();
        }
        return this.dalog_nameDirtyFlag;
    }

    /**
     *  重置属性值[DA日志名称]
     */
    public void resetDALOG_Name() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDALOG_Name();
            return;
        }

        this.dalog_nameDirtyFlag = false;
        this.dalog_name = null;
    }
    /**
     *  设置属性值[日志信息]
     *  @param loginfo
     */
    public void setLogInfo(String loginfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLogInfo(loginfo);
            return;
        }
        if(loginfo!=null) {
            loginfo = StringHelper.trimRight(loginfo);
            if(loginfo.length()==0) {
                loginfo = null;
            }
        }
        this.loginfo = loginfo;
        this.loginfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[日志信息]
     */
    public String getLogInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLogInfo();
        }
        return this.loginfo;
    }

    /**
     *  获取属性值[日志信息]是否修改
     */
    public boolean isLogInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLogInfoDirty();
        }
        return this.loginfoDirtyFlag;
    }

    /**
     *  重置属性值[日志信息]
     */
    public void resetLogInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLogInfo();
            return;
        }

        this.loginfoDirtyFlag = false;
        this.loginfo = null;
    }
    /**
     *  设置属性值[日志序列]
     *  @param logsn
     */
    public void setLogSN(Integer logsn) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLogSN(logsn);
            return;
        }
        this.logsn = logsn;
        this.logsnDirtyFlag  = true;
    }

    /**
     *  获取属性值[日志序列]
     */
    public Integer getLogSN() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLogSN();
        }
        return this.logsn;
    }

    /**
     *  获取属性值[日志序列]是否修改
     */
    public boolean isLogSNDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLogSNDirty();
        }
        return this.logsnDirtyFlag;
    }

    /**
     *  重置属性值[日志序列]
     */
    public void resetLogSN() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLogSN();
            return;
        }

        this.logsnDirtyFlag = false;
        this.logsn = null;
    }
    /**
     *  设置属性值[日志类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel
     *  @param logtype
     */
    public void setLOGType(String logtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLOGType(logtype);
            return;
        }
        if(logtype!=null) {
            logtype = StringHelper.trimRight(logtype);
            if(logtype.length()==0) {
                logtype = null;
            }
        }
        this.logtype = logtype;
        this.logtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[日志类型]代码表：net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel
     */
    public String getLOGType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLOGType();
        }
        return this.logtype;
    }

    /**
     *  获取属性值[日志类型]是否修改
     */
    public boolean isLOGTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLOGTypeDirty();
        }
        return this.logtypeDirtyFlag;
    }

    /**
     *  重置属性值[日志类型]
     */
    public void resetLOGType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLOGType();
            return;
        }

        this.logtypeDirtyFlag = false;
        this.logtype = null;
    }
    /**
     *  设置属性值[对象标识]
     *  @param objectid
     */
    public void setObjectId(String objectid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setObjectId(objectid);
            return;
        }
        if(objectid!=null) {
            objectid = StringHelper.trimRight(objectid);
            if(objectid.length()==0) {
                objectid = null;
            }
        }
        this.objectid = objectid;
        this.objectidDirtyFlag  = true;
    }

    /**
     *  获取属性值[对象标识]
     */
    public String getObjectId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getObjectId();
        }
        return this.objectid;
    }

    /**
     *  获取属性值[对象标识]是否修改
     */
    public boolean isObjectIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isObjectIdDirty();
        }
        return this.objectidDirtyFlag;
    }

    /**
     *  重置属性值[对象标识]
     */
    public void resetObjectId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetObjectId();
            return;
        }

        this.objectidDirtyFlag = false;
        this.objectid = null;
    }
    /**
     *  设置属性值[对象类型]
     *  @param objecttype
     */
    public void setObjectType(String objecttype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setObjectType(objecttype);
            return;
        }
        if(objecttype!=null) {
            objecttype = StringHelper.trimRight(objecttype);
            if(objecttype.length()==0) {
                objecttype = null;
            }
        }
        this.objecttype = objecttype;
        this.objecttypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[对象类型]
     */
    public String getObjectType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getObjectType();
        }
        return this.objecttype;
    }

    /**
     *  获取属性值[对象类型]是否修改
     */
    public boolean isObjectTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isObjectTypeDirty();
        }
        return this.objecttypeDirtyFlag;
    }

    /**
     *  重置属性值[对象类型]
     */
    public void resetObjectType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetObjectType();
            return;
        }

        this.objecttypeDirtyFlag = false;
        this.objecttype = null;
    }
    /**
     *  设置属性值[远程地址]
     *  @param remoteaddr
     */
    public void setRemoteAddr(String remoteaddr) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRemoteAddr(remoteaddr);
            return;
        }
        if(remoteaddr!=null) {
            remoteaddr = StringHelper.trimRight(remoteaddr);
            if(remoteaddr.length()==0) {
                remoteaddr = null;
            }
        }
        this.remoteaddr = remoteaddr;
        this.remoteaddrDirtyFlag  = true;
    }

    /**
     *  获取属性值[远程地址]
     */
    public String getRemoteAddr() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRemoteAddr();
        }
        return this.remoteaddr;
    }

    /**
     *  获取属性值[远程地址]是否修改
     */
    public boolean isRemoteAddrDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRemoteAddrDirty();
        }
        return this.remoteaddrDirtyFlag;
    }

    /**
     *  重置属性值[远程地址]
     */
    public void resetRemoteAddr() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRemoteAddr();
            return;
        }

        this.remoteaddrDirtyFlag = false;
        this.remoteaddr = null;
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
        DALogBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DALogBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDALOG_Id();
        et.resetDALOG_Name();
        et.resetLogInfo();
        et.resetLogSN();
        et.resetLOGType();
        et.resetObjectId();
        et.resetObjectType();
        et.resetRemoteAddr();
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
        if(!bDirtyOnly || isDALOG_IdDirty()) {
            params.put(FIELD_DALOG_ID,getDALOG_Id());
        }
        if(!bDirtyOnly || isDALOG_NameDirty()) {
            params.put(FIELD_DALOG_NAME,getDALOG_Name());
        }
        if(!bDirtyOnly || isLogInfoDirty()) {
            params.put(FIELD_LOGINFO,getLogInfo());
        }
        if(!bDirtyOnly || isLogSNDirty()) {
            params.put(FIELD_LOGSN,getLogSN());
        }
        if(!bDirtyOnly || isLOGTypeDirty()) {
            params.put(FIELD_LOGTYPE,getLOGType());
        }
        if(!bDirtyOnly || isObjectIdDirty()) {
            params.put(FIELD_OBJECTID,getObjectId());
        }
        if(!bDirtyOnly || isObjectTypeDirty()) {
            params.put(FIELD_OBJECTTYPE,getObjectType());
        }
        if(!bDirtyOnly || isRemoteAddrDirty()) {
            params.put(FIELD_REMOTEADDR,getRemoteAddr());
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

        return  DALogBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DALogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DALOG_ID:
            return et.getDALOG_Id();
        case INDEX_DALOG_NAME:
            return et.getDALOG_Name();
        case INDEX_LOGINFO:
            return et.getLogInfo();
        case INDEX_LOGSN:
            return et.getLogSN();
        case INDEX_LOGTYPE:
            return et.getLOGType();
        case INDEX_OBJECTID:
            return et.getObjectId();
        case INDEX_OBJECTTYPE:
            return et.getObjectType();
        case INDEX_REMOTEADDR:
            return et.getRemoteAddr();
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

        DALogBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DALogBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DALOG_ID:
            et.setDALOG_Id(DataObject.getStringValue(obj));
            return ;
        case INDEX_DALOG_NAME:
            et.setDALOG_Name(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGINFO:
            et.setLogInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGSN:
            et.setLogSN(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_LOGTYPE:
            et.setLOGType(DataObject.getStringValue(obj));
            return ;
        case INDEX_OBJECTID:
            et.setObjectId(DataObject.getStringValue(obj));
            return ;
        case INDEX_OBJECTTYPE:
            et.setObjectType(DataObject.getStringValue(obj));
            return ;
        case INDEX_REMOTEADDR:
            et.setRemoteAddr(DataObject.getStringValue(obj));
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

        return  DALogBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DALogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DALOG_ID:
            return et.getDALOG_Id()==null;
        case INDEX_DALOG_NAME:
            return et.getDALOG_Name()==null;
        case INDEX_LOGINFO:
            return et.getLogInfo()==null;
        case INDEX_LOGSN:
            return et.getLogSN()==null;
        case INDEX_LOGTYPE:
            return et.getLOGType()==null;
        case INDEX_OBJECTID:
            return et.getObjectId()==null;
        case INDEX_OBJECTTYPE:
            return et.getObjectType()==null;
        case INDEX_REMOTEADDR:
            return et.getRemoteAddr()==null;
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
        return  DALogBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DALogBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DALOG_ID:
            return et.isDALOG_IdDirty();
        case INDEX_DALOG_NAME:
            return et.isDALOG_NameDirty();
        case INDEX_LOGINFO:
            return et.isLogInfoDirty();
        case INDEX_LOGSN:
            return et.isLogSNDirty();
        case INDEX_LOGTYPE:
            return et.isLOGTypeDirty();
        case INDEX_OBJECTID:
            return et.isObjectIdDirty();
        case INDEX_OBJECTTYPE:
            return et.isObjectTypeDirty();
        case INDEX_REMOTEADDR:
            return et.isRemoteAddrDirty();
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
    private static  void fillJSONObject(DALogBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDALOG_Id()!=null) {
            JSONObjectHelper.put(json,"dalog_id",getJSONValue(et.getDALOG_Id()),false);
        }
        if(bIncEmpty||et.getDALOG_Name()!=null) {
            JSONObjectHelper.put(json,"dalog_name",getJSONValue(et.getDALOG_Name()),false);
        }
        if(bIncEmpty||et.getLogInfo()!=null) {
            JSONObjectHelper.put(json,"loginfo",getJSONValue(et.getLogInfo()),false);
        }
        if(bIncEmpty||et.getLogSN()!=null) {
            JSONObjectHelper.put(json,"logsn",getJSONValue(et.getLogSN()),false);
        }
        if(bIncEmpty||et.getLOGType()!=null) {
            JSONObjectHelper.put(json,"logtype",getJSONValue(et.getLOGType()),false);
        }
        if(bIncEmpty||et.getObjectId()!=null) {
            JSONObjectHelper.put(json,"objectid",getJSONValue(et.getObjectId()),false);
        }
        if(bIncEmpty||et.getObjectType()!=null) {
            JSONObjectHelper.put(json,"objecttype",getJSONValue(et.getObjectType()),false);
        }
        if(bIncEmpty||et.getRemoteAddr()!=null) {
            JSONObjectHelper.put(json,"remoteaddr",getJSONValue(et.getRemoteAddr()),false);
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
    private static void fillXmlNode(DALogBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDALOG_Id()!=null) {
            Object obj = et.getDALOG_Id();
            node.setAttribute("DALOG_ID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDALOG_Name()!=null) {
            Object obj = et.getDALOG_Name();
            node.setAttribute("DALOG_NAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLogInfo()!=null) {
            Object obj = et.getLogInfo();
            node.setAttribute("LOGINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLogSN()!=null) {
            Object obj = et.getLogSN();
            node.setAttribute("LOGSN",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLOGType()!=null) {
            Object obj = et.getLOGType();
            node.setAttribute("LOGTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getObjectId()!=null) {
            Object obj = et.getObjectId();
            node.setAttribute("OBJECTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getObjectType()!=null) {
            Object obj = et.getObjectType();
            node.setAttribute("OBJECTTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRemoteAddr()!=null) {
            Object obj = et.getRemoteAddr();
            node.setAttribute("REMOTEADDR",(obj==null)?"":(String)obj);
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
        DALogBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DALogBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDALOG_IdDirty() && (bIncEmpty||et.getDALOG_Id()!=null)) {
            dst.set(FIELD_DALOG_ID,et.getDALOG_Id());
        }
        if(et.isDALOG_NameDirty() && (bIncEmpty||et.getDALOG_Name()!=null)) {
            dst.set(FIELD_DALOG_NAME,et.getDALOG_Name());
        }
        if(et.isLogInfoDirty() && (bIncEmpty||et.getLogInfo()!=null)) {
            dst.set(FIELD_LOGINFO,et.getLogInfo());
        }
        if(et.isLogSNDirty() && (bIncEmpty||et.getLogSN()!=null)) {
            dst.set(FIELD_LOGSN,et.getLogSN());
        }
        if(et.isLOGTypeDirty() && (bIncEmpty||et.getLOGType()!=null)) {
            dst.set(FIELD_LOGTYPE,et.getLOGType());
        }
        if(et.isObjectIdDirty() && (bIncEmpty||et.getObjectId()!=null)) {
            dst.set(FIELD_OBJECTID,et.getObjectId());
        }
        if(et.isObjectTypeDirty() && (bIncEmpty||et.getObjectType()!=null)) {
            dst.set(FIELD_OBJECTTYPE,et.getObjectType());
        }
        if(et.isRemoteAddrDirty() && (bIncEmpty||et.getRemoteAddr()!=null)) {
            dst.set(FIELD_REMOTEADDR,et.getRemoteAddr());
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
        return  DALogBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DALogBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DALOG_ID:
            et.resetDALOG_Id();
            return true;
        case INDEX_DALOG_NAME:
            et.resetDALOG_Name();
            return true;
        case INDEX_LOGINFO:
            et.resetLogInfo();
            return true;
        case INDEX_LOGSN:
            et.resetLogSN();
            return true;
        case INDEX_LOGTYPE:
            et.resetLOGType();
            return true;
        case INDEX_OBJECTID:
            et.resetObjectId();
            return true;
        case INDEX_OBJECTTYPE:
            et.resetObjectType();
            return true;
        case INDEX_REMOTEADDR:
            et.resetRemoteAddr();
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




    /**
     *  获取代理的数据对象
     */
    private DALogBase getProxyEntity() {
        return this.proxyDALogBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDALogBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DALogBase) {
            this.proxyDALogBase = (DALogBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DALogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}