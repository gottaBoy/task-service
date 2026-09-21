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
package net.ibizsys.pscore.srv.def.entity;

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
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.service.PSV3MigrateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MGViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSV3MGViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSV3MGVIEWID = "PSV3MGVIEWID";
    public static final String FIELD_PSV3MGVIEWNAME = "PSV3MGVIEWNAME";
    public static final String FIELD_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String FIELD_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSV3MGVIEWID = 2;
    private static final int INDEX_PSV3MGVIEWNAME = 3;
    private static final int INDEX_PSV3MIGRATEID = 4;
    private static final int INDEX_PSV3MIGRATENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSV3MGViewBase proxyPSV3MGViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psv3mgviewidDirtyFlag = false;
    private boolean psv3mgviewnameDirtyFlag = false;
    private boolean psv3migrateidDirtyFlag = false;
    private boolean psv3migratenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psv3mgviewid")
    private String psv3mgviewid;
    @Column(name="psv3mgviewname")
    private String psv3mgviewname;
    @Column(name="psv3migrateid")
    private String psv3migrateid;
    @Column(name="psv3migratename")
    private String psv3migratename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsv3migrateLock = new Integer(1);
    private PSV3Migrate psv3migrate = null;

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

    public void setPSV3MGViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mgviewid = string;
        this.psv3mgviewidDirtyFlag = true;
    }

    public String getPSV3MGViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGViewId();
        }
        return this.psv3mgviewid;
    }

    public boolean isPSV3MGViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGViewIdDirty();
        }
        return this.psv3mgviewidDirtyFlag;
    }

    public void resetPSV3MGViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGViewId();
            return;
        }
        this.psv3mgviewidDirtyFlag = false;
        this.psv3mgviewid = null;
    }

    public void setPSV3MGViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mgviewname = string;
        this.psv3mgviewnameDirtyFlag = true;
    }

    public String getPSV3MGViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGViewName();
        }
        return this.psv3mgviewname;
    }

    public boolean isPSV3MGViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGViewNameDirty();
        }
        return this.psv3mgviewnameDirtyFlag;
    }

    public void resetPSV3MGViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGViewName();
            return;
        }
        this.psv3mgviewnameDirtyFlag = false;
        this.psv3mgviewname = null;
    }

    public void setPSV3MigrateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migrateid = string;
        this.psv3migrateidDirtyFlag = true;
    }

    public String getPSV3MigrateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateId();
        }
        return this.psv3migrateid;
    }

    public boolean isPSV3MigrateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateIdDirty();
        }
        return this.psv3migrateidDirtyFlag;
    }

    public void resetPSV3MigrateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateId();
            return;
        }
        this.psv3migrateidDirtyFlag = false;
        this.psv3migrateid = null;
    }

    public void setPSV3MigrateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migratename = string;
        this.psv3migratenameDirtyFlag = true;
    }

    public String getPSV3MigrateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateName();
        }
        return this.psv3migratename;
    }

    public boolean isPSV3MigrateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateNameDirty();
        }
        return this.psv3migratenameDirtyFlag;
    }

    public void resetPSV3MigrateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateName();
            return;
        }
        this.psv3migratenameDirtyFlag = false;
        this.psv3migratename = null;
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
        PSV3MGViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSV3MGViewBase pSV3MGViewBase) {
        pSV3MGViewBase.resetCreateDate();
        pSV3MGViewBase.resetCreateMan();
        pSV3MGViewBase.resetPSV3MGViewId();
        pSV3MGViewBase.resetPSV3MGViewName();
        pSV3MGViewBase.resetPSV3MigrateId();
        pSV3MGViewBase.resetPSV3MigrateName();
        pSV3MGViewBase.resetUpdateDate();
        pSV3MGViewBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSV3MGViewIdDirty()) {
            hashMap.put(FIELD_PSV3MGVIEWID, this.getPSV3MGViewId());
        }
        if (!bl || this.isPSV3MGViewNameDirty()) {
            hashMap.put(FIELD_PSV3MGVIEWNAME, this.getPSV3MGViewName());
        }
        if (!bl || this.isPSV3MigrateIdDirty()) {
            hashMap.put(FIELD_PSV3MIGRATEID, this.getPSV3MigrateId());
        }
        if (!bl || this.isPSV3MigrateNameDirty()) {
            hashMap.put(FIELD_PSV3MIGRATENAME, this.getPSV3MigrateName());
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
        return PSV3MGViewBase.get(this, n);
    }

    private static Object get(PSV3MGViewBase pSV3MGViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGViewBase.getCreateDate();
            }
            case 1: {
                return pSV3MGViewBase.getCreateMan();
            }
            case 2: {
                return pSV3MGViewBase.getPSV3MGViewId();
            }
            case 3: {
                return pSV3MGViewBase.getPSV3MGViewName();
            }
            case 4: {
                return pSV3MGViewBase.getPSV3MigrateId();
            }
            case 5: {
                return pSV3MGViewBase.getPSV3MigrateName();
            }
            case 6: {
                return pSV3MGViewBase.getUpdateDate();
            }
            case 7: {
                return pSV3MGViewBase.getUpdateMan();
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
        PSV3MGViewBase.set(this, n, object);
    }

    private static void set(PSV3MGViewBase pSV3MGViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSV3MGViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSV3MGViewBase.setPSV3MGViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSV3MGViewBase.setPSV3MGViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSV3MGViewBase.setPSV3MigrateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSV3MGViewBase.setPSV3MigrateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSV3MGViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSV3MGViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSV3MGViewBase.isNull(this, n);
    }

    private static boolean isNull(PSV3MGViewBase pSV3MGViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGViewBase.getCreateDate() == null;
            }
            case 1: {
                return pSV3MGViewBase.getCreateMan() == null;
            }
            case 2: {
                return pSV3MGViewBase.getPSV3MGViewId() == null;
            }
            case 3: {
                return pSV3MGViewBase.getPSV3MGViewName() == null;
            }
            case 4: {
                return pSV3MGViewBase.getPSV3MigrateId() == null;
            }
            case 5: {
                return pSV3MGViewBase.getPSV3MigrateName() == null;
            }
            case 6: {
                return pSV3MGViewBase.getUpdateDate() == null;
            }
            case 7: {
                return pSV3MGViewBase.getUpdateMan() == null;
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
        return PSV3MGViewBase.contains(this, n);
    }

    private static boolean contains(PSV3MGViewBase pSV3MGViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGViewBase.isCreateDateDirty();
            }
            case 1: {
                return pSV3MGViewBase.isCreateManDirty();
            }
            case 2: {
                return pSV3MGViewBase.isPSV3MGViewIdDirty();
            }
            case 3: {
                return pSV3MGViewBase.isPSV3MGViewNameDirty();
            }
            case 4: {
                return pSV3MGViewBase.isPSV3MigrateIdDirty();
            }
            case 5: {
                return pSV3MGViewBase.isPSV3MigrateNameDirty();
            }
            case 6: {
                return pSV3MGViewBase.isUpdateDateDirty();
            }
            case 7: {
                return pSV3MGViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSV3MGViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSV3MGViewBase pSV3MGViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSV3MGViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getPSV3MGViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mgviewid", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getPSV3MGViewId()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getPSV3MGViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mgviewname", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getPSV3MGViewName()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getPSV3MigrateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migrateid", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getPSV3MigrateId()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getPSV3MigrateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratename", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getPSV3MigrateName()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSV3MGViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSV3MGViewBase.getJSONValue((Object)pSV3MGViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSV3MGViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSV3MGViewBase pSV3MGViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSV3MGViewBase.getCreateDate() != null) {
            object = pSV3MGViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGViewBase.getCreateMan() != null) {
            object = pSV3MGViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGViewBase.getPSV3MGViewId() != null) {
            object = pSV3MGViewBase.getPSV3MGViewId();
            xmlNode.setAttribute(FIELD_PSV3MGVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGViewBase.getPSV3MGViewName() != null) {
            object = pSV3MGViewBase.getPSV3MGViewName();
            xmlNode.setAttribute(FIELD_PSV3MGVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGViewBase.getPSV3MigrateId() != null) {
            object = pSV3MGViewBase.getPSV3MigrateId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGViewBase.getPSV3MigrateName() != null) {
            object = pSV3MGViewBase.getPSV3MigrateName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGViewBase.getUpdateDate() != null) {
            object = pSV3MGViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGViewBase.getUpdateMan() != null) {
            object = pSV3MGViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSV3MGViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSV3MGViewBase pSV3MGViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSV3MGViewBase.isCreateDateDirty() && (bl || pSV3MGViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSV3MGViewBase.getCreateDate());
        }
        if (pSV3MGViewBase.isCreateManDirty() && (bl || pSV3MGViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSV3MGViewBase.getCreateMan());
        }
        if (pSV3MGViewBase.isPSV3MGViewIdDirty() && (bl || pSV3MGViewBase.getPSV3MGViewId() != null)) {
            iDataObject.set(FIELD_PSV3MGVIEWID, (Object)pSV3MGViewBase.getPSV3MGViewId());
        }
        if (pSV3MGViewBase.isPSV3MGViewNameDirty() && (bl || pSV3MGViewBase.getPSV3MGViewName() != null)) {
            iDataObject.set(FIELD_PSV3MGVIEWNAME, (Object)pSV3MGViewBase.getPSV3MGViewName());
        }
        if (pSV3MGViewBase.isPSV3MigrateIdDirty() && (bl || pSV3MGViewBase.getPSV3MigrateId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEID, (Object)pSV3MGViewBase.getPSV3MigrateId());
        }
        if (pSV3MGViewBase.isPSV3MigrateNameDirty() && (bl || pSV3MGViewBase.getPSV3MigrateName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATENAME, (Object)pSV3MGViewBase.getPSV3MigrateName());
        }
        if (pSV3MGViewBase.isUpdateDateDirty() && (bl || pSV3MGViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSV3MGViewBase.getUpdateDate());
        }
        if (pSV3MGViewBase.isUpdateManDirty() && (bl || pSV3MGViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSV3MGViewBase.getUpdateMan());
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
        return PSV3MGViewBase.remove(this, n);
    }

    private static boolean remove(PSV3MGViewBase pSV3MGViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGViewBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSV3MGViewBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSV3MGViewBase.resetPSV3MGViewId();
                return true;
            }
            case 3: {
                pSV3MGViewBase.resetPSV3MGViewName();
                return true;
            }
            case 4: {
                pSV3MGViewBase.resetPSV3MigrateId();
                return true;
            }
            case 5: {
                pSV3MGViewBase.resetPSV3MigrateName();
                return true;
            }
            case 6: {
                pSV3MGViewBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSV3MGViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSV3Migrate getPsv3migrate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsv3migrate();
        }
        if (this.getPSV3MigrateId() == null) {
            return null;
        }
        Integer n = this.objPsv3migrateLock;
        synchronized (n) {
            if (this.psv3migrate != null && DataTypeHelper.compare((int)25, (Object)this.getPSV3MigrateId(), (Object)this.psv3migrate.getPSV3MigrateId()) != 0L) {
                this.psv3migrate = null;
            }
            if (this.psv3migrate == null) {
                PSV3Migrate pSV3Migrate = new PSV3Migrate();
                pSV3Migrate.setPSV3MigrateId(this.getPSV3MigrateId());
                PSV3MigrateService pSV3MigrateService = (PSV3MigrateService)ServiceGlobal.getService(PSV3MigrateService.class, (SessionFactory)this.getSessionFactory());
                pSV3MigrateService.autoGet((IEntity)pSV3Migrate);
                this.psv3migrate = pSV3Migrate;
            }
            return this.psv3migrate;
        }
    }

    private PSV3MGViewBase getProxyEntity() {
        return this.proxyPSV3MGViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSV3MGViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSV3MGViewBase) {
            this.proxyPSV3MGViewBase = (PSV3MGViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MGViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSV3MGVIEWID, 2);
        fieldIndexMap.put(FIELD_PSV3MGVIEWNAME, 3);
        fieldIndexMap.put(FIELD_PSV3MIGRATEID, 4);
        fieldIndexMap.put(FIELD_PSV3MIGRATENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

