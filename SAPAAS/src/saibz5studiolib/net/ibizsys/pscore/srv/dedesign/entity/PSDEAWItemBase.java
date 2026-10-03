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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEAWItemBase.class);
    public static final String FIELD_ACTIONVALUE = "ACTIONVALUE";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOREURL = "MOREURL";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String FIELD_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String FIELD_PSDEAWITEMID = "PSDEAWITEMID";
    public static final String FIELD_PSDEAWITEMNAME = "PSDEAWITEMNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIONVALUE = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MOREURL = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEACTIONWIZARDID = 7;
    private static final int INDEX_PSDEACTIONWIZARDNAME = 8;
    private static final int INDEX_PSDEAWITEMID = 9;
    private static final int INDEX_PSDEAWITEMNAME = 10;
    private static final int INDEX_PSDEFID = 11;
    private static final int INDEX_PSDEFNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEAWItemBase proxyPSDEAWItemBase = null;
    private boolean actionvalueDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean moreurlDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeactionwizardidDirtyFlag = false;
    private boolean psdeactionwizardnameDirtyFlag = false;
    private boolean psdeawitemidDirtyFlag = false;
    private boolean psdeawitemnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="actionvalue")
    private String actionvalue;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="moreurl")
    private String moreurl;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeactionwizardid")
    private String psdeactionwizardid;
    @Column(name="psdeactionwizardname")
    private String psdeactionwizardname;
    @Column(name="psdeawitemid")
    private String psdeawitemid;
    @Column(name="psdeawitemname")
    private String psdeawitemname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEActionWizardLock = new Integer(1);
    private PSDEActionWizard psdeactionwizard = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;

    public void setActionValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actionvalue = string;
        this.actionvalueDirtyFlag = true;
    }

    public String getActionValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionValue();
        }
        return this.actionvalue;
    }

    public boolean isActionValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionValueDirty();
        }
        return this.actionvalueDirtyFlag;
    }

    public void resetActionValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionValue();
            return;
        }
        this.actionvalueDirtyFlag = false;
        this.actionvalue = null;
    }

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setMoreUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMoreUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.moreurl = string;
        this.moreurlDirtyFlag = true;
    }

    public String getMoreUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMoreUrl();
        }
        return this.moreurl;
    }

    public boolean isMoreUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMoreUrlDirty();
        }
        return this.moreurlDirtyFlag;
    }

    public void resetMoreUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMoreUrl();
            return;
        }
        this.moreurlDirtyFlag = false;
        this.moreurl = null;
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

    public void setPSDEActionWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionwizardid = string;
        this.psdeactionwizardidDirtyFlag = true;
    }

    public String getPSDEActionWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionWizardId();
        }
        return this.psdeactionwizardid;
    }

    public boolean isPSDEActionWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionWizardIdDirty();
        }
        return this.psdeactionwizardidDirtyFlag;
    }

    public void resetPSDEActionWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionWizardId();
            return;
        }
        this.psdeactionwizardidDirtyFlag = false;
        this.psdeactionwizardid = null;
    }

    public void setPSDEActionWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionwizardname = string;
        this.psdeactionwizardnameDirtyFlag = true;
    }

    public String getPSDEActionWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionWizardName();
        }
        return this.psdeactionwizardname;
    }

    public boolean isPSDEActionWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionWizardNameDirty();
        }
        return this.psdeactionwizardnameDirtyFlag;
    }

    public void resetPSDEActionWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionWizardName();
            return;
        }
        this.psdeactionwizardnameDirtyFlag = false;
        this.psdeactionwizardname = null;
    }

    public void setPSDEAWItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawitemid = string;
        this.psdeawitemidDirtyFlag = true;
    }

    public String getPSDEAWItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWItemId();
        }
        return this.psdeawitemid;
    }

    public boolean isPSDEAWItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWItemIdDirty();
        }
        return this.psdeawitemidDirtyFlag;
    }

    public void resetPSDEAWItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWItemId();
            return;
        }
        this.psdeawitemidDirtyFlag = false;
        this.psdeawitemid = null;
    }

    public void setPSDEAWItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toLowerCase();
        }
        this.psdeawitemname = string;
        this.psdeawitemnameDirtyFlag = true;
    }

    public String getPSDEAWItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWItemName();
        }
        return this.psdeawitemname;
    }

    public boolean isPSDEAWItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWItemNameDirty();
        }
        return this.psdeawitemnameDirtyFlag;
    }

    public void resetPSDEAWItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWItemName();
            return;
        }
        this.psdeawitemnameDirtyFlag = false;
        this.psdeawitemname = null;
    }

    public void setPSDEFID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFID();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIDDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFID();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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
        PSDEAWItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEAWItemBase pSDEAWItemBase) {
        pSDEAWItemBase.resetActionValue();
        pSDEAWItemBase.resetContent();
        pSDEAWItemBase.resetCreateDate();
        pSDEAWItemBase.resetCreateMan();
        pSDEAWItemBase.resetMemo();
        pSDEAWItemBase.resetMoreUrl();
        pSDEAWItemBase.resetOrderValue();
        pSDEAWItemBase.resetPSDEActionWizardId();
        pSDEAWItemBase.resetPSDEActionWizardName();
        pSDEAWItemBase.resetPSDEAWItemId();
        pSDEAWItemBase.resetPSDEAWItemName();
        pSDEAWItemBase.resetPSDEFID();
        pSDEAWItemBase.resetPSDEFName();
        pSDEAWItemBase.resetUpdateDate();
        pSDEAWItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionValueDirty()) {
            hashMap.put(FIELD_ACTIONVALUE, this.getActionValue());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
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
        if (!bl || this.isMoreUrlDirty()) {
            hashMap.put(FIELD_MOREURL, this.getMoreUrl());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEActionWizardIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDID, this.getPSDEActionWizardId());
        }
        if (!bl || this.isPSDEActionWizardNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDNAME, this.getPSDEActionWizardName());
        }
        if (!bl || this.isPSDEAWItemIdDirty()) {
            hashMap.put(FIELD_PSDEAWITEMID, this.getPSDEAWItemId());
        }
        if (!bl || this.isPSDEAWItemNameDirty()) {
            hashMap.put(FIELD_PSDEAWITEMNAME, this.getPSDEAWItemName());
        }
        if (!bl || this.isPSDEFIDDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFID());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
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
        return PSDEAWItemBase.get(this, n);
    }

    private static Object get(PSDEAWItemBase pSDEAWItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWItemBase.getActionValue();
            }
            case 1: {
                return pSDEAWItemBase.getContent();
            }
            case 2: {
                return pSDEAWItemBase.getCreateDate();
            }
            case 3: {
                return pSDEAWItemBase.getCreateMan();
            }
            case 4: {
                return pSDEAWItemBase.getMemo();
            }
            case 5: {
                return pSDEAWItemBase.getMoreUrl();
            }
            case 6: {
                return pSDEAWItemBase.getOrderValue();
            }
            case 7: {
                return pSDEAWItemBase.getPSDEActionWizardId();
            }
            case 8: {
                return pSDEAWItemBase.getPSDEActionWizardName();
            }
            case 9: {
                return pSDEAWItemBase.getPSDEAWItemId();
            }
            case 10: {
                return pSDEAWItemBase.getPSDEAWItemName();
            }
            case 11: {
                return pSDEAWItemBase.getPSDEFID();
            }
            case 12: {
                return pSDEAWItemBase.getPSDEFName();
            }
            case 13: {
                return pSDEAWItemBase.getUpdateDate();
            }
            case 14: {
                return pSDEAWItemBase.getUpdateMan();
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
        PSDEAWItemBase.set(this, n, object);
    }

    private static void set(PSDEAWItemBase pSDEAWItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWItemBase.setActionValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEAWItemBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEAWItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEAWItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEAWItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEAWItemBase.setMoreUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEAWItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEAWItemBase.setPSDEActionWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEAWItemBase.setPSDEActionWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEAWItemBase.setPSDEAWItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEAWItemBase.setPSDEAWItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEAWItemBase.setPSDEFID(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEAWItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEAWItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEAWItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEAWItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEAWItemBase pSDEAWItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWItemBase.getActionValue() == null;
            }
            case 1: {
                return pSDEAWItemBase.getContent() == null;
            }
            case 2: {
                return pSDEAWItemBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEAWItemBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEAWItemBase.getMemo() == null;
            }
            case 5: {
                return pSDEAWItemBase.getMoreUrl() == null;
            }
            case 6: {
                return pSDEAWItemBase.getOrderValue() == null;
            }
            case 7: {
                return pSDEAWItemBase.getPSDEActionWizardId() == null;
            }
            case 8: {
                return pSDEAWItemBase.getPSDEActionWizardName() == null;
            }
            case 9: {
                return pSDEAWItemBase.getPSDEAWItemId() == null;
            }
            case 10: {
                return pSDEAWItemBase.getPSDEAWItemName() == null;
            }
            case 11: {
                return pSDEAWItemBase.getPSDEFID() == null;
            }
            case 12: {
                return pSDEAWItemBase.getPSDEFName() == null;
            }
            case 13: {
                return pSDEAWItemBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEAWItemBase.getUpdateMan() == null;
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
        return PSDEAWItemBase.contains(this, n);
    }

    private static boolean contains(PSDEAWItemBase pSDEAWItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWItemBase.isActionValueDirty();
            }
            case 1: {
                return pSDEAWItemBase.isContentDirty();
            }
            case 2: {
                return pSDEAWItemBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEAWItemBase.isCreateManDirty();
            }
            case 4: {
                return pSDEAWItemBase.isMemoDirty();
            }
            case 5: {
                return pSDEAWItemBase.isMoreUrlDirty();
            }
            case 6: {
                return pSDEAWItemBase.isOrderValueDirty();
            }
            case 7: {
                return pSDEAWItemBase.isPSDEActionWizardIdDirty();
            }
            case 8: {
                return pSDEAWItemBase.isPSDEActionWizardNameDirty();
            }
            case 9: {
                return pSDEAWItemBase.isPSDEAWItemIdDirty();
            }
            case 10: {
                return pSDEAWItemBase.isPSDEAWItemNameDirty();
            }
            case 11: {
                return pSDEAWItemBase.isPSDEFIDDirty();
            }
            case 12: {
                return pSDEAWItemBase.isPSDEFNameDirty();
            }
            case 13: {
                return pSDEAWItemBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEAWItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEAWItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEAWItemBase pSDEAWItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEAWItemBase.getActionValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionvalue", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getActionValue()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getContent()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getMoreUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"moreurl", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getMoreUrl()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEActionWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardid", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEActionWizardId()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEActionWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardname", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEActionWizardName()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEAWItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawitemid", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEAWItemId()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEAWItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawitemname", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEAWItemName()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEFID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEFID()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEAWItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEAWItemBase.getJSONValue((Object)pSDEAWItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEAWItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEAWItemBase pSDEAWItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEAWItemBase.getActionValue() != null) {
            object = pSDEAWItemBase.getActionValue();
            xmlNode.setAttribute(FIELD_ACTIONVALUE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEAWItemBase.getContent() != null) {
            object = pSDEAWItemBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getCreateDate() != null) {
            object = pSDEAWItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWItemBase.getCreateMan() != null) {
            object = pSDEAWItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getMemo() != null) {
            object = pSDEAWItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getMoreUrl() != null) {
            object = pSDEAWItemBase.getMoreUrl();
            xmlNode.setAttribute(FIELD_MOREURL, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getOrderValue() != null) {
            object = pSDEAWItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEAWItemBase.getPSDEActionWizardId() != null) {
            object = pSDEAWItemBase.getPSDEActionWizardId();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getPSDEActionWizardName() != null) {
            object = pSDEAWItemBase.getPSDEActionWizardName();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getPSDEAWItemId() != null) {
            object = pSDEAWItemBase.getPSDEAWItemId();
            xmlNode.setAttribute(FIELD_PSDEAWITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getPSDEAWItemName() != null) {
            object = pSDEAWItemBase.getPSDEAWItemName();
            xmlNode.setAttribute(FIELD_PSDEAWITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getPSDEFID() != null) {
            object = pSDEAWItemBase.getPSDEFID();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getPSDEFName() != null) {
            object = pSDEAWItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWItemBase.getUpdateDate() != null) {
            object = pSDEAWItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWItemBase.getUpdateMan() != null) {
            object = pSDEAWItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEAWItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEAWItemBase pSDEAWItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEAWItemBase.isActionValueDirty() && (bl || pSDEAWItemBase.getActionValue() != null)) {
            iDataObject.set(FIELD_ACTIONVALUE, (Object)pSDEAWItemBase.getActionValue());
        }
        if (pSDEAWItemBase.isContentDirty() && (bl || pSDEAWItemBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDEAWItemBase.getContent());
        }
        if (pSDEAWItemBase.isCreateDateDirty() && (bl || pSDEAWItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEAWItemBase.getCreateDate());
        }
        if (pSDEAWItemBase.isCreateManDirty() && (bl || pSDEAWItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEAWItemBase.getCreateMan());
        }
        if (pSDEAWItemBase.isMemoDirty() && (bl || pSDEAWItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEAWItemBase.getMemo());
        }
        if (pSDEAWItemBase.isMoreUrlDirty() && (bl || pSDEAWItemBase.getMoreUrl() != null)) {
            iDataObject.set(FIELD_MOREURL, (Object)pSDEAWItemBase.getMoreUrl());
        }
        if (pSDEAWItemBase.isOrderValueDirty() && (bl || pSDEAWItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEAWItemBase.getOrderValue());
        }
        if (pSDEAWItemBase.isPSDEActionWizardIdDirty() && (bl || pSDEAWItemBase.getPSDEActionWizardId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDID, (Object)pSDEAWItemBase.getPSDEActionWizardId());
        }
        if (pSDEAWItemBase.isPSDEActionWizardNameDirty() && (bl || pSDEAWItemBase.getPSDEActionWizardName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDNAME, (Object)pSDEAWItemBase.getPSDEActionWizardName());
        }
        if (pSDEAWItemBase.isPSDEAWItemIdDirty() && (bl || pSDEAWItemBase.getPSDEAWItemId() != null)) {
            iDataObject.set(FIELD_PSDEAWITEMID, (Object)pSDEAWItemBase.getPSDEAWItemId());
        }
        if (pSDEAWItemBase.isPSDEAWItemNameDirty() && (bl || pSDEAWItemBase.getPSDEAWItemName() != null)) {
            iDataObject.set(FIELD_PSDEAWITEMNAME, (Object)pSDEAWItemBase.getPSDEAWItemName());
        }
        if (pSDEAWItemBase.isPSDEFIDDirty() && (bl || pSDEAWItemBase.getPSDEFID() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEAWItemBase.getPSDEFID());
        }
        if (pSDEAWItemBase.isPSDEFNameDirty() && (bl || pSDEAWItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEAWItemBase.getPSDEFName());
        }
        if (pSDEAWItemBase.isUpdateDateDirty() && (bl || pSDEAWItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEAWItemBase.getUpdateDate());
        }
        if (pSDEAWItemBase.isUpdateManDirty() && (bl || pSDEAWItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEAWItemBase.getUpdateMan());
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
        return PSDEAWItemBase.remove(this, n);
    }

    private static boolean remove(PSDEAWItemBase pSDEAWItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWItemBase.resetActionValue();
                return true;
            }
            case 1: {
                pSDEAWItemBase.resetContent();
                return true;
            }
            case 2: {
                pSDEAWItemBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEAWItemBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEAWItemBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEAWItemBase.resetMoreUrl();
                return true;
            }
            case 6: {
                pSDEAWItemBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDEAWItemBase.resetPSDEActionWizardId();
                return true;
            }
            case 8: {
                pSDEAWItemBase.resetPSDEActionWizardName();
                return true;
            }
            case 9: {
                pSDEAWItemBase.resetPSDEAWItemId();
                return true;
            }
            case 10: {
                pSDEAWItemBase.resetPSDEAWItemName();
                return true;
            }
            case 11: {
                pSDEAWItemBase.resetPSDEFID();
                return true;
            }
            case 12: {
                pSDEAWItemBase.resetPSDEFName();
                return true;
            }
            case 13: {
                pSDEAWItemBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEAWItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEActionWizard getPSDEActionWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionWizard();
        }
        if (this.getPSDEActionWizardId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionWizardLock;
        synchronized (n) {
            if (this.psdeactionwizard != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionWizardId(), (Object)this.psdeactionwizard.getPSDEActionWizardId()) != 0L) {
                this.psdeactionwizard = null;
            }
            if (this.psdeactionwizard == null) {
                PSDEActionWizard pSDEActionWizard = new PSDEActionWizard();
                pSDEActionWizard.setPSDEActionWizardId(this.getPSDEActionWizardId());
                PSDEActionWizardService pSDEActionWizardService = (PSDEActionWizardService)ServiceGlobal.getService(PSDEActionWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionWizardService.autoGet(pSDEActionWizard);
                this.psdeactionwizard = pSDEActionWizard;
            }
            return this.psdeactionwizard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFID() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFID(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFID());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    private PSDEAWItemBase getProxyEntity() {
        return this.proxyPSDEAWItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEAWItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEAWItemBase) {
            this.proxyPSDEAWItemBase = (PSDEAWItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAWItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONVALUE, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MOREURL, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDID, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDNAME, 8);
        fieldIndexMap.put(FIELD_PSDEAWITEMID, 9);
        fieldIndexMap.put(FIELD_PSDEAWITEMNAME, 10);
        fieldIndexMap.put(FIELD_PSDEFID, 11);
        fieldIndexMap.put(FIELD_PSDEFNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

