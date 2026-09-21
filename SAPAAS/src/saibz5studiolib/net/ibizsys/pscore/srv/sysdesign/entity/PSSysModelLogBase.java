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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSMODELLOGID = "PSSYSMODELLOGID";
    public static final String FIELD_PSSYSMODELLOGNAME = "PSSYSMODELLOGNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDYNAINSTID = 2;
    private static final int INDEX_PSSYSMODELLOGID = 3;
    private static final int INDEX_PSSYSMODELLOGNAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_PSSYSTEMNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelLogBase proxyPSSysModelLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysmodellogidDirtyFlag = false;
    private boolean pssysmodellognameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysmodellogid")
    private String pssysmodellogid;
    @Column(name="pssysmodellogname")
    private String pssysmodellogname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSysModelLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodellogid = string;
        this.pssysmodellogidDirtyFlag = true;
    }

    public String getPSSysModelLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelLogId();
        }
        return this.pssysmodellogid;
    }

    public boolean isPSSysModelLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelLogIdDirty();
        }
        return this.pssysmodellogidDirtyFlag;
    }

    public void resetPSSysModelLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelLogId();
            return;
        }
        this.pssysmodellogidDirtyFlag = false;
        this.pssysmodellogid = null;
    }

    public void setPSSysModelLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodellogname = string;
        this.pssysmodellognameDirtyFlag = true;
    }

    public String getPSSysModelLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelLogName();
        }
        return this.pssysmodellogname;
    }

    public boolean isPSSysModelLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelLogNameDirty();
        }
        return this.pssysmodellognameDirtyFlag;
    }

    public void resetPSSysModelLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelLogName();
            return;
        }
        this.pssysmodellognameDirtyFlag = false;
        this.pssysmodellogname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSSysModelLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelLogBase pSSysModelLogBase) {
        pSSysModelLogBase.resetCreateDate();
        pSSysModelLogBase.resetCreateMan();
        pSSysModelLogBase.resetPSDynaInstId();
        pSSysModelLogBase.resetPSSysModelLogId();
        pSSysModelLogBase.resetPSSysModelLogName();
        pSSysModelLogBase.resetPSSystemId();
        pSSysModelLogBase.resetPSSystemName();
        pSSysModelLogBase.resetUpdateDate();
        pSSysModelLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysModelLogIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELLOGID, this.getPSSysModelLogId());
        }
        if (!bl || this.isPSSysModelLogNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELLOGNAME, this.getPSSysModelLogName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysModelLogBase.get(this, n);
    }

    private static Object get(PSSysModelLogBase pSSysModelLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLogBase.getCreateDate();
            }
            case 1: {
                return pSSysModelLogBase.getCreateMan();
            }
            case 2: {
                return pSSysModelLogBase.getPSDynaInstId();
            }
            case 3: {
                return pSSysModelLogBase.getPSSysModelLogId();
            }
            case 4: {
                return pSSysModelLogBase.getPSSysModelLogName();
            }
            case 5: {
                return pSSysModelLogBase.getPSSystemId();
            }
            case 6: {
                return pSSysModelLogBase.getPSSystemName();
            }
            case 7: {
                return pSSysModelLogBase.getUpdateDate();
            }
            case 8: {
                return pSSysModelLogBase.getUpdateMan();
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
        PSSysModelLogBase.set(this, n, object);
    }

    private static void set(PSSysModelLogBase pSSysModelLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelLogBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelLogBase.setPSSysModelLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelLogBase.setPSSysModelLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelLogBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelLogBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelLogBase pSSysModelLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelLogBase.getPSDynaInstId() == null;
            }
            case 3: {
                return pSSysModelLogBase.getPSSysModelLogId() == null;
            }
            case 4: {
                return pSSysModelLogBase.getPSSysModelLogName() == null;
            }
            case 5: {
                return pSSysModelLogBase.getPSSystemId() == null;
            }
            case 6: {
                return pSSysModelLogBase.getPSSystemName() == null;
            }
            case 7: {
                return pSSysModelLogBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSysModelLogBase.getUpdateMan() == null;
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
        return PSSysModelLogBase.contains(this, n);
    }

    private static boolean contains(PSSysModelLogBase pSSysModelLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelLogBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelLogBase.isPSDynaInstIdDirty();
            }
            case 3: {
                return pSSysModelLogBase.isPSSysModelLogIdDirty();
            }
            case 4: {
                return pSSysModelLogBase.isPSSysModelLogNameDirty();
            }
            case 5: {
                return pSSysModelLogBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSSysModelLogBase.isPSSystemNameDirty();
            }
            case 7: {
                return pSSysModelLogBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSysModelLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelLogBase pSSysModelLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getPSSysModelLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodellogid", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getPSSysModelLogId()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getPSSysModelLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodellogname", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getPSSysModelLogName()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelLogBase.getJSONValue((Object)pSSysModelLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelLogBase pSSysModelLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelLogBase.getCreateDate() != null) {
            object = pSSysModelLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelLogBase.getCreateMan() != null) {
            object = pSSysModelLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getPSDynaInstId() != null) {
            object = pSSysModelLogBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getPSSysModelLogId() != null) {
            object = pSSysModelLogBase.getPSSysModelLogId();
            xmlNode.setAttribute(FIELD_PSSYSMODELLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getPSSysModelLogName() != null) {
            object = pSSysModelLogBase.getPSSysModelLogName();
            xmlNode.setAttribute(FIELD_PSSYSMODELLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getPSSystemId() != null) {
            object = pSSysModelLogBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getPSSystemName() != null) {
            object = pSSysModelLogBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelLogBase.getUpdateDate() != null) {
            object = pSSysModelLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelLogBase.getUpdateMan() != null) {
            object = pSSysModelLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelLogBase pSSysModelLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelLogBase.isCreateDateDirty() && (bl || pSSysModelLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelLogBase.getCreateDate());
        }
        if (pSSysModelLogBase.isCreateManDirty() && (bl || pSSysModelLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelLogBase.getCreateMan());
        }
        if (pSSysModelLogBase.isPSDynaInstIdDirty() && (bl || pSSysModelLogBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysModelLogBase.getPSDynaInstId());
        }
        if (pSSysModelLogBase.isPSSysModelLogIdDirty() && (bl || pSSysModelLogBase.getPSSysModelLogId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELLOGID, (Object)pSSysModelLogBase.getPSSysModelLogId());
        }
        if (pSSysModelLogBase.isPSSysModelLogNameDirty() && (bl || pSSysModelLogBase.getPSSysModelLogName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELLOGNAME, (Object)pSSysModelLogBase.getPSSysModelLogName());
        }
        if (pSSysModelLogBase.isPSSystemIdDirty() && (bl || pSSysModelLogBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelLogBase.getPSSystemId());
        }
        if (pSSysModelLogBase.isPSSystemNameDirty() && (bl || pSSysModelLogBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysModelLogBase.getPSSystemName());
        }
        if (pSSysModelLogBase.isUpdateDateDirty() && (bl || pSSysModelLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelLogBase.getUpdateDate());
        }
        if (pSSysModelLogBase.isUpdateManDirty() && (bl || pSSysModelLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelLogBase.getUpdateMan());
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
        return PSSysModelLogBase.remove(this, n);
    }

    private static boolean remove(PSSysModelLogBase pSSysModelLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelLogBase.resetPSDynaInstId();
                return true;
            }
            case 3: {
                pSSysModelLogBase.resetPSSysModelLogId();
                return true;
            }
            case 4: {
                pSSysModelLogBase.resetPSSysModelLogName();
                return true;
            }
            case 5: {
                pSSysModelLogBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSSysModelLogBase.resetPSSystemName();
                return true;
            }
            case 7: {
                pSSysModelLogBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSysModelLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysModelLogBase getProxyEntity() {
        return this.proxyPSSysModelLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelLogBase) {
            this.proxyPSSysModelLogBase = (PSSysModelLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 2);
        fieldIndexMap.put(FIELD_PSSYSMODELLOGID, 3);
        fieldIndexMap.put(FIELD_PSSYSMODELLOGNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

