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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysOPPrivBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysOPPrivBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DEOPPRIV = "DEOPPRIV";
    public static final String FIELD_GLOBALFLAG = "GLOBALFLAG";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRIVID = "PRIVID";
    public static final String FIELD_PRIVTYPE = "PRIVTYPE";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String FIELD_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_ROLETAGPSDEFID = "ROLETAGPSDEFID";
    public static final String FIELD_ROLETAGPSDEFNAME = "ROLETAGPSDEFNAME";
    public static final String FIELD_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERIDPSDEFID = "USERIDPSDEFID";
    public static final String FIELD_USERIDPSDEFNAME = "USERIDPSDEFNAME";
    public static final String FIELD_USERROLESN = "USERROLESN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTMODE = 3;
    private static final int INDEX_DEOPPRIV = 4;
    private static final int INDEX_GLOBALFLAG = 5;
    private static final int INDEX_LOCKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PRIVID = 8;
    private static final int INDEX_PRIVTYPE = 9;
    private static final int INDEX_PSDEDATASETID = 10;
    private static final int INDEX_PSDEDATASETNAME = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSMODULEID = 14;
    private static final int INDEX_PSMODULENAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSOPPRIVID = 18;
    private static final int INDEX_PSSYSOPPRIVNAME = 19;
    private static final int INDEX_PSSYSSFPLUGINID = 20;
    private static final int INDEX_PSSYSSFPLUGINNAME = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_PSSYSTEMNAME = 23;
    private static final int INDEX_ROLETAGPSDEFID = 24;
    private static final int INDEX_ROLETAGPSDEFNAME = 25;
    private static final int INDEX_SYSTEMFLAG = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERIDPSDEFID = 30;
    private static final int INDEX_USERIDPSDEFNAME = 31;
    private static final int INDEX_USERROLESN = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysOPPrivBase proxyPSSysOPPrivBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean deopprivDirtyFlag = false;
    private boolean globalflagDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean prividDirtyFlag = false;
    private boolean privtypeDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysopprividDirtyFlag = false;
    private boolean pssysopprivnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean roletagpsdefidDirtyFlag = false;
    private boolean roletagpsdefnameDirtyFlag = false;
    private boolean systemflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean useridpsdefidDirtyFlag = false;
    private boolean useridpsdefnameDirtyFlag = false;
    private boolean userrolesnDirtyFlag = false;
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
    @Column(name="defaultmode")
    private String defaultmode;
    @Column(name="deoppriv")
    private String deoppriv;
    @Column(name="globalflag")
    private Integer globalflag;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="privid")
    private String privid;
    @Column(name="privtype")
    private String privtype;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysopprivid")
    private String pssysopprivid;
    @Column(name="pssysopprivname")
    private String pssysopprivname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="roletagpsdefid")
    private String roletagpsdefid;
    @Column(name="roletagpsdefname")
    private String roletagpsdefname;
    @Column(name="systemflag")
    private Integer systemflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="useridpsdefid")
    private String useridpsdefid;
    @Column(name="useridpsdefname")
    private String useridpsdefname;
    @Column(name="userrolesn")
    private String userrolesn;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objRoleTagPSDEFLock = new Integer(1);
    private PSDEField roletagpsdef = null;
    private Integer objUserIdPSDEFLock = new Integer(1);
    private PSDEField useridpsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUserRoleDatasLock = new Integer(1);
    private ArrayList<PSSysUserRoleData> pssysuserroledatas = null;
    private Integer objPSSysUserRoleResesLock = new Integer(1);
    private ArrayList<PSSysUserRoleRes> pssysuserrolereses = null;

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

    public void setDefaultMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultmode = string;
        this.defaultmodeDirtyFlag = true;
    }

    public String getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
    }

    public void setDEOpPriv(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEOpPriv(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deoppriv = string;
        this.deopprivDirtyFlag = true;
    }

    public String getDEOpPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEOpPriv();
        }
        return this.deoppriv;
    }

    public boolean isDEOpPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEOpPrivDirty();
        }
        return this.deopprivDirtyFlag;
    }

    public void resetDEOpPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEOpPriv();
            return;
        }
        this.deopprivDirtyFlag = false;
        this.deoppriv = null;
    }

    public void setGlobalFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGlobalFlag(n);
            return;
        }
        this.globalflag = n;
        this.globalflagDirtyFlag = true;
    }

    public Integer getGlobalFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGlobalFlag();
        }
        return this.globalflag;
    }

    public boolean isGlobalFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGlobalFlagDirty();
        }
        return this.globalflagDirtyFlag;
    }

    public void resetGlobalFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGlobalFlag();
            return;
        }
        this.globalflagDirtyFlag = false;
        this.globalflag = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
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

    public void setPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.privid = string;
        this.prividDirtyFlag = true;
    }

    public String getPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrivId();
        }
        return this.privid;
    }

    public boolean isPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrivIdDirty();
        }
        return this.prividDirtyFlag;
    }

    public void resetPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrivId();
            return;
        }
        this.prividDirtyFlag = false;
        this.privid = null;
    }

    public void setPrivType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrivType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.privtype = string;
        this.privtypeDirtyFlag = true;
    }

    public String getPrivType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrivType();
        }
        return this.privtype;
    }

    public boolean isPrivTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrivTypeDirty();
        }
        return this.privtypeDirtyFlag;
    }

    public void resetPrivType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrivType();
            return;
        }
        this.privtypeDirtyFlag = false;
        this.privtype = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSSysOPPrivId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivid = string;
        this.pssysopprividDirtyFlag = true;
    }

    public String getPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivId();
        }
        return this.pssysopprivid;
    }

    public boolean isPSSysOPPrivIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivIdDirty();
        }
        return this.pssysopprividDirtyFlag;
    }

    public void resetPSSysOPPrivId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivId();
            return;
        }
        this.pssysopprividDirtyFlag = false;
        this.pssysopprivid = null;
    }

    public void setPSSysOPPrivName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysOPPrivName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysopprivname = string;
        this.pssysopprivnameDirtyFlag = true;
    }

    public String getPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysOPPrivName();
        }
        return this.pssysopprivname;
    }

    public boolean isPSSysOPPrivNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysOPPrivNameDirty();
        }
        return this.pssysopprivnameDirtyFlag;
    }

    public void resetPSSysOPPrivName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysOPPrivName();
            return;
        }
        this.pssysopprivnameDirtyFlag = false;
        this.pssysopprivname = null;
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

    public void setRoleTagPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRoleTagPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.roletagpsdefid = string;
        this.roletagpsdefidDirtyFlag = true;
    }

    public String getRoleTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoleTagPSDEFId();
        }
        return this.roletagpsdefid;
    }

    public boolean isRoleTagPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRoleTagPSDEFIdDirty();
        }
        return this.roletagpsdefidDirtyFlag;
    }

    public void resetRoleTagPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRoleTagPSDEFId();
            return;
        }
        this.roletagpsdefidDirtyFlag = false;
        this.roletagpsdefid = null;
    }

    public void setRoleTagPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRoleTagPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.roletagpsdefname = string;
        this.roletagpsdefnameDirtyFlag = true;
    }

    public String getRoleTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoleTagPSDEFName();
        }
        return this.roletagpsdefname;
    }

    public boolean isRoleTagPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRoleTagPSDEFNameDirty();
        }
        return this.roletagpsdefnameDirtyFlag;
    }

    public void resetRoleTagPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRoleTagPSDEFName();
            return;
        }
        this.roletagpsdefnameDirtyFlag = false;
        this.roletagpsdefname = null;
    }

    public void setSystemFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSystemFlag(n);
            return;
        }
        this.systemflag = n;
        this.systemflagDirtyFlag = true;
    }

    public Integer getSystemFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSystemFlag();
        }
        return this.systemflag;
    }

    public boolean isSystemFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSystemFlagDirty();
        }
        return this.systemflagDirtyFlag;
    }

    public void resetSystemFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSystemFlag();
            return;
        }
        this.systemflagDirtyFlag = false;
        this.systemflag = null;
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

    public void setUserIdPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserIdPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.useridpsdefid = string;
        this.useridpsdefidDirtyFlag = true;
    }

    public String getUserIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserIdPSDEFId();
        }
        return this.useridpsdefid;
    }

    public boolean isUserIdPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserIdPSDEFIdDirty();
        }
        return this.useridpsdefidDirtyFlag;
    }

    public void resetUserIdPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserIdPSDEFId();
            return;
        }
        this.useridpsdefidDirtyFlag = false;
        this.useridpsdefid = null;
    }

    public void setUserIdPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserIdPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.useridpsdefname = string;
        this.useridpsdefnameDirtyFlag = true;
    }

    public String getUserIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserIdPSDEFName();
        }
        return this.useridpsdefname;
    }

    public boolean isUserIdPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserIdPSDEFNameDirty();
        }
        return this.useridpsdefnameDirtyFlag;
    }

    public void resetUserIdPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserIdPSDEFName();
            return;
        }
        this.useridpsdefnameDirtyFlag = false;
        this.useridpsdefname = null;
    }

    public void setUserRoleSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserRoleSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userrolesn = string;
        this.userrolesnDirtyFlag = true;
    }

    public String getUserRoleSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserRoleSN();
        }
        return this.userrolesn;
    }

    public boolean isUserRoleSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserRoleSNDirty();
        }
        return this.userrolesnDirtyFlag;
    }

    public void resetUserRoleSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserRoleSN();
            return;
        }
        this.userrolesnDirtyFlag = false;
        this.userrolesn = null;
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
        PSSysOPPrivBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysOPPrivBase pSSysOPPrivBase) {
        pSSysOPPrivBase.resetCodeName();
        pSSysOPPrivBase.resetCreateDate();
        pSSysOPPrivBase.resetCreateMan();
        pSSysOPPrivBase.resetDefaultMode();
        pSSysOPPrivBase.resetDEOpPriv();
        pSSysOPPrivBase.resetGlobalFlag();
        pSSysOPPrivBase.resetLockFlag();
        pSSysOPPrivBase.resetMemo();
        pSSysOPPrivBase.resetPrivId();
        pSSysOPPrivBase.resetPrivType();
        pSSysOPPrivBase.resetPSDEDataSetId();
        pSSysOPPrivBase.resetPSDEDataSetName();
        pSSysOPPrivBase.resetPSDEId();
        pSSysOPPrivBase.resetPSDEName();
        pSSysOPPrivBase.resetPSModuleId();
        pSSysOPPrivBase.resetPSModuleName();
        pSSysOPPrivBase.resetPSSysDynaModelId();
        pSSysOPPrivBase.resetPSSysDynaModelName();
        pSSysOPPrivBase.resetPSSysOPPrivId();
        pSSysOPPrivBase.resetPSSysOPPrivName();
        pSSysOPPrivBase.resetPSSysSFPluginId();
        pSSysOPPrivBase.resetPSSysSFPluginName();
        pSSysOPPrivBase.resetPSSystemId();
        pSSysOPPrivBase.resetPSSystemName();
        pSSysOPPrivBase.resetRoleTagPSDEFId();
        pSSysOPPrivBase.resetRoleTagPSDEFName();
        pSSysOPPrivBase.resetSystemFlag();
        pSSysOPPrivBase.resetUpdateDate();
        pSSysOPPrivBase.resetUpdateMan();
        pSSysOPPrivBase.resetUserCat();
        pSSysOPPrivBase.resetUserIdPSDEFId();
        pSSysOPPrivBase.resetUserIdPSDEFName();
        pSSysOPPrivBase.resetUserRoleSN();
        pSSysOPPrivBase.resetUserTag();
        pSSysOPPrivBase.resetUserTag2();
        pSSysOPPrivBase.resetUserTag3();
        pSSysOPPrivBase.resetUserTag4();
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
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDEOpPrivDirty()) {
            hashMap.put(FIELD_DEOPPRIV, this.getDEOpPriv());
        }
        if (!bl || this.isGlobalFlagDirty()) {
            hashMap.put(FIELD_GLOBALFLAG, this.getGlobalFlag());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrivIdDirty()) {
            hashMap.put(FIELD_PRIVID, this.getPrivId());
        }
        if (!bl || this.isPrivTypeDirty()) {
            hashMap.put(FIELD_PRIVTYPE, this.getPrivType());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        if (!bl || this.isPSSysOPPrivIdDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVID, this.getPSSysOPPrivId());
        }
        if (!bl || this.isPSSysOPPrivNameDirty()) {
            hashMap.put(FIELD_PSSYSOPPRIVNAME, this.getPSSysOPPrivName());
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
        if (!bl || this.isRoleTagPSDEFIdDirty()) {
            hashMap.put(FIELD_ROLETAGPSDEFID, this.getRoleTagPSDEFId());
        }
        if (!bl || this.isRoleTagPSDEFNameDirty()) {
            hashMap.put(FIELD_ROLETAGPSDEFNAME, this.getRoleTagPSDEFName());
        }
        if (!bl || this.isSystemFlagDirty()) {
            hashMap.put(FIELD_SYSTEMFLAG, this.getSystemFlag());
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
        if (!bl || this.isUserIdPSDEFIdDirty()) {
            hashMap.put(FIELD_USERIDPSDEFID, this.getUserIdPSDEFId());
        }
        if (!bl || this.isUserIdPSDEFNameDirty()) {
            hashMap.put(FIELD_USERIDPSDEFNAME, this.getUserIdPSDEFName());
        }
        if (!bl || this.isUserRoleSNDirty()) {
            hashMap.put(FIELD_USERROLESN, this.getUserRoleSN());
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
        return PSSysOPPrivBase.get(this, n);
    }

    private static Object get(PSSysOPPrivBase pSSysOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOPPrivBase.getCodeName();
            }
            case 1: {
                return pSSysOPPrivBase.getCreateDate();
            }
            case 2: {
                return pSSysOPPrivBase.getCreateMan();
            }
            case 3: {
                return pSSysOPPrivBase.getDefaultMode();
            }
            case 4: {
                return pSSysOPPrivBase.getDEOpPriv();
            }
            case 5: {
                return pSSysOPPrivBase.getGlobalFlag();
            }
            case 6: {
                return pSSysOPPrivBase.getLockFlag();
            }
            case 7: {
                return pSSysOPPrivBase.getMemo();
            }
            case 8: {
                return pSSysOPPrivBase.getPrivId();
            }
            case 9: {
                return pSSysOPPrivBase.getPrivType();
            }
            case 10: {
                return pSSysOPPrivBase.getPSDEDataSetId();
            }
            case 11: {
                return pSSysOPPrivBase.getPSDEDataSetName();
            }
            case 12: {
                return pSSysOPPrivBase.getPSDEId();
            }
            case 13: {
                return pSSysOPPrivBase.getPSDEName();
            }
            case 14: {
                return pSSysOPPrivBase.getPSModuleId();
            }
            case 15: {
                return pSSysOPPrivBase.getPSModuleName();
            }
            case 16: {
                return pSSysOPPrivBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSSysOPPrivBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSSysOPPrivBase.getPSSysOPPrivId();
            }
            case 19: {
                return pSSysOPPrivBase.getPSSysOPPrivName();
            }
            case 20: {
                return pSSysOPPrivBase.getPSSysSFPluginId();
            }
            case 21: {
                return pSSysOPPrivBase.getPSSysSFPluginName();
            }
            case 22: {
                return pSSysOPPrivBase.getPSSystemId();
            }
            case 23: {
                return pSSysOPPrivBase.getPSSystemName();
            }
            case 24: {
                return pSSysOPPrivBase.getRoleTagPSDEFId();
            }
            case 25: {
                return pSSysOPPrivBase.getRoleTagPSDEFName();
            }
            case 26: {
                return pSSysOPPrivBase.getSystemFlag();
            }
            case 27: {
                return pSSysOPPrivBase.getUpdateDate();
            }
            case 28: {
                return pSSysOPPrivBase.getUpdateMan();
            }
            case 29: {
                return pSSysOPPrivBase.getUserCat();
            }
            case 30: {
                return pSSysOPPrivBase.getUserIdPSDEFId();
            }
            case 31: {
                return pSSysOPPrivBase.getUserIdPSDEFName();
            }
            case 32: {
                return pSSysOPPrivBase.getUserRoleSN();
            }
            case 33: {
                return pSSysOPPrivBase.getUserTag();
            }
            case 34: {
                return pSSysOPPrivBase.getUserTag2();
            }
            case 35: {
                return pSSysOPPrivBase.getUserTag3();
            }
            case 36: {
                return pSSysOPPrivBase.getUserTag4();
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
        PSSysOPPrivBase.set(this, n, object);
    }

    private static void set(PSSysOPPrivBase pSSysOPPrivBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysOPPrivBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysOPPrivBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysOPPrivBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysOPPrivBase.setDefaultMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysOPPrivBase.setDEOpPriv(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysOPPrivBase.setGlobalFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysOPPrivBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysOPPrivBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysOPPrivBase.setPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysOPPrivBase.setPrivType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysOPPrivBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysOPPrivBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysOPPrivBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysOPPrivBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysOPPrivBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysOPPrivBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysOPPrivBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysOPPrivBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysOPPrivBase.setPSSysOPPrivId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysOPPrivBase.setPSSysOPPrivName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysOPPrivBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysOPPrivBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysOPPrivBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysOPPrivBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysOPPrivBase.setRoleTagPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysOPPrivBase.setRoleTagPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysOPPrivBase.setSystemFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSSysOPPrivBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSSysOPPrivBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysOPPrivBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysOPPrivBase.setUserIdPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysOPPrivBase.setUserIdPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysOPPrivBase.setUserRoleSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysOPPrivBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysOPPrivBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysOPPrivBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysOPPrivBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysOPPrivBase.isNull(this, n);
    }

    private static boolean isNull(PSSysOPPrivBase pSSysOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOPPrivBase.getCodeName() == null;
            }
            case 1: {
                return pSSysOPPrivBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysOPPrivBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysOPPrivBase.getDefaultMode() == null;
            }
            case 4: {
                return pSSysOPPrivBase.getDEOpPriv() == null;
            }
            case 5: {
                return pSSysOPPrivBase.getGlobalFlag() == null;
            }
            case 6: {
                return pSSysOPPrivBase.getLockFlag() == null;
            }
            case 7: {
                return pSSysOPPrivBase.getMemo() == null;
            }
            case 8: {
                return pSSysOPPrivBase.getPrivId() == null;
            }
            case 9: {
                return pSSysOPPrivBase.getPrivType() == null;
            }
            case 10: {
                return pSSysOPPrivBase.getPSDEDataSetId() == null;
            }
            case 11: {
                return pSSysOPPrivBase.getPSDEDataSetName() == null;
            }
            case 12: {
                return pSSysOPPrivBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysOPPrivBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysOPPrivBase.getPSModuleId() == null;
            }
            case 15: {
                return pSSysOPPrivBase.getPSModuleName() == null;
            }
            case 16: {
                return pSSysOPPrivBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSysOPPrivBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSysOPPrivBase.getPSSysOPPrivId() == null;
            }
            case 19: {
                return pSSysOPPrivBase.getPSSysOPPrivName() == null;
            }
            case 20: {
                return pSSysOPPrivBase.getPSSysSFPluginId() == null;
            }
            case 21: {
                return pSSysOPPrivBase.getPSSysSFPluginName() == null;
            }
            case 22: {
                return pSSysOPPrivBase.getPSSystemId() == null;
            }
            case 23: {
                return pSSysOPPrivBase.getPSSystemName() == null;
            }
            case 24: {
                return pSSysOPPrivBase.getRoleTagPSDEFId() == null;
            }
            case 25: {
                return pSSysOPPrivBase.getRoleTagPSDEFName() == null;
            }
            case 26: {
                return pSSysOPPrivBase.getSystemFlag() == null;
            }
            case 27: {
                return pSSysOPPrivBase.getUpdateDate() == null;
            }
            case 28: {
                return pSSysOPPrivBase.getUpdateMan() == null;
            }
            case 29: {
                return pSSysOPPrivBase.getUserCat() == null;
            }
            case 30: {
                return pSSysOPPrivBase.getUserIdPSDEFId() == null;
            }
            case 31: {
                return pSSysOPPrivBase.getUserIdPSDEFName() == null;
            }
            case 32: {
                return pSSysOPPrivBase.getUserRoleSN() == null;
            }
            case 33: {
                return pSSysOPPrivBase.getUserTag() == null;
            }
            case 34: {
                return pSSysOPPrivBase.getUserTag2() == null;
            }
            case 35: {
                return pSSysOPPrivBase.getUserTag3() == null;
            }
            case 36: {
                return pSSysOPPrivBase.getUserTag4() == null;
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
        return PSSysOPPrivBase.contains(this, n);
    }

    private static boolean contains(PSSysOPPrivBase pSSysOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysOPPrivBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysOPPrivBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysOPPrivBase.isCreateManDirty();
            }
            case 3: {
                return pSSysOPPrivBase.isDefaultModeDirty();
            }
            case 4: {
                return pSSysOPPrivBase.isDEOpPrivDirty();
            }
            case 5: {
                return pSSysOPPrivBase.isGlobalFlagDirty();
            }
            case 6: {
                return pSSysOPPrivBase.isLockFlagDirty();
            }
            case 7: {
                return pSSysOPPrivBase.isMemoDirty();
            }
            case 8: {
                return pSSysOPPrivBase.isPrivIdDirty();
            }
            case 9: {
                return pSSysOPPrivBase.isPrivTypeDirty();
            }
            case 10: {
                return pSSysOPPrivBase.isPSDEDataSetIdDirty();
            }
            case 11: {
                return pSSysOPPrivBase.isPSDEDataSetNameDirty();
            }
            case 12: {
                return pSSysOPPrivBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysOPPrivBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysOPPrivBase.isPSModuleIdDirty();
            }
            case 15: {
                return pSSysOPPrivBase.isPSModuleNameDirty();
            }
            case 16: {
                return pSSysOPPrivBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSysOPPrivBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSysOPPrivBase.isPSSysOPPrivIdDirty();
            }
            case 19: {
                return pSSysOPPrivBase.isPSSysOPPrivNameDirty();
            }
            case 20: {
                return pSSysOPPrivBase.isPSSysSFPluginIdDirty();
            }
            case 21: {
                return pSSysOPPrivBase.isPSSysSFPluginNameDirty();
            }
            case 22: {
                return pSSysOPPrivBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSSysOPPrivBase.isPSSystemNameDirty();
            }
            case 24: {
                return pSSysOPPrivBase.isRoleTagPSDEFIdDirty();
            }
            case 25: {
                return pSSysOPPrivBase.isRoleTagPSDEFNameDirty();
            }
            case 26: {
                return pSSysOPPrivBase.isSystemFlagDirty();
            }
            case 27: {
                return pSSysOPPrivBase.isUpdateDateDirty();
            }
            case 28: {
                return pSSysOPPrivBase.isUpdateManDirty();
            }
            case 29: {
                return pSSysOPPrivBase.isUserCatDirty();
            }
            case 30: {
                return pSSysOPPrivBase.isUserIdPSDEFIdDirty();
            }
            case 31: {
                return pSSysOPPrivBase.isUserIdPSDEFNameDirty();
            }
            case 32: {
                return pSSysOPPrivBase.isUserRoleSNDirty();
            }
            case 33: {
                return pSSysOPPrivBase.isUserTagDirty();
            }
            case 34: {
                return pSSysOPPrivBase.isUserTag2Dirty();
            }
            case 35: {
                return pSSysOPPrivBase.isUserTag3Dirty();
            }
            case 36: {
                return pSSysOPPrivBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysOPPrivBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysOPPrivBase pSSysOPPrivBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysOPPrivBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getDEOpPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deoppriv", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getDEOpPriv()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getGlobalFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"globalflag", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getGlobalFlag()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"privid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPrivId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPrivType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"privtype", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPrivType()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysOPPrivId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysOPPrivId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysOPPrivName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysopprivname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysOPPrivName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getRoleTagPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"roletagpsdefid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getRoleTagPSDEFId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getRoleTagPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"roletagpsdefname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getRoleTagPSDEFName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getSystemFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systemflag", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getSystemFlag()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserIdPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"useridpsdefid", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserIdPSDEFId()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserIdPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"useridpsdefname", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserIdPSDEFName()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserRoleSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userrolesn", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserRoleSN()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysOPPrivBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysOPPrivBase.getJSONValue((Object)pSSysOPPrivBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysOPPrivBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysOPPrivBase pSSysOPPrivBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysOPPrivBase.getCodeName() != null) {
            object = pSSysOPPrivBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getCreateDate() != null) {
            object = pSSysOPPrivBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOPPrivBase.getCreateMan() != null) {
            object = pSSysOPPrivBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getDefaultMode() != null) {
            object = pSSysOPPrivBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getDEOpPriv() != null) {
            object = pSSysOPPrivBase.getDEOpPriv();
            xmlNode.setAttribute(FIELD_DEOPPRIV, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getGlobalFlag() != null) {
            object = pSSysOPPrivBase.getGlobalFlag();
            xmlNode.setAttribute(FIELD_GLOBALFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOPPrivBase.getLockFlag() != null) {
            object = pSSysOPPrivBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOPPrivBase.getMemo() != null) {
            object = pSSysOPPrivBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPrivId() != null) {
            object = pSSysOPPrivBase.getPrivId();
            xmlNode.setAttribute(FIELD_PRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPrivType() != null) {
            object = pSSysOPPrivBase.getPrivType();
            xmlNode.setAttribute(FIELD_PRIVTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSDEDataSetId() != null) {
            object = pSSysOPPrivBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSDEDataSetName() != null) {
            object = pSSysOPPrivBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSDEId() != null) {
            object = pSSysOPPrivBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSDEName() != null) {
            object = pSSysOPPrivBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSModuleId() != null) {
            object = pSSysOPPrivBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSModuleName() != null) {
            object = pSSysOPPrivBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysDynaModelId() != null) {
            object = pSSysOPPrivBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysDynaModelName() != null) {
            object = pSSysOPPrivBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysOPPrivId() != null) {
            object = pSSysOPPrivBase.getPSSysOPPrivId();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysOPPrivName() != null) {
            object = pSSysOPPrivBase.getPSSysOPPrivName();
            xmlNode.setAttribute(FIELD_PSSYSOPPRIVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysSFPluginId() != null) {
            object = pSSysOPPrivBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSysSFPluginName() != null) {
            object = pSSysOPPrivBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSystemId() != null) {
            object = pSSysOPPrivBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getPSSystemName() != null) {
            object = pSSysOPPrivBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getRoleTagPSDEFId() != null) {
            object = pSSysOPPrivBase.getRoleTagPSDEFId();
            xmlNode.setAttribute(FIELD_ROLETAGPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getRoleTagPSDEFName() != null) {
            object = pSSysOPPrivBase.getRoleTagPSDEFName();
            xmlNode.setAttribute(FIELD_ROLETAGPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getSystemFlag() != null) {
            object = pSSysOPPrivBase.getSystemFlag();
            xmlNode.setAttribute(FIELD_SYSTEMFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysOPPrivBase.getUpdateDate() != null) {
            object = pSSysOPPrivBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysOPPrivBase.getUpdateMan() != null) {
            object = pSSysOPPrivBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserCat() != null) {
            object = pSSysOPPrivBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserIdPSDEFId() != null) {
            object = pSSysOPPrivBase.getUserIdPSDEFId();
            xmlNode.setAttribute(FIELD_USERIDPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserIdPSDEFName() != null) {
            object = pSSysOPPrivBase.getUserIdPSDEFName();
            xmlNode.setAttribute(FIELD_USERIDPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserRoleSN() != null) {
            object = pSSysOPPrivBase.getUserRoleSN();
            xmlNode.setAttribute(FIELD_USERROLESN, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserTag() != null) {
            object = pSSysOPPrivBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserTag2() != null) {
            object = pSSysOPPrivBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserTag3() != null) {
            object = pSSysOPPrivBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysOPPrivBase.getUserTag4() != null) {
            object = pSSysOPPrivBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysOPPrivBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysOPPrivBase pSSysOPPrivBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysOPPrivBase.isCodeNameDirty() && (bl || pSSysOPPrivBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysOPPrivBase.getCodeName());
        }
        if (pSSysOPPrivBase.isCreateDateDirty() && (bl || pSSysOPPrivBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysOPPrivBase.getCreateDate());
        }
        if (pSSysOPPrivBase.isCreateManDirty() && (bl || pSSysOPPrivBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysOPPrivBase.getCreateMan());
        }
        if (pSSysOPPrivBase.isDefaultModeDirty() && (bl || pSSysOPPrivBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSSysOPPrivBase.getDefaultMode());
        }
        if (pSSysOPPrivBase.isDEOpPrivDirty() && (bl || pSSysOPPrivBase.getDEOpPriv() != null)) {
            iDataObject.set(FIELD_DEOPPRIV, (Object)pSSysOPPrivBase.getDEOpPriv());
        }
        if (pSSysOPPrivBase.isGlobalFlagDirty() && (bl || pSSysOPPrivBase.getGlobalFlag() != null)) {
            iDataObject.set(FIELD_GLOBALFLAG, (Object)pSSysOPPrivBase.getGlobalFlag());
        }
        if (pSSysOPPrivBase.isLockFlagDirty() && (bl || pSSysOPPrivBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysOPPrivBase.getLockFlag());
        }
        if (pSSysOPPrivBase.isMemoDirty() && (bl || pSSysOPPrivBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysOPPrivBase.getMemo());
        }
        if (pSSysOPPrivBase.isPrivIdDirty() && (bl || pSSysOPPrivBase.getPrivId() != null)) {
            iDataObject.set(FIELD_PRIVID, (Object)pSSysOPPrivBase.getPrivId());
        }
        if (pSSysOPPrivBase.isPrivTypeDirty() && (bl || pSSysOPPrivBase.getPrivType() != null)) {
            iDataObject.set(FIELD_PRIVTYPE, (Object)pSSysOPPrivBase.getPrivType());
        }
        if (pSSysOPPrivBase.isPSDEDataSetIdDirty() && (bl || pSSysOPPrivBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysOPPrivBase.getPSDEDataSetId());
        }
        if (pSSysOPPrivBase.isPSDEDataSetNameDirty() && (bl || pSSysOPPrivBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysOPPrivBase.getPSDEDataSetName());
        }
        if (pSSysOPPrivBase.isPSDEIdDirty() && (bl || pSSysOPPrivBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysOPPrivBase.getPSDEId());
        }
        if (pSSysOPPrivBase.isPSDENameDirty() && (bl || pSSysOPPrivBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysOPPrivBase.getPSDEName());
        }
        if (pSSysOPPrivBase.isPSModuleIdDirty() && (bl || pSSysOPPrivBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysOPPrivBase.getPSModuleId());
        }
        if (pSSysOPPrivBase.isPSModuleNameDirty() && (bl || pSSysOPPrivBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysOPPrivBase.getPSModuleName());
        }
        if (pSSysOPPrivBase.isPSSysDynaModelIdDirty() && (bl || pSSysOPPrivBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysOPPrivBase.getPSSysDynaModelId());
        }
        if (pSSysOPPrivBase.isPSSysDynaModelNameDirty() && (bl || pSSysOPPrivBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysOPPrivBase.getPSSysDynaModelName());
        }
        if (pSSysOPPrivBase.isPSSysOPPrivIdDirty() && (bl || pSSysOPPrivBase.getPSSysOPPrivId() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVID, (Object)pSSysOPPrivBase.getPSSysOPPrivId());
        }
        if (pSSysOPPrivBase.isPSSysOPPrivNameDirty() && (bl || pSSysOPPrivBase.getPSSysOPPrivName() != null)) {
            iDataObject.set(FIELD_PSSYSOPPRIVNAME, (Object)pSSysOPPrivBase.getPSSysOPPrivName());
        }
        if (pSSysOPPrivBase.isPSSysSFPluginIdDirty() && (bl || pSSysOPPrivBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysOPPrivBase.getPSSysSFPluginId());
        }
        if (pSSysOPPrivBase.isPSSysSFPluginNameDirty() && (bl || pSSysOPPrivBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysOPPrivBase.getPSSysSFPluginName());
        }
        if (pSSysOPPrivBase.isPSSystemIdDirty() && (bl || pSSysOPPrivBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysOPPrivBase.getPSSystemId());
        }
        if (pSSysOPPrivBase.isPSSystemNameDirty() && (bl || pSSysOPPrivBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysOPPrivBase.getPSSystemName());
        }
        if (pSSysOPPrivBase.isRoleTagPSDEFIdDirty() && (bl || pSSysOPPrivBase.getRoleTagPSDEFId() != null)) {
            iDataObject.set(FIELD_ROLETAGPSDEFID, (Object)pSSysOPPrivBase.getRoleTagPSDEFId());
        }
        if (pSSysOPPrivBase.isRoleTagPSDEFNameDirty() && (bl || pSSysOPPrivBase.getRoleTagPSDEFName() != null)) {
            iDataObject.set(FIELD_ROLETAGPSDEFNAME, (Object)pSSysOPPrivBase.getRoleTagPSDEFName());
        }
        if (pSSysOPPrivBase.isSystemFlagDirty() && (bl || pSSysOPPrivBase.getSystemFlag() != null)) {
            iDataObject.set(FIELD_SYSTEMFLAG, (Object)pSSysOPPrivBase.getSystemFlag());
        }
        if (pSSysOPPrivBase.isUpdateDateDirty() && (bl || pSSysOPPrivBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysOPPrivBase.getUpdateDate());
        }
        if (pSSysOPPrivBase.isUpdateManDirty() && (bl || pSSysOPPrivBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysOPPrivBase.getUpdateMan());
        }
        if (pSSysOPPrivBase.isUserCatDirty() && (bl || pSSysOPPrivBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysOPPrivBase.getUserCat());
        }
        if (pSSysOPPrivBase.isUserIdPSDEFIdDirty() && (bl || pSSysOPPrivBase.getUserIdPSDEFId() != null)) {
            iDataObject.set(FIELD_USERIDPSDEFID, (Object)pSSysOPPrivBase.getUserIdPSDEFId());
        }
        if (pSSysOPPrivBase.isUserIdPSDEFNameDirty() && (bl || pSSysOPPrivBase.getUserIdPSDEFName() != null)) {
            iDataObject.set(FIELD_USERIDPSDEFNAME, (Object)pSSysOPPrivBase.getUserIdPSDEFName());
        }
        if (pSSysOPPrivBase.isUserRoleSNDirty() && (bl || pSSysOPPrivBase.getUserRoleSN() != null)) {
            iDataObject.set(FIELD_USERROLESN, (Object)pSSysOPPrivBase.getUserRoleSN());
        }
        if (pSSysOPPrivBase.isUserTagDirty() && (bl || pSSysOPPrivBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysOPPrivBase.getUserTag());
        }
        if (pSSysOPPrivBase.isUserTag2Dirty() && (bl || pSSysOPPrivBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysOPPrivBase.getUserTag2());
        }
        if (pSSysOPPrivBase.isUserTag3Dirty() && (bl || pSSysOPPrivBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysOPPrivBase.getUserTag3());
        }
        if (pSSysOPPrivBase.isUserTag4Dirty() && (bl || pSSysOPPrivBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysOPPrivBase.getUserTag4());
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
        return PSSysOPPrivBase.remove(this, n);
    }

    private static boolean remove(PSSysOPPrivBase pSSysOPPrivBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysOPPrivBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysOPPrivBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysOPPrivBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysOPPrivBase.resetDefaultMode();
                return true;
            }
            case 4: {
                pSSysOPPrivBase.resetDEOpPriv();
                return true;
            }
            case 5: {
                pSSysOPPrivBase.resetGlobalFlag();
                return true;
            }
            case 6: {
                pSSysOPPrivBase.resetLockFlag();
                return true;
            }
            case 7: {
                pSSysOPPrivBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysOPPrivBase.resetPrivId();
                return true;
            }
            case 9: {
                pSSysOPPrivBase.resetPrivType();
                return true;
            }
            case 10: {
                pSSysOPPrivBase.resetPSDEDataSetId();
                return true;
            }
            case 11: {
                pSSysOPPrivBase.resetPSDEDataSetName();
                return true;
            }
            case 12: {
                pSSysOPPrivBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysOPPrivBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysOPPrivBase.resetPSModuleId();
                return true;
            }
            case 15: {
                pSSysOPPrivBase.resetPSModuleName();
                return true;
            }
            case 16: {
                pSSysOPPrivBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSysOPPrivBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSysOPPrivBase.resetPSSysOPPrivId();
                return true;
            }
            case 19: {
                pSSysOPPrivBase.resetPSSysOPPrivName();
                return true;
            }
            case 20: {
                pSSysOPPrivBase.resetPSSysSFPluginId();
                return true;
            }
            case 21: {
                pSSysOPPrivBase.resetPSSysSFPluginName();
                return true;
            }
            case 22: {
                pSSysOPPrivBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSSysOPPrivBase.resetPSSystemName();
                return true;
            }
            case 24: {
                pSSysOPPrivBase.resetRoleTagPSDEFId();
                return true;
            }
            case 25: {
                pSSysOPPrivBase.resetRoleTagPSDEFName();
                return true;
            }
            case 26: {
                pSSysOPPrivBase.resetSystemFlag();
                return true;
            }
            case 27: {
                pSSysOPPrivBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSSysOPPrivBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSSysOPPrivBase.resetUserCat();
                return true;
            }
            case 30: {
                pSSysOPPrivBase.resetUserIdPSDEFId();
                return true;
            }
            case 31: {
                pSSysOPPrivBase.resetUserIdPSDEFName();
                return true;
            }
            case 32: {
                pSSysOPPrivBase.resetUserRoleSN();
                return true;
            }
            case 33: {
                pSSysOPPrivBase.resetUserTag();
                return true;
            }
            case 34: {
                pSSysOPPrivBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSSysOPPrivBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSSysOPPrivBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getRoleTagPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoleTagPSDEF();
        }
        if (this.getRoleTagPSDEFId() == null) {
            return null;
        }
        Integer n = this.objRoleTagPSDEFLock;
        synchronized (n) {
            if (this.roletagpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getRoleTagPSDEFId(), (Object)this.roletagpsdef.getPSDEFieldId()) != 0L) {
                this.roletagpsdef = null;
            }
            if (this.roletagpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getRoleTagPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.roletagpsdef = pSDEField;
            }
            return this.roletagpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserIdPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserIdPSDEF();
        }
        if (this.getUserIdPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserIdPSDEFLock;
        synchronized (n) {
            if (this.useridpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserIdPSDEFId(), (Object)this.useridpsdef.getPSDEFieldId()) != 0L) {
                this.useridpsdef = null;
            }
            if (this.useridpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserIdPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.useridpsdef = pSDEField;
            }
            return this.useridpsdef;
        }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserRoleData> getPSSysUserRoleDatas() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleDatas();
        }
        if (this.getPSSysOPPrivId() == null) {
            return null;
        }
        PSSysUserRoleDataService pSSysUserRoleDataService = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserRoleDatasLock;
        synchronized (n) {
            if (this.pssysuserroledatas == null) {
                this.pssysuserroledatas = pSSysUserRoleDataService.selectByPSSysOPPriv(this);
            }
            return this.pssysuserroledatas;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysUserRoleRes> getPSSysUserRoleReses() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserRoleReses();
        }
        if (this.getPSSysOPPrivId() == null) {
            return null;
        }
        PSSysUserRoleResService pSSysUserRoleResService = (PSSysUserRoleResService)ServiceGlobal.getService(PSSysUserRoleResService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysUserRoleResesLock;
        synchronized (n) {
            if (this.pssysuserrolereses == null) {
                this.pssysuserrolereses = pSSysUserRoleResService.selectByPSSysOPPriv(this);
            }
            return this.pssysuserrolereses;
        }
    }

    private PSSysOPPrivBase getProxyEntity() {
        return this.proxyPSSysOPPrivBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysOPPrivBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysOPPrivBase) {
            this.proxyPSSysOPPrivBase = (PSSysOPPrivBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 3);
        fieldIndexMap.put(FIELD_DEOPPRIV, 4);
        fieldIndexMap.put(FIELD_GLOBALFLAG, 5);
        fieldIndexMap.put(FIELD_LOCKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PRIVID, 8);
        fieldIndexMap.put(FIELD_PRIVTYPE, 9);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 10);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSMODULEID, 14);
        fieldIndexMap.put(FIELD_PSMODULENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVID, 18);
        fieldIndexMap.put(FIELD_PSSYSOPPRIVNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 23);
        fieldIndexMap.put(FIELD_ROLETAGPSDEFID, 24);
        fieldIndexMap.put(FIELD_ROLETAGPSDEFNAME, 25);
        fieldIndexMap.put(FIELD_SYSTEMFLAG, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERIDPSDEFID, 30);
        fieldIndexMap.put(FIELD_USERIDPSDEFNAME, 31);
        fieldIndexMap.put(FIELD_USERROLESN, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
    }
}

