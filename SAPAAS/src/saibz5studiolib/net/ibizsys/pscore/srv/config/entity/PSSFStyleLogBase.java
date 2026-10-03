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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStyleLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFStyleLogBase.class);
    public static final String FIELD_CHANGELOG = "CHANGELOG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLELOGID = "PSSFSTYLELOGID";
    public static final String FIELD_PSSFSTYLELOGNAME = "PSSFSTYLELOGNAME";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CHANGELOG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_PSSFSTYLEID = 3;
    private static final int INDEX_PSSFSTYLELOGID = 4;
    private static final int INDEX_PSSFSTYLELOGNAME = 5;
    private static final int INDEX_PSSFSTYLENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFStyleLogBase proxyPSSFStyleLogBase = null;
    private boolean changelogDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylelogidDirtyFlag = false;
    private boolean pssfstylelognameDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="changelog")
    private String changelog;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylelogid")
    private String pssfstylelogid;
    @Column(name="pssfstylelogname")
    private String pssfstylelogname;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;

    public void setChangeLog(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChangeLog(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.changelog = string;
        this.changelogDirtyFlag = true;
    }

    public String getChangeLog() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChangeLog();
        }
        return this.changelog;
    }

    public boolean isChangeLogDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChangeLogDirty();
        }
        return this.changelogDirtyFlag;
    }

    public void resetChangeLog() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChangeLog();
            return;
        }
        this.changelogDirtyFlag = false;
        this.changelog = null;
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

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylelogid = string;
        this.pssfstylelogidDirtyFlag = true;
    }

    public String getPSSFStyleLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleLogId();
        }
        return this.pssfstylelogid;
    }

    public boolean isPSSFStyleLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleLogIdDirty();
        }
        return this.pssfstylelogidDirtyFlag;
    }

    public void resetPSSFStyleLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleLogId();
            return;
        }
        this.pssfstylelogidDirtyFlag = false;
        this.pssfstylelogid = null;
    }

    public void setPSSFStyleLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylelogname = string;
        this.pssfstylelognameDirtyFlag = true;
    }

    public String getPSSFStyleLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleLogName();
        }
        return this.pssfstylelogname;
    }

    public boolean isPSSFStyleLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleLogNameDirty();
        }
        return this.pssfstylelognameDirtyFlag;
    }

    public void resetPSSFStyleLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleLogName();
            return;
        }
        this.pssfstylelognameDirtyFlag = false;
        this.pssfstylelogname = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
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
        PSSFStyleLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFStyleLogBase pSSFStyleLogBase) {
        pSSFStyleLogBase.resetChangeLog();
        pSSFStyleLogBase.resetCreateDate();
        pSSFStyleLogBase.resetCreateMan();
        pSSFStyleLogBase.resetPSSFStyleId();
        pSSFStyleLogBase.resetPSSFStyleLogId();
        pSSFStyleLogBase.resetPSSFStyleLogName();
        pSSFStyleLogBase.resetPSSFStyleName();
        pSSFStyleLogBase.resetUpdateDate();
        pSSFStyleLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isChangeLogDirty()) {
            hashMap.put(FIELD_CHANGELOG, this.getChangeLog());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleLogIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLELOGID, this.getPSSFStyleLogId());
        }
        if (!bl || this.isPSSFStyleLogNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLELOGNAME, this.getPSSFStyleLogName());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
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
        return PSSFStyleLogBase.get(this, n);
    }

    private static Object get(PSSFStyleLogBase pSSFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleLogBase.getChangeLog();
            }
            case 1: {
                return pSSFStyleLogBase.getCreateDate();
            }
            case 2: {
                return pSSFStyleLogBase.getCreateMan();
            }
            case 3: {
                return pSSFStyleLogBase.getPSSFStyleId();
            }
            case 4: {
                return pSSFStyleLogBase.getPSSFStyleLogId();
            }
            case 5: {
                return pSSFStyleLogBase.getPSSFStyleLogName();
            }
            case 6: {
                return pSSFStyleLogBase.getPSSFStyleName();
            }
            case 7: {
                return pSSFStyleLogBase.getUpdateDate();
            }
            case 8: {
                return pSSFStyleLogBase.getUpdateMan();
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
        PSSFStyleLogBase.set(this, n, object);
    }

    private static void set(PSSFStyleLogBase pSSFStyleLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleLogBase.setChangeLog(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFStyleLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFStyleLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFStyleLogBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFStyleLogBase.setPSSFStyleLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFStyleLogBase.setPSSFStyleLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFStyleLogBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFStyleLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSFStyleLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFStyleLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSFStyleLogBase pSSFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleLogBase.getChangeLog() == null;
            }
            case 1: {
                return pSSFStyleLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFStyleLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFStyleLogBase.getPSSFStyleId() == null;
            }
            case 4: {
                return pSSFStyleLogBase.getPSSFStyleLogId() == null;
            }
            case 5: {
                return pSSFStyleLogBase.getPSSFStyleLogName() == null;
            }
            case 6: {
                return pSSFStyleLogBase.getPSSFStyleName() == null;
            }
            case 7: {
                return pSSFStyleLogBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSFStyleLogBase.getUpdateMan() == null;
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
        return PSSFStyleLogBase.contains(this, n);
    }

    private static boolean contains(PSSFStyleLogBase pSSFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFStyleLogBase.isChangeLogDirty();
            }
            case 1: {
                return pSSFStyleLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFStyleLogBase.isCreateManDirty();
            }
            case 3: {
                return pSSFStyleLogBase.isPSSFStyleIdDirty();
            }
            case 4: {
                return pSSFStyleLogBase.isPSSFStyleLogIdDirty();
            }
            case 5: {
                return pSSFStyleLogBase.isPSSFStyleLogNameDirty();
            }
            case 6: {
                return pSSFStyleLogBase.isPSSFStyleNameDirty();
            }
            case 7: {
                return pSSFStyleLogBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSFStyleLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFStyleLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFStyleLogBase pSSFStyleLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFStyleLogBase.getChangeLog() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"changelog", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getChangeLog()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylelogid", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getPSSFStyleLogId()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylelogname", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getPSSFStyleLogName()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFStyleLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFStyleLogBase.getJSONValue((Object)pSSFStyleLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFStyleLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFStyleLogBase pSSFStyleLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFStyleLogBase.getChangeLog() != null) {
            object = pSSFStyleLogBase.getChangeLog();
            xmlNode.setAttribute(FIELD_CHANGELOG, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getCreateDate() != null) {
            object = pSSFStyleLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleLogBase.getCreateMan() != null) {
            object = pSSFStyleLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleId() != null) {
            object = pSSFStyleLogBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleLogId() != null) {
            object = pSSFStyleLogBase.getPSSFStyleLogId();
            xmlNode.setAttribute(FIELD_PSSFSTYLELOGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleLogName() != null) {
            object = pSSFStyleLogBase.getPSSFStyleLogName();
            xmlNode.setAttribute(FIELD_PSSFSTYLELOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getPSSFStyleName() != null) {
            object = pSSFStyleLogBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFStyleLogBase.getUpdateDate() != null) {
            object = pSSFStyleLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFStyleLogBase.getUpdateMan() != null) {
            object = pSSFStyleLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFStyleLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFStyleLogBase pSSFStyleLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFStyleLogBase.isChangeLogDirty() && (bl || pSSFStyleLogBase.getChangeLog() != null)) {
            iDataObject.set(FIELD_CHANGELOG, (Object)pSSFStyleLogBase.getChangeLog());
        }
        if (pSSFStyleLogBase.isCreateDateDirty() && (bl || pSSFStyleLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFStyleLogBase.getCreateDate());
        }
        if (pSSFStyleLogBase.isCreateManDirty() && (bl || pSSFStyleLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFStyleLogBase.getCreateMan());
        }
        if (pSSFStyleLogBase.isPSSFStyleIdDirty() && (bl || pSSFStyleLogBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFStyleLogBase.getPSSFStyleId());
        }
        if (pSSFStyleLogBase.isPSSFStyleLogIdDirty() && (bl || pSSFStyleLogBase.getPSSFStyleLogId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLELOGID, (Object)pSSFStyleLogBase.getPSSFStyleLogId());
        }
        if (pSSFStyleLogBase.isPSSFStyleLogNameDirty() && (bl || pSSFStyleLogBase.getPSSFStyleLogName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLELOGNAME, (Object)pSSFStyleLogBase.getPSSFStyleLogName());
        }
        if (pSSFStyleLogBase.isPSSFStyleNameDirty() && (bl || pSSFStyleLogBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFStyleLogBase.getPSSFStyleName());
        }
        if (pSSFStyleLogBase.isUpdateDateDirty() && (bl || pSSFStyleLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFStyleLogBase.getUpdateDate());
        }
        if (pSSFStyleLogBase.isUpdateManDirty() && (bl || pSSFStyleLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFStyleLogBase.getUpdateMan());
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
        return PSSFStyleLogBase.remove(this, n);
    }

    private static boolean remove(PSSFStyleLogBase pSSFStyleLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFStyleLogBase.resetChangeLog();
                return true;
            }
            case 1: {
                pSSFStyleLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFStyleLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFStyleLogBase.resetPSSFStyleId();
                return true;
            }
            case 4: {
                pSSFStyleLogBase.resetPSSFStyleLogId();
                return true;
            }
            case 5: {
                pSSFStyleLogBase.resetPSSFStyleLogName();
                return true;
            }
            case 6: {
                pSSFStyleLogBase.resetPSSFStyleName();
                return true;
            }
            case 7: {
                pSSFStyleLogBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSFStyleLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
    }

    private PSSFStyleLogBase getProxyEntity() {
        return this.proxyPSSFStyleLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFStyleLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFStyleLogBase) {
            this.proxyPSSFStyleLogBase = (PSSFStyleLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHANGELOG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 3);
        fieldIndexMap.put(FIELD_PSSFSTYLELOGID, 4);
        fieldIndexMap.put(FIELD_PSSFSTYLELOGNAME, 5);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

