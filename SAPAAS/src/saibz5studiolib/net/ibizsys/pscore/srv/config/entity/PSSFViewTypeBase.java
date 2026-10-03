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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFViewTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFViewTypeBase.class);
    public static final String FIELD_CONTROLLERCLASS = "CONTROLLERCLASS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELCLASS = "MODELCLASS";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String FIELD_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String FIELD_PSSFVIEWTYPEID = "PSSFVIEWTYPEID";
    public static final String FIELD_PSSFVIEWTYPENAME = "PSSFVIEWTYPENAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWCLASS = "VIEWCLASS";
    public static final String FIELD_VIEWDESC = "VIEWDESC";
    private static final int INDEX_CONTROLLERCLASS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MODELCLASS = 4;
    private static final int INDEX_PSSFID = 5;
    private static final int INDEX_PSSFNAME = 6;
    private static final int INDEX_PSSFSTYLEID = 7;
    private static final int INDEX_PSSFSTYLENAME = 8;
    private static final int INDEX_PSSFVIEWTYPEID = 9;
    private static final int INDEX_PSSFVIEWTYPENAME = 10;
    private static final int INDEX_PSVIEWTYPEID = 11;
    private static final int INDEX_PSVIEWTYPENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VIEWCLASS = 15;
    private static final int INDEX_VIEWDESC = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFViewTypeBase proxyPSSFViewTypeBase = null;
    private boolean controllerclassDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelclassDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfstyleidDirtyFlag = false;
    private boolean pssfstylenameDirtyFlag = false;
    private boolean pssfviewtypeidDirtyFlag = false;
    private boolean pssfviewtypenameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewclassDirtyFlag = false;
    private boolean viewdescDirtyFlag = false;
    @Column(name="controllerclass")
    private String controllerclass;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="modelclass")
    private String modelclass;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfstyleid")
    private String pssfstyleid;
    @Column(name="pssfstylename")
    private String pssfstylename;
    @Column(name="pssfviewtypeid")
    private String pssfviewtypeid;
    @Column(name="pssfviewtypename")
    private String pssfviewtypename;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewclass")
    private String viewclass;
    @Column(name="viewdesc")
    private String viewdesc;
    private Integer objPSSFStyleLock = new Integer(1);
    private PSSFStyle pssfstyle = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

    public void setControllerClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setControllerClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.controllerclass = string;
        this.controllerclassDirtyFlag = true;
    }

    public String getControllerClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getControllerClass();
        }
        return this.controllerclass;
    }

    public boolean isControllerClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isControllerClassDirty();
        }
        return this.controllerclassDirtyFlag;
    }

    public void resetControllerClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetControllerClass();
            return;
        }
        this.controllerclassDirtyFlag = false;
        this.controllerclass = null;
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

    public void setPSSFViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfviewtypeid = string;
        this.pssfviewtypeidDirtyFlag = true;
    }

    public String getPSSFViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFViewTypeId();
        }
        return this.pssfviewtypeid;
    }

    public boolean isPSSFViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFViewTypeIdDirty();
        }
        return this.pssfviewtypeidDirtyFlag;
    }

    public void resetPSSFViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFViewTypeId();
            return;
        }
        this.pssfviewtypeidDirtyFlag = false;
        this.pssfviewtypeid = null;
    }

    public void setPSSFViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfviewtypename = string;
        this.pssfviewtypenameDirtyFlag = true;
    }

    public String getPSSFViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFViewTypeName();
        }
        return this.pssfviewtypename;
    }

    public boolean isPSSFViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFViewTypeNameDirty();
        }
        return this.pssfviewtypenameDirtyFlag;
    }

    public void resetPSSFViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFViewTypeName();
            return;
        }
        this.pssfviewtypenameDirtyFlag = false;
        this.pssfviewtypename = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
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

    public void setViewClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewclass = string;
        this.viewclassDirtyFlag = true;
    }

    public String getViewClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewClass();
        }
        return this.viewclass;
    }

    public boolean isViewClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewClassDirty();
        }
        return this.viewclassDirtyFlag;
    }

    public void resetViewClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewClass();
            return;
        }
        this.viewclassDirtyFlag = false;
        this.viewclass = null;
    }

    public void setViewDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewdesc = string;
        this.viewdescDirtyFlag = true;
    }

    public String getViewDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewDesc();
        }
        return this.viewdesc;
    }

    public boolean isViewDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewDescDirty();
        }
        return this.viewdescDirtyFlag;
    }

    public void resetViewDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewDesc();
            return;
        }
        this.viewdescDirtyFlag = false;
        this.viewdesc = null;
    }

    protected void onReset() {
        PSSFViewTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFViewTypeBase pSSFViewTypeBase) {
        pSSFViewTypeBase.resetControllerClass();
        pSSFViewTypeBase.resetCreateDate();
        pSSFViewTypeBase.resetCreateMan();
        pSSFViewTypeBase.resetMemo();
        pSSFViewTypeBase.resetModelClass();
        pSSFViewTypeBase.resetPSSFId();
        pSSFViewTypeBase.resetPSSFName();
        pSSFViewTypeBase.resetPSSFStyleId();
        pSSFViewTypeBase.resetPSSFStyleName();
        pSSFViewTypeBase.resetPSSFViewTypeId();
        pSSFViewTypeBase.resetPSSFViewTypeName();
        pSSFViewTypeBase.resetPSViewTypeId();
        pSSFViewTypeBase.resetPSViewTypeName();
        pSSFViewTypeBase.resetUpdateDate();
        pSSFViewTypeBase.resetUpdateMan();
        pSSFViewTypeBase.resetViewClass();
        pSSFViewTypeBase.resetViewDesc();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isControllerClassDirty()) {
            hashMap.put(FIELD_CONTROLLERCLASS, this.getControllerClass());
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
        if (!bl || this.isModelClassDirty()) {
            hashMap.put(FIELD_MODELCLASS, this.getModelClass());
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
        if (!bl || this.isPSSFViewTypeIdDirty()) {
            hashMap.put(FIELD_PSSFVIEWTYPEID, this.getPSSFViewTypeId());
        }
        if (!bl || this.isPSSFViewTypeNameDirty()) {
            hashMap.put(FIELD_PSSFVIEWTYPENAME, this.getPSSFViewTypeName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isViewClassDirty()) {
            hashMap.put(FIELD_VIEWCLASS, this.getViewClass());
        }
        if (!bl || this.isViewDescDirty()) {
            hashMap.put(FIELD_VIEWDESC, this.getViewDesc());
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
        return PSSFViewTypeBase.get(this, n);
    }

    private static Object get(PSSFViewTypeBase pSSFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFViewTypeBase.getControllerClass();
            }
            case 1: {
                return pSSFViewTypeBase.getCreateDate();
            }
            case 2: {
                return pSSFViewTypeBase.getCreateMan();
            }
            case 3: {
                return pSSFViewTypeBase.getMemo();
            }
            case 4: {
                return pSSFViewTypeBase.getModelClass();
            }
            case 5: {
                return pSSFViewTypeBase.getPSSFId();
            }
            case 6: {
                return pSSFViewTypeBase.getPSSFName();
            }
            case 7: {
                return pSSFViewTypeBase.getPSSFStyleId();
            }
            case 8: {
                return pSSFViewTypeBase.getPSSFStyleName();
            }
            case 9: {
                return pSSFViewTypeBase.getPSSFViewTypeId();
            }
            case 10: {
                return pSSFViewTypeBase.getPSSFViewTypeName();
            }
            case 11: {
                return pSSFViewTypeBase.getPSViewTypeId();
            }
            case 12: {
                return pSSFViewTypeBase.getPSViewTypeName();
            }
            case 13: {
                return pSSFViewTypeBase.getUpdateDate();
            }
            case 14: {
                return pSSFViewTypeBase.getUpdateMan();
            }
            case 15: {
                return pSSFViewTypeBase.getViewClass();
            }
            case 16: {
                return pSSFViewTypeBase.getViewDesc();
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
        PSSFViewTypeBase.set(this, n, object);
    }

    private static void set(PSSFViewTypeBase pSSFViewTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFViewTypeBase.setControllerClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSFViewTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSFViewTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFViewTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFViewTypeBase.setModelClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFViewTypeBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFViewTypeBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFViewTypeBase.setPSSFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFViewTypeBase.setPSSFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFViewTypeBase.setPSSFViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFViewTypeBase.setPSSFViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFViewTypeBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSFViewTypeBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSFViewTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSSFViewTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSFViewTypeBase.setViewClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSFViewTypeBase.setViewDesc(DataObject.getStringValue((Object)object));
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
        return PSSFViewTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSFViewTypeBase pSSFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFViewTypeBase.getControllerClass() == null;
            }
            case 1: {
                return pSSFViewTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSFViewTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSFViewTypeBase.getMemo() == null;
            }
            case 4: {
                return pSSFViewTypeBase.getModelClass() == null;
            }
            case 5: {
                return pSSFViewTypeBase.getPSSFId() == null;
            }
            case 6: {
                return pSSFViewTypeBase.getPSSFName() == null;
            }
            case 7: {
                return pSSFViewTypeBase.getPSSFStyleId() == null;
            }
            case 8: {
                return pSSFViewTypeBase.getPSSFStyleName() == null;
            }
            case 9: {
                return pSSFViewTypeBase.getPSSFViewTypeId() == null;
            }
            case 10: {
                return pSSFViewTypeBase.getPSSFViewTypeName() == null;
            }
            case 11: {
                return pSSFViewTypeBase.getPSViewTypeId() == null;
            }
            case 12: {
                return pSSFViewTypeBase.getPSViewTypeName() == null;
            }
            case 13: {
                return pSSFViewTypeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSSFViewTypeBase.getUpdateMan() == null;
            }
            case 15: {
                return pSSFViewTypeBase.getViewClass() == null;
            }
            case 16: {
                return pSSFViewTypeBase.getViewDesc() == null;
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
        return PSSFViewTypeBase.contains(this, n);
    }

    private static boolean contains(PSSFViewTypeBase pSSFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFViewTypeBase.isControllerClassDirty();
            }
            case 1: {
                return pSSFViewTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSFViewTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSSFViewTypeBase.isMemoDirty();
            }
            case 4: {
                return pSSFViewTypeBase.isModelClassDirty();
            }
            case 5: {
                return pSSFViewTypeBase.isPSSFIdDirty();
            }
            case 6: {
                return pSSFViewTypeBase.isPSSFNameDirty();
            }
            case 7: {
                return pSSFViewTypeBase.isPSSFStyleIdDirty();
            }
            case 8: {
                return pSSFViewTypeBase.isPSSFStyleNameDirty();
            }
            case 9: {
                return pSSFViewTypeBase.isPSSFViewTypeIdDirty();
            }
            case 10: {
                return pSSFViewTypeBase.isPSSFViewTypeNameDirty();
            }
            case 11: {
                return pSSFViewTypeBase.isPSViewTypeIdDirty();
            }
            case 12: {
                return pSSFViewTypeBase.isPSViewTypeNameDirty();
            }
            case 13: {
                return pSSFViewTypeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSSFViewTypeBase.isUpdateManDirty();
            }
            case 15: {
                return pSSFViewTypeBase.isViewClassDirty();
            }
            case 16: {
                return pSSFViewTypeBase.isViewDescDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFViewTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFViewTypeBase pSSFViewTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFViewTypeBase.getControllerClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"controllerclass", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getControllerClass()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getModelClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelclass", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getModelClass()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstyleid", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFStyleId()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfstylename", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFStyleName()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfviewtypeid", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFViewTypeId()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSSFViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfviewtypename", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSSFViewTypeName()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getViewClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewclass", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getViewClass()), (boolean)false);
        }
        if (bl || pSSFViewTypeBase.getViewDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewdesc", (Object)PSSFViewTypeBase.getJSONValue((Object)pSSFViewTypeBase.getViewDesc()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFViewTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFViewTypeBase pSSFViewTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFViewTypeBase.getControllerClass() != null) {
            object = pSSFViewTypeBase.getControllerClass();
            xmlNode.setAttribute(FIELD_CONTROLLERCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getCreateDate() != null) {
            object = pSSFViewTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFViewTypeBase.getCreateMan() != null) {
            object = pSSFViewTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getMemo() != null) {
            object = pSSFViewTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getModelClass() != null) {
            object = pSSFViewTypeBase.getModelClass();
            xmlNode.setAttribute(FIELD_MODELCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFId() != null) {
            object = pSSFViewTypeBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFName() != null) {
            object = pSSFViewTypeBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFStyleId() != null) {
            object = pSSFViewTypeBase.getPSSFStyleId();
            xmlNode.setAttribute(FIELD_PSSFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFStyleName() != null) {
            object = pSSFViewTypeBase.getPSSFStyleName();
            xmlNode.setAttribute(FIELD_PSSFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFViewTypeId() != null) {
            object = pSSFViewTypeBase.getPSSFViewTypeId();
            xmlNode.setAttribute(FIELD_PSSFVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSSFViewTypeName() != null) {
            object = pSSFViewTypeBase.getPSSFViewTypeName();
            xmlNode.setAttribute(FIELD_PSSFVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSViewTypeId() != null) {
            object = pSSFViewTypeBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getPSViewTypeName() != null) {
            object = pSSFViewTypeBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getUpdateDate() != null) {
            object = pSSFViewTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFViewTypeBase.getUpdateMan() != null) {
            object = pSSFViewTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getViewClass() != null) {
            object = pSSFViewTypeBase.getViewClass();
            xmlNode.setAttribute(FIELD_VIEWCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSFViewTypeBase.getViewDesc() != null) {
            object = pSSFViewTypeBase.getViewDesc();
            xmlNode.setAttribute(FIELD_VIEWDESC, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFViewTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFViewTypeBase pSSFViewTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFViewTypeBase.isControllerClassDirty() && (bl || pSSFViewTypeBase.getControllerClass() != null)) {
            iDataObject.set(FIELD_CONTROLLERCLASS, (Object)pSSFViewTypeBase.getControllerClass());
        }
        if (pSSFViewTypeBase.isCreateDateDirty() && (bl || pSSFViewTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFViewTypeBase.getCreateDate());
        }
        if (pSSFViewTypeBase.isCreateManDirty() && (bl || pSSFViewTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFViewTypeBase.getCreateMan());
        }
        if (pSSFViewTypeBase.isMemoDirty() && (bl || pSSFViewTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFViewTypeBase.getMemo());
        }
        if (pSSFViewTypeBase.isModelClassDirty() && (bl || pSSFViewTypeBase.getModelClass() != null)) {
            iDataObject.set(FIELD_MODELCLASS, (Object)pSSFViewTypeBase.getModelClass());
        }
        if (pSSFViewTypeBase.isPSSFIdDirty() && (bl || pSSFViewTypeBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFViewTypeBase.getPSSFId());
        }
        if (pSSFViewTypeBase.isPSSFNameDirty() && (bl || pSSFViewTypeBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFViewTypeBase.getPSSFName());
        }
        if (pSSFViewTypeBase.isPSSFStyleIdDirty() && (bl || pSSFViewTypeBase.getPSSFStyleId() != null)) {
            iDataObject.set(FIELD_PSSFSTYLEID, (Object)pSSFViewTypeBase.getPSSFStyleId());
        }
        if (pSSFViewTypeBase.isPSSFStyleNameDirty() && (bl || pSSFViewTypeBase.getPSSFStyleName() != null)) {
            iDataObject.set(FIELD_PSSFSTYLENAME, (Object)pSSFViewTypeBase.getPSSFStyleName());
        }
        if (pSSFViewTypeBase.isPSSFViewTypeIdDirty() && (bl || pSSFViewTypeBase.getPSSFViewTypeId() != null)) {
            iDataObject.set(FIELD_PSSFVIEWTYPEID, (Object)pSSFViewTypeBase.getPSSFViewTypeId());
        }
        if (pSSFViewTypeBase.isPSSFViewTypeNameDirty() && (bl || pSSFViewTypeBase.getPSSFViewTypeName() != null)) {
            iDataObject.set(FIELD_PSSFVIEWTYPENAME, (Object)pSSFViewTypeBase.getPSSFViewTypeName());
        }
        if (pSSFViewTypeBase.isPSViewTypeIdDirty() && (bl || pSSFViewTypeBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSSFViewTypeBase.getPSViewTypeId());
        }
        if (pSSFViewTypeBase.isPSViewTypeNameDirty() && (bl || pSSFViewTypeBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSSFViewTypeBase.getPSViewTypeName());
        }
        if (pSSFViewTypeBase.isUpdateDateDirty() && (bl || pSSFViewTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFViewTypeBase.getUpdateDate());
        }
        if (pSSFViewTypeBase.isUpdateManDirty() && (bl || pSSFViewTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFViewTypeBase.getUpdateMan());
        }
        if (pSSFViewTypeBase.isViewClassDirty() && (bl || pSSFViewTypeBase.getViewClass() != null)) {
            iDataObject.set(FIELD_VIEWCLASS, (Object)pSSFViewTypeBase.getViewClass());
        }
        if (pSSFViewTypeBase.isViewDescDirty() && (bl || pSSFViewTypeBase.getViewDesc() != null)) {
            iDataObject.set(FIELD_VIEWDESC, (Object)pSSFViewTypeBase.getViewDesc());
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
        return PSSFViewTypeBase.remove(this, n);
    }

    private static boolean remove(PSSFViewTypeBase pSSFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFViewTypeBase.resetControllerClass();
                return true;
            }
            case 1: {
                pSSFViewTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSFViewTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSFViewTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFViewTypeBase.resetModelClass();
                return true;
            }
            case 5: {
                pSSFViewTypeBase.resetPSSFId();
                return true;
            }
            case 6: {
                pSSFViewTypeBase.resetPSSFName();
                return true;
            }
            case 7: {
                pSSFViewTypeBase.resetPSSFStyleId();
                return true;
            }
            case 8: {
                pSSFViewTypeBase.resetPSSFStyleName();
                return true;
            }
            case 9: {
                pSSFViewTypeBase.resetPSSFViewTypeId();
                return true;
            }
            case 10: {
                pSSFViewTypeBase.resetPSSFViewTypeName();
                return true;
            }
            case 11: {
                pSSFViewTypeBase.resetPSViewTypeId();
                return true;
            }
            case 12: {
                pSSFViewTypeBase.resetPSViewTypeName();
                return true;
            }
            case 13: {
                pSSFViewTypeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSSFViewTypeBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSSFViewTypeBase.resetViewClass();
                return true;
            }
            case 16: {
                pSSFViewTypeBase.resetViewDesc();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet(pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSSFViewTypeBase getProxyEntity() {
        return this.proxyPSSFViewTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFViewTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFViewTypeBase) {
            this.proxyPSSFViewTypeBase = (PSSFViewTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFViewTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTROLLERCLASS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MODELCLASS, 4);
        fieldIndexMap.put(FIELD_PSSFID, 5);
        fieldIndexMap.put(FIELD_PSSFNAME, 6);
        fieldIndexMap.put(FIELD_PSSFSTYLEID, 7);
        fieldIndexMap.put(FIELD_PSSFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_PSSFVIEWTYPEID, 9);
        fieldIndexMap.put(FIELD_PSSFVIEWTYPENAME, 10);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 11);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VIEWCLASS, 15);
        fieldIndexMap.put(FIELD_VIEWDESC, 16);
    }
}

