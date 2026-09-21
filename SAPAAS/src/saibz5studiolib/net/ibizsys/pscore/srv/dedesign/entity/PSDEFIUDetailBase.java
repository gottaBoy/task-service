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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIUDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFIUDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_PSDEFIUDETAILID = "PSDEFIUDETAILID";
    public static final String FIELD_PSDEFIUDETAILNAME = "PSDEFIUDETAILNAME";
    public static final String FIELD_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String FIELD_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String FIELD_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String FIELD_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_PSDEFIUDETAILID = 3;
    private static final int INDEX_PSDEFIUDETAILNAME = 4;
    private static final int INDEX_PSDEFIUPDATEID = 5;
    private static final int INDEX_PSDEFIUPDATENAME = 6;
    private static final int INDEX_PSDEFORMDETAILID = 7;
    private static final int INDEX_PSDEFORMDETAILNAME = 8;
    private static final int INDEX_PSDEFORMID = 9;
    private static final int INDEX_PSDEFORMNAME = 10;
    private static final int INDEX_PSDYNAINSTID = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFIUDetailBase proxyPSDEFIUDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean psdefiudetailidDirtyFlag = false;
    private boolean psdefiudetailnameDirtyFlag = false;
    private boolean psdefiupdateidDirtyFlag = false;
    private boolean psdefiupdatenameDirtyFlag = false;
    private boolean psdeformdetailidDirtyFlag = false;
    private boolean psdeformdetailnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="psdefiudetailid")
    private String psdefiudetailid;
    @Column(name="psdefiudetailname")
    private String psdefiudetailname;
    @Column(name="psdefiupdateid")
    private String psdefiupdateid;
    @Column(name="psdefiupdatename")
    private String psdefiupdatename;
    @Column(name="psdeformdetailid")
    private String psdeformdetailid;
    @Column(name="psdeformdetailname")
    private String psdeformdetailname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEFIUpdateLock = new Integer(1);
    private PSDEFIUpdate psdefiupdate = null;
    private Integer objPSDEFormDetailLock = new Integer(1);
    private PSDEFormDetail psdeformdetail = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;

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

    public void setPSDEFIUDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiudetailid = string;
        this.psdefiudetailidDirtyFlag = true;
    }

    public String getPSDEFIUDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUDetailId();
        }
        return this.psdefiudetailid;
    }

    public boolean isPSDEFIUDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUDetailIdDirty();
        }
        return this.psdefiudetailidDirtyFlag;
    }

    public void resetPSDEFIUDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUDetailId();
            return;
        }
        this.psdefiudetailidDirtyFlag = false;
        this.psdefiudetailid = null;
    }

    public void setPSDEFIUDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiudetailname = string;
        this.psdefiudetailnameDirtyFlag = true;
    }

    public String getPSDEFIUDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUDetailName();
        }
        return this.psdefiudetailname;
    }

    public boolean isPSDEFIUDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUDetailNameDirty();
        }
        return this.psdefiudetailnameDirtyFlag;
    }

    public void resetPSDEFIUDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUDetailName();
            return;
        }
        this.psdefiudetailnameDirtyFlag = false;
        this.psdefiudetailname = null;
    }

    public void setPSDEFIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdateid = string;
        this.psdefiupdateidDirtyFlag = true;
    }

    public String getPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateId();
        }
        return this.psdefiupdateid;
    }

    public boolean isPSDEFIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateIdDirty();
        }
        return this.psdefiupdateidDirtyFlag;
    }

    public void resetPSDEFIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateId();
            return;
        }
        this.psdefiupdateidDirtyFlag = false;
        this.psdefiupdateid = null;
    }

    public void setPSDEFIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiupdatename = string;
        this.psdefiupdatenameDirtyFlag = true;
    }

    public String getPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdateName();
        }
        return this.psdefiupdatename;
    }

    public boolean isPSDEFIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIUpdateNameDirty();
        }
        return this.psdefiupdatenameDirtyFlag;
    }

    public void resetPSDEFIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIUpdateName();
            return;
        }
        this.psdefiupdatenameDirtyFlag = false;
        this.psdefiupdatename = null;
    }

    public void setPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailid = string;
        this.psdeformdetailidDirtyFlag = true;
    }

    public String getPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailId();
        }
        return this.psdeformdetailid;
    }

    public boolean isPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailIdDirty();
        }
        return this.psdeformdetailidDirtyFlag;
    }

    public void resetPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailId();
            return;
        }
        this.psdeformdetailidDirtyFlag = false;
        this.psdeformdetailid = null;
    }

    public void setPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailname = string;
        this.psdeformdetailnameDirtyFlag = true;
    }

    public String getPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailName();
        }
        return this.psdeformdetailname;
    }

    public boolean isPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailNameDirty();
        }
        return this.psdeformdetailnameDirtyFlag;
    }

    public void resetPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailName();
            return;
        }
        this.psdeformdetailnameDirtyFlag = false;
        this.psdeformdetailname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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

    protected void onReset() {
        PSDEFIUDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFIUDetailBase pSDEFIUDetailBase) {
        pSDEFIUDetailBase.resetCreateDate();
        pSDEFIUDetailBase.resetCreateMan();
        pSDEFIUDetailBase.resetDynaModelFlag();
        pSDEFIUDetailBase.resetPSDEFIUDetailId();
        pSDEFIUDetailBase.resetPSDEFIUDetailName();
        pSDEFIUDetailBase.resetPSDEFIUpdateId();
        pSDEFIUDetailBase.resetPSDEFIUpdateName();
        pSDEFIUDetailBase.resetPSDEFormDetailId();
        pSDEFIUDetailBase.resetPSDEFormDetailName();
        pSDEFIUDetailBase.resetPSDEFormId();
        pSDEFIUDetailBase.resetPSDEFormName();
        pSDEFIUDetailBase.resetPSDynaInstId();
        pSDEFIUDetailBase.resetUpdateDate();
        pSDEFIUDetailBase.resetUpdateMan();
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
        if (!bl || this.isPSDEFIUDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFIUDETAILID, this.getPSDEFIUDetailId());
        }
        if (!bl || this.isPSDEFIUDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFIUDETAILNAME, this.getPSDEFIUDetailName());
        }
        if (!bl || this.isPSDEFIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATEID, this.getPSDEFIUpdateId());
        }
        if (!bl || this.isPSDEFIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEFIUPDATENAME, this.getPSDEFIUpdateName());
        }
        if (!bl || this.isPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILID, this.getPSDEFormDetailId());
        }
        if (!bl || this.isPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILNAME, this.getPSDEFormDetailName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
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
        return PSDEFIUDetailBase.get(this, n);
    }

    private static Object get(PSDEFIUDetailBase pSDEFIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEFIUDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEFIUDetailBase.getDynaModelFlag();
            }
            case 3: {
                return pSDEFIUDetailBase.getPSDEFIUDetailId();
            }
            case 4: {
                return pSDEFIUDetailBase.getPSDEFIUDetailName();
            }
            case 5: {
                return pSDEFIUDetailBase.getPSDEFIUpdateId();
            }
            case 6: {
                return pSDEFIUDetailBase.getPSDEFIUpdateName();
            }
            case 7: {
                return pSDEFIUDetailBase.getPSDEFormDetailId();
            }
            case 8: {
                return pSDEFIUDetailBase.getPSDEFormDetailName();
            }
            case 9: {
                return pSDEFIUDetailBase.getPSDEFormId();
            }
            case 10: {
                return pSDEFIUDetailBase.getPSDEFormName();
            }
            case 11: {
                return pSDEFIUDetailBase.getPSDynaInstId();
            }
            case 12: {
                return pSDEFIUDetailBase.getUpdateDate();
            }
            case 13: {
                return pSDEFIUDetailBase.getUpdateMan();
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
        PSDEFIUDetailBase.set(this, n, object);
    }

    private static void set(PSDEFIUDetailBase pSDEFIUDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIUDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFIUDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFIUDetailBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEFIUDetailBase.setPSDEFIUDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFIUDetailBase.setPSDEFIUDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFIUDetailBase.setPSDEFIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFIUDetailBase.setPSDEFIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFIUDetailBase.setPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFIUDetailBase.setPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFIUDetailBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFIUDetailBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFIUDetailBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFIUDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDEFIUDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFIUDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFIUDetailBase pSDEFIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFIUDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFIUDetailBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSDEFIUDetailBase.getPSDEFIUDetailId() == null;
            }
            case 4: {
                return pSDEFIUDetailBase.getPSDEFIUDetailName() == null;
            }
            case 5: {
                return pSDEFIUDetailBase.getPSDEFIUpdateId() == null;
            }
            case 6: {
                return pSDEFIUDetailBase.getPSDEFIUpdateName() == null;
            }
            case 7: {
                return pSDEFIUDetailBase.getPSDEFormDetailId() == null;
            }
            case 8: {
                return pSDEFIUDetailBase.getPSDEFormDetailName() == null;
            }
            case 9: {
                return pSDEFIUDetailBase.getPSDEFormId() == null;
            }
            case 10: {
                return pSDEFIUDetailBase.getPSDEFormName() == null;
            }
            case 11: {
                return pSDEFIUDetailBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSDEFIUDetailBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDEFIUDetailBase.getUpdateMan() == null;
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
        return PSDEFIUDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEFIUDetailBase pSDEFIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIUDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFIUDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFIUDetailBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSDEFIUDetailBase.isPSDEFIUDetailIdDirty();
            }
            case 4: {
                return pSDEFIUDetailBase.isPSDEFIUDetailNameDirty();
            }
            case 5: {
                return pSDEFIUDetailBase.isPSDEFIUpdateIdDirty();
            }
            case 6: {
                return pSDEFIUDetailBase.isPSDEFIUpdateNameDirty();
            }
            case 7: {
                return pSDEFIUDetailBase.isPSDEFormDetailIdDirty();
            }
            case 8: {
                return pSDEFIUDetailBase.isPSDEFormDetailNameDirty();
            }
            case 9: {
                return pSDEFIUDetailBase.isPSDEFormIdDirty();
            }
            case 10: {
                return pSDEFIUDetailBase.isPSDEFormNameDirty();
            }
            case 11: {
                return pSDEFIUDetailBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSDEFIUDetailBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDEFIUDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFIUDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFIUDetailBase pSDEFIUDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFIUDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiudetailid", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFIUDetailId()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiudetailname", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFIUDetailName()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdateid", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFIUpdateId()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiupdatename", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFIUpdateName()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailid", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailname", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFIUDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFIUDetailBase.getJSONValue((Object)pSDEFIUDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFIUDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFIUDetailBase pSDEFIUDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFIUDetailBase.getCreateDate() != null) {
            object = pSDEFIUDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIUDetailBase.getCreateMan() != null) {
            object = pSDEFIUDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getDynaModelFlag() != null) {
            object = pSDEFIUDetailBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUDetailId() != null) {
            object = pSDEFIUDetailBase.getPSDEFIUDetailId();
            xmlNode.setAttribute(FIELD_PSDEFIUDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUDetailName() != null) {
            object = pSDEFIUDetailBase.getPSDEFIUDetailName();
            xmlNode.setAttribute(FIELD_PSDEFIUDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUpdateId() != null) {
            object = pSDEFIUDetailBase.getPSDEFIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFIUpdateName() != null) {
            object = pSDEFIUDetailBase.getPSDEFIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEFIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormDetailId() != null) {
            object = pSDEFIUDetailBase.getPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormDetailName() != null) {
            object = pSDEFIUDetailBase.getPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormId() != null) {
            object = pSDEFIUDetailBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDEFormName() != null) {
            object = pSDEFIUDetailBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getPSDynaInstId() != null) {
            object = pSDEFIUDetailBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIUDetailBase.getUpdateDate() != null) {
            object = pSDEFIUDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIUDetailBase.getUpdateMan() != null) {
            object = pSDEFIUDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFIUDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFIUDetailBase pSDEFIUDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFIUDetailBase.isCreateDateDirty() && (bl || pSDEFIUDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFIUDetailBase.getCreateDate());
        }
        if (pSDEFIUDetailBase.isCreateManDirty() && (bl || pSDEFIUDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFIUDetailBase.getCreateMan());
        }
        if (pSDEFIUDetailBase.isDynaModelFlagDirty() && (bl || pSDEFIUDetailBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFIUDetailBase.getDynaModelFlag());
        }
        if (pSDEFIUDetailBase.isPSDEFIUDetailIdDirty() && (bl || pSDEFIUDetailBase.getPSDEFIUDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFIUDETAILID, (Object)pSDEFIUDetailBase.getPSDEFIUDetailId());
        }
        if (pSDEFIUDetailBase.isPSDEFIUDetailNameDirty() && (bl || pSDEFIUDetailBase.getPSDEFIUDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFIUDETAILNAME, (Object)pSDEFIUDetailBase.getPSDEFIUDetailName());
        }
        if (pSDEFIUDetailBase.isPSDEFIUpdateIdDirty() && (bl || pSDEFIUDetailBase.getPSDEFIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATEID, (Object)pSDEFIUDetailBase.getPSDEFIUpdateId());
        }
        if (pSDEFIUDetailBase.isPSDEFIUpdateNameDirty() && (bl || pSDEFIUDetailBase.getPSDEFIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEFIUPDATENAME, (Object)pSDEFIUDetailBase.getPSDEFIUpdateName());
        }
        if (pSDEFIUDetailBase.isPSDEFormDetailIdDirty() && (bl || pSDEFIUDetailBase.getPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILID, (Object)pSDEFIUDetailBase.getPSDEFormDetailId());
        }
        if (pSDEFIUDetailBase.isPSDEFormDetailNameDirty() && (bl || pSDEFIUDetailBase.getPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILNAME, (Object)pSDEFIUDetailBase.getPSDEFormDetailName());
        }
        if (pSDEFIUDetailBase.isPSDEFormIdDirty() && (bl || pSDEFIUDetailBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFIUDetailBase.getPSDEFormId());
        }
        if (pSDEFIUDetailBase.isPSDEFormNameDirty() && (bl || pSDEFIUDetailBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFIUDetailBase.getPSDEFormName());
        }
        if (pSDEFIUDetailBase.isPSDynaInstIdDirty() && (bl || pSDEFIUDetailBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFIUDetailBase.getPSDynaInstId());
        }
        if (pSDEFIUDetailBase.isUpdateDateDirty() && (bl || pSDEFIUDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFIUDetailBase.getUpdateDate());
        }
        if (pSDEFIUDetailBase.isUpdateManDirty() && (bl || pSDEFIUDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFIUDetailBase.getUpdateMan());
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
        return PSDEFIUDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEFIUDetailBase pSDEFIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIUDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFIUDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFIUDetailBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSDEFIUDetailBase.resetPSDEFIUDetailId();
                return true;
            }
            case 4: {
                pSDEFIUDetailBase.resetPSDEFIUDetailName();
                return true;
            }
            case 5: {
                pSDEFIUDetailBase.resetPSDEFIUpdateId();
                return true;
            }
            case 6: {
                pSDEFIUDetailBase.resetPSDEFIUpdateName();
                return true;
            }
            case 7: {
                pSDEFIUDetailBase.resetPSDEFormDetailId();
                return true;
            }
            case 8: {
                pSDEFIUDetailBase.resetPSDEFormDetailName();
                return true;
            }
            case 9: {
                pSDEFIUDetailBase.resetPSDEFormId();
                return true;
            }
            case 10: {
                pSDEFIUDetailBase.resetPSDEFormName();
                return true;
            }
            case 11: {
                pSDEFIUDetailBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSDEFIUDetailBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDEFIUDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFIUpdate getPSDEFIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIUpdate();
        }
        if (this.getPSDEFIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDEFIUpdateLock;
        synchronized (n) {
            if (this.psdefiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFIUpdateId(), (Object)this.psdefiupdate.getPSDEFIUpdateId()) != 0L) {
                this.psdefiupdate = null;
            }
            if (this.psdefiupdate == null) {
                PSDEFIUpdate pSDEFIUpdate = new PSDEFIUpdate();
                pSDEFIUpdate.setPSDEFIUpdateId(this.getPSDEFIUpdateId());
                PSDEFIUpdateService pSDEFIUpdateService = (PSDEFIUpdateService)ServiceGlobal.getService(PSDEFIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDEFIUpdateService.autoGet((IEntity)pSDEFIUpdate);
                this.psdefiupdate = pSDEFIUpdate;
            }
            return this.psdefiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormDetail getPSDEFormDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetail();
        }
        if (this.getPSDEFormDetailId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormDetailLock;
        synchronized (n) {
            if (this.psdeformdetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormDetailId(), (Object)this.psdeformdetail.getPSDEFormDetailId()) != 0L) {
                this.psdeformdetail = null;
            }
            if (this.psdeformdetail == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getPSDEFormDetailId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet((IEntity)pSDEFormDetail);
                this.psdeformdetail = pSDEFormDetail;
            }
            return this.psdeformdetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    private PSDEFIUDetailBase getProxyEntity() {
        return this.proxyPSDEFIUDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFIUDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFIUDetailBase) {
            this.proxyPSDEFIUDetailBase = (PSDEFIUDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_PSDEFIUDETAILID, 3);
        fieldIndexMap.put(FIELD_PSDEFIUDETAILNAME, 4);
        fieldIndexMap.put(FIELD_PSDEFIUPDATEID, 5);
        fieldIndexMap.put(FIELD_PSDEFIUPDATENAME, 6);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILID, 7);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILNAME, 8);
        fieldIndexMap.put(FIELD_PSDEFORMID, 9);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 10);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

