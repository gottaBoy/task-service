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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFCtrlTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFCtrlTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLDESC = "CTRLDESC";
    public static final String FIELD_HANDLERCLASS = "HANDLERCLASS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELCLASS = "MODELCLASS";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSSFCTRLTYPEID = "PSSFCTRLTYPEID";
    public static final String FIELD_PSSFCTRLTYPENAME = "PSSFCTRLTYPENAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CTRLDESC = 2;
    private static final int INDEX_HANDLERCLASS = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODELCLASS = 5;
    private static final int INDEX_PSCTRLTYPEID = 6;
    private static final int INDEX_PSCTRLTYPENAME = 7;
    private static final int INDEX_PSSFCTRLTYPEID = 8;
    private static final int INDEX_PSSFCTRLTYPENAME = 9;
    private static final int INDEX_PSSFID = 10;
    private static final int INDEX_PSSFNAME = 11;
    private static final int INDEX_PSSFSTYLEID = 12;
    private static final int INDEX_PSSFSTYLENAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFCtrlTypeBase proxyPSSFCtrlTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrldescDirtyFlag = false;
    private boolean handlerclassDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelclassDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean pssfctrltypeidDirtyFlag = false;
    private boolean pssfctrltypenameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrldesc")
    private String ctrldesc;
    @Column(name="handlerclass")
    private String handlerclass;
    @Column(name="memo")
    private String memo;
    @Column(name="modelclass")
    private String modelclass;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="pssfctrltypeid")
    private String pssfctrltypeid;
    @Column(name="pssfctrltypename")
    private String pssfctrltypename;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setHandlerClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerclass = string;
        this.handlerclassDirtyFlag = true;
    }

    public String getHandlerClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerClass();
        }
        return this.handlerclass;
    }

    public boolean isHandlerClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerClassDirty();
        }
        return this.handlerclassDirtyFlag;
    }

    public void resetHandlerClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerClass();
            return;
        }
        this.handlerclassDirtyFlag = false;
        this.handlerclass = null;
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

    public void setModelClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelclass = string;
        this.modelclassDirtyFlag = true;
    }

    public String getModelClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelClass();
        }
        return this.modelclass;
    }

    public boolean isModelClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelClassDirty();
        }
        return this.modelclassDirtyFlag;
    }

    public void resetModelClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelClass();
            return;
        }
        this.modelclassDirtyFlag = false;
        this.modelclass = null;
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

    public void setPSSFCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfctrltypeid = string;
        this.pssfctrltypeidDirtyFlag = true;
    }

    public String getPSSFCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCtrlTypeId();
        }
        return this.pssfctrltypeid;
    }

    public boolean isPSSFCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCtrlTypeIdDirty();
        }
        return this.pssfctrltypeidDirtyFlag;
    }

    public void resetPSSFCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCtrlTypeId();
            return;
        }
        this.pssfctrltypeidDirtyFlag = false;
        this.pssfctrltypeid = null;
    }

    public void setPSSFCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfctrltypename = string;
        this.pssfctrltypenameDirtyFlag = true;
    }

    public String getPSSFCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFCtrlTypeName();
        }
        return this.pssfctrltypename;
    }

    public boolean isPSSFCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFCtrlTypeNameDirty();
        }
        return this.pssfctrltypenameDirtyFlag;
    }

    public void resetPSSFCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFCtrlTypeName();
            return;
        }
        this.pssfctrltypenameDirtyFlag = false;
        this.pssfctrltypename = null;
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

    public void setPSSFStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstyleid = string;
        this.pssfstyleidDirtyFlag = true;
    }

    public String getPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleId();
        }
        return this.pssfstyleid;
    }

    public boolean isPSSFStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleIdDirty();
        }
        return this.pssfstyleidDirtyFlag;
    }

    public void resetPSSFStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleId();
            return;
        }
        this.pssfstyleidDirtyFlag = false;
        this.pssfstyleid = null;
    }

    public void setPSSFStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfstylename = string;
        this.pssfstylenameDirtyFlag = true;
    }

    public String getPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyleName();
        }
        return this.pssfstylename;
    }

    public boolean isPSSFStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFStyleNameDirty();
        }
        return this.pssfstylenameDirtyFlag;
    }

    public void resetPSSFStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFStyleName();
            return;
        }
        this.pssfstylenameDirtyFlag = false;
        this.pssfstylename = null;
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
        PSSFCtrlTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFCtrlTypeBase pSSFCtrlTypeBase) {
        pSSFCtrlTypeBase.resetCreateDate();
        pSSFCtrlTypeBase.resetCreateMan();
        pSSFCtrlTypeBase.resetCtrlDesc();
        pSSFCtrlTypeBase.resetHandlerClass();
        pSSFCtrlTypeBase.resetMemo();
        pSSFCtrlTypeBase.resetModelClass();
        pSSFCtrlTypeBase.resetPSCtrlTypeId();
        pSSFCtrlTypeBase.resetPSCtrlTypeName();
        pSSFCtrlTypeBase.resetPSSFCtrlTypeId();
        pSSFCtrlTypeBase.resetPSSFCtrlTypeName();
        pSSFCtrlTypeBase.resetPSSFId();
        pSSFCtrlTypeBase.resetPSSFName();
        pSSFCtrlTypeBase.resetPSSFStyleId();
        pSSFCtrlTypeBase.resetPSSFStyleName();
        pSSFCtrlTypeBase.resetUpdateDate();
        pSSFCtrlTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlDescDirty()) {
            hashMap.put(FIELD_CTRLDESC, this.getCtrlDesc());
        }
        if (!bl || this.isHandlerClassDirty()) {
            hashMap.put(FIELD_HANDLERCLASS, this.getHandlerClass());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelClassDirty()) {
            hashMap.put(FIELD_MODELCLASS, this.getModelClass());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSSFCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSSFCTRLTYPEID, this.getPSSFCtrlTypeId());
        }
        if (!bl || this.isPSSFCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSSFCTRLTYPENAME, this.getPSSFCtrlTypeName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFStyleIdDirty()) {
            hashMap.put(FIELD_PSSFSTYLEID, this.getPSSFStyleId());
        }
        if (!bl || this.isPSSFStyleNameDirty()) {
            hashMap.put(FIELD_PSSFSTYLENAME, this.getPSSFStyleName());
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
        return PSSFCtrlTypeBase.get(this, n);
    }

    private static Object get(PSSFCtrlTypeBase pSSFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCtrlTypeBase.getCreateDate();
            }
            case 1: {
                return pSSFCtrlTypeBase.getCreateMan();
            }
            case 2: {
                return pSSFCtrlTypeBase.getCtrlDesc();
            }
            case 3: {
                return pSSFCtrlTypeBase.getHandlerClass();
            }
            case 4: {
                return pSSFCtrlTypeBase.getMemo();
            }
            case 5: {
                return pSSFCtrlTypeBase.getModelClass();
            }
            case 6: {
                return pSSFCtrlTypeBase.getPSCtrlTypeId();
            }
            case 7: {
                return pSSFCtrlTypeBase.getPSCtrlTypeName();
            }
            case 8: {
                return pSSFCtrlTypeBase.getPSSFCtrlTypeId();
            }
            case 9: {
                return pSSFCtrlTypeBase.getPSSFCtrlTypeName();
            }
            case 10: {
                return pSSFCtrlTypeBase.getPSSFId();
            }
            case 11: {
                return pSSFCtrlTypeBase.getPSSFName();
            }
            case 12: {
                return pSSFCtrlTypeBase.getPSSFStyleId();
            }
            case 13: {
                return pSSFCtrlTypeBase.getPSSFStyleName();
            }
            case 14: {
                return pSSFCtrlTypeBase.getUpdateDate();
            }
            case 15: {
                return pSSFCtrlTypeBase.getUpdateMan();
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
        PSSFCtrlTypeBase.set(this, n, object);
    }

    private static void set(PSSFCtrlTypeBase pSSFCtrlTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFCtrlTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFCtrlTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFCtrlTypeBase.setCtrlDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFCtrlTypeBase.setHandlerClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFCtrlTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFCtrlTypeBase.setModelClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFCtrlTypeBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFCtrlTypeBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFCtrlTypeBase.setPSSFCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFCtrlTypeBase.setPSSFCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFCtrlTypeBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFCtrlTypeBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFCtrlTypeBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFCtrlTypeBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSFCtrlTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSFCtrlTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFCtrlTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSFCtrlTypeBase pSSFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCtrlTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFCtrlTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFCtrlTypeBase.getCtrlDesc() == null;
            }
            case 3: {
                return pSSFCtrlTypeBase.getHandlerClass() == null;
            }
            case 4: {
                return pSSFCtrlTypeBase.getMemo() == null;
            }
            case 5: {
                return pSSFCtrlTypeBase.getModelClass() == null;
            }
            case 6: {
                return pSSFCtrlTypeBase.getPSCtrlTypeId() == null;
            }
            case 7: {
                return pSSFCtrlTypeBase.getPSCtrlTypeName() == null;
            }
            case 8: {
                return pSSFCtrlTypeBase.getPSSFCtrlTypeId() == null;
            }
            case 9: {
                return pSSFCtrlTypeBase.getPSSFCtrlTypeName() == null;
            }
            case 10: {
                return pSSFCtrlTypeBase.getPSSFId() == null;
            }
            case 11: {
                return pSSFCtrlTypeBase.getPSSFName() == null;
            }
            case 12: {
                return pSSFCtrlTypeBase.getPSSFStyleId() == null;
            }
            case 13: {
                return pSSFCtrlTypeBase.getPSSFStyleName() == null;
            }
            case 14: {
                return pSSFCtrlTypeBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSFCtrlTypeBase.getUpdateMan() == null;
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
        return PSSFCtrlTypeBase.contains(this, n);
    }

    private static boolean contains(PSSFCtrlTypeBase pSSFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFCtrlTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFCtrlTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSFCtrlTypeBase.isCtrlDescDirty();
            }
            case 3: {
                return pSSFCtrlTypeBase.isHandlerClassDirty();
            }
            case 4: {
                return pSSFCtrlTypeBase.isMemoDirty();
            }
            case 5: {
                return pSSFCtrlTypeBase.isModelClassDirty();
            }
            case 6: {
                return pSSFCtrlTypeBase.isPSCtrlTypeIdDirty();
            }
            case 7: {
                return pSSFCtrlTypeBase.isPSCtrlTypeNameDirty();
            }
            case 8: {
                return pSSFCtrlTypeBase.isPSSFCtrlTypeIdDirty();
            }
            case 9: {
                return pSSFCtrlTypeBase.isPSSFCtrlTypeNameDirty();
            }
            case 10: {
                return pSSFCtrlTypeBase.isPSSFIdDirty();
            }
            case 11: {
                return pSSFCtrlTypeBase.isPSSFNameDirty();
            }
            case 12: {
                return pSSFCtrlTypeBase.isPSSFStyleIdDirty();
            }
            case 13: {
                return pSSFCtrlTypeBase.isPSSFStyleNameDirty();
            }
            case 14: {
                return pSSFCtrlTypeBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSFCtrlTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFCtrlTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFCtrlTypeBase pSSFCtrlTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFCtrlTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getCtrlDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrldesc", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getCtrlDesc()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getHandlerClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerclass", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getHandlerClass()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getModelClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelclass", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getModelClass()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfctrltypeid", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFCtrlTypeId()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfctrltypename", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFCtrlTypeName()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFCtrlTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFCtrlTypeBase.getJSONValue((Object)pSSFCtrlTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFCtrlTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFCtrlTypeBase pSSFCtrlTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFCtrlTypeBase.getCreateDate() != null) {
            object = pSSFCtrlTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCtrlTypeBase.getCreateMan() != null) {
            object = pSSFCtrlTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getCtrlDesc() != null) {
            object = pSSFCtrlTypeBase.getCtrlDesc();
            xmlNode.setAttribute(FIELD_CTRLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getHandlerClass() != null) {
            object = pSSFCtrlTypeBase.getHandlerClass();
            xmlNode.setAttribute(FIELD_HANDLERCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getMemo() != null) {
            object = pSSFCtrlTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getModelClass() != null) {
            object = pSSFCtrlTypeBase.getModelClass();
            xmlNode.setAttribute(FIELD_MODELCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSCtrlTypeId() != null) {
            object = pSSFCtrlTypeBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSCtrlTypeName() != null) {
            object = pSSFCtrlTypeBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeId() != null) {
            object = pSSFCtrlTypeBase.getPSSFCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSSFCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeName() != null) {
            object = pSSFCtrlTypeBase.getPSSFCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSSFCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFId() != null) {
            object = pSSFCtrlTypeBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFName() != null) {
            object = pSSFCtrlTypeBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFStyleId() != null) {
            object = pSSFCtrlTypeBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getPSSFStyleName() != null) {
            object = pSSFCtrlTypeBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFCtrlTypeBase.getUpdateDate() != null) {
            object = pSSFCtrlTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFCtrlTypeBase.getUpdateMan() != null) {
            object = pSSFCtrlTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFCtrlTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFCtrlTypeBase pSSFCtrlTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFCtrlTypeBase.isCreateDateDirty() && (bl || pSSFCtrlTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFCtrlTypeBase.getCreateDate());
        }
        if (pSSFCtrlTypeBase.isCreateManDirty() && (bl || pSSFCtrlTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFCtrlTypeBase.getCreateMan());
        }
        if (pSSFCtrlTypeBase.isCtrlDescDirty() && (bl || pSSFCtrlTypeBase.getCtrlDesc() != null)) {
            iDataObject.set(FIELD_CTRLDESC, (Object)pSSFCtrlTypeBase.getCtrlDesc());
        }
        if (pSSFCtrlTypeBase.isHandlerClassDirty() && (bl || pSSFCtrlTypeBase.getHandlerClass() != null)) {
            iDataObject.set(FIELD_HANDLERCLASS, (Object)pSSFCtrlTypeBase.getHandlerClass());
        }
        if (pSSFCtrlTypeBase.isMemoDirty() && (bl || pSSFCtrlTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFCtrlTypeBase.getMemo());
        }
        if (pSSFCtrlTypeBase.isModelClassDirty() && (bl || pSSFCtrlTypeBase.getModelClass() != null)) {
            iDataObject.set(FIELD_MODELCLASS, (Object)pSSFCtrlTypeBase.getModelClass());
        }
        if (pSSFCtrlTypeBase.isPSCtrlTypeIdDirty() && (bl || pSSFCtrlTypeBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSSFCtrlTypeBase.getPSCtrlTypeId());
        }
        if (pSSFCtrlTypeBase.isPSCtrlTypeNameDirty() && (bl || pSSFCtrlTypeBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSSFCtrlTypeBase.getPSCtrlTypeName());
        }
        if (pSSFCtrlTypeBase.isPSSFCtrlTypeIdDirty() && (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSSFCTRLTYPEID, (Object)pSSFCtrlTypeBase.getPSSFCtrlTypeId());
        }
        if (pSSFCtrlTypeBase.isPSSFCtrlTypeNameDirty() && (bl || pSSFCtrlTypeBase.getPSSFCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSSFCTRLTYPENAME, (Object)pSSFCtrlTypeBase.getPSSFCtrlTypeName());
        }
        if (pSSFCtrlTypeBase.isPSSFIdDirty() && (bl || pSSFCtrlTypeBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFCtrlTypeBase.getPSSFId());
        }
        if (pSSFCtrlTypeBase.isPSSFNameDirty() && (bl || pSSFCtrlTypeBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFCtrlTypeBase.getPSSFName());
        }
        if (pSSFCtrlTypeBase.isPSSFStyleIdDirty() && (bl || pSSFCtrlTypeBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFCtrlTypeBase.getPSSFStyleId());
        }
        if (pSSFCtrlTypeBase.isPSSFStyleNameDirty() && (bl || pSSFCtrlTypeBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFCtrlTypeBase.getPSSFStyleName());
        }
        if (pSSFCtrlTypeBase.isUpdateDateDirty() && (bl || pSSFCtrlTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFCtrlTypeBase.getUpdateDate());
        }
        if (pSSFCtrlTypeBase.isUpdateManDirty() && (bl || pSSFCtrlTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFCtrlTypeBase.getUpdateMan());
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
        return PSSFCtrlTypeBase.remove(this, n);
    }

    private static boolean remove(PSSFCtrlTypeBase pSSFCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFCtrlTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFCtrlTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFCtrlTypeBase.resetCtrlDesc();
                return true;
            }
            case 3: {
                pSSFCtrlTypeBase.resetHandlerClass();
                return true;
            }
            case 4: {
                pSSFCtrlTypeBase.resetMemo();
                return true;
            }
            case 5: {
                pSSFCtrlTypeBase.resetModelClass();
                return true;
            }
            case 6: {
                pSSFCtrlTypeBase.resetPSCtrlTypeId();
                return true;
            }
            case 7: {
                pSSFCtrlTypeBase.resetPSCtrlTypeName();
                return true;
            }
            case 8: {
                pSSFCtrlTypeBase.resetPSSFCtrlTypeId();
                return true;
            }
            case 9: {
                pSSFCtrlTypeBase.resetPSSFCtrlTypeName();
                return true;
            }
            case 10: {
                pSSFCtrlTypeBase.resetPSSFId();
                return true;
            }
            case 11: {
                pSSFCtrlTypeBase.resetPSSFName();
                return true;
            }
            case 12: {
                pSSFCtrlTypeBase.resetPSSFStyleId();
                return true;
            }
            case 13: {
                pSSFCtrlTypeBase.resetPSSFStyleName();
                return true;
            }
            case 14: {
                pSSFCtrlTypeBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSFCtrlTypeBase.resetUpdateMan();
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
    public PSSFStyle getPSSFStyle() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFStyle();
        }
        if (this.getPSSFStyleId() == null) {
            return null;
        }
        Integer n = this.objPSSFStyleLock;
        synchronized (n) {
            if (this.pssfstyle != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFStyleId(), (Object)this.pssfstyle.getPSSFStyleId()) != 0L) {
                this.pssfstyle = null;
            }
            if (this.pssfstyle == null) {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(this.getPSSFStyleId());
                PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                pSSFStyleService.autoGet(pSSFStyle);
                this.pssfstyle = pSSFStyle;
            }
            return this.pssfstyle;
        }
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

    private PSSFCtrlTypeBase getProxyEntity() {
        return this.proxyPSSFCtrlTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFCtrlTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFCtrlTypeBase) {
            this.proxyPSSFCtrlTypeBase = (PSSFCtrlTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCtrlTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CTRLDESC, 2);
        fieldIndexMap.put(FIELD_HANDLERCLASS, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODELCLASS, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 7);
        fieldIndexMap.put(FIELD_PSSFCTRLTYPEID, 8);
        fieldIndexMap.put(FIELD_PSSFCTRLTYPENAME, 9);
        fieldIndexMap.put(FIELD_PSSFID, 10);
        fieldIndexMap.put(FIELD_PSSFNAME, 11);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 12);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

