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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFConfigBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFConfigBase.class);
    public static final String FIELD_CONFIGCAT = "CONFIGCAT";
    public static final String FIELD_CONFIGDESC = "CONFIGDESC";
    public static final String FIELD_CONFIGVALUE = "CONFIGVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSFCONFIGID = "PSSFCONFIGID";
    public static final String FIELD_PSSFCONFIGNAME = "PSSFCONFIGNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONFIGCAT = 0;
    private static final int INDEX_CONFIGDESC = 1;
    private static final int INDEX_CONFIGVALUE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSSFCONFIGID = 7;
    private static final int INDEX_PSSFCONFIGNAME = 8;
    private static final int INDEX_PSSFID = 9;
    private static final int INDEX_PSSFNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFConfigBase proxyPSSFConfigBase = null;
    private boolean configcatDirtyFlag = false;
    private boolean configdescDirtyFlag = false;
    private boolean configvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssfconfigidDirtyFlag = false;
    private boolean pssfconfignameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="configcat")
    private String configcat;
    @Column(name="configdesc")
    private String configdesc;
    @Column(name="configvalue")
    private String configvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssfconfigid")
    private String pssfconfigid;
    @Column(name="pssfconfigname")
    private String pssfconfigname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

    public void setConfigCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfigCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.configcat = string;
        this.configcatDirtyFlag = true;
    }

    public String getConfigCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfigCat();
        }
        return this.configcat;
    }

    public boolean isConfigCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfigCatDirty();
        }
        return this.configcatDirtyFlag;
    }

    public void resetConfigCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfigCat();
            return;
        }
        this.configcatDirtyFlag = false;
        this.configcat = null;
    }

    public void setConfigDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfigDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.configdesc = string;
        this.configdescDirtyFlag = true;
    }

    public String getConfigDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfigDesc();
        }
        return this.configdesc;
    }

    public boolean isConfigDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfigDescDirty();
        }
        return this.configdescDirtyFlag;
    }

    public void resetConfigDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfigDesc();
            return;
        }
        this.configdescDirtyFlag = false;
        this.configdesc = null;
    }

    public void setConfigValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConfigValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.configvalue = string;
        this.configvalueDirtyFlag = true;
    }

    public String getConfigValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConfigValue();
        }
        return this.configvalue;
    }

    public boolean isConfigValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConfigValueDirty();
        }
        return this.configvalueDirtyFlag;
    }

    public void resetConfigValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConfigValue();
            return;
        }
        this.configvalueDirtyFlag = false;
        this.configvalue = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSSFConfigId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFConfigId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfconfigid = string;
        this.pssfconfigidDirtyFlag = true;
    }

    public String getPSSFConfigId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFConfigId();
        }
        return this.pssfconfigid;
    }

    public boolean isPSSFConfigIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFConfigIdDirty();
        }
        return this.pssfconfigidDirtyFlag;
    }

    public void resetPSSFConfigId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFConfigId();
            return;
        }
        this.pssfconfigidDirtyFlag = false;
        this.pssfconfigid = null;
    }

    public void setPSSFConfigName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFConfigName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfconfigname = string;
        this.pssfconfignameDirtyFlag = true;
    }

    public String getPSSFConfigName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFConfigName();
        }
        return this.pssfconfigname;
    }

    public boolean isPSSFConfigNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFConfigNameDirty();
        }
        return this.pssfconfignameDirtyFlag;
    }

    public void resetPSSFConfigName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFConfigName();
            return;
        }
        this.pssfconfignameDirtyFlag = false;
        this.pssfconfigname = null;
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
        PSSFConfigBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFConfigBase pSSFConfigBase) {
        pSSFConfigBase.resetConfigCat();
        pSSFConfigBase.resetConfigDesc();
        pSSFConfigBase.resetConfigValue();
        pSSFConfigBase.resetCreateDate();
        pSSFConfigBase.resetCreateMan();
        pSSFConfigBase.resetMemo();
        pSSFConfigBase.resetOrderValue();
        pSSFConfigBase.resetPSSFConfigId();
        pSSFConfigBase.resetPSSFConfigName();
        pSSFConfigBase.resetPSSFId();
        pSSFConfigBase.resetPSSFName();
        pSSFConfigBase.resetUpdateDate();
        pSSFConfigBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConfigCatDirty()) {
            hashMap.put(FIELD_CONFIGCAT, this.getConfigCat());
        }
        if (!bl || this.isConfigDescDirty()) {
            hashMap.put(FIELD_CONFIGDESC, this.getConfigDesc());
        }
        if (!bl || this.isConfigValueDirty()) {
            hashMap.put(FIELD_CONFIGVALUE, this.getConfigValue());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSFConfigIdDirty()) {
            hashMap.put(FIELD_PSSFCONFIGID, this.getPSSFConfigId());
        }
        if (!bl || this.isPSSFConfigNameDirty()) {
            hashMap.put(FIELD_PSSFCONFIGNAME, this.getPSSFConfigName());
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
        return PSSFConfigBase.get(this, n);
    }

    private static Object get(PSSFConfigBase pSSFConfigBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFConfigBase.getConfigCat();
            }
            case 1: {
                return pSSFConfigBase.getConfigDesc();
            }
            case 2: {
                return pSSFConfigBase.getConfigValue();
            }
            case 3: {
                return pSSFConfigBase.getCreateDate();
            }
            case 4: {
                return pSSFConfigBase.getCreateMan();
            }
            case 5: {
                return pSSFConfigBase.getMemo();
            }
            case 6: {
                return pSSFConfigBase.getOrderValue();
            }
            case 7: {
                return pSSFConfigBase.getPSSFConfigId();
            }
            case 8: {
                return pSSFConfigBase.getPSSFConfigName();
            }
            case 9: {
                return pSSFConfigBase.getPSSFId();
            }
            case 10: {
                return pSSFConfigBase.getPSSFName();
            }
            case 11: {
                return pSSFConfigBase.getUpdateDate();
            }
            case 12: {
                return pSSFConfigBase.getUpdateMan();
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
        PSSFConfigBase.set(this, n, object);
    }

    private static void set(PSSFConfigBase pSSFConfigBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFConfigBase.setConfigCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFConfigBase.setConfigDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFConfigBase.setConfigValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFConfigBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSFConfigBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFConfigBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFConfigBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSFConfigBase.setPSSFConfigId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFConfigBase.setPSSFConfigName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFConfigBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFConfigBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFConfigBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSFConfigBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFConfigBase.isNull(this, n);
    }

    private static boolean isNull(PSSFConfigBase pSSFConfigBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFConfigBase.getConfigCat() == null;
            }
            case 1: {
                return pSSFConfigBase.getConfigDesc() == null;
            }
            case 2: {
                return pSSFConfigBase.getConfigValue() == null;
            }
            case 3: {
                return pSSFConfigBase.getCreateDate() == null;
            }
            case 4: {
                return pSSFConfigBase.getCreateMan() == null;
            }
            case 5: {
                return pSSFConfigBase.getMemo() == null;
            }
            case 6: {
                return pSSFConfigBase.getOrderValue() == null;
            }
            case 7: {
                return pSSFConfigBase.getPSSFConfigId() == null;
            }
            case 8: {
                return pSSFConfigBase.getPSSFConfigName() == null;
            }
            case 9: {
                return pSSFConfigBase.getPSSFId() == null;
            }
            case 10: {
                return pSSFConfigBase.getPSSFName() == null;
            }
            case 11: {
                return pSSFConfigBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSFConfigBase.getUpdateMan() == null;
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
        return PSSFConfigBase.contains(this, n);
    }

    private static boolean contains(PSSFConfigBase pSSFConfigBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFConfigBase.isConfigCatDirty();
            }
            case 1: {
                return pSSFConfigBase.isConfigDescDirty();
            }
            case 2: {
                return pSSFConfigBase.isConfigValueDirty();
            }
            case 3: {
                return pSSFConfigBase.isCreateDateDirty();
            }
            case 4: {
                return pSSFConfigBase.isCreateManDirty();
            }
            case 5: {
                return pSSFConfigBase.isMemoDirty();
            }
            case 6: {
                return pSSFConfigBase.isOrderValueDirty();
            }
            case 7: {
                return pSSFConfigBase.isPSSFConfigIdDirty();
            }
            case 8: {
                return pSSFConfigBase.isPSSFConfigNameDirty();
            }
            case 9: {
                return pSSFConfigBase.isPSSFIdDirty();
            }
            case 10: {
                return pSSFConfigBase.isPSSFNameDirty();
            }
            case 11: {
                return pSSFConfigBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSFConfigBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFConfigBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFConfigBase pSSFConfigBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFConfigBase.getConfigCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"configcat", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getConfigCat()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getConfigDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"configdesc", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getConfigDesc()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getConfigValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"configvalue", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getConfigValue()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getPSSFConfigId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfconfigid", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getPSSFConfigId()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getPSSFConfigName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfconfigname", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getPSSFConfigName()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFConfigBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFConfigBase.getJSONValue((Object)pSSFConfigBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFConfigBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFConfigBase pSSFConfigBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFConfigBase.getConfigCat() != null) {
            object = pSSFConfigBase.getConfigCat();
            xmlNode.setAttribute(FIELD_CONFIGCAT, (String)(object == null ? "" : object));
        }
        if (bl || pSSFConfigBase.getConfigDesc() != null) {
            object = pSSFConfigBase.getConfigDesc();
            xmlNode.setAttribute(FIELD_CONFIGDESC, (String)(object == null ? "" : object));
        }
        if (bl || pSSFConfigBase.getConfigValue() != null) {
            object = pSSFConfigBase.getConfigValue();
            xmlNode.setAttribute(FIELD_CONFIGVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getCreateDate() != null) {
            object = pSSFConfigBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFConfigBase.getCreateMan() != null) {
            object = pSSFConfigBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getMemo() != null) {
            object = pSSFConfigBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getOrderValue() != null) {
            object = pSSFConfigBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSFConfigBase.getPSSFConfigId() != null) {
            object = pSSFConfigBase.getPSSFConfigId();
            xmlNode.setAttribute(FIELD_PSSFCONFIGID, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getPSSFConfigName() != null) {
            object = pSSFConfigBase.getPSSFConfigName();
            xmlNode.setAttribute(FIELD_PSSFCONFIGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getPSSFId() != null) {
            object = pSSFConfigBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getPSSFName() != null) {
            object = pSSFConfigBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFConfigBase.getUpdateDate() != null) {
            object = pSSFConfigBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFConfigBase.getUpdateMan() != null) {
            object = pSSFConfigBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFConfigBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFConfigBase pSSFConfigBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFConfigBase.isConfigCatDirty() && (bl || pSSFConfigBase.getConfigCat() != null)) {
            iDataObject.set(FIELD_CONFIGCAT, (Object)pSSFConfigBase.getConfigCat());
        }
        if (pSSFConfigBase.isConfigDescDirty() && (bl || pSSFConfigBase.getConfigDesc() != null)) {
            iDataObject.set(FIELD_CONFIGDESC, (Object)pSSFConfigBase.getConfigDesc());
        }
        if (pSSFConfigBase.isConfigValueDirty() && (bl || pSSFConfigBase.getConfigValue() != null)) {
            iDataObject.set(FIELD_CONFIGVALUE, (Object)pSSFConfigBase.getConfigValue());
        }
        if (pSSFConfigBase.isCreateDateDirty() && (bl || pSSFConfigBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFConfigBase.getCreateDate());
        }
        if (pSSFConfigBase.isCreateManDirty() && (bl || pSSFConfigBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFConfigBase.getCreateMan());
        }
        if (pSSFConfigBase.isMemoDirty() && (bl || pSSFConfigBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFConfigBase.getMemo());
        }
        if (pSSFConfigBase.isOrderValueDirty() && (bl || pSSFConfigBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSFConfigBase.getOrderValue());
        }
        if (pSSFConfigBase.isPSSFConfigIdDirty() && (bl || pSSFConfigBase.getPSSFConfigId() != null)) {
            iDataObject.set(FIELD_PSSFCONFIGID, (Object)pSSFConfigBase.getPSSFConfigId());
        }
        if (pSSFConfigBase.isPSSFConfigNameDirty() && (bl || pSSFConfigBase.getPSSFConfigName() != null)) {
            iDataObject.set(FIELD_PSSFCONFIGNAME, (Object)pSSFConfigBase.getPSSFConfigName());
        }
        if (pSSFConfigBase.isPSSFIdDirty() && (bl || pSSFConfigBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFConfigBase.getPSSFId());
        }
        if (pSSFConfigBase.isPSSFNameDirty() && (bl || pSSFConfigBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFConfigBase.getPSSFName());
        }
        if (pSSFConfigBase.isUpdateDateDirty() && (bl || pSSFConfigBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFConfigBase.getUpdateDate());
        }
        if (pSSFConfigBase.isUpdateManDirty() && (bl || pSSFConfigBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFConfigBase.getUpdateMan());
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
        return PSSFConfigBase.remove(this, n);
    }

    private static boolean remove(PSSFConfigBase pSSFConfigBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFConfigBase.resetConfigCat();
                return true;
            }
            case 1: {
                pSSFConfigBase.resetConfigDesc();
                return true;
            }
            case 2: {
                pSSFConfigBase.resetConfigValue();
                return true;
            }
            case 3: {
                pSSFConfigBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSFConfigBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSFConfigBase.resetMemo();
                return true;
            }
            case 6: {
                pSSFConfigBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSSFConfigBase.resetPSSFConfigId();
                return true;
            }
            case 8: {
                pSSFConfigBase.resetPSSFConfigName();
                return true;
            }
            case 9: {
                pSSFConfigBase.resetPSSFId();
                return true;
            }
            case 10: {
                pSSFConfigBase.resetPSSFName();
                return true;
            }
            case 11: {
                pSSFConfigBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSFConfigBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFConfigBase getProxyEntity() {
        return this.proxyPSSFConfigBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFConfigBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFConfigBase) {
            this.proxyPSSFConfigBase = (PSSFConfigBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFConfigService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONFIGCAT, 0);
        fieldIndexMap.put(FIELD_CONFIGDESC, 1);
        fieldIndexMap.put(FIELD_CONFIGVALUE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSSFCONFIGID, 7);
        fieldIndexMap.put(FIELD_PSSFCONFIGNAME, 8);
        fieldIndexMap.put(FIELD_PSSFID, 9);
        fieldIndexMap.put(FIELD_PSSFNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

