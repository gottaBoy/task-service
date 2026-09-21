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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFWorkTimeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFWorkTimeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSWFWORKTIMEID = "PSWFWORKTIMEID";
    public static final String FIELD_PSWFWORKTIMENAME = "PSWFWORKTIMENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_WFWORKTIMESN = "WFWORKTIMESN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_ENABLE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDYNAINSTID = 6;
    private static final int INDEX_PSMODULEID = 7;
    private static final int INDEX_PSMODULENAME = 8;
    private static final int INDEX_PSSYSSFPLUGINID = 9;
    private static final int INDEX_PSSYSSFPLUGINNAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSTEMNAME = 12;
    private static final int INDEX_PSWFWORKTIMEID = 13;
    private static final int INDEX_PSWFWORKTIMENAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERDATA = 18;
    private static final int INDEX_USERDATA2 = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_WFWORKTIMESN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFWorkTimeBase proxyPSWFWorkTimeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pswfworktimeidDirtyFlag = false;
    private boolean pswfworktimenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean wfworktimesnDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enable")
    private Integer enable;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pswfworktimeid")
    private String pswfworktimeid;
    @Column(name="pswfworktimename")
    private String pswfworktimename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="wfworktimesn")
    private String wfworktimesn;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setPSWFWorkTimeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFWorkTimeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfworktimeid = string;
        this.pswfworktimeidDirtyFlag = true;
    }

    public String getPSWFWorkTimeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorkTimeId();
        }
        return this.pswfworktimeid;
    }

    public boolean isPSWFWorkTimeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFWorkTimeIdDirty();
        }
        return this.pswfworktimeidDirtyFlag;
    }

    public void resetPSWFWorkTimeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFWorkTimeId();
            return;
        }
        this.pswfworktimeidDirtyFlag = false;
        this.pswfworktimeid = null;
    }

    public void setPSWFWorkTimeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFWorkTimeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfworktimename = string;
        this.pswfworktimenameDirtyFlag = true;
    }

    public String getPSWFWorkTimeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFWorkTimeName();
        }
        return this.pswfworktimename;
    }

    public boolean isPSWFWorkTimeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFWorkTimeNameDirty();
        }
        return this.pswfworktimenameDirtyFlag;
    }

    public void resetPSWFWorkTimeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFWorkTimeName();
            return;
        }
        this.pswfworktimenameDirtyFlag = false;
        this.pswfworktimename = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
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

    public void setWFWorktimeSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorktimeSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfworktimesn = string;
        this.wfworktimesnDirtyFlag = true;
    }

    public String getWFWorktimeSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorktimeSN();
        }
        return this.wfworktimesn;
    }

    public boolean isWFWorktimeSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorktimeSNDirty();
        }
        return this.wfworktimesnDirtyFlag;
    }

    public void resetWFWorktimeSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorktimeSN();
            return;
        }
        this.wfworktimesnDirtyFlag = false;
        this.wfworktimesn = null;
    }

    protected void onReset() {
        PSWFWorkTimeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFWorkTimeBase pSWFWorkTimeBase) {
        pSWFWorkTimeBase.resetCodeName();
        pSWFWorkTimeBase.resetCreateDate();
        pSWFWorkTimeBase.resetCreateMan();
        pSWFWorkTimeBase.resetDynaModelFlag();
        pSWFWorkTimeBase.resetEnable();
        pSWFWorkTimeBase.resetMemo();
        pSWFWorkTimeBase.resetPSDynaInstId();
        pSWFWorkTimeBase.resetPSModuleId();
        pSWFWorkTimeBase.resetPSModuleName();
        pSWFWorkTimeBase.resetPSSysSFPluginId();
        pSWFWorkTimeBase.resetPSSysSFPluginName();
        pSWFWorkTimeBase.resetPSSystemId();
        pSWFWorkTimeBase.resetPSSystemName();
        pSWFWorkTimeBase.resetPSWFWorkTimeId();
        pSWFWorkTimeBase.resetPSWFWorkTimeName();
        pSWFWorkTimeBase.resetUpdateDate();
        pSWFWorkTimeBase.resetUpdateMan();
        pSWFWorkTimeBase.resetUserCat();
        pSWFWorkTimeBase.resetUserData();
        pSWFWorkTimeBase.resetUserData2();
        pSWFWorkTimeBase.resetUserTag();
        pSWFWorkTimeBase.resetUserTag2();
        pSWFWorkTimeBase.resetUserTag3();
        pSWFWorkTimeBase.resetUserTag4();
        pSWFWorkTimeBase.resetWFWorktimeSN();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSWFWorkTimeIdDirty()) {
            hashMap.put(FIELD_PSWFWORKTIMEID, this.getPSWFWorkTimeId());
        }
        if (!bl || this.isPSWFWorkTimeNameDirty()) {
            hashMap.put(FIELD_PSWFWORKTIMENAME, this.getPSWFWorkTimeName());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
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
        if (!bl || this.isWFWorktimeSNDirty()) {
            hashMap.put(FIELD_WFWORKTIMESN, this.getWFWorktimeSN());
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
        return PSWFWorkTimeBase.get(this, n);
    }

    private static Object get(PSWFWorkTimeBase pSWFWorkTimeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFWorkTimeBase.getCodeName();
            }
            case 1: {
                return pSWFWorkTimeBase.getCreateDate();
            }
            case 2: {
                return pSWFWorkTimeBase.getCreateMan();
            }
            case 3: {
                return pSWFWorkTimeBase.getDynaModelFlag();
            }
            case 4: {
                return pSWFWorkTimeBase.getEnable();
            }
            case 5: {
                return pSWFWorkTimeBase.getMemo();
            }
            case 6: {
                return pSWFWorkTimeBase.getPSDynaInstId();
            }
            case 7: {
                return pSWFWorkTimeBase.getPSModuleId();
            }
            case 8: {
                return pSWFWorkTimeBase.getPSModuleName();
            }
            case 9: {
                return pSWFWorkTimeBase.getPSSysSFPluginId();
            }
            case 10: {
                return pSWFWorkTimeBase.getPSSysSFPluginName();
            }
            case 11: {
                return pSWFWorkTimeBase.getPSSystemId();
            }
            case 12: {
                return pSWFWorkTimeBase.getPSSystemName();
            }
            case 13: {
                return pSWFWorkTimeBase.getPSWFWorkTimeId();
            }
            case 14: {
                return pSWFWorkTimeBase.getPSWFWorkTimeName();
            }
            case 15: {
                return pSWFWorkTimeBase.getUpdateDate();
            }
            case 16: {
                return pSWFWorkTimeBase.getUpdateMan();
            }
            case 17: {
                return pSWFWorkTimeBase.getUserCat();
            }
            case 18: {
                return pSWFWorkTimeBase.getUserData();
            }
            case 19: {
                return pSWFWorkTimeBase.getUserData2();
            }
            case 20: {
                return pSWFWorkTimeBase.getUserTag();
            }
            case 21: {
                return pSWFWorkTimeBase.getUserTag2();
            }
            case 22: {
                return pSWFWorkTimeBase.getUserTag3();
            }
            case 23: {
                return pSWFWorkTimeBase.getUserTag4();
            }
            case 24: {
                return pSWFWorkTimeBase.getWFWorktimeSN();
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
        PSWFWorkTimeBase.set(this, n, object);
    }

    private static void set(PSWFWorkTimeBase pSWFWorkTimeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFWorkTimeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFWorkTimeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFWorkTimeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFWorkTimeBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSWFWorkTimeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFWorkTimeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFWorkTimeBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFWorkTimeBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFWorkTimeBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFWorkTimeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFWorkTimeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFWorkTimeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWFWorkTimeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFWorkTimeBase.setPSWFWorkTimeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFWorkTimeBase.setPSWFWorkTimeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFWorkTimeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSWFWorkTimeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFWorkTimeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFWorkTimeBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFWorkTimeBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFWorkTimeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFWorkTimeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFWorkTimeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFWorkTimeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFWorkTimeBase.setWFWorktimeSN(DataObject.getStringValue((Object)object));
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
        return PSWFWorkTimeBase.isNull(this, n);
    }

    private static boolean isNull(PSWFWorkTimeBase pSWFWorkTimeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFWorkTimeBase.getCodeName() == null;
            }
            case 1: {
                return pSWFWorkTimeBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFWorkTimeBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFWorkTimeBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSWFWorkTimeBase.getEnable() == null;
            }
            case 5: {
                return pSWFWorkTimeBase.getMemo() == null;
            }
            case 6: {
                return pSWFWorkTimeBase.getPSDynaInstId() == null;
            }
            case 7: {
                return pSWFWorkTimeBase.getPSModuleId() == null;
            }
            case 8: {
                return pSWFWorkTimeBase.getPSModuleName() == null;
            }
            case 9: {
                return pSWFWorkTimeBase.getPSSysSFPluginId() == null;
            }
            case 10: {
                return pSWFWorkTimeBase.getPSSysSFPluginName() == null;
            }
            case 11: {
                return pSWFWorkTimeBase.getPSSystemId() == null;
            }
            case 12: {
                return pSWFWorkTimeBase.getPSSystemName() == null;
            }
            case 13: {
                return pSWFWorkTimeBase.getPSWFWorkTimeId() == null;
            }
            case 14: {
                return pSWFWorkTimeBase.getPSWFWorkTimeName() == null;
            }
            case 15: {
                return pSWFWorkTimeBase.getUpdateDate() == null;
            }
            case 16: {
                return pSWFWorkTimeBase.getUpdateMan() == null;
            }
            case 17: {
                return pSWFWorkTimeBase.getUserCat() == null;
            }
            case 18: {
                return pSWFWorkTimeBase.getUserData() == null;
            }
            case 19: {
                return pSWFWorkTimeBase.getUserData2() == null;
            }
            case 20: {
                return pSWFWorkTimeBase.getUserTag() == null;
            }
            case 21: {
                return pSWFWorkTimeBase.getUserTag2() == null;
            }
            case 22: {
                return pSWFWorkTimeBase.getUserTag3() == null;
            }
            case 23: {
                return pSWFWorkTimeBase.getUserTag4() == null;
            }
            case 24: {
                return pSWFWorkTimeBase.getWFWorktimeSN() == null;
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
        return PSWFWorkTimeBase.contains(this, n);
    }

    private static boolean contains(PSWFWorkTimeBase pSWFWorkTimeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFWorkTimeBase.isCodeNameDirty();
            }
            case 1: {
                return pSWFWorkTimeBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFWorkTimeBase.isCreateManDirty();
            }
            case 3: {
                return pSWFWorkTimeBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSWFWorkTimeBase.isEnableDirty();
            }
            case 5: {
                return pSWFWorkTimeBase.isMemoDirty();
            }
            case 6: {
                return pSWFWorkTimeBase.isPSDynaInstIdDirty();
            }
            case 7: {
                return pSWFWorkTimeBase.isPSModuleIdDirty();
            }
            case 8: {
                return pSWFWorkTimeBase.isPSModuleNameDirty();
            }
            case 9: {
                return pSWFWorkTimeBase.isPSSysSFPluginIdDirty();
            }
            case 10: {
                return pSWFWorkTimeBase.isPSSysSFPluginNameDirty();
            }
            case 11: {
                return pSWFWorkTimeBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSWFWorkTimeBase.isPSSystemNameDirty();
            }
            case 13: {
                return pSWFWorkTimeBase.isPSWFWorkTimeIdDirty();
            }
            case 14: {
                return pSWFWorkTimeBase.isPSWFWorkTimeNameDirty();
            }
            case 15: {
                return pSWFWorkTimeBase.isUpdateDateDirty();
            }
            case 16: {
                return pSWFWorkTimeBase.isUpdateManDirty();
            }
            case 17: {
                return pSWFWorkTimeBase.isUserCatDirty();
            }
            case 18: {
                return pSWFWorkTimeBase.isUserDataDirty();
            }
            case 19: {
                return pSWFWorkTimeBase.isUserData2Dirty();
            }
            case 20: {
                return pSWFWorkTimeBase.isUserTagDirty();
            }
            case 21: {
                return pSWFWorkTimeBase.isUserTag2Dirty();
            }
            case 22: {
                return pSWFWorkTimeBase.isUserTag3Dirty();
            }
            case 23: {
                return pSWFWorkTimeBase.isUserTag4Dirty();
            }
            case 24: {
                return pSWFWorkTimeBase.isWFWorktimeSNDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFWorkTimeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFWorkTimeBase pSWFWorkTimeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFWorkTimeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getEnable()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSWFWorkTimeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfworktimeid", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSWFWorkTimeId()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getPSWFWorkTimeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfworktimename", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getPSWFWorkTimeName()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserData()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserData2()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSWFWorkTimeBase.getWFWorktimeSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfworktimesn", (Object)PSWFWorkTimeBase.getJSONValue((Object)pSWFWorkTimeBase.getWFWorktimeSN()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFWorkTimeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFWorkTimeBase pSWFWorkTimeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFWorkTimeBase.getCodeName() != null) {
            object = pSWFWorkTimeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getCreateDate() != null) {
            object = pSWFWorkTimeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFWorkTimeBase.getCreateMan() != null) {
            object = pSWFWorkTimeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getDynaModelFlag() != null) {
            object = pSWFWorkTimeBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFWorkTimeBase.getEnable() != null) {
            object = pSWFWorkTimeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFWorkTimeBase.getMemo() != null) {
            object = pSWFWorkTimeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSDynaInstId() != null) {
            object = pSWFWorkTimeBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSModuleId() != null) {
            object = pSWFWorkTimeBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSModuleName() != null) {
            object = pSWFWorkTimeBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSSysSFPluginId() != null) {
            object = pSWFWorkTimeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSSysSFPluginName() != null) {
            object = pSWFWorkTimeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSSystemId() != null) {
            object = pSWFWorkTimeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSSystemName() != null) {
            object = pSWFWorkTimeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSWFWorkTimeId() != null) {
            object = pSWFWorkTimeBase.getPSWFWorkTimeId();
            xmlNode.setAttribute(FIELD_PSWFWORKTIMEID, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getPSWFWorkTimeName() != null) {
            object = pSWFWorkTimeBase.getPSWFWorkTimeName();
            xmlNode.setAttribute(FIELD_PSWFWORKTIMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUpdateDate() != null) {
            object = pSWFWorkTimeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFWorkTimeBase.getUpdateMan() != null) {
            object = pSWFWorkTimeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserCat() != null) {
            object = pSWFWorkTimeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserData() != null) {
            object = pSWFWorkTimeBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserData2() != null) {
            object = pSWFWorkTimeBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserTag() != null) {
            object = pSWFWorkTimeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserTag2() != null) {
            object = pSWFWorkTimeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserTag3() != null) {
            object = pSWFWorkTimeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getUserTag4() != null) {
            object = pSWFWorkTimeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWFWorkTimeBase.getWFWorktimeSN() != null) {
            object = pSWFWorkTimeBase.getWFWorktimeSN();
            xmlNode.setAttribute(FIELD_WFWORKTIMESN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFWorkTimeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFWorkTimeBase pSWFWorkTimeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFWorkTimeBase.isCodeNameDirty() && (bl || pSWFWorkTimeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSWFWorkTimeBase.getCodeName());
        }
        if (pSWFWorkTimeBase.isCreateDateDirty() && (bl || pSWFWorkTimeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFWorkTimeBase.getCreateDate());
        }
        if (pSWFWorkTimeBase.isCreateManDirty() && (bl || pSWFWorkTimeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFWorkTimeBase.getCreateMan());
        }
        if (pSWFWorkTimeBase.isDynaModelFlagDirty() && (bl || pSWFWorkTimeBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFWorkTimeBase.getDynaModelFlag());
        }
        if (pSWFWorkTimeBase.isEnableDirty() && (bl || pSWFWorkTimeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSWFWorkTimeBase.getEnable());
        }
        if (pSWFWorkTimeBase.isMemoDirty() && (bl || pSWFWorkTimeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFWorkTimeBase.getMemo());
        }
        if (pSWFWorkTimeBase.isPSDynaInstIdDirty() && (bl || pSWFWorkTimeBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFWorkTimeBase.getPSDynaInstId());
        }
        if (pSWFWorkTimeBase.isPSModuleIdDirty() && (bl || pSWFWorkTimeBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSWFWorkTimeBase.getPSModuleId());
        }
        if (pSWFWorkTimeBase.isPSModuleNameDirty() && (bl || pSWFWorkTimeBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSWFWorkTimeBase.getPSModuleName());
        }
        if (pSWFWorkTimeBase.isPSSysSFPluginIdDirty() && (bl || pSWFWorkTimeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSWFWorkTimeBase.getPSSysSFPluginId());
        }
        if (pSWFWorkTimeBase.isPSSysSFPluginNameDirty() && (bl || pSWFWorkTimeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSWFWorkTimeBase.getPSSysSFPluginName());
        }
        if (pSWFWorkTimeBase.isPSSystemIdDirty() && (bl || pSWFWorkTimeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSWFWorkTimeBase.getPSSystemId());
        }
        if (pSWFWorkTimeBase.isPSSystemNameDirty() && (bl || pSWFWorkTimeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSWFWorkTimeBase.getPSSystemName());
        }
        if (pSWFWorkTimeBase.isPSWFWorkTimeIdDirty() && (bl || pSWFWorkTimeBase.getPSWFWorkTimeId() != null)) {
            iDataObject.set(FIELD_PSWFWORKTIMEID, (Object)pSWFWorkTimeBase.getPSWFWorkTimeId());
        }
        if (pSWFWorkTimeBase.isPSWFWorkTimeNameDirty() && (bl || pSWFWorkTimeBase.getPSWFWorkTimeName() != null)) {
            iDataObject.set(FIELD_PSWFWORKTIMENAME, (Object)pSWFWorkTimeBase.getPSWFWorkTimeName());
        }
        if (pSWFWorkTimeBase.isUpdateDateDirty() && (bl || pSWFWorkTimeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFWorkTimeBase.getUpdateDate());
        }
        if (pSWFWorkTimeBase.isUpdateManDirty() && (bl || pSWFWorkTimeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFWorkTimeBase.getUpdateMan());
        }
        if (pSWFWorkTimeBase.isUserCatDirty() && (bl || pSWFWorkTimeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSWFWorkTimeBase.getUserCat());
        }
        if (pSWFWorkTimeBase.isUserDataDirty() && (bl || pSWFWorkTimeBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSWFWorkTimeBase.getUserData());
        }
        if (pSWFWorkTimeBase.isUserData2Dirty() && (bl || pSWFWorkTimeBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSWFWorkTimeBase.getUserData2());
        }
        if (pSWFWorkTimeBase.isUserTagDirty() && (bl || pSWFWorkTimeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSWFWorkTimeBase.getUserTag());
        }
        if (pSWFWorkTimeBase.isUserTag2Dirty() && (bl || pSWFWorkTimeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSWFWorkTimeBase.getUserTag2());
        }
        if (pSWFWorkTimeBase.isUserTag3Dirty() && (bl || pSWFWorkTimeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSWFWorkTimeBase.getUserTag3());
        }
        if (pSWFWorkTimeBase.isUserTag4Dirty() && (bl || pSWFWorkTimeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSWFWorkTimeBase.getUserTag4());
        }
        if (pSWFWorkTimeBase.isWFWorktimeSNDirty() && (bl || pSWFWorkTimeBase.getWFWorktimeSN() != null)) {
            iDataObject.set(FIELD_WFWORKTIMESN, (Object)pSWFWorkTimeBase.getWFWorktimeSN());
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
        return PSWFWorkTimeBase.remove(this, n);
    }

    private static boolean remove(PSWFWorkTimeBase pSWFWorkTimeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFWorkTimeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSWFWorkTimeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFWorkTimeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFWorkTimeBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSWFWorkTimeBase.resetEnable();
                return true;
            }
            case 5: {
                pSWFWorkTimeBase.resetMemo();
                return true;
            }
            case 6: {
                pSWFWorkTimeBase.resetPSDynaInstId();
                return true;
            }
            case 7: {
                pSWFWorkTimeBase.resetPSModuleId();
                return true;
            }
            case 8: {
                pSWFWorkTimeBase.resetPSModuleName();
                return true;
            }
            case 9: {
                pSWFWorkTimeBase.resetPSSysSFPluginId();
                return true;
            }
            case 10: {
                pSWFWorkTimeBase.resetPSSysSFPluginName();
                return true;
            }
            case 11: {
                pSWFWorkTimeBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSWFWorkTimeBase.resetPSSystemName();
                return true;
            }
            case 13: {
                pSWFWorkTimeBase.resetPSWFWorkTimeId();
                return true;
            }
            case 14: {
                pSWFWorkTimeBase.resetPSWFWorkTimeName();
                return true;
            }
            case 15: {
                pSWFWorkTimeBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSWFWorkTimeBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSWFWorkTimeBase.resetUserCat();
                return true;
            }
            case 18: {
                pSWFWorkTimeBase.resetUserData();
                return true;
            }
            case 19: {
                pSWFWorkTimeBase.resetUserData2();
                return true;
            }
            case 20: {
                pSWFWorkTimeBase.resetUserTag();
                return true;
            }
            case 21: {
                pSWFWorkTimeBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSWFWorkTimeBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSWFWorkTimeBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSWFWorkTimeBase.resetWFWorktimeSN();
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSWFWorkTimeBase getProxyEntity() {
        return this.proxyPSWFWorkTimeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFWorkTimeBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFWorkTimeBase) {
            this.proxyPSWFWorkTimeBase = (PSWFWorkTimeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFWorkTimeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_ENABLE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSMODULEID, 7);
        fieldIndexMap.put(FIELD_PSMODULENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 9);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 12);
        fieldIndexMap.put(FIELD_PSWFWORKTIMEID, 13);
        fieldIndexMap.put(FIELD_PSWFWORKTIMENAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERDATA, 18);
        fieldIndexMap.put(FIELD_USERDATA2, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_WFWORKTIMESN, 24);
    }
}

