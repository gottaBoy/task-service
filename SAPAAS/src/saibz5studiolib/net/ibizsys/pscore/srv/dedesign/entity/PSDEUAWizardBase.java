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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAWizardBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUAWizardBase.class);
    public static final String FIELD_ACTIONDATA = "ACTIONDATA";
    public static final String FIELD_ACTIONDATA2 = "ACTIONDATA2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSUAWIZARDID = "PSUAWIZARDID";
    public static final String FIELD_PSUAWIZARDNAME = "PSUAWIZARDNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WIZARDMODE = "WIZARDMODE";
    public static final String FIELD_WIZARDPARAM = "WIZARDPARAM";
    public static final String FIELD_WIZARDPARAM2 = "WIZARDPARAM2";
    public static final String FIELD_WIZARDPARAM3 = "WIZARDPARAM3";
    public static final String FIELD_WIZARDPARAM4 = "WIZARDPARAM4";
    public static final String FIELD_WIZARDPARAM5 = "WIZARDPARAM5";
    public static final String FIELD_WIZARDPARAM6 = "WIZARDPARAM6";
    private static final int INDEX_ACTIONDATA = 0;
    private static final int INDEX_ACTIONDATA2 = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_PSAPPMODULEID = 4;
    private static final int INDEX_PSAPPMODULENAME = 5;
    private static final int INDEX_PSDSCONSOLEID = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_PSSYSTEMNAME = 10;
    private static final int INDEX_PSUAWIZARDID = 11;
    private static final int INDEX_PSUAWIZARDNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_WIZARDMODE = 15;
    private static final int INDEX_WIZARDPARAM = 16;
    private static final int INDEX_WIZARDPARAM2 = 17;
    private static final int INDEX_WIZARDPARAM3 = 18;
    private static final int INDEX_WIZARDPARAM4 = 19;
    private static final int INDEX_WIZARDPARAM5 = 20;
    private static final int INDEX_WIZARDPARAM6 = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUAWizardBase proxyPSDEUAWizardBase = null;
    private boolean actiondataDirtyFlag = false;
    private boolean actiondata2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappmodulenameDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psuawizardidDirtyFlag = false;
    private boolean psuawizardnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wizardmodeDirtyFlag = false;
    private boolean wizardparamDirtyFlag = false;
    private boolean wizardparam2DirtyFlag = false;
    private boolean wizardparam3DirtyFlag = false;
    private boolean wizardparam4DirtyFlag = false;
    private boolean wizardparam5DirtyFlag = false;
    private boolean wizardparam6DirtyFlag = false;
    @Column(name="actiondata")
    private String actiondata;
    @Column(name="actiondata2")
    private String actiondata2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappmodulename")
    private String psappmodulename;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psuawizardid")
    private String psuawizardid;
    @Column(name="psuawizardname")
    private String psuawizardname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wizardmode")
    private String wizardmode;
    @Column(name="wizardparam")
    private Integer wizardparam;
    @Column(name="wizardparam2")
    private Integer wizardparam2;
    @Column(name="wizardparam3")
    private String wizardparam3;
    @Column(name="wizardparam4")
    private String wizardparam4;
    @Column(name="wizardparam5")
    private String wizardparam5;
    @Column(name="wizardparam6")
    private String wizardparam6;
    private Integer objPSAppModuleLock = new Integer(1);
    private PSAppModule psappmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setActionData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiondata = string;
        this.actiondataDirtyFlag = true;
    }

    public String getActionData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionData();
        }
        return this.actiondata;
    }

    public boolean isActionDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionDataDirty();
        }
        return this.actiondataDirtyFlag;
    }

    public void resetActionData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionData();
            return;
        }
        this.actiondataDirtyFlag = false;
        this.actiondata = null;
    }

    public void setActionData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.actiondata2 = string;
        this.actiondata2DirtyFlag = true;
    }

    public String getActionData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionData2();
        }
        return this.actiondata2;
    }

    public boolean isActionData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionData2Dirty();
        }
        return this.actiondata2DirtyFlag;
    }

    public void resetActionData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionData2();
            return;
        }
        this.actiondata2DirtyFlag = false;
        this.actiondata2 = null;
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

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmodulename = string;
        this.psappmodulenameDirtyFlag = true;
    }

    public String getPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleName();
        }
        return this.psappmodulename;
    }

    public boolean isPSAppModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleNameDirty();
        }
        return this.psappmodulenameDirtyFlag;
    }

    public void resetPSAppModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleName();
            return;
        }
        this.psappmodulenameDirtyFlag = false;
        this.psappmodulename = null;
    }

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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

    public void setPSUAWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizardid = string;
        this.psuawizardidDirtyFlag = true;
    }

    public String getPSUAWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizardId();
        }
        return this.psuawizardid;
    }

    public boolean isPSUAWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizardIdDirty();
        }
        return this.psuawizardidDirtyFlag;
    }

    public void resetPSUAWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizardId();
            return;
        }
        this.psuawizardidDirtyFlag = false;
        this.psuawizardid = null;
    }

    public void setPSUAWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUAWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuawizardname = string;
        this.psuawizardnameDirtyFlag = true;
    }

    public String getPSUAWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUAWizardName();
        }
        return this.psuawizardname;
    }

    public boolean isPSUAWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUAWizardNameDirty();
        }
        return this.psuawizardnameDirtyFlag;
    }

    public void resetPSUAWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUAWizardName();
            return;
        }
        this.psuawizardnameDirtyFlag = false;
        this.psuawizardname = null;
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

    public void setWizardParam(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam(n);
            return;
        }
        this.wizardparam = n;
        this.wizardparamDirtyFlag = true;
    }

    public Integer getWizardParam() {
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

    public void setWizardParam2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam2(n);
            return;
        }
        this.wizardparam2 = n;
        this.wizardparam2DirtyFlag = true;
    }

    public Integer getWizardParam2() {
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

    public void setWizardParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam3 = string;
        this.wizardparam3DirtyFlag = true;
    }

    public String getWizardParam3() {
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

    public void setWizardParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam4 = string;
        this.wizardparam4DirtyFlag = true;
    }

    public String getWizardParam4() {
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

    public void setWizardParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam5 = string;
        this.wizardparam5DirtyFlag = true;
    }

    public String getWizardParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam5();
        }
        return this.wizardparam5;
    }

    public boolean isWizardParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam5Dirty();
        }
        return this.wizardparam5DirtyFlag;
    }

    public void resetWizardParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam5();
            return;
        }
        this.wizardparam5DirtyFlag = false;
        this.wizardparam5 = null;
    }

    public void setWizardParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWizardParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wizardparam6 = string;
        this.wizardparam6DirtyFlag = true;
    }

    public String getWizardParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWizardParam6();
        }
        return this.wizardparam6;
    }

    public boolean isWizardParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWizardParam6Dirty();
        }
        return this.wizardparam6DirtyFlag;
    }

    public void resetWizardParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWizardParam6();
            return;
        }
        this.wizardparam6DirtyFlag = false;
        this.wizardparam6 = null;
    }

    protected void onReset() {
        PSDEUAWizardBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUAWizardBase pSDEUAWizardBase) {
        pSDEUAWizardBase.resetActionData();
        pSDEUAWizardBase.resetActionData2();
        pSDEUAWizardBase.resetCreateDate();
        pSDEUAWizardBase.resetCreateMan();
        pSDEUAWizardBase.resetPSAppModuleId();
        pSDEUAWizardBase.resetPSAppModuleName();
        pSDEUAWizardBase.resetPSDSConsoleId();
        pSDEUAWizardBase.resetPSSysAppId();
        pSDEUAWizardBase.resetPSSysAppName();
        pSDEUAWizardBase.resetPSSystemId();
        pSDEUAWizardBase.resetPSSystemName();
        pSDEUAWizardBase.resetPSUAWizardId();
        pSDEUAWizardBase.resetPSUAWizardName();
        pSDEUAWizardBase.resetUpdateDate();
        pSDEUAWizardBase.resetUpdateMan();
        pSDEUAWizardBase.resetWizardMode();
        pSDEUAWizardBase.resetWizardParam();
        pSDEUAWizardBase.resetWizardParam2();
        pSDEUAWizardBase.resetWizardParam3();
        pSDEUAWizardBase.resetWizardParam4();
        pSDEUAWizardBase.resetWizardParam5();
        pSDEUAWizardBase.resetWizardParam6();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionDataDirty()) {
            hashMap.put(FIELD_ACTIONDATA, this.getActionData());
        }
        if (!bl || this.isActionData2Dirty()) {
            hashMap.put(FIELD_ACTIONDATA2, this.getActionData2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppModuleNameDirty()) {
            hashMap.put(FIELD_PSAPPMODULENAME, this.getPSAppModuleName());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSUAWizardIdDirty()) {
            hashMap.put(FIELD_PSUAWIZARDID, this.getPSUAWizardId());
        }
        if (!bl || this.isPSUAWizardNameDirty()) {
            hashMap.put(FIELD_PSUAWIZARDNAME, this.getPSUAWizardName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        if (!bl || this.isWizardParam5Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM5, this.getWizardParam5());
        }
        if (!bl || this.isWizardParam6Dirty()) {
            hashMap.put(FIELD_WIZARDPARAM6, this.getWizardParam6());
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
        return PSDEUAWizardBase.get(this, n);
    }

    private static Object get(PSDEUAWizardBase pSDEUAWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAWizardBase.getActionData();
            }
            case 1: {
                return pSDEUAWizardBase.getActionData2();
            }
            case 2: {
                return pSDEUAWizardBase.getCreateDate();
            }
            case 3: {
                return pSDEUAWizardBase.getCreateMan();
            }
            case 4: {
                return pSDEUAWizardBase.getPSAppModuleId();
            }
            case 5: {
                return pSDEUAWizardBase.getPSAppModuleName();
            }
            case 6: {
                return pSDEUAWizardBase.getPSDSConsoleId();
            }
            case 7: {
                return pSDEUAWizardBase.getPSSysAppId();
            }
            case 8: {
                return pSDEUAWizardBase.getPSSysAppName();
            }
            case 9: {
                return pSDEUAWizardBase.getPSSystemId();
            }
            case 10: {
                return pSDEUAWizardBase.getPSSystemName();
            }
            case 11: {
                return pSDEUAWizardBase.getPSUAWizardId();
            }
            case 12: {
                return pSDEUAWizardBase.getPSUAWizardName();
            }
            case 13: {
                return pSDEUAWizardBase.getUpdateDate();
            }
            case 14: {
                return pSDEUAWizardBase.getUpdateMan();
            }
            case 15: {
                return pSDEUAWizardBase.getWizardMode();
            }
            case 16: {
                return pSDEUAWizardBase.getWizardParam();
            }
            case 17: {
                return pSDEUAWizardBase.getWizardParam2();
            }
            case 18: {
                return pSDEUAWizardBase.getWizardParam3();
            }
            case 19: {
                return pSDEUAWizardBase.getWizardParam4();
            }
            case 20: {
                return pSDEUAWizardBase.getWizardParam5();
            }
            case 21: {
                return pSDEUAWizardBase.getWizardParam6();
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
        PSDEUAWizardBase.set(this, n, object);
    }

    private static void set(PSDEUAWizardBase pSDEUAWizardBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAWizardBase.setActionData(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEUAWizardBase.setActionData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEUAWizardBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEUAWizardBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUAWizardBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUAWizardBase.setPSAppModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUAWizardBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUAWizardBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUAWizardBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUAWizardBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUAWizardBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUAWizardBase.setPSUAWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUAWizardBase.setPSUAWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUAWizardBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDEUAWizardBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUAWizardBase.setWizardMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUAWizardBase.setWizardParam(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDEUAWizardBase.setWizardParam2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDEUAWizardBase.setWizardParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUAWizardBase.setWizardParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEUAWizardBase.setWizardParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEUAWizardBase.setWizardParam6(DataObject.getStringValue((Object)object));
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
        return PSDEUAWizardBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUAWizardBase pSDEUAWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAWizardBase.getActionData() == null;
            }
            case 1: {
                return pSDEUAWizardBase.getActionData2() == null;
            }
            case 2: {
                return pSDEUAWizardBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEUAWizardBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEUAWizardBase.getPSAppModuleId() == null;
            }
            case 5: {
                return pSDEUAWizardBase.getPSAppModuleName() == null;
            }
            case 6: {
                return pSDEUAWizardBase.getPSDSConsoleId() == null;
            }
            case 7: {
                return pSDEUAWizardBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSDEUAWizardBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSDEUAWizardBase.getPSSystemId() == null;
            }
            case 10: {
                return pSDEUAWizardBase.getPSSystemName() == null;
            }
            case 11: {
                return pSDEUAWizardBase.getPSUAWizardId() == null;
            }
            case 12: {
                return pSDEUAWizardBase.getPSUAWizardName() == null;
            }
            case 13: {
                return pSDEUAWizardBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDEUAWizardBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDEUAWizardBase.getWizardMode() == null;
            }
            case 16: {
                return pSDEUAWizardBase.getWizardParam() == null;
            }
            case 17: {
                return pSDEUAWizardBase.getWizardParam2() == null;
            }
            case 18: {
                return pSDEUAWizardBase.getWizardParam3() == null;
            }
            case 19: {
                return pSDEUAWizardBase.getWizardParam4() == null;
            }
            case 20: {
                return pSDEUAWizardBase.getWizardParam5() == null;
            }
            case 21: {
                return pSDEUAWizardBase.getWizardParam6() == null;
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
        return PSDEUAWizardBase.contains(this, n);
    }

    private static boolean contains(PSDEUAWizardBase pSDEUAWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAWizardBase.isActionDataDirty();
            }
            case 1: {
                return pSDEUAWizardBase.isActionData2Dirty();
            }
            case 2: {
                return pSDEUAWizardBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEUAWizardBase.isCreateManDirty();
            }
            case 4: {
                return pSDEUAWizardBase.isPSAppModuleIdDirty();
            }
            case 5: {
                return pSDEUAWizardBase.isPSAppModuleNameDirty();
            }
            case 6: {
                return pSDEUAWizardBase.isPSDSConsoleIdDirty();
            }
            case 7: {
                return pSDEUAWizardBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSDEUAWizardBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSDEUAWizardBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSDEUAWizardBase.isPSSystemNameDirty();
            }
            case 11: {
                return pSDEUAWizardBase.isPSUAWizardIdDirty();
            }
            case 12: {
                return pSDEUAWizardBase.isPSUAWizardNameDirty();
            }
            case 13: {
                return pSDEUAWizardBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDEUAWizardBase.isUpdateManDirty();
            }
            case 15: {
                return pSDEUAWizardBase.isWizardModeDirty();
            }
            case 16: {
                return pSDEUAWizardBase.isWizardParamDirty();
            }
            case 17: {
                return pSDEUAWizardBase.isWizardParam2Dirty();
            }
            case 18: {
                return pSDEUAWizardBase.isWizardParam3Dirty();
            }
            case 19: {
                return pSDEUAWizardBase.isWizardParam4Dirty();
            }
            case 20: {
                return pSDEUAWizardBase.isWizardParam5Dirty();
            }
            case 21: {
                return pSDEUAWizardBase.isWizardParam6Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUAWizardBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUAWizardBase pSDEUAWizardBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUAWizardBase.getActionData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiondata", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getActionData()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getActionData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actiondata2", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getActionData2()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSAppModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmodulename", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSAppModuleName()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSUAWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizardid", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSUAWizardId()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getPSUAWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuawizardname", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getPSUAWizardName()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardmode", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardMode()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam2", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam2()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam3", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam3()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam4", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam4()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam5", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam5()), (boolean)false);
        }
        if (bl || pSDEUAWizardBase.getWizardParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wizardparam6", (Object)PSDEUAWizardBase.getJSONValue((Object)pSDEUAWizardBase.getWizardParam6()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUAWizardBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUAWizardBase pSDEUAWizardBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUAWizardBase.getActionData() != null) {
            object = pSDEUAWizardBase.getActionData();
            xmlNode.setAttribute(FIELD_ACTIONDATA, (String)(object == null ? "" : object));
        }
        if (bl || pSDEUAWizardBase.getActionData2() != null) {
            object = pSDEUAWizardBase.getActionData2();
            xmlNode.setAttribute(FIELD_ACTIONDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getCreateDate() != null) {
            object = pSDEUAWizardBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAWizardBase.getCreateMan() != null) {
            object = pSDEUAWizardBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSAppModuleId() != null) {
            object = pSDEUAWizardBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSAppModuleName() != null) {
            object = pSDEUAWizardBase.getPSAppModuleName();
            xmlNode.setAttribute(FIELD_PSAPPMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSDSConsoleId() != null) {
            object = pSDEUAWizardBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSSysAppId() != null) {
            object = pSDEUAWizardBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSSysAppName() != null) {
            object = pSDEUAWizardBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSSystemId() != null) {
            object = pSDEUAWizardBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSSystemName() != null) {
            object = pSDEUAWizardBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSUAWizardId() != null) {
            object = pSDEUAWizardBase.getPSUAWizardId();
            xmlNode.setAttribute(FIELD_PSUAWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getPSUAWizardName() != null) {
            object = pSDEUAWizardBase.getPSUAWizardName();
            xmlNode.setAttribute(FIELD_PSUAWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getUpdateDate() != null) {
            object = pSDEUAWizardBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAWizardBase.getUpdateMan() != null) {
            object = pSDEUAWizardBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getWizardMode() != null) {
            object = pSDEUAWizardBase.getWizardMode();
            xmlNode.setAttribute(FIELD_WIZARDMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getWizardParam() != null) {
            object = pSDEUAWizardBase.getWizardParam();
            xmlNode.setAttribute(FIELD_WIZARDPARAM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAWizardBase.getWizardParam2() != null) {
            object = pSDEUAWizardBase.getWizardParam2();
            xmlNode.setAttribute(FIELD_WIZARDPARAM2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAWizardBase.getWizardParam3() != null) {
            object = pSDEUAWizardBase.getWizardParam3();
            xmlNode.setAttribute(FIELD_WIZARDPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getWizardParam4() != null) {
            object = pSDEUAWizardBase.getWizardParam4();
            xmlNode.setAttribute(FIELD_WIZARDPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getWizardParam5() != null) {
            object = pSDEUAWizardBase.getWizardParam5();
            xmlNode.setAttribute(FIELD_WIZARDPARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAWizardBase.getWizardParam6() != null) {
            object = pSDEUAWizardBase.getWizardParam6();
            xmlNode.setAttribute(FIELD_WIZARDPARAM6, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUAWizardBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUAWizardBase pSDEUAWizardBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUAWizardBase.isActionDataDirty() && (bl || pSDEUAWizardBase.getActionData() != null)) {
            iDataObject.set(FIELD_ACTIONDATA, (Object)pSDEUAWizardBase.getActionData());
        }
        if (pSDEUAWizardBase.isActionData2Dirty() && (bl || pSDEUAWizardBase.getActionData2() != null)) {
            iDataObject.set(FIELD_ACTIONDATA2, (Object)pSDEUAWizardBase.getActionData2());
        }
        if (pSDEUAWizardBase.isCreateDateDirty() && (bl || pSDEUAWizardBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUAWizardBase.getCreateDate());
        }
        if (pSDEUAWizardBase.isCreateManDirty() && (bl || pSDEUAWizardBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUAWizardBase.getCreateMan());
        }
        if (pSDEUAWizardBase.isPSAppModuleIdDirty() && (bl || pSDEUAWizardBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSDEUAWizardBase.getPSAppModuleId());
        }
        if (pSDEUAWizardBase.isPSAppModuleNameDirty() && (bl || pSDEUAWizardBase.getPSAppModuleName() != null)) {
            iDataObject.set(FIELD_PSAPPMODULENAME, (Object)pSDEUAWizardBase.getPSAppModuleName());
        }
        if (pSDEUAWizardBase.isPSDSConsoleIdDirty() && (bl || pSDEUAWizardBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSDEUAWizardBase.getPSDSConsoleId());
        }
        if (pSDEUAWizardBase.isPSSysAppIdDirty() && (bl || pSDEUAWizardBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDEUAWizardBase.getPSSysAppId());
        }
        if (pSDEUAWizardBase.isPSSysAppNameDirty() && (bl || pSDEUAWizardBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDEUAWizardBase.getPSSysAppName());
        }
        if (pSDEUAWizardBase.isPSSystemIdDirty() && (bl || pSDEUAWizardBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEUAWizardBase.getPSSystemId());
        }
        if (pSDEUAWizardBase.isPSSystemNameDirty() && (bl || pSDEUAWizardBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEUAWizardBase.getPSSystemName());
        }
        if (pSDEUAWizardBase.isPSUAWizardIdDirty() && (bl || pSDEUAWizardBase.getPSUAWizardId() != null)) {
            iDataObject.set(FIELD_PSUAWIZARDID, (Object)pSDEUAWizardBase.getPSUAWizardId());
        }
        if (pSDEUAWizardBase.isPSUAWizardNameDirty() && (bl || pSDEUAWizardBase.getPSUAWizardName() != null)) {
            iDataObject.set(FIELD_PSUAWIZARDNAME, (Object)pSDEUAWizardBase.getPSUAWizardName());
        }
        if (pSDEUAWizardBase.isUpdateDateDirty() && (bl || pSDEUAWizardBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUAWizardBase.getUpdateDate());
        }
        if (pSDEUAWizardBase.isUpdateManDirty() && (bl || pSDEUAWizardBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUAWizardBase.getUpdateMan());
        }
        if (pSDEUAWizardBase.isWizardModeDirty() && (bl || pSDEUAWizardBase.getWizardMode() != null)) {
            iDataObject.set(FIELD_WIZARDMODE, (Object)pSDEUAWizardBase.getWizardMode());
        }
        if (pSDEUAWizardBase.isWizardParamDirty() && (bl || pSDEUAWizardBase.getWizardParam() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM, (Object)pSDEUAWizardBase.getWizardParam());
        }
        if (pSDEUAWizardBase.isWizardParam2Dirty() && (bl || pSDEUAWizardBase.getWizardParam2() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM2, (Object)pSDEUAWizardBase.getWizardParam2());
        }
        if (pSDEUAWizardBase.isWizardParam3Dirty() && (bl || pSDEUAWizardBase.getWizardParam3() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM3, (Object)pSDEUAWizardBase.getWizardParam3());
        }
        if (pSDEUAWizardBase.isWizardParam4Dirty() && (bl || pSDEUAWizardBase.getWizardParam4() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM4, (Object)pSDEUAWizardBase.getWizardParam4());
        }
        if (pSDEUAWizardBase.isWizardParam5Dirty() && (bl || pSDEUAWizardBase.getWizardParam5() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM5, (Object)pSDEUAWizardBase.getWizardParam5());
        }
        if (pSDEUAWizardBase.isWizardParam6Dirty() && (bl || pSDEUAWizardBase.getWizardParam6() != null)) {
            iDataObject.set(FIELD_WIZARDPARAM6, (Object)pSDEUAWizardBase.getWizardParam6());
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
        return PSDEUAWizardBase.remove(this, n);
    }

    private static boolean remove(PSDEUAWizardBase pSDEUAWizardBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAWizardBase.resetActionData();
                return true;
            }
            case 1: {
                pSDEUAWizardBase.resetActionData2();
                return true;
            }
            case 2: {
                pSDEUAWizardBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEUAWizardBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEUAWizardBase.resetPSAppModuleId();
                return true;
            }
            case 5: {
                pSDEUAWizardBase.resetPSAppModuleName();
                return true;
            }
            case 6: {
                pSDEUAWizardBase.resetPSDSConsoleId();
                return true;
            }
            case 7: {
                pSDEUAWizardBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSDEUAWizardBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSDEUAWizardBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSDEUAWizardBase.resetPSSystemName();
                return true;
            }
            case 11: {
                pSDEUAWizardBase.resetPSUAWizardId();
                return true;
            }
            case 12: {
                pSDEUAWizardBase.resetPSUAWizardName();
                return true;
            }
            case 13: {
                pSDEUAWizardBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDEUAWizardBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDEUAWizardBase.resetWizardMode();
                return true;
            }
            case 16: {
                pSDEUAWizardBase.resetWizardParam();
                return true;
            }
            case 17: {
                pSDEUAWizardBase.resetWizardParam2();
                return true;
            }
            case 18: {
                pSDEUAWizardBase.resetWizardParam3();
                return true;
            }
            case 19: {
                pSDEUAWizardBase.resetWizardParam4();
                return true;
            }
            case 20: {
                pSDEUAWizardBase.resetWizardParam5();
                return true;
            }
            case 21: {
                pSDEUAWizardBase.resetWizardParam6();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppModule getPSAppModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModule();
        }
        if (this.getPSAppModuleId() == null) {
            return null;
        }
        Integer n = this.objPSAppModuleLock;
        synchronized (n) {
            if (this.psappmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppModuleId(), (Object)this.psappmodule.getPSAppModuleId()) != 0L) {
                this.psappmodule = null;
            }
            if (this.psappmodule == null) {
                PSAppModule pSAppModule = new PSAppModule();
                pSAppModule.setPSAppModuleId(this.getPSAppModuleId());
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                pSAppModuleService.autoGet((IEntity)pSAppModule);
                this.psappmodule = pSAppModule;
            }
            return this.psappmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSDEUAWizardBase getProxyEntity() {
        return this.proxyPSDEUAWizardBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUAWizardBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUAWizardBase) {
            this.proxyPSDEUAWizardBase = (PSDEUAWizardBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONDATA, 0);
        fieldIndexMap.put(FIELD_ACTIONDATA2, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 4);
        fieldIndexMap.put(FIELD_PSAPPMODULENAME, 5);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_PSUAWIZARDID, 11);
        fieldIndexMap.put(FIELD_PSUAWIZARDNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_WIZARDMODE, 15);
        fieldIndexMap.put(FIELD_WIZARDPARAM, 16);
        fieldIndexMap.put(FIELD_WIZARDPARAM2, 17);
        fieldIndexMap.put(FIELD_WIZARDPARAM3, 18);
        fieldIndexMap.put(FIELD_WIZARDPARAM4, 19);
        fieldIndexMap.put(FIELD_WIZARDPARAM5, 20);
        fieldIndexMap.put(FIELD_WIZARDPARAM6, 21);
    }
}

