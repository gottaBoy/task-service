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

public abstract class DALogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DALogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DALOG_ID = "DALOG_ID";
    public static final String FIELD_DALOG_NAME = "DALOG_NAME";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGSN = "LOGSN";
    public static final String FIELD_LOGTYPE = "LOGTYPE";
    public static final String FIELD_OBJECTID = "OBJECTID";
    public static final String FIELD_OBJECTTYPE = "OBJECTTYPE";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DALOG_ID = 2;
    private static final int INDEX_DALOG_NAME = 3;
    private static final int INDEX_LOGINFO = 4;
    private static final int INDEX_LOGSN = 5;
    private static final int INDEX_LOGTYPE = 6;
    private static final int INDEX_OBJECTID = 7;
    private static final int INDEX_OBJECTTYPE = 8;
    private static final int INDEX_REMOTEADDR = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DALogBase proxyDALogBase = null;
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

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DALOG_ID, 2);
        fieldIndexMap.put(FIELD_DALOG_NAME, 3);
        fieldIndexMap.put(FIELD_LOGINFO, 4);
        fieldIndexMap.put(FIELD_LOGSN, 5);
        fieldIndexMap.put(FIELD_LOGTYPE, 6);
        fieldIndexMap.put(FIELD_OBJECTID, 7);
        fieldIndexMap.put(FIELD_OBJECTTYPE, 8);
        fieldIndexMap.put(FIELD_REMOTEADDR, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
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

    public void setDALOG_Id(String dalog_id) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDALOG_Id(dalog_id);
            return;
        }
        if (dalog_id != null && (dalog_id = StringHelper.trimRight(dalog_id)).length() == 0) {
            dalog_id = null;
        }
        this.dalog_id = dalog_id;
        this.dalog_idDirtyFlag = true;
    }

    public String getDALOG_Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDALOG_Id();
        }
        return this.dalog_id;
    }

    public boolean isDALOG_IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDALOG_IdDirty();
        }
        return this.dalog_idDirtyFlag;
    }

    public void resetDALOG_Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDALOG_Id();
            return;
        }
        this.dalog_idDirtyFlag = false;
        this.dalog_id = null;
    }

    public void setDALOG_Name(String dalog_name) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDALOG_Name(dalog_name);
            return;
        }
        if (dalog_name != null && (dalog_name = StringHelper.trimRight(dalog_name)).length() == 0) {
            dalog_name = null;
        }
        this.dalog_name = dalog_name;
        this.dalog_nameDirtyFlag = true;
    }

    public String getDALOG_Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDALOG_Name();
        }
        return this.dalog_name;
    }

    public boolean isDALOG_NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDALOG_NameDirty();
        }
        return this.dalog_nameDirtyFlag;
    }

    public void resetDALOG_Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDALOG_Name();
            return;
        }
        this.dalog_nameDirtyFlag = false;
        this.dalog_name = null;
    }

    public void setLogInfo(String loginfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo(loginfo);
            return;
        }
        if (loginfo != null && (loginfo = StringHelper.trimRight(loginfo)).length() == 0) {
            loginfo = null;
        }
        this.loginfo = loginfo;
        this.loginfoDirtyFlag = true;
    }

    public String getLogInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo();
        }
        return this.loginfo;
    }

    public boolean isLogInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfoDirty();
        }
        return this.loginfoDirtyFlag;
    }

    public void resetLogInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo();
            return;
        }
        this.loginfoDirtyFlag = false;
        this.loginfo = null;
    }

    public void setLogSN(Integer logsn) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogSN(logsn);
            return;
        }
        this.logsn = logsn;
        this.logsnDirtyFlag = true;
    }

    public Integer getLogSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogSN();
        }
        return this.logsn;
    }

    public boolean isLogSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogSNDirty();
        }
        return this.logsnDirtyFlag;
    }

    public void resetLogSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogSN();
            return;
        }
        this.logsnDirtyFlag = false;
        this.logsn = null;
    }

    public void setLOGType(String logtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLOGType(logtype);
            return;
        }
        if (logtype != null && (logtype = StringHelper.trimRight(logtype)).length() == 0) {
            logtype = null;
        }
        this.logtype = logtype;
        this.logtypeDirtyFlag = true;
    }

    public String getLOGType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLOGType();
        }
        return this.logtype;
    }

    public boolean isLOGTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLOGTypeDirty();
        }
        return this.logtypeDirtyFlag;
    }

    public void resetLOGType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLOGType();
            return;
        }
        this.logtypeDirtyFlag = false;
        this.logtype = null;
    }

    public void setObjectId(String objectid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjectId(objectid);
            return;
        }
        if (objectid != null && (objectid = StringHelper.trimRight(objectid)).length() == 0) {
            objectid = null;
        }
        this.objectid = objectid;
        this.objectidDirtyFlag = true;
    }

    public String getObjectId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjectId();
        }
        return this.objectid;
    }

    public boolean isObjectIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjectIdDirty();
        }
        return this.objectidDirtyFlag;
    }

    public void resetObjectId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjectId();
            return;
        }
        this.objectidDirtyFlag = false;
        this.objectid = null;
    }

    public void setObjectType(String objecttype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjectType(objecttype);
            return;
        }
        if (objecttype != null && (objecttype = StringHelper.trimRight(objecttype)).length() == 0) {
            objecttype = null;
        }
        this.objecttype = objecttype;
        this.objecttypeDirtyFlag = true;
    }

    public String getObjectType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjectType();
        }
        return this.objecttype;
    }

    public boolean isObjectTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjectTypeDirty();
        }
        return this.objecttypeDirtyFlag;
    }

    public void resetObjectType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjectType();
            return;
        }
        this.objecttypeDirtyFlag = false;
        this.objecttype = null;
    }

    public void setRemoteAddr(String remoteaddr) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoteAddr(remoteaddr);
            return;
        }
        if (remoteaddr != null && (remoteaddr = StringHelper.trimRight(remoteaddr)).length() == 0) {
            remoteaddr = null;
        }
        this.remoteaddr = remoteaddr;
        this.remoteaddrDirtyFlag = true;
    }

    public String getRemoteAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoteAddr();
        }
        return this.remoteaddr;
    }

    public boolean isRemoteAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoteAddrDirty();
        }
        return this.remoteaddrDirtyFlag;
    }

    public void resetRemoteAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoteAddr();
            return;
        }
        this.remoteaddrDirtyFlag = false;
        this.remoteaddr = null;
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
        DALogBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDALOG_IdDirty()) {
            params.put(FIELD_DALOG_ID, this.getDALOG_Id());
        }
        if (!bDirtyOnly || this.isDALOG_NameDirty()) {
            params.put(FIELD_DALOG_NAME, this.getDALOG_Name());
        }
        if (!bDirtyOnly || this.isLogInfoDirty()) {
            params.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bDirtyOnly || this.isLogSNDirty()) {
            params.put(FIELD_LOGSN, this.getLogSN());
        }
        if (!bDirtyOnly || this.isLOGTypeDirty()) {
            params.put(FIELD_LOGTYPE, this.getLOGType());
        }
        if (!bDirtyOnly || this.isObjectIdDirty()) {
            params.put(FIELD_OBJECTID, this.getObjectId());
        }
        if (!bDirtyOnly || this.isObjectTypeDirty()) {
            params.put(FIELD_OBJECTTYPE, this.getObjectType());
        }
        if (!bDirtyOnly || this.isRemoteAddrDirty()) {
            params.put(FIELD_REMOTEADDR, this.getRemoteAddr());
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
        return DALogBase.get(this, index);
    }

    private static Object get(DALogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDALOG_Id();
            }
            case 3: {
                return et.getDALOG_Name();
            }
            case 4: {
                return et.getLogInfo();
            }
            case 5: {
                return et.getLogSN();
            }
            case 6: {
                return et.getLOGType();
            }
            case 7: {
                return et.getObjectId();
            }
            case 8: {
                return et.getObjectType();
            }
            case 9: {
                return et.getRemoteAddr();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
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
        DALogBase.set(this, index, objValue);
    }

    private static void set(DALogBase et, int index, Object obj) throws Exception {
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
                et.setDALOG_Id(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDALOG_Name(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setLogInfo(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setLogSN(DataObject.getIntegerValue(obj));
                return;
            }
            case 6: {
                et.setLOGType(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setObjectId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setObjectType(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setRemoteAddr(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
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
        return DALogBase.isNull(this, index);
    }

    private static boolean isNull(DALogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDALOG_Id() == null;
            }
            case 3: {
                return et.getDALOG_Name() == null;
            }
            case 4: {
                return et.getLogInfo() == null;
            }
            case 5: {
                return et.getLogSN() == null;
            }
            case 6: {
                return et.getLOGType() == null;
            }
            case 7: {
                return et.getObjectId() == null;
            }
            case 8: {
                return et.getObjectType() == null;
            }
            case 9: {
                return et.getRemoteAddr() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
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
        return DALogBase.contains(this, index);
    }

    private static boolean contains(DALogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDALOG_IdDirty();
            }
            case 3: {
                return et.isDALOG_NameDirty();
            }
            case 4: {
                return et.isLogInfoDirty();
            }
            case 5: {
                return et.isLogSNDirty();
            }
            case 6: {
                return et.isLOGTypeDirty();
            }
            case 7: {
                return et.isObjectIdDirty();
            }
            case 8: {
                return et.isObjectTypeDirty();
            }
            case 9: {
                return et.isRemoteAddrDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DALogBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DALogBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DALogBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DALogBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDALOG_Id() != null) {
            JSONObjectHelper.put(json, "dalog_id", DALogBase.getJSONValue(et.getDALOG_Id()), false);
        }
        if (bIncEmpty || et.getDALOG_Name() != null) {
            JSONObjectHelper.put(json, "dalog_name", DALogBase.getJSONValue(et.getDALOG_Name()), false);
        }
        if (bIncEmpty || et.getLogInfo() != null) {
            JSONObjectHelper.put(json, "loginfo", DALogBase.getJSONValue(et.getLogInfo()), false);
        }
        if (bIncEmpty || et.getLogSN() != null) {
            JSONObjectHelper.put(json, "logsn", DALogBase.getJSONValue(et.getLogSN()), false);
        }
        if (bIncEmpty || et.getLOGType() != null) {
            JSONObjectHelper.put(json, "logtype", DALogBase.getJSONValue(et.getLOGType()), false);
        }
        if (bIncEmpty || et.getObjectId() != null) {
            JSONObjectHelper.put(json, "objectid", DALogBase.getJSONValue(et.getObjectId()), false);
        }
        if (bIncEmpty || et.getObjectType() != null) {
            JSONObjectHelper.put(json, "objecttype", DALogBase.getJSONValue(et.getObjectType()), false);
        }
        if (bIncEmpty || et.getRemoteAddr() != null) {
            JSONObjectHelper.put(json, "remoteaddr", DALogBase.getJSONValue(et.getRemoteAddr()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DALogBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DALogBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DALogBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DALogBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDALOG_Id() != null) {
            obj = et.getDALOG_Id();
            node.setAttribute(FIELD_DALOG_ID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDALOG_Name() != null) {
            obj = et.getDALOG_Name();
            node.setAttribute(FIELD_DALOG_NAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLogInfo() != null) {
            obj = et.getLogInfo();
            node.setAttribute(FIELD_LOGINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLogSN() != null) {
            obj = et.getLogSN();
            node.setAttribute(FIELD_LOGSN, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLOGType() != null) {
            obj = et.getLOGType();
            node.setAttribute(FIELD_LOGTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getObjectId() != null) {
            obj = et.getObjectId();
            node.setAttribute(FIELD_OBJECTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getObjectType() != null) {
            obj = et.getObjectType();
            node.setAttribute(FIELD_OBJECTTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRemoteAddr() != null) {
            obj = et.getRemoteAddr();
            node.setAttribute(FIELD_REMOTEADDR, obj == null ? "" : (String)obj);
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
        DALogBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DALogBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDALOG_IdDirty() && (bIncEmpty || et.getDALOG_Id() != null)) {
            dst.set(FIELD_DALOG_ID, et.getDALOG_Id());
        }
        if (et.isDALOG_NameDirty() && (bIncEmpty || et.getDALOG_Name() != null)) {
            dst.set(FIELD_DALOG_NAME, et.getDALOG_Name());
        }
        if (et.isLogInfoDirty() && (bIncEmpty || et.getLogInfo() != null)) {
            dst.set(FIELD_LOGINFO, et.getLogInfo());
        }
        if (et.isLogSNDirty() && (bIncEmpty || et.getLogSN() != null)) {
            dst.set(FIELD_LOGSN, et.getLogSN());
        }
        if (et.isLOGTypeDirty() && (bIncEmpty || et.getLOGType() != null)) {
            dst.set(FIELD_LOGTYPE, et.getLOGType());
        }
        if (et.isObjectIdDirty() && (bIncEmpty || et.getObjectId() != null)) {
            dst.set(FIELD_OBJECTID, et.getObjectId());
        }
        if (et.isObjectTypeDirty() && (bIncEmpty || et.getObjectType() != null)) {
            dst.set(FIELD_OBJECTTYPE, et.getObjectType());
        }
        if (et.isRemoteAddrDirty() && (bIncEmpty || et.getRemoteAddr() != null)) {
            dst.set(FIELD_REMOTEADDR, et.getRemoteAddr());
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
        return DALogBase.remove(this, index);
    }

    private static boolean remove(DALogBase et, int index) throws Exception {
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
                et.resetDALOG_Id();
                return true;
            }
            case 3: {
                et.resetDALOG_Name();
                return true;
            }
            case 4: {
                et.resetLogInfo();
                return true;
            }
            case 5: {
                et.resetLogSN();
                return true;
            }
            case 6: {
                et.resetLOGType();
                return true;
            }
            case 7: {
                et.resetObjectId();
                return true;
            }
            case 8: {
                et.resetObjectType();
                return true;
            }
            case 9: {
                et.resetRemoteAddr();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private DALogBase getProxyEntity() {
        return this.proxyDALogBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDALogBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DALogBase) {
            this.proxyDALogBase = (DALogBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DALogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

