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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEPSLNSYSAPPID = "PSDEPSLNSYSAPPID";
    public static final String FIELD_PSDEPSLNSYSAPPNAME = "PSDEPSLNSYSAPPNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEPSLNSYSAPPID = 2;
    private static final int INDEX_PSDEPSLNSYSAPPNAME = 3;
    private static final int INDEX_PSDEPSLNSYSID = 4;
    private static final int INDEX_PSDEPSLNSYSNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysAppBase proxyPSDepSlnSysAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdepslnsysappidDirtyFlag = false;
    private boolean psdepslnsysappnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdepslnsysappid")
    private String psdepslnsysappid;
    @Column(name="psdepslnsysappname")
    private String psdepslnsysappname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;

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

    public void setPSDepSlnSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysappid = string;
        this.psdepslnsysappidDirtyFlag = true;
    }

    public String getPSDepSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAppId();
        }
        return this.psdepslnsysappid;
    }

    public boolean isPSDepSlnSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysAppIdDirty();
        }
        return this.psdepslnsysappidDirtyFlag;
    }

    public void resetPSDepSlnSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysAppId();
            return;
        }
        this.psdepslnsysappidDirtyFlag = false;
        this.psdepslnsysappid = null;
    }

    public void setPSDepSlnSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysappname = string;
        this.psdepslnsysappnameDirtyFlag = true;
    }

    public String getPSDepSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAppName();
        }
        return this.psdepslnsysappname;
    }

    public boolean isPSDepSlnSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysAppNameDirty();
        }
        return this.psdepslnsysappnameDirtyFlag;
    }

    public void resetPSDepSlnSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysAppName();
            return;
        }
        this.psdepslnsysappnameDirtyFlag = false;
        this.psdepslnsysappname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
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
        PSDepSlnSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysAppBase pSDepSlnSysAppBase) {
        pSDepSlnSysAppBase.resetCreateDate();
        pSDepSlnSysAppBase.resetCreateMan();
        pSDepSlnSysAppBase.resetPSDepSlnSysAppId();
        pSDepSlnSysAppBase.resetPSDepSlnSysAppName();
        pSDepSlnSysAppBase.resetPSDepSlnSysId();
        pSDepSlnSysAppBase.resetPSDepSlnSysName();
        pSDepSlnSysAppBase.resetUpdateDate();
        pSDepSlnSysAppBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDepSlnSysAppIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSAPPID, this.getPSDepSlnSysAppId());
        }
        if (!bl || this.isPSDepSlnSysAppNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSAPPNAME, this.getPSDepSlnSysAppName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
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
        return PSDepSlnSysAppBase.get(this, n);
    }

    private static Object get(PSDepSlnSysAppBase pSDepSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAppBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysAppBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysAppBase.getPSDepSlnSysAppId();
            }
            case 3: {
                return pSDepSlnSysAppBase.getPSDepSlnSysAppName();
            }
            case 4: {
                return pSDepSlnSysAppBase.getPSDepSlnSysId();
            }
            case 5: {
                return pSDepSlnSysAppBase.getPSDepSlnSysName();
            }
            case 6: {
                return pSDepSlnSysAppBase.getUpdateDate();
            }
            case 7: {
                return pSDepSlnSysAppBase.getUpdateMan();
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
        PSDepSlnSysAppBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysAppBase pSDepSlnSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysAppBase.setPSDepSlnSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysAppBase.setPSDepSlnSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysAppBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysAppBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysAppBase pSDepSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysAppBase.getPSDepSlnSysAppId() == null;
            }
            case 3: {
                return pSDepSlnSysAppBase.getPSDepSlnSysAppName() == null;
            }
            case 4: {
                return pSDepSlnSysAppBase.getPSDepSlnSysId() == null;
            }
            case 5: {
                return pSDepSlnSysAppBase.getPSDepSlnSysName() == null;
            }
            case 6: {
                return pSDepSlnSysAppBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDepSlnSysAppBase.getUpdateMan() == null;
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
        return PSDepSlnSysAppBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysAppBase pSDepSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysAppBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysAppBase.isPSDepSlnSysAppIdDirty();
            }
            case 3: {
                return pSDepSlnSysAppBase.isPSDepSlnSysAppNameDirty();
            }
            case 4: {
                return pSDepSlnSysAppBase.isPSDepSlnSysIdDirty();
            }
            case 5: {
                return pSDepSlnSysAppBase.isPSDepSlnSysNameDirty();
            }
            case 6: {
                return pSDepSlnSysAppBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDepSlnSysAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysAppBase pSDepSlnSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysappid", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getPSDepSlnSysAppId()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysappname", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getPSDepSlnSysAppName()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysAppBase.getJSONValue((Object)pSDepSlnSysAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysAppBase pSDepSlnSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysAppBase.getCreateDate() != null) {
            object = pSDepSlnSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysAppBase.getCreateMan() != null) {
            object = pSDepSlnSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppId() != null) {
            object = pSDepSlnSysAppBase.getPSDepSlnSysAppId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppName() != null) {
            object = pSDepSlnSysAppBase.getPSDepSlnSysAppName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysAppBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAppBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysAppBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAppBase.getUpdateDate() != null) {
            object = pSDepSlnSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysAppBase.getUpdateMan() != null) {
            object = pSDepSlnSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysAppBase pSDepSlnSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysAppBase.isCreateDateDirty() && (bl || pSDepSlnSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysAppBase.getCreateDate());
        }
        if (pSDepSlnSysAppBase.isCreateManDirty() && (bl || pSDepSlnSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysAppBase.getCreateMan());
        }
        if (pSDepSlnSysAppBase.isPSDepSlnSysAppIdDirty() && (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSAPPID, (Object)pSDepSlnSysAppBase.getPSDepSlnSysAppId());
        }
        if (pSDepSlnSysAppBase.isPSDepSlnSysAppNameDirty() && (bl || pSDepSlnSysAppBase.getPSDepSlnSysAppName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSAPPNAME, (Object)pSDepSlnSysAppBase.getPSDepSlnSysAppName());
        }
        if (pSDepSlnSysAppBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysAppBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysAppBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysAppBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysAppBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysAppBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysAppBase.isUpdateDateDirty() && (bl || pSDepSlnSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysAppBase.getUpdateDate());
        }
        if (pSDepSlnSysAppBase.isUpdateManDirty() && (bl || pSDepSlnSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysAppBase.getUpdateMan());
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
        return PSDepSlnSysAppBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysAppBase pSDepSlnSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysAppBase.resetPSDepSlnSysAppId();
                return true;
            }
            case 3: {
                pSDepSlnSysAppBase.resetPSDepSlnSysAppName();
                return true;
            }
            case 4: {
                pSDepSlnSysAppBase.resetPSDepSlnSysId();
                return true;
            }
            case 5: {
                pSDepSlnSysAppBase.resetPSDepSlnSysName();
                return true;
            }
            case 6: {
                pSDepSlnSysAppBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDepSlnSysAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    private PSDepSlnSysAppBase getProxyEntity() {
        return this.proxyPSDepSlnSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysAppBase) {
            this.proxyPSDepSlnSysAppBase = (PSDepSlnSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSAPPID, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSAPPNAME, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

