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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSDQBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDSDQBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_PSDEDSDQID = "PSDEDSDQID";
    public static final String FIELD_PSDEDSDQNAME = "PSDEDSDQNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSDEDATASETID = 5;
    private static final int INDEX_PSDEDATASETNAME = 6;
    private static final int INDEX_PSDEDQID = 7;
    private static final int INDEX_PSDEDQNAME = 8;
    private static final int INDEX_PSDEDSDQID = 9;
    private static final int INDEX_PSDEDSDQNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDYNAINSTID = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VIEWCOLLEVEL = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDSDQBase proxyPSDEDSDQBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean psdedsdqidDirtyFlag = false;
    private boolean psdedsdqnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewcollevelDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="psdedsdqid")
    private String psdedsdqid;
    @Column(name="psdedsdqname")
    private String psdedsdqname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewcollevel")
    private Integer viewcollevel;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;

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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
    }

    public void setPSDEDSDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsdqid = string;
        this.psdedsdqidDirtyFlag = true;
    }

    public String getPSDEDSDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSDQId();
        }
        return this.psdedsdqid;
    }

    public boolean isPSDEDSDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSDQIdDirty();
        }
        return this.psdedsdqidDirtyFlag;
    }

    public void resetPSDEDSDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSDQId();
            return;
        }
        this.psdedsdqidDirtyFlag = false;
        this.psdedsdqid = null;
    }

    public void setPSDEDSDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsdqname = string;
        this.psdedsdqnameDirtyFlag = true;
    }

    public String getPSDEDSDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSDQName();
        }
        return this.psdedsdqname;
    }

    public boolean isPSDEDSDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSDQNameDirty();
        }
        return this.psdedsdqnameDirtyFlag;
    }

    public void resetPSDEDSDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSDQName();
            return;
        }
        this.psdedsdqnameDirtyFlag = false;
        this.psdedsdqname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setViewColLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewColLevel(n);
            return;
        }
        this.viewcollevel = n;
        this.viewcollevelDirtyFlag = true;
    }

    public Integer getViewColLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewColLevel();
        }
        return this.viewcollevel;
    }

    public boolean isViewColLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewColLevelDirty();
        }
        return this.viewcollevelDirtyFlag;
    }

    public void resetViewColLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewColLevel();
            return;
        }
        this.viewcollevelDirtyFlag = false;
        this.viewcollevel = null;
    }

    protected void onReset() {
        PSDEDSDQBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDSDQBase pSDEDSDQBase) {
        pSDEDSDQBase.resetCreateDate();
        pSDEDSDQBase.resetCreateMan();
        pSDEDSDQBase.resetDynaModelFlag();
        pSDEDSDQBase.resetMemo();
        pSDEDSDQBase.resetOrderValue();
        pSDEDSDQBase.resetPSDEDataSetId();
        pSDEDSDQBase.resetPSDEDataSetName();
        pSDEDSDQBase.resetPSDEDQId();
        pSDEDSDQBase.resetPSDEDQName();
        pSDEDSDQBase.resetPSDEDSDQId();
        pSDEDSDQBase.resetPSDEDSDQName();
        pSDEDSDQBase.resetPSDEId();
        pSDEDSDQBase.resetPSDynaInstId();
        pSDEDSDQBase.resetUpdateDate();
        pSDEDSDQBase.resetUpdateMan();
        pSDEDSDQBase.resetViewColLevel();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isPSDEDSDQIdDirty()) {
            hashMap.put(FIELD_PSDEDSDQID, this.getPSDEDSDQId());
        }
        if (!bl || this.isPSDEDSDQNameDirty()) {
            hashMap.put(FIELD_PSDEDSDQNAME, this.getPSDEDSDQName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewColLevelDirty()) {
            hashMap.put(FIELD_VIEWCOLLEVEL, this.getViewColLevel());
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
        return PSDEDSDQBase.get(this, n);
    }

    private static Object get(PSDEDSDQBase pSDEDSDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSDQBase.getCreateDate();
            }
            case 1: {
                return pSDEDSDQBase.getCreateMan();
            }
            case 2: {
                return pSDEDSDQBase.getDynaModelFlag();
            }
            case 3: {
                return pSDEDSDQBase.getMemo();
            }
            case 4: {
                return pSDEDSDQBase.getOrderValue();
            }
            case 5: {
                return pSDEDSDQBase.getPSDEDataSetId();
            }
            case 6: {
                return pSDEDSDQBase.getPSDEDataSetName();
            }
            case 7: {
                return pSDEDSDQBase.getPSDEDQId();
            }
            case 8: {
                return pSDEDSDQBase.getPSDEDQName();
            }
            case 9: {
                return pSDEDSDQBase.getPSDEDSDQId();
            }
            case 10: {
                return pSDEDSDQBase.getPSDEDSDQName();
            }
            case 11: {
                return pSDEDSDQBase.getPSDEId();
            }
            case 12: {
                return pSDEDSDQBase.getPSDynaInstId();
            }
            case 13: {
                return pSDEDSDQBase.getUpdateDate();
            }
            case 14: {
                return pSDEDSDQBase.getUpdateMan();
            }
            case 15: {
                return pSDEDSDQBase.getViewColLevel();
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
        PSDEDSDQBase.set(this, n, object);
    }

    private static void set(PSDEDSDQBase pSDEDSDQBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSDQBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDSDQBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDSDQBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEDSDQBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDSDQBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDSDQBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDSDQBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDSDQBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDSDQBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDSDQBase.setPSDEDSDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDSDQBase.setPSDEDSDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDSDQBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDSDQBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDSDQBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEDSDQBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDSDQBase.setViewColLevel(DataObject.getIntegerValue((Object)object));
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
        return PSDEDSDQBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDSDQBase pSDEDSDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSDQBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDSDQBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDSDQBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSDEDSDQBase.getMemo() == null;
            }
            case 4: {
                return pSDEDSDQBase.getOrderValue() == null;
            }
            case 5: {
                return pSDEDSDQBase.getPSDEDataSetId() == null;
            }
            case 6: {
                return pSDEDSDQBase.getPSDEDataSetName() == null;
            }
            case 7: {
                return pSDEDSDQBase.getPSDEDQId() == null;
            }
            case 8: {
                return pSDEDSDQBase.getPSDEDQName() == null;
            }
            case 9: {
                return pSDEDSDQBase.getPSDEDSDQId() == null;
            }
            case 10: {
                return pSDEDSDQBase.getPSDEDSDQName() == null;
            }
            case 11: {
                return pSDEDSDQBase.getPSDEId() == null;
            }
            case 12: {
                return pSDEDSDQBase.getPSDynaInstId() == null;
            }
            case 13: {
                return pSDEDSDQBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEDSDQBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDEDSDQBase.getViewColLevel() == null;
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
        return PSDEDSDQBase.contains(this, n);
    }

    private static boolean contains(PSDEDSDQBase pSDEDSDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSDQBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDSDQBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDSDQBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSDEDSDQBase.isMemoDirty();
            }
            case 4: {
                return pSDEDSDQBase.isOrderValueDirty();
            }
            case 5: {
                return pSDEDSDQBase.isPSDEDataSetIdDirty();
            }
            case 6: {
                return pSDEDSDQBase.isPSDEDataSetNameDirty();
            }
            case 7: {
                return pSDEDSDQBase.isPSDEDQIdDirty();
            }
            case 8: {
                return pSDEDSDQBase.isPSDEDQNameDirty();
            }
            case 9: {
                return pSDEDSDQBase.isPSDEDSDQIdDirty();
            }
            case 10: {
                return pSDEDSDQBase.isPSDEDSDQNameDirty();
            }
            case 11: {
                return pSDEDSDQBase.isPSDEIdDirty();
            }
            case 12: {
                return pSDEDSDQBase.isPSDynaInstIdDirty();
            }
            case 13: {
                return pSDEDSDQBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEDSDQBase.isUpdateManDirty();
            }
            case 15: {
                return pSDEDSDQBase.isViewColLevelDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDSDQBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDSDQBase pSDEDSDQBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDSDQBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDSDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsdqid", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDSDQId()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEDSDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsdqname", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEDSDQName()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDSDQBase.getViewColLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewcollevel", (Object)PSDEDSDQBase.getJSONValue((Object)pSDEDSDQBase.getViewColLevel()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDSDQBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDSDQBase pSDEDSDQBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDSDQBase.getCreateDate() != null) {
            object = pSDEDSDQBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSDQBase.getCreateMan() != null) {
            object = pSDEDSDQBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getDynaModelFlag() != null) {
            object = pSDEDSDQBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSDQBase.getMemo() != null) {
            object = pSDEDSDQBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getOrderValue() != null) {
            object = pSDEDSDQBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDSDQBase.getPSDEDataSetId() != null) {
            object = pSDEDSDQBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEDataSetName() != null) {
            object = pSDEDSDQBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEDQId() != null) {
            object = pSDEDSDQBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEDQName() != null) {
            object = pSDEDSDQBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEDSDQId() != null) {
            object = pSDEDSDQBase.getPSDEDSDQId();
            xmlNode.setAttribute(FIELD_PSDEDSDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEDSDQName() != null) {
            object = pSDEDSDQBase.getPSDEDSDQName();
            xmlNode.setAttribute(FIELD_PSDEDSDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDEId() != null) {
            object = pSDEDSDQBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getPSDynaInstId() != null) {
            object = pSDEDSDQBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getUpdateDate() != null) {
            object = pSDEDSDQBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSDQBase.getUpdateMan() != null) {
            object = pSDEDSDQBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSDQBase.getViewColLevel() != null) {
            object = pSDEDSDQBase.getViewColLevel();
            xmlNode.setAttribute(FIELD_VIEWCOLLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDSDQBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDSDQBase pSDEDSDQBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDSDQBase.isCreateDateDirty() && (bl || pSDEDSDQBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDSDQBase.getCreateDate());
        }
        if (pSDEDSDQBase.isCreateManDirty() && (bl || pSDEDSDQBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDSDQBase.getCreateMan());
        }
        if (pSDEDSDQBase.isDynaModelFlagDirty() && (bl || pSDEDSDQBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDSDQBase.getDynaModelFlag());
        }
        if (pSDEDSDQBase.isMemoDirty() && (bl || pSDEDSDQBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDSDQBase.getMemo());
        }
        if (pSDEDSDQBase.isOrderValueDirty() && (bl || pSDEDSDQBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDSDQBase.getOrderValue());
        }
        if (pSDEDSDQBase.isPSDEDataSetIdDirty() && (bl || pSDEDSDQBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEDSDQBase.getPSDEDataSetId());
        }
        if (pSDEDSDQBase.isPSDEDataSetNameDirty() && (bl || pSDEDSDQBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEDSDQBase.getPSDEDataSetName());
        }
        if (pSDEDSDQBase.isPSDEDQIdDirty() && (bl || pSDEDSDQBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEDSDQBase.getPSDEDQId());
        }
        if (pSDEDSDQBase.isPSDEDQNameDirty() && (bl || pSDEDSDQBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEDSDQBase.getPSDEDQName());
        }
        if (pSDEDSDQBase.isPSDEDSDQIdDirty() && (bl || pSDEDSDQBase.getPSDEDSDQId() != null)) {
            iDataObject.set(FIELD_PSDEDSDQID, (Object)pSDEDSDQBase.getPSDEDSDQId());
        }
        if (pSDEDSDQBase.isPSDEDSDQNameDirty() && (bl || pSDEDSDQBase.getPSDEDSDQName() != null)) {
            iDataObject.set(FIELD_PSDEDSDQNAME, (Object)pSDEDSDQBase.getPSDEDSDQName());
        }
        if (pSDEDSDQBase.isPSDEIdDirty() && (bl || pSDEDSDQBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDSDQBase.getPSDEId());
        }
        if (pSDEDSDQBase.isPSDynaInstIdDirty() && (bl || pSDEDSDQBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDSDQBase.getPSDynaInstId());
        }
        if (pSDEDSDQBase.isUpdateDateDirty() && (bl || pSDEDSDQBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDSDQBase.getUpdateDate());
        }
        if (pSDEDSDQBase.isUpdateManDirty() && (bl || pSDEDSDQBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDSDQBase.getUpdateMan());
        }
        if (pSDEDSDQBase.isViewColLevelDirty() && (bl || pSDEDSDQBase.getViewColLevel() != null)) {
            iDataObject.set(FIELD_VIEWCOLLEVEL, (Object)pSDEDSDQBase.getViewColLevel());
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
        return PSDEDSDQBase.remove(this, n);
    }

    private static boolean remove(PSDEDSDQBase pSDEDSDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSDQBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDSDQBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDSDQBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSDEDSDQBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDSDQBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSDEDSDQBase.resetPSDEDataSetId();
                return true;
            }
            case 6: {
                pSDEDSDQBase.resetPSDEDataSetName();
                return true;
            }
            case 7: {
                pSDEDSDQBase.resetPSDEDQId();
                return true;
            }
            case 8: {
                pSDEDSDQBase.resetPSDEDQName();
                return true;
            }
            case 9: {
                pSDEDSDQBase.resetPSDEDSDQId();
                return true;
            }
            case 10: {
                pSDEDSDQBase.resetPSDEDSDQName();
                return true;
            }
            case 11: {
                pSDEDSDQBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSDEDSDQBase.resetPSDynaInstId();
                return true;
            }
            case 13: {
                pSDEDSDQBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEDSDQBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDEDSDQBase.resetViewColLevel();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
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

    private PSDEDSDQBase getProxyEntity() {
        return this.proxyPSDEDSDQBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDSDQBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDSDQBase) {
            this.proxyPSDEDSDQBase = (PSDEDSDQBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 5);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 6);
        fieldIndexMap.put(FIELD_PSDEDQID, 7);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 8);
        fieldIndexMap.put(FIELD_PSDEDSDQID, 9);
        fieldIndexMap.put(FIELD_PSDEDSDQNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VIEWCOLLEVEL, 15);
    }
}

