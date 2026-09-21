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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFViewTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFViewTypeBase.class);
    public static final String FIELD_CONTROLLERCLASS = "CONTROLLERCLASS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELCLASS = "MODELCLASS";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String FIELD_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String FIELD_PSPFVIEWTYPEID = "PSPFVIEWTYPEID";
    public static final String FIELD_PSPFVIEWTYPENAME = "PSPFVIEWTYPENAME";
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
    private static final int INDEX_PSPFID = 5;
    private static final int INDEX_PSPFNAME = 6;
    private static final int INDEX_PSPFSTYLEID = 7;
    private static final int INDEX_PSPFSTYLENAME = 8;
    private static final int INDEX_PSPFVIEWTYPEID = 9;
    private static final int INDEX_PSPFVIEWTYPENAME = 10;
    private static final int INDEX_PSVIEWTYPEID = 11;
    private static final int INDEX_PSVIEWTYPENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_VIEWCLASS = 15;
    private static final int INDEX_VIEWDESC = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFViewTypeBase proxyPSPFViewTypeBase = null;
    private boolean controllerclassDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelclassDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfstyleidDirtyFlag = false;
    private boolean pspfstylenameDirtyFlag = false;
    private boolean pspfviewtypeidDirtyFlag = false;
    private boolean pspfviewtypenameDirtyFlag = false;
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
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfstyleid")
    private String pspfstyleid;
    @Column(name="pspfstylename")
    private String pspfstylename;
    @Column(name="pspfviewtypeid")
    private String pspfviewtypeid;
    @Column(name="pspfviewtypename")
    private String pspfviewtypename;
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
    private Integer objPSPFStyleLock = new Integer(1);
    private PSPFStyle pspfstyle = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
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

    public void setPSPFViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfviewtypeid = string;
        this.pspfviewtypeidDirtyFlag = true;
    }

    public String getPSPFViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFViewTypeId();
        }
        return this.pspfviewtypeid;
    }

    public boolean isPSPFViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFViewTypeIdDirty();
        }
        return this.pspfviewtypeidDirtyFlag;
    }

    public void resetPSPFViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFViewTypeId();
            return;
        }
        this.pspfviewtypeidDirtyFlag = false;
        this.pspfviewtypeid = null;
    }

    public void setPSPFViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfviewtypename = string;
        this.pspfviewtypenameDirtyFlag = true;
    }

    public String getPSPFViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFViewTypeName();
        }
        return this.pspfviewtypename;
    }

    public boolean isPSPFViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFViewTypeNameDirty();
        }
        return this.pspfviewtypenameDirtyFlag;
    }

    public void resetPSPFViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFViewTypeName();
            return;
        }
        this.pspfviewtypenameDirtyFlag = false;
        this.pspfviewtypename = null;
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
        PSPFViewTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFViewTypeBase pSPFViewTypeBase) {
        pSPFViewTypeBase.resetControllerClass();
        pSPFViewTypeBase.resetCreateDate();
        pSPFViewTypeBase.resetCreateMan();
        pSPFViewTypeBase.resetMemo();
        pSPFViewTypeBase.resetModelClass();
        pSPFViewTypeBase.resetPSPFId();
        pSPFViewTypeBase.resetPSPFName();
        pSPFViewTypeBase.resetPSPFStyleId();
        pSPFViewTypeBase.resetPSPFStyleName();
        pSPFViewTypeBase.resetPSPFViewTypeId();
        pSPFViewTypeBase.resetPSPFViewTypeName();
        pSPFViewTypeBase.resetPSViewTypeId();
        pSPFViewTypeBase.resetPSViewTypeName();
        pSPFViewTypeBase.resetUpdateDate();
        pSPFViewTypeBase.resetUpdateMan();
        pSPFViewTypeBase.resetViewClass();
        pSPFViewTypeBase.resetViewDesc();
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
        if (!bl || this.isPSPFViewTypeIdDirty()) {
            hashMap.put(FIELD_PSPFVIEWTYPEID, this.getPSPFViewTypeId());
        }
        if (!bl || this.isPSPFViewTypeNameDirty()) {
            hashMap.put(FIELD_PSPFVIEWTYPENAME, this.getPSPFViewTypeName());
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
        return PSPFViewTypeBase.get(this, n);
    }

    private static Object get(PSPFViewTypeBase pSPFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTypeBase.getControllerClass();
            }
            case 1: {
                return pSPFViewTypeBase.getCreateDate();
            }
            case 2: {
                return pSPFViewTypeBase.getCreateMan();
            }
            case 3: {
                return pSPFViewTypeBase.getMemo();
            }
            case 4: {
                return pSPFViewTypeBase.getModelClass();
            }
            case 5: {
                return pSPFViewTypeBase.getPSPFId();
            }
            case 6: {
                return pSPFViewTypeBase.getPSPFName();
            }
            case 7: {
                return pSPFViewTypeBase.getPSPFStyleId();
            }
            case 8: {
                return pSPFViewTypeBase.getPSPFStyleName();
            }
            case 9: {
                return pSPFViewTypeBase.getPSPFViewTypeId();
            }
            case 10: {
                return pSPFViewTypeBase.getPSPFViewTypeName();
            }
            case 11: {
                return pSPFViewTypeBase.getPSViewTypeId();
            }
            case 12: {
                return pSPFViewTypeBase.getPSViewTypeName();
            }
            case 13: {
                return pSPFViewTypeBase.getUpdateDate();
            }
            case 14: {
                return pSPFViewTypeBase.getUpdateMan();
            }
            case 15: {
                return pSPFViewTypeBase.getViewClass();
            }
            case 16: {
                return pSPFViewTypeBase.getViewDesc();
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
        PSPFViewTypeBase.set(this, n, object);
    }

    private static void set(PSPFViewTypeBase pSPFViewTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFViewTypeBase.setControllerClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFViewTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFViewTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFViewTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFViewTypeBase.setModelClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFViewTypeBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFViewTypeBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFViewTypeBase.setPSPFStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFViewTypeBase.setPSPFStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFViewTypeBase.setPSPFViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFViewTypeBase.setPSPFViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFViewTypeBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFViewTypeBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFViewTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPFViewTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFViewTypeBase.setViewClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFViewTypeBase.setViewDesc(DataObject.getStringValue((Object)object));
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
        return PSPFViewTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFViewTypeBase pSPFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTypeBase.getControllerClass() == null;
            }
            case 1: {
                return pSPFViewTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFViewTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFViewTypeBase.getMemo() == null;
            }
            case 4: {
                return pSPFViewTypeBase.getModelClass() == null;
            }
            case 5: {
                return pSPFViewTypeBase.getPSPFId() == null;
            }
            case 6: {
                return pSPFViewTypeBase.getPSPFName() == null;
            }
            case 7: {
                return pSPFViewTypeBase.getPSPFStyleId() == null;
            }
            case 8: {
                return pSPFViewTypeBase.getPSPFStyleName() == null;
            }
            case 9: {
                return pSPFViewTypeBase.getPSPFViewTypeId() == null;
            }
            case 10: {
                return pSPFViewTypeBase.getPSPFViewTypeName() == null;
            }
            case 11: {
                return pSPFViewTypeBase.getPSViewTypeId() == null;
            }
            case 12: {
                return pSPFViewTypeBase.getPSViewTypeName() == null;
            }
            case 13: {
                return pSPFViewTypeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPFViewTypeBase.getUpdateMan() == null;
            }
            case 15: {
                return pSPFViewTypeBase.getViewClass() == null;
            }
            case 16: {
                return pSPFViewTypeBase.getViewDesc() == null;
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
        return PSPFViewTypeBase.contains(this, n);
    }

    private static boolean contains(PSPFViewTypeBase pSPFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFViewTypeBase.isControllerClassDirty();
            }
            case 1: {
                return pSPFViewTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFViewTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSPFViewTypeBase.isMemoDirty();
            }
            case 4: {
                return pSPFViewTypeBase.isModelClassDirty();
            }
            case 5: {
                return pSPFViewTypeBase.isPSPFIdDirty();
            }
            case 6: {
                return pSPFViewTypeBase.isPSPFNameDirty();
            }
            case 7: {
                return pSPFViewTypeBase.isPSPFStyleIdDirty();
            }
            case 8: {
                return pSPFViewTypeBase.isPSPFStyleNameDirty();
            }
            case 9: {
                return pSPFViewTypeBase.isPSPFViewTypeIdDirty();
            }
            case 10: {
                return pSPFViewTypeBase.isPSPFViewTypeNameDirty();
            }
            case 11: {
                return pSPFViewTypeBase.isPSViewTypeIdDirty();
            }
            case 12: {
                return pSPFViewTypeBase.isPSViewTypeNameDirty();
            }
            case 13: {
                return pSPFViewTypeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPFViewTypeBase.isUpdateManDirty();
            }
            case 15: {
                return pSPFViewTypeBase.isViewClassDirty();
            }
            case 16: {
                return pSPFViewTypeBase.isViewDescDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFViewTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFViewTypeBase pSPFViewTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFViewTypeBase.getControllerClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"controllerclass", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getControllerClass()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getModelClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelclass", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getModelClass()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstyleid", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFStyleId()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfstylename", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFStyleName()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfviewtypeid", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFViewTypeId()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSPFViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfviewtypename", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSPFViewTypeName()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getViewClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewclass", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getViewClass()), (boolean)false);
        }
        if (bl || pSPFViewTypeBase.getViewDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewdesc", (Object)PSPFViewTypeBase.getJSONValue((Object)pSPFViewTypeBase.getViewDesc()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFViewTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFViewTypeBase pSPFViewTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFViewTypeBase.getControllerClass() != null) {
            object = pSPFViewTypeBase.getControllerClass();
            xmlNode.setAttribute(FIELD_CONTROLLERCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getCreateDate() != null) {
            object = pSPFViewTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFViewTypeBase.getCreateMan() != null) {
            object = pSPFViewTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getMemo() != null) {
            object = pSPFViewTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getModelClass() != null) {
            object = pSPFViewTypeBase.getModelClass();
            xmlNode.setAttribute(FIELD_MODELCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFId() != null) {
            object = pSPFViewTypeBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFName() != null) {
            object = pSPFViewTypeBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFStyleId() != null) {
            object = pSPFViewTypeBase.getPSPFStyleId();
            xmlNode.setAttribute(FIELD_PSPFSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFStyleName() != null) {
            object = pSPFViewTypeBase.getPSPFStyleName();
            xmlNode.setAttribute(FIELD_PSPFSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFViewTypeId() != null) {
            object = pSPFViewTypeBase.getPSPFViewTypeId();
            xmlNode.setAttribute(FIELD_PSPFVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSPFViewTypeName() != null) {
            object = pSPFViewTypeBase.getPSPFViewTypeName();
            xmlNode.setAttribute(FIELD_PSPFVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSViewTypeId() != null) {
            object = pSPFViewTypeBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getPSViewTypeName() != null) {
            object = pSPFViewTypeBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getUpdateDate() != null) {
            object = pSPFViewTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFViewTypeBase.getUpdateMan() != null) {
            object = pSPFViewTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getViewClass() != null) {
            object = pSPFViewTypeBase.getViewClass();
            xmlNode.setAttribute(FIELD_VIEWCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSPFViewTypeBase.getViewDesc() != null) {
            object = pSPFViewTypeBase.getViewDesc();
            xmlNode.setAttribute(FIELD_VIEWDESC, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFViewTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFViewTypeBase pSPFViewTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFViewTypeBase.isControllerClassDirty() && (bl || pSPFViewTypeBase.getControllerClass() != null)) {
            iDataObject.set(FIELD_CONTROLLERCLASS, (Object)pSPFViewTypeBase.getControllerClass());
        }
        if (pSPFViewTypeBase.isCreateDateDirty() && (bl || pSPFViewTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFViewTypeBase.getCreateDate());
        }
        if (pSPFViewTypeBase.isCreateManDirty() && (bl || pSPFViewTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFViewTypeBase.getCreateMan());
        }
        if (pSPFViewTypeBase.isMemoDirty() && (bl || pSPFViewTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFViewTypeBase.getMemo());
        }
        if (pSPFViewTypeBase.isModelClassDirty() && (bl || pSPFViewTypeBase.getModelClass() != null)) {
            iDataObject.set(FIELD_MODELCLASS, (Object)pSPFViewTypeBase.getModelClass());
        }
        if (pSPFViewTypeBase.isPSPFIdDirty() && (bl || pSPFViewTypeBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFViewTypeBase.getPSPFId());
        }
        if (pSPFViewTypeBase.isPSPFNameDirty() && (bl || pSPFViewTypeBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFViewTypeBase.getPSPFName());
        }
        if (pSPFViewTypeBase.isPSPFStyleIdDirty() && (bl || pSPFViewTypeBase.getPSPFStyleId() != null)) {
            iDataObject.set(FIELD_PSPFSTYLEID, (Object)pSPFViewTypeBase.getPSPFStyleId());
        }
        if (pSPFViewTypeBase.isPSPFStyleNameDirty() && (bl || pSPFViewTypeBase.getPSPFStyleName() != null)) {
            iDataObject.set(FIELD_PSPFSTYLENAME, (Object)pSPFViewTypeBase.getPSPFStyleName());
        }
        if (pSPFViewTypeBase.isPSPFViewTypeIdDirty() && (bl || pSPFViewTypeBase.getPSPFViewTypeId() != null)) {
            iDataObject.set(FIELD_PSPFVIEWTYPEID, (Object)pSPFViewTypeBase.getPSPFViewTypeId());
        }
        if (pSPFViewTypeBase.isPSPFViewTypeNameDirty() && (bl || pSPFViewTypeBase.getPSPFViewTypeName() != null)) {
            iDataObject.set(FIELD_PSPFVIEWTYPENAME, (Object)pSPFViewTypeBase.getPSPFViewTypeName());
        }
        if (pSPFViewTypeBase.isPSViewTypeIdDirty() && (bl || pSPFViewTypeBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSPFViewTypeBase.getPSViewTypeId());
        }
        if (pSPFViewTypeBase.isPSViewTypeNameDirty() && (bl || pSPFViewTypeBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSPFViewTypeBase.getPSViewTypeName());
        }
        if (pSPFViewTypeBase.isUpdateDateDirty() && (bl || pSPFViewTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFViewTypeBase.getUpdateDate());
        }
        if (pSPFViewTypeBase.isUpdateManDirty() && (bl || pSPFViewTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFViewTypeBase.getUpdateMan());
        }
        if (pSPFViewTypeBase.isViewClassDirty() && (bl || pSPFViewTypeBase.getViewClass() != null)) {
            iDataObject.set(FIELD_VIEWCLASS, (Object)pSPFViewTypeBase.getViewClass());
        }
        if (pSPFViewTypeBase.isViewDescDirty() && (bl || pSPFViewTypeBase.getViewDesc() != null)) {
            iDataObject.set(FIELD_VIEWDESC, (Object)pSPFViewTypeBase.getViewDesc());
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
        return PSPFViewTypeBase.remove(this, n);
    }

    private static boolean remove(PSPFViewTypeBase pSPFViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFViewTypeBase.resetControllerClass();
                return true;
            }
            case 1: {
                pSPFViewTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFViewTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFViewTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFViewTypeBase.resetModelClass();
                return true;
            }
            case 5: {
                pSPFViewTypeBase.resetPSPFId();
                return true;
            }
            case 6: {
                pSPFViewTypeBase.resetPSPFName();
                return true;
            }
            case 7: {
                pSPFViewTypeBase.resetPSPFStyleId();
                return true;
            }
            case 8: {
                pSPFViewTypeBase.resetPSPFStyleName();
                return true;
            }
            case 9: {
                pSPFViewTypeBase.resetPSPFViewTypeId();
                return true;
            }
            case 10: {
                pSPFViewTypeBase.resetPSPFViewTypeName();
                return true;
            }
            case 11: {
                pSPFViewTypeBase.resetPSViewTypeId();
                return true;
            }
            case 12: {
                pSPFViewTypeBase.resetPSViewTypeName();
                return true;
            }
            case 13: {
                pSPFViewTypeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPFViewTypeBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSPFViewTypeBase.resetViewClass();
                return true;
            }
            case 16: {
                pSPFViewTypeBase.resetViewDesc();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSPFStyleService.autoGet((IEntity)pSPFStyle);
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
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
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
                pSViewTypeService.autoGet((IEntity)pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSPFViewTypeBase getProxyEntity() {
        return this.proxyPSPFViewTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFViewTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFViewTypeBase) {
            this.proxyPSPFViewTypeBase = (PSPFViewTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFViewTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTROLLERCLASS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MODELCLASS, 4);
        fieldIndexMap.put(FIELD_PSPFID, 5);
        fieldIndexMap.put(FIELD_PSPFNAME, 6);
        fieldIndexMap.put(FIELD_PSPFSTYLEID, 7);
        fieldIndexMap.put(FIELD_PSPFSTYLENAME, 8);
        fieldIndexMap.put(FIELD_PSPFVIEWTYPEID, 9);
        fieldIndexMap.put(FIELD_PSPFVIEWTYPENAME, 10);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 11);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_VIEWCLASS, 15);
        fieldIndexMap.put(FIELD_VIEWDESC, 16);
    }
}

