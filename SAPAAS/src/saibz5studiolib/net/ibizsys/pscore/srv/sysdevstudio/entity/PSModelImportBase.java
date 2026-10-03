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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelImportBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelImportBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_IMPORTMODE = "IMPORTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELFILE = "MODELFILE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODELIMPORTID = "PSMODELIMPORTID";
    public static final String FIELD_PSMODELIMPORTNAME = "PSMODELIMPORTNAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DYNAMODELFLAG = 2;
    private static final int INDEX_IMPORTMODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODELFILE = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSDYNAINSTID = 8;
    private static final int INDEX_PSMODELIMPORTID = 9;
    private static final int INDEX_PSMODELIMPORTNAME = 10;
    private static final int INDEX_PSOBJID = 11;
    private static final int INDEX_PSOBJNAME = 12;
    private static final int INDEX_PSOBJTYPE = 13;
    private static final int INDEX_PSOBJTYPENAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelImportBase proxyPSModelImportBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean importmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelfileDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmodelimportidDirtyFlag = false;
    private boolean psmodelimportnameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="importmode")
    private String importmode;
    @Column(name="memo")
    private String memo;
    @Column(name="modelfile")
    private String modelfile;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmodelimportid")
    private String psmodelimportid;
    @Column(name="psmodelimportname")
    private String psmodelimportname;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setImportMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.importmode = string;
        this.importmodeDirtyFlag = true;
    }

    public String getImportMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportMode();
        }
        return this.importmode;
    }

    public boolean isImportModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportModeDirty();
        }
        return this.importmodeDirtyFlag;
    }

    public void resetImportMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportMode();
            return;
        }
        this.importmodeDirtyFlag = false;
        this.importmode = null;
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

    public void setModelFile(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelFile(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelfile = string;
        this.modelfileDirtyFlag = true;
    }

    public String getModelFile() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelFile();
        }
        return this.modelfile;
    }

    public boolean isModelFileDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelFileDirty();
        }
        return this.modelfileDirtyFlag;
    }

    public void resetModelFile() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelFile();
            return;
        }
        this.modelfileDirtyFlag = false;
        this.modelfile = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
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

    public void setPSModelImportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelImportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelimportid = string;
        this.psmodelimportidDirtyFlag = true;
    }

    public String getPSModelImportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelImportId();
        }
        return this.psmodelimportid;
    }

    public boolean isPSModelImportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelImportIdDirty();
        }
        return this.psmodelimportidDirtyFlag;
    }

    public void resetPSModelImportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelImportId();
            return;
        }
        this.psmodelimportidDirtyFlag = false;
        this.psmodelimportid = null;
    }

    public void setPSModelImportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelImportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelimportname = string;
        this.psmodelimportnameDirtyFlag = true;
    }

    public String getPSModelImportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelImportName();
        }
        return this.psmodelimportname;
    }

    public boolean isPSModelImportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelImportNameDirty();
        }
        return this.psmodelimportnameDirtyFlag;
    }

    public void resetPSModelImportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelImportName();
            return;
        }
        this.psmodelimportnameDirtyFlag = false;
        this.psmodelimportname = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSModelImportBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelImportBase pSModelImportBase) {
        pSModelImportBase.resetCreateDate();
        pSModelImportBase.resetCreateMan();
        pSModelImportBase.resetDynaModelFlag();
        pSModelImportBase.resetImportMode();
        pSModelImportBase.resetMemo();
        pSModelImportBase.resetModelFile();
        pSModelImportBase.resetPSDevCenterId();
        pSModelImportBase.resetPSDevCenterName();
        pSModelImportBase.resetPSDynaInstId();
        pSModelImportBase.resetPSModelImportId();
        pSModelImportBase.resetPSModelImportName();
        pSModelImportBase.resetPSObjId();
        pSModelImportBase.resetPSObjName();
        pSModelImportBase.resetPSObjType();
        pSModelImportBase.resetPSObjTypeName();
        pSModelImportBase.resetPSSystemId();
        pSModelImportBase.resetPSSystemName();
        pSModelImportBase.resetUpdateDate();
        pSModelImportBase.resetUpdateMan();
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
        if (!bl || this.isImportModeDirty()) {
            hashMap.put(FIELD_IMPORTMODE, this.getImportMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelFileDirty()) {
            hashMap.put(FIELD_MODELFILE, this.getModelFile());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModelImportIdDirty()) {
            hashMap.put(FIELD_PSMODELIMPORTID, this.getPSModelImportId());
        }
        if (!bl || this.isPSModelImportNameDirty()) {
            hashMap.put(FIELD_PSMODELIMPORTNAME, this.getPSModelImportName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSModelImportBase.get(this, n);
    }

    private static Object get(PSModelImportBase pSModelImportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelImportBase.getCreateDate();
            }
            case 1: {
                return pSModelImportBase.getCreateMan();
            }
            case 2: {
                return pSModelImportBase.getDynaModelFlag();
            }
            case 3: {
                return pSModelImportBase.getImportMode();
            }
            case 4: {
                return pSModelImportBase.getMemo();
            }
            case 5: {
                return pSModelImportBase.getModelFile();
            }
            case 6: {
                return pSModelImportBase.getPSDevCenterId();
            }
            case 7: {
                return pSModelImportBase.getPSDevCenterName();
            }
            case 8: {
                return pSModelImportBase.getPSDynaInstId();
            }
            case 9: {
                return pSModelImportBase.getPSModelImportId();
            }
            case 10: {
                return pSModelImportBase.getPSModelImportName();
            }
            case 11: {
                return pSModelImportBase.getPSObjId();
            }
            case 12: {
                return pSModelImportBase.getPSObjName();
            }
            case 13: {
                return pSModelImportBase.getPSObjType();
            }
            case 14: {
                return pSModelImportBase.getPSObjTypeName();
            }
            case 15: {
                return pSModelImportBase.getPSSystemId();
            }
            case 16: {
                return pSModelImportBase.getPSSystemName();
            }
            case 17: {
                return pSModelImportBase.getUpdateDate();
            }
            case 18: {
                return pSModelImportBase.getUpdateMan();
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
        PSModelImportBase.set(this, n, object);
    }

    private static void set(PSModelImportBase pSModelImportBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelImportBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelImportBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelImportBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelImportBase.setImportMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelImportBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelImportBase.setModelFile(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelImportBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelImportBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelImportBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelImportBase.setPSModelImportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelImportBase.setPSModelImportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelImportBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelImportBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelImportBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelImportBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelImportBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelImportBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelImportBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSModelImportBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelImportBase.isNull(this, n);
    }

    private static boolean isNull(PSModelImportBase pSModelImportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelImportBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelImportBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelImportBase.getDynaModelFlag() == null;
            }
            case 3: {
                return pSModelImportBase.getImportMode() == null;
            }
            case 4: {
                return pSModelImportBase.getMemo() == null;
            }
            case 5: {
                return pSModelImportBase.getModelFile() == null;
            }
            case 6: {
                return pSModelImportBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSModelImportBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSModelImportBase.getPSDynaInstId() == null;
            }
            case 9: {
                return pSModelImportBase.getPSModelImportId() == null;
            }
            case 10: {
                return pSModelImportBase.getPSModelImportName() == null;
            }
            case 11: {
                return pSModelImportBase.getPSObjId() == null;
            }
            case 12: {
                return pSModelImportBase.getPSObjName() == null;
            }
            case 13: {
                return pSModelImportBase.getPSObjType() == null;
            }
            case 14: {
                return pSModelImportBase.getPSObjTypeName() == null;
            }
            case 15: {
                return pSModelImportBase.getPSSystemId() == null;
            }
            case 16: {
                return pSModelImportBase.getPSSystemName() == null;
            }
            case 17: {
                return pSModelImportBase.getUpdateDate() == null;
            }
            case 18: {
                return pSModelImportBase.getUpdateMan() == null;
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
        return PSModelImportBase.contains(this, n);
    }

    private static boolean contains(PSModelImportBase pSModelImportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelImportBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelImportBase.isCreateManDirty();
            }
            case 2: {
                return pSModelImportBase.isDynaModelFlagDirty();
            }
            case 3: {
                return pSModelImportBase.isImportModeDirty();
            }
            case 4: {
                return pSModelImportBase.isMemoDirty();
            }
            case 5: {
                return pSModelImportBase.isModelFileDirty();
            }
            case 6: {
                return pSModelImportBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSModelImportBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSModelImportBase.isPSDynaInstIdDirty();
            }
            case 9: {
                return pSModelImportBase.isPSModelImportIdDirty();
            }
            case 10: {
                return pSModelImportBase.isPSModelImportNameDirty();
            }
            case 11: {
                return pSModelImportBase.isPSObjIdDirty();
            }
            case 12: {
                return pSModelImportBase.isPSObjNameDirty();
            }
            case 13: {
                return pSModelImportBase.isPSObjTypeDirty();
            }
            case 14: {
                return pSModelImportBase.isPSObjTypeNameDirty();
            }
            case 15: {
                return pSModelImportBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSModelImportBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSModelImportBase.isUpdateDateDirty();
            }
            case 18: {
                return pSModelImportBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelImportBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelImportBase pSModelImportBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelImportBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelImportBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelImportBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSModelImportBase.getImportMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importmode", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getImportMode()), (boolean)false);
        }
        if (bl || pSModelImportBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelImportBase.getModelFile() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelfile", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getModelFile()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSModelImportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelimportid", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSModelImportId()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSModelImportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelimportname", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSModelImportName()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelImportBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSModelImportBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelImportBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelImportBase.getJSONValue((Object)pSModelImportBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelImportBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelImportBase pSModelImportBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelImportBase.getCreateDate() != null) {
            object = pSModelImportBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelImportBase.getCreateMan() != null) {
            object = pSModelImportBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getDynaModelFlag() != null) {
            object = pSModelImportBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelImportBase.getImportMode() != null) {
            object = pSModelImportBase.getImportMode();
            xmlNode.setAttribute(FIELD_IMPORTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getMemo() != null) {
            object = pSModelImportBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getModelFile() != null) {
            object = pSModelImportBase.getModelFile();
            xmlNode.setAttribute(FIELD_MODELFILE, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSDevCenterId() != null) {
            object = pSModelImportBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSDevCenterName() != null) {
            object = pSModelImportBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSDynaInstId() != null) {
            object = pSModelImportBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSModelImportId() != null) {
            object = pSModelImportBase.getPSModelImportId();
            xmlNode.setAttribute(FIELD_PSMODELIMPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSModelImportName() != null) {
            object = pSModelImportBase.getPSModelImportName();
            xmlNode.setAttribute(FIELD_PSMODELIMPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSObjId() != null) {
            object = pSModelImportBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSObjName() != null) {
            object = pSModelImportBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSObjType() != null) {
            object = pSModelImportBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSObjTypeName() != null) {
            object = pSModelImportBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSSystemId() != null) {
            object = pSModelImportBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getPSSystemName() != null) {
            object = pSModelImportBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelImportBase.getUpdateDate() != null) {
            object = pSModelImportBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelImportBase.getUpdateMan() != null) {
            object = pSModelImportBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelImportBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelImportBase pSModelImportBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelImportBase.isCreateDateDirty() && (bl || pSModelImportBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelImportBase.getCreateDate());
        }
        if (pSModelImportBase.isCreateManDirty() && (bl || pSModelImportBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelImportBase.getCreateMan());
        }
        if (pSModelImportBase.isDynaModelFlagDirty() && (bl || pSModelImportBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSModelImportBase.getDynaModelFlag());
        }
        if (pSModelImportBase.isImportModeDirty() && (bl || pSModelImportBase.getImportMode() != null)) {
            iDataObject.set(FIELD_IMPORTMODE, (Object)pSModelImportBase.getImportMode());
        }
        if (pSModelImportBase.isMemoDirty() && (bl || pSModelImportBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelImportBase.getMemo());
        }
        if (pSModelImportBase.isModelFileDirty() && (bl || pSModelImportBase.getModelFile() != null)) {
            iDataObject.set(FIELD_MODELFILE, (Object)pSModelImportBase.getModelFile());
        }
        if (pSModelImportBase.isPSDevCenterIdDirty() && (bl || pSModelImportBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSModelImportBase.getPSDevCenterId());
        }
        if (pSModelImportBase.isPSDevCenterNameDirty() && (bl || pSModelImportBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSModelImportBase.getPSDevCenterName());
        }
        if (pSModelImportBase.isPSDynaInstIdDirty() && (bl || pSModelImportBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSModelImportBase.getPSDynaInstId());
        }
        if (pSModelImportBase.isPSModelImportIdDirty() && (bl || pSModelImportBase.getPSModelImportId() != null)) {
            iDataObject.set(FIELD_PSMODELIMPORTID, (Object)pSModelImportBase.getPSModelImportId());
        }
        if (pSModelImportBase.isPSModelImportNameDirty() && (bl || pSModelImportBase.getPSModelImportName() != null)) {
            iDataObject.set(FIELD_PSMODELIMPORTNAME, (Object)pSModelImportBase.getPSModelImportName());
        }
        if (pSModelImportBase.isPSObjIdDirty() && (bl || pSModelImportBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSModelImportBase.getPSObjId());
        }
        if (pSModelImportBase.isPSObjNameDirty() && (bl || pSModelImportBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSModelImportBase.getPSObjName());
        }
        if (pSModelImportBase.isPSObjTypeDirty() && (bl || pSModelImportBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSModelImportBase.getPSObjType());
        }
        if (pSModelImportBase.isPSObjTypeNameDirty() && (bl || pSModelImportBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSModelImportBase.getPSObjTypeName());
        }
        if (pSModelImportBase.isPSSystemIdDirty() && (bl || pSModelImportBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelImportBase.getPSSystemId());
        }
        if (pSModelImportBase.isPSSystemNameDirty() && (bl || pSModelImportBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSModelImportBase.getPSSystemName());
        }
        if (pSModelImportBase.isUpdateDateDirty() && (bl || pSModelImportBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelImportBase.getUpdateDate());
        }
        if (pSModelImportBase.isUpdateManDirty() && (bl || pSModelImportBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelImportBase.getUpdateMan());
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
        return PSModelImportBase.remove(this, n);
    }

    private static boolean remove(PSModelImportBase pSModelImportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelImportBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelImportBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelImportBase.resetDynaModelFlag();
                return true;
            }
            case 3: {
                pSModelImportBase.resetImportMode();
                return true;
            }
            case 4: {
                pSModelImportBase.resetMemo();
                return true;
            }
            case 5: {
                pSModelImportBase.resetModelFile();
                return true;
            }
            case 6: {
                pSModelImportBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSModelImportBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSModelImportBase.resetPSDynaInstId();
                return true;
            }
            case 9: {
                pSModelImportBase.resetPSModelImportId();
                return true;
            }
            case 10: {
                pSModelImportBase.resetPSModelImportName();
                return true;
            }
            case 11: {
                pSModelImportBase.resetPSObjId();
                return true;
            }
            case 12: {
                pSModelImportBase.resetPSObjName();
                return true;
            }
            case 13: {
                pSModelImportBase.resetPSObjType();
                return true;
            }
            case 14: {
                pSModelImportBase.resetPSObjTypeName();
                return true;
            }
            case 15: {
                pSModelImportBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSModelImportBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSModelImportBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSModelImportBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSModelImportBase getProxyEntity() {
        return this.proxyPSModelImportBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelImportBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelImportBase) {
            this.proxyPSModelImportBase = (PSModelImportBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSModelImportService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 2);
        fieldIndexMap.put(FIELD_IMPORTMODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODELFILE, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 8);
        fieldIndexMap.put(FIELD_PSMODELIMPORTID, 9);
        fieldIndexMap.put(FIELD_PSMODELIMPORTNAME, 10);
        fieldIndexMap.put(FIELD_PSOBJID, 11);
        fieldIndexMap.put(FIELD_PSOBJNAME, 12);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 13);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

