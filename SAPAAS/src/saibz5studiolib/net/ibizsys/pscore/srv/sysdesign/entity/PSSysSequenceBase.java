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

public abstract class PSSysSequenceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSequenceBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_EXTFORMATPARAMS = "EXTFORMATPARAMS";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String FIELD_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_SEQUENCEFORMAT = "SEQUENCEFORMAT";
    public static final String FIELD_SEQUENCEPARAMS = "SEQUENCEPARAMS";
    public static final String FIELD_SEQUENCETAG = "SEQUENCETAG";
    public static final String FIELD_SEQUENCETAG2 = "SEQUENCETAG2";
    public static final String FIELD_SEQUENCETYPE = "SEQUENCETYPE";
    public static final String FIELD_TIMEFORMAT = "TIMEFORMAT";
    public static final String FIELD_TIMEPSDEFID = "TIMEPSDEFID";
    public static final String FIELD_TIMEPSDEFNAME = "TIMEPSDEFNAME";
    public static final String FIELD_TYPEPSDEFID = "TYPEPSDEFID";
    public static final String FIELD_TYPEPSDEFNAME = "TYPEPSDEFNAME";
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
    private static final int INDEX_EXTFORMATPARAMS = 5;
    private static final int INDEX_KEYPSDEFID = 6;
    private static final int INDEX_KEYPSDEFNAME = 7;
    private static final int INDEX_MAXVALUE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_MINVALUE = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDENAME = 12;
    private static final int INDEX_PSMODULEID = 13;
    private static final int INDEX_PSMODULENAME = 14;
    private static final int INDEX_PSSYSDYNAMODELID = 15;
    private static final int INDEX_PSSYSDYNAMODELNAME = 16;
    private static final int INDEX_PSSYSSEQUENCEID = 17;
    private static final int INDEX_PSSYSSEQUENCENAME = 18;
    private static final int INDEX_PSSYSSFPLUGINID = 19;
    private static final int INDEX_PSSYSSFPLUGINNAME = 20;
    private static final int INDEX_PSSYSTEMID = 21;
    private static final int INDEX_PSSYSTEMNAME = 22;
    private static final int INDEX_SEQUENCEFORMAT = 23;
    private static final int INDEX_SEQUENCEPARAMS = 24;
    private static final int INDEX_SEQUENCETAG = 25;
    private static final int INDEX_SEQUENCETAG2 = 26;
    private static final int INDEX_SEQUENCETYPE = 27;
    private static final int INDEX_TIMEFORMAT = 28;
    private static final int INDEX_TIMEPSDEFID = 29;
    private static final int INDEX_TIMEPSDEFNAME = 30;
    private static final int INDEX_TYPEPSDEFID = 31;
    private static final int INDEX_TYPEPSDEFNAME = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USER2PSDEFID = 35;
    private static final int INDEX_USER2PSDEFNAME = 36;
    private static final int INDEX_USERCAT = 37;
    private static final int INDEX_USERPSDEFID = 38;
    private static final int INDEX_USERPSDEFNAME = 39;
    private static final int INDEX_USERTAG = 40;
    private static final int INDEX_USERTAG2 = 41;
    private static final int INDEX_USERTAG3 = 42;
    private static final int INDEX_USERTAG4 = 43;
    private static final int INDEX_VALIDFLAG = 44;
    private static final int INDEX_VALUEPSDEFID = 45;
    private static final int INDEX_VALUEPSDEFNAME = 46;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSequenceBase proxyPSSysSequenceBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean extformatparamsDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssequenceidDirtyFlag = false;
    private boolean pssyssequencenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean sequenceformatDirtyFlag = false;
    private boolean sequenceparamsDirtyFlag = false;
    private boolean sequencetagDirtyFlag = false;
    private boolean sequencetag2DirtyFlag = false;
    private boolean sequencetypeDirtyFlag = false;
    private boolean timeformatDirtyFlag = false;
    private boolean timepsdefidDirtyFlag = false;
    private boolean timepsdefnameDirtyFlag = false;
    private boolean typepsdefidDirtyFlag = false;
    private boolean typepsdefnameDirtyFlag = false;
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
    @Column(name="extformatparams")
    private String extformatparams;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="maxvalue")
    private Integer maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minvalue")
    private Integer minvalue;
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
    @Column(name="pssyssequenceid")
    private String pssyssequenceid;
    @Column(name="pssyssequencename")
    private String pssyssequencename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="sequenceformat")
    private String sequenceformat;
    @Column(name="sequenceparams")
    private String sequenceparams;
    @Column(name="sequencetag")
    private String sequencetag;
    @Column(name="sequencetag2")
    private String sequencetag2;
    @Column(name="sequencetype")
    private String sequencetype;
    @Column(name="timeformat")
    private String timeformat;
    @Column(name="timepsdefid")
    private String timepsdefid;
    @Column(name="timepsdefname")
    private String timepsdefname;
    @Column(name="typepsdefid")
    private String typepsdefid;
    @Column(name="typepsdefname")
    private String typepsdefname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objTimePSDEFLock = new Integer(1);
    private PSDEField timepsdef = null;
    private Integer objTypePSDEFLock = new Integer(1);
    private PSDEField typepsdef = null;
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

    public void setExtFormatParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExtFormatParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.extformatparams = string;
        this.extformatparamsDirtyFlag = true;
    }

    public String getExtFormatParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExtFormatParams();
        }
        return this.extformatparams;
    }

    public boolean isExtFormatParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExtFormatParamsDirty();
        }
        return this.extformatparamsDirtyFlag;
    }

    public void resetExtFormatParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExtFormatParams();
            return;
        }
        this.extformatparamsDirtyFlag = false;
        this.extformatparams = null;
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

    public void setMaxValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(n);
            return;
        }
        this.maxvalue = n;
        this.maxvalueDirtyFlag = true;
    }

    public Integer getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
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

    public void setMinValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(n);
            return;
        }
        this.minvalue = n;
        this.minvalueDirtyFlag = true;
    }

    public Integer getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
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

    public void setPSSysSequenceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequenceid = string;
        this.pssyssequenceidDirtyFlag = true;
    }

    public String getPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceId();
        }
        return this.pssyssequenceid;
    }

    public boolean isPSSysSequenceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceIdDirty();
        }
        return this.pssyssequenceidDirtyFlag;
    }

    public void resetPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceId();
            return;
        }
        this.pssyssequenceidDirtyFlag = false;
        this.pssyssequenceid = null;
    }

    public void setPSSysSequenceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequencename = string;
        this.pssyssequencenameDirtyFlag = true;
    }

    public String getPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceName();
        }
        return this.pssyssequencename;
    }

    public boolean isPSSysSequenceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceNameDirty();
        }
        return this.pssyssequencenameDirtyFlag;
    }

    public void resetPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceName();
            return;
        }
        this.pssyssequencenameDirtyFlag = false;
        this.pssyssequencename = null;
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

    public void setSequenceFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequenceformat = string;
        this.sequenceformatDirtyFlag = true;
    }

    public String getSequenceFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceFormat();
        }
        return this.sequenceformat;
    }

    public boolean isSequenceFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceFormatDirty();
        }
        return this.sequenceformatDirtyFlag;
    }

    public void resetSequenceFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceFormat();
            return;
        }
        this.sequenceformatDirtyFlag = false;
        this.sequenceformat = null;
    }

    public void setSequenceParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequenceparams = string;
        this.sequenceparamsDirtyFlag = true;
    }

    public String getSequenceParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceParams();
        }
        return this.sequenceparams;
    }

    public boolean isSequenceParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceParamsDirty();
        }
        return this.sequenceparamsDirtyFlag;
    }

    public void resetSequenceParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceParams();
            return;
        }
        this.sequenceparamsDirtyFlag = false;
        this.sequenceparams = null;
    }

    public void setSequenceTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequencetag = string;
        this.sequencetagDirtyFlag = true;
    }

    public String getSequenceTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceTag();
        }
        return this.sequencetag;
    }

    public boolean isSequenceTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceTagDirty();
        }
        return this.sequencetagDirtyFlag;
    }

    public void resetSequenceTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceTag();
            return;
        }
        this.sequencetagDirtyFlag = false;
        this.sequencetag = null;
    }

    public void setSequenceTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequencetag2 = string;
        this.sequencetag2DirtyFlag = true;
    }

    public String getSequenceTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceTag2();
        }
        return this.sequencetag2;
    }

    public boolean isSequenceTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceTag2Dirty();
        }
        return this.sequencetag2DirtyFlag;
    }

    public void resetSequenceTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceTag2();
            return;
        }
        this.sequencetag2DirtyFlag = false;
        this.sequencetag2 = null;
    }

    public void setSequenceType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSequenceType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sequencetype = string;
        this.sequencetypeDirtyFlag = true;
    }

    public String getSequenceType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSequenceType();
        }
        return this.sequencetype;
    }

    public boolean isSequenceTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSequenceTypeDirty();
        }
        return this.sequencetypeDirtyFlag;
    }

    public void resetSequenceType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSequenceType();
            return;
        }
        this.sequencetypeDirtyFlag = false;
        this.sequencetype = null;
    }

    public void setTimeFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimeFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timeformat = string;
        this.timeformatDirtyFlag = true;
    }

    public String getTimeFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimeFormat();
        }
        return this.timeformat;
    }

    public boolean isTimeFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimeFormatDirty();
        }
        return this.timeformatDirtyFlag;
    }

    public void resetTimeFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimeFormat();
            return;
        }
        this.timeformatDirtyFlag = false;
        this.timeformat = null;
    }

    public void setTimePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefid = string;
        this.timepsdefidDirtyFlag = true;
    }

    public String getTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFId();
        }
        return this.timepsdefid;
    }

    public boolean isTimePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFIdDirty();
        }
        return this.timepsdefidDirtyFlag;
    }

    public void resetTimePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFId();
            return;
        }
        this.timepsdefidDirtyFlag = false;
        this.timepsdefid = null;
    }

    public void setTimePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.timepsdefname = string;
        this.timepsdefnameDirtyFlag = true;
    }

    public String getTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEFName();
        }
        return this.timepsdefname;
    }

    public boolean isTimePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimePSDEFNameDirty();
        }
        return this.timepsdefnameDirtyFlag;
    }

    public void resetTimePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimePSDEFName();
            return;
        }
        this.timepsdefnameDirtyFlag = false;
        this.timepsdefname = null;
    }

    public void setTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefid = string;
        this.typepsdefidDirtyFlag = true;
    }

    public String getTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFId();
        }
        return this.typepsdefid;
    }

    public boolean isTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFIdDirty();
        }
        return this.typepsdefidDirtyFlag;
    }

    public void resetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFId();
            return;
        }
        this.typepsdefidDirtyFlag = false;
        this.typepsdefid = null;
    }

    public void setTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefname = string;
        this.typepsdefnameDirtyFlag = true;
    }

    public String getTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFName();
        }
        return this.typepsdefname;
    }

    public boolean isTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFNameDirty();
        }
        return this.typepsdefnameDirtyFlag;
    }

    public void resetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFName();
            return;
        }
        this.typepsdefnameDirtyFlag = false;
        this.typepsdefname = null;
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
        PSSysSequenceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSequenceBase pSSysSequenceBase) {
        pSSysSequenceBase.resetCodeName();
        pSSysSequenceBase.resetCreateDate();
        pSSysSequenceBase.resetCreateMan();
        pSSysSequenceBase.resetCustomCode();
        pSSysSequenceBase.resetCustomMode();
        pSSysSequenceBase.resetExtFormatParams();
        pSSysSequenceBase.resetKeyPSDEFId();
        pSSysSequenceBase.resetKeyPSDEFName();
        pSSysSequenceBase.resetMaxValue();
        pSSysSequenceBase.resetMemo();
        pSSysSequenceBase.resetMinValue();
        pSSysSequenceBase.resetPSDEId();
        pSSysSequenceBase.resetPSDEName();
        pSSysSequenceBase.resetPSModuleId();
        pSSysSequenceBase.resetPSModuleName();
        pSSysSequenceBase.resetPSSysDynaModelId();
        pSSysSequenceBase.resetPSSysDynaModelName();
        pSSysSequenceBase.resetPSSysSequenceId();
        pSSysSequenceBase.resetPSSysSequenceName();
        pSSysSequenceBase.resetPSSysSFPluginId();
        pSSysSequenceBase.resetPSSysSFPluginName();
        pSSysSequenceBase.resetPSSystemId();
        pSSysSequenceBase.resetPSSystemName();
        pSSysSequenceBase.resetSequenceFormat();
        pSSysSequenceBase.resetSequenceParams();
        pSSysSequenceBase.resetSequenceTag();
        pSSysSequenceBase.resetSequenceTag2();
        pSSysSequenceBase.resetSequenceType();
        pSSysSequenceBase.resetTimeFormat();
        pSSysSequenceBase.resetTimePSDEFId();
        pSSysSequenceBase.resetTimePSDEFName();
        pSSysSequenceBase.resetTypePSDEFId();
        pSSysSequenceBase.resetTypePSDEFName();
        pSSysSequenceBase.resetUpdateDate();
        pSSysSequenceBase.resetUpdateMan();
        pSSysSequenceBase.resetUser2PSDEFId();
        pSSysSequenceBase.resetUser2PSDEFName();
        pSSysSequenceBase.resetUserCat();
        pSSysSequenceBase.resetUserPSDEFId();
        pSSysSequenceBase.resetUserPSDEFName();
        pSSysSequenceBase.resetUserTag();
        pSSysSequenceBase.resetUserTag2();
        pSSysSequenceBase.resetUserTag3();
        pSSysSequenceBase.resetUserTag4();
        pSSysSequenceBase.resetValidFlag();
        pSSysSequenceBase.resetValuePSDEFId();
        pSSysSequenceBase.resetValuePSDEFName();
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
        if (!bl || this.isExtFormatParamsDirty()) {
            hashMap.put(FIELD_EXTFORMATPARAMS, this.getExtFormatParams());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
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
        if (!bl || this.isPSSysSequenceIdDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCEID, this.getPSSysSequenceId());
        }
        if (!bl || this.isPSSysSequenceNameDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCENAME, this.getPSSysSequenceName());
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
        if (!bl || this.isSequenceFormatDirty()) {
            hashMap.put(FIELD_SEQUENCEFORMAT, this.getSequenceFormat());
        }
        if (!bl || this.isSequenceParamsDirty()) {
            hashMap.put(FIELD_SEQUENCEPARAMS, this.getSequenceParams());
        }
        if (!bl || this.isSequenceTagDirty()) {
            hashMap.put(FIELD_SEQUENCETAG, this.getSequenceTag());
        }
        if (!bl || this.isSequenceTag2Dirty()) {
            hashMap.put(FIELD_SEQUENCETAG2, this.getSequenceTag2());
        }
        if (!bl || this.isSequenceTypeDirty()) {
            hashMap.put(FIELD_SEQUENCETYPE, this.getSequenceType());
        }
        if (!bl || this.isTimeFormatDirty()) {
            hashMap.put(FIELD_TIMEFORMAT, this.getTimeFormat());
        }
        if (!bl || this.isTimePSDEFIdDirty()) {
            hashMap.put(FIELD_TIMEPSDEFID, this.getTimePSDEFId());
        }
        if (!bl || this.isTimePSDEFNameDirty()) {
            hashMap.put(FIELD_TIMEPSDEFNAME, this.getTimePSDEFName());
        }
        if (!bl || this.isTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TYPEPSDEFID, this.getTypePSDEFId());
        }
        if (!bl || this.isTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TYPEPSDEFNAME, this.getTypePSDEFName());
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
        return PSSysSequenceBase.get(this, n);
    }

    private static Object get(PSSysSequenceBase pSSysSequenceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSequenceBase.getCodeName();
            }
            case 1: {
                return pSSysSequenceBase.getCreateDate();
            }
            case 2: {
                return pSSysSequenceBase.getCreateMan();
            }
            case 3: {
                return pSSysSequenceBase.getCustomCode();
            }
            case 4: {
                return pSSysSequenceBase.getCustomMode();
            }
            case 5: {
                return pSSysSequenceBase.getExtFormatParams();
            }
            case 6: {
                return pSSysSequenceBase.getKeyPSDEFId();
            }
            case 7: {
                return pSSysSequenceBase.getKeyPSDEFName();
            }
            case 8: {
                return pSSysSequenceBase.getMaxValue();
            }
            case 9: {
                return pSSysSequenceBase.getMemo();
            }
            case 10: {
                return pSSysSequenceBase.getMinValue();
            }
            case 11: {
                return pSSysSequenceBase.getPSDEId();
            }
            case 12: {
                return pSSysSequenceBase.getPSDEName();
            }
            case 13: {
                return pSSysSequenceBase.getPSModuleId();
            }
            case 14: {
                return pSSysSequenceBase.getPSModuleName();
            }
            case 15: {
                return pSSysSequenceBase.getPSSysDynaModelId();
            }
            case 16: {
                return pSSysSequenceBase.getPSSysDynaModelName();
            }
            case 17: {
                return pSSysSequenceBase.getPSSysSequenceId();
            }
            case 18: {
                return pSSysSequenceBase.getPSSysSequenceName();
            }
            case 19: {
                return pSSysSequenceBase.getPSSysSFPluginId();
            }
            case 20: {
                return pSSysSequenceBase.getPSSysSFPluginName();
            }
            case 21: {
                return pSSysSequenceBase.getPSSystemId();
            }
            case 22: {
                return pSSysSequenceBase.getPSSystemName();
            }
            case 23: {
                return pSSysSequenceBase.getSequenceFormat();
            }
            case 24: {
                return pSSysSequenceBase.getSequenceParams();
            }
            case 25: {
                return pSSysSequenceBase.getSequenceTag();
            }
            case 26: {
                return pSSysSequenceBase.getSequenceTag2();
            }
            case 27: {
                return pSSysSequenceBase.getSequenceType();
            }
            case 28: {
                return pSSysSequenceBase.getTimeFormat();
            }
            case 29: {
                return pSSysSequenceBase.getTimePSDEFId();
            }
            case 30: {
                return pSSysSequenceBase.getTimePSDEFName();
            }
            case 31: {
                return pSSysSequenceBase.getTypePSDEFId();
            }
            case 32: {
                return pSSysSequenceBase.getTypePSDEFName();
            }
            case 33: {
                return pSSysSequenceBase.getUpdateDate();
            }
            case 34: {
                return pSSysSequenceBase.getUpdateMan();
            }
            case 35: {
                return pSSysSequenceBase.getUser2PSDEFId();
            }
            case 36: {
                return pSSysSequenceBase.getUser2PSDEFName();
            }
            case 37: {
                return pSSysSequenceBase.getUserCat();
            }
            case 38: {
                return pSSysSequenceBase.getUserPSDEFId();
            }
            case 39: {
                return pSSysSequenceBase.getUserPSDEFName();
            }
            case 40: {
                return pSSysSequenceBase.getUserTag();
            }
            case 41: {
                return pSSysSequenceBase.getUserTag2();
            }
            case 42: {
                return pSSysSequenceBase.getUserTag3();
            }
            case 43: {
                return pSSysSequenceBase.getUserTag4();
            }
            case 44: {
                return pSSysSequenceBase.getValidFlag();
            }
            case 45: {
                return pSSysSequenceBase.getValuePSDEFId();
            }
            case 46: {
                return pSSysSequenceBase.getValuePSDEFName();
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
        PSSysSequenceBase.set(this, n, object);
    }

    private static void set(PSSysSequenceBase pSSysSequenceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSequenceBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSequenceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSequenceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSequenceBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSequenceBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysSequenceBase.setExtFormatParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSequenceBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSequenceBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSequenceBase.setMaxValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysSequenceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSequenceBase.setMinValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysSequenceBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSequenceBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSequenceBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSequenceBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSequenceBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSequenceBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSequenceBase.setPSSysSequenceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSequenceBase.setPSSysSequenceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSequenceBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSequenceBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysSequenceBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysSequenceBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysSequenceBase.setSequenceFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysSequenceBase.setSequenceParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysSequenceBase.setSequenceTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysSequenceBase.setSequenceTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysSequenceBase.setSequenceType(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysSequenceBase.setTimeFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysSequenceBase.setTimePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysSequenceBase.setTimePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysSequenceBase.setTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysSequenceBase.setTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysSequenceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSysSequenceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysSequenceBase.setUser2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysSequenceBase.setUser2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysSequenceBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysSequenceBase.setUserPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysSequenceBase.setUserPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysSequenceBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysSequenceBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysSequenceBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysSequenceBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysSequenceBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 45: {
                pSSysSequenceBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysSequenceBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
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
        return PSSysSequenceBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSequenceBase pSSysSequenceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSequenceBase.getCodeName() == null;
            }
            case 1: {
                return pSSysSequenceBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSequenceBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSequenceBase.getCustomCode() == null;
            }
            case 4: {
                return pSSysSequenceBase.getCustomMode() == null;
            }
            case 5: {
                return pSSysSequenceBase.getExtFormatParams() == null;
            }
            case 6: {
                return pSSysSequenceBase.getKeyPSDEFId() == null;
            }
            case 7: {
                return pSSysSequenceBase.getKeyPSDEFName() == null;
            }
            case 8: {
                return pSSysSequenceBase.getMaxValue() == null;
            }
            case 9: {
                return pSSysSequenceBase.getMemo() == null;
            }
            case 10: {
                return pSSysSequenceBase.getMinValue() == null;
            }
            case 11: {
                return pSSysSequenceBase.getPSDEId() == null;
            }
            case 12: {
                return pSSysSequenceBase.getPSDEName() == null;
            }
            case 13: {
                return pSSysSequenceBase.getPSModuleId() == null;
            }
            case 14: {
                return pSSysSequenceBase.getPSModuleName() == null;
            }
            case 15: {
                return pSSysSequenceBase.getPSSysDynaModelId() == null;
            }
            case 16: {
                return pSSysSequenceBase.getPSSysDynaModelName() == null;
            }
            case 17: {
                return pSSysSequenceBase.getPSSysSequenceId() == null;
            }
            case 18: {
                return pSSysSequenceBase.getPSSysSequenceName() == null;
            }
            case 19: {
                return pSSysSequenceBase.getPSSysSFPluginId() == null;
            }
            case 20: {
                return pSSysSequenceBase.getPSSysSFPluginName() == null;
            }
            case 21: {
                return pSSysSequenceBase.getPSSystemId() == null;
            }
            case 22: {
                return pSSysSequenceBase.getPSSystemName() == null;
            }
            case 23: {
                return pSSysSequenceBase.getSequenceFormat() == null;
            }
            case 24: {
                return pSSysSequenceBase.getSequenceParams() == null;
            }
            case 25: {
                return pSSysSequenceBase.getSequenceTag() == null;
            }
            case 26: {
                return pSSysSequenceBase.getSequenceTag2() == null;
            }
            case 27: {
                return pSSysSequenceBase.getSequenceType() == null;
            }
            case 28: {
                return pSSysSequenceBase.getTimeFormat() == null;
            }
            case 29: {
                return pSSysSequenceBase.getTimePSDEFId() == null;
            }
            case 30: {
                return pSSysSequenceBase.getTimePSDEFName() == null;
            }
            case 31: {
                return pSSysSequenceBase.getTypePSDEFId() == null;
            }
            case 32: {
                return pSSysSequenceBase.getTypePSDEFName() == null;
            }
            case 33: {
                return pSSysSequenceBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSysSequenceBase.getUpdateMan() == null;
            }
            case 35: {
                return pSSysSequenceBase.getUser2PSDEFId() == null;
            }
            case 36: {
                return pSSysSequenceBase.getUser2PSDEFName() == null;
            }
            case 37: {
                return pSSysSequenceBase.getUserCat() == null;
            }
            case 38: {
                return pSSysSequenceBase.getUserPSDEFId() == null;
            }
            case 39: {
                return pSSysSequenceBase.getUserPSDEFName() == null;
            }
            case 40: {
                return pSSysSequenceBase.getUserTag() == null;
            }
            case 41: {
                return pSSysSequenceBase.getUserTag2() == null;
            }
            case 42: {
                return pSSysSequenceBase.getUserTag3() == null;
            }
            case 43: {
                return pSSysSequenceBase.getUserTag4() == null;
            }
            case 44: {
                return pSSysSequenceBase.getValidFlag() == null;
            }
            case 45: {
                return pSSysSequenceBase.getValuePSDEFId() == null;
            }
            case 46: {
                return pSSysSequenceBase.getValuePSDEFName() == null;
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
        return PSSysSequenceBase.contains(this, n);
    }

    private static boolean contains(PSSysSequenceBase pSSysSequenceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSequenceBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysSequenceBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSequenceBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSequenceBase.isCustomCodeDirty();
            }
            case 4: {
                return pSSysSequenceBase.isCustomModeDirty();
            }
            case 5: {
                return pSSysSequenceBase.isExtFormatParamsDirty();
            }
            case 6: {
                return pSSysSequenceBase.isKeyPSDEFIdDirty();
            }
            case 7: {
                return pSSysSequenceBase.isKeyPSDEFNameDirty();
            }
            case 8: {
                return pSSysSequenceBase.isMaxValueDirty();
            }
            case 9: {
                return pSSysSequenceBase.isMemoDirty();
            }
            case 10: {
                return pSSysSequenceBase.isMinValueDirty();
            }
            case 11: {
                return pSSysSequenceBase.isPSDEIdDirty();
            }
            case 12: {
                return pSSysSequenceBase.isPSDENameDirty();
            }
            case 13: {
                return pSSysSequenceBase.isPSModuleIdDirty();
            }
            case 14: {
                return pSSysSequenceBase.isPSModuleNameDirty();
            }
            case 15: {
                return pSSysSequenceBase.isPSSysDynaModelIdDirty();
            }
            case 16: {
                return pSSysSequenceBase.isPSSysDynaModelNameDirty();
            }
            case 17: {
                return pSSysSequenceBase.isPSSysSequenceIdDirty();
            }
            case 18: {
                return pSSysSequenceBase.isPSSysSequenceNameDirty();
            }
            case 19: {
                return pSSysSequenceBase.isPSSysSFPluginIdDirty();
            }
            case 20: {
                return pSSysSequenceBase.isPSSysSFPluginNameDirty();
            }
            case 21: {
                return pSSysSequenceBase.isPSSystemIdDirty();
            }
            case 22: {
                return pSSysSequenceBase.isPSSystemNameDirty();
            }
            case 23: {
                return pSSysSequenceBase.isSequenceFormatDirty();
            }
            case 24: {
                return pSSysSequenceBase.isSequenceParamsDirty();
            }
            case 25: {
                return pSSysSequenceBase.isSequenceTagDirty();
            }
            case 26: {
                return pSSysSequenceBase.isSequenceTag2Dirty();
            }
            case 27: {
                return pSSysSequenceBase.isSequenceTypeDirty();
            }
            case 28: {
                return pSSysSequenceBase.isTimeFormatDirty();
            }
            case 29: {
                return pSSysSequenceBase.isTimePSDEFIdDirty();
            }
            case 30: {
                return pSSysSequenceBase.isTimePSDEFNameDirty();
            }
            case 31: {
                return pSSysSequenceBase.isTypePSDEFIdDirty();
            }
            case 32: {
                return pSSysSequenceBase.isTypePSDEFNameDirty();
            }
            case 33: {
                return pSSysSequenceBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSysSequenceBase.isUpdateManDirty();
            }
            case 35: {
                return pSSysSequenceBase.isUser2PSDEFIdDirty();
            }
            case 36: {
                return pSSysSequenceBase.isUser2PSDEFNameDirty();
            }
            case 37: {
                return pSSysSequenceBase.isUserCatDirty();
            }
            case 38: {
                return pSSysSequenceBase.isUserPSDEFIdDirty();
            }
            case 39: {
                return pSSysSequenceBase.isUserPSDEFNameDirty();
            }
            case 40: {
                return pSSysSequenceBase.isUserTagDirty();
            }
            case 41: {
                return pSSysSequenceBase.isUserTag2Dirty();
            }
            case 42: {
                return pSSysSequenceBase.isUserTag3Dirty();
            }
            case 43: {
                return pSSysSequenceBase.isUserTag4Dirty();
            }
            case 44: {
                return pSSysSequenceBase.isValidFlagDirty();
            }
            case 45: {
                return pSSysSequenceBase.isValuePSDEFIdDirty();
            }
            case 46: {
                return pSSysSequenceBase.isValuePSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSequenceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSequenceBase pSSysSequenceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSequenceBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getExtFormatParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"extformatparams", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getExtFormatParams()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getMinValue()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysSequenceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequenceid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysSequenceId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysSequenceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequencename", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysSequenceName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getSequenceFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequenceformat", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getSequenceFormat()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getSequenceParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequenceparams", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getSequenceParams()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getSequenceTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequencetag", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getSequenceTag()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getSequenceTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequencetag2", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getSequenceTag2()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getSequenceType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sequencetype", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getSequenceType()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getTimeFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timeformat", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getTimeFormat()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getTimePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getTimePSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getTimePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timepsdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getTimePSDEFName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUser2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUser2PSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUser2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"user2psdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUser2PSDEFName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserPSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userpsdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserPSDEFName()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSSysSequenceBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSSysSequenceBase.getJSONValue((Object)pSSysSequenceBase.getValuePSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSequenceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSequenceBase pSSysSequenceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSequenceBase.getCodeName() != null) {
            object = pSSysSequenceBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getCreateDate() != null) {
            object = pSSysSequenceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSequenceBase.getCreateMan() != null) {
            object = pSSysSequenceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getCustomCode() != null) {
            object = pSSysSequenceBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getCustomMode() != null) {
            object = pSSysSequenceBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSequenceBase.getExtFormatParams() != null) {
            object = pSSysSequenceBase.getExtFormatParams();
            xmlNode.setAttribute(FIELD_EXTFORMATPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getKeyPSDEFId() != null) {
            object = pSSysSequenceBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getKeyPSDEFName() != null) {
            object = pSSysSequenceBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getMaxValue() != null) {
            object = pSSysSequenceBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSequenceBase.getMemo() != null) {
            object = pSSysSequenceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getMinValue() != null) {
            object = pSSysSequenceBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSequenceBase.getPSDEId() != null) {
            object = pSSysSequenceBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSDEName() != null) {
            object = pSSysSequenceBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSModuleId() != null) {
            object = pSSysSequenceBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSModuleName() != null) {
            object = pSSysSequenceBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysDynaModelId() != null) {
            object = pSSysSequenceBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysDynaModelName() != null) {
            object = pSSysSequenceBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysSequenceId() != null) {
            object = pSSysSequenceBase.getPSSysSequenceId();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysSequenceName() != null) {
            object = pSSysSequenceBase.getPSSysSequenceName();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysSFPluginId() != null) {
            object = pSSysSequenceBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSysSFPluginName() != null) {
            object = pSSysSequenceBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSystemId() != null) {
            object = pSSysSequenceBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getPSSystemName() != null) {
            object = pSSysSequenceBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getSequenceFormat() != null) {
            object = pSSysSequenceBase.getSequenceFormat();
            xmlNode.setAttribute(FIELD_SEQUENCEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getSequenceParams() != null) {
            object = pSSysSequenceBase.getSequenceParams();
            xmlNode.setAttribute(FIELD_SEQUENCEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getSequenceTag() != null) {
            object = pSSysSequenceBase.getSequenceTag();
            xmlNode.setAttribute(FIELD_SEQUENCETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getSequenceTag2() != null) {
            object = pSSysSequenceBase.getSequenceTag2();
            xmlNode.setAttribute(FIELD_SEQUENCETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getSequenceType() != null) {
            object = pSSysSequenceBase.getSequenceType();
            xmlNode.setAttribute(FIELD_SEQUENCETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getTimeFormat() != null) {
            object = pSSysSequenceBase.getTimeFormat();
            xmlNode.setAttribute(FIELD_TIMEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getTimePSDEFId() != null) {
            object = pSSysSequenceBase.getTimePSDEFId();
            xmlNode.setAttribute(FIELD_TIMEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getTimePSDEFName() != null) {
            object = pSSysSequenceBase.getTimePSDEFName();
            xmlNode.setAttribute(FIELD_TIMEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getTypePSDEFId() != null) {
            object = pSSysSequenceBase.getTypePSDEFId();
            xmlNode.setAttribute(FIELD_TYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getTypePSDEFName() != null) {
            object = pSSysSequenceBase.getTypePSDEFName();
            xmlNode.setAttribute(FIELD_TYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUpdateDate() != null) {
            object = pSSysSequenceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSequenceBase.getUpdateMan() != null) {
            object = pSSysSequenceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUser2PSDEFId() != null) {
            object = pSSysSequenceBase.getUser2PSDEFId();
            xmlNode.setAttribute(FIELD_USER2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUser2PSDEFName() != null) {
            object = pSSysSequenceBase.getUser2PSDEFName();
            xmlNode.setAttribute(FIELD_USER2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserCat() != null) {
            object = pSSysSequenceBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserPSDEFId() != null) {
            object = pSSysSequenceBase.getUserPSDEFId();
            xmlNode.setAttribute(FIELD_USERPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserPSDEFName() != null) {
            object = pSSysSequenceBase.getUserPSDEFName();
            xmlNode.setAttribute(FIELD_USERPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserTag() != null) {
            object = pSSysSequenceBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserTag2() != null) {
            object = pSSysSequenceBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserTag3() != null) {
            object = pSSysSequenceBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getUserTag4() != null) {
            object = pSSysSequenceBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getValidFlag() != null) {
            object = pSSysSequenceBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysSequenceBase.getValuePSDEFId() != null) {
            object = pSSysSequenceBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSequenceBase.getValuePSDEFName() != null) {
            object = pSSysSequenceBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSequenceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSequenceBase pSSysSequenceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSequenceBase.isCodeNameDirty() && (bl || pSSysSequenceBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysSequenceBase.getCodeName());
        }
        if (pSSysSequenceBase.isCreateDateDirty() && (bl || pSSysSequenceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSequenceBase.getCreateDate());
        }
        if (pSSysSequenceBase.isCreateManDirty() && (bl || pSSysSequenceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSequenceBase.getCreateMan());
        }
        if (pSSysSequenceBase.isCustomCodeDirty() && (bl || pSSysSequenceBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysSequenceBase.getCustomCode());
        }
        if (pSSysSequenceBase.isCustomModeDirty() && (bl || pSSysSequenceBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysSequenceBase.getCustomMode());
        }
        if (pSSysSequenceBase.isExtFormatParamsDirty() && (bl || pSSysSequenceBase.getExtFormatParams() != null)) {
            iDataObject.set(FIELD_EXTFORMATPARAMS, (Object)pSSysSequenceBase.getExtFormatParams());
        }
        if (pSSysSequenceBase.isKeyPSDEFIdDirty() && (bl || pSSysSequenceBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysSequenceBase.getKeyPSDEFId());
        }
        if (pSSysSequenceBase.isKeyPSDEFNameDirty() && (bl || pSSysSequenceBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysSequenceBase.getKeyPSDEFName());
        }
        if (pSSysSequenceBase.isMaxValueDirty() && (bl || pSSysSequenceBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSSysSequenceBase.getMaxValue());
        }
        if (pSSysSequenceBase.isMemoDirty() && (bl || pSSysSequenceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSequenceBase.getMemo());
        }
        if (pSSysSequenceBase.isMinValueDirty() && (bl || pSSysSequenceBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSSysSequenceBase.getMinValue());
        }
        if (pSSysSequenceBase.isPSDEIdDirty() && (bl || pSSysSequenceBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysSequenceBase.getPSDEId());
        }
        if (pSSysSequenceBase.isPSDENameDirty() && (bl || pSSysSequenceBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysSequenceBase.getPSDEName());
        }
        if (pSSysSequenceBase.isPSModuleIdDirty() && (bl || pSSysSequenceBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysSequenceBase.getPSModuleId());
        }
        if (pSSysSequenceBase.isPSModuleNameDirty() && (bl || pSSysSequenceBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysSequenceBase.getPSModuleName());
        }
        if (pSSysSequenceBase.isPSSysDynaModelIdDirty() && (bl || pSSysSequenceBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysSequenceBase.getPSSysDynaModelId());
        }
        if (pSSysSequenceBase.isPSSysDynaModelNameDirty() && (bl || pSSysSequenceBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysSequenceBase.getPSSysDynaModelName());
        }
        if (pSSysSequenceBase.isPSSysSequenceIdDirty() && (bl || pSSysSequenceBase.getPSSysSequenceId() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCEID, (Object)pSSysSequenceBase.getPSSysSequenceId());
        }
        if (pSSysSequenceBase.isPSSysSequenceNameDirty() && (bl || pSSysSequenceBase.getPSSysSequenceName() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCENAME, (Object)pSSysSequenceBase.getPSSysSequenceName());
        }
        if (pSSysSequenceBase.isPSSysSFPluginIdDirty() && (bl || pSSysSequenceBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysSequenceBase.getPSSysSFPluginId());
        }
        if (pSSysSequenceBase.isPSSysSFPluginNameDirty() && (bl || pSSysSequenceBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysSequenceBase.getPSSysSFPluginName());
        }
        if (pSSysSequenceBase.isPSSystemIdDirty() && (bl || pSSysSequenceBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysSequenceBase.getPSSystemId());
        }
        if (pSSysSequenceBase.isPSSystemNameDirty() && (bl || pSSysSequenceBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysSequenceBase.getPSSystemName());
        }
        if (pSSysSequenceBase.isSequenceFormatDirty() && (bl || pSSysSequenceBase.getSequenceFormat() != null)) {
            iDataObject.set(FIELD_SEQUENCEFORMAT, (Object)pSSysSequenceBase.getSequenceFormat());
        }
        if (pSSysSequenceBase.isSequenceParamsDirty() && (bl || pSSysSequenceBase.getSequenceParams() != null)) {
            iDataObject.set(FIELD_SEQUENCEPARAMS, (Object)pSSysSequenceBase.getSequenceParams());
        }
        if (pSSysSequenceBase.isSequenceTagDirty() && (bl || pSSysSequenceBase.getSequenceTag() != null)) {
            iDataObject.set(FIELD_SEQUENCETAG, (Object)pSSysSequenceBase.getSequenceTag());
        }
        if (pSSysSequenceBase.isSequenceTag2Dirty() && (bl || pSSysSequenceBase.getSequenceTag2() != null)) {
            iDataObject.set(FIELD_SEQUENCETAG2, (Object)pSSysSequenceBase.getSequenceTag2());
        }
        if (pSSysSequenceBase.isSequenceTypeDirty() && (bl || pSSysSequenceBase.getSequenceType() != null)) {
            iDataObject.set(FIELD_SEQUENCETYPE, (Object)pSSysSequenceBase.getSequenceType());
        }
        if (pSSysSequenceBase.isTimeFormatDirty() && (bl || pSSysSequenceBase.getTimeFormat() != null)) {
            iDataObject.set(FIELD_TIMEFORMAT, (Object)pSSysSequenceBase.getTimeFormat());
        }
        if (pSSysSequenceBase.isTimePSDEFIdDirty() && (bl || pSSysSequenceBase.getTimePSDEFId() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFID, (Object)pSSysSequenceBase.getTimePSDEFId());
        }
        if (pSSysSequenceBase.isTimePSDEFNameDirty() && (bl || pSSysSequenceBase.getTimePSDEFName() != null)) {
            iDataObject.set(FIELD_TIMEPSDEFNAME, (Object)pSSysSequenceBase.getTimePSDEFName());
        }
        if (pSSysSequenceBase.isTypePSDEFIdDirty() && (bl || pSSysSequenceBase.getTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFID, (Object)pSSysSequenceBase.getTypePSDEFId());
        }
        if (pSSysSequenceBase.isTypePSDEFNameDirty() && (bl || pSSysSequenceBase.getTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFNAME, (Object)pSSysSequenceBase.getTypePSDEFName());
        }
        if (pSSysSequenceBase.isUpdateDateDirty() && (bl || pSSysSequenceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSequenceBase.getUpdateDate());
        }
        if (pSSysSequenceBase.isUpdateManDirty() && (bl || pSSysSequenceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSequenceBase.getUpdateMan());
        }
        if (pSSysSequenceBase.isUser2PSDEFIdDirty() && (bl || pSSysSequenceBase.getUser2PSDEFId() != null)) {
            iDataObject.set(FIELD_USER2PSDEFID, (Object)pSSysSequenceBase.getUser2PSDEFId());
        }
        if (pSSysSequenceBase.isUser2PSDEFNameDirty() && (bl || pSSysSequenceBase.getUser2PSDEFName() != null)) {
            iDataObject.set(FIELD_USER2PSDEFNAME, (Object)pSSysSequenceBase.getUser2PSDEFName());
        }
        if (pSSysSequenceBase.isUserCatDirty() && (bl || pSSysSequenceBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysSequenceBase.getUserCat());
        }
        if (pSSysSequenceBase.isUserPSDEFIdDirty() && (bl || pSSysSequenceBase.getUserPSDEFId() != null)) {
            iDataObject.set(FIELD_USERPSDEFID, (Object)pSSysSequenceBase.getUserPSDEFId());
        }
        if (pSSysSequenceBase.isUserPSDEFNameDirty() && (bl || pSSysSequenceBase.getUserPSDEFName() != null)) {
            iDataObject.set(FIELD_USERPSDEFNAME, (Object)pSSysSequenceBase.getUserPSDEFName());
        }
        if (pSSysSequenceBase.isUserTagDirty() && (bl || pSSysSequenceBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysSequenceBase.getUserTag());
        }
        if (pSSysSequenceBase.isUserTag2Dirty() && (bl || pSSysSequenceBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysSequenceBase.getUserTag2());
        }
        if (pSSysSequenceBase.isUserTag3Dirty() && (bl || pSSysSequenceBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysSequenceBase.getUserTag3());
        }
        if (pSSysSequenceBase.isUserTag4Dirty() && (bl || pSSysSequenceBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysSequenceBase.getUserTag4());
        }
        if (pSSysSequenceBase.isValidFlagDirty() && (bl || pSSysSequenceBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysSequenceBase.getValidFlag());
        }
        if (pSSysSequenceBase.isValuePSDEFIdDirty() && (bl || pSSysSequenceBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSSysSequenceBase.getValuePSDEFId());
        }
        if (pSSysSequenceBase.isValuePSDEFNameDirty() && (bl || pSSysSequenceBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSSysSequenceBase.getValuePSDEFName());
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
        return PSSysSequenceBase.remove(this, n);
    }

    private static boolean remove(PSSysSequenceBase pSSysSequenceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSequenceBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysSequenceBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSequenceBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSequenceBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSSysSequenceBase.resetCustomMode();
                return true;
            }
            case 5: {
                pSSysSequenceBase.resetExtFormatParams();
                return true;
            }
            case 6: {
                pSSysSequenceBase.resetKeyPSDEFId();
                return true;
            }
            case 7: {
                pSSysSequenceBase.resetKeyPSDEFName();
                return true;
            }
            case 8: {
                pSSysSequenceBase.resetMaxValue();
                return true;
            }
            case 9: {
                pSSysSequenceBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysSequenceBase.resetMinValue();
                return true;
            }
            case 11: {
                pSSysSequenceBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSSysSequenceBase.resetPSDEName();
                return true;
            }
            case 13: {
                pSSysSequenceBase.resetPSModuleId();
                return true;
            }
            case 14: {
                pSSysSequenceBase.resetPSModuleName();
                return true;
            }
            case 15: {
                pSSysSequenceBase.resetPSSysDynaModelId();
                return true;
            }
            case 16: {
                pSSysSequenceBase.resetPSSysDynaModelName();
                return true;
            }
            case 17: {
                pSSysSequenceBase.resetPSSysSequenceId();
                return true;
            }
            case 18: {
                pSSysSequenceBase.resetPSSysSequenceName();
                return true;
            }
            case 19: {
                pSSysSequenceBase.resetPSSysSFPluginId();
                return true;
            }
            case 20: {
                pSSysSequenceBase.resetPSSysSFPluginName();
                return true;
            }
            case 21: {
                pSSysSequenceBase.resetPSSystemId();
                return true;
            }
            case 22: {
                pSSysSequenceBase.resetPSSystemName();
                return true;
            }
            case 23: {
                pSSysSequenceBase.resetSequenceFormat();
                return true;
            }
            case 24: {
                pSSysSequenceBase.resetSequenceParams();
                return true;
            }
            case 25: {
                pSSysSequenceBase.resetSequenceTag();
                return true;
            }
            case 26: {
                pSSysSequenceBase.resetSequenceTag2();
                return true;
            }
            case 27: {
                pSSysSequenceBase.resetSequenceType();
                return true;
            }
            case 28: {
                pSSysSequenceBase.resetTimeFormat();
                return true;
            }
            case 29: {
                pSSysSequenceBase.resetTimePSDEFId();
                return true;
            }
            case 30: {
                pSSysSequenceBase.resetTimePSDEFName();
                return true;
            }
            case 31: {
                pSSysSequenceBase.resetTypePSDEFId();
                return true;
            }
            case 32: {
                pSSysSequenceBase.resetTypePSDEFName();
                return true;
            }
            case 33: {
                pSSysSequenceBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSysSequenceBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSSysSequenceBase.resetUser2PSDEFId();
                return true;
            }
            case 36: {
                pSSysSequenceBase.resetUser2PSDEFName();
                return true;
            }
            case 37: {
                pSSysSequenceBase.resetUserCat();
                return true;
            }
            case 38: {
                pSSysSequenceBase.resetUserPSDEFId();
                return true;
            }
            case 39: {
                pSSysSequenceBase.resetUserPSDEFName();
                return true;
            }
            case 40: {
                pSSysSequenceBase.resetUserTag();
                return true;
            }
            case 41: {
                pSSysSequenceBase.resetUserTag2();
                return true;
            }
            case 42: {
                pSSysSequenceBase.resetUserTag3();
                return true;
            }
            case 43: {
                pSSysSequenceBase.resetUserTag4();
                return true;
            }
            case 44: {
                pSSysSequenceBase.resetValidFlag();
                return true;
            }
            case 45: {
                pSSysSequenceBase.resetValuePSDEFId();
                return true;
            }
            case 46: {
                pSSysSequenceBase.resetValuePSDEFName();
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
    public PSDEField getTimePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimePSDEF();
        }
        if (this.getTimePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTimePSDEFLock;
        synchronized (n) {
            if (this.timepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTimePSDEFId(), (Object)this.timepsdef.getPSDEFieldId()) != 0L) {
                this.timepsdef = null;
            }
            if (this.timepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTimePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.timepsdef = pSDEField;
            }
            return this.timepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEF();
        }
        if (this.getTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTypePSDEFLock;
        synchronized (n) {
            if (this.typepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTypePSDEFId(), (Object)this.typepsdef.getPSDEFieldId()) != 0L) {
                this.typepsdef = null;
            }
            if (this.typepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.typepsdef = pSDEField;
            }
            return this.typepsdef;
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

    private PSSysSequenceBase getProxyEntity() {
        return this.proxyPSSysSequenceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSequenceBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSequenceBase) {
            this.proxyPSSysSequenceBase = (PSSysSequenceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 4);
        fieldIndexMap.put(FIELD_EXTFORMATPARAMS, 5);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 6);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 7);
        fieldIndexMap.put(FIELD_MAXVALUE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_MINVALUE, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDENAME, 12);
        fieldIndexMap.put(FIELD_PSMODULEID, 13);
        fieldIndexMap.put(FIELD_PSMODULENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCEID, 17);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCENAME, 18);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 22);
        fieldIndexMap.put(FIELD_SEQUENCEFORMAT, 23);
        fieldIndexMap.put(FIELD_SEQUENCEPARAMS, 24);
        fieldIndexMap.put(FIELD_SEQUENCETAG, 25);
        fieldIndexMap.put(FIELD_SEQUENCETAG2, 26);
        fieldIndexMap.put(FIELD_SEQUENCETYPE, 27);
        fieldIndexMap.put(FIELD_TIMEFORMAT, 28);
        fieldIndexMap.put(FIELD_TIMEPSDEFID, 29);
        fieldIndexMap.put(FIELD_TIMEPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_TYPEPSDEFID, 31);
        fieldIndexMap.put(FIELD_TYPEPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USER2PSDEFID, 35);
        fieldIndexMap.put(FIELD_USER2PSDEFNAME, 36);
        fieldIndexMap.put(FIELD_USERCAT, 37);
        fieldIndexMap.put(FIELD_USERPSDEFID, 38);
        fieldIndexMap.put(FIELD_USERPSDEFNAME, 39);
        fieldIndexMap.put(FIELD_USERTAG, 40);
        fieldIndexMap.put(FIELD_USERTAG2, 41);
        fieldIndexMap.put(FIELD_USERTAG3, 42);
        fieldIndexMap.put(FIELD_USERTAG4, 43);
        fieldIndexMap.put(FIELD_VALIDFLAG, 44);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 45);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 46);
    }
}

