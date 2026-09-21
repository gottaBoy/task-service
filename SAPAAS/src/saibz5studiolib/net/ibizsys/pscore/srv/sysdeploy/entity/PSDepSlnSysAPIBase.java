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

public abstract class PSDepSlnSysAPIBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysAPIBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEPSLNSYSAPIID = "PSDEPSLNSYSAPIID";
    public static final String FIELD_PSDEPSLNSYSAPINAME = "PSDEPSLNSYSAPINAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEPSLNSYSAPIID = 2;
    private static final int INDEX_PSDEPSLNSYSAPINAME = 3;
    private static final int INDEX_PSDEPSLNSYSID = 4;
    private static final int INDEX_PSDEPSLNSYSNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysAPIBase proxyPSDepSlnSysAPIBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdepslnsysapiidDirtyFlag = false;
    private boolean psdepslnsysapinameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdepslnsysapiid")
    private String psdepslnsysapiid;
    @Column(name="psdepslnsysapiname")
    private String psdepslnsysapiname;
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

    public void setPSDepSlnSysAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysapiid = string;
        this.psdepslnsysapiidDirtyFlag = true;
    }

    public String getPSDepSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAPIId();
        }
        return this.psdepslnsysapiid;
    }

    public boolean isPSDepSlnSysAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysAPIIdDirty();
        }
        return this.psdepslnsysapiidDirtyFlag;
    }

    public void resetPSDepSlnSysAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysAPIId();
            return;
        }
        this.psdepslnsysapiidDirtyFlag = false;
        this.psdepslnsysapiid = null;
    }

    public void setPSDepSlnSysAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysapiname = string;
        this.psdepslnsysapinameDirtyFlag = true;
    }

    public String getPSDepSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysAPIName();
        }
        return this.psdepslnsysapiname;
    }

    public boolean isPSDepSlnSysAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysAPINameDirty();
        }
        return this.psdepslnsysapinameDirtyFlag;
    }

    public void resetPSDepSlnSysAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysAPIName();
            return;
        }
        this.psdepslnsysapinameDirtyFlag = false;
        this.psdepslnsysapiname = null;
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
        PSDepSlnSysAPIBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysAPIBase pSDepSlnSysAPIBase) {
        pSDepSlnSysAPIBase.resetCreateDate();
        pSDepSlnSysAPIBase.resetCreateMan();
        pSDepSlnSysAPIBase.resetPSDepSlnSysAPIId();
        pSDepSlnSysAPIBase.resetPSDepSlnSysAPIName();
        pSDepSlnSysAPIBase.resetPSDepSlnSysId();
        pSDepSlnSysAPIBase.resetPSDepSlnSysName();
        pSDepSlnSysAPIBase.resetUpdateDate();
        pSDepSlnSysAPIBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDepSlnSysAPIIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSAPIID, this.getPSDepSlnSysAPIId());
        }
        if (!bl || this.isPSDepSlnSysAPINameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSAPINAME, this.getPSDepSlnSysAPIName());
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
        return PSDepSlnSysAPIBase.get(this, n);
    }

    private static Object get(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAPIBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysAPIBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysAPIId();
            }
            case 3: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysAPIName();
            }
            case 4: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysId();
            }
            case 5: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysName();
            }
            case 6: {
                return pSDepSlnSysAPIBase.getUpdateDate();
            }
            case 7: {
                return pSDepSlnSysAPIBase.getUpdateMan();
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
        PSDepSlnSysAPIBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysAPIBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysAPIBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysAPIBase.setPSDepSlnSysAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysAPIBase.setPSDepSlnSysAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysAPIBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysAPIBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysAPIBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysAPIBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysAPIBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAPIBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysAPIBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysAPIId() == null;
            }
            case 3: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysAPIName() == null;
            }
            case 4: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysId() == null;
            }
            case 5: {
                return pSDepSlnSysAPIBase.getPSDepSlnSysName() == null;
            }
            case 6: {
                return pSDepSlnSysAPIBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDepSlnSysAPIBase.getUpdateMan() == null;
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
        return PSDepSlnSysAPIBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysAPIBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysAPIBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysAPIBase.isPSDepSlnSysAPIIdDirty();
            }
            case 3: {
                return pSDepSlnSysAPIBase.isPSDepSlnSysAPINameDirty();
            }
            case 4: {
                return pSDepSlnSysAPIBase.isPSDepSlnSysIdDirty();
            }
            case 5: {
                return pSDepSlnSysAPIBase.isPSDepSlnSysNameDirty();
            }
            case 6: {
                return pSDepSlnSysAPIBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDepSlnSysAPIBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysAPIBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysAPIBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysapiid", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getPSDepSlnSysAPIId()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysapiname", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getPSDepSlnSysAPIName()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysAPIBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysAPIBase.getJSONValue((Object)pSDepSlnSysAPIBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysAPIBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysAPIBase.getCreateDate() != null) {
            object = pSDepSlnSysAPIBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysAPIBase.getCreateMan() != null) {
            object = pSDepSlnSysAPIBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIId() != null) {
            object = pSDepSlnSysAPIBase.getPSDepSlnSysAPIId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIName() != null) {
            object = pSDepSlnSysAPIBase.getPSDepSlnSysAPIName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysAPIBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAPIBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysAPIBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysAPIBase.getUpdateDate() != null) {
            object = pSDepSlnSysAPIBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysAPIBase.getUpdateMan() != null) {
            object = pSDepSlnSysAPIBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysAPIBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysAPIBase.isCreateDateDirty() && (bl || pSDepSlnSysAPIBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysAPIBase.getCreateDate());
        }
        if (pSDepSlnSysAPIBase.isCreateManDirty() && (bl || pSDepSlnSysAPIBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysAPIBase.getCreateMan());
        }
        if (pSDepSlnSysAPIBase.isPSDepSlnSysAPIIdDirty() && (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSAPIID, (Object)pSDepSlnSysAPIBase.getPSDepSlnSysAPIId());
        }
        if (pSDepSlnSysAPIBase.isPSDepSlnSysAPINameDirty() && (bl || pSDepSlnSysAPIBase.getPSDepSlnSysAPIName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSAPINAME, (Object)pSDepSlnSysAPIBase.getPSDepSlnSysAPIName());
        }
        if (pSDepSlnSysAPIBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysAPIBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysAPIBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysAPIBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysAPIBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysAPIBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysAPIBase.isUpdateDateDirty() && (bl || pSDepSlnSysAPIBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysAPIBase.getUpdateDate());
        }
        if (pSDepSlnSysAPIBase.isUpdateManDirty() && (bl || pSDepSlnSysAPIBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysAPIBase.getUpdateMan());
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
        return PSDepSlnSysAPIBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysAPIBase pSDepSlnSysAPIBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysAPIBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysAPIBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysAPIBase.resetPSDepSlnSysAPIId();
                return true;
            }
            case 3: {
                pSDepSlnSysAPIBase.resetPSDepSlnSysAPIName();
                return true;
            }
            case 4: {
                pSDepSlnSysAPIBase.resetPSDepSlnSysId();
                return true;
            }
            case 5: {
                pSDepSlnSysAPIBase.resetPSDepSlnSysName();
                return true;
            }
            case 6: {
                pSDepSlnSysAPIBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDepSlnSysAPIBase.resetUpdateMan();
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
                pSDepSlnSysService.autoGet((IEntity)pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    private PSDepSlnSysAPIBase getProxyEntity() {
        return this.proxyPSDepSlnSysAPIBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysAPIBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysAPIBase) {
            this.proxyPSDepSlnSysAPIBase = (PSDepSlnSysAPIBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysAPIService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSAPIID, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSAPINAME, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

