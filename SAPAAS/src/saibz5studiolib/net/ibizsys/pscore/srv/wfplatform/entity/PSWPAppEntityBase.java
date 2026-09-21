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
package net.ibizsys.pscore.srv.wfplatform.entity;

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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPAppEntityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPAppEntityBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSWPAPPENTITYID = "PSWPAPPENTITYID";
    public static final String FIELD_PSWPAPPENTITYNAME = "PSWPAPPENTITYNAME";
    public static final String FIELD_PSWPAPPID = "PSWPAPPID";
    public static final String FIELD_PSWPAPPNAME = "PSWPAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSWPAPPENTITYID = 2;
    private static final int INDEX_PSWPAPPENTITYNAME = 3;
    private static final int INDEX_PSWPAPPID = 4;
    private static final int INDEX_PSWPAPPNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPAppEntityBase proxyPSWPAppEntityBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean pswpappentityidDirtyFlag = false;
    private boolean pswpappentitynameDirtyFlag = false;
    private boolean pswpappidDirtyFlag = false;
    private boolean pswpappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="pswpappentityid")
    private String pswpappentityid;
    @Column(name="pswpappentityname")
    private String pswpappentityname;
    @Column(name="pswpappid")
    private String pswpappid;
    @Column(name="pswpappname")
    private String pswpappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSWPAppLock = new Integer(1);
    private PSWPApp pswpapp = null;

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

    public void setPSWPAppEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappentityid = string;
        this.pswpappentityidDirtyFlag = true;
    }

    public String getPSWPAppEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntityId();
        }
        return this.pswpappentityid;
    }

    public boolean isPSWPAppEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppEntityIdDirty();
        }
        return this.pswpappentityidDirtyFlag;
    }

    public void resetPSWPAppEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppEntityId();
            return;
        }
        this.pswpappentityidDirtyFlag = false;
        this.pswpappentityid = null;
    }

    public void setPSWPAppEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappentityname = string;
        this.pswpappentitynameDirtyFlag = true;
    }

    public String getPSWPAppEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntityName();
        }
        return this.pswpappentityname;
    }

    public boolean isPSWPAppEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppEntityNameDirty();
        }
        return this.pswpappentitynameDirtyFlag;
    }

    public void resetPSWPAppEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppEntityName();
            return;
        }
        this.pswpappentitynameDirtyFlag = false;
        this.pswpappentityname = null;
    }

    public void setPSWPAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappid = string;
        this.pswpappidDirtyFlag = true;
    }

    public String getPSWPAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppId();
        }
        return this.pswpappid;
    }

    public boolean isPSWPAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppIdDirty();
        }
        return this.pswpappidDirtyFlag;
    }

    public void resetPSWPAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppId();
            return;
        }
        this.pswpappidDirtyFlag = false;
        this.pswpappid = null;
    }

    public void setPSWPAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappname = string;
        this.pswpappnameDirtyFlag = true;
    }

    public String getPSWPAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppName();
        }
        return this.pswpappname;
    }

    public boolean isPSWPAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppNameDirty();
        }
        return this.pswpappnameDirtyFlag;
    }

    public void resetPSWPAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppName();
            return;
        }
        this.pswpappnameDirtyFlag = false;
        this.pswpappname = null;
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
        PSWPAppEntityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPAppEntityBase pSWPAppEntityBase) {
        pSWPAppEntityBase.resetCreateDate();
        pSWPAppEntityBase.resetCreateMan();
        pSWPAppEntityBase.resetPSWPAppEntityId();
        pSWPAppEntityBase.resetPSWPAppEntityName();
        pSWPAppEntityBase.resetPSWPAppId();
        pSWPAppEntityBase.resetPSWPAppName();
        pSWPAppEntityBase.resetUpdateDate();
        pSWPAppEntityBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSWPAppEntityIdDirty()) {
            hashMap.put(FIELD_PSWPAPPENTITYID, this.getPSWPAppEntityId());
        }
        if (!bl || this.isPSWPAppEntityNameDirty()) {
            hashMap.put(FIELD_PSWPAPPENTITYNAME, this.getPSWPAppEntityName());
        }
        if (!bl || this.isPSWPAppIdDirty()) {
            hashMap.put(FIELD_PSWPAPPID, this.getPSWPAppId());
        }
        if (!bl || this.isPSWPAppNameDirty()) {
            hashMap.put(FIELD_PSWPAPPNAME, this.getPSWPAppName());
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
        return PSWPAppEntityBase.get(this, n);
    }

    private static Object get(PSWPAppEntityBase pSWPAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppEntityBase.getCreateDate();
            }
            case 1: {
                return pSWPAppEntityBase.getCreateMan();
            }
            case 2: {
                return pSWPAppEntityBase.getPSWPAppEntityId();
            }
            case 3: {
                return pSWPAppEntityBase.getPSWPAppEntityName();
            }
            case 4: {
                return pSWPAppEntityBase.getPSWPAppId();
            }
            case 5: {
                return pSWPAppEntityBase.getPSWPAppName();
            }
            case 6: {
                return pSWPAppEntityBase.getUpdateDate();
            }
            case 7: {
                return pSWPAppEntityBase.getUpdateMan();
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
        PSWPAppEntityBase.set(this, n, object);
    }

    private static void set(PSWPAppEntityBase pSWPAppEntityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppEntityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPAppEntityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPAppEntityBase.setPSWPAppEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPAppEntityBase.setPSWPAppEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPAppEntityBase.setPSWPAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPAppEntityBase.setPSWPAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPAppEntityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWPAppEntityBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPAppEntityBase.isNull(this, n);
    }

    private static boolean isNull(PSWPAppEntityBase pSWPAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppEntityBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPAppEntityBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPAppEntityBase.getPSWPAppEntityId() == null;
            }
            case 3: {
                return pSWPAppEntityBase.getPSWPAppEntityName() == null;
            }
            case 4: {
                return pSWPAppEntityBase.getPSWPAppId() == null;
            }
            case 5: {
                return pSWPAppEntityBase.getPSWPAppName() == null;
            }
            case 6: {
                return pSWPAppEntityBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWPAppEntityBase.getUpdateMan() == null;
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
        return PSWPAppEntityBase.contains(this, n);
    }

    private static boolean contains(PSWPAppEntityBase pSWPAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPAppEntityBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPAppEntityBase.isCreateManDirty();
            }
            case 2: {
                return pSWPAppEntityBase.isPSWPAppEntityIdDirty();
            }
            case 3: {
                return pSWPAppEntityBase.isPSWPAppEntityNameDirty();
            }
            case 4: {
                return pSWPAppEntityBase.isPSWPAppIdDirty();
            }
            case 5: {
                return pSWPAppEntityBase.isPSWPAppNameDirty();
            }
            case 6: {
                return pSWPAppEntityBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWPAppEntityBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPAppEntityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPAppEntityBase pSWPAppEntityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPAppEntityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappentityid", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getPSWPAppEntityId()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappentityname", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getPSWPAppEntityName()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappid", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getPSWPAppId()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappname", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getPSWPAppName()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPAppEntityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPAppEntityBase.getJSONValue((Object)pSWPAppEntityBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPAppEntityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPAppEntityBase pSWPAppEntityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPAppEntityBase.getCreateDate() != null) {
            object = pSWPAppEntityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppEntityBase.getCreateMan() != null) {
            object = pSWPAppEntityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppEntityId() != null) {
            object = pSWPAppEntityBase.getPSWPAppEntityId();
            xmlNode.setAttribute(FIELD_PSWPAPPENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppEntityName() != null) {
            object = pSWPAppEntityBase.getPSWPAppEntityName();
            xmlNode.setAttribute(FIELD_PSWPAPPENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppId() != null) {
            object = pSWPAppEntityBase.getPSWPAppId();
            xmlNode.setAttribute(FIELD_PSWPAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppEntityBase.getPSWPAppName() != null) {
            object = pSWPAppEntityBase.getPSWPAppName();
            xmlNode.setAttribute(FIELD_PSWPAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPAppEntityBase.getUpdateDate() != null) {
            object = pSWPAppEntityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPAppEntityBase.getUpdateMan() != null) {
            object = pSWPAppEntityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPAppEntityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPAppEntityBase pSWPAppEntityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPAppEntityBase.isCreateDateDirty() && (bl || pSWPAppEntityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPAppEntityBase.getCreateDate());
        }
        if (pSWPAppEntityBase.isCreateManDirty() && (bl || pSWPAppEntityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPAppEntityBase.getCreateMan());
        }
        if (pSWPAppEntityBase.isPSWPAppEntityIdDirty() && (bl || pSWPAppEntityBase.getPSWPAppEntityId() != null)) {
            iDataObject.set(FIELD_PSWPAPPENTITYID, (Object)pSWPAppEntityBase.getPSWPAppEntityId());
        }
        if (pSWPAppEntityBase.isPSWPAppEntityNameDirty() && (bl || pSWPAppEntityBase.getPSWPAppEntityName() != null)) {
            iDataObject.set(FIELD_PSWPAPPENTITYNAME, (Object)pSWPAppEntityBase.getPSWPAppEntityName());
        }
        if (pSWPAppEntityBase.isPSWPAppIdDirty() && (bl || pSWPAppEntityBase.getPSWPAppId() != null)) {
            iDataObject.set(FIELD_PSWPAPPID, (Object)pSWPAppEntityBase.getPSWPAppId());
        }
        if (pSWPAppEntityBase.isPSWPAppNameDirty() && (bl || pSWPAppEntityBase.getPSWPAppName() != null)) {
            iDataObject.set(FIELD_PSWPAPPNAME, (Object)pSWPAppEntityBase.getPSWPAppName());
        }
        if (pSWPAppEntityBase.isUpdateDateDirty() && (bl || pSWPAppEntityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPAppEntityBase.getUpdateDate());
        }
        if (pSWPAppEntityBase.isUpdateManDirty() && (bl || pSWPAppEntityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPAppEntityBase.getUpdateMan());
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
        return PSWPAppEntityBase.remove(this, n);
    }

    private static boolean remove(PSWPAppEntityBase pSWPAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPAppEntityBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPAppEntityBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPAppEntityBase.resetPSWPAppEntityId();
                return true;
            }
            case 3: {
                pSWPAppEntityBase.resetPSWPAppEntityName();
                return true;
            }
            case 4: {
                pSWPAppEntityBase.resetPSWPAppId();
                return true;
            }
            case 5: {
                pSWPAppEntityBase.resetPSWPAppName();
                return true;
            }
            case 6: {
                pSWPAppEntityBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWPAppEntityBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPApp getPSWPApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPApp();
        }
        if (this.getPSWPAppId() == null) {
            return null;
        }
        Integer n = this.objPSWPAppLock;
        synchronized (n) {
            if (this.pswpapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPAppId(), (Object)this.pswpapp.getPSWPAppId()) != 0L) {
                this.pswpapp = null;
            }
            if (this.pswpapp == null) {
                PSWPApp pSWPApp = new PSWPApp();
                pSWPApp.setPSWPAppId(this.getPSWPAppId());
                PSWPAppService pSWPAppService = (PSWPAppService)ServiceGlobal.getService(PSWPAppService.class, (SessionFactory)this.getSessionFactory());
                pSWPAppService.autoGet((IEntity)pSWPApp);
                this.pswpapp = pSWPApp;
            }
            return this.pswpapp;
        }
    }

    private PSWPAppEntityBase getProxyEntity() {
        return this.proxyPSWPAppEntityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPAppEntityBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPAppEntityBase) {
            this.proxyPSWPAppEntityBase = (PSWPAppEntityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSWPAPPENTITYID, 2);
        fieldIndexMap.put(FIELD_PSWPAPPENTITYNAME, 3);
        fieldIndexMap.put(FIELD_PSWPAPPID, 4);
        fieldIndexMap.put(FIELD_PSWPAPPNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

