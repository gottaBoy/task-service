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

public abstract class DataAuditBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataAuditBase.class);
    public static final String FIELD_AUDITINFO = "AUDITINFO";
    public static final String FIELD_AUDITTYPE = "AUDITTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATAAUDITID = "DATAAUDITID";
    public static final String FIELD_DATAAUDITNAME = "DATAAUDITNAME";
    public static final String FIELD_IPADDRESS = "IPADDRESS";
    public static final String FIELD_OBJECTID = "OBJECTID";
    public static final String FIELD_OBJECTTYPE = "OBJECTTYPE";
    public static final String FIELD_OPPERSONID = "OPPERSONID";
    public static final String FIELD_OPPERSONNAME = "OPPERSONNAME";
    public static final String FIELD_SESSIONID = "SESSIONID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_AUDITINFO = 0;
    private static final int INDEX_AUDITTYPE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DATAAUDITID = 4;
    private static final int INDEX_DATAAUDITNAME = 5;
    private static final int INDEX_IPADDRESS = 6;
    private static final int INDEX_OBJECTID = 7;
    private static final int INDEX_OBJECTTYPE = 8;
    private static final int INDEX_OPPERSONID = 9;
    private static final int INDEX_OPPERSONNAME = 10;
    private static final int INDEX_SESSIONID = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DataAuditBase proxyDataAuditBase = null;
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

    static {
        fieldIndexMap.put(FIELD_AUDITINFO, 0);
        fieldIndexMap.put(FIELD_AUDITTYPE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATAAUDITID, 4);
        fieldIndexMap.put(FIELD_DATAAUDITNAME, 5);
        fieldIndexMap.put(FIELD_IPADDRESS, 6);
        fieldIndexMap.put(FIELD_OBJECTID, 7);
        fieldIndexMap.put(FIELD_OBJECTTYPE, 8);
        fieldIndexMap.put(FIELD_OPPERSONID, 9);
        fieldIndexMap.put(FIELD_OPPERSONNAME, 10);
        fieldIndexMap.put(FIELD_SESSIONID, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }

    public void setAuditInfo(String auditinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuditInfo(auditinfo);
            return;
        }
        if (auditinfo != null && (auditinfo = StringHelper.trimRight(auditinfo)).length() == 0) {
            auditinfo = null;
        }
        this.auditinfo = auditinfo;
        this.auditinfoDirtyFlag = true;
    }

    public String getAuditInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuditInfo();
        }
        return this.auditinfo;
    }

    public boolean isAuditInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuditInfoDirty();
        }
        return this.auditinfoDirtyFlag;
    }

    public void resetAuditInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuditInfo();
            return;
        }
        this.auditinfoDirtyFlag = false;
        this.auditinfo = null;
    }

    public void setAuditType(String audittype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAuditType(audittype);
            return;
        }
        if (audittype != null && (audittype = StringHelper.trimRight(audittype)).length() == 0) {
            audittype = null;
        }
        this.audittype = audittype;
        this.audittypeDirtyFlag = true;
    }

    public String getAuditType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAuditType();
        }
        return this.audittype;
    }

    public boolean isAuditTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAuditTypeDirty();
        }
        return this.audittypeDirtyFlag;
    }

    public void resetAuditType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAuditType();
            return;
        }
        this.audittypeDirtyFlag = false;
        this.audittype = null;
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

    public void setDataAuditId(String dataauditid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditId(dataauditid);
            return;
        }
        if (dataauditid != null && (dataauditid = StringHelper.trimRight(dataauditid)).length() == 0) {
            dataauditid = null;
        }
        this.dataauditid = dataauditid;
        this.dataauditidDirtyFlag = true;
    }

    public String getDataAuditId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditId();
        }
        return this.dataauditid;
    }

    public boolean isDataAuditIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditIdDirty();
        }
        return this.dataauditidDirtyFlag;
    }

    public void resetDataAuditId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditId();
            return;
        }
        this.dataauditidDirtyFlag = false;
        this.dataauditid = null;
    }

    public void setDataAuditName(String dataauditname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataAuditName(dataauditname);
            return;
        }
        if (dataauditname != null && (dataauditname = StringHelper.trimRight(dataauditname)).length() == 0) {
            dataauditname = null;
        }
        this.dataauditname = dataauditname;
        this.dataauditnameDirtyFlag = true;
    }

    public String getDataAuditName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataAuditName();
        }
        return this.dataauditname;
    }

    public boolean isDataAuditNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataAuditNameDirty();
        }
        return this.dataauditnameDirtyFlag;
    }

    public void resetDataAuditName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataAuditName();
            return;
        }
        this.dataauditnameDirtyFlag = false;
        this.dataauditname = null;
    }

    public void setIPAddress(String ipaddress) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIPAddress(ipaddress);
            return;
        }
        if (ipaddress != null && (ipaddress = StringHelper.trimRight(ipaddress)).length() == 0) {
            ipaddress = null;
        }
        this.ipaddress = ipaddress;
        this.ipaddressDirtyFlag = true;
    }

    public String getIPAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIPAddress();
        }
        return this.ipaddress;
    }

    public boolean isIPAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIPAddressDirty();
        }
        return this.ipaddressDirtyFlag;
    }

    public void resetIPAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIPAddress();
            return;
        }
        this.ipaddressDirtyFlag = false;
        this.ipaddress = null;
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

    public void setOpPersonId(String oppersonid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpPersonId(oppersonid);
            return;
        }
        if (oppersonid != null && (oppersonid = StringHelper.trimRight(oppersonid)).length() == 0) {
            oppersonid = null;
        }
        this.oppersonid = oppersonid;
        this.oppersonidDirtyFlag = true;
    }

    public String getOpPersonId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpPersonId();
        }
        return this.oppersonid;
    }

    public boolean isOpPersonIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpPersonIdDirty();
        }
        return this.oppersonidDirtyFlag;
    }

    public void resetOpPersonId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpPersonId();
            return;
        }
        this.oppersonidDirtyFlag = false;
        this.oppersonid = null;
    }

    public void setOpPersonName(String oppersonname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOpPersonName(oppersonname);
            return;
        }
        if (oppersonname != null && (oppersonname = StringHelper.trimRight(oppersonname)).length() == 0) {
            oppersonname = null;
        }
        this.oppersonname = oppersonname;
        this.oppersonnameDirtyFlag = true;
    }

    public String getOpPersonName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOpPersonName();
        }
        return this.oppersonname;
    }

    public boolean isOpPersonNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOpPersonNameDirty();
        }
        return this.oppersonnameDirtyFlag;
    }

    public void resetOpPersonName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOpPersonName();
            return;
        }
        this.oppersonnameDirtyFlag = false;
        this.oppersonname = null;
    }

    public void setSessionId(String sessionid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSessionId(sessionid);
            return;
        }
        if (sessionid != null && (sessionid = StringHelper.trimRight(sessionid)).length() == 0) {
            sessionid = null;
        }
        this.sessionid = sessionid;
        this.sessionidDirtyFlag = true;
    }

    public String getSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSessionId();
        }
        return this.sessionid;
    }

    public boolean isSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSessionIdDirty();
        }
        return this.sessionidDirtyFlag;
    }

    public void resetSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSessionId();
            return;
        }
        this.sessionidDirtyFlag = false;
        this.sessionid = null;
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
        DataAuditBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isAuditInfoDirty()) {
            params.put(FIELD_AUDITINFO, this.getAuditInfo());
        }
        if (!bDirtyOnly || this.isAuditTypeDirty()) {
            params.put(FIELD_AUDITTYPE, this.getAuditType());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDataAuditIdDirty()) {
            params.put(FIELD_DATAAUDITID, this.getDataAuditId());
        }
        if (!bDirtyOnly || this.isDataAuditNameDirty()) {
            params.put(FIELD_DATAAUDITNAME, this.getDataAuditName());
        }
        if (!bDirtyOnly || this.isIPAddressDirty()) {
            params.put(FIELD_IPADDRESS, this.getIPAddress());
        }
        if (!bDirtyOnly || this.isObjectIdDirty()) {
            params.put(FIELD_OBJECTID, this.getObjectId());
        }
        if (!bDirtyOnly || this.isObjectTypeDirty()) {
            params.put(FIELD_OBJECTTYPE, this.getObjectType());
        }
        if (!bDirtyOnly || this.isOpPersonIdDirty()) {
            params.put(FIELD_OPPERSONID, this.getOpPersonId());
        }
        if (!bDirtyOnly || this.isOpPersonNameDirty()) {
            params.put(FIELD_OPPERSONNAME, this.getOpPersonName());
        }
        if (!bDirtyOnly || this.isSessionIdDirty()) {
            params.put(FIELD_SESSIONID, this.getSessionId());
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
        return DataAuditBase.get(this, index);
    }

    private static Object get(DataAuditBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAuditInfo();
            }
            case 1: {
                return et.getAuditType();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getDataAuditId();
            }
            case 5: {
                return et.getDataAuditName();
            }
            case 6: {
                return et.getIPAddress();
            }
            case 7: {
                return et.getObjectId();
            }
            case 8: {
                return et.getObjectType();
            }
            case 9: {
                return et.getOpPersonId();
            }
            case 10: {
                return et.getOpPersonName();
            }
            case 11: {
                return et.getSessionId();
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
        DataAuditBase.set(this, index, objValue);
    }

    private static void set(DataAuditBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setAuditInfo(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setAuditType(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDataAuditId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDataAuditName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setIPAddress(DataObject.getStringValue(obj));
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
                et.setOpPersonId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setOpPersonName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setSessionId(DataObject.getStringValue(obj));
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
        return DataAuditBase.isNull(this, index);
    }

    private static boolean isNull(DataAuditBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getAuditInfo() == null;
            }
            case 1: {
                return et.getAuditType() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getDataAuditId() == null;
            }
            case 5: {
                return et.getDataAuditName() == null;
            }
            case 6: {
                return et.getIPAddress() == null;
            }
            case 7: {
                return et.getObjectId() == null;
            }
            case 8: {
                return et.getObjectType() == null;
            }
            case 9: {
                return et.getOpPersonId() == null;
            }
            case 10: {
                return et.getOpPersonName() == null;
            }
            case 11: {
                return et.getSessionId() == null;
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
        return DataAuditBase.contains(this, index);
    }

    private static boolean contains(DataAuditBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isAuditInfoDirty();
            }
            case 1: {
                return et.isAuditTypeDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isDataAuditIdDirty();
            }
            case 5: {
                return et.isDataAuditNameDirty();
            }
            case 6: {
                return et.isIPAddressDirty();
            }
            case 7: {
                return et.isObjectIdDirty();
            }
            case 8: {
                return et.isObjectTypeDirty();
            }
            case 9: {
                return et.isOpPersonIdDirty();
            }
            case 10: {
                return et.isOpPersonNameDirty();
            }
            case 11: {
                return et.isSessionIdDirty();
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
        DataAuditBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DataAuditBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getAuditInfo() != null) {
            JSONObjectHelper.put(json, "auditinfo", DataAuditBase.getJSONValue(et.getAuditInfo()), false);
        }
        if (bIncEmpty || et.getAuditType() != null) {
            JSONObjectHelper.put(json, "audittype", DataAuditBase.getJSONValue(et.getAuditType()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DataAuditBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DataAuditBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDataAuditId() != null) {
            JSONObjectHelper.put(json, "dataauditid", DataAuditBase.getJSONValue(et.getDataAuditId()), false);
        }
        if (bIncEmpty || et.getDataAuditName() != null) {
            JSONObjectHelper.put(json, "dataauditname", DataAuditBase.getJSONValue(et.getDataAuditName()), false);
        }
        if (bIncEmpty || et.getIPAddress() != null) {
            JSONObjectHelper.put(json, "ipaddress", DataAuditBase.getJSONValue(et.getIPAddress()), false);
        }
        if (bIncEmpty || et.getObjectId() != null) {
            JSONObjectHelper.put(json, "objectid", DataAuditBase.getJSONValue(et.getObjectId()), false);
        }
        if (bIncEmpty || et.getObjectType() != null) {
            JSONObjectHelper.put(json, "objecttype", DataAuditBase.getJSONValue(et.getObjectType()), false);
        }
        if (bIncEmpty || et.getOpPersonId() != null) {
            JSONObjectHelper.put(json, "oppersonid", DataAuditBase.getJSONValue(et.getOpPersonId()), false);
        }
        if (bIncEmpty || et.getOpPersonName() != null) {
            JSONObjectHelper.put(json, "oppersonname", DataAuditBase.getJSONValue(et.getOpPersonName()), false);
        }
        if (bIncEmpty || et.getSessionId() != null) {
            JSONObjectHelper.put(json, "sessionid", DataAuditBase.getJSONValue(et.getSessionId()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DataAuditBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DataAuditBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DataAuditBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DataAuditBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getAuditInfo() != null) {
            obj = et.getAuditInfo();
            node.setAttribute(FIELD_AUDITINFO, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getAuditType() != null) {
            obj = et.getAuditType();
            node.setAttribute(FIELD_AUDITTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditId() != null) {
            obj = et.getDataAuditId();
            node.setAttribute(FIELD_DATAAUDITID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDataAuditName() != null) {
            obj = et.getDataAuditName();
            node.setAttribute(FIELD_DATAAUDITNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIPAddress() != null) {
            obj = et.getIPAddress();
            node.setAttribute(FIELD_IPADDRESS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getObjectId() != null) {
            obj = et.getObjectId();
            node.setAttribute(FIELD_OBJECTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getObjectType() != null) {
            obj = et.getObjectType();
            node.setAttribute(FIELD_OBJECTTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOpPersonId() != null) {
            obj = et.getOpPersonId();
            node.setAttribute(FIELD_OPPERSONID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOpPersonName() != null) {
            obj = et.getOpPersonName();
            node.setAttribute(FIELD_OPPERSONNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSessionId() != null) {
            obj = et.getSessionId();
            node.setAttribute(FIELD_SESSIONID, obj == null ? "" : (String)obj);
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
        DataAuditBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DataAuditBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isAuditInfoDirty() && (bIncEmpty || et.getAuditInfo() != null)) {
            dst.set(FIELD_AUDITINFO, et.getAuditInfo());
        }
        if (et.isAuditTypeDirty() && (bIncEmpty || et.getAuditType() != null)) {
            dst.set(FIELD_AUDITTYPE, et.getAuditType());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDataAuditIdDirty() && (bIncEmpty || et.getDataAuditId() != null)) {
            dst.set(FIELD_DATAAUDITID, et.getDataAuditId());
        }
        if (et.isDataAuditNameDirty() && (bIncEmpty || et.getDataAuditName() != null)) {
            dst.set(FIELD_DATAAUDITNAME, et.getDataAuditName());
        }
        if (et.isIPAddressDirty() && (bIncEmpty || et.getIPAddress() != null)) {
            dst.set(FIELD_IPADDRESS, et.getIPAddress());
        }
        if (et.isObjectIdDirty() && (bIncEmpty || et.getObjectId() != null)) {
            dst.set(FIELD_OBJECTID, et.getObjectId());
        }
        if (et.isObjectTypeDirty() && (bIncEmpty || et.getObjectType() != null)) {
            dst.set(FIELD_OBJECTTYPE, et.getObjectType());
        }
        if (et.isOpPersonIdDirty() && (bIncEmpty || et.getOpPersonId() != null)) {
            dst.set(FIELD_OPPERSONID, et.getOpPersonId());
        }
        if (et.isOpPersonNameDirty() && (bIncEmpty || et.getOpPersonName() != null)) {
            dst.set(FIELD_OPPERSONNAME, et.getOpPersonName());
        }
        if (et.isSessionIdDirty() && (bIncEmpty || et.getSessionId() != null)) {
            dst.set(FIELD_SESSIONID, et.getSessionId());
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
        return DataAuditBase.remove(this, index);
    }

    private static boolean remove(DataAuditBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetAuditInfo();
                return true;
            }
            case 1: {
                et.resetAuditType();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetDataAuditId();
                return true;
            }
            case 5: {
                et.resetDataAuditName();
                return true;
            }
            case 6: {
                et.resetIPAddress();
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
                et.resetOpPersonId();
                return true;
            }
            case 10: {
                et.resetOpPersonName();
                return true;
            }
            case 11: {
                et.resetSessionId();
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

    private DataAuditBase getProxyEntity() {
        return this.proxyDataAuditBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataAuditBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DataAuditBase) {
            this.proxyDataAuditBase = (DataAuditBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataAuditService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

