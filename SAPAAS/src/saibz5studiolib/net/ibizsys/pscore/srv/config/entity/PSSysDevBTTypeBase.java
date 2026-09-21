/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

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
import org.hibernate.SessionFactory;

public abstract class PSSysDevBTTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDevBTTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSDEVBTTYPEID = "PSSYSDEVBTTYPEID";
    public static final String FIELD_PSSYSDEVBTTYPENAME = "PSSYSDEVBTTYPENAME";
    public static final String FIELD_TASKOBJ = "TASKOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEROBOTFLAG = "USEROBOTFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSDEVBTTYPEID = 3;
    private static final int INDEX_PSSYSDEVBTTYPENAME = 4;
    private static final int INDEX_TASKOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_USEROBOTFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDevBTTypeBase proxyPSSysDevBTTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysdevbttypeidDirtyFlag = false;
    private boolean pssysdevbttypenameDirtyFlag = false;
    private boolean taskobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userobotflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysdevbttypeid")
    private String pssysdevbttypeid;
    @Column(name="pssysdevbttypename")
    private String pssysdevbttypename;
    @Column(name="taskobj")
    private String taskobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userobotflag")
    private Integer userobotflag;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
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

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setPSSysDevBTTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevBTTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevbttypeid = string;
        this.pssysdevbttypeidDirtyFlag = true;
    }

    public String getPSSysDevBTTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBTTypeId();
        }
        return this.pssysdevbttypeid;
    }

    public boolean isPSSysDevBTTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevBTTypeIdDirty();
        }
        return this.pssysdevbttypeidDirtyFlag;
    }

    public void resetPSSysDevBTTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevBTTypeId();
            return;
        }
        this.pssysdevbttypeidDirtyFlag = false;
        this.pssysdevbttypeid = null;
    }

    public void setPSSysDevBTTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevBTTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevbttypename = string;
        this.pssysdevbttypenameDirtyFlag = true;
    }

    public String getPSSysDevBTTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBTTypeName();
        }
        return this.pssysdevbttypename;
    }

    public boolean isPSSysDevBTTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevBTTypeNameDirty();
        }
        return this.pssysdevbttypenameDirtyFlag;
    }

    public void resetPSSysDevBTTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevBTTypeName();
            return;
        }
        this.pssysdevbttypenameDirtyFlag = false;
        this.pssysdevbttypename = null;
    }

    public void setTaskObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskobj = string;
        this.taskobjDirtyFlag = true;
    }

    public String getTaskObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskObj();
        }
        return this.taskobj;
    }

    public boolean isTaskObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskObjDirty();
        }
        return this.taskobjDirtyFlag;
    }

    public void resetTaskObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskObj();
            return;
        }
        this.taskobjDirtyFlag = false;
        this.taskobj = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
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

    public void setUseRobotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUseRobotFlag(n);
            return;
        }
        this.userobotflag = n;
        this.userobotflagDirtyFlag = true;
    }

    public Integer getUseRobotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUseRobotFlag();
        }
        return this.userobotflag;
    }

    public boolean isUseRobotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUseRobotFlagDirty();
        }
        return this.userobotflagDirtyFlag;
    }

    public void resetUseRobotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUseRobotFlag();
            return;
        }
        this.userobotflagDirtyFlag = false;
        this.userobotflag = null;
    }

    protected void onReset() {
        PSSysDevBTTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDevBTTypeBase pSSysDevBTTypeBase) {
        pSSysDevBTTypeBase.resetCreateDate();
        pSSysDevBTTypeBase.resetCreateMan();
        pSSysDevBTTypeBase.resetMemo();
        pSSysDevBTTypeBase.resetPSSysDevBTTypeId();
        pSSysDevBTTypeBase.resetPSSysDevBTTypeName();
        pSSysDevBTTypeBase.resetTaskObj();
        pSSysDevBTTypeBase.resetUpdateDate();
        pSSysDevBTTypeBase.resetUpdateMan();
        pSSysDevBTTypeBase.resetUseRobotFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysDevBTTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVBTTYPEID, this.getPSSysDevBTTypeId());
        }
        if (!bl || this.isPSSysDevBTTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVBTTYPENAME, this.getPSSysDevBTTypeName());
        }
        if (!bl || this.isTaskObjDirty()) {
            hashMap.put(FIELD_TASKOBJ, this.getTaskObj());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUseRobotFlagDirty()) {
            hashMap.put(FIELD_USEROBOTFLAG, this.getUseRobotFlag());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSSysDevBTTypeBase.get(this, n);
    }

    private static Object get(PSSysDevBTTypeBase pSSysDevBTTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBTTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysDevBTTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysDevBTTypeBase.getMemo();
            }
            case 3: {
                return pSSysDevBTTypeBase.getPSSysDevBTTypeId();
            }
            case 4: {
                return pSSysDevBTTypeBase.getPSSysDevBTTypeName();
            }
            case 5: {
                return pSSysDevBTTypeBase.getTaskObj();
            }
            case 6: {
                return pSSysDevBTTypeBase.getUpdateDate();
            }
            case 7: {
                return pSSysDevBTTypeBase.getUpdateMan();
            }
            case 8: {
                return pSSysDevBTTypeBase.getUseRobotFlag();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSSysDevBTTypeBase.set(this, n, object);
    }

    private static void set(PSSysDevBTTypeBase pSSysDevBTTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevBTTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDevBTTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDevBTTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDevBTTypeBase.setPSSysDevBTTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDevBTTypeBase.setPSSysDevBTTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDevBTTypeBase.setTaskObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDevBTTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysDevBTTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDevBTTypeBase.setUseRobotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSSysDevBTTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDevBTTypeBase pSSysDevBTTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBTTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDevBTTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDevBTTypeBase.getMemo() == null;
            }
            case 3: {
                return pSSysDevBTTypeBase.getPSSysDevBTTypeId() == null;
            }
            case 4: {
                return pSSysDevBTTypeBase.getPSSysDevBTTypeName() == null;
            }
            case 5: {
                return pSSysDevBTTypeBase.getTaskObj() == null;
            }
            case 6: {
                return pSSysDevBTTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSysDevBTTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSSysDevBTTypeBase.getUseRobotFlag() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSSysDevBTTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysDevBTTypeBase pSSysDevBTTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBTTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDevBTTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDevBTTypeBase.isMemoDirty();
            }
            case 3: {
                return pSSysDevBTTypeBase.isPSSysDevBTTypeIdDirty();
            }
            case 4: {
                return pSSysDevBTTypeBase.isPSSysDevBTTypeNameDirty();
            }
            case 5: {
                return pSSysDevBTTypeBase.isTaskObjDirty();
            }
            case 6: {
                return pSSysDevBTTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSysDevBTTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSSysDevBTTypeBase.isUseRobotFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDevBTTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDevBTTypeBase pSSysDevBTTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDevBTTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevbttypeid", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getPSSysDevBTTypeId()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevbttypename", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getPSSysDevBTTypeName()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getTaskObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskobj", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getTaskObj()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDevBTTypeBase.getUseRobotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userobotflag", (Object)PSSysDevBTTypeBase.getJSONValue((Object)pSSysDevBTTypeBase.getUseRobotFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDevBTTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDevBTTypeBase pSSysDevBTTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDevBTTypeBase.getCreateDate() != null) {
            object = pSSysDevBTTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBTTypeBase.getCreateMan() != null) {
            object = pSSysDevBTTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getMemo() != null) {
            object = pSSysDevBTTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeId() != null) {
            object = pSSysDevBTTypeBase.getPSSysDevBTTypeId();
            xmlNode.setAttribute(FIELD_PSSYSDEVBTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeName() != null) {
            object = pSSysDevBTTypeBase.getPSSysDevBTTypeName();
            xmlNode.setAttribute(FIELD_PSSYSDEVBTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getTaskObj() != null) {
            object = pSSysDevBTTypeBase.getTaskObj();
            xmlNode.setAttribute(FIELD_TASKOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getUpdateDate() != null) {
            object = pSSysDevBTTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBTTypeBase.getUpdateMan() != null) {
            object = pSSysDevBTTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBTTypeBase.getUseRobotFlag() != null) {
            object = pSSysDevBTTypeBase.getUseRobotFlag();
            xmlNode.setAttribute(FIELD_USEROBOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDevBTTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDevBTTypeBase pSSysDevBTTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDevBTTypeBase.isCreateDateDirty() && (bl || pSSysDevBTTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDevBTTypeBase.getCreateDate());
        }
        if (pSSysDevBTTypeBase.isCreateManDirty() && (bl || pSSysDevBTTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDevBTTypeBase.getCreateMan());
        }
        if (pSSysDevBTTypeBase.isMemoDirty() && (bl || pSSysDevBTTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDevBTTypeBase.getMemo());
        }
        if (pSSysDevBTTypeBase.isPSSysDevBTTypeIdDirty() && (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVBTTYPEID, (Object)pSSysDevBTTypeBase.getPSSysDevBTTypeId());
        }
        if (pSSysDevBTTypeBase.isPSSysDevBTTypeNameDirty() && (bl || pSSysDevBTTypeBase.getPSSysDevBTTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVBTTYPENAME, (Object)pSSysDevBTTypeBase.getPSSysDevBTTypeName());
        }
        if (pSSysDevBTTypeBase.isTaskObjDirty() && (bl || pSSysDevBTTypeBase.getTaskObj() != null)) {
            iDataObject.set(FIELD_TASKOBJ, (Object)pSSysDevBTTypeBase.getTaskObj());
        }
        if (pSSysDevBTTypeBase.isUpdateDateDirty() && (bl || pSSysDevBTTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDevBTTypeBase.getUpdateDate());
        }
        if (pSSysDevBTTypeBase.isUpdateManDirty() && (bl || pSSysDevBTTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDevBTTypeBase.getUpdateMan());
        }
        if (pSSysDevBTTypeBase.isUseRobotFlagDirty() && (bl || pSSysDevBTTypeBase.getUseRobotFlag() != null)) {
            iDataObject.set(FIELD_USEROBOTFLAG, (Object)pSSysDevBTTypeBase.getUseRobotFlag());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSSysDevBTTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysDevBTTypeBase pSSysDevBTTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevBTTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDevBTTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDevBTTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysDevBTTypeBase.resetPSSysDevBTTypeId();
                return true;
            }
            case 4: {
                pSSysDevBTTypeBase.resetPSSysDevBTTypeName();
                return true;
            }
            case 5: {
                pSSysDevBTTypeBase.resetTaskObj();
                return true;
            }
            case 6: {
                pSSysDevBTTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSysDevBTTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSSysDevBTTypeBase.resetUseRobotFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysDevBTTypeBase getProxyEntity() {
        return this.proxyPSSysDevBTTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDevBTTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDevBTTypeBase) {
            this.proxyPSSysDevBTTypeBase = (PSSysDevBTTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysDevBTTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSDEVBTTYPEID, 3);
        fieldIndexMap.put(FIELD_PSSYSDEVBTTYPENAME, 4);
        fieldIndexMap.put(FIELD_TASKOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_USEROBOTFLAG, 8);
    }
}

