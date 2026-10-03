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
package net.ibizsys.pscore.srv.eaidesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAISchemeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAISchemeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAISCHEMETAG = "EAISCHEMETAG";
    public static final String FIELD_EAISCHEMETAG2 = "EAISCHEMETAG2";
    public static final String FIELD_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String FIELD_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String FIELD_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String FIELD_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SCHEMEPARAMS = "SCHEMEPARAMS";
    public static final String FIELD_SERVICECODENAME = "SERVICECODENAME";
    public static final String FIELD_SUBSYSSERVICECODENAME = "SUBSYSSERVICECODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_EAISCHEMETAG = 3;
    private static final int INDEX_EAISCHEMETAG2 = 4;
    private static final int INDEX_ENABLESERVICEAPI = 5;
    private static final int INDEX_ENABLESUBSYSSERVICEAPI = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSMODULEID = 9;
    private static final int INDEX_PSMODULENAME = 10;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 11;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 12;
    private static final int INDEX_PSSYSDYNAMODELID = 13;
    private static final int INDEX_PSSYSDYNAMODELNAME = 14;
    private static final int INDEX_PSSYSEAISCHEMEID = 15;
    private static final int INDEX_PSSYSEAISCHEMENAME = 16;
    private static final int INDEX_PSSYSSERVICEAPIID = 17;
    private static final int INDEX_PSSYSSERVICEAPINAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_SCHEMEPARAMS = 23;
    private static final int INDEX_SERVICECODENAME = 24;
    private static final int INDEX_SUBSYSSERVICECODENAME = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAISchemeBase proxyPSSysEAISchemeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaischemetagDirtyFlag = false;
    private boolean eaischemetag2DirtyFlag = false;
    private boolean enableserviceapiDirtyFlag = false;
    private boolean enablesubsysserviceapiDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
    private boolean pssysserviceapiidDirtyFlag = false;
    private boolean pssysserviceapinameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean schemeparamsDirtyFlag = false;
    private boolean servicecodenameDirtyFlag = false;
    private boolean subsysservicecodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="eaischemetag")
    private String eaischemetag;
    @Column(name="eaischemetag2")
    private String eaischemetag2;
    @Column(name="enableserviceapi")
    private Integer enableserviceapi;
    @Column(name="enablesubsysserviceapi")
    private Integer enablesubsysserviceapi;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
    @Column(name="pssysserviceapiid")
    private String pssysserviceapiid;
    @Column(name="pssysserviceapiname")
    private String pssysserviceapiname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="schemeparams")
    private String schemeparams;
    @Column(name="servicecodename")
    private String servicecodename;
    @Column(name="subsysservicecodename")
    private String subsysservicecodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysServiceAPILock = new Integer(1);
    private PSSysServiceAPI pssysserviceapi = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysEAIDataTypesLock = new Integer(1);
    private ArrayList<PSSysEAIDataType> pssyseaidatatypes = null;
    private Integer objPSSysEAIDEsLock = new Integer(1);
    private ArrayList<PSSysEAIDE> pssyseaides = null;
    private Integer objPSSysEAIElementsLock = new Integer(1);
    private ArrayList<PSSysEAIElement> pssyseaielements = null;

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

    public void setEAISchemeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAISchemeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaischemetag = string;
        this.eaischemetagDirtyFlag = true;
    }

    public String getEAISchemeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAISchemeTag();
        }
        return this.eaischemetag;
    }

    public boolean isEAISchemeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAISchemeTagDirty();
        }
        return this.eaischemetagDirtyFlag;
    }

    public void resetEAISchemeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAISchemeTag();
            return;
        }
        this.eaischemetagDirtyFlag = false;
        this.eaischemetag = null;
    }

    public void setEAISchemeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAISchemeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaischemetag2 = string;
        this.eaischemetag2DirtyFlag = true;
    }

    public String getEAISchemeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAISchemeTag2();
        }
        return this.eaischemetag2;
    }

    public boolean isEAISchemeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAISchemeTag2Dirty();
        }
        return this.eaischemetag2DirtyFlag;
    }

    public void resetEAISchemeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAISchemeTag2();
            return;
        }
        this.eaischemetag2DirtyFlag = false;
        this.eaischemetag2 = null;
    }

    public void setEnableServiceAPI(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableServiceAPI(n);
            return;
        }
        this.enableserviceapi = n;
        this.enableserviceapiDirtyFlag = true;
    }

    public Integer getEnableServiceAPI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableServiceAPI();
        }
        return this.enableserviceapi;
    }

    public boolean isEnableServiceAPIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableServiceAPIDirty();
        }
        return this.enableserviceapiDirtyFlag;
    }

    public void resetEnableServiceAPI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableServiceAPI();
            return;
        }
        this.enableserviceapiDirtyFlag = false;
        this.enableserviceapi = null;
    }

    public void setEnableSubSysServiceAPI(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSubSysServiceAPI(n);
            return;
        }
        this.enablesubsysserviceapi = n;
        this.enablesubsysserviceapiDirtyFlag = true;
    }

    public Integer getEnableSubSysServiceAPI() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSubSysServiceAPI();
        }
        return this.enablesubsysserviceapi;
    }

    public boolean isEnableSubSysServiceAPIDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSubSysServiceAPIDirty();
        }
        return this.enablesubsysserviceapiDirtyFlag;
    }

    public void resetEnableSubSysServiceAPI() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSubSysServiceAPI();
            return;
        }
        this.enablesubsysserviceapiDirtyFlag = false;
        this.enablesubsysserviceapi = null;
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

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
    }

    public void setPSSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiid = string;
        this.pssysserviceapiidDirtyFlag = true;
    }

    public String getPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIId();
        }
        return this.pssysserviceapiid;
    }

    public boolean isPSSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPIIdDirty();
        }
        return this.pssysserviceapiidDirtyFlag;
    }

    public void resetPSSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIId();
            return;
        }
        this.pssysserviceapiidDirtyFlag = false;
        this.pssysserviceapiid = null;
    }

    public void setPSSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysserviceapiname = string;
        this.pssysserviceapinameDirtyFlag = true;
    }

    public String getPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPIName();
        }
        return this.pssysserviceapiname;
    }

    public boolean isPSSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysServiceAPINameDirty();
        }
        return this.pssysserviceapinameDirtyFlag;
    }

    public void resetPSSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysServiceAPIName();
            return;
        }
        this.pssysserviceapinameDirtyFlag = false;
        this.pssysserviceapiname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setSchemeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSchemeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.schemeparams = string;
        this.schemeparamsDirtyFlag = true;
    }

    public String getSchemeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSchemeParams();
        }
        return this.schemeparams;
    }

    public boolean isSchemeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSchemeParamsDirty();
        }
        return this.schemeparamsDirtyFlag;
    }

    public void resetSchemeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSchemeParams();
            return;
        }
        this.schemeparamsDirtyFlag = false;
        this.schemeparams = null;
    }

    public void setServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.servicecodename = string;
        this.servicecodenameDirtyFlag = true;
    }

    public String getServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceCodeName();
        }
        return this.servicecodename;
    }

    public boolean isServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceCodeNameDirty();
        }
        return this.servicecodenameDirtyFlag;
    }

    public void resetServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceCodeName();
            return;
        }
        this.servicecodenameDirtyFlag = false;
        this.servicecodename = null;
    }

    public void setSubSysServiceCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSubSysServiceCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.subsysservicecodename = string;
        this.subsysservicecodenameDirtyFlag = true;
    }

    public String getSubSysServiceCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSubSysServiceCodeName();
        }
        return this.subsysservicecodename;
    }

    public boolean isSubSysServiceCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSubSysServiceCodeNameDirty();
        }
        return this.subsysservicecodenameDirtyFlag;
    }

    public void resetSubSysServiceCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSubSysServiceCodeName();
            return;
        }
        this.subsysservicecodenameDirtyFlag = false;
        this.subsysservicecodename = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSSysEAISchemeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAISchemeBase pSSysEAISchemeBase) {
        pSSysEAISchemeBase.resetCodeName();
        pSSysEAISchemeBase.resetCreateDate();
        pSSysEAISchemeBase.resetCreateMan();
        pSSysEAISchemeBase.resetEAISchemeTag();
        pSSysEAISchemeBase.resetEAISchemeTag2();
        pSSysEAISchemeBase.resetEnableServiceAPI();
        pSSysEAISchemeBase.resetEnableSubSysServiceAPI();
        pSSysEAISchemeBase.resetMemo();
        pSSysEAISchemeBase.resetOrderValue();
        pSSysEAISchemeBase.resetPSModuleId();
        pSSysEAISchemeBase.resetPSModuleName();
        pSSysEAISchemeBase.resetPSSubSysServiceAPIId();
        pSSysEAISchemeBase.resetPSSubSysServiceAPIName();
        pSSysEAISchemeBase.resetPSSysDynaModelId();
        pSSysEAISchemeBase.resetPSSysDynaModelName();
        pSSysEAISchemeBase.resetPSSysEAISchemeId();
        pSSysEAISchemeBase.resetPSSysEAISchemeName();
        pSSysEAISchemeBase.resetPSSysServiceAPIId();
        pSSysEAISchemeBase.resetPSSysServiceAPIName();
        pSSysEAISchemeBase.resetPSSysSFPluginId();
        pSSysEAISchemeBase.resetPSSysSFPluginName();
        pSSysEAISchemeBase.resetPSSystemId();
        pSSysEAISchemeBase.resetPSSystemName();
        pSSysEAISchemeBase.resetSchemeParams();
        pSSysEAISchemeBase.resetServiceCodeName();
        pSSysEAISchemeBase.resetSubSysServiceCodeName();
        pSSysEAISchemeBase.resetUpdateDate();
        pSSysEAISchemeBase.resetUpdateMan();
        pSSysEAISchemeBase.resetUserCat();
        pSSysEAISchemeBase.resetUserTag();
        pSSysEAISchemeBase.resetUserTag2();
        pSSysEAISchemeBase.resetUserTag3();
        pSSysEAISchemeBase.resetUserTag4();
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
        if (!bl || this.isEAISchemeTagDirty()) {
            hashMap.put(FIELD_EAISCHEMETAG, this.getEAISchemeTag());
        }
        if (!bl || this.isEAISchemeTag2Dirty()) {
            hashMap.put(FIELD_EAISCHEMETAG2, this.getEAISchemeTag2());
        }
        if (!bl || this.isEnableServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESERVICEAPI, this.getEnableServiceAPI());
        }
        if (!bl || this.isEnableSubSysServiceAPIDirty()) {
            hashMap.put(FIELD_ENABLESUBSYSSERVICEAPI, this.getEnableSubSysServiceAPI());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
        }
        if (!bl || this.isPSSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPIID, this.getPSSysServiceAPIId());
        }
        if (!bl || this.isPSSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSYSSERVICEAPINAME, this.getPSSysServiceAPIName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isSchemeParamsDirty()) {
            hashMap.put(FIELD_SCHEMEPARAMS, this.getSchemeParams());
        }
        if (!bl || this.isServiceCodeNameDirty()) {
            hashMap.put(FIELD_SERVICECODENAME, this.getServiceCodeName());
        }
        if (!bl || this.isSubSysServiceCodeNameDirty()) {
            hashMap.put(FIELD_SUBSYSSERVICECODENAME, this.getSubSysServiceCodeName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSSysEAISchemeBase.get(this, n);
    }

    private static Object get(PSSysEAISchemeBase pSSysEAISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAISchemeBase.getCodeName();
            }
            case 1: {
                return pSSysEAISchemeBase.getCreateDate();
            }
            case 2: {
                return pSSysEAISchemeBase.getCreateMan();
            }
            case 3: {
                return pSSysEAISchemeBase.getEAISchemeTag();
            }
            case 4: {
                return pSSysEAISchemeBase.getEAISchemeTag2();
            }
            case 5: {
                return pSSysEAISchemeBase.getEnableServiceAPI();
            }
            case 6: {
                return pSSysEAISchemeBase.getEnableSubSysServiceAPI();
            }
            case 7: {
                return pSSysEAISchemeBase.getMemo();
            }
            case 8: {
                return pSSysEAISchemeBase.getOrderValue();
            }
            case 9: {
                return pSSysEAISchemeBase.getPSModuleId();
            }
            case 10: {
                return pSSysEAISchemeBase.getPSModuleName();
            }
            case 11: {
                return pSSysEAISchemeBase.getPSSubSysServiceAPIId();
            }
            case 12: {
                return pSSysEAISchemeBase.getPSSubSysServiceAPIName();
            }
            case 13: {
                return pSSysEAISchemeBase.getPSSysDynaModelId();
            }
            case 14: {
                return pSSysEAISchemeBase.getPSSysDynaModelName();
            }
            case 15: {
                return pSSysEAISchemeBase.getPSSysEAISchemeId();
            }
            case 16: {
                return pSSysEAISchemeBase.getPSSysEAISchemeName();
            }
            case 17: {
                return pSSysEAISchemeBase.getPSSysServiceAPIId();
            }
            case 18: {
                return pSSysEAISchemeBase.getPSSysServiceAPIName();
            }
            case 19: {
                return pSSysEAISchemeBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysEAISchemeBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysEAISchemeBase.getPSSystemId();
            }
            case 22: {
                return pSSysEAISchemeBase.getPSSystemName();
            }
            case 23: {
                return pSSysEAISchemeBase.getSchemeParams();
            }
            case 24: {
                return pSSysEAISchemeBase.getServiceCodeName();
            }
            case 25: {
                return pSSysEAISchemeBase.getSubSysServiceCodeName();
            }
            case 26: {
                return pSSysEAISchemeBase.getUpdateDate();
            }
            case 27: {
                return pSSysEAISchemeBase.getUpdateMan();
            }
            case 28: {
                return pSSysEAISchemeBase.getUserCat();
            }
            case 29: {
                return pSSysEAISchemeBase.getUserTag();
            }
            case 30: {
                return pSSysEAISchemeBase.getUserTag2();
            }
            case 31: {
                return pSSysEAISchemeBase.getUserTag3();
            }
            case 32: {
                return pSSysEAISchemeBase.getUserTag4();
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
        PSSysEAISchemeBase.set(this, n, object);
    }

    private static void set(PSSysEAISchemeBase pSSysEAISchemeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAISchemeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAISchemeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAISchemeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAISchemeBase.setEAISchemeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAISchemeBase.setEAISchemeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAISchemeBase.setEnableServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAISchemeBase.setEnableSubSysServiceAPI(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAISchemeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAISchemeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAISchemeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAISchemeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAISchemeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAISchemeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAISchemeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAISchemeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAISchemeBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAISchemeBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAISchemeBase.setPSSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAISchemeBase.setPSSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAISchemeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAISchemeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAISchemeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAISchemeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAISchemeBase.setSchemeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEAISchemeBase.setServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEAISchemeBase.setSubSysServiceCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEAISchemeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysEAISchemeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysEAISchemeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysEAISchemeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysEAISchemeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysEAISchemeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysEAISchemeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysEAISchemeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAISchemeBase pSSysEAISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAISchemeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAISchemeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAISchemeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAISchemeBase.getEAISchemeTag() == null;
            }
            case 4: {
                return pSSysEAISchemeBase.getEAISchemeTag2() == null;
            }
            case 5: {
                return pSSysEAISchemeBase.getEnableServiceAPI() == null;
            }
            case 6: {
                return pSSysEAISchemeBase.getEnableSubSysServiceAPI() == null;
            }
            case 7: {
                return pSSysEAISchemeBase.getMemo() == null;
            }
            case 8: {
                return pSSysEAISchemeBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysEAISchemeBase.getPSModuleId() == null;
            }
            case 10: {
                return pSSysEAISchemeBase.getPSModuleName() == null;
            }
            case 11: {
                return pSSysEAISchemeBase.getPSSubSysServiceAPIId() == null;
            }
            case 12: {
                return pSSysEAISchemeBase.getPSSubSysServiceAPIName() == null;
            }
            case 13: {
                return pSSysEAISchemeBase.getPSSysDynaModelId() == null;
            }
            case 14: {
                return pSSysEAISchemeBase.getPSSysDynaModelName() == null;
            }
            case 15: {
                return pSSysEAISchemeBase.getPSSysEAISchemeId() == null;
            }
            case 16: {
                return pSSysEAISchemeBase.getPSSysEAISchemeName() == null;
            }
            case 17: {
                return pSSysEAISchemeBase.getPSSysServiceAPIId() == null;
            }
            case 18: {
                return pSSysEAISchemeBase.getPSSysServiceAPIName() == null;
            }
            case 19: {
                return pSSysEAISchemeBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysEAISchemeBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysEAISchemeBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysEAISchemeBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysEAISchemeBase.getSchemeParams() == null;
            }
            case 24: {
                return pSSysEAISchemeBase.getServiceCodeName() == null;
            }
            case 25: {
                return pSSysEAISchemeBase.getSubSysServiceCodeName() == null;
            }
            case 26: {
                return pSSysEAISchemeBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysEAISchemeBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysEAISchemeBase.getUserCat() == null;
            }
            case 29: {
                return pSSysEAISchemeBase.getUserTag() == null;
            }
            case 30: {
                return pSSysEAISchemeBase.getUserTag2() == null;
            }
            case 31: {
                return pSSysEAISchemeBase.getUserTag3() == null;
            }
            case 32: {
                return pSSysEAISchemeBase.getUserTag4() == null;
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
        return PSSysEAISchemeBase.contains(this, n);
    }

    private static boolean contains(PSSysEAISchemeBase pSSysEAISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAISchemeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAISchemeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAISchemeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAISchemeBase.isEAISchemeTagDirty();
            }
            case 4: {
                return pSSysEAISchemeBase.isEAISchemeTag2Dirty();
            }
            case 5: {
                return pSSysEAISchemeBase.isEnableServiceAPIDirty();
            }
            case 6: {
                return pSSysEAISchemeBase.isEnableSubSysServiceAPIDirty();
            }
            case 7: {
                return pSSysEAISchemeBase.isMemoDirty();
            }
            case 8: {
                return pSSysEAISchemeBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysEAISchemeBase.isPSModuleIdDirty();
            }
            case 10: {
                return pSSysEAISchemeBase.isPSModuleNameDirty();
            }
            case 11: {
                return pSSysEAISchemeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 12: {
                return pSSysEAISchemeBase.isPSSubSysServiceAPINameDirty();
            }
            case 13: {
                return pSSysEAISchemeBase.isPSSysDynaModelIdDirty();
            }
            case 14: {
                return pSSysEAISchemeBase.isPSSysDynaModelNameDirty();
            }
            case 15: {
                return pSSysEAISchemeBase.isPSSysEAISchemeIdDirty();
            }
            case 16: {
                return pSSysEAISchemeBase.isPSSysEAISchemeNameDirty();
            }
            case 17: {
                return pSSysEAISchemeBase.isPSSysServiceAPIIdDirty();
            }
            case 18: {
                return pSSysEAISchemeBase.isPSSysServiceAPINameDirty();
            }
            case 19: {
                return pSSysEAISchemeBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysEAISchemeBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysEAISchemeBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysEAISchemeBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysEAISchemeBase.isSchemeParamsDirty();
            }
            case 24: {
                return pSSysEAISchemeBase.isServiceCodeNameDirty();
            }
            case 25: {
                return pSSysEAISchemeBase.isSubSysServiceCodeNameDirty();
            }
            case 26: {
                return pSSysEAISchemeBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysEAISchemeBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysEAISchemeBase.isUserCatDirty();
            }
            case 29: {
                return pSSysEAISchemeBase.isUserTagDirty();
            }
            case 30: {
                return pSSysEAISchemeBase.isUserTag2Dirty();
            }
            case 31: {
                return pSSysEAISchemeBase.isUserTag3Dirty();
            }
            case 32: {
                return pSSysEAISchemeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAISchemeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAISchemeBase pSSysEAISchemeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAISchemeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getEAISchemeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaischemetag", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getEAISchemeTag()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getEAISchemeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaischemetag2", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getEAISchemeTag2()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getEnableServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableserviceapi", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getEnableServiceAPI()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getEnableSubSysServiceAPI() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubsysserviceapi", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getEnableSubSysServiceAPI()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysserviceapiname", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getSchemeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"schemeparams", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getSchemeParams()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"servicecodename", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getSubSysServiceCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"subsysservicecodename", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getSubSysServiceCodeName()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAISchemeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAISchemeBase.getJSONValue((Object)pSSysEAISchemeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAISchemeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAISchemeBase pSSysEAISchemeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAISchemeBase.getCodeName() != null) {
            object = pSSysEAISchemeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getCreateDate() != null) {
            object = pSSysEAISchemeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAISchemeBase.getCreateMan() != null) {
            object = pSSysEAISchemeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getEAISchemeTag() != null) {
            object = pSSysEAISchemeBase.getEAISchemeTag();
            xmlNode.setAttribute(FIELD_EAISCHEMETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getEAISchemeTag2() != null) {
            object = pSSysEAISchemeBase.getEAISchemeTag2();
            xmlNode.setAttribute(FIELD_EAISCHEMETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getEnableServiceAPI() != null) {
            object = pSSysEAISchemeBase.getEnableServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAISchemeBase.getEnableSubSysServiceAPI() != null) {
            object = pSSysEAISchemeBase.getEnableSubSysServiceAPI();
            xmlNode.setAttribute(FIELD_ENABLESUBSYSSERVICEAPI, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAISchemeBase.getMemo() != null) {
            object = pSSysEAISchemeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getOrderValue() != null) {
            object = pSSysEAISchemeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAISchemeBase.getPSModuleId() != null) {
            object = pSSysEAISchemeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSModuleName() != null) {
            object = pSSysEAISchemeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIId() != null) {
            object = pSSysEAISchemeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIName() != null) {
            object = pSSysEAISchemeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysDynaModelId() != null) {
            object = pSSysEAISchemeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysDynaModelName() != null) {
            object = pSSysEAISchemeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAISchemeBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysEAISchemeName() != null) {
            object = pSSysEAISchemeBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysServiceAPIId() != null) {
            object = pSSysEAISchemeBase.getPSSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysServiceAPIName() != null) {
            object = pSSysEAISchemeBase.getPSSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysSFPluginId() != null) {
            object = pSSysEAISchemeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSysSFPluginName() != null) {
            object = pSSysEAISchemeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSystemId() != null) {
            object = pSSysEAISchemeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getPSSystemName() != null) {
            object = pSSysEAISchemeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getSchemeParams() != null) {
            object = pSSysEAISchemeBase.getSchemeParams();
            xmlNode.setAttribute(FIELD_SCHEMEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getServiceCodeName() != null) {
            object = pSSysEAISchemeBase.getServiceCodeName();
            xmlNode.setAttribute(FIELD_SERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getSubSysServiceCodeName() != null) {
            object = pSSysEAISchemeBase.getSubSysServiceCodeName();
            xmlNode.setAttribute(FIELD_SUBSYSSERVICECODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUpdateDate() != null) {
            object = pSSysEAISchemeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAISchemeBase.getUpdateMan() != null) {
            object = pSSysEAISchemeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUserCat() != null) {
            object = pSSysEAISchemeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUserTag() != null) {
            object = pSSysEAISchemeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUserTag2() != null) {
            object = pSSysEAISchemeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUserTag3() != null) {
            object = pSSysEAISchemeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAISchemeBase.getUserTag4() != null) {
            object = pSSysEAISchemeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAISchemeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAISchemeBase pSSysEAISchemeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAISchemeBase.isCodeNameDirty() && (bl || pSSysEAISchemeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAISchemeBase.getCodeName());
        }
        if (pSSysEAISchemeBase.isCreateDateDirty() && (bl || pSSysEAISchemeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAISchemeBase.getCreateDate());
        }
        if (pSSysEAISchemeBase.isCreateManDirty() && (bl || pSSysEAISchemeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAISchemeBase.getCreateMan());
        }
        if (pSSysEAISchemeBase.isEAISchemeTagDirty() && (bl || pSSysEAISchemeBase.getEAISchemeTag() != null)) {
            iDataObject.set(FIELD_EAISCHEMETAG, (Object)pSSysEAISchemeBase.getEAISchemeTag());
        }
        if (pSSysEAISchemeBase.isEAISchemeTag2Dirty() && (bl || pSSysEAISchemeBase.getEAISchemeTag2() != null)) {
            iDataObject.set(FIELD_EAISCHEMETAG2, (Object)pSSysEAISchemeBase.getEAISchemeTag2());
        }
        if (pSSysEAISchemeBase.isEnableServiceAPIDirty() && (bl || pSSysEAISchemeBase.getEnableServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESERVICEAPI, (Object)pSSysEAISchemeBase.getEnableServiceAPI());
        }
        if (pSSysEAISchemeBase.isEnableSubSysServiceAPIDirty() && (bl || pSSysEAISchemeBase.getEnableSubSysServiceAPI() != null)) {
            iDataObject.set(FIELD_ENABLESUBSYSSERVICEAPI, (Object)pSSysEAISchemeBase.getEnableSubSysServiceAPI());
        }
        if (pSSysEAISchemeBase.isMemoDirty() && (bl || pSSysEAISchemeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAISchemeBase.getMemo());
        }
        if (pSSysEAISchemeBase.isOrderValueDirty() && (bl || pSSysEAISchemeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysEAISchemeBase.getOrderValue());
        }
        if (pSSysEAISchemeBase.isPSModuleIdDirty() && (bl || pSSysEAISchemeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysEAISchemeBase.getPSModuleId());
        }
        if (pSSysEAISchemeBase.isPSModuleNameDirty() && (bl || pSSysEAISchemeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysEAISchemeBase.getPSModuleName());
        }
        if (pSSysEAISchemeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSSysEAISchemeBase.getPSSubSysServiceAPIId());
        }
        if (pSSysEAISchemeBase.isPSSubSysServiceAPINameDirty() && (bl || pSSysEAISchemeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSSysEAISchemeBase.getPSSubSysServiceAPIName());
        }
        if (pSSysEAISchemeBase.isPSSysDynaModelIdDirty() && (bl || pSSysEAISchemeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysEAISchemeBase.getPSSysDynaModelId());
        }
        if (pSSysEAISchemeBase.isPSSysDynaModelNameDirty() && (bl || pSSysEAISchemeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysEAISchemeBase.getPSSysDynaModelName());
        }
        if (pSSysEAISchemeBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAISchemeBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAISchemeBase.getPSSysEAISchemeId());
        }
        if (pSSysEAISchemeBase.isPSSysEAISchemeNameDirty() && (bl || pSSysEAISchemeBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSSysEAISchemeBase.getPSSysEAISchemeName());
        }
        if (pSSysEAISchemeBase.isPSSysServiceAPIIdDirty() && (bl || pSSysEAISchemeBase.getPSSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPIID, (Object)pSSysEAISchemeBase.getPSSysServiceAPIId());
        }
        if (pSSysEAISchemeBase.isPSSysServiceAPINameDirty() && (bl || pSSysEAISchemeBase.getPSSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSYSSERVICEAPINAME, (Object)pSSysEAISchemeBase.getPSSysServiceAPIName());
        }
        if (pSSysEAISchemeBase.isPSSysSFPluginIdDirty() && (bl || pSSysEAISchemeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysEAISchemeBase.getPSSysSFPluginId());
        }
        if (pSSysEAISchemeBase.isPSSysSFPluginNameDirty() && (bl || pSSysEAISchemeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysEAISchemeBase.getPSSysSFPluginName());
        }
        if (pSSysEAISchemeBase.isPSSystemIdDirty() && (bl || pSSysEAISchemeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysEAISchemeBase.getPSSystemId());
        }
        if (pSSysEAISchemeBase.isPSSystemNameDirty() && (bl || pSSysEAISchemeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysEAISchemeBase.getPSSystemName());
        }
        if (pSSysEAISchemeBase.isSchemeParamsDirty() && (bl || pSSysEAISchemeBase.getSchemeParams() != null)) {
            iDataObject.set(FIELD_SCHEMEPARAMS, (Object)pSSysEAISchemeBase.getSchemeParams());
        }
        if (pSSysEAISchemeBase.isServiceCodeNameDirty() && (bl || pSSysEAISchemeBase.getServiceCodeName() != null)) {
            iDataObject.set(FIELD_SERVICECODENAME, (Object)pSSysEAISchemeBase.getServiceCodeName());
        }
        if (pSSysEAISchemeBase.isSubSysServiceCodeNameDirty() && (bl || pSSysEAISchemeBase.getSubSysServiceCodeName() != null)) {
            iDataObject.set(FIELD_SUBSYSSERVICECODENAME, (Object)pSSysEAISchemeBase.getSubSysServiceCodeName());
        }
        if (pSSysEAISchemeBase.isUpdateDateDirty() && (bl || pSSysEAISchemeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAISchemeBase.getUpdateDate());
        }
        if (pSSysEAISchemeBase.isUpdateManDirty() && (bl || pSSysEAISchemeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAISchemeBase.getUpdateMan());
        }
        if (pSSysEAISchemeBase.isUserCatDirty() && (bl || pSSysEAISchemeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAISchemeBase.getUserCat());
        }
        if (pSSysEAISchemeBase.isUserTagDirty() && (bl || pSSysEAISchemeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAISchemeBase.getUserTag());
        }
        if (pSSysEAISchemeBase.isUserTag2Dirty() && (bl || pSSysEAISchemeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAISchemeBase.getUserTag2());
        }
        if (pSSysEAISchemeBase.isUserTag3Dirty() && (bl || pSSysEAISchemeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAISchemeBase.getUserTag3());
        }
        if (pSSysEAISchemeBase.isUserTag4Dirty() && (bl || pSSysEAISchemeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAISchemeBase.getUserTag4());
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
        return PSSysEAISchemeBase.remove(this, n);
    }

    private static boolean remove(PSSysEAISchemeBase pSSysEAISchemeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAISchemeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAISchemeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAISchemeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAISchemeBase.resetEAISchemeTag();
                return true;
            }
            case 4: {
                pSSysEAISchemeBase.resetEAISchemeTag2();
                return true;
            }
            case 5: {
                pSSysEAISchemeBase.resetEnableServiceAPI();
                return true;
            }
            case 6: {
                pSSysEAISchemeBase.resetEnableSubSysServiceAPI();
                return true;
            }
            case 7: {
                pSSysEAISchemeBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysEAISchemeBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysEAISchemeBase.resetPSModuleId();
                return true;
            }
            case 10: {
                pSSysEAISchemeBase.resetPSModuleName();
                return true;
            }
            case 11: {
                pSSysEAISchemeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 12: {
                pSSysEAISchemeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 13: {
                pSSysEAISchemeBase.resetPSSysDynaModelId();
                return true;
            }
            case 14: {
                pSSysEAISchemeBase.resetPSSysDynaModelName();
                return true;
            }
            case 15: {
                pSSysEAISchemeBase.resetPSSysEAISchemeId();
                return true;
            }
            case 16: {
                pSSysEAISchemeBase.resetPSSysEAISchemeName();
                return true;
            }
            case 17: {
                pSSysEAISchemeBase.resetPSSysServiceAPIId();
                return true;
            }
            case 18: {
                pSSysEAISchemeBase.resetPSSysServiceAPIName();
                return true;
            }
            case 19: {
                pSSysEAISchemeBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysEAISchemeBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysEAISchemeBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysEAISchemeBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysEAISchemeBase.resetSchemeParams();
                return true;
            }
            case 24: {
                pSSysEAISchemeBase.resetServiceCodeName();
                return true;
            }
            case 25: {
                pSSysEAISchemeBase.resetSubSysServiceCodeName();
                return true;
            }
            case 26: {
                pSSysEAISchemeBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysEAISchemeBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysEAISchemeBase.resetUserCat();
                return true;
            }
            case 29: {
                pSSysEAISchemeBase.resetUserTag();
                return true;
            }
            case 30: {
                pSSysEAISchemeBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSSysEAISchemeBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSSysEAISchemeBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet(pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysServiceAPI getPSSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysServiceAPI();
        }
        if (this.getPSSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSysServiceAPILock;
        synchronized (n) {
            if (this.pssysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysServiceAPIId(), (Object)this.pssysserviceapi.getPSSysServiceAPIId()) != 0L) {
                this.pssysserviceapi = null;
            }
            if (this.pssysserviceapi == null) {
                PSSysServiceAPI pSSysServiceAPI = new PSSysServiceAPI();
                pSSysServiceAPI.setPSSysServiceAPIId(this.getPSSysServiceAPIId());
                PSSysServiceAPIService pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSysServiceAPIService.autoGet(pSSysServiceAPI);
                this.pssysserviceapi = pSSysServiceAPI;
            }
            return this.pssysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIDataType> getPSSysEAIDataTypes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypes();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        PSSysEAIDataTypeService pSSysEAIDataTypeService = (PSSysEAIDataTypeService)ServiceGlobal.getService(PSSysEAIDataTypeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIDataTypesLock;
        synchronized (n) {
            if (this.pssyseaidatatypes == null) {
                this.pssyseaidatatypes = pSSysEAIDataTypeService.selectByPSSysEAIScheme(this);
            }
            return this.pssyseaidatatypes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIDE> getPSSysEAIDEs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDEs();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        PSSysEAIDEService pSSysEAIDEService = (PSSysEAIDEService)ServiceGlobal.getService(PSSysEAIDEService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIDEsLock;
        synchronized (n) {
            if (this.pssyseaides == null) {
                this.pssyseaides = pSSysEAIDEService.selectByPSSysEAIScheme(this);
            }
            return this.pssyseaides;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIElement> getPSSysEAIElements() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElements();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIElementsLock;
        synchronized (n) {
            if (this.pssyseaielements == null) {
                this.pssyseaielements = pSSysEAIElementService.selectByPSSysEAIScheme(this);
            }
            return this.pssyseaielements;
        }
    }

    private PSSysEAISchemeBase getProxyEntity() {
        return this.proxyPSSysEAISchemeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAISchemeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAISchemeBase) {
            this.proxyPSSysEAISchemeBase = (PSSysEAISchemeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAISCHEMETAG, 3);
        fieldIndexMap.put(FIELD_EAISCHEMETAG2, 4);
        fieldIndexMap.put(FIELD_ENABLESERVICEAPI, 5);
        fieldIndexMap.put(FIELD_ENABLESUBSYSSERVICEAPI, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSMODULEID, 9);
        fieldIndexMap.put(FIELD_PSMODULENAME, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 11);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 13);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 15);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 16);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPIID, 17);
        fieldIndexMap.put(FIELD_PSSYSSERVICEAPINAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_SCHEMEPARAMS, 23);
        fieldIndexMap.put(FIELD_SERVICECODENAME, 24);
        fieldIndexMap.put(FIELD_SUBSYSSERVICECODENAME, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
    }
}

