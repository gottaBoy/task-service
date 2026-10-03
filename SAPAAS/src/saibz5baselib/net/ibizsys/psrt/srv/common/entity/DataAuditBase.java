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
 * 实体[DataAudit] 数据对象基类
 */
public abstract class DataAuditBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataAuditBase.class);
    /**
     * 属性[审计明细]
     */
    public final static String FIELD_AUDITINFO = "AUDITINFO";
    /**
     * 属性[行为类型]
     */
    public final static String FIELD_AUDITTYPE = "AUDITTYPE";
    /**
     * 属性[操作时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据审计标识]
     */
    public final static String FIELD_DATAAUDITID = "DATAAUDITID";
    /**
     * 属性[审计条目]
     */
    public final static String FIELD_DATAAUDITNAME = "DATAAUDITNAME";
    /**
     * 属性[访问地址]
     */
    public final static String FIELD_IPADDRESS = "IPADDRESS";
    /**
     * 属性[对象编号]
     */
    public final static String FIELD_OBJECTID = "OBJECTID";
    /**
     * 属性[对象类型]
     */
    public final static String FIELD_OBJECTTYPE = "OBJECTTYPE";
    /**
     * 属性[操作人]
     */
    public final static String FIELD_OPPERSONID = "OPPERSONID";
    /**
     * 属性[操作人]
     */
    public final static String FIELD_OPPERSONNAME = "OPPERSONNAME";
    /**
     * 属性[访问标识]
     */
    public final static String FIELD_SESSIONID = "SESSIONID";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_AUDITINFO = 0;
    private final static int INDEX_AUDITTYPE = 1;
    private final static int INDEX_CREATEDATE = 2;
    private final static int INDEX_CREATEMAN = 3;
    private final static int INDEX_DATAAUDITID = 4;
    private final static int INDEX_DATAAUDITNAME = 5;
    private final static int INDEX_IPADDRESS = 6;
    private final static int INDEX_OBJECTID = 7;
    private final static int INDEX_OBJECTTYPE = 8;
    private final static int INDEX_OPPERSONID = 9;
    private final static int INDEX_OPPERSONNAME = 10;
    private final static int INDEX_SESSIONID = 11;
    private final static int INDEX_UPDATEDATE = 12;
    private final static int INDEX_UPDATEMAN = 13;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_AUDITINFO, INDEX_AUDITINFO);
        fieldIndexMap.put( FIELD_AUDITTYPE, INDEX_AUDITTYPE);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATAAUDITID, INDEX_DATAAUDITID);
        fieldIndexMap.put( FIELD_DATAAUDITNAME, INDEX_DATAAUDITNAME);
        fieldIndexMap.put( FIELD_IPADDRESS, INDEX_IPADDRESS);
        fieldIndexMap.put( FIELD_OBJECTID, INDEX_OBJECTID);
        fieldIndexMap.put( FIELD_OBJECTTYPE, INDEX_OBJECTTYPE);
        fieldIndexMap.put( FIELD_OPPERSONID, INDEX_OPPERSONID);
        fieldIndexMap.put( FIELD_OPPERSONNAME, INDEX_OPPERSONNAME);
        fieldIndexMap.put( FIELD_SESSIONID, INDEX_SESSIONID);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private DataAuditBase proxyDataAuditBase = null;
    public DataAuditBase() {
        super();
    }
    private boolean auditinfoDirtyFlag = false;
    private boolean audittypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataauditidDirtyFlag = false;
    private boolean dataauditnameDirtyFlag = false;
    private boolean ipaddressDirtyFlag = false;
    private boolean objectidDirtyFlag = false;
    private boolean objecttypeDirtyFlag = false;
    private boolean oppersonidDirtyFlag = false;
    private boolean oppersonnameDirtyFlag = false;
    private boolean sessionidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="auditinfo")
    private String auditinfo;
    @Column(name="audittype")
    private String audittype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dataauditid")
    private String dataauditid;
    @Column(name="dataauditname")
    private String dataauditname;
    @Column(name="ipaddress")
    private String ipaddress;
    @Column(name="objectid")
    private String objectid;
    @Column(name="objecttype")
    private String objecttype;
    @Column(name="oppersonid")
    private String oppersonid;
    @Column(name="oppersonname")
    private String oppersonname;
    @Column(name="sessionid")
    private String sessionid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[审计明细]
     *  @param auditinfo
     */
    public void setAuditInfo(String auditinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAuditInfo(auditinfo);
            return;
        }
        if(auditinfo!=null) {
            auditinfo = StringHelper.trimRight(auditinfo);
            if(auditinfo.length()==0) {
                auditinfo = null;
            }
        }
        this.auditinfo = auditinfo;
        this.auditinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[审计明细]
     */
    public String getAuditInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAuditInfo();
        }
        return this.auditinfo;
    }

    /**
     *  获取属性值[审计明细]是否修改
     */
    public boolean isAuditInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAuditInfoDirty();
        }
        return this.auditinfoDirtyFlag;
    }

    /**
     *  重置属性值[审计明细]
     */
    public void resetAuditInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAuditInfo();
            return;
        }

        this.auditinfoDirtyFlag = false;
        this.auditinfo = null;
    }
    /**
     *  设置属性值[行为类型]代码表：net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel
     *  @param audittype
     */
    public void setAuditType(String audittype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setAuditType(audittype);
            return;
        }
        if(audittype!=null) {
            audittype = StringHelper.trimRight(audittype);
            if(audittype.length()==0) {
                audittype = null;
            }
        }
        this.audittype = audittype;
        this.audittypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[行为类型]代码表：net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel
     */
    public String getAuditType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getAuditType();
        }
        return this.audittype;
    }

    /**
     *  获取属性值[行为类型]是否修改
     */
    public boolean isAuditTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isAuditTypeDirty();
        }
        return this.audittypeDirtyFlag;
    }

    /**
     *  重置属性值[行为类型]
     */
    public void resetAuditType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetAuditType();
            return;
        }

        this.audittypeDirtyFlag = false;
        this.audittype = null;
    }
    /**
     *  设置属性值[操作时间]
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
     *  获取属性值[操作时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[操作时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[操作时间]
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
     *  设置属性值[数据审计标识]
     *  @param dataauditid
     */
    public void setDataAuditId(String dataauditid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditId(dataauditid);
            return;
        }
        if(dataauditid!=null) {
            dataauditid = StringHelper.trimRight(dataauditid);
            if(dataauditid.length()==0) {
                dataauditid = null;
            }
        }
        this.dataauditid = dataauditid;
        this.dataauditidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据审计标识]
     */
    public String getDataAuditId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditId();
        }
        return this.dataauditid;
    }

    /**
     *  获取属性值[数据审计标识]是否修改
     */
    public boolean isDataAuditIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditIdDirty();
        }
        return this.dataauditidDirtyFlag;
    }

    /**
     *  重置属性值[数据审计标识]
     */
    public void resetDataAuditId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditId();
            return;
        }

        this.dataauditidDirtyFlag = false;
        this.dataauditid = null;
    }
    /**
     *  设置属性值[审计条目]
     *  @param dataauditname
     */
    public void setDataAuditName(String dataauditname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataAuditName(dataauditname);
            return;
        }
        if(dataauditname!=null) {
            dataauditname = StringHelper.trimRight(dataauditname);
            if(dataauditname.length()==0) {
                dataauditname = null;
            }
        }
        this.dataauditname = dataauditname;
        this.dataauditnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[审计条目]
     */
    public String getDataAuditName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataAuditName();
        }
        return this.dataauditname;
    }

    /**
     *  获取属性值[审计条目]是否修改
     */
    public boolean isDataAuditNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataAuditNameDirty();
        }
        return this.dataauditnameDirtyFlag;
    }

    /**
     *  重置属性值[审计条目]
     */
    public void resetDataAuditName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataAuditName();
            return;
        }

        this.dataauditnameDirtyFlag = false;
        this.dataauditname = null;
    }
    /**
     *  设置属性值[访问地址]
     *  @param ipaddress
     */
    public void setIPAddress(String ipaddress) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIPAddress(ipaddress);
            return;
        }
        if(ipaddress!=null) {
            ipaddress = StringHelper.trimRight(ipaddress);
            if(ipaddress.length()==0) {
                ipaddress = null;
            }
        }
        this.ipaddress = ipaddress;
        this.ipaddressDirtyFlag  = true;
    }

    /**
     *  获取属性值[访问地址]
     */
    public String getIPAddress() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIPAddress();
        }
        return this.ipaddress;
    }

    /**
     *  获取属性值[访问地址]是否修改
     */
    public boolean isIPAddressDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIPAddressDirty();
        }
        return this.ipaddressDirtyFlag;
    }

    /**
     *  重置属性值[访问地址]
     */
    public void resetIPAddress() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIPAddress();
            return;
        }

        this.ipaddressDirtyFlag = false;
        this.ipaddress = null;
    }
    /**
     *  设置属性值[对象编号]
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
     *  获取属性值[对象编号]
     */
    public String getObjectId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getObjectId();
        }
        return this.objectid;
    }

    /**
     *  获取属性值[对象编号]是否修改
     */
    public boolean isObjectIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isObjectIdDirty();
        }
        return this.objectidDirtyFlag;
    }

    /**
     *  重置属性值[对象编号]
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
     *  设置属性值[操作人]
     *  @param oppersonid
     */
    public void setOpPersonId(String oppersonid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOpPersonId(oppersonid);
            return;
        }
        if(oppersonid!=null) {
            oppersonid = StringHelper.trimRight(oppersonid);
            if(oppersonid.length()==0) {
                oppersonid = null;
            }
        }
        this.oppersonid = oppersonid;
        this.oppersonidDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作人]
     */
    public String getOpPersonId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOpPersonId();
        }
        return this.oppersonid;
    }

    /**
     *  获取属性值[操作人]是否修改
     */
    public boolean isOpPersonIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOpPersonIdDirty();
        }
        return this.oppersonidDirtyFlag;
    }

    /**
     *  重置属性值[操作人]
     */
    public void resetOpPersonId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOpPersonId();
            return;
        }

        this.oppersonidDirtyFlag = false;
        this.oppersonid = null;
    }
    /**
     *  设置属性值[操作人]
     *  @param oppersonname
     */
    public void setOpPersonName(String oppersonname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOpPersonName(oppersonname);
            return;
        }
        if(oppersonname!=null) {
            oppersonname = StringHelper.trimRight(oppersonname);
            if(oppersonname.length()==0) {
                oppersonname = null;
            }
        }
        this.oppersonname = oppersonname;
        this.oppersonnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[操作人]
     */
    public String getOpPersonName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOpPersonName();
        }
        return this.oppersonname;
    }

    /**
     *  获取属性值[操作人]是否修改
     */
    public boolean isOpPersonNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOpPersonNameDirty();
        }
        return this.oppersonnameDirtyFlag;
    }

    /**
     *  重置属性值[操作人]
     */
    public void resetOpPersonName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOpPersonName();
            return;
        }

        this.oppersonnameDirtyFlag = false;
        this.oppersonname = null;
    }
    /**
     *  设置属性值[访问标识]
     *  @param sessionid
     */
    public void setSessionId(String sessionid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSessionId(sessionid);
            return;
        }
        if(sessionid!=null) {
            sessionid = StringHelper.trimRight(sessionid);
            if(sessionid.length()==0) {
                sessionid = null;
            }
        }
        this.sessionid = sessionid;
        this.sessionidDirtyFlag  = true;
    }

    /**
     *  获取属性值[访问标识]
     */
    public String getSessionId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSessionId();
        }
        return this.sessionid;
    }

    /**
     *  获取属性值[访问标识]是否修改
     */
    public boolean isSessionIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSessionIdDirty();
        }
        return this.sessionidDirtyFlag;
    }

    /**
     *  重置属性值[访问标识]
     */
    public void resetSessionId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSessionId();
            return;
        }

        this.sessionidDirtyFlag = false;
        this.sessionid = null;
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
        DataAuditBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DataAuditBase et) {
        et.resetAuditInfo();
        et.resetAuditType();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDataAuditId();
        et.resetDataAuditName();
        et.resetIPAddress();
        et.resetObjectId();
        et.resetObjectType();
        et.resetOpPersonId();
        et.resetOpPersonName();
        et.resetSessionId();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isAuditInfoDirty()) {
            params.put(FIELD_AUDITINFO,getAuditInfo());
        }
        if(!bDirtyOnly || isAuditTypeDirty()) {
            params.put(FIELD_AUDITTYPE,getAuditType());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDataAuditIdDirty()) {
            params.put(FIELD_DATAAUDITID,getDataAuditId());
        }
        if(!bDirtyOnly || isDataAuditNameDirty()) {
            params.put(FIELD_DATAAUDITNAME,getDataAuditName());
        }
        if(!bDirtyOnly || isIPAddressDirty()) {
            params.put(FIELD_IPADDRESS,getIPAddress());
        }
        if(!bDirtyOnly || isObjectIdDirty()) {
            params.put(FIELD_OBJECTID,getObjectId());
        }
        if(!bDirtyOnly || isObjectTypeDirty()) {
            params.put(FIELD_OBJECTTYPE,getObjectType());
        }
        if(!bDirtyOnly || isOpPersonIdDirty()) {
            params.put(FIELD_OPPERSONID,getOpPersonId());
        }
        if(!bDirtyOnly || isOpPersonNameDirty()) {
            params.put(FIELD_OPPERSONNAME,getOpPersonName());
        }
        if(!bDirtyOnly || isSessionIdDirty()) {
            params.put(FIELD_SESSIONID,getSessionId());
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

        return  DataAuditBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DataAuditBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AUDITINFO:
            return et.getAuditInfo();
        case INDEX_AUDITTYPE:
            return et.getAuditType();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATAAUDITID:
            return et.getDataAuditId();
        case INDEX_DATAAUDITNAME:
            return et.getDataAuditName();
        case INDEX_IPADDRESS:
            return et.getIPAddress();
        case INDEX_OBJECTID:
            return et.getObjectId();
        case INDEX_OBJECTTYPE:
            return et.getObjectType();
        case INDEX_OPPERSONID:
            return et.getOpPersonId();
        case INDEX_OPPERSONNAME:
            return et.getOpPersonName();
        case INDEX_SESSIONID:
            return et.getSessionId();
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

        DataAuditBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DataAuditBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_AUDITINFO:
            et.setAuditInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_AUDITTYPE:
            et.setAuditType(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITID:
            et.setDataAuditId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAAUDITNAME:
            et.setDataAuditName(DataObject.getStringValue(obj));
            return ;
        case INDEX_IPADDRESS:
            et.setIPAddress(DataObject.getStringValue(obj));
            return ;
        case INDEX_OBJECTID:
            et.setObjectId(DataObject.getStringValue(obj));
            return ;
        case INDEX_OBJECTTYPE:
            et.setObjectType(DataObject.getStringValue(obj));
            return ;
        case INDEX_OPPERSONID:
            et.setOpPersonId(DataObject.getStringValue(obj));
            return ;
        case INDEX_OPPERSONNAME:
            et.setOpPersonName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SESSIONID:
            et.setSessionId(DataObject.getStringValue(obj));
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

        return  DataAuditBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DataAuditBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AUDITINFO:
            return et.getAuditInfo()==null;
        case INDEX_AUDITTYPE:
            return et.getAuditType()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATAAUDITID:
            return et.getDataAuditId()==null;
        case INDEX_DATAAUDITNAME:
            return et.getDataAuditName()==null;
        case INDEX_IPADDRESS:
            return et.getIPAddress()==null;
        case INDEX_OBJECTID:
            return et.getObjectId()==null;
        case INDEX_OBJECTTYPE:
            return et.getObjectType()==null;
        case INDEX_OPPERSONID:
            return et.getOpPersonId()==null;
        case INDEX_OPPERSONNAME:
            return et.getOpPersonName()==null;
        case INDEX_SESSIONID:
            return et.getSessionId()==null;
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
        return  DataAuditBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DataAuditBase et,int index) throws Exception {

        switch(index) {
        case INDEX_AUDITINFO:
            return et.isAuditInfoDirty();
        case INDEX_AUDITTYPE:
            return et.isAuditTypeDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATAAUDITID:
            return et.isDataAuditIdDirty();
        case INDEX_DATAAUDITNAME:
            return et.isDataAuditNameDirty();
        case INDEX_IPADDRESS:
            return et.isIPAddressDirty();
        case INDEX_OBJECTID:
            return et.isObjectIdDirty();
        case INDEX_OBJECTTYPE:
            return et.isObjectTypeDirty();
        case INDEX_OPPERSONID:
            return et.isOpPersonIdDirty();
        case INDEX_OPPERSONNAME:
            return et.isOpPersonNameDirty();
        case INDEX_SESSIONID:
            return et.isSessionIdDirty();
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
    private static  void fillJSONObject(DataAuditBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAuditInfo()!=null) {
            JSONObjectHelper.put(json,"auditinfo",getJSONValue(et.getAuditInfo()),false);
        }
        if(bIncEmpty||et.getAuditType()!=null) {
            JSONObjectHelper.put(json,"audittype",getJSONValue(et.getAuditType()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDataAuditId()!=null) {
            JSONObjectHelper.put(json,"dataauditid",getJSONValue(et.getDataAuditId()),false);
        }
        if(bIncEmpty||et.getDataAuditName()!=null) {
            JSONObjectHelper.put(json,"dataauditname",getJSONValue(et.getDataAuditName()),false);
        }
        if(bIncEmpty||et.getIPAddress()!=null) {
            JSONObjectHelper.put(json,"ipaddress",getJSONValue(et.getIPAddress()),false);
        }
        if(bIncEmpty||et.getObjectId()!=null) {
            JSONObjectHelper.put(json,"objectid",getJSONValue(et.getObjectId()),false);
        }
        if(bIncEmpty||et.getObjectType()!=null) {
            JSONObjectHelper.put(json,"objecttype",getJSONValue(et.getObjectType()),false);
        }
        if(bIncEmpty||et.getOpPersonId()!=null) {
            JSONObjectHelper.put(json,"oppersonid",getJSONValue(et.getOpPersonId()),false);
        }
        if(bIncEmpty||et.getOpPersonName()!=null) {
            JSONObjectHelper.put(json,"oppersonname",getJSONValue(et.getOpPersonName()),false);
        }
        if(bIncEmpty||et.getSessionId()!=null) {
            JSONObjectHelper.put(json,"sessionid",getJSONValue(et.getSessionId()),false);
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
    private static void fillXmlNode(DataAuditBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getAuditInfo()!=null) {
            Object obj = et.getAuditInfo();
            node.setAttribute("AUDITINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getAuditType()!=null) {
            Object obj = et.getAuditType();
            node.setAttribute("AUDITTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditId()!=null) {
            Object obj = et.getDataAuditId();
            node.setAttribute("DATAAUDITID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataAuditName()!=null) {
            Object obj = et.getDataAuditName();
            node.setAttribute("DATAAUDITNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIPAddress()!=null) {
            Object obj = et.getIPAddress();
            node.setAttribute("IPADDRESS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getObjectId()!=null) {
            Object obj = et.getObjectId();
            node.setAttribute("OBJECTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getObjectType()!=null) {
            Object obj = et.getObjectType();
            node.setAttribute("OBJECTTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOpPersonId()!=null) {
            Object obj = et.getOpPersonId();
            node.setAttribute("OPPERSONID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOpPersonName()!=null) {
            Object obj = et.getOpPersonName();
            node.setAttribute("OPPERSONNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSessionId()!=null) {
            Object obj = et.getSessionId();
            node.setAttribute("SESSIONID",(obj==null)?"":(String)obj);
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
        DataAuditBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DataAuditBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isAuditInfoDirty() && (bIncEmpty||et.getAuditInfo()!=null)) {
            dst.set(FIELD_AUDITINFO,et.getAuditInfo());
        }
        if(et.isAuditTypeDirty() && (bIncEmpty||et.getAuditType()!=null)) {
            dst.set(FIELD_AUDITTYPE,et.getAuditType());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataAuditIdDirty() && (bIncEmpty||et.getDataAuditId()!=null)) {
            dst.set(FIELD_DATAAUDITID,et.getDataAuditId());
        }
        if(et.isDataAuditNameDirty() && (bIncEmpty||et.getDataAuditName()!=null)) {
            dst.set(FIELD_DATAAUDITNAME,et.getDataAuditName());
        }
        if(et.isIPAddressDirty() && (bIncEmpty||et.getIPAddress()!=null)) {
            dst.set(FIELD_IPADDRESS,et.getIPAddress());
        }
        if(et.isObjectIdDirty() && (bIncEmpty||et.getObjectId()!=null)) {
            dst.set(FIELD_OBJECTID,et.getObjectId());
        }
        if(et.isObjectTypeDirty() && (bIncEmpty||et.getObjectType()!=null)) {
            dst.set(FIELD_OBJECTTYPE,et.getObjectType());
        }
        if(et.isOpPersonIdDirty() && (bIncEmpty||et.getOpPersonId()!=null)) {
            dst.set(FIELD_OPPERSONID,et.getOpPersonId());
        }
        if(et.isOpPersonNameDirty() && (bIncEmpty||et.getOpPersonName()!=null)) {
            dst.set(FIELD_OPPERSONNAME,et.getOpPersonName());
        }
        if(et.isSessionIdDirty() && (bIncEmpty||et.getSessionId()!=null)) {
            dst.set(FIELD_SESSIONID,et.getSessionId());
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
        return  DataAuditBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DataAuditBase et,int index) throws Exception {
        switch(index) {
        case INDEX_AUDITINFO:
            et.resetAuditInfo();
            return true;
        case INDEX_AUDITTYPE:
            et.resetAuditType();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATAAUDITID:
            et.resetDataAuditId();
            return true;
        case INDEX_DATAAUDITNAME:
            et.resetDataAuditName();
            return true;
        case INDEX_IPADDRESS:
            et.resetIPAddress();
            return true;
        case INDEX_OBJECTID:
            et.resetObjectId();
            return true;
        case INDEX_OBJECTTYPE:
            et.resetObjectType();
            return true;
        case INDEX_OPPERSONID:
            et.resetOpPersonId();
            return true;
        case INDEX_OPPERSONNAME:
            et.resetOpPersonName();
            return true;
        case INDEX_SESSIONID:
            et.resetSessionId();
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
    private DataAuditBase getProxyEntity() {
        return this.proxyDataAuditBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataAuditBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DataAuditBase) {
            this.proxyDataAuditBase = (DataAuditBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataAuditService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}