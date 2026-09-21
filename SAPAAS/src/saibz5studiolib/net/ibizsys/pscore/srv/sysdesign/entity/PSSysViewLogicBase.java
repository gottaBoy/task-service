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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewLogicBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMSTYLE = "CUSTOMSTYLE";
    public static final String FIELD_LOGICMODEL = "LOGICMODEL";
    public static final String FIELD_LOGICPSDEID = "LOGICPSDEID";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String FIELD_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String FIELD_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String FIELD_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String FIELD_SYSAPPFLAG = "SYSAPPFLAG";
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
    private static final int INDEX_CUSTOMSTYLE = 3;
    private static final int INDEX_LOGICMODEL = 4;
    private static final int INDEX_LOGICPSDEID = 5;
    private static final int INDEX_LOGICTYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDELOGICID = 9;
    private static final int INDEX_PSDELOGICNAME = 10;
    private static final int INDEX_PSDENAME = 11;
    private static final int INDEX_PSMODULEID = 12;
    private static final int INDEX_PSMODULENAME = 13;
    private static final int INDEX_PSSYSAPPID = 14;
    private static final int INDEX_PSSYSAPPNAME = 15;
    private static final int INDEX_PSSYSDYNAMODELID = 16;
    private static final int INDEX_PSSYSDYNAMODELNAME = 17;
    private static final int INDEX_PSSYSPFPLUGINID = 18;
    private static final int INDEX_PSSYSPFPLUGINNAME = 19;
    private static final int INDEX_PSSYSREQITEMID = 20;
    private static final int INDEX_PSSYSREQITEMNAME = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_PSSYSTEMNAME = 23;
    private static final int INDEX_PSSYSVIEWLOGICID = 24;
    private static final int INDEX_PSSYSVIEWLOGICNAME = 25;
    private static final int INDEX_PSVIEWLOGICTYPEID = 26;
    private static final int INDEX_PSVIEWLOGICTYPENAME = 27;
    private static final int INDEX_SYSAPPFLAG = 28;
    private static final int INDEX_UPDATEDATE = 29;
    private static final int INDEX_UPDATEMAN = 30;
    private static final int INDEX_USERCAT = 31;
    private static final int INDEX_USERTAG = 32;
    private static final int INDEX_USERTAG2 = 33;
    private static final int INDEX_USERTAG3 = 34;
    private static final int INDEX_USERTAG4 = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewLogicBase proxyPSSysViewLogicBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customstyleDirtyFlag = false;
    private boolean logicmodelDirtyFlag = false;
    private boolean logicpsdeidDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysviewlogicidDirtyFlag = false;
    private boolean pssysviewlogicnameDirtyFlag = false;
    private boolean psviewlogictypeidDirtyFlag = false;
    private boolean psviewlogictypenameDirtyFlag = false;
    private boolean sysappflagDirtyFlag = false;
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
    @Column(name="customstyle")
    private String customstyle;
    @Column(name="logicmodel")
    private String logicmodel;
    @Column(name="logicpsdeid")
    private String logicpsdeid;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysviewlogicid")
    private String pssysviewlogicid;
    @Column(name="pssysviewlogicname")
    private String pssysviewlogicname;
    @Column(name="psviewlogictypeid")
    private String psviewlogictypeid;
    @Column(name="psviewlogictypename")
    private String psviewlogictypename;
    @Column(name="sysappflag")
    private Integer sysappflag;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSViewLogicTypeLock = new Integer(1);
    private PSViewLogicType psviewlogictype = null;
    private Integer objPSSysViewLogicParamsLock = new Integer(1);
    private ArrayList<PSSysViewLogicParam> pssysviewlogicparams = null;

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

    public void setCustomStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customstyle = string;
        this.customstyleDirtyFlag = true;
    }

    public String getCustomStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomStyle();
        }
        return this.customstyle;
    }

    public boolean isCustomStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomStyleDirty();
        }
        return this.customstyleDirtyFlag;
    }

    public void resetCustomStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomStyle();
            return;
        }
        this.customstyleDirtyFlag = false;
        this.customstyle = null;
    }

    public void setLogicModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicmodel = string;
        this.logicmodelDirtyFlag = true;
    }

    public String getLogicModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicModel();
        }
        return this.logicmodel;
    }

    public boolean isLogicModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicModelDirty();
        }
        return this.logicmodelDirtyFlag;
    }

    public void resetLogicModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicModel();
            return;
        }
        this.logicmodelDirtyFlag = false;
        this.logicmodel = null;
    }

    public void setLogicPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicpsdeid = string;
        this.logicpsdeidDirtyFlag = true;
    }

    public String getLogicPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicPSDEId();
        }
        return this.logicpsdeid;
    }

    public boolean isLogicPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicPSDEIdDirty();
        }
        return this.logicpsdeidDirtyFlag;
    }

    public void resetLogicPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicPSDEId();
            return;
        }
        this.logicpsdeidDirtyFlag = false;
        this.logicpsdeid = null;
    }

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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

    public void setPSSysViewLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicid = string;
        this.pssysviewlogicidDirtyFlag = true;
    }

    public String getPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicId();
        }
        return this.pssysviewlogicid;
    }

    public boolean isPSSysViewLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicIdDirty();
        }
        return this.pssysviewlogicidDirtyFlag;
    }

    public void resetPSSysViewLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicId();
            return;
        }
        this.pssysviewlogicidDirtyFlag = false;
        this.pssysviewlogicid = null;
    }

    public void setPSSysViewLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewlogicname = string;
        this.pssysviewlogicnameDirtyFlag = true;
    }

    public String getPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicName();
        }
        return this.pssysviewlogicname;
    }

    public boolean isPSSysViewLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewLogicNameDirty();
        }
        return this.pssysviewlogicnameDirtyFlag;
    }

    public void resetPSSysViewLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewLogicName();
            return;
        }
        this.pssysviewlogicnameDirtyFlag = false;
        this.pssysviewlogicname = null;
    }

    public void setPSViewLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeid = string;
        this.psviewlogictypeidDirtyFlag = true;
    }

    public String getPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeId();
        }
        return this.psviewlogictypeid;
    }

    public boolean isPSViewLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeIdDirty();
        }
        return this.psviewlogictypeidDirtyFlag;
    }

    public void resetPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeId();
            return;
        }
        this.psviewlogictypeidDirtyFlag = false;
        this.psviewlogictypeid = null;
    }

    public void setPSViewLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypename = string;
        this.psviewlogictypenameDirtyFlag = true;
    }

    public String getPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeName();
        }
        return this.psviewlogictypename;
    }

    public boolean isPSViewLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeNameDirty();
        }
        return this.psviewlogictypenameDirtyFlag;
    }

    public void resetPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeName();
            return;
        }
        this.psviewlogictypenameDirtyFlag = false;
        this.psviewlogictypename = null;
    }

    public void setSysAppFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAppFlag(n);
            return;
        }
        this.sysappflag = n;
        this.sysappflagDirtyFlag = true;
    }

    public Integer getSysAppFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAppFlag();
        }
        return this.sysappflag;
    }

    public boolean isSysAppFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAppFlagDirty();
        }
        return this.sysappflagDirtyFlag;
    }

    public void resetSysAppFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAppFlag();
            return;
        }
        this.sysappflagDirtyFlag = false;
        this.sysappflag = null;
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
        PSSysViewLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewLogicBase pSSysViewLogicBase) {
        pSSysViewLogicBase.resetCodeName();
        pSSysViewLogicBase.resetCreateDate();
        pSSysViewLogicBase.resetCreateMan();
        pSSysViewLogicBase.resetCustomStyle();
        pSSysViewLogicBase.resetLogicModel();
        pSSysViewLogicBase.resetLogicPSDEId();
        pSSysViewLogicBase.resetLogicType();
        pSSysViewLogicBase.resetMemo();
        pSSysViewLogicBase.resetPSDEId();
        pSSysViewLogicBase.resetPSDELogicId();
        pSSysViewLogicBase.resetPSDELogicName();
        pSSysViewLogicBase.resetPSDEName();
        pSSysViewLogicBase.resetPSModuleId();
        pSSysViewLogicBase.resetPSModuleName();
        pSSysViewLogicBase.resetPSSysAppId();
        pSSysViewLogicBase.resetPSSysAppName();
        pSSysViewLogicBase.resetPSSysDynaModelId();
        pSSysViewLogicBase.resetPSSysDynaModelName();
        pSSysViewLogicBase.resetPSSysPFPluginId();
        pSSysViewLogicBase.resetPSSysPFPluginName();
        pSSysViewLogicBase.resetPSSysReqItemId();
        pSSysViewLogicBase.resetPSSysReqItemName();
        pSSysViewLogicBase.resetPSSystemId();
        pSSysViewLogicBase.resetPSSystemName();
        pSSysViewLogicBase.resetPSSysViewLogicId();
        pSSysViewLogicBase.resetPSSysViewLogicName();
        pSSysViewLogicBase.resetPSViewLogicTypeId();
        pSSysViewLogicBase.resetPSViewLogicTypeName();
        pSSysViewLogicBase.resetSysAppFlag();
        pSSysViewLogicBase.resetUpdateDate();
        pSSysViewLogicBase.resetUpdateMan();
        pSSysViewLogicBase.resetUserCat();
        pSSysViewLogicBase.resetUserTag();
        pSSysViewLogicBase.resetUserTag2();
        pSSysViewLogicBase.resetUserTag3();
        pSSysViewLogicBase.resetUserTag4();
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
        if (!bl || this.isCustomStyleDirty()) {
            hashMap.put(FIELD_CUSTOMSTYLE, this.getCustomStyle());
        }
        if (!bl || this.isLogicModelDirty()) {
            hashMap.put(FIELD_LOGICMODEL, this.getLogicModel());
        }
        if (!bl || this.isLogicPSDEIdDirty()) {
            hashMap.put(FIELD_LOGICPSDEID, this.getLogicPSDEId());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
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
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysViewLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICID, this.getPSSysViewLogicId());
        }
        if (!bl || this.isPSSysViewLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWLOGICNAME, this.getPSSysViewLogicName());
        }
        if (!bl || this.isPSViewLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEID, this.getPSViewLogicTypeId());
        }
        if (!bl || this.isPSViewLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPENAME, this.getPSViewLogicTypeName());
        }
        if (!bl || this.isSysAppFlagDirty()) {
            hashMap.put(FIELD_SYSAPPFLAG, this.getSysAppFlag());
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
        return PSSysViewLogicBase.get(this, n);
    }

    private static Object get(PSSysViewLogicBase pSSysViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicBase.getCodeName();
            }
            case 1: {
                return pSSysViewLogicBase.getCreateDate();
            }
            case 2: {
                return pSSysViewLogicBase.getCreateMan();
            }
            case 3: {
                return pSSysViewLogicBase.getCustomStyle();
            }
            case 4: {
                return pSSysViewLogicBase.getLogicModel();
            }
            case 5: {
                return pSSysViewLogicBase.getLogicPSDEId();
            }
            case 6: {
                return pSSysViewLogicBase.getLogicType();
            }
            case 7: {
                return pSSysViewLogicBase.getMemo();
            }
            case 8: {
                return pSSysViewLogicBase.getPSDEId();
            }
            case 9: {
                return pSSysViewLogicBase.getPSDELogicId();
            }
            case 10: {
                return pSSysViewLogicBase.getPSDELogicName();
            }
            case 11: {
                return pSSysViewLogicBase.getPSDEName();
            }
            case 12: {
                return pSSysViewLogicBase.getPSModuleId();
            }
            case 13: {
                return pSSysViewLogicBase.getPSModuleName();
            }
            case 14: {
                return pSSysViewLogicBase.getPSSysAppId();
            }
            case 15: {
                return pSSysViewLogicBase.getPSSysAppName();
            }
            case 16: {
                return pSSysViewLogicBase.getPSSysDynaModelId();
            }
            case 17: {
                return pSSysViewLogicBase.getPSSysDynaModelName();
            }
            case 18: {
                return pSSysViewLogicBase.getPSSysPFPluginId();
            }
            case 19: {
                return pSSysViewLogicBase.getPSSysPFPluginName();
            }
            case 20: {
                return pSSysViewLogicBase.getPSSysReqItemId();
            }
            case 21: {
                return pSSysViewLogicBase.getPSSysReqItemName();
            }
            case 22: {
                return pSSysViewLogicBase.getPSSystemId();
            }
            case 23: {
                return pSSysViewLogicBase.getPSSystemName();
            }
            case 24: {
                return pSSysViewLogicBase.getPSSysViewLogicId();
            }
            case 25: {
                return pSSysViewLogicBase.getPSSysViewLogicName();
            }
            case 26: {
                return pSSysViewLogicBase.getPSViewLogicTypeId();
            }
            case 27: {
                return pSSysViewLogicBase.getPSViewLogicTypeName();
            }
            case 28: {
                return pSSysViewLogicBase.getSysAppFlag();
            }
            case 29: {
                return pSSysViewLogicBase.getUpdateDate();
            }
            case 30: {
                return pSSysViewLogicBase.getUpdateMan();
            }
            case 31: {
                return pSSysViewLogicBase.getUserCat();
            }
            case 32: {
                return pSSysViewLogicBase.getUserTag();
            }
            case 33: {
                return pSSysViewLogicBase.getUserTag2();
            }
            case 34: {
                return pSSysViewLogicBase.getUserTag3();
            }
            case 35: {
                return pSSysViewLogicBase.getUserTag4();
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
        PSSysViewLogicBase.set(this, n, object);
    }

    private static void set(PSSysViewLogicBase pSSysViewLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewLogicBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewLogicBase.setCustomStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewLogicBase.setLogicModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewLogicBase.setLogicPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewLogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewLogicBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewLogicBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewLogicBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewLogicBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewLogicBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewLogicBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewLogicBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewLogicBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewLogicBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewLogicBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewLogicBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewLogicBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewLogicBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewLogicBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewLogicBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewLogicBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewLogicBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewLogicBase.setPSSysViewLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewLogicBase.setPSSysViewLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewLogicBase.setPSViewLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewLogicBase.setPSViewLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewLogicBase.setSysAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysViewLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 30: {
                pSSysViewLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysViewLogicBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysViewLogicBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysViewLogicBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysViewLogicBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysViewLogicBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysViewLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewLogicBase pSSysViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicBase.getCodeName() == null;
            }
            case 1: {
                return pSSysViewLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysViewLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysViewLogicBase.getCustomStyle() == null;
            }
            case 4: {
                return pSSysViewLogicBase.getLogicModel() == null;
            }
            case 5: {
                return pSSysViewLogicBase.getLogicPSDEId() == null;
            }
            case 6: {
                return pSSysViewLogicBase.getLogicType() == null;
            }
            case 7: {
                return pSSysViewLogicBase.getMemo() == null;
            }
            case 8: {
                return pSSysViewLogicBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysViewLogicBase.getPSDELogicId() == null;
            }
            case 10: {
                return pSSysViewLogicBase.getPSDELogicName() == null;
            }
            case 11: {
                return pSSysViewLogicBase.getPSDEName() == null;
            }
            case 12: {
                return pSSysViewLogicBase.getPSModuleId() == null;
            }
            case 13: {
                return pSSysViewLogicBase.getPSModuleName() == null;
            }
            case 14: {
                return pSSysViewLogicBase.getPSSysAppId() == null;
            }
            case 15: {
                return pSSysViewLogicBase.getPSSysAppName() == null;
            }
            case 16: {
                return pSSysViewLogicBase.getPSSysDynaModelId() == null;
            }
            case 17: {
                return pSSysViewLogicBase.getPSSysDynaModelName() == null;
            }
            case 18: {
                return pSSysViewLogicBase.getPSSysPFPluginId() == null;
            }
            case 19: {
                return pSSysViewLogicBase.getPSSysPFPluginName() == null;
            }
            case 20: {
                return pSSysViewLogicBase.getPSSysReqItemId() == null;
            }
            case 21: {
                return pSSysViewLogicBase.getPSSysReqItemName() == null;
            }
            case 22: {
                return pSSysViewLogicBase.getPSSystemId() == null;
            }
            case 23: {
                return pSSysViewLogicBase.getPSSystemName() == null;
            }
            case 24: {
                return pSSysViewLogicBase.getPSSysViewLogicId() == null;
            }
            case 25: {
                return pSSysViewLogicBase.getPSSysViewLogicName() == null;
            }
            case 26: {
                return pSSysViewLogicBase.getPSViewLogicTypeId() == null;
            }
            case 27: {
                return pSSysViewLogicBase.getPSViewLogicTypeName() == null;
            }
            case 28: {
                return pSSysViewLogicBase.getSysAppFlag() == null;
            }
            case 29: {
                return pSSysViewLogicBase.getUpdateDate() == null;
            }
            case 30: {
                return pSSysViewLogicBase.getUpdateMan() == null;
            }
            case 31: {
                return pSSysViewLogicBase.getUserCat() == null;
            }
            case 32: {
                return pSSysViewLogicBase.getUserTag() == null;
            }
            case 33: {
                return pSSysViewLogicBase.getUserTag2() == null;
            }
            case 34: {
                return pSSysViewLogicBase.getUserTag3() == null;
            }
            case 35: {
                return pSSysViewLogicBase.getUserTag4() == null;
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
        return PSSysViewLogicBase.contains(this, n);
    }

    private static boolean contains(PSSysViewLogicBase pSSysViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewLogicBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysViewLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysViewLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSSysViewLogicBase.isCustomStyleDirty();
            }
            case 4: {
                return pSSysViewLogicBase.isLogicModelDirty();
            }
            case 5: {
                return pSSysViewLogicBase.isLogicPSDEIdDirty();
            }
            case 6: {
                return pSSysViewLogicBase.isLogicTypeDirty();
            }
            case 7: {
                return pSSysViewLogicBase.isMemoDirty();
            }
            case 8: {
                return pSSysViewLogicBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysViewLogicBase.isPSDELogicIdDirty();
            }
            case 10: {
                return pSSysViewLogicBase.isPSDELogicNameDirty();
            }
            case 11: {
                return pSSysViewLogicBase.isPSDENameDirty();
            }
            case 12: {
                return pSSysViewLogicBase.isPSModuleIdDirty();
            }
            case 13: {
                return pSSysViewLogicBase.isPSModuleNameDirty();
            }
            case 14: {
                return pSSysViewLogicBase.isPSSysAppIdDirty();
            }
            case 15: {
                return pSSysViewLogicBase.isPSSysAppNameDirty();
            }
            case 16: {
                return pSSysViewLogicBase.isPSSysDynaModelIdDirty();
            }
            case 17: {
                return pSSysViewLogicBase.isPSSysDynaModelNameDirty();
            }
            case 18: {
                return pSSysViewLogicBase.isPSSysPFPluginIdDirty();
            }
            case 19: {
                return pSSysViewLogicBase.isPSSysPFPluginNameDirty();
            }
            case 20: {
                return pSSysViewLogicBase.isPSSysReqItemIdDirty();
            }
            case 21: {
                return pSSysViewLogicBase.isPSSysReqItemNameDirty();
            }
            case 22: {
                return pSSysViewLogicBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSSysViewLogicBase.isPSSystemNameDirty();
            }
            case 24: {
                return pSSysViewLogicBase.isPSSysViewLogicIdDirty();
            }
            case 25: {
                return pSSysViewLogicBase.isPSSysViewLogicNameDirty();
            }
            case 26: {
                return pSSysViewLogicBase.isPSViewLogicTypeIdDirty();
            }
            case 27: {
                return pSSysViewLogicBase.isPSViewLogicTypeNameDirty();
            }
            case 28: {
                return pSSysViewLogicBase.isSysAppFlagDirty();
            }
            case 29: {
                return pSSysViewLogicBase.isUpdateDateDirty();
            }
            case 30: {
                return pSSysViewLogicBase.isUpdateManDirty();
            }
            case 31: {
                return pSSysViewLogicBase.isUserCatDirty();
            }
            case 32: {
                return pSSysViewLogicBase.isUserTagDirty();
            }
            case 33: {
                return pSSysViewLogicBase.isUserTag2Dirty();
            }
            case 34: {
                return pSSysViewLogicBase.isUserTag3Dirty();
            }
            case 35: {
                return pSSysViewLogicBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewLogicBase pSSysViewLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewLogicBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getCustomStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customstyle", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getCustomStyle()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getLogicModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicmodel", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getLogicModel()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getLogicPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicpsdeid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getLogicPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysViewLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysViewLogicId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSSysViewLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewlogicname", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSSysViewLogicName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSViewLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeid", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSViewLogicTypeId()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getPSViewLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypename", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getPSViewLogicTypeName()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getSysAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappflag", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getSysAppFlag()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysViewLogicBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysViewLogicBase.getJSONValue((Object)pSSysViewLogicBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewLogicBase pSSysViewLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewLogicBase.getCodeName() != null) {
            object = pSSysViewLogicBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getCreateDate() != null) {
            object = pSSysViewLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewLogicBase.getCreateMan() != null) {
            object = pSSysViewLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getCustomStyle() != null) {
            object = pSSysViewLogicBase.getCustomStyle();
            xmlNode.setAttribute(FIELD_CUSTOMSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getLogicModel() != null) {
            object = pSSysViewLogicBase.getLogicModel();
            xmlNode.setAttribute(FIELD_LOGICMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getLogicPSDEId() != null) {
            object = pSSysViewLogicBase.getLogicPSDEId();
            xmlNode.setAttribute(FIELD_LOGICPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getLogicType() != null) {
            object = pSSysViewLogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getMemo() != null) {
            object = pSSysViewLogicBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSDEId() != null) {
            object = pSSysViewLogicBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSDELogicId() != null) {
            object = pSSysViewLogicBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSDELogicName() != null) {
            object = pSSysViewLogicBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSDEName() != null) {
            object = pSSysViewLogicBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSModuleId() != null) {
            object = pSSysViewLogicBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSModuleName() != null) {
            object = pSSysViewLogicBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysAppId() != null) {
            object = pSSysViewLogicBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysAppName() != null) {
            object = pSSysViewLogicBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysDynaModelId() != null) {
            object = pSSysViewLogicBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysDynaModelName() != null) {
            object = pSSysViewLogicBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysPFPluginId() != null) {
            object = pSSysViewLogicBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysPFPluginName() != null) {
            object = pSSysViewLogicBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysReqItemId() != null) {
            object = pSSysViewLogicBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysReqItemName() != null) {
            object = pSSysViewLogicBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSystemId() != null) {
            object = pSSysViewLogicBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSystemName() != null) {
            object = pSSysViewLogicBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysViewLogicId() != null) {
            object = pSSysViewLogicBase.getPSSysViewLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSSysViewLogicName() != null) {
            object = pSSysViewLogicBase.getPSSysViewLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSViewLogicTypeId() != null) {
            object = pSSysViewLogicBase.getPSViewLogicTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getPSViewLogicTypeName() != null) {
            object = pSSysViewLogicBase.getPSViewLogicTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getSysAppFlag() != null) {
            object = pSSysViewLogicBase.getSysAppFlag();
            xmlNode.setAttribute(FIELD_SYSAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewLogicBase.getUpdateDate() != null) {
            object = pSSysViewLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewLogicBase.getUpdateMan() != null) {
            object = pSSysViewLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getUserCat() != null) {
            object = pSSysViewLogicBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getUserTag() != null) {
            object = pSSysViewLogicBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getUserTag2() != null) {
            object = pSSysViewLogicBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getUserTag3() != null) {
            object = pSSysViewLogicBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewLogicBase.getUserTag4() != null) {
            object = pSSysViewLogicBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewLogicBase pSSysViewLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewLogicBase.isCodeNameDirty() && (bl || pSSysViewLogicBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysViewLogicBase.getCodeName());
        }
        if (pSSysViewLogicBase.isCreateDateDirty() && (bl || pSSysViewLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewLogicBase.getCreateDate());
        }
        if (pSSysViewLogicBase.isCreateManDirty() && (bl || pSSysViewLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewLogicBase.getCreateMan());
        }
        if (pSSysViewLogicBase.isCustomStyleDirty() && (bl || pSSysViewLogicBase.getCustomStyle() != null)) {
            iDataObject.set(FIELD_CUSTOMSTYLE, (Object)pSSysViewLogicBase.getCustomStyle());
        }
        if (pSSysViewLogicBase.isLogicModelDirty() && (bl || pSSysViewLogicBase.getLogicModel() != null)) {
            iDataObject.set(FIELD_LOGICMODEL, (Object)pSSysViewLogicBase.getLogicModel());
        }
        if (pSSysViewLogicBase.isLogicPSDEIdDirty() && (bl || pSSysViewLogicBase.getLogicPSDEId() != null)) {
            iDataObject.set(FIELD_LOGICPSDEID, (Object)pSSysViewLogicBase.getLogicPSDEId());
        }
        if (pSSysViewLogicBase.isLogicTypeDirty() && (bl || pSSysViewLogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSSysViewLogicBase.getLogicType());
        }
        if (pSSysViewLogicBase.isMemoDirty() && (bl || pSSysViewLogicBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewLogicBase.getMemo());
        }
        if (pSSysViewLogicBase.isPSDEIdDirty() && (bl || pSSysViewLogicBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysViewLogicBase.getPSDEId());
        }
        if (pSSysViewLogicBase.isPSDELogicIdDirty() && (bl || pSSysViewLogicBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSSysViewLogicBase.getPSDELogicId());
        }
        if (pSSysViewLogicBase.isPSDELogicNameDirty() && (bl || pSSysViewLogicBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSSysViewLogicBase.getPSDELogicName());
        }
        if (pSSysViewLogicBase.isPSDENameDirty() && (bl || pSSysViewLogicBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysViewLogicBase.getPSDEName());
        }
        if (pSSysViewLogicBase.isPSModuleIdDirty() && (bl || pSSysViewLogicBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysViewLogicBase.getPSModuleId());
        }
        if (pSSysViewLogicBase.isPSModuleNameDirty() && (bl || pSSysViewLogicBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysViewLogicBase.getPSModuleName());
        }
        if (pSSysViewLogicBase.isPSSysAppIdDirty() && (bl || pSSysViewLogicBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysViewLogicBase.getPSSysAppId());
        }
        if (pSSysViewLogicBase.isPSSysAppNameDirty() && (bl || pSSysViewLogicBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysViewLogicBase.getPSSysAppName());
        }
        if (pSSysViewLogicBase.isPSSysDynaModelIdDirty() && (bl || pSSysViewLogicBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysViewLogicBase.getPSSysDynaModelId());
        }
        if (pSSysViewLogicBase.isPSSysDynaModelNameDirty() && (bl || pSSysViewLogicBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysViewLogicBase.getPSSysDynaModelName());
        }
        if (pSSysViewLogicBase.isPSSysPFPluginIdDirty() && (bl || pSSysViewLogicBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysViewLogicBase.getPSSysPFPluginId());
        }
        if (pSSysViewLogicBase.isPSSysPFPluginNameDirty() && (bl || pSSysViewLogicBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysViewLogicBase.getPSSysPFPluginName());
        }
        if (pSSysViewLogicBase.isPSSysReqItemIdDirty() && (bl || pSSysViewLogicBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSSysViewLogicBase.getPSSysReqItemId());
        }
        if (pSSysViewLogicBase.isPSSysReqItemNameDirty() && (bl || pSSysViewLogicBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSSysViewLogicBase.getPSSysReqItemName());
        }
        if (pSSysViewLogicBase.isPSSystemIdDirty() && (bl || pSSysViewLogicBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysViewLogicBase.getPSSystemId());
        }
        if (pSSysViewLogicBase.isPSSystemNameDirty() && (bl || pSSysViewLogicBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysViewLogicBase.getPSSystemName());
        }
        if (pSSysViewLogicBase.isPSSysViewLogicIdDirty() && (bl || pSSysViewLogicBase.getPSSysViewLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICID, (Object)pSSysViewLogicBase.getPSSysViewLogicId());
        }
        if (pSSysViewLogicBase.isPSSysViewLogicNameDirty() && (bl || pSSysViewLogicBase.getPSSysViewLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWLOGICNAME, (Object)pSSysViewLogicBase.getPSSysViewLogicName());
        }
        if (pSSysViewLogicBase.isPSViewLogicTypeIdDirty() && (bl || pSSysViewLogicBase.getPSViewLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEID, (Object)pSSysViewLogicBase.getPSViewLogicTypeId());
        }
        if (pSSysViewLogicBase.isPSViewLogicTypeNameDirty() && (bl || pSSysViewLogicBase.getPSViewLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPENAME, (Object)pSSysViewLogicBase.getPSViewLogicTypeName());
        }
        if (pSSysViewLogicBase.isSysAppFlagDirty() && (bl || pSSysViewLogicBase.getSysAppFlag() != null)) {
            iDataObject.set(FIELD_SYSAPPFLAG, (Object)pSSysViewLogicBase.getSysAppFlag());
        }
        if (pSSysViewLogicBase.isUpdateDateDirty() && (bl || pSSysViewLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewLogicBase.getUpdateDate());
        }
        if (pSSysViewLogicBase.isUpdateManDirty() && (bl || pSSysViewLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewLogicBase.getUpdateMan());
        }
        if (pSSysViewLogicBase.isUserCatDirty() && (bl || pSSysViewLogicBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysViewLogicBase.getUserCat());
        }
        if (pSSysViewLogicBase.isUserTagDirty() && (bl || pSSysViewLogicBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysViewLogicBase.getUserTag());
        }
        if (pSSysViewLogicBase.isUserTag2Dirty() && (bl || pSSysViewLogicBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysViewLogicBase.getUserTag2());
        }
        if (pSSysViewLogicBase.isUserTag3Dirty() && (bl || pSSysViewLogicBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysViewLogicBase.getUserTag3());
        }
        if (pSSysViewLogicBase.isUserTag4Dirty() && (bl || pSSysViewLogicBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysViewLogicBase.getUserTag4());
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
        return PSSysViewLogicBase.remove(this, n);
    }

    private static boolean remove(PSSysViewLogicBase pSSysViewLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewLogicBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysViewLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysViewLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysViewLogicBase.resetCustomStyle();
                return true;
            }
            case 4: {
                pSSysViewLogicBase.resetLogicModel();
                return true;
            }
            case 5: {
                pSSysViewLogicBase.resetLogicPSDEId();
                return true;
            }
            case 6: {
                pSSysViewLogicBase.resetLogicType();
                return true;
            }
            case 7: {
                pSSysViewLogicBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysViewLogicBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysViewLogicBase.resetPSDELogicId();
                return true;
            }
            case 10: {
                pSSysViewLogicBase.resetPSDELogicName();
                return true;
            }
            case 11: {
                pSSysViewLogicBase.resetPSDEName();
                return true;
            }
            case 12: {
                pSSysViewLogicBase.resetPSModuleId();
                return true;
            }
            case 13: {
                pSSysViewLogicBase.resetPSModuleName();
                return true;
            }
            case 14: {
                pSSysViewLogicBase.resetPSSysAppId();
                return true;
            }
            case 15: {
                pSSysViewLogicBase.resetPSSysAppName();
                return true;
            }
            case 16: {
                pSSysViewLogicBase.resetPSSysDynaModelId();
                return true;
            }
            case 17: {
                pSSysViewLogicBase.resetPSSysDynaModelName();
                return true;
            }
            case 18: {
                pSSysViewLogicBase.resetPSSysPFPluginId();
                return true;
            }
            case 19: {
                pSSysViewLogicBase.resetPSSysPFPluginName();
                return true;
            }
            case 20: {
                pSSysViewLogicBase.resetPSSysReqItemId();
                return true;
            }
            case 21: {
                pSSysViewLogicBase.resetPSSysReqItemName();
                return true;
            }
            case 22: {
                pSSysViewLogicBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSSysViewLogicBase.resetPSSystemName();
                return true;
            }
            case 24: {
                pSSysViewLogicBase.resetPSSysViewLogicId();
                return true;
            }
            case 25: {
                pSSysViewLogicBase.resetPSSysViewLogicName();
                return true;
            }
            case 26: {
                pSSysViewLogicBase.resetPSViewLogicTypeId();
                return true;
            }
            case 27: {
                pSSysViewLogicBase.resetPSViewLogicTypeName();
                return true;
            }
            case 28: {
                pSSysViewLogicBase.resetSysAppFlag();
                return true;
            }
            case 29: {
                pSSysViewLogicBase.resetUpdateDate();
                return true;
            }
            case 30: {
                pSSysViewLogicBase.resetUpdateMan();
                return true;
            }
            case 31: {
                pSSysViewLogicBase.resetUserCat();
                return true;
            }
            case 32: {
                pSSysViewLogicBase.resetUserTag();
                return true;
            }
            case 33: {
                pSSysViewLogicBase.resetUserTag2();
                return true;
            }
            case 34: {
                pSSysViewLogicBase.resetUserTag3();
                return true;
            }
            case 35: {
                pSSysViewLogicBase.resetUserTag4();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
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
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
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
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet((IEntity)pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewLogicType getPSViewLogicType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicType();
        }
        if (this.getPSViewLogicTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewLogicTypeLock;
        synchronized (n) {
            if (this.psviewlogictype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewLogicTypeId(), (Object)this.psviewlogictype.getPSViewLogicTypeId()) != 0L) {
                this.psviewlogictype = null;
            }
            if (this.psviewlogictype == null) {
                PSViewLogicType pSViewLogicType = new PSViewLogicType();
                pSViewLogicType.setPSViewLogicTypeId(this.getPSViewLogicTypeId());
                PSViewLogicTypeService pSViewLogicTypeService = (PSViewLogicTypeService)ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewLogicTypeService.autoGet((IEntity)pSViewLogicType);
                this.psviewlogictype = pSViewLogicType;
            }
            return this.psviewlogictype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysViewLogicParam> getPSSysViewLogicParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewLogicParams();
        }
        if (this.getPSSysViewLogicId() == null) {
            return null;
        }
        PSSysViewLogicService pSSysViewLogicService = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysViewLogicParamsLock;
        synchronized (n) {
            if (this.pssysviewlogicparams == null) {
                this.pssysviewlogicparams = pSSysViewLogicService.isTempData((IEntity)this) ? pSSysViewLogicParamService.selectTempByPSSysViewLogic(this) : pSSysViewLogicParamService.selectByPSSysViewLogic(this);
            }
            return this.pssysviewlogicparams;
        }
    }

    private PSSysViewLogicBase getProxyEntity() {
        return this.proxyPSSysViewLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewLogicBase) {
            this.proxyPSSysViewLogicBase = (PSSysViewLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMSTYLE, 3);
        fieldIndexMap.put(FIELD_LOGICMODEL, 4);
        fieldIndexMap.put(FIELD_LOGICPSDEID, 5);
        fieldIndexMap.put(FIELD_LOGICTYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDELOGICID, 9);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 10);
        fieldIndexMap.put(FIELD_PSDENAME, 11);
        fieldIndexMap.put(FIELD_PSMODULEID, 12);
        fieldIndexMap.put(FIELD_PSMODULENAME, 13);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 14);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 18);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 20);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICID, 24);
        fieldIndexMap.put(FIELD_PSSYSVIEWLOGICNAME, 25);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEID, 26);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPENAME, 27);
        fieldIndexMap.put(FIELD_SYSAPPFLAG, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 29);
        fieldIndexMap.put(FIELD_UPDATEMAN, 30);
        fieldIndexMap.put(FIELD_USERCAT, 31);
        fieldIndexMap.put(FIELD_USERTAG, 32);
        fieldIndexMap.put(FIELD_USERTAG2, 33);
        fieldIndexMap.put(FIELD_USERTAG3, 34);
        fieldIndexMap.put(FIELD_USERTAG4, 35);
    }
}

