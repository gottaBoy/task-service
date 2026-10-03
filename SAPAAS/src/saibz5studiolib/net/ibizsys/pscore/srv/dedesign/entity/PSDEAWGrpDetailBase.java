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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAWGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEAWGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionWizardService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEAWGrpDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEAWGrpDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String FIELD_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String FIELD_PSDEAWGROUPID = "PSDEAWGROUPID";
    public static final String FIELD_PSDEAWGROUPNAME = "PSDEAWGROUPNAME";
    public static final String FIELD_PSDEAWGRPDETAILID = "PSDEAWGRPDETAILID";
    public static final String FIELD_PSDEAWGRPDETAILNAME = "PSDEAWGRPDETAILNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PSDEACTIONWIZARDID = 4;
    private static final int INDEX_PSDEACTIONWIZARDNAME = 5;
    private static final int INDEX_PSDEAWGROUPID = 6;
    private static final int INDEX_PSDEAWGROUPNAME = 7;
    private static final int INDEX_PSDEAWGRPDETAILID = 8;
    private static final int INDEX_PSDEAWGRPDETAILNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEAWGrpDetailBase proxyPSDEAWGrpDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeactionwizardidDirtyFlag = false;
    private boolean psdeactionwizardnameDirtyFlag = false;
    private boolean psdeawgroupidDirtyFlag = false;
    private boolean psdeawgroupnameDirtyFlag = false;
    private boolean psdeawgrpdetailidDirtyFlag = false;
    private boolean psdeawgrpdetailnameDirtyFlag = false;
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
    @Column(name="psdeactionwizardid")
    private String psdeactionwizardid;
    @Column(name="psdeactionwizardname")
    private String psdeactionwizardname;
    @Column(name="psdeawgroupid")
    private String psdeawgroupid;
    @Column(name="psdeawgroupname")
    private String psdeawgroupname;
    @Column(name="psdeawgrpdetailid")
    private String psdeawgrpdetailid;
    @Column(name="psdeawgrpdetailname")
    private String psdeawgrpdetailname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDEActionWizardLock = new Integer(1);
    private PSDEActionWizard psdeactionwizard = null;
    private Integer objPSDEAWGroupLock = new Integer(1);
    private PSDEAWGroup psdeawgroup = null;

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

    public void setPSDEAWGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupid = string;
        this.psdeawgroupidDirtyFlag = true;
    }

    public String getPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupId();
        }
        return this.psdeawgroupid;
    }

    public boolean isPSDEAWGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupIdDirty();
        }
        return this.psdeawgroupidDirtyFlag;
    }

    public void resetPSDEAWGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupId();
            return;
        }
        this.psdeawgroupidDirtyFlag = false;
        this.psdeawgroupid = null;
    }

    public void setPSDEAWGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgroupname = string;
        this.psdeawgroupnameDirtyFlag = true;
    }

    public String getPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroupName();
        }
        return this.psdeawgroupname;
    }

    public boolean isPSDEAWGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGroupNameDirty();
        }
        return this.psdeawgroupnameDirtyFlag;
    }

    public void resetPSDEAWGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGroupName();
            return;
        }
        this.psdeawgroupnameDirtyFlag = false;
        this.psdeawgroupname = null;
    }

    public void setPSDEAWGrpDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGrpDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgrpdetailid = string;
        this.psdeawgrpdetailidDirtyFlag = true;
    }

    public String getPSDEAWGrpDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGrpDetailId();
        }
        return this.psdeawgrpdetailid;
    }

    public boolean isPSDEAWGrpDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGrpDetailIdDirty();
        }
        return this.psdeawgrpdetailidDirtyFlag;
    }

    public void resetPSDEAWGrpDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGrpDetailId();
            return;
        }
        this.psdeawgrpdetailidDirtyFlag = false;
        this.psdeawgrpdetailid = null;
    }

    public void setPSDEAWGrpDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEAWGrpDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeawgrpdetailname = string;
        this.psdeawgrpdetailnameDirtyFlag = true;
    }

    public String getPSDEAWGrpDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGrpDetailName();
        }
        return this.psdeawgrpdetailname;
    }

    public boolean isPSDEAWGrpDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEAWGrpDetailNameDirty();
        }
        return this.psdeawgrpdetailnameDirtyFlag;
    }

    public void resetPSDEAWGrpDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEAWGrpDetailName();
            return;
        }
        this.psdeawgrpdetailnameDirtyFlag = false;
        this.psdeawgrpdetailname = null;
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
        PSDEAWGrpDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEAWGrpDetailBase pSDEAWGrpDetailBase) {
        pSDEAWGrpDetailBase.resetCreateDate();
        pSDEAWGrpDetailBase.resetCreateMan();
        pSDEAWGrpDetailBase.resetMemo();
        pSDEAWGrpDetailBase.resetOrderValue();
        pSDEAWGrpDetailBase.resetPSDEActionWizardId();
        pSDEAWGrpDetailBase.resetPSDEActionWizardName();
        pSDEAWGrpDetailBase.resetPSDEAWGroupId();
        pSDEAWGrpDetailBase.resetPSDEAWGroupName();
        pSDEAWGrpDetailBase.resetPSDEAWGrpDetailId();
        pSDEAWGrpDetailBase.resetPSDEAWGrpDetailName();
        pSDEAWGrpDetailBase.resetUpdateDate();
        pSDEAWGrpDetailBase.resetUpdateMan();
        pSDEAWGrpDetailBase.resetValidFlag();
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
        if (!bl || this.isPSDEActionWizardIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDID, this.getPSDEActionWizardId());
        }
        if (!bl || this.isPSDEActionWizardNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONWIZARDNAME, this.getPSDEActionWizardName());
        }
        if (!bl || this.isPSDEAWGroupIdDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPID, this.getPSDEAWGroupId());
        }
        if (!bl || this.isPSDEAWGroupNameDirty()) {
            hashMap.put(FIELD_PSDEAWGROUPNAME, this.getPSDEAWGroupName());
        }
        if (!bl || this.isPSDEAWGrpDetailIdDirty()) {
            hashMap.put(FIELD_PSDEAWGRPDETAILID, this.getPSDEAWGrpDetailId());
        }
        if (!bl || this.isPSDEAWGrpDetailNameDirty()) {
            hashMap.put(FIELD_PSDEAWGRPDETAILNAME, this.getPSDEAWGrpDetailName());
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
        return PSDEAWGrpDetailBase.get(this, n);
    }

    private static Object get(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGrpDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEAWGrpDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEAWGrpDetailBase.getMemo();
            }
            case 3: {
                return pSDEAWGrpDetailBase.getOrderValue();
            }
            case 4: {
                return pSDEAWGrpDetailBase.getPSDEActionWizardId();
            }
            case 5: {
                return pSDEAWGrpDetailBase.getPSDEActionWizardName();
            }
            case 6: {
                return pSDEAWGrpDetailBase.getPSDEAWGroupId();
            }
            case 7: {
                return pSDEAWGrpDetailBase.getPSDEAWGroupName();
            }
            case 8: {
                return pSDEAWGrpDetailBase.getPSDEAWGrpDetailId();
            }
            case 9: {
                return pSDEAWGrpDetailBase.getPSDEAWGrpDetailName();
            }
            case 10: {
                return pSDEAWGrpDetailBase.getUpdateDate();
            }
            case 11: {
                return pSDEAWGrpDetailBase.getUpdateMan();
            }
            case 12: {
                return pSDEAWGrpDetailBase.getValidFlag();
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
        PSDEAWGrpDetailBase.set(this, n, object);
    }

    private static void set(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWGrpDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEAWGrpDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEAWGrpDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEAWGrpDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEAWGrpDetailBase.setPSDEActionWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEAWGrpDetailBase.setPSDEActionWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEAWGrpDetailBase.setPSDEAWGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEAWGrpDetailBase.setPSDEAWGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEAWGrpDetailBase.setPSDEAWGrpDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEAWGrpDetailBase.setPSDEAWGrpDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEAWGrpDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEAWGrpDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEAWGrpDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEAWGrpDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGrpDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEAWGrpDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEAWGrpDetailBase.getMemo() == null;
            }
            case 3: {
                return pSDEAWGrpDetailBase.getOrderValue() == null;
            }
            case 4: {
                return pSDEAWGrpDetailBase.getPSDEActionWizardId() == null;
            }
            case 5: {
                return pSDEAWGrpDetailBase.getPSDEActionWizardName() == null;
            }
            case 6: {
                return pSDEAWGrpDetailBase.getPSDEAWGroupId() == null;
            }
            case 7: {
                return pSDEAWGrpDetailBase.getPSDEAWGroupName() == null;
            }
            case 8: {
                return pSDEAWGrpDetailBase.getPSDEAWGrpDetailId() == null;
            }
            case 9: {
                return pSDEAWGrpDetailBase.getPSDEAWGrpDetailName() == null;
            }
            case 10: {
                return pSDEAWGrpDetailBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEAWGrpDetailBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDEAWGrpDetailBase.getValidFlag() == null;
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
        return PSDEAWGrpDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEAWGrpDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEAWGrpDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEAWGrpDetailBase.isMemoDirty();
            }
            case 3: {
                return pSDEAWGrpDetailBase.isOrderValueDirty();
            }
            case 4: {
                return pSDEAWGrpDetailBase.isPSDEActionWizardIdDirty();
            }
            case 5: {
                return pSDEAWGrpDetailBase.isPSDEActionWizardNameDirty();
            }
            case 6: {
                return pSDEAWGrpDetailBase.isPSDEAWGroupIdDirty();
            }
            case 7: {
                return pSDEAWGrpDetailBase.isPSDEAWGroupNameDirty();
            }
            case 8: {
                return pSDEAWGrpDetailBase.isPSDEAWGrpDetailIdDirty();
            }
            case 9: {
                return pSDEAWGrpDetailBase.isPSDEAWGrpDetailNameDirty();
            }
            case 10: {
                return pSDEAWGrpDetailBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEAWGrpDetailBase.isUpdateManDirty();
            }
            case 12: {
                return pSDEAWGrpDetailBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEAWGrpDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEAWGrpDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEActionWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardid", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEActionWizardId()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEActionWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionwizardname", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEActionWizardName()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupid", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEAWGroupId()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgroupname", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEAWGroupName()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgrpdetailid", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEAWGrpDetailId()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeawgrpdetailname", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getPSDEAWGrpDetailName()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEAWGrpDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEAWGrpDetailBase.getJSONValue((Object)pSDEAWGrpDetailBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEAWGrpDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEAWGrpDetailBase.getCreateDate() != null) {
            object = pSDEAWGrpDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWGrpDetailBase.getCreateMan() != null) {
            object = pSDEAWGrpDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getMemo() != null) {
            object = pSDEAWGrpDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getOrderValue() != null) {
            object = pSDEAWGrpDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEActionWizardId() != null) {
            object = pSDEAWGrpDetailBase.getPSDEActionWizardId();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEActionWizardName() != null) {
            object = pSDEAWGrpDetailBase.getPSDEActionWizardName();
            xmlNode.setAttribute(FIELD_PSDEACTIONWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGroupId() != null) {
            object = pSDEAWGrpDetailBase.getPSDEAWGroupId();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGroupName() != null) {
            object = pSDEAWGrpDetailBase.getPSDEAWGroupName();
            xmlNode.setAttribute(FIELD_PSDEAWGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailId() != null) {
            object = pSDEAWGrpDetailBase.getPSDEAWGrpDetailId();
            xmlNode.setAttribute(FIELD_PSDEAWGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailName() != null) {
            object = pSDEAWGrpDetailBase.getPSDEAWGrpDetailName();
            xmlNode.setAttribute(FIELD_PSDEAWGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getUpdateDate() != null) {
            object = pSDEAWGrpDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEAWGrpDetailBase.getUpdateMan() != null) {
            object = pSDEAWGrpDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEAWGrpDetailBase.getValidFlag() != null) {
            object = pSDEAWGrpDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEAWGrpDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEAWGrpDetailBase.isCreateDateDirty() && (bl || pSDEAWGrpDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEAWGrpDetailBase.getCreateDate());
        }
        if (pSDEAWGrpDetailBase.isCreateManDirty() && (bl || pSDEAWGrpDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEAWGrpDetailBase.getCreateMan());
        }
        if (pSDEAWGrpDetailBase.isMemoDirty() && (bl || pSDEAWGrpDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEAWGrpDetailBase.getMemo());
        }
        if (pSDEAWGrpDetailBase.isOrderValueDirty() && (bl || pSDEAWGrpDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEAWGrpDetailBase.getOrderValue());
        }
        if (pSDEAWGrpDetailBase.isPSDEActionWizardIdDirty() && (bl || pSDEAWGrpDetailBase.getPSDEActionWizardId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDID, (Object)pSDEAWGrpDetailBase.getPSDEActionWizardId());
        }
        if (pSDEAWGrpDetailBase.isPSDEActionWizardNameDirty() && (bl || pSDEAWGrpDetailBase.getPSDEActionWizardName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONWIZARDNAME, (Object)pSDEAWGrpDetailBase.getPSDEActionWizardName());
        }
        if (pSDEAWGrpDetailBase.isPSDEAWGroupIdDirty() && (bl || pSDEAWGrpDetailBase.getPSDEAWGroupId() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPID, (Object)pSDEAWGrpDetailBase.getPSDEAWGroupId());
        }
        if (pSDEAWGrpDetailBase.isPSDEAWGroupNameDirty() && (bl || pSDEAWGrpDetailBase.getPSDEAWGroupName() != null)) {
            iDataObject.set(FIELD_PSDEAWGROUPNAME, (Object)pSDEAWGrpDetailBase.getPSDEAWGroupName());
        }
        if (pSDEAWGrpDetailBase.isPSDEAWGrpDetailIdDirty() && (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailId() != null)) {
            iDataObject.set(FIELD_PSDEAWGRPDETAILID, (Object)pSDEAWGrpDetailBase.getPSDEAWGrpDetailId());
        }
        if (pSDEAWGrpDetailBase.isPSDEAWGrpDetailNameDirty() && (bl || pSDEAWGrpDetailBase.getPSDEAWGrpDetailName() != null)) {
            iDataObject.set(FIELD_PSDEAWGRPDETAILNAME, (Object)pSDEAWGrpDetailBase.getPSDEAWGrpDetailName());
        }
        if (pSDEAWGrpDetailBase.isUpdateDateDirty() && (bl || pSDEAWGrpDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEAWGrpDetailBase.getUpdateDate());
        }
        if (pSDEAWGrpDetailBase.isUpdateManDirty() && (bl || pSDEAWGrpDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEAWGrpDetailBase.getUpdateMan());
        }
        if (pSDEAWGrpDetailBase.isValidFlagDirty() && (bl || pSDEAWGrpDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEAWGrpDetailBase.getValidFlag());
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
        return PSDEAWGrpDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEAWGrpDetailBase pSDEAWGrpDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEAWGrpDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEAWGrpDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEAWGrpDetailBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEAWGrpDetailBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSDEAWGrpDetailBase.resetPSDEActionWizardId();
                return true;
            }
            case 5: {
                pSDEAWGrpDetailBase.resetPSDEActionWizardName();
                return true;
            }
            case 6: {
                pSDEAWGrpDetailBase.resetPSDEAWGroupId();
                return true;
            }
            case 7: {
                pSDEAWGrpDetailBase.resetPSDEAWGroupName();
                return true;
            }
            case 8: {
                pSDEAWGrpDetailBase.resetPSDEAWGrpDetailId();
                return true;
            }
            case 9: {
                pSDEAWGrpDetailBase.resetPSDEAWGrpDetailName();
                return true;
            }
            case 10: {
                pSDEAWGrpDetailBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEAWGrpDetailBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDEAWGrpDetailBase.resetValidFlag();
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
    public PSDEAWGroup getPSDEAWGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAWGroup();
        }
        if (this.getPSDEAWGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEAWGroupLock;
        synchronized (n) {
            if (this.psdeawgroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEAWGroupId(), (Object)this.psdeawgroup.getPSDEAWGroupId()) != 0L) {
                this.psdeawgroup = null;
            }
            if (this.psdeawgroup == null) {
                PSDEAWGroup pSDEAWGroup = new PSDEAWGroup();
                pSDEAWGroup.setPSDEAWGroupId(this.getPSDEAWGroupId());
                PSDEAWGroupService pSDEAWGroupService = (PSDEAWGroupService)ServiceGlobal.getService(PSDEAWGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEAWGroupService.autoGet(pSDEAWGroup);
                this.psdeawgroup = pSDEAWGroup;
            }
            return this.psdeawgroup;
        }
    }

    private PSDEAWGrpDetailBase getProxyEntity() {
        return this.proxyPSDEAWGrpDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEAWGrpDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEAWGrpDetailBase) {
            this.proxyPSDEAWGrpDetailBase = (PSDEAWGrpDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEAWGrpDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDID, 4);
        fieldIndexMap.put(FIELD_PSDEACTIONWIZARDNAME, 5);
        fieldIndexMap.put(FIELD_PSDEAWGROUPID, 6);
        fieldIndexMap.put(FIELD_PSDEAWGROUPNAME, 7);
        fieldIndexMap.put(FIELD_PSDEAWGRPDETAILID, 8);
        fieldIndexMap.put(FIELD_PSDEAWGRPDETAILNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

