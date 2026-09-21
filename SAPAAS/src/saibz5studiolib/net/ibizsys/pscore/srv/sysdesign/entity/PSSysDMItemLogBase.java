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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDMItemLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDMItemLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBOBJTYPE = "DBOBJTYPE";
    public static final String FIELD_FIXSQL = "FIXSQL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEWSQL = "NEWSQL";
    public static final String FIELD_NEWTAG = "NEWTAG";
    public static final String FIELD_NEWTAG2 = "NEWTAG2";
    public static final String FIELD_OLDSQL = "OLDSQL";
    public static final String FIELD_OLDTAG = "OLDTAG";
    public static final String FIELD_OLDTAG2 = "OLDTAG2";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSSYSDMITEMLOGID = "PSSYSDMITEMLOGID";
    public static final String FIELD_PSSYSDMITEMLOGNAME = "PSSYSDMITEMLOGNAME";
    public static final String FIELD_PSSYSDMVERID = "PSSYSDMVERID";
    public static final String FIELD_PSSYSDMVERNAME = "PSSYSDMVERNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_SYSDBVER = "SYSDBVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBOBJTYPE = 2;
    private static final int INDEX_FIXSQL = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_NEWSQL = 5;
    private static final int INDEX_NEWTAG = 6;
    private static final int INDEX_NEWTAG2 = 7;
    private static final int INDEX_OLDSQL = 8;
    private static final int INDEX_OLDTAG = 9;
    private static final int INDEX_OLDTAG2 = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDENAME = 12;
    private static final int INDEX_PSOBJID = 13;
    private static final int INDEX_PSOBJNAME = 14;
    private static final int INDEX_PSSYSDMITEMLOGID = 15;
    private static final int INDEX_PSSYSDMITEMLOGNAME = 16;
    private static final int INDEX_PSSYSDMVERID = 17;
    private static final int INDEX_PSSYSDMVERNAME = 18;
    private static final int INDEX_PSSYSTEMDBCFGID = 19;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 20;
    private static final int INDEX_SYSDBVER = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDMItemLogBase proxyPSSysDMItemLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbobjtypeDirtyFlag = false;
    private boolean fixsqlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean newsqlDirtyFlag = false;
    private boolean newtagDirtyFlag = false;
    private boolean newtag2DirtyFlag = false;
    private boolean oldsqlDirtyFlag = false;
    private boolean oldtagDirtyFlag = false;
    private boolean oldtag2DirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean pssysdmitemlogidDirtyFlag = false;
    private boolean pssysdmitemlognameDirtyFlag = false;
    private boolean pssysdmveridDirtyFlag = false;
    private boolean pssysdmvernameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean sysdbverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbobjtype")
    private String dbobjtype;
    @Column(name="fixsql")
    private String fixsql;
    @Column(name="memo")
    private String memo;
    @Column(name="newsql")
    private String newsql;
    @Column(name="newtag")
    private String newtag;
    @Column(name="newtag2")
    private String newtag2;
    @Column(name="oldsql")
    private String oldsql;
    @Column(name="oldtag")
    private String oldtag;
    @Column(name="oldtag2")
    private String oldtag2;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="pssysdmitemlogid")
    private String pssysdmitemlogid;
    @Column(name="pssysdmitemlogname")
    private String pssysdmitemlogname;
    @Column(name="pssysdmverid")
    private String pssysdmverid;
    @Column(name="pssysdmvername")
    private String pssysdmvername;
    @Column(name="pssystemdbcfgid")
    private String pssystemdbcfgid;
    @Column(name="pssystemdbcfgname")
    private String pssystemdbcfgname;
    @Column(name="sysdbver")
    private Integer sysdbver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysDMVerLock = new Integer(1);
    private PSSysDMVer pssysdmver = null;
    private Integer objPSSystemDBCfgLock = new Integer(1);
    private PSSystemDBCfg pssystemdbcfg = null;

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

    public void setDBObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbobjtype = string;
        this.dbobjtypeDirtyFlag = true;
    }

    public String getDBObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBObjType();
        }
        return this.dbobjtype;
    }

    public boolean isDBObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBObjTypeDirty();
        }
        return this.dbobjtypeDirtyFlag;
    }

    public void resetDBObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBObjType();
            return;
        }
        this.dbobjtypeDirtyFlag = false;
        this.dbobjtype = null;
    }

    public void setFixSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fixsql = string;
        this.fixsqlDirtyFlag = true;
    }

    public String getFixSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixSql();
        }
        return this.fixsql;
    }

    public boolean isFixSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixSqlDirty();
        }
        return this.fixsqlDirtyFlag;
    }

    public void resetFixSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixSql();
            return;
        }
        this.fixsqlDirtyFlag = false;
        this.fixsql = null;
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

    public void setNewSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newsql = string;
        this.newsqlDirtyFlag = true;
    }

    public String getNewSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewSql();
        }
        return this.newsql;
    }

    public boolean isNewSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewSqlDirty();
        }
        return this.newsqlDirtyFlag;
    }

    public void resetNewSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewSql();
            return;
        }
        this.newsqlDirtyFlag = false;
        this.newsql = null;
    }

    public void setNewTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newtag = string;
        this.newtagDirtyFlag = true;
    }

    public String getNewTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewTag();
        }
        return this.newtag;
    }

    public boolean isNewTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewTagDirty();
        }
        return this.newtagDirtyFlag;
    }

    public void resetNewTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewTag();
            return;
        }
        this.newtagDirtyFlag = false;
        this.newtag = null;
    }

    public void setNewTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.newtag2 = string;
        this.newtag2DirtyFlag = true;
    }

    public String getNewTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewTag2();
        }
        return this.newtag2;
    }

    public boolean isNewTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewTag2Dirty();
        }
        return this.newtag2DirtyFlag;
    }

    public void resetNewTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewTag2();
            return;
        }
        this.newtag2DirtyFlag = false;
        this.newtag2 = null;
    }

    public void setOldSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOldSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oldsql = string;
        this.oldsqlDirtyFlag = true;
    }

    public String getOldSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOldSql();
        }
        return this.oldsql;
    }

    public boolean isOldSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOldSqlDirty();
        }
        return this.oldsqlDirtyFlag;
    }

    public void resetOldSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOldSql();
            return;
        }
        this.oldsqlDirtyFlag = false;
        this.oldsql = null;
    }

    public void setOldTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOldTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oldtag = string;
        this.oldtagDirtyFlag = true;
    }

    public String getOldTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOldTag();
        }
        return this.oldtag;
    }

    public boolean isOldTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOldTagDirty();
        }
        return this.oldtagDirtyFlag;
    }

    public void resetOldTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOldTag();
            return;
        }
        this.oldtagDirtyFlag = false;
        this.oldtag = null;
    }

    public void setOldTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOldTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.oldtag2 = string;
        this.oldtag2DirtyFlag = true;
    }

    public String getOldTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOldTag2();
        }
        return this.oldtag2;
    }

    public boolean isOldTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOldTag2Dirty();
        }
        return this.oldtag2DirtyFlag;
    }

    public void resetOldTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOldTag2();
            return;
        }
        this.oldtag2DirtyFlag = false;
        this.oldtag2 = null;
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

    public void setPSOBJId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSOBJId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSOBJId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSOBJId();
        }
        return this.psobjid;
    }

    public boolean isPSOBJIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSOBJIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSOBJId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSOBJId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSOBJName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSOBJName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSOBJName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSOBJName();
        }
        return this.psobjname;
    }

    public boolean isPSOBJNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSOBJNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSOBJName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSOBJName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSSysDMItemLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMItemLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmitemlogid = string;
        this.pssysdmitemlogidDirtyFlag = true;
    }

    public String getPSSysDMItemLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItemLogId();
        }
        return this.pssysdmitemlogid;
    }

    public boolean isPSSysDMItemLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMItemLogIdDirty();
        }
        return this.pssysdmitemlogidDirtyFlag;
    }

    public void resetPSSysDMItemLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMItemLogId();
            return;
        }
        this.pssysdmitemlogidDirtyFlag = false;
        this.pssysdmitemlogid = null;
    }

    public void setPSSysDMItemLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMItemLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmitemlogname = string;
        this.pssysdmitemlognameDirtyFlag = true;
    }

    public String getPSSysDMItemLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItemLogName();
        }
        return this.pssysdmitemlogname;
    }

    public boolean isPSSysDMItemLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMItemLogNameDirty();
        }
        return this.pssysdmitemlognameDirtyFlag;
    }

    public void resetPSSysDMItemLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMItemLogName();
            return;
        }
        this.pssysdmitemlognameDirtyFlag = false;
        this.pssysdmitemlogname = null;
    }

    public void setPSSysDMVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmverid = string;
        this.pssysdmveridDirtyFlag = true;
    }

    public String getPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerId();
        }
        return this.pssysdmverid;
    }

    public boolean isPSSysDMVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMVerIdDirty();
        }
        return this.pssysdmveridDirtyFlag;
    }

    public void resetPSSysDMVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMVerId();
            return;
        }
        this.pssysdmveridDirtyFlag = false;
        this.pssysdmverid = null;
    }

    public void setPSSysDMVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmvername = string;
        this.pssysdmvernameDirtyFlag = true;
    }

    public String getPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVerName();
        }
        return this.pssysdmvername;
    }

    public boolean isPSSysDMVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMVerNameDirty();
        }
        return this.pssysdmvernameDirtyFlag;
    }

    public void resetPSSysDMVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMVerName();
            return;
        }
        this.pssysdmvernameDirtyFlag = false;
        this.pssysdmvername = null;
    }

    public void setPSSystemDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgid = string;
        this.pssystemdbcfgidDirtyFlag = true;
    }

    public String getPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgId();
        }
        return this.pssystemdbcfgid;
    }

    public boolean isPSSystemDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgIdDirty();
        }
        return this.pssystemdbcfgidDirtyFlag;
    }

    public void resetPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgId();
            return;
        }
        this.pssystemdbcfgidDirtyFlag = false;
        this.pssystemdbcfgid = null;
    }

    public void setPSSystemDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgname = string;
        this.pssystemdbcfgnameDirtyFlag = true;
    }

    public String getPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgName();
        }
        return this.pssystemdbcfgname;
    }

    public boolean isPSSystemDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgNameDirty();
        }
        return this.pssystemdbcfgnameDirtyFlag;
    }

    public void resetPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgName();
            return;
        }
        this.pssystemdbcfgnameDirtyFlag = false;
        this.pssystemdbcfgname = null;
    }

    public void setSysDBVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysDBVer(n);
            return;
        }
        this.sysdbver = n;
        this.sysdbverDirtyFlag = true;
    }

    public Integer getSysDBVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysDBVer();
        }
        return this.sysdbver;
    }

    public boolean isSysDBVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysDBVerDirty();
        }
        return this.sysdbverDirtyFlag;
    }

    public void resetSysDBVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysDBVer();
            return;
        }
        this.sysdbverDirtyFlag = false;
        this.sysdbver = null;
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

    protected void onReset() {
        PSSysDMItemLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDMItemLogBase pSSysDMItemLogBase) {
        pSSysDMItemLogBase.resetCreateDate();
        pSSysDMItemLogBase.resetCreateMan();
        pSSysDMItemLogBase.resetDBObjType();
        pSSysDMItemLogBase.resetFixSql();
        pSSysDMItemLogBase.resetMemo();
        pSSysDMItemLogBase.resetNewSql();
        pSSysDMItemLogBase.resetNewTag();
        pSSysDMItemLogBase.resetNewTag2();
        pSSysDMItemLogBase.resetOldSql();
        pSSysDMItemLogBase.resetOldTag();
        pSSysDMItemLogBase.resetOldTag2();
        pSSysDMItemLogBase.resetPSDEId();
        pSSysDMItemLogBase.resetPSDEName();
        pSSysDMItemLogBase.resetPSOBJId();
        pSSysDMItemLogBase.resetPSOBJName();
        pSSysDMItemLogBase.resetPSSysDMItemLogId();
        pSSysDMItemLogBase.resetPSSysDMItemLogName();
        pSSysDMItemLogBase.resetPSSysDMVerId();
        pSSysDMItemLogBase.resetPSSysDMVerName();
        pSSysDMItemLogBase.resetPSSystemDBCfgId();
        pSSysDMItemLogBase.resetPSSystemDBCfgName();
        pSSysDMItemLogBase.resetSysDBVer();
        pSSysDMItemLogBase.resetUpdateDate();
        pSSysDMItemLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBObjTypeDirty()) {
            hashMap.put(FIELD_DBOBJTYPE, this.getDBObjType());
        }
        if (!bl || this.isFixSqlDirty()) {
            hashMap.put(FIELD_FIXSQL, this.getFixSql());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNewSqlDirty()) {
            hashMap.put(FIELD_NEWSQL, this.getNewSql());
        }
        if (!bl || this.isNewTagDirty()) {
            hashMap.put(FIELD_NEWTAG, this.getNewTag());
        }
        if (!bl || this.isNewTag2Dirty()) {
            hashMap.put(FIELD_NEWTAG2, this.getNewTag2());
        }
        if (!bl || this.isOldSqlDirty()) {
            hashMap.put(FIELD_OLDSQL, this.getOldSql());
        }
        if (!bl || this.isOldTagDirty()) {
            hashMap.put(FIELD_OLDTAG, this.getOldTag());
        }
        if (!bl || this.isOldTag2Dirty()) {
            hashMap.put(FIELD_OLDTAG2, this.getOldTag2());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSOBJIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSOBJId());
        }
        if (!bl || this.isPSOBJNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSOBJName());
        }
        if (!bl || this.isPSSysDMItemLogIdDirty()) {
            hashMap.put(FIELD_PSSYSDMITEMLOGID, this.getPSSysDMItemLogId());
        }
        if (!bl || this.isPSSysDMItemLogNameDirty()) {
            hashMap.put(FIELD_PSSYSDMITEMLOGNAME, this.getPSSysDMItemLogName());
        }
        if (!bl || this.isPSSysDMVerIdDirty()) {
            hashMap.put(FIELD_PSSYSDMVERID, this.getPSSysDMVerId());
        }
        if (!bl || this.isPSSysDMVerNameDirty()) {
            hashMap.put(FIELD_PSSYSDMVERNAME, this.getPSSysDMVerName());
        }
        if (!bl || this.isPSSystemDBCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGID, this.getPSSystemDBCfgId());
        }
        if (!bl || this.isPSSystemDBCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGNAME, this.getPSSystemDBCfgName());
        }
        if (!bl || this.isSysDBVerDirty()) {
            hashMap.put(FIELD_SYSDBVER, this.getSysDBVer());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSSysDMItemLogBase.get(this, n);
    }

    private static Object get(PSSysDMItemLogBase pSSysDMItemLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemLogBase.getCreateDate();
            }
            case 1: {
                return pSSysDMItemLogBase.getCreateMan();
            }
            case 2: {
                return pSSysDMItemLogBase.getDBObjType();
            }
            case 3: {
                return pSSysDMItemLogBase.getFixSql();
            }
            case 4: {
                return pSSysDMItemLogBase.getMemo();
            }
            case 5: {
                return pSSysDMItemLogBase.getNewSql();
            }
            case 6: {
                return pSSysDMItemLogBase.getNewTag();
            }
            case 7: {
                return pSSysDMItemLogBase.getNewTag2();
            }
            case 8: {
                return pSSysDMItemLogBase.getOldSql();
            }
            case 9: {
                return pSSysDMItemLogBase.getOldTag();
            }
            case 10: {
                return pSSysDMItemLogBase.getOldTag2();
            }
            case 11: {
                return pSSysDMItemLogBase.getPSDEId();
            }
            case 12: {
                return pSSysDMItemLogBase.getPSDEName();
            }
            case 13: {
                return pSSysDMItemLogBase.getPSOBJId();
            }
            case 14: {
                return pSSysDMItemLogBase.getPSOBJName();
            }
            case 15: {
                return pSSysDMItemLogBase.getPSSysDMItemLogId();
            }
            case 16: {
                return pSSysDMItemLogBase.getPSSysDMItemLogName();
            }
            case 17: {
                return pSSysDMItemLogBase.getPSSysDMVerId();
            }
            case 18: {
                return pSSysDMItemLogBase.getPSSysDMVerName();
            }
            case 19: {
                return pSSysDMItemLogBase.getPSSystemDBCfgId();
            }
            case 20: {
                return pSSysDMItemLogBase.getPSSystemDBCfgName();
            }
            case 21: {
                return pSSysDMItemLogBase.getSysDBVer();
            }
            case 22: {
                return pSSysDMItemLogBase.getUpdateDate();
            }
            case 23: {
                return pSSysDMItemLogBase.getUpdateMan();
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
        PSSysDMItemLogBase.set(this, n, object);
    }

    private static void set(PSSysDMItemLogBase pSSysDMItemLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMItemLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDMItemLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDMItemLogBase.setDBObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDMItemLogBase.setFixSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDMItemLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDMItemLogBase.setNewSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDMItemLogBase.setNewTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDMItemLogBase.setNewTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDMItemLogBase.setOldSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDMItemLogBase.setOldTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDMItemLogBase.setOldTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDMItemLogBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDMItemLogBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDMItemLogBase.setPSOBJId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDMItemLogBase.setPSOBJName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDMItemLogBase.setPSSysDMItemLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDMItemLogBase.setPSSysDMItemLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDMItemLogBase.setPSSysDMVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDMItemLogBase.setPSSysDMVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDMItemLogBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDMItemLogBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDMItemLogBase.setSysDBVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysDMItemLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSSysDMItemLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDMItemLogBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDMItemLogBase pSSysDMItemLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDMItemLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDMItemLogBase.getDBObjType() == null;
            }
            case 3: {
                return pSSysDMItemLogBase.getFixSql() == null;
            }
            case 4: {
                return pSSysDMItemLogBase.getMemo() == null;
            }
            case 5: {
                return pSSysDMItemLogBase.getNewSql() == null;
            }
            case 6: {
                return pSSysDMItemLogBase.getNewTag() == null;
            }
            case 7: {
                return pSSysDMItemLogBase.getNewTag2() == null;
            }
            case 8: {
                return pSSysDMItemLogBase.getOldSql() == null;
            }
            case 9: {
                return pSSysDMItemLogBase.getOldTag() == null;
            }
            case 10: {
                return pSSysDMItemLogBase.getOldTag2() == null;
            }
            case 11: {
                return pSSysDMItemLogBase.getPSDEId() == null;
            }
            case 12: {
                return pSSysDMItemLogBase.getPSDEName() == null;
            }
            case 13: {
                return pSSysDMItemLogBase.getPSOBJId() == null;
            }
            case 14: {
                return pSSysDMItemLogBase.getPSOBJName() == null;
            }
            case 15: {
                return pSSysDMItemLogBase.getPSSysDMItemLogId() == null;
            }
            case 16: {
                return pSSysDMItemLogBase.getPSSysDMItemLogName() == null;
            }
            case 17: {
                return pSSysDMItemLogBase.getPSSysDMVerId() == null;
            }
            case 18: {
                return pSSysDMItemLogBase.getPSSysDMVerName() == null;
            }
            case 19: {
                return pSSysDMItemLogBase.getPSSystemDBCfgId() == null;
            }
            case 20: {
                return pSSysDMItemLogBase.getPSSystemDBCfgName() == null;
            }
            case 21: {
                return pSSysDMItemLogBase.getSysDBVer() == null;
            }
            case 22: {
                return pSSysDMItemLogBase.getUpdateDate() == null;
            }
            case 23: {
                return pSSysDMItemLogBase.getUpdateMan() == null;
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
        return PSSysDMItemLogBase.contains(this, n);
    }

    private static boolean contains(PSSysDMItemLogBase pSSysDMItemLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDMItemLogBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDMItemLogBase.isDBObjTypeDirty();
            }
            case 3: {
                return pSSysDMItemLogBase.isFixSqlDirty();
            }
            case 4: {
                return pSSysDMItemLogBase.isMemoDirty();
            }
            case 5: {
                return pSSysDMItemLogBase.isNewSqlDirty();
            }
            case 6: {
                return pSSysDMItemLogBase.isNewTagDirty();
            }
            case 7: {
                return pSSysDMItemLogBase.isNewTag2Dirty();
            }
            case 8: {
                return pSSysDMItemLogBase.isOldSqlDirty();
            }
            case 9: {
                return pSSysDMItemLogBase.isOldTagDirty();
            }
            case 10: {
                return pSSysDMItemLogBase.isOldTag2Dirty();
            }
            case 11: {
                return pSSysDMItemLogBase.isPSDEIdDirty();
            }
            case 12: {
                return pSSysDMItemLogBase.isPSDENameDirty();
            }
            case 13: {
                return pSSysDMItemLogBase.isPSOBJIdDirty();
            }
            case 14: {
                return pSSysDMItemLogBase.isPSOBJNameDirty();
            }
            case 15: {
                return pSSysDMItemLogBase.isPSSysDMItemLogIdDirty();
            }
            case 16: {
                return pSSysDMItemLogBase.isPSSysDMItemLogNameDirty();
            }
            case 17: {
                return pSSysDMItemLogBase.isPSSysDMVerIdDirty();
            }
            case 18: {
                return pSSysDMItemLogBase.isPSSysDMVerNameDirty();
            }
            case 19: {
                return pSSysDMItemLogBase.isPSSystemDBCfgIdDirty();
            }
            case 20: {
                return pSSysDMItemLogBase.isPSSystemDBCfgNameDirty();
            }
            case 21: {
                return pSSysDMItemLogBase.isSysDBVerDirty();
            }
            case 22: {
                return pSSysDMItemLogBase.isUpdateDateDirty();
            }
            case 23: {
                return pSSysDMItemLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDMItemLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDMItemLogBase pSSysDMItemLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDMItemLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getDBObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbobjtype", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getDBObjType()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getFixSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixsql", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getFixSql()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getNewSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newsql", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getNewSql()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getNewTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newtag", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getNewTag()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getNewTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newtag2", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getNewTag2()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getOldSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oldsql", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getOldSql()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getOldTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oldtag", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getOldTag()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getOldTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"oldtag2", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getOldTag2()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSOBJId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSOBJId()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSOBJName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSOBJName()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMItemLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmitemlogid", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSysDMItemLogId()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMItemLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmitemlogname", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSysDMItemLogName()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmverid", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSysDMVerId()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmvername", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSysDMVerName()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getSysDBVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysdbver", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getSysDBVer()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDMItemLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDMItemLogBase.getJSONValue((Object)pSSysDMItemLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDMItemLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDMItemLogBase pSSysDMItemLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDMItemLogBase.getCreateDate() != null) {
            object = pSSysDMItemLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMItemLogBase.getCreateMan() != null) {
            object = pSSysDMItemLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getDBObjType() != null) {
            object = pSSysDMItemLogBase.getDBObjType();
            xmlNode.setAttribute(FIELD_DBOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getFixSql() != null) {
            object = pSSysDMItemLogBase.getFixSql();
            xmlNode.setAttribute(FIELD_FIXSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getMemo() != null) {
            object = pSSysDMItemLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getNewSql() != null) {
            object = pSSysDMItemLogBase.getNewSql();
            xmlNode.setAttribute(FIELD_NEWSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getNewTag() != null) {
            object = pSSysDMItemLogBase.getNewTag();
            xmlNode.setAttribute(FIELD_NEWTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getNewTag2() != null) {
            object = pSSysDMItemLogBase.getNewTag2();
            xmlNode.setAttribute(FIELD_NEWTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getOldSql() != null) {
            object = pSSysDMItemLogBase.getOldSql();
            xmlNode.setAttribute(FIELD_OLDSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getOldTag() != null) {
            object = pSSysDMItemLogBase.getOldTag();
            xmlNode.setAttribute(FIELD_OLDTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getOldTag2() != null) {
            object = pSSysDMItemLogBase.getOldTag2();
            xmlNode.setAttribute(FIELD_OLDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSDEId() != null) {
            object = pSSysDMItemLogBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSDEName() != null) {
            object = pSSysDMItemLogBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSOBJId() != null) {
            object = pSSysDMItemLogBase.getPSOBJId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSOBJName() != null) {
            object = pSSysDMItemLogBase.getPSOBJName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMItemLogId() != null) {
            object = pSSysDMItemLogBase.getPSSysDMItemLogId();
            xmlNode.setAttribute(FIELD_PSSYSDMITEMLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMItemLogName() != null) {
            object = pSSysDMItemLogBase.getPSSysDMItemLogName();
            xmlNode.setAttribute(FIELD_PSSYSDMITEMLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMVerId() != null) {
            object = pSSysDMItemLogBase.getPSSysDMVerId();
            xmlNode.setAttribute(FIELD_PSSYSDMVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSysDMVerName() != null) {
            object = pSSysDMItemLogBase.getPSSysDMVerName();
            xmlNode.setAttribute(FIELD_PSSYSDMVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSystemDBCfgId() != null) {
            object = pSSysDMItemLogBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getPSSystemDBCfgName() != null) {
            object = pSSysDMItemLogBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemLogBase.getSysDBVer() != null) {
            object = pSSysDMItemLogBase.getSysDBVer();
            xmlNode.setAttribute(FIELD_SYSDBVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDMItemLogBase.getUpdateDate() != null) {
            object = pSSysDMItemLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMItemLogBase.getUpdateMan() != null) {
            object = pSSysDMItemLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDMItemLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDMItemLogBase pSSysDMItemLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDMItemLogBase.isCreateDateDirty() && (bl || pSSysDMItemLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDMItemLogBase.getCreateDate());
        }
        if (pSSysDMItemLogBase.isCreateManDirty() && (bl || pSSysDMItemLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDMItemLogBase.getCreateMan());
        }
        if (pSSysDMItemLogBase.isDBObjTypeDirty() && (bl || pSSysDMItemLogBase.getDBObjType() != null)) {
            iDataObject.set(FIELD_DBOBJTYPE, (Object)pSSysDMItemLogBase.getDBObjType());
        }
        if (pSSysDMItemLogBase.isFixSqlDirty() && (bl || pSSysDMItemLogBase.getFixSql() != null)) {
            iDataObject.set(FIELD_FIXSQL, (Object)pSSysDMItemLogBase.getFixSql());
        }
        if (pSSysDMItemLogBase.isMemoDirty() && (bl || pSSysDMItemLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDMItemLogBase.getMemo());
        }
        if (pSSysDMItemLogBase.isNewSqlDirty() && (bl || pSSysDMItemLogBase.getNewSql() != null)) {
            iDataObject.set(FIELD_NEWSQL, (Object)pSSysDMItemLogBase.getNewSql());
        }
        if (pSSysDMItemLogBase.isNewTagDirty() && (bl || pSSysDMItemLogBase.getNewTag() != null)) {
            iDataObject.set(FIELD_NEWTAG, (Object)pSSysDMItemLogBase.getNewTag());
        }
        if (pSSysDMItemLogBase.isNewTag2Dirty() && (bl || pSSysDMItemLogBase.getNewTag2() != null)) {
            iDataObject.set(FIELD_NEWTAG2, (Object)pSSysDMItemLogBase.getNewTag2());
        }
        if (pSSysDMItemLogBase.isOldSqlDirty() && (bl || pSSysDMItemLogBase.getOldSql() != null)) {
            iDataObject.set(FIELD_OLDSQL, (Object)pSSysDMItemLogBase.getOldSql());
        }
        if (pSSysDMItemLogBase.isOldTagDirty() && (bl || pSSysDMItemLogBase.getOldTag() != null)) {
            iDataObject.set(FIELD_OLDTAG, (Object)pSSysDMItemLogBase.getOldTag());
        }
        if (pSSysDMItemLogBase.isOldTag2Dirty() && (bl || pSSysDMItemLogBase.getOldTag2() != null)) {
            iDataObject.set(FIELD_OLDTAG2, (Object)pSSysDMItemLogBase.getOldTag2());
        }
        if (pSSysDMItemLogBase.isPSDEIdDirty() && (bl || pSSysDMItemLogBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysDMItemLogBase.getPSDEId());
        }
        if (pSSysDMItemLogBase.isPSDENameDirty() && (bl || pSSysDMItemLogBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysDMItemLogBase.getPSDEName());
        }
        if (pSSysDMItemLogBase.isPSOBJIdDirty() && (bl || pSSysDMItemLogBase.getPSOBJId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysDMItemLogBase.getPSOBJId());
        }
        if (pSSysDMItemLogBase.isPSOBJNameDirty() && (bl || pSSysDMItemLogBase.getPSOBJName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysDMItemLogBase.getPSOBJName());
        }
        if (pSSysDMItemLogBase.isPSSysDMItemLogIdDirty() && (bl || pSSysDMItemLogBase.getPSSysDMItemLogId() != null)) {
            iDataObject.set(FIELD_PSSYSDMITEMLOGID, (Object)pSSysDMItemLogBase.getPSSysDMItemLogId());
        }
        if (pSSysDMItemLogBase.isPSSysDMItemLogNameDirty() && (bl || pSSysDMItemLogBase.getPSSysDMItemLogName() != null)) {
            iDataObject.set(FIELD_PSSYSDMITEMLOGNAME, (Object)pSSysDMItemLogBase.getPSSysDMItemLogName());
        }
        if (pSSysDMItemLogBase.isPSSysDMVerIdDirty() && (bl || pSSysDMItemLogBase.getPSSysDMVerId() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERID, (Object)pSSysDMItemLogBase.getPSSysDMVerId());
        }
        if (pSSysDMItemLogBase.isPSSysDMVerNameDirty() && (bl || pSSysDMItemLogBase.getPSSysDMVerName() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERNAME, (Object)pSSysDMItemLogBase.getPSSysDMVerName());
        }
        if (pSSysDMItemLogBase.isPSSystemDBCfgIdDirty() && (bl || pSSysDMItemLogBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSysDMItemLogBase.getPSSystemDBCfgId());
        }
        if (pSSysDMItemLogBase.isPSSystemDBCfgNameDirty() && (bl || pSSysDMItemLogBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSysDMItemLogBase.getPSSystemDBCfgName());
        }
        if (pSSysDMItemLogBase.isSysDBVerDirty() && (bl || pSSysDMItemLogBase.getSysDBVer() != null)) {
            iDataObject.set(FIELD_SYSDBVER, (Object)pSSysDMItemLogBase.getSysDBVer());
        }
        if (pSSysDMItemLogBase.isUpdateDateDirty() && (bl || pSSysDMItemLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDMItemLogBase.getUpdateDate());
        }
        if (pSSysDMItemLogBase.isUpdateManDirty() && (bl || pSSysDMItemLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDMItemLogBase.getUpdateMan());
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
        return PSSysDMItemLogBase.remove(this, n);
    }

    private static boolean remove(PSSysDMItemLogBase pSSysDMItemLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMItemLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDMItemLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDMItemLogBase.resetDBObjType();
                return true;
            }
            case 3: {
                pSSysDMItemLogBase.resetFixSql();
                return true;
            }
            case 4: {
                pSSysDMItemLogBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysDMItemLogBase.resetNewSql();
                return true;
            }
            case 6: {
                pSSysDMItemLogBase.resetNewTag();
                return true;
            }
            case 7: {
                pSSysDMItemLogBase.resetNewTag2();
                return true;
            }
            case 8: {
                pSSysDMItemLogBase.resetOldSql();
                return true;
            }
            case 9: {
                pSSysDMItemLogBase.resetOldTag();
                return true;
            }
            case 10: {
                pSSysDMItemLogBase.resetOldTag2();
                return true;
            }
            case 11: {
                pSSysDMItemLogBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSSysDMItemLogBase.resetPSDEName();
                return true;
            }
            case 13: {
                pSSysDMItemLogBase.resetPSOBJId();
                return true;
            }
            case 14: {
                pSSysDMItemLogBase.resetPSOBJName();
                return true;
            }
            case 15: {
                pSSysDMItemLogBase.resetPSSysDMItemLogId();
                return true;
            }
            case 16: {
                pSSysDMItemLogBase.resetPSSysDMItemLogName();
                return true;
            }
            case 17: {
                pSSysDMItemLogBase.resetPSSysDMVerId();
                return true;
            }
            case 18: {
                pSSysDMItemLogBase.resetPSSysDMVerName();
                return true;
            }
            case 19: {
                pSSysDMItemLogBase.resetPSSystemDBCfgId();
                return true;
            }
            case 20: {
                pSSysDMItemLogBase.resetPSSystemDBCfgName();
                return true;
            }
            case 21: {
                pSSysDMItemLogBase.resetSysDBVer();
                return true;
            }
            case 22: {
                pSSysDMItemLogBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSSysDMItemLogBase.resetUpdateMan();
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
    public PSSysDMVer getPSSysDMVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMVer();
        }
        if (this.getPSSysDMVerId() == null) {
            return null;
        }
        Integer n = this.objPSSysDMVerLock;
        synchronized (n) {
            if (this.pssysdmver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDMVerId(), (Object)this.pssysdmver.getPSSysDMVerId()) != 0L) {
                this.pssysdmver = null;
            }
            if (this.pssysdmver == null) {
                PSSysDMVer pSSysDMVer = new PSSysDMVer();
                pSSysDMVer.setPSSysDMVerId(this.getPSSysDMVerId());
                PSSysDMVerService pSSysDMVerService = (PSSysDMVerService)ServiceGlobal.getService(PSSysDMVerService.class, (SessionFactory)this.getSessionFactory());
                pSSysDMVerService.autoGet((IEntity)pSSysDMVer);
                this.pssysdmver = pSSysDMVer;
            }
            return this.pssysdmver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemDBCfg getPSSystemDBCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfg();
        }
        if (this.getPSSystemDBCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSystemDBCfgLock;
        synchronized (n) {
            if (this.pssystemdbcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemDBCfgId(), (Object)this.pssystemdbcfg.getPSSystemDBCfgId()) != 0L) {
                this.pssystemdbcfg = null;
            }
            if (this.pssystemdbcfg == null) {
                PSSystemDBCfg pSSystemDBCfg = new PSSystemDBCfg();
                pSSystemDBCfg.setPSSystemDBCfgId(this.getPSSystemDBCfgId());
                PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSystemDBCfgService.autoGet((IEntity)pSSystemDBCfg);
                this.pssystemdbcfg = pSSystemDBCfg;
            }
            return this.pssystemdbcfg;
        }
    }

    private PSSysDMItemLogBase getProxyEntity() {
        return this.proxyPSSysDMItemLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDMItemLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDMItemLogBase) {
            this.proxyPSSysDMItemLogBase = (PSSysDMItemLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBOBJTYPE, 2);
        fieldIndexMap.put(FIELD_FIXSQL, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_NEWSQL, 5);
        fieldIndexMap.put(FIELD_NEWTAG, 6);
        fieldIndexMap.put(FIELD_NEWTAG2, 7);
        fieldIndexMap.put(FIELD_OLDSQL, 8);
        fieldIndexMap.put(FIELD_OLDTAG, 9);
        fieldIndexMap.put(FIELD_OLDTAG2, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDENAME, 12);
        fieldIndexMap.put(FIELD_PSOBJID, 13);
        fieldIndexMap.put(FIELD_PSOBJNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSDMITEMLOGID, 15);
        fieldIndexMap.put(FIELD_PSSYSDMITEMLOGNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSDMVERID, 17);
        fieldIndexMap.put(FIELD_PSSYSDMVERNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 20);
        fieldIndexMap.put(FIELD_SYSDBVER, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

