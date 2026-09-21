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

public abstract class PSSysDMItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDMItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CREATESQL = "CREATESQL";
    public static final String FIELD_CREATESQL2 = "CREATESQL2";
    public static final String FIELD_CREATESQL3 = "CREATESQL3";
    public static final String FIELD_CREATESQL4 = "CREATESQL4";
    public static final String FIELD_CREATESQL5 = "CREATESQL5";
    public static final String FIELD_CREATESQL6 = "CREATESQL6";
    public static final String FIELD_CREATESQL7 = "CREATESQL7";
    public static final String FIELD_DBOBJTYPE = "DBOBJTYPE";
    public static final String FIELD_DROPSQL = "DROPSQL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSSYSDMITEMID = "PSSYSDMITEMID";
    public static final String FIELD_PSSYSDMITEMNAME = "PSSYSDMITEMNAME";
    public static final String FIELD_PSSYSDMVERID = "PSSYSDMVERID";
    public static final String FIELD_PSSYSDMVERNAME = "PSSYSDMVERNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_SYSDBVER = "SYSDBVER";
    public static final String FIELD_TESTSQL = "TESTSQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERFLAG = "USERFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CREATESQL = 2;
    private static final int INDEX_CREATESQL2 = 3;
    private static final int INDEX_CREATESQL3 = 4;
    private static final int INDEX_CREATESQL4 = 5;
    private static final int INDEX_CREATESQL5 = 6;
    private static final int INDEX_CREATESQL6 = 7;
    private static final int INDEX_CREATESQL7 = 8;
    private static final int INDEX_DBOBJTYPE = 9;
    private static final int INDEX_DROPSQL = 10;
    private static final int INDEX_MEMO = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDENAME = 13;
    private static final int INDEX_PSOBJID = 14;
    private static final int INDEX_PSOBJNAME = 15;
    private static final int INDEX_PSSYSDMITEMID = 16;
    private static final int INDEX_PSSYSDMITEMNAME = 17;
    private static final int INDEX_PSSYSDMVERID = 18;
    private static final int INDEX_PSSYSDMVERNAME = 19;
    private static final int INDEX_PSSYSTEMDBCFGID = 20;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 21;
    private static final int INDEX_SYSDBVER = 22;
    private static final int INDEX_TESTSQL = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_USERFLAG = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDMItemBase proxyPSSysDMItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean createsqlDirtyFlag = false;
    private boolean createsql2DirtyFlag = false;
    private boolean createsql3DirtyFlag = false;
    private boolean createsql4DirtyFlag = false;
    private boolean createsql5DirtyFlag = false;
    private boolean createsql6DirtyFlag = false;
    private boolean createsql7DirtyFlag = false;
    private boolean dbobjtypeDirtyFlag = false;
    private boolean dropsqlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean pssysdmitemidDirtyFlag = false;
    private boolean pssysdmitemnameDirtyFlag = false;
    private boolean pssysdmveridDirtyFlag = false;
    private boolean pssysdmvernameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean sysdbverDirtyFlag = false;
    private boolean testsqlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="createsql")
    private String createsql;
    @Column(name="createsql2")
    private String createsql2;
    @Column(name="createsql3")
    private String createsql3;
    @Column(name="createsql4")
    private String createsql4;
    @Column(name="createsql5")
    private String createsql5;
    @Column(name="createsql6")
    private String createsql6;
    @Column(name="createsql7")
    private String createsql7;
    @Column(name="dbobjtype")
    private String dbobjtype;
    @Column(name="dropsql")
    private String dropsql;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="pssysdmitemid")
    private String pssysdmitemid;
    @Column(name="pssysdmitemname")
    private String pssysdmitemname;
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
    @Column(name="testsql")
    private String testsql;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userflag")
    private Integer userflag;
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

    public void setCreateSql2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql2 = string;
        this.createsql2DirtyFlag = true;
    }

    public String getCreateSql2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql2();
        }
        return this.createsql2;
    }

    public boolean isCreateSql2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql2Dirty();
        }
        return this.createsql2DirtyFlag;
    }

    public void resetCreateSql2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql2();
            return;
        }
        this.createsql2DirtyFlag = false;
        this.createsql2 = null;
    }

    public void setCreateSql3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql3 = string;
        this.createsql3DirtyFlag = true;
    }

    public String getCreateSql3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql3();
        }
        return this.createsql3;
    }

    public boolean isCreateSql3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql3Dirty();
        }
        return this.createsql3DirtyFlag;
    }

    public void resetCreateSql3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql3();
            return;
        }
        this.createsql3DirtyFlag = false;
        this.createsql3 = null;
    }

    public void setCreateSql4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql4 = string;
        this.createsql4DirtyFlag = true;
    }

    public String getCreateSql4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql4();
        }
        return this.createsql4;
    }

    public boolean isCreateSql4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql4Dirty();
        }
        return this.createsql4DirtyFlag;
    }

    public void resetCreateSql4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql4();
            return;
        }
        this.createsql4DirtyFlag = false;
        this.createsql4 = null;
    }

    public void setCreateSql5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql5 = string;
        this.createsql5DirtyFlag = true;
    }

    public String getCreateSql5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql5();
        }
        return this.createsql5;
    }

    public boolean isCreateSql5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql5Dirty();
        }
        return this.createsql5DirtyFlag;
    }

    public void resetCreateSql5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql5();
            return;
        }
        this.createsql5DirtyFlag = false;
        this.createsql5 = null;
    }

    public void setCreateSql6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql6 = string;
        this.createsql6DirtyFlag = true;
    }

    public String getCreateSql6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql6();
        }
        return this.createsql6;
    }

    public boolean isCreateSql6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql6Dirty();
        }
        return this.createsql6DirtyFlag;
    }

    public void resetCreateSql6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql6();
            return;
        }
        this.createsql6DirtyFlag = false;
        this.createsql6 = null;
    }

    public void setCreateSql7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateSql7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createsql7 = string;
        this.createsql7DirtyFlag = true;
    }

    public String getCreateSql7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateSql7();
        }
        return this.createsql7;
    }

    public boolean isCreateSql7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateSql7Dirty();
        }
        return this.createsql7DirtyFlag;
    }

    public void resetCreateSql7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateSql7();
            return;
        }
        this.createsql7DirtyFlag = false;
        this.createsql7 = null;
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

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSSysDMItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdmitemid = string;
        this.pssysdmitemidDirtyFlag = true;
    }

    public String getPSSysDMItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItemId();
        }
        return this.pssysdmitemid;
    }

    public boolean isPSSysDMItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMItemIdDirty();
        }
        return this.pssysdmitemidDirtyFlag;
    }

    public void resetPSSysDMItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMItemId();
            return;
        }
        this.pssysdmitemidDirtyFlag = false;
        this.pssysdmitemid = null;
    }

    public void setPSSysDMItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDMItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        this.pssysdmitemname = string;
        this.pssysdmitemnameDirtyFlag = true;
    }

    public String getPSSysDMItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDMItemName();
        }
        return this.pssysdmitemname;
    }

    public boolean isPSSysDMItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDMItemNameDirty();
        }
        return this.pssysdmitemnameDirtyFlag;
    }

    public void resetPSSysDMItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDMItemName();
            return;
        }
        this.pssysdmitemnameDirtyFlag = false;
        this.pssysdmitemname = null;
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

    public void setTestSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testsql = string;
        this.testsqlDirtyFlag = true;
    }

    public String getTestSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestSql();
        }
        return this.testsql;
    }

    public boolean isTestSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestSqlDirty();
        }
        return this.testsqlDirtyFlag;
    }

    public void resetTestSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestSql();
            return;
        }
        this.testsqlDirtyFlag = false;
        this.testsql = null;
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

    public void setUserFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserFlag(n);
            return;
        }
        this.userflag = n;
        this.userflagDirtyFlag = true;
    }

    public Integer getUserFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserFlag();
        }
        return this.userflag;
    }

    public boolean isUserFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserFlagDirty();
        }
        return this.userflagDirtyFlag;
    }

    public void resetUserFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserFlag();
            return;
        }
        this.userflagDirtyFlag = false;
        this.userflag = null;
    }

    protected void onReset() {
        PSSysDMItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDMItemBase pSSysDMItemBase) {
        pSSysDMItemBase.resetCreateDate();
        pSSysDMItemBase.resetCreateMan();
        pSSysDMItemBase.resetCreateSql();
        pSSysDMItemBase.resetCreateSql2();
        pSSysDMItemBase.resetCreateSql3();
        pSSysDMItemBase.resetCreateSql4();
        pSSysDMItemBase.resetCreateSql5();
        pSSysDMItemBase.resetCreateSql6();
        pSSysDMItemBase.resetCreateSql7();
        pSSysDMItemBase.resetDBObjType();
        pSSysDMItemBase.resetDropSql();
        pSSysDMItemBase.resetMemo();
        pSSysDMItemBase.resetPSDEId();
        pSSysDMItemBase.resetPSDEName();
        pSSysDMItemBase.resetPSObjId();
        pSSysDMItemBase.resetPSObjName();
        pSSysDMItemBase.resetPSSysDMItemId();
        pSSysDMItemBase.resetPSSysDMItemName();
        pSSysDMItemBase.resetPSSysDMVerId();
        pSSysDMItemBase.resetPSSysDMVerName();
        pSSysDMItemBase.resetPSSystemDBCfgId();
        pSSysDMItemBase.resetPSSystemDBCfgName();
        pSSysDMItemBase.resetSysDBVer();
        pSSysDMItemBase.resetTestSql();
        pSSysDMItemBase.resetUpdateDate();
        pSSysDMItemBase.resetUpdateMan();
        pSSysDMItemBase.resetUserFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCreateSqlDirty()) {
            hashMap.put(FIELD_CREATESQL, this.getCreateSql());
        }
        if (!bl || this.isCreateSql2Dirty()) {
            hashMap.put(FIELD_CREATESQL2, this.getCreateSql2());
        }
        if (!bl || this.isCreateSql3Dirty()) {
            hashMap.put(FIELD_CREATESQL3, this.getCreateSql3());
        }
        if (!bl || this.isCreateSql4Dirty()) {
            hashMap.put(FIELD_CREATESQL4, this.getCreateSql4());
        }
        if (!bl || this.isCreateSql5Dirty()) {
            hashMap.put(FIELD_CREATESQL5, this.getCreateSql5());
        }
        if (!bl || this.isCreateSql6Dirty()) {
            hashMap.put(FIELD_CREATESQL6, this.getCreateSql6());
        }
        if (!bl || this.isCreateSql7Dirty()) {
            hashMap.put(FIELD_CREATESQL7, this.getCreateSql7());
        }
        if (!bl || this.isDBObjTypeDirty()) {
            hashMap.put(FIELD_DBOBJTYPE, this.getDBObjType());
        }
        if (!bl || this.isDropSqlDirty()) {
            hashMap.put(FIELD_DROPSQL, this.getDropSql());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSSysDMItemIdDirty()) {
            hashMap.put(FIELD_PSSYSDMITEMID, this.getPSSysDMItemId());
        }
        if (!bl || this.isPSSysDMItemNameDirty()) {
            hashMap.put(FIELD_PSSYSDMITEMNAME, this.getPSSysDMItemName());
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
        if (!bl || this.isTestSqlDirty()) {
            hashMap.put(FIELD_TESTSQL, this.getTestSql());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserFlagDirty()) {
            hashMap.put(FIELD_USERFLAG, this.getUserFlag());
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
        return PSSysDMItemBase.get(this, n);
    }

    private static Object get(PSSysDMItemBase pSSysDMItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemBase.getCreateDate();
            }
            case 1: {
                return pSSysDMItemBase.getCreateMan();
            }
            case 2: {
                return pSSysDMItemBase.getCreateSql();
            }
            case 3: {
                return pSSysDMItemBase.getCreateSql2();
            }
            case 4: {
                return pSSysDMItemBase.getCreateSql3();
            }
            case 5: {
                return pSSysDMItemBase.getCreateSql4();
            }
            case 6: {
                return pSSysDMItemBase.getCreateSql5();
            }
            case 7: {
                return pSSysDMItemBase.getCreateSql6();
            }
            case 8: {
                return pSSysDMItemBase.getCreateSql7();
            }
            case 9: {
                return pSSysDMItemBase.getDBObjType();
            }
            case 10: {
                return pSSysDMItemBase.getDropSql();
            }
            case 11: {
                return pSSysDMItemBase.getMemo();
            }
            case 12: {
                return pSSysDMItemBase.getPSDEId();
            }
            case 13: {
                return pSSysDMItemBase.getPSDEName();
            }
            case 14: {
                return pSSysDMItemBase.getPSObjId();
            }
            case 15: {
                return pSSysDMItemBase.getPSObjName();
            }
            case 16: {
                return pSSysDMItemBase.getPSSysDMItemId();
            }
            case 17: {
                return pSSysDMItemBase.getPSSysDMItemName();
            }
            case 18: {
                return pSSysDMItemBase.getPSSysDMVerId();
            }
            case 19: {
                return pSSysDMItemBase.getPSSysDMVerName();
            }
            case 20: {
                return pSSysDMItemBase.getPSSystemDBCfgId();
            }
            case 21: {
                return pSSysDMItemBase.getPSSystemDBCfgName();
            }
            case 22: {
                return pSSysDMItemBase.getSysDBVer();
            }
            case 23: {
                return pSSysDMItemBase.getTestSql();
            }
            case 24: {
                return pSSysDMItemBase.getUpdateDate();
            }
            case 25: {
                return pSSysDMItemBase.getUpdateMan();
            }
            case 26: {
                return pSSysDMItemBase.getUserFlag();
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
        PSSysDMItemBase.set(this, n, object);
    }

    private static void set(PSSysDMItemBase pSSysDMItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDMItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDMItemBase.setCreateSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDMItemBase.setCreateSql2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDMItemBase.setCreateSql3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDMItemBase.setCreateSql4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDMItemBase.setCreateSql5(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDMItemBase.setCreateSql6(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDMItemBase.setCreateSql7(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDMItemBase.setDBObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDMItemBase.setDropSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDMItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDMItemBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDMItemBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDMItemBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDMItemBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDMItemBase.setPSSysDMItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDMItemBase.setPSSysDMItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDMItemBase.setPSSysDMVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDMItemBase.setPSSysDMVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDMItemBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDMItemBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDMItemBase.setSysDBVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSSysDMItemBase.setTestSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDMItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSSysDMItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDMItemBase.setUserFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysDMItemBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDMItemBase pSSysDMItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDMItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDMItemBase.getCreateSql() == null;
            }
            case 3: {
                return pSSysDMItemBase.getCreateSql2() == null;
            }
            case 4: {
                return pSSysDMItemBase.getCreateSql3() == null;
            }
            case 5: {
                return pSSysDMItemBase.getCreateSql4() == null;
            }
            case 6: {
                return pSSysDMItemBase.getCreateSql5() == null;
            }
            case 7: {
                return pSSysDMItemBase.getCreateSql6() == null;
            }
            case 8: {
                return pSSysDMItemBase.getCreateSql7() == null;
            }
            case 9: {
                return pSSysDMItemBase.getDBObjType() == null;
            }
            case 10: {
                return pSSysDMItemBase.getDropSql() == null;
            }
            case 11: {
                return pSSysDMItemBase.getMemo() == null;
            }
            case 12: {
                return pSSysDMItemBase.getPSDEId() == null;
            }
            case 13: {
                return pSSysDMItemBase.getPSDEName() == null;
            }
            case 14: {
                return pSSysDMItemBase.getPSObjId() == null;
            }
            case 15: {
                return pSSysDMItemBase.getPSObjName() == null;
            }
            case 16: {
                return pSSysDMItemBase.getPSSysDMItemId() == null;
            }
            case 17: {
                return pSSysDMItemBase.getPSSysDMItemName() == null;
            }
            case 18: {
                return pSSysDMItemBase.getPSSysDMVerId() == null;
            }
            case 19: {
                return pSSysDMItemBase.getPSSysDMVerName() == null;
            }
            case 20: {
                return pSSysDMItemBase.getPSSystemDBCfgId() == null;
            }
            case 21: {
                return pSSysDMItemBase.getPSSystemDBCfgName() == null;
            }
            case 22: {
                return pSSysDMItemBase.getSysDBVer() == null;
            }
            case 23: {
                return pSSysDMItemBase.getTestSql() == null;
            }
            case 24: {
                return pSSysDMItemBase.getUpdateDate() == null;
            }
            case 25: {
                return pSSysDMItemBase.getUpdateMan() == null;
            }
            case 26: {
                return pSSysDMItemBase.getUserFlag() == null;
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
        return PSSysDMItemBase.contains(this, n);
    }

    private static boolean contains(PSSysDMItemBase pSSysDMItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDMItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDMItemBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDMItemBase.isCreateSqlDirty();
            }
            case 3: {
                return pSSysDMItemBase.isCreateSql2Dirty();
            }
            case 4: {
                return pSSysDMItemBase.isCreateSql3Dirty();
            }
            case 5: {
                return pSSysDMItemBase.isCreateSql4Dirty();
            }
            case 6: {
                return pSSysDMItemBase.isCreateSql5Dirty();
            }
            case 7: {
                return pSSysDMItemBase.isCreateSql6Dirty();
            }
            case 8: {
                return pSSysDMItemBase.isCreateSql7Dirty();
            }
            case 9: {
                return pSSysDMItemBase.isDBObjTypeDirty();
            }
            case 10: {
                return pSSysDMItemBase.isDropSqlDirty();
            }
            case 11: {
                return pSSysDMItemBase.isMemoDirty();
            }
            case 12: {
                return pSSysDMItemBase.isPSDEIdDirty();
            }
            case 13: {
                return pSSysDMItemBase.isPSDENameDirty();
            }
            case 14: {
                return pSSysDMItemBase.isPSObjIdDirty();
            }
            case 15: {
                return pSSysDMItemBase.isPSObjNameDirty();
            }
            case 16: {
                return pSSysDMItemBase.isPSSysDMItemIdDirty();
            }
            case 17: {
                return pSSysDMItemBase.isPSSysDMItemNameDirty();
            }
            case 18: {
                return pSSysDMItemBase.isPSSysDMVerIdDirty();
            }
            case 19: {
                return pSSysDMItemBase.isPSSysDMVerNameDirty();
            }
            case 20: {
                return pSSysDMItemBase.isPSSystemDBCfgIdDirty();
            }
            case 21: {
                return pSSysDMItemBase.isPSSystemDBCfgNameDirty();
            }
            case 22: {
                return pSSysDMItemBase.isSysDBVerDirty();
            }
            case 23: {
                return pSSysDMItemBase.isTestSqlDirty();
            }
            case 24: {
                return pSSysDMItemBase.isUpdateDateDirty();
            }
            case 25: {
                return pSSysDMItemBase.isUpdateManDirty();
            }
            case 26: {
                return pSSysDMItemBase.isUserFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDMItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDMItemBase pSSysDMItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDMItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql2", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql2()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql3", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql3()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql4", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql4()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql5", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql5()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql6", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql6()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getCreateSql7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createsql7", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getCreateSql7()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getDBObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbobjtype", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getDBObjType()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getDropSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dropsql", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getDropSql()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSysDMItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmitemid", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSysDMItemId()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSysDMItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmitemname", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSysDMItemName()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSysDMVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmverid", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSysDMVerId()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSysDMVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdmvername", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSysDMVerName()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getSysDBVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysdbver", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getSysDBVer()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getTestSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testsql", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getTestSql()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDMItemBase.getUserFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userflag", (Object)PSSysDMItemBase.getJSONValue((Object)pSSysDMItemBase.getUserFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDMItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDMItemBase pSSysDMItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDMItemBase.getCreateDate() != null) {
            object = pSSysDMItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMItemBase.getCreateMan() != null) {
            object = pSSysDMItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql() != null) {
            object = pSSysDMItemBase.getCreateSql();
            xmlNode.setAttribute(FIELD_CREATESQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql2() != null) {
            object = pSSysDMItemBase.getCreateSql2();
            xmlNode.setAttribute(FIELD_CREATESQL2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql3() != null) {
            object = pSSysDMItemBase.getCreateSql3();
            xmlNode.setAttribute(FIELD_CREATESQL3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql4() != null) {
            object = pSSysDMItemBase.getCreateSql4();
            xmlNode.setAttribute(FIELD_CREATESQL4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql5() != null) {
            object = pSSysDMItemBase.getCreateSql5();
            xmlNode.setAttribute(FIELD_CREATESQL5, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql6() != null) {
            object = pSSysDMItemBase.getCreateSql6();
            xmlNode.setAttribute(FIELD_CREATESQL6, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getCreateSql7() != null) {
            object = pSSysDMItemBase.getCreateSql7();
            xmlNode.setAttribute(FIELD_CREATESQL7, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getDBObjType() != null) {
            object = pSSysDMItemBase.getDBObjType();
            xmlNode.setAttribute(FIELD_DBOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getDropSql() != null) {
            object = pSSysDMItemBase.getDropSql();
            xmlNode.setAttribute(FIELD_DROPSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getMemo() != null) {
            object = pSSysDMItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSDEId() != null) {
            object = pSSysDMItemBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSDEName() != null) {
            object = pSSysDMItemBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSObjId() != null) {
            object = pSSysDMItemBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSObjName() != null) {
            object = pSSysDMItemBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSysDMItemId() != null) {
            object = pSSysDMItemBase.getPSSysDMItemId();
            xmlNode.setAttribute(FIELD_PSSYSDMITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSysDMItemName() != null) {
            object = pSSysDMItemBase.getPSSysDMItemName();
            xmlNode.setAttribute(FIELD_PSSYSDMITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSysDMVerId() != null) {
            object = pSSysDMItemBase.getPSSysDMVerId();
            xmlNode.setAttribute(FIELD_PSSYSDMVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSysDMVerName() != null) {
            object = pSSysDMItemBase.getPSSysDMVerName();
            xmlNode.setAttribute(FIELD_PSSYSDMVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSystemDBCfgId() != null) {
            object = pSSysDMItemBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getPSSystemDBCfgName() != null) {
            object = pSSysDMItemBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getSysDBVer() != null) {
            object = pSSysDMItemBase.getSysDBVer();
            xmlNode.setAttribute(FIELD_SYSDBVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDMItemBase.getTestSql() != null) {
            object = pSSysDMItemBase.getTestSql();
            xmlNode.setAttribute(FIELD_TESTSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getUpdateDate() != null) {
            object = pSSysDMItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDMItemBase.getUpdateMan() != null) {
            object = pSSysDMItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDMItemBase.getUserFlag() != null) {
            object = pSSysDMItemBase.getUserFlag();
            xmlNode.setAttribute(FIELD_USERFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDMItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDMItemBase pSSysDMItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDMItemBase.isCreateDateDirty() && (bl || pSSysDMItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDMItemBase.getCreateDate());
        }
        if (pSSysDMItemBase.isCreateManDirty() && (bl || pSSysDMItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDMItemBase.getCreateMan());
        }
        if (pSSysDMItemBase.isCreateSqlDirty() && (bl || pSSysDMItemBase.getCreateSql() != null)) {
            iDataObject.set(FIELD_CREATESQL, (Object)pSSysDMItemBase.getCreateSql());
        }
        if (pSSysDMItemBase.isCreateSql2Dirty() && (bl || pSSysDMItemBase.getCreateSql2() != null)) {
            iDataObject.set(FIELD_CREATESQL2, (Object)pSSysDMItemBase.getCreateSql2());
        }
        if (pSSysDMItemBase.isCreateSql3Dirty() && (bl || pSSysDMItemBase.getCreateSql3() != null)) {
            iDataObject.set(FIELD_CREATESQL3, (Object)pSSysDMItemBase.getCreateSql3());
        }
        if (pSSysDMItemBase.isCreateSql4Dirty() && (bl || pSSysDMItemBase.getCreateSql4() != null)) {
            iDataObject.set(FIELD_CREATESQL4, (Object)pSSysDMItemBase.getCreateSql4());
        }
        if (pSSysDMItemBase.isCreateSql5Dirty() && (bl || pSSysDMItemBase.getCreateSql5() != null)) {
            iDataObject.set(FIELD_CREATESQL5, (Object)pSSysDMItemBase.getCreateSql5());
        }
        if (pSSysDMItemBase.isCreateSql6Dirty() && (bl || pSSysDMItemBase.getCreateSql6() != null)) {
            iDataObject.set(FIELD_CREATESQL6, (Object)pSSysDMItemBase.getCreateSql6());
        }
        if (pSSysDMItemBase.isCreateSql7Dirty() && (bl || pSSysDMItemBase.getCreateSql7() != null)) {
            iDataObject.set(FIELD_CREATESQL7, (Object)pSSysDMItemBase.getCreateSql7());
        }
        if (pSSysDMItemBase.isDBObjTypeDirty() && (bl || pSSysDMItemBase.getDBObjType() != null)) {
            iDataObject.set(FIELD_DBOBJTYPE, (Object)pSSysDMItemBase.getDBObjType());
        }
        if (pSSysDMItemBase.isDropSqlDirty() && (bl || pSSysDMItemBase.getDropSql() != null)) {
            iDataObject.set(FIELD_DROPSQL, (Object)pSSysDMItemBase.getDropSql());
        }
        if (pSSysDMItemBase.isMemoDirty() && (bl || pSSysDMItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDMItemBase.getMemo());
        }
        if (pSSysDMItemBase.isPSDEIdDirty() && (bl || pSSysDMItemBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysDMItemBase.getPSDEId());
        }
        if (pSSysDMItemBase.isPSDENameDirty() && (bl || pSSysDMItemBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysDMItemBase.getPSDEName());
        }
        if (pSSysDMItemBase.isPSObjIdDirty() && (bl || pSSysDMItemBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSSysDMItemBase.getPSObjId());
        }
        if (pSSysDMItemBase.isPSObjNameDirty() && (bl || pSSysDMItemBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSSysDMItemBase.getPSObjName());
        }
        if (pSSysDMItemBase.isPSSysDMItemIdDirty() && (bl || pSSysDMItemBase.getPSSysDMItemId() != null)) {
            iDataObject.set(FIELD_PSSYSDMITEMID, (Object)pSSysDMItemBase.getPSSysDMItemId());
        }
        if (pSSysDMItemBase.isPSSysDMItemNameDirty() && (bl || pSSysDMItemBase.getPSSysDMItemName() != null)) {
            iDataObject.set(FIELD_PSSYSDMITEMNAME, (Object)pSSysDMItemBase.getPSSysDMItemName());
        }
        if (pSSysDMItemBase.isPSSysDMVerIdDirty() && (bl || pSSysDMItemBase.getPSSysDMVerId() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERID, (Object)pSSysDMItemBase.getPSSysDMVerId());
        }
        if (pSSysDMItemBase.isPSSysDMVerNameDirty() && (bl || pSSysDMItemBase.getPSSysDMVerName() != null)) {
            iDataObject.set(FIELD_PSSYSDMVERNAME, (Object)pSSysDMItemBase.getPSSysDMVerName());
        }
        if (pSSysDMItemBase.isPSSystemDBCfgIdDirty() && (bl || pSSysDMItemBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSysDMItemBase.getPSSystemDBCfgId());
        }
        if (pSSysDMItemBase.isPSSystemDBCfgNameDirty() && (bl || pSSysDMItemBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSysDMItemBase.getPSSystemDBCfgName());
        }
        if (pSSysDMItemBase.isSysDBVerDirty() && (bl || pSSysDMItemBase.getSysDBVer() != null)) {
            iDataObject.set(FIELD_SYSDBVER, (Object)pSSysDMItemBase.getSysDBVer());
        }
        if (pSSysDMItemBase.isTestSqlDirty() && (bl || pSSysDMItemBase.getTestSql() != null)) {
            iDataObject.set(FIELD_TESTSQL, (Object)pSSysDMItemBase.getTestSql());
        }
        if (pSSysDMItemBase.isUpdateDateDirty() && (bl || pSSysDMItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDMItemBase.getUpdateDate());
        }
        if (pSSysDMItemBase.isUpdateManDirty() && (bl || pSSysDMItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDMItemBase.getUpdateMan());
        }
        if (pSSysDMItemBase.isUserFlagDirty() && (bl || pSSysDMItemBase.getUserFlag() != null)) {
            iDataObject.set(FIELD_USERFLAG, (Object)pSSysDMItemBase.getUserFlag());
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
        return PSSysDMItemBase.remove(this, n);
    }

    private static boolean remove(PSSysDMItemBase pSSysDMItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDMItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDMItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDMItemBase.resetCreateSql();
                return true;
            }
            case 3: {
                pSSysDMItemBase.resetCreateSql2();
                return true;
            }
            case 4: {
                pSSysDMItemBase.resetCreateSql3();
                return true;
            }
            case 5: {
                pSSysDMItemBase.resetCreateSql4();
                return true;
            }
            case 6: {
                pSSysDMItemBase.resetCreateSql5();
                return true;
            }
            case 7: {
                pSSysDMItemBase.resetCreateSql6();
                return true;
            }
            case 8: {
                pSSysDMItemBase.resetCreateSql7();
                return true;
            }
            case 9: {
                pSSysDMItemBase.resetDBObjType();
                return true;
            }
            case 10: {
                pSSysDMItemBase.resetDropSql();
                return true;
            }
            case 11: {
                pSSysDMItemBase.resetMemo();
                return true;
            }
            case 12: {
                pSSysDMItemBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSSysDMItemBase.resetPSDEName();
                return true;
            }
            case 14: {
                pSSysDMItemBase.resetPSObjId();
                return true;
            }
            case 15: {
                pSSysDMItemBase.resetPSObjName();
                return true;
            }
            case 16: {
                pSSysDMItemBase.resetPSSysDMItemId();
                return true;
            }
            case 17: {
                pSSysDMItemBase.resetPSSysDMItemName();
                return true;
            }
            case 18: {
                pSSysDMItemBase.resetPSSysDMVerId();
                return true;
            }
            case 19: {
                pSSysDMItemBase.resetPSSysDMVerName();
                return true;
            }
            case 20: {
                pSSysDMItemBase.resetPSSystemDBCfgId();
                return true;
            }
            case 21: {
                pSSysDMItemBase.resetPSSystemDBCfgName();
                return true;
            }
            case 22: {
                pSSysDMItemBase.resetSysDBVer();
                return true;
            }
            case 23: {
                pSSysDMItemBase.resetTestSql();
                return true;
            }
            case 24: {
                pSSysDMItemBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSSysDMItemBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSSysDMItemBase.resetUserFlag();
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

    private PSSysDMItemBase getProxyEntity() {
        return this.proxyPSSysDMItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDMItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDMItemBase) {
            this.proxyPSSysDMItemBase = (PSSysDMItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CREATESQL, 2);
        fieldIndexMap.put(FIELD_CREATESQL2, 3);
        fieldIndexMap.put(FIELD_CREATESQL3, 4);
        fieldIndexMap.put(FIELD_CREATESQL4, 5);
        fieldIndexMap.put(FIELD_CREATESQL5, 6);
        fieldIndexMap.put(FIELD_CREATESQL6, 7);
        fieldIndexMap.put(FIELD_CREATESQL7, 8);
        fieldIndexMap.put(FIELD_DBOBJTYPE, 9);
        fieldIndexMap.put(FIELD_DROPSQL, 10);
        fieldIndexMap.put(FIELD_MEMO, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDENAME, 13);
        fieldIndexMap.put(FIELD_PSOBJID, 14);
        fieldIndexMap.put(FIELD_PSOBJNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSDMITEMID, 16);
        fieldIndexMap.put(FIELD_PSSYSDMITEMNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSDMVERID, 18);
        fieldIndexMap.put(FIELD_PSSYSDMVERNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 20);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 21);
        fieldIndexMap.put(FIELD_SYSDBVER, 22);
        fieldIndexMap.put(FIELD_TESTSQL, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_USERFLAG, 26);
    }
}

