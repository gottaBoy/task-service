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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSysSync;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevPrdSysSyncItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevPrdSysSyncItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEVPRDSYSSYNCID = "PSDEVPRDSYSSYNCID";
    public static final String FIELD_PSDEVPRDSYSSYNCITEMID = "PSDEVPRDSYSSYNCITEMID";
    public static final String FIELD_PSDEVPRDSYSSYNCITEMNAME = "PSDEVPRDSYSSYNCITEMNAME";
    public static final String FIELD_PSDEVPRDSYSSYNCNAME = "PSDEVPRDSYSSYNCNAME";
    public static final String FIELD_SYNCACTION = "SYNCACTION";
    public static final String FIELD_SYNCPARAM = "SYNCPARAM";
    public static final String FIELD_SYNCPARAM2 = "SYNCPARAM2";
    public static final String FIELD_SYNCPARAM3 = "SYNCPARAM3";
    public static final String FIELD_SYNCPARAM4 = "SYNCPARAM4";
    public static final String FIELD_SYNCPARAM5 = "SYNCPARAM5";
    public static final String FIELD_SYNCPARAM6 = "SYNCPARAM6";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ORDERVALUE = 2;
    private static final int INDEX_PSDEVPRDSYSSYNCID = 3;
    private static final int INDEX_PSDEVPRDSYSSYNCITEMID = 4;
    private static final int INDEX_PSDEVPRDSYSSYNCITEMNAME = 5;
    private static final int INDEX_PSDEVPRDSYSSYNCNAME = 6;
    private static final int INDEX_SYNCACTION = 7;
    private static final int INDEX_SYNCPARAM = 8;
    private static final int INDEX_SYNCPARAM2 = 9;
    private static final int INDEX_SYNCPARAM3 = 10;
    private static final int INDEX_SYNCPARAM4 = 11;
    private static final int INDEX_SYNCPARAM5 = 12;
    private static final int INDEX_SYNCPARAM6 = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevPrdSysSyncItemBase proxyPSDevPrdSysSyncItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdevprdsyssyncidDirtyFlag = false;
    private boolean psdevprdsyssyncitemidDirtyFlag = false;
    private boolean psdevprdsyssyncitemnameDirtyFlag = false;
    private boolean psdevprdsyssyncnameDirtyFlag = false;
    private boolean syncactionDirtyFlag = false;
    private boolean syncparamDirtyFlag = false;
    private boolean syncparam2DirtyFlag = false;
    private boolean syncparam3DirtyFlag = false;
    private boolean syncparam4DirtyFlag = false;
    private boolean syncparam5DirtyFlag = false;
    private boolean syncparam6DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdevprdsyssyncid")
    private String psdevprdsyssyncid;
    @Column(name="psdevprdsyssyncitemid")
    private String psdevprdsyssyncitemid;
    @Column(name="psdevprdsyssyncitemname")
    private String psdevprdsyssyncitemname;
    @Column(name="psdevprdsyssyncname")
    private String psdevprdsyssyncname;
    @Column(name="syncaction")
    private String syncaction;
    @Column(name="syncparam")
    private String syncparam;
    @Column(name="syncparam2")
    private String syncparam2;
    @Column(name="syncparam3")
    private String syncparam3;
    @Column(name="syncparam4")
    private String syncparam4;
    @Column(name="syncparam5")
    private Integer syncparam5;
    @Column(name="syncparam6")
    private Integer syncparam6;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevPrdSysSyncLock = new Integer(1);
    private PSDevPrdSysSync psdevprdsyssync = null;

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

    public void setPSDevPrdSysSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncid = string;
        this.psdevprdsyssyncidDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncId();
        }
        return this.psdevprdsyssyncid;
    }

    public boolean isPSDevPrdSysSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncIdDirty();
        }
        return this.psdevprdsyssyncidDirtyFlag;
    }

    public void resetPSDevPrdSysSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncId();
            return;
        }
        this.psdevprdsyssyncidDirtyFlag = false;
        this.psdevprdsyssyncid = null;
    }

    public void setPSDevPrdSysSyncItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncitemid = string;
        this.psdevprdsyssyncitemidDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncItemId();
        }
        return this.psdevprdsyssyncitemid;
    }

    public boolean isPSDevPrdSysSyncItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncItemIdDirty();
        }
        return this.psdevprdsyssyncitemidDirtyFlag;
    }

    public void resetPSDevPrdSysSyncItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncItemId();
            return;
        }
        this.psdevprdsyssyncitemidDirtyFlag = false;
        this.psdevprdsyssyncitemid = null;
    }

    public void setPSDevPrdSysSyncItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncitemname = string;
        this.psdevprdsyssyncitemnameDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncItemName();
        }
        return this.psdevprdsyssyncitemname;
    }

    public boolean isPSDevPrdSysSyncItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncItemNameDirty();
        }
        return this.psdevprdsyssyncitemnameDirtyFlag;
    }

    public void resetPSDevPrdSysSyncItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncItemName();
            return;
        }
        this.psdevprdsyssyncitemnameDirtyFlag = false;
        this.psdevprdsyssyncitemname = null;
    }

    public void setPSDevPrdSysSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevPrdSysSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevprdsyssyncname = string;
        this.psdevprdsyssyncnameDirtyFlag = true;
    }

    public String getPSDevPrdSysSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSyncName();
        }
        return this.psdevprdsyssyncname;
    }

    public boolean isPSDevPrdSysSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevPrdSysSyncNameDirty();
        }
        return this.psdevprdsyssyncnameDirtyFlag;
    }

    public void resetPSDevPrdSysSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevPrdSysSyncName();
            return;
        }
        this.psdevprdsyssyncnameDirtyFlag = false;
        this.psdevprdsyssyncname = null;
    }

    public void setSyncAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncaction = string;
        this.syncactionDirtyFlag = true;
    }

    public String getSyncAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncAction();
        }
        return this.syncaction;
    }

    public boolean isSyncActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncActionDirty();
        }
        return this.syncactionDirtyFlag;
    }

    public void resetSyncAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncAction();
            return;
        }
        this.syncactionDirtyFlag = false;
        this.syncaction = null;
    }

    public void setSyncParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam = string;
        this.syncparamDirtyFlag = true;
    }

    public String getSyncParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam();
        }
        return this.syncparam;
    }

    public boolean isSyncParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParamDirty();
        }
        return this.syncparamDirtyFlag;
    }

    public void resetSyncParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam();
            return;
        }
        this.syncparamDirtyFlag = false;
        this.syncparam = null;
    }

    public void setSyncParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam2 = string;
        this.syncparam2DirtyFlag = true;
    }

    public String getSyncParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam2();
        }
        return this.syncparam2;
    }

    public boolean isSyncParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam2Dirty();
        }
        return this.syncparam2DirtyFlag;
    }

    public void resetSyncParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam2();
            return;
        }
        this.syncparam2DirtyFlag = false;
        this.syncparam2 = null;
    }

    public void setSyncParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam3 = string;
        this.syncparam3DirtyFlag = true;
    }

    public String getSyncParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam3();
        }
        return this.syncparam3;
    }

    public boolean isSyncParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam3Dirty();
        }
        return this.syncparam3DirtyFlag;
    }

    public void resetSyncParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam3();
            return;
        }
        this.syncparam3DirtyFlag = false;
        this.syncparam3 = null;
    }

    public void setSyncParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncparam4 = string;
        this.syncparam4DirtyFlag = true;
    }

    public String getSyncParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam4();
        }
        return this.syncparam4;
    }

    public boolean isSyncParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam4Dirty();
        }
        return this.syncparam4DirtyFlag;
    }

    public void resetSyncParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam4();
            return;
        }
        this.syncparam4DirtyFlag = false;
        this.syncparam4 = null;
    }

    public void setSyncParam5(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam5(n);
            return;
        }
        this.syncparam5 = n;
        this.syncparam5DirtyFlag = true;
    }

    public Integer getSyncParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam5();
        }
        return this.syncparam5;
    }

    public boolean isSyncParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam5Dirty();
        }
        return this.syncparam5DirtyFlag;
    }

    public void resetSyncParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam5();
            return;
        }
        this.syncparam5DirtyFlag = false;
        this.syncparam5 = null;
    }

    public void setSyncParam6(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncParam6(n);
            return;
        }
        this.syncparam6 = n;
        this.syncparam6DirtyFlag = true;
    }

    public Integer getSyncParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncParam6();
        }
        return this.syncparam6;
    }

    public boolean isSyncParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncParam6Dirty();
        }
        return this.syncparam6DirtyFlag;
    }

    public void resetSyncParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncParam6();
            return;
        }
        this.syncparam6DirtyFlag = false;
        this.syncparam6 = null;
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
        PSDevPrdSysSyncItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase) {
        pSDevPrdSysSyncItemBase.resetCreateDate();
        pSDevPrdSysSyncItemBase.resetCreateMan();
        pSDevPrdSysSyncItemBase.resetOrderValue();
        pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncId();
        pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncItemId();
        pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncItemName();
        pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncName();
        pSDevPrdSysSyncItemBase.resetSyncAction();
        pSDevPrdSysSyncItemBase.resetSyncParam();
        pSDevPrdSysSyncItemBase.resetSyncParam2();
        pSDevPrdSysSyncItemBase.resetSyncParam3();
        pSDevPrdSysSyncItemBase.resetSyncParam4();
        pSDevPrdSysSyncItemBase.resetSyncParam5();
        pSDevPrdSysSyncItemBase.resetSyncParam6();
        pSDevPrdSysSyncItemBase.resetUpdateDate();
        pSDevPrdSysSyncItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDevPrdSysSyncIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCID, this.getPSDevPrdSysSyncId());
        }
        if (!bl || this.isPSDevPrdSysSyncItemIdDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCITEMID, this.getPSDevPrdSysSyncItemId());
        }
        if (!bl || this.isPSDevPrdSysSyncItemNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCITEMNAME, this.getPSDevPrdSysSyncItemName());
        }
        if (!bl || this.isPSDevPrdSysSyncNameDirty()) {
            hashMap.put(FIELD_PSDEVPRDSYSSYNCNAME, this.getPSDevPrdSysSyncName());
        }
        if (!bl || this.isSyncActionDirty()) {
            hashMap.put(FIELD_SYNCACTION, this.getSyncAction());
        }
        if (!bl || this.isSyncParamDirty()) {
            hashMap.put(FIELD_SYNCPARAM, this.getSyncParam());
        }
        if (!bl || this.isSyncParam2Dirty()) {
            hashMap.put(FIELD_SYNCPARAM2, this.getSyncParam2());
        }
        if (!bl || this.isSyncParam3Dirty()) {
            hashMap.put(FIELD_SYNCPARAM3, this.getSyncParam3());
        }
        if (!bl || this.isSyncParam4Dirty()) {
            hashMap.put(FIELD_SYNCPARAM4, this.getSyncParam4());
        }
        if (!bl || this.isSyncParam5Dirty()) {
            hashMap.put(FIELD_SYNCPARAM5, this.getSyncParam5());
        }
        if (!bl || this.isSyncParam6Dirty()) {
            hashMap.put(FIELD_SYNCPARAM6, this.getSyncParam6());
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
        return PSDevPrdSysSyncItemBase.get(this, n);
    }

    private static Object get(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncItemBase.getCreateDate();
            }
            case 1: {
                return pSDevPrdSysSyncItemBase.getCreateMan();
            }
            case 2: {
                return pSDevPrdSysSyncItemBase.getOrderValue();
            }
            case 3: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId();
            }
            case 4: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId();
            }
            case 5: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName();
            }
            case 6: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName();
            }
            case 7: {
                return pSDevPrdSysSyncItemBase.getSyncAction();
            }
            case 8: {
                return pSDevPrdSysSyncItemBase.getSyncParam();
            }
            case 9: {
                return pSDevPrdSysSyncItemBase.getSyncParam2();
            }
            case 10: {
                return pSDevPrdSysSyncItemBase.getSyncParam3();
            }
            case 11: {
                return pSDevPrdSysSyncItemBase.getSyncParam4();
            }
            case 12: {
                return pSDevPrdSysSyncItemBase.getSyncParam5();
            }
            case 13: {
                return pSDevPrdSysSyncItemBase.getSyncParam6();
            }
            case 14: {
                return pSDevPrdSysSyncItemBase.getUpdateDate();
            }
            case 15: {
                return pSDevPrdSysSyncItemBase.getUpdateMan();
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
        PSDevPrdSysSyncItemBase.set(this, n, object);
    }

    private static void set(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysSyncItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevPrdSysSyncItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevPrdSysSyncItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevPrdSysSyncItemBase.setPSDevPrdSysSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevPrdSysSyncItemBase.setPSDevPrdSysSyncItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevPrdSysSyncItemBase.setPSDevPrdSysSyncItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevPrdSysSyncItemBase.setPSDevPrdSysSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevPrdSysSyncItemBase.setSyncAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevPrdSysSyncItemBase.setSyncParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevPrdSysSyncItemBase.setSyncParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevPrdSysSyncItemBase.setSyncParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevPrdSysSyncItemBase.setSyncParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevPrdSysSyncItemBase.setSyncParam5(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDevPrdSysSyncItemBase.setSyncParam6(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSDevPrdSysSyncItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDevPrdSysSyncItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevPrdSysSyncItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevPrdSysSyncItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevPrdSysSyncItemBase.getOrderValue() == null;
            }
            case 3: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId() == null;
            }
            case 4: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId() == null;
            }
            case 5: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName() == null;
            }
            case 6: {
                return pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName() == null;
            }
            case 7: {
                return pSDevPrdSysSyncItemBase.getSyncAction() == null;
            }
            case 8: {
                return pSDevPrdSysSyncItemBase.getSyncParam() == null;
            }
            case 9: {
                return pSDevPrdSysSyncItemBase.getSyncParam2() == null;
            }
            case 10: {
                return pSDevPrdSysSyncItemBase.getSyncParam3() == null;
            }
            case 11: {
                return pSDevPrdSysSyncItemBase.getSyncParam4() == null;
            }
            case 12: {
                return pSDevPrdSysSyncItemBase.getSyncParam5() == null;
            }
            case 13: {
                return pSDevPrdSysSyncItemBase.getSyncParam6() == null;
            }
            case 14: {
                return pSDevPrdSysSyncItemBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDevPrdSysSyncItemBase.getUpdateMan() == null;
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
        return PSDevPrdSysSyncItemBase.contains(this, n);
    }

    private static boolean contains(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevPrdSysSyncItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevPrdSysSyncItemBase.isCreateManDirty();
            }
            case 2: {
                return pSDevPrdSysSyncItemBase.isOrderValueDirty();
            }
            case 3: {
                return pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncIdDirty();
            }
            case 4: {
                return pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncItemIdDirty();
            }
            case 5: {
                return pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncItemNameDirty();
            }
            case 6: {
                return pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncNameDirty();
            }
            case 7: {
                return pSDevPrdSysSyncItemBase.isSyncActionDirty();
            }
            case 8: {
                return pSDevPrdSysSyncItemBase.isSyncParamDirty();
            }
            case 9: {
                return pSDevPrdSysSyncItemBase.isSyncParam2Dirty();
            }
            case 10: {
                return pSDevPrdSysSyncItemBase.isSyncParam3Dirty();
            }
            case 11: {
                return pSDevPrdSysSyncItemBase.isSyncParam4Dirty();
            }
            case 12: {
                return pSDevPrdSysSyncItemBase.isSyncParam5Dirty();
            }
            case 13: {
                return pSDevPrdSysSyncItemBase.isSyncParam6Dirty();
            }
            case 14: {
                return pSDevPrdSysSyncItemBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDevPrdSysSyncItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevPrdSysSyncItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevPrdSysSyncItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncid", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncitemid", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncitemname", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevprdsyssyncname", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncaction", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncAction()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam2", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam2()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam3", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam3()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam4", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam4()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam5", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam5()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncparam6", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getSyncParam6()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevPrdSysSyncItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevPrdSysSyncItemBase.getJSONValue((Object)pSDevPrdSysSyncItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevPrdSysSyncItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevPrdSysSyncItemBase.getCreateDate() != null) {
            object = pSDevPrdSysSyncItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysSyncItemBase.getCreateMan() != null) {
            object = pSDevPrdSysSyncItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getOrderValue() != null) {
            object = pSDevPrdSysSyncItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId() != null) {
            object = pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId() != null) {
            object = pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName() != null) {
            object = pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName() != null) {
            object = pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName();
            xmlNode.setAttribute(FIELD_PSDEVPRDSYSSYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncAction() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncAction();
            xmlNode.setAttribute(FIELD_SYNCACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam();
            xmlNode.setAttribute(FIELD_SYNCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam2() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam2();
            xmlNode.setAttribute(FIELD_SYNCPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam3() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam3();
            xmlNode.setAttribute(FIELD_SYNCPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam4() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam4();
            xmlNode.setAttribute(FIELD_SYNCPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam5() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam5();
            xmlNode.setAttribute(FIELD_SYNCPARAM5, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSysSyncItemBase.getSyncParam6() != null) {
            object = pSDevPrdSysSyncItemBase.getSyncParam6();
            xmlNode.setAttribute(FIELD_SYNCPARAM6, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevPrdSysSyncItemBase.getUpdateDate() != null) {
            object = pSDevPrdSysSyncItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevPrdSysSyncItemBase.getUpdateMan() != null) {
            object = pSDevPrdSysSyncItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevPrdSysSyncItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevPrdSysSyncItemBase.isCreateDateDirty() && (bl || pSDevPrdSysSyncItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevPrdSysSyncItemBase.getCreateDate());
        }
        if (pSDevPrdSysSyncItemBase.isCreateManDirty() && (bl || pSDevPrdSysSyncItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevPrdSysSyncItemBase.getCreateMan());
        }
        if (pSDevPrdSysSyncItemBase.isOrderValueDirty() && (bl || pSDevPrdSysSyncItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevPrdSysSyncItemBase.getOrderValue());
        }
        if (pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncIdDirty() && (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCID, (Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncId());
        }
        if (pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncItemIdDirty() && (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCITEMID, (Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemId());
        }
        if (pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncItemNameDirty() && (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCITEMNAME, (Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncItemName());
        }
        if (pSDevPrdSysSyncItemBase.isPSDevPrdSysSyncNameDirty() && (bl || pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName() != null)) {
            iDataObject.set(FIELD_PSDEVPRDSYSSYNCNAME, (Object)pSDevPrdSysSyncItemBase.getPSDevPrdSysSyncName());
        }
        if (pSDevPrdSysSyncItemBase.isSyncActionDirty() && (bl || pSDevPrdSysSyncItemBase.getSyncAction() != null)) {
            iDataObject.set(FIELD_SYNCACTION, (Object)pSDevPrdSysSyncItemBase.getSyncAction());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParamDirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam() != null)) {
            iDataObject.set(FIELD_SYNCPARAM, (Object)pSDevPrdSysSyncItemBase.getSyncParam());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParam2Dirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam2() != null)) {
            iDataObject.set(FIELD_SYNCPARAM2, (Object)pSDevPrdSysSyncItemBase.getSyncParam2());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParam3Dirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam3() != null)) {
            iDataObject.set(FIELD_SYNCPARAM3, (Object)pSDevPrdSysSyncItemBase.getSyncParam3());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParam4Dirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam4() != null)) {
            iDataObject.set(FIELD_SYNCPARAM4, (Object)pSDevPrdSysSyncItemBase.getSyncParam4());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParam5Dirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam5() != null)) {
            iDataObject.set(FIELD_SYNCPARAM5, (Object)pSDevPrdSysSyncItemBase.getSyncParam5());
        }
        if (pSDevPrdSysSyncItemBase.isSyncParam6Dirty() && (bl || pSDevPrdSysSyncItemBase.getSyncParam6() != null)) {
            iDataObject.set(FIELD_SYNCPARAM6, (Object)pSDevPrdSysSyncItemBase.getSyncParam6());
        }
        if (pSDevPrdSysSyncItemBase.isUpdateDateDirty() && (bl || pSDevPrdSysSyncItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevPrdSysSyncItemBase.getUpdateDate());
        }
        if (pSDevPrdSysSyncItemBase.isUpdateManDirty() && (bl || pSDevPrdSysSyncItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevPrdSysSyncItemBase.getUpdateMan());
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
        return PSDevPrdSysSyncItemBase.remove(this, n);
    }

    private static boolean remove(PSDevPrdSysSyncItemBase pSDevPrdSysSyncItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevPrdSysSyncItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevPrdSysSyncItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevPrdSysSyncItemBase.resetOrderValue();
                return true;
            }
            case 3: {
                pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncId();
                return true;
            }
            case 4: {
                pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncItemId();
                return true;
            }
            case 5: {
                pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncItemName();
                return true;
            }
            case 6: {
                pSDevPrdSysSyncItemBase.resetPSDevPrdSysSyncName();
                return true;
            }
            case 7: {
                pSDevPrdSysSyncItemBase.resetSyncAction();
                return true;
            }
            case 8: {
                pSDevPrdSysSyncItemBase.resetSyncParam();
                return true;
            }
            case 9: {
                pSDevPrdSysSyncItemBase.resetSyncParam2();
                return true;
            }
            case 10: {
                pSDevPrdSysSyncItemBase.resetSyncParam3();
                return true;
            }
            case 11: {
                pSDevPrdSysSyncItemBase.resetSyncParam4();
                return true;
            }
            case 12: {
                pSDevPrdSysSyncItemBase.resetSyncParam5();
                return true;
            }
            case 13: {
                pSDevPrdSysSyncItemBase.resetSyncParam6();
                return true;
            }
            case 14: {
                pSDevPrdSysSyncItemBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDevPrdSysSyncItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevPrdSysSync getPSDevPrdSysSync() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevPrdSysSync();
        }
        if (this.getPSDevPrdSysSyncId() == null) {
            return null;
        }
        Integer n = this.objPSDevPrdSysSyncLock;
        synchronized (n) {
            if (this.psdevprdsyssync != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevPrdSysSyncId(), (Object)this.psdevprdsyssync.getPSDevPrdSysSyncId()) != 0L) {
                this.psdevprdsyssync = null;
            }
            if (this.psdevprdsyssync == null) {
                PSDevPrdSysSync pSDevPrdSysSync = new PSDevPrdSysSync();
                pSDevPrdSysSync.setPSDevPrdSysSyncId(this.getPSDevPrdSysSyncId());
                PSDevPrdSysSyncService pSDevPrdSysSyncService = (PSDevPrdSysSyncService)ServiceGlobal.getService(PSDevPrdSysSyncService.class, (SessionFactory)this.getSessionFactory());
                pSDevPrdSysSyncService.autoGet((IEntity)pSDevPrdSysSync);
                this.psdevprdsyssync = pSDevPrdSysSync;
            }
            return this.psdevprdsyssync;
        }
    }

    private PSDevPrdSysSyncItemBase getProxyEntity() {
        return this.proxyPSDevPrdSysSyncItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevPrdSysSyncItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevPrdSysSyncItemBase) {
            this.proxyPSDevPrdSysSyncItemBase = (PSDevPrdSysSyncItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysSyncItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ORDERVALUE, 2);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCID, 3);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCITEMID, 4);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCITEMNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVPRDSYSSYNCNAME, 6);
        fieldIndexMap.put(FIELD_SYNCACTION, 7);
        fieldIndexMap.put(FIELD_SYNCPARAM, 8);
        fieldIndexMap.put(FIELD_SYNCPARAM2, 9);
        fieldIndexMap.put(FIELD_SYNCPARAM3, 10);
        fieldIndexMap.put(FIELD_SYNCPARAM4, 11);
        fieldIndexMap.put(FIELD_SYNCPARAM5, 12);
        fieldIndexMap.put(FIELD_SYNCPARAM6, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

