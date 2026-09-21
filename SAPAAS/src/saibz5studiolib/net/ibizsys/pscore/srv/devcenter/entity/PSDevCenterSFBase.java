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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterSFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterSFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSFID = "PSDEVCENTERSFID";
    public static final String FIELD_PSDEVCENTERSFNAME = "PSDEVCENTERSFNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSDEVCENTERSFID = 4;
    private static final int INDEX_PSDEVCENTERSFNAME = 5;
    private static final int INDEX_PSSFID = 6;
    private static final int INDEX_PSSFNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterSFBase proxyPSDevCenterSFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcentersfidDirtyFlag = false;
    private boolean psdevcentersfnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcentersfid")
    private String psdevcentersfid;
    @Column(name="psdevcentersfname")
    private String psdevcentersfname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevCenterSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersfid = string;
        this.psdevcentersfidDirtyFlag = true;
    }

    public String getPSDevCenterSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSFId();
        }
        return this.psdevcentersfid;
    }

    public boolean isPSDevCenterSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSFIdDirty();
        }
        return this.psdevcentersfidDirtyFlag;
    }

    public void resetPSDevCenterSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSFId();
            return;
        }
        this.psdevcentersfidDirtyFlag = false;
        this.psdevcentersfid = null;
    }

    public void setPSDevCenterSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentersfname = string;
        this.psdevcentersfnameDirtyFlag = true;
    }

    public String getPSDevCenterSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterSFName();
        }
        return this.psdevcentersfname;
    }

    public boolean isPSDevCenterSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterSFNameDirty();
        }
        return this.psdevcentersfnameDirtyFlag;
    }

    public void resetPSDevCenterSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterSFName();
            return;
        }
        this.psdevcentersfnameDirtyFlag = false;
        this.psdevcentersfname = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
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
        PSDevCenterSFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterSFBase pSDevCenterSFBase) {
        pSDevCenterSFBase.resetCreateDate();
        pSDevCenterSFBase.resetCreateMan();
        pSDevCenterSFBase.resetPSDevCenterId();
        pSDevCenterSFBase.resetPSDevCenterName();
        pSDevCenterSFBase.resetPSDevCenterSFId();
        pSDevCenterSFBase.resetPSDevCenterSFName();
        pSDevCenterSFBase.resetPSSFId();
        pSDevCenterSFBase.resetPSSFName();
        pSDevCenterSFBase.resetUpdateDate();
        pSDevCenterSFBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterSFIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSFID, this.getPSDevCenterSFId());
        }
        if (!bl || this.isPSDevCenterSFNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSFNAME, this.getPSDevCenterSFName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
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
        return PSDevCenterSFBase.get(this, n);
    }

    private static Object get(PSDevCenterSFBase pSDevCenterSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSFBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterSFBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterSFBase.getPSDevCenterId();
            }
            case 3: {
                return pSDevCenterSFBase.getPSDevCenterName();
            }
            case 4: {
                return pSDevCenterSFBase.getPSDevCenterSFId();
            }
            case 5: {
                return pSDevCenterSFBase.getPSDevCenterSFName();
            }
            case 6: {
                return pSDevCenterSFBase.getPSSFId();
            }
            case 7: {
                return pSDevCenterSFBase.getPSSFName();
            }
            case 8: {
                return pSDevCenterSFBase.getUpdateDate();
            }
            case 9: {
                return pSDevCenterSFBase.getUpdateMan();
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
        PSDevCenterSFBase.set(this, n, object);
    }

    private static void set(PSDevCenterSFBase pSDevCenterSFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterSFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterSFBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterSFBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterSFBase.setPSDevCenterSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterSFBase.setPSDevCenterSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterSFBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterSFBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterSFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterSFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevCenterSFBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterSFBase pSDevCenterSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSFBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterSFBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterSFBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSDevCenterSFBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSDevCenterSFBase.getPSDevCenterSFId() == null;
            }
            case 5: {
                return pSDevCenterSFBase.getPSDevCenterSFName() == null;
            }
            case 6: {
                return pSDevCenterSFBase.getPSSFId() == null;
            }
            case 7: {
                return pSDevCenterSFBase.getPSSFName() == null;
            }
            case 8: {
                return pSDevCenterSFBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDevCenterSFBase.getUpdateMan() == null;
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
        return PSDevCenterSFBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterSFBase pSDevCenterSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterSFBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterSFBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterSFBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSDevCenterSFBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSDevCenterSFBase.isPSDevCenterSFIdDirty();
            }
            case 5: {
                return pSDevCenterSFBase.isPSDevCenterSFNameDirty();
            }
            case 6: {
                return pSDevCenterSFBase.isPSSFIdDirty();
            }
            case 7: {
                return pSDevCenterSFBase.isPSSFNameDirty();
            }
            case 8: {
                return pSDevCenterSFBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDevCenterSFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterSFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterSFBase pSDevCenterSFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterSFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersfid", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSDevCenterSFId()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentersfname", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSDevCenterSFName()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterSFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterSFBase.getJSONValue((Object)pSDevCenterSFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterSFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterSFBase pSDevCenterSFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterSFBase.getCreateDate() != null) {
            object = pSDevCenterSFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSFBase.getCreateMan() != null) {
            object = pSDevCenterSFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterId() != null) {
            object = pSDevCenterSFBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterName() != null) {
            object = pSDevCenterSFBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterSFId() != null) {
            object = pSDevCenterSFBase.getPSDevCenterSFId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSDevCenterSFName() != null) {
            object = pSDevCenterSFBase.getPSDevCenterSFName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSSFId() != null) {
            object = pSDevCenterSFBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getPSSFName() != null) {
            object = pSDevCenterSFBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterSFBase.getUpdateDate() != null) {
            object = pSDevCenterSFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterSFBase.getUpdateMan() != null) {
            object = pSDevCenterSFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterSFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterSFBase pSDevCenterSFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterSFBase.isCreateDateDirty() && (bl || pSDevCenterSFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterSFBase.getCreateDate());
        }
        if (pSDevCenterSFBase.isCreateManDirty() && (bl || pSDevCenterSFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterSFBase.getCreateMan());
        }
        if (pSDevCenterSFBase.isPSDevCenterIdDirty() && (bl || pSDevCenterSFBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterSFBase.getPSDevCenterId());
        }
        if (pSDevCenterSFBase.isPSDevCenterNameDirty() && (bl || pSDevCenterSFBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterSFBase.getPSDevCenterName());
        }
        if (pSDevCenterSFBase.isPSDevCenterSFIdDirty() && (bl || pSDevCenterSFBase.getPSDevCenterSFId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSFID, (Object)pSDevCenterSFBase.getPSDevCenterSFId());
        }
        if (pSDevCenterSFBase.isPSDevCenterSFNameDirty() && (bl || pSDevCenterSFBase.getPSDevCenterSFName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSFNAME, (Object)pSDevCenterSFBase.getPSDevCenterSFName());
        }
        if (pSDevCenterSFBase.isPSSFIdDirty() && (bl || pSDevCenterSFBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSDevCenterSFBase.getPSSFId());
        }
        if (pSDevCenterSFBase.isPSSFNameDirty() && (bl || pSDevCenterSFBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSDevCenterSFBase.getPSSFName());
        }
        if (pSDevCenterSFBase.isUpdateDateDirty() && (bl || pSDevCenterSFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterSFBase.getUpdateDate());
        }
        if (pSDevCenterSFBase.isUpdateManDirty() && (bl || pSDevCenterSFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterSFBase.getUpdateMan());
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
        return PSDevCenterSFBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterSFBase pSDevCenterSFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterSFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterSFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterSFBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSDevCenterSFBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSDevCenterSFBase.resetPSDevCenterSFId();
                return true;
            }
            case 5: {
                pSDevCenterSFBase.resetPSDevCenterSFName();
                return true;
            }
            case 6: {
                pSDevCenterSFBase.resetPSSFId();
                return true;
            }
            case 7: {
                pSDevCenterSFBase.resetPSSFName();
                return true;
            }
            case 8: {
                pSDevCenterSFBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDevCenterSFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSDevCenterSFBase getProxyEntity() {
        return this.proxyPSDevCenterSFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterSFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterSFBase) {
            this.proxyPSDevCenterSFBase = (PSDevCenterSFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERSFID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERSFNAME, 5);
        fieldIndexMap.put(FIELD_PSSFID, 6);
        fieldIndexMap.put(FIELD_PSSFNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

