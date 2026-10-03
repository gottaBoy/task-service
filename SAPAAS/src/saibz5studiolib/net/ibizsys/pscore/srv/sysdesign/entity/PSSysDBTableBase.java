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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBTableBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBTableBase.class);
    public static final String FIELD_AUTOEXTENDMODEL = "AUTOEXTENDMODEL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CODENAME2 = "CODENAME2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATESQL = "CREATESQL";
    public static final String FIELD_DROPSQL = "DROPSQL";
    public static final String FIELD_DSLINK = "DSLINK";
    public static final String FIELD_EXISTINGMODEL = "EXISTINGMODEL";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String FIELD_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String FIELD_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_TABDESC = "TABDESC";
    public static final String FIELD_TABLETAG = "TABLETAG";
    public static final String FIELD_TABLETAG2 = "TABLETAG2";
    public static final String FIELD_TABLETYPE = "TABLETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AUTOEXTENDMODEL = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CODENAME2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_CREATESQL = 5;
    private static final int INDEX_DROPSQL = 6;
    private static final int INDEX_DSLINK = 7;
    private static final int INDEX_EXISTINGMODEL = 8;
    private static final int INDEX_LOGICNAME = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSSYSDBSCHEMEID = 11;
    private static final int INDEX_PSSYSDBSCHEMENAME = 12;
    private static final int INDEX_PSSYSDBTABLEID = 13;
    private static final int INDEX_PSSYSDBTABLENAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_PSSYSTEMNAME = 16;
    private static final int INDEX_TABDESC = 17;
    private static final int INDEX_TABLETAG = 18;
    private static final int INDEX_TABLETAG2 = 19;
    private static final int INDEX_TABLETYPE = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBTableBase proxyPSSysDBTableBase = null;
    private boolean autoextendmodelDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean codename2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createsqlDirtyFlag = false;
    private boolean dropsqlDirtyFlag = false;
    private boolean dslinkDirtyFlag = false;
    private boolean existingmodelDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbschemenameDirtyFlag = false;
    private boolean pssysdbtableidDirtyFlag = false;
    private boolean pssysdbtablenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean tabdescDirtyFlag = false;
    private boolean tabletagDirtyFlag = false;
    private boolean tabletag2DirtyFlag = false;
    private boolean tabletypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="autoextendmodel")
    private Integer autoextendmodel;
    @Column(name="codename")
    private String codename;
    @Column(name="codename2")
    private String codename2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createsql")
    private String createsql;
    @Column(name="dropsql")
    private String dropsql;
    @Column(name="dslink")
    private String dslink;
    @Column(name="existingmodel")
    private Integer existingmodel;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbschemename")
    private String pssysdbschemename;
    @Column(name="pssysdbtableid")
    private String pssysdbtableid;
    @Column(name="pssysdbtablename")
    private String pssysdbtablename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="tabdesc")
    private String tabdesc;
    @Column(name="tabletag")
    private String tabletag;
    @Column(name="tabletag2")
    private String tabletag2;
    @Column(name="tabletype")
    private String tabletype;
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
    private Integer objPSSysDBSchemeLock = new Integer(1);
    private PSSysDBScheme pssysdbscheme = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysDBColumnsLock = new Integer(1);
    private ArrayList<PSSysDBColumn> pssysdbcolumns = null;

    public void setAutoExtendModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoExtendModel(n);
            return;
        }
        this.autoextendmodel = n;
        this.autoextendmodelDirtyFlag = true;
    }

    public Integer getAutoExtendModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoExtendModel();
        }
        return this.autoextendmodel;
    }

    public boolean isAutoExtendModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoExtendModelDirty();
        }
        return this.autoextendmodelDirtyFlag;
    }

    public void resetAutoExtendModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoExtendModel();
            return;
        }
        this.autoextendmodelDirtyFlag = false;
        this.autoextendmodel = null;
    }

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

    public void setCodeName2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename2 = string;
        this.codename2DirtyFlag = true;
    }

    public String getCodeName2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName2();
        }
        return this.codename2;
    }

    public boolean isCodeName2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeName2Dirty();
        }
        return this.codename2DirtyFlag;
    }

    public void resetCodeName2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName2();
            return;
        }
        this.codename2DirtyFlag = false;
        this.codename2 = null;
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

    public void setCreateSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql = string;
        this.createsqlDirtyFlag = true;
    }

    public String getCreateSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql();
        }
        return this.createsql;
    }

    public boolean isCreateSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSqlDirty();
        }
        return this.createsqlDirtyFlag;
    }

    public void resetCreateSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql();
            return;
        }
        this.createsqlDirtyFlag = false;
        this.createsql = null;
    }

    public void setDropSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDropSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dropsql = string;
        this.dropsqlDirtyFlag = true;
    }

    public String getDropSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDropSql();
        }
        return this.dropsql;
    }

    public boolean isDropSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDropSqlDirty();
        }
        return this.dropsqlDirtyFlag;
    }

    public void resetDropSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDropSql();
            return;
        }
        this.dropsqlDirtyFlag = false;
        this.dropsql = null;
    }

    public void setDSLink(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSLink(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dslink = string;
        this.dslinkDirtyFlag = true;
    }

    public String getDSLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSLink();
        }
        return this.dslink;
    }

    public boolean isDSLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSLinkDirty();
        }
        return this.dslinkDirtyFlag;
    }

    public void resetDSLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSLink();
            return;
        }
        this.dslinkDirtyFlag = false;
        this.dslink = null;
    }

    public void setExistingModel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExistingModel(n);
            return;
        }
        this.existingmodel = n;
        this.existingmodelDirtyFlag = true;
    }

    public Integer getExistingModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExistingModel();
        }
        return this.existingmodel;
    }

    public boolean isExistingModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExistingModelDirty();
        }
        return this.existingmodelDirtyFlag;
    }

    public void resetExistingModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExistingModel();
            return;
        }
        this.existingmodelDirtyFlag = false;
        this.existingmodel = null;
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

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemename = string;
        this.pssysdbschemenameDirtyFlag = true;
    }

    public String getPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeName();
        }
        return this.pssysdbschemename;
    }

    public boolean isPSSysDBSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeNameDirty();
        }
        return this.pssysdbschemenameDirtyFlag;
    }

    public void resetPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeName();
            return;
        }
        this.pssysdbschemenameDirtyFlag = false;
        this.pssysdbschemename = null;
    }

    public void setPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtableid = string;
        this.pssysdbtableidDirtyFlag = true;
    }

    public String getPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableId();
        }
        return this.pssysdbtableid;
    }

    public boolean isPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableIdDirty();
        }
        return this.pssysdbtableidDirtyFlag;
    }

    public void resetPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableId();
            return;
        }
        this.pssysdbtableidDirtyFlag = false;
        this.pssysdbtableid = null;
    }

    public void setPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysdbtablename = string;
        this.pssysdbtablenameDirtyFlag = true;
    }

    public String getPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableName();
        }
        return this.pssysdbtablename;
    }

    public boolean isPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableNameDirty();
        }
        return this.pssysdbtablenameDirtyFlag;
    }

    public void resetPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableName();
            return;
        }
        this.pssysdbtablenameDirtyFlag = false;
        this.pssysdbtablename = null;
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

    public void setTabDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTabDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabdesc = string;
        this.tabdescDirtyFlag = true;
    }

    public String getTabDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTabDesc();
        }
        return this.tabdesc;
    }

    public boolean isTabDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTabDescDirty();
        }
        return this.tabdescDirtyFlag;
    }

    public void resetTabDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTabDesc();
            return;
        }
        this.tabdescDirtyFlag = false;
        this.tabdesc = null;
    }

    public void setTableTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabletag = string;
        this.tabletagDirtyFlag = true;
    }

    public String getTableTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableTag();
        }
        return this.tabletag;
    }

    public boolean isTableTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableTagDirty();
        }
        return this.tabletagDirtyFlag;
    }

    public void resetTableTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableTag();
            return;
        }
        this.tabletagDirtyFlag = false;
        this.tabletag = null;
    }

    public void setTableTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabletag2 = string;
        this.tabletag2DirtyFlag = true;
    }

    public String getTableTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableTag2();
        }
        return this.tabletag2;
    }

    public boolean isTableTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableTag2Dirty();
        }
        return this.tabletag2DirtyFlag;
    }

    public void resetTableTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableTag2();
            return;
        }
        this.tabletag2DirtyFlag = false;
        this.tabletag2 = null;
    }

    public void setTableType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTableType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tabletype = string;
        this.tabletypeDirtyFlag = true;
    }

    public String getTableType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTableType();
        }
        return this.tabletype;
    }

    public boolean isTableTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTableTypeDirty();
        }
        return this.tabletypeDirtyFlag;
    }

    public void resetTableType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTableType();
            return;
        }
        this.tabletypeDirtyFlag = false;
        this.tabletype = null;
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
        PSSysDBTableBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBTableBase pSSysDBTableBase) {
        pSSysDBTableBase.resetAutoExtendModel();
        pSSysDBTableBase.resetCodeName();
        pSSysDBTableBase.resetCodeName2();
        pSSysDBTableBase.resetCreateDate();
        pSSysDBTableBase.resetCreateMan();
        pSSysDBTableBase.resetCreateSql();
        pSSysDBTableBase.resetDropSql();
        pSSysDBTableBase.resetDSLink();
        pSSysDBTableBase.resetExistingModel();
        pSSysDBTableBase.resetLogicName();
        pSSysDBTableBase.resetMemo();
        pSSysDBTableBase.resetPSSysDBSchemeId();
        pSSysDBTableBase.resetPSSysDBSchemeName();
        pSSysDBTableBase.resetPSSysDBTableId();
        pSSysDBTableBase.resetPSSysDBTableName();
        pSSysDBTableBase.resetPSSystemId();
        pSSysDBTableBase.resetPSSystemName();
        pSSysDBTableBase.resetTabDesc();
        pSSysDBTableBase.resetTableTag();
        pSSysDBTableBase.resetTableTag2();
        pSSysDBTableBase.resetTableType();
        pSSysDBTableBase.resetUpdateDate();
        pSSysDBTableBase.resetUpdateMan();
        pSSysDBTableBase.resetUserCat();
        pSSysDBTableBase.resetUserTag();
        pSSysDBTableBase.resetUserTag2();
        pSSysDBTableBase.resetUserTag3();
        pSSysDBTableBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAutoExtendModelDirty()) {
            hashMap.put(FIELD_AUTOEXTENDMODEL, this.getAutoExtendModel());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCodeName2Dirty()) {
            hashMap.put(FIELD_CODENAME2, this.getCodeName2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreateSqlDirty()) {
            hashMap.put(FIELD_CREATESQL, this.getCreateSql());
        }
        if (!bl || this.isDropSqlDirty()) {
            hashMap.put(FIELD_DROPSQL, this.getDropSql());
        }
        if (!bl || this.isDSLinkDirty()) {
            hashMap.put(FIELD_DSLINK, this.getDSLink());
        }
        if (!bl || this.isExistingModelDirty()) {
            hashMap.put(FIELD_EXISTINGMODEL, this.getExistingModel());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMENAME, this.getPSSysDBSchemeName());
        }
        if (!bl || this.isPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLEID, this.getPSSysDBTableId());
        }
        if (!bl || this.isPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLENAME, this.getPSSysDBTableName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isTabDescDirty()) {
            hashMap.put(FIELD_TABDESC, this.getTabDesc());
        }
        if (!bl || this.isTableTagDirty()) {
            hashMap.put(FIELD_TABLETAG, this.getTableTag());
        }
        if (!bl || this.isTableTag2Dirty()) {
            hashMap.put(FIELD_TABLETAG2, this.getTableTag2());
        }
        if (!bl || this.isTableTypeDirty()) {
            hashMap.put(FIELD_TABLETYPE, this.getTableType());
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
        return PSSysDBTableBase.get(this, n);
    }

    private static Object get(PSSysDBTableBase pSSysDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBTableBase.getAutoExtendModel();
            }
            case 1: {
                return pSSysDBTableBase.getCodeName();
            }
            case 2: {
                return pSSysDBTableBase.getCodeName2();
            }
            case 3: {
                return pSSysDBTableBase.getCreateDate();
            }
            case 4: {
                return pSSysDBTableBase.getCreateMan();
            }
            case 5: {
                return pSSysDBTableBase.getCreateSql();
            }
            case 6: {
                return pSSysDBTableBase.getDropSql();
            }
            case 7: {
                return pSSysDBTableBase.getDSLink();
            }
            case 8: {
                return pSSysDBTableBase.getExistingModel();
            }
            case 9: {
                return pSSysDBTableBase.getLogicName();
            }
            case 10: {
                return pSSysDBTableBase.getMemo();
            }
            case 11: {
                return pSSysDBTableBase.getPSSysDBSchemeId();
            }
            case 12: {
                return pSSysDBTableBase.getPSSysDBSchemeName();
            }
            case 13: {
                return pSSysDBTableBase.getPSSysDBTableId();
            }
            case 14: {
                return pSSysDBTableBase.getPSSysDBTableName();
            }
            case 15: {
                return pSSysDBTableBase.getPSSystemId();
            }
            case 16: {
                return pSSysDBTableBase.getPSSystemName();
            }
            case 17: {
                return pSSysDBTableBase.getTabDesc();
            }
            case 18: {
                return pSSysDBTableBase.getTableTag();
            }
            case 19: {
                return pSSysDBTableBase.getTableTag2();
            }
            case 20: {
                return pSSysDBTableBase.getTableType();
            }
            case 21: {
                return pSSysDBTableBase.getUpdateDate();
            }
            case 22: {
                return pSSysDBTableBase.getUpdateMan();
            }
            case 23: {
                return pSSysDBTableBase.getUserCat();
            }
            case 24: {
                return pSSysDBTableBase.getUserTag();
            }
            case 25: {
                return pSSysDBTableBase.getUserTag2();
            }
            case 26: {
                return pSSysDBTableBase.getUserTag3();
            }
            case 27: {
                return pSSysDBTableBase.getUserTag4();
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
        PSSysDBTableBase.set(this, n, object);
    }

    private static void set(PSSysDBTableBase pSSysDBTableBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBTableBase.setAutoExtendModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBTableBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBTableBase.setCodeName2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBTableBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBTableBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBTableBase.setCreateSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBTableBase.setDropSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBTableBase.setDSLink(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBTableBase.setExistingModel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBTableBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBTableBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBTableBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBTableBase.setPSSysDBSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBTableBase.setPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBTableBase.setPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBTableBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBTableBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBTableBase.setTabDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBTableBase.setTableTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDBTableBase.setTableTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDBTableBase.setTableType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDBTableBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSSysDBTableBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDBTableBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDBTableBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDBTableBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDBTableBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDBTableBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysDBTableBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBTableBase pSSysDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBTableBase.getAutoExtendModel() == null;
            }
            case 1: {
                return pSSysDBTableBase.getCodeName() == null;
            }
            case 2: {
                return pSSysDBTableBase.getCodeName2() == null;
            }
            case 3: {
                return pSSysDBTableBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysDBTableBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysDBTableBase.getCreateSql() == null;
            }
            case 6: {
                return pSSysDBTableBase.getDropSql() == null;
            }
            case 7: {
                return pSSysDBTableBase.getDSLink() == null;
            }
            case 8: {
                return pSSysDBTableBase.getExistingModel() == null;
            }
            case 9: {
                return pSSysDBTableBase.getLogicName() == null;
            }
            case 10: {
                return pSSysDBTableBase.getMemo() == null;
            }
            case 11: {
                return pSSysDBTableBase.getPSSysDBSchemeId() == null;
            }
            case 12: {
                return pSSysDBTableBase.getPSSysDBSchemeName() == null;
            }
            case 13: {
                return pSSysDBTableBase.getPSSysDBTableId() == null;
            }
            case 14: {
                return pSSysDBTableBase.getPSSysDBTableName() == null;
            }
            case 15: {
                return pSSysDBTableBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysDBTableBase.getPSSystemName() == null;
            }
            case 17: {
                return pSSysDBTableBase.getTabDesc() == null;
            }
            case 18: {
                return pSSysDBTableBase.getTableTag() == null;
            }
            case 19: {
                return pSSysDBTableBase.getTableTag2() == null;
            }
            case 20: {
                return pSSysDBTableBase.getTableType() == null;
            }
            case 21: {
                return pSSysDBTableBase.getUpdateDate() == null;
            }
            case 22: {
                return pSSysDBTableBase.getUpdateMan() == null;
            }
            case 23: {
                return pSSysDBTableBase.getUserCat() == null;
            }
            case 24: {
                return pSSysDBTableBase.getUserTag() == null;
            }
            case 25: {
                return pSSysDBTableBase.getUserTag2() == null;
            }
            case 26: {
                return pSSysDBTableBase.getUserTag3() == null;
            }
            case 27: {
                return pSSysDBTableBase.getUserTag4() == null;
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
        return PSSysDBTableBase.contains(this, n);
    }

    private static boolean contains(PSSysDBTableBase pSSysDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBTableBase.isAutoExtendModelDirty();
            }
            case 1: {
                return pSSysDBTableBase.isCodeNameDirty();
            }
            case 2: {
                return pSSysDBTableBase.isCodeName2Dirty();
            }
            case 3: {
                return pSSysDBTableBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysDBTableBase.isCreateManDirty();
            }
            case 5: {
                return pSSysDBTableBase.isCreateSqlDirty();
            }
            case 6: {
                return pSSysDBTableBase.isDropSqlDirty();
            }
            case 7: {
                return pSSysDBTableBase.isDSLinkDirty();
            }
            case 8: {
                return pSSysDBTableBase.isExistingModelDirty();
            }
            case 9: {
                return pSSysDBTableBase.isLogicNameDirty();
            }
            case 10: {
                return pSSysDBTableBase.isMemoDirty();
            }
            case 11: {
                return pSSysDBTableBase.isPSSysDBSchemeIdDirty();
            }
            case 12: {
                return pSSysDBTableBase.isPSSysDBSchemeNameDirty();
            }
            case 13: {
                return pSSysDBTableBase.isPSSysDBTableIdDirty();
            }
            case 14: {
                return pSSysDBTableBase.isPSSysDBTableNameDirty();
            }
            case 15: {
                return pSSysDBTableBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysDBTableBase.isPSSystemNameDirty();
            }
            case 17: {
                return pSSysDBTableBase.isTabDescDirty();
            }
            case 18: {
                return pSSysDBTableBase.isTableTagDirty();
            }
            case 19: {
                return pSSysDBTableBase.isTableTag2Dirty();
            }
            case 20: {
                return pSSysDBTableBase.isTableTypeDirty();
            }
            case 21: {
                return pSSysDBTableBase.isUpdateDateDirty();
            }
            case 22: {
                return pSSysDBTableBase.isUpdateManDirty();
            }
            case 23: {
                return pSSysDBTableBase.isUserCatDirty();
            }
            case 24: {
                return pSSysDBTableBase.isUserTagDirty();
            }
            case 25: {
                return pSSysDBTableBase.isUserTag2Dirty();
            }
            case 26: {
                return pSSysDBTableBase.isUserTag3Dirty();
            }
            case 27: {
                return pSSysDBTableBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBTableBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBTableBase pSSysDBTableBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBTableBase.getAutoExtendModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autoextendmodel", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getAutoExtendModel()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getCodeName2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename2", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getCodeName2()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getCreateSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getCreateSql()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getDropSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dropsql", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getDropSql()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getDSLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dslink", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getDSLink()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getExistingModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"existingmodel", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getExistingModel()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSysDBSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemename", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSysDBSchemeName()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtableid", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtablename", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getTabDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabdesc", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getTabDesc()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getTableTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabletag", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getTableTag()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getTableTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabletag2", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getTableTag2()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getTableType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tabletype", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getTableType()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysDBTableBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysDBTableBase.getJSONValue((Object)pSSysDBTableBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBTableBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBTableBase pSSysDBTableBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBTableBase.getAutoExtendModel() != null) {
            object = pSSysDBTableBase.getAutoExtendModel();
            xmlNode.setAttribute(FIELD_AUTOEXTENDMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBTableBase.getCodeName() != null) {
            object = pSSysDBTableBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getCodeName2() != null) {
            object = pSSysDBTableBase.getCodeName2();
            xmlNode.setAttribute(FIELD_CODENAME2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getCreateDate() != null) {
            object = pSSysDBTableBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBTableBase.getCreateMan() != null) {
            object = pSSysDBTableBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getCreateSql() != null) {
            object = pSSysDBTableBase.getCreateSql();
            xmlNode.setAttribute(FIELD_CREATESQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getDropSql() != null) {
            object = pSSysDBTableBase.getDropSql();
            xmlNode.setAttribute(FIELD_DROPSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getDSLink() != null) {
            object = pSSysDBTableBase.getDSLink();
            xmlNode.setAttribute(FIELD_DSLINK, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getExistingModel() != null) {
            object = pSSysDBTableBase.getExistingModel();
            xmlNode.setAttribute(FIELD_EXISTINGMODEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBTableBase.getLogicName() != null) {
            object = pSSysDBTableBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getMemo() != null) {
            object = pSSysDBTableBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSysDBSchemeId() != null) {
            object = pSSysDBTableBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSysDBSchemeName() != null) {
            object = pSSysDBTableBase.getPSSysDBSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSysDBTableId() != null) {
            object = pSSysDBTableBase.getPSSysDBTableId();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSysDBTableName() != null) {
            object = pSSysDBTableBase.getPSSysDBTableName();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSystemId() != null) {
            object = pSSysDBTableBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getPSSystemName() != null) {
            object = pSSysDBTableBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getTabDesc() != null) {
            object = pSSysDBTableBase.getTabDesc();
            xmlNode.setAttribute(FIELD_TABDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getTableTag() != null) {
            object = pSSysDBTableBase.getTableTag();
            xmlNode.setAttribute(FIELD_TABLETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getTableTag2() != null) {
            object = pSSysDBTableBase.getTableTag2();
            xmlNode.setAttribute(FIELD_TABLETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getTableType() != null) {
            object = pSSysDBTableBase.getTableType();
            xmlNode.setAttribute(FIELD_TABLETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUpdateDate() != null) {
            object = pSSysDBTableBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBTableBase.getUpdateMan() != null) {
            object = pSSysDBTableBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUserCat() != null) {
            object = pSSysDBTableBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUserTag() != null) {
            object = pSSysDBTableBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUserTag2() != null) {
            object = pSSysDBTableBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUserTag3() != null) {
            object = pSSysDBTableBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBTableBase.getUserTag4() != null) {
            object = pSSysDBTableBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBTableBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBTableBase pSSysDBTableBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBTableBase.isAutoExtendModelDirty() && (bl || pSSysDBTableBase.getAutoExtendModel() != null)) {
            iDataObject.set(FIELD_AUTOEXTENDMODEL, (Object)pSSysDBTableBase.getAutoExtendModel());
        }
        if (pSSysDBTableBase.isCodeNameDirty() && (bl || pSSysDBTableBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysDBTableBase.getCodeName());
        }
        if (pSSysDBTableBase.isCodeName2Dirty() && (bl || pSSysDBTableBase.getCodeName2() != null)) {
            iDataObject.set(FIELD_CODENAME2, (Object)pSSysDBTableBase.getCodeName2());
        }
        if (pSSysDBTableBase.isCreateDateDirty() && (bl || pSSysDBTableBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBTableBase.getCreateDate());
        }
        if (pSSysDBTableBase.isCreateManDirty() && (bl || pSSysDBTableBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBTableBase.getCreateMan());
        }
        if (pSSysDBTableBase.isCreateSqlDirty() && (bl || pSSysDBTableBase.getCreateSql() != null)) {
            iDataObject.set(FIELD_CREATESQL, (Object)pSSysDBTableBase.getCreateSql());
        }
        if (pSSysDBTableBase.isDropSqlDirty() && (bl || pSSysDBTableBase.getDropSql() != null)) {
            iDataObject.set(FIELD_DROPSQL, (Object)pSSysDBTableBase.getDropSql());
        }
        if (pSSysDBTableBase.isDSLinkDirty() && (bl || pSSysDBTableBase.getDSLink() != null)) {
            iDataObject.set(FIELD_DSLINK, (Object)pSSysDBTableBase.getDSLink());
        }
        if (pSSysDBTableBase.isExistingModelDirty() && (bl || pSSysDBTableBase.getExistingModel() != null)) {
            iDataObject.set(FIELD_EXISTINGMODEL, (Object)pSSysDBTableBase.getExistingModel());
        }
        if (pSSysDBTableBase.isLogicNameDirty() && (bl || pSSysDBTableBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysDBTableBase.getLogicName());
        }
        if (pSSysDBTableBase.isMemoDirty() && (bl || pSSysDBTableBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBTableBase.getMemo());
        }
        if (pSSysDBTableBase.isPSSysDBSchemeIdDirty() && (bl || pSSysDBTableBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSSysDBTableBase.getPSSysDBSchemeId());
        }
        if (pSSysDBTableBase.isPSSysDBSchemeNameDirty() && (bl || pSSysDBTableBase.getPSSysDBSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMENAME, (Object)pSSysDBTableBase.getPSSysDBSchemeName());
        }
        if (pSSysDBTableBase.isPSSysDBTableIdDirty() && (bl || pSSysDBTableBase.getPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLEID, (Object)pSSysDBTableBase.getPSSysDBTableId());
        }
        if (pSSysDBTableBase.isPSSysDBTableNameDirty() && (bl || pSSysDBTableBase.getPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLENAME, (Object)pSSysDBTableBase.getPSSysDBTableName());
        }
        if (pSSysDBTableBase.isPSSystemIdDirty() && (bl || pSSysDBTableBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDBTableBase.getPSSystemId());
        }
        if (pSSysDBTableBase.isPSSystemNameDirty() && (bl || pSSysDBTableBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDBTableBase.getPSSystemName());
        }
        if (pSSysDBTableBase.isTabDescDirty() && (bl || pSSysDBTableBase.getTabDesc() != null)) {
            iDataObject.set(FIELD_TABDESC, (Object)pSSysDBTableBase.getTabDesc());
        }
        if (pSSysDBTableBase.isTableTagDirty() && (bl || pSSysDBTableBase.getTableTag() != null)) {
            iDataObject.set(FIELD_TABLETAG, (Object)pSSysDBTableBase.getTableTag());
        }
        if (pSSysDBTableBase.isTableTag2Dirty() && (bl || pSSysDBTableBase.getTableTag2() != null)) {
            iDataObject.set(FIELD_TABLETAG2, (Object)pSSysDBTableBase.getTableTag2());
        }
        if (pSSysDBTableBase.isTableTypeDirty() && (bl || pSSysDBTableBase.getTableType() != null)) {
            iDataObject.set(FIELD_TABLETYPE, (Object)pSSysDBTableBase.getTableType());
        }
        if (pSSysDBTableBase.isUpdateDateDirty() && (bl || pSSysDBTableBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBTableBase.getUpdateDate());
        }
        if (pSSysDBTableBase.isUpdateManDirty() && (bl || pSSysDBTableBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBTableBase.getUpdateMan());
        }
        if (pSSysDBTableBase.isUserCatDirty() && (bl || pSSysDBTableBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysDBTableBase.getUserCat());
        }
        if (pSSysDBTableBase.isUserTagDirty() && (bl || pSSysDBTableBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBTableBase.getUserTag());
        }
        if (pSSysDBTableBase.isUserTag2Dirty() && (bl || pSSysDBTableBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBTableBase.getUserTag2());
        }
        if (pSSysDBTableBase.isUserTag3Dirty() && (bl || pSSysDBTableBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysDBTableBase.getUserTag3());
        }
        if (pSSysDBTableBase.isUserTag4Dirty() && (bl || pSSysDBTableBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysDBTableBase.getUserTag4());
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
        return PSSysDBTableBase.remove(this, n);
    }

    private static boolean remove(PSSysDBTableBase pSSysDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBTableBase.resetAutoExtendModel();
                return true;
            }
            case 1: {
                pSSysDBTableBase.resetCodeName();
                return true;
            }
            case 2: {
                pSSysDBTableBase.resetCodeName2();
                return true;
            }
            case 3: {
                pSSysDBTableBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysDBTableBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysDBTableBase.resetCreateSql();
                return true;
            }
            case 6: {
                pSSysDBTableBase.resetDropSql();
                return true;
            }
            case 7: {
                pSSysDBTableBase.resetDSLink();
                return true;
            }
            case 8: {
                pSSysDBTableBase.resetExistingModel();
                return true;
            }
            case 9: {
                pSSysDBTableBase.resetLogicName();
                return true;
            }
            case 10: {
                pSSysDBTableBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysDBTableBase.resetPSSysDBSchemeId();
                return true;
            }
            case 12: {
                pSSysDBTableBase.resetPSSysDBSchemeName();
                return true;
            }
            case 13: {
                pSSysDBTableBase.resetPSSysDBTableId();
                return true;
            }
            case 14: {
                pSSysDBTableBase.resetPSSysDBTableName();
                return true;
            }
            case 15: {
                pSSysDBTableBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysDBTableBase.resetPSSystemName();
                return true;
            }
            case 17: {
                pSSysDBTableBase.resetTabDesc();
                return true;
            }
            case 18: {
                pSSysDBTableBase.resetTableTag();
                return true;
            }
            case 19: {
                pSSysDBTableBase.resetTableTag2();
                return true;
            }
            case 20: {
                pSSysDBTableBase.resetTableType();
                return true;
            }
            case 21: {
                pSSysDBTableBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSSysDBTableBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSSysDBTableBase.resetUserCat();
                return true;
            }
            case 24: {
                pSSysDBTableBase.resetUserTag();
                return true;
            }
            case 25: {
                pSSysDBTableBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSSysDBTableBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSSysDBTableBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBScheme();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBSchemeLock;
        synchronized (n) {
            if (this.pssysdbscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBSchemeId(), (Object)this.pssysdbscheme.getPSSysDBSchemeId()) != 0L) {
                this.pssysdbscheme = null;
            }
            if (this.pssysdbscheme == null) {
                PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
                pSSysDBScheme.setPSSysDBSchemeId(this.getPSSysDBSchemeId());
                PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBSchemeService.autoGet(pSSysDBScheme);
                this.pssysdbscheme = pSSysDBScheme;
            }
            return this.pssysdbscheme;
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
    public ArrayList<PSSysDBColumn> getPSSysDBColumns() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBColumns();
        }
        if (this.getPSSysDBTableId() == null) {
            return null;
        }
        PSSysDBColumnService pSSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysDBColumnsLock;
        synchronized (n) {
            if (this.pssysdbcolumns == null) {
                this.pssysdbcolumns = pSSysDBColumnService.selectByPSSysDBTable(this);
            }
            return this.pssysdbcolumns;
        }
    }

    private PSSysDBTableBase getProxyEntity() {
        return this.proxyPSSysDBTableBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBTableBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBTableBase) {
            this.proxyPSSysDBTableBase = (PSSysDBTableBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTOEXTENDMODEL, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CODENAME2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_CREATESQL, 5);
        fieldIndexMap.put(FIELD_DROPSQL, 6);
        fieldIndexMap.put(FIELD_DSLINK, 7);
        fieldIndexMap.put(FIELD_EXISTINGMODEL, 8);
        fieldIndexMap.put(FIELD_LOGICNAME, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 11);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSDBTABLEID, 13);
        fieldIndexMap.put(FIELD_PSSYSDBTABLENAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 16);
        fieldIndexMap.put(FIELD_TABDESC, 17);
        fieldIndexMap.put(FIELD_TABLETAG, 18);
        fieldIndexMap.put(FIELD_TABLETAG2, 19);
        fieldIndexMap.put(FIELD_TABLETYPE, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
    }
}

