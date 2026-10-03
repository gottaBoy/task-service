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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelAttr;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelAttrService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDynaModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDynaModelBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DTOCODENAME = "DTOCODENAME";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNAMODEL2 = "DYNAMODEL2";
    public static final String FIELD_DYNAMODELFMT = "DYNAMODELFMT";
    public static final String FIELD_DYNAMODELUSAGE = "DYNAMODELUSAGE";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELTAG = "MODELTAG";
    public static final String FIELD_MODELTAG2 = "MODELTAG2";
    public static final String FIELD_MODELTAG3 = "MODELTAG3";
    public static final String FIELD_MODELTAG4 = "MODELTAG4";
    public static final String FIELD_PPSSYSDYNAMODELID = "PPSSYSDYNAMODELID";
    public static final String FIELD_PPSSYSDYNAMODELNAME = "PPSSYSDYNAMODELNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSDYNAMODELCATID = "PSSYSDYNAMODELCATID";
    public static final String FIELD_PSSYSDYNAMODELCATNAME = "PSSYSDYNAMODELCATNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
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
    private static final int INDEX_DEFAULTFLAG = 3;
    private static final int INDEX_DTOCODENAME = 4;
    private static final int INDEX_DYNAMODEL = 5;
    private static final int INDEX_DYNAMODEL2 = 6;
    private static final int INDEX_DYNAMODELFMT = 7;
    private static final int INDEX_DYNAMODELUSAGE = 8;
    private static final int INDEX_LOCKFLAG = 9;
    private static final int INDEX_LOGICNAME = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_MODELTAG = 12;
    private static final int INDEX_MODELTAG2 = 13;
    private static final int INDEX_MODELTAG3 = 14;
    private static final int INDEX_MODELTAG4 = 15;
    private static final int INDEX_PPSSYSDYNAMODELID = 16;
    private static final int INDEX_PPSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSMODULEID = 18;
    private static final int INDEX_PSMODULENAME = 19;
    private static final int INDEX_PSSYSDYNAMODELCATID = 20;
    private static final int INDEX_PSSYSDYNAMODELCATNAME = 21;
    private static final int INDEX_PSSYSDYNAMODELID = 22;
    private static final int INDEX_PSSYSDYNAMODELNAME = 23;
    private static final int INDEX_PSSYSTEMID = 24;
    private static final int INDEX_PSSYSTEMNAME = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final int INDEX_USERCAT = 28;
    private static final int INDEX_USERTAG = 29;
    private static final int INDEX_USERTAG2 = 30;
    private static final int INDEX_USERTAG3 = 31;
    private static final int INDEX_USERTAG4 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDynaModelBase proxyPSSysDynaModelBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dtocodenameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynamodel2DirtyFlag = false;
    private boolean dynamodelfmtDirtyFlag = false;
    private boolean dynamodelusageDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeltagDirtyFlag = false;
    private boolean modeltag2DirtyFlag = false;
    private boolean modeltag3DirtyFlag = false;
    private boolean modeltag4DirtyFlag = false;
    private boolean ppssysdynamodelidDirtyFlag = false;
    private boolean ppssysdynamodelnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysdynamodelcatidDirtyFlag = false;
    private boolean pssysdynamodelcatnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dtocodename")
    private String dtocodename;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynamodel2")
    private String dynamodel2;
    @Column(name="dynamodelfmt")
    private String dynamodelfmt;
    @Column(name="dynamodelusage")
    private String dynamodelusage;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modeltag")
    private String modeltag;
    @Column(name="modeltag2")
    private String modeltag2;
    @Column(name="modeltag3")
    private String modeltag3;
    @Column(name="modeltag4")
    private String modeltag4;
    @Column(name="ppssysdynamodelid")
    private String ppssysdynamodelid;
    @Column(name="ppssysdynamodelname")
    private String ppssysdynamodelname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysdynamodelcatid")
    private String pssysdynamodelcatid;
    @Column(name="pssysdynamodelcatname")
    private String pssysdynamodelcatname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModelCat pssysdynamodel = null;
    private Integer objPPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel ppssysdynamodel = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDynaModelAttrsLock = new Integer(1);
    private ArrayList<PSSysDynaModelAttr> pssysdynamodelattrs = null;

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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDTOCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDTOCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dtocodename = string;
        this.dtocodenameDirtyFlag = true;
    }

    public String getDTOCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDTOCodeName();
        }
        return this.dtocodename;
    }

    public boolean isDTOCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDTOCodeNameDirty();
        }
        return this.dtocodenameDirtyFlag;
    }

    public void resetDTOCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDTOCodeName();
            return;
        }
        this.dtocodenameDirtyFlag = false;
        this.dtocodename = null;
    }

    public void setDynaModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel = string;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setDynaModel2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel2 = string;
        this.dynamodel2DirtyFlag = true;
    }

    public String getDynaModel2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel2();
        }
        return this.dynamodel2;
    }

    public boolean isDynaModel2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModel2Dirty();
        }
        return this.dynamodel2DirtyFlag;
    }

    public void resetDynaModel2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel2();
            return;
        }
        this.dynamodel2DirtyFlag = false;
        this.dynamodel2 = null;
    }

    public void setDynaModelFmt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFmt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodelfmt = string;
        this.dynamodelfmtDirtyFlag = true;
    }

    public String getDynaModelFmt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFmt();
        }
        return this.dynamodelfmt;
    }

    public boolean isDynaModelFmtDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFmtDirty();
        }
        return this.dynamodelfmtDirtyFlag;
    }

    public void resetDynaModelFmt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFmt();
            return;
        }
        this.dynamodelfmtDirtyFlag = false;
        this.dynamodelfmt = null;
    }

    public void setDynaModelUsage(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelUsage(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodelusage = string;
        this.dynamodelusageDirtyFlag = true;
    }

    public String getDynaModelUsage() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelUsage();
        }
        return this.dynamodelusage;
    }

    public boolean isDynaModelUsageDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelUsageDirty();
        }
        return this.dynamodelusageDirtyFlag;
    }

    public void resetDynaModelUsage() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelUsage();
            return;
        }
        this.dynamodelusageDirtyFlag = false;
        this.dynamodelusage = null;
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

    public void setModelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag = string;
        this.modeltagDirtyFlag = true;
    }

    public String getModelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag();
        }
        return this.modeltag;
    }

    public boolean isModelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTagDirty();
        }
        return this.modeltagDirtyFlag;
    }

    public void resetModelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag();
            return;
        }
        this.modeltagDirtyFlag = false;
        this.modeltag = null;
    }

    public void setModelTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag2 = string;
        this.modeltag2DirtyFlag = true;
    }

    public String getModelTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag2();
        }
        return this.modeltag2;
    }

    public boolean isModelTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTag2Dirty();
        }
        return this.modeltag2DirtyFlag;
    }

    public void resetModelTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag2();
            return;
        }
        this.modeltag2DirtyFlag = false;
        this.modeltag2 = null;
    }

    public void setModelTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag3 = string;
        this.modeltag3DirtyFlag = true;
    }

    public String getModelTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag3();
        }
        return this.modeltag3;
    }

    public boolean isModelTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTag3Dirty();
        }
        return this.modeltag3DirtyFlag;
    }

    public void resetModelTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag3();
            return;
        }
        this.modeltag3DirtyFlag = false;
        this.modeltag3 = null;
    }

    public void setModelTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag4 = string;
        this.modeltag4DirtyFlag = true;
    }

    public String getModelTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag4();
        }
        return this.modeltag4;
    }

    public boolean isModelTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTag4Dirty();
        }
        return this.modeltag4DirtyFlag;
    }

    public void resetModelTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag4();
            return;
        }
        this.modeltag4DirtyFlag = false;
        this.modeltag4 = null;
    }

    public void setPPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdynamodelid = string;
        this.ppssysdynamodelidDirtyFlag = true;
    }

    public String getPPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDynaModelId();
        }
        return this.ppssysdynamodelid;
    }

    public boolean isPPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDynaModelIdDirty();
        }
        return this.ppssysdynamodelidDirtyFlag;
    }

    public void resetPPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDynaModelId();
            return;
        }
        this.ppssysdynamodelidDirtyFlag = false;
        this.ppssysdynamodelid = null;
    }

    public void setPPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdynamodelname = string;
        this.ppssysdynamodelnameDirtyFlag = true;
    }

    public String getPPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDynaModelName();
        }
        return this.ppssysdynamodelname;
    }

    public boolean isPPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDynaModelNameDirty();
        }
        return this.ppssysdynamodelnameDirtyFlag;
    }

    public void resetPPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDynaModelName();
            return;
        }
        this.ppssysdynamodelnameDirtyFlag = false;
        this.ppssysdynamodelname = null;
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

    public void setPSSysDynaModelCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelcatid = string;
        this.pssysdynamodelcatidDirtyFlag = true;
    }

    public String getPSSysDynaModelCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelCatId();
        }
        return this.pssysdynamodelcatid;
    }

    public boolean isPSSysDynaModelCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelCatIdDirty();
        }
        return this.pssysdynamodelcatidDirtyFlag;
    }

    public void resetPSSysDynaModelCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelCatId();
            return;
        }
        this.pssysdynamodelcatidDirtyFlag = false;
        this.pssysdynamodelcatid = null;
    }

    public void setPSSysDynaModelCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelcatname = string;
        this.pssysdynamodelcatnameDirtyFlag = true;
    }

    public String getPSSysDynaModelCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelCatName();
        }
        return this.pssysdynamodelcatname;
    }

    public boolean isPSSysDynaModelCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelCatNameDirty();
        }
        return this.pssysdynamodelcatnameDirtyFlag;
    }

    public void resetPSSysDynaModelCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelCatName();
            return;
        }
        this.pssysdynamodelcatnameDirtyFlag = false;
        this.pssysdynamodelcatname = null;
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
        PSSysDynaModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDynaModelBase pSSysDynaModelBase) {
        pSSysDynaModelBase.resetCodeName();
        pSSysDynaModelBase.resetCreateDate();
        pSSysDynaModelBase.resetCreateMan();
        pSSysDynaModelBase.resetDefaultFlag();
        pSSysDynaModelBase.resetDTOCodeName();
        pSSysDynaModelBase.resetDynaModel();
        pSSysDynaModelBase.resetDynaModel2();
        pSSysDynaModelBase.resetDynaModelFmt();
        pSSysDynaModelBase.resetDynaModelUsage();
        pSSysDynaModelBase.resetLockFlag();
        pSSysDynaModelBase.resetLogicName();
        pSSysDynaModelBase.resetMemo();
        pSSysDynaModelBase.resetModelTag();
        pSSysDynaModelBase.resetModelTag2();
        pSSysDynaModelBase.resetModelTag3();
        pSSysDynaModelBase.resetModelTag4();
        pSSysDynaModelBase.resetPPSSysDynaModelId();
        pSSysDynaModelBase.resetPPSSysDynaModelName();
        pSSysDynaModelBase.resetPSModuleId();
        pSSysDynaModelBase.resetPSModuleName();
        pSSysDynaModelBase.resetPSSysDynaModelCatId();
        pSSysDynaModelBase.resetPSSysDynaModelCatName();
        pSSysDynaModelBase.resetPSSysDynaModelId();
        pSSysDynaModelBase.resetPSSysDynaModelName();
        pSSysDynaModelBase.resetPSSystemId();
        pSSysDynaModelBase.resetPSSystemName();
        pSSysDynaModelBase.resetUpdateDate();
        pSSysDynaModelBase.resetUpdateMan();
        pSSysDynaModelBase.resetUserCat();
        pSSysDynaModelBase.resetUserTag();
        pSSysDynaModelBase.resetUserTag2();
        pSSysDynaModelBase.resetUserTag3();
        pSSysDynaModelBase.resetUserTag4();
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDTOCodeNameDirty()) {
            hashMap.put(FIELD_DTOCODENAME, this.getDTOCodeName());
        }
        if (!bl || this.isDynaModelDirty()) {
            hashMap.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bl || this.isDynaModel2Dirty()) {
            hashMap.put(FIELD_DYNAMODEL2, this.getDynaModel2());
        }
        if (!bl || this.isDynaModelFmtDirty()) {
            hashMap.put(FIELD_DYNAMODELFMT, this.getDynaModelFmt());
        }
        if (!bl || this.isDynaModelUsageDirty()) {
            hashMap.put(FIELD_DYNAMODELUSAGE, this.getDynaModelUsage());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelTagDirty()) {
            hashMap.put(FIELD_MODELTAG, this.getModelTag());
        }
        if (!bl || this.isModelTag2Dirty()) {
            hashMap.put(FIELD_MODELTAG2, this.getModelTag2());
        }
        if (!bl || this.isModelTag3Dirty()) {
            hashMap.put(FIELD_MODELTAG3, this.getModelTag3());
        }
        if (!bl || this.isModelTag4Dirty()) {
            hashMap.put(FIELD_MODELTAG4, this.getModelTag4());
        }
        if (!bl || this.isPPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PPSSYSDYNAMODELID, this.getPPSSysDynaModelId());
        }
        if (!bl || this.isPPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PPSSYSDYNAMODELNAME, this.getPPSSysDynaModelName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysDynaModelCatIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELCATID, this.getPSSysDynaModelCatId());
        }
        if (!bl || this.isPSSysDynaModelCatNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELCATNAME, this.getPSSysDynaModelCatName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        return PSSysDynaModelBase.get(this, n);
    }

    private static Object get(PSSysDynaModelBase pSSysDynaModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelBase.getCodeName();
            }
            case 1: {
                return pSSysDynaModelBase.getCreateDate();
            }
            case 2: {
                return pSSysDynaModelBase.getCreateMan();
            }
            case 3: {
                return pSSysDynaModelBase.getDefaultFlag();
            }
            case 4: {
                return pSSysDynaModelBase.getDTOCodeName();
            }
            case 5: {
                return pSSysDynaModelBase.getDynaModel();
            }
            case 6: {
                return pSSysDynaModelBase.getDynaModel2();
            }
            case 7: {
                return pSSysDynaModelBase.getDynaModelFmt();
            }
            case 8: {
                return pSSysDynaModelBase.getDynaModelUsage();
            }
            case 9: {
                return pSSysDynaModelBase.getLockFlag();
            }
            case 10: {
                return pSSysDynaModelBase.getLogicName();
            }
            case 11: {
                return pSSysDynaModelBase.getMemo();
            }
            case 12: {
                return pSSysDynaModelBase.getModelTag();
            }
            case 13: {
                return pSSysDynaModelBase.getModelTag2();
            }
            case 14: {
                return pSSysDynaModelBase.getModelTag3();
            }
            case 15: {
                return pSSysDynaModelBase.getModelTag4();
            }
            case 16: {
                return pSSysDynaModelBase.getPPSSysDynaModelId();
            }
            case 17: {
                return pSSysDynaModelBase.getPPSSysDynaModelName();
            }
            case 18: {
                return pSSysDynaModelBase.getPSModuleId();
            }
            case 19: {
                return pSSysDynaModelBase.getPSModuleName();
            }
            case 20: {
                return pSSysDynaModelBase.getPSSysDynaModelCatId();
            }
            case 21: {
                return pSSysDynaModelBase.getPSSysDynaModelCatName();
            }
            case 22: {
                return pSSysDynaModelBase.getPSSysDynaModelId();
            }
            case 23: {
                return pSSysDynaModelBase.getPSSysDynaModelName();
            }
            case 24: {
                return pSSysDynaModelBase.getPSSystemId();
            }
            case 25: {
                return pSSysDynaModelBase.getPSSystemName();
            }
            case 26: {
                return pSSysDynaModelBase.getUpdateDate();
            }
            case 27: {
                return pSSysDynaModelBase.getUpdateMan();
            }
            case 28: {
                return pSSysDynaModelBase.getUserCat();
            }
            case 29: {
                return pSSysDynaModelBase.getUserTag();
            }
            case 30: {
                return pSSysDynaModelBase.getUserTag2();
            }
            case 31: {
                return pSSysDynaModelBase.getUserTag3();
            }
            case 32: {
                return pSSysDynaModelBase.getUserTag4();
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
        PSSysDynaModelBase.set(this, n, object);
    }

    private static void set(PSSysDynaModelBase pSSysDynaModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDynaModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDynaModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDynaModelBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysDynaModelBase.setDTOCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDynaModelBase.setDynaModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDynaModelBase.setDynaModel2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDynaModelBase.setDynaModelFmt(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDynaModelBase.setDynaModelUsage(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDynaModelBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysDynaModelBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDynaModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDynaModelBase.setModelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDynaModelBase.setModelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDynaModelBase.setModelTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDynaModelBase.setModelTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDynaModelBase.setPPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDynaModelBase.setPPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDynaModelBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDynaModelBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDynaModelBase.setPSSysDynaModelCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDynaModelBase.setPSSysDynaModelCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDynaModelBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDynaModelBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDynaModelBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDynaModelBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDynaModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSSysDynaModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDynaModelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDynaModelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDynaModelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDynaModelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDynaModelBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDynaModelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDynaModelBase pSSysDynaModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelBase.getCodeName() == null;
            }
            case 1: {
                return pSSysDynaModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDynaModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDynaModelBase.getDefaultFlag() == null;
            }
            case 4: {
                return pSSysDynaModelBase.getDTOCodeName() == null;
            }
            case 5: {
                return pSSysDynaModelBase.getDynaModel() == null;
            }
            case 6: {
                return pSSysDynaModelBase.getDynaModel2() == null;
            }
            case 7: {
                return pSSysDynaModelBase.getDynaModelFmt() == null;
            }
            case 8: {
                return pSSysDynaModelBase.getDynaModelUsage() == null;
            }
            case 9: {
                return pSSysDynaModelBase.getLockFlag() == null;
            }
            case 10: {
                return pSSysDynaModelBase.getLogicName() == null;
            }
            case 11: {
                return pSSysDynaModelBase.getMemo() == null;
            }
            case 12: {
                return pSSysDynaModelBase.getModelTag() == null;
            }
            case 13: {
                return pSSysDynaModelBase.getModelTag2() == null;
            }
            case 14: {
                return pSSysDynaModelBase.getModelTag3() == null;
            }
            case 15: {
                return pSSysDynaModelBase.getModelTag4() == null;
            }
            case 16: {
                return pSSysDynaModelBase.getPPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSysDynaModelBase.getPPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSysDynaModelBase.getPSModuleId() == null;
            }
            case 19: {
                return pSSysDynaModelBase.getPSModuleName() == null;
            }
            case 20: {
                return pSSysDynaModelBase.getPSSysDynaModelCatId() == null;
            }
            case 21: {
                return pSSysDynaModelBase.getPSSysDynaModelCatName() == null;
            }
            case 22: {
                return pSSysDynaModelBase.getPSSysDynaModelId() == null;
            }
            case 23: {
                return pSSysDynaModelBase.getPSSysDynaModelName() == null;
            }
            case 24: {
                return pSSysDynaModelBase.getPSSystemId() == null;
            }
            case 25: {
                return pSSysDynaModelBase.getPSSystemName() == null;
            }
            case 26: {
                return pSSysDynaModelBase.getUpdateDate() == null;
            }
            case 27: {
                return pSSysDynaModelBase.getUpdateMan() == null;
            }
            case 28: {
                return pSSysDynaModelBase.getUserCat() == null;
            }
            case 29: {
                return pSSysDynaModelBase.getUserTag() == null;
            }
            case 30: {
                return pSSysDynaModelBase.getUserTag2() == null;
            }
            case 31: {
                return pSSysDynaModelBase.getUserTag3() == null;
            }
            case 32: {
                return pSSysDynaModelBase.getUserTag4() == null;
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
        return PSSysDynaModelBase.contains(this, n);
    }

    private static boolean contains(PSSysDynaModelBase pSSysDynaModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDynaModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysDynaModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDynaModelBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDynaModelBase.isDefaultFlagDirty();
            }
            case 4: {
                return pSSysDynaModelBase.isDTOCodeNameDirty();
            }
            case 5: {
                return pSSysDynaModelBase.isDynaModelDirty();
            }
            case 6: {
                return pSSysDynaModelBase.isDynaModel2Dirty();
            }
            case 7: {
                return pSSysDynaModelBase.isDynaModelFmtDirty();
            }
            case 8: {
                return pSSysDynaModelBase.isDynaModelUsageDirty();
            }
            case 9: {
                return pSSysDynaModelBase.isLockFlagDirty();
            }
            case 10: {
                return pSSysDynaModelBase.isLogicNameDirty();
            }
            case 11: {
                return pSSysDynaModelBase.isMemoDirty();
            }
            case 12: {
                return pSSysDynaModelBase.isModelTagDirty();
            }
            case 13: {
                return pSSysDynaModelBase.isModelTag2Dirty();
            }
            case 14: {
                return pSSysDynaModelBase.isModelTag3Dirty();
            }
            case 15: {
                return pSSysDynaModelBase.isModelTag4Dirty();
            }
            case 16: {
                return pSSysDynaModelBase.isPPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSysDynaModelBase.isPPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSysDynaModelBase.isPSModuleIdDirty();
            }
            case 19: {
                return pSSysDynaModelBase.isPSModuleNameDirty();
            }
            case 20: {
                return pSSysDynaModelBase.isPSSysDynaModelCatIdDirty();
            }
            case 21: {
                return pSSysDynaModelBase.isPSSysDynaModelCatNameDirty();
            }
            case 22: {
                return pSSysDynaModelBase.isPSSysDynaModelIdDirty();
            }
            case 23: {
                return pSSysDynaModelBase.isPSSysDynaModelNameDirty();
            }
            case 24: {
                return pSSysDynaModelBase.isPSSystemIdDirty();
            }
            case 25: {
                return pSSysDynaModelBase.isPSSystemNameDirty();
            }
            case 26: {
                return pSSysDynaModelBase.isUpdateDateDirty();
            }
            case 27: {
                return pSSysDynaModelBase.isUpdateManDirty();
            }
            case 28: {
                return pSSysDynaModelBase.isUserCatDirty();
            }
            case 29: {
                return pSSysDynaModelBase.isUserTagDirty();
            }
            case 30: {
                return pSSysDynaModelBase.isUserTag2Dirty();
            }
            case 31: {
                return pSSysDynaModelBase.isUserTag3Dirty();
            }
            case 32: {
                return pSSysDynaModelBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDynaModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDynaModelBase pSSysDynaModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDynaModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDTOCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dtocodename", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDTOCodeName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDynaModel()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDynaModel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel2", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDynaModel2()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDynaModelFmt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelfmt", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDynaModelFmt()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getDynaModelUsage() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelusage", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getDynaModelUsage()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getModelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getModelTag()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getModelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag2", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getModelTag2()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getModelTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag3", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getModelTag3()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getModelTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag4", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getModelTag4()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdynamodelid", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdynamodelname", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelcatid", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSysDynaModelCatId()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelcatname", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSysDynaModelCatName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDynaModelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDynaModelBase.getJSONValue((Object)pSSysDynaModelBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDynaModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDynaModelBase pSSysDynaModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDynaModelBase.getCodeName() != null) {
            object = pSSysDynaModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getCreateDate() != null) {
            object = pSSysDynaModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelBase.getCreateMan() != null) {
            object = pSSysDynaModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getDefaultFlag() != null) {
            object = pSSysDynaModelBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelBase.getDTOCodeName() != null) {
            object = pSSysDynaModelBase.getDTOCodeName();
            xmlNode.setAttribute(FIELD_DTOCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getDynaModel() != null) {
            object = pSSysDynaModelBase.getDynaModel();
            xmlNode.setAttribute(FIELD_DYNAMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getDynaModel2() != null) {
            object = pSSysDynaModelBase.getDynaModel2();
            xmlNode.setAttribute(FIELD_DYNAMODEL2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getDynaModelFmt() != null) {
            object = pSSysDynaModelBase.getDynaModelFmt();
            xmlNode.setAttribute(FIELD_DYNAMODELFMT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getDynaModelUsage() != null) {
            object = pSSysDynaModelBase.getDynaModelUsage();
            xmlNode.setAttribute(FIELD_DYNAMODELUSAGE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getLockFlag() != null) {
            object = pSSysDynaModelBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDynaModelBase.getLogicName() != null) {
            object = pSSysDynaModelBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getMemo() != null) {
            object = pSSysDynaModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getModelTag() != null) {
            object = pSSysDynaModelBase.getModelTag();
            xmlNode.setAttribute(FIELD_MODELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getModelTag2() != null) {
            object = pSSysDynaModelBase.getModelTag2();
            xmlNode.setAttribute(FIELD_MODELTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getModelTag3() != null) {
            object = pSSysDynaModelBase.getModelTag3();
            xmlNode.setAttribute(FIELD_MODELTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getModelTag4() != null) {
            object = pSSysDynaModelBase.getModelTag4();
            xmlNode.setAttribute(FIELD_MODELTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPPSSysDynaModelId() != null) {
            object = pSSysDynaModelBase.getPPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PPSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPPSSysDynaModelName() != null) {
            object = pSSysDynaModelBase.getPPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PPSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSModuleId() != null) {
            object = pSSysDynaModelBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSModuleName() != null) {
            object = pSSysDynaModelBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelCatId() != null) {
            object = pSSysDynaModelBase.getPSSysDynaModelCatId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelCatName() != null) {
            object = pSSysDynaModelBase.getPSSysDynaModelCatName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelId() != null) {
            object = pSSysDynaModelBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSysDynaModelName() != null) {
            object = pSSysDynaModelBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSystemId() != null) {
            object = pSSysDynaModelBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getPSSystemName() != null) {
            object = pSSysDynaModelBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUpdateDate() != null) {
            object = pSSysDynaModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDynaModelBase.getUpdateMan() != null) {
            object = pSSysDynaModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUserCat() != null) {
            object = pSSysDynaModelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUserTag() != null) {
            object = pSSysDynaModelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUserTag2() != null) {
            object = pSSysDynaModelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUserTag3() != null) {
            object = pSSysDynaModelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDynaModelBase.getUserTag4() != null) {
            object = pSSysDynaModelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDynaModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDynaModelBase pSSysDynaModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDynaModelBase.isCodeNameDirty() && (bl || pSSysDynaModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDynaModelBase.getCodeName());
        }
        if (pSSysDynaModelBase.isCreateDateDirty() && (bl || pSSysDynaModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDynaModelBase.getCreateDate());
        }
        if (pSSysDynaModelBase.isCreateManDirty() && (bl || pSSysDynaModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDynaModelBase.getCreateMan());
        }
        if (pSSysDynaModelBase.isDefaultFlagDirty() && (bl || pSSysDynaModelBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysDynaModelBase.getDefaultFlag());
        }
        if (pSSysDynaModelBase.isDTOCodeNameDirty() && (bl || pSSysDynaModelBase.getDTOCodeName() != null)) {
            iDataObject.set(FIELD_DTOCODENAME, (Object)pSSysDynaModelBase.getDTOCodeName());
        }
        if (pSSysDynaModelBase.isDynaModelDirty() && (bl || pSSysDynaModelBase.getDynaModel() != null)) {
            iDataObject.set(FIELD_DYNAMODEL, (Object)pSSysDynaModelBase.getDynaModel());
        }
        if (pSSysDynaModelBase.isDynaModel2Dirty() && (bl || pSSysDynaModelBase.getDynaModel2() != null)) {
            iDataObject.set(FIELD_DYNAMODEL2, (Object)pSSysDynaModelBase.getDynaModel2());
        }
        if (pSSysDynaModelBase.isDynaModelFmtDirty() && (bl || pSSysDynaModelBase.getDynaModelFmt() != null)) {
            iDataObject.set(FIELD_DYNAMODELFMT, (Object)pSSysDynaModelBase.getDynaModelFmt());
        }
        if (pSSysDynaModelBase.isDynaModelUsageDirty() && (bl || pSSysDynaModelBase.getDynaModelUsage() != null)) {
            iDataObject.set(FIELD_DYNAMODELUSAGE, (Object)pSSysDynaModelBase.getDynaModelUsage());
        }
        if (pSSysDynaModelBase.isLockFlagDirty() && (bl || pSSysDynaModelBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysDynaModelBase.getLockFlag());
        }
        if (pSSysDynaModelBase.isLogicNameDirty() && (bl || pSSysDynaModelBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDynaModelBase.getLogicName());
        }
        if (pSSysDynaModelBase.isMemoDirty() && (bl || pSSysDynaModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDynaModelBase.getMemo());
        }
        if (pSSysDynaModelBase.isModelTagDirty() && (bl || pSSysDynaModelBase.getModelTag() != null)) {
            iDataObject.set(FIELD_MODELTAG, (Object)pSSysDynaModelBase.getModelTag());
        }
        if (pSSysDynaModelBase.isModelTag2Dirty() && (bl || pSSysDynaModelBase.getModelTag2() != null)) {
            iDataObject.set(FIELD_MODELTAG2, (Object)pSSysDynaModelBase.getModelTag2());
        }
        if (pSSysDynaModelBase.isModelTag3Dirty() && (bl || pSSysDynaModelBase.getModelTag3() != null)) {
            iDataObject.set(FIELD_MODELTAG3, (Object)pSSysDynaModelBase.getModelTag3());
        }
        if (pSSysDynaModelBase.isModelTag4Dirty() && (bl || pSSysDynaModelBase.getModelTag4() != null)) {
            iDataObject.set(FIELD_MODELTAG4, (Object)pSSysDynaModelBase.getModelTag4());
        }
        if (pSSysDynaModelBase.isPPSSysDynaModelIdDirty() && (bl || pSSysDynaModelBase.getPPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PPSSYSDYNAMODELID, (Object)pSSysDynaModelBase.getPPSSysDynaModelId());
        }
        if (pSSysDynaModelBase.isPPSSysDynaModelNameDirty() && (bl || pSSysDynaModelBase.getPPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PPSSYSDYNAMODELNAME, (Object)pSSysDynaModelBase.getPPSSysDynaModelName());
        }
        if (pSSysDynaModelBase.isPSModuleIdDirty() && (bl || pSSysDynaModelBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysDynaModelBase.getPSModuleId());
        }
        if (pSSysDynaModelBase.isPSModuleNameDirty() && (bl || pSSysDynaModelBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysDynaModelBase.getPSModuleName());
        }
        if (pSSysDynaModelBase.isPSSysDynaModelCatIdDirty() && (bl || pSSysDynaModelBase.getPSSysDynaModelCatId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELCATID, (Object)pSSysDynaModelBase.getPSSysDynaModelCatId());
        }
        if (pSSysDynaModelBase.isPSSysDynaModelCatNameDirty() && (bl || pSSysDynaModelBase.getPSSysDynaModelCatName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELCATNAME, (Object)pSSysDynaModelBase.getPSSysDynaModelCatName());
        }
        if (pSSysDynaModelBase.isPSSysDynaModelIdDirty() && (bl || pSSysDynaModelBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        }
        if (pSSysDynaModelBase.isPSSysDynaModelNameDirty() && (bl || pSSysDynaModelBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysDynaModelBase.getPSSysDynaModelName());
        }
        if (pSSysDynaModelBase.isPSSystemIdDirty() && (bl || pSSysDynaModelBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDynaModelBase.getPSSystemId());
        }
        if (pSSysDynaModelBase.isPSSystemNameDirty() && (bl || pSSysDynaModelBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDynaModelBase.getPSSystemName());
        }
        if (pSSysDynaModelBase.isUpdateDateDirty() && (bl || pSSysDynaModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDynaModelBase.getUpdateDate());
        }
        if (pSSysDynaModelBase.isUpdateManDirty() && (bl || pSSysDynaModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDynaModelBase.getUpdateMan());
        }
        if (pSSysDynaModelBase.isUserCatDirty() && (bl || pSSysDynaModelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDynaModelBase.getUserCat());
        }
        if (pSSysDynaModelBase.isUserTagDirty() && (bl || pSSysDynaModelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDynaModelBase.getUserTag());
        }
        if (pSSysDynaModelBase.isUserTag2Dirty() && (bl || pSSysDynaModelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDynaModelBase.getUserTag2());
        }
        if (pSSysDynaModelBase.isUserTag3Dirty() && (bl || pSSysDynaModelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDynaModelBase.getUserTag3());
        }
        if (pSSysDynaModelBase.isUserTag4Dirty() && (bl || pSSysDynaModelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDynaModelBase.getUserTag4());
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
        return PSSysDynaModelBase.remove(this, n);
    }

    private static boolean remove(PSSysDynaModelBase pSSysDynaModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDynaModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysDynaModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDynaModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDynaModelBase.resetDefaultFlag();
                return true;
            }
            case 4: {
                pSSysDynaModelBase.resetDTOCodeName();
                return true;
            }
            case 5: {
                pSSysDynaModelBase.resetDynaModel();
                return true;
            }
            case 6: {
                pSSysDynaModelBase.resetDynaModel2();
                return true;
            }
            case 7: {
                pSSysDynaModelBase.resetDynaModelFmt();
                return true;
            }
            case 8: {
                pSSysDynaModelBase.resetDynaModelUsage();
                return true;
            }
            case 9: {
                pSSysDynaModelBase.resetLockFlag();
                return true;
            }
            case 10: {
                pSSysDynaModelBase.resetLogicName();
                return true;
            }
            case 11: {
                pSSysDynaModelBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysDynaModelBase.resetModelTag();
                return true;
            }
            case 13: {
                pSSysDynaModelBase.resetModelTag2();
                return true;
            }
            case 14: {
                pSSysDynaModelBase.resetModelTag3();
                return true;
            }
            case 15: {
                pSSysDynaModelBase.resetModelTag4();
                return true;
            }
            case 16: {
                pSSysDynaModelBase.resetPPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSysDynaModelBase.resetPPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSysDynaModelBase.resetPSModuleId();
                return true;
            }
            case 19: {
                pSSysDynaModelBase.resetPSModuleName();
                return true;
            }
            case 20: {
                pSSysDynaModelBase.resetPSSysDynaModelCatId();
                return true;
            }
            case 21: {
                pSSysDynaModelBase.resetPSSysDynaModelCatName();
                return true;
            }
            case 22: {
                pSSysDynaModelBase.resetPSSysDynaModelId();
                return true;
            }
            case 23: {
                pSSysDynaModelBase.resetPSSysDynaModelName();
                return true;
            }
            case 24: {
                pSSysDynaModelBase.resetPSSystemId();
                return true;
            }
            case 25: {
                pSSysDynaModelBase.resetPSSystemName();
                return true;
            }
            case 26: {
                pSSysDynaModelBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSSysDynaModelBase.resetUpdateMan();
                return true;
            }
            case 28: {
                pSSysDynaModelBase.resetUserCat();
                return true;
            }
            case 29: {
                pSSysDynaModelBase.resetUserTag();
                return true;
            }
            case 30: {
                pSSysDynaModelBase.resetUserTag2();
                return true;
            }
            case 31: {
                pSSysDynaModelBase.resetUserTag3();
                return true;
            }
            case 32: {
                pSSysDynaModelBase.resetUserTag4();
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
    public PSSysDynaModelCat getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelCatId(), (Object)this.pssysdynamodel.getPSSysDynaModelCatId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModelCat pSSysDynaModelCat = new PSSysDynaModelCat();
                pSSysDynaModelCat.setPSSysDynaModelCatId(this.getPSSysDynaModelCatId());
                PSSysDynaModelCatService pSSysDynaModelCatService = (PSSysDynaModelCatService)ServiceGlobal.getService(PSSysDynaModelCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelCatService.autoGet(pSSysDynaModelCat);
                this.pssysdynamodel = pSSysDynaModelCat;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDynaModel();
        }
        if (this.getPPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPPSSysDynaModelLock;
        synchronized (n) {
            if (this.ppssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysDynaModelId(), (Object)this.ppssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.ppssysdynamodel = null;
            }
            if (this.ppssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.ppssysdynamodel = pSSysDynaModel;
            }
            return this.ppssysdynamodel;
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
    public ArrayList<PSSysDynaModelAttr> getPSSysDynaModelAttrs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelAttrs();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        PSSysDynaModelAttrService pSSysDynaModelAttrService = (PSSysDynaModelAttrService)ServiceGlobal.getService(PSSysDynaModelAttrService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDynaModelAttrsLock;
        synchronized (n) {
            if (this.pssysdynamodelattrs == null) {
                this.pssysdynamodelattrs = pSSysDynaModelAttrService.selectByPSSysDynaModel(this);
            }
            return this.pssysdynamodelattrs;
        }
    }

    private PSSysDynaModelBase getProxyEntity() {
        return this.proxyPSSysDynaModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDynaModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDynaModelBase) {
            this.proxyPSSysDynaModelBase = (PSSysDynaModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 3);
        fieldIndexMap.put(FIELD_DTOCODENAME, 4);
        fieldIndexMap.put(FIELD_DYNAMODEL, 5);
        fieldIndexMap.put(FIELD_DYNAMODEL2, 6);
        fieldIndexMap.put(FIELD_DYNAMODELFMT, 7);
        fieldIndexMap.put(FIELD_DYNAMODELUSAGE, 8);
        fieldIndexMap.put(FIELD_LOCKFLAG, 9);
        fieldIndexMap.put(FIELD_LOGICNAME, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_MODELTAG, 12);
        fieldIndexMap.put(FIELD_MODELTAG2, 13);
        fieldIndexMap.put(FIELD_MODELTAG3, 14);
        fieldIndexMap.put(FIELD_MODELTAG4, 15);
        fieldIndexMap.put(FIELD_PPSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PPSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSMODULEID, 18);
        fieldIndexMap.put(FIELD_PSMODULENAME, 19);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELCATID, 20);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELCATNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 22);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
        fieldIndexMap.put(FIELD_USERCAT, 28);
        fieldIndexMap.put(FIELD_USERTAG, 29);
        fieldIndexMap.put(FIELD_USERTAG2, 30);
        fieldIndexMap.put(FIELD_USERTAG3, 31);
        fieldIndexMap.put(FIELD_USERTAG4, 32);
    }
}

