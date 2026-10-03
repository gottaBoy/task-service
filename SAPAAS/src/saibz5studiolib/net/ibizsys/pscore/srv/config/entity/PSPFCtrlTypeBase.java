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
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFCtrlTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFCtrlTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLCLASS = "CTRLCLASS";
    public static final String FIELD_CTRLDESC = "CTRLDESC";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSPFCTRLTYPEID = "PSPFCTRLTYPEID";
    public static final String FIELD_PSPFCTRLTYPENAME = "PSPFCTRLTYPENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLCLASS = 2;
    private static final int INDEX_CTRLDESC = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSCTRLTYPEID = 5;
    private static final int INDEX_PSCTRLTYPENAME = 6;
    private static final int INDEX_PSPFCTRLTYPEID = 7;
    private static final int INDEX_PSPFCTRLTYPENAME = 8;
    private static final int INDEX_PSPFID = 9;
    private static final int INDEX_PSPFNAME = 10;
    private static final int INDEX_PSPFSTYLEID = 11;
    private static final int INDEX_PSPFSTYLENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFCtrlTypeBase proxyPSPFCtrlTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlclassDirtyFlag = false;
    private boolean ctrldescDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean pspfctrltypeidDirtyFlag = false;
    private boolean pspfctrltypenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlclass")
    private String ctrlclass;
    @Column(name="ctrldesc")
    private String ctrldesc;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="pspfctrltypeid")
    private String pspfctrltypeid;
    @Column(name="pspfctrltypename")
    private String pspfctrltypename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setCtrlClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlclass = string;
        this.ctrlclassDirtyFlag = true;
    }

    public String getCtrlClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlClass();
        }
        return this.ctrlclass;
    }

    public boolean isCtrlClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlClassDirty();
        }
        return this.ctrlclassDirtyFlag;
    }

    public void resetCtrlClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlClass();
            return;
        }
        this.ctrlclassDirtyFlag = false;
        this.ctrlclass = null;
    }

    public void setCtrlDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrldesc = string;
        this.ctrldescDirtyFlag = true;
    }

    public String getCtrlDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlDesc();
        }
        return this.ctrldesc;
    }

    public boolean isCtrlDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlDescDirty();
        }
        return this.ctrldescDirtyFlag;
    }

    public void resetCtrlDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlDesc();
            return;
        }
        this.ctrldescDirtyFlag = false;
        this.ctrldesc = null;
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

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setPSPFCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltypeid = string;
        this.pspfctrltypeidDirtyFlag = true;
    }

    public String getPSPFCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTypeId();
        }
        return this.pspfctrltypeid;
    }

    public boolean isPSPFCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTypeIdDirty();
        }
        return this.pspfctrltypeidDirtyFlag;
    }

    public void resetPSPFCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTypeId();
            return;
        }
        this.pspfctrltypeidDirtyFlag = false;
        this.pspfctrltypeid = null;
    }

    public void setPSPFCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfctrltypename = string;
        this.pspfctrltypenameDirtyFlag = true;
    }

    public String getPSPFCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCtrlTypeName();
        }
        return this.pspfctrltypename;
    }

    public boolean isPSPFCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCtrlTypeNameDirty();
        }
        return this.pspfctrltypenameDirtyFlag;
    }

    public void resetPSPFCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCtrlTypeName();
            return;
        }
        this.pspfctrltypenameDirtyFlag = false;
        this.pspfctrltypename = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstyleid = string;
        this.pspfstyleidDirtyFlag = true;
    }

    public String getPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleId();
        }
        return this.pspfstyleid;
    }

    public boolean isPSPFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleIdDirty();
        }
        return this.pspfstyleidDirtyFlag;
    }

    public void resetPSPFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleId();
            return;
        }
        this.pspfstyleidDirtyFlag = false;
        this.pspfstyleid = null;
    }

    public void setPSPFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfstylename = string;
        this.pspfstylenameDirtyFlag = true;
    }

    public String getPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyleName();
        }
        return this.pspfstylename;
    }

    public boolean isPSPFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFStyleNameDirty();
        }
        return this.pspfstylenameDirtyFlag;
    }

    public void resetPSPFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFStyleName();
            return;
        }
        this.pspfstylenameDirtyFlag = false;
        this.pspfstylename = null;
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
        PSPFCtrlTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFCtrlTypeBase pSPFCtrlTypeBase) {
        pSPFCtrlTypeBase.resetCreateDate();
        pSPFCtrlTypeBase.resetCreateMan();
        pSPFCtrlTypeBase.resetCtrlClass();
        pSPFCtrlTypeBase.resetCtrlDesc();
        pSPFCtrlTypeBase.resetMemo();
        pSPFCtrlTypeBase.resetPSCtrlTypeId();
        pSPFCtrlTypeBase.resetPSCtrlTypeName();
        pSPFCtrlTypeBase.resetPSPFCtrlTypeId();
        pSPFCtrlTypeBase.resetPSPFCtrlTypeName();
        pSPFCtrlTypeBase.resetPSPFId();
        pSPFCtrlTypeBase.resetPSPFName();
        pSPFCtrlTypeBase.resetPSPFStyleId();
        pSPFCtrlTypeBase.resetPSPFStyleName();
        pSPFCtrlTypeBase.resetUpdateDate();
        pSPFCtrlTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlClassDirty()) {
            hashMap.put(FIELD_CTRLCLASS, this.getCtrlClass());
        }
        if (!bl || this.isCtrlDescDirty()) {
            hashMap.put(FIELD_CTRLDESC, this.getCtrlDesc());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSPFCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSPFCTRLTYPEID, this.getPSPFCtrlTypeId());
        }
        if (!bl || this.isPSPFCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSPFCTRLTYPENAME, this.getPSPFCtrlTypeName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFStyleIdDirty()) {
            hashMap.put(FIELD_PSPFSTYLEID, this.getPSPFStyleId());
        }
        if (!bl || this.isPSPFStyleNameDirty()) {
            hashMap.put(FIELD_PSPFSTYLENAME, this.getPSPFStyleName());
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
        return PSPFCtrlTypeBase.get(this, n);
    }

    private static Object get(PSPFCtrlTypeBase pSPFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTypeBase.getCreateDate();
            }
            case 1: {
                return pSPFCtrlTypeBase.getCreateMan();
            }
            case 2: {
                return pSPFCtrlTypeBase.getCtrlClass();
            }
            case 3: {
                return pSPFCtrlTypeBase.getCtrlDesc();
            }
            case 4: {
                return pSPFCtrlTypeBase.getMemo();
            }
            case 5: {
                return pSPFCtrlTypeBase.getPSCtrlTypeId();
            }
            case 6: {
                return pSPFCtrlTypeBase.getPSCtrlTypeName();
            }
            case 7: {
                return pSPFCtrlTypeBase.getPSPFCtrlTypeId();
            }
            case 8: {
                return pSPFCtrlTypeBase.getPSPFCtrlTypeName();
            }
            case 9: {
                return pSPFCtrlTypeBase.getPSPFId();
            }
            case 10: {
                return pSPFCtrlTypeBase.getPSPFName();
            }
            case 11: {
                return pSPFCtrlTypeBase.getPSPFStyleId();
            }
            case 12: {
                return pSPFCtrlTypeBase.getPSPFStyleName();
            }
            case 13: {
                return pSPFCtrlTypeBase.getUpdateDate();
            }
            case 14: {
                return pSPFCtrlTypeBase.getUpdateMan();
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
        PSPFCtrlTypeBase.set(this, n, object);
    }

    private static void set(PSPFCtrlTypeBase pSPFCtrlTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFCtrlTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFCtrlTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFCtrlTypeBase.setCtrlClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFCtrlTypeBase.setCtrlDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFCtrlTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFCtrlTypeBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFCtrlTypeBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFCtrlTypeBase.setPSPFCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFCtrlTypeBase.setPSPFCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFCtrlTypeBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFCtrlTypeBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFCtrlTypeBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFCtrlTypeBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFCtrlTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFCtrlTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFCtrlTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFCtrlTypeBase pSPFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFCtrlTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFCtrlTypeBase.getCtrlClass() == null;
            }
            case 3: {
                return pSPFCtrlTypeBase.getCtrlDesc() == null;
            }
            case 4: {
                return pSPFCtrlTypeBase.getMemo() == null;
            }
            case 5: {
                return pSPFCtrlTypeBase.getPSCtrlTypeId() == null;
            }
            case 6: {
                return pSPFCtrlTypeBase.getPSCtrlTypeName() == null;
            }
            case 7: {
                return pSPFCtrlTypeBase.getPSPFCtrlTypeId() == null;
            }
            case 8: {
                return pSPFCtrlTypeBase.getPSPFCtrlTypeName() == null;
            }
            case 9: {
                return pSPFCtrlTypeBase.getPSPFId() == null;
            }
            case 10: {
                return pSPFCtrlTypeBase.getPSPFName() == null;
            }
            case 11: {
                return pSPFCtrlTypeBase.getPSPFStyleId() == null;
            }
            case 12: {
                return pSPFCtrlTypeBase.getPSPFStyleName() == null;
            }
            case 13: {
                return pSPFCtrlTypeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPFCtrlTypeBase.getUpdateMan() == null;
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
        return PSPFCtrlTypeBase.contains(this, n);
    }

    private static boolean contains(PSPFCtrlTypeBase pSPFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCtrlTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFCtrlTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPFCtrlTypeBase.isCtrlClassDirty();
            }
            case 3: {
                return pSPFCtrlTypeBase.isCtrlDescDirty();
            }
            case 4: {
                return pSPFCtrlTypeBase.isMemoDirty();
            }
            case 5: {
                return pSPFCtrlTypeBase.isPSCtrlTypeIdDirty();
            }
            case 6: {
                return pSPFCtrlTypeBase.isPSCtrlTypeNameDirty();
            }
            case 7: {
                return pSPFCtrlTypeBase.isPSPFCtrlTypeIdDirty();
            }
            case 8: {
                return pSPFCtrlTypeBase.isPSPFCtrlTypeNameDirty();
            }
            case 9: {
                return pSPFCtrlTypeBase.isPSPFIdDirty();
            }
            case 10: {
                return pSPFCtrlTypeBase.isPSPFNameDirty();
            }
            case 11: {
                return pSPFCtrlTypeBase.isPSPFStyleIdDirty();
            }
            case 12: {
                return pSPFCtrlTypeBase.isPSPFStyleNameDirty();
            }
            case 13: {
                return pSPFCtrlTypeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPFCtrlTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFCtrlTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFCtrlTypeBase pSPFCtrlTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFCtrlTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getCtrlClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlclass", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getCtrlClass()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getCtrlDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrldesc", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getCtrlDesc()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltypeid", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFCtrlTypeId()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfctrltypename", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFCtrlTypeName()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFCtrlTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFCtrlTypeBase.getJSONValue((Object)pSPFCtrlTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFCtrlTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFCtrlTypeBase pSPFCtrlTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFCtrlTypeBase.getCreateDate() != null) {
            object = pSPFCtrlTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCtrlTypeBase.getCreateMan() != null) {
            object = pSPFCtrlTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getCtrlClass() != null) {
            object = pSPFCtrlTypeBase.getCtrlClass();
            xmlNode.setAttribute(FIELD_CTRLCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getCtrlDesc() != null) {
            object = pSPFCtrlTypeBase.getCtrlDesc();
            xmlNode.setAttribute(FIELD_CTRLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getMemo() != null) {
            object = pSPFCtrlTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSCtrlTypeId() != null) {
            object = pSPFCtrlTypeBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSCtrlTypeName() != null) {
            object = pSPFCtrlTypeBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeId() != null) {
            object = pSPFCtrlTypeBase.getPSPFCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSPFCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeName() != null) {
            object = pSPFCtrlTypeBase.getPSPFCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSPFCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFId() != null) {
            object = pSPFCtrlTypeBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFName() != null) {
            object = pSPFCtrlTypeBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFStyleId() != null) {
            object = pSPFCtrlTypeBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getPSPFStyleName() != null) {
            object = pSPFCtrlTypeBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCtrlTypeBase.getUpdateDate() != null) {
            object = pSPFCtrlTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCtrlTypeBase.getUpdateMan() != null) {
            object = pSPFCtrlTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFCtrlTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFCtrlTypeBase pSPFCtrlTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFCtrlTypeBase.isCreateDateDirty() && (bl || pSPFCtrlTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFCtrlTypeBase.getCreateDate());
        }
        if (pSPFCtrlTypeBase.isCreateManDirty() && (bl || pSPFCtrlTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFCtrlTypeBase.getCreateMan());
        }
        if (pSPFCtrlTypeBase.isCtrlClassDirty() && (bl || pSPFCtrlTypeBase.getCtrlClass() != null)) {
            iDataObject.set(FIELD_CTRLCLASS, (Object)pSPFCtrlTypeBase.getCtrlClass());
        }
        if (pSPFCtrlTypeBase.isCtrlDescDirty() && (bl || pSPFCtrlTypeBase.getCtrlDesc() != null)) {
            iDataObject.set(FIELD_CTRLDESC, (Object)pSPFCtrlTypeBase.getCtrlDesc());
        }
        if (pSPFCtrlTypeBase.isMemoDirty() && (bl || pSPFCtrlTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFCtrlTypeBase.getMemo());
        }
        if (pSPFCtrlTypeBase.isPSCtrlTypeIdDirty() && (bl || pSPFCtrlTypeBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSPFCtrlTypeBase.getPSCtrlTypeId());
        }
        if (pSPFCtrlTypeBase.isPSCtrlTypeNameDirty() && (bl || pSPFCtrlTypeBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSPFCtrlTypeBase.getPSCtrlTypeName());
        }
        if (pSPFCtrlTypeBase.isPSPFCtrlTypeIdDirty() && (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTYPEID, (Object)pSPFCtrlTypeBase.getPSPFCtrlTypeId());
        }
        if (pSPFCtrlTypeBase.isPSPFCtrlTypeNameDirty() && (bl || pSPFCtrlTypeBase.getPSPFCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSPFCTRLTYPENAME, (Object)pSPFCtrlTypeBase.getPSPFCtrlTypeName());
        }
        if (pSPFCtrlTypeBase.isPSPFIdDirty() && (bl || pSPFCtrlTypeBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFCtrlTypeBase.getPSPFId());
        }
        if (pSPFCtrlTypeBase.isPSPFNameDirty() && (bl || pSPFCtrlTypeBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFCtrlTypeBase.getPSPFName());
        }
        if (pSPFCtrlTypeBase.isPSPFStyleIdDirty() && (bl || pSPFCtrlTypeBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFCtrlTypeBase.getPSPFStyleId());
        }
        if (pSPFCtrlTypeBase.isPSPFStyleNameDirty() && (bl || pSPFCtrlTypeBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFCtrlTypeBase.getPSPFStyleName());
        }
        if (pSPFCtrlTypeBase.isUpdateDateDirty() && (bl || pSPFCtrlTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFCtrlTypeBase.getUpdateDate());
        }
        if (pSPFCtrlTypeBase.isUpdateManDirty() && (bl || pSPFCtrlTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFCtrlTypeBase.getUpdateMan());
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
        return PSPFCtrlTypeBase.remove(this, n);
    }

    private static boolean remove(PSPFCtrlTypeBase pSPFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFCtrlTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFCtrlTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFCtrlTypeBase.resetCtrlClass();
                return true;
            }
            case 3: {
                pSPFCtrlTypeBase.resetCtrlDesc();
                return true;
            }
            case 4: {
                pSPFCtrlTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSPFCtrlTypeBase.resetPSCtrlTypeId();
                return true;
            }
            case 6: {
                pSPFCtrlTypeBase.resetPSCtrlTypeName();
                return true;
            }
            case 7: {
                pSPFCtrlTypeBase.resetPSPFCtrlTypeId();
                return true;
            }
            case 8: {
                pSPFCtrlTypeBase.resetPSPFCtrlTypeName();
                return true;
            }
            case 9: {
                pSPFCtrlTypeBase.resetPSPFId();
                return true;
            }
            case 10: {
                pSPFCtrlTypeBase.resetPSPFName();
                return true;
            }
            case 11: {
                pSPFCtrlTypeBase.resetPSPFStyleId();
                return true;
            }
            case 12: {
                pSPFCtrlTypeBase.resetPSPFStyleName();
                return true;
            }
            case 13: {
                pSPFCtrlTypeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPFCtrlTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlType getPSCtrlType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlType();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlTypeLock;
        synchronized (n) {
            if (this.psctrltype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlTypeId(), (Object)this.psctrltype.getPSCtrlTypeId()) != 0L) {
                this.psctrltype = null;
            }
            if (this.psctrltype == null) {
                PSCtrlType pSCtrlType = new PSCtrlType();
                pSCtrlType.setPSCtrlTypeId(this.getPSCtrlTypeId());
                PSCtrlTypeService pSCtrlTypeService = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlTypeService.autoGet(pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFStyle getPSPFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFStyle();
        }
        if (this.getPSPFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSPFStyleLock;
        synchronized (n) {
            if (this.pspfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFStyleId(), (Object)this.pspfstyle.getPSPFStyleId()) != 0L) {
                this.pspfstyle = null;
            }
            if (this.pspfstyle == null) {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(this.getPSPFStyleId());
                PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSPFStyleService.autoGet(pSPFStyle);
                this.pspfstyle = pSPFStyle;
            }
            return this.pspfstyle;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSPFCtrlTypeBase getProxyEntity() {
        return this.proxyPSPFCtrlTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFCtrlTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFCtrlTypeBase) {
            this.proxyPSPFCtrlTypeBase = (PSPFCtrlTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLCLASS, 2);
        fieldIndexMap.put(FIELD_CTRLDESC, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSPFCTRLTYPEID, 7);
        fieldIndexMap.put(FIELD_PSPFCTRLTYPENAME, 8);
        fieldIndexMap.put(FIELD_PSPFID, 9);
        fieldIndexMap.put(FIELD_PSPFNAME, 10);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 11);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

