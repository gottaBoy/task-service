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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTranslatorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysTranslatorBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_TRANSLATORPARAMS = "TRANSLATORPARAMS";
    public static final String FIELD_TRANSLATORTAG = "TRANSLATORTAG";
    public static final String FIELD_TRANSLATORTAG2 = "TRANSLATORTAG2";
    public static final String FIELD_TRANSLATORTYPE = "TRANSLATORTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USER2PSDEFID = "USER2PSDEFID";
    public static final String FIELD_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPSDEFID = "USERPSDEFID";
    public static final String FIELD_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String FIELD_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_CUSTOMMODE = 4;
    private static final int INDEX_KEYPSDEFID = 5;
    private static final int INDEX_KEYPSDEFNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSCODELISTID = 8;
    private static final int INDEX_PSCODELISTNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_PSMODULEID = 12;
    private static final int INDEX_PSMODULENAME = 13;
    private static final int INDEX_PSSYSDYNAMODELID = 14;
    private static final int INDEX_PSSYSDYNAMODELNAME = 15;
    private static final int INDEX_PSSYSSFPLUGINID = 16;
    private static final int INDEX_PSSYSSFPLUGINNAME = 17;
    private static final int INDEX_PSSYSTEMID = 18;
    private static final int INDEX_PSSYSTEMNAME = 19;
    private static final int INDEX_PSSYSTRANSLATORID = 20;
    private static final int INDEX_PSSYSTRANSLATORNAME = 21;
    private static final int INDEX_TRANSLATORPARAMS = 22;
    private static final int INDEX_TRANSLATORTAG = 23;
    private static final int INDEX_TRANSLATORTAG2 = 24;
    private static final int INDEX_TRANSLATORTYPE = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USER2PSDEFID = 28;
    private static final int INDEX_USER2PSDEFNAME = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERPSDEFID = 31;
    private static final int INDEX_USERPSDEFNAME = 32;
    private static final int INDEX_USERTAG = 33;
    private static final int INDEX_USERTAG2 = 34;
    private static final int INDEX_USERTAG3 = 35;
    private static final int INDEX_USERTAG4 = 36;
    private static final int INDEX_VALIDFLAG = 37;
    private static final int INDEX_VALUEPSDEFID = 38;
    private static final int INDEX_VALUEPSDEFNAME = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysTranslatorBase proxyPSSysTranslatorBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean translatorparamsDirtyFlag = false;
    private boolean translatortagDirtyFlag = false;
    private boolean translatortag2DirtyFlag = false;
    private boolean translatortypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean user2psdefidDirtyFlag = false;
    private boolean user2psdefnameDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userpsdefidDirtyFlag = false;
    private boolean userpsdefnameDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valuepsdefidDirtyFlag = false;
    private boolean valuepsdefnameDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="memo")
    private String memo;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
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
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="translatorparams")
    private String translatorparams;
    @Column(name="translatortag")
    private String translatortag;
    @Column(name="translatortag2")
    private String translatortag2;
    @Column(name="translatortype")
    private String translatortype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="user2psdefid")
    private String user2psdefid;
    @Column(name="user2psdefname")
    private String user2psdefname;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userpsdefid")
    private String userpsdefid;
    @Column(name="userpsdefname")
    private String userpsdefname;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valuepsdefid")
    private String valuepsdefid;
    @Column(name="valuepsdefname")
    private String valuepsdefname;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objUser2PSDEFLock = new Integer(1);
    private PSDEField user2psdef = null;
    private Integer objUserPSDEFLock = new Integer(1);
    private PSDEField userpsdef = null;
    private Integer objValuePSDEFLock = new Integer(1);
    private PSDEField valuepsdef = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefid = string;
        this.keypsdefidDirtyFlag = true;
    }

    public String getKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFId();
        }
        return this.keypsdefid;
    }

    public boolean isKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFIdDirty();
        }
        return this.keypsdefidDirtyFlag;
    }

    public void resetKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFId();
            return;
        }
        this.keypsdefidDirtyFlag = false;
        this.keypsdefid = null;
    }

    public void setKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefname = string;
        this.keypsdefnameDirtyFlag = true;
    }

    public String getKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFName();
        }
        return this.keypsdefname;
    }

    public boolean isKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFNameDirty();
        }
        return this.keypsdefnameDirtyFlag;
    }

    public void resetKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFName();
            return;
        }
        this.keypsdefnameDirtyFlag = false;
        this.keypsdefname = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
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

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setTranslatorParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTranslatorParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.translatorparams = string;
        this.translatorparamsDirtyFlag = true;
    }

    public String getTranslatorParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTranslatorParams();
        }
        return this.translatorparams;
    }

    public boolean isTranslatorParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTranslatorParamsDirty();
        }
        return this.translatorparamsDirtyFlag;
    }

    public void resetTranslatorParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTranslatorParams();
            return;
        }
        this.translatorparamsDirtyFlag = false;
        this.translatorparams = null;
    }

    public void setTranslatorTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTranslatorTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.translatortag = string;
        this.translatortagDirtyFlag = true;
    }

    public String getTranslatorTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTranslatorTag();
        }
        return this.translatortag;
    }

    public boolean isTranslatorTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTranslatorTagDirty();
        }
        return this.translatortagDirtyFlag;
    }

    public void resetTranslatorTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTranslatorTag();
            return;
        }
        this.translatortagDirtyFlag = false;
        this.translatortag = null;
    }

    public void setTranslatorTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTranslatorTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.translatortag2 = string;
        this.translatortag2DirtyFlag = true;
    }

    public String getTranslatorTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTranslatorTag2();
        }
        return this.translatortag2;
    }

    public boolean isTranslatorTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTranslatorTag2Dirty();
        }
        return this.translatortag2DirtyFlag;
    }

    public void resetTranslatorTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTranslatorTag2();
            return;
        }
        this.translatortag2DirtyFlag = false;
        this.translatortag2 = null;
    }

    public void setTranslatorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTranslatorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.translatortype = string;
        this.translatortypeDirtyFlag = true;
    }

    public String getTranslatorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTranslatorType();
        }
        return this.translatortype;
    }

    public boolean isTranslatorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTranslatorTypeDirty();
        }
        return this.translatortypeDirtyFlag;
    }

    public void resetTranslatorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTranslatorType();
            return;
        }
        this.translatortypeDirtyFlag = false;
        this.translatortype = null;
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

    public void setUser2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefid = string;
        this.user2psdefidDirtyFlag = true;
    }

    public String getUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFId();
        }
        return this.user2psdefid;
    }

    public boolean isUser2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFIdDirty();
        }
        return this.user2psdefidDirtyFlag;
    }

    public void resetUser2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFId();
            return;
        }
        this.user2psdefidDirtyFlag = false;
        this.user2psdefid = null;
    }

    public void setUser2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUser2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.user2psdefname = string;
        this.user2psdefnameDirtyFlag = true;
    }

    public String getUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEFName();
        }
        return this.user2psdefname;
    }

    public boolean isUser2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUser2PSDEFNameDirty();
        }
        return this.user2psdefnameDirtyFlag;
    }

    public void resetUser2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUser2PSDEFName();
            return;
        }
        this.user2psdefnameDirtyFlag = false;
        this.user2psdefname = null;
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

    public void setUserPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefid = string;
        this.userpsdefidDirtyFlag = true;
    }

    public String getUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFId();
        }
        return this.userpsdefid;
    }

    public boolean isUserPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFIdDirty();
        }
        return this.userpsdefidDirtyFlag;
    }

    public void resetUserPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFId();
            return;
        }
        this.userpsdefidDirtyFlag = false;
        this.userpsdefid = null;
    }

    public void setUserPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userpsdefname = string;
        this.userpsdefnameDirtyFlag = true;
    }

    public String getUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEFName();
        }
        return this.userpsdefname;
    }

    public boolean isUserPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserPSDEFNameDirty();
        }
        return this.userpsdefnameDirtyFlag;
    }

    public void resetUserPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserPSDEFName();
            return;
        }
        this.userpsdefnameDirtyFlag = false;
        this.userpsdefname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefid = string;
        this.valuepsdefidDirtyFlag = true;
    }

    public String getValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFId();
        }
        return this.valuepsdefid;
    }

    public boolean isValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFIdDirty();
        }
        return this.valuepsdefidDirtyFlag;
    }

    public void resetValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFId();
            return;
        }
        this.valuepsdefidDirtyFlag = false;
        this.valuepsdefid = null;
    }

    public void setValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefname = string;
        this.valuepsdefnameDirtyFlag = true;
    }

    public String getValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFName();
        }
        return this.valuepsdefname;
    }

    public boolean isValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFNameDirty();
        }
        return this.valuepsdefnameDirtyFlag;
    }

    public void resetValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFName();
            return;
        }
        this.valuepsdefnameDirtyFlag = false;
        this.valuepsdefname = null;
    }

    protected void onReset() {
        PSSysTranslatorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysTranslatorBase pSSysTranslatorBase) {
        pSSysTranslatorBase.resetCodeName();
        pSSysTranslatorBase.resetCreateDate();
        pSSysTranslatorBase.resetCreateMan();
        pSSysTranslatorBase.resetCustomCode();
        pSSysTranslatorBase.resetCustomMode();
        pSSysTranslatorBase.resetKeyPSDEFId();
        pSSysTranslatorBase.resetKeyPSDEFName();
        pSSysTranslatorBase.resetMemo();
        pSSysTranslatorBase.resetPSCodeListId();
        pSSysTranslatorBase.resetPSCodeListName();
        pSSysTranslatorBase.resetPSDEId();
        pSSysTranslatorBase.resetPSDEName();
        pSSysTranslatorBase.resetPSModuleId();
        pSSysTranslatorBase.resetPSModuleName();
        pSSysTranslatorBase.resetPSSysDynaModelId();
        pSSysTranslatorBase.resetPSSysDynaModelName();
        pSSysTranslatorBase.resetPSSysSFPluginId();
        pSSysTranslatorBase.resetPSSysSFPluginName();
        pSSysTranslatorBase.resetPSSystemId();
        pSSysTranslatorBase.resetPSSystemName();
        pSSysTranslatorBase.resetPSSysTranslatorId();
        pSSysTranslatorBase.resetPSSysTranslatorName();
        pSSysTranslatorBase.resetTranslatorParams();
        pSSysTranslatorBase.resetTranslatorTag();
        pSSysTranslatorBase.resetTranslatorTag2();
        pSSysTranslatorBase.resetTranslatorType();
        pSSysTranslatorBase.resetUpdateDate();
        pSSysTranslatorBase.resetUpdateMan();
        pSSysTranslatorBase.resetUser2PSDEFId();
        pSSysTranslatorBase.resetUser2PSDEFName();
        pSSysTranslatorBase.resetUserCat();
        pSSysTranslatorBase.resetUserPSDEFId();
        pSSysTranslatorBase.resetUserPSDEFName();
        pSSysTranslatorBase.resetUserTag();
        pSSysTranslatorBase.resetUserTag2();
        pSSysTranslatorBase.resetUserTag3();
        pSSysTranslatorBase.resetUserTag4();
        pSSysTranslatorBase.resetValidFlag();
        pSSysTranslatorBase.resetValuePSDEFId();
        pSSysTranslatorBase.resetValuePSDEFName();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
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
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isTranslatorParamsDirty()) {
            hashMap.put(FIELD_TRANSLATORPARAMS, this.getTranslatorParams());
        }
        if (!bl || this.isTranslatorTagDirty()) {
            hashMap.put(FIELD_TRANSLATORTAG, this.getTranslatorTag());
        }
        if (!bl || this.isTranslatorTag2Dirty()) {
            hashMap.put(FIELD_TRANSLATORTAG2, this.getTranslatorTag2());
        }
        if (!bl || this.isTranslatorTypeDirty()) {
            hashMap.put(FIELD_TRANSLATORTYPE, this.getTranslatorType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUser2PSDEFIdDirty()) {
            hashMap.put(FIELD_USER2PSDEFID, this.getUser2PSDEFId());
        }
        if (!bl || this.isUser2PSDEFNameDirty()) {
            hashMap.put(FIELD_USER2PSDEFNAME, this.getUser2PSDEFName());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserPSDEFIdDirty()) {
            hashMap.put(FIELD_USERPSDEFID, this.getUserPSDEFId());
        }
        if (!bl || this.isUserPSDEFNameDirty()) {
            hashMap.put(FIELD_USERPSDEFNAME, this.getUserPSDEFName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isValuePSDEFIdDirty()) {
            hashMap.put(FIELD_VALUEPSDEFID, this.getValuePSDEFId());
        }
        if (!bl || this.isValuePSDEFNameDirty()) {
            hashMap.put(FIELD_VALUEPSDEFNAME, this.getValuePSDEFName());
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
        return PSSysTranslatorBase.get(this, n);
    }

    private static Object get(PSSysTranslatorBase pSSysTranslatorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTranslatorBase.getCodeName();
            }
            case 1: {
                return pSSysTranslatorBase.getCreateDate();
            }
            case 2: {
                return pSSysTranslatorBase.getCreateMan();
            }
            case 3: {
                return pSSysTranslatorBase.getCustomCode();
            }
            case 4: {
                return pSSysTranslatorBase.getCustomMode();
            }
            case 5: {
                return pSSysTranslatorBase.getKeyPSDEFId();
            }
            case 6: {
                return pSSysTranslatorBase.getKeyPSDEFName();
            }
            case 7: {
                return pSSysTranslatorBase.getMemo();
            }
            case 8: {
                return pSSysTranslatorBase.getPSCodeListId();
            }
            case 9: {
                return pSSysTranslatorBase.getPSCodeListName();
            }
            case 10: {
                return pSSysTranslatorBase.getPSDEId();
            }
            case 11: {
                return pSSysTranslatorBase.getPSDEName();
            }
            case 12: {
                return pSSysTranslatorBase.getPSModuleId();
            }
            case 13: {
                return pSSysTranslatorBase.getPSModuleName();
            }
            case 14: {
                return pSSysTranslatorBase.getPSSysDynaModelId();
            }
            case 15: {
                return pSSysTranslatorBase.getPSSysDynaModelName();
            }
            case 16: {
                return pSSysTranslatorBase.getPSSysSFPluginId();
            }
            case 17: {
                return pSSysTranslatorBase.getPSSysSFPluginName();
            }
            case 18: {
                return pSSysTranslatorBase.getPSSystemId();
            }
            case 19: {
                return pSSysTranslatorBase.getPSSystemName();
            }
            case 20: {
                return pSSysTranslatorBase.getPSSysTranslatorId();
            }
            case 21: {
                return pSSysTranslatorBase.getPSSysTranslatorName();
            }
            case 22: {
                return pSSysTranslatorBase.getTranslatorParams();
            }
            case 23: {
                return pSSysTranslatorBase.getTranslatorTag();
            }
            case 24: {
                return pSSysTranslatorBase.getTranslatorTag2();
            }
            case 25: {
                return pSSysTranslatorBase.getTranslatorType();
            }
            case 26: {
                return pSSysTranslatorBase.getUpdateDate();
            }
            case 27: {
                return pSSysTranslatorBase.getUpdateMan();
            }
            case 28: {
                return pSSysTranslatorBase.getUser2PSDEFId();
            }
            case 29: {
                return pSSysTranslatorBase.getUser2PSDEFName();
            }
            case 30: {
                return pSSysTranslatorBase.getUserCat();
            }
            case 31: {
                return pSSysTranslatorBase.getUserPSDEFId();
            }
            case 32: {
                return pSSysTranslatorBase.getUserPSDEFName();
            }
            case 33: {
                return pSSysTranslatorBase.getUserTag();
            }
            case 34: {
                return pSSysTranslatorBase.getUserTag2();
            }
            case 35: {
                return pSSysTranslatorBase.getUserTag3();
            }
            case 36: {
                return pSSysTranslatorBase.getUserTag4();
            }
            case 37: {
                return pSSysTranslatorBase.getValidFlag();
            }
            case 38: {
                return pSSysTranslatorBase.getValuePSDEFId();
            }
            case 39: {
                return pSSysTranslatorBase.getValuePSDEFName();
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
        PSSysTranslatorBase.set(this, n, object);
    }

    private static void set(PSSysTranslatorBase pSSysTranslatorBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysTranslatorBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysTranslatorBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysTranslatorBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysTranslatorBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysTranslatorBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysTranslatorBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysTranslatorBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysTranslatorBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysTranslatorBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysTranslatorBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysTranslatorBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysTranslatorBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysTranslatorBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysTranslatorBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysTranslatorBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysTranslatorBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysTranslatorBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysTranslatorBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysTranslatorBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysTranslatorBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysTranslatorBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysTranslatorBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysTranslatorBase.setTranslatorParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysTranslatorBase.setTranslatorTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysTranslatorBase.setTranslatorTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysTranslatorBase.setTranslatorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysTranslatorBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysTranslatorBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysTranslatorBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysTranslatorBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysTranslatorBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysTranslatorBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysTranslatorBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysTranslatorBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysTranslatorBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysTranslatorBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysTranslatorBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysTranslatorBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysTranslatorBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysTranslatorBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
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
        return PSSysTranslatorBase.isNull(this, n);
    }

    private static boolean isNull(PSSysTranslatorBase pSSysTranslatorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTranslatorBase.getCodeName() == null;
            }
            case 1: {
                return pSSysTranslatorBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysTranslatorBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysTranslatorBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysTranslatorBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysTranslatorBase.getKeyPSDEFId() == null;
            }
            case 6: {
                return pSSysTranslatorBase.getKeyPSDEFName() == null;
            }
            case 7: {
                return pSSysTranslatorBase.getMemo() == null;
            }
            case 8: {
                return pSSysTranslatorBase.getPSCodeListId() == null;
            }
            case 9: {
                return pSSysTranslatorBase.getPSCodeListName() == null;
            }
            case 10: {
                return pSSysTranslatorBase.getPSDEId() == null;
            }
            case 11: {
                return pSSysTranslatorBase.getPSDEName() == null;
            }
            case 12: {
                return pSSysTranslatorBase.getPSModuleId() == null;
            }
            case 13: {
                return pSSysTranslatorBase.getPSModuleName() == null;
            }
            case 14: {
                return pSSysTranslatorBase.getPSSysDynaModelId() == null;
            }
            case 15: {
                return pSSysTranslatorBase.getPSSysDynaModelName() == null;
            }
            case 16: {
                return pSSysTranslatorBase.getPSSysSFPluginId() == null;
            }
            case 17: {
                return pSSysTranslatorBase.getPSSysSFPluginName() == null;
            }
            case 18: {
                return pSSysTranslatorBase.getPSSystemId() == null;
            }
            case 19: {
                return pSSysTranslatorBase.getPSSystemName() == null;
            }
            case 20: {
                return pSSysTranslatorBase.getPSSysTranslatorId() == null;
            }
            case 21: {
                return pSSysTranslatorBase.getPSSysTranslatorName() == null;
            }
            case 22: {
                return pSSysTranslatorBase.getTranslatorParams() == null;
            }
            case 23: {
                return pSSysTranslatorBase.getTranslatorTag() == null;
            }
            case 24: {
                return pSSysTranslatorBase.getTranslatorTag2() == null;
            }
            case 25: {
                return pSSysTranslatorBase.getTranslatorType() == null;
            }
            case 26: {
                return pSSysTranslatorBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysTranslatorBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysTranslatorBase.getUser2PSDEFId() == null;
            }
            case 29: {
                return pSSysTranslatorBase.getUser2PSDEFName() == null;
            }
            case 30: {
                return pSSysTranslatorBase.getUserCat() == null;
            }
            case 31: {
                return pSSysTranslatorBase.getUserPSDEFId() == null;
            }
            case 32: {
                return pSSysTranslatorBase.getUserPSDEFName() == null;
            }
            case 33: {
                return pSSysTranslatorBase.getUserTag() == null;
            }
            case 34: {
                return pSSysTranslatorBase.getUserTag2() == null;
            }
            case 35: {
                return pSSysTranslatorBase.getUserTag3() == null;
            }
            case 36: {
                return pSSysTranslatorBase.getUserTag4() == null;
            }
            case 37: {
                return pSSysTranslatorBase.getValidFlag() == null;
            }
            case 38: {
                return pSSysTranslatorBase.getValuePSDEFId() == null;
            }
            case 39: {
                return pSSysTranslatorBase.getValuePSDEFName() == null;
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
        return PSSysTranslatorBase.contains(this, n);
    }

    private static boolean contains(PSSysTranslatorBase pSSysTranslatorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysTranslatorBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysTranslatorBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysTranslatorBase.isCreateManDirty();
            }
            case 3: {
                return pSSysTranslatorBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysTranslatorBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysTranslatorBase.isKeyPSDEFIdDirty();
            }
            case 6: {
                return pSSysTranslatorBase.isKeyPSDEFNameDirty();
            }
            case 7: {
                return pSSysTranslatorBase.isMemoDirty();
            }
            case 8: {
                return pSSysTranslatorBase.isPSCodeListIdDirty();
            }
            case 9: {
                return pSSysTranslatorBase.isPSCodeListNameDirty();
            }
            case 10: {
                return pSSysTranslatorBase.isPSDEIdDirty();
            }
            case 11: {
                return pSSysTranslatorBase.isPSDENameDirty();
            }
            case 12: {
                return pSSysTranslatorBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSSysTranslatorBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSSysTranslatorBase.isPSSysDynaModelIdDirty();
            }
            case 15: {
                return pSSysTranslatorBase.isPSSysDynaModelNameDirty();
            }
            case 16: {
                return pSSysTranslatorBase.isPSSysSFPluginIdDirty();
            }
            case 17: {
                return pSSysTranslatorBase.isPSSysSFPluginNameDirty();
            }
            case 18: {
                return pSSysTranslatorBase.isPSSystemIdDirty();
            }
            case 19: {
                return pSSysTranslatorBase.isPSSystemNameDirty();
            }
            case 20: {
                return pSSysTranslatorBase.isPSSysTranslatorIdDirty();
            }
            case 21: {
                return pSSysTranslatorBase.isPSSysTranslatorNameDirty();
            }
            case 22: {
                return pSSysTranslatorBase.isTranslatorParamsDirty();
            }
            case 23: {
                return pSSysTranslatorBase.isTranslatorTagDirty();
            }
            case 24: {
                return pSSysTranslatorBase.isTranslatorTag2Dirty();
            }
            case 25: {
                return pSSysTranslatorBase.isTranslatorTypeDirty();
            }
            case 26: {
                return pSSysTranslatorBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysTranslatorBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysTranslatorBase.isUser2PSDEFIdDirty();
            }
            case 29: {
                return pSSysTranslatorBase.isUser2PSDEFNameDirty();
            }
            case 30: {
                return pSSysTranslatorBase.isUserCatDirty();
            }
            case 31: {
                return pSSysTranslatorBase.isUserPSDEFIdDirty();
            }
            case 32: {
                return pSSysTranslatorBase.isUserPSDEFNameDirty();
            }
            case 33: {
                return pSSysTranslatorBase.isUserTagDirty();
            }
            case 34: {
                return pSSysTranslatorBase.isUserTag2Dirty();
            }
            case 35: {
                return pSSysTranslatorBase.isUserTag3Dirty();
            }
            case 36: {
                return pSSysTranslatorBase.isUserTag4Dirty();
            }
            case 37: {
                return pSSysTranslatorBase.isValidFlagDirty();
            }
            case 38: {
                return pSSysTranslatorBase.isValuePSDEFIdDirty();
            }
            case 39: {
                return pSSysTranslatorBase.isValuePSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysTranslatorBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysTranslatorBase pSSysTranslatorBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysTranslatorBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getTranslatorParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"translatorparams", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getTranslatorParams()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getTranslatorTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"translatortag", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getTranslatorTag()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getTranslatorTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"translatortag2", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getTranslatorTag2()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getTranslatorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"translatortype", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getTranslatorType()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSSysTranslatorBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSSysTranslatorBase.getJSONValue((Object)pSSysTranslatorBase.getValuePSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysTranslatorBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysTranslatorBase pSSysTranslatorBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysTranslatorBase.getCodeName() != null) {
            object = pSSysTranslatorBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getCreateDate() != null) {
            object = pSSysTranslatorBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTranslatorBase.getCreateMan() != null) {
            object = pSSysTranslatorBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getCustomCode() != null) {
            object = pSSysTranslatorBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getCustomMode() != null) {
            object = pSSysTranslatorBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTranslatorBase.getKeyPSDEFId() != null) {
            object = pSSysTranslatorBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getKeyPSDEFName() != null) {
            object = pSSysTranslatorBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getMemo() != null) {
            object = pSSysTranslatorBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSCodeListId() != null) {
            object = pSSysTranslatorBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSCodeListName() != null) {
            object = pSSysTranslatorBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSDEId() != null) {
            object = pSSysTranslatorBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSDEName() != null) {
            object = pSSysTranslatorBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSModuleId() != null) {
            object = pSSysTranslatorBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSModuleName() != null) {
            object = pSSysTranslatorBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysDynaModelId() != null) {
            object = pSSysTranslatorBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysDynaModelName() != null) {
            object = pSSysTranslatorBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysSFPluginId() != null) {
            object = pSSysTranslatorBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysSFPluginName() != null) {
            object = pSSysTranslatorBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSystemId() != null) {
            object = pSSysTranslatorBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSystemName() != null) {
            object = pSSysTranslatorBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysTranslatorId() != null) {
            object = pSSysTranslatorBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getPSSysTranslatorName() != null) {
            object = pSSysTranslatorBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getTranslatorParams() != null) {
            object = pSSysTranslatorBase.getTranslatorParams();
            xmlNode.setAttribute(FIELD_TRANSLATORPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getTranslatorTag() != null) {
            object = pSSysTranslatorBase.getTranslatorTag();
            xmlNode.setAttribute(FIELD_TRANSLATORTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getTranslatorTag2() != null) {
            object = pSSysTranslatorBase.getTranslatorTag2();
            xmlNode.setAttribute(FIELD_TRANSLATORTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getTranslatorType() != null) {
            object = pSSysTranslatorBase.getTranslatorType();
            xmlNode.setAttribute(FIELD_TRANSLATORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUpdateDate() != null) {
            object = pSSysTranslatorBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysTranslatorBase.getUpdateMan() != null) {
            object = pSSysTranslatorBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUser2PSDEFId() != null) {
            object = pSSysTranslatorBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUser2PSDEFName() != null) {
            object = pSSysTranslatorBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserCat() != null) {
            object = pSSysTranslatorBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserPSDEFId() != null) {
            object = pSSysTranslatorBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserPSDEFName() != null) {
            object = pSSysTranslatorBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserTag() != null) {
            object = pSSysTranslatorBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserTag2() != null) {
            object = pSSysTranslatorBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserTag3() != null) {
            object = pSSysTranslatorBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getUserTag4() != null) {
            object = pSSysTranslatorBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getValidFlag() != null) {
            object = pSSysTranslatorBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysTranslatorBase.getValuePSDEFId() != null) {
            object = pSSysTranslatorBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysTranslatorBase.getValuePSDEFName() != null) {
            object = pSSysTranslatorBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysTranslatorBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysTranslatorBase pSSysTranslatorBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysTranslatorBase.isCodeNameDirty() && (bl || pSSysTranslatorBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysTranslatorBase.getCodeName());
        }
        if (pSSysTranslatorBase.isCreateDateDirty() && (bl || pSSysTranslatorBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysTranslatorBase.getCreateDate());
        }
        if (pSSysTranslatorBase.isCreateManDirty() && (bl || pSSysTranslatorBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysTranslatorBase.getCreateMan());
        }
        if (pSSysTranslatorBase.isCustomCodeDirty() && (bl || pSSysTranslatorBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysTranslatorBase.getCustomCode());
        }
        if (pSSysTranslatorBase.isCustomModeDirty() && (bl || pSSysTranslatorBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysTranslatorBase.getCustomMode());
        }
        if (pSSysTranslatorBase.isKeyPSDEFIdDirty() && (bl || pSSysTranslatorBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysTranslatorBase.getKeyPSDEFId());
        }
        if (pSSysTranslatorBase.isKeyPSDEFNameDirty() && (bl || pSSysTranslatorBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysTranslatorBase.getKeyPSDEFName());
        }
        if (pSSysTranslatorBase.isMemoDirty() && (bl || pSSysTranslatorBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysTranslatorBase.getMemo());
        }
        if (pSSysTranslatorBase.isPSCodeListIdDirty() && (bl || pSSysTranslatorBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysTranslatorBase.getPSCodeListId());
        }
        if (pSSysTranslatorBase.isPSCodeListNameDirty() && (bl || pSSysTranslatorBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysTranslatorBase.getPSCodeListName());
        }
        if (pSSysTranslatorBase.isPSDEIdDirty() && (bl || pSSysTranslatorBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysTranslatorBase.getPSDEId());
        }
        if (pSSysTranslatorBase.isPSDENameDirty() && (bl || pSSysTranslatorBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysTranslatorBase.getPSDEName());
        }
        if (pSSysTranslatorBase.isPSModuleIdDirty() && (bl || pSSysTranslatorBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysTranslatorBase.getPSModuleId());
        }
        if (pSSysTranslatorBase.isPSModuleNameDirty() && (bl || pSSysTranslatorBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysTranslatorBase.getPSModuleName());
        }
        if (pSSysTranslatorBase.isPSSysDynaModelIdDirty() && (bl || pSSysTranslatorBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysTranslatorBase.getPSSysDynaModelId());
        }
        if (pSSysTranslatorBase.isPSSysDynaModelNameDirty() && (bl || pSSysTranslatorBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysTranslatorBase.getPSSysDynaModelName());
        }
        if (pSSysTranslatorBase.isPSSysSFPluginIdDirty() && (bl || pSSysTranslatorBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysTranslatorBase.getPSSysSFPluginId());
        }
        if (pSSysTranslatorBase.isPSSysSFPluginNameDirty() && (bl || pSSysTranslatorBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysTranslatorBase.getPSSysSFPluginName());
        }
        if (pSSysTranslatorBase.isPSSystemIdDirty() && (bl || pSSysTranslatorBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysTranslatorBase.getPSSystemId());
        }
        if (pSSysTranslatorBase.isPSSystemNameDirty() && (bl || pSSysTranslatorBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysTranslatorBase.getPSSystemName());
        }
        if (pSSysTranslatorBase.isPSSysTranslatorIdDirty() && (bl || pSSysTranslatorBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        }
        if (pSSysTranslatorBase.isPSSysTranslatorNameDirty() && (bl || pSSysTranslatorBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSSysTranslatorBase.getPSSysTranslatorName());
        }
        if (pSSysTranslatorBase.isTranslatorParamsDirty() && (bl || pSSysTranslatorBase.getTranslatorParams() != null)) {
            iDataObject.set(FIELD_TRANSLATORPARAMS, (Object)pSSysTranslatorBase.getTranslatorParams());
        }
        if (pSSysTranslatorBase.isTranslatorTagDirty() && (bl || pSSysTranslatorBase.getTranslatorTag() != null)) {
            iDataObject.set(FIELD_TRANSLATORTAG, (Object)pSSysTranslatorBase.getTranslatorTag());
        }
        if (pSSysTranslatorBase.isTranslatorTag2Dirty() && (bl || pSSysTranslatorBase.getTranslatorTag2() != null)) {
            iDataObject.set(FIELD_TRANSLATORTAG2, (Object)pSSysTranslatorBase.getTranslatorTag2());
        }
        if (pSSysTranslatorBase.isTranslatorTypeDirty() && (bl || pSSysTranslatorBase.getTranslatorType() != null)) {
            iDataObject.set(FIELD_TRANSLATORTYPE, (Object)pSSysTranslatorBase.getTranslatorType());
        }
        if (pSSysTranslatorBase.isUpdateDateDirty() && (bl || pSSysTranslatorBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysTranslatorBase.getUpdateDate());
        }
        if (pSSysTranslatorBase.isUpdateManDirty() && (bl || pSSysTranslatorBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysTranslatorBase.getUpdateMan());
        }
        if (pSSysTranslatorBase.isUser2PSDEFIdDirty() && (bl || pSSysTranslatorBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysTranslatorBase.getUser2PSDEFId());
        }
        if (pSSysTranslatorBase.isUser2PSDEFNameDirty() && (bl || pSSysTranslatorBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysTranslatorBase.getUser2PSDEFName());
        }
        if (pSSysTranslatorBase.isUserCatDirty() && (bl || pSSysTranslatorBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysTranslatorBase.getUserCat());
        }
        if (pSSysTranslatorBase.isUserPSDEFIdDirty() && (bl || pSSysTranslatorBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysTranslatorBase.getUserPSDEFId());
        }
        if (pSSysTranslatorBase.isUserPSDEFNameDirty() && (bl || pSSysTranslatorBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysTranslatorBase.getUserPSDEFName());
        }
        if (pSSysTranslatorBase.isUserTagDirty() && (bl || pSSysTranslatorBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysTranslatorBase.getUserTag());
        }
        if (pSSysTranslatorBase.isUserTag2Dirty() && (bl || pSSysTranslatorBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysTranslatorBase.getUserTag2());
        }
        if (pSSysTranslatorBase.isUserTag3Dirty() && (bl || pSSysTranslatorBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysTranslatorBase.getUserTag3());
        }
        if (pSSysTranslatorBase.isUserTag4Dirty() && (bl || pSSysTranslatorBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysTranslatorBase.getUserTag4());
        }
        if (pSSysTranslatorBase.isValidFlagDirty() && (bl || pSSysTranslatorBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysTranslatorBase.getValidFlag());
        }
        if (pSSysTranslatorBase.isValuePSDEFIdDirty() && (bl || pSSysTranslatorBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSSysTranslatorBase.getValuePSDEFId());
        }
        if (pSSysTranslatorBase.isValuePSDEFNameDirty() && (bl || pSSysTranslatorBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSSysTranslatorBase.getValuePSDEFName());
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
        return PSSysTranslatorBase.remove(this, n);
    }

    private static boolean remove(PSSysTranslatorBase pSSysTranslatorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysTranslatorBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysTranslatorBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysTranslatorBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysTranslatorBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysTranslatorBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysTranslatorBase.resetKeyPSDEFId();
                return true;
            }
            case 6: {
                pSSysTranslatorBase.resetKeyPSDEFName();
                return true;
            }
            case 7: {
                pSSysTranslatorBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysTranslatorBase.resetPSCodeListId();
                return true;
            }
            case 9: {
                pSSysTranslatorBase.resetPSCodeListName();
                return true;
            }
            case 10: {
                pSSysTranslatorBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSSysTranslatorBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSSysTranslatorBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSSysTranslatorBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSSysTranslatorBase.resetPSSysDynaModelId();
                return true;
            }
            case 15: {
                pSSysTranslatorBase.resetPSSysDynaModelName();
                return true;
            }
            case 16: {
                pSSysTranslatorBase.resetPSSysSFPluginId();
                return true;
            }
            case 17: {
                pSSysTranslatorBase.resetPSSysSFPluginName();
                return true;
            }
            case 18: {
                pSSysTranslatorBase.resetPSSystemId();
                return true;
            }
            case 19: {
                pSSysTranslatorBase.resetPSSystemName();
                return true;
            }
            case 20: {
                pSSysTranslatorBase.resetPSSysTranslatorId();
                return true;
            }
            case 21: {
                pSSysTranslatorBase.resetPSSysTranslatorName();
                return true;
            }
            case 22: {
                pSSysTranslatorBase.resetTranslatorParams();
                return true;
            }
            case 23: {
                pSSysTranslatorBase.resetTranslatorTag();
                return true;
            }
            case 24: {
                pSSysTranslatorBase.resetTranslatorTag2();
                return true;
            }
            case 25: {
                pSSysTranslatorBase.resetTranslatorType();
                return true;
            }
            case 26: {
                pSSysTranslatorBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysTranslatorBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysTranslatorBase.resetUser2PSDEFId();
                return true;
            }
            case 29: {
                pSSysTranslatorBase.resetUser2PSDEFName();
                return true;
            }
            case 30: {
                pSSysTranslatorBase.resetUserCat();
                return true;
            }
            case 31: {
                pSSysTranslatorBase.resetUserPSDEFId();
                return true;
            }
            case 32: {
                pSSysTranslatorBase.resetUserPSDEFName();
                return true;
            }
            case 33: {
                pSSysTranslatorBase.resetUserTag();
                return true;
            }
            case 34: {
                pSSysTranslatorBase.resetUserTag2();
                return true;
            }
            case 35: {
                pSSysTranslatorBase.resetUserTag3();
                return true;
            }
            case 36: {
                pSSysTranslatorBase.resetUserTag4();
                return true;
            }
            case 37: {
                pSSysTranslatorBase.resetValidFlag();
                return true;
            }
            case 38: {
                pSSysTranslatorBase.resetValuePSDEFId();
                return true;
            }
            case 39: {
                pSSysTranslatorBase.resetValuePSDEFName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
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
    public PSDEField getKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEF();
        }
        if (this.getKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objKeyPSDEFLock;
        synchronized (n) {
            if (this.keypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getKeyPSDEFId(), (Object)this.keypsdef.getPSDEFieldId()) != 0L) {
                this.keypsdef = null;
            }
            if (this.keypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.keypsdef = pSDEField;
            }
            return this.keypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUser2PSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUser2PSDEF();
        }
        if (this.getUser2PSDEFId() == null) {
            return null;
        }
        Integer n = this.objUser2PSDEFLock;
        synchronized (n) {
            if (this.user2psdef != null && DataTypeHelper.compare((int)25, (Object)this.getUser2PSDEFId(), (Object)this.user2psdef.getPSDEFieldId()) != 0L) {
                this.user2psdef = null;
            }
            if (this.user2psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUser2PSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.user2psdef = pSDEField;
            }
            return this.user2psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getUserPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserPSDEF();
        }
        if (this.getUserPSDEFId() == null) {
            return null;
        }
        Integer n = this.objUserPSDEFLock;
        synchronized (n) {
            if (this.userpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getUserPSDEFId(), (Object)this.userpsdef.getPSDEFieldId()) != 0L) {
                this.userpsdef = null;
            }
            if (this.userpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getUserPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.userpsdef = pSDEField;
            }
            return this.userpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEF();
        }
        if (this.getValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objValuePSDEFLock;
        synchronized (n) {
            if (this.valuepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getValuePSDEFId(), (Object)this.valuepsdef.getPSDEFieldId()) != 0L) {
                this.valuepsdef = null;
            }
            if (this.valuepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.valuepsdef = pSDEField;
            }
            return this.valuepsdef;
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

    private PSSysTranslatorBase getProxyEntity() {
        return this.proxyPSSysTranslatorBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysTranslatorBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysTranslatorBase) {
            this.proxyPSSysTranslatorBase = (PSSysTranslatorBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 5);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSCODELISTID, 8);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_PSMODULEID, 12);
        fieldIndexMap.put(FIELD_PSMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 14);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 16);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 20);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 21);
        fieldIndexMap.put(FIELD_TRANSLATORPARAMS, 22);
        fieldIndexMap.put(FIELD_TRANSLATORTAG, 23);
        fieldIndexMap.put(FIELD_TRANSLATORTAG2, 24);
        fieldIndexMap.put(FIELD_TRANSLATORTYPE, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 28);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERPSDEFID, 31);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_USERTAG, 33);
        fieldIndexMap.put(FIELD_USERTAG2, 34);
        fieldIndexMap.put(FIELD_USERTAG3, 35);
        fieldIndexMap.put(FIELD_USERTAG4, 36);
        fieldIndexMap.put(FIELD_VALIDFLAG, 37);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 38);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 39);
    }
}

