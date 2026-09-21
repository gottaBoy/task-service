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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataSyncIn2Base
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataSyncIn2Base.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DATAKEY = "DATAKEY";
    public static final String FIELD_DATASYNCIN2ID = "DATASYNCIN2ID";
    public static final String FIELD_DATASYNCIN2NAME = "DATASYNCIN2NAME";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_ERROR = "ERROR";
    public static final String FIELD_EVENTTYPE = "EVENTTYPE";
    public static final String FIELD_FILEFLAG = "FILEFLAG";
    public static final String FIELD_LOGICDATA = "LOGICDATA";
    public static final String FIELD_SYNCAGENT = "SYNCAGENT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATA = 2;
    private static final int INDEX_DATAKEY = 3;
    private static final int INDEX_DATASYNCIN2ID = 4;
    private static final int INDEX_DATASYNCIN2NAME = 5;
    private static final int INDEX_DEID = 6;
    private static final int INDEX_DENAME = 7;
    private static final int INDEX_ERROR = 8;
    private static final int INDEX_EVENTTYPE = 9;
    private static final int INDEX_FILEFLAG = 10;
    private static final int INDEX_LOGICDATA = 11;
    private static final int INDEX_SYNCAGENT = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataSyncIn2Base proxyDataSyncIn2Base = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean datakeyDirtyFlag = false;
    private boolean datasyncin2idDirtyFlag = false;
    private boolean datasyncin2nameDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean errorDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean fileflagDirtyFlag = false;
    private boolean logicdataDirtyFlag = false;
    private boolean syncagentDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="datakey")
    private String datakey;
    @Column(name="datasyncin2id")
    private String datasyncin2id;
    @Column(name="datasyncin2name")
    private String datasyncin2name;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="error")
    private String error;
    @Column(name="eventtype")
    private Integer eventtype;
    @Column(name="fileflag")
    private Integer fileflag;
    @Column(name="logicdata")
    private String logicdata;
    @Column(name="syncagent")
    private String syncagent;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATA, 2);
        fieldIndexMap.put(FIELD_DATAKEY, 3);
        fieldIndexMap.put(FIELD_DATASYNCIN2ID, 4);
        fieldIndexMap.put(FIELD_DATASYNCIN2NAME, 5);
        fieldIndexMap.put(FIELD_DEID, 6);
        fieldIndexMap.put(FIELD_DENAME, 7);
        fieldIndexMap.put(FIELD_ERROR, 8);
        fieldIndexMap.put(FIELD_EVENTTYPE, 9);
        fieldIndexMap.put(FIELD_FILEFLAG, 10);
        fieldIndexMap.put(FIELD_LOGICDATA, 11);
        fieldIndexMap.put(FIELD_SYNCAGENT, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
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

    public void setData(String data) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(data);
            return;
        }
        if (data != null && (data = StringHelper.trimRight(data)).length() == 0) {
            data = null;
        }
        this.data = data;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setDataKey(String datakey) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataKey(datakey);
            return;
        }
        if (datakey != null && (datakey = StringHelper.trimRight(datakey)).length() == 0) {
            datakey = null;
        }
        this.datakey = datakey;
        this.datakeyDirtyFlag = true;
    }

    public String getDataKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataKey();
        }
        return this.datakey;
    }

    public boolean isDataKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataKeyDirty();
        }
        return this.datakeyDirtyFlag;
    }

    public void resetDataKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataKey();
            return;
        }
        this.datakeyDirtyFlag = false;
        this.datakey = null;
    }

    public void setDataSyncIn2Id(String datasyncin2id) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncIn2Id(datasyncin2id);
            return;
        }
        if (datasyncin2id != null && (datasyncin2id = StringHelper.trimRight(datasyncin2id)).length() == 0) {
            datasyncin2id = null;
        }
        this.datasyncin2id = datasyncin2id;
        this.datasyncin2idDirtyFlag = true;
    }

    public String getDataSyncIn2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncIn2Id();
        }
        return this.datasyncin2id;
    }

    public boolean isDataSyncIn2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncIn2IdDirty();
        }
        return this.datasyncin2idDirtyFlag;
    }

    public void resetDataSyncIn2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncIn2Id();
            return;
        }
        this.datasyncin2idDirtyFlag = false;
        this.datasyncin2id = null;
    }

    public void setDataSyncIn2Name(String datasyncin2name) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncIn2Name(datasyncin2name);
            return;
        }
        if (datasyncin2name != null && (datasyncin2name = StringHelper.trimRight(datasyncin2name)).length() == 0) {
            datasyncin2name = null;
        }
        this.datasyncin2name = datasyncin2name;
        this.datasyncin2nameDirtyFlag = true;
    }

    public String getDataSyncIn2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncIn2Name();
        }
        return this.datasyncin2name;
    }

    public boolean isDataSyncIn2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncIn2NameDirty();
        }
        return this.datasyncin2nameDirtyFlag;
    }

    public void resetDataSyncIn2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncIn2Name();
            return;
        }
        this.datasyncin2nameDirtyFlag = false;
        this.datasyncin2name = null;
    }

    public void setDEId(String deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if (deid != null && (deid = StringHelper.trimRight(deid)).length() == 0) {
            deid = null;
        }
        this.deid = deid;
        this.deidDirtyFlag = true;
    }

    public String getDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    public boolean isDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEId();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
    }

    public void setError(String error) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setError(error);
            return;
        }
        if (error != null && (error = StringHelper.trimRight(error)).length() == 0) {
            error = null;
        }
        this.error = error;
        this.errorDirtyFlag = true;
    }

    public String getError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getError();
        }
        return this.error;
    }

    public boolean isErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorDirty();
        }
        return this.errorDirtyFlag;
    }

    public void resetError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetError();
            return;
        }
        this.errorDirtyFlag = false;
        this.error = null;
    }

    public void setEventType(Integer eventtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventType(eventtype);
            return;
        }
        this.eventtype = eventtype;
        this.eventtypeDirtyFlag = true;
    }

    public Integer getEventType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventType();
        }
        return this.eventtype;
    }

    public boolean isEventTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventTypeDirty();
        }
        return this.eventtypeDirtyFlag;
    }

    public void resetEventType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventType();
            return;
        }
        this.eventtypeDirtyFlag = false;
        this.eventtype = null;
    }

    public void setFileFlag(Integer fileflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileFlag(fileflag);
            return;
        }
        this.fileflag = fileflag;
        this.fileflagDirtyFlag = true;
    }

    public Integer getFileFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileFlag();
        }
        return this.fileflag;
    }

    public boolean isFileFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileFlagDirty();
        }
        return this.fileflagDirtyFlag;
    }

    public void resetFileFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileFlag();
            return;
        }
        this.fileflagDirtyFlag = false;
        this.fileflag = null;
    }

    public void setLogicData(String logicdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicData(logicdata);
            return;
        }
        if (logicdata != null && (logicdata = StringHelper.trimRight(logicdata)).length() == 0) {
            logicdata = null;
        }
        this.logicdata = logicdata;
        this.logicdataDirtyFlag = true;
    }

    public String getLogicData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicData();
        }
        return this.logicdata;
    }

    public boolean isLogicDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicDataDirty();
        }
        return this.logicdataDirtyFlag;
    }

    public void resetLogicData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicData();
            return;
        }
        this.logicdataDirtyFlag = false;
        this.logicdata = null;
    }

    public void setSyncAgent(String syncagent) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncAgent(syncagent);
            return;
        }
        if (syncagent != null && (syncagent = StringHelper.trimRight(syncagent)).length() == 0) {
            syncagent = null;
        }
        this.syncagent = syncagent;
        this.syncagentDirtyFlag = true;
    }

    public String getSyncAgent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncAgent();
        }
        return this.syncagent;
    }

    public boolean isSyncAgentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncAgentDirty();
        }
        return this.syncagentDirtyFlag;
    }

    public void resetSyncAgent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncAgent();
            return;
        }
        this.syncagentDirtyFlag = false;
        this.syncagent = null;
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
        DataSyncIn2Base.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DataSyncIn2Base et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetData();
        et.resetDataKey();
        et.resetDataSyncIn2Id();
        et.resetDataSyncIn2Name();
        et.resetDEId();
        et.resetDEName();
        et.resetError();
        et.resetEventType();
        et.resetFileFlag();
        et.resetLogicData();
        et.resetSyncAgent();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataDirty()) {
            params.put(FIELD_DATA, this.getData());
        }
        if (!bDirtyOnly || this.isDataKeyDirty()) {
            params.put(FIELD_DATAKEY, this.getDataKey());
        }
        if (!bDirtyOnly || this.isDataSyncIn2IdDirty()) {
            params.put(FIELD_DATASYNCIN2ID, this.getDataSyncIn2Id());
        }
        if (!bDirtyOnly || this.isDataSyncIn2NameDirty()) {
            params.put(FIELD_DATASYNCIN2NAME, this.getDataSyncIn2Name());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isErrorDirty()) {
            params.put(FIELD_ERROR, this.getError());
        }
        if (!bDirtyOnly || this.isEventTypeDirty()) {
            params.put(FIELD_EVENTTYPE, this.getEventType());
        }
        if (!bDirtyOnly || this.isFileFlagDirty()) {
            params.put(FIELD_FILEFLAG, this.getFileFlag());
        }
        if (!bDirtyOnly || this.isLogicDataDirty()) {
            params.put(FIELD_LOGICDATA, this.getLogicData());
        }
        if (!bDirtyOnly || this.isSyncAgentDirty()) {
            params.put(FIELD_SYNCAGENT, this.getSyncAgent());
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
        return DataSyncIn2Base.get(this, index);
    }

    private static Object get(DataSyncIn2Base et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getData();
            }
            case 3: {
                return et.getDataKey();
            }
            case 4: {
                return et.getDataSyncIn2Id();
            }
            case 5: {
                return et.getDataSyncIn2Name();
            }
            case 6: {
                return et.getDEId();
            }
            case 7: {
                return et.getDEName();
            }
            case 8: {
                return et.getError();
            }
            case 9: {
                return et.getEventType();
            }
            case 10: {
                return et.getFileFlag();
            }
            case 11: {
                return et.getLogicData();
            }
            case 12: {
                return et.getSyncAgent();
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
        DataSyncIn2Base.set(this, index, objValue);
    }

    private static void set(DataSyncIn2Base et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setData(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDataKey(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDataSyncIn2Id(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDataSyncIn2Name(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setError(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setEventType(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setFileFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setLogicData(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setSyncAgent(DataObject.getStringValue(obj));
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
        return DataSyncIn2Base.isNull(this, index);
    }

    private static boolean isNull(DataSyncIn2Base et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getData() == null;
            }
            case 3: {
                return et.getDataKey() == null;
            }
            case 4: {
                return et.getDataSyncIn2Id() == null;
            }
            case 5: {
                return et.getDataSyncIn2Name() == null;
            }
            case 6: {
                return et.getDEId() == null;
            }
            case 7: {
                return et.getDEName() == null;
            }
            case 8: {
                return et.getError() == null;
            }
            case 9: {
                return et.getEventType() == null;
            }
            case 10: {
                return et.getFileFlag() == null;
            }
            case 11: {
                return et.getLogicData() == null;
            }
            case 12: {
                return et.getSyncAgent() == null;
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
        return DataSyncIn2Base.contains(this, index);
    }

    private static boolean contains(DataSyncIn2Base et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDataDirty();
            }
            case 3: {
                return et.isDataKeyDirty();
            }
            case 4: {
                return et.isDataSyncIn2IdDirty();
            }
            case 5: {
                return et.isDataSyncIn2NameDirty();
            }
            case 6: {
                return et.isDEIdDirty();
            }
            case 7: {
                return et.isDENameDirty();
            }
            case 8: {
                return et.isErrorDirty();
            }
            case 9: {
                return et.isEventTypeDirty();
            }
            case 10: {
                return et.isFileFlagDirty();
            }
            case 11: {
                return et.isLogicDataDirty();
            }
            case 12: {
                return et.isSyncAgentDirty();
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
        DataSyncIn2Base.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataSyncIn2Base et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataSyncIn2Base.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataSyncIn2Base.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getData() != null) {
            JSONObjectHelper.put(json, "data", DataSyncIn2Base.getJSONValue(et.getData()), false);
        }
        if (bIncEmpty || et.getDataKey() != null) {
            JSONObjectHelper.put(json, "datakey", DataSyncIn2Base.getJSONValue(et.getDataKey()), false);
        }
        if (bIncEmpty || et.getDataSyncIn2Id() != null) {
            JSONObjectHelper.put(json, "datasyncin2id", DataSyncIn2Base.getJSONValue(et.getDataSyncIn2Id()), false);
        }
        if (bIncEmpty || et.getDataSyncIn2Name() != null) {
            JSONObjectHelper.put(json, "datasyncin2name", DataSyncIn2Base.getJSONValue(et.getDataSyncIn2Name()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", DataSyncIn2Base.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", DataSyncIn2Base.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getError() != null) {
            JSONObjectHelper.put(json, "error", DataSyncIn2Base.getJSONValue(et.getError()), false);
        }
        if (bIncEmpty || et.getEventType() != null) {
            JSONObjectHelper.put(json, "eventtype", DataSyncIn2Base.getJSONValue(et.getEventType()), false);
        }
        if (bIncEmpty || et.getFileFlag() != null) {
            JSONObjectHelper.put(json, "fileflag", DataSyncIn2Base.getJSONValue(et.getFileFlag()), false);
        }
        if (bIncEmpty || et.getLogicData() != null) {
            JSONObjectHelper.put(json, "logicdata", DataSyncIn2Base.getJSONValue(et.getLogicData()), false);
        }
        if (bIncEmpty || et.getSyncAgent() != null) {
            JSONObjectHelper.put(json, "syncagent", DataSyncIn2Base.getJSONValue(et.getSyncAgent()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataSyncIn2Base.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataSyncIn2Base.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataSyncIn2Base.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataSyncIn2Base et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getData() != null) {
            obj = et.getData();
            node.setAttribute(FIELD_DATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataKey() != null) {
            obj = et.getDataKey();
            node.setAttribute(FIELD_DATAKEY, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataSyncIn2Id() != null) {
            obj = et.getDataSyncIn2Id();
            node.setAttribute(FIELD_DATASYNCIN2ID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataSyncIn2Name() != null) {
            obj = et.getDataSyncIn2Name();
            node.setAttribute(FIELD_DATASYNCIN2NAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getError() != null) {
            obj = et.getError();
            node.setAttribute(FIELD_ERROR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEventType() != null) {
            obj = et.getEventType();
            node.setAttribute(FIELD_EVENTTYPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getFileFlag() != null) {
            obj = et.getFileFlag();
            node.setAttribute(FIELD_FILEFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLogicData() != null) {
            obj = et.getLogicData();
            node.setAttribute(FIELD_LOGICDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSyncAgent() != null) {
            obj = et.getSyncAgent();
            node.setAttribute(FIELD_SYNCAGENT, obj == null ? "" : (String)obj);
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
        DataSyncIn2Base.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataSyncIn2Base et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataDirty() && (bIncEmpty || et.getData() != null)) {
            dst.set(FIELD_DATA, et.getData());
        }
        if (et.isDataKeyDirty() && (bIncEmpty || et.getDataKey() != null)) {
            dst.set(FIELD_DATAKEY, et.getDataKey());
        }
        if (et.isDataSyncIn2IdDirty() && (bIncEmpty || et.getDataSyncIn2Id() != null)) {
            dst.set(FIELD_DATASYNCIN2ID, et.getDataSyncIn2Id());
        }
        if (et.isDataSyncIn2NameDirty() && (bIncEmpty || et.getDataSyncIn2Name() != null)) {
            dst.set(FIELD_DATASYNCIN2NAME, et.getDataSyncIn2Name());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isErrorDirty() && (bIncEmpty || et.getError() != null)) {
            dst.set(FIELD_ERROR, et.getError());
        }
        if (et.isEventTypeDirty() && (bIncEmpty || et.getEventType() != null)) {
            dst.set(FIELD_EVENTTYPE, et.getEventType());
        }
        if (et.isFileFlagDirty() && (bIncEmpty || et.getFileFlag() != null)) {
            dst.set(FIELD_FILEFLAG, et.getFileFlag());
        }
        if (et.isLogicDataDirty() && (bIncEmpty || et.getLogicData() != null)) {
            dst.set(FIELD_LOGICDATA, et.getLogicData());
        }
        if (et.isSyncAgentDirty() && (bIncEmpty || et.getSyncAgent() != null)) {
            dst.set(FIELD_SYNCAGENT, et.getSyncAgent());
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
        return DataSyncIn2Base.remove(this, index);
    }

    private static boolean remove(DataSyncIn2Base et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetData();
                return true;
            }
            case 3: {
                et.resetDataKey();
                return true;
            }
            case 4: {
                et.resetDataSyncIn2Id();
                return true;
            }
            case 5: {
                et.resetDataSyncIn2Name();
                return true;
            }
            case 6: {
                et.resetDEId();
                return true;
            }
            case 7: {
                et.resetDEName();
                return true;
            }
            case 8: {
                et.resetError();
                return true;
            }
            case 9: {
                et.resetEventType();
                return true;
            }
            case 10: {
                et.resetFileFlag();
                return true;
            }
            case 11: {
                et.resetLogicData();
                return true;
            }
            case 12: {
                et.resetSyncAgent();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntity getDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDE();
        }
        if (this.getDEId() == null) {
            return null;
        }
        Integer n = this.objDELock;
        synchronized (n) {
            if (this.de != null && DataTypeHelper.compare(25, (Object)this.getDEId(), (Object)this.de.getDEId()) != 0L) {
                this.de = null;
            }
            if (this.de == null) {
                DataEntity de = new DataEntity();
                de.setDEId(this.getDEId());
                DataEntityService service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }

    private DataSyncIn2Base getProxyEntity() {
        return this.proxyDataSyncIn2Base;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataSyncIn2Base = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataSyncIn2Base) {
            this.proxyDataSyncIn2Base = (DataSyncIn2Base)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataSyncIn2Service", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

