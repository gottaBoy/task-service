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

public abstract class DEDataChg2Base
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DEDataChg2Base.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DATAKEY = "DATAKEY";
    public static final String FIELD_DEDATACHG2ID = "DEDATACHG2ID";
    public static final String FIELD_DEDATACHG2NAME = "DEDATACHG2NAME";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_DISPERROR = "DISPERROR";
    public static final String FIELD_ERROR = "ERROR";
    public static final String FIELD_EVENTTYPE = "EVENTTYPE";
    public static final String FIELD_LOGICDATA = "LOGICDATA";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATA = 2;
    private static final int INDEX_DATAKEY = 3;
    private static final int INDEX_DEDATACHG2ID = 4;
    private static final int INDEX_DEDATACHG2NAME = 5;
    private static final int INDEX_DEID = 6;
    private static final int INDEX_DENAME = 7;
    private static final int INDEX_DISPERROR = 8;
    private static final int INDEX_ERROR = 9;
    private static final int INDEX_EVENTTYPE = 10;
    private static final int INDEX_LOGICDATA = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DEDataChg2Base proxyDEDataChg2Base = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean datakeyDirtyFlag = false;
    private boolean dedatachg2idDirtyFlag = false;
    private boolean dedatachg2nameDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean disperrorDirtyFlag = false;
    private boolean errorDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean logicdataDirtyFlag = false;
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
    @Column(name="dedatachg2id")
    private String dedatachg2id;
    @Column(name="dedatachg2name")
    private String dedatachg2name;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="disperror")
    private String disperror;
    @Column(name="error")
    private String error;
    @Column(name="eventtype")
    private Integer eventtype;
    @Column(name="logicdata")
    private String logicdata;
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
        fieldIndexMap.put(FIELD_DEDATACHG2ID, 4);
        fieldIndexMap.put(FIELD_DEDATACHG2NAME, 5);
        fieldIndexMap.put(FIELD_DEID, 6);
        fieldIndexMap.put(FIELD_DENAME, 7);
        fieldIndexMap.put(FIELD_DISPERROR, 8);
        fieldIndexMap.put(FIELD_ERROR, 9);
        fieldIndexMap.put(FIELD_EVENTTYPE, 10);
        fieldIndexMap.put(FIELD_LOGICDATA, 11);
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

    public void setDEDataChg2Id(String dedatachg2id) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDataChg2Id(dedatachg2id);
            return;
        }
        if (dedatachg2id != null && (dedatachg2id = StringHelper.trimRight(dedatachg2id)).length() == 0) {
            dedatachg2id = null;
        }
        this.dedatachg2id = dedatachg2id;
        this.dedatachg2idDirtyFlag = true;
    }

    public String getDEDataChg2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDataChg2Id();
        }
        return this.dedatachg2id;
    }

    public boolean isDEDataChg2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDataChg2IdDirty();
        }
        return this.dedatachg2idDirtyFlag;
    }

    public void resetDEDataChg2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDataChg2Id();
            return;
        }
        this.dedatachg2idDirtyFlag = false;
        this.dedatachg2id = null;
    }

    public void setDEDataChg2Name(String dedatachg2name) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDataChg2Name(dedatachg2name);
            return;
        }
        if (dedatachg2name != null && (dedatachg2name = StringHelper.trimRight(dedatachg2name)).length() == 0) {
            dedatachg2name = null;
        }
        this.dedatachg2name = dedatachg2name;
        this.dedatachg2nameDirtyFlag = true;
    }

    public String getDEDataChg2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDataChg2Name();
        }
        return this.dedatachg2name;
    }

    public boolean isDEDataChg2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDataChg2NameDirty();
        }
        return this.dedatachg2nameDirtyFlag;
    }

    public void resetDEDataChg2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDataChg2Name();
            return;
        }
        this.dedatachg2nameDirtyFlag = false;
        this.dedatachg2name = null;
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

    public void setDISPError(String disperror) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDISPError(disperror);
            return;
        }
        if (disperror != null && (disperror = StringHelper.trimRight(disperror)).length() == 0) {
            disperror = null;
        }
        this.disperror = disperror;
        this.disperrorDirtyFlag = true;
    }

    public String getDISPError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDISPError();
        }
        return this.disperror;
    }

    public boolean isDISPErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDISPErrorDirty();
        }
        return this.disperrorDirtyFlag;
    }

    public void resetDISPError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDISPError();
            return;
        }
        this.disperrorDirtyFlag = false;
        this.disperror = null;
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
        DEDataChg2Base.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DEDataChg2Base et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetData();
        et.resetDataKey();
        et.resetDEDataChg2Id();
        et.resetDEDataChg2Name();
        et.resetDEId();
        et.resetDEName();
        et.resetDISPError();
        et.resetError();
        et.resetEventType();
        et.resetLogicData();
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
        if (!bDirtyOnly || this.isDEDataChg2IdDirty()) {
            params.put(FIELD_DEDATACHG2ID, this.getDEDataChg2Id());
        }
        if (!bDirtyOnly || this.isDEDataChg2NameDirty()) {
            params.put(FIELD_DEDATACHG2NAME, this.getDEDataChg2Name());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isDISPErrorDirty()) {
            params.put(FIELD_DISPERROR, this.getDISPError());
        }
        if (!bDirtyOnly || this.isErrorDirty()) {
            params.put(FIELD_ERROR, this.getError());
        }
        if (!bDirtyOnly || this.isEventTypeDirty()) {
            params.put(FIELD_EVENTTYPE, this.getEventType());
        }
        if (!bDirtyOnly || this.isLogicDataDirty()) {
            params.put(FIELD_LOGICDATA, this.getLogicData());
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
        return DEDataChg2Base.get(this, index);
    }

    private static Object get(DEDataChg2Base et, int index) throws Exception {
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
                return et.getDEDataChg2Id();
            }
            case 5: {
                return et.getDEDataChg2Name();
            }
            case 6: {
                return et.getDEId();
            }
            case 7: {
                return et.getDEName();
            }
            case 8: {
                return et.getDISPError();
            }
            case 9: {
                return et.getError();
            }
            case 10: {
                return et.getEventType();
            }
            case 11: {
                return et.getLogicData();
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
        DEDataChg2Base.set(this, index, objValue);
    }

    private static void set(DEDataChg2Base et, int index, Object obj) throws Exception {
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
                et.setDEDataChg2Id(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDEDataChg2Name(DataObject.getStringValue(obj));
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
                et.setDISPError(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setError(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setEventType(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setLogicData(DataObject.getStringValue(obj));
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
        return DEDataChg2Base.isNull(this, index);
    }

    private static boolean isNull(DEDataChg2Base et, int index) throws Exception {
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
                return et.getDEDataChg2Id() == null;
            }
            case 5: {
                return et.getDEDataChg2Name() == null;
            }
            case 6: {
                return et.getDEId() == null;
            }
            case 7: {
                return et.getDEName() == null;
            }
            case 8: {
                return et.getDISPError() == null;
            }
            case 9: {
                return et.getError() == null;
            }
            case 10: {
                return et.getEventType() == null;
            }
            case 11: {
                return et.getLogicData() == null;
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
        return DEDataChg2Base.contains(this, index);
    }

    private static boolean contains(DEDataChg2Base et, int index) throws Exception {
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
                return et.isDEDataChg2IdDirty();
            }
            case 5: {
                return et.isDEDataChg2NameDirty();
            }
            case 6: {
                return et.isDEIdDirty();
            }
            case 7: {
                return et.isDENameDirty();
            }
            case 8: {
                return et.isDISPErrorDirty();
            }
            case 9: {
                return et.isErrorDirty();
            }
            case 10: {
                return et.isEventTypeDirty();
            }
            case 11: {
                return et.isLogicDataDirty();
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
        DEDataChg2Base.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DEDataChg2Base et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DEDataChg2Base.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DEDataChg2Base.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getData() != null) {
            JSONObjectHelper.put(json, "data", DEDataChg2Base.getJSONValue(et.getData()), false);
        }
        if (bIncEmpty || et.getDataKey() != null) {
            JSONObjectHelper.put(json, "datakey", DEDataChg2Base.getJSONValue(et.getDataKey()), false);
        }
        if (bIncEmpty || et.getDEDataChg2Id() != null) {
            JSONObjectHelper.put(json, "dedatachg2id", DEDataChg2Base.getJSONValue(et.getDEDataChg2Id()), false);
        }
        if (bIncEmpty || et.getDEDataChg2Name() != null) {
            JSONObjectHelper.put(json, "dedatachg2name", DEDataChg2Base.getJSONValue(et.getDEDataChg2Name()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", DEDataChg2Base.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", DEDataChg2Base.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getDISPError() != null) {
            JSONObjectHelper.put(json, "disperror", DEDataChg2Base.getJSONValue(et.getDISPError()), false);
        }
        if (bIncEmpty || et.getError() != null) {
            JSONObjectHelper.put(json, "error", DEDataChg2Base.getJSONValue(et.getError()), false);
        }
        if (bIncEmpty || et.getEventType() != null) {
            JSONObjectHelper.put(json, "eventtype", DEDataChg2Base.getJSONValue(et.getEventType()), false);
        }
        if (bIncEmpty || et.getLogicData() != null) {
            JSONObjectHelper.put(json, "logicdata", DEDataChg2Base.getJSONValue(et.getLogicData()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DEDataChg2Base.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DEDataChg2Base.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DEDataChg2Base.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DEDataChg2Base et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getDEDataChg2Id() != null) {
            obj = et.getDEDataChg2Id();
            node.setAttribute(FIELD_DEDATACHG2ID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEDataChg2Name() != null) {
            obj = et.getDEDataChg2Name();
            node.setAttribute(FIELD_DEDATACHG2NAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDISPError() != null) {
            obj = et.getDISPError();
            node.setAttribute(FIELD_DISPERROR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getError() != null) {
            obj = et.getError();
            node.setAttribute(FIELD_ERROR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEventType() != null) {
            obj = et.getEventType();
            node.setAttribute(FIELD_EVENTTYPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLogicData() != null) {
            obj = et.getLogicData();
            node.setAttribute(FIELD_LOGICDATA, obj == null ? "" : (String)obj);
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
        DEDataChg2Base.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DEDataChg2Base et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isDEDataChg2IdDirty() && (bIncEmpty || et.getDEDataChg2Id() != null)) {
            dst.set(FIELD_DEDATACHG2ID, et.getDEDataChg2Id());
        }
        if (et.isDEDataChg2NameDirty() && (bIncEmpty || et.getDEDataChg2Name() != null)) {
            dst.set(FIELD_DEDATACHG2NAME, et.getDEDataChg2Name());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isDISPErrorDirty() && (bIncEmpty || et.getDISPError() != null)) {
            dst.set(FIELD_DISPERROR, et.getDISPError());
        }
        if (et.isErrorDirty() && (bIncEmpty || et.getError() != null)) {
            dst.set(FIELD_ERROR, et.getError());
        }
        if (et.isEventTypeDirty() && (bIncEmpty || et.getEventType() != null)) {
            dst.set(FIELD_EVENTTYPE, et.getEventType());
        }
        if (et.isLogicDataDirty() && (bIncEmpty || et.getLogicData() != null)) {
            dst.set(FIELD_LOGICDATA, et.getLogicData());
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
        return DEDataChg2Base.remove(this, index);
    }

    private static boolean remove(DEDataChg2Base et, int index) throws Exception {
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
                et.resetDEDataChg2Id();
                return true;
            }
            case 5: {
                et.resetDEDataChg2Name();
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
                et.resetDISPError();
                return true;
            }
            case 9: {
                et.resetError();
                return true;
            }
            case 10: {
                et.resetEventType();
                return true;
            }
            case 11: {
                et.resetLogicData();
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

    private DEDataChg2Base getProxyEntity() {
        return this.proxyDEDataChg2Base;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDEDataChg2Base = null;
        if (proxyDataObject != null && proxyDataObject instanceof DEDataChg2Base) {
            this.proxyDEDataChg2Base = (DEDataChg2Base)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DEDataChg2Service", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

