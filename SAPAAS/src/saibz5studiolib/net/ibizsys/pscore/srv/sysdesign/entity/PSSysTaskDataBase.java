/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTaskDataBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTaskDataBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSYSTASKDATAID = "PSSYSTASKDATAID";
    public static final String FIELD_PSSYSTASKDATANAME = "PSSYSTASKDATANAME";
    public static final String FIELD_PSSYSTASKID = "PSSYSTASKID";
    public static final String FIELD_PSSYSTASKNAME = "PSSYSTASKNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_PSSYSTASKDATAID = 3;
    private static final int INDEX_PSSYSTASKDATANAME = 4;
    private static final int INDEX_PSSYSTASKID = 5;
    private static final int INDEX_PSSYSTASKNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTaskDataBase proxyPSSysTaskDataBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssystaskdataidDirtyFlag = false;
    private boolean pssystaskdatanameDirtyFlag = false;
    private boolean pssystaskidDirtyFlag = false;
    private boolean pssystasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssystaskdataid")
    private String pssystaskdataid;
    @Column(name="pssystaskdataname")
    private String pssystaskdataname;
    @Column(name="pssystaskid")
    private String pssystaskid;
    @Column(name="pssystaskname")
    private String pssystaskname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysTaskLock = new Integer(1);
    private PSSysTask pssystask = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
    }

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

    public void setPSSysTaskDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskdataid = string;
        this.pssystaskdataidDirtyFlag = true;
    }

    public String getPSSysTaskDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskDataId();
        }
        return this.pssystaskdataid;
    }

    public boolean isPSSysTaskDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskDataIdDirty();
        }
        return this.pssystaskdataidDirtyFlag;
    }

    public void resetPSSysTaskDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskDataId();
            return;
        }
        this.pssystaskdataidDirtyFlag = false;
        this.pssystaskdataid = null;
    }

    public void setPSSysTaskDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskdataname = string;
        this.pssystaskdatanameDirtyFlag = true;
    }

    public String getPSSysTaskDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskDataName();
        }
        return this.pssystaskdataname;
    }

    public boolean isPSSysTaskDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskDataNameDirty();
        }
        return this.pssystaskdatanameDirtyFlag;
    }

    public void resetPSSysTaskDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskDataName();
            return;
        }
        this.pssystaskdatanameDirtyFlag = false;
        this.pssystaskdataname = null;
    }

    public void setPSSysTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskid = string;
        this.pssystaskidDirtyFlag = true;
    }

    public String getPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskId();
        }
        return this.pssystaskid;
    }

    public boolean isPSSysTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskIdDirty();
        }
        return this.pssystaskidDirtyFlag;
    }

    public void resetPSSysTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskId();
            return;
        }
        this.pssystaskidDirtyFlag = false;
        this.pssystaskid = null;
    }

    public void setPSSysTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystaskname = string;
        this.pssystasknameDirtyFlag = true;
    }

    public String getPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTaskName();
        }
        return this.pssystaskname;
    }

    public boolean isPSSysTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTaskNameDirty();
        }
        return this.pssystasknameDirtyFlag;
    }

    public void resetPSSysTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTaskName();
            return;
        }
        this.pssystasknameDirtyFlag = false;
        this.pssystaskname = null;
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
        PSSysTaskDataBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTaskDataBase pSSysTaskDataBase) {
        pSSysTaskDataBase.resetContent();
        pSSysTaskDataBase.resetCreateDate();
        pSSysTaskDataBase.resetCreateMan();
        pSSysTaskDataBase.resetPSSysTaskDataId();
        pSSysTaskDataBase.resetPSSysTaskDataName();
        pSSysTaskDataBase.resetPSSysTaskId();
        pSSysTaskDataBase.resetPSSysTaskName();
        pSSysTaskDataBase.resetUpdateDate();
        pSSysTaskDataBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSysTaskDataIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKDATAID, this.getPSSysTaskDataId());
        }
        if (!bl || this.isPSSysTaskDataNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKDATANAME, this.getPSSysTaskDataName());
        }
        if (!bl || this.isPSSysTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSTASKID, this.getPSSysTaskId());
        }
        if (!bl || this.isPSSysTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSTASKNAME, this.getPSSysTaskName());
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
        return PSSysTaskDataBase.get(this, n);
    }

    private static Object get(PSSysTaskDataBase pSSysTaskDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskDataBase.getContent();
            }
            case 1: {
                return pSSysTaskDataBase.getCreateDate();
            }
            case 2: {
                return pSSysTaskDataBase.getCreateMan();
            }
            case 3: {
                return pSSysTaskDataBase.getPSSysTaskDataId();
            }
            case 4: {
                return pSSysTaskDataBase.getPSSysTaskDataName();
            }
            case 5: {
                return pSSysTaskDataBase.getPSSysTaskId();
            }
            case 6: {
                return pSSysTaskDataBase.getPSSysTaskName();
            }
            case 7: {
                return pSSysTaskDataBase.getUpdateDate();
            }
            case 8: {
                return pSSysTaskDataBase.getUpdateMan();
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
        PSSysTaskDataBase.set(this, n, object);
    }

    private static void set(PSSysTaskDataBase pSSysTaskDataBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTaskDataBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTaskDataBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTaskDataBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTaskDataBase.setPSSysTaskDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTaskDataBase.setPSSysTaskDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysTaskDataBase.setPSSysTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTaskDataBase.setPSSysTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTaskDataBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysTaskDataBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysTaskDataBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTaskDataBase pSSysTaskDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskDataBase.getContent() == null;
            }
            case 1: {
                return pSSysTaskDataBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTaskDataBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTaskDataBase.getPSSysTaskDataId() == null;
            }
            case 4: {
                return pSSysTaskDataBase.getPSSysTaskDataName() == null;
            }
            case 5: {
                return pSSysTaskDataBase.getPSSysTaskId() == null;
            }
            case 6: {
                return pSSysTaskDataBase.getPSSysTaskName() == null;
            }
            case 7: {
                return pSSysTaskDataBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSysTaskDataBase.getUpdateMan() == null;
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
        return PSSysTaskDataBase.contains(this, n);
    }

    private static boolean contains(PSSysTaskDataBase pSSysTaskDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTaskDataBase.isContentDirty();
            }
            case 1: {
                return pSSysTaskDataBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTaskDataBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTaskDataBase.isPSSysTaskDataIdDirty();
            }
            case 4: {
                return pSSysTaskDataBase.isPSSysTaskDataNameDirty();
            }
            case 5: {
                return pSSysTaskDataBase.isPSSysTaskIdDirty();
            }
            case 6: {
                return pSSysTaskDataBase.isPSSysTaskNameDirty();
            }
            case 7: {
                return pSSysTaskDataBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSysTaskDataBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTaskDataBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTaskDataBase pSSysTaskDataBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTaskDataBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getContent()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskdataid", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getPSSysTaskDataId()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskdataname", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getPSSysTaskDataName()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskid", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getPSSysTaskId()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystaskname", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getPSSysTaskName()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTaskDataBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTaskDataBase.getJSONValue((Object)pSSysTaskDataBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTaskDataBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTaskDataBase pSSysTaskDataBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTaskDataBase.getContent() != null) {
            object = pSSysTaskDataBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getCreateDate() != null) {
            object = pSSysTaskDataBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTaskDataBase.getCreateMan() != null) {
            object = pSSysTaskDataBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskDataId() != null) {
            object = pSSysTaskDataBase.getPSSysTaskDataId();
            xmlNode.setAttribute(FIELD_PSSYSTASKDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskDataName() != null) {
            object = pSSysTaskDataBase.getPSSysTaskDataName();
            xmlNode.setAttribute(FIELD_PSSYSTASKDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskId() != null) {
            object = pSSysTaskDataBase.getPSSysTaskId();
            xmlNode.setAttribute(FIELD_PSSYSTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getPSSysTaskName() != null) {
            object = pSSysTaskDataBase.getPSSysTaskName();
            xmlNode.setAttribute(FIELD_PSSYSTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTaskDataBase.getUpdateDate() != null) {
            object = pSSysTaskDataBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTaskDataBase.getUpdateMan() != null) {
            object = pSSysTaskDataBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTaskDataBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTaskDataBase pSSysTaskDataBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTaskDataBase.isContentDirty() && (bl || pSSysTaskDataBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSSysTaskDataBase.getContent());
        }
        if (pSSysTaskDataBase.isCreateDateDirty() && (bl || pSSysTaskDataBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTaskDataBase.getCreateDate());
        }
        if (pSSysTaskDataBase.isCreateManDirty() && (bl || pSSysTaskDataBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTaskDataBase.getCreateMan());
        }
        if (pSSysTaskDataBase.isPSSysTaskDataIdDirty() && (bl || pSSysTaskDataBase.getPSSysTaskDataId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKDATAID, (Object)pSSysTaskDataBase.getPSSysTaskDataId());
        }
        if (pSSysTaskDataBase.isPSSysTaskDataNameDirty() && (bl || pSSysTaskDataBase.getPSSysTaskDataName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKDATANAME, (Object)pSSysTaskDataBase.getPSSysTaskDataName());
        }
        if (pSSysTaskDataBase.isPSSysTaskIdDirty() && (bl || pSSysTaskDataBase.getPSSysTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSTASKID, (Object)pSSysTaskDataBase.getPSSysTaskId());
        }
        if (pSSysTaskDataBase.isPSSysTaskNameDirty() && (bl || pSSysTaskDataBase.getPSSysTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSTASKNAME, (Object)pSSysTaskDataBase.getPSSysTaskName());
        }
        if (pSSysTaskDataBase.isUpdateDateDirty() && (bl || pSSysTaskDataBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTaskDataBase.getUpdateDate());
        }
        if (pSSysTaskDataBase.isUpdateManDirty() && (bl || pSSysTaskDataBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTaskDataBase.getUpdateMan());
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
        return PSSysTaskDataBase.remove(this, n);
    }

    private static boolean remove(PSSysTaskDataBase pSSysTaskDataBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTaskDataBase.resetContent();
                return true;
            }
            case 1: {
                pSSysTaskDataBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTaskDataBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTaskDataBase.resetPSSysTaskDataId();
                return true;
            }
            case 4: {
                pSSysTaskDataBase.resetPSSysTaskDataName();
                return true;
            }
            case 5: {
                pSSysTaskDataBase.resetPSSysTaskId();
                return true;
            }
            case 6: {
                pSSysTaskDataBase.resetPSSysTaskName();
                return true;
            }
            case 7: {
                pSSysTaskDataBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSysTaskDataBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTask getPSSysTask() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTask();
        }
        if (this.getPSSysTaskId() == null) {
            return null;
        }
        Integer n = this.objPSSysTaskLock;
        synchronized (n) {
            if (this.pssystask != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTaskId(), (Object)this.pssystask.getPSSysTaskId()) != 0L) {
                this.pssystask = null;
            }
            if (this.pssystask == null) {
                PSSysTask pSSysTask = new PSSysTask();
                pSSysTask.setPSSysTaskId(this.getPSSysTaskId());
                PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
                pSSysTaskService.autoGet((IEntity)pSSysTask);
                this.pssystask = pSSysTask;
            }
            return this.pssystask;
        }
    }

    private PSSysTaskDataBase getProxyEntity() {
        return this.proxyPSSysTaskDataBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTaskDataBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTaskDataBase) {
            this.proxyPSSysTaskDataBase = (PSSysTaskDataBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskDataService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_PSSYSTASKDATAID, 3);
        fieldIndexMap.put(FIELD_PSSYSTASKDATANAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTASKID, 5);
        fieldIndexMap.put(FIELD_PSSYSTASKNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

