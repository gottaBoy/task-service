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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewCtrlDSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewCtrlDSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORSORTDIR = "MINORSORTDIR";
    public static final String FIELD_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String FIELD_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEVIEWCTRLDSID = "PSDEVIEWCTRLDSID";
    public static final String FIELD_PSDEVIEWCTRLDSNAME = "PSDEVIEWCTRLDSNAME";
    public static final String FIELD_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String FIELD_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_MINORSORTDIR = 3;
    private static final int INDEX_MINORSORTPSDEFID = 4;
    private static final int INDEX_MINORSORTPSDEFNAME = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEDATASETID = 7;
    private static final int INDEX_PSDEDATASETNAME = 8;
    private static final int INDEX_PSDEVIEWCTRLDSID = 9;
    private static final int INDEX_PSDEVIEWCTRLDSNAME = 10;
    private static final int INDEX_PSDEVIEWCTRLID = 11;
    private static final int INDEX_PSDEVIEWCTRLNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewCtrlDSBase proxyPSDEViewCtrlDSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorsortdirDirtyFlag = false;
    private boolean minorsortpsdefidDirtyFlag = false;
    private boolean minorsortpsdefnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeviewctrldsidDirtyFlag = false;
    private boolean psdeviewctrldsnameDirtyFlag = false;
    private boolean psdeviewctrlidDirtyFlag = false;
    private boolean psdeviewctrlnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="minorsortdir")
    private String minorsortdir;
    @Column(name="minorsortpsdefid")
    private String minorsortpsdefid;
    @Column(name="minorsortpsdefname")
    private String minorsortpsdefname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeviewctrldsid")
    private String psdeviewctrldsid;
    @Column(name="psdeviewctrldsname")
    private String psdeviewctrldsname;
    @Column(name="psdeviewctrlid")
    private String psdeviewctrlid;
    @Column(name="psdeviewctrlname")
    private String psdeviewctrlname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsdedatasetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objMinorsortpsdefLock = new Integer(1);
    private PSDEField minorsortpsdef = null;
    private Integer objPsdeviewctrlLock = new Integer(1);
    private PSDEViewCtrl psdeviewctrl = null;

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

    public void setMinorSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortdir = string;
        this.minorsortdirDirtyFlag = true;
    }

    public String getMinorSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortDir();
        }
        return this.minorsortdir;
    }

    public boolean isMinorSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortDirDirty();
        }
        return this.minorsortdirDirtyFlag;
    }

    public void resetMinorSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortDir();
            return;
        }
        this.minorsortdirDirtyFlag = false;
        this.minorsortdir = null;
    }

    public void setMinorSortPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefid = string;
        this.minorsortpsdefidDirtyFlag = true;
    }

    public String getMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFId();
        }
        return this.minorsortpsdefid;
    }

    public boolean isMinorSortPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFIdDirty();
        }
        return this.minorsortpsdefidDirtyFlag;
    }

    public void resetMinorSortPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFId();
            return;
        }
        this.minorsortpsdefidDirtyFlag = false;
        this.minorsortpsdefid = null;
    }

    public void setMinorSortPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorSortPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minorsortpsdefname = string;
        this.minorsortpsdefnameDirtyFlag = true;
    }

    public String getMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorSortPSDEFName();
        }
        return this.minorsortpsdefname;
    }

    public boolean isMinorSortPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorSortPSDEFNameDirty();
        }
        return this.minorsortpsdefnameDirtyFlag;
    }

    public void resetMinorSortPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorSortPSDEFName();
            return;
        }
        this.minorsortpsdefnameDirtyFlag = false;
        this.minorsortpsdefname = null;
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

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEViewCtrlDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrldsid = string;
        this.psdeviewctrldsidDirtyFlag = true;
    }

    public String getPSDEViewCtrlDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlDSId();
        }
        return this.psdeviewctrldsid;
    }

    public boolean isPSDEViewCtrlDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlDSIdDirty();
        }
        return this.psdeviewctrldsidDirtyFlag;
    }

    public void resetPSDEViewCtrlDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlDSId();
            return;
        }
        this.psdeviewctrldsidDirtyFlag = false;
        this.psdeviewctrldsid = null;
    }

    public void setPSDEViewCtrlDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrldsname = string;
        this.psdeviewctrldsnameDirtyFlag = true;
    }

    public String getPSDEViewCtrlDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlDSName();
        }
        return this.psdeviewctrldsname;
    }

    public boolean isPSDEViewCtrlDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlDSNameDirty();
        }
        return this.psdeviewctrldsnameDirtyFlag;
    }

    public void resetPSDEViewCtrlDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlDSName();
            return;
        }
        this.psdeviewctrldsnameDirtyFlag = false;
        this.psdeviewctrldsname = null;
    }

    public void setPSDEViewCtrlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlid = string;
        this.psdeviewctrlidDirtyFlag = true;
    }

    public String getPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlId();
        }
        return this.psdeviewctrlid;
    }

    public boolean isPSDEViewCtrlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlIdDirty();
        }
        return this.psdeviewctrlidDirtyFlag;
    }

    public void resetPSDEViewCtrlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlId();
            return;
        }
        this.psdeviewctrlidDirtyFlag = false;
        this.psdeviewctrlid = null;
    }

    public void setPSDEViewCtrlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewCtrlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewctrlname = string;
        this.psdeviewctrlnameDirtyFlag = true;
    }

    public String getPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewCtrlName();
        }
        return this.psdeviewctrlname;
    }

    public boolean isPSDEViewCtrlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewCtrlNameDirty();
        }
        return this.psdeviewctrlnameDirtyFlag;
    }

    public void resetPSDEViewCtrlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewCtrlName();
            return;
        }
        this.psdeviewctrlnameDirtyFlag = false;
        this.psdeviewctrlname = null;
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
        PSDEViewCtrlDSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewCtrlDSBase pSDEViewCtrlDSBase) {
        pSDEViewCtrlDSBase.resetCreateDate();
        pSDEViewCtrlDSBase.resetCreateMan();
        pSDEViewCtrlDSBase.resetMemo();
        pSDEViewCtrlDSBase.resetMinorSortDir();
        pSDEViewCtrlDSBase.resetMinorSortPSDEFId();
        pSDEViewCtrlDSBase.resetMinorSortPSDEFName();
        pSDEViewCtrlDSBase.resetOrderValue();
        pSDEViewCtrlDSBase.resetPSDEDataSetId();
        pSDEViewCtrlDSBase.resetPSDEDataSetName();
        pSDEViewCtrlDSBase.resetPSDEViewCtrlDSId();
        pSDEViewCtrlDSBase.resetPSDEViewCtrlDSName();
        pSDEViewCtrlDSBase.resetPSDEViewCtrlId();
        pSDEViewCtrlDSBase.resetPSDEViewCtrlName();
        pSDEViewCtrlDSBase.resetUpdateDate();
        pSDEViewCtrlDSBase.resetUpdateMan();
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
        if (!bl || this.isMinorSortDirDirty()) {
            hashMap.put(FIELD_MINORSORTDIR, this.getMinorSortDir());
        }
        if (!bl || this.isMinorSortPSDEFIdDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFID, this.getMinorSortPSDEFId());
        }
        if (!bl || this.isMinorSortPSDEFNameDirty()) {
            hashMap.put(FIELD_MINORSORTPSDEFNAME, this.getMinorSortPSDEFName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEViewCtrlDSIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLDSID, this.getPSDEViewCtrlDSId());
        }
        if (!bl || this.isPSDEViewCtrlDSNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLDSNAME, this.getPSDEViewCtrlDSName());
        }
        if (!bl || this.isPSDEViewCtrlIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLID, this.getPSDEViewCtrlId());
        }
        if (!bl || this.isPSDEViewCtrlNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWCTRLNAME, this.getPSDEViewCtrlName());
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
        return PSDEViewCtrlDSBase.get(this, n);
    }

    private static Object get(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlDSBase.getCreateDate();
            }
            case 1: {
                return pSDEViewCtrlDSBase.getCreateMan();
            }
            case 2: {
                return pSDEViewCtrlDSBase.getMemo();
            }
            case 3: {
                return pSDEViewCtrlDSBase.getMinorSortDir();
            }
            case 4: {
                return pSDEViewCtrlDSBase.getMinorSortPSDEFId();
            }
            case 5: {
                return pSDEViewCtrlDSBase.getMinorSortPSDEFName();
            }
            case 6: {
                return pSDEViewCtrlDSBase.getOrderValue();
            }
            case 7: {
                return pSDEViewCtrlDSBase.getPSDEDataSetId();
            }
            case 8: {
                return pSDEViewCtrlDSBase.getPSDEDataSetName();
            }
            case 9: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlDSId();
            }
            case 10: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlDSName();
            }
            case 11: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlId();
            }
            case 12: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlName();
            }
            case 13: {
                return pSDEViewCtrlDSBase.getUpdateDate();
            }
            case 14: {
                return pSDEViewCtrlDSBase.getUpdateMan();
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
        PSDEViewCtrlDSBase.set(this, n, object);
    }

    private static void set(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewCtrlDSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewCtrlDSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewCtrlDSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewCtrlDSBase.setMinorSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewCtrlDSBase.setMinorSortPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewCtrlDSBase.setMinorSortPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewCtrlDSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewCtrlDSBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewCtrlDSBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEViewCtrlDSBase.setPSDEViewCtrlDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEViewCtrlDSBase.setPSDEViewCtrlDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEViewCtrlDSBase.setPSDEViewCtrlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEViewCtrlDSBase.setPSDEViewCtrlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEViewCtrlDSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEViewCtrlDSBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEViewCtrlDSBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlDSBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewCtrlDSBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewCtrlDSBase.getMemo() == null;
            }
            case 3: {
                return pSDEViewCtrlDSBase.getMinorSortDir() == null;
            }
            case 4: {
                return pSDEViewCtrlDSBase.getMinorSortPSDEFId() == null;
            }
            case 5: {
                return pSDEViewCtrlDSBase.getMinorSortPSDEFName() == null;
            }
            case 6: {
                return pSDEViewCtrlDSBase.getOrderValue() == null;
            }
            case 7: {
                return pSDEViewCtrlDSBase.getPSDEDataSetId() == null;
            }
            case 8: {
                return pSDEViewCtrlDSBase.getPSDEDataSetName() == null;
            }
            case 9: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlDSId() == null;
            }
            case 10: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlDSName() == null;
            }
            case 11: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlId() == null;
            }
            case 12: {
                return pSDEViewCtrlDSBase.getPSDEViewCtrlName() == null;
            }
            case 13: {
                return pSDEViewCtrlDSBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEViewCtrlDSBase.getUpdateMan() == null;
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
        return PSDEViewCtrlDSBase.contains(this, n);
    }

    private static boolean contains(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewCtrlDSBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewCtrlDSBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewCtrlDSBase.isMemoDirty();
            }
            case 3: {
                return pSDEViewCtrlDSBase.isMinorSortDirDirty();
            }
            case 4: {
                return pSDEViewCtrlDSBase.isMinorSortPSDEFIdDirty();
            }
            case 5: {
                return pSDEViewCtrlDSBase.isMinorSortPSDEFNameDirty();
            }
            case 6: {
                return pSDEViewCtrlDSBase.isOrderValueDirty();
            }
            case 7: {
                return pSDEViewCtrlDSBase.isPSDEDataSetIdDirty();
            }
            case 8: {
                return pSDEViewCtrlDSBase.isPSDEDataSetNameDirty();
            }
            case 9: {
                return pSDEViewCtrlDSBase.isPSDEViewCtrlDSIdDirty();
            }
            case 10: {
                return pSDEViewCtrlDSBase.isPSDEViewCtrlDSNameDirty();
            }
            case 11: {
                return pSDEViewCtrlDSBase.isPSDEViewCtrlIdDirty();
            }
            case 12: {
                return pSDEViewCtrlDSBase.isPSDEViewCtrlNameDirty();
            }
            case 13: {
                return pSDEViewCtrlDSBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEViewCtrlDSBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewCtrlDSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewCtrlDSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortdir", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getMinorSortDir()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefid", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getMinorSortPSDEFId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minorsortpsdefname", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getMinorSortPSDEFName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrldsid", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEViewCtrlDSId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrldsname", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEViewCtrlDSName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlid", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEViewCtrlId()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewctrlname", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getPSDEViewCtrlName()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewCtrlDSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewCtrlDSBase.getJSONValue((Object)pSDEViewCtrlDSBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewCtrlDSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewCtrlDSBase.getCreateDate() != null) {
            object = pSDEViewCtrlDSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewCtrlDSBase.getCreateMan() != null) {
            object = pSDEViewCtrlDSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getMemo() != null) {
            object = pSDEViewCtrlDSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortDir() != null) {
            object = pSDEViewCtrlDSBase.getMinorSortDir();
            xmlNode.setAttribute(FIELD_MINORSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFId() != null) {
            object = pSDEViewCtrlDSBase.getMinorSortPSDEFId();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFName() != null) {
            object = pSDEViewCtrlDSBase.getMinorSortPSDEFName();
            xmlNode.setAttribute(FIELD_MINORSORTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getOrderValue() != null) {
            object = pSDEViewCtrlDSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEDataSetId() != null) {
            object = pSDEViewCtrlDSBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEDataSetName() != null) {
            object = pSDEViewCtrlDSBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSId() != null) {
            object = pSDEViewCtrlDSBase.getPSDEViewCtrlDSId();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSName() != null) {
            object = pSDEViewCtrlDSBase.getPSDEViewCtrlDSName();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlId() != null) {
            object = pSDEViewCtrlDSBase.getPSDEViewCtrlId();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlName() != null) {
            object = pSDEViewCtrlDSBase.getPSDEViewCtrlName();
            xmlNode.setAttribute(FIELD_PSDEVIEWCTRLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewCtrlDSBase.getUpdateDate() != null) {
            object = pSDEViewCtrlDSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewCtrlDSBase.getUpdateMan() != null) {
            object = pSDEViewCtrlDSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewCtrlDSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewCtrlDSBase.isCreateDateDirty() && (bl || pSDEViewCtrlDSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewCtrlDSBase.getCreateDate());
        }
        if (pSDEViewCtrlDSBase.isCreateManDirty() && (bl || pSDEViewCtrlDSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewCtrlDSBase.getCreateMan());
        }
        if (pSDEViewCtrlDSBase.isMemoDirty() && (bl || pSDEViewCtrlDSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewCtrlDSBase.getMemo());
        }
        if (pSDEViewCtrlDSBase.isMinorSortDirDirty() && (bl || pSDEViewCtrlDSBase.getMinorSortDir() != null)) {
            iDataObject.set(FIELD_MINORSORTDIR, (Object)pSDEViewCtrlDSBase.getMinorSortDir());
        }
        if (pSDEViewCtrlDSBase.isMinorSortPSDEFIdDirty() && (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFId() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFID, (Object)pSDEViewCtrlDSBase.getMinorSortPSDEFId());
        }
        if (pSDEViewCtrlDSBase.isMinorSortPSDEFNameDirty() && (bl || pSDEViewCtrlDSBase.getMinorSortPSDEFName() != null)) {
            iDataObject.set(FIELD_MINORSORTPSDEFNAME, (Object)pSDEViewCtrlDSBase.getMinorSortPSDEFName());
        }
        if (pSDEViewCtrlDSBase.isOrderValueDirty() && (bl || pSDEViewCtrlDSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEViewCtrlDSBase.getOrderValue());
        }
        if (pSDEViewCtrlDSBase.isPSDEDataSetIdDirty() && (bl || pSDEViewCtrlDSBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEViewCtrlDSBase.getPSDEDataSetId());
        }
        if (pSDEViewCtrlDSBase.isPSDEDataSetNameDirty() && (bl || pSDEViewCtrlDSBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEViewCtrlDSBase.getPSDEDataSetName());
        }
        if (pSDEViewCtrlDSBase.isPSDEViewCtrlDSIdDirty() && (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLDSID, (Object)pSDEViewCtrlDSBase.getPSDEViewCtrlDSId());
        }
        if (pSDEViewCtrlDSBase.isPSDEViewCtrlDSNameDirty() && (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlDSName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLDSNAME, (Object)pSDEViewCtrlDSBase.getPSDEViewCtrlDSName());
        }
        if (pSDEViewCtrlDSBase.isPSDEViewCtrlIdDirty() && (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLID, (Object)pSDEViewCtrlDSBase.getPSDEViewCtrlId());
        }
        if (pSDEViewCtrlDSBase.isPSDEViewCtrlNameDirty() && (bl || pSDEViewCtrlDSBase.getPSDEViewCtrlName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWCTRLNAME, (Object)pSDEViewCtrlDSBase.getPSDEViewCtrlName());
        }
        if (pSDEViewCtrlDSBase.isUpdateDateDirty() && (bl || pSDEViewCtrlDSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewCtrlDSBase.getUpdateDate());
        }
        if (pSDEViewCtrlDSBase.isUpdateManDirty() && (bl || pSDEViewCtrlDSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewCtrlDSBase.getUpdateMan());
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
        return PSDEViewCtrlDSBase.remove(this, n);
    }

    private static boolean remove(PSDEViewCtrlDSBase pSDEViewCtrlDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewCtrlDSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewCtrlDSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewCtrlDSBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEViewCtrlDSBase.resetMinorSortDir();
                return true;
            }
            case 4: {
                pSDEViewCtrlDSBase.resetMinorSortPSDEFId();
                return true;
            }
            case 5: {
                pSDEViewCtrlDSBase.resetMinorSortPSDEFName();
                return true;
            }
            case 6: {
                pSDEViewCtrlDSBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDEViewCtrlDSBase.resetPSDEDataSetId();
                return true;
            }
            case 8: {
                pSDEViewCtrlDSBase.resetPSDEDataSetName();
                return true;
            }
            case 9: {
                pSDEViewCtrlDSBase.resetPSDEViewCtrlDSId();
                return true;
            }
            case 10: {
                pSDEViewCtrlDSBase.resetPSDEViewCtrlDSName();
                return true;
            }
            case 11: {
                pSDEViewCtrlDSBase.resetPSDEViewCtrlId();
                return true;
            }
            case 12: {
                pSDEViewCtrlDSBase.resetPSDEViewCtrlName();
                return true;
            }
            case 13: {
                pSDEViewCtrlDSBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEViewCtrlDSBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPsdedataset() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdedataset();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPsdedatasetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getMinorsortpsdef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorsortpsdef();
        }
        if (this.getMinorSortPSDEFId() == null) {
            return null;
        }
        Integer n = this.objMinorsortpsdefLock;
        synchronized (n) {
            if (this.minorsortpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getMinorSortPSDEFId(), (Object)this.minorsortpsdef.getPSDEFieldId()) != 0L) {
                this.minorsortpsdef = null;
            }
            if (this.minorsortpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getMinorSortPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.minorsortpsdef = pSDEField;
            }
            return this.minorsortpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewCtrl getPsdeviewctrl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdeviewctrl();
        }
        if (this.getPSDEViewCtrlId() == null) {
            return null;
        }
        Integer n = this.objPsdeviewctrlLock;
        synchronized (n) {
            if (this.psdeviewctrl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewCtrlId(), (Object)this.psdeviewctrl.getPSDEViewCtrlId()) != 0L) {
                this.psdeviewctrl = null;
            }
            if (this.psdeviewctrl == null) {
                PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
                pSDEViewCtrl.setPSDEViewCtrlId(this.getPSDEViewCtrlId());
                PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewCtrlService.autoGet(pSDEViewCtrl);
                this.psdeviewctrl = pSDEViewCtrl;
            }
            return this.psdeviewctrl;
        }
    }

    private PSDEViewCtrlDSBase getProxyEntity() {
        return this.proxyPSDEViewCtrlDSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewCtrlDSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewCtrlDSBase) {
            this.proxyPSDEViewCtrlDSBase = (PSDEViewCtrlDSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_MINORSORTDIR, 3);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFID, 4);
        fieldIndexMap.put(FIELD_MINORSORTPSDEFNAME, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 7);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLDSID, 9);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLDSNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLID, 11);
        fieldIndexMap.put(FIELD_PSDEVIEWCTRLNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

