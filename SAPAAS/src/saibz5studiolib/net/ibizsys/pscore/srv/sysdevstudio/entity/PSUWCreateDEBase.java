/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWCreateDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWCreateDEBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_LOGICVALID = "LOGICVALID";
    public static final String FIELD_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSUWCREATEDEID = "PSUWCREATEDEID";
    public static final String FIELD_PSUWCREATEDENAME = "PSUWCREATEDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDDATA = "WIZARDDATA";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_LOGICVALID = 4;
    private static final int INDEX_PSDATAENTITYNAME = 5;
    private static final int INDEX_PSDEID = 6;
    private static final int INDEX_PSDENAME = 7;
    private static final int INDEX_PSDYNAINSTID = 8;
    private static final int INDEX_PSMODULEID = 9;
    private static final int INDEX_PSMODULENAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSUWCREATEDEID = 12;
    private static final int INDEX_PSUWCREATEDENAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_WIZARDDATA = 16;
    private static final int INDEX_WIZARDMODE = 17;
    private static final int INDEX_WIZARDPARAM = 18;
    private static final int INDEX_WIZARDPARAM2 = 19;
    private static final int INDEX_WIZARDPARAM3 = 20;
    private static final int INDEX_WIZARDPARAM4 = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWCreateDEBase proxyPSUWCreateDEBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean logicvalidDirtyFlag = false;
    private boolean psdataentitynameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean psuwcreatedeidDirtyFlag = false;
    private boolean psuwcreatedenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizarddataDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="logicvalid")
    private Integer logicvalid;
    @Column(name="psdataentityname")
    private String psdataentityname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="psuwcreatedeid")
    private String psuwcreatedeid;
    @Column(name="psuwcreatedename")
    private String psuwcreatedename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizarddata")
    private String wizarddata;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private String wizardparam;
    @Column(name="wizardparam2")
    private String wizardparam2;
    @Column(name="wizardparam3")
    private Integer wizardparam3;
    @Column(name="wizardparam4")
    private Integer wizardparam4;
    private Integer objPSUWCreateDEItemsLock = new Integer(1);
    private ArrayList<PSUWCreateDEItem> psuwcreatedeitems = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setLogicValid(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicValid(n);
            return;
        }
        this.logicvalid = n;
        this.logicvalidDirtyFlag = true;
    }

    public Integer getLogicValid() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicValid();
        }
        return this.logicvalid;
    }

    public boolean isLogicValidDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicValidDirty();
        }
        return this.logicvalidDirtyFlag;
    }

    public void resetLogicValid() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicValid();
            return;
        }
        this.logicvalidDirtyFlag = false;
        this.logicvalid = null;
    }

    public void setPSDataEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdataentityname = string;
        this.psdataentitynameDirtyFlag = true;
    }

    public String getPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityName();
        }
        return this.psdataentityname;
    }

    public boolean isPSDataEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityNameDirty();
        }
        return this.psdataentitynameDirtyFlag;
    }

    public void resetPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityName();
            return;
        }
        this.psdataentitynameDirtyFlag = false;
        this.psdataentityname = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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

    public void setPSUWCreateDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedeid = string;
        this.psuwcreatedeidDirtyFlag = true;
    }

    public String getPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEId();
        }
        return this.psuwcreatedeid;
    }

    public boolean isPSUWCreateDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDEIdDirty();
        }
        return this.psuwcreatedeidDirtyFlag;
    }

    public void resetPSUWCreateDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEId();
            return;
        }
        this.psuwcreatedeidDirtyFlag = false;
        this.psuwcreatedeid = null;
    }

    public void setPSUWCreateDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWCreateDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwcreatedename = string;
        this.psuwcreatedenameDirtyFlag = true;
    }

    public String getPSUWCreateDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEName();
        }
        return this.psuwcreatedename;
    }

    public boolean isPSUWCreateDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWCreateDENameDirty();
        }
        return this.psuwcreatedenameDirtyFlag;
    }

    public void resetPSUWCreateDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWCreateDEName();
            return;
        }
        this.psuwcreatedenameDirtyFlag = false;
        this.psuwcreatedename = null;
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

    public void setWizardData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizarddata = string;
        this.wizarddataDirtyFlag = true;
    }

    public String getWizardData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardData();
        }
        return this.wizarddata;
    }

    public boolean isWizardDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardDataDirty();
        }
        return this.wizarddataDirtyFlag;
    }

    public void resetWizardData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardData();
            return;
        }
        this.wizarddataDirtyFlag = false;
        this.wizarddata = null;
    }

    public void setWizardMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardmode = string;
        this.wizardmodeDirtyFlag = true;
    }

    public String getWizardMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardMode();
        }
        return this.wizardmode;
    }

    public boolean isWizardModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardModeDirty();
        }
        return this.wizardmodeDirtyFlag;
    }

    public void resetWizardMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardMode();
            return;
        }
        this.wizardmodeDirtyFlag = false;
        this.wizardmode = null;
    }

    public void setWizardParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam = string;
        this.wizardparamDirtyFlag = true;
    }

    public String getWizardParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam();
        }
        return this.wizardparam;
    }

    public boolean isWizardParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParamDirty();
        }
        return this.wizardparamDirtyFlag;
    }

    public void resetWizardParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam();
            return;
        }
        this.wizardparamDirtyFlag = false;
        this.wizardparam = null;
    }

    public void setWizardParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam2 = string;
        this.wizardparam2DirtyFlag = true;
    }

    public String getWizardParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam2();
        }
        return this.wizardparam2;
    }

    public boolean isWizardParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam2Dirty();
        }
        return this.wizardparam2DirtyFlag;
    }

    public void resetWizardParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam2();
            return;
        }
        this.wizardparam2DirtyFlag = false;
        this.wizardparam2 = null;
    }

    public void setWizardParam3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(n);
            return;
        }
        this.wizardparam3 = n;
        this.wizardparam3DirtyFlag = true;
    }

    public Integer getWizardParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam3();
        }
        return this.wizardparam3;
    }

    public boolean isWizardParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam3Dirty();
        }
        return this.wizardparam3DirtyFlag;
    }

    public void resetWizardParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam3();
            return;
        }
        this.wizardparam3DirtyFlag = false;
        this.wizardparam3 = null;
    }

    public void setWizardParam4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(n);
            return;
        }
        this.wizardparam4 = n;
        this.wizardparam4DirtyFlag = true;
    }

    public Integer getWizardParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam4();
        }
        return this.wizardparam4;
    }

    public boolean isWizardParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam4Dirty();
        }
        return this.wizardparam4DirtyFlag;
    }

    public void resetWizardParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam4();
            return;
        }
        this.wizardparam4DirtyFlag = false;
        this.wizardparam4 = null;
    }

    protected void onReset() {
        PSUWCreateDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWCreateDEBase pSUWCreateDEBase) {
        pSUWCreateDEBase.resetCodeName();
        pSUWCreateDEBase.resetCreateDate();
        pSUWCreateDEBase.resetCreateMan();
        pSUWCreateDEBase.resetLogicName();
        pSUWCreateDEBase.resetLogicValid();
        pSUWCreateDEBase.resetPSDataEntityName();
        pSUWCreateDEBase.resetPSDEId();
        pSUWCreateDEBase.resetPSDEName();
        pSUWCreateDEBase.resetPSDynaInstId();
        pSUWCreateDEBase.resetPSModuleId();
        pSUWCreateDEBase.resetPSModuleName();
        pSUWCreateDEBase.resetPSSystemId();
        pSUWCreateDEBase.resetPSUWCreateDEId();
        pSUWCreateDEBase.resetPSUWCreateDEName();
        pSUWCreateDEBase.resetUpdateDate();
        pSUWCreateDEBase.resetUpdateMan();
        pSUWCreateDEBase.resetWizardData();
        pSUWCreateDEBase.resetWizardMode();
        pSUWCreateDEBase.resetWizardParam();
        pSUWCreateDEBase.resetWizardParam2();
        pSUWCreateDEBase.resetWizardParam3();
        pSUWCreateDEBase.resetWizardParam4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isLogicValidDirty()) {
            hashMap.put(FIELD_LOGICVALID, this.getLogicValid());
        }
        if (!bl || this.isPSDataEntityNameDirty()) {
            hashMap.put(FIELD_PSDATAENTITYNAME, this.getPSDataEntityName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSUWCreateDEIdDirty()) {
            hashMap.put(FIELD_PSUWCREATEDEID, this.getPSUWCreateDEId());
        }
        if (!bl || this.isPSUWCreateDENameDirty()) {
            hashMap.put(FIELD_PSUWCREATEDENAME, this.getPSUWCreateDEName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWizardDataDirty()) {
            hashMap.put(FIELD_WIZARDDATA, this.getWizardData());
        }
        if (!bl || this.isWizardModeDirty()) {
            hashMap.put(FIELD_WIZARDMODE, this.getWizardMode());
        }
        if (!bl || this.isWizardParamDirty()) {
            hashMap.put(FIELD_WIZARDPARAM, this.getWizardParam());
        }
        if (!bl || this.isWizardParam2Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM2, this.getWizardParam2());
        }
        if (!bl || this.isWizardParam3Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM3, this.getWizardParam3());
        }
        if (!bl || this.isWizardParam4Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM4, this.getWizardParam4());
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
        return PSUWCreateDEBase.get(this, n);
    }

    private static Object get(PSUWCreateDEBase pSUWCreateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEBase.getCodeName();
            }
            case 1: {
                return pSUWCreateDEBase.getCreateDate();
            }
            case 2: {
                return pSUWCreateDEBase.getCreateMan();
            }
            case 3: {
                return pSUWCreateDEBase.getLogicName();
            }
            case 4: {
                return pSUWCreateDEBase.getLogicValid();
            }
            case 5: {
                return pSUWCreateDEBase.getPSDataEntityName();
            }
            case 6: {
                return pSUWCreateDEBase.getPSDEId();
            }
            case 7: {
                return pSUWCreateDEBase.getPSDEName();
            }
            case 8: {
                return pSUWCreateDEBase.getPSDynaInstId();
            }
            case 9: {
                return pSUWCreateDEBase.getPSModuleId();
            }
            case 10: {
                return pSUWCreateDEBase.getPSModuleName();
            }
            case 11: {
                return pSUWCreateDEBase.getPSSystemId();
            }
            case 12: {
                return pSUWCreateDEBase.getPSUWCreateDEId();
            }
            case 13: {
                return pSUWCreateDEBase.getPSUWCreateDEName();
            }
            case 14: {
                return pSUWCreateDEBase.getUpdateDate();
            }
            case 15: {
                return pSUWCreateDEBase.getUpdateMan();
            }
            case 16: {
                return pSUWCreateDEBase.getWizardData();
            }
            case 17: {
                return pSUWCreateDEBase.getWizardMode();
            }
            case 18: {
                return pSUWCreateDEBase.getWizardParam();
            }
            case 19: {
                return pSUWCreateDEBase.getWizardParam2();
            }
            case 20: {
                return pSUWCreateDEBase.getWizardParam3();
            }
            case 21: {
                return pSUWCreateDEBase.getWizardParam4();
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
        PSUWCreateDEBase.set(this, n, object);
    }

    private static void set(PSUWCreateDEBase pSUWCreateDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWCreateDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSUWCreateDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWCreateDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWCreateDEBase.setLogicValid(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSUWCreateDEBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWCreateDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWCreateDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWCreateDEBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWCreateDEBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWCreateDEBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWCreateDEBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWCreateDEBase.setPSUWCreateDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWCreateDEBase.setPSUWCreateDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWCreateDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSUWCreateDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSUWCreateDEBase.setWizardData(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSUWCreateDEBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSUWCreateDEBase.setWizardParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSUWCreateDEBase.setWizardParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSUWCreateDEBase.setWizardParam3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSUWCreateDEBase.setWizardParam4(DataObject.getIntegerValue((Object)object));
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
        return PSUWCreateDEBase.isNull(this, n);
    }

    private static boolean isNull(PSUWCreateDEBase pSUWCreateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEBase.getCodeName() == null;
            }
            case 1: {
                return pSUWCreateDEBase.getCreateDate() == null;
            }
            case 2: {
                return pSUWCreateDEBase.getCreateMan() == null;
            }
            case 3: {
                return pSUWCreateDEBase.getLogicName() == null;
            }
            case 4: {
                return pSUWCreateDEBase.getLogicValid() == null;
            }
            case 5: {
                return pSUWCreateDEBase.getPSDataEntityName() == null;
            }
            case 6: {
                return pSUWCreateDEBase.getPSDEId() == null;
            }
            case 7: {
                return pSUWCreateDEBase.getPSDEName() == null;
            }
            case 8: {
                return pSUWCreateDEBase.getPSDynaInstId() == null;
            }
            case 9: {
                return pSUWCreateDEBase.getPSModuleId() == null;
            }
            case 10: {
                return pSUWCreateDEBase.getPSModuleName() == null;
            }
            case 11: {
                return pSUWCreateDEBase.getPSSystemId() == null;
            }
            case 12: {
                return pSUWCreateDEBase.getPSUWCreateDEId() == null;
            }
            case 13: {
                return pSUWCreateDEBase.getPSUWCreateDEName() == null;
            }
            case 14: {
                return pSUWCreateDEBase.getUpdateDate() == null;
            }
            case 15: {
                return pSUWCreateDEBase.getUpdateMan() == null;
            }
            case 16: {
                return pSUWCreateDEBase.getWizardData() == null;
            }
            case 17: {
                return pSUWCreateDEBase.getWizardMode() == null;
            }
            case 18: {
                return pSUWCreateDEBase.getWizardParam() == null;
            }
            case 19: {
                return pSUWCreateDEBase.getWizardParam2() == null;
            }
            case 20: {
                return pSUWCreateDEBase.getWizardParam3() == null;
            }
            case 21: {
                return pSUWCreateDEBase.getWizardParam4() == null;
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
        return PSUWCreateDEBase.contains(this, n);
    }

    private static boolean contains(PSUWCreateDEBase pSUWCreateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWCreateDEBase.isCodeNameDirty();
            }
            case 1: {
                return pSUWCreateDEBase.isCreateDateDirty();
            }
            case 2: {
                return pSUWCreateDEBase.isCreateManDirty();
            }
            case 3: {
                return pSUWCreateDEBase.isLogicNameDirty();
            }
            case 4: {
                return pSUWCreateDEBase.isLogicValidDirty();
            }
            case 5: {
                return pSUWCreateDEBase.isPSDataEntityNameDirty();
            }
            case 6: {
                return pSUWCreateDEBase.isPSDEIdDirty();
            }
            case 7: {
                return pSUWCreateDEBase.isPSDENameDirty();
            }
            case 8: {
                return pSUWCreateDEBase.isPSDynaInstIdDirty();
            }
            case 9: {
                return pSUWCreateDEBase.isPSModuleIdDirty();
            }
            case 10: {
                return pSUWCreateDEBase.isPSModuleNameDirty();
            }
            case 11: {
                return pSUWCreateDEBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSUWCreateDEBase.isPSUWCreateDEIdDirty();
            }
            case 13: {
                return pSUWCreateDEBase.isPSUWCreateDENameDirty();
            }
            case 14: {
                return pSUWCreateDEBase.isUpdateDateDirty();
            }
            case 15: {
                return pSUWCreateDEBase.isUpdateManDirty();
            }
            case 16: {
                return pSUWCreateDEBase.isWizardDataDirty();
            }
            case 17: {
                return pSUWCreateDEBase.isWizardModeDirty();
            }
            case 18: {
                return pSUWCreateDEBase.isWizardParamDirty();
            }
            case 19: {
                return pSUWCreateDEBase.isWizardParam2Dirty();
            }
            case 20: {
                return pSUWCreateDEBase.isWizardParam3Dirty();
            }
            case 21: {
                return pSUWCreateDEBase.isWizardParam4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWCreateDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWCreateDEBase pSUWCreateDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWCreateDEBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getCodeName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getLogicValid() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicvalid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getLogicValid()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSUWCreateDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedeid", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSUWCreateDEId()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getPSUWCreateDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwcreatedename", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getPSUWCreateDEName()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizarddata", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardData()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSUWCreateDEBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSUWCreateDEBase.getJSONValue((Object)pSUWCreateDEBase.getWizardParam4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWCreateDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWCreateDEBase pSUWCreateDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWCreateDEBase.getCodeName() != null) {
            object = pSUWCreateDEBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getCreateDate() != null) {
            object = pSUWCreateDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEBase.getCreateMan() != null) {
            object = pSUWCreateDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getLogicName() != null) {
            object = pSUWCreateDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getLogicValid() != null) {
            object = pSUWCreateDEBase.getLogicValid();
            xmlNode.setAttribute(FIELD_LOGICVALID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEBase.getPSDataEntityName() != null) {
            object = pSUWCreateDEBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSDEId() != null) {
            object = pSUWCreateDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSDEName() != null) {
            object = pSUWCreateDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSDynaInstId() != null) {
            object = pSUWCreateDEBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSModuleId() != null) {
            object = pSUWCreateDEBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSModuleName() != null) {
            object = pSUWCreateDEBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSSystemId() != null) {
            object = pSUWCreateDEBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSUWCreateDEId() != null) {
            object = pSUWCreateDEBase.getPSUWCreateDEId();
            xmlNode.setAttribute(FIELD_PSUWCREATEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getPSUWCreateDEName() != null) {
            object = pSUWCreateDEBase.getPSUWCreateDEName();
            xmlNode.setAttribute(FIELD_PSUWCREATEDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getUpdateDate() != null) {
            object = pSUWCreateDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWCreateDEBase.getUpdateMan() != null) {
            object = pSUWCreateDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getWizardData() != null) {
            object = pSUWCreateDEBase.getWizardData();
            xmlNode.setAttribute(FIELD_WIZARDDATA, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getWizardMode() != null) {
            object = pSUWCreateDEBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getWizardParam() != null) {
            object = pSUWCreateDEBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getWizardParam2() != null) {
            object = pSUWCreateDEBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSUWCreateDEBase.getWizardParam3() != null) {
            object = pSUWCreateDEBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSUWCreateDEBase.getWizardParam4() != null) {
            object = pSUWCreateDEBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWCreateDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWCreateDEBase pSUWCreateDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWCreateDEBase.isCodeNameDirty() && (bl || pSUWCreateDEBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSUWCreateDEBase.getCodeName());
        }
        if (pSUWCreateDEBase.isCreateDateDirty() && (bl || pSUWCreateDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWCreateDEBase.getCreateDate());
        }
        if (pSUWCreateDEBase.isCreateManDirty() && (bl || pSUWCreateDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWCreateDEBase.getCreateMan());
        }
        if (pSUWCreateDEBase.isLogicNameDirty() && (bl || pSUWCreateDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSUWCreateDEBase.getLogicName());
        }
        if (pSUWCreateDEBase.isLogicValidDirty() && (bl || pSUWCreateDEBase.getLogicValid() != null)) {
            iDataObject.set(FIELD_LOGICVALID, (Object)pSUWCreateDEBase.getLogicValid());
        }
        if (pSUWCreateDEBase.isPSDataEntityNameDirty() && (bl || pSUWCreateDEBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSUWCreateDEBase.getPSDataEntityName());
        }
        if (pSUWCreateDEBase.isPSDEIdDirty() && (bl || pSUWCreateDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWCreateDEBase.getPSDEId());
        }
        if (pSUWCreateDEBase.isPSDENameDirty() && (bl || pSUWCreateDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSUWCreateDEBase.getPSDEName());
        }
        if (pSUWCreateDEBase.isPSDynaInstIdDirty() && (bl || pSUWCreateDEBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWCreateDEBase.getPSDynaInstId());
        }
        if (pSUWCreateDEBase.isPSModuleIdDirty() && (bl || pSUWCreateDEBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSUWCreateDEBase.getPSModuleId());
        }
        if (pSUWCreateDEBase.isPSModuleNameDirty() && (bl || pSUWCreateDEBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSUWCreateDEBase.getPSModuleName());
        }
        if (pSUWCreateDEBase.isPSSystemIdDirty() && (bl || pSUWCreateDEBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSUWCreateDEBase.getPSSystemId());
        }
        if (pSUWCreateDEBase.isPSUWCreateDEIdDirty() && (bl || pSUWCreateDEBase.getPSUWCreateDEId() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDEID, (Object)pSUWCreateDEBase.getPSUWCreateDEId());
        }
        if (pSUWCreateDEBase.isPSUWCreateDENameDirty() && (bl || pSUWCreateDEBase.getPSUWCreateDEName() != null)) {
            iDataObject.set(FIELD_PSUWCREATEDENAME, (Object)pSUWCreateDEBase.getPSUWCreateDEName());
        }
        if (pSUWCreateDEBase.isUpdateDateDirty() && (bl || pSUWCreateDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWCreateDEBase.getUpdateDate());
        }
        if (pSUWCreateDEBase.isUpdateManDirty() && (bl || pSUWCreateDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWCreateDEBase.getUpdateMan());
        }
        if (pSUWCreateDEBase.isWizardDataDirty() && (bl || pSUWCreateDEBase.getWizardData() != null)) {
            iDataObject.set(FIELD_WIZARDDATA, (Object)pSUWCreateDEBase.getWizardData());
        }
        if (pSUWCreateDEBase.isWizardModeDirty() && (bl || pSUWCreateDEBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSUWCreateDEBase.getWizardMode());
        }
        if (pSUWCreateDEBase.isWizardParamDirty() && (bl || pSUWCreateDEBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSUWCreateDEBase.getWizardParam());
        }
        if (pSUWCreateDEBase.isWizardParam2Dirty() && (bl || pSUWCreateDEBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSUWCreateDEBase.getWizardParam2());
        }
        if (pSUWCreateDEBase.isWizardParam3Dirty() && (bl || pSUWCreateDEBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSUWCreateDEBase.getWizardParam3());
        }
        if (pSUWCreateDEBase.isWizardParam4Dirty() && (bl || pSUWCreateDEBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSUWCreateDEBase.getWizardParam4());
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
        return PSUWCreateDEBase.remove(this, n);
    }

    private static boolean remove(PSUWCreateDEBase pSUWCreateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWCreateDEBase.resetCodeName();
                return true;
            }
            case 1: {
                pSUWCreateDEBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSUWCreateDEBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSUWCreateDEBase.resetLogicName();
                return true;
            }
            case 4: {
                pSUWCreateDEBase.resetLogicValid();
                return true;
            }
            case 5: {
                pSUWCreateDEBase.resetPSDataEntityName();
                return true;
            }
            case 6: {
                pSUWCreateDEBase.resetPSDEId();
                return true;
            }
            case 7: {
                pSUWCreateDEBase.resetPSDEName();
                return true;
            }
            case 8: {
                pSUWCreateDEBase.resetPSDynaInstId();
                return true;
            }
            case 9: {
                pSUWCreateDEBase.resetPSModuleId();
                return true;
            }
            case 10: {
                pSUWCreateDEBase.resetPSModuleName();
                return true;
            }
            case 11: {
                pSUWCreateDEBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSUWCreateDEBase.resetPSUWCreateDEId();
                return true;
            }
            case 13: {
                pSUWCreateDEBase.resetPSUWCreateDEName();
                return true;
            }
            case 14: {
                pSUWCreateDEBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSUWCreateDEBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSUWCreateDEBase.resetWizardData();
                return true;
            }
            case 17: {
                pSUWCreateDEBase.resetWizardMode();
                return true;
            }
            case 18: {
                pSUWCreateDEBase.resetWizardParam();
                return true;
            }
            case 19: {
                pSUWCreateDEBase.resetWizardParam2();
                return true;
            }
            case 20: {
                pSUWCreateDEBase.resetWizardParam3();
                return true;
            }
            case 21: {
                pSUWCreateDEBase.resetWizardParam4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUWCreateDEItem> getPSUWCreateDEItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWCreateDEItems();
        }
        if (this.getPSUWCreateDEId() == null) {
            return null;
        }
        PSUWCreateDEItemService pSUWCreateDEItemService = (PSUWCreateDEItemService)ServiceGlobal.getService(PSUWCreateDEItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUWCreateDEItemsLock;
        synchronized (n) {
            if (this.psuwcreatedeitems == null) {
                this.psuwcreatedeitems = pSUWCreateDEItemService.selectByPSUWCreateDE(this);
            }
            return this.psuwcreatedeitems;
        }
    }

    private PSUWCreateDEBase getProxyEntity() {
        return this.proxyPSUWCreateDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWCreateDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWCreateDEBase) {
            this.proxyPSUWCreateDEBase = (PSUWCreateDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_LOGICVALID, 4);
        fieldIndexMap.put(FIELD_PSDATAENTITYNAME, 5);
        fieldIndexMap.put(FIELD_PSDEID, 6);
        fieldIndexMap.put(FIELD_PSDENAME, 7);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 8);
        fieldIndexMap.put(FIELD_PSMODULEID, 9);
        fieldIndexMap.put(FIELD_PSMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSUWCREATEDEID, 12);
        fieldIndexMap.put(FIELD_PSUWCREATEDENAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_WIZARDDATA, 16);
        fieldIndexMap.put(FIELD_WIZARDMODE, 17);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 18);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 19);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 20);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 21);
    }
}

