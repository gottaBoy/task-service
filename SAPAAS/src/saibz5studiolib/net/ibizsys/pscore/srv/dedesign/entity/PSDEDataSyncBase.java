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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataSyncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDataSyncBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DENAMES = "DENAMES";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_EVENTTYPE = "EVENTTYPE";
    public static final String FIELD_EXPORTFULL = "EXPORTFULL";
    public static final String FIELD_FILTERMODEL = "FILTERMODEL";
    public static final String FIELD_IMPORTPSDEACTIONID = "IMPORTPSDEACTIONID";
    public static final String FIELD_IMPORTPSDEACTIONNAME = "IMPORTPSDEACTIONNAME";
    public static final String FIELD_INCUSTOMCODE = "INCUSTOMCODE";
    public static final String FIELD_INCUSTOMMODE = "INCUSTOMMODE";
    public static final String FIELD_INPSDEACTIONID = "INPSDEACTIONID";
    public static final String FIELD_INPSDEACTIONNAME = "INPSDEACTIONNAME";
    public static final String FIELD_INPSDEDATASETID = "INPSDEDATASETID";
    public static final String FIELD_INPSDEDATASETNAME = "INPSDEDATASETNAME";
    public static final String FIELD_INPSSYSDATASYNCAGENTID = "INPSSYSDATASYNCAGENTID";
    public static final String FIELD_INPSSYSDATASYNCAGENTNAME = "INPSSYSDATASYNCAGENTNAME";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OUTCUSTOMCODE = "OUTCUSTOMCODE";
    public static final String FIELD_OUTCUSTOMMODE = "OUTCUSTOMMODE";
    public static final String FIELD_OUTMODE = "OUTMODE";
    public static final String FIELD_OUTPSDEACTIONID = "OUTPSDEACTIONID";
    public static final String FIELD_OUTPSDEACTIONNAME = "OUTPSDEACTIONNAME";
    public static final String FIELD_OUTPSDEDATASETID = "OUTPSDEDATASETID";
    public static final String FIELD_OUTPSDEDATASETNAME = "OUTPSDEDATASETNAME";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTID = "OUTPSSYSDATASYNCAGENTID";
    public static final String FIELD_OUTPSSYSDATASYNCAGENTNAME = "OUTPSSYSDATASYNCAGENTNAME";
    public static final String FIELD_OUTTIMER = "OUTTIMER";
    public static final String FIELD_PSDEDATASYNCID = "PSDEDATASYNCID";
    public static final String FIELD_PSDEDATASYNCNAME = "PSDEDATASYNCNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_SYNCDIR = "SYNCDIR";
    public static final String FIELD_SYNCEXPORT = "SYNCEXPORT";
    public static final String FIELD_TIMERMODE = "TIMERMODE";
    public static final String FIELD_TODOTASK = "TODOTASK";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DENAMES = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_EVENTTYPE = 5;
    private static final int INDEX_EXPORTFULL = 6;
    private static final int INDEX_FILTERMODEL = 7;
    private static final int INDEX_IMPORTPSDEACTIONID = 8;
    private static final int INDEX_IMPORTPSDEACTIONNAME = 9;
    private static final int INDEX_INCUSTOMCODE = 10;
    private static final int INDEX_INCUSTOMMODE = 11;
    private static final int INDEX_INPSDEACTIONID = 12;
    private static final int INDEX_INPSDEACTIONNAME = 13;
    private static final int INDEX_INPSDEDATASETID = 14;
    private static final int INDEX_INPSDEDATASETNAME = 15;
    private static final int INDEX_INPSSYSDATASYNCAGENTID = 16;
    private static final int INDEX_INPSSYSDATASYNCAGENTNAME = 17;
    private static final int INDEX_LOCKFLAG = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_OUTCUSTOMCODE = 20;
    private static final int INDEX_OUTCUSTOMMODE = 21;
    private static final int INDEX_OUTMODE = 22;
    private static final int INDEX_OUTPSDEACTIONID = 23;
    private static final int INDEX_OUTPSDEACTIONNAME = 24;
    private static final int INDEX_OUTPSDEDATASETID = 25;
    private static final int INDEX_OUTPSDEDATASETNAME = 26;
    private static final int INDEX_OUTPSSYSDATASYNCAGENTID = 27;
    private static final int INDEX_OUTPSSYSDATASYNCAGENTNAME = 28;
    private static final int INDEX_OUTTIMER = 29;
    private static final int INDEX_PSDEDATASYNCID = 30;
    private static final int INDEX_PSDEDATASYNCNAME = 31;
    private static final int INDEX_PSDEID = 32;
    private static final int INDEX_PSDENAME = 33;
    private static final int INDEX_PSDYNAINSTID = 34;
    private static final int INDEX_PSSYSREQITEMID = 35;
    private static final int INDEX_PSSYSREQITEMNAME = 36;
    private static final int INDEX_PSSYSSFPLUGINID = 37;
    private static final int INDEX_PSSYSSFPLUGINNAME = 38;
    private static final int INDEX_SYNCDIR = 39;
    private static final int INDEX_SYNCEXPORT = 40;
    private static final int INDEX_TIMERMODE = 41;
    private static final int INDEX_TODOTASK = 42;
    private static final int INDEX_UPDATEDATE = 43;
    private static final int INDEX_UPDATEMAN = 44;
    private static final int INDEX_USERCAT = 45;
    private static final int INDEX_USERTAG = 46;
    private static final int INDEX_USERTAG2 = 47;
    private static final int INDEX_USERTAG3 = 48;
    private static final int INDEX_USERTAG4 = 49;
    private static final int INDEX_VALIDFLAG = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDataSyncBase proxyPSDEDataSyncBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean denamesDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean exportfullDirtyFlag = false;
    private boolean filtermodelDirtyFlag = false;
    private boolean importpsdeactionidDirtyFlag = false;
    private boolean importpsdeactionnameDirtyFlag = false;
    private boolean incustomcodeDirtyFlag = false;
    private boolean incustommodeDirtyFlag = false;
    private boolean inpsdeactionidDirtyFlag = false;
    private boolean inpsdeactionnameDirtyFlag = false;
    private boolean inpsdedatasetidDirtyFlag = false;
    private boolean inpsdedatasetnameDirtyFlag = false;
    private boolean inpssysdatasyncagentidDirtyFlag = false;
    private boolean inpssysdatasyncagentnameDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean outcustomcodeDirtyFlag = false;
    private boolean outcustommodeDirtyFlag = false;
    private boolean outmodeDirtyFlag = false;
    private boolean outpsdeactionidDirtyFlag = false;
    private boolean outpsdeactionnameDirtyFlag = false;
    private boolean outpsdedatasetidDirtyFlag = false;
    private boolean outpsdedatasetnameDirtyFlag = false;
    private boolean outpssysdatasyncagentidDirtyFlag = false;
    private boolean outpssysdatasyncagentnameDirtyFlag = false;
    private boolean outtimerDirtyFlag = false;
    private boolean psdedatasyncidDirtyFlag = false;
    private boolean psdedatasyncnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean syncdirDirtyFlag = false;
    private boolean syncexportDirtyFlag = false;
    private boolean timermodeDirtyFlag = false;
    private boolean todotaskDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="denames")
    private String denames;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="eventtype")
    private Integer eventtype;
    @Column(name="exportfull")
    private Integer exportfull;
    @Column(name="filtermodel")
    private String filtermodel;
    @Column(name="importpsdeactionid")
    private String importpsdeactionid;
    @Column(name="importpsdeactionname")
    private String importpsdeactionname;
    @Column(name="incustomcode")
    private String incustomcode;
    @Column(name="incustommode")
    private Integer incustommode;
    @Column(name="inpsdeactionid")
    private String inpsdeactionid;
    @Column(name="inpsdeactionname")
    private String inpsdeactionname;
    @Column(name="inpsdedatasetid")
    private String inpsdedatasetid;
    @Column(name="inpsdedatasetname")
    private String inpsdedatasetname;
    @Column(name="inpssysdatasyncagentid")
    private String inpssysdatasyncagentid;
    @Column(name="inpssysdatasyncagentname")
    private String inpssysdatasyncagentname;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="memo")
    private String memo;
    @Column(name="outcustomcode")
    private String outcustomcode;
    @Column(name="outcustommode")
    private Integer outcustommode;
    @Column(name="outmode")
    private Integer outmode;
    @Column(name="outpsdeactionid")
    private String outpsdeactionid;
    @Column(name="outpsdeactionname")
    private String outpsdeactionname;
    @Column(name="outpsdedatasetid")
    private String outpsdedatasetid;
    @Column(name="outpsdedatasetname")
    private String outpsdedatasetname;
    @Column(name="outpssysdatasyncagentid")
    private String outpssysdatasyncagentid;
    @Column(name="outpssysdatasyncagentname")
    private String outpssysdatasyncagentname;
    @Column(name="outtimer")
    private Integer outtimer;
    @Column(name="psdedatasyncid")
    private String psdedatasyncid;
    @Column(name="psdedatasyncname")
    private String psdedatasyncname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="syncdir")
    private String syncdir;
    @Column(name="syncexport")
    private Integer syncexport;
    @Column(name="timermode")
    private Integer timermode;
    @Column(name="todotask")
    private String todotask;
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
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objImportPSDEActionLock = new Integer(1);
    private PSDEAction importpsdeaction = null;
    private Integer objInPSDEActionLock = new Integer(1);
    private PSDEAction inpsdeaction = null;
    private Integer objOutPSDEActionLock = new Integer(1);
    private PSDEAction outpsdeaction = null;
    private Integer objInPSDEDataSetLock = new Integer(1);
    private PSDEDataSet inpsdedataset = null;
    private Integer objOutPSDEDataSetLock = new Integer(1);
    private PSDEDataSet outpsdedataset = null;
    private Integer objInPSSysDataSyncAgentLock = new Integer(1);
    private PSSysDataSyncAgent inpssysdatasyncagent = null;
    private Integer objOutPSSysDataSyncAgentLock = new Integer(1);
    private PSSysDataSyncAgent outpssysdatasyncagent = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;

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

    public void setDENames(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDENames(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.denames = string;
        this.denamesDirtyFlag = true;
    }

    public String getDENames() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDENames();
        }
        return this.denames;
    }

    public boolean isDENamesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENamesDirty();
        }
        return this.denamesDirtyFlag;
    }

    public void resetDENames() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDENames();
            return;
        }
        this.denamesDirtyFlag = false;
        this.denames = null;
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

    public void setEventType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventType(n);
            return;
        }
        this.eventtype = n;
        this.eventtypeDirtyFlag = true;
    }

    public Integer getEventType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventType();
        }
        return this.eventtype;
    }

    public boolean isEventTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventTypeDirty();
        }
        return this.eventtypeDirtyFlag;
    }

    public void resetEventType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventType();
            return;
        }
        this.eventtypeDirtyFlag = false;
        this.eventtype = null;
    }

    public void setExportFull(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExportFull(n);
            return;
        }
        this.exportfull = n;
        this.exportfullDirtyFlag = true;
    }

    public Integer getExportFull() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExportFull();
        }
        return this.exportfull;
    }

    public boolean isExportFullDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExportFullDirty();
        }
        return this.exportfullDirtyFlag;
    }

    public void resetExportFull() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExportFull();
            return;
        }
        this.exportfullDirtyFlag = false;
        this.exportfull = null;
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

    public void setImportPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.importpsdeactionid = string;
        this.importpsdeactionidDirtyFlag = true;
    }

    public String getImportPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportPSDEActionId();
        }
        return this.importpsdeactionid;
    }

    public boolean isImportPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportPSDEActionIdDirty();
        }
        return this.importpsdeactionidDirtyFlag;
    }

    public void resetImportPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportPSDEActionId();
            return;
        }
        this.importpsdeactionidDirtyFlag = false;
        this.importpsdeactionid = null;
    }

    public void setImportPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.importpsdeactionname = string;
        this.importpsdeactionnameDirtyFlag = true;
    }

    public String getImportPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportPSDEActionName();
        }
        return this.importpsdeactionname;
    }

    public boolean isImportPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportPSDEActionNameDirty();
        }
        return this.importpsdeactionnameDirtyFlag;
    }

    public void resetImportPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportPSDEActionName();
            return;
        }
        this.importpsdeactionnameDirtyFlag = false;
        this.importpsdeactionname = null;
    }

    public void setInCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.incustomcode = string;
        this.incustomcodeDirtyFlag = true;
    }

    public String getInCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInCustomCode();
        }
        return this.incustomcode;
    }

    public boolean isInCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInCustomCodeDirty();
        }
        return this.incustomcodeDirtyFlag;
    }

    public void resetInCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInCustomCode();
            return;
        }
        this.incustomcodeDirtyFlag = false;
        this.incustomcode = null;
    }

    public void setInCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInCustomMode(n);
            return;
        }
        this.incustommode = n;
        this.incustommodeDirtyFlag = true;
    }

    public Integer getInCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInCustomMode();
        }
        return this.incustommode;
    }

    public boolean isInCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInCustomModeDirty();
        }
        return this.incustommodeDirtyFlag;
    }

    public void resetInCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInCustomMode();
            return;
        }
        this.incustommodeDirtyFlag = false;
        this.incustommode = null;
    }

    public void setInPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdeactionid = string;
        this.inpsdeactionidDirtyFlag = true;
    }

    public String getInPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEActionId();
        }
        return this.inpsdeactionid;
    }

    public boolean isInPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEActionIdDirty();
        }
        return this.inpsdeactionidDirtyFlag;
    }

    public void resetInPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEActionId();
            return;
        }
        this.inpsdeactionidDirtyFlag = false;
        this.inpsdeactionid = null;
    }

    public void setInPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdeactionname = string;
        this.inpsdeactionnameDirtyFlag = true;
    }

    public String getInPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEActionName();
        }
        return this.inpsdeactionname;
    }

    public boolean isInPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEActionNameDirty();
        }
        return this.inpsdeactionnameDirtyFlag;
    }

    public void resetInPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEActionName();
            return;
        }
        this.inpsdeactionnameDirtyFlag = false;
        this.inpsdeactionname = null;
    }

    public void setInPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdedatasetid = string;
        this.inpsdedatasetidDirtyFlag = true;
    }

    public String getInPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEDataSetId();
        }
        return this.inpsdedatasetid;
    }

    public boolean isInPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEDataSetIdDirty();
        }
        return this.inpsdedatasetidDirtyFlag;
    }

    public void resetInPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEDataSetId();
            return;
        }
        this.inpsdedatasetidDirtyFlag = false;
        this.inpsdedatasetid = null;
    }

    public void setInPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpsdedatasetname = string;
        this.inpsdedatasetnameDirtyFlag = true;
    }

    public String getInPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEDataSetName();
        }
        return this.inpsdedatasetname;
    }

    public boolean isInPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSDEDataSetNameDirty();
        }
        return this.inpsdedatasetnameDirtyFlag;
    }

    public void resetInPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSDEDataSetName();
            return;
        }
        this.inpsdedatasetnameDirtyFlag = false;
        this.inpsdedatasetname = null;
    }

    public void setInPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdatasyncagentid = string;
        this.inpssysdatasyncagentidDirtyFlag = true;
    }

    public String getInPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgentId();
        }
        return this.inpssysdatasyncagentid;
    }

    public boolean isInPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDataSyncAgentIdDirty();
        }
        return this.inpssysdatasyncagentidDirtyFlag;
    }

    public void resetInPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDataSyncAgentId();
            return;
        }
        this.inpssysdatasyncagentidDirtyFlag = false;
        this.inpssysdatasyncagentid = null;
    }

    public void setInPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.inpssysdatasyncagentname = string;
        this.inpssysdatasyncagentnameDirtyFlag = true;
    }

    public String getInPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgentName();
        }
        return this.inpssysdatasyncagentname;
    }

    public boolean isInPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInPSSysDataSyncAgentNameDirty();
        }
        return this.inpssysdatasyncagentnameDirtyFlag;
    }

    public void resetInPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInPSSysDataSyncAgentName();
            return;
        }
        this.inpssysdatasyncagentnameDirtyFlag = false;
        this.inpssysdatasyncagentname = null;
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

    public void setOutCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outcustomcode = string;
        this.outcustomcodeDirtyFlag = true;
    }

    public String getOutCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutCustomCode();
        }
        return this.outcustomcode;
    }

    public boolean isOutCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutCustomCodeDirty();
        }
        return this.outcustomcodeDirtyFlag;
    }

    public void resetOutCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutCustomCode();
            return;
        }
        this.outcustomcodeDirtyFlag = false;
        this.outcustomcode = null;
    }

    public void setOutCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutCustomMode(n);
            return;
        }
        this.outcustommode = n;
        this.outcustommodeDirtyFlag = true;
    }

    public Integer getOutCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutCustomMode();
        }
        return this.outcustommode;
    }

    public boolean isOutCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutCustomModeDirty();
        }
        return this.outcustommodeDirtyFlag;
    }

    public void resetOutCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutCustomMode();
            return;
        }
        this.outcustommodeDirtyFlag = false;
        this.outcustommode = null;
    }

    public void setOutMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutMode(n);
            return;
        }
        this.outmode = n;
        this.outmodeDirtyFlag = true;
    }

    public Integer getOutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutMode();
        }
        return this.outmode;
    }

    public boolean isOutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutModeDirty();
        }
        return this.outmodeDirtyFlag;
    }

    public void resetOutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutMode();
            return;
        }
        this.outmodeDirtyFlag = false;
        this.outmode = null;
    }

    public void setOutPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdeactionid = string;
        this.outpsdeactionidDirtyFlag = true;
    }

    public String getOutPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEActionId();
        }
        return this.outpsdeactionid;
    }

    public boolean isOutPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEActionIdDirty();
        }
        return this.outpsdeactionidDirtyFlag;
    }

    public void resetOutPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEActionId();
            return;
        }
        this.outpsdeactionidDirtyFlag = false;
        this.outpsdeactionid = null;
    }

    public void setOutPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdeactionname = string;
        this.outpsdeactionnameDirtyFlag = true;
    }

    public String getOutPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEActionName();
        }
        return this.outpsdeactionname;
    }

    public boolean isOutPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEActionNameDirty();
        }
        return this.outpsdeactionnameDirtyFlag;
    }

    public void resetOutPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEActionName();
            return;
        }
        this.outpsdeactionnameDirtyFlag = false;
        this.outpsdeactionname = null;
    }

    public void setOutPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdedatasetid = string;
        this.outpsdedatasetidDirtyFlag = true;
    }

    public String getOutPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEDataSetId();
        }
        return this.outpsdedatasetid;
    }

    public boolean isOutPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEDataSetIdDirty();
        }
        return this.outpsdedatasetidDirtyFlag;
    }

    public void resetOutPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEDataSetId();
            return;
        }
        this.outpsdedatasetidDirtyFlag = false;
        this.outpsdedatasetid = null;
    }

    public void setOutPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpsdedatasetname = string;
        this.outpsdedatasetnameDirtyFlag = true;
    }

    public String getOutPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEDataSetName();
        }
        return this.outpsdedatasetname;
    }

    public boolean isOutPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSDEDataSetNameDirty();
        }
        return this.outpsdedatasetnameDirtyFlag;
    }

    public void resetOutPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSDEDataSetName();
            return;
        }
        this.outpsdedatasetnameDirtyFlag = false;
        this.outpsdedatasetname = null;
    }

    public void setOutPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdatasyncagentid = string;
        this.outpssysdatasyncagentidDirtyFlag = true;
    }

    public String getOutPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgentId();
        }
        return this.outpssysdatasyncagentid;
    }

    public boolean isOutPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDataSyncAgentIdDirty();
        }
        return this.outpssysdatasyncagentidDirtyFlag;
    }

    public void resetOutPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDataSyncAgentId();
            return;
        }
        this.outpssysdatasyncagentidDirtyFlag = false;
        this.outpssysdatasyncagentid = null;
    }

    public void setOutPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.outpssysdatasyncagentname = string;
        this.outpssysdatasyncagentnameDirtyFlag = true;
    }

    public String getOutPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgentName();
        }
        return this.outpssysdatasyncagentname;
    }

    public boolean isOutPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutPSSysDataSyncAgentNameDirty();
        }
        return this.outpssysdatasyncagentnameDirtyFlag;
    }

    public void resetOutPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutPSSysDataSyncAgentName();
            return;
        }
        this.outpssysdatasyncagentnameDirtyFlag = false;
        this.outpssysdatasyncagentname = null;
    }

    public void setOutTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOutTimer(n);
            return;
        }
        this.outtimer = n;
        this.outtimerDirtyFlag = true;
    }

    public Integer getOutTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutTimer();
        }
        return this.outtimer;
    }

    public boolean isOutTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOutTimerDirty();
        }
        return this.outtimerDirtyFlag;
    }

    public void resetOutTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOutTimer();
            return;
        }
        this.outtimerDirtyFlag = false;
        this.outtimer = null;
    }

    public void setPSDEDataSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasyncid = string;
        this.psdedatasyncidDirtyFlag = true;
    }

    public String getPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncId();
        }
        return this.psdedatasyncid;
    }

    public boolean isPSDEDataSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSyncIdDirty();
        }
        return this.psdedatasyncidDirtyFlag;
    }

    public void resetPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSyncId();
            return;
        }
        this.psdedatasyncidDirtyFlag = false;
        this.psdedatasyncid = null;
    }

    public void setPSDEDataSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasyncname = string;
        this.psdedatasyncnameDirtyFlag = true;
    }

    public String getPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSyncName();
        }
        return this.psdedatasyncname;
    }

    public boolean isPSDEDataSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSyncNameDirty();
        }
        return this.psdedatasyncnameDirtyFlag;
    }

    public void resetPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSyncName();
            return;
        }
        this.psdedatasyncnameDirtyFlag = false;
        this.psdedatasyncname = null;
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

    public void setSyncDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.syncdir = string;
        this.syncdirDirtyFlag = true;
    }

    public String getSyncDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncDir();
        }
        return this.syncdir;
    }

    public boolean isSyncDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncDirDirty();
        }
        return this.syncdirDirtyFlag;
    }

    public void resetSyncDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncDir();
            return;
        }
        this.syncdirDirtyFlag = false;
        this.syncdir = null;
    }

    public void setSyncExport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncExport(n);
            return;
        }
        this.syncexport = n;
        this.syncexportDirtyFlag = true;
    }

    public Integer getSyncExport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncExport();
        }
        return this.syncexport;
    }

    public boolean isSyncExportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncExportDirty();
        }
        return this.syncexportDirtyFlag;
    }

    public void resetSyncExport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncExport();
            return;
        }
        this.syncexportDirtyFlag = false;
        this.syncexport = null;
    }

    public void setTimerMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTimerMode(n);
            return;
        }
        this.timermode = n;
        this.timermodeDirtyFlag = true;
    }

    public Integer getTimerMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTimerMode();
        }
        return this.timermode;
    }

    public boolean isTimerModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTimerModeDirty();
        }
        return this.timermodeDirtyFlag;
    }

    public void resetTimerMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTimerMode();
            return;
        }
        this.timermodeDirtyFlag = false;
        this.timermode = null;
    }

    public void setToDoTask(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToDoTask(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.todotask = string;
        this.todotaskDirtyFlag = true;
    }

    public String getToDoTask() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToDoTask();
        }
        return this.todotask;
    }

    public boolean isToDoTaskDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToDoTaskDirty();
        }
        return this.todotaskDirtyFlag;
    }

    public void resetToDoTask() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToDoTask();
            return;
        }
        this.todotaskDirtyFlag = false;
        this.todotask = null;
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

    protected void onReset() {
        PSDEDataSyncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDataSyncBase pSDEDataSyncBase) {
        pSDEDataSyncBase.resetCodeName();
        pSDEDataSyncBase.resetCreateDate();
        pSDEDataSyncBase.resetCreateMan();
        pSDEDataSyncBase.resetDENames();
        pSDEDataSyncBase.resetDynaModelFlag();
        pSDEDataSyncBase.resetEventType();
        pSDEDataSyncBase.resetExportFull();
        pSDEDataSyncBase.resetFilterModel();
        pSDEDataSyncBase.resetImportPSDEActionId();
        pSDEDataSyncBase.resetImportPSDEActionName();
        pSDEDataSyncBase.resetInCustomCode();
        pSDEDataSyncBase.resetInCustomMode();
        pSDEDataSyncBase.resetInPSDEActionId();
        pSDEDataSyncBase.resetInPSDEActionName();
        pSDEDataSyncBase.resetInPSDEDataSetId();
        pSDEDataSyncBase.resetInPSDEDataSetName();
        pSDEDataSyncBase.resetInPSSysDataSyncAgentId();
        pSDEDataSyncBase.resetInPSSysDataSyncAgentName();
        pSDEDataSyncBase.resetLockFlag();
        pSDEDataSyncBase.resetMemo();
        pSDEDataSyncBase.resetOutCustomCode();
        pSDEDataSyncBase.resetOutCustomMode();
        pSDEDataSyncBase.resetOutMode();
        pSDEDataSyncBase.resetOutPSDEActionId();
        pSDEDataSyncBase.resetOutPSDEActionName();
        pSDEDataSyncBase.resetOutPSDEDataSetId();
        pSDEDataSyncBase.resetOutPSDEDataSetName();
        pSDEDataSyncBase.resetOutPSSysDataSyncAgentId();
        pSDEDataSyncBase.resetOutPSSysDataSyncAgentName();
        pSDEDataSyncBase.resetOutTimer();
        pSDEDataSyncBase.resetPSDEDataSyncId();
        pSDEDataSyncBase.resetPSDEDataSyncName();
        pSDEDataSyncBase.resetPSDEId();
        pSDEDataSyncBase.resetPSDEName();
        pSDEDataSyncBase.resetPSDynaInstId();
        pSDEDataSyncBase.resetPSSysReqItemId();
        pSDEDataSyncBase.resetPSSysReqItemName();
        pSDEDataSyncBase.resetPSSysSFPluginId();
        pSDEDataSyncBase.resetPSSysSFPluginName();
        pSDEDataSyncBase.resetSyncDir();
        pSDEDataSyncBase.resetSyncExport();
        pSDEDataSyncBase.resetTimerMode();
        pSDEDataSyncBase.resetToDoTask();
        pSDEDataSyncBase.resetUpdateDate();
        pSDEDataSyncBase.resetUpdateMan();
        pSDEDataSyncBase.resetUserCat();
        pSDEDataSyncBase.resetUserTag();
        pSDEDataSyncBase.resetUserTag2();
        pSDEDataSyncBase.resetUserTag3();
        pSDEDataSyncBase.resetUserTag4();
        pSDEDataSyncBase.resetValidFlag();
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
        if (!bl || this.isDENamesDirty()) {
            hashMap.put(FIELD_DENAMES, this.getDENames());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEventTypeDirty()) {
            hashMap.put(FIELD_EVENTTYPE, this.getEventType());
        }
        if (!bl || this.isExportFullDirty()) {
            hashMap.put(FIELD_EXPORTFULL, this.getExportFull());
        }
        if (!bl || this.isFilterModelDirty()) {
            hashMap.put(FIELD_FILTERMODEL, this.getFilterModel());
        }
        if (!bl || this.isImportPSDEActionIdDirty()) {
            hashMap.put(FIELD_IMPORTPSDEACTIONID, this.getImportPSDEActionId());
        }
        if (!bl || this.isImportPSDEActionNameDirty()) {
            hashMap.put(FIELD_IMPORTPSDEACTIONNAME, this.getImportPSDEActionName());
        }
        if (!bl || this.isInCustomCodeDirty()) {
            hashMap.put(FIELD_INCUSTOMCODE, this.getInCustomCode());
        }
        if (!bl || this.isInCustomModeDirty()) {
            hashMap.put(FIELD_INCUSTOMMODE, this.getInCustomMode());
        }
        if (!bl || this.isInPSDEActionIdDirty()) {
            hashMap.put(FIELD_INPSDEACTIONID, this.getInPSDEActionId());
        }
        if (!bl || this.isInPSDEActionNameDirty()) {
            hashMap.put(FIELD_INPSDEACTIONNAME, this.getInPSDEActionName());
        }
        if (!bl || this.isInPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_INPSDEDATASETID, this.getInPSDEDataSetId());
        }
        if (!bl || this.isInPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_INPSDEDATASETNAME, this.getInPSDEDataSetName());
        }
        if (!bl || this.isInPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_INPSSYSDATASYNCAGENTID, this.getInPSSysDataSyncAgentId());
        }
        if (!bl || this.isInPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_INPSSYSDATASYNCAGENTNAME, this.getInPSSysDataSyncAgentName());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOutCustomCodeDirty()) {
            hashMap.put(FIELD_OUTCUSTOMCODE, this.getOutCustomCode());
        }
        if (!bl || this.isOutCustomModeDirty()) {
            hashMap.put(FIELD_OUTCUSTOMMODE, this.getOutCustomMode());
        }
        if (!bl || this.isOutModeDirty()) {
            hashMap.put(FIELD_OUTMODE, this.getOutMode());
        }
        if (!bl || this.isOutPSDEActionIdDirty()) {
            hashMap.put(FIELD_OUTPSDEACTIONID, this.getOutPSDEActionId());
        }
        if (!bl || this.isOutPSDEActionNameDirty()) {
            hashMap.put(FIELD_OUTPSDEACTIONNAME, this.getOutPSDEActionName());
        }
        if (!bl || this.isOutPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_OUTPSDEDATASETID, this.getOutPSDEDataSetId());
        }
        if (!bl || this.isOutPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_OUTPSDEDATASETNAME, this.getOutPSDEDataSetName());
        }
        if (!bl || this.isOutPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_OUTPSSYSDATASYNCAGENTID, this.getOutPSSysDataSyncAgentId());
        }
        if (!bl || this.isOutPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_OUTPSSYSDATASYNCAGENTNAME, this.getOutPSSysDataSyncAgentName());
        }
        if (!bl || this.isOutTimerDirty()) {
            hashMap.put(FIELD_OUTTIMER, this.getOutTimer());
        }
        if (!bl || this.isPSDEDataSyncIdDirty()) {
            hashMap.put(FIELD_PSDEDATASYNCID, this.getPSDEDataSyncId());
        }
        if (!bl || this.isPSDEDataSyncNameDirty()) {
            hashMap.put(FIELD_PSDEDATASYNCNAME, this.getPSDEDataSyncName());
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
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isSyncDirDirty()) {
            hashMap.put(FIELD_SYNCDIR, this.getSyncDir());
        }
        if (!bl || this.isSyncExportDirty()) {
            hashMap.put(FIELD_SYNCEXPORT, this.getSyncExport());
        }
        if (!bl || this.isTimerModeDirty()) {
            hashMap.put(FIELD_TIMERMODE, this.getTimerMode());
        }
        if (!bl || this.isToDoTaskDirty()) {
            hashMap.put(FIELD_TODOTASK, this.getToDoTask());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDEDataSyncBase.get(this, n);
    }

    private static Object get(PSDEDataSyncBase pSDEDataSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSyncBase.getCodeName();
            }
            case 1: {
                return pSDEDataSyncBase.getCreateDate();
            }
            case 2: {
                return pSDEDataSyncBase.getCreateMan();
            }
            case 3: {
                return pSDEDataSyncBase.getDENames();
            }
            case 4: {
                return pSDEDataSyncBase.getDynaModelFlag();
            }
            case 5: {
                return pSDEDataSyncBase.getEventType();
            }
            case 6: {
                return pSDEDataSyncBase.getExportFull();
            }
            case 7: {
                return pSDEDataSyncBase.getFilterModel();
            }
            case 8: {
                return pSDEDataSyncBase.getImportPSDEActionId();
            }
            case 9: {
                return pSDEDataSyncBase.getImportPSDEActionName();
            }
            case 10: {
                return pSDEDataSyncBase.getInCustomCode();
            }
            case 11: {
                return pSDEDataSyncBase.getInCustomMode();
            }
            case 12: {
                return pSDEDataSyncBase.getInPSDEActionId();
            }
            case 13: {
                return pSDEDataSyncBase.getInPSDEActionName();
            }
            case 14: {
                return pSDEDataSyncBase.getInPSDEDataSetId();
            }
            case 15: {
                return pSDEDataSyncBase.getInPSDEDataSetName();
            }
            case 16: {
                return pSDEDataSyncBase.getInPSSysDataSyncAgentId();
            }
            case 17: {
                return pSDEDataSyncBase.getInPSSysDataSyncAgentName();
            }
            case 18: {
                return pSDEDataSyncBase.getLockFlag();
            }
            case 19: {
                return pSDEDataSyncBase.getMemo();
            }
            case 20: {
                return pSDEDataSyncBase.getOutCustomCode();
            }
            case 21: {
                return pSDEDataSyncBase.getOutCustomMode();
            }
            case 22: {
                return pSDEDataSyncBase.getOutMode();
            }
            case 23: {
                return pSDEDataSyncBase.getOutPSDEActionId();
            }
            case 24: {
                return pSDEDataSyncBase.getOutPSDEActionName();
            }
            case 25: {
                return pSDEDataSyncBase.getOutPSDEDataSetId();
            }
            case 26: {
                return pSDEDataSyncBase.getOutPSDEDataSetName();
            }
            case 27: {
                return pSDEDataSyncBase.getOutPSSysDataSyncAgentId();
            }
            case 28: {
                return pSDEDataSyncBase.getOutPSSysDataSyncAgentName();
            }
            case 29: {
                return pSDEDataSyncBase.getOutTimer();
            }
            case 30: {
                return pSDEDataSyncBase.getPSDEDataSyncId();
            }
            case 31: {
                return pSDEDataSyncBase.getPSDEDataSyncName();
            }
            case 32: {
                return pSDEDataSyncBase.getPSDEId();
            }
            case 33: {
                return pSDEDataSyncBase.getPSDEName();
            }
            case 34: {
                return pSDEDataSyncBase.getPSDynaInstId();
            }
            case 35: {
                return pSDEDataSyncBase.getPSSysReqItemId();
            }
            case 36: {
                return pSDEDataSyncBase.getPSSysReqItemName();
            }
            case 37: {
                return pSDEDataSyncBase.getPSSysSFPluginId();
            }
            case 38: {
                return pSDEDataSyncBase.getPSSysSFPluginName();
            }
            case 39: {
                return pSDEDataSyncBase.getSyncDir();
            }
            case 40: {
                return pSDEDataSyncBase.getSyncExport();
            }
            case 41: {
                return pSDEDataSyncBase.getTimerMode();
            }
            case 42: {
                return pSDEDataSyncBase.getToDoTask();
            }
            case 43: {
                return pSDEDataSyncBase.getUpdateDate();
            }
            case 44: {
                return pSDEDataSyncBase.getUpdateMan();
            }
            case 45: {
                return pSDEDataSyncBase.getUserCat();
            }
            case 46: {
                return pSDEDataSyncBase.getUserTag();
            }
            case 47: {
                return pSDEDataSyncBase.getUserTag2();
            }
            case 48: {
                return pSDEDataSyncBase.getUserTag3();
            }
            case 49: {
                return pSDEDataSyncBase.getUserTag4();
            }
            case 50: {
                return pSDEDataSyncBase.getValidFlag();
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
        PSDEDataSyncBase.set(this, n, object);
    }

    private static void set(PSDEDataSyncBase pSDEDataSyncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataSyncBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDataSyncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEDataSyncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDataSyncBase.setDENames(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDataSyncBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEDataSyncBase.setEventType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEDataSyncBase.setExportFull(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDataSyncBase.setFilterModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDataSyncBase.setImportPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDataSyncBase.setImportPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDataSyncBase.setInCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDataSyncBase.setInCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEDataSyncBase.setInPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDataSyncBase.setInPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDataSyncBase.setInPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEDataSyncBase.setInPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEDataSyncBase.setInPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEDataSyncBase.setInPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEDataSyncBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEDataSyncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEDataSyncBase.setOutCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEDataSyncBase.setOutCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEDataSyncBase.setOutMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEDataSyncBase.setOutPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEDataSyncBase.setOutPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEDataSyncBase.setOutPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEDataSyncBase.setOutPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEDataSyncBase.setOutPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEDataSyncBase.setOutPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEDataSyncBase.setOutTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSDEDataSyncBase.setPSDEDataSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEDataSyncBase.setPSDEDataSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEDataSyncBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEDataSyncBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEDataSyncBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEDataSyncBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEDataSyncBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEDataSyncBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEDataSyncBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEDataSyncBase.setSyncDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEDataSyncBase.setSyncExport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDEDataSyncBase.setTimerMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDEDataSyncBase.setToDoTask(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEDataSyncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 44: {
                pSDEDataSyncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEDataSyncBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEDataSyncBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEDataSyncBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEDataSyncBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEDataSyncBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEDataSyncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEDataSyncBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDataSyncBase pSDEDataSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSyncBase.getCodeName() == null;
            }
            case 1: {
                return pSDEDataSyncBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEDataSyncBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEDataSyncBase.getDENames() == null;
            }
            case 4: {
                return pSDEDataSyncBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSDEDataSyncBase.getEventType() == null;
            }
            case 6: {
                return pSDEDataSyncBase.getExportFull() == null;
            }
            case 7: {
                return pSDEDataSyncBase.getFilterModel() == null;
            }
            case 8: {
                return pSDEDataSyncBase.getImportPSDEActionId() == null;
            }
            case 9: {
                return pSDEDataSyncBase.getImportPSDEActionName() == null;
            }
            case 10: {
                return pSDEDataSyncBase.getInCustomCode() == null;
            }
            case 11: {
                return pSDEDataSyncBase.getInCustomMode() == null;
            }
            case 12: {
                return pSDEDataSyncBase.getInPSDEActionId() == null;
            }
            case 13: {
                return pSDEDataSyncBase.getInPSDEActionName() == null;
            }
            case 14: {
                return pSDEDataSyncBase.getInPSDEDataSetId() == null;
            }
            case 15: {
                return pSDEDataSyncBase.getInPSDEDataSetName() == null;
            }
            case 16: {
                return pSDEDataSyncBase.getInPSSysDataSyncAgentId() == null;
            }
            case 17: {
                return pSDEDataSyncBase.getInPSSysDataSyncAgentName() == null;
            }
            case 18: {
                return pSDEDataSyncBase.getLockFlag() == null;
            }
            case 19: {
                return pSDEDataSyncBase.getMemo() == null;
            }
            case 20: {
                return pSDEDataSyncBase.getOutCustomCode() == null;
            }
            case 21: {
                return pSDEDataSyncBase.getOutCustomMode() == null;
            }
            case 22: {
                return pSDEDataSyncBase.getOutMode() == null;
            }
            case 23: {
                return pSDEDataSyncBase.getOutPSDEActionId() == null;
            }
            case 24: {
                return pSDEDataSyncBase.getOutPSDEActionName() == null;
            }
            case 25: {
                return pSDEDataSyncBase.getOutPSDEDataSetId() == null;
            }
            case 26: {
                return pSDEDataSyncBase.getOutPSDEDataSetName() == null;
            }
            case 27: {
                return pSDEDataSyncBase.getOutPSSysDataSyncAgentId() == null;
            }
            case 28: {
                return pSDEDataSyncBase.getOutPSSysDataSyncAgentName() == null;
            }
            case 29: {
                return pSDEDataSyncBase.getOutTimer() == null;
            }
            case 30: {
                return pSDEDataSyncBase.getPSDEDataSyncId() == null;
            }
            case 31: {
                return pSDEDataSyncBase.getPSDEDataSyncName() == null;
            }
            case 32: {
                return pSDEDataSyncBase.getPSDEId() == null;
            }
            case 33: {
                return pSDEDataSyncBase.getPSDEName() == null;
            }
            case 34: {
                return pSDEDataSyncBase.getPSDynaInstId() == null;
            }
            case 35: {
                return pSDEDataSyncBase.getPSSysReqItemId() == null;
            }
            case 36: {
                return pSDEDataSyncBase.getPSSysReqItemName() == null;
            }
            case 37: {
                return pSDEDataSyncBase.getPSSysSFPluginId() == null;
            }
            case 38: {
                return pSDEDataSyncBase.getPSSysSFPluginName() == null;
            }
            case 39: {
                return pSDEDataSyncBase.getSyncDir() == null;
            }
            case 40: {
                return pSDEDataSyncBase.getSyncExport() == null;
            }
            case 41: {
                return pSDEDataSyncBase.getTimerMode() == null;
            }
            case 42: {
                return pSDEDataSyncBase.getToDoTask() == null;
            }
            case 43: {
                return pSDEDataSyncBase.getUpdateDate() == null;
            }
            case 44: {
                return pSDEDataSyncBase.getUpdateMan() == null;
            }
            case 45: {
                return pSDEDataSyncBase.getUserCat() == null;
            }
            case 46: {
                return pSDEDataSyncBase.getUserTag() == null;
            }
            case 47: {
                return pSDEDataSyncBase.getUserTag2() == null;
            }
            case 48: {
                return pSDEDataSyncBase.getUserTag3() == null;
            }
            case 49: {
                return pSDEDataSyncBase.getUserTag4() == null;
            }
            case 50: {
                return pSDEDataSyncBase.getValidFlag() == null;
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
        return PSDEDataSyncBase.contains(this, n);
    }

    private static boolean contains(PSDEDataSyncBase pSDEDataSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDataSyncBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEDataSyncBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEDataSyncBase.isCreateManDirty();
            }
            case 3: {
                return pSDEDataSyncBase.isDENamesDirty();
            }
            case 4: {
                return pSDEDataSyncBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSDEDataSyncBase.isEventTypeDirty();
            }
            case 6: {
                return pSDEDataSyncBase.isExportFullDirty();
            }
            case 7: {
                return pSDEDataSyncBase.isFilterModelDirty();
            }
            case 8: {
                return pSDEDataSyncBase.isImportPSDEActionIdDirty();
            }
            case 9: {
                return pSDEDataSyncBase.isImportPSDEActionNameDirty();
            }
            case 10: {
                return pSDEDataSyncBase.isInCustomCodeDirty();
            }
            case 11: {
                return pSDEDataSyncBase.isInCustomModeDirty();
            }
            case 12: {
                return pSDEDataSyncBase.isInPSDEActionIdDirty();
            }
            case 13: {
                return pSDEDataSyncBase.isInPSDEActionNameDirty();
            }
            case 14: {
                return pSDEDataSyncBase.isInPSDEDataSetIdDirty();
            }
            case 15: {
                return pSDEDataSyncBase.isInPSDEDataSetNameDirty();
            }
            case 16: {
                return pSDEDataSyncBase.isInPSSysDataSyncAgentIdDirty();
            }
            case 17: {
                return pSDEDataSyncBase.isInPSSysDataSyncAgentNameDirty();
            }
            case 18: {
                return pSDEDataSyncBase.isLockFlagDirty();
            }
            case 19: {
                return pSDEDataSyncBase.isMemoDirty();
            }
            case 20: {
                return pSDEDataSyncBase.isOutCustomCodeDirty();
            }
            case 21: {
                return pSDEDataSyncBase.isOutCustomModeDirty();
            }
            case 22: {
                return pSDEDataSyncBase.isOutModeDirty();
            }
            case 23: {
                return pSDEDataSyncBase.isOutPSDEActionIdDirty();
            }
            case 24: {
                return pSDEDataSyncBase.isOutPSDEActionNameDirty();
            }
            case 25: {
                return pSDEDataSyncBase.isOutPSDEDataSetIdDirty();
            }
            case 26: {
                return pSDEDataSyncBase.isOutPSDEDataSetNameDirty();
            }
            case 27: {
                return pSDEDataSyncBase.isOutPSSysDataSyncAgentIdDirty();
            }
            case 28: {
                return pSDEDataSyncBase.isOutPSSysDataSyncAgentNameDirty();
            }
            case 29: {
                return pSDEDataSyncBase.isOutTimerDirty();
            }
            case 30: {
                return pSDEDataSyncBase.isPSDEDataSyncIdDirty();
            }
            case 31: {
                return pSDEDataSyncBase.isPSDEDataSyncNameDirty();
            }
            case 32: {
                return pSDEDataSyncBase.isPSDEIdDirty();
            }
            case 33: {
                return pSDEDataSyncBase.isPSDENameDirty();
            }
            case 34: {
                return pSDEDataSyncBase.isPSDynaInstIdDirty();
            }
            case 35: {
                return pSDEDataSyncBase.isPSSysReqItemIdDirty();
            }
            case 36: {
                return pSDEDataSyncBase.isPSSysReqItemNameDirty();
            }
            case 37: {
                return pSDEDataSyncBase.isPSSysSFPluginIdDirty();
            }
            case 38: {
                return pSDEDataSyncBase.isPSSysSFPluginNameDirty();
            }
            case 39: {
                return pSDEDataSyncBase.isSyncDirDirty();
            }
            case 40: {
                return pSDEDataSyncBase.isSyncExportDirty();
            }
            case 41: {
                return pSDEDataSyncBase.isTimerModeDirty();
            }
            case 42: {
                return pSDEDataSyncBase.isToDoTaskDirty();
            }
            case 43: {
                return pSDEDataSyncBase.isUpdateDateDirty();
            }
            case 44: {
                return pSDEDataSyncBase.isUpdateManDirty();
            }
            case 45: {
                return pSDEDataSyncBase.isUserCatDirty();
            }
            case 46: {
                return pSDEDataSyncBase.isUserTagDirty();
            }
            case 47: {
                return pSDEDataSyncBase.isUserTag2Dirty();
            }
            case 48: {
                return pSDEDataSyncBase.isUserTag3Dirty();
            }
            case 49: {
                return pSDEDataSyncBase.isUserTag4Dirty();
            }
            case 50: {
                return pSDEDataSyncBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDataSyncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDataSyncBase pSDEDataSyncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDataSyncBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getDENames() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"denames", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getDENames()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getEventType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eventtype", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getEventType()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getExportFull() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"exportfull", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getExportFull()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getFilterModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filtermodel", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getFilterModel()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getImportPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importpsdeactionid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getImportPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getImportPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"importpsdeactionname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getImportPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incustomcode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incustommode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdeactionid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdeactionname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdedatasetid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpsdedatasetname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdatasyncagentid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inpssysdatasyncagentname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getInPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outcustomcode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutCustomCode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outcustommode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutCustomMode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outmode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutMode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdeactionid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdeactionname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdedatasetid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpsdedatasetname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdatasyncagentid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outpssysdatasyncagentname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getOutTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"outtimer", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getOutTimer()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSDEDataSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasyncid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSDEDataSyncId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSDEDataSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasyncname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSDEDataSyncName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getSyncDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncdir", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getSyncDir()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getSyncExport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncexport", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getSyncExport()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getTimerMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"timermode", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getTimerMode()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getToDoTask() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"todotask", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getToDoTask()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEDataSyncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEDataSyncBase.getJSONValue((Object)pSDEDataSyncBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDataSyncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDataSyncBase pSDEDataSyncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDataSyncBase.getCodeName() != null) {
            object = pSDEDataSyncBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getCreateDate() != null) {
            object = pSDEDataSyncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getCreateMan() != null) {
            object = pSDEDataSyncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getDENames() != null) {
            object = pSDEDataSyncBase.getDENames();
            xmlNode.setAttribute(FIELD_DENAMES, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getDynaModelFlag() != null) {
            object = pSDEDataSyncBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getEventType() != null) {
            object = pSDEDataSyncBase.getEventType();
            xmlNode.setAttribute(FIELD_EVENTTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getExportFull() != null) {
            object = pSDEDataSyncBase.getExportFull();
            xmlNode.setAttribute(FIELD_EXPORTFULL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getFilterModel() != null) {
            object = pSDEDataSyncBase.getFilterModel();
            xmlNode.setAttribute(FIELD_FILTERMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getImportPSDEActionId() != null) {
            object = pSDEDataSyncBase.getImportPSDEActionId();
            xmlNode.setAttribute(FIELD_IMPORTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getImportPSDEActionName() != null) {
            object = pSDEDataSyncBase.getImportPSDEActionName();
            xmlNode.setAttribute(FIELD_IMPORTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInCustomCode() != null) {
            object = pSDEDataSyncBase.getInCustomCode();
            xmlNode.setAttribute(FIELD_INCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInCustomMode() != null) {
            object = pSDEDataSyncBase.getInCustomMode();
            xmlNode.setAttribute(FIELD_INCUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getInPSDEActionId() != null) {
            object = pSDEDataSyncBase.getInPSDEActionId();
            xmlNode.setAttribute(FIELD_INPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInPSDEActionName() != null) {
            object = pSDEDataSyncBase.getInPSDEActionName();
            xmlNode.setAttribute(FIELD_INPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInPSDEDataSetId() != null) {
            object = pSDEDataSyncBase.getInPSDEDataSetId();
            xmlNode.setAttribute(FIELD_INPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInPSDEDataSetName() != null) {
            object = pSDEDataSyncBase.getInPSDEDataSetName();
            xmlNode.setAttribute(FIELD_INPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentId() != null) {
            object = pSDEDataSyncBase.getInPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_INPSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentName() != null) {
            object = pSDEDataSyncBase.getInPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_INPSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getLockFlag() != null) {
            object = pSDEDataSyncBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getMemo() != null) {
            object = pSDEDataSyncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutCustomCode() != null) {
            object = pSDEDataSyncBase.getOutCustomCode();
            xmlNode.setAttribute(FIELD_OUTCUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutCustomMode() != null) {
            object = pSDEDataSyncBase.getOutCustomMode();
            xmlNode.setAttribute(FIELD_OUTCUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getOutMode() != null) {
            object = pSDEDataSyncBase.getOutMode();
            xmlNode.setAttribute(FIELD_OUTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getOutPSDEActionId() != null) {
            object = pSDEDataSyncBase.getOutPSDEActionId();
            xmlNode.setAttribute(FIELD_OUTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEActionName() != null) {
            object = pSDEDataSyncBase.getOutPSDEActionName();
            xmlNode.setAttribute(FIELD_OUTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEDataSetId() != null) {
            object = pSDEDataSyncBase.getOutPSDEDataSetId();
            xmlNode.setAttribute(FIELD_OUTPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutPSDEDataSetName() != null) {
            object = pSDEDataSyncBase.getOutPSDEDataSetName();
            xmlNode.setAttribute(FIELD_OUTPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentId() != null) {
            object = pSDEDataSyncBase.getOutPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_OUTPSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentName() != null) {
            object = pSDEDataSyncBase.getOutPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_OUTPSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getOutTimer() != null) {
            object = pSDEDataSyncBase.getOutTimer();
            xmlNode.setAttribute(FIELD_OUTTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getPSDEDataSyncId() != null) {
            object = pSDEDataSyncBase.getPSDEDataSyncId();
            xmlNode.setAttribute(FIELD_PSDEDATASYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSDEDataSyncName() != null) {
            object = pSDEDataSyncBase.getPSDEDataSyncName();
            xmlNode.setAttribute(FIELD_PSDEDATASYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSDEId() != null) {
            object = pSDEDataSyncBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSDEName() != null) {
            object = pSDEDataSyncBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSDynaInstId() != null) {
            object = pSDEDataSyncBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSSysReqItemId() != null) {
            object = pSDEDataSyncBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSSysReqItemName() != null) {
            object = pSDEDataSyncBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSSysSFPluginId() != null) {
            object = pSDEDataSyncBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getPSSysSFPluginName() != null) {
            object = pSDEDataSyncBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getSyncDir() != null) {
            object = pSDEDataSyncBase.getSyncDir();
            xmlNode.setAttribute(FIELD_SYNCDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getSyncExport() != null) {
            object = pSDEDataSyncBase.getSyncExport();
            xmlNode.setAttribute(FIELD_SYNCEXPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getTimerMode() != null) {
            object = pSDEDataSyncBase.getTimerMode();
            xmlNode.setAttribute(FIELD_TIMERMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getToDoTask() != null) {
            object = pSDEDataSyncBase.getToDoTask();
            xmlNode.setAttribute(FIELD_TODOTASK, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUpdateDate() != null) {
            object = pSDEDataSyncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDataSyncBase.getUpdateMan() != null) {
            object = pSDEDataSyncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUserCat() != null) {
            object = pSDEDataSyncBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUserTag() != null) {
            object = pSDEDataSyncBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUserTag2() != null) {
            object = pSDEDataSyncBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUserTag3() != null) {
            object = pSDEDataSyncBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getUserTag4() != null) {
            object = pSDEDataSyncBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEDataSyncBase.getValidFlag() != null) {
            object = pSDEDataSyncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDataSyncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDataSyncBase pSDEDataSyncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDataSyncBase.isCodeNameDirty() && (bl || pSDEDataSyncBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEDataSyncBase.getCodeName());
        }
        if (pSDEDataSyncBase.isCreateDateDirty() && (bl || pSDEDataSyncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDataSyncBase.getCreateDate());
        }
        if (pSDEDataSyncBase.isCreateManDirty() && (bl || pSDEDataSyncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDataSyncBase.getCreateMan());
        }
        if (pSDEDataSyncBase.isDENamesDirty() && (bl || pSDEDataSyncBase.getDENames() != null)) {
            iDataObject.set(FIELD_DENAMES, (Object)pSDEDataSyncBase.getDENames());
        }
        if (pSDEDataSyncBase.isDynaModelFlagDirty() && (bl || pSDEDataSyncBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEDataSyncBase.getDynaModelFlag());
        }
        if (pSDEDataSyncBase.isEventTypeDirty() && (bl || pSDEDataSyncBase.getEventType() != null)) {
            iDataObject.set(FIELD_EVENTTYPE, (Object)pSDEDataSyncBase.getEventType());
        }
        if (pSDEDataSyncBase.isExportFullDirty() && (bl || pSDEDataSyncBase.getExportFull() != null)) {
            iDataObject.set(FIELD_EXPORTFULL, (Object)pSDEDataSyncBase.getExportFull());
        }
        if (pSDEDataSyncBase.isFilterModelDirty() && (bl || pSDEDataSyncBase.getFilterModel() != null)) {
            iDataObject.set(FIELD_FILTERMODEL, (Object)pSDEDataSyncBase.getFilterModel());
        }
        if (pSDEDataSyncBase.isImportPSDEActionIdDirty() && (bl || pSDEDataSyncBase.getImportPSDEActionId() != null)) {
            iDataObject.set(FIELD_IMPORTPSDEACTIONID, (Object)pSDEDataSyncBase.getImportPSDEActionId());
        }
        if (pSDEDataSyncBase.isImportPSDEActionNameDirty() && (bl || pSDEDataSyncBase.getImportPSDEActionName() != null)) {
            iDataObject.set(FIELD_IMPORTPSDEACTIONNAME, (Object)pSDEDataSyncBase.getImportPSDEActionName());
        }
        if (pSDEDataSyncBase.isInCustomCodeDirty() && (bl || pSDEDataSyncBase.getInCustomCode() != null)) {
            iDataObject.set(FIELD_INCUSTOMCODE, (Object)pSDEDataSyncBase.getInCustomCode());
        }
        if (pSDEDataSyncBase.isInCustomModeDirty() && (bl || pSDEDataSyncBase.getInCustomMode() != null)) {
            iDataObject.set(FIELD_INCUSTOMMODE, (Object)pSDEDataSyncBase.getInCustomMode());
        }
        if (pSDEDataSyncBase.isInPSDEActionIdDirty() && (bl || pSDEDataSyncBase.getInPSDEActionId() != null)) {
            iDataObject.set(FIELD_INPSDEACTIONID, (Object)pSDEDataSyncBase.getInPSDEActionId());
        }
        if (pSDEDataSyncBase.isInPSDEActionNameDirty() && (bl || pSDEDataSyncBase.getInPSDEActionName() != null)) {
            iDataObject.set(FIELD_INPSDEACTIONNAME, (Object)pSDEDataSyncBase.getInPSDEActionName());
        }
        if (pSDEDataSyncBase.isInPSDEDataSetIdDirty() && (bl || pSDEDataSyncBase.getInPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_INPSDEDATASETID, (Object)pSDEDataSyncBase.getInPSDEDataSetId());
        }
        if (pSDEDataSyncBase.isInPSDEDataSetNameDirty() && (bl || pSDEDataSyncBase.getInPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_INPSDEDATASETNAME, (Object)pSDEDataSyncBase.getInPSDEDataSetName());
        }
        if (pSDEDataSyncBase.isInPSSysDataSyncAgentIdDirty() && (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_INPSSYSDATASYNCAGENTID, (Object)pSDEDataSyncBase.getInPSSysDataSyncAgentId());
        }
        if (pSDEDataSyncBase.isInPSSysDataSyncAgentNameDirty() && (bl || pSDEDataSyncBase.getInPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_INPSSYSDATASYNCAGENTNAME, (Object)pSDEDataSyncBase.getInPSSysDataSyncAgentName());
        }
        if (pSDEDataSyncBase.isLockFlagDirty() && (bl || pSDEDataSyncBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSDEDataSyncBase.getLockFlag());
        }
        if (pSDEDataSyncBase.isMemoDirty() && (bl || pSDEDataSyncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDataSyncBase.getMemo());
        }
        if (pSDEDataSyncBase.isOutCustomCodeDirty() && (bl || pSDEDataSyncBase.getOutCustomCode() != null)) {
            iDataObject.set(FIELD_OUTCUSTOMCODE, (Object)pSDEDataSyncBase.getOutCustomCode());
        }
        if (pSDEDataSyncBase.isOutCustomModeDirty() && (bl || pSDEDataSyncBase.getOutCustomMode() != null)) {
            iDataObject.set(FIELD_OUTCUSTOMMODE, (Object)pSDEDataSyncBase.getOutCustomMode());
        }
        if (pSDEDataSyncBase.isOutModeDirty() && (bl || pSDEDataSyncBase.getOutMode() != null)) {
            iDataObject.set(FIELD_OUTMODE, (Object)pSDEDataSyncBase.getOutMode());
        }
        if (pSDEDataSyncBase.isOutPSDEActionIdDirty() && (bl || pSDEDataSyncBase.getOutPSDEActionId() != null)) {
            iDataObject.set(FIELD_OUTPSDEACTIONID, (Object)pSDEDataSyncBase.getOutPSDEActionId());
        }
        if (pSDEDataSyncBase.isOutPSDEActionNameDirty() && (bl || pSDEDataSyncBase.getOutPSDEActionName() != null)) {
            iDataObject.set(FIELD_OUTPSDEACTIONNAME, (Object)pSDEDataSyncBase.getOutPSDEActionName());
        }
        if (pSDEDataSyncBase.isOutPSDEDataSetIdDirty() && (bl || pSDEDataSyncBase.getOutPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_OUTPSDEDATASETID, (Object)pSDEDataSyncBase.getOutPSDEDataSetId());
        }
        if (pSDEDataSyncBase.isOutPSDEDataSetNameDirty() && (bl || pSDEDataSyncBase.getOutPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_OUTPSDEDATASETNAME, (Object)pSDEDataSyncBase.getOutPSDEDataSetName());
        }
        if (pSDEDataSyncBase.isOutPSSysDataSyncAgentIdDirty() && (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDATASYNCAGENTID, (Object)pSDEDataSyncBase.getOutPSSysDataSyncAgentId());
        }
        if (pSDEDataSyncBase.isOutPSSysDataSyncAgentNameDirty() && (bl || pSDEDataSyncBase.getOutPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_OUTPSSYSDATASYNCAGENTNAME, (Object)pSDEDataSyncBase.getOutPSSysDataSyncAgentName());
        }
        if (pSDEDataSyncBase.isOutTimerDirty() && (bl || pSDEDataSyncBase.getOutTimer() != null)) {
            iDataObject.set(FIELD_OUTTIMER, (Object)pSDEDataSyncBase.getOutTimer());
        }
        if (pSDEDataSyncBase.isPSDEDataSyncIdDirty() && (bl || pSDEDataSyncBase.getPSDEDataSyncId() != null)) {
            iDataObject.set(FIELD_PSDEDATASYNCID, (Object)pSDEDataSyncBase.getPSDEDataSyncId());
        }
        if (pSDEDataSyncBase.isPSDEDataSyncNameDirty() && (bl || pSDEDataSyncBase.getPSDEDataSyncName() != null)) {
            iDataObject.set(FIELD_PSDEDATASYNCNAME, (Object)pSDEDataSyncBase.getPSDEDataSyncName());
        }
        if (pSDEDataSyncBase.isPSDEIdDirty() && (bl || pSDEDataSyncBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDataSyncBase.getPSDEId());
        }
        if (pSDEDataSyncBase.isPSDENameDirty() && (bl || pSDEDataSyncBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDataSyncBase.getPSDEName());
        }
        if (pSDEDataSyncBase.isPSDynaInstIdDirty() && (bl || pSDEDataSyncBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEDataSyncBase.getPSDynaInstId());
        }
        if (pSDEDataSyncBase.isPSSysReqItemIdDirty() && (bl || pSDEDataSyncBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEDataSyncBase.getPSSysReqItemId());
        }
        if (pSDEDataSyncBase.isPSSysReqItemNameDirty() && (bl || pSDEDataSyncBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEDataSyncBase.getPSSysReqItemName());
        }
        if (pSDEDataSyncBase.isPSSysSFPluginIdDirty() && (bl || pSDEDataSyncBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEDataSyncBase.getPSSysSFPluginId());
        }
        if (pSDEDataSyncBase.isPSSysSFPluginNameDirty() && (bl || pSDEDataSyncBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEDataSyncBase.getPSSysSFPluginName());
        }
        if (pSDEDataSyncBase.isSyncDirDirty() && (bl || pSDEDataSyncBase.getSyncDir() != null)) {
            iDataObject.set(FIELD_SYNCDIR, (Object)pSDEDataSyncBase.getSyncDir());
        }
        if (pSDEDataSyncBase.isSyncExportDirty() && (bl || pSDEDataSyncBase.getSyncExport() != null)) {
            iDataObject.set(FIELD_SYNCEXPORT, (Object)pSDEDataSyncBase.getSyncExport());
        }
        if (pSDEDataSyncBase.isTimerModeDirty() && (bl || pSDEDataSyncBase.getTimerMode() != null)) {
            iDataObject.set(FIELD_TIMERMODE, (Object)pSDEDataSyncBase.getTimerMode());
        }
        if (pSDEDataSyncBase.isToDoTaskDirty() && (bl || pSDEDataSyncBase.getToDoTask() != null)) {
            iDataObject.set(FIELD_TODOTASK, (Object)pSDEDataSyncBase.getToDoTask());
        }
        if (pSDEDataSyncBase.isUpdateDateDirty() && (bl || pSDEDataSyncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDataSyncBase.getUpdateDate());
        }
        if (pSDEDataSyncBase.isUpdateManDirty() && (bl || pSDEDataSyncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDataSyncBase.getUpdateMan());
        }
        if (pSDEDataSyncBase.isUserCatDirty() && (bl || pSDEDataSyncBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEDataSyncBase.getUserCat());
        }
        if (pSDEDataSyncBase.isUserTagDirty() && (bl || pSDEDataSyncBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEDataSyncBase.getUserTag());
        }
        if (pSDEDataSyncBase.isUserTag2Dirty() && (bl || pSDEDataSyncBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEDataSyncBase.getUserTag2());
        }
        if (pSDEDataSyncBase.isUserTag3Dirty() && (bl || pSDEDataSyncBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEDataSyncBase.getUserTag3());
        }
        if (pSDEDataSyncBase.isUserTag4Dirty() && (bl || pSDEDataSyncBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEDataSyncBase.getUserTag4());
        }
        if (pSDEDataSyncBase.isValidFlagDirty() && (bl || pSDEDataSyncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEDataSyncBase.getValidFlag());
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
        return PSDEDataSyncBase.remove(this, n);
    }

    private static boolean remove(PSDEDataSyncBase pSDEDataSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDataSyncBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEDataSyncBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEDataSyncBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEDataSyncBase.resetDENames();
                return true;
            }
            case 4: {
                pSDEDataSyncBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSDEDataSyncBase.resetEventType();
                return true;
            }
            case 6: {
                pSDEDataSyncBase.resetExportFull();
                return true;
            }
            case 7: {
                pSDEDataSyncBase.resetFilterModel();
                return true;
            }
            case 8: {
                pSDEDataSyncBase.resetImportPSDEActionId();
                return true;
            }
            case 9: {
                pSDEDataSyncBase.resetImportPSDEActionName();
                return true;
            }
            case 10: {
                pSDEDataSyncBase.resetInCustomCode();
                return true;
            }
            case 11: {
                pSDEDataSyncBase.resetInCustomMode();
                return true;
            }
            case 12: {
                pSDEDataSyncBase.resetInPSDEActionId();
                return true;
            }
            case 13: {
                pSDEDataSyncBase.resetInPSDEActionName();
                return true;
            }
            case 14: {
                pSDEDataSyncBase.resetInPSDEDataSetId();
                return true;
            }
            case 15: {
                pSDEDataSyncBase.resetInPSDEDataSetName();
                return true;
            }
            case 16: {
                pSDEDataSyncBase.resetInPSSysDataSyncAgentId();
                return true;
            }
            case 17: {
                pSDEDataSyncBase.resetInPSSysDataSyncAgentName();
                return true;
            }
            case 18: {
                pSDEDataSyncBase.resetLockFlag();
                return true;
            }
            case 19: {
                pSDEDataSyncBase.resetMemo();
                return true;
            }
            case 20: {
                pSDEDataSyncBase.resetOutCustomCode();
                return true;
            }
            case 21: {
                pSDEDataSyncBase.resetOutCustomMode();
                return true;
            }
            case 22: {
                pSDEDataSyncBase.resetOutMode();
                return true;
            }
            case 23: {
                pSDEDataSyncBase.resetOutPSDEActionId();
                return true;
            }
            case 24: {
                pSDEDataSyncBase.resetOutPSDEActionName();
                return true;
            }
            case 25: {
                pSDEDataSyncBase.resetOutPSDEDataSetId();
                return true;
            }
            case 26: {
                pSDEDataSyncBase.resetOutPSDEDataSetName();
                return true;
            }
            case 27: {
                pSDEDataSyncBase.resetOutPSSysDataSyncAgentId();
                return true;
            }
            case 28: {
                pSDEDataSyncBase.resetOutPSSysDataSyncAgentName();
                return true;
            }
            case 29: {
                pSDEDataSyncBase.resetOutTimer();
                return true;
            }
            case 30: {
                pSDEDataSyncBase.resetPSDEDataSyncId();
                return true;
            }
            case 31: {
                pSDEDataSyncBase.resetPSDEDataSyncName();
                return true;
            }
            case 32: {
                pSDEDataSyncBase.resetPSDEId();
                return true;
            }
            case 33: {
                pSDEDataSyncBase.resetPSDEName();
                return true;
            }
            case 34: {
                pSDEDataSyncBase.resetPSDynaInstId();
                return true;
            }
            case 35: {
                pSDEDataSyncBase.resetPSSysReqItemId();
                return true;
            }
            case 36: {
                pSDEDataSyncBase.resetPSSysReqItemName();
                return true;
            }
            case 37: {
                pSDEDataSyncBase.resetPSSysSFPluginId();
                return true;
            }
            case 38: {
                pSDEDataSyncBase.resetPSSysSFPluginName();
                return true;
            }
            case 39: {
                pSDEDataSyncBase.resetSyncDir();
                return true;
            }
            case 40: {
                pSDEDataSyncBase.resetSyncExport();
                return true;
            }
            case 41: {
                pSDEDataSyncBase.resetTimerMode();
                return true;
            }
            case 42: {
                pSDEDataSyncBase.resetToDoTask();
                return true;
            }
            case 43: {
                pSDEDataSyncBase.resetUpdateDate();
                return true;
            }
            case 44: {
                pSDEDataSyncBase.resetUpdateMan();
                return true;
            }
            case 45: {
                pSDEDataSyncBase.resetUserCat();
                return true;
            }
            case 46: {
                pSDEDataSyncBase.resetUserTag();
                return true;
            }
            case 47: {
                pSDEDataSyncBase.resetUserTag2();
                return true;
            }
            case 48: {
                pSDEDataSyncBase.resetUserTag3();
                return true;
            }
            case 49: {
                pSDEDataSyncBase.resetUserTag4();
                return true;
            }
            case 50: {
                pSDEDataSyncBase.resetValidFlag();
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
    public PSDEAction getImportPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportPSDEAction();
        }
        if (this.getImportPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objImportPSDEActionLock;
        synchronized (n) {
            if (this.importpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getImportPSDEActionId(), (Object)this.importpsdeaction.getPSDEActionId()) != 0L) {
                this.importpsdeaction = null;
            }
            if (this.importpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getImportPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.importpsdeaction = pSDEAction;
            }
            return this.importpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getInPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEAction();
        }
        if (this.getInPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objInPSDEActionLock;
        synchronized (n) {
            if (this.inpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getInPSDEActionId(), (Object)this.inpsdeaction.getPSDEActionId()) != 0L) {
                this.inpsdeaction = null;
            }
            if (this.inpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getInPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.inpsdeaction = pSDEAction;
            }
            return this.inpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getOutPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEAction();
        }
        if (this.getOutPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objOutPSDEActionLock;
        synchronized (n) {
            if (this.outpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSDEActionId(), (Object)this.outpsdeaction.getPSDEActionId()) != 0L) {
                this.outpsdeaction = null;
            }
            if (this.outpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getOutPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.outpsdeaction = pSDEAction;
            }
            return this.outpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getInPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSDEDataSet();
        }
        if (this.getInPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objInPSDEDataSetLock;
        synchronized (n) {
            if (this.inpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getInPSDEDataSetId(), (Object)this.inpsdedataset.getPSDEDataSetId()) != 0L) {
                this.inpsdedataset = null;
            }
            if (this.inpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getInPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.inpsdedataset = pSDEDataSet;
            }
            return this.inpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getOutPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSDEDataSet();
        }
        if (this.getOutPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objOutPSDEDataSetLock;
        synchronized (n) {
            if (this.outpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSDEDataSetId(), (Object)this.outpsdedataset.getPSDEDataSetId()) != 0L) {
                this.outpsdedataset = null;
            }
            if (this.outpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getOutPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.outpsdedataset = pSDEDataSet;
            }
            return this.outpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDataSyncAgent getInPSSysDataSyncAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInPSSysDataSyncAgent();
        }
        if (this.getInPSSysDataSyncAgentId() == null) {
            return null;
        }
        Integer n = this.objInPSSysDataSyncAgentLock;
        synchronized (n) {
            if (this.inpssysdatasyncagent != null && DataTypeHelper.compare((int)25, (Object)this.getInPSSysDataSyncAgentId(), (Object)this.inpssysdatasyncagent.getPSSysDataSyncAgentId()) != 0L) {
                this.inpssysdatasyncagent = null;
            }
            if (this.inpssysdatasyncagent == null) {
                PSSysDataSyncAgent pSSysDataSyncAgent = new PSSysDataSyncAgent();
                pSSysDataSyncAgent.setPSSysDataSyncAgentId(this.getInPSSysDataSyncAgentId());
                PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysDataSyncAgentService.autoGet((IEntity)pSSysDataSyncAgent);
                this.inpssysdatasyncagent = pSSysDataSyncAgent;
            }
            return this.inpssysdatasyncagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDataSyncAgent getOutPSSysDataSyncAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOutPSSysDataSyncAgent();
        }
        if (this.getOutPSSysDataSyncAgentId() == null) {
            return null;
        }
        Integer n = this.objOutPSSysDataSyncAgentLock;
        synchronized (n) {
            if (this.outpssysdatasyncagent != null && DataTypeHelper.compare((int)25, (Object)this.getOutPSSysDataSyncAgentId(), (Object)this.outpssysdatasyncagent.getPSSysDataSyncAgentId()) != 0L) {
                this.outpssysdatasyncagent = null;
            }
            if (this.outpssysdatasyncagent == null) {
                PSSysDataSyncAgent pSSysDataSyncAgent = new PSSysDataSyncAgent();
                pSSysDataSyncAgent.setPSSysDataSyncAgentId(this.getOutPSSysDataSyncAgentId());
                PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysDataSyncAgentService.autoGet((IEntity)pSSysDataSyncAgent);
                this.outpssysdatasyncagent = pSSysDataSyncAgent;
            }
            return this.outpssysdatasyncagent;
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

    private PSDEDataSyncBase getProxyEntity() {
        return this.proxyPSDEDataSyncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDataSyncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDataSyncBase) {
            this.proxyPSDEDataSyncBase = (PSDEDataSyncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DENAMES, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_EVENTTYPE, 5);
        fieldIndexMap.put(FIELD_EXPORTFULL, 6);
        fieldIndexMap.put(FIELD_FILTERMODEL, 7);
        fieldIndexMap.put(FIELD_IMPORTPSDEACTIONID, 8);
        fieldIndexMap.put(FIELD_IMPORTPSDEACTIONNAME, 9);
        fieldIndexMap.put(FIELD_INCUSTOMCODE, 10);
        fieldIndexMap.put(FIELD_INCUSTOMMODE, 11);
        fieldIndexMap.put(FIELD_INPSDEACTIONID, 12);
        fieldIndexMap.put(FIELD_INPSDEACTIONNAME, 13);
        fieldIndexMap.put(FIELD_INPSDEDATASETID, 14);
        fieldIndexMap.put(FIELD_INPSDEDATASETNAME, 15);
        fieldIndexMap.put(FIELD_INPSSYSDATASYNCAGENTID, 16);
        fieldIndexMap.put(FIELD_INPSSYSDATASYNCAGENTNAME, 17);
        fieldIndexMap.put(FIELD_LOCKFLAG, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_OUTCUSTOMCODE, 20);
        fieldIndexMap.put(FIELD_OUTCUSTOMMODE, 21);
        fieldIndexMap.put(FIELD_OUTMODE, 22);
        fieldIndexMap.put(FIELD_OUTPSDEACTIONID, 23);
        fieldIndexMap.put(FIELD_OUTPSDEACTIONNAME, 24);
        fieldIndexMap.put(FIELD_OUTPSDEDATASETID, 25);
        fieldIndexMap.put(FIELD_OUTPSDEDATASETNAME, 26);
        fieldIndexMap.put(FIELD_OUTPSSYSDATASYNCAGENTID, 27);
        fieldIndexMap.put(FIELD_OUTPSSYSDATASYNCAGENTNAME, 28);
        fieldIndexMap.put(FIELD_OUTTIMER, 29);
        fieldIndexMap.put(FIELD_PSDEDATASYNCID, 30);
        fieldIndexMap.put(FIELD_PSDEDATASYNCNAME, 31);
        fieldIndexMap.put(FIELD_PSDEID, 32);
        fieldIndexMap.put(FIELD_PSDENAME, 33);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 34);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 35);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 36);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 37);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 38);
        fieldIndexMap.put(FIELD_SYNCDIR, 39);
        fieldIndexMap.put(FIELD_SYNCEXPORT, 40);
        fieldIndexMap.put(FIELD_TIMERMODE, 41);
        fieldIndexMap.put(FIELD_TODOTASK, 42);
        fieldIndexMap.put(FIELD_UPDATEDATE, 43);
        fieldIndexMap.put(FIELD_UPDATEMAN, 44);
        fieldIndexMap.put(FIELD_USERCAT, 45);
        fieldIndexMap.put(FIELD_USERTAG, 46);
        fieldIndexMap.put(FIELD_USERTAG2, 47);
        fieldIndexMap.put(FIELD_USERTAG3, 48);
        fieldIndexMap.put(FIELD_USERTAG4, 49);
        fieldIndexMap.put(FIELD_VALIDFLAG, 50);
    }
}

