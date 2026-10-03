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
import net.ibizsys.pscore.srv.config.entity.PSModelAPIInt;
import net.ibizsys.pscore.srv.config.service.PSModelAPIIntService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelAPIMethodBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelAPIMethodBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELAPIINTID = "PSMODELAPIINTID";
    public static final String FIELD_PSMODELAPIINTNAME = "PSMODELAPIINTNAME";
    public static final String FIELD_PSMODELAPIMETHODID = "PSMODELAPIMETHODID";
    public static final String FIELD_PSMODELAPIMETHODNAME = "PSMODELAPIMETHODNAME";
    public static final String FIELD_PSMODELAPINAME = "PSMODELAPINAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMODELAPIINTID = 3;
    private static final int INDEX_PSMODELAPIINTNAME = 4;
    private static final int INDEX_PSMODELAPIMETHODID = 5;
    private static final int INDEX_PSMODELAPIMETHODNAME = 6;
    private static final int INDEX_PSMODELAPINAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelAPIMethodBase proxyPSModelAPIMethodBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelapiintidDirtyFlag = false;
    private boolean psmodelapiintnameDirtyFlag = false;
    private boolean psmodelapimethodidDirtyFlag = false;
    private boolean psmodelapimethodnameDirtyFlag = false;
    private boolean psmodelapinameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelapiintid")
    private String psmodelapiintid;
    @Column(name="psmodelapiintname")
    private String psmodelapiintname;
    @Column(name="psmodelapimethodid")
    private String psmodelapimethodid;
    @Column(name="psmodelapimethodname")
    private String psmodelapimethodname;
    @Column(name="psmodelapiname")
    private String psmodelapiname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelAPIIntLock = new Integer(1);
    private PSModelAPIInt psmodelapiint = null;

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

    public void setPSModelAPIIntId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIIntId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiintid = string;
        this.psmodelapiintidDirtyFlag = true;
    }

    public String getPSModelAPIIntId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIIntId();
        }
        return this.psmodelapiintid;
    }

    public boolean isPSModelAPIIntIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIntIdDirty();
        }
        return this.psmodelapiintidDirtyFlag;
    }

    public void resetPSModelAPIIntId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIIntId();
            return;
        }
        this.psmodelapiintidDirtyFlag = false;
        this.psmodelapiintid = null;
    }

    public void setPSModelAPIIntName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIIntName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiintname = string;
        this.psmodelapiintnameDirtyFlag = true;
    }

    public String getPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIIntName();
        }
        return this.psmodelapiintname;
    }

    public boolean isPSModelAPIIntNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIIntNameDirty();
        }
        return this.psmodelapiintnameDirtyFlag;
    }

    public void resetPSModelAPIIntName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIIntName();
            return;
        }
        this.psmodelapiintnameDirtyFlag = false;
        this.psmodelapiintname = null;
    }

    public void setPSModelAPIMethodId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIMethodId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapimethodid = string;
        this.psmodelapimethodidDirtyFlag = true;
    }

    public String getPSModelAPIMethodId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIMethodId();
        }
        return this.psmodelapimethodid;
    }

    public boolean isPSModelAPIMethodIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIMethodIdDirty();
        }
        return this.psmodelapimethodidDirtyFlag;
    }

    public void resetPSModelAPIMethodId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIMethodId();
            return;
        }
        this.psmodelapimethodidDirtyFlag = false;
        this.psmodelapimethodid = null;
    }

    public void setPSModelAPIMethodName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIMethodName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapimethodname = string;
        this.psmodelapimethodnameDirtyFlag = true;
    }

    public String getPSModelAPIMethodName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIMethodName();
        }
        return this.psmodelapimethodname;
    }

    public boolean isPSModelAPIMethodNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPIMethodNameDirty();
        }
        return this.psmodelapimethodnameDirtyFlag;
    }

    public void resetPSModelAPIMethodName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIMethodName();
            return;
        }
        this.psmodelapimethodnameDirtyFlag = false;
        this.psmodelapimethodname = null;
    }

    public void setPSModelAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelapiname = string;
        this.psmodelapinameDirtyFlag = true;
    }

    public String getPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIName();
        }
        return this.psmodelapiname;
    }

    public boolean isPSModelAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelAPINameDirty();
        }
        return this.psmodelapinameDirtyFlag;
    }

    public void resetPSModelAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelAPIName();
            return;
        }
        this.psmodelapinameDirtyFlag = false;
        this.psmodelapiname = null;
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
        PSModelAPIMethodBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelAPIMethodBase pSModelAPIMethodBase) {
        pSModelAPIMethodBase.resetCreateDate();
        pSModelAPIMethodBase.resetCreateMan();
        pSModelAPIMethodBase.resetMemo();
        pSModelAPIMethodBase.resetPSModelAPIIntId();
        pSModelAPIMethodBase.resetPSModelAPIIntName();
        pSModelAPIMethodBase.resetPSModelAPIMethodId();
        pSModelAPIMethodBase.resetPSModelAPIMethodName();
        pSModelAPIMethodBase.resetPSModelAPIName();
        pSModelAPIMethodBase.resetUpdateDate();
        pSModelAPIMethodBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModelAPIIntIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIINTID, this.getPSModelAPIIntId());
        }
        if (!bl || this.isPSModelAPIIntNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIINTNAME, this.getPSModelAPIIntName());
        }
        if (!bl || this.isPSModelAPIMethodIdDirty()) {
            hashMap.put(FIELD_PSMODELAPIMETHODID, this.getPSModelAPIMethodId());
        }
        if (!bl || this.isPSModelAPIMethodNameDirty()) {
            hashMap.put(FIELD_PSMODELAPIMETHODNAME, this.getPSModelAPIMethodName());
        }
        if (!bl || this.isPSModelAPINameDirty()) {
            hashMap.put(FIELD_PSMODELAPINAME, this.getPSModelAPIName());
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
        return PSModelAPIMethodBase.get(this, n);
    }

    private static Object get(PSModelAPIMethodBase pSModelAPIMethodBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIMethodBase.getCreateDate();
            }
            case 1: {
                return pSModelAPIMethodBase.getCreateMan();
            }
            case 2: {
                return pSModelAPIMethodBase.getMemo();
            }
            case 3: {
                return pSModelAPIMethodBase.getPSModelAPIIntId();
            }
            case 4: {
                return pSModelAPIMethodBase.getPSModelAPIIntName();
            }
            case 5: {
                return pSModelAPIMethodBase.getPSModelAPIMethodId();
            }
            case 6: {
                return pSModelAPIMethodBase.getPSModelAPIMethodName();
            }
            case 7: {
                return pSModelAPIMethodBase.getPSModelAPIName();
            }
            case 8: {
                return pSModelAPIMethodBase.getUpdateDate();
            }
            case 9: {
                return pSModelAPIMethodBase.getUpdateMan();
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
        PSModelAPIMethodBase.set(this, n, object);
    }

    private static void set(PSModelAPIMethodBase pSModelAPIMethodBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIMethodBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelAPIMethodBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelAPIMethodBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelAPIMethodBase.setPSModelAPIIntId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelAPIMethodBase.setPSModelAPIIntName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelAPIMethodBase.setPSModelAPIMethodId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelAPIMethodBase.setPSModelAPIMethodName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelAPIMethodBase.setPSModelAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelAPIMethodBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSModelAPIMethodBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelAPIMethodBase.isNull(this, n);
    }

    private static boolean isNull(PSModelAPIMethodBase pSModelAPIMethodBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIMethodBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelAPIMethodBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelAPIMethodBase.getMemo() == null;
            }
            case 3: {
                return pSModelAPIMethodBase.getPSModelAPIIntId() == null;
            }
            case 4: {
                return pSModelAPIMethodBase.getPSModelAPIIntName() == null;
            }
            case 5: {
                return pSModelAPIMethodBase.getPSModelAPIMethodId() == null;
            }
            case 6: {
                return pSModelAPIMethodBase.getPSModelAPIMethodName() == null;
            }
            case 7: {
                return pSModelAPIMethodBase.getPSModelAPIName() == null;
            }
            case 8: {
                return pSModelAPIMethodBase.getUpdateDate() == null;
            }
            case 9: {
                return pSModelAPIMethodBase.getUpdateMan() == null;
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
        return PSModelAPIMethodBase.contains(this, n);
    }

    private static boolean contains(PSModelAPIMethodBase pSModelAPIMethodBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelAPIMethodBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelAPIMethodBase.isCreateManDirty();
            }
            case 2: {
                return pSModelAPIMethodBase.isMemoDirty();
            }
            case 3: {
                return pSModelAPIMethodBase.isPSModelAPIIntIdDirty();
            }
            case 4: {
                return pSModelAPIMethodBase.isPSModelAPIIntNameDirty();
            }
            case 5: {
                return pSModelAPIMethodBase.isPSModelAPIMethodIdDirty();
            }
            case 6: {
                return pSModelAPIMethodBase.isPSModelAPIMethodNameDirty();
            }
            case 7: {
                return pSModelAPIMethodBase.isPSModelAPINameDirty();
            }
            case 8: {
                return pSModelAPIMethodBase.isUpdateDateDirty();
            }
            case 9: {
                return pSModelAPIMethodBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelAPIMethodBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelAPIMethodBase pSModelAPIMethodBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelAPIMethodBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIIntId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiintid", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getPSModelAPIIntId()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIIntName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiintname", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getPSModelAPIIntName()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIMethodId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapimethodid", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getPSModelAPIMethodId()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIMethodName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapimethodname", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getPSModelAPIMethodName()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelapiname", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getPSModelAPIName()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelAPIMethodBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelAPIMethodBase.getJSONValue((Object)pSModelAPIMethodBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelAPIMethodBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelAPIMethodBase pSModelAPIMethodBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelAPIMethodBase.getCreateDate() != null) {
            object = pSModelAPIMethodBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIMethodBase.getCreateMan() != null) {
            object = pSModelAPIMethodBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getMemo() != null) {
            object = pSModelAPIMethodBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIIntId() != null) {
            object = pSModelAPIMethodBase.getPSModelAPIIntId();
            xmlNode.setAttribute(FIELD_PSMODELAPIINTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIIntName() != null) {
            object = pSModelAPIMethodBase.getPSModelAPIIntName();
            xmlNode.setAttribute(FIELD_PSMODELAPIINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIMethodId() != null) {
            object = pSModelAPIMethodBase.getPSModelAPIMethodId();
            xmlNode.setAttribute(FIELD_PSMODELAPIMETHODID, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIMethodName() != null) {
            object = pSModelAPIMethodBase.getPSModelAPIMethodName();
            xmlNode.setAttribute(FIELD_PSMODELAPIMETHODNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getPSModelAPIName() != null) {
            object = pSModelAPIMethodBase.getPSModelAPIName();
            xmlNode.setAttribute(FIELD_PSMODELAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelAPIMethodBase.getUpdateDate() != null) {
            object = pSModelAPIMethodBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelAPIMethodBase.getUpdateMan() != null) {
            object = pSModelAPIMethodBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelAPIMethodBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelAPIMethodBase pSModelAPIMethodBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelAPIMethodBase.isCreateDateDirty() && (bl || pSModelAPIMethodBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelAPIMethodBase.getCreateDate());
        }
        if (pSModelAPIMethodBase.isCreateManDirty() && (bl || pSModelAPIMethodBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelAPIMethodBase.getCreateMan());
        }
        if (pSModelAPIMethodBase.isMemoDirty() && (bl || pSModelAPIMethodBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelAPIMethodBase.getMemo());
        }
        if (pSModelAPIMethodBase.isPSModelAPIIntIdDirty() && (bl || pSModelAPIMethodBase.getPSModelAPIIntId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIINTID, (Object)pSModelAPIMethodBase.getPSModelAPIIntId());
        }
        if (pSModelAPIMethodBase.isPSModelAPIIntNameDirty() && (bl || pSModelAPIMethodBase.getPSModelAPIIntName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIINTNAME, (Object)pSModelAPIMethodBase.getPSModelAPIIntName());
        }
        if (pSModelAPIMethodBase.isPSModelAPIMethodIdDirty() && (bl || pSModelAPIMethodBase.getPSModelAPIMethodId() != null)) {
            iDataObject.set(FIELD_PSMODELAPIMETHODID, (Object)pSModelAPIMethodBase.getPSModelAPIMethodId());
        }
        if (pSModelAPIMethodBase.isPSModelAPIMethodNameDirty() && (bl || pSModelAPIMethodBase.getPSModelAPIMethodName() != null)) {
            iDataObject.set(FIELD_PSMODELAPIMETHODNAME, (Object)pSModelAPIMethodBase.getPSModelAPIMethodName());
        }
        if (pSModelAPIMethodBase.isPSModelAPINameDirty() && (bl || pSModelAPIMethodBase.getPSModelAPIName() != null)) {
            iDataObject.set(FIELD_PSMODELAPINAME, (Object)pSModelAPIMethodBase.getPSModelAPIName());
        }
        if (pSModelAPIMethodBase.isUpdateDateDirty() && (bl || pSModelAPIMethodBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelAPIMethodBase.getUpdateDate());
        }
        if (pSModelAPIMethodBase.isUpdateManDirty() && (bl || pSModelAPIMethodBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelAPIMethodBase.getUpdateMan());
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
        return PSModelAPIMethodBase.remove(this, n);
    }

    private static boolean remove(PSModelAPIMethodBase pSModelAPIMethodBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelAPIMethodBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelAPIMethodBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelAPIMethodBase.resetMemo();
                return true;
            }
            case 3: {
                pSModelAPIMethodBase.resetPSModelAPIIntId();
                return true;
            }
            case 4: {
                pSModelAPIMethodBase.resetPSModelAPIIntName();
                return true;
            }
            case 5: {
                pSModelAPIMethodBase.resetPSModelAPIMethodId();
                return true;
            }
            case 6: {
                pSModelAPIMethodBase.resetPSModelAPIMethodName();
                return true;
            }
            case 7: {
                pSModelAPIMethodBase.resetPSModelAPIName();
                return true;
            }
            case 8: {
                pSModelAPIMethodBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSModelAPIMethodBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelAPIInt getPSModelAPIInt() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelAPIInt();
        }
        if (this.getPSModelAPIIntId() == null) {
            return null;
        }
        Integer n = this.objPSModelAPIIntLock;
        synchronized (n) {
            if (this.psmodelapiint != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelAPIIntId(), (Object)this.psmodelapiint.getPSModelAPIIntId()) != 0L) {
                this.psmodelapiint = null;
            }
            if (this.psmodelapiint == null) {
                PSModelAPIInt pSModelAPIInt = new PSModelAPIInt();
                pSModelAPIInt.setPSModelAPIIntId(this.getPSModelAPIIntId());
                PSModelAPIIntService pSModelAPIIntService = (PSModelAPIIntService)ServiceGlobal.getService(PSModelAPIIntService.class, (SessionFactory)this.getSessionFactory());
                pSModelAPIIntService.autoGet(pSModelAPIInt);
                this.psmodelapiint = pSModelAPIInt;
            }
            return this.psmodelapiint;
        }
    }

    private PSModelAPIMethodBase getProxyEntity() {
        return this.proxyPSModelAPIMethodBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelAPIMethodBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelAPIMethodBase) {
            this.proxyPSModelAPIMethodBase = (PSModelAPIMethodBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelAPIMethodService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMODELAPIINTID, 3);
        fieldIndexMap.put(FIELD_PSMODELAPIINTNAME, 4);
        fieldIndexMap.put(FIELD_PSMODELAPIMETHODID, 5);
        fieldIndexMap.put(FIELD_PSMODELAPIMETHODNAME, 6);
        fieldIndexMap.put(FIELD_PSMODELAPINAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

