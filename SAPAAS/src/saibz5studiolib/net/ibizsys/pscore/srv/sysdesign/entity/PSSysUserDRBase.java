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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserDRBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUserDRBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCOND = "CUSTOMCOND";
    public static final String FIELD_CUSTOMCOND2 = "CUSTOMCOND2";
    public static final String FIELD_CUSTOMTYPE = "CUSTOMTYPE";
    public static final String FIELD_CUSTOMTYPE2 = "CUSTOMTYPE2";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String FIELD_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDRTAG = "USERDRTAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CUSTOMCOND = 2;
    private static final int INDEX_CUSTOMCOND2 = 3;
    private static final int INDEX_CUSTOMTYPE = 4;
    private static final int INDEX_CUSTOMTYPE2 = 5;
    private static final int INDEX_FILTERMODEL = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSMODULEID = 8;
    private static final int INDEX_PSMODULENAME = 9;
    private static final int INDEX_PSSYSDYNAMODELID = 10;
    private static final int INDEX_PSSYSDYNAMODELNAME = 11;
    private static final int INDEX_PSSYSSFPLUGINID = 12;
    private static final int INDEX_PSSYSSFPLUGINNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_PSSYSUSERDRID = 16;
    private static final int INDEX_PSSYSUSERDRNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERDRTAG = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUserDRBase proxyPSSysUserDRBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcondDirtyFlag = false;
    private boolean customcond2DirtyFlag = false;
    private boolean customtypeDirtyFlag = false;
    private boolean customtype2DirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysuserdridDirtyFlag = false;
    private boolean pssysuserdrnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdrtagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcond")
    private String customcond;
    @Column(name="customcond2")
    private String customcond2;
    @Column(name="customtype")
    private String customtype;
    @Column(name="customtype2")
    private String customtype2;
    @Column(name="filtermodel")
    private String filtermodel;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysuserdrid")
    private String pssysuserdrid;
    @Column(name="pssysuserdrname")
    private String pssysuserdrname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdrtag")
    private String userdrtag;
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
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
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

    public void setCustomCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond = string;
        this.customcondDirtyFlag = true;
    }

    public String getCustomCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond();
        }
        return this.customcond;
    }

    public boolean isCustomCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCondDirty();
        }
        return this.customcondDirtyFlag;
    }

    public void resetCustomCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond();
            return;
        }
        this.customcondDirtyFlag = false;
        this.customcond = null;
    }

    public void setCustomCond2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCond2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcond2 = string;
        this.customcond2DirtyFlag = true;
    }

    public String getCustomCond2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCond2();
        }
        return this.customcond2;
    }

    public boolean isCustomCond2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCond2Dirty();
        }
        return this.customcond2DirtyFlag;
    }

    public void resetCustomCond2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCond2();
            return;
        }
        this.customcond2DirtyFlag = false;
        this.customcond2 = null;
    }

    public void setCustomType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype = string;
        this.customtypeDirtyFlag = true;
    }

    public String getCustomType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType();
        }
        return this.customtype;
    }

    public boolean isCustomTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomTypeDirty();
        }
        return this.customtypeDirtyFlag;
    }

    public void resetCustomType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType();
            return;
        }
        this.customtypeDirtyFlag = false;
        this.customtype = null;
    }

    public void setCustomType2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomType2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customtype2 = string;
        this.customtype2DirtyFlag = true;
    }

    public String getCustomType2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomType2();
        }
        return this.customtype2;
    }

    public boolean isCustomType2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomType2Dirty();
        }
        return this.customtype2DirtyFlag;
    }

    public void resetCustomType2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomType2();
            return;
        }
        this.customtype2DirtyFlag = false;
        this.customtype2 = null;
    }

    public void setFilterModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilterModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filtermodel = string;
        this.filtermodelDirtyFlag = true;
    }

    public String getFilterModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilterModel();
        }
        return this.filtermodel;
    }

    public boolean isFilterModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilterModelDirty();
        }
        return this.filtermodelDirtyFlag;
    }

    public void resetFilterModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilterModel();
            return;
        }
        this.filtermodelDirtyFlag = false;
        this.filtermodel = null;
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

    public void setPSSysUserDRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrid = string;
        this.pssysuserdridDirtyFlag = true;
    }

    public String getPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRId();
        }
        return this.pssysuserdrid;
    }

    public boolean isPSSysUserDRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRIdDirty();
        }
        return this.pssysuserdridDirtyFlag;
    }

    public void resetPSSysUserDRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRId();
            return;
        }
        this.pssysuserdridDirtyFlag = false;
        this.pssysuserdrid = null;
    }

    public void setPSSysUserDRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserDRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuserdrname = string;
        this.pssysuserdrnameDirtyFlag = true;
    }

    public String getPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserDRName();
        }
        return this.pssysuserdrname;
    }

    public boolean isPSSysUserDRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserDRNameDirty();
        }
        return this.pssysuserdrnameDirtyFlag;
    }

    public void resetPSSysUserDRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserDRName();
            return;
        }
        this.pssysuserdrnameDirtyFlag = false;
        this.pssysuserdrname = null;
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

    public void setUserDRTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDRTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdrtag = string;
        this.userdrtagDirtyFlag = true;
    }

    public String getUserDRTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDRTag();
        }
        return this.userdrtag;
    }

    public boolean isUserDRTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDRTagDirty();
        }
        return this.userdrtagDirtyFlag;
    }

    public void resetUserDRTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDRTag();
            return;
        }
        this.userdrtagDirtyFlag = false;
        this.userdrtag = null;
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
        PSSysUserDRBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUserDRBase pSSysUserDRBase) {
        pSSysUserDRBase.resetCreateDate();
        pSSysUserDRBase.resetCreateMan();
        pSSysUserDRBase.resetCustomCond();
        pSSysUserDRBase.resetCustomCond2();
        pSSysUserDRBase.resetCustomType();
        pSSysUserDRBase.resetCustomType2();
        pSSysUserDRBase.resetFilterModel();
        pSSysUserDRBase.resetMemo();
        pSSysUserDRBase.resetPSModuleId();
        pSSysUserDRBase.resetPSModuleName();
        pSSysUserDRBase.resetPSSysDynaModelId();
        pSSysUserDRBase.resetPSSysDynaModelName();
        pSSysUserDRBase.resetPSSysSFPluginId();
        pSSysUserDRBase.resetPSSysSFPluginName();
        pSSysUserDRBase.resetPSSystemId();
        pSSysUserDRBase.resetPSSystemName();
        pSSysUserDRBase.resetPSSysUserDRId();
        pSSysUserDRBase.resetPSSysUserDRName();
        pSSysUserDRBase.resetUpdateDate();
        pSSysUserDRBase.resetUpdateMan();
        pSSysUserDRBase.resetUserCat();
        pSSysUserDRBase.resetUserDRTag();
        pSSysUserDRBase.resetUserTag();
        pSSysUserDRBase.resetUserTag2();
        pSSysUserDRBase.resetUserTag3();
        pSSysUserDRBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCondDirty()) {
            hashMap.put(FIELD_CUSTOMCOND, this.getCustomCond());
        }
        if (!bl || this.isCustomCond2Dirty()) {
            hashMap.put(FIELD_CUSTOMCOND2, this.getCustomCond2());
        }
        if (!bl || this.isCustomTypeDirty()) {
            hashMap.put(FIELD_CUSTOMTYPE, this.getCustomType());
        }
        if (!bl || this.isCustomType2Dirty()) {
            hashMap.put(FIELD_CUSTOMTYPE2, this.getCustomType2());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isPSSysUserDRIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRID, this.getPSSysUserDRId());
        }
        if (!bl || this.isPSSysUserDRNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERDRNAME, this.getPSSysUserDRName());
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
        if (!bl || this.isUserDRTagDirty()) {
            hashMap.put(FIELD_USERDRTAG, this.getUserDRTag());
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
        return PSSysUserDRBase.get(this, n);
    }

    private static Object get(PSSysUserDRBase pSSysUserDRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserDRBase.getCreateDate();
            }
            case 1: {
                return pSSysUserDRBase.getCreateMan();
            }
            case 2: {
                return pSSysUserDRBase.getCustomCond();
            }
            case 3: {
                return pSSysUserDRBase.getCustomCond2();
            }
            case 4: {
                return pSSysUserDRBase.getCustomType();
            }
            case 5: {
                return pSSysUserDRBase.getCustomType2();
            }
            case 6: {
                return pSSysUserDRBase.getFilterModel();
            }
            case 7: {
                return pSSysUserDRBase.getMemo();
            }
            case 8: {
                return pSSysUserDRBase.getPSModuleId();
            }
            case 9: {
                return pSSysUserDRBase.getPSModuleName();
            }
            case 10: {
                return pSSysUserDRBase.getPSSysDynaModelId();
            }
            case 11: {
                return pSSysUserDRBase.getPSSysDynaModelName();
            }
            case 12: {
                return pSSysUserDRBase.getPSSysSFPluginId();
            }
            case 13: {
                return pSSysUserDRBase.getPSSysSFPluginName();
            }
            case 14: {
                return pSSysUserDRBase.getPSSystemId();
            }
            case 15: {
                return pSSysUserDRBase.getPSSystemName();
            }
            case 16: {
                return pSSysUserDRBase.getPSSysUserDRId();
            }
            case 17: {
                return pSSysUserDRBase.getPSSysUserDRName();
            }
            case 18: {
                return pSSysUserDRBase.getUpdateDate();
            }
            case 19: {
                return pSSysUserDRBase.getUpdateMan();
            }
            case 20: {
                return pSSysUserDRBase.getUserCat();
            }
            case 21: {
                return pSSysUserDRBase.getUserDRTag();
            }
            case 22: {
                return pSSysUserDRBase.getUserTag();
            }
            case 23: {
                return pSSysUserDRBase.getUserTag2();
            }
            case 24: {
                return pSSysUserDRBase.getUserTag3();
            }
            case 25: {
                return pSSysUserDRBase.getUserTag4();
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
        PSSysUserDRBase.set(this, n, object);
    }

    private static void set(PSSysUserDRBase pSSysUserDRBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserDRBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUserDRBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUserDRBase.setCustomCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUserDRBase.setCustomCond2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUserDRBase.setCustomType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUserDRBase.setCustomType2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUserDRBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUserDRBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUserDRBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUserDRBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUserDRBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUserDRBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUserDRBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUserDRBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUserDRBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysUserDRBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUserDRBase.setPSSysUserDRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUserDRBase.setPSSysUserDRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUserDRBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysUserDRBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUserDRBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysUserDRBase.setUserDRTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysUserDRBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysUserDRBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysUserDRBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysUserDRBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUserDRBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUserDRBase pSSysUserDRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserDRBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUserDRBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUserDRBase.getCustomCond() == null;
            }
            case 3: {
                return pSSysUserDRBase.getCustomCond2() == null;
            }
            case 4: {
                return pSSysUserDRBase.getCustomType() == null;
            }
            case 5: {
                return pSSysUserDRBase.getCustomType2() == null;
            }
            case 6: {
                return pSSysUserDRBase.getFilterModel() == null;
            }
            case 7: {
                return pSSysUserDRBase.getMemo() == null;
            }
            case 8: {
                return pSSysUserDRBase.getPSModuleId() == null;
            }
            case 9: {
                return pSSysUserDRBase.getPSModuleName() == null;
            }
            case 10: {
                return pSSysUserDRBase.getPSSysDynaModelId() == null;
            }
            case 11: {
                return pSSysUserDRBase.getPSSysDynaModelName() == null;
            }
            case 12: {
                return pSSysUserDRBase.getPSSysSFPluginId() == null;
            }
            case 13: {
                return pSSysUserDRBase.getPSSysSFPluginName() == null;
            }
            case 14: {
                return pSSysUserDRBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysUserDRBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysUserDRBase.getPSSysUserDRId() == null;
            }
            case 17: {
                return pSSysUserDRBase.getPSSysUserDRName() == null;
            }
            case 18: {
                return pSSysUserDRBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSysUserDRBase.getUpdateMan() == null;
            }
            case 20: {
                return pSSysUserDRBase.getUserCat() == null;
            }
            case 21: {
                return pSSysUserDRBase.getUserDRTag() == null;
            }
            case 22: {
                return pSSysUserDRBase.getUserTag() == null;
            }
            case 23: {
                return pSSysUserDRBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysUserDRBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysUserDRBase.getUserTag4() == null;
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
        return PSSysUserDRBase.contains(this, n);
    }

    private static boolean contains(PSSysUserDRBase pSSysUserDRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUserDRBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUserDRBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUserDRBase.isCustomCondDirty();
            }
            case 3: {
                return pSSysUserDRBase.isCustomCond2Dirty();
            }
            case 4: {
                return pSSysUserDRBase.isCustomTypeDirty();
            }
            case 5: {
                return pSSysUserDRBase.isCustomType2Dirty();
            }
            case 6: {
                return pSSysUserDRBase.isFilterModelDirty();
            }
            case 7: {
                return pSSysUserDRBase.isMemoDirty();
            }
            case 8: {
                return pSSysUserDRBase.isPSModuleIdDirty();
            }
            case 9: {
                return pSSysUserDRBase.isPSModuleNameDirty();
            }
            case 10: {
                return pSSysUserDRBase.isPSSysDynaModelIdDirty();
            }
            case 11: {
                return pSSysUserDRBase.isPSSysDynaModelNameDirty();
            }
            case 12: {
                return pSSysUserDRBase.isPSSysSFPluginIdDirty();
            }
            case 13: {
                return pSSysUserDRBase.isPSSysSFPluginNameDirty();
            }
            case 14: {
                return pSSysUserDRBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysUserDRBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysUserDRBase.isPSSysUserDRIdDirty();
            }
            case 17: {
                return pSSysUserDRBase.isPSSysUserDRNameDirty();
            }
            case 18: {
                return pSSysUserDRBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSysUserDRBase.isUpdateManDirty();
            }
            case 20: {
                return pSSysUserDRBase.isUserCatDirty();
            }
            case 21: {
                return pSSysUserDRBase.isUserDRTagDirty();
            }
            case 22: {
                return pSSysUserDRBase.isUserTagDirty();
            }
            case 23: {
                return pSSysUserDRBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysUserDRBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysUserDRBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUserDRBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUserDRBase pSSysUserDRBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUserDRBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getCustomCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCustomCond()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getCustomCond2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcond2", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCustomCond2()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getCustomType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCustomType()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getCustomType2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customtype2", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getCustomType2()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysUserDRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrid", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysUserDRId()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getPSSysUserDRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuserdrname", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getPSSysUserDRName()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserDRTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdrtag", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserDRTag()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUserDRBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUserDRBase.getJSONValue((Object)pSSysUserDRBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUserDRBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUserDRBase pSSysUserDRBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUserDRBase.getCreateDate() != null) {
            object = pSSysUserDRBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserDRBase.getCreateMan() != null) {
            object = pSSysUserDRBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getCustomCond() != null) {
            object = pSSysUserDRBase.getCustomCond();
            xmlNode.setAttribute(FIELD_CUSTOMCOND, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getCustomCond2() != null) {
            object = pSSysUserDRBase.getCustomCond2();
            xmlNode.setAttribute(FIELD_CUSTOMCOND2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getCustomType() != null) {
            object = pSSysUserDRBase.getCustomType();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getCustomType2() != null) {
            object = pSSysUserDRBase.getCustomType2();
            xmlNode.setAttribute(FIELD_CUSTOMTYPE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getFilterModel() != null) {
            object = pSSysUserDRBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getMemo() != null) {
            object = pSSysUserDRBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSModuleId() != null) {
            object = pSSysUserDRBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSModuleName() != null) {
            object = pSSysUserDRBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysDynaModelId() != null) {
            object = pSSysUserDRBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysDynaModelName() != null) {
            object = pSSysUserDRBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysSFPluginId() != null) {
            object = pSSysUserDRBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysSFPluginName() != null) {
            object = pSSysUserDRBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSystemId() != null) {
            object = pSSysUserDRBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSystemName() != null) {
            object = pSSysUserDRBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysUserDRId() != null) {
            object = pSSysUserDRBase.getPSSysUserDRId();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getPSSysUserDRName() != null) {
            object = pSSysUserDRBase.getPSSysUserDRName();
            xmlNode.setAttribute(FIELD_PSSYSUSERDRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUpdateDate() != null) {
            object = pSSysUserDRBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUserDRBase.getUpdateMan() != null) {
            object = pSSysUserDRBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserCat() != null) {
            object = pSSysUserDRBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserDRTag() != null) {
            object = pSSysUserDRBase.getUserDRTag();
            xmlNode.setAttribute(FIELD_USERDRTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserTag() != null) {
            object = pSSysUserDRBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserTag2() != null) {
            object = pSSysUserDRBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserTag3() != null) {
            object = pSSysUserDRBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUserDRBase.getUserTag4() != null) {
            object = pSSysUserDRBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUserDRBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUserDRBase pSSysUserDRBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUserDRBase.isCreateDateDirty() && (bl || pSSysUserDRBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUserDRBase.getCreateDate());
        }
        if (pSSysUserDRBase.isCreateManDirty() && (bl || pSSysUserDRBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUserDRBase.getCreateMan());
        }
        if (pSSysUserDRBase.isCustomCondDirty() && (bl || pSSysUserDRBase.getCustomCond() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND, (Object)pSSysUserDRBase.getCustomCond());
        }
        if (pSSysUserDRBase.isCustomCond2Dirty() && (bl || pSSysUserDRBase.getCustomCond2() != null)) {
            iDataObject.set(FIELD_CUSTOMCOND2, (Object)pSSysUserDRBase.getCustomCond2());
        }
        if (pSSysUserDRBase.isCustomTypeDirty() && (bl || pSSysUserDRBase.getCustomType() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE, (Object)pSSysUserDRBase.getCustomType());
        }
        if (pSSysUserDRBase.isCustomType2Dirty() && (bl || pSSysUserDRBase.getCustomType2() != null)) {
            iDataObject.set(FIELD_CUSTOMTYPE2, (Object)pSSysUserDRBase.getCustomType2());
        }
        if (pSSysUserDRBase.isFilterModelDirty() && (bl || pSSysUserDRBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSSysUserDRBase.getFilterModel());
        }
        if (pSSysUserDRBase.isMemoDirty() && (bl || pSSysUserDRBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUserDRBase.getMemo());
        }
        if (pSSysUserDRBase.isPSModuleIdDirty() && (bl || pSSysUserDRBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysUserDRBase.getPSModuleId());
        }
        if (pSSysUserDRBase.isPSModuleNameDirty() && (bl || pSSysUserDRBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysUserDRBase.getPSModuleName());
        }
        if (pSSysUserDRBase.isPSSysDynaModelIdDirty() && (bl || pSSysUserDRBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysUserDRBase.getPSSysDynaModelId());
        }
        if (pSSysUserDRBase.isPSSysDynaModelNameDirty() && (bl || pSSysUserDRBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysUserDRBase.getPSSysDynaModelName());
        }
        if (pSSysUserDRBase.isPSSysSFPluginIdDirty() && (bl || pSSysUserDRBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysUserDRBase.getPSSysSFPluginId());
        }
        if (pSSysUserDRBase.isPSSysSFPluginNameDirty() && (bl || pSSysUserDRBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysUserDRBase.getPSSysSFPluginName());
        }
        if (pSSysUserDRBase.isPSSystemIdDirty() && (bl || pSSysUserDRBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysUserDRBase.getPSSystemId());
        }
        if (pSSysUserDRBase.isPSSystemNameDirty() && (bl || pSSysUserDRBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysUserDRBase.getPSSystemName());
        }
        if (pSSysUserDRBase.isPSSysUserDRIdDirty() && (bl || pSSysUserDRBase.getPSSysUserDRId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRID, (Object)pSSysUserDRBase.getPSSysUserDRId());
        }
        if (pSSysUserDRBase.isPSSysUserDRNameDirty() && (bl || pSSysUserDRBase.getPSSysUserDRName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERDRNAME, (Object)pSSysUserDRBase.getPSSysUserDRName());
        }
        if (pSSysUserDRBase.isUpdateDateDirty() && (bl || pSSysUserDRBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUserDRBase.getUpdateDate());
        }
        if (pSSysUserDRBase.isUpdateManDirty() && (bl || pSSysUserDRBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUserDRBase.getUpdateMan());
        }
        if (pSSysUserDRBase.isUserCatDirty() && (bl || pSSysUserDRBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUserDRBase.getUserCat());
        }
        if (pSSysUserDRBase.isUserDRTagDirty() && (bl || pSSysUserDRBase.getUserDRTag() != null)) {
            iDataObject.set(FIELD_USERDRTAG, (Object)pSSysUserDRBase.getUserDRTag());
        }
        if (pSSysUserDRBase.isUserTagDirty() && (bl || pSSysUserDRBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUserDRBase.getUserTag());
        }
        if (pSSysUserDRBase.isUserTag2Dirty() && (bl || pSSysUserDRBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUserDRBase.getUserTag2());
        }
        if (pSSysUserDRBase.isUserTag3Dirty() && (bl || pSSysUserDRBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUserDRBase.getUserTag3());
        }
        if (pSSysUserDRBase.isUserTag4Dirty() && (bl || pSSysUserDRBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUserDRBase.getUserTag4());
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
        return PSSysUserDRBase.remove(this, n);
    }

    private static boolean remove(PSSysUserDRBase pSSysUserDRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUserDRBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUserDRBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUserDRBase.resetCustomCond();
                return true;
            }
            case 3: {
                pSSysUserDRBase.resetCustomCond2();
                return true;
            }
            case 4: {
                pSSysUserDRBase.resetCustomType();
                return true;
            }
            case 5: {
                pSSysUserDRBase.resetCustomType2();
                return true;
            }
            case 6: {
                pSSysUserDRBase.resetFilterModel();
                return true;
            }
            case 7: {
                pSSysUserDRBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysUserDRBase.resetPSModuleId();
                return true;
            }
            case 9: {
                pSSysUserDRBase.resetPSModuleName();
                return true;
            }
            case 10: {
                pSSysUserDRBase.resetPSSysDynaModelId();
                return true;
            }
            case 11: {
                pSSysUserDRBase.resetPSSysDynaModelName();
                return true;
            }
            case 12: {
                pSSysUserDRBase.resetPSSysSFPluginId();
                return true;
            }
            case 13: {
                pSSysUserDRBase.resetPSSysSFPluginName();
                return true;
            }
            case 14: {
                pSSysUserDRBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysUserDRBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysUserDRBase.resetPSSysUserDRId();
                return true;
            }
            case 17: {
                pSSysUserDRBase.resetPSSysUserDRName();
                return true;
            }
            case 18: {
                pSSysUserDRBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSysUserDRBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSSysUserDRBase.resetUserCat();
                return true;
            }
            case 21: {
                pSSysUserDRBase.resetUserDRTag();
                return true;
            }
            case 22: {
                pSSysUserDRBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysUserDRBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysUserDRBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysUserDRBase.resetUserTag4();
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

    private PSSysUserDRBase getProxyEntity() {
        return this.proxyPSSysUserDRBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUserDRBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUserDRBase) {
            this.proxyPSSysUserDRBase = (PSSysUserDRBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CUSTOMCOND, 2);
        fieldIndexMap.put(FIELD_CUSTOMCOND2, 3);
        fieldIndexMap.put(FIELD_CUSTOMTYPE, 4);
        fieldIndexMap.put(FIELD_CUSTOMTYPE2, 5);
        fieldIndexMap.put(FIELD_FILTERMODEL, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSMODULEID, 8);
        fieldIndexMap.put(FIELD_PSMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 10);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 12);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSUSERDRID, 16);
        fieldIndexMap.put(FIELD_PSSYSUSERDRNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERDRTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

