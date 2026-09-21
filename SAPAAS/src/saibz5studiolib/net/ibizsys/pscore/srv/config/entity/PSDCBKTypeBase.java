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

public abstract class PSDCBKTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCBKTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCBKTYPEID = "PSDCBKTYPEID";
    public static final String FIELD_PSDCBKTYPENAME = "PSDCBKTYPENAME";
    public static final String FIELD_TASKOBJ = "TASKOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEROBOTFLAG = "USEROBOTFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDCBKTYPEID = 4;
    private static final int INDEX_PSDCBKTYPENAME = 5;
    private static final int INDEX_TASKOBJ = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_USEROBOTFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCBKTypeBase proxyPSDCBKTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcbktypeidDirtyFlag = false;
    private boolean psdcbktypenameDirtyFlag = false;
    private boolean taskobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userobotflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcbktypeid")
    private String psdcbktypeid;
    @Column(name="psdcbktypename")
    private String psdcbktypename;
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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSDCBKTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBKTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbktypeid = string;
        this.psdcbktypeidDirtyFlag = true;
    }

    public String getPSDCBKTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBKTypeId();
        }
        return this.psdcbktypeid;
    }

    public boolean isPSDCBKTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBKTypeIdDirty();
        }
        return this.psdcbktypeidDirtyFlag;
    }

    public void resetPSDCBKTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBKTypeId();
            return;
        }
        this.psdcbktypeidDirtyFlag = false;
        this.psdcbktypeid = null;
    }

    public void setPSDCBKTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBKTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbktypename = string;
        this.psdcbktypenameDirtyFlag = true;
    }

    public String getPSDCBKTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBKTypeName();
        }
        return this.psdcbktypename;
    }

    public boolean isPSDCBKTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBKTypeNameDirty();
        }
        return this.psdcbktypenameDirtyFlag;
    }

    public void resetPSDCBKTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBKTypeName();
            return;
        }
        this.psdcbktypenameDirtyFlag = false;
        this.psdcbktypename = null;
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
        PSDCBKTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCBKTypeBase pSDCBKTypeBase) {
        pSDCBKTypeBase.resetCreateDate();
        pSDCBKTypeBase.resetCreateMan();
        pSDCBKTypeBase.resetEnable();
        pSDCBKTypeBase.resetMemo();
        pSDCBKTypeBase.resetPSDCBKTypeId();
        pSDCBKTypeBase.resetPSDCBKTypeName();
        pSDCBKTypeBase.resetTaskObj();
        pSDCBKTypeBase.resetUpdateDate();
        pSDCBKTypeBase.resetUpdateMan();
        pSDCBKTypeBase.resetUseRobotFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCBKTypeIdDirty()) {
            hashMap.put(FIELD_PSDCBKTYPEID, this.getPSDCBKTypeId());
        }
        if (!bl || this.isPSDCBKTypeNameDirty()) {
            hashMap.put(FIELD_PSDCBKTYPENAME, this.getPSDCBKTypeName());
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
        return PSDCBKTypeBase.get(this, n);
    }

    private static Object get(PSDCBKTypeBase pSDCBKTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTypeBase.getCreateDate();
            }
            case 1: {
                return pSDCBKTypeBase.getCreateMan();
            }
            case 2: {
                return pSDCBKTypeBase.getEnable();
            }
            case 3: {
                return pSDCBKTypeBase.getMemo();
            }
            case 4: {
                return pSDCBKTypeBase.getPSDCBKTypeId();
            }
            case 5: {
                return pSDCBKTypeBase.getPSDCBKTypeName();
            }
            case 6: {
                return pSDCBKTypeBase.getTaskObj();
            }
            case 7: {
                return pSDCBKTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDCBKTypeBase.getUpdateMan();
            }
            case 9: {
                return pSDCBKTypeBase.getUseRobotFlag();
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
        PSDCBKTypeBase.set(this, n, object);
    }

    private static void set(PSDCBKTypeBase pSDCBKTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCBKTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCBKTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCBKTypeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCBKTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCBKTypeBase.setPSDCBKTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCBKTypeBase.setPSDCBKTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCBKTypeBase.setTaskObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCBKTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDCBKTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCBKTypeBase.setUseRobotFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCBKTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDCBKTypeBase pSDCBKTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCBKTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCBKTypeBase.getEnable() == null;
            }
            case 3: {
                return pSDCBKTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDCBKTypeBase.getPSDCBKTypeId() == null;
            }
            case 5: {
                return pSDCBKTypeBase.getPSDCBKTypeName() == null;
            }
            case 6: {
                return pSDCBKTypeBase.getTaskObj() == null;
            }
            case 7: {
                return pSDCBKTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDCBKTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSDCBKTypeBase.getUseRobotFlag() == null;
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
        return PSDCBKTypeBase.contains(this, n);
    }

    private static boolean contains(PSDCBKTypeBase pSDCBKTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCBKTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDCBKTypeBase.isEnableDirty();
            }
            case 3: {
                return pSDCBKTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDCBKTypeBase.isPSDCBKTypeIdDirty();
            }
            case 5: {
                return pSDCBKTypeBase.isPSDCBKTypeNameDirty();
            }
            case 6: {
                return pSDCBKTypeBase.isTaskObjDirty();
            }
            case 7: {
                return pSDCBKTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDCBKTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSDCBKTypeBase.isUseRobotFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCBKTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCBKTypeBase pSDCBKTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCBKTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getEnable()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getPSDCBKTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbktypeid", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getPSDCBKTypeId()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getPSDCBKTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbktypename", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getPSDCBKTypeName()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getTaskObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskobj", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getTaskObj()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCBKTypeBase.getUseRobotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userobotflag", (Object)PSDCBKTypeBase.getJSONValue((Object)pSDCBKTypeBase.getUseRobotFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCBKTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCBKTypeBase pSDCBKTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCBKTypeBase.getCreateDate() != null) {
            object = pSDCBKTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTypeBase.getCreateMan() != null) {
            object = pSDCBKTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getEnable() != null) {
            object = pSDCBKTypeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTypeBase.getMemo() != null) {
            object = pSDCBKTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getPSDCBKTypeId() != null) {
            object = pSDCBKTypeBase.getPSDCBKTypeId();
            xmlNode.setAttribute(FIELD_PSDCBKTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getPSDCBKTypeName() != null) {
            object = pSDCBKTypeBase.getPSDCBKTypeName();
            xmlNode.setAttribute(FIELD_PSDCBKTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getTaskObj() != null) {
            object = pSDCBKTypeBase.getTaskObj();
            xmlNode.setAttribute(FIELD_TASKOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getUpdateDate() != null) {
            object = pSDCBKTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTypeBase.getUpdateMan() != null) {
            object = pSDCBKTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTypeBase.getUseRobotFlag() != null) {
            object = pSDCBKTypeBase.getUseRobotFlag();
            xmlNode.setAttribute(FIELD_USEROBOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCBKTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCBKTypeBase pSDCBKTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCBKTypeBase.isCreateDateDirty() && (bl || pSDCBKTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCBKTypeBase.getCreateDate());
        }
        if (pSDCBKTypeBase.isCreateManDirty() && (bl || pSDCBKTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCBKTypeBase.getCreateMan());
        }
        if (pSDCBKTypeBase.isEnableDirty() && (bl || pSDCBKTypeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDCBKTypeBase.getEnable());
        }
        if (pSDCBKTypeBase.isMemoDirty() && (bl || pSDCBKTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCBKTypeBase.getMemo());
        }
        if (pSDCBKTypeBase.isPSDCBKTypeIdDirty() && (bl || pSDCBKTypeBase.getPSDCBKTypeId() != null)) {
            iDataObject.set(FIELD_PSDCBKTYPEID, (Object)pSDCBKTypeBase.getPSDCBKTypeId());
        }
        if (pSDCBKTypeBase.isPSDCBKTypeNameDirty() && (bl || pSDCBKTypeBase.getPSDCBKTypeName() != null)) {
            iDataObject.set(FIELD_PSDCBKTYPENAME, (Object)pSDCBKTypeBase.getPSDCBKTypeName());
        }
        if (pSDCBKTypeBase.isTaskObjDirty() && (bl || pSDCBKTypeBase.getTaskObj() != null)) {
            iDataObject.set(FIELD_TASKOBJ, (Object)pSDCBKTypeBase.getTaskObj());
        }
        if (pSDCBKTypeBase.isUpdateDateDirty() && (bl || pSDCBKTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCBKTypeBase.getUpdateDate());
        }
        if (pSDCBKTypeBase.isUpdateManDirty() && (bl || pSDCBKTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCBKTypeBase.getUpdateMan());
        }
        if (pSDCBKTypeBase.isUseRobotFlagDirty() && (bl || pSDCBKTypeBase.getUseRobotFlag() != null)) {
            iDataObject.set(FIELD_USEROBOTFLAG, (Object)pSDCBKTypeBase.getUseRobotFlag());
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
        return PSDCBKTypeBase.remove(this, n);
    }

    private static boolean remove(PSDCBKTypeBase pSDCBKTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCBKTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCBKTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCBKTypeBase.resetEnable();
                return true;
            }
            case 3: {
                pSDCBKTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDCBKTypeBase.resetPSDCBKTypeId();
                return true;
            }
            case 5: {
                pSDCBKTypeBase.resetPSDCBKTypeName();
                return true;
            }
            case 6: {
                pSDCBKTypeBase.resetTaskObj();
                return true;
            }
            case 7: {
                pSDCBKTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDCBKTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSDCBKTypeBase.resetUseRobotFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCBKTypeBase getProxyEntity() {
        return this.proxyPSDCBKTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCBKTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCBKTypeBase) {
            this.proxyPSDCBKTypeBase = (PSDCBKTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCBKTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDCBKTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDCBKTYPENAME, 5);
        fieldIndexMap.put(FIELD_TASKOBJ, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_USEROBOTFLAG, 9);
    }
}

