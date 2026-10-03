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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPrdVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPrdVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSPRDVERID = "PSSYSPRDVERID";
    public static final String FIELD_PSSYSPRDVERNAME = "PSSYSPRDVERNAME";
    public static final String FIELD_PSSYSPRODUCTID = "PSSYSPRODUCTID";
    public static final String FIELD_PSSYSPRODUCTNAME = "PSSYSPRODUCTNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSPRDVERID = 3;
    private static final int INDEX_PSSYSPRDVERNAME = 4;
    private static final int INDEX_PSSYSPRODUCTID = 5;
    private static final int INDEX_PSSYSPRODUCTNAME = 6;
    private static final int INDEX_PSSYSTEMID = 7;
    private static final int INDEX_PSSYSTEMNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPrdVerBase proxyPSSysPrdVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysprdveridDirtyFlag = false;
    private boolean pssysprdvernameDirtyFlag = false;
    private boolean pssysproductidDirtyFlag = false;
    private boolean pssysproductnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysprdverid")
    private String pssysprdverid;
    @Column(name="pssysprdvername")
    private String pssysprdvername;
    @Column(name="pssysproductid")
    private String pssysproductid;
    @Column(name="pssysproductname")
    private String pssysproductname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysProductLock = new Integer(1);
    private PSSysProduct pssysproduct = null;

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

    public void setPSSysPrdVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPrdVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysprdverid = string;
        this.pssysprdveridDirtyFlag = true;
    }

    public String getPSSysPrdVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPrdVerId();
        }
        return this.pssysprdverid;
    }

    public boolean isPSSysPrdVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPrdVerIdDirty();
        }
        return this.pssysprdveridDirtyFlag;
    }

    public void resetPSSysPrdVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPrdVerId();
            return;
        }
        this.pssysprdveridDirtyFlag = false;
        this.pssysprdverid = null;
    }

    public void setPSSysPrdVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPrdVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysprdvername = string;
        this.pssysprdvernameDirtyFlag = true;
    }

    public String getPSSysPrdVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPrdVerName();
        }
        return this.pssysprdvername;
    }

    public boolean isPSSysPrdVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPrdVerNameDirty();
        }
        return this.pssysprdvernameDirtyFlag;
    }

    public void resetPSSysPrdVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPrdVerName();
            return;
        }
        this.pssysprdvernameDirtyFlag = false;
        this.pssysprdvername = null;
    }

    public void setPSSysProductId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductid = string;
        this.pssysproductidDirtyFlag = true;
    }

    public String getPSSysProductId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductId();
        }
        return this.pssysproductid;
    }

    public boolean isPSSysProductIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductIdDirty();
        }
        return this.pssysproductidDirtyFlag;
    }

    public void resetPSSysProductId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductId();
            return;
        }
        this.pssysproductidDirtyFlag = false;
        this.pssysproductid = null;
    }

    public void setPSSysProductName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysProductName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysproductname = string;
        this.pssysproductnameDirtyFlag = true;
    }

    public String getPSSysProductName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProductName();
        }
        return this.pssysproductname;
    }

    public boolean isPSSysProductNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysProductNameDirty();
        }
        return this.pssysproductnameDirtyFlag;
    }

    public void resetPSSysProductName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysProductName();
            return;
        }
        this.pssysproductnameDirtyFlag = false;
        this.pssysproductname = null;
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
        PSSysPrdVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPrdVerBase pSSysPrdVerBase) {
        pSSysPrdVerBase.resetCreateDate();
        pSSysPrdVerBase.resetCreateMan();
        pSSysPrdVerBase.resetMemo();
        pSSysPrdVerBase.resetPSSysPrdVerId();
        pSSysPrdVerBase.resetPSSysPrdVerName();
        pSSysPrdVerBase.resetPSSysProductId();
        pSSysPrdVerBase.resetPSSysProductName();
        pSSysPrdVerBase.resetPSSystemId();
        pSSysPrdVerBase.resetPSSystemName();
        pSSysPrdVerBase.resetUpdateDate();
        pSSysPrdVerBase.resetUpdateMan();
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
        if (!bl || this.isPSSysPrdVerIdDirty()) {
            hashMap.put(FIELD_PSSYSPRDVERID, this.getPSSysPrdVerId());
        }
        if (!bl || this.isPSSysPrdVerNameDirty()) {
            hashMap.put(FIELD_PSSYSPRDVERNAME, this.getPSSysPrdVerName());
        }
        if (!bl || this.isPSSysProductIdDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTID, this.getPSSysProductId());
        }
        if (!bl || this.isPSSysProductNameDirty()) {
            hashMap.put(FIELD_PSSYSPRODUCTNAME, this.getPSSysProductName());
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
        return PSSysPrdVerBase.get(this, n);
    }

    private static Object get(PSSysPrdVerBase pSSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPrdVerBase.getCreateDate();
            }
            case 1: {
                return pSSysPrdVerBase.getCreateMan();
            }
            case 2: {
                return pSSysPrdVerBase.getMemo();
            }
            case 3: {
                return pSSysPrdVerBase.getPSSysPrdVerId();
            }
            case 4: {
                return pSSysPrdVerBase.getPSSysPrdVerName();
            }
            case 5: {
                return pSSysPrdVerBase.getPSSysProductId();
            }
            case 6: {
                return pSSysPrdVerBase.getPSSysProductName();
            }
            case 7: {
                return pSSysPrdVerBase.getPSSystemId();
            }
            case 8: {
                return pSSysPrdVerBase.getPSSystemName();
            }
            case 9: {
                return pSSysPrdVerBase.getUpdateDate();
            }
            case 10: {
                return pSSysPrdVerBase.getUpdateMan();
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
        PSSysPrdVerBase.set(this, n, object);
    }

    private static void set(PSSysPrdVerBase pSSysPrdVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPrdVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysPrdVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysPrdVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPrdVerBase.setPSSysPrdVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysPrdVerBase.setPSSysPrdVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysPrdVerBase.setPSSysProductId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPrdVerBase.setPSSysProductName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysPrdVerBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPrdVerBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPrdVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysPrdVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysPrdVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPrdVerBase pSSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPrdVerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysPrdVerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysPrdVerBase.getMemo() == null;
            }
            case 3: {
                return pSSysPrdVerBase.getPSSysPrdVerId() == null;
            }
            case 4: {
                return pSSysPrdVerBase.getPSSysPrdVerName() == null;
            }
            case 5: {
                return pSSysPrdVerBase.getPSSysProductId() == null;
            }
            case 6: {
                return pSSysPrdVerBase.getPSSysProductName() == null;
            }
            case 7: {
                return pSSysPrdVerBase.getPSSystemId() == null;
            }
            case 8: {
                return pSSysPrdVerBase.getPSSystemName() == null;
            }
            case 9: {
                return pSSysPrdVerBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSysPrdVerBase.getUpdateMan() == null;
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
        return PSSysPrdVerBase.contains(this, n);
    }

    private static boolean contains(PSSysPrdVerBase pSSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPrdVerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysPrdVerBase.isCreateManDirty();
            }
            case 2: {
                return pSSysPrdVerBase.isMemoDirty();
            }
            case 3: {
                return pSSysPrdVerBase.isPSSysPrdVerIdDirty();
            }
            case 4: {
                return pSSysPrdVerBase.isPSSysPrdVerNameDirty();
            }
            case 5: {
                return pSSysPrdVerBase.isPSSysProductIdDirty();
            }
            case 6: {
                return pSSysPrdVerBase.isPSSysProductNameDirty();
            }
            case 7: {
                return pSSysPrdVerBase.isPSSystemIdDirty();
            }
            case 8: {
                return pSSysPrdVerBase.isPSSystemNameDirty();
            }
            case 9: {
                return pSSysPrdVerBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSysPrdVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPrdVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPrdVerBase pSSysPrdVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPrdVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSysPrdVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysprdverid", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSysPrdVerId()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSysPrdVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysprdvername", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSysPrdVerName()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSysProductId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductid", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSysProductId()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSysProductName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysproductname", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSysProductName()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPrdVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPrdVerBase.getJSONValue((Object)pSSysPrdVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPrdVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPrdVerBase pSSysPrdVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPrdVerBase.getCreateDate() != null) {
            object = pSSysPrdVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPrdVerBase.getCreateMan() != null) {
            object = pSSysPrdVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getMemo() != null) {
            object = pSSysPrdVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSysPrdVerId() != null) {
            object = pSSysPrdVerBase.getPSSysPrdVerId();
            xmlNode.setAttribute(FIELD_PSSYSPRDVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSysPrdVerName() != null) {
            object = pSSysPrdVerBase.getPSSysPrdVerName();
            xmlNode.setAttribute(FIELD_PSSYSPRDVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSysProductId() != null) {
            object = pSSysPrdVerBase.getPSSysProductId();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSysProductName() != null) {
            object = pSSysPrdVerBase.getPSSysProductName();
            xmlNode.setAttribute(FIELD_PSSYSPRODUCTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSystemId() != null) {
            object = pSSysPrdVerBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getPSSystemName() != null) {
            object = pSSysPrdVerBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPrdVerBase.getUpdateDate() != null) {
            object = pSSysPrdVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPrdVerBase.getUpdateMan() != null) {
            object = pSSysPrdVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPrdVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPrdVerBase pSSysPrdVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPrdVerBase.isCreateDateDirty() && (bl || pSSysPrdVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPrdVerBase.getCreateDate());
        }
        if (pSSysPrdVerBase.isCreateManDirty() && (bl || pSSysPrdVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPrdVerBase.getCreateMan());
        }
        if (pSSysPrdVerBase.isMemoDirty() && (bl || pSSysPrdVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPrdVerBase.getMemo());
        }
        if (pSSysPrdVerBase.isPSSysPrdVerIdDirty() && (bl || pSSysPrdVerBase.getPSSysPrdVerId() != null)) {
            iDataObject.set(FIELD_PSSYSPRDVERID, (Object)pSSysPrdVerBase.getPSSysPrdVerId());
        }
        if (pSSysPrdVerBase.isPSSysPrdVerNameDirty() && (bl || pSSysPrdVerBase.getPSSysPrdVerName() != null)) {
            iDataObject.set(FIELD_PSSYSPRDVERNAME, (Object)pSSysPrdVerBase.getPSSysPrdVerName());
        }
        if (pSSysPrdVerBase.isPSSysProductIdDirty() && (bl || pSSysPrdVerBase.getPSSysProductId() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTID, (Object)pSSysPrdVerBase.getPSSysProductId());
        }
        if (pSSysPrdVerBase.isPSSysProductNameDirty() && (bl || pSSysPrdVerBase.getPSSysProductName() != null)) {
            iDataObject.set(FIELD_PSSYSPRODUCTNAME, (Object)pSSysPrdVerBase.getPSSysProductName());
        }
        if (pSSysPrdVerBase.isPSSystemIdDirty() && (bl || pSSysPrdVerBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysPrdVerBase.getPSSystemId());
        }
        if (pSSysPrdVerBase.isPSSystemNameDirty() && (bl || pSSysPrdVerBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysPrdVerBase.getPSSystemName());
        }
        if (pSSysPrdVerBase.isUpdateDateDirty() && (bl || pSSysPrdVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPrdVerBase.getUpdateDate());
        }
        if (pSSysPrdVerBase.isUpdateManDirty() && (bl || pSSysPrdVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPrdVerBase.getUpdateMan());
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
        return PSSysPrdVerBase.remove(this, n);
    }

    private static boolean remove(PSSysPrdVerBase pSSysPrdVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPrdVerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysPrdVerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysPrdVerBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysPrdVerBase.resetPSSysPrdVerId();
                return true;
            }
            case 4: {
                pSSysPrdVerBase.resetPSSysPrdVerName();
                return true;
            }
            case 5: {
                pSSysPrdVerBase.resetPSSysProductId();
                return true;
            }
            case 6: {
                pSSysPrdVerBase.resetPSSysProductName();
                return true;
            }
            case 7: {
                pSSysPrdVerBase.resetPSSystemId();
                return true;
            }
            case 8: {
                pSSysPrdVerBase.resetPSSystemName();
                return true;
            }
            case 9: {
                pSSysPrdVerBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSysPrdVerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysProduct getPSSysProduct() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysProduct();
        }
        if (this.getPSSysProductId() == null) {
            return null;
        }
        Integer n = this.objPSSysProductLock;
        synchronized (n) {
            if (this.pssysproduct != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysProductId(), (Object)this.pssysproduct.getPSSysProductId()) != 0L) {
                this.pssysproduct = null;
            }
            if (this.pssysproduct == null) {
                PSSysProduct pSSysProduct = new PSSysProduct();
                pSSysProduct.setPSSysProductId(this.getPSSysProductId());
                PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
                pSSysProductService.autoGet(pSSysProduct);
                this.pssysproduct = pSSysProduct;
            }
            return this.pssysproduct;
        }
    }

    private PSSysPrdVerBase getProxyEntity() {
        return this.proxyPSSysPrdVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPrdVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPrdVerBase) {
            this.proxyPSSysPrdVerBase = (PSSysPrdVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysPrdVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSPRDVERID, 3);
        fieldIndexMap.put(FIELD_PSSYSPRDVERNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTID, 5);
        fieldIndexMap.put(FIELD_PSSYSPRODUCTNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

