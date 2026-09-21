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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstSumBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelInstSumBase.class);
    public static final String FIELD_CNT = "CNT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MODELLOGICNAME = "MODELLOGICNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSSYSMODELINSTSUMID = "PSSYSMODELINSTSUMID";
    public static final String FIELD_PSSYSMODELINSTSUMNAME = "PSSYSMODELINSTSUMNAME";
    public static final String FIELD_TMPCNT = "TMPCNT";
    public static final String FIELD_TMPUSEDSIZE = "TMPUSEDSIZE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEDSIZE = "USEDSIZE";
    private static final int INDEX_CNT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MODELLOGICNAME = 3;
    private static final int INDEX_PSSYSMODELINSTID = 4;
    private static final int INDEX_PSSYSMODELINSTNAME = 5;
    private static final int INDEX_PSSYSMODELINSTSUMID = 6;
    private static final int INDEX_PSSYSMODELINSTSUMNAME = 7;
    private static final int INDEX_TMPCNT = 8;
    private static final int INDEX_TMPUSEDSIZE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USEDSIZE = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelInstSumBase proxyPSSysModelInstSumBase = null;
    private boolean cntDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean modellogicnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean pssysmodelinstsumidDirtyFlag = false;
    private boolean pssysmodelinstsumnameDirtyFlag = false;
    private boolean tmpcntDirtyFlag = false;
    private boolean tmpusedsizeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usedsizeDirtyFlag = false;
    @Column(name="cnt")
    private Integer cnt;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="modellogicname")
    private String modellogicname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="pssysmodelinstsumid")
    private String pssysmodelinstsumid;
    @Column(name="pssysmodelinstsumname")
    private String pssysmodelinstsumname;
    @Column(name="tmpcnt")
    private Integer tmpcnt;
    @Column(name="tmpusedsize")
    private Integer tmpusedsize;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usedsize")
    private Integer usedsize;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;

    public void setCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCnt(n);
            return;
        }
        this.cnt = n;
        this.cntDirtyFlag = true;
    }

    public Integer getCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCnt();
        }
        return this.cnt;
    }

    public boolean isCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCntDirty();
        }
        return this.cntDirtyFlag;
    }

    public void resetCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCnt();
            return;
        }
        this.cntDirtyFlag = false;
        this.cnt = null;
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

    public void setModelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modellogicname = string;
        this.modellogicnameDirtyFlag = true;
    }

    public String getModelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelLogicName();
        }
        return this.modellogicname;
    }

    public boolean isModelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelLogicNameDirty();
        }
        return this.modellogicnameDirtyFlag;
    }

    public void resetModelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelLogicName();
            return;
        }
        this.modellogicnameDirtyFlag = false;
        this.modellogicname = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
    }

    public void setPSSysModelInstSumId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstSumId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstsumid = string;
        this.pssysmodelinstsumidDirtyFlag = true;
    }

    public String getPSSysModelInstSumId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstSumId();
        }
        return this.pssysmodelinstsumid;
    }

    public boolean isPSSysModelInstSumIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstSumIdDirty();
        }
        return this.pssysmodelinstsumidDirtyFlag;
    }

    public void resetPSSysModelInstSumId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstSumId();
            return;
        }
        this.pssysmodelinstsumidDirtyFlag = false;
        this.pssysmodelinstsumid = null;
    }

    public void setPSSysModelInstSumName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstSumName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstsumname = string;
        this.pssysmodelinstsumnameDirtyFlag = true;
    }

    public String getPSSysModelInstSumName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstSumName();
        }
        return this.pssysmodelinstsumname;
    }

    public boolean isPSSysModelInstSumNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstSumNameDirty();
        }
        return this.pssysmodelinstsumnameDirtyFlag;
    }

    public void resetPSSysModelInstSumName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstSumName();
            return;
        }
        this.pssysmodelinstsumnameDirtyFlag = false;
        this.pssysmodelinstsumname = null;
    }

    public void setTmpCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTmpCnt(n);
            return;
        }
        this.tmpcnt = n;
        this.tmpcntDirtyFlag = true;
    }

    public Integer getTmpCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTmpCnt();
        }
        return this.tmpcnt;
    }

    public boolean isTmpCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTmpCntDirty();
        }
        return this.tmpcntDirtyFlag;
    }

    public void resetTmpCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTmpCnt();
            return;
        }
        this.tmpcntDirtyFlag = false;
        this.tmpcnt = null;
    }

    public void setTmpUsedSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTmpUsedSize(n);
            return;
        }
        this.tmpusedsize = n;
        this.tmpusedsizeDirtyFlag = true;
    }

    public Integer getTmpUsedSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTmpUsedSize();
        }
        return this.tmpusedsize;
    }

    public boolean isTmpUsedSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTmpUsedSizeDirty();
        }
        return this.tmpusedsizeDirtyFlag;
    }

    public void resetTmpUsedSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTmpUsedSize();
            return;
        }
        this.tmpusedsizeDirtyFlag = false;
        this.tmpusedsize = null;
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

    public void setUsedSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsedSize(n);
            return;
        }
        this.usedsize = n;
        this.usedsizeDirtyFlag = true;
    }

    public Integer getUsedSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsedSize();
        }
        return this.usedsize;
    }

    public boolean isUsedSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsedSizeDirty();
        }
        return this.usedsizeDirtyFlag;
    }

    public void resetUsedSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsedSize();
            return;
        }
        this.usedsizeDirtyFlag = false;
        this.usedsize = null;
    }

    protected void onReset() {
        PSSysModelInstSumBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelInstSumBase pSSysModelInstSumBase) {
        pSSysModelInstSumBase.resetCnt();
        pSSysModelInstSumBase.resetCreateDate();
        pSSysModelInstSumBase.resetCreateMan();
        pSSysModelInstSumBase.resetModelLogicName();
        pSSysModelInstSumBase.resetPSSysModelInstId();
        pSSysModelInstSumBase.resetPSSysModelInstName();
        pSSysModelInstSumBase.resetPSSysModelInstSumId();
        pSSysModelInstSumBase.resetPSSysModelInstSumName();
        pSSysModelInstSumBase.resetTmpCnt();
        pSSysModelInstSumBase.resetTmpUsedSize();
        pSSysModelInstSumBase.resetUpdateDate();
        pSSysModelInstSumBase.resetUpdateMan();
        pSSysModelInstSumBase.resetUsedSize();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCntDirty()) {
            hashMap.put(FIELD_CNT, this.getCnt());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isModelLogicNameDirty()) {
            hashMap.put(FIELD_MODELLOGICNAME, this.getModelLogicName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
        }
        if (!bl || this.isPSSysModelInstSumIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTSUMID, this.getPSSysModelInstSumId());
        }
        if (!bl || this.isPSSysModelInstSumNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTSUMNAME, this.getPSSysModelInstSumName());
        }
        if (!bl || this.isTmpCntDirty()) {
            hashMap.put(FIELD_TMPCNT, this.getTmpCnt());
        }
        if (!bl || this.isTmpUsedSizeDirty()) {
            hashMap.put(FIELD_TMPUSEDSIZE, this.getTmpUsedSize());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsedSizeDirty()) {
            hashMap.put(FIELD_USEDSIZE, this.getUsedSize());
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
        return PSSysModelInstSumBase.get(this, n);
    }

    private static Object get(PSSysModelInstSumBase pSSysModelInstSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstSumBase.getCnt();
            }
            case 1: {
                return pSSysModelInstSumBase.getCreateDate();
            }
            case 2: {
                return pSSysModelInstSumBase.getCreateMan();
            }
            case 3: {
                return pSSysModelInstSumBase.getModelLogicName();
            }
            case 4: {
                return pSSysModelInstSumBase.getPSSysModelInstId();
            }
            case 5: {
                return pSSysModelInstSumBase.getPSSysModelInstName();
            }
            case 6: {
                return pSSysModelInstSumBase.getPSSysModelInstSumId();
            }
            case 7: {
                return pSSysModelInstSumBase.getPSSysModelInstSumName();
            }
            case 8: {
                return pSSysModelInstSumBase.getTmpCnt();
            }
            case 9: {
                return pSSysModelInstSumBase.getTmpUsedSize();
            }
            case 10: {
                return pSSysModelInstSumBase.getUpdateDate();
            }
            case 11: {
                return pSSysModelInstSumBase.getUpdateMan();
            }
            case 12: {
                return pSSysModelInstSumBase.getUsedSize();
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
        PSSysModelInstSumBase.set(this, n, object);
    }

    private static void set(PSSysModelInstSumBase pSSysModelInstSumBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstSumBase.setCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelInstSumBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelInstSumBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelInstSumBase.setModelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelInstSumBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelInstSumBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelInstSumBase.setPSSysModelInstSumId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelInstSumBase.setPSSysModelInstSumName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelInstSumBase.setTmpCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelInstSumBase.setTmpUsedSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelInstSumBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelInstSumBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelInstSumBase.setUsedSize(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelInstSumBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelInstSumBase pSSysModelInstSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstSumBase.getCnt() == null;
            }
            case 1: {
                return pSSysModelInstSumBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelInstSumBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelInstSumBase.getModelLogicName() == null;
            }
            case 4: {
                return pSSysModelInstSumBase.getPSSysModelInstId() == null;
            }
            case 5: {
                return pSSysModelInstSumBase.getPSSysModelInstName() == null;
            }
            case 6: {
                return pSSysModelInstSumBase.getPSSysModelInstSumId() == null;
            }
            case 7: {
                return pSSysModelInstSumBase.getPSSysModelInstSumName() == null;
            }
            case 8: {
                return pSSysModelInstSumBase.getTmpCnt() == null;
            }
            case 9: {
                return pSSysModelInstSumBase.getTmpUsedSize() == null;
            }
            case 10: {
                return pSSysModelInstSumBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysModelInstSumBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysModelInstSumBase.getUsedSize() == null;
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
        return PSSysModelInstSumBase.contains(this, n);
    }

    private static boolean contains(PSSysModelInstSumBase pSSysModelInstSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstSumBase.isCntDirty();
            }
            case 1: {
                return pSSysModelInstSumBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelInstSumBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelInstSumBase.isModelLogicNameDirty();
            }
            case 4: {
                return pSSysModelInstSumBase.isPSSysModelInstIdDirty();
            }
            case 5: {
                return pSSysModelInstSumBase.isPSSysModelInstNameDirty();
            }
            case 6: {
                return pSSysModelInstSumBase.isPSSysModelInstSumIdDirty();
            }
            case 7: {
                return pSSysModelInstSumBase.isPSSysModelInstSumNameDirty();
            }
            case 8: {
                return pSSysModelInstSumBase.isTmpCntDirty();
            }
            case 9: {
                return pSSysModelInstSumBase.isTmpUsedSizeDirty();
            }
            case 10: {
                return pSSysModelInstSumBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysModelInstSumBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysModelInstSumBase.isUsedSizeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelInstSumBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelInstSumBase pSSysModelInstSumBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelInstSumBase.getCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cnt", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getCnt()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getModelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modellogicname", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getModelLogicName()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstSumId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstsumid", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getPSSysModelInstSumId()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstSumName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstsumname", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getPSSysModelInstSumName()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getTmpCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tmpcnt", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getTmpCnt()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getTmpUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tmpusedsize", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getTmpUsedSize()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstSumBase.getUsedSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usedsize", (Object)PSSysModelInstSumBase.getJSONValue((Object)pSSysModelInstSumBase.getUsedSize()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelInstSumBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelInstSumBase pSSysModelInstSumBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelInstSumBase.getCnt() != null) {
            object = pSSysModelInstSumBase.getCnt();
            xmlNode.setAttribute(FIELD_CNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstSumBase.getCreateDate() != null) {
            object = pSSysModelInstSumBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstSumBase.getCreateMan() != null) {
            object = pSSysModelInstSumBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getModelLogicName() != null) {
            object = pSSysModelInstSumBase.getModelLogicName();
            xmlNode.setAttribute(FIELD_MODELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstId() != null) {
            object = pSSysModelInstSumBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstName() != null) {
            object = pSSysModelInstSumBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstSumId() != null) {
            object = pSSysModelInstSumBase.getPSSysModelInstSumId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTSUMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getPSSysModelInstSumName() != null) {
            object = pSSysModelInstSumBase.getPSSysModelInstSumName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTSUMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getTmpCnt() != null) {
            object = pSSysModelInstSumBase.getTmpCnt();
            xmlNode.setAttribute(FIELD_TMPCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstSumBase.getTmpUsedSize() != null) {
            object = pSSysModelInstSumBase.getTmpUsedSize();
            xmlNode.setAttribute(FIELD_TMPUSEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstSumBase.getUpdateDate() != null) {
            object = pSSysModelInstSumBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstSumBase.getUpdateMan() != null) {
            object = pSSysModelInstSumBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstSumBase.getUsedSize() != null) {
            object = pSSysModelInstSumBase.getUsedSize();
            xmlNode.setAttribute(FIELD_USEDSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelInstSumBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelInstSumBase pSSysModelInstSumBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelInstSumBase.isCntDirty() && (bl || pSSysModelInstSumBase.getCnt() != null)) {
            iDataObject.set(FIELD_CNT, (Object)pSSysModelInstSumBase.getCnt());
        }
        if (pSSysModelInstSumBase.isCreateDateDirty() && (bl || pSSysModelInstSumBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelInstSumBase.getCreateDate());
        }
        if (pSSysModelInstSumBase.isCreateManDirty() && (bl || pSSysModelInstSumBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelInstSumBase.getCreateMan());
        }
        if (pSSysModelInstSumBase.isModelLogicNameDirty() && (bl || pSSysModelInstSumBase.getModelLogicName() != null)) {
            iDataObject.set(FIELD_MODELLOGICNAME, (Object)pSSysModelInstSumBase.getModelLogicName());
        }
        if (pSSysModelInstSumBase.isPSSysModelInstIdDirty() && (bl || pSSysModelInstSumBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSysModelInstSumBase.getPSSysModelInstId());
        }
        if (pSSysModelInstSumBase.isPSSysModelInstNameDirty() && (bl || pSSysModelInstSumBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSysModelInstSumBase.getPSSysModelInstName());
        }
        if (pSSysModelInstSumBase.isPSSysModelInstSumIdDirty() && (bl || pSSysModelInstSumBase.getPSSysModelInstSumId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTSUMID, (Object)pSSysModelInstSumBase.getPSSysModelInstSumId());
        }
        if (pSSysModelInstSumBase.isPSSysModelInstSumNameDirty() && (bl || pSSysModelInstSumBase.getPSSysModelInstSumName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTSUMNAME, (Object)pSSysModelInstSumBase.getPSSysModelInstSumName());
        }
        if (pSSysModelInstSumBase.isTmpCntDirty() && (bl || pSSysModelInstSumBase.getTmpCnt() != null)) {
            iDataObject.set(FIELD_TMPCNT, (Object)pSSysModelInstSumBase.getTmpCnt());
        }
        if (pSSysModelInstSumBase.isTmpUsedSizeDirty() && (bl || pSSysModelInstSumBase.getTmpUsedSize() != null)) {
            iDataObject.set(FIELD_TMPUSEDSIZE, (Object)pSSysModelInstSumBase.getTmpUsedSize());
        }
        if (pSSysModelInstSumBase.isUpdateDateDirty() && (bl || pSSysModelInstSumBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelInstSumBase.getUpdateDate());
        }
        if (pSSysModelInstSumBase.isUpdateManDirty() && (bl || pSSysModelInstSumBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelInstSumBase.getUpdateMan());
        }
        if (pSSysModelInstSumBase.isUsedSizeDirty() && (bl || pSSysModelInstSumBase.getUsedSize() != null)) {
            iDataObject.set(FIELD_USEDSIZE, (Object)pSSysModelInstSumBase.getUsedSize());
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
        return PSSysModelInstSumBase.remove(this, n);
    }

    private static boolean remove(PSSysModelInstSumBase pSSysModelInstSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstSumBase.resetCnt();
                return true;
            }
            case 1: {
                pSSysModelInstSumBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelInstSumBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelInstSumBase.resetModelLogicName();
                return true;
            }
            case 4: {
                pSSysModelInstSumBase.resetPSSysModelInstId();
                return true;
            }
            case 5: {
                pSSysModelInstSumBase.resetPSSysModelInstName();
                return true;
            }
            case 6: {
                pSSysModelInstSumBase.resetPSSysModelInstSumId();
                return true;
            }
            case 7: {
                pSSysModelInstSumBase.resetPSSysModelInstSumName();
                return true;
            }
            case 8: {
                pSSysModelInstSumBase.resetTmpCnt();
                return true;
            }
            case 9: {
                pSSysModelInstSumBase.resetTmpUsedSize();
                return true;
            }
            case 10: {
                pSSysModelInstSumBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysModelInstSumBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysModelInstSumBase.resetUsedSize();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
        }
    }

    private PSSysModelInstSumBase getProxyEntity() {
        return this.proxyPSSysModelInstSumBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelInstSumBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelInstSumBase) {
            this.proxyPSSysModelInstSumBase = (PSSysModelInstSumBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstSumService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CNT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MODELLOGICNAME, 3);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 4);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTSUMID, 6);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTSUMNAME, 7);
        fieldIndexMap.put(FIELD_TMPCNT, 8);
        fieldIndexMap.put(FIELD_TMPUSEDSIZE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USEDSIZE, 12);
    }
}

