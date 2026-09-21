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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCounterItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCounterItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String FIELD_PSSYSCOUNTERITEMID = "PSSYSCOUNTERITEMID";
    public static final String FIELD_PSSYSCOUNTERITEMNAME = "PSSYSCOUNTERITEMNAME";
    public static final String FIELD_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSYSCOUNTERID = 4;
    private static final int INDEX_PSSYSCOUNTERITEMID = 5;
    private static final int INDEX_PSSYSCOUNTERITEMNAME = 6;
    private static final int INDEX_PSSYSCOUNTERNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCounterItemBase proxyPSSysCounterItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyscounteridDirtyFlag = false;
    private boolean pssyscounteritemidDirtyFlag = false;
    private boolean pssyscounteritemnameDirtyFlag = false;
    private boolean pssyscounternameDirtyFlag = false;
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
    @Column(name="pssyscounterid")
    private String pssyscounterid;
    @Column(name="pssyscounteritemid")
    private String pssyscounteritemid;
    @Column(name="pssyscounteritemname")
    private String pssyscounteritemname;
    @Column(name="pssyscountername")
    private String pssyscountername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysCounterLock = new Integer(1);
    private PSSysCounter pssyscounter = null;

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

    public void setPSSysCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounterid = string;
        this.pssyscounteridDirtyFlag = true;
    }

    public String getPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterId();
        }
        return this.pssyscounterid;
    }

    public boolean isPSSysCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterIdDirty();
        }
        return this.pssyscounteridDirtyFlag;
    }

    public void resetPSSysCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterId();
            return;
        }
        this.pssyscounteridDirtyFlag = false;
        this.pssyscounterid = null;
    }

    public void setPSSysCounterItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounteritemid = string;
        this.pssyscounteritemidDirtyFlag = true;
    }

    public String getPSSysCounterItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterItemId();
        }
        return this.pssyscounteritemid;
    }

    public boolean isPSSysCounterItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterItemIdDirty();
        }
        return this.pssyscounteritemidDirtyFlag;
    }

    public void resetPSSysCounterItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterItemId();
            return;
        }
        this.pssyscounteritemidDirtyFlag = false;
        this.pssyscounteritemid = null;
    }

    public void setPSSysCounterItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscounteritemname = string;
        this.pssyscounteritemnameDirtyFlag = true;
    }

    public String getPSSysCounterItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterItemName();
        }
        return this.pssyscounteritemname;
    }

    public boolean isPSSysCounterItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterItemNameDirty();
        }
        return this.pssyscounteritemnameDirtyFlag;
    }

    public void resetPSSysCounterItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterItemName();
            return;
        }
        this.pssyscounteritemnameDirtyFlag = false;
        this.pssyscounteritemname = null;
    }

    public void setPSSysCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscountername = string;
        this.pssyscounternameDirtyFlag = true;
    }

    public String getPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounterName();
        }
        return this.pssyscountername;
    }

    public boolean isPSSysCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCounterNameDirty();
        }
        return this.pssyscounternameDirtyFlag;
    }

    public void resetPSSysCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCounterName();
            return;
        }
        this.pssyscounternameDirtyFlag = false;
        this.pssyscountername = null;
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
        PSSysCounterItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCounterItemBase pSSysCounterItemBase) {
        pSSysCounterItemBase.resetCreateDate();
        pSSysCounterItemBase.resetCreateMan();
        pSSysCounterItemBase.resetLogicName();
        pSSysCounterItemBase.resetMemo();
        pSSysCounterItemBase.resetPSSysCounterId();
        pSSysCounterItemBase.resetPSSysCounterItemId();
        pSSysCounterItemBase.resetPSSysCounterItemName();
        pSSysCounterItemBase.resetPSSysCounterName();
        pSSysCounterItemBase.resetUpdateDate();
        pSSysCounterItemBase.resetUpdateMan();
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
        if (!bl || this.isPSSysCounterIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERID, this.getPSSysCounterId());
        }
        if (!bl || this.isPSSysCounterItemIdDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERITEMID, this.getPSSysCounterItemId());
        }
        if (!bl || this.isPSSysCounterItemNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERITEMNAME, this.getPSSysCounterItemName());
        }
        if (!bl || this.isPSSysCounterNameDirty()) {
            hashMap.put(FIELD_PSSYSCOUNTERNAME, this.getPSSysCounterName());
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
        return PSSysCounterItemBase.get(this, n);
    }

    private static Object get(PSSysCounterItemBase pSSysCounterItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterItemBase.getCreateDate();
            }
            case 1: {
                return pSSysCounterItemBase.getCreateMan();
            }
            case 2: {
                return pSSysCounterItemBase.getLogicName();
            }
            case 3: {
                return pSSysCounterItemBase.getMemo();
            }
            case 4: {
                return pSSysCounterItemBase.getPSSysCounterId();
            }
            case 5: {
                return pSSysCounterItemBase.getPSSysCounterItemId();
            }
            case 6: {
                return pSSysCounterItemBase.getPSSysCounterItemName();
            }
            case 7: {
                return pSSysCounterItemBase.getPSSysCounterName();
            }
            case 8: {
                return pSSysCounterItemBase.getUpdateDate();
            }
            case 9: {
                return pSSysCounterItemBase.getUpdateMan();
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
        PSSysCounterItemBase.set(this, n, object);
    }

    private static void set(PSSysCounterItemBase pSSysCounterItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCounterItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysCounterItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCounterItemBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCounterItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCounterItemBase.setPSSysCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCounterItemBase.setPSSysCounterItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCounterItemBase.setPSSysCounterItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCounterItemBase.setPSSysCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCounterItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSysCounterItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysCounterItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCounterItemBase pSSysCounterItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysCounterItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysCounterItemBase.getLogicName() == null;
            }
            case 3: {
                return pSSysCounterItemBase.getMemo() == null;
            }
            case 4: {
                return pSSysCounterItemBase.getPSSysCounterId() == null;
            }
            case 5: {
                return pSSysCounterItemBase.getPSSysCounterItemId() == null;
            }
            case 6: {
                return pSSysCounterItemBase.getPSSysCounterItemName() == null;
            }
            case 7: {
                return pSSysCounterItemBase.getPSSysCounterName() == null;
            }
            case 8: {
                return pSSysCounterItemBase.getUpdateDate() == null;
            }
            case 9: {
                return pSSysCounterItemBase.getUpdateMan() == null;
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
        return PSSysCounterItemBase.contains(this, n);
    }

    private static boolean contains(PSSysCounterItemBase pSSysCounterItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCounterItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysCounterItemBase.isCreateManDirty();
            }
            case 2: {
                return pSSysCounterItemBase.isLogicNameDirty();
            }
            case 3: {
                return pSSysCounterItemBase.isMemoDirty();
            }
            case 4: {
                return pSSysCounterItemBase.isPSSysCounterIdDirty();
            }
            case 5: {
                return pSSysCounterItemBase.isPSSysCounterItemIdDirty();
            }
            case 6: {
                return pSSysCounterItemBase.isPSSysCounterItemNameDirty();
            }
            case 7: {
                return pSSysCounterItemBase.isPSSysCounterNameDirty();
            }
            case 8: {
                return pSSysCounterItemBase.isUpdateDateDirty();
            }
            case 9: {
                return pSSysCounterItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCounterItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCounterItemBase pSSysCounterItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCounterItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounterid", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getPSSysCounterId()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounteritemid", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getPSSysCounterItemId()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscounteritemname", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getPSSysCounterItemName()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscountername", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getPSSysCounterName()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCounterItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCounterItemBase.getJSONValue((Object)pSSysCounterItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCounterItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCounterItemBase pSSysCounterItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCounterItemBase.getCreateDate() != null) {
            object = pSSysCounterItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCounterItemBase.getCreateMan() != null) {
            object = pSSysCounterItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getLogicName() != null) {
            object = pSSysCounterItemBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getMemo() != null) {
            object = pSSysCounterItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterId() != null) {
            object = pSSysCounterItemBase.getPSSysCounterId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterItemId() != null) {
            object = pSSysCounterItemBase.getPSSysCounterItemId();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterItemName() != null) {
            object = pSSysCounterItemBase.getPSSysCounterItemName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getPSSysCounterName() != null) {
            object = pSSysCounterItemBase.getPSSysCounterName();
            xmlNode.setAttribute(FIELD_PSSYSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCounterItemBase.getUpdateDate() != null) {
            object = pSSysCounterItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCounterItemBase.getUpdateMan() != null) {
            object = pSSysCounterItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCounterItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCounterItemBase pSSysCounterItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCounterItemBase.isCreateDateDirty() && (bl || pSSysCounterItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCounterItemBase.getCreateDate());
        }
        if (pSSysCounterItemBase.isCreateManDirty() && (bl || pSSysCounterItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCounterItemBase.getCreateMan());
        }
        if (pSSysCounterItemBase.isLogicNameDirty() && (bl || pSSysCounterItemBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysCounterItemBase.getLogicName());
        }
        if (pSSysCounterItemBase.isMemoDirty() && (bl || pSSysCounterItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCounterItemBase.getMemo());
        }
        if (pSSysCounterItemBase.isPSSysCounterIdDirty() && (bl || pSSysCounterItemBase.getPSSysCounterId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERID, (Object)pSSysCounterItemBase.getPSSysCounterId());
        }
        if (pSSysCounterItemBase.isPSSysCounterItemIdDirty() && (bl || pSSysCounterItemBase.getPSSysCounterItemId() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERITEMID, (Object)pSSysCounterItemBase.getPSSysCounterItemId());
        }
        if (pSSysCounterItemBase.isPSSysCounterItemNameDirty() && (bl || pSSysCounterItemBase.getPSSysCounterItemName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERITEMNAME, (Object)pSSysCounterItemBase.getPSSysCounterItemName());
        }
        if (pSSysCounterItemBase.isPSSysCounterNameDirty() && (bl || pSSysCounterItemBase.getPSSysCounterName() != null)) {
            iDataObject.set(FIELD_PSSYSCOUNTERNAME, (Object)pSSysCounterItemBase.getPSSysCounterName());
        }
        if (pSSysCounterItemBase.isUpdateDateDirty() && (bl || pSSysCounterItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCounterItemBase.getUpdateDate());
        }
        if (pSSysCounterItemBase.isUpdateManDirty() && (bl || pSSysCounterItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCounterItemBase.getUpdateMan());
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
        return PSSysCounterItemBase.remove(this, n);
    }

    private static boolean remove(PSSysCounterItemBase pSSysCounterItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCounterItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysCounterItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysCounterItemBase.resetLogicName();
                return true;
            }
            case 3: {
                pSSysCounterItemBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysCounterItemBase.resetPSSysCounterId();
                return true;
            }
            case 5: {
                pSSysCounterItemBase.resetPSSysCounterItemId();
                return true;
            }
            case 6: {
                pSSysCounterItemBase.resetPSSysCounterItemName();
                return true;
            }
            case 7: {
                pSSysCounterItemBase.resetPSSysCounterName();
                return true;
            }
            case 8: {
                pSSysCounterItemBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSSysCounterItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCounter getPSSysCounter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCounter();
        }
        if (this.getPSSysCounterId() == null) {
            return null;
        }
        Integer n = this.objPSSysCounterLock;
        synchronized (n) {
            if (this.pssyscounter != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCounterId(), (Object)this.pssyscounter.getPSSysCounterId()) != 0L) {
                this.pssyscounter = null;
            }
            if (this.pssyscounter == null) {
                PSSysCounter pSSysCounter = new PSSysCounter();
                pSSysCounter.setPSSysCounterId(this.getPSSysCounterId());
                PSSysCounterService pSSysCounterService = (PSSysCounterService)ServiceGlobal.getService(PSSysCounterService.class, (SessionFactory)this.getSessionFactory());
                pSSysCounterService.autoGet((IEntity)pSSysCounter);
                this.pssyscounter = pSSysCounter;
            }
            return this.pssyscounter;
        }
    }

    private PSSysCounterItemBase getProxyEntity() {
        return this.proxyPSSysCounterItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCounterItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCounterItemBase) {
            this.proxyPSSysCounterItemBase = (PSSysCounterItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERID, 4);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERITEMID, 5);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERITEMNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSCOUNTERNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

