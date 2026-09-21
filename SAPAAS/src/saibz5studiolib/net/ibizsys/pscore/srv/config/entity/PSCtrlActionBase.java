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

public abstract class PSCtrlActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLACTIONID = "PSCTRLACTIONID";
    public static final String FIELD_PSCTRLACTIONNAME = "PSCTRLACTIONNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCTRLACTIONID = 4;
    private static final int INDEX_PSCTRLACTIONNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlActionBase proxyPSCtrlActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrlactionidDirtyFlag = false;
    private boolean psctrlactionnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrlactionid")
    private String psctrlactionid;
    @Column(name="psctrlactionname")
    private String psctrlactionname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSCtrlActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlactionid = string;
        this.psctrlactionidDirtyFlag = true;
    }

    public String getPSCtrlActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlActionId();
        }
        return this.psctrlactionid;
    }

    public boolean isPSCtrlActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlActionIdDirty();
        }
        return this.psctrlactionidDirtyFlag;
    }

    public void resetPSCtrlActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlActionId();
            return;
        }
        this.psctrlactionidDirtyFlag = false;
        this.psctrlactionid = null;
    }

    public void setPSCtrlActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlactionname = string;
        this.psctrlactionnameDirtyFlag = true;
    }

    public String getPSCtrlActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlActionName();
        }
        return this.psctrlactionname;
    }

    public boolean isPSCtrlActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlActionNameDirty();
        }
        return this.psctrlactionnameDirtyFlag;
    }

    public void resetPSCtrlActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlActionName();
            return;
        }
        this.psctrlactionnameDirtyFlag = false;
        this.psctrlactionname = null;
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

    protected void onReset() {
        PSCtrlActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlActionBase pSCtrlActionBase) {
        pSCtrlActionBase.resetCreateDate();
        pSCtrlActionBase.resetCreateMan();
        pSCtrlActionBase.resetLogicName();
        pSCtrlActionBase.resetMemo();
        pSCtrlActionBase.resetPSCtrlActionId();
        pSCtrlActionBase.resetPSCtrlActionName();
        pSCtrlActionBase.resetUpdateDate();
        pSCtrlActionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlActionIdDirty()) {
            hashMap.put(FIELD_PSCTRLACTIONID, this.getPSCtrlActionId());
        }
        if (!bl || this.isPSCtrlActionNameDirty()) {
            hashMap.put(FIELD_PSCTRLACTIONNAME, this.getPSCtrlActionName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSCtrlActionBase.get(this, n);
    }

    private static Object get(PSCtrlActionBase pSCtrlActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlActionBase.getCreateDate();
            }
            case 1: {
                return pSCtrlActionBase.getCreateMan();
            }
            case 2: {
                return pSCtrlActionBase.getLogicName();
            }
            case 3: {
                return pSCtrlActionBase.getMemo();
            }
            case 4: {
                return pSCtrlActionBase.getPSCtrlActionId();
            }
            case 5: {
                return pSCtrlActionBase.getPSCtrlActionName();
            }
            case 6: {
                return pSCtrlActionBase.getUpdateDate();
            }
            case 7: {
                return pSCtrlActionBase.getUpdateMan();
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
        PSCtrlActionBase.set(this, n, object);
    }

    private static void set(PSCtrlActionBase pSCtrlActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlActionBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlActionBase.setPSCtrlActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlActionBase.setPSCtrlActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCtrlActionBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlActionBase pSCtrlActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSCtrlActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSCtrlActionBase.getLogicName() == null;
            }
            case 3: {
                return pSCtrlActionBase.getMemo() == null;
            }
            case 4: {
                return pSCtrlActionBase.getPSCtrlActionId() == null;
            }
            case 5: {
                return pSCtrlActionBase.getPSCtrlActionName() == null;
            }
            case 6: {
                return pSCtrlActionBase.getUpdateDate() == null;
            }
            case 7: {
                return pSCtrlActionBase.getUpdateMan() == null;
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
        return PSCtrlActionBase.contains(this, n);
    }

    private static boolean contains(PSCtrlActionBase pSCtrlActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSCtrlActionBase.isCreateManDirty();
            }
            case 2: {
                return pSCtrlActionBase.isLogicNameDirty();
            }
            case 3: {
                return pSCtrlActionBase.isMemoDirty();
            }
            case 4: {
                return pSCtrlActionBase.isPSCtrlActionIdDirty();
            }
            case 5: {
                return pSCtrlActionBase.isPSCtrlActionNameDirty();
            }
            case 6: {
                return pSCtrlActionBase.isUpdateDateDirty();
            }
            case 7: {
                return pSCtrlActionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlActionBase pSCtrlActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getLogicName()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getPSCtrlActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlactionid", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getPSCtrlActionId()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getPSCtrlActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlactionname", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getPSCtrlActionName()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlActionBase.getJSONValue((Object)pSCtrlActionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlActionBase pSCtrlActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlActionBase.getCreateDate() != null) {
            object = pSCtrlActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlActionBase.getCreateMan() != null) {
            object = pSCtrlActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlActionBase.getLogicName() != null) {
            object = pSCtrlActionBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlActionBase.getMemo() != null) {
            object = pSCtrlActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlActionBase.getPSCtrlActionId() != null) {
            object = pSCtrlActionBase.getPSCtrlActionId();
            xmlNode.setAttribute(FIELD_PSCTRLACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlActionBase.getPSCtrlActionName() != null) {
            object = pSCtrlActionBase.getPSCtrlActionName();
            xmlNode.setAttribute(FIELD_PSCTRLACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlActionBase.getUpdateDate() != null) {
            object = pSCtrlActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlActionBase.getUpdateMan() != null) {
            object = pSCtrlActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlActionBase pSCtrlActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlActionBase.isCreateDateDirty() && (bl || pSCtrlActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlActionBase.getCreateDate());
        }
        if (pSCtrlActionBase.isCreateManDirty() && (bl || pSCtrlActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlActionBase.getCreateMan());
        }
        if (pSCtrlActionBase.isLogicNameDirty() && (bl || pSCtrlActionBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSCtrlActionBase.getLogicName());
        }
        if (pSCtrlActionBase.isMemoDirty() && (bl || pSCtrlActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlActionBase.getMemo());
        }
        if (pSCtrlActionBase.isPSCtrlActionIdDirty() && (bl || pSCtrlActionBase.getPSCtrlActionId() != null)) {
            iDataObject.set(FIELD_PSCTRLACTIONID, (Object)pSCtrlActionBase.getPSCtrlActionId());
        }
        if (pSCtrlActionBase.isPSCtrlActionNameDirty() && (bl || pSCtrlActionBase.getPSCtrlActionName() != null)) {
            iDataObject.set(FIELD_PSCTRLACTIONNAME, (Object)pSCtrlActionBase.getPSCtrlActionName());
        }
        if (pSCtrlActionBase.isUpdateDateDirty() && (bl || pSCtrlActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlActionBase.getUpdateDate());
        }
        if (pSCtrlActionBase.isUpdateManDirty() && (bl || pSCtrlActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlActionBase.getUpdateMan());
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
        return PSCtrlActionBase.remove(this, n);
    }

    private static boolean remove(PSCtrlActionBase pSCtrlActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCtrlActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCtrlActionBase.resetLogicName();
                return true;
            }
            case 3: {
                pSCtrlActionBase.resetMemo();
                return true;
            }
            case 4: {
                pSCtrlActionBase.resetPSCtrlActionId();
                return true;
            }
            case 5: {
                pSCtrlActionBase.resetPSCtrlActionName();
                return true;
            }
            case 6: {
                pSCtrlActionBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSCtrlActionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCtrlActionBase getProxyEntity() {
        return this.proxyPSCtrlActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlActionBase) {
            this.proxyPSCtrlActionBase = (PSCtrlActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCTRLACTIONID, 4);
        fieldIndexMap.put(FIELD_PSCTRLACTIONNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

