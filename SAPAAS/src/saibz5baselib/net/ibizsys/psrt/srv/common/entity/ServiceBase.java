/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ServiceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(ServiceBase.class);
    public static final String FIELD_CONTAINER = "CONTAINER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ERRORINFO = "ERRORINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RUNORDER = "RUNORDER";
    public static final String FIELD_SERVICEID = "SERVICEID";
    public static final String FIELD_SERVICENAME = "SERVICENAME";
    public static final String FIELD_SERVICEOBJECT = "SERVICEOBJECT";
    public static final String FIELD_SERVICEPARAM = "SERVICEPARAM";
    public static final String FIELD_SERVICESTATE = "SERVICESTATE";
    public static final String FIELD_STARTMODE = "STARTMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTAINER = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ERRORINFO = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_RESERVER = 5;
    private static final int INDEX_RUNORDER = 6;
    private static final int INDEX_SERVICEID = 7;
    private static final int INDEX_SERVICENAME = 8;
    private static final int INDEX_SERVICEOBJECT = 9;
    private static final int INDEX_SERVICEPARAM = 10;
    private static final int INDEX_SERVICESTATE = 11;
    private static final int INDEX_STARTMODE = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private ServiceBase proxyServiceBase = null;
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

    static {
        fieldIndexMap.put(FIELD_CONTAINER, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ERRORINFO, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_RESERVER, 5);
        fieldIndexMap.put(FIELD_RUNORDER, 6);
        fieldIndexMap.put(FIELD_SERVICEID, 7);
        fieldIndexMap.put(FIELD_SERVICENAME, 8);
        fieldIndexMap.put(FIELD_SERVICEOBJECT, 9);
        fieldIndexMap.put(FIELD_SERVICEPARAM, 10);
        fieldIndexMap.put(FIELD_SERVICESTATE, 11);
        fieldIndexMap.put(FIELD_STARTMODE, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }

    public void setContainer(String container) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContainer(container);
            return;
        }
        if (container != null && (container = StringHelper.trimRight(container)).length() == 0) {
            container = null;
        }
        this.container = container;
        this.containerDirtyFlag = true;
    }

    public String getContainer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContainer();
        }
        return this.container;
    }

    public boolean isContainerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContainerDirty();
        }
        return this.containerDirtyFlag;
    }

    public void resetContainer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContainer();
            return;
        }
        this.containerDirtyFlag = false;
        this.container = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setErrorInfo(String errorinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorInfo(errorinfo);
            return;
        }
        if (errorinfo != null && (errorinfo = StringHelper.trimRight(errorinfo)).length() == 0) {
            errorinfo = null;
        }
        this.errorinfo = errorinfo;
        this.errorinfoDirtyFlag = true;
    }

    public String getErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    public boolean isErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    public void resetErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }
        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setRunOrder(Integer runorder) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunOrder(runorder);
            return;
        }
        this.runorder = runorder;
        this.runorderDirtyFlag = true;
    }

    public Integer getRunOrder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunOrder();
        }
        return this.runorder;
    }

    public boolean isRunOrderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunOrderDirty();
        }
        return this.runorderDirtyFlag;
    }

    public void resetRunOrder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunOrder();
            return;
        }
        this.runorderDirtyFlag = false;
        this.runorder = null;
    }

    public void setServiceId(String serviceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceId(serviceid);
            return;
        }
        if (serviceid != null && (serviceid = StringHelper.trimRight(serviceid)).length() == 0) {
            serviceid = null;
        }
        this.serviceid = serviceid;
        this.serviceidDirtyFlag = true;
    }

    public String getServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceId();
        }
        return this.serviceid;
    }

    public boolean isServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceIdDirty();
        }
        return this.serviceidDirtyFlag;
    }

    public void resetServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceId();
            return;
        }
        this.serviceidDirtyFlag = false;
        this.serviceid = null;
    }

    public void setServiceName(String servicename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceName(servicename);
            return;
        }
        if (servicename != null && (servicename = StringHelper.trimRight(servicename)).length() == 0) {
            servicename = null;
        }
        this.servicename = servicename;
        this.servicenameDirtyFlag = true;
    }

    public String getServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceName();
        }
        return this.servicename;
    }

    public boolean isServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceNameDirty();
        }
        return this.servicenameDirtyFlag;
    }

    public void resetServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceName();
            return;
        }
        this.servicenameDirtyFlag = false;
        this.servicename = null;
    }

    public void setServiceObject(String serviceobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceObject(serviceobject);
            return;
        }
        if (serviceobject != null && (serviceobject = StringHelper.trimRight(serviceobject)).length() == 0) {
            serviceobject = null;
        }
        this.serviceobject = serviceobject;
        this.serviceobjectDirtyFlag = true;
    }

    public String getServiceObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceObject();
        }
        return this.serviceobject;
    }

    public boolean isServiceObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceObjectDirty();
        }
        return this.serviceobjectDirtyFlag;
    }

    public void resetServiceObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceObject();
            return;
        }
        this.serviceobjectDirtyFlag = false;
        this.serviceobject = null;
    }

    public void setServiceParam(String serviceparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceParam(serviceparam);
            return;
        }
        if (serviceparam != null && (serviceparam = StringHelper.trimRight(serviceparam)).length() == 0) {
            serviceparam = null;
        }
        this.serviceparam = serviceparam;
        this.serviceparamDirtyFlag = true;
    }

    public String getServiceParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceParam();
        }
        return this.serviceparam;
    }

    public boolean isServiceParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceParamDirty();
        }
        return this.serviceparamDirtyFlag;
    }

    public void resetServiceParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceParam();
            return;
        }
        this.serviceparamDirtyFlag = false;
        this.serviceparam = null;
    }

    public void setServiceState(String servicestate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceState(servicestate);
            return;
        }
        if (servicestate != null && (servicestate = StringHelper.trimRight(servicestate)).length() == 0) {
            servicestate = null;
        }
        this.servicestate = servicestate;
        this.servicestateDirtyFlag = true;
    }

    public String getServiceState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceState();
        }
        return this.servicestate;
    }

    public boolean isServiceStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceStateDirty();
        }
        return this.servicestateDirtyFlag;
    }

    public void resetServiceState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceState();
            return;
        }
        this.servicestateDirtyFlag = false;
        this.servicestate = null;
    }

    public void setStartMode(String startmode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartMode(startmode);
            return;
        }
        if (startmode != null && (startmode = StringHelper.trimRight(startmode)).length() == 0) {
            startmode = null;
        }
        this.startmode = startmode;
        this.startmodeDirtyFlag = true;
    }

    public String getStartMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartMode();
        }
        return this.startmode;
    }

    public boolean isStartModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartModeDirty();
        }
        return this.startmodeDirtyFlag;
    }

    public void resetStartMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartMode();
            return;
        }
        this.startmodeDirtyFlag = false;
        this.startmode = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    @Override
    protected void onReset() {
        ServiceBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isContainerDirty()) {
            params.put(FIELD_CONTAINER, this.getContainer());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isErrorInfoDirty()) {
            params.put(FIELD_ERRORINFO, this.getErrorInfo());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isRunOrderDirty()) {
            params.put(FIELD_RUNORDER, this.getRunOrder());
        }
        if (!bDirtyOnly || this.isServiceIdDirty()) {
            params.put(FIELD_SERVICEID, this.getServiceId());
        }
        if (!bDirtyOnly || this.isServiceNameDirty()) {
            params.put(FIELD_SERVICENAME, this.getServiceName());
        }
        if (!bDirtyOnly || this.isServiceObjectDirty()) {
            params.put(FIELD_SERVICEOBJECT, this.getServiceObject());
        }
        if (!bDirtyOnly || this.isServiceParamDirty()) {
            params.put(FIELD_SERVICEPARAM, this.getServiceParam());
        }
        if (!bDirtyOnly || this.isServiceStateDirty()) {
            params.put(FIELD_SERVICESTATE, this.getServiceState());
        }
        if (!bDirtyOnly || this.isStartModeDirty()) {
            params.put(FIELD_STARTMODE, this.getStartMode());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return ServiceBase.get(this, index);
    }

    private static Object get(ServiceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContainer();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getErrorInfo();
            }
            case 4: {
                return et.getMemo();
            }
            case 5: {
                return et.getReserver();
            }
            case 6: {
                return et.getRunOrder();
            }
            case 7: {
                return et.getServiceId();
            }
            case 8: {
                return et.getServiceName();
            }
            case 9: {
                return et.getServiceObject();
            }
            case 10: {
                return et.getServiceParam();
            }
            case 11: {
                return et.getServiceState();
            }
            case 12: {
                return et.getStartMode();
            }
            case 13: {
                return et.getUpdateDate();
            }
            case 14: {
                return et.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        ServiceBase.set(this, index, objValue);
    }

    private static void set(ServiceBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setContainer(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setErrorInfo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setRunOrder(DataObject.getIntegerValue(obj));
                return;
            }
            case 7: {
                et.setServiceId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setServiceName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setServiceObject(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setServiceParam(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setServiceState(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setStartMode(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 14: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return ServiceBase.isNull(this, index);
    }

    private static boolean isNull(ServiceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getContainer() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getErrorInfo() == null;
            }
            case 4: {
                return et.getMemo() == null;
            }
            case 5: {
                return et.getReserver() == null;
            }
            case 6: {
                return et.getRunOrder() == null;
            }
            case 7: {
                return et.getServiceId() == null;
            }
            case 8: {
                return et.getServiceName() == null;
            }
            case 9: {
                return et.getServiceObject() == null;
            }
            case 10: {
                return et.getServiceParam() == null;
            }
            case 11: {
                return et.getServiceState() == null;
            }
            case 12: {
                return et.getStartMode() == null;
            }
            case 13: {
                return et.getUpdateDate() == null;
            }
            case 14: {
                return et.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return ServiceBase.contains(this, index);
    }

    private static boolean contains(ServiceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isContainerDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isErrorInfoDirty();
            }
            case 4: {
                return et.isMemoDirty();
            }
            case 5: {
                return et.isReserverDirty();
            }
            case 6: {
                return et.isRunOrderDirty();
            }
            case 7: {
                return et.isServiceIdDirty();
            }
            case 8: {
                return et.isServiceNameDirty();
            }
            case 9: {
                return et.isServiceObjectDirty();
            }
            case 10: {
                return et.isServiceParamDirty();
            }
            case 11: {
                return et.isServiceStateDirty();
            }
            case 12: {
                return et.isStartModeDirty();
            }
            case 13: {
                return et.isUpdateDateDirty();
            }
            case 14: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        ServiceBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(ServiceBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getContainer() != null) {
            JSONObjectHelper.put(json, "container", ServiceBase.getJSONValue(et.getContainer()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", ServiceBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", ServiceBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            JSONObjectHelper.put(json, "errorinfo", ServiceBase.getJSONValue(et.getErrorInfo()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", ServiceBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", ServiceBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getRunOrder() != null) {
            JSONObjectHelper.put(json, "runorder", ServiceBase.getJSONValue(et.getRunOrder()), false);
        }
        if (bIncEmpty || et.getServiceId() != null) {
            JSONObjectHelper.put(json, "serviceid", ServiceBase.getJSONValue(et.getServiceId()), false);
        }
        if (bIncEmpty || et.getServiceName() != null) {
            JSONObjectHelper.put(json, "servicename", ServiceBase.getJSONValue(et.getServiceName()), false);
        }
        if (bIncEmpty || et.getServiceObject() != null) {
            JSONObjectHelper.put(json, "serviceobject", ServiceBase.getJSONValue(et.getServiceObject()), false);
        }
        if (bIncEmpty || et.getServiceParam() != null) {
            JSONObjectHelper.put(json, "serviceparam", ServiceBase.getJSONValue(et.getServiceParam()), false);
        }
        if (bIncEmpty || et.getServiceState() != null) {
            JSONObjectHelper.put(json, "servicestate", ServiceBase.getJSONValue(et.getServiceState()), false);
        }
        if (bIncEmpty || et.getStartMode() != null) {
            JSONObjectHelper.put(json, "startmode", ServiceBase.getJSONValue(et.getStartMode()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", ServiceBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", ServiceBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        ServiceBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(ServiceBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getContainer() != null) {
            obj = et.getContainer();
            node.setAttribute(FIELD_CONTAINER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            obj = et.getErrorInfo();
            node.setAttribute(FIELD_ERRORINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRunOrder() != null) {
            obj = et.getRunOrder();
            node.setAttribute(FIELD_RUNORDER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getServiceId() != null) {
            obj = et.getServiceId();
            node.setAttribute(FIELD_SERVICEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServiceName() != null) {
            obj = et.getServiceName();
            node.setAttribute(FIELD_SERVICENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServiceObject() != null) {
            obj = et.getServiceObject();
            node.setAttribute(FIELD_SERVICEOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServiceParam() != null) {
            obj = et.getServiceParam();
            node.setAttribute(FIELD_SERVICEPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getServiceState() != null) {
            obj = et.getServiceState();
            node.setAttribute(FIELD_SERVICESTATE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getStartMode() != null) {
            obj = et.getStartMode();
            node.setAttribute(FIELD_STARTMODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        ServiceBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(ServiceBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isContainerDirty() && (bIncEmpty || et.getContainer() != null)) {
            dst.set(FIELD_CONTAINER, et.getContainer());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isErrorInfoDirty() && (bIncEmpty || et.getErrorInfo() != null)) {
            dst.set(FIELD_ERRORINFO, et.getErrorInfo());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isRunOrderDirty() && (bIncEmpty || et.getRunOrder() != null)) {
            dst.set(FIELD_RUNORDER, et.getRunOrder());
        }
        if (et.isServiceIdDirty() && (bIncEmpty || et.getServiceId() != null)) {
            dst.set(FIELD_SERVICEID, et.getServiceId());
        }
        if (et.isServiceNameDirty() && (bIncEmpty || et.getServiceName() != null)) {
            dst.set(FIELD_SERVICENAME, et.getServiceName());
        }
        if (et.isServiceObjectDirty() && (bIncEmpty || et.getServiceObject() != null)) {
            dst.set(FIELD_SERVICEOBJECT, et.getServiceObject());
        }
        if (et.isServiceParamDirty() && (bIncEmpty || et.getServiceParam() != null)) {
            dst.set(FIELD_SERVICEPARAM, et.getServiceParam());
        }
        if (et.isServiceStateDirty() && (bIncEmpty || et.getServiceState() != null)) {
            dst.set(FIELD_SERVICESTATE, et.getServiceState());
        }
        if (et.isStartModeDirty() && (bIncEmpty || et.getStartMode() != null)) {
            dst.set(FIELD_STARTMODE, et.getStartMode());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return ServiceBase.remove(this, index);
    }

    private static boolean remove(ServiceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetContainer();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetErrorInfo();
                return true;
            }
            case 4: {
                et.resetMemo();
                return true;
            }
            case 5: {
                et.resetReserver();
                return true;
            }
            case 6: {
                et.resetRunOrder();
                return true;
            }
            case 7: {
                et.resetServiceId();
                return true;
            }
            case 8: {
                et.resetServiceName();
                return true;
            }
            case 9: {
                et.resetServiceObject();
                return true;
            }
            case 10: {
                et.resetServiceParam();
                return true;
            }
            case 11: {
                et.resetServiceState();
                return true;
            }
            case 12: {
                et.resetStartMode();
                return true;
            }
            case 13: {
                et.resetUpdateDate();
                return true;
            }
            case 14: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private ServiceBase getProxyEntity() {
        return this.proxyServiceBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyServiceBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof ServiceBase) {
            this.proxyServiceBase = (ServiceBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.ServiceService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

