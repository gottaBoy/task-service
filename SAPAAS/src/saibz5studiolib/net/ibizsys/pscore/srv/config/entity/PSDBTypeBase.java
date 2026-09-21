/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBCLIENTPATH = "DBCLIENTPATH";
    public static final String FIELD_DEDBCFGOBJ = "DEDBCFGOBJ";
    public static final String FIELD_DEDQENGOBJ = "DEDQENGOBJ";
    public static final String FIELD_DEDQPUBOBJ = "DEDQPUBOBJ";
    public static final String FIELD_DEDSPUBOBJ = "DEDSPUBOBJ";
    public static final String FIELD_DEFDTCOLOBJ = "DEFDTCOLOBJ";
    public static final String FIELD_DELETESPPUBOBJ = "DELETESPPUBOBJ";
    public static final String FIELD_GETSPPUBOBJ = "GETSPPUBOBJ";
    public static final String FIELD_HIBDIALECT = "HIBDIALECT";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_INSERTSPPUBOBJ = "INSERTSPPUBOBJ";
    public static final String FIELD_INSTALLPATH = "INSTALLPATH";
    public static final String FIELD_JDBCDIALECT = "JDBCDIALECT";
    public static final String FIELD_JDBCDRIVERNAME = "JDBCDRIVERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDBTYPEID = "PSDBTYPEID";
    public static final String FIELD_PSDBTYPENAME = "PSDBTYPENAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_SYSDBCFGOBJ = "SYSDBCFGOBJ";
    public static final String FIELD_TYPEHELPER = "TYPEHELPER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UPDATESPPUBOBJ = "UPDATESPPUBOBJ";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBCLIENTPATH = 2;
    private static final int INDEX_DEDBCFGOBJ = 3;
    private static final int INDEX_DEDQENGOBJ = 4;
    private static final int INDEX_DEDQPUBOBJ = 5;
    private static final int INDEX_DEDSPUBOBJ = 6;
    private static final int INDEX_DEFDTCOLOBJ = 7;
    private static final int INDEX_DELETESPPUBOBJ = 8;
    private static final int INDEX_GETSPPUBOBJ = 9;
    private static final int INDEX_HIBDIALECT = 10;
    private static final int INDEX_ICONPATH = 11;
    private static final int INDEX_INSERTSPPUBOBJ = 12;
    private static final int INDEX_INSTALLPATH = 13;
    private static final int INDEX_JDBCDIALECT = 14;
    private static final int INDEX_JDBCDRIVERNAME = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_PSDBTYPEID = 17;
    private static final int INDEX_PSDBTYPENAME = 18;
    private static final int INDEX_PUBMODE = 19;
    private static final int INDEX_SYSDBCFGOBJ = 20;
    private static final int INDEX_TYPEHELPER = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final int INDEX_UPDATESPPUBOBJ = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBTypeBase proxyPSDBTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbclientpathDirtyFlag = false;
    private boolean dedbcfgobjDirtyFlag = false;
    private boolean dedqengobjDirtyFlag = false;
    private boolean dedqpubobjDirtyFlag = false;
    private boolean dedspubobjDirtyFlag = false;
    private boolean defdtcolobjDirtyFlag = false;
    private boolean deletesppubobjDirtyFlag = false;
    private boolean getsppubobjDirtyFlag = false;
    private boolean hibdialectDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean insertsppubobjDirtyFlag = false;
    private boolean installpathDirtyFlag = false;
    private boolean jdbcdialectDirtyFlag = false;
    private boolean jdbcdrivernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdbtypeidDirtyFlag = false;
    private boolean psdbtypenameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean sysdbcfgobjDirtyFlag = false;
    private boolean typehelperDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean updatesppubobjDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbclientpath")
    private String dbclientpath;
    @Column(name="dedbcfgobj")
    private String dedbcfgobj;
    @Column(name="dedqengobj")
    private String dedqengobj;
    @Column(name="dedqpubobj")
    private String dedqpubobj;
    @Column(name="dedspubobj")
    private String dedspubobj;
    @Column(name="defdtcolobj")
    private String defdtcolobj;
    @Column(name="deletesppubobj")
    private String deletesppubobj;
    @Column(name="getsppubobj")
    private String getsppubobj;
    @Column(name="hibdialect")
    private String hibdialect;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="insertsppubobj")
    private String insertsppubobj;
    @Column(name="installpath")
    private String installpath;
    @Column(name="jdbcdialect")
    private String jdbcdialect;
    @Column(name="jdbcdrivername")
    private String jdbcdrivername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdbtypeid")
    private String psdbtypeid;
    @Column(name="psdbtypename")
    private String psdbtypename;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="sysdbcfgobj")
    private String sysdbcfgobj;
    @Column(name="typehelper")
    private String typehelper;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="updatesppubobj")
    private String updatesppubobj;

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

    public void setDBClientPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBClientPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbclientpath = string;
        this.dbclientpathDirtyFlag = true;
    }

    public String getDBClientPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBClientPath();
        }
        return this.dbclientpath;
    }

    public boolean isDBClientPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBClientPathDirty();
        }
        return this.dbclientpathDirtyFlag;
    }

    public void resetDBClientPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBClientPath();
            return;
        }
        this.dbclientpathDirtyFlag = false;
        this.dbclientpath = null;
    }

    public void setDEDBCfgObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDBCfgObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedbcfgobj = string;
        this.dedbcfgobjDirtyFlag = true;
    }

    public String getDEDBCfgObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDBCfgObj();
        }
        return this.dedbcfgobj;
    }

    public boolean isDEDBCfgObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDBCfgObjDirty();
        }
        return this.dedbcfgobjDirtyFlag;
    }

    public void resetDEDBCfgObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDBCfgObj();
            return;
        }
        this.dedbcfgobjDirtyFlag = false;
        this.dedbcfgobj = null;
    }

    public void setDEDQEngObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDQEngObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedqengobj = string;
        this.dedqengobjDirtyFlag = true;
    }

    public String getDEDQEngObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDQEngObj();
        }
        return this.dedqengobj;
    }

    public boolean isDEDQEngObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDQEngObjDirty();
        }
        return this.dedqengobjDirtyFlag;
    }

    public void resetDEDQEngObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDQEngObj();
            return;
        }
        this.dedqengobjDirtyFlag = false;
        this.dedqengobj = null;
    }

    public void setDEDQPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDQPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedqpubobj = string;
        this.dedqpubobjDirtyFlag = true;
    }

    public String getDEDQPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDQPubObj();
        }
        return this.dedqpubobj;
    }

    public boolean isDEDQPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDQPubObjDirty();
        }
        return this.dedqpubobjDirtyFlag;
    }

    public void resetDEDQPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDQPubObj();
            return;
        }
        this.dedqpubobjDirtyFlag = false;
        this.dedqpubobj = null;
    }

    public void setDEDSPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDSPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedspubobj = string;
        this.dedspubobjDirtyFlag = true;
    }

    public String getDEDSPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDSPubObj();
        }
        return this.dedspubobj;
    }

    public boolean isDEDSPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDSPubObjDirty();
        }
        return this.dedspubobjDirtyFlag;
    }

    public void resetDEDSPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDSPubObj();
            return;
        }
        this.dedspubobjDirtyFlag = false;
        this.dedspubobj = null;
    }

    public void setDEFDTColObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFDTColObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defdtcolobj = string;
        this.defdtcolobjDirtyFlag = true;
    }

    public String getDEFDTColObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFDTColObj();
        }
        return this.defdtcolobj;
    }

    public boolean isDEFDTColObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFDTColObjDirty();
        }
        return this.defdtcolobjDirtyFlag;
    }

    public void resetDEFDTColObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFDTColObj();
            return;
        }
        this.defdtcolobjDirtyFlag = false;
        this.defdtcolobj = null;
    }

    public void setDeleteSPPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeleteSPPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deletesppubobj = string;
        this.deletesppubobjDirtyFlag = true;
    }

    public String getDeleteSPPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeleteSPPubObj();
        }
        return this.deletesppubobj;
    }

    public boolean isDeleteSPPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeleteSPPubObjDirty();
        }
        return this.deletesppubobjDirtyFlag;
    }

    public void resetDeleteSPPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeleteSPPubObj();
            return;
        }
        this.deletesppubobjDirtyFlag = false;
        this.deletesppubobj = null;
    }

    public void setGetSPPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGetSPPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.getsppubobj = string;
        this.getsppubobjDirtyFlag = true;
    }

    public String getGetSPPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGetSPPubObj();
        }
        return this.getsppubobj;
    }

    public boolean isGetSPPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGetSPPubObjDirty();
        }
        return this.getsppubobjDirtyFlag;
    }

    public void resetGetSPPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGetSPPubObj();
            return;
        }
        this.getsppubobjDirtyFlag = false;
        this.getsppubobj = null;
    }

    public void setHibDialect(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHibDialect(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hibdialect = string;
        this.hibdialectDirtyFlag = true;
    }

    public String getHibDialect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHibDialect();
        }
        return this.hibdialect;
    }

    public boolean isHibDialectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHibDialectDirty();
        }
        return this.hibdialectDirtyFlag;
    }

    public void resetHibDialect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHibDialect();
            return;
        }
        this.hibdialectDirtyFlag = false;
        this.hibdialect = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setInsertSPPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInsertSPPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insertsppubobj = string;
        this.insertsppubobjDirtyFlag = true;
    }

    public String getInsertSPPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInsertSPPubObj();
        }
        return this.insertsppubobj;
    }

    public boolean isInsertSPPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInsertSPPubObjDirty();
        }
        return this.insertsppubobjDirtyFlag;
    }

    public void resetInsertSPPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInsertSPPubObj();
            return;
        }
        this.insertsppubobjDirtyFlag = false;
        this.insertsppubobj = null;
    }

    public void setInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.installpath = string;
        this.installpathDirtyFlag = true;
    }

    public String getInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstallPath();
        }
        return this.installpath;
    }

    public boolean isInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstallPathDirty();
        }
        return this.installpathDirtyFlag;
    }

    public void resetInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstallPath();
            return;
        }
        this.installpathDirtyFlag = false;
        this.installpath = null;
    }

    public void setJdbcDialect(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJdbcDialect(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jdbcdialect = string;
        this.jdbcdialectDirtyFlag = true;
    }

    public String getJdbcDialect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJdbcDialect();
        }
        return this.jdbcdialect;
    }

    public boolean isJdbcDialectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJdbcDialectDirty();
        }
        return this.jdbcdialectDirtyFlag;
    }

    public void resetJdbcDialect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJdbcDialect();
            return;
        }
        this.jdbcdialectDirtyFlag = false;
        this.jdbcdialect = null;
    }

    public void setJdbcDriverName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJdbcDriverName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jdbcdrivername = string;
        this.jdbcdrivernameDirtyFlag = true;
    }

    public String getJdbcDriverName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJdbcDriverName();
        }
        return this.jdbcdrivername;
    }

    public boolean isJdbcDriverNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJdbcDriverNameDirty();
        }
        return this.jdbcdrivernameDirtyFlag;
    }

    public void resetJdbcDriverName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJdbcDriverName();
            return;
        }
        this.jdbcdrivernameDirtyFlag = false;
        this.jdbcdrivername = null;
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

    public void setPSDBTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypeid = string;
        this.psdbtypeidDirtyFlag = true;
    }

    public String getPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeId();
        }
        return this.psdbtypeid;
    }

    public boolean isPSDBTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeIdDirty();
        }
        return this.psdbtypeidDirtyFlag;
    }

    public void resetPSDBTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeId();
            return;
        }
        this.psdbtypeidDirtyFlag = false;
        this.psdbtypeid = null;
    }

    public void setPSDBTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbtypename = string;
        this.psdbtypenameDirtyFlag = true;
    }

    public String getPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBTypeName();
        }
        return this.psdbtypename;
    }

    public boolean isPSDBTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBTypeNameDirty();
        }
        return this.psdbtypenameDirtyFlag;
    }

    public void resetPSDBTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBTypeName();
            return;
        }
        this.psdbtypenameDirtyFlag = false;
        this.psdbtypename = null;
    }

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setSysDBCfgObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysDBCfgObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysdbcfgobj = string;
        this.sysdbcfgobjDirtyFlag = true;
    }

    public String getSysDBCfgObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysDBCfgObj();
        }
        return this.sysdbcfgobj;
    }

    public boolean isSysDBCfgObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysDBCfgObjDirty();
        }
        return this.sysdbcfgobjDirtyFlag;
    }

    public void resetSysDBCfgObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysDBCfgObj();
            return;
        }
        this.sysdbcfgobjDirtyFlag = false;
        this.sysdbcfgobj = null;
    }

    public void setTypeHelper(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeHelper(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typehelper = string;
        this.typehelperDirtyFlag = true;
    }

    public String getTypeHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeHelper();
        }
        return this.typehelper;
    }

    public boolean isTypeHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeHelperDirty();
        }
        return this.typehelperDirtyFlag;
    }

    public void resetTypeHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeHelper();
            return;
        }
        this.typehelperDirtyFlag = false;
        this.typehelper = null;
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

    public void setUpdateSPPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateSPPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updatesppubobj = string;
        this.updatesppubobjDirtyFlag = true;
    }

    public String getUpdateSPPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateSPPubObj();
        }
        return this.updatesppubobj;
    }

    public boolean isUpdateSPPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateSPPubObjDirty();
        }
        return this.updatesppubobjDirtyFlag;
    }

    public void resetUpdateSPPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateSPPubObj();
            return;
        }
        this.updatesppubobjDirtyFlag = false;
        this.updatesppubobj = null;
    }

    protected void onReset() {
        PSDBTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBTypeBase pSDBTypeBase) {
        pSDBTypeBase.resetCreateDate();
        pSDBTypeBase.resetCreateMan();
        pSDBTypeBase.resetDBClientPath();
        pSDBTypeBase.resetDEDBCfgObj();
        pSDBTypeBase.resetDEDQEngObj();
        pSDBTypeBase.resetDEDQPubObj();
        pSDBTypeBase.resetDEDSPubObj();
        pSDBTypeBase.resetDEFDTColObj();
        pSDBTypeBase.resetDeleteSPPubObj();
        pSDBTypeBase.resetGetSPPubObj();
        pSDBTypeBase.resetHibDialect();
        pSDBTypeBase.resetIconPath();
        pSDBTypeBase.resetInsertSPPubObj();
        pSDBTypeBase.resetInstallPath();
        pSDBTypeBase.resetJdbcDialect();
        pSDBTypeBase.resetJdbcDriverName();
        pSDBTypeBase.resetMemo();
        pSDBTypeBase.resetPSDBTypeId();
        pSDBTypeBase.resetPSDBTypeName();
        pSDBTypeBase.resetPubMode();
        pSDBTypeBase.resetSysDBCfgObj();
        pSDBTypeBase.resetTypeHelper();
        pSDBTypeBase.resetUpdateDate();
        pSDBTypeBase.resetUpdateMan();
        pSDBTypeBase.resetUpdateSPPubObj();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBClientPathDirty()) {
            hashMap.put(FIELD_DBCLIENTPATH, this.getDBClientPath());
        }
        if (!bl || this.isDEDBCfgObjDirty()) {
            hashMap.put(FIELD_DEDBCFGOBJ, this.getDEDBCfgObj());
        }
        if (!bl || this.isDEDQEngObjDirty()) {
            hashMap.put(FIELD_DEDQENGOBJ, this.getDEDQEngObj());
        }
        if (!bl || this.isDEDQPubObjDirty()) {
            hashMap.put(FIELD_DEDQPUBOBJ, this.getDEDQPubObj());
        }
        if (!bl || this.isDEDSPubObjDirty()) {
            hashMap.put(FIELD_DEDSPUBOBJ, this.getDEDSPubObj());
        }
        if (!bl || this.isDEFDTColObjDirty()) {
            hashMap.put(FIELD_DEFDTCOLOBJ, this.getDEFDTColObj());
        }
        if (!bl || this.isDeleteSPPubObjDirty()) {
            hashMap.put(FIELD_DELETESPPUBOBJ, this.getDeleteSPPubObj());
        }
        if (!bl || this.isGetSPPubObjDirty()) {
            hashMap.put(FIELD_GETSPPUBOBJ, this.getGetSPPubObj());
        }
        if (!bl || this.isHibDialectDirty()) {
            hashMap.put(FIELD_HIBDIALECT, this.getHibDialect());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isInsertSPPubObjDirty()) {
            hashMap.put(FIELD_INSERTSPPUBOBJ, this.getInsertSPPubObj());
        }
        if (!bl || this.isInstallPathDirty()) {
            hashMap.put(FIELD_INSTALLPATH, this.getInstallPath());
        }
        if (!bl || this.isJdbcDialectDirty()) {
            hashMap.put(FIELD_JDBCDIALECT, this.getJdbcDialect());
        }
        if (!bl || this.isJdbcDriverNameDirty()) {
            hashMap.put(FIELD_JDBCDRIVERNAME, this.getJdbcDriverName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDBTypeIdDirty()) {
            hashMap.put(FIELD_PSDBTYPEID, this.getPSDBTypeId());
        }
        if (!bl || this.isPSDBTypeNameDirty()) {
            hashMap.put(FIELD_PSDBTYPENAME, this.getPSDBTypeName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isSysDBCfgObjDirty()) {
            hashMap.put(FIELD_SYSDBCFGOBJ, this.getSysDBCfgObj());
        }
        if (!bl || this.isTypeHelperDirty()) {
            hashMap.put(FIELD_TYPEHELPER, this.getTypeHelper());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUpdateSPPubObjDirty()) {
            hashMap.put(FIELD_UPDATESPPUBOBJ, this.getUpdateSPPubObj());
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
        return PSDBTypeBase.get(this, n);
    }

    private static Object get(PSDBTypeBase pSDBTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBTypeBase.getCreateDate();
            }
            case 1: {
                return pSDBTypeBase.getCreateMan();
            }
            case 2: {
                return pSDBTypeBase.getDBClientPath();
            }
            case 3: {
                return pSDBTypeBase.getDEDBCfgObj();
            }
            case 4: {
                return pSDBTypeBase.getDEDQEngObj();
            }
            case 5: {
                return pSDBTypeBase.getDEDQPubObj();
            }
            case 6: {
                return pSDBTypeBase.getDEDSPubObj();
            }
            case 7: {
                return pSDBTypeBase.getDEFDTColObj();
            }
            case 8: {
                return pSDBTypeBase.getDeleteSPPubObj();
            }
            case 9: {
                return pSDBTypeBase.getGetSPPubObj();
            }
            case 10: {
                return pSDBTypeBase.getHibDialect();
            }
            case 11: {
                return pSDBTypeBase.getIconPath();
            }
            case 12: {
                return pSDBTypeBase.getInsertSPPubObj();
            }
            case 13: {
                return pSDBTypeBase.getInstallPath();
            }
            case 14: {
                return pSDBTypeBase.getJdbcDialect();
            }
            case 15: {
                return pSDBTypeBase.getJdbcDriverName();
            }
            case 16: {
                return pSDBTypeBase.getMemo();
            }
            case 17: {
                return pSDBTypeBase.getPSDBTypeId();
            }
            case 18: {
                return pSDBTypeBase.getPSDBTypeName();
            }
            case 19: {
                return pSDBTypeBase.getPubMode();
            }
            case 20: {
                return pSDBTypeBase.getSysDBCfgObj();
            }
            case 21: {
                return pSDBTypeBase.getTypeHelper();
            }
            case 22: {
                return pSDBTypeBase.getUpdateDate();
            }
            case 23: {
                return pSDBTypeBase.getUpdateMan();
            }
            case 24: {
                return pSDBTypeBase.getUpdateSPPubObj();
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
        PSDBTypeBase.set(this, n, object);
    }

    private static void set(PSDBTypeBase pSDBTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBTypeBase.setDBClientPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBTypeBase.setDEDBCfgObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDBTypeBase.setDEDQEngObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDBTypeBase.setDEDQPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBTypeBase.setDEDSPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBTypeBase.setDEFDTColObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBTypeBase.setDeleteSPPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBTypeBase.setGetSPPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBTypeBase.setHibDialect(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDBTypeBase.setInsertSPPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDBTypeBase.setInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDBTypeBase.setJdbcDialect(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDBTypeBase.setJdbcDriverName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDBTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDBTypeBase.setPSDBTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDBTypeBase.setPSDBTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDBTypeBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDBTypeBase.setSysDBCfgObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDBTypeBase.setTypeHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDBTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDBTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDBTypeBase.setUpdateSPPubObj(DataObject.getStringValue((Object)object));
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
        return PSDBTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDBTypeBase pSDBTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBTypeBase.getDBClientPath() == null;
            }
            case 3: {
                return pSDBTypeBase.getDEDBCfgObj() == null;
            }
            case 4: {
                return pSDBTypeBase.getDEDQEngObj() == null;
            }
            case 5: {
                return pSDBTypeBase.getDEDQPubObj() == null;
            }
            case 6: {
                return pSDBTypeBase.getDEDSPubObj() == null;
            }
            case 7: {
                return pSDBTypeBase.getDEFDTColObj() == null;
            }
            case 8: {
                return pSDBTypeBase.getDeleteSPPubObj() == null;
            }
            case 9: {
                return pSDBTypeBase.getGetSPPubObj() == null;
            }
            case 10: {
                return pSDBTypeBase.getHibDialect() == null;
            }
            case 11: {
                return pSDBTypeBase.getIconPath() == null;
            }
            case 12: {
                return pSDBTypeBase.getInsertSPPubObj() == null;
            }
            case 13: {
                return pSDBTypeBase.getInstallPath() == null;
            }
            case 14: {
                return pSDBTypeBase.getJdbcDialect() == null;
            }
            case 15: {
                return pSDBTypeBase.getJdbcDriverName() == null;
            }
            case 16: {
                return pSDBTypeBase.getMemo() == null;
            }
            case 17: {
                return pSDBTypeBase.getPSDBTypeId() == null;
            }
            case 18: {
                return pSDBTypeBase.getPSDBTypeName() == null;
            }
            case 19: {
                return pSDBTypeBase.getPubMode() == null;
            }
            case 20: {
                return pSDBTypeBase.getSysDBCfgObj() == null;
            }
            case 21: {
                return pSDBTypeBase.getTypeHelper() == null;
            }
            case 22: {
                return pSDBTypeBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDBTypeBase.getUpdateMan() == null;
            }
            case 24: {
                return pSDBTypeBase.getUpdateSPPubObj() == null;
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
        return PSDBTypeBase.contains(this, n);
    }

    private static boolean contains(PSDBTypeBase pSDBTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDBTypeBase.isDBClientPathDirty();
            }
            case 3: {
                return pSDBTypeBase.isDEDBCfgObjDirty();
            }
            case 4: {
                return pSDBTypeBase.isDEDQEngObjDirty();
            }
            case 5: {
                return pSDBTypeBase.isDEDQPubObjDirty();
            }
            case 6: {
                return pSDBTypeBase.isDEDSPubObjDirty();
            }
            case 7: {
                return pSDBTypeBase.isDEFDTColObjDirty();
            }
            case 8: {
                return pSDBTypeBase.isDeleteSPPubObjDirty();
            }
            case 9: {
                return pSDBTypeBase.isGetSPPubObjDirty();
            }
            case 10: {
                return pSDBTypeBase.isHibDialectDirty();
            }
            case 11: {
                return pSDBTypeBase.isIconPathDirty();
            }
            case 12: {
                return pSDBTypeBase.isInsertSPPubObjDirty();
            }
            case 13: {
                return pSDBTypeBase.isInstallPathDirty();
            }
            case 14: {
                return pSDBTypeBase.isJdbcDialectDirty();
            }
            case 15: {
                return pSDBTypeBase.isJdbcDriverNameDirty();
            }
            case 16: {
                return pSDBTypeBase.isMemoDirty();
            }
            case 17: {
                return pSDBTypeBase.isPSDBTypeIdDirty();
            }
            case 18: {
                return pSDBTypeBase.isPSDBTypeNameDirty();
            }
            case 19: {
                return pSDBTypeBase.isPubModeDirty();
            }
            case 20: {
                return pSDBTypeBase.isSysDBCfgObjDirty();
            }
            case 21: {
                return pSDBTypeBase.isTypeHelperDirty();
            }
            case 22: {
                return pSDBTypeBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDBTypeBase.isUpdateManDirty();
            }
            case 24: {
                return pSDBTypeBase.isUpdateSPPubObjDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBTypeBase pSDBTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDBClientPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbclientpath", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDBClientPath()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDEDBCfgObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedbcfgobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDEDBCfgObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDEDQEngObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedqengobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDEDQEngObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDEDQPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedqpubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDEDQPubObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDEDSPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedspubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDEDSPubObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDEFDTColObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdtcolobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDEFDTColObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getDeleteSPPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deletesppubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getDeleteSPPubObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getGetSPPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"getsppubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getGetSPPubObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getHibDialect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hibdialect", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getHibDialect()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getInsertSPPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insertsppubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getInsertSPPubObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"installpath", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getInstallPath()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getJdbcDialect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jdbcdialect", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getJdbcDialect()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getJdbcDriverName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jdbcdrivername", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getJdbcDriverName()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getPSDBTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypeid", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getPSDBTypeId()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getPSDBTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbtypename", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getPSDBTypeName()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getPubMode()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getSysDBCfgObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysdbcfgobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getSysDBCfgObj()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getTypeHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typehelper", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getTypeHelper()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBTypeBase.getUpdateSPPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatesppubobj", (Object)PSDBTypeBase.getJSONValue((Object)pSDBTypeBase.getUpdateSPPubObj()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBTypeBase pSDBTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBTypeBase.getCreateDate() != null) {
            object = pSDBTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBTypeBase.getCreateMan() != null) {
            object = pSDBTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDBClientPath() != null) {
            object = pSDBTypeBase.getDBClientPath();
            xmlNode.setAttribute(FIELD_DBCLIENTPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDEDBCfgObj() != null) {
            object = pSDBTypeBase.getDEDBCfgObj();
            xmlNode.setAttribute(FIELD_DEDBCFGOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDEDQEngObj() != null) {
            object = pSDBTypeBase.getDEDQEngObj();
            xmlNode.setAttribute(FIELD_DEDQENGOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDEDQPubObj() != null) {
            object = pSDBTypeBase.getDEDQPubObj();
            xmlNode.setAttribute(FIELD_DEDQPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDEDSPubObj() != null) {
            object = pSDBTypeBase.getDEDSPubObj();
            xmlNode.setAttribute(FIELD_DEDSPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDEFDTColObj() != null) {
            object = pSDBTypeBase.getDEFDTColObj();
            xmlNode.setAttribute(FIELD_DEFDTCOLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getDeleteSPPubObj() != null) {
            object = pSDBTypeBase.getDeleteSPPubObj();
            xmlNode.setAttribute(FIELD_DELETESPPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getGetSPPubObj() != null) {
            object = pSDBTypeBase.getGetSPPubObj();
            xmlNode.setAttribute(FIELD_GETSPPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getHibDialect() != null) {
            object = pSDBTypeBase.getHibDialect();
            xmlNode.setAttribute(FIELD_HIBDIALECT, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getIconPath() != null) {
            object = pSDBTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getInsertSPPubObj() != null) {
            object = pSDBTypeBase.getInsertSPPubObj();
            xmlNode.setAttribute(FIELD_INSERTSPPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getInstallPath() != null) {
            object = pSDBTypeBase.getInstallPath();
            xmlNode.setAttribute(FIELD_INSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getJdbcDialect() != null) {
            object = pSDBTypeBase.getJdbcDialect();
            xmlNode.setAttribute(FIELD_JDBCDIALECT, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getJdbcDriverName() != null) {
            object = pSDBTypeBase.getJdbcDriverName();
            xmlNode.setAttribute(FIELD_JDBCDRIVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getMemo() != null) {
            object = pSDBTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getPSDBTypeId() != null) {
            object = pSDBTypeBase.getPSDBTypeId();
            xmlNode.setAttribute(FIELD_PSDBTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getPSDBTypeName() != null) {
            object = pSDBTypeBase.getPSDBTypeName();
            xmlNode.setAttribute(FIELD_PSDBTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getPubMode() != null) {
            object = pSDBTypeBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBTypeBase.getSysDBCfgObj() != null) {
            object = pSDBTypeBase.getSysDBCfgObj();
            xmlNode.setAttribute(FIELD_SYSDBCFGOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getTypeHelper() != null) {
            object = pSDBTypeBase.getTypeHelper();
            xmlNode.setAttribute(FIELD_TYPEHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getUpdateDate() != null) {
            object = pSDBTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBTypeBase.getUpdateMan() != null) {
            object = pSDBTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBTypeBase.getUpdateSPPubObj() != null) {
            object = pSDBTypeBase.getUpdateSPPubObj();
            xmlNode.setAttribute(FIELD_UPDATESPPUBOBJ, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBTypeBase pSDBTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBTypeBase.isCreateDateDirty() && (bl || pSDBTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBTypeBase.getCreateDate());
        }
        if (pSDBTypeBase.isCreateManDirty() && (bl || pSDBTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBTypeBase.getCreateMan());
        }
        if (pSDBTypeBase.isDBClientPathDirty() && (bl || pSDBTypeBase.getDBClientPath() != null)) {
            iDataObject.set(FIELD_DBCLIENTPATH, (Object)pSDBTypeBase.getDBClientPath());
        }
        if (pSDBTypeBase.isDEDBCfgObjDirty() && (bl || pSDBTypeBase.getDEDBCfgObj() != null)) {
            iDataObject.set(FIELD_DEDBCFGOBJ, (Object)pSDBTypeBase.getDEDBCfgObj());
        }
        if (pSDBTypeBase.isDEDQEngObjDirty() && (bl || pSDBTypeBase.getDEDQEngObj() != null)) {
            iDataObject.set(FIELD_DEDQENGOBJ, (Object)pSDBTypeBase.getDEDQEngObj());
        }
        if (pSDBTypeBase.isDEDQPubObjDirty() && (bl || pSDBTypeBase.getDEDQPubObj() != null)) {
            iDataObject.set(FIELD_DEDQPUBOBJ, (Object)pSDBTypeBase.getDEDQPubObj());
        }
        if (pSDBTypeBase.isDEDSPubObjDirty() && (bl || pSDBTypeBase.getDEDSPubObj() != null)) {
            iDataObject.set(FIELD_DEDSPUBOBJ, (Object)pSDBTypeBase.getDEDSPubObj());
        }
        if (pSDBTypeBase.isDEFDTColObjDirty() && (bl || pSDBTypeBase.getDEFDTColObj() != null)) {
            iDataObject.set(FIELD_DEFDTCOLOBJ, (Object)pSDBTypeBase.getDEFDTColObj());
        }
        if (pSDBTypeBase.isDeleteSPPubObjDirty() && (bl || pSDBTypeBase.getDeleteSPPubObj() != null)) {
            iDataObject.set(FIELD_DELETESPPUBOBJ, (Object)pSDBTypeBase.getDeleteSPPubObj());
        }
        if (pSDBTypeBase.isGetSPPubObjDirty() && (bl || pSDBTypeBase.getGetSPPubObj() != null)) {
            iDataObject.set(FIELD_GETSPPUBOBJ, (Object)pSDBTypeBase.getGetSPPubObj());
        }
        if (pSDBTypeBase.isHibDialectDirty() && (bl || pSDBTypeBase.getHibDialect() != null)) {
            iDataObject.set(FIELD_HIBDIALECT, (Object)pSDBTypeBase.getHibDialect());
        }
        if (pSDBTypeBase.isIconPathDirty() && (bl || pSDBTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDBTypeBase.getIconPath());
        }
        if (pSDBTypeBase.isInsertSPPubObjDirty() && (bl || pSDBTypeBase.getInsertSPPubObj() != null)) {
            iDataObject.set(FIELD_INSERTSPPUBOBJ, (Object)pSDBTypeBase.getInsertSPPubObj());
        }
        if (pSDBTypeBase.isInstallPathDirty() && (bl || pSDBTypeBase.getInstallPath() != null)) {
            iDataObject.set(FIELD_INSTALLPATH, (Object)pSDBTypeBase.getInstallPath());
        }
        if (pSDBTypeBase.isJdbcDialectDirty() && (bl || pSDBTypeBase.getJdbcDialect() != null)) {
            iDataObject.set(FIELD_JDBCDIALECT, (Object)pSDBTypeBase.getJdbcDialect());
        }
        if (pSDBTypeBase.isJdbcDriverNameDirty() && (bl || pSDBTypeBase.getJdbcDriverName() != null)) {
            iDataObject.set(FIELD_JDBCDRIVERNAME, (Object)pSDBTypeBase.getJdbcDriverName());
        }
        if (pSDBTypeBase.isMemoDirty() && (bl || pSDBTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBTypeBase.getMemo());
        }
        if (pSDBTypeBase.isPSDBTypeIdDirty() && (bl || pSDBTypeBase.getPSDBTypeId() != null)) {
            iDataObject.set(FIELD_PSDBTYPEID, (Object)pSDBTypeBase.getPSDBTypeId());
        }
        if (pSDBTypeBase.isPSDBTypeNameDirty() && (bl || pSDBTypeBase.getPSDBTypeName() != null)) {
            iDataObject.set(FIELD_PSDBTYPENAME, (Object)pSDBTypeBase.getPSDBTypeName());
        }
        if (pSDBTypeBase.isPubModeDirty() && (bl || pSDBTypeBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSDBTypeBase.getPubMode());
        }
        if (pSDBTypeBase.isSysDBCfgObjDirty() && (bl || pSDBTypeBase.getSysDBCfgObj() != null)) {
            iDataObject.set(FIELD_SYSDBCFGOBJ, (Object)pSDBTypeBase.getSysDBCfgObj());
        }
        if (pSDBTypeBase.isTypeHelperDirty() && (bl || pSDBTypeBase.getTypeHelper() != null)) {
            iDataObject.set(FIELD_TYPEHELPER, (Object)pSDBTypeBase.getTypeHelper());
        }
        if (pSDBTypeBase.isUpdateDateDirty() && (bl || pSDBTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBTypeBase.getUpdateDate());
        }
        if (pSDBTypeBase.isUpdateManDirty() && (bl || pSDBTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBTypeBase.getUpdateMan());
        }
        if (pSDBTypeBase.isUpdateSPPubObjDirty() && (bl || pSDBTypeBase.getUpdateSPPubObj() != null)) {
            iDataObject.set(FIELD_UPDATESPPUBOBJ, (Object)pSDBTypeBase.getUpdateSPPubObj());
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
        return PSDBTypeBase.remove(this, n);
    }

    private static boolean remove(PSDBTypeBase pSDBTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBTypeBase.resetDBClientPath();
                return true;
            }
            case 3: {
                pSDBTypeBase.resetDEDBCfgObj();
                return true;
            }
            case 4: {
                pSDBTypeBase.resetDEDQEngObj();
                return true;
            }
            case 5: {
                pSDBTypeBase.resetDEDQPubObj();
                return true;
            }
            case 6: {
                pSDBTypeBase.resetDEDSPubObj();
                return true;
            }
            case 7: {
                pSDBTypeBase.resetDEFDTColObj();
                return true;
            }
            case 8: {
                pSDBTypeBase.resetDeleteSPPubObj();
                return true;
            }
            case 9: {
                pSDBTypeBase.resetGetSPPubObj();
                return true;
            }
            case 10: {
                pSDBTypeBase.resetHibDialect();
                return true;
            }
            case 11: {
                pSDBTypeBase.resetIconPath();
                return true;
            }
            case 12: {
                pSDBTypeBase.resetInsertSPPubObj();
                return true;
            }
            case 13: {
                pSDBTypeBase.resetInstallPath();
                return true;
            }
            case 14: {
                pSDBTypeBase.resetJdbcDialect();
                return true;
            }
            case 15: {
                pSDBTypeBase.resetJdbcDriverName();
                return true;
            }
            case 16: {
                pSDBTypeBase.resetMemo();
                return true;
            }
            case 17: {
                pSDBTypeBase.resetPSDBTypeId();
                return true;
            }
            case 18: {
                pSDBTypeBase.resetPSDBTypeName();
                return true;
            }
            case 19: {
                pSDBTypeBase.resetPubMode();
                return true;
            }
            case 20: {
                pSDBTypeBase.resetSysDBCfgObj();
                return true;
            }
            case 21: {
                pSDBTypeBase.resetTypeHelper();
                return true;
            }
            case 22: {
                pSDBTypeBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDBTypeBase.resetUpdateMan();
                return true;
            }
            case 24: {
                pSDBTypeBase.resetUpdateSPPubObj();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDBTypeBase getProxyEntity() {
        return this.proxyPSDBTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBTypeBase) {
            this.proxyPSDBTypeBase = (PSDBTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBCLIENTPATH, 2);
        fieldIndexMap.put(FIELD_DEDBCFGOBJ, 3);
        fieldIndexMap.put(FIELD_DEDQENGOBJ, 4);
        fieldIndexMap.put(FIELD_DEDQPUBOBJ, 5);
        fieldIndexMap.put(FIELD_DEDSPUBOBJ, 6);
        fieldIndexMap.put(FIELD_DEFDTCOLOBJ, 7);
        fieldIndexMap.put(FIELD_DELETESPPUBOBJ, 8);
        fieldIndexMap.put(FIELD_GETSPPUBOBJ, 9);
        fieldIndexMap.put(FIELD_HIBDIALECT, 10);
        fieldIndexMap.put(FIELD_ICONPATH, 11);
        fieldIndexMap.put(FIELD_INSERTSPPUBOBJ, 12);
        fieldIndexMap.put(FIELD_INSTALLPATH, 13);
        fieldIndexMap.put(FIELD_JDBCDIALECT, 14);
        fieldIndexMap.put(FIELD_JDBCDRIVERNAME, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_PSDBTYPEID, 17);
        fieldIndexMap.put(FIELD_PSDBTYPENAME, 18);
        fieldIndexMap.put(FIELD_PUBMODE, 19);
        fieldIndexMap.put(FIELD_SYSDBCFGOBJ, 20);
        fieldIndexMap.put(FIELD_TYPEHELPER, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
        fieldIndexMap.put(FIELD_UPDATESPPUBOBJ, 24);
    }
}

