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
 * 实体[Service] 数据对象基类
 */
public abstract class ServiceBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(ServiceBase.class);
    /**
     * 属性[服务容器]
     */
    public final static String FIELD_CONTAINER = "CONTAINER";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[错误信息]
     */
    public final static String FIELD_ERRORINFO = "ERRORINFO";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[服务次序]
     */
    public final static String FIELD_RUNORDER = "RUNORDER";
    /**
     * 属性[服务标识]
     */
    public final static String FIELD_SERVICEID = "SERVICEID";
    /**
     * 属性[服务名称]
     */
    public final static String FIELD_SERVICENAME = "SERVICENAME";
    /**
     * 属性[服务对象]
     */
    public final static String FIELD_SERVICEOBJECT = "SERVICEOBJECT";
    /**
     * 属性[服务参数]
     */
    public final static String FIELD_SERVICEPARAM = "SERVICEPARAM";
    /**
     * 属性[服务运行状态]
     */
    public final static String FIELD_SERVICESTATE = "SERVICESTATE";
    /**
     * 属性[启动模式]
     */
    public final static String FIELD_STARTMODE = "STARTMODE";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CONTAINER = 0;
    private final static int INDEX_CREATEDATE = 1;
    private final static int INDEX_CREATEMAN = 2;
    private final static int INDEX_ERRORINFO = 3;
    private final static int INDEX_MEMO = 4;
    private final static int INDEX_RESERVER = 5;
    private final static int INDEX_RUNORDER = 6;
    private final static int INDEX_SERVICEID = 7;
    private final static int INDEX_SERVICENAME = 8;
    private final static int INDEX_SERVICEOBJECT = 9;
    private final static int INDEX_SERVICEPARAM = 10;
    private final static int INDEX_SERVICESTATE = 11;
    private final static int INDEX_STARTMODE = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CONTAINER, INDEX_CONTAINER);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ERRORINFO, INDEX_ERRORINFO);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RUNORDER, INDEX_RUNORDER);
        fieldIndexMap.put( FIELD_SERVICEID, INDEX_SERVICEID);
        fieldIndexMap.put( FIELD_SERVICENAME, INDEX_SERVICENAME);
        fieldIndexMap.put( FIELD_SERVICEOBJECT, INDEX_SERVICEOBJECT);
        fieldIndexMap.put( FIELD_SERVICEPARAM, INDEX_SERVICEPARAM);
        fieldIndexMap.put( FIELD_SERVICESTATE, INDEX_SERVICESTATE);
        fieldIndexMap.put( FIELD_STARTMODE, INDEX_STARTMODE);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private ServiceBase proxyServiceBase = null;
    public ServiceBase() {
        super();
    }
    private boolean containerDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean errorinfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean runorderDirtyFlag = false;
    private boolean serviceidDirtyFlag = false;
    private boolean servicenameDirtyFlag = false;
    private boolean serviceobjectDirtyFlag = false;
    private boolean serviceparamDirtyFlag = false;
    private boolean servicestateDirtyFlag = false;
    private boolean startmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="container")
    private String container;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="errorinfo")
    private String errorinfo;
    @Column(name="memo")
    private String memo;
    @Column(name="reserver")
    private String reserver;
    @Column(name="runorder")
    private Integer runorder;
    @Column(name="serviceid")
    private String serviceid;
    @Column(name="servicename")
    private String servicename;
    @Column(name="serviceobject")
    private String serviceobject;
    @Column(name="serviceparam")
    private String serviceparam;
    @Column(name="servicestate")
    private String servicestate;
    @Column(name="startmode")
    private String startmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


    /**
     *  设置属性值[服务容器]代码表：net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel
     *  @param container
     */
    public void setContainer(String container) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setContainer(container);
            return;
        }
        if(container!=null) {
            container = StringHelper.trimRight(container);
            if(container.length()==0) {
                container = null;
            }
        }
        this.container = container;
        this.containerDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务容器]代码表：net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel
     */
    public String getContainer() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getContainer();
        }
        return this.container;
    }

    /**
     *  获取属性值[服务容器]是否修改
     */
    public boolean isContainerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isContainerDirty();
        }
        return this.containerDirtyFlag;
    }

    /**
     *  重置属性值[服务容器]
     */
    public void resetContainer() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetContainer();
            return;
        }

        this.containerDirtyFlag = false;
        this.container = null;
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
     *  设置属性值[错误信息]
     *  @param errorinfo
     */
    public void setErrorInfo(String errorinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setErrorInfo(errorinfo);
            return;
        }
        if(errorinfo!=null) {
            errorinfo = StringHelper.trimRight(errorinfo);
            if(errorinfo.length()==0) {
                errorinfo = null;
            }
        }
        this.errorinfo = errorinfo;
        this.errorinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[错误信息]
     */
    public String getErrorInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    /**
     *  获取属性值[错误信息]是否修改
     */
    public boolean isErrorInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    /**
     *  重置属性值[错误信息]
     */
    public void resetErrorInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }

        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
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
     *  设置属性值[服务次序]
     *  @param runorder
     */
    public void setRunOrder(Integer runorder) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRunOrder(runorder);
            return;
        }
        this.runorder = runorder;
        this.runorderDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务次序]
     */
    public Integer getRunOrder() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRunOrder();
        }
        return this.runorder;
    }

    /**
     *  获取属性值[服务次序]是否修改
     */
    public boolean isRunOrderDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRunOrderDirty();
        }
        return this.runorderDirtyFlag;
    }

    /**
     *  重置属性值[服务次序]
     */
    public void resetRunOrder() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRunOrder();
            return;
        }

        this.runorderDirtyFlag = false;
        this.runorder = null;
    }
    /**
     *  设置属性值[服务标识]
     *  @param serviceid
     */
    public void setServiceId(String serviceid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceId(serviceid);
            return;
        }
        if(serviceid!=null) {
            serviceid = StringHelper.trimRight(serviceid);
            if(serviceid.length()==0) {
                serviceid = null;
            }
        }
        this.serviceid = serviceid;
        this.serviceidDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务标识]
     */
    public String getServiceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceId();
        }
        return this.serviceid;
    }

    /**
     *  获取属性值[服务标识]是否修改
     */
    public boolean isServiceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceIdDirty();
        }
        return this.serviceidDirtyFlag;
    }

    /**
     *  重置属性值[服务标识]
     */
    public void resetServiceId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceId();
            return;
        }

        this.serviceidDirtyFlag = false;
        this.serviceid = null;
    }
    /**
     *  设置属性值[服务名称]
     *  @param servicename
     */
    public void setServiceName(String servicename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceName(servicename);
            return;
        }
        if(servicename!=null) {
            servicename = StringHelper.trimRight(servicename);
            if(servicename.length()==0) {
                servicename = null;
            }
        }
        this.servicename = servicename;
        this.servicenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务名称]
     */
    public String getServiceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceName();
        }
        return this.servicename;
    }

    /**
     *  获取属性值[服务名称]是否修改
     */
    public boolean isServiceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceNameDirty();
        }
        return this.servicenameDirtyFlag;
    }

    /**
     *  重置属性值[服务名称]
     */
    public void resetServiceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceName();
            return;
        }

        this.servicenameDirtyFlag = false;
        this.servicename = null;
    }
    /**
     *  设置属性值[服务对象]
     *  @param serviceobject
     */
    public void setServiceObject(String serviceobject) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceObject(serviceobject);
            return;
        }
        if(serviceobject!=null) {
            serviceobject = StringHelper.trimRight(serviceobject);
            if(serviceobject.length()==0) {
                serviceobject = null;
            }
        }
        this.serviceobject = serviceobject;
        this.serviceobjectDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务对象]
     */
    public String getServiceObject() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceObject();
        }
        return this.serviceobject;
    }

    /**
     *  获取属性值[服务对象]是否修改
     */
    public boolean isServiceObjectDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceObjectDirty();
        }
        return this.serviceobjectDirtyFlag;
    }

    /**
     *  重置属性值[服务对象]
     */
    public void resetServiceObject() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceObject();
            return;
        }

        this.serviceobjectDirtyFlag = false;
        this.serviceobject = null;
    }
    /**
     *  设置属性值[服务参数]
     *  @param serviceparam
     */
    public void setServiceParam(String serviceparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceParam(serviceparam);
            return;
        }
        if(serviceparam!=null) {
            serviceparam = StringHelper.trimRight(serviceparam);
            if(serviceparam.length()==0) {
                serviceparam = null;
            }
        }
        this.serviceparam = serviceparam;
        this.serviceparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务参数]
     */
    public String getServiceParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    /**
     *  获取属性值[服务参数]是否修改
     */
    public boolean isServiceParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    /**
     *  重置属性值[服务参数]
     */
    public void resetServiceParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }

        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }
    /**
     *  设置属性值[服务运行状态]代码表：net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel
     *  @param servicestate
     */
    public void setServiceState(String servicestate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setServiceState(servicestate);
            return;
        }
        if(servicestate!=null) {
            servicestate = StringHelper.trimRight(servicestate);
            if(servicestate.length()==0) {
                servicestate = null;
            }
        }
        this.servicestate = servicestate;
        this.servicestateDirtyFlag  = true;
    }

    /**
     *  获取属性值[服务运行状态]代码表：net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel
     */
    public String getServiceState() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getServiceState();
        }
        return this.servicestate;
    }

    /**
     *  获取属性值[服务运行状态]是否修改
     */
    public boolean isServiceStateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isServiceStateDirty();
        }
        return this.servicestateDirtyFlag;
    }

    /**
     *  重置属性值[服务运行状态]
     */
    public void resetServiceState() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetServiceState();
            return;
        }

        this.servicestateDirtyFlag = false;
        this.servicestate = null;
    }
    /**
     *  设置属性值[启动模式]代码表：net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel
     *  @param startmode
     */
    public void setStartMode(String startmode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setStartMode(startmode);
            return;
        }
        if(startmode!=null) {
            startmode = StringHelper.trimRight(startmode);
            if(startmode.length()==0) {
                startmode = null;
            }
        }
        this.startmode = startmode;
        this.startmodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[启动模式]代码表：net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel
     */
    public String getStartMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getStartMode();
        }
        return this.startmode;
    }

    /**
     *  获取属性值[启动模式]是否修改
     */
    public boolean isStartModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isStartModeDirty();
        }
        return this.startmodeDirtyFlag;
    }

    /**
     *  重置属性值[启动模式]
     */
    public void resetStartMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetStartMode();
            return;
        }

        this.startmodeDirtyFlag = false;
        this.startmode = null;
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
        ServiceBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(ServiceBase et) {
        et.resetContainer();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetErrorInfo();
        et.resetMemo();
        et.resetReserver();
        et.resetRunOrder();
        et.resetServiceId();
        et.resetServiceName();
        et.resetServiceObject();
        et.resetServiceParam();
        et.resetServiceState();
        et.resetStartMode();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isContainerDirty()) {
            params.put(FIELD_CONTAINER,getContainer());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isErrorInfoDirty()) {
            params.put(FIELD_ERRORINFO,getErrorInfo());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isRunOrderDirty()) {
            params.put(FIELD_RUNORDER,getRunOrder());
        }
        if(!bDirtyOnly || isServiceIdDirty()) {
            params.put(FIELD_SERVICEID,getServiceId());
        }
        if(!bDirtyOnly || isServiceNameDirty()) {
            params.put(FIELD_SERVICENAME,getServiceName());
        }
        if(!bDirtyOnly || isServiceObjectDirty()) {
            params.put(FIELD_SERVICEOBJECT,getServiceObject());
        }
        if(!bDirtyOnly || isServiceParamDirty()) {
            params.put(FIELD_SERVICEPARAM,getServiceParam());
        }
        if(!bDirtyOnly || isServiceStateDirty()) {
            params.put(FIELD_SERVICESTATE,getServiceState());
        }
        if(!bDirtyOnly || isStartModeDirty()) {
            params.put(FIELD_STARTMODE,getStartMode());
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

        return  ServiceBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(ServiceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTAINER:
            return et.getContainer();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ERRORINFO:
            return et.getErrorInfo();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RUNORDER:
            return et.getRunOrder();
        case INDEX_SERVICEID:
            return et.getServiceId();
        case INDEX_SERVICENAME:
            return et.getServiceName();
        case INDEX_SERVICEOBJECT:
            return et.getServiceObject();
        case INDEX_SERVICEPARAM:
            return et.getServiceParam();
        case INDEX_SERVICESTATE:
            return et.getServiceState();
        case INDEX_STARTMODE:
            return et.getStartMode();
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

        ServiceBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(ServiceBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CONTAINER:
            et.setContainer(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ERRORINFO:
            et.setErrorInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RUNORDER:
            et.setRunOrder(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SERVICEID:
            et.setServiceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICENAME:
            et.setServiceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICEOBJECT:
            et.setServiceObject(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICEPARAM:
            et.setServiceParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_SERVICESTATE:
            et.setServiceState(DataObject.getStringValue(obj));
            return ;
        case INDEX_STARTMODE:
            et.setStartMode(DataObject.getStringValue(obj));
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

        return  ServiceBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(ServiceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTAINER:
            return et.getContainer()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ERRORINFO:
            return et.getErrorInfo()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RUNORDER:
            return et.getRunOrder()==null;
        case INDEX_SERVICEID:
            return et.getServiceId()==null;
        case INDEX_SERVICENAME:
            return et.getServiceName()==null;
        case INDEX_SERVICEOBJECT:
            return et.getServiceObject()==null;
        case INDEX_SERVICEPARAM:
            return et.getServiceParam()==null;
        case INDEX_SERVICESTATE:
            return et.getServiceState()==null;
        case INDEX_STARTMODE:
            return et.getStartMode()==null;
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
        return  ServiceBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(ServiceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CONTAINER:
            return et.isContainerDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ERRORINFO:
            return et.isErrorInfoDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RUNORDER:
            return et.isRunOrderDirty();
        case INDEX_SERVICEID:
            return et.isServiceIdDirty();
        case INDEX_SERVICENAME:
            return et.isServiceNameDirty();
        case INDEX_SERVICEOBJECT:
            return et.isServiceObjectDirty();
        case INDEX_SERVICEPARAM:
            return et.isServiceParamDirty();
        case INDEX_SERVICESTATE:
            return et.isServiceStateDirty();
        case INDEX_STARTMODE:
            return et.isStartModeDirty();
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
    private static  void fillJSONObject(ServiceBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getContainer()!=null) {
            JSONObjectHelper.put(json,"container",getJSONValue(et.getContainer()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getErrorInfo()!=null) {
            JSONObjectHelper.put(json,"errorinfo",getJSONValue(et.getErrorInfo()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getRunOrder()!=null) {
            JSONObjectHelper.put(json,"runorder",getJSONValue(et.getRunOrder()),false);
        }
        if(bIncEmpty||et.getServiceId()!=null) {
            JSONObjectHelper.put(json,"serviceid",getJSONValue(et.getServiceId()),false);
        }
        if(bIncEmpty||et.getServiceName()!=null) {
            JSONObjectHelper.put(json,"servicename",getJSONValue(et.getServiceName()),false);
        }
        if(bIncEmpty||et.getServiceObject()!=null) {
            JSONObjectHelper.put(json,"serviceobject",getJSONValue(et.getServiceObject()),false);
        }
        if(bIncEmpty||et.getServiceParam()!=null) {
            JSONObjectHelper.put(json,"serviceparam",getJSONValue(et.getServiceParam()),false);
        }
        if(bIncEmpty||et.getServiceState()!=null) {
            JSONObjectHelper.put(json,"servicestate",getJSONValue(et.getServiceState()),false);
        }
        if(bIncEmpty||et.getStartMode()!=null) {
            JSONObjectHelper.put(json,"startmode",getJSONValue(et.getStartMode()),false);
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
    private static void fillXmlNode(ServiceBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getContainer()!=null) {
            Object obj = et.getContainer();
            node.setAttribute("CONTAINER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getErrorInfo()!=null) {
            Object obj = et.getErrorInfo();
            node.setAttribute("ERRORINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRunOrder()!=null) {
            Object obj = et.getRunOrder();
            node.setAttribute("RUNORDER",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getServiceId()!=null) {
            Object obj = et.getServiceId();
            node.setAttribute("SERVICEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServiceName()!=null) {
            Object obj = et.getServiceName();
            node.setAttribute("SERVICENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServiceObject()!=null) {
            Object obj = et.getServiceObject();
            node.setAttribute("SERVICEOBJECT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServiceParam()!=null) {
            Object obj = et.getServiceParam();
            node.setAttribute("SERVICEPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getServiceState()!=null) {
            Object obj = et.getServiceState();
            node.setAttribute("SERVICESTATE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getStartMode()!=null) {
            Object obj = et.getStartMode();
            node.setAttribute("STARTMODE",(obj==null)?"":(String)obj);
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
        ServiceBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(ServiceBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isContainerDirty() && (bIncEmpty||et.getContainer()!=null)) {
            dst.set(FIELD_CONTAINER,et.getContainer());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isErrorInfoDirty() && (bIncEmpty||et.getErrorInfo()!=null)) {
            dst.set(FIELD_ERRORINFO,et.getErrorInfo());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isRunOrderDirty() && (bIncEmpty||et.getRunOrder()!=null)) {
            dst.set(FIELD_RUNORDER,et.getRunOrder());
        }
        if(et.isServiceIdDirty() && (bIncEmpty||et.getServiceId()!=null)) {
            dst.set(FIELD_SERVICEID,et.getServiceId());
        }
        if(et.isServiceNameDirty() && (bIncEmpty||et.getServiceName()!=null)) {
            dst.set(FIELD_SERVICENAME,et.getServiceName());
        }
        if(et.isServiceObjectDirty() && (bIncEmpty||et.getServiceObject()!=null)) {
            dst.set(FIELD_SERVICEOBJECT,et.getServiceObject());
        }
        if(et.isServiceParamDirty() && (bIncEmpty||et.getServiceParam()!=null)) {
            dst.set(FIELD_SERVICEPARAM,et.getServiceParam());
        }
        if(et.isServiceStateDirty() && (bIncEmpty||et.getServiceState()!=null)) {
            dst.set(FIELD_SERVICESTATE,et.getServiceState());
        }
        if(et.isStartModeDirty() && (bIncEmpty||et.getStartMode()!=null)) {
            dst.set(FIELD_STARTMODE,et.getStartMode());
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
        return  ServiceBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(ServiceBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CONTAINER:
            et.resetContainer();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ERRORINFO:
            et.resetErrorInfo();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RUNORDER:
            et.resetRunOrder();
            return true;
        case INDEX_SERVICEID:
            et.resetServiceId();
            return true;
        case INDEX_SERVICENAME:
            et.resetServiceName();
            return true;
        case INDEX_SERVICEOBJECT:
            et.resetServiceObject();
            return true;
        case INDEX_SERVICEPARAM:
            et.resetServiceParam();
            return true;
        case INDEX_SERVICESTATE:
            et.resetServiceState();
            return true;
        case INDEX_STARTMODE:
            et.resetStartMode();
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
    private ServiceBase getProxyEntity() {
        return this.proxyServiceBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyServiceBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof ServiceBase) {
            this.proxyServiceBase = (ServiceBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.ServiceService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}