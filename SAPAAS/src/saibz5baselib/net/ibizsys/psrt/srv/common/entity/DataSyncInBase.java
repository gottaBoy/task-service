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

public abstract class DataSyncInBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataSyncInBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DATAKEY = "DATAKEY";
    public static final String FIELD_DATASYNCINID = "DATASYNCINID";
    public static final String FIELD_DATASYNCINNAME = "DATASYNCINNAME";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
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
    private static final int INDEX_DATASYNCINID = 4;
    private static final int INDEX_DATASYNCINNAME = 5;
    private static final int INDEX_DEID = 6;
    private static final int INDEX_DENAME = 7;
    private static final int INDEX_EVENTTYPE = 8;
    private static final int INDEX_FILEFLAG = 9;
    private static final int INDEX_LOGICDATA = 10;
    private static final int INDEX_SYNCAGENT = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataSyncInBase proxyDataSyncInBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean datakeyDirtyFlag = false;
    private boolean datasyncinidDirtyFlag = false;
    private boolean datasyncinnameDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
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
    @Column(name="datasyncinid")
    private String datasyncinid;
    @Column(name="datasyncinname")
    private String datasyncinname;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
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
        fieldIndexMap.put(FIELD_DATASYNCINID, 4);
        fieldIndexMap.put(FIELD_DATASYNCINNAME, 5);
        fieldIndexMap.put(FIELD_DEID, 6);
        fieldIndexMap.put(FIELD_DENAME, 7);
        fieldIndexMap.put(FIELD_EVENTTYPE, 8);
        fieldIndexMap.put(FIELD_FILEFLAG, 9);
        fieldIndexMap.put(FIELD_LOGICDATA, 10);
        fieldIndexMap.put(FIELD_SYNCAGENT, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
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

    public void setDataSyncInId(String datasyncinid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncInId(datasyncinid);
            return;
        }
        if (datasyncinid != null && (datasyncinid = StringHelper.trimRight(datasyncinid)).length() == 0) {
            datasyncinid = null;
        }
        this.datasyncinid = datasyncinid;
        this.datasyncinidDirtyFlag = true;
    }

    public String getDataSyncInId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncInId();
        }
        return this.datasyncinid;
    }

    public boolean isDataSyncInIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncInIdDirty();
        }
        return this.datasyncinidDirtyFlag;
    }

    public void resetDataSyncInId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncInId();
            return;
        }
        this.datasyncinidDirtyFlag = false;
        this.datasyncinid = null;
    }

    public void setDataSyncInName(String datasyncinname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSyncInName(datasyncinname);
            return;
        }
        if (datasyncinname != null && (datasyncinname = StringHelper.trimRight(datasyncinname)).length() == 0) {
            datasyncinname = null;
        }
        this.datasyncinname = datasyncinname;
        this.datasyncinnameDirtyFlag = true;
    }

    public String getDataSyncInName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSyncInName();
        }
        return this.datasyncinname;
    }

    public boolean isDataSyncInNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSyncInNameDirty();
        }
        return this.datasyncinnameDirtyFlag;
    }

    public void resetDataSyncInName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSyncInName();
            return;
        }
        this.datasyncinnameDirtyFlag = false;
        this.datasyncinname = null;
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
        DataSyncInBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DataSyncInBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetData();
        et.resetDataKey();
        et.resetDataSyncInId();
        et.resetDataSyncInName();
        et.resetDEId();
        et.resetDEName();
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
        if (!bDirtyOnly || this.isDataSyncInIdDirty()) {
            params.put(FIELD_DATASYNCINID, this.getDataSyncInId());
        }
        if (!bDirtyOnly || this.isDataSyncInNameDirty()) {
            params.put(FIELD_DATASYNCINNAME, this.getDataSyncInName());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
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
        return DataSyncInBase.get(this, index);
    }

    private static Object get(DataSyncInBase et, int index) throws Exception {
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
                return et.getDataSyncInId();
            }
            case 5: {
                return et.getDataSyncInName();
            }
            case 6: {
                return et.getDEId();
            }
            case 7: {
                return et.getDEName();
            }
            case 8: {
                return et.getEventType();
            }
            case 9: {
                return et.getFileFlag();
            }
            case 10: {
                return et.getLogicData();
            }
            case 11: {
                return et.getSyncAgent();
            }
            case 12: {
                return et.getUpdateDate();
            }
            case 13: {
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
        DataSyncInBase.set(this, index, objValue);
    }

    private static void set(DataSyncInBase et, int index, Object obj) throws Exception {
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
                et.setDataSyncInId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDataSyncInName(DataObject.getStringValue(obj));
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
                et.setEventType(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setFileFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setLogicData(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setSyncAgent(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
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
        return DataSyncInBase.isNull(this, index);
    }

    private static boolean isNull(DataSyncInBase et, int index) throws Exception {
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
                return et.getDataSyncInId() == null;
            }
            case 5: {
                return et.getDataSyncInName() == null;
            }
            case 6: {
                return et.getDEId() == null;
            }
            case 7: {
                return et.getDEName() == null;
            }
            case 8: {
                return et.getEventType() == null;
            }
            case 9: {
                return et.getFileFlag() == null;
            }
            case 10: {
                return et.getLogicData() == null;
            }
            case 11: {
                return et.getSyncAgent() == null;
            }
            case 12: {
                return et.getUpdateDate() == null;
            }
            case 13: {
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
        return DataSyncInBase.contains(this, index);
    }

    private static boolean contains(DataSyncInBase et, int index) throws Exception {
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
                return et.isDataSyncInIdDirty();
            }
            case 5: {
                return et.isDataSyncInNameDirty();
            }
            case 6: {
                return et.isDEIdDirty();
            }
            case 7: {
                return et.isDENameDirty();
            }
            case 8: {
                return et.isEventTypeDirty();
            }
            case 9: {
                return et.isFileFlagDirty();
            }
            case 10: {
                return et.isLogicDataDirty();
            }
            case 11: {
                return et.isSyncAgentDirty();
            }
            case 12: {
                return et.isUpdateDateDirty();
            }
            case 13: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DataSyncInBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataSyncInBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataSyncInBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataSyncInBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getData() != null) {
            JSONObjectHelper.put(json, "data", DataSyncInBase.getJSONValue(et.getData()), false);
        }
        if (bIncEmpty || et.getDataKey() != null) {
            JSONObjectHelper.put(json, "datakey", DataSyncInBase.getJSONValue(et.getDataKey()), false);
        }
        if (bIncEmpty || et.getDataSyncInId() != null) {
            JSONObjectHelper.put(json, "datasyncinid", DataSyncInBase.getJSONValue(et.getDataSyncInId()), false);
        }
        if (bIncEmpty || et.getDataSyncInName() != null) {
            JSONObjectHelper.put(json, "datasyncinname", DataSyncInBase.getJSONValue(et.getDataSyncInName()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", DataSyncInBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", DataSyncInBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getEventType() != null) {
            JSONObjectHelper.put(json, "eventtype", DataSyncInBase.getJSONValue(et.getEventType()), false);
        }
        if (bIncEmpty || et.getFileFlag() != null) {
            JSONObjectHelper.put(json, "fileflag", DataSyncInBase.getJSONValue(et.getFileFlag()), false);
        }
        if (bIncEmpty || et.getLogicData() != null) {
            JSONObjectHelper.put(json, "logicdata", DataSyncInBase.getJSONValue(et.getLogicData()), false);
        }
        if (bIncEmpty || et.getSyncAgent() != null) {
            JSONObjectHelper.put(json, "syncagent", DataSyncInBase.getJSONValue(et.getSyncAgent()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataSyncInBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataSyncInBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataSyncInBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataSyncInBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getDataSyncInId() != null) {
            obj = et.getDataSyncInId();
            node.setAttribute(FIELD_DATASYNCINID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataSyncInName() != null) {
            obj = et.getDataSyncInName();
            node.setAttribute(FIELD_DATASYNCINNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
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
        DataSyncInBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataSyncInBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isDataSyncInIdDirty() && (bIncEmpty || et.getDataSyncInId() != null)) {
            dst.set(FIELD_DATASYNCINID, et.getDataSyncInId());
        }
        if (et.isDataSyncInNameDirty() && (bIncEmpty || et.getDataSyncInName() != null)) {
            dst.set(FIELD_DATASYNCINNAME, et.getDataSyncInName());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
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
        return DataSyncInBase.remove(this, index);
    }

    private static boolean remove(DataSyncInBase et, int index) throws Exception {
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
                et.resetDataSyncInId();
                return true;
            }
            case 5: {
                et.resetDataSyncInName();
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
                et.resetEventType();
                return true;
            }
            case 9: {
                et.resetFileFlag();
                return true;
            }
            case 10: {
                et.resetLogicData();
                return true;
            }
            case 11: {
                et.resetSyncAgent();
                return true;
            }
            case 12: {
                et.resetUpdateDate();
                return true;
            }
            case 13: {
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

    private DataSyncInBase getProxyEntity() {
        return this.proxyDataSyncInBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataSyncInBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataSyncInBase) {
            this.proxyDataSyncInBase = (DataSyncInBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataSyncInService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

