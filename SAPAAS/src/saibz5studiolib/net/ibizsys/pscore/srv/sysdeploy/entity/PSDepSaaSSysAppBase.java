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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysApp;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSaaSSysAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEPSAASSYSAPPID = "PSDEPSAASSYSAPPID";
    public static final String FIELD_PSDEPSAASSYSAPPNAME = "PSDEPSAASSYSAPPNAME";
    public static final String FIELD_PSSAASSYSAPPID = "PSSAASSYSAPPID";
    public static final String FIELD_PSSAASSYSAPPNAME = "PSSAASSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEPSAASSYSAPPID = 2;
    private static final int INDEX_PSDEPSAASSYSAPPNAME = 3;
    private static final int INDEX_PSSAASSYSAPPID = 4;
    private static final int INDEX_PSSAASSYSAPPNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSaaSSysAppBase proxyPSDepSaaSSysAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdepsaassysappidDirtyFlag = false;
    private boolean psdepsaassysappnameDirtyFlag = false;
    private boolean pssaassysappidDirtyFlag = false;
    private boolean pssaassysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdepsaassysappid")
    private String psdepsaassysappid;
    @Column(name="psdepsaassysappname")
    private String psdepsaassysappname;
    @Column(name="pssaassysappid")
    private String pssaassysappid;
    @Column(name="pssaassysappname")
    private String pssaassysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSaaSSysAppLock = new Integer(1);
    private PSSaaSSysApp pssaassysapp = null;

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

    public void setPSDepSaaSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysappid = string;
        this.psdepsaassysappidDirtyFlag = true;
    }

    public String getPSDepSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysAppId();
        }
        return this.psdepsaassysappid;
    }

    public boolean isPSDepSaaSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysAppIdDirty();
        }
        return this.psdepsaassysappidDirtyFlag;
    }

    public void resetPSDepSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysAppId();
            return;
        }
        this.psdepsaassysappidDirtyFlag = false;
        this.psdepsaassysappid = null;
    }

    public void setPSDepSaaSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysappname = string;
        this.psdepsaassysappnameDirtyFlag = true;
    }

    public String getPSDepSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysAppName();
        }
        return this.psdepsaassysappname;
    }

    public boolean isPSDepSaaSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysAppNameDirty();
        }
        return this.psdepsaassysappnameDirtyFlag;
    }

    public void resetPSDepSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysAppName();
            return;
        }
        this.psdepsaassysappnameDirtyFlag = false;
        this.psdepsaassysappname = null;
    }

    public void setPSSaaSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappid = string;
        this.pssaassysappidDirtyFlag = true;
    }

    public String getPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppId();
        }
        return this.pssaassysappid;
    }

    public boolean isPSSaaSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppIdDirty();
        }
        return this.pssaassysappidDirtyFlag;
    }

    public void resetPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppId();
            return;
        }
        this.pssaassysappidDirtyFlag = false;
        this.pssaassysappid = null;
    }

    public void setPSSaaSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappname = string;
        this.pssaassysappnameDirtyFlag = true;
    }

    public String getPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppName();
        }
        return this.pssaassysappname;
    }

    public boolean isPSSaaSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppNameDirty();
        }
        return this.pssaassysappnameDirtyFlag;
    }

    public void resetPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppName();
            return;
        }
        this.pssaassysappnameDirtyFlag = false;
        this.pssaassysappname = null;
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
        PSDepSaaSSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSaaSSysAppBase pSDepSaaSSysAppBase) {
        pSDepSaaSSysAppBase.resetCreateDate();
        pSDepSaaSSysAppBase.resetCreateMan();
        pSDepSaaSSysAppBase.resetPSDepSaaSSysAppId();
        pSDepSaaSSysAppBase.resetPSDepSaaSSysAppName();
        pSDepSaaSSysAppBase.resetPSSaaSSysAppId();
        pSDepSaaSSysAppBase.resetPSSaaSSysAppName();
        pSDepSaaSSysAppBase.resetUpdateDate();
        pSDepSaaSSysAppBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDepSaaSSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSAPPID, this.getPSDepSaaSSysAppId());
        }
        if (!bl || this.isPSDepSaaSSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSAPPNAME, this.getPSDepSaaSSysAppName());
        }
        if (!bl || this.isPSSaaSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPID, this.getPSSaaSSysAppId());
        }
        if (!bl || this.isPSSaaSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPNAME, this.getPSSaaSSysAppName());
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
        return PSDepSaaSSysAppBase.get(this, n);
    }

    private static Object get(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysAppBase.getCreateDate();
            }
            case 1: {
                return pSDepSaaSSysAppBase.getCreateMan();
            }
            case 2: {
                return pSDepSaaSSysAppBase.getPSDepSaaSSysAppId();
            }
            case 3: {
                return pSDepSaaSSysAppBase.getPSDepSaaSSysAppName();
            }
            case 4: {
                return pSDepSaaSSysAppBase.getPSSaaSSysAppId();
            }
            case 5: {
                return pSDepSaaSSysAppBase.getPSSaaSSysAppName();
            }
            case 6: {
                return pSDepSaaSSysAppBase.getUpdateDate();
            }
            case 7: {
                return pSDepSaaSSysAppBase.getUpdateMan();
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
        PSDepSaaSSysAppBase.set(this, n, object);
    }

    private static void set(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSaaSSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSaaSSysAppBase.setPSDepSaaSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSaaSSysAppBase.setPSDepSaaSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSaaSSysAppBase.setPSSaaSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSaaSSysAppBase.setPSSaaSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSaaSSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSaaSSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSaaSSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSaaSSysAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSaaSSysAppBase.getPSDepSaaSSysAppId() == null;
            }
            case 3: {
                return pSDepSaaSSysAppBase.getPSDepSaaSSysAppName() == null;
            }
            case 4: {
                return pSDepSaaSSysAppBase.getPSSaaSSysAppId() == null;
            }
            case 5: {
                return pSDepSaaSSysAppBase.getPSSaaSSysAppName() == null;
            }
            case 6: {
                return pSDepSaaSSysAppBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDepSaaSSysAppBase.getUpdateMan() == null;
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
        return PSDepSaaSSysAppBase.contains(this, n);
    }

    private static boolean contains(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSaaSSysAppBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSaaSSysAppBase.isPSDepSaaSSysAppIdDirty();
            }
            case 3: {
                return pSDepSaaSSysAppBase.isPSDepSaaSSysAppNameDirty();
            }
            case 4: {
                return pSDepSaaSSysAppBase.isPSSaaSSysAppIdDirty();
            }
            case 5: {
                return pSDepSaaSSysAppBase.isPSSaaSSysAppNameDirty();
            }
            case 6: {
                return pSDepSaaSSysAppBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDepSaaSSysAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSaaSSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSaaSSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysappid", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getPSDepSaaSSysAppId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysappname", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getPSDepSaaSSysAppName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappid", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getPSSaaSSysAppId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappname", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getPSSaaSSysAppName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSaaSSysAppBase.getJSONValue((Object)pSDepSaaSSysAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSaaSSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSaaSSysAppBase.getCreateDate() != null) {
            object = pSDepSaaSSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysAppBase.getCreateMan() != null) {
            object = pSDepSaaSSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppId() != null) {
            object = pSDepSaaSSysAppBase.getPSDepSaaSSysAppId();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppName() != null) {
            object = pSDepSaaSSysAppBase.getPSDepSaaSSysAppName();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppId() != null) {
            object = pSDepSaaSSysAppBase.getPSSaaSSysAppId();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppName() != null) {
            object = pSDepSaaSSysAppBase.getPSSaaSSysAppName();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysAppBase.getUpdateDate() != null) {
            object = pSDepSaaSSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysAppBase.getUpdateMan() != null) {
            object = pSDepSaaSSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSaaSSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSaaSSysAppBase.isCreateDateDirty() && (bl || pSDepSaaSSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSaaSSysAppBase.getCreateDate());
        }
        if (pSDepSaaSSysAppBase.isCreateManDirty() && (bl || pSDepSaaSSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSaaSSysAppBase.getCreateMan());
        }
        if (pSDepSaaSSysAppBase.isPSDepSaaSSysAppIdDirty() && (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSAPPID, (Object)pSDepSaaSSysAppBase.getPSDepSaaSSysAppId());
        }
        if (pSDepSaaSSysAppBase.isPSDepSaaSSysAppNameDirty() && (bl || pSDepSaaSSysAppBase.getPSDepSaaSSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSAPPNAME, (Object)pSDepSaaSSysAppBase.getPSDepSaaSSysAppName());
        }
        if (pSDepSaaSSysAppBase.isPSSaaSSysAppIdDirty() && (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPID, (Object)pSDepSaaSSysAppBase.getPSSaaSSysAppId());
        }
        if (pSDepSaaSSysAppBase.isPSSaaSSysAppNameDirty() && (bl || pSDepSaaSSysAppBase.getPSSaaSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPNAME, (Object)pSDepSaaSSysAppBase.getPSSaaSSysAppName());
        }
        if (pSDepSaaSSysAppBase.isUpdateDateDirty() && (bl || pSDepSaaSSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSaaSSysAppBase.getUpdateDate());
        }
        if (pSDepSaaSSysAppBase.isUpdateManDirty() && (bl || pSDepSaaSSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSaaSSysAppBase.getUpdateMan());
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
        return PSDepSaaSSysAppBase.remove(this, n);
    }

    private static boolean remove(PSDepSaaSSysAppBase pSDepSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSaaSSysAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSaaSSysAppBase.resetPSDepSaaSSysAppId();
                return true;
            }
            case 3: {
                pSDepSaaSSysAppBase.resetPSDepSaaSSysAppName();
                return true;
            }
            case 4: {
                pSDepSaaSSysAppBase.resetPSSaaSSysAppId();
                return true;
            }
            case 5: {
                pSDepSaaSSysAppBase.resetPSSaaSSysAppName();
                return true;
            }
            case 6: {
                pSDepSaaSSysAppBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDepSaaSSysAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysApp getPSSaaSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysApp();
        }
        if (this.getPSSaaSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysAppLock;
        synchronized (n) {
            if (this.pssaassysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysAppId(), (Object)this.pssaassysapp.getPSSaaSSysAppId()) != 0L) {
                this.pssaassysapp = null;
            }
            if (this.pssaassysapp == null) {
                PSSaaSSysApp pSSaaSSysApp = new PSSaaSSysApp();
                pSSaaSSysApp.setPSSaaSSysAppId(this.getPSSaaSSysAppId());
                PSSaaSSysAppService pSSaaSSysAppService = (PSSaaSSysAppService)ServiceGlobal.getService(PSSaaSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysAppService.autoGet((IEntity)pSSaaSSysApp);
                this.pssaassysapp = pSSaaSSysApp;
            }
            return this.pssaassysapp;
        }
    }

    private PSDepSaaSSysAppBase getProxyEntity() {
        return this.proxyPSDepSaaSSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSaaSSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSaaSSysAppBase) {
            this.proxyPSDepSaaSSysAppBase = (PSDepSaaSSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSAPPID, 2);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSAPPNAME, 3);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPID, 4);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

