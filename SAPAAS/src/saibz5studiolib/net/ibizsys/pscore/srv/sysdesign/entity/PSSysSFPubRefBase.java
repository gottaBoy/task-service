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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFPubRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSSFPUBREFID = "PSSYSSFPUBREFID";
    public static final String FIELD_PSSYSSFPUBREFNAME = "PSSYSSFPUBREFNAME";
    public static final String FIELD_REFPSSYSSFPUBID = "REFPSSYSSFPUBID";
    public static final String FIELD_REFPSSYSSFPUBNAME = "REFPSSYSSFPUBNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSSYSSFPUBID = 4;
    private static final int INDEX_PSSYSSFPUBNAME = 5;
    private static final int INDEX_PSSYSSFPUBREFID = 6;
    private static final int INDEX_PSSYSSFPUBREFNAME = 7;
    private static final int INDEX_REFPSSYSSFPUBID = 8;
    private static final int INDEX_REFPSSYSSFPUBNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFPubRefBase proxyPSSysSFPubRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssyssfpubrefidDirtyFlag = false;
    private boolean pssyssfpubrefnameDirtyFlag = false;
    private boolean refpssyssfpubidDirtyFlag = false;
    private boolean refpssyssfpubnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssyssfpubrefid")
    private String pssyssfpubrefid;
    @Column(name="pssyssfpubrefname")
    private String pssyssfpubrefname;
    @Column(name="refpssyssfpubid")
    private String refpssyssfpubid;
    @Column(name="refpssyssfpubname")
    private String refpssyssfpubname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSysSFPubLock = new Integer(1);
    private PSSysSFPub pssyssfpub = null;
    private Integer objRefPSSysSFPubLock = new Integer(1);
    private PSSysSFPub refpssyssfpub = null;

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

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
    }

    public void setPSSysSFPubRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubrefid = string;
        this.pssyssfpubrefidDirtyFlag = true;
    }

    public String getPSSysSFPubRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubRefId();
        }
        return this.pssyssfpubrefid;
    }

    public boolean isPSSysSFPubRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubRefIdDirty();
        }
        return this.pssyssfpubrefidDirtyFlag;
    }

    public void resetPSSysSFPubRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubRefId();
            return;
        }
        this.pssyssfpubrefidDirtyFlag = false;
        this.pssyssfpubrefid = null;
    }

    public void setPSSysSFPubRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubrefname = string;
        this.pssyssfpubrefnameDirtyFlag = true;
    }

    public String getPSSysSFPubRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubRefName();
        }
        return this.pssyssfpubrefname;
    }

    public boolean isPSSysSFPubRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubRefNameDirty();
        }
        return this.pssyssfpubrefnameDirtyFlag;
    }

    public void resetPSSysSFPubRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubRefName();
            return;
        }
        this.pssyssfpubrefnameDirtyFlag = false;
        this.pssyssfpubrefname = null;
    }

    public void setRefPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssyssfpubid = string;
        this.refpssyssfpubidDirtyFlag = true;
    }

    public String getRefPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysSFPubId();
        }
        return this.refpssyssfpubid;
    }

    public boolean isRefPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysSFPubIdDirty();
        }
        return this.refpssyssfpubidDirtyFlag;
    }

    public void resetRefPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysSFPubId();
            return;
        }
        this.refpssyssfpubidDirtyFlag = false;
        this.refpssyssfpubid = null;
    }

    public void setRefPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssyssfpubname = string;
        this.refpssyssfpubnameDirtyFlag = true;
    }

    public String getRefPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysSFPubName();
        }
        return this.refpssyssfpubname;
    }

    public boolean isRefPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysSFPubNameDirty();
        }
        return this.refpssyssfpubnameDirtyFlag;
    }

    public void resetRefPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysSFPubName();
            return;
        }
        this.refpssyssfpubnameDirtyFlag = false;
        this.refpssyssfpubname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSSysSFPubRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFPubRefBase pSSysSFPubRefBase) {
        pSSysSFPubRefBase.resetCreateDate();
        pSSysSFPubRefBase.resetCreateMan();
        pSSysSFPubRefBase.resetMemo();
        pSSysSFPubRefBase.resetOrderValue();
        pSSysSFPubRefBase.resetPSSysSFPubId();
        pSSysSFPubRefBase.resetPSSysSFPubName();
        pSSysSFPubRefBase.resetPSSysSFPubRefId();
        pSSysSFPubRefBase.resetPSSysSFPubRefName();
        pSSysSFPubRefBase.resetRefPSSysSFPubId();
        pSSysSFPubRefBase.resetRefPSSysSFPubName();
        pSSysSFPubRefBase.resetUpdateDate();
        pSSysSFPubRefBase.resetUpdateMan();
        pSSysSFPubRefBase.resetValidFlag();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSysSFPubRefIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBREFID, this.getPSSysSFPubRefId());
        }
        if (!bl || this.isPSSysSFPubRefNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBREFNAME, this.getPSSysSFPubRefName());
        }
        if (!bl || this.isRefPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_REFPSSYSSFPUBID, this.getRefPSSysSFPubId());
        }
        if (!bl || this.isRefPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_REFPSSYSSFPUBNAME, this.getRefPSSysSFPubName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSSysSFPubRefBase.get(this, n);
    }

    private static Object get(PSSysSFPubRefBase pSSysSFPubRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubRefBase.getCreateDate();
            }
            case 1: {
                return pSSysSFPubRefBase.getCreateMan();
            }
            case 2: {
                return pSSysSFPubRefBase.getMemo();
            }
            case 3: {
                return pSSysSFPubRefBase.getOrderValue();
            }
            case 4: {
                return pSSysSFPubRefBase.getPSSysSFPubId();
            }
            case 5: {
                return pSSysSFPubRefBase.getPSSysSFPubName();
            }
            case 6: {
                return pSSysSFPubRefBase.getPSSysSFPubRefId();
            }
            case 7: {
                return pSSysSFPubRefBase.getPSSysSFPubRefName();
            }
            case 8: {
                return pSSysSFPubRefBase.getRefPSSysSFPubId();
            }
            case 9: {
                return pSSysSFPubRefBase.getRefPSSysSFPubName();
            }
            case 10: {
                return pSSysSFPubRefBase.getUpdateDate();
            }
            case 11: {
                return pSSysSFPubRefBase.getUpdateMan();
            }
            case 12: {
                return pSSysSFPubRefBase.getValidFlag();
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
        PSSysSFPubRefBase.set(this, n, object);
    }

    private static void set(PSSysSFPubRefBase pSSysSFPubRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFPubRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFPubRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFPubRefBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFPubRefBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFPubRefBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFPubRefBase.setPSSysSFPubRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFPubRefBase.setPSSysSFPubRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFPubRefBase.setRefPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFPubRefBase.setRefPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFPubRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFPubRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFPubRefBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysSFPubRefBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFPubRefBase pSSysSFPubRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysSFPubRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysSFPubRefBase.getMemo() == null;
            }
            case 3: {
                return pSSysSFPubRefBase.getOrderValue() == null;
            }
            case 4: {
                return pSSysSFPubRefBase.getPSSysSFPubId() == null;
            }
            case 5: {
                return pSSysSFPubRefBase.getPSSysSFPubName() == null;
            }
            case 6: {
                return pSSysSFPubRefBase.getPSSysSFPubRefId() == null;
            }
            case 7: {
                return pSSysSFPubRefBase.getPSSysSFPubRefName() == null;
            }
            case 8: {
                return pSSysSFPubRefBase.getRefPSSysSFPubId() == null;
            }
            case 9: {
                return pSSysSFPubRefBase.getRefPSSysSFPubName() == null;
            }
            case 10: {
                return pSSysSFPubRefBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysSFPubRefBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysSFPubRefBase.getValidFlag() == null;
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
        return PSSysSFPubRefBase.contains(this, n);
    }

    private static boolean contains(PSSysSFPubRefBase pSSysSFPubRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPubRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysSFPubRefBase.isCreateManDirty();
            }
            case 2: {
                return pSSysSFPubRefBase.isMemoDirty();
            }
            case 3: {
                return pSSysSFPubRefBase.isOrderValueDirty();
            }
            case 4: {
                return pSSysSFPubRefBase.isPSSysSFPubIdDirty();
            }
            case 5: {
                return pSSysSFPubRefBase.isPSSysSFPubNameDirty();
            }
            case 6: {
                return pSSysSFPubRefBase.isPSSysSFPubRefIdDirty();
            }
            case 7: {
                return pSSysSFPubRefBase.isPSSysSFPubRefNameDirty();
            }
            case 8: {
                return pSSysSFPubRefBase.isRefPSSysSFPubIdDirty();
            }
            case 9: {
                return pSSysSFPubRefBase.isRefPSSysSFPubNameDirty();
            }
            case 10: {
                return pSSysSFPubRefBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysSFPubRefBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysSFPubRefBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFPubRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFPubRefBase pSSysSFPubRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFPubRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubrefid", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getPSSysSFPubRefId()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubrefname", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getPSSysSFPubRefName()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getRefPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyssfpubid", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getRefPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getRefPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyssfpubname", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getRefPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSFPubRefBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSFPubRefBase.getJSONValue((Object)pSSysSFPubRefBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFPubRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFPubRefBase pSSysSFPubRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFPubRefBase.getCreateDate() != null) {
            object = pSSysSFPubRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubRefBase.getCreateMan() != null) {
            object = pSSysSFPubRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getMemo() != null) {
            object = pSSysSFPubRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getOrderValue() != null) {
            object = pSSysSFPubRefBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubId() != null) {
            object = pSSysSFPubRefBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubName() != null) {
            object = pSSysSFPubRefBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubRefId() != null) {
            object = pSSysSFPubRefBase.getPSSysSFPubRefId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBREFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getPSSysSFPubRefName() != null) {
            object = pSSysSFPubRefBase.getPSSysSFPubRefName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getRefPSSysSFPubId() != null) {
            object = pSSysSFPubRefBase.getRefPSSysSFPubId();
            xmlNode.setAttribute(FIELD_REFPSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getRefPSSysSFPubName() != null) {
            object = pSSysSFPubRefBase.getRefPSSysSFPubName();
            xmlNode.setAttribute(FIELD_REFPSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getUpdateDate() != null) {
            object = pSSysSFPubRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPubRefBase.getUpdateMan() != null) {
            object = pSSysSFPubRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPubRefBase.getValidFlag() != null) {
            object = pSSysSFPubRefBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFPubRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFPubRefBase pSSysSFPubRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFPubRefBase.isCreateDateDirty() && (bl || pSSysSFPubRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFPubRefBase.getCreateDate());
        }
        if (pSSysSFPubRefBase.isCreateManDirty() && (bl || pSSysSFPubRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFPubRefBase.getCreateMan());
        }
        if (pSSysSFPubRefBase.isMemoDirty() && (bl || pSSysSFPubRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFPubRefBase.getMemo());
        }
        if (pSSysSFPubRefBase.isOrderValueDirty() && (bl || pSSysSFPubRefBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysSFPubRefBase.getOrderValue());
        }
        if (pSSysSFPubRefBase.isPSSysSFPubIdDirty() && (bl || pSSysSFPubRefBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSSysSFPubRefBase.getPSSysSFPubId());
        }
        if (pSSysSFPubRefBase.isPSSysSFPubNameDirty() && (bl || pSSysSFPubRefBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSSysSFPubRefBase.getPSSysSFPubName());
        }
        if (pSSysSFPubRefBase.isPSSysSFPubRefIdDirty() && (bl || pSSysSFPubRefBase.getPSSysSFPubRefId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBREFID, (Object)pSSysSFPubRefBase.getPSSysSFPubRefId());
        }
        if (pSSysSFPubRefBase.isPSSysSFPubRefNameDirty() && (bl || pSSysSFPubRefBase.getPSSysSFPubRefName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBREFNAME, (Object)pSSysSFPubRefBase.getPSSysSFPubRefName());
        }
        if (pSSysSFPubRefBase.isRefPSSysSFPubIdDirty() && (bl || pSSysSFPubRefBase.getRefPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_REFPSSYSSFPUBID, (Object)pSSysSFPubRefBase.getRefPSSysSFPubId());
        }
        if (pSSysSFPubRefBase.isRefPSSysSFPubNameDirty() && (bl || pSSysSFPubRefBase.getRefPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_REFPSSYSSFPUBNAME, (Object)pSSysSFPubRefBase.getRefPSSysSFPubName());
        }
        if (pSSysSFPubRefBase.isUpdateDateDirty() && (bl || pSSysSFPubRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFPubRefBase.getUpdateDate());
        }
        if (pSSysSFPubRefBase.isUpdateManDirty() && (bl || pSSysSFPubRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFPubRefBase.getUpdateMan());
        }
        if (pSSysSFPubRefBase.isValidFlagDirty() && (bl || pSSysSFPubRefBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSFPubRefBase.getValidFlag());
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
        return PSSysSFPubRefBase.remove(this, n);
    }

    private static boolean remove(PSSysSFPubRefBase pSSysSFPubRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPubRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysSFPubRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysSFPubRefBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysSFPubRefBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSSysSFPubRefBase.resetPSSysSFPubId();
                return true;
            }
            case 5: {
                pSSysSFPubRefBase.resetPSSysSFPubName();
                return true;
            }
            case 6: {
                pSSysSFPubRefBase.resetPSSysSFPubRefId();
                return true;
            }
            case 7: {
                pSSysSFPubRefBase.resetPSSysSFPubRefName();
                return true;
            }
            case 8: {
                pSSysSFPubRefBase.resetRefPSSysSFPubId();
                return true;
            }
            case 9: {
                pSSysSFPubRefBase.resetRefPSSysSFPubName();
                return true;
            }
            case 10: {
                pSSysSFPubRefBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysSFPubRefBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysSFPubRefBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPub();
        }
        if (this.getPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPubLock;
        synchronized (n) {
            if (this.pssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPubId(), (Object)this.pssyssfpub.getPSSysSFPubId()) != 0L) {
                this.pssyssfpub = null;
            }
            if (this.pssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet((IEntity)pSSysSFPub);
                this.pssyssfpub = pSSysSFPub;
            }
            return this.pssyssfpub;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPub getRefPSSysSFPub() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysSFPub();
        }
        if (this.getRefPSSysSFPubId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysSFPubLock;
        synchronized (n) {
            if (this.refpssyssfpub != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysSFPubId(), (Object)this.refpssyssfpub.getPSSysSFPubId()) != 0L) {
                this.refpssyssfpub = null;
            }
            if (this.refpssyssfpub == null) {
                PSSysSFPub pSSysSFPub = new PSSysSFPub();
                pSSysSFPub.setPSSysSFPubId(this.getRefPSSysSFPubId());
                PSSysSFPubService pSSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPubService.autoGet((IEntity)pSSysSFPub);
                this.refpssyssfpub = pSSysSFPub;
            }
            return this.refpssyssfpub;
        }
    }

    private PSSysSFPubRefBase getProxyEntity() {
        return this.proxyPSSysSFPubRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFPubRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFPubRefBase) {
            this.proxyPSSysSFPubRefBase = (PSSysSFPubRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 4);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSSFPUBREFID, 6);
        fieldIndexMap.put(FIELD_PSSYSSFPUBREFNAME, 7);
        fieldIndexMap.put(FIELD_REFPSSYSSFPUBID, 8);
        fieldIndexMap.put(FIELD_REFPSSYSSFPUBNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

