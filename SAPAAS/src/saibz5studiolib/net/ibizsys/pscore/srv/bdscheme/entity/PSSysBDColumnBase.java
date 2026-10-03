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
package net.ibizsys.pscore.srv.bdscheme.entity;

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
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDColSet;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableDE;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColSetService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableDEService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDColumnBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBDColumnBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FULLCOLNAME = "FULLCOLNAME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSBDCOLSETID = "PSSYSBDCOLSETID";
    public static final String FIELD_PSSYSBDCOLSETNAME = "PSSYSBDCOLSETNAME";
    public static final String FIELD_PSSYSBDCOLUMNID = "PSSYSBDCOLUMNID";
    public static final String FIELD_PSSYSBDCOLUMNNAME = "PSSYSBDCOLUMNNAME";
    public static final String FIELD_PSSYSBDTABLEDEID = "PSSYSBDTABLEDEID";
    public static final String FIELD_PSSYSBDTABLEDENAME = "PSSYSBDTABLEDENAME";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String FIELD_UNIONKEYVALUE = "UNIONKEYVALUE";
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
    private static final int INDEX_FULLCOLNAME = 3;
    private static final int INDEX_LOGICNAME = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEFID = 6;
    private static final int INDEX_PSDEFNAME = 7;
    private static final int INDEX_PSDEID = 8;
    private static final int INDEX_PSDENAME = 9;
    private static final int INDEX_PSSYSBDCOLSETID = 10;
    private static final int INDEX_PSSYSBDCOLSETNAME = 11;
    private static final int INDEX_PSSYSBDCOLUMNID = 12;
    private static final int INDEX_PSSYSBDCOLUMNNAME = 13;
    private static final int INDEX_PSSYSBDTABLEDEID = 14;
    private static final int INDEX_PSSYSBDTABLEDENAME = 15;
    private static final int INDEX_PSSYSBDTABLEID = 16;
    private static final int INDEX_PSSYSBDTABLENAME = 17;
    private static final int INDEX_UNIONKEYVALUE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBDColumnBase proxyPSSysBDColumnBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fullcolnameDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysbdcolsetidDirtyFlag = false;
    private boolean pssysbdcolsetnameDirtyFlag = false;
    private boolean pssysbdcolumnidDirtyFlag = false;
    private boolean pssysbdcolumnnameDirtyFlag = false;
    private boolean pssysbdtabledeidDirtyFlag = false;
    private boolean pssysbdtabledenameDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
    private boolean unionkeyvalueDirtyFlag = false;
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
    @Column(name="fullcolname")
    private String fullcolname;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysbdcolsetid")
    private String pssysbdcolsetid;
    @Column(name="pssysbdcolsetname")
    private String pssysbdcolsetname;
    @Column(name="pssysbdcolumnid")
    private String pssysbdcolumnid;
    @Column(name="pssysbdcolumnname")
    private String pssysbdcolumnname;
    @Column(name="pssysbdtabledeid")
    private String pssysbdtabledeid;
    @Column(name="pssysbdtabledename")
    private String pssysbdtabledename;
    @Column(name="pssysbdtableid")
    private String pssysbdtableid;
    @Column(name="pssysbdtablename")
    private String pssysbdtablename;
    @Column(name="unionkeyvalue")
    private String unionkeyvalue;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSSysBDColSetLock = new Integer(1);
    private PSSysBDColSet pssysbdcolset = null;
    private Integer objPSSysBDTableDELock = new Integer(1);
    private PSSysBDTableDE pssysbdtablede = null;
    private Integer objPSSysBDTableLock = new Integer(1);
    private PSSysBDTable pssysbdtable = null;

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

    public void setFullColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullcolname = string;
        this.fullcolnameDirtyFlag = true;
    }

    public String getFullColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullColName();
        }
        return this.fullcolname;
    }

    public boolean isFullColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullColNameDirty();
        }
        return this.fullcolnameDirtyFlag;
    }

    public void resetFullColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullColName();
            return;
        }
        this.fullcolnameDirtyFlag = false;
        this.fullcolname = null;
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

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSSysBDColSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdcolsetid = string;
        this.pssysbdcolsetidDirtyFlag = true;
    }

    public String getPSSysBDColSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSetId();
        }
        return this.pssysbdcolsetid;
    }

    public boolean isPSSysBDColSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColSetIdDirty();
        }
        return this.pssysbdcolsetidDirtyFlag;
    }

    public void resetPSSysBDColSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColSetId();
            return;
        }
        this.pssysbdcolsetidDirtyFlag = false;
        this.pssysbdcolsetid = null;
    }

    public void setPSSysBDColSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdcolsetname = string;
        this.pssysbdcolsetnameDirtyFlag = true;
    }

    public String getPSSysBDColSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSetName();
        }
        return this.pssysbdcolsetname;
    }

    public boolean isPSSysBDColSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColSetNameDirty();
        }
        return this.pssysbdcolsetnameDirtyFlag;
    }

    public void resetPSSysBDColSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColSetName();
            return;
        }
        this.pssysbdcolsetnameDirtyFlag = false;
        this.pssysbdcolsetname = null;
    }

    public void setPSSysBDColumnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColumnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdcolumnid = string;
        this.pssysbdcolumnidDirtyFlag = true;
    }

    public String getPSSysBDColumnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColumnId();
        }
        return this.pssysbdcolumnid;
    }

    public boolean isPSSysBDColumnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColumnIdDirty();
        }
        return this.pssysbdcolumnidDirtyFlag;
    }

    public void resetPSSysBDColumnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColumnId();
            return;
        }
        this.pssysbdcolumnidDirtyFlag = false;
        this.pssysbdcolumnid = null;
    }

    public void setPSSysBDColumnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDColumnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysbdcolumnname = string;
        this.pssysbdcolumnnameDirtyFlag = true;
    }

    public String getPSSysBDColumnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColumnName();
        }
        return this.pssysbdcolumnname;
    }

    public boolean isPSSysBDColumnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDColumnNameDirty();
        }
        return this.pssysbdcolumnnameDirtyFlag;
    }

    public void resetPSSysBDColumnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDColumnName();
            return;
        }
        this.pssysbdcolumnnameDirtyFlag = false;
        this.pssysbdcolumnname = null;
    }

    public void setPSSysBDTableDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtabledeid = string;
        this.pssysbdtabledeidDirtyFlag = true;
    }

    public String getPSSysBDTableDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDEId();
        }
        return this.pssysbdtabledeid;
    }

    public boolean isPSSysBDTableDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDEIdDirty();
        }
        return this.pssysbdtabledeidDirtyFlag;
    }

    public void resetPSSysBDTableDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDEId();
            return;
        }
        this.pssysbdtabledeidDirtyFlag = false;
        this.pssysbdtabledeid = null;
    }

    public void setPSSysBDTableDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtabledename = string;
        this.pssysbdtabledenameDirtyFlag = true;
    }

    public String getPSSysBDTableDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDEName();
        }
        return this.pssysbdtabledename;
    }

    public boolean isPSSysBDTableDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableDENameDirty();
        }
        return this.pssysbdtabledenameDirtyFlag;
    }

    public void resetPSSysBDTableDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableDEName();
            return;
        }
        this.pssysbdtabledenameDirtyFlag = false;
        this.pssysbdtabledename = null;
    }

    public void setPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtableid = string;
        this.pssysbdtableidDirtyFlag = true;
    }

    public String getPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableId();
        }
        return this.pssysbdtableid;
    }

    public boolean isPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableIdDirty();
        }
        return this.pssysbdtableidDirtyFlag;
    }

    public void resetPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableId();
            return;
        }
        this.pssysbdtableidDirtyFlag = false;
        this.pssysbdtableid = null;
    }

    public void setPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablename = string;
        this.pssysbdtablenameDirtyFlag = true;
    }

    public String getPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableName();
        }
        return this.pssysbdtablename;
    }

    public boolean isPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableNameDirty();
        }
        return this.pssysbdtablenameDirtyFlag;
    }

    public void resetPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableName();
            return;
        }
        this.pssysbdtablenameDirtyFlag = false;
        this.pssysbdtablename = null;
    }

    public void setUnionKeyValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnionKeyValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.unionkeyvalue = string;
        this.unionkeyvalueDirtyFlag = true;
    }

    public String getUnionKeyValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnionKeyValue();
        }
        return this.unionkeyvalue;
    }

    public boolean isUnionKeyValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnionKeyValueDirty();
        }
        return this.unionkeyvalueDirtyFlag;
    }

    public void resetUnionKeyValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnionKeyValue();
            return;
        }
        this.unionkeyvalueDirtyFlag = false;
        this.unionkeyvalue = null;
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
        PSSysBDColumnBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBDColumnBase pSSysBDColumnBase) {
        pSSysBDColumnBase.resetCodeName();
        pSSysBDColumnBase.resetCreateDate();
        pSSysBDColumnBase.resetCreateMan();
        pSSysBDColumnBase.resetFullColName();
        pSSysBDColumnBase.resetLogicName();
        pSSysBDColumnBase.resetMemo();
        pSSysBDColumnBase.resetPSDEFId();
        pSSysBDColumnBase.resetPSDEFName();
        pSSysBDColumnBase.resetPSDEId();
        pSSysBDColumnBase.resetPSDEName();
        pSSysBDColumnBase.resetPSSysBDColSetId();
        pSSysBDColumnBase.resetPSSysBDColSetName();
        pSSysBDColumnBase.resetPSSysBDColumnId();
        pSSysBDColumnBase.resetPSSysBDColumnName();
        pSSysBDColumnBase.resetPSSysBDTableDEId();
        pSSysBDColumnBase.resetPSSysBDTableDEName();
        pSSysBDColumnBase.resetPSSysBDTableId();
        pSSysBDColumnBase.resetPSSysBDTableName();
        pSSysBDColumnBase.resetUnionKeyValue();
        pSSysBDColumnBase.resetUpdateDate();
        pSSysBDColumnBase.resetUpdateMan();
        pSSysBDColumnBase.resetUserCat();
        pSSysBDColumnBase.resetUserTag();
        pSSysBDColumnBase.resetUserTag2();
        pSSysBDColumnBase.resetUserTag3();
        pSSysBDColumnBase.resetUserTag4();
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
        if (!bl || this.isFullColNameDirty()) {
            hashMap.put(FIELD_FULLCOLNAME, this.getFullColName());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysBDColSetIdDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLSETID, this.getPSSysBDColSetId());
        }
        if (!bl || this.isPSSysBDColSetNameDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLSETNAME, this.getPSSysBDColSetName());
        }
        if (!bl || this.isPSSysBDColumnIdDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLUMNID, this.getPSSysBDColumnId());
        }
        if (!bl || this.isPSSysBDColumnNameDirty()) {
            hashMap.put(FIELD_PSSYSBDCOLUMNNAME, this.getPSSysBDColumnName());
        }
        if (!bl || this.isPSSysBDTableDEIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDEID, this.getPSSysBDTableDEId());
        }
        if (!bl || this.isPSSysBDTableDENameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEDENAME, this.getPSSysBDTableDEName());
        }
        if (!bl || this.isPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEID, this.getPSSysBDTableId());
        }
        if (!bl || this.isPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLENAME, this.getPSSysBDTableName());
        }
        if (!bl || this.isUnionKeyValueDirty()) {
            hashMap.put(FIELD_UNIONKEYVALUE, this.getUnionKeyValue());
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
        return PSSysBDColumnBase.get(this, n);
    }

    private static Object get(PSSysBDColumnBase pSSysBDColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColumnBase.getCodeName();
            }
            case 1: {
                return pSSysBDColumnBase.getCreateDate();
            }
            case 2: {
                return pSSysBDColumnBase.getCreateMan();
            }
            case 3: {
                return pSSysBDColumnBase.getFullColName();
            }
            case 4: {
                return pSSysBDColumnBase.getLogicName();
            }
            case 5: {
                return pSSysBDColumnBase.getMemo();
            }
            case 6: {
                return pSSysBDColumnBase.getPSDEFId();
            }
            case 7: {
                return pSSysBDColumnBase.getPSDEFName();
            }
            case 8: {
                return pSSysBDColumnBase.getPSDEId();
            }
            case 9: {
                return pSSysBDColumnBase.getPSDEName();
            }
            case 10: {
                return pSSysBDColumnBase.getPSSysBDColSetId();
            }
            case 11: {
                return pSSysBDColumnBase.getPSSysBDColSetName();
            }
            case 12: {
                return pSSysBDColumnBase.getPSSysBDColumnId();
            }
            case 13: {
                return pSSysBDColumnBase.getPSSysBDColumnName();
            }
            case 14: {
                return pSSysBDColumnBase.getPSSysBDTableDEId();
            }
            case 15: {
                return pSSysBDColumnBase.getPSSysBDTableDEName();
            }
            case 16: {
                return pSSysBDColumnBase.getPSSysBDTableId();
            }
            case 17: {
                return pSSysBDColumnBase.getPSSysBDTableName();
            }
            case 18: {
                return pSSysBDColumnBase.getUnionKeyValue();
            }
            case 19: {
                return pSSysBDColumnBase.getUpdateDate();
            }
            case 20: {
                return pSSysBDColumnBase.getUpdateMan();
            }
            case 21: {
                return pSSysBDColumnBase.getUserCat();
            }
            case 22: {
                return pSSysBDColumnBase.getUserTag();
            }
            case 23: {
                return pSSysBDColumnBase.getUserTag2();
            }
            case 24: {
                return pSSysBDColumnBase.getUserTag3();
            }
            case 25: {
                return pSSysBDColumnBase.getUserTag4();
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
        PSSysBDColumnBase.set(this, n, object);
    }

    private static void set(PSSysBDColumnBase pSSysBDColumnBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDColumnBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBDColumnBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysBDColumnBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBDColumnBase.setFullColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBDColumnBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBDColumnBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBDColumnBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBDColumnBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBDColumnBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBDColumnBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBDColumnBase.setPSSysBDColSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBDColumnBase.setPSSysBDColSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBDColumnBase.setPSSysBDColumnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBDColumnBase.setPSSysBDColumnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBDColumnBase.setPSSysBDTableDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBDColumnBase.setPSSysBDTableDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBDColumnBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBDColumnBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBDColumnBase.setUnionKeyValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBDColumnBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSSysBDColumnBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBDColumnBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBDColumnBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBDColumnBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBDColumnBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBDColumnBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysBDColumnBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBDColumnBase pSSysBDColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColumnBase.getCodeName() == null;
            }
            case 1: {
                return pSSysBDColumnBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysBDColumnBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysBDColumnBase.getFullColName() == null;
            }
            case 4: {
                return pSSysBDColumnBase.getLogicName() == null;
            }
            case 5: {
                return pSSysBDColumnBase.getMemo() == null;
            }
            case 6: {
                return pSSysBDColumnBase.getPSDEFId() == null;
            }
            case 7: {
                return pSSysBDColumnBase.getPSDEFName() == null;
            }
            case 8: {
                return pSSysBDColumnBase.getPSDEId() == null;
            }
            case 9: {
                return pSSysBDColumnBase.getPSDEName() == null;
            }
            case 10: {
                return pSSysBDColumnBase.getPSSysBDColSetId() == null;
            }
            case 11: {
                return pSSysBDColumnBase.getPSSysBDColSetName() == null;
            }
            case 12: {
                return pSSysBDColumnBase.getPSSysBDColumnId() == null;
            }
            case 13: {
                return pSSysBDColumnBase.getPSSysBDColumnName() == null;
            }
            case 14: {
                return pSSysBDColumnBase.getPSSysBDTableDEId() == null;
            }
            case 15: {
                return pSSysBDColumnBase.getPSSysBDTableDEName() == null;
            }
            case 16: {
                return pSSysBDColumnBase.getPSSysBDTableId() == null;
            }
            case 17: {
                return pSSysBDColumnBase.getPSSysBDTableName() == null;
            }
            case 18: {
                return pSSysBDColumnBase.getUnionKeyValue() == null;
            }
            case 19: {
                return pSSysBDColumnBase.getUpdateDate() == null;
            }
            case 20: {
                return pSSysBDColumnBase.getUpdateMan() == null;
            }
            case 21: {
                return pSSysBDColumnBase.getUserCat() == null;
            }
            case 22: {
                return pSSysBDColumnBase.getUserTag() == null;
            }
            case 23: {
                return pSSysBDColumnBase.getUserTag2() == null;
            }
            case 24: {
                return pSSysBDColumnBase.getUserTag3() == null;
            }
            case 25: {
                return pSSysBDColumnBase.getUserTag4() == null;
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
        return PSSysBDColumnBase.contains(this, n);
    }

    private static boolean contains(PSSysBDColumnBase pSSysBDColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBDColumnBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysBDColumnBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysBDColumnBase.isCreateManDirty();
            }
            case 3: {
                return pSSysBDColumnBase.isFullColNameDirty();
            }
            case 4: {
                return pSSysBDColumnBase.isLogicNameDirty();
            }
            case 5: {
                return pSSysBDColumnBase.isMemoDirty();
            }
            case 6: {
                return pSSysBDColumnBase.isPSDEFIdDirty();
            }
            case 7: {
                return pSSysBDColumnBase.isPSDEFNameDirty();
            }
            case 8: {
                return pSSysBDColumnBase.isPSDEIdDirty();
            }
            case 9: {
                return pSSysBDColumnBase.isPSDENameDirty();
            }
            case 10: {
                return pSSysBDColumnBase.isPSSysBDColSetIdDirty();
            }
            case 11: {
                return pSSysBDColumnBase.isPSSysBDColSetNameDirty();
            }
            case 12: {
                return pSSysBDColumnBase.isPSSysBDColumnIdDirty();
            }
            case 13: {
                return pSSysBDColumnBase.isPSSysBDColumnNameDirty();
            }
            case 14: {
                return pSSysBDColumnBase.isPSSysBDTableDEIdDirty();
            }
            case 15: {
                return pSSysBDColumnBase.isPSSysBDTableDENameDirty();
            }
            case 16: {
                return pSSysBDColumnBase.isPSSysBDTableIdDirty();
            }
            case 17: {
                return pSSysBDColumnBase.isPSSysBDTableNameDirty();
            }
            case 18: {
                return pSSysBDColumnBase.isUnionKeyValueDirty();
            }
            case 19: {
                return pSSysBDColumnBase.isUpdateDateDirty();
            }
            case 20: {
                return pSSysBDColumnBase.isUpdateManDirty();
            }
            case 21: {
                return pSSysBDColumnBase.isUserCatDirty();
            }
            case 22: {
                return pSSysBDColumnBase.isUserTagDirty();
            }
            case 23: {
                return pSSysBDColumnBase.isUserTag2Dirty();
            }
            case 24: {
                return pSSysBDColumnBase.isUserTag3Dirty();
            }
            case 25: {
                return pSSysBDColumnBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBDColumnBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBDColumnBase pSSysBDColumnBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBDColumnBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getFullColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcolname", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getFullColName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolsetid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDColSetId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolsetname", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDColSetName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColumnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolumnid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDColumnId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColumnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdcolumnname", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDColumnName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtabledeid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDTableDEId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtabledename", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDTableDEName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUnionKeyValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unionkeyvalue", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUnionKeyValue()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBDColumnBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBDColumnBase.getJSONValue((Object)pSSysBDColumnBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBDColumnBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBDColumnBase pSSysBDColumnBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBDColumnBase.getCodeName() != null) {
            object = pSSysBDColumnBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getCreateDate() != null) {
            object = pSSysBDColumnBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDColumnBase.getCreateMan() != null) {
            object = pSSysBDColumnBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getFullColName() != null) {
            object = pSSysBDColumnBase.getFullColName();
            xmlNode.setAttribute(FIELD_FULLCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getLogicName() != null) {
            object = pSSysBDColumnBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getMemo() != null) {
            object = pSSysBDColumnBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSDEFId() != null) {
            object = pSSysBDColumnBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSDEFName() != null) {
            object = pSSysBDColumnBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSDEId() != null) {
            object = pSSysBDColumnBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSDEName() != null) {
            object = pSSysBDColumnBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColSetId() != null) {
            object = pSSysBDColumnBase.getPSSysBDColSetId();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLSETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColSetName() != null) {
            object = pSSysBDColumnBase.getPSSysBDColSetName();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLSETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColumnId() != null) {
            object = pSSysBDColumnBase.getPSSysBDColumnId();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLUMNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDColumnName() != null) {
            object = pSSysBDColumnBase.getPSSysBDColumnName();
            xmlNode.setAttribute(FIELD_PSSYSBDCOLUMNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableDEId() != null) {
            object = pSSysBDColumnBase.getPSSysBDTableDEId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableDEName() != null) {
            object = pSSysBDColumnBase.getPSSysBDTableDEName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableId() != null) {
            object = pSSysBDColumnBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getPSSysBDTableName() != null) {
            object = pSSysBDColumnBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUnionKeyValue() != null) {
            object = pSSysBDColumnBase.getUnionKeyValue();
            xmlNode.setAttribute(FIELD_UNIONKEYVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUpdateDate() != null) {
            object = pSSysBDColumnBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBDColumnBase.getUpdateMan() != null) {
            object = pSSysBDColumnBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUserCat() != null) {
            object = pSSysBDColumnBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUserTag() != null) {
            object = pSSysBDColumnBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUserTag2() != null) {
            object = pSSysBDColumnBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUserTag3() != null) {
            object = pSSysBDColumnBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBDColumnBase.getUserTag4() != null) {
            object = pSSysBDColumnBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBDColumnBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBDColumnBase pSSysBDColumnBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBDColumnBase.isCodeNameDirty() && (bl || pSSysBDColumnBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBDColumnBase.getCodeName());
        }
        if (pSSysBDColumnBase.isCreateDateDirty() && (bl || pSSysBDColumnBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBDColumnBase.getCreateDate());
        }
        if (pSSysBDColumnBase.isCreateManDirty() && (bl || pSSysBDColumnBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBDColumnBase.getCreateMan());
        }
        if (pSSysBDColumnBase.isFullColNameDirty() && (bl || pSSysBDColumnBase.getFullColName() != null)) {
            iDataObject.set(FIELD_FULLCOLNAME, (Object)pSSysBDColumnBase.getFullColName());
        }
        if (pSSysBDColumnBase.isLogicNameDirty() && (bl || pSSysBDColumnBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysBDColumnBase.getLogicName());
        }
        if (pSSysBDColumnBase.isMemoDirty() && (bl || pSSysBDColumnBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBDColumnBase.getMemo());
        }
        if (pSSysBDColumnBase.isPSDEFIdDirty() && (bl || pSSysBDColumnBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBDColumnBase.getPSDEFId());
        }
        if (pSSysBDColumnBase.isPSDEFNameDirty() && (bl || pSSysBDColumnBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBDColumnBase.getPSDEFName());
        }
        if (pSSysBDColumnBase.isPSDEIdDirty() && (bl || pSSysBDColumnBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBDColumnBase.getPSDEId());
        }
        if (pSSysBDColumnBase.isPSDENameDirty() && (bl || pSSysBDColumnBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBDColumnBase.getPSDEName());
        }
        if (pSSysBDColumnBase.isPSSysBDColSetIdDirty() && (bl || pSSysBDColumnBase.getPSSysBDColSetId() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLSETID, (Object)pSSysBDColumnBase.getPSSysBDColSetId());
        }
        if (pSSysBDColumnBase.isPSSysBDColSetNameDirty() && (bl || pSSysBDColumnBase.getPSSysBDColSetName() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLSETNAME, (Object)pSSysBDColumnBase.getPSSysBDColSetName());
        }
        if (pSSysBDColumnBase.isPSSysBDColumnIdDirty() && (bl || pSSysBDColumnBase.getPSSysBDColumnId() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLUMNID, (Object)pSSysBDColumnBase.getPSSysBDColumnId());
        }
        if (pSSysBDColumnBase.isPSSysBDColumnNameDirty() && (bl || pSSysBDColumnBase.getPSSysBDColumnName() != null)) {
            iDataObject.set(FIELD_PSSYSBDCOLUMNNAME, (Object)pSSysBDColumnBase.getPSSysBDColumnName());
        }
        if (pSSysBDColumnBase.isPSSysBDTableDEIdDirty() && (bl || pSSysBDColumnBase.getPSSysBDTableDEId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDEID, (Object)pSSysBDColumnBase.getPSSysBDTableDEId());
        }
        if (pSSysBDColumnBase.isPSSysBDTableDENameDirty() && (bl || pSSysBDColumnBase.getPSSysBDTableDEName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEDENAME, (Object)pSSysBDColumnBase.getPSSysBDTableDEName());
        }
        if (pSSysBDColumnBase.isPSSysBDTableIdDirty() && (bl || pSSysBDColumnBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSSysBDColumnBase.getPSSysBDTableId());
        }
        if (pSSysBDColumnBase.isPSSysBDTableNameDirty() && (bl || pSSysBDColumnBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSSysBDColumnBase.getPSSysBDTableName());
        }
        if (pSSysBDColumnBase.isUnionKeyValueDirty() && (bl || pSSysBDColumnBase.getUnionKeyValue() != null)) {
            iDataObject.set(FIELD_UNIONKEYVALUE, (Object)pSSysBDColumnBase.getUnionKeyValue());
        }
        if (pSSysBDColumnBase.isUpdateDateDirty() && (bl || pSSysBDColumnBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBDColumnBase.getUpdateDate());
        }
        if (pSSysBDColumnBase.isUpdateManDirty() && (bl || pSSysBDColumnBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBDColumnBase.getUpdateMan());
        }
        if (pSSysBDColumnBase.isUserCatDirty() && (bl || pSSysBDColumnBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBDColumnBase.getUserCat());
        }
        if (pSSysBDColumnBase.isUserTagDirty() && (bl || pSSysBDColumnBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBDColumnBase.getUserTag());
        }
        if (pSSysBDColumnBase.isUserTag2Dirty() && (bl || pSSysBDColumnBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBDColumnBase.getUserTag2());
        }
        if (pSSysBDColumnBase.isUserTag3Dirty() && (bl || pSSysBDColumnBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBDColumnBase.getUserTag3());
        }
        if (pSSysBDColumnBase.isUserTag4Dirty() && (bl || pSSysBDColumnBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBDColumnBase.getUserTag4());
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
        return PSSysBDColumnBase.remove(this, n);
    }

    private static boolean remove(PSSysBDColumnBase pSSysBDColumnBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBDColumnBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysBDColumnBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysBDColumnBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysBDColumnBase.resetFullColName();
                return true;
            }
            case 4: {
                pSSysBDColumnBase.resetLogicName();
                return true;
            }
            case 5: {
                pSSysBDColumnBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBDColumnBase.resetPSDEFId();
                return true;
            }
            case 7: {
                pSSysBDColumnBase.resetPSDEFName();
                return true;
            }
            case 8: {
                pSSysBDColumnBase.resetPSDEId();
                return true;
            }
            case 9: {
                pSSysBDColumnBase.resetPSDEName();
                return true;
            }
            case 10: {
                pSSysBDColumnBase.resetPSSysBDColSetId();
                return true;
            }
            case 11: {
                pSSysBDColumnBase.resetPSSysBDColSetName();
                return true;
            }
            case 12: {
                pSSysBDColumnBase.resetPSSysBDColumnId();
                return true;
            }
            case 13: {
                pSSysBDColumnBase.resetPSSysBDColumnName();
                return true;
            }
            case 14: {
                pSSysBDColumnBase.resetPSSysBDTableDEId();
                return true;
            }
            case 15: {
                pSSysBDColumnBase.resetPSSysBDTableDEName();
                return true;
            }
            case 16: {
                pSSysBDColumnBase.resetPSSysBDTableId();
                return true;
            }
            case 17: {
                pSSysBDColumnBase.resetPSSysBDTableName();
                return true;
            }
            case 18: {
                pSSysBDColumnBase.resetUnionKeyValue();
                return true;
            }
            case 19: {
                pSSysBDColumnBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSSysBDColumnBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSSysBDColumnBase.resetUserCat();
                return true;
            }
            case 22: {
                pSSysBDColumnBase.resetUserTag();
                return true;
            }
            case 23: {
                pSSysBDColumnBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSSysBDColumnBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSSysBDColumnBase.resetUserTag4();
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
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDColSet getPSSysBDColSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDColSet();
        }
        if (this.getPSSysBDColSetId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDColSetLock;
        synchronized (n) {
            if (this.pssysbdcolset != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDColSetId(), (Object)this.pssysbdcolset.getPSSysBDColSetId()) != 0L) {
                this.pssysbdcolset = null;
            }
            if (this.pssysbdcolset == null) {
                PSSysBDColSet pSSysBDColSet = new PSSysBDColSet();
                pSSysBDColSet.setPSSysBDColSetId(this.getPSSysBDColSetId());
                PSSysBDColSetService pSSysBDColSetService = (PSSysBDColSetService)ServiceGlobal.getService(PSSysBDColSetService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDColSetService.autoGet(pSSysBDColSet);
                this.pssysbdcolset = pSSysBDColSet;
            }
            return this.pssysbdcolset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTableDE getPSSysBDTableDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableDE();
        }
        if (this.getPSSysBDTableDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDTableDELock;
        synchronized (n) {
            if (this.pssysbdtablede != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDTableDEId(), (Object)this.pssysbdtablede.getPSSysBDTableDEId()) != 0L) {
                this.pssysbdtablede = null;
            }
            if (this.pssysbdtablede == null) {
                PSSysBDTableDE pSSysBDTableDE = new PSSysBDTableDE();
                pSSysBDTableDE.setPSSysBDTableDEId(this.getPSSysBDTableDEId());
                PSSysBDTableDEService pSSysBDTableDEService = (PSSysBDTableDEService)ServiceGlobal.getService(PSSysBDTableDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableDEService.autoGet(pSSysBDTableDE);
                this.pssysbdtablede = pSSysBDTableDE;
            }
            return this.pssysbdtablede;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTable();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDTableLock;
        synchronized (n) {
            if (this.pssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDTableId(), (Object)this.pssysbdtable.getPSSysBDTableId()) != 0L) {
                this.pssysbdtable = null;
            }
            if (this.pssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet(pSSysBDTable);
                this.pssysbdtable = pSSysBDTable;
            }
            return this.pssysbdtable;
        }
    }

    private PSSysBDColumnBase getProxyEntity() {
        return this.proxyPSSysBDColumnBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBDColumnBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBDColumnBase) {
            this.proxyPSSysBDColumnBase = (PSSysBDColumnBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDColumnService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FULLCOLNAME, 3);
        fieldIndexMap.put(FIELD_LOGICNAME, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEFID, 6);
        fieldIndexMap.put(FIELD_PSDEFNAME, 7);
        fieldIndexMap.put(FIELD_PSDEID, 8);
        fieldIndexMap.put(FIELD_PSDENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSBDCOLSETID, 10);
        fieldIndexMap.put(FIELD_PSSYSBDCOLSETNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSBDCOLUMNID, 12);
        fieldIndexMap.put(FIELD_PSSYSBDCOLUMNNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDEID, 14);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEDENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEID, 16);
        fieldIndexMap.put(FIELD_PSSYSBDTABLENAME, 17);
        fieldIndexMap.put(FIELD_UNIONKEYVALUE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
    }
}

