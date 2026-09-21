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

public abstract class PSDEDQPDCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQPDCondBase.class);
    public static final String FIELD_CONDOBJ = "CONDOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDQPDCONDID = "PSDEDQPDCONDID";
    public static final String FIELD_PSDEDQPDCONDNAME = "PSDEDQPDCONDNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEDQPDCONDID = 4;
    private static final int INDEX_PSDEDQPDCONDNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQPDCondBase proxyPSDEDQPDCondBase = null;
    private boolean condobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedqpdcondidDirtyFlag = false;
    private boolean psdedqpdcondnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="condobj")
    private String condobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedqpdcondid")
    private String psdedqpdcondid;
    @Column(name="psdedqpdcondname")
    private String psdedqpdcondname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCondObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condobj = string;
        this.condobjDirtyFlag = true;
    }

    public String getCondObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondObj();
        }
        return this.condobj;
    }

    public boolean isCondObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondObjDirty();
        }
        return this.condobjDirtyFlag;
    }

    public void resetCondObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondObj();
            return;
        }
        this.condobjDirtyFlag = false;
        this.condobj = null;
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

    public void setPSDEDQPDCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQPDCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqpdcondid = string;
        this.psdedqpdcondidDirtyFlag = true;
    }

    public String getPSDEDQPDCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQPDCondId();
        }
        return this.psdedqpdcondid;
    }

    public boolean isPSDEDQPDCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQPDCondIdDirty();
        }
        return this.psdedqpdcondidDirtyFlag;
    }

    public void resetPSDEDQPDCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQPDCondId();
            return;
        }
        this.psdedqpdcondidDirtyFlag = false;
        this.psdedqpdcondid = null;
    }

    public void setPSDEDQPDCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQPDCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqpdcondname = string;
        this.psdedqpdcondnameDirtyFlag = true;
    }

    public String getPSDEDQPDCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQPDCondName();
        }
        return this.psdedqpdcondname;
    }

    public boolean isPSDEDQPDCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQPDCondNameDirty();
        }
        return this.psdedqpdcondnameDirtyFlag;
    }

    public void resetPSDEDQPDCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQPDCondName();
            return;
        }
        this.psdedqpdcondnameDirtyFlag = false;
        this.psdedqpdcondname = null;
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
        PSDEDQPDCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQPDCondBase pSDEDQPDCondBase) {
        pSDEDQPDCondBase.resetCondObj();
        pSDEDQPDCondBase.resetCreateDate();
        pSDEDQPDCondBase.resetCreateMan();
        pSDEDQPDCondBase.resetMemo();
        pSDEDQPDCondBase.resetPSDEDQPDCondId();
        pSDEDQPDCondBase.resetPSDEDQPDCondName();
        pSDEDQPDCondBase.resetUpdateDate();
        pSDEDQPDCondBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondObjDirty()) {
            hashMap.put(FIELD_CONDOBJ, this.getCondObj());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDQPDCondIdDirty()) {
            hashMap.put(FIELD_PSDEDQPDCONDID, this.getPSDEDQPDCondId());
        }
        if (!bl || this.isPSDEDQPDCondNameDirty()) {
            hashMap.put(FIELD_PSDEDQPDCONDNAME, this.getPSDEDQPDCondName());
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
        return PSDEDQPDCondBase.get(this, n);
    }

    private static Object get(PSDEDQPDCondBase pSDEDQPDCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQPDCondBase.getCondObj();
            }
            case 1: {
                return pSDEDQPDCondBase.getCreateDate();
            }
            case 2: {
                return pSDEDQPDCondBase.getCreateMan();
            }
            case 3: {
                return pSDEDQPDCondBase.getMemo();
            }
            case 4: {
                return pSDEDQPDCondBase.getPSDEDQPDCondId();
            }
            case 5: {
                return pSDEDQPDCondBase.getPSDEDQPDCondName();
            }
            case 6: {
                return pSDEDQPDCondBase.getUpdateDate();
            }
            case 7: {
                return pSDEDQPDCondBase.getUpdateMan();
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
        PSDEDQPDCondBase.set(this, n, object);
    }

    private static void set(PSDEDQPDCondBase pSDEDQPDCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQPDCondBase.setCondObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQPDCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQPDCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQPDCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQPDCondBase.setPSDEDQPDCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQPDCondBase.setPSDEDQPDCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQPDCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQPDCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDQPDCondBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQPDCondBase pSDEDQPDCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQPDCondBase.getCondObj() == null;
            }
            case 1: {
                return pSDEDQPDCondBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDQPDCondBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDQPDCondBase.getMemo() == null;
            }
            case 4: {
                return pSDEDQPDCondBase.getPSDEDQPDCondId() == null;
            }
            case 5: {
                return pSDEDQPDCondBase.getPSDEDQPDCondName() == null;
            }
            case 6: {
                return pSDEDQPDCondBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDEDQPDCondBase.getUpdateMan() == null;
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
        return PSDEDQPDCondBase.contains(this, n);
    }

    private static boolean contains(PSDEDQPDCondBase pSDEDQPDCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQPDCondBase.isCondObjDirty();
            }
            case 1: {
                return pSDEDQPDCondBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDQPDCondBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDQPDCondBase.isMemoDirty();
            }
            case 4: {
                return pSDEDQPDCondBase.isPSDEDQPDCondIdDirty();
            }
            case 5: {
                return pSDEDQPDCondBase.isPSDEDQPDCondNameDirty();
            }
            case 6: {
                return pSDEDQPDCondBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDEDQPDCondBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQPDCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQPDCondBase pSDEDQPDCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQPDCondBase.getCondObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condobj", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getCondObj()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getPSDEDQPDCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqpdcondid", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getPSDEDQPDCondId()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getPSDEDQPDCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqpdcondname", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getPSDEDQPDCondName()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQPDCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQPDCondBase.getJSONValue((Object)pSDEDQPDCondBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQPDCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQPDCondBase pSDEDQPDCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQPDCondBase.getCondObj() != null) {
            object = pSDEDQPDCondBase.getCondObj();
            xmlNode.setAttribute(FIELD_CONDOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQPDCondBase.getCreateDate() != null) {
            object = pSDEDQPDCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQPDCondBase.getCreateMan() != null) {
            object = pSDEDQPDCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQPDCondBase.getMemo() != null) {
            object = pSDEDQPDCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQPDCondBase.getPSDEDQPDCondId() != null) {
            object = pSDEDQPDCondBase.getPSDEDQPDCondId();
            xmlNode.setAttribute(FIELD_PSDEDQPDCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQPDCondBase.getPSDEDQPDCondName() != null) {
            object = pSDEDQPDCondBase.getPSDEDQPDCondName();
            xmlNode.setAttribute(FIELD_PSDEDQPDCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQPDCondBase.getUpdateDate() != null) {
            object = pSDEDQPDCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQPDCondBase.getUpdateMan() != null) {
            object = pSDEDQPDCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQPDCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQPDCondBase pSDEDQPDCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQPDCondBase.isCondObjDirty() && (bl || pSDEDQPDCondBase.getCondObj() != null)) {
            iDataObject.set(FIELD_CONDOBJ, (Object)pSDEDQPDCondBase.getCondObj());
        }
        if (pSDEDQPDCondBase.isCreateDateDirty() && (bl || pSDEDQPDCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQPDCondBase.getCreateDate());
        }
        if (pSDEDQPDCondBase.isCreateManDirty() && (bl || pSDEDQPDCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQPDCondBase.getCreateMan());
        }
        if (pSDEDQPDCondBase.isMemoDirty() && (bl || pSDEDQPDCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQPDCondBase.getMemo());
        }
        if (pSDEDQPDCondBase.isPSDEDQPDCondIdDirty() && (bl || pSDEDQPDCondBase.getPSDEDQPDCondId() != null)) {
            iDataObject.set(FIELD_PSDEDQPDCONDID, (Object)pSDEDQPDCondBase.getPSDEDQPDCondId());
        }
        if (pSDEDQPDCondBase.isPSDEDQPDCondNameDirty() && (bl || pSDEDQPDCondBase.getPSDEDQPDCondName() != null)) {
            iDataObject.set(FIELD_PSDEDQPDCONDNAME, (Object)pSDEDQPDCondBase.getPSDEDQPDCondName());
        }
        if (pSDEDQPDCondBase.isUpdateDateDirty() && (bl || pSDEDQPDCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQPDCondBase.getUpdateDate());
        }
        if (pSDEDQPDCondBase.isUpdateManDirty() && (bl || pSDEDQPDCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQPDCondBase.getUpdateMan());
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
        return PSDEDQPDCondBase.remove(this, n);
    }

    private static boolean remove(PSDEDQPDCondBase pSDEDQPDCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQPDCondBase.resetCondObj();
                return true;
            }
            case 1: {
                pSDEDQPDCondBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDQPDCondBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDQPDCondBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDQPDCondBase.resetPSDEDQPDCondId();
                return true;
            }
            case 5: {
                pSDEDQPDCondBase.resetPSDEDQPDCondName();
                return true;
            }
            case 6: {
                pSDEDQPDCondBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDEDQPDCondBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEDQPDCondBase getProxyEntity() {
        return this.proxyPSDEDQPDCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQPDCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQPDCondBase) {
            this.proxyPSDEDQPDCondBase = (PSDEDQPDCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEDQPDCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEDQPDCONDID, 4);
        fieldIndexMap.put(FIELD_PSDEDQPDCONDNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

